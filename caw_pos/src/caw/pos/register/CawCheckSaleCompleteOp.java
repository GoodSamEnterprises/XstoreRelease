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
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 * BZ27294          220818    'Issue Store credit' is displayed as refund tender when performing WO complete then remove a line item from WO transaction
 * BZ29410          280219    [Internal] Xstore displaying Sale Tenders Options screen and not the Tender amount box.
 * BZ29590          010319    [Internal] PLCC/CO-BRAND-Good Sam Visa should be displayed on receipt instead of Credit/Card when using authorized token tender of Credit application to tender.
 * BZ29635          050319    [Internal] Xstore backs to Sale screen instead of Sale Tender option when hit BACK on Sale Complete for Return transaction used authorized token credit/debit for refund.
 * BZ29743          260319    [Internal] Modify Tender screen is prompted when there is no tenders to modify.
 * BZ31569          260619    [Port BZ31111 to 5.0] [Prod] Lost PLCC token when doing the account lookup for the WO transactions
 * BZ32033          290719    [Prod] WO Issuing Store Credit
 * BZ35513          120320    [NEW REQ] Need option for "No Receipt" as a Receipt Method on Sales Complete screen
 * BZ37382          270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ37884          180920    Disable extra Customer Copy & Store Copy of printed receipt for Brokered Order Transactions
 * BZ42889          110521    [Prod] Order cancellation with pricing turned on, tries to force a return with a refund. The refund should be happening in Oracle.
 * BZ46798          151021    [Internal] Performing partial reject back to back will force the user to restart Xstore
 * BZ47542          061221    RV Service Payments - Property Names
 * BZ48441          110222    [PROD] Issue Refunding Money during WO Complete
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 * BZ48692          250422    [Task] Process New Service is offline/time out when processing customer Search.
 * BZ50112          240522    [Internal] Loyalty Member Order Submit API - Need to add memberId to the request body
 * BZ50139          260522    [Internal] Xstore makes a call to New Service incorrectly when performing types of Work Order transactions. 
 * BZ51770          181022    [Task[ Xstore needs to handle these additional updated submit order response from API
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 * BZ53547          161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 * BZ53876          291122    [Internal] Mismatch information between Submit Order API request and Order Service request.
 * BZ55978          290323    Loyalty Issue: Java Null Pointer
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ57844          030823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58836          080923    [Internal] Disqualification of GS Membership offer displays unexpectedly at print receipt when using PLCC amount for Account Lookup
 * BZ58840          080923    [Internal] Disqualification of GS Membership offer display unexpectedly when not applied for GS Membership offer
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62219          060324    [Internal] - Xstore makes a call to Retrieve the Reward API when the customer is not a Loyalty member
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ63054          080424    [API Change] - Format of the Submit Order API response is changed.
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 * BZ69392          170225    [AGIS Modification] - Update the Receipt (Section 2.2)
 * BZ69691          210225    [AGIS Modification] The submitOrder response does not include information of “subscriberId” and “phoneNumber” in “attributes”
 *===================================================================
 */

package caw.pos.register;

import static dtv.pos.common.TransactionType.RETAIL_SALE;
import static dtv.pos.email.Configurations.getSendEmailReceipts;
import static dtv.xst.xom.impl.order.OrderLineStatus.CANCELLED;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.agis.op.CawAGISPitchesHelper;
import caw.pos.cheetah.util.*;
import caw.pos.common.*;
import caw.pos.order.CawOrderHelper;
import caw.pos.pricing.discount.CawDiscountCouponHelper;
import caw.pos.register.rvpayment.CawRvPaymentHelper;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.hardware.posprinting.ReceiptInfo;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.account.AccountManager;
import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.email.receipt.EmailRcptDeliveryType;
import dtv.pos.email.receipt.EmailRcptHelper;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.CheckSaleCompleteOp;
import dtv.pos.register.type.LineItemType;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyManager;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.itm.IWarranty;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.IPosTransactionProperty;
import dtv.xst.dao.ttr.impl.AccountCreditTenderLineItemModel;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawCheckSaleCompleteOp extends CheckSaleCompleteOp {
    // Begin BZ27294
    private static final Logger _logger          = LogManager.getLogger(CawCheckSaleCompleteOp.class);
    // End BZ27294
  
    private CawCheetahHelper    _cheetahHelper   = CawCheetahHelper.getInstance(); //BZ48629
    
    Boolean                     isWorkOrderTrans = _transactionScope.getValue(CawValueKeys.IS_WORK_ORDER_TRANS); ////wo352-get

    private CawCustomerGSHelper _gsHelper        = CawCustomerGSHelper.getInstance();
    
    protected static final IXstDataActionKey NO_RECEIPTS      = XstDataActionKey.valueOf("NO_RECEIPTS"); /* BZ35513 */
    
    private static final int            RESPONSE_SUCCESS_CODE = 200;
    
    // Begin BZ48629
    @Inject
    private TransactionScope                  _transaction;

    @Inject
    protected StationState                    stationState;
    // End BZ48629
    
    // BEGIN BZ51770 
    private static final String            CAW_LOYALTY_DATA_FOR_OS = "CAW_LOYALTY_FOR_OS";
    private static final String            STRING = "STRING";
    // END BZ51770 
    
    /* BZ26207 Begin work order session
     * If this transaction contain work order then it should be orange.
     * @see dtv.pos.register.CheckSaleCompleteOp#getSaleTenderOpChainKey()
     */
    /*Begin BZ 37382*/
    private static String SIGNED = "SIGNED";
    
    private static String NOT_SIGNED = "NOT_SIGNED";
    
    @Inject
    private OrderMgr                         _orderMgr;
    
    @Inject
    private WarrantyManager _warrantyMgr; //BZ53752
    /*End BZ 37382*/
    
    @Inject
    private Provider<AccountManager> _amProvider; //BZ53752
    
    //BEGIN BZ53876
    private Map<String, List<JSONObject>> serialNumberActive = _transactionScope.getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);
   
    @Inject
    private CawDiscountCouponHelper       _cawDiscountCouponHelper; 
    
    //END BZ53876
    //BEGIN BZ57844 
    private boolean                          hasRunEnableLoyalty     = false;
    private IXstActionKey                    preKey                  = null;
    //END BZ57844 
    
    
    private CawAGISPitchesHelper    _gsmPitchesHelper   = CawAGISPitchesHelper.getInstance(); //BZ61159

    private IXstActionKey                    key                     = null; //BZ63054
    
    private final static String CAW_PHONE_NUMBER_INFORMATION = "CAW_PHONE_NUMBER_INFORMATION";
    
    private final static String CAW_SUBSCRIBER_ID_INFORMATION = "CAW_SUBSCRIBER_ID_INFORMATION";
    
    private final static String CAW_SUBMIT_ORDER_PHONE_NUMBER_PROPERTY = "CAW_SUBMIT_ORDER_PHONE_NUMBER_PROPERTY";
    

    @Override
    protected OpChainKey getSaleTenderOpChainKey() {

        /*BEGIN BZ29590, BZ29743, BZ29410*/
        if (_gsHelper.isApplyGS() && !_gsHelper.isTokenUsed()
                && BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.IS_PRE_TENDERING_OP))) {
            _transactionScope.setValue(CawValueKeys.IS_PRE_TENDERING_OP, false);
            if (_gsHelper.getCardType() == 1) {
                return OpChainKey.valueOf("CAW_TENDER_GOOD_SAM_VISA_CARD");
            } else if (_gsHelper.getCardType() == 2) {
                return OpChainKey.valueOf("CAW_TENDER_GOOD_SAM_PLCC_CARD");
            }
        }
        /*BEGIN BZ31569*/
        if (isWorkOrderTrans == Boolean.TRUE) {
            return OpChainKey.valueOf("WO_SALE_TENDER");
        }
        /*END BZ31569*/
        /*END BZ29590, BZ29743, BZ29410*/
        return super.getSaleTenderOpChainKey();
    }

    /* BZ26207 Begin work order session
     * Enable email receipt for work order.
     * @see dtv.pos.register.CheckSaleCompleteOp#anyEmailableReceipts()
     */
    @Override
    protected boolean anyEmailableReceipts() {

        if (isWorkOrderTrans == Boolean.TRUE) {
            return isWorkOrderTrans;
        }
        return super.anyEmailableReceipts();
    }
    
    /* BEGIN BZ37382 */
    protected IOpResponse handleInitialStateOderBroker() {

        IOpResponse iOpResponse = super.handleInitialState();
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        String isSigned = _transactionScope.getValue(CawValueKeys.IS_ORDER_TRANSACTION);
        
        if (isSigned != null && SIGNED.equals(isSigned)) {
            // don't need to check capturing signature or not
        } 
        else if (currentOrder != null) {
            for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                if (CANCELLED.matches(orderLine.getStatusCode())) {
                    // don't need to capture signature
                    return iOpResponse;
                }
            }

            if (isSigned == null 
                    || (isSigned != null && NOT_SIGNED.equals(isSigned))) {
                _transactionScope
                        .setValue(CawValueKeys.IS_ORDER_TRANSACTION, NOT_SIGNED);
                return HELPER.getWaitStackChainResponse(OpChainKey
                        .valueOf("CAW_ORDER_BROKER_PROMPT_SIGNATURE_CAPTURE"));
            } 
        }

        return iOpResponse;
    }
    /* END BZ 37382 */
    
    // Begin BZ27294
    @Override
    protected IOpResponse handleInitialState() {

        try {
            IPosTransaction trans = this._transactionScope.getTransaction();
            /* BEGIN BZ47542*/
            List<ISaleReturnLineItem> transLineItems = trans.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
            for (ISaleReturnLineItem item : transLineItems) {
                if (CawRvPaymentHelper.isRvPaymentSaleLineItem(item) && item.getVoid()) {
                    item.deleteProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES);
                }
            }
            /* END BZ47542*/
            BigDecimal totalAmt = trans.getTotal().add(trans.getRoundedAmount());
            BigDecimal tenderAmt = trans.getAmountTendered();

            BigDecimal depositAmt = BigDecimal.ZERO;
            List<IRetailTransactionLineItem> tenderLineItems = trans.getTenderLineItems();
            if (tenderLineItems != null && tenderLineItems.size() > 0) {
                for (IRetailTransactionLineItem iRetailTransactionLineItem : tenderLineItems) {
                    if (iRetailTransactionLineItem instanceof AccountCreditTenderLineItemModel) {
                        depositAmt = ((AccountCreditTenderLineItemModel) iRetailTransactionLineItem).getAmount();

                    }
                }
            }
            IOrder currentOrder = _orderMgr.getCurrentOrder();//BZ46798
            if (currentOrder == null) {//BZ46798
                if (depositAmt.compareTo(BigDecimal.ZERO) >= 0 //BZ48441: Change compareTo from == 0 to >=0 
                        && totalAmt.compareTo(BigDecimal.ZERO) >= 0 
                            && depositAmt.compareTo(totalAmt) >= 0) {//BZ32033: Update condition to run the work order refund work flow
                    if (totalAmt.compareTo(tenderAmt) == 0) {
    
                        /*BEGIN BZ37382 */
                    	return handleInitialStateOderBroker();
                        /* END BZ 37382 */
                    } else {
                        return this.HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_WORK_ORDER_REFUND_TENDER"));
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("handleInitialState error." + ex.getMessage());
        }
       
        return super.handleInitialState();
    }
    
    // End BZ27294

    /* BEGIN BZ29635*/
    /* Override base class
     * @see dtv.pos.register.CheckSaleCompleteOp#handlePromptResponse(dtv.pos.iframework.action.IXstAction)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstAction argAction) {
        //BEGIN BZ57844
        key = argAction.getActionKey(); //BZ63054
        if (key != XstDataActionKey.NO && _gsHelper.isEnableLoyalty()) {
            //BEGIN BZ58836, BZ58840
            IPosTransaction trans = _transactionScope.getTransaction();
            String gsMembershipSKUId = _gsHelper.getGSMembershipSKU(trans);//BZ58779
            if (gsMembershipSKUId != null) { 
            //END BZ58836, BZ58840
                if (!hasRunEnableLoyalty) {
                    hasRunEnableLoyalty = _gsHelper.getRunEnableLoyalty(trans);
                    if (hasRunEnableLoyalty) {
                    	_transactionScope.setValue(CawValueKeys.CAW_DISABLE_TOKEN_IS_USED, true);//BZ58779
                    	preKey = key;
                        IFormattable args[] = new IFormattable[2];
                        args[0] = this._formattables.getTranslatable(CawConstants.CAW_BACK_BUTTON);
                        args[1] = this._formattables.getTranslatable(CawConstants.CAW_OK_BUTTON);
                        return HELPER
                                .getPromptResponse(PromptKey.valueOf(CawConstants.CAW_PLCC_OR_GSVISA_NOT_FOUND), args);
                    }
                }
                if (key == XstDataActionKey.ACCEPT && hasRunEnableLoyalty) {
                    _gsHelper.setVoidGSMembershipSKU(trans, gsMembershipSKUId);
                    return HELPER.getPromptResponse(PromptKey.valueOf(CawConstants.CAW_PLCC_OR_GSVISA_CANCEL));
                }
            }
            if (preKey != null && hasRunEnableLoyalty && !"LOYALTY_OFFLINE".equalsIgnoreCase(key.toString())) {
                key = preKey;
                preKey = null;
            }
        }
        //END BZ57844
        //BEGIN BZ48629
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        String jsonMessageThirdPartyTender = CawCatalystHelper.getLookupResponseDataUseThirdPartyTender(); //BZ53547
        //Start BZ50139
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        if (key != XstDataActionKey.NO
                //&& (_cheetahHelper.isClubMembership(jsonMessage) || _cheetahHelper.isClubMembership(jsonMessageThirdPartyTender)) //BZ53547
                //&& _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null
                //&& _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) //BZ54290
                && !CawWorkOrderOptionsOp.isDepositAction() && !CawWorkOrderOptionsOp.isRefundAction()
                && (currentOrder == null || currentOrder.getOrderLines().isEmpty())) {
                //End BZ50139
            try {
                callEarningsAPI();
            } catch (Exception ex) {
                _logger.error("Can't read file : " + ex.getMessage());
                return HELPER.getPromptResponse(PromptKey.valueOf("CAW_LOYALTY_OFFLINE_MESSAGE"));

            }
        }
        //end BZ48629
        //END BZ62219 
       _gsmPitchesHelper.setTemporaryMembershipCard(_transactionScope); //BZ61159          
        
        if (key == XstDataActionKey.YES || key == PRINT_ONLY) {
            return handleYesResponse();
        } else if (key == XstDataActionKey.NO) {
            /*Check for WO Deposit transaction*/
            if (BooleanUtils.isTrue(isWorkOrderTrans) && CawWorkOrderOptionsOp.isDepositAction()) {
                return HELPER.getBackupResponse();
            } 
            /* Check OMNI_REFUND=YES BEGIN BZ42889 */
            else if(CawOrderHelper.getInstance().isOmniRefundYes(_orderMgr)){
                return HELPER.getBackupResponse();
            }
            else
            {
                return handleNoResponse();
            }
            /* END BZ42889 */
        } else if (key == PRINT_EMAIL) {
            return handlePrintEmailResponse();
        } else if (key == EMAIL_ONLY) {
            return handleEmailOnlyResponse();
        }
        /* BEGIN BZ35513*/
        else if (key == NO_RECEIPTS) {
            return handleNoPrintReceipts();
        }
        /* END BZ35513*/
        else {
            _logger.error("data action key not expected!  " + "possible misconfiguration? " + key);
            return HELPER.errorNotifyResponse();
        }
    }
    /* END BZ29635*/

    /* BEGIN BZ35513*/
    /**
     * handleNoPrintReceipts()
     * @return HELPER.getCompleteStackChainResponse(getSaleCompleteOpChainKey());
     */
    protected IOpResponse handleNoPrintReceipts() {
        ReceiptInfo receiptInfo = getScopedValue(ValueKeys.RECEIPT_INFO);

        if (receiptInfo != null) {
            receiptInfo.setPrintReceipt(true);
            setScopedValue(CawValueKeys.NO_PRINT_RECEIPTS, Boolean.TRUE);
            IRetailTransaction transaction = _transactionScope.getTransaction(RETAIL_SALE);

            if (getSendEmailReceipts()) {
                EmailRcptHelper.setReceiptDeliveryMethods(transaction, EmailRcptDeliveryType.NONE);
            }
        }
        return HELPER.getCompleteStackChainResponse(getSaleCompleteOpChainKey());
    }
    /* END BZ35513*/
    
    /*BEGIN BZ37884*/
    @Override
    protected boolean getPromptToEmailReceipts() {

        IOrder currentOrder = _orderMgr.getCurrentOrder();
        if (currentOrder != null) {
            return true;
        } else {
            return super.getPromptToEmailReceipts();
        }
    }
    /*END BZ37884*/
    /* BEGIN BZ42889 */
    @Override
    public OpChainKey getRefundTenderOpChainKey() {
        
        boolean isOmniRefundYes = CawOrderHelper.getInstance().isOmniRefundYes(_orderMgr);

        if (isOmniRefundYes) {
            return OpChainKey.valueOf("CAW_RETURN_OMNI_REFUND");
        }
        return OpChainKey.valueOf("REFUND_TENDER");
    }
    /* END BZ42889 */
    //BEGIN BZ48629
    private void callEarningsAPI() {
       IPosTransaction trans = this._transactionScope.getTransaction();//BZ51770
       /* BEGIN BZ53752 */
       CawCheetahSubmitRequestModel requestModel = new CawCheetahSubmitRequestModel();
        if (CawWorkOrderOptionsOp.isCompleteAction()) {
            if (_amProvider.get() != null) {
                ICustomerAccountMaintModel workOrderAccount = _amProvider.get().getCurrentCustAccountModel(CustomerAccountType.WORK_ORDER);
                if (workOrderAccount != null && workOrderAccount.getAccount() != null) {
                    String workOrderId = workOrderAccount.getAccount().getCustAccountId();
                    if (workOrderId != null) {
                        workOrderId = workOrderId.replace(CawWorkOrderConstants.WO_PREFIX, CawConstants.CAW_STRING_EMPTY);
                        CawCheetahWorkOrderDetailModel workOrderDetailModel = new CawCheetahWorkOrderDetailModel();
                        workOrderDetailModel.setWorkOrderId(workOrderId.trim());
                        workOrderDetailModel.setPosStatus(CawWorkOrderConstants.WO_COMPLETE_CODE);
                        requestModel.setWorkOrderDetail(workOrderDetailModel);
                    }
                }
            }
        }
        
        ISaleReturnLineItem lineItem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if(lineItem != null && !lineItem.getVoid()) {
            if(this.getScopedValue(CawValueKeys.WONDERSIGN_CART_ID_SUBMIT_ORDER) != null) {
                String cartId = this.getScopedValue(CawValueKeys.WONDERSIGN_CART_ID_SUBMIT_ORDER);
                requestModel.setWondersignCartIdSubmitOrder(cartId);
                this.clearScopedValue(CawValueKeys.WONDERSIGN_CART_ID_SUBMIT_ORDER);
            } else if(this.getScopedValue(CawValueKeys.CAW_RV_PROPERTIES_SUBMIT_ORDER) != null) {
                BigDecimal rvPaymentAmount = new BigDecimal(this.getScopedValue(CawValueKeys.CAW_RV_PROPERTIES_SUBMIT_ORDER));
                requestModel.setRvPropertiesSubmitOrder(rvPaymentAmount);
                this.clearScopedValue(CawValueKeys.CAW_RV_PROPERTIES_SUBMIT_ORDER);
            }
        }
        IParty party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        requestModel.setParty(party);
        /* END BZ53752 */        

        mappingReceiptType(requestModel); //BZ63054

        //BEGIN BZ53876, BZ54290
        List<IWarranty> listWarranty = _warrantyMgr.getWarranties(_transaction.getTransaction(), "WARRANTY");
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope.getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        /* BEGIN BZ59418 */
        String loyaltyFreeTierSKU = _transactionScope.getValue(CawValueKeys.CAW_LOYALTY_FREE_TIER_SKU);
        
        //BEGIN BZ61159
        String pitchesUpdatedJson = CawAGISPitchesHelper.getInstance().updatePitchesFormResponse(_transaction, CawCatalystHelper.getLookupResponseData());
        CawCatalystHelper.setLookupResponseData(pitchesUpdatedJson);
        //END BZ61159
        
        ResponseEntity<String> result = _cheetahHelper.callSubmitOrderAPI(_transaction.getTransaction(), stationState
               , _orderMgr.getCurrentOrder(), requestModel, _warrantyMgr, serialNumberActive, _cawDiscountCouponHelper, listWarranty, workOrderResult, loyaltyFreeTierSKU);/*BZ50112, BZ53752*/
       //END BZ53876, BZ54290, BZ59418
       
       if (result != null && result.getStatusCode() == HttpStatus.OK && _cheetahHelper.getResultCodeFromEBS(result)==RESPONSE_SUCCESS_CODE) {
           //BEGIN BZ51770 
           String cawLoyaltyDataForOS =_cheetahHelper.saveLoyaltyInfoForOS(result.getBody(), trans);
           CawCheetahHelper.getInstance().savePropertyExceedMaxLength(trans, CAW_LOYALTY_DATA_FOR_OS, cawLoyaltyDataForOS, STRING);//BZ55978
           //END BZ51770
           addLoyaltyInformationIntoTransProperty(trans, result.getBody());//BZ52876
           
           addSubscriberIdInformationIntoTransProperty(trans, result.getBody());
           addPhoneNumberInformationIntoTransProperty(trans, result.getBody());
           
        } else {
            //BEGIN BZ51770 
            String cawLoyaltyDataForOS =_cheetahHelper.saveLoyaltyInfoForOS(null, trans);
            cawLoyaltyDataForOS = cawLoyaltyDataForOS.replaceAll("\\s","");
            CawCheetahHelper.getInstance().savePropertyExceedMaxLength(trans, CAW_LOYALTY_DATA_FOR_OS, cawLoyaltyDataForOS, STRING);//BZ55978
            //END BZ51770
        }
       
       //BEGIN BZ61159, BZ62146
       if(_transactionScope.getValue(CawValueKeys.CAW_AGIS_PITCHES_JSON) != null
               && !_transactionScope.getValue(CawValueKeys.CAW_AGIS_PITCHES_JSON).isEmpty()){
           CawAGISPitchesModel cawAGISPitchesModel =  _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
           String pitchesStr = CawAGISPitchesHelper.getInstance().updatePitchesJson(_transactionScope,
                   cawAGISPitchesModel, _transactionScope.getValue(CawValueKeys.CAW_AGIS_PITCHES_JSON)); //BZ69389
           if(pitchesStr != null && !pitchesStr.isEmpty()){
               CawCheetahHelper.getInstance().savePropertyExceedMaxLength(trans, CawValueKeys.CAW_AGIS_PITCHES_JSON.getName(), pitchesStr, STRING);
           }
       }
       //END BZ61159, BZ62146
       
        try {
            //BEGIN BZ48564: ENABLE TO USE MOCKUP
            if (Files.exists(Paths.get("/opt/xstore/mockupResponse/Member_Estimate_Earnings.txt"))) {
                String jsonMess = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/Member_Estimate_Earnings.txt")));
                if (StringUtils.isNotEmpty(jsonMess)) {
                    addLoyaltyInformationIntoTransProperty(trans, jsonMess);//BZ52876
                    addSubscriberIdInformationIntoTransProperty(trans, jsonMess);
                    addPhoneNumberInformationIntoTransProperty(trans, jsonMess);
                }
            }
            //END BZ48564: ENABLE TO USE MOCKUP
            
        }
        catch(Exception ex) {
            _logger.error("[Can't Read the response ]: "+ex.getMessage());
        }
    }
    //END BZ48629
    
    public void addPhoneNumberInformationIntoTransProperty(IPosTransaction argTrans, String argBody) {

        if (argBody != null) {
            try {
                String phoneNumberProperty = CawEBSConstant.PHONE_NUMBER;
                ICodeValue codeValue = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CAW_SUBMIT_ORDER_PHONE_NUMBER_PROPERTY, CAW_SUBMIT_ORDER_PHONE_NUMBER_PROPERTY);
                if (codeValue != null && codeValue.getDescription() != null) {
                    phoneNumberProperty = codeValue.getDescription();
                }
                
                JSONObject objects = new JSONObject(argBody);
                JSONObject result = objects.getJSONObject(CawJSONConstant.JSON_RESULT);
                JSONObject membershipSubmitOrderResponse = result.getJSONObject(CawEBSConstant.MEMBERSHIP_SUBMIT_ORDER_RESPONSE);
                
                if(membershipSubmitOrderResponse != null) {
                    JSONObject attributes = result.getJSONObject(CawEBSConstant.ATTRIBUTES);
                    if(attributes != null) {
                        if (attributes.getString(phoneNumberProperty) != null) {
                            IPosTransactionProperty transactionProperty = DataFactory.createObject(IPosTransactionProperty.class);
                            transactionProperty.setOrganizationId(argTrans.getOrganizationId());
                            transactionProperty.setRetailLocationId(argTrans.getRetailLocationId());
                            transactionProperty.setTransactionSequence(argTrans.getTransactionSequence());
                            transactionProperty.setBusinessDate(argTrans.getBusinessDate());
                            transactionProperty.setWorkstationId(argTrans.getWorkstationId());
                            transactionProperty.setPropertyCode(CAW_PHONE_NUMBER_INFORMATION);
                            transactionProperty.setType(CawConstants.PROP_STRING_TYPE);
                            transactionProperty.setStringValue(attributes.getString(phoneNumberProperty));
                            
                            argTrans.addPosTransactionProperty(transactionProperty);
                        }
                    }
                }
            } catch (JSONException ex) {
                _logger.info("[Cannot get \"attributes\".\"phoneNumber\" from SubmitOrder response ]: ");
            }
        }
        
    }
    
    public void addSubscriberIdInformationIntoTransProperty(IPosTransaction argTrans, String argBody) {

        if (argBody != null) {
            try {
                JSONObject objects = new JSONObject(argBody);
                JSONObject result = objects.getJSONObject(CawJSONConstant.JSON_RESULT);
                JSONObject membershipSubmitOrderResponse = result.getJSONObject(CawEBSConstant.MEMBERSHIP_SUBMIT_ORDER_RESPONSE);
                
                if(membershipSubmitOrderResponse != null) {
                    JSONObject attributes = membershipSubmitOrderResponse.getJSONObject(CawEBSConstant.ATTRIBUTES);
                    if(attributes != null) {
                        if (attributes.getString(CawEBSConstant.SUBSCRIBER_ID) != null) {
                            IPosTransactionProperty transactionProperty = DataFactory.createObject(IPosTransactionProperty.class);
                            transactionProperty.setOrganizationId(argTrans.getOrganizationId());
                            transactionProperty.setRetailLocationId(argTrans.getRetailLocationId());
                            transactionProperty.setTransactionSequence(argTrans.getTransactionSequence());
                            transactionProperty.setBusinessDate(argTrans.getBusinessDate());
                            transactionProperty.setWorkstationId(argTrans.getWorkstationId());
                            transactionProperty.setPropertyCode(CAW_SUBSCRIBER_ID_INFORMATION);
                            transactionProperty.setType(CawConstants.PROP_STRING_TYPE);
                            transactionProperty.setStringValue(attributes.getString(CawEBSConstant.SUBSCRIBER_ID));
                            argTrans.addPosTransactionProperty(transactionProperty);
                        }
                    }
                }
            } catch (JSONException ex) {
                _logger.info("[Cannot get \"attributes\".\"subscriberId\" from SubmitOrder response ]: ");
            }
        }
    }

    /* BEGIN BZ52876 */
    private void addLoyaltyInformationIntoTransProperty(IPosTransaction trans, String customerLoyatyInfo) {
        if (customerLoyatyInfo != null && customerLoyatyInfo.length() > 0) {
            IPosTransactionProperty transactionProperty = DataFactory.createObject(IPosTransactionProperty.class);
            transactionProperty.setOrganizationId(trans.getOrganizationId());
            transactionProperty.setRetailLocationId(trans.getRetailLocationId());
            transactionProperty.setTransactionSequence(trans.getTransactionSequence());
            transactionProperty.setBusinessDate(trans.getBusinessDate());
            transactionProperty.setWorkstationId(trans.getWorkstationId());
            transactionProperty.setPropertyCode(CawConstants.CAW_LOYALTY_POINTS_INFORMATION);
            transactionProperty.setType(CawConstants.PROP_STRING_TYPE);
            transactionProperty.setStringValue(customerLoyatyInfo);
            trans.addPosTransactionProperty(transactionProperty);
        } else {
            _logger.debug("Can not get customer loyalty information from API response.");
        }
    }
    /* END BZ52876 */


    /*BEGIN BZ63054*/
    private void mappingReceiptType(CawCheetahSubmitRequestModel requestModel) {
       
        CawReceiptTypeMappingEnum receipt = null;
        if (key == PRINT_ONLY) {
            receipt = CawReceiptTypeMappingEnum.PRINT_ONLY;
        } else if(key == NO_RECEIPTS) {
            receipt = CawReceiptTypeMappingEnum.NO_RECEIPTS;
        } else {
            receipt = CawReceiptTypeMappingEnum.NOT_SPECIFIED;
        }        
        requestModel.setReceiptType(receipt.getKey());
        requestModel.setReceiptTypeDescription(receipt.getValue());
    }
    /*END BZ63054*/
}
