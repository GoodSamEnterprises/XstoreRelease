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
 * PAYMENT          070917    Payment-Item Display
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 * BZ23587          260917    [Payments]New GS visa got a declined because of missing address
 * BZ23612          270917    Missing expiry date on the shopping pass slip
 * BZ23604          270917    [Xstore] Pin Pad displays incorrect Ext Price when qty is greater than 1
 * BZ23406          290917    Implement tender by "Create Good Sam Visa" card function
 * BZ23265          290917    Implement issue "Create Good Sam Visa" card function
 * BZ23685          021017    [Instant Credit] Words on the PinPad screens for instant credit don't all fit on the display
 * BZ23707          031017    [Payment]Eigen Feedback: Remove D7 field on Financial Transaction Request
 * BZ23563          101017    [Payments] Xstore needs to confirm selected 
 *                            customer before sending command to pin pad for instant credit
 * BZ23945          101017    real time and batch prescreen - income field should be 7 digits max without the last 2 decimal
 * BZ23946          101017    Changes for membership number and phone used for real time and batch prescreen.
 * BZ23947          101017    For instant credit, real time and batch prescreen, birthday format on the pin pad prompt.
 * BZ23953          111017    [Certification] Instant Credit Phone Number is not submitted to ADS
 * BZ23946          111017    [Certification] OLPS Request for instant credit must not send "null" 
 *                            in the <customerMemberId> field, leave this field blank for customers 
 *                            who are not club members
 * BZ23917          111017    [Payments] Xstore is stuck "Waiting for sigcap input" 
 *                            even after customer cancels credit application on pin pad
 * BZ23978          121017    send ClearSecureEntry transaction type after complete the 
 *                            prescreen/instant credit application
 * BZ23947          121017    [Certification] For instant credit, real time and batch prescreen, 
 *                            birthday format on the pin pad prompt
 * BZ23982          121017    Registers are constantly frozen and required rebooting                           
 * BZ23976          121017    Need to send the ADS result to CareTaker after the credit application completes
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24019          161017    [Technical issue] - Empty method
 * BZ24070          181017    Some places still display "Camping World" text on receipt and PinPad
 * BZ24039          181017    Customer name displays null instead of company name on "Confirm name & address" prompt when registering "GS Visa apply now".
 * BZ24131          201017    'HDE' screen is displayed after pressing 'Yes' on customer confirmation.
 * BZ24582          221117    Need to specify the unique terminal Station ID in the MiraServ requests
 * BZ24937          291217    [Prod Support] Disable line item displaying on pinpad
 * BZ25049          080118    [PROD] Employee ID of 9999999 is being Passed to Eigen
 * BZ24937          090118    [Prod Support] Disable line item displaying on pinpad
 * BZ24110          130418    Multiple brand name forXstore
 * BZ25884          100417    [PROD] New Requirement- Display Good Sam credit application/error message on Pin Pad
 * BZ25986          160418    [PROD] Zip Code change for Good Sam Visa Credit Applications
 * BZ27090          090818    [1.6] Return flow runing long with decimal quantity
 * BZ26858          101118    [PROD] Register suspends transaction involuntarily and charges customer multiple times
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ27933          301018    [26858]Void request of return trans doesn't send to Mira when Register suspends transaction involuntarily
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28401          211118    [Internal] Item displayed twice on PINPAD screen when adding a discount to the item
 * BZ28375          231118    [2.9.4] The number of items displayed incorrect on PIN PAD when changing qty number then void line item
 * BZ27875          151018    [PROD] Register suspends transaction involuntarily and charges customer double times once tendering with GC
 * BZ28403          071218    [Internal] Tax amount is not rounding to 2 digits for the decimal on PINPAD.
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ25762          121418    New Requirement - Credit Account Look up integration in Xstore
 * BZ28738          211218    [PLCC] PINPAD and Xstore display inconsistency once selecting 'NO' on Customer & Confirmation screen
 * BZ28735          211218    [27875] Void request of return trans doesn't send to Mira when Register suspends transaction involuntarily 
 * BZ28973          240119    [Internal] The content of decline message display inconsistent on Xstore and PINPAD
 * BZ29134          290119    [Internal] The Account Lookup flow should be aborted after three failed attempts look up a customer hasn't found in system.
 * BZ29237          290119    [INTERNAL][PLCC] The notified content on PINPAD is not corrected.
 * BZ29239          300119    [Internal][PLCC] The prompting content is wrong at Xstore Pre-Approved Credit Offer screen
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ29313          120219    [Internal] Xstore sending the incorrect trancode to clear secure entry on pinpad
 * BZ29314          120219    [Internal] Add CustomerType field to the Prescreen Acceptance request
 * BZ29316          120219    [Internal] Zip Code in Xstore does not match the zip code displayed on the Pin Pad Customer Verification Form
 * BZ29290          130119    [Internal] Email address is cut off on the IS YOUR INFORMATION CORRECT? form
 * BZ29293          140219    [Internal] Missing Credit limit amount on the Xstore GOOD SAM CREDIT APPLICATION RESPONSE screen
 * BZ29379          140219    [Internal] Xstore should display the actual response provided by Eigen MiraServ once returning an unsuccessful GS Account Payment inquiry response
 * BZ29343          140219    [Internal] Customer Name displayed incorrect on GOOD SAM ACCOUNT PAYMENT screen after cancel trans
 * BZ29399          140219    [Internal] Missing content text on Pin Pad Pre-Approved Form for PLCC once doing prescreen trans.
 * BZ29400          140118    [Internal[Account Lookup] First&Last name displaying on Account Found prompt does not match exactly First&name retrieved from ADS.
 * BZ29416          150219    [Internal] PinPad does not display APR and Temporary Credit Limit.
 * BZ29360          150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29419          180219    [Internal] Xstore needs to change response screen for instant credit when offline.
 * BZ29455          200219    Account Payment we receive 741 invalid Amount
 * BZ29454          200219    [Internal] Temporary Shopping Pass is missing Temporary Limit amount.
 * BZ29472          210219    [Internal] Xstore handles the PLCC prescreen application status improperly.
 * BZ29478          210219    [EXTERNAL] PLCC Acquisition Changes from Client
 * BZ29468          210219    [Internal] Invalid search data provided response received after swiping PLCC for Account Payment
 * BZ29476          210219    [Internal] GS Account Payment is prompting signature on PinPad.
 * BZ29422          220219    [Internal] Existing Account Response screen is not prompted when customer has already an existing account.
 * BZ29515          220219    [ADS Feedback] Duplicate cardholder address in the ‘address’ and ‘address2’ fields for credit application 
 * BZ29514          220219    Updated Requirement] ADS Feedback: Instant Credit API – the phone number is not being sent. This is a required field.
 * BZ29504          220219    [Internal] PLCC tender doesn't capture customer name in DB when using lookup functionality
 * BZ29528          250219    [Internal][Account Payment] Account number of GS Account payment is masked incorrectly format on Xstore screen, receipt and Inquiry prompt
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29535          260219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 * BZ29505          010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29601          010319    [EXTERNAL] [PLCC] Compliance feedback: Instant Credit Pin Pad Confirmation Screen
 * BZ29613          040319    [Internal][PLCC] Pin Pad TCPA Disclosure/Telephone Number Form
 * BZ29619          040319    [Internal][PLCC] Shopping Pass Changes
 * BZ29704          120319    [PLCC Cert] Xstore displays the incorrect message for instant credit timeout
 * BZ29752          190319    [Internal] PLCC Token tender does not void when sale transaction was unable to be completed.
 * BZ29960          280319    [Port the fixed BZ 29923 into 4.1 release] Cannot tender with GSV Account Lookup due to Invalid Expired date
 * BZ30314          220419    [Port BZ30262 to Release 4.2.0] OS transaction failed due to token is missing when tender exchange GiftCard with Credit Card
 * BZ32046          230719    [New Requirement] Ability to change text Welcome screen on Pin Pad
 * BZ35962          050520    [Prod] Don't need to encrypt the credit card token (GSVS/PLCC) for Xstore build 6.0
 * BZ37207          260820    Pinpad verification - Email length modification
 * BZ37382          270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ37661          070920    [Requirement] Add new prompt "Please ask the customer to sign the receipt"
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ46300          060121    [New Requirement] Settlement Request for New Payment Type
 * BZ57844          040823    Bug 57844 - [Task] Loyalty Phase 2.
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import static caw.tenderauth.impl.eigen.constants.CawEigenConstants.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.pos.araccount.CawCustomerAddressFieldType;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSInfo;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.*;
import dtv.i18n.FormattableFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.iframework.security.StationState;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.pos.tender.TenderHelper;
import dtv.tenderauth.*;
import dtv.util.CollectionUtils;
import dtv.xst.crm.impl.task.TaskTypeResult;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.tnd.TenderCategory;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.*;
import dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemModel;
import dtv.xst.dao.xom.IOrder;

public class CawEigenMgr {
    
    private static final Logger         logger           = Logger.getLogger(CawEigenMgr.class);

    public static volatile CawEigenMgr  _instance        = null;

    public static final AuthRequestType LAST_TRANSACTION = AuthRequestType.get("LAST_TRANSACTION");

    public static final MiraServJava    msj              = new MiraServJava();

    private ITenderLineItem             _tenderLine;
    /*Begin BZ30314*/
    private ITenderLineItem             _tenderLineExchange;

    /**
     * @return the tenderLineExchange
     */
    public ITenderLineItem getTenderLineExchange() {
        return _tenderLineExchange;
    }

    /**
     * @param argTenderLineExchange the tenderLineExchange to set
     */
    public void setTenderLineExchange(ITenderLineItem argTenderLineExchange) {
        _tenderLineExchange = argTenderLineExchange;
    }
    /*End BZ30314*/

    @Inject
    private TenderHelper                          _tenderHelper;

    @Inject
    private StationState                          _stationState;

    @Inject
    private CawEigenHelper                        _cawEigenHelper;

    private String                                birthDay                       = null;

    // BZ 24937
    public static final IQueryKey<TaskTypeResult> ALLOW_DISPLAY_LINEITM_PP_QUERY = new QueryKey<TaskTypeResult>(
            "ALLOW_DISPLAY_LINEITM_PP_QUERY", TaskTypeResult.class);

    // BZ 24937
    private static String                         allowDisplLineItmPP            = null;

    private static final int                      POSTAL_CODE__FIRST_INDEX       = 0;                                //BZ25986

    private static final int                      POSTAL_CODE__LAST_INDEX        = 5;                                //BZ25986

    /* Begin BZ25761 */
    @Inject
    protected FormattableFactory                  _ff;

