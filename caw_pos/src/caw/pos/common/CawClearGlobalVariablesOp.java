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
 * BZ24264          091117    Membership info of previous transaction is 
 *                            kept unexpected when doing a new transaction with new customer
 * BZ25113          120118    Pinpad is not clear after the transaction completed or canceled
 * BZ25173          190118    Pinpad is clear items list unexpectedly when removing customer from transaction
 * BZ25916          120418    New customer is attached account# of previous customer info unexpectedly at Dashboard also prompting request with catalyst 1 or 4
 * BZ26012          200418    'GS VISA Apply Now' button is disable once getting approval from Eigent when doing Instant Credit Card
 * BZ25115          020518    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ25434          220518    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ26563          120618    [Internal] A new transaction is auto attached the customer of previous transaction unexpectedly although skip customer at pre-sale.
 * BZ25435          160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 * BZ26289          120718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27163          160818    [1.6.7] WO Email receipt shows the incorrect header for Work Order Deposit or Refund
 * BZ27629          210918    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27813          181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28562          071218    PINPAD doesn't reload items once complete transaction by partial Credit card
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28740          211218    [PLCC] Can't do trans with New GSVisa Card
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ29383          190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc.
 * BZ28033          200219    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ29407          260219    [Internal] Xstore continues to prompt prescreen after application has been successfully completed.
 * BZ32123          240719    [Prod] Gift Card Reload Activated Wrong Card Number
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37382          070920    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ37661          070920    [Requirement] Add new prompt "Please ask the customer to sign the receipt"
 * BZ37901          150920    [Internal] Xstore should be displayed exactly message retrieved from Neuron API for restricted shipping items instead of incorrectly offline status
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ37396          051020    Tax value calculation issue in Order transactions
 * BZ40798          240221    Modification to member savings calculation
 * BZ47123          050122    [PROD] Order Service Token Error
 * BZ49801          040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ50442          130622    Redemption data missing in request
 * BZ53547          161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 * BZ53977          021222    [UAT] Xstore is discounting Loyalty offer more than maximum offer amount
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ63225          230424    Issue with refunds from Work Order Completes
 * BZ62169          040324    [Internal] - the Pitches form is NOT displayed when changing a NOT GS customer to GS customer 
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69644          170225    [Internal][AGIS Modification] The 'Item Not On File' prompt is NOt displayed when entering Membership items do not exist in Xstore
 *===================================================================
 */

package caw.pos.common;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.register.CawUPCHelper;
import caw.pos.shippingfee.CawGetListsShippingFee;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.CawPinpadItemModelHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 * Clear global variables when sale completes
 */
public class CawClearGlobalVariablesOp extends Operation {
    
    private CawCustomerGSHelper     _gsHelper           = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr _cawEigenMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        CawCatalystHelper.setLookupResponseData(null); // BZ 24264
        CawCatalystHelper.setCatalystDirectiveResponse(null);
        CawCatalystHelper.setCatalystMessageResponse(null);
        CawCatalystHelper.setCatalystInputsResponse(null);
        CawCatalystHelper.setLookupLoyaltyResponseData(null); //BZ49801
        CawWorkOrderOptionsOp.resetWorkOrderAction(); //BZ27163

