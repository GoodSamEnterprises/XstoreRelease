/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 * BZ23562          260917    Instant Credit Approval or Decline message does not display in Xstore after application is complete
 * BZ23613          270917    Need the percentage sign for APR on the shopping pass slip
 * BZ23612          270917    Missing expiry date on the shopping pass slip
 * BZ23579          021017    Should be written log file for Good Sam Visa card transaction once it is approved or declined.
 * BZ23743          091017    Close Where Created in GoodSamVisa flow
 * BZ23871          091017    Good Sam Shopping Pass has invalid expiration date format
 * BZ23915          091017    Xstore prompts for "made Offer" even though customer has been approved
 * BZ23982          121017    Registers are constantly frozen and required rebooting
 * BZ23976          121017    Need to send the ADS result to CareTaker after the credit application completes
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24000          161017    ResponseXML in the caretaker WS request need to be HTML-encoded format
 * BZ24365          071117    Customer search screen is displayed when pressing GS Visa apply now although customer has been associated
 * BZ25173          190118    Pinpad is clear items list unexpectedly when removing customer from transaction
 * BZ25219          240118    [Prod] care taker request to Neuron is not well formed and causing issue at card services
 * BZ25263          260118    Customer info applied GS VISA and RESPONSE XML into EBS.log are not same
 * BZ25286          290118    [Xstore] Help Desk Error is displayed instead of Instant credit approval response
 * BZ25858          030418    [Internal] Help Desk Error when you select GS Visa Apply when EBS is Offline
 * BZ25884          100417    [PROD] New Requirement- Display Good Sam credit application/error message on Pin Pad
 * BZ26006          180417    [Internal][Hot fix for BZ25884 & BZ25986] EBS is Offline displayed when you accept the Credit Offer
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ27108          160818    [PROD]Good Sam Visa Shopping Pass text needs to reflect the approved credit amount
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28247          181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28012          211218    [New Requirement] Update the Caretaker Calls to include all credit application responses
 * BZ28740          211218    [PLCC] Can't do trans with New GSVisa Card
 * BZ28973          240119    [Internal] The content of decline message display inconsistent on Xstore and PINPAD
 * BZ28942          300119    [Internal] Credit card name displays inconsistent on shopping Pass receipt and Xstore screen
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29278          130219    [Internal] [PLCC] Item screen overwrites Welcome screen after finish "GS VISA Apply Now"
 * BZ29293          140219    [Internal] Missing Credit limit amount on the Xstore GOOD SAM CREDIT APPLICATION RESPONSE screen
 * BZ29292          140219    [Internal] Need to fix the text on the PLCC Shopping Pass to match ADS Requirements
 * BZ29419          180219    [Internal] Xstore needs to change response screen for instant credit when offline.
 * BZ29422          220219    [Internal] Existing Account Response screen is not prompted when customer has already an existing account.
 * BZ29407          260219    [Internal] Xstore continues to prompt prescreen after application has been successfully completed.
 * BZ29613          040319    [Internal][PLCC] Pin Pad TCPA Disclosure/Telephone Number Form
 * BZ29704          120319    [PLCC Cert] Xstore displays the incorrect message for instant credit timeout
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.tenderauth.impl.eigen.*;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.op.CawGoodSamVisaHelper;
import weblogic.utils.FileUtils;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.op.OpState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.util.IReceiptSource;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawGoodSamInstantApplyOp extends AbstractPromptOp {

    /*Begin BZ23265*/
    List<IReceiptSource>          rcptSrclistOrg        = new ArrayList<IReceiptSource>();

    private final IOpState        COMPLETE_PRINT        = new OpState("COMPLETE_PRINT");

    /*Begin BZ23579*/
    private static final Logger   _logger               = LogManager.getLogger(CawGoodSamInstantApplyOp.class);
    /*End BZ23579*/

    @Inject
    private CawEigenMgr           _cawEigenMgr;

    @Inject
    private CawEigenHelper        _cawEigenHelper;

    private CawGoodSamVisaHelper  _cawGoodSamVisaHelper = CawGoodSamVisaHelper.getInstance();                  // BZ23976

    private Boolean               isFulfillAllSteps     = Boolean.FALSE;

    private CawCustomerGSHelper   _gsHelper             = CawCustomerGSHelper.getInstance();

    @Inject
    private CustomerHelper        _customerHelper;

    @Inject
    private CawShoppingPassHelper _cawShoppingPassHelper;                                                      //BZ29292

    private Boolean               isDuplicate           = Boolean.FALSE;                                       //BZ29407

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        _gsHelper.isVerified(false);
        _gsHelper.setApplicationType(2);

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        _gsHelper.isVerified(false); //BZ25761
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION")); /*BZ23563*/
        }

        IParty custParty = trans.getCustomerParty();
        if (ebsResponse(custParty) == null) {
            return HELPER.getCompletePromptResponse(PromptKey.valueOf("CAW.CONFIRM_CUST_INFO_ERROR")); // BZ24365
        }

        //Check customer's response: NO-not cancel process, YES-cancel process
        if (argArg0 != null) {
            IXstActionKey key = ((IXstAction) argArg0).getActionKey();
            if (key.equals(XstDataActionKey.NO)) {
                return HELPER.incompleteResponse();
            } else if (key.equals(XstDataActionKey.YES)) {
                _gsHelper.setApplicationStatus(4); /*BZ28740: status 4 if customer cancel process*/

                setScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE, getRcptSrclistOrg());

                setRcptSrclistOrg(null);
                /**
                 * Begin BZ27344 - added to use refreshPinpadScreen(_transactionScope)
                 * After the transaction has applied the GoodSamVisa, The transaction will apply the discount.
                 * Therefore the items need to update new price on Pinpad. 
                 */
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                // handle send EBS
                String argSource = _cawEigenHelper.getGsXMLEncode();

                _gsHelper.convertGRToObject(argSource);

                return HELPER.completeResponse();
            }
            /*BEGIN BZ29278*/
            else if (key.equals(XstDataActionKey.ACCEPT)) {
                _cawEigenMgr.startSessionToClearPinpadScreen();
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                return HELPER.completeResponse();
            }
            /*END BZ29278*/
        }

        //Start pinpad entry
        Boolean isCustPressCancelOnPinPad = Boolean.FALSE;//BZ25884
        if (!COMPLETE_PRINT.equals(this.getOpState())) {//BZ24556
            setRcptSrclistOrg(getScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE));
            if (_cawEigenMgr.promptDateOfBirthEntry()) {
                if (_cawEigenMgr.promptSocialSecurityEntryFull()) {
                    if (_cawEigenMgr.enterAnnualIncome()) {
                        if (_cawEigenMgr.displayPhoneNumbers(custParty)) {
                            if (_cawEigenMgr.displayConfirmationInstantCredit()) {//BZ29613
                                // BZ 25263
                                isFulfillAllSteps = Boolean.TRUE;
                                if (_cawEigenMgr.instanceCreditRequest(custParty)) {
                                    /**************************
                                     * Duplicate response BLOCK
                                     */
                                    /*Begin BZ23916*/
                                    //if (_cawEigenHelper.checkDuplicate(_cawEigenHelper.getGsXMLEncode())) { //BZ29422: Backup the old function check account exists.
                                    if (_cawEigenHelper.isAccountDuplicate(_gsHelper.getGSInfo())) { //BZ29422
                                        /* BEGIN BZ29407 */
                                        isDuplicate = Boolean.TRUE;
                                        _gsHelper.setApplicationStatus(1);
                                        /* BEGIN BZ29407 */
                                    }
                                    /**
                                     * Duplicate response BLOCK
                                     **************************/
                                    else {
                                        /*End BZ23916*/
                                        printShoppingPassRcpt();
                                        this.setOpState(COMPLETE_PRINT);
                                        _gsHelper.setApplicationStatus(1);
                                        return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("PRINT_RECEIPTS"));
                                    }
                                }
                            } else {
                                isCustPressCancelOnPinPad = Boolean.TRUE;//BZ25884
                            }
                        } else {
                            isCustPressCancelOnPinPad = Boolean.TRUE;//BZ25884
                        }
                    } else {
                        isCustPressCancelOnPinPad = Boolean.TRUE;//BZ25884
                    }
                } else {
                    isCustPressCancelOnPinPad = Boolean.TRUE;//BZ25884
                }

            } else {
                isCustPressCancelOnPinPad = Boolean.TRUE;//BZ25884
            }
        }

        if (isCustPressCancelOnPinPad == Boolean.TRUE) {//BZ25884
            IFormattable args[] = new IFormattable[1];
            args[0] = _ff.getSimpleFormattable("_cancelledByCustomer");
            return HELPER.getPromptResponse(PromptKey.valueOf("CAW_GOOD_SAM_CANCEL_PROCESS"), args);
        } else {//BZ25884
            setScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE, getRcptSrclistOrg());
            setRcptSrclistOrg(null);
            /**
             * Begin BZ27344 - added to use refreshPinpadScreen(_transactionScope)
             * After the transaction has applied the GoodSamVisa, The transaction will apply the discount.
             * Therefore the items need to update new price on Pinpad. 
             */
            _cawEigenHelper.refreshPinpadScreen(_transactionScope); // BZ25173
            /**
             * End BZ27344
             */

            /*******************************
             * Send Application status BLOCK
             */
            // BZ 25263: When fulfilling all steps, send careTaker request 
            if (isFulfillAllSteps) {
                _transactionScope.setValue(CawValueKeys.IS_COMPLETED_MADE_OFFER, Boolean.TRUE);// BZ29407
                //CawCustomerGSInfo gsInfo = _gsHelper.getGSInfo();
                // Begin BZ23976
                // handle send EBS
                /* BEGIN BZ29280 */
                String argSource = _cawEigenHelper.getGsXMLEncode();
                /* BEGIN BZ28247 */
                _gsHelper.convertGRToObject(argSource);
                /* BEGIN BZ28012 */
                String requestCareTaker = _cawGoodSamVisaHelper
                        .getCareTakerTemplate(trans, ebsResponse(custParty), CawEigenConstants.INSTANT_CREDIT, _gsHelper
                                .getPreScreenId());
                /* END BZ28247 */
                /* END BZ29280 */
                ResponseEntity<String> careTakerResponse = null;
                if (requestCareTaker != null) {
                    careTakerResponse = CawEBSHelper.getInstance().sendCareTakerToEBS(requestCareTaker);
                    int retryTime = 0;
                    int retryTimes = CawCustomerUtil.getApplicationStatusRetriesTime();
                    while (retryTime < retryTimes && careTakerResponse != null
                            && CawEBSHelper.RESPONSE_SUCCESS_CODE != careTakerResponse.getStatusCodeValue()) {
                        careTakerResponse = CawEBSHelper.getInstance().sendCareTakerToEBS(requestCareTaker);
                        retryTime++;
                        _logger.info("[Retried send application status at] : " + retryTime + " Time");
                    }
                    if (retryTime == retryTimes) {
                        if (StringUtils.isNotEmpty(requestCareTaker)) {
                            byte requestData[] = requestCareTaker.getBytes();
                            String esbResponse = CawCatalystHelper.getLookupResponseData();
                            String accountId = "";
                            if (StringUtils.isNotEmpty(esbResponse)) {
                                accountId = CawCustomerUtil.getAccountNumber(esbResponse);
                            }
                            long transSequeue = trans.getTransactionSequence();
                            String fileName = CawConstants.CAW_APPLICATION_STAUS + transSequeue
                                    + CawConstants.CAW_UNDER_LINE + accountId + CawConstants.CAW_FILE_EXTENDTION;
                            try {
                                String directory = CawPropertyUtils
                                        .getSystemProperty(CawConstants.CAW_ESB_QUEUE_PATH, CawConstants.CAW_ESB_QUEUE_PATH);
                                FileUtils.writeToFile(requestData, directory + "/" + fileName);
                            } catch (IOException ex) {
                                _logger.info("Could not save Json Caretaker to file: " + fileName);
                            }
                        }
                    }
                }
                /* END BZ28012 */
                // End BZ23976
            }
            /**
             * Send Application status BLOCK
             ******************************/

            /***************
             * APPROVE BLOCK
             */
            /*Begin BZ23562*/
            if (_gsHelper.getApplicationStatus() == 1) {
                /* BEGIN BZ29407 */
                if (isDuplicate) {
                    IFormattable args[] = new IFormattable[2];
                    args[0] = _ff.getSimpleFormattable(_customerHelper.getCustomerDisplayName(custParty));
                    if (_gsHelper.getCardType() == 1) {
                        args[1] = _ff.getTranslatable("_visaXst");
                    } else if (_gsHelper.getCardType() == 2) {
                        args[1] = _ff.getTranslatable("_plcc");
                    }
                    return HELPER.getCompletePromptResponse(PromptKey
                            .valueOf("CAW.PRESCREEN_ACCEPTANCE_RESPONSE_DUPLICATE"), args);
                    /* END BZ29407 */
                } else {
                    _logger.info("[GoodSam Visa]: APPROVED!!! The customer has been APPROVED."); // BZ23579

                    /* Begin BZ23676 */
                    return HELPER
                            .getCompleteStackChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_VISA_RESPONSE_APPROVE"));
                    /* End BZ23676 */
                }
            }
            /**
             * APPROVE BLOCK
             ***************/

            /***************
             * DECLINE BLOCK
             */
            _logger.info("[GoodSam Visa]: DECLINED!!! The customer has been DECLINED."); // BZ23579
            /* Begin BZ25884*/
            boolean checkErrorMessage = false;// BZ28973
            IFormattable args[] = CawUtilFunction.promptArgs(_ff.getSimpleFormattable("_defaultMessageGoodSamVisa"));
            /* BEGIN BZ29293, BZ29419 */
            String eigenReturnCode = _gsHelper.getEigenReturnCode();
            String adsReturnCode = _gsHelper.getAdsReturnCode();
            String adsAuxResponseCode = _gsHelper.getAdsAuxResponseCode(); //BZ29704

            if (_cawEigenHelper.isProcessingOrTimeOutError(eigenReturnCode, adsReturnCode, adsAuxResponseCode)) { //BZ29704
                checkErrorMessage = true;//BZ28973
                args[0] = _ff.getTranslatable("_processingOrTimeOutError");
            }
            /* END BZ29293, BZ29419 */

            /*BEGIN BZ28973*/
            if (checkErrorMessage) {
                _cawEigenMgr.displayErrorForm();
            } else {
                _cawEigenMgr.displayPendedForm();
            }
            /*END BZ28973*/
            /*BEGIN BZ29278*/
            return HELPER.getPromptResponse(PromptKey.valueOf("CAW.GOOD_SAM_VISA_RESPONSE_ERROR"), args);
            /*END BZ29278*/
            /* End BZ25884*/
            /*End BZ23562*/
            /**
             * DECLINE BLOCK
             ***************/
        }
    }

    /**
     * 
     */
    private void printShoppingPassRcpt() {
        /* BEGIN BZ29292 */
        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        CawGoodSamVisaShoppingPassReferenceData gsBean = _cawShoppingPassHelper
                .prepareDataForShoppingPass(_gsHelper.getGSInfo(), iParty, _transactionScope.getTransaction());
        /* END BZ29292 */

        // End BZ27108, BZ23915
        List<IReceiptSource> rcptSrclistOveride = new ArrayList<IReceiptSource>();
        rcptSrclistOveride.add(gsBean);
        setScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE, rcptSrclistOveride);
    }

    /**
     * @return the rcptSrclistOrg
     */
    public List<IReceiptSource> getRcptSrclistOrg() {

        return rcptSrclistOrg;
    }

    /**
     * @param argRcptSrclistOrg the rcptSrclistOrg to set
     */
    public void setRcptSrclistOrg(List<IReceiptSource> argRcptSrclistOrg) {

        rcptSrclistOrg = argRcptSrclistOrg;
    }
    /*End BZ232365*/

    /**
     * 
     * @param custParty
     * @return
     */
    private String ebsResponse(IParty custParty) {

        /*Begin BZ23563*/
        /*Begin BZ26006*/
        String accountNumber = CawCustomerUtil.getEBSAccountNumber(custParty);
        if (accountNumber == null && _transactionScope.getValue(CawValueKeys.API_LOOKUP_RESPONSE) != null) {
            String customerLookup = _transactionScope.getValue(CawValueKeys.API_LOOKUP_RESPONSE);
            accountNumber = _cawEigenMgr.getAccountNumber(customerLookup);
        }

        String ebsResponse = null;
        if (accountNumber != null) {
            _logger.info("Account number get from ESB:" + accountNumber);
            ebsResponse = CawCustomerUtil.getCustomerDetailResponse(accountNumber);
        }
        /*End BZ26006*/
        /*End BZ23563*/
        return ebsResponse;
    }

    /*Begin BZ23562*/
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW.GOOD_SAM_VISA_RESPONSE_APPROVE");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }
    /*End BZ23562*/

    @Override
    public String getLongRunningMessage() {

        return CawConstants.WAIT_FOR_SIGCAP;
    }
}