    @Inject
    private CustomerHelper                        _customerHelper;

    private CawCustomerGSHelper                   _gsHelper                      = CawCustomerGSHelper.getInstance();
    /* End BZ25761 */

    private MoneyFormatter                        _moneyFormatter                = new MoneyFormatter();

    /*Begin BZ 37382*/
    private String sigCap = null;

    public String setSigCap(String argString) {
        return sigCap = argString;
    }

    public String getSigCap() {
        return sigCap;
    }

    /*End BZ 37382*/
    /* BEGIN BZ37661 */
    private String responseApproved = null;

    public String setResponseApproved(String argString) {
        return responseApproved = argString;
    }

    public String getResponseApproved() {
        return responseApproved;
    }
    /* END BZ37661 */
    
    // Begin BZ23976
    public static CawEigenMgr getInstance() {

        if (_instance == null) {
            synchronized (CawEigenMgr.class) {
                if (_instance == null) {
                    _instance = new CawEigenMgr();
                }
            }
        }
        return _instance;
    }
    // End BZ23976

    /**
     * Start a session for new transaction
     * 
     */
    public void startSession() {

        /*CawTransactionListEditModel._cawCurrentTransAmtModel.clear();*/ /*BZ48120*/
        /*BEGIN BZ32046*/
        /*String WELCOME_STRING = FormattableFactory.getInstance().getSimpleFormattable("_cawSigcapWelcome")
                .toString(OutputContextType.VIEW);*/
        /*END BZ32046*/
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_K);