        // Only close Eigen session when transaction completes
        if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) != null) { // BZ 25173
            _cawEigenMgr.closeSession(); // BZ 25113
        }

        _transactionScope.clearValue(CawValueKeys.EDIT_ACCOUNT_NUMBER);//BZ25916
        _transactionScope.clearValue(CawValueKeys.IS_APPLY_CLUB_PRICE); //BZ25115

        //Begin BZ26012
        _transactionScope.clearValue(CawValueKeys.ACCOUNT_NUMBER);
        _transactionScope.clearValue(CawValueKeys.EXP_DATE);
        _transactionScope.clearValue(CawValueKeys.API_LOOKUP_RESPONSE); //BZ25434
        _transactionScope.clearValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP); //BZ25434
        //End BZ26012

        // Begin BZ26563
        clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        _transactionScope.clearValue(ValueKeys.SELECTED_CUSTOMER);
        CawCustomerHelper.getInstance().resetSelectedCustomer();
        // End BZ26563

        // Begin BZ25435
        _transactionScope.clearValue(CawValueKeys.SUBMIT_REQUEST_ID);
        _transactionScope.clearValue(CawValueKeys.STATUS_PRESCREEN_ID);
        // End BZ25435

        // BZ26207 Begin work order session
        _transactionScope.clearValue(CawValueKeys.CAW_WORK_ORDER_NUMBER);//wo448283-clear
        _transactionScope.clearValue(CawValueKeys.IS_WORK_ORDER_TRANS);//wo352-clear
        // BZ26207 End work order session

        // BZ26289 Begin AR session
        _transactionScope.clearValue(CawValueKeys.HAS_WHLS_HOUSE_ACCOUNT);
        _transactionScope.clearValue(CawValueKeys.HOUSE_ACCOUNT_NUMBER);
        _transactionScope.clearValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_THIRD_PARTY);
        // BZ26289 End AR session
        _transactionScope.clearValue(CawValueKeys.CAW_CUSTOMER_AVATAR_ICON_KEY);// BZ27339
        CawVoucherValue.setVOUCHER_CARD_NUMBER("");//BZ25958

        _transactionScope
                .clearValue(CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO); //BZ26978
        CawVoucherValue.setIsTenderExchange(false);//BZ27629

        _transactionScope.clearValue(CawValueKeys.TP_ACCOUNT_BALANCE);// BZ27813
        _transactionScope.clearValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);//BZ27924
        CawUPCHelper.getInstance().clearCache();//BZ27344-BZ26270
        CawPinpadItemModelHelper.getInstance()
                .clearAllElementToListNeedToSendMiraServ();//BZ27344
        
        CawPinpadItemModelHelper.handleRefreshPinPadScreen(false); //BZ28562, BZ29383
        
        _transactionScope.clearValue(CawValueKeys.CAW_SUBMIT_STATUS_RESPONSE); //BZ28247
        
        _gsHelper.clearGSInfo(); /*BZ28740: clear GS info after remove customer or complete transaction*/
        /* BEGIN BZ29387 */
        Boolean valid = _transactionScope.getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);
        if (valid != null && valid.booleanValue()) {
            _gsHelper.revertAttributes();
        }
        _transactionScope.clearValue(CawValueKeys.IS_ACCOUNT_PAYMENT);
        /* END BZ29387 */
        _transactionScope.clearValue(CawValueKeys.IS_RESENT_CATALYST_4);// BZ28033
        _transactionScope.clearValue(CawValueKeys.IS_COMPLETED_MADE_OFFER);// BZ29407
        CawVoucherValue.setGiftCardToken(CawConstants.CAW_STRING_EMPTY); //BZ32123 Clear token is cached
        
        /* BEGIN BZ37023, BZ37901 */
        CawGetListsShippingFee.setShipperMethodAPIModels(null);
        CawGetListsShippingFee.setShipperMethodEnterFeeeModels(null);
        CawGetListsShippingFee.setIsEBSOffile(false);
        CawGetListsShippingFee.setShippingHasError(false);// BZ37901
        /* END BZ37023, BZ37901 */
        
        _transactionScope.clearValue(CawValueKeys.CAW_TAX_RESPONSE); // BZ37396

        _cawEigenMgr.setSigCap(null); // BZ 37382
        _cawEigenMgr.setResponseApproved(null); // BZ37661
        /* BEGIN BZ37912 */
        CawGetListsShippingFee.setShippingGroupsModels(null);
        _transactionScope.clearValue(CawValueKeys.CAW_SHIPPER_METHODS);
        _transactionScope.clearValue(CawValueKeys.CAW_GROUP_ID);
        _transactionScope.clearValue(CawValueKeys.TEMP_SHIPPING_FEE);
        CawGetListsShippingFee.setTotalOrderShippingFee(null);
        /* END BZ37912 */
        
        /* BEGIN BZ40798 */
        _transactionScope.clearValue(CawValueKeys.GOOD_SAM_SAVINGS);
        _transactionScope.clearValue(CawValueKeys.COULD_SAVE);
        /* END BZ40798 */
        /*BEGIN BZ47123*/
        _transactionScope.clearValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG);
        clearScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP);
        /*END BZ47123*/
        //Start BZ50442
        CawCatalystHelper.setOfferApplyLoyalty(null); 
        CawCatalystHelper.setRewardApplyLoyalty(null);
        //End BZ50442
        //BEGIN BZ53547
        CawCatalystHelper.setLookupResponseDataUseThirdPartyTender(null);
        CawCatalystHelper.setLookupResponseLoyaltyDataUseThirdPartyTender(null);
        CawCatalystHelper.setSelectedCustomerUseThirdPartyTender(null);
        //END BZ53547
        _transactionScope.clearValue(CawValueKeys.CAW_PROMOTIONS_SELECTED);   //BZ53977
        _transactionScope.clearValue(CawValueKeys.IS_LOYALTY_CUSTOMER); //BZ54290
        _transactionScope.clearValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING); //BZ63225
        
        //BEGIN BZ62169
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH);
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PRICING_ID);
        _transactionScope.clearValue(CawValueKeys.CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER);
        _transactionScope.clearValue(CawValueKeys.CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER);//BZ62146
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED); //BZ69389
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PICHES_COUNT);
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PITCHES_JSON);//BZ62146
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_LIST_NOT_ON_FILE); //BZ69644
        //END BZ62169
        return HELPER.completeResponse();
    }

}