            msj.SetTField(CawEigenConstants.FN_HEADER_OPTION, CawEigenConstants.VALUE_OC_IT_MU);
            msj.SetTField(CawEigenConstants.FN_FOOTER_OPTION, CawEigenConstants.VALUE_OCIT_MB);
            /*BEGIN BZ32046*/
            /*msj.SetTField(CawEigenConstants.FN_HEADER_TXT, WELCOME_STRING); // BZ24070 */        
            msj.SetTField(CawEigenConstants.FN_HEADER_TXT, _cawEigenHelper.getWelcomeMessage());
            /*END BZ32046*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Close a session
     * @param transactionScope
     */
    public void closeSession() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_K);
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Setup Slide Image for Eigen
     * @param transactionScope
     */
    public void setupSlideImages() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SETUP_SLIDES);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            // BZ 23707
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.RU);
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Add an item into Eigen
     * 
     * @param newLineItem
     */
    public void addItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope) {

        addItem(newLineItem, transactionScope, true);
    }

    /**
     * Add an item into Eigen
     * 
     * @param newLineItem
     */
    public void addItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope,
            boolean isIncludeFooterLine) {

        /* START BZ 24937 */
        if (!allowDisplayLineItemPP()) {
            return;
        }
        /* END BZ 24937 */

        //check condition that item isn't extended
        IDataModel itemExt = newLineItem.getItem().getItemExt();
        if (itemExt != null || newLineItem.getVoid()) {
            return;
        }

        if (isIncludeFooterLine) {

            IPosTransaction tranx = transactionScope.getTransaction();
            String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
            String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());
            addItem(newLineItem.getQuantity().toString(), newLineItem.getUnitPrice().toString(), newLineItem
                    .getItemDescription(), sTaxAmount, sAmountDue);
        } else {
            /**
             * BZ27344: due to performance issue on Pinpad
             * bIncludeFooterLine: True (sending footer info to Eigen) 
             * if items is not apply trans discount amt, 
             * else if False (not sending footer info to Eigen) will apply trans discount amt
             */
            addItem(newLineItem.getQuantity().toString(), newLineItem.getUnitPrice().toString(), newLineItem
                    .getItemDescription());
        }

    }

    /**
     * BZ27344
     * Display an item line without footer update
     * @param itemID
     * @param qty
     * @param unitPrice
     * @param desc
     */
    public void addItem(String qty, String unitPrice, String desc) {

        addItem(qty, unitPrice, desc, null, null);
    }

    /**
     * Add an item into Eigen
     * 
     * @param newLineItem
     */
    public void addItem(String qty, String unitPrice, String desc, String sAmountDue, String sTaxAmount) {

        /* START BZ 24937 */
        if (!allowDisplayLineItemPP()) {
            return;
        }
        /* END BZ 24937 */

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FN_ITEM_CODE, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_DES, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_QTY, qty);
            msj.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, new BigDecimal(unitPrice)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN).toString().replace(".", ""));
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.SE);

            if (sAmountDue != null && sTaxAmount != null) {
                msj.SetTField(CawEigenConstants.FN_FOOTER_TXT, CawEigenUtil.fnFooterText(sAmountDue, sTaxAmount));
            }

            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Clean item request for Eigen
     * 
     * @param newLineItem, transactionScope
     */
    public void removeItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FN_ITEM_CODE, String.valueOf(newLineItem.getLineItemSequence()));
            msj.SetTField(CawEigenConstants.FN_ITEM_CODE, newLineItem.getItemId());
            msj.SetTField(CawEigenConstants.FN_ITEM_DES, newLineItem.getItemDescription());
            msj.SetTField(CawEigenConstants.FN_ITEM_QTY, newLineItem.getQuantity().toString());
            msj.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, formatItemPrice(newLineItem
                    .getExtendedAmount(), newLineItem.getQuantity())); /*BZ-23604*/
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.SE);
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_V);
            String strFooterPinpad = CawEigenConstants.AMT_DUE + transactionScope.getTransaction().getAmountDue()
                    + " | Tax: " + transactionScope.getTransaction().getTaxAmount(); /*BZ28403*/
            msj.SetTField(CawEigenConstants.FN_FOOTER_TXT, CawEigenUtil
                    .formatFooterPinpad(strFooterPinpad)); /*BZ28403*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Clean item request for Eigen
     * 
     * @param newLineItem, transactionScope
     */
    public void removeItem(String qty, String unitPrice, String desc, TransactionScope transactionScope) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FN_ITEM_CODE, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_DES, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_QTY, qty);
            msj.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, new BigDecimal(unitPrice)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN).toString().replace(".", ""));
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.SE);
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_V);
            String strFooterPinpad = CawEigenConstants.AMT_DUE + transactionScope.getTransaction().getAmountDue()
                    + " | Tax: " + transactionScope.getTransaction().getTaxAmount(); /*BZ28403*/
            msj.SetTField(CawEigenConstants.FN_FOOTER_TXT, CawEigenUtil
                    .formatFooterPinpad(strFooterPinpad)); /*BZ28403*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    public void updateTransAmt(String transAmt, String transTax) {
        /*BEGIN BZ32046*/
        /*String WELCOME_STRING = FormattableFactory.getInstance().getSimpleFormattable("_cawSigcapWelcome")
                .toString(OutputContextType.VIEW);*/
        /*END BZ32046*/
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.SE);
            msj.SetTField(CawEigenConstants.FN_HEADER_OPTION, CawEigenConstants.VALUE_OC_IT_MU);
            msj.SetTField(CawEigenConstants.FN_FOOTER_OPTION, CawEigenConstants.VALUE_OCIT_MB);
            /*BEGIN BZ32046*/
            /*msj.SetTField(CawEigenConstants.FN_HEADER_TXT, WELCOME_STRING); // BZ24070*/ 
            msj.SetTField(CawEigenConstants.FN_HEADER_TXT, _cawEigenHelper.getWelcomeMessage());
            /*END BZ32046*/
            String strFooterPinpad = CawEigenConstants.AMT_DUE + transAmt + " | Tax: " + transTax; /*BZ28403*/
            msj.SetTField(CawEigenConstants.FN_FOOTER_TXT, CawEigenUtil
                    .formatFooterPinpad(strFooterPinpad)); /*BZ28403*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * Override item request for Eigen
     * 
     * @param newLineItem, transactionScope
     */
    public void overrideItem(TransactionScope transactionScope) {

        IPosTransaction iPosTransaction = transactionScope.getTransaction();
        if (iPosTransaction != null) {
            List<IRetailTransactionLineItem> tranLineItems = iPosTransaction.getRetailTransactionLineItems();
            if (!tranLineItems.isEmpty()) {
                for (IRetailTransactionLineItem lineItem : tranLineItems) {
                    if (!lineItem.getVoid() && lineItem instanceof ISaleReturnLineItem) {
                        addItem((ISaleReturnLineItem) lineItem, transactionScope);
                    }
                }
            }
        }
    }

    private String formatItemPrice(BigDecimal argItemPrice, BigDecimal argQty) {

        /*Begin BZ-23604*/
        String formatedItemPrice = null;
        if (argItemPrice != null && argQty != null) {
            if (argQty.compareTo(BigDecimal.ZERO) == 0) {
                formatedItemPrice = argItemPrice.toString().replaceAll("\\.", CawEigenConstants.VALUE_EMPTY);
            } else {
                // Begin BZ27090
                BigDecimal newPrice = argItemPrice.divide(argQty, BigDecimal.ROUND_HALF_EVEN)
                        .setScale(2, BigDecimal.ROUND_HALF_EVEN);
                // End BZ27090
                formatedItemPrice = newPrice.toString().replaceAll("\\.", CawEigenConstants.VALUE_EMPTY);
            }
        }
        /*End BZ-23604*/
        return formatedItemPrice;
    }

    /**
     * Build a general VERIFONE request
     * @return
    */
    public IAuthRequest buildLastTransAuthRequest() {

        // create dummy tender line
        if (_tenderLine == null) {
            _tenderLine = _tenderHelper.createTenderLineItem(_tenderHelper
                    .getLocalCurrency(), TenderCategory.CREDIT_CARD, TenderStatus.TENDER, null);
            ((IAuthorizableTenderLineItem) _tenderLine).setAuthorizationMethodCode(CawEigenConstants.EIGEN);
        }
        // create last trans request
        IAuthRequest currentRequest = AuthFactory.getInstance()
                .makeAuthRequest(LAST_TRANSACTION, (IAuthorizableTenderLineItem) _tenderLine, TenderUsageCodeType.DEFAULT, true);
        return currentRequest;
    }

    /**
     * Build a general VERIFONE request
     * @return
     */
    public IAuthRequest buildAuthRequest() {

        // create dummy tender line
        if (_tenderLine == null) {
            _tenderLine = _tenderHelper.createTenderLineItem(_tenderHelper
                    .getLocalCurrency(), TenderCategory.CREDIT_CARD, TenderStatus.TENDER, null);
            ((IAuthorizableTenderLineItem) _tenderLine).setAuthorizationMethodCode(CawEigenConstants.EIGEN);
        }
        // create request
        IAuthRequest currentRequest = AuthFactory.getInstance()
                .makeAuthRequest(AuthRequestType.CREDIT_APP, (IAuthorizableTenderLineItem) _tenderLine, TenderUsageCodeType.DEFAULT, true);
        return currentRequest;
    }

    /**
     * Build authorization processor
     * @return
     */
    public IAuthProcess buildAuthProcessor() {

        return AuthFactory.getInstance().getAuthProcess(CawEigenConstants.EIGEN);
    }

    /*Begin BZ-23265*/
    public Boolean promptSocialSecurityEntryFull() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KcSU);/* BZ37207 */
            //Begin BZ23685
            msj.SetTField(CawEigenConstants.FIELD_L1, CawEigenConstants.ENTER_FULL);
            msj.SetTField(CawEigenConstants.FIELD_L3, CawEigenConstants.SOCIAL_SECURITY_NUMBER);
            //End BZ23685
            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.VALUE_5N);

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_P7_SSN);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public Boolean promptDateOfBirthEntry() {

        birthDay = null;
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.BIRTH_DATE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KCSU);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.VALUE_P1_BDE);

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_P7_BDE); //BZ23947
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                birthDay = msj.GetTField(CawEigenConstants.FN_BIRTH_DATE);
                String month = birthDay.substring(0, 2);
                String day = birthDay.substring(2, 4);
                String year = birthDay.substring(4);
                birthDay = year + month + day;
                msj.Confirm();
                return true;

            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public Boolean promptTelephoneEntry() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KCSU);/* BZ37207 */
            //Begin BZ23685
            msj.SetTField(CawEigenConstants.FIELD_L1, CawEigenConstants.PLEASE_ENTER_YOUR_FULL);
            msj.SetTField(CawEigenConstants.FIELD_L2, CawEigenConstants.TELEPHONE_NUMBER);
            msj.SetTField(CawEigenConstants.FIELD_L3, CawEigenConstants.INCLUDING_AREA_CODE);
            msj.SetTField(CawEigenConstants.FIELD_L4, CawEigenConstants.EX_5554443333);
            //End BZ23685
            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.VALUE_6P);// BZ 23953

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_5_1_20_A_L);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public Boolean promptAnnualIncomeEntry() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KCLU);

            msj.SetTField(CawEigenConstants.FIELD_L1, CawEigenConstants.PLEASE_ENTER_YOUR);
            msj.SetTField(CawEigenConstants.FIELD_L2, CawEigenConstants.ANNUAL_INCOME_AMOUNT);
            msj.SetTField(CawEigenConstants.FIELD_L3, CawEigenConstants.EX_50000);

            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.FIELD_A2);

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_5_1_7_D_L);//23945
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public void clearSecureEntry() {

        try {
            msj.Init();

            // BEGIN BZ29313
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.CLEAR_SECURE_ENTRY_TRANSACTION_CODE);
            // END BZ29313

            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_CLEAR_SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            // BEGIN BZ25049
            logger.debug(" The Employee ID before passing EN is ---> "
                    + _stationState.getSystemUser().getOperatorParty().getEmployeeId());
            String operatorId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            msj.SetTField(CawEigenConstants.FIELD_EN, operatorId);
            // END BZ25049

            msj.Process();
            msj.Confirm();
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    public Boolean preScreenRequest(IParty argParty, String argReponse) {

        if (argParty == null) {
            return false;
        }
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_83);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.OLPS);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FIELD_N1, argParty.getFirstName());
            msj.SetTField(CawEigenConstants.FIELD_N3, argParty.getLastName());

            /*Begin BZ-23587*/
            msj.SetTField(CawEigenConstants.FIELD_D1, getEBSCustomerAddressLine1(argReponse));
            msj.SetTField(CawEigenConstants.FIELD_D2, getEBSCustomerAddressLine3(argReponse));
            msj.SetTField(CawEigenConstants.FIELD_1C, getEBSCustomerCity(argReponse));
            msj.SetTField(CawEigenConstants.FIELD_1S, getEBSCustomerState(argReponse));
            msj.SetTField(CawEigenConstants.FIELD_Z1, getEBSCustomerZIP(argReponse));
            /*End BZ-23587*/

            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_Y);

            /* START | BZ 23946 */
            msj.SetTField(CawEigenConstants.FIELD_6N, String.valueOf(argParty.getPartyId()));

            if (argParty.getAlternatePartyIds() != null && !argParty.getAlternatePartyIds().isEmpty()
                    && argParty.getAlternatePartyIds().get(0) != null
                    && argParty.getAlternatePartyIds().get(0).getAlternateId() != null) {
                msj.SetTField(CawEigenConstants.FIELD_ME, argParty.getAlternatePartyIds().get(0).getAlternateId());
            } else {
                msj.SetTField(CawEigenConstants.FIELD_ME, CawEigenConstants.VALUE_EMPTY);
            }
            /* END | BZ 23946 */

            msj.SetTField(CawEigenConstants.FIELD_ED, CawEigenConstants.VALUE_EMPTY);

            // BEGIN BZ25049
            logger.debug(" The Employee ID before passing EN is ---> "
                    + _stationState.getSystemUser().getOperatorParty().getEmployeeId());
            String operatorId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            msj.SetTField(CawEigenConstants.FIELD_EN, operatorId);
            // END BZ25049

            msj.SetTField(CawEigenConstants.FIELD_OF, CawEigenConstants.VALUE_Y);
            msj.SetTField(CawEigenConstants.FIELD_OF, CawEigenConstants.VALUE_A);

            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                _gsHelper.setPreScreenId(msj.GetTField(CawEigenConstants.FIELD_R7));
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    /**
     * BZ25761
     * @param argParty
     * @param preScreenId
     * @return
     */
    public Boolean preScreenAcceptanceRequest(IParty argParty, String preScreenId) {

        if (argParty == null) {
            return false;
        }
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_83);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.PRE_SCREEN);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FIELD_N1, argParty.getFirstName());
            msj.SetTField(CawEigenConstants.FIELD_N3, argParty.getLastName());

            // BEGIN BZ25049
            logger.debug(" The Employee ID before passing EN is ---> "
                    + _stationState.getSystemUser().getOperatorParty().getEmployeeId());
            String operatorId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            msj.SetTField(CawEigenConstants.FIELD_EN, operatorId);
            // END BZ25049

            /*Set customer's infomation*/
            setCustomerInfo(argParty); /*BZ29514*/

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_Y);
            msj.SetTField(CawEigenConstants.FIELD_SV, CawEigenConstants.VALUE_N);
            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            msj.SetTField(CawEigenConstants.FIELD_R7, preScreenId);
            if (StringUtils.isNotEmpty(birthDay)) {
                msj.SetTField(CawEigenConstants.FN_BIRTH_DATE, birthDay);
            }

            /* START | BZ 23946 */
            msj.SetTField(CawEigenConstants.FIELD_6N, String.valueOf(argParty.getPartyId()));

            if (!CollectionUtils.isEmpty(argParty.getAlternatePartyIds())
                    && argParty.getAlternatePartyIds().get(0) != null
                    && argParty.getAlternatePartyIds().get(0).getAlternateId() != null) {
                msj.SetTField(CawEigenConstants.FIELD_ME, argParty.getAlternatePartyIds().get(0).getAlternateId());
            } else {
                msj.SetTField(CawEigenConstants.FIELD_ME, CawEigenConstants.VALUE_EMPTY);
            }
            /* END | BZ 23946 */

            msj.SetTField(CawEigenConstants.FIELD_OF, CawEigenConstants.VALUE_A);

            // BEGIN BZ29314
            msj.SetTField(CawEigenConstants.FIELD_6Y, CawEigenConstants.FIELD_6Y_VALUE);
            // END BZ29314

            msj.Process();
            _cawEigenHelper.setGsXMLEncode(msj.GetTField(CawEigenConstants.FIELD_GR)); // BZ23976
            _cawEigenHelper.setGsOD(msj.GetTField(CawEigenConstants.FN_OPERATOR_DETAIL_MSG)); //BZ25884

            /* BEGIN BZ29704  */
            _gsHelper.setEigenReturnCode(msj.GetTField(CawEigenConstants.FIELD_RC));
            _gsHelper.setAdsReturnCode(msj.GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE));
            _gsHelper.setAdsAuxResponseCode(msj.GetTField(CawEigenConstants.FN_AUX_RESPONSE_CODE));
            /* END BZ29704 */

            /* BEGIN BZ29472 */
            boolean isApproved = _cawEigenHelper.isADSApproved(msj);
            if (isApproved) {
                /* END BZ29472 */
                /* BEGIN BZ29293 */
                _gsHelper.convertGRToObject(msj.GetTField(CawEigenConstants.FIELD_GR));
                /* END BZ29293 */
                /* BEGIN BZ29504*/
                _gsHelper.setFirstNameADS(msj.GetTField(CawEigenConstants.FIELD_N1));
                _gsHelper.setLastNameADS(msj.GetTField(CawEigenConstants.FIELD_N3));
                /* END BZ29504*/
                getCardToken(1); /*BZ29360/BZ29505: use short token here*/
                msj.Confirm();
                clearSecureEntry();
                return true;
            } else {
                _gsHelper.setApplicationStatus(2); /*BZ28738: set status for decline*/
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        clearSecureEntry();
        return false;
    }

    public Boolean madeOfferEigenRequest() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_83);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.MADE_OFFER);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            // BEGIN BZ25049
            logger.debug(" The Employee ID before passing EN is ---> "
                    + _stationState.getSystemUser().getOperatorParty().getEmployeeId());
            String operatorId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            msj.SetTField(CawEigenConstants.FIELD_EN, operatorId);
            // END BZ25049

            msj.SetTField(CawEigenConstants.FIELD_R7, _gsHelper.getPreScreenId());
            msj.SetTField(CawEigenConstants.FIELD_SV, CawEigenConstants.VALUE_Y);
            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            msj.SetTField(CawEigenConstants.FIELD_R0, CawEigenConstants.VALUE_1);

            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                msj.Confirm();
                clearSecureEntry();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        clearSecureEntry();
        return false;
    }

    /**
     * BZ25761
     * @param argParty
     * @return
     */
    public Boolean instanceCreditRequest(IParty argParty) {

        if (argParty == null) {
            return false;
        }

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_83);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.INSTANT_CREDIT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

            msj.SetTField(CawEigenConstants.FIELD_N1, argParty.getFirstName());
            msj.SetTField(CawEigenConstants.FIELD_N3, argParty.getLastName());

            // BEGIN BZ25049
            logger.debug(" The Employee ID before passing EN is ---> "
                    + _stationState.getSystemUser().getOperatorParty().getEmployeeId());
            String operatorId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            msj.SetTField(CawEigenConstants.FIELD_EN, operatorId);
            // END BZ25049

            /*Set customer's infomation*/
            setCustomerInfo(argParty); /*BZ29514*/

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_Y);
            msj.SetTField(CawEigenConstants.FIELD_SV, CawEigenConstants.VALUE_N);
            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            //msj.SetTField("R7", _cawEigenHelper.getGsPreScreenId());

            if (!StringUtils.isEmpty(birthDay)) {
                msj.SetTField(CawEigenConstants.FN_BIRTH_DATE, birthDay);
            }

            /* START | BZ 23946 */
            msj.SetTField(CawEigenConstants.FIELD_6N, String.valueOf(argParty.getPartyId()));

            if (argParty.getAlternatePartyIds() != null && !argParty.getAlternatePartyIds().isEmpty()
                    && argParty.getAlternatePartyIds().get(0) != null
                    && argParty.getAlternatePartyIds().get(0).getAlternateId() != null) {
                msj.SetTField(CawEigenConstants.FIELD_ME, argParty.getAlternatePartyIds().get(0).getAlternateId());
            } else {
                msj.SetTField(CawEigenConstants.FIELD_ME, CawEigenConstants.VALUE_EMPTY);
            }
            /* END | BZ 23946 */

            msj.SetTField(CawEigenConstants.FIELD_OF, CawEigenConstants.VALUE_A);

            msj.Process();
            _cawEigenHelper.setGsXMLEncode(msj.GetTField(CawEigenConstants.FIELD_GR)); // BZ23976
            _cawEigenHelper.setGsOD(msj.GetTField(CawEigenConstants.FN_OPERATOR_DETAIL_MSG)); // BZ25884
            _gsHelper.setEigenReturnCode(msj.GetTField(CawEigenConstants.FIELD_RC)); // BZ29419
            _gsHelper.setAdsReturnCode(msj.GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE)); // BZ29704
            _gsHelper.setAdsAuxResponseCode(msj.GetTField(CawEigenConstants.FN_AUX_RESPONSE_CODE)); // BZ29704

            /* BEGIN BZ29472 */
            boolean isApproved = _cawEigenHelper.isADSApproved(msj);
            if (isApproved) {
                /* END BZ29472 */
                /* BEGIN BZ29293 */
                _gsHelper.convertGRToObject(msj.GetTField(CawEigenConstants.FIELD_GR));
                /* END BZ29293 */
                /* BEGIN BZ29504*/
                _gsHelper.setFirstNameADS(msj.GetTField(CawEigenConstants.FIELD_N1));
                _gsHelper.setLastNameADS(msj.GetTField(CawEigenConstants.FIELD_N3));
                /* END BZ29504*/
                getCardToken(1); /*BZ29360/BZ29505: use short token here.*/
                msj.Confirm();
                clearSecureEntry();
                return true;
            } else {
                _gsHelper.setApplicationStatus(2); /*BZ28738: set status for decline*/
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        clearSecureEntry();
        return false;
    }

    public Boolean preScreenConfirm(String argEbsResponse) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_MUCK);

            msj.SetTField(CawEigenConstants.FIELD_L1, CawEigenConstants.CONFIRM_DETAILS);
            /* Begin BZ24131 */
            if (getEBSCustomerFullName(argEbsResponse) != null) {
                msj.SetTField(CawEigenConstants.FIELD_L3, getEBSCustomerFullName(argEbsResponse));
            } else if (getEBSCompanyName(argEbsResponse) != null) {
                msj.SetTField(CawEigenConstants.FIELD_L3, getEBSCompanyName(argEbsResponse));
            }
            /* End BZ24131 */
            msj.SetTField(CawEigenConstants.FIELD_L4, getEBSCustomerAddressLine1(argEbsResponse));
            msj.SetTField(CawEigenConstants.FIELD_L5, getEBSCustomerAddressLine2(argEbsResponse));
            msj.SetTField(CawEigenConstants.FIELD_L6, getEBSCustomerAccount(argEbsResponse));
            msj.SetTField(CawEigenConstants.FIELD_L9, CawEigenConstants.CONFIRM_INFO);

            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.VALUE_OX);

            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public String getEBSCustomerAddressLine1(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.JSON_LINE1);
            } catch (JSONException ex) {
                logger.error("JSON Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerAddressLine2(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.CITY) + ", "
                        + res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.STATE_PROVINCE)
                        + " "
                        + res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.POSTAL_CODE);
            } catch (JSONException ex) {
                logger.error("JSON Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerAccount(String argSource) {

        String response = CawEigenConstants.STR_ACCOUNT_NUM;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response += res.getString(CawEigenConstants.ACCOUNT_NUMBER);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerFullName(String argSource) {

        String response = null;
        /* BZ24039 Begin */
        String firstName = null;
        String lastName = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                firstName = res.getJSONObject(CawEigenConstants.JSON_NAME).getString(CawEigenConstants.JSON_FIRST_NAME);
                lastName = res.getJSONObject(CawEigenConstants.JSON_NAME).getString(CawEigenConstants.JSON_LAST_NAME);
                if (firstName != null && lastName != null) {
                    response = firstName + " " + lastName;
                }
                /* BZ24039 End */
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }
    /*End BZ-23265*/

    /* BZ24039 Begin */
    public String getEBSCompanyName(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_NAME)
                        .getString(CawEigenConstants.JSON_COMPANY_NAME);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }
    /* BZ24039 End */

    /*Begin BZ-23587*/
    private String getEBSCustomerAddressLine3(String argSource) {

        String response = CawEigenConstants.VALUE_EMPTY;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                if (res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.JSON_LINE2) != null) {
                    response += res.getJSONObject(CawEigenConstants.JSON_ADDRESS)
                            .getString(CawEigenConstants.JSON_LINE2);
                }
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerCity(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.CITY);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerState(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_ADDRESS)
                        .getString(CawEigenConstants.STATE_PROVINCE);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerZIP(String argSource) {

        String postalCode = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                /* Begin BZ-25986*/
                if (!res.isNull(CawEigenConstants.JSON_ADDRESS)) {
                    if (!res.getJSONObject(CawEigenConstants.JSON_ADDRESS).isNull(CawEigenConstants.POSTAL_CODE)) {
                        postalCode = res.getJSONObject(CawEigenConstants.JSON_ADDRESS)
                                .getString(CawEigenConstants.POSTAL_CODE);

                        if (postalCode != null && postalCode.length() > 5) {
                            postalCode = postalCode.substring(POSTAL_CODE__FIRST_INDEX, POSTAL_CODE__LAST_INDEX);
                        }
                    }
                }

                /* End BZ-25986*/
            } catch (JSONException ex) {
                logger.error("Can not get postalCode from response at ESB: " + ex.getMessage());
            }
        }

        return postalCode;

    }
    /*End BZ-23587*/

    /*Begin BZ-23406*/
    public Boolean shoppingPassAuth(String argShoppingPassNumber, String argExpiry, BigDecimal argAmount) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_01);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FIELD_A1, formatItemPrice(argAmount, BigDecimal.ONE));
            msj.SetTField(CawEigenConstants.FIELD_SO, argShoppingPassNumber);
            msj.SetTField(CawEigenConstants.FIELD_EX, argExpiry);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }

        return false;
    }
    /*End BZ-23406*/

    /*Begin BZ-23265*/
    public Boolean promptSocialSecurityEntryPartial() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KCSU);/* BZ37207 */

            //Begin BZ23685
            msj.SetTField(CawEigenConstants.FIELD_L1, CawEigenConstants.ENTER_LAST_NAME);
            msj.SetTField(CawEigenConstants.FIELD_L2, CawEigenConstants.ENTER_4_DIGITS_OF_SSN);
            msj.SetTField(CawEigenConstants.FIELD_L3, CawEigenConstants.SOCIAL_SECURITY_NUMBER);
            //End BZ23685

            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.VALUE_5N);

            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_5_4_4_N_L_4);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                return true;
            }
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }
    /*End BZ-23265*/

    // Begin BZ23976
    public String getAccountNumber(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getString(CawEigenConstants.ACCOUNT_NUMBER);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getCustomerType(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getString(CawEigenConstants.JSON_CUSTOMER_TYPE);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getCustomerFirstName(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_NAME).getString(CawEigenConstants.JSON_FIRST_NAME);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getCustomerLastName(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_NAME).getString(CawEigenConstants.JSON_LAST_NAME);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public String getEBSCustomerCountry(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawEigenConstants.JSON_ADDRESS).getString(CawEigenConstants.JSON_COUNTRY);
            } catch (JSONException ex) {
                logger.error("Creating Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }
    // End BZ23976

    /**
     * BZ 24937: [Prod Support] Disable line item displaying on pinpad
     */
    public boolean allowDisplayLineItemPP() {

        if (allowDisplLineItmPP == null || allowDisplLineItmPP.isEmpty()) {
            Map<String, Object> params = new HashMap<String, Object>();
            List<TaskTypeResult> results = null;
            params.put(CawEigenConstants.ARG_ORGANIZATION_ID, ConfigurationMgr.getOrganizationId());
            try {
                results = DataFactory.getObjectByQuery(ALLOW_DISPLAY_LINEITM_PP_QUERY, params);
            } catch (ObjectNotPresentException e) {
                logger.debug("ALLOW_DISPLAY_LINEITM_PP_QUERY returns ObjectNotPresentException");
                results = null;
            }

            if (results == null || results.isEmpty()) {
                allowDisplLineItmPP = Boolean.FALSE.toString();
                return false;
            }
            allowDisplLineItmPP = results.get(results.size() - 1).getCode();
        }

        return allowDisplLineItmPP.equalsIgnoreCase(Boolean.TRUE.toString());
    }

    // Begin BZ26858
    /**
     * The function set timeout for the request to Eigen.
     * @param time
     * @param miraRequest
     */
    public void setTimeOut(String time, MiraServJava miraRequest) {

        if (miraRequest != null && !StringUtils.isEmpty(time)) {
            miraRequest.SetTField(HOST_TIMEOUT, time);
            miraRequest.SetTField(SIGCAP_TIMEOUT, time);
            miraRequest.SetTField(SOCKET_CONNECT_TIMEOUT, time);
            miraRequest.SetTField(FN_PINPAD_DISP_TIMEOUT, time);
        }
    }

    /**
     * The function send void request for tender type 'credit/debit'
     * @param iTenderLineItem
     */
    public void sendVoidCreditDebitRequest(ITenderLineItem iTenderLineItem) {

        if (iTenderLineItem != null) {
            try {
                IAuthorizableLineItem tenderLineItem = (IAuthorizableLineItem) iTenderLineItem;

                msj.Init();
                setTimeOut(CawPropertyUtils
                        .getSystemProperty(CawEigenConstants.CAW_EIGEN_TIMEOUT, CawEigenConstants.VALUE_EMPTY), msj);
                msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.VOID_CAPTURE);

                msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());

                msj.SetTField(CawEigenConstants.FN_ECHO_DATA, CawEigenUtil
                        .buildEchoData(tenderLineItem.getRetailLocationId(), tenderLineItem
                                .getWorkstationId(), tenderLineItem.getTransactionSequence()));

                if (tenderLineItem.getAmount() != null) {
                    msj.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().toString()
                            .replace(CawEigenConstants.DOT, CawEigenConstants.VALUE_EMPTY));
                }

                msj.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());

                /*BEGIN BZ29752*/
                if (StringUtils.isNotEmpty(tenderLineItem.getAuthorizationToken())) {
                    msj.SetTField(CawEigenConstants.FN_SHORT_TOKEN, tenderLineItem.getAuthorizationToken());
                    msj.SetTField(CawEigenConstants.FN_EXPIRY_DATE, ((CreditDebitTenderLineItemModel) tenderLineItem)
                            .getExpirationDateString());
                }
                /*END BZ29752*/
                msj.SetTField(CawEigenConstants.MESSAGE_TYPE, CawEigenConstants.MESSAGE_TYPE_Q);

                if (msj.Process()) {
                    if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {//BZ27933
                        logger.info("The credit/debit with amount $" + iTenderLineItem.getAmount()
                                + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                                + " are voided(TC03)successfully. ");//BZ27933
                    }

                } else {
                    logger.info("The credit/debit with amount $" + iTenderLineItem.getAmount()
                            + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                            + " are voided(TC03) fail. ");//BZ27933
                }

            } catch (Exception ex) {
                logger.error("The credit/debit with amount $" + iTenderLineItem.getAmount()
                        + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                        + " was not send the void(TC03) request to Eigen." //BZ27933
                        + ex.getMessage());
            }
        }
    }
    // End BZ26858

    // Begin BZ27933
    public void sendVoidRefundTField(ITenderLineItem iTenderLineItem) {

        if (iTenderLineItem != null) {
            try {
                IAuthorizableLineItem tenderLineItem = (IAuthorizableLineItem) iTenderLineItem;

                msj.Init();
                setTimeOut(CawPropertyUtils
                        .getSystemProperty(CawEigenConstants.CAW_EIGEN_TIMEOUT, CawEigenConstants.VALUE_EMPTY), msj);
                msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.VOID_REFUND);

                msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());

                msj.SetTField(CawEigenConstants.FN_ECHO_DATA, CawEigenUtil
                        .buildEchoData(tenderLineItem.getRetailLocationId(), tenderLineItem
                                .getWorkstationId(), tenderLineItem.getTransactionSequence()));

                if (tenderLineItem.getAmount() != null) {
                    msj.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().abs().toString()
                            .replace(DOT, CawEigenConstants.VALUE_EMPTY));
                } else {
                    msj.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().abs().toString()
                            .replace(DOT, CawEigenConstants.VALUE_EMPTY));
                }
                msj.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());

                /*BEGIN BZ29752*/
                if (StringUtils.isNotEmpty(tenderLineItem.getAuthorizationToken())) {
                    msj.SetTField(CawEigenConstants.FN_SHORT_TOKEN, tenderLineItem.getAuthorizationToken());
                    msj.SetTField(CawEigenConstants.FN_EXPIRY_DATE, ((CreditDebitTenderLineItemModel) tenderLineItem)
                            .getExpirationDateString());
                }
                /*END BZ29752*/
                msj.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);

                if (msj.Process()) {
                    if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                        logger.info("The credit/debit with amount $" + iTenderLineItem.getAmount()
                                + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                                + " are voided(TC06) successfully. ");
                    } else {
                        logger.info("The credit/debit with amount $" + iTenderLineItem.getAmount()
                                + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                                + " are voided(TC06) fail. ");
                    }

                } else {
                    logger.info("The credit/debit with amount $" + iTenderLineItem.getAmount()
                            + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                            + " are voided(TC06) fail. ");
                }

            } catch (Exception ex) {
                logger.error("The credit/debit with amount $" + iTenderLineItem.getAmount()
                        + " used tender into transaction#" + iTenderLineItem.getTransactionSequence()
                        + " was not send the void(TC06) request to Eigen." + ex.getMessage());
            }
        }
    }
    // End BZ27933

    // Begin BZ27344
    /**
     * 
     */
    public void startSessionToClearPinpadScreen() {
        /*BEGIN BZ32046*/
        /*String WELCOME_STRING = FormattableFactory.getInstance().getSimpleFormattable("_cawSigcapWelcome")
                .toString(OutputContextType.VIEW);*/
        /*END BZ32046*/
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_K);

            msj.SetTField(CawEigenConstants.FN_HEADER_OPTION, CawEigenConstants.VALUE_OC_IT_MU);
            msj.SetTField(CawEigenConstants.FN_FOOTER_OPTION, CawEigenConstants.VALUE_OCIT_MB);
            /*BEGIN BZ32046*/
            /*msj.SetTField(CawEigenConstants.FN_HEADER_TXT, WELCOME_STRING);*/
            msj.SetTField(CawEigenConstants.FN_HEADER_TXT, _cawEigenHelper.getWelcomeMessage());
            /*END BZ32046*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * 
     * @param itemID
     * @param qty
     * @param unitPrice
     * @param desc
     * @param sAmountDue
     * @param sTaxAmount
     */
    public void removeItem(String qty, String unitPrice, String desc, String sAmountDue, String sTaxAmount) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TRANS_TYPE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());

            msj.SetTField(CawEigenConstants.FN_ITEM_CODE, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_DES, desc);
            msj.SetTField(CawEigenConstants.FN_ITEM_QTY, qty);
            msj.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, new BigDecimal(unitPrice)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN).toString().replace(".", ""));
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.SE);
            msj.SetTField(CawEigenConstants.FN_OTHER_FLAG, CawEigenConstants.VALUE_V);
            String strFooterPinpad = CawEigenConstants.AMT_DUE + sAmountDue + " | Tax: " + sTaxAmount; /*BZ28403*/
            msj.SetTField(CawEigenConstants.FN_FOOTER_TXT, CawEigenUtil
                    .formatFooterPinpad(strFooterPinpad)); /*BZ28403*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * 
     * @param cawPinpadItemModel
     */
    public void addItemModelToPinpad(CawPinpadItemModel cawPinpadItemModel) {

        // Begin BZ28375
        if (cawPinpadItemModel != null) {
            if (!StringUtils.isEmpty(cawPinpadItemModel.getIsVoid())) {
                boolean isVoid = Boolean.valueOf(cawPinpadItemModel.getIsVoid());
                if (!isVoid) {
                    addItem(cawPinpadItemModel.getQty(), cawPinpadItemModel.getUnitPrice(), cawPinpadItemModel
                            .getDescription(), cawPinpadItemModel.getsAmountDue(), cawPinpadItemModel.getsTaxAmount());
                }
            }
        }
        // End BZ28375
    }

    /**
     * 
     * @param cawPinpadItemModel
     */
    public void removeItemModelToPinpad(CawPinpadItemModel cawPinpadItemModel) {

        String currentQuantity = INIT_NUMBER_ITEM;
        String price = cawPinpadItemModel.getUnitPriceOld();//BZ28401

        if (!cawPinpadItemModel.getCurrentQty().equals(INIT_NUMBER_ITEM)) {
            BigDecimal decimal = new BigDecimal(cawPinpadItemModel.getCurrentQty());
            currentQuantity = String.valueOf(decimal.intValue());
        }

        removeItem(currentQuantity, price, cawPinpadItemModel.getDescription(), cawPinpadItemModel
                .getsAmountDue(), cawPinpadItemModel.getsTaxAmount());
    }
    // End BZ27344

    /* Begin BZ27875 */
    /**
     * The function sent the Void gift card reload to the Eigen when The Xstore terminal.
     * @param lineItem
     */
    public void sendRequestVoidGiftCardReload(IRetailTransactionLineItem lineItem) {

        if (lineItem != null) {
            String amount = CawEigenConstants.VALUE_EMPTY;
            String giftCardType = CawEigenConstants.VALUE_EMPTY;
            try {
                msj.Init();

                setTimeOut(CawPropertyUtils
                        .getSystemProperty(CawEigenConstants.CAW_EIGEN_TIMEOUT, CawEigenConstants.VALUE_EMPTY), msj);
                msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());

                /**
                 * Build request for sale line 
                 */
                if (lineItem instanceof IVoucherSaleLineItem) {
                    IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) lineItem;

                    msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.RELOAD_VOID);
                    giftCardType = CawEigenConstants.GIFT_CARD_TYPE_RELOAD;

                    if (CawEigenConstants.GIFT_CARD_TYPE_ISSUED
                            .equalsIgnoreCase(voucherSaleLineItem.getActivityCode())) {
                        msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.DEACTIVATE);
                        giftCardType = CawEigenConstants.GIFT_CARD_TYPE_ISSUED;
                    }

                    String echoData = CawEigenUtil.buildEchoData(lineItem.getRetailLocationId(), lineItem
                            .getWorkstationId(), lineItem.getTransactionSequence());

                    msj.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData);

                    msj.SetTField(CawEigenConstants.FN_APPROVAL_CD, voucherSaleLineItem.getAuthorizationCode());
                    msj.SetTField(CawEigenConstants.FN_TOKEN, voucherSaleLineItem.getBankReferenceNumber());

                    amount = voucherSaleLineItem.getBaseUnitPrice().toString();
                    msj.SetTField(CawEigenConstants.FN_AMOUNT_1, amount.replace(DOT, CawEigenConstants.VALUE_EMPTY));

                } else if (lineItem instanceof IVoucherTenderLineItem) {

                    /**
                     * Build request for tender line with types active Gift Card: RELOAD_VOID, DEACTIVATE and REDEEM_VOID
                     * 
                     */

                    /* BEGIN BZ28735 */
                    IVoucherTenderLineItem voucherTenderLineItem = (IVoucherTenderLineItem) lineItem;
                    msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.RELOAD_VOID);
                    giftCardType = CawEigenConstants.GIFT_CARD_TYPE_RELOAD;
                    String activityCode = voucherTenderLineItem.getActivityCode();

                    if (activityCode != null) {
                        if (CawEigenConstants.GIFT_CARD_TYPE_ISSUED.equalsIgnoreCase(activityCode)) {
                            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.DEACTIVATE);
                            giftCardType = CawEigenConstants.GIFT_CARD_TYPE_ISSUED;
                        } else if (CawEigenConstants.GIFT_CARD_TYPE_REDEEM.equalsIgnoreCase(activityCode)
                                || CawEigenConstants.GIFT_CARD_TYPE_REDEEMED.equalsIgnoreCase(activityCode)) {
                            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.REDEEM_VOID);
                            giftCardType = CawEigenConstants.GIFT_CARD_TYPE_REDEEM;
                        }
                    }

                    /* END BZ28735 */

                    String echoData = CawEigenUtil
                            .buildEchoData(voucherTenderLineItem.getRetailLocationId(), voucherTenderLineItem
                                    .getWorkstationId(), voucherTenderLineItem.getTransactionSequence());

                    msj.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData);

                    msj.SetTField(CawEigenConstants.FN_APPROVAL_CD, voucherTenderLineItem.getAuthorizationCode());
                    msj.SetTField(CawEigenConstants.FN_TOKEN, voucherTenderLineItem.getBankReferenceNumber());

                    amount = voucherTenderLineItem.getAmount().abs().toString();
                    msj.SetTField(CawEigenConstants.FN_AMOUNT_1, amount.replace(DOT, CawEigenConstants.VALUE_EMPTY));
                }

                msj.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);

                // Sent the Void gift card reload request to the Eigen.
                if (msj.Process()) {
                    if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                        logger.info("The Gift Card " + giftCardType + "with amount $" + amount
                                + " used into transaction#" + lineItem.getTransactionSequence()
                                + " are voided successfully. ");
                    } else {
                        logger.info("The Gift card " + giftCardType + " with amount $" + amount
                                + " used into transaction#" + lineItem.getTransactionSequence()
                                + " are unsuccessfully. The error was the response from Eigen:"
                                + msj.GetTField(CawEigenConstants.FN_DISPLAY_MSG));
                    }

                } else {
                    logger.info("The Gift card " + giftCardType + " with amount $" + amount
                            + " used tender into transaction#" + lineItem.getTransactionSequence()
                            + " are voided fail. ");
                }

            } catch (Exception ex) {
                logger.error("The Gift card (deactive/reload/redeem) " + " used into transaction#"
                        + lineItem.getTransactionSequence() + " was not send the void request to Eigen."
                        + ex.getMessage());
            }
        }
    }
    /* End BZ27875 */

    /**
     * Offer Good Sam Reward Screen
     * (Card type = 1: VISA)
     * (Card type = 2: PLCC)
     * @param custParty
     * @param cardType
     * @return
     */
    /**
     * Offer Good Sam Reward Screen
     * (Card type = 1: VISA)
     * (Card type = 2: PLCC)
     * @param custParty
     * @param cardType
     * @return
     */
    public int offerGoodSamReward(IParty custParty, int cardType) {

        String cardTypeString = "";
        int key = 0;
        /* BEGIN BZ29399*/
        //Visa or PLCC
        if (cardType == 1) {
            cardTypeString = _ff.getTranslatable("_visaPinpad").toString();
            key = displayPreApprovedForCoBrand(custParty); //BZ29601
        } else if (cardType == 2) {
            cardTypeString = _ff.getTranslatable("_plcc").toString();
            key = displayPreApprovedForPLCC(custParty, cardTypeString); //BZ29601
        }

        return key;
    }

    /* BEGIN BZ29601*/
    /**
     * @param custParty
     * @param cardTypeString
     * @param key
     * @return
     */
    private int displayPreApprovedForPLCC(IParty custParty, String cardTypeString) {
        int key = 0;
        try {
            msj.Init();
            /* END BZ29399 */
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            //Customer name or Company name
            msj.SetTField(CawEigenConstants.FIELD_L1, makeString("_offerL1", _customerHelper
                    .getCustomerDisplayName(custParty)));
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_offerL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, makeString("_offerL3", cardTypeString));
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_offerL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_L7, _ff.getTranslatable("_offerL7").toString());
            msj.SetTField(CawEigenConstants.FIELD_L8, _ff.getTranslatable("_offerL8").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_offerL9").toString());
            /* BEGIN BZ29399*/
            msj.SetTField(CawEigenConstants.FIELD_L0, makeString("_offerL10", cardTypeString));
            msj.SetTField(CawEigenConstants.FIELD_LA, _ff.getTranslatable("_offerL11").toString());
            /* END BZ29399*/
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F6_F7_F8);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F6, CawEigenConstants.TEXT_THIS_NOT_ME);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_NO_THANKS);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F8, CawEigenConstants.TEXT_YES_ACCEPT);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                if (CawEigenConstants.KEY_F8.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    msj.Confirm();
                    key = 1;
                } else if (CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    key = 2;
                } else if (CawEigenConstants.KEY_F6.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    key = 3;
                }
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return key;
    }

    private int displayPreApprovedForCoBrand(IParty custParty) {
        int key = 0;
        try {
            msj.Init();

            /* END BZ29399 */
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            //Customer name or Company name
            msj.SetTField(CawEigenConstants.FIELD_L1, makeString("_cawCoBrandL1", _customerHelper
                    .getCustomerDisplayName(custParty)));
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_cawCoBrandL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_cawCoBrandL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_cawCoBrandL4").toString());

            msj.SetTField(CawEigenConstants.FIELD_L7, _ff.getTranslatable("_cawCoBrandL7").toString());
            msj.SetTField(CawEigenConstants.FIELD_L8, _ff.getTranslatable("_cawCoBrandL8").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_cawCoBrandL9").toString());
            msj.SetTField(CawEigenConstants.FIELD_L0, _ff.getTranslatable("_cawCoBrandL10").toString());
            msj.SetTField(CawEigenConstants.FIELD_LA, _ff.getTranslatable("_cawCoBrandL11").toString());
            msj.SetTField(CawEigenConstants.FIELD_LB, _ff.getTranslatable("_cawCoBrandL12").toString());

            /* END BZ29399*/
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F6_F7_F8);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F6, CawEigenConstants.TEXT_THIS_NOT_ME);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_NO_THANKS);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F8, CawEigenConstants.TEXT_YES_ACCEPT);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                if (CawEigenConstants.KEY_F8.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    msj.Confirm();
                    key = 1;
                } else if (CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    key = 2;
                } else if (CawEigenConstants.KEY_F6.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                    key = 3;
                }
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return key;
    }
    /* END BZ29601*/

    /**
     * BZ25761
     * Customer information verification
     * @param custParty
     * @return
     */
    public boolean verifyCustomer(IParty custParty) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_verifyCusInfoL1").toString());
            //Customer name or Company name
            msj.SetTField(CawEigenConstants.FIELD_L3, makeString("_verifyCusInfoL3", _customerHelper
                    .getCustomerDisplayName(custParty)));
            //Address line 1
            msj.SetTField(CawEigenConstants.FIELD_L4, makeString("_verifyCusInfoL4", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 1)));
            //City
            msj.SetTField(CawEigenConstants.FIELD_L5, makeString("_verifyCusInfoL5", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 2)));
            //State
            msj.SetTField(CawEigenConstants.FIELD_L6, makeString("_verifyCusInfoL6", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 3)));
            //Zipcode
            msj.SetTField(CawEigenConstants.FIELD_L7, makeString("_verifyCusInfoL7", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 4)));
            //Phone numbers
            Map<String, String> phoneNumbers = CawCustomerUtil.getPhoneNumberIParty(custParty);
            String home = "";
            String mobile = "";
            if (!CollectionUtils.sizeIsEmpty(phoneNumbers)) {
                home = phoneNumbers.get(CawConstants.HOME);
                home = (home == null) ? "" : home;
                mobile = phoneNumbers.get(CawConstants.MOBILE);
                mobile = (mobile == null) ? "" : mobile;
            }
            msj.SetTField(CawEigenConstants.FIELD_L8, makeString("_verifyCusInfoL8", home));
            msj.SetTField(CawEigenConstants.FIELD_L9, makeString("_verifyCusInfoL9", mobile));
            //Email
            String email = custParty.getEmailAddress();
            if (email == null) {
                email = "";
            }
            msj.SetTField(CawEigenConstants.FIELD_L0, makeString("_verifyCusInfoL10", email));
            /* BEGIN BZ29290 */
            String subEmail = "";
            int lengthEmail = email.length();
            if (lengthEmail > CawEigenConstants.MAX_LENGTH_FIRST_LINE_EMAIL) {
                subEmail = email.substring(CawEigenConstants.MAX_LENGTH_FIRST_LINE_EMAIL, lengthEmail);
                //If length of subEmail after split > MAX_LENGTH_SECOND_LINE_EMAIL. Get MAX_LENGTH_SECOND_LINE_EMAIL character first.
                if (subEmail.length() > CawEigenConstants.MAX_LENGTH_SECOND_LINE_EMAIL) {
                    subEmail = subEmail.substring(0, CawEigenConstants.MAX_LENGTH_SECOND_LINE_EMAIL);
                }
                msj.SetTField(CawEigenConstants.FIELD_LA, subEmail);
            }
            /* END BZ29290 */
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F6_F7);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F6, CawEigenConstants.TEXT_NO);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_YES);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    /**
     * BZ25761
     * Government-issued identification
     */
    public void verifyGovIssuedId() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_govIssuedIdL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_govIssuedIdL2").toString());
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * BZ25761
     * Enter annual income
     * @return
     */
    public boolean enterAnnualIncome() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.SECURE_ENTRY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_annualIncomeL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_annualIncomeL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_annualIncomeL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_annualIncomeL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_L6, _ff.getTranslatable("_annualIncomeL6").toString());
            msj.SetTField(CawEigenConstants.FIELD_L8, _ff.getTranslatable("_annualIncomeL8").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_annualIncomeL9").toString());
            msj.SetTField(CawEigenConstants.FIELD_L0, _ff.getTranslatable("_annualIncomeL10").toString());
            msj.SetTField(CawEigenConstants.FIELD_LA, _ff.getTranslatable("_annualIncomeL11").toString());
            msj.SetTField(CawEigenConstants.FIELD_P1, CawEigenConstants.FIELD_A2);
            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_13_1_7_D_L);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    /**
     * BZ25761
     * @param custParty
     * @return
     */
    public boolean displayPhoneNumbers(IParty custParty) { /* BZ29613 */

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_phonesL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_phonesL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_phonesL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_phonesL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_phonesL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_L6, _ff.getTranslatable("_phonesL6").toString());
            msj.SetTField(CawEigenConstants.FIELD_L7, _ff.getTranslatable("_phonesL7").toString());
            msj.SetTField(CawEigenConstants.FIELD_L8, _ff.getTranslatable("_phonesL8").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_phonesL9").toString());
            //Get phone numbers
            Map<String, String> phoneNumbers = CawCustomerUtil.getPhoneNumberIParty(custParty);
            String home = "";
            String mobile = "";
            if (!CollectionUtils.sizeIsEmpty(phoneNumbers)) {
                home = phoneNumbers.get(CawConstants.HOME);
                home = (home == null) ? "" : home;
                mobile = phoneNumbers.get(CawConstants.MOBILE);
                mobile = (mobile == null) ? "" : mobile;
            }
            msj.SetTField(CawEigenConstants.FIELD_LA, makeString("_phonesL11", home));
            msj.SetTField(CawEigenConstants.FIELD_LB, makeString("_phonesL12", mobile));
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F7);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_OK);//BZ29478
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    /* BEGIN BZ29613 */
    public boolean displayConfirmationInstantCredit() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);

            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_cawInstantCreditConfirmaL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_cawInstantCreditConfirmaL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_cawInstantCreditConfirmaL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_cawInstantCreditConfirmaL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_cawInstantCreditConfirmaL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_L6, _ff.getTranslatable("_cawInstantCreditConfirmaL6").toString());
            msj.SetTField(CawEigenConstants.FIELD_L7, _ff.getTranslatable("_cawInstantCreditConfirmaL7").toString());
            msj.SetTField(CawEigenConstants.FIELD_L8, _ff.getTranslatable("_cawInstantCreditConfirmaL8").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_cawInstantCreditConfirmaL9").toString());

            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F7);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_SUBMIT);
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }

        return false;
    }

    /* END BZ29613 */

    /**
     * BZ25761
     * @param gsInfo
     * @return
     */
    public boolean applyGoodSamRewards(CawCustomerGSInfo gsInfo) {

        String cardTypeString = "";
        //Visa or PLCC
        if (gsInfo.getCardType() == 1) {
            cardTypeString = _ff.getTranslatable("_visaPinpad").toString();
        } else if (gsInfo.getCardType() == 2) {
            cardTypeString = _ff.getTranslatable("_plcc").toString();
        }
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_applyGSL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_applyGSL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, makeString("_applyGSL3", cardTypeString.toUpperCase()));

            /* BEGIN BZ29619 */
            msj.SetTField(CawEigenConstants.FIELD_L5, makeString("_applyGSL5", _moneyFormatter
                    .format(gsInfo.getCreditLimit(), null)));
            msj.SetTField(CawEigenConstants.FIELD_L6, _ff.getTranslatable("_applyGSL6").toString());
            String strApr = CawConstants.VALUE_00;
            if (StringUtils.isNotEmpty(gsInfo.getApr())) {
                strApr = gsInfo.getApr();
            }
            msj.SetTField(CawEigenConstants.FIELD_L7, makeString("_applyGSL7", strApr));//BZ29416
            msj.SetTField(CawEigenConstants.FIELD_L8, makeString("_applyGSL8", _moneyFormatter
                    .format(gsInfo.getVitualCreditLimit(), null)));//BZ29416/BZ29454
            /* END BZ29619 */
            msj.SetTField(CawEigenConstants.FIELD_L9, _ff.getTranslatable("_applyGSL9").toString());
            /* BEGIN BZ57844 */
            /* if (_gsHelper.isEnableLoyalty()) {
                msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F7);
                msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_OK);
            } else {
                msj.SetTField(CawEigenConstants.FIELD_LA, _ff.getTranslatable("_applyGSL11").toString());
                msj.SetTField(CawEigenConstants.FIELD_LB, _ff.getTranslatable("_applyGSL12").toString());
                msj.SetTField(CawEigenConstants.FIELD_LC, makeString("_applyGSL13", cardTypeString));
                msj.SetTField(CawEigenConstants.FIELD_LD, _ff.getTranslatable("_applyGSL14").toString());

                msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F6_F7);
                msj.SetTField(CawEigenConstants.KEY_TEXT_F6, CawEigenConstants.TEXT_NO);
                msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_YES);
            }*/
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F7);
            msj.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_OK);
            /* END BZ57844 */
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.KEY_F7.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    /**
     * BZ25761
     * Government-issued identification
     */
    public void displayPendedForm() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_pendedL1").toString());
            //msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_pendedL3").toString()); /*BZ29237 Two space line will be displayed at here*/
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_pendedL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_pendedL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_D7, CawEigenConstants.TEN_SEC); /*BZ28738: set timeout for screen*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * BZ28973
     * Government-issued identification when decline.
     */
    public void displayErrorForm() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_pendedL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_errordelL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_errordelL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L5, _ff.getTranslatable("_errordelL5").toString());
            msj.SetTField(CawEigenConstants.FIELD_D7, CawEigenConstants.TEN_SEC); /*BZ28738: set timeout for screen*/
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }

    /**
     * BZ25761
     * @param keyTranslation
     * @param parameter
     * @return
     */
    public String makeString(String keyTranslation, String parameter) {

        return String.format(_ff.getTranslatable(keyTranslation).toString(), parameter); /*BZ27973*/
    }

    /* BEGIN BZ25762 */
    /**
     * Account Summary Request.
     * @return
     */
    public boolean requestAccountLookup() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_83);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.ACCOUNT_SUMMARY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            msj.SetTField(CawEigenConstants.FIELD_P7, CawEigenConstants.VALUE_Y);
            /*BZ29468: This token is retrieved from swip card request.*/
            setCardToken(2); /*BZ29536/BZ29505: use Long Token here*/
            msj.Process();
            _gsHelper.clearGSInfo();//BZ29343:clear value before set
            _cawEigenHelper.setGsXMLEncode(msj.GetTField(CawEigenConstants.FIELD_GR));

            /*BEGIN BZ29379*/
            _gsHelper.setResMgs(msj.GetTField(CawEigenConstants.FN_OPERATOR_MESSAGE));
            /*END BZ29379*/

            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                /*BEGIN BZ29379*/
                if (CawEigenConstants.ADS_RETURN_CODE_APPROVE_00
                        .equalsIgnoreCase(msj.GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE))) {
                    /*END BZ29379*/
                    _gsHelper.parseCustomerInfo(msj.GetTField(CawEigenConstants.FIELD_GR)); // BZ29535
                    /*BEGIN BZ27973*/
                    _gsHelper.setFirstNameADS(msj.GetTField(CawEigenConstants.FIELD_N1));
                    _gsHelper.setLastNameADS(msj.GetTField(CawEigenConstants.FIELD_N3));
                    _gsHelper.setMarkedPAN(formatAccountNumber(msj
                            .GetTField(CawEigenConstants.FN_PAN), CawEigenConstants.INVOICE_TRANSACTION_SEQ, CawEigenConstants.KEY_F8, CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD)); // BZ29528
                    /*END BZ27973*/
                    _gsHelper.setAccountCode(msj.GetTField(CawEigenConstants.FIELD_AU));// BZ27973
                    /* BEGIN BZ29535 */
                    //Phuong need to update code below on TRUNK BRANCH
                    /*_gsHelper.setMinAmountDue(new BigDecimal(msj.GetTField(CawEigenConstants.MINIMUM_PAYMENT_AMOUNT_DUE)));
                    _gsHelper.setDueDate(msj.GetTField(CawEigenConstants.PAYMENT_DUE_DATE));*/
                    /* END BZ29535 */
                    getCardToken(1); /*BZ29360/BZ29505: use short token here.*/
                    msj.Confirm();
                    clearSecureEntry();
                    return true;
                    /*BEGIN BZ29379*/
                } else {
                    msj.Confirm();
                    return false;
                }
                /*END BZ29379*/
            } else {
                msj.Confirm();
                return false;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }
    /* END BZ25762 */

    /* BEGIN BZ25762 */
    /**
     * Screen confirm "Retry Account Lookup" on PINPAD
     * @return
     */
    public boolean retryAccountLookup() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUCK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_retryLookupL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_retryLookupL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_retryLookupL4").toString());
            msj.SetTField(CawEigenConstants.FIELD_L9, CawEigenConstants.CONFIRM_INFO);
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.VALUE_OX);
            msj.Process();
            if (CawEigenConstants.PINPAD_KEY_OK.equals(msj.GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                msj.Confirm();
                return true;
            }
        } catch (MiraServJavaException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    /* END BZ25762 */

    /* BEGIN BZ29134 */
    /***
     * 
     * Pin Pad displaying the message for three failed attempts to enter SSN
     */
    public void displayAccountThreeFailedAttemptsSSN() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_ppnumattemptL1").toString());
            msj.SetTField(CawEigenConstants.FIELD_L2, _ff.getTranslatable("_ppnumattemptL2").toString());
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_ppnumattemptL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_ppnumattemptL4").toString());
            msj.Process();

        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }
    /* END BZ29134 */

    /*BEGIN BZ27973*/
    public boolean swipeCardRequest() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_60);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.Process();
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                /*BZ29468: This token will be set to request Account Lookup later.*/
                getCardToken(2);/*BZ29536/BZ29505: use long token here*/
                msj.Confirm();
                return true;
            } else {
                msj.Confirm();
                return false;
            }
        } catch (MiraServJavaException | IOException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
        return false;
    }

    public void displayAccountInquiry(CawCustomerGSInfo gsInfo) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */

            /* BEGIN BZ29400 */
            StringBuilder nameADS = new StringBuilder();
            nameADS.append(_gsHelper.getFirstNameADS()).append(CawConstants.SPACE_SIGN)
                    .append(_gsHelper.getLastNameADS()).toString();
            msj.SetTField(CawEigenConstants.FIELD_L3, makeString("_accountInquiryL2", nameADS.toString()));
            // msj.SetTField(CawEigenConstants.FIELD_L3, makeString("_accountInquiryL2", _customerHelper
            //  .getCustomerDisplayName(custParty)));
            /* END BZ29400 */

            msj.SetTField(CawEigenConstants.FIELD_L4, makeString("_accountInquiryL3", gsInfo.getMarkedPAN()));
            msj.SetTField(CawEigenConstants.FIELD_L5, makeString("_accountInquiryL4", _moneyFormatter
                    .format(gsInfo.getBlance(), null)));
            msj.SetTField(CawEigenConstants.FIELD_L6, makeString("_accountInquiryL5", _moneyFormatter
                    .format(gsInfo.getMinAmountDue(), null)));
            /* BEGIN BZ29535 */
            Date dueDate = CawUtilFunction.formatDateMMDDYYY(_gsHelper.getDueDate());
            String strDueDate = CawUtilFunction.convertDateFormatMMDDYYY(dueDate);
            msj.SetTField(CawEigenConstants.FIELD_L7, makeString("_accountInquiryL6", strDueDate));
            /* END BZ29535 */
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }
    /*END BZ27973*/

    /*BEGIN BZ29360/BZ29505*/
    /**
     * Get card token from ADS response
     * @param tokenType
     * 1: short token
     * 2: long token
     */
    private void getCardToken(int tokenType) {

        String expDate = null;
        try {
            if (tokenType == 1) {
                _gsHelper.setAccountLongToken(msj.GetTField(CawEigenConstants.FN_TOKEN));/*BZ35962*/
                _gsHelper.setAccountShortToken(msj.GetTField(CawEigenConstants.FN_SHORT_TOKEN)); /*BZ29536*/
                /*BEGIN BZ29505, BZ29960: in case EX in Eigen's response is corrupted. Set default EX, current +1 month*/
                if (StringUtils.isEmpty(_gsHelper.getExpiryDay())) {
                    expDate = msj.GetTField(CawEigenConstants.FN_EXPIRY_DATE);
                    if (StringUtils.isEmpty(expDate)) {
                        expDate = _gsHelper.getGSExpiryDate(CawEigenConstants.EXPIRY_DATE_MMYY);
                    }
                    _gsHelper.setExpiryDay(expDate);
                }
                /*END BZ29505, BZ29960*/
            } else if (tokenType == 2) {
                _gsHelper.setAccountLongToken(msj.GetTField(CawEigenConstants.FN_TOKEN));/*BZ29536*/
            }
            /*BEGIN BZ33319*/
            if (!StringUtils.isEmpty(msj.GetTField(CawEigenConstants.FN_EXTENDED_CARD_TYPE))) {
                _gsHelper.setExtendedCardType(msj.GetTField(CawEigenConstants.FN_EXTENDED_CARD_TYPE));
            }
            /*END BZ33319*/
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }
    /*END BZ29360/BZ29505*/

    /*BEGIN BZ29505*/
    /**
     * Set the token into ADS request
     * 1: short token
     * 2: long token
     */
    private void setCardToken(int tokenType) {

        if (tokenType == 1) {
            msj.SetTField(CawEigenConstants.FN_SHORT_TOKEN, _gsHelper.getAccountShortToken());/*BZ29536, khanhhuynh*/
            /*Only GS Visa card that need expiry date*/
            if (_gsHelper.getCardType() == 1) {
                msj.SetTField(CawEigenConstants.FN_EXPIRY_DATE, _gsHelper.getExpiryDay());
            }
        } else if (tokenType == 2) {
            msj.SetTField(CawEigenConstants.FN_TOKEN, _gsHelper.getAccountLongToken()); /*BZ29536*/
        }
    }
    /*END BZ29505*/

    /*BEGIN BZ29406*/
    /**
     * Request GS Account Payment
     * @param trans
     * @return
     */
    public boolean accountPaymentRequest(IPosTransaction trans, String argTenderType, BigDecimal argTenderAmount) {
        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_70);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FIELD_SN, String.valueOf(_stationState.getRetailLocationId()));
            setCardToken(1); /*BZ29505: use short token here*/
            /*Set trans seq and trans amount*/
            String transSeq = String.valueOf(trans.getTransactionSequence());
            BigDecimal amount = new BigDecimal(CawEigenConstants.DEFAUTL_AMOUNT); //BZ29455
            if (trans.getSubtotal() != null) {
                amount = trans.getSubtotal();//BZ29455
            }
            msj.SetTField(CawEigenConstants.FIELD_HI, transSeq);
            
            // BEGIN BZ46300: Update A1 to use tender amount and add TE field for tender type
            if (argTenderAmount.compareTo(amount) >= 0) {
            msj.SetTField(CawEigenConstants.FIELD_A1, formatItemPrice(amount, BigDecimal.ONE)); //BZ29455
            }
            else {
                msj.SetTField(CawEigenConstants.FIELD_A1, formatItemPrice(argTenderAmount, BigDecimal.ONE)); //BZ29455
            }           
            
            if (!dtv.util.StringUtils.EMPTY.equalsIgnoreCase(argTenderType)) {
                msj.SetTField(CawEigenConstants.FIELD_TE, argTenderType);
            }           
            // END BZ46300
            
            msj.Process();
            _cawEigenHelper.setGsXMLEncode(msj.GetTField(CawEigenConstants.FIELD_GR));
            if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {

                /* BEGIN BZ29476 */
                if (StringUtils.isNotEmpty(msj.GetTField(CawEigenConstants.FN_SIGNATURE_DATA))) {
                    _cawEigenHelper.setAcPaymentSignature(msj.GetTField(CawEigenConstants.FN_SIGNATURE_DATA));
                }
                /* END BZ29476 */

                msj.Confirm();
                clearSecureEntry();
                return true;
            } else {
                msj.Confirm();
            }
        } catch (MiraServJavaException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    /*END BZ29406*/

    /*BEGIN BZ29514*/
    /**
     * Set customer's information into request
     * @param argParty
     */
    private void setCustomerInfo(IParty argParty) {

        /*BEGIN BZ23587, BZ25761, BZ29515*/
        msj.SetTField(CawEigenConstants.FIELD_D1, CawCustomerUtil
                .getAddressInfoIParty(argParty, CawCustomerAddressFieldType.ADDRESS1));
        msj.SetTField(CawEigenConstants.FIELD_D2, CawCustomerUtil
                .getAddressInfoIParty(argParty, CawCustomerAddressFieldType.ADDRESS2));
        msj.SetTField(CawEigenConstants.FIELD_1C, CawCustomerUtil
                .getAddressInfoIParty(argParty, CawCustomerAddressFieldType.CITY));
        msj.SetTField(CawEigenConstants.FIELD_1S, CawCustomerUtil
                .getAddressInfoIParty(argParty, CawCustomerAddressFieldType.STATE));
        msj.SetTField(CawEigenConstants.FIELD_Z1, CawCustomerUtil.getPartialZipcode(argParty)); /*BZ29316*/
        /*END BZ23587, BZ25761, BZ29515*/
        //Set phone numbers
        msj.SetTField(CawEigenConstants.VALUE_6P, formatedPhoneNumber(argParty));
    }

    /**
     * Format phone numbers follow format Home:Mobile for credit application.
     * @param argParty
     * @return string with format Home:Mobile
     */
    private String formatedPhoneNumber(IParty argParty) {

        StringJoiner value = new StringJoiner(CawConstants.CAW_COLON_SIGN);
        /*Home:Mobile*/
        if (StringUtils.isNotEmpty(CawCustomerUtil.getPhoneNumberByType(argParty, 1))) {
            value.add(CawCustomerUtil.getPhoneNumberByType(argParty, 1));
        }
        if (StringUtils.isNotEmpty(CawCustomerUtil.getPhoneNumberByType(argParty, 2))) {
            value.add(CawCustomerUtil.getPhoneNumberByType(argParty, 2));
        }
        return value.toString().replace("-", "");
    }

    /**
     * Government-issued identification
     */
    public void askingPhoneNumber() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L3, _ff.getTranslatable("_cawAskingPhoneNumberL3").toString());
            msj.SetTField(CawEigenConstants.FIELD_L4, _ff.getTranslatable("_cawAskingPhoneNumberL4").toString());
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }
    /*END BZ29514*/

    /* BEGIN BZ29528 */
    /***
     * Function to replace from String "1234*****3455" to "********3455" 
     * @param strInput 1234*****3455
     * @param amountDisplay 4 is (4 last character ->"3455")
     * @param symbolReplace "*"
     * @param symbolAmount 8
     * @return ********3455
     */
    public static String formatAccountNumber(String strInput, int amountDisplay, String symbolReplace,
            int symbolAmount) {

        String strResult = "";
        if (strInput.length() >= amountDisplay) {
            String strEndPart = strInput.substring(strInput.length() - amountDisplay);
            String sRepeated = IntStream.range(0, symbolAmount).mapToObj(i -> symbolReplace)
                    .collect(Collectors.joining(""));
            strResult = sRepeated + strEndPart;
        }
        return strResult;
    }
    /* END BZ29528 */

    /* BEGIN BZ29379 */
    /***
     * 
     * PINPAD Good Sam Account Payment Inquiry response displays as same as  
     * response message unsuccessfully on Xstore retrieved from Miraserve.
     */
    public void displayResMgs(String resMgs) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            msj.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.TEXT_DISPLAY);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);/* BZ37207 */
            msj.SetTField(CawEigenConstants.FIELD_L1, resMgs);
            msj.SetTField(CawEigenConstants.FIELD_D7, CawEigenConstants.FIVE_SEC);
            msj.Process();

        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }
    }
    /* END  BZ29379 */
    /* BEGIN BZ37382 */
    public String signatureCapture(IOrder currentOrder) {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP_TYPE);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper
                    .getStationId());
            msj.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.KCLU);
            /* Begin Check Oder type for display in pinpad*/
            if (currentOrder != null && currentOrder.getStatusCode()
                    .equals(CawEigenConstants.TRANS_ODER_STATUS_TRAINSACTION)) {
                msj.SetTField(CawEigenConstants.FIELD_L2, CawEigenConstants.PINPAD_ODER_PICKUP_TRAINSACTION);
            } else
                msj.SetTField(CawEigenConstants.FIELD_L2, CawEigenConstants.PINPAD_ODER_CREATE_TRAINSACTION);
            /* End Check Oder type for display in pinpad*/
            msj.SetTField(CawEigenConstants.FIELD_LF, CawEigenConstants.FIELD_CLEAR);
            msj.SetTField(CawEigenConstants.FIELD_LE, CawEigenConstants.FIELD_ACCEPT);
            /* BEGIN BZ37661 */
            msj.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.VALUE_OX);
            /* END BZ37661 */
            msj.Process();
            /* BEGIN BZ37661 */
            if (msj.GetTField(CawEigenConstants.FN_SIGNATURE_DATA) != null
                    && msj.GetTField(CawEigenConstants.FN_SIGNATURE_DATA).length() > 0) {
                setSigCap(msj.GetTField(CawEigenConstants.FN_SIGNATURE_DATA));
                setResponseApproved(msj.GetTField(CawEigenConstants.FN_RESPONSE_CODE));
            }
            /* END BZ37661 */
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        }

        return sigCap;
    }
    /* ENDs BZ37382 */
}
