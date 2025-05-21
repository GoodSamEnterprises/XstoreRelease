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
 * BZ29291          130319    [Internal] Able to bypass manage override for cashier during a sale for a crew member.
 * BZ31982          230719    [INTERNAL] Could not tender by AR Account when consuming trans in Xstore
 * BZ33582          291019    [INTERNAL] Xstore displayed HDE while testing the realease 5.0 Patch 7.0
 * BZ36405          030620    Issue with Credit Customer placed on credit hold
 * BZ45160          100821    [Internal] Can complete the transaction paid other tender types not credit card even though the transaction receives directive: 10 for credit card required
 * BZ45921          250821    Phase 1 Electric World - Help Desk Error when you attempt to resume a suspended Kiosk Order transaction mixed with Sale
 * BZ48795          090522    [Internal] - The customer's loyalty coupon info displayed incorrectly during creating the "Resume Transaction"
 * BZ62036          040324    [Task] - Suspend and Resume transaction.
 * BZ62987          040424    [Internal] The Banner customer and LOGO are displayed incorrectly when assigning a customer has GS Expired *===================================================================
 */

package caw.pos.register.suspendresume;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import caw.pos.advance.prompting.CawAGISSavePricingMembershipGSOp;
import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerConstants;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.customer.membership.*;
import caw.pos.item.CawItemHelper;
import caw.pos.item.CawItemMessage;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.tax.ITaxHelper;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.suspendresume.PromptSuspendedTransOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.tax.ITaxExemption;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawPromptSuspendedTransOp extends PromptSuspendedTransOp {

    private static final Logger logger_ = Logger.getLogger(CawAGISSavePricingMembershipGSOp.class);

    /* BEGIN BZ31982 */
    @Inject
    private ITaxHelper                           _taxHelper;
    /* END BZ31982 */
    
    @Inject
    private IBusyState _busyState;//BZ48795
    
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        super.handlePromptResponse(argEvent);
        IPosTransaction suspended = getScopedValue(ValueKeys.SELECTED_SUSPENDED_TRANSACTION);

        if (suspended instanceof RetailTransactionModel) {

            IParty party = ((RetailTransactionModel) suspended).getCustomerParty();

            if (party != null && _transactionScope != null) {
                /* BEGIN BZ31982 */
                _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, party);
                String arAccNumber = CawCustomerUtil.getAccountNumber(party);

                /* BEGIN BZ33582 */
                if (StringUtils.isNotEmpty(arAccNumber)) {
                    _transactionScope.setValue(CawCustomerConstants.ACCOUNT_NUMBER, arAccNumber);
                }
                /* END BZ33582 */

                // BEGIN BZ48795
                // Build String JSON of customer information from DB. Limit to call EBS many times.
                String jsonMessage = CawCatalystHelper.getLookupResponseData();
                List<CawCustomerMembershipView> outCustomerMembershipViews = CawMembershipHelper.getInstance().getReloadMemberships(jsonMessage);
                CawCustomerMembershipModel model = new CawCustomerMembershipModel();
                
                if (StringUtils.isEmpty(jsonMessage)) {
                    _busyState.start(CawConstants.BUSY_STATE_MSG);
                    jsonMessage = CawEBSHelper.getInstance()
                            .lookupCustomerInEBS(arAccNumber, CawPropertyUtils.STORE_NUMBER);/*BZ27535*/
                    //BEGIN BZ62987
                    storeMembershipFromMiddleLayer(jsonMessage);
                    storePricingFromMiddleLayer(jsonMessage);
                    //END BZ62987
                    // BEGIN BZ62036
                    IRetailTransaction retailTrans = (IRetailTransaction) suspended;
                    String pricingInfomation = retailTrans.getStringProperty(CawConstants.CAW_PRICING_INFO);
                    String membership = retailTrans.getStringProperty(CawConstants.CAW_MEMBERSHIP_INFO);
                    if(pricingInfomation != null) {
                        JSONObject responseObject;
                        try {
                            responseObject = new JSONObject(jsonMessage);
                            if(responseObject.has(CawEBSConstant.PRICING_ATTR) && pricingInfomation != null) {
                                responseObject.put(CawEBSConstant.PRICING_ATTR, new JSONObject(pricingInfomation));
                            }
                            if(responseObject.has(CawJSONConstant.JSON_MEMBERSHIPS) && membership != null) {
                                responseObject.put(CawJSONConstant.JSON_MEMBERSHIPS, new JSONArray(membership));
                            }
                            jsonMessage = responseObject.toString();
                        } catch (JSONException ex) {
                            logger_.error("updatePricingInformation: There is no membership from database response."
                                    + ex.getMessage());
                        }   
                    }
                    // END BZ62036
                    _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, jsonMessage);
                    CawCatalystHelper.setLookupResponseData(jsonMessage);
                    _busyState.end();
                    
                    if (!StringUtils.isEmpty(jsonMessage)) {
                        outCustomerMembershipViews = CawMembershipHelper
                                .getInstance()
                                .getReloadMemberships(jsonMessage);
                    }
                    
                    if(StringUtils.isEmpty(jsonMessage)) {
                        List<ITaxExemption> taxExemptions = _taxHelper.getTaxExemptions(party);
                        jsonMessage = CawCustomerHelper.buildCustomerInforFromDB(jsonMessage, party, taxExemptions);
                        
                        if (StringUtils.isNotEmpty(jsonMessage)) {
                            boolean isTenderArAccount = false;
                            BigDecimal arAccountBalance = CawCustomerHelper.getInstance()
                                    .getAvailableBalanceAmt(jsonMessage);/*BZ36405*/

                            if (BigDecimal.ZERO.compareTo(arAccountBalance) != 0) {
                                isTenderArAccount = true;
                            }
                            _transactionScope
                                    .setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, Boolean.valueOf(isTenderArAccount));
                            _transactionScope.setValue(CawValueKeys.AR_ACCOUNT_BALANCE, arAccountBalance);
                            _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, jsonMessage);
                            CawCatalystHelper.setLookupResponseData(jsonMessage);
                        }
                    }
                    
                    String awartarIcon = _transactionScope
                            .getValue(CawValueKeys.CAW_CUSTOMER_AVATAR_ICON_KEY);
                    if (!StringUtils.isEmpty(awartarIcon)) {
                        model.setAvatarIcon(awartarIcon);
                    }

                    model.setCustomerMembershipList(outCustomerMembershipViews);
                    model.initFieldValues();
                }
                // END BZ48795
                /* END BZ31982 */
            }

            /* BEGIN BZ45160 */
            List<IRetailTransactionLineItem> lineItems = suspended.getRetailTransactionLineItems();
            if (lineItems != null && lineItems.size() > 0) {
                for (IRetailTransactionLineItem lineItem : lineItems) {
                    if (lineItem instanceof ISaleReturnLineItem) {
                        ISaleReturnLineItem saleReturnLineItem = (ISaleReturnLineItem) lineItem;
                        /*BEGIN BZ45921*/
                        if(saleReturnLineItem.getItem() != null) {
                            getItemMgs(saleReturnLineItem);
                        }
                       /*END BZ45921*/
                    }
                }
            }
            /* END BZ45160 */
        }
        return HELPER.completeResponse();
    }

    /* BEGIN BZ45160 */
    private void getItemMgs(ISaleReturnLineItem argLineItem) {
        ItemMessageCrossReferencePropertyId crossReferencePropertyId = new ItemMessageCrossReferencePropertyId();
        IItemMessageCrossReferenceProperty crossReferenceProperty = null;

        @SuppressWarnings("unchecked")
        Map<String, List<CawItemMessage>> mapListCawItemMess = _transactionScope.getValue(CawValueKeys.CAW_MAP_ITM_MSG);
        if (mapListCawItemMess == null) {
            mapListCawItemMess = new HashMap<>();
        }
        List<CawItemMessage> listCawItemMessages = new ArrayList<>();

        List<IItemMessage> listItemMessage = CawItemHelper.getInstance().getItmMsgByQuery(argLineItem);
        String messageId = StringUtils.EMPTY;
        String strMessage = StringUtils.EMPTY;
        if (CollectionUtils.isNotEmpty(listItemMessage)) {

            String itemId = argLineItem.getItemId();
            for (IItemMessage itemMessage : listItemMessage) {
                messageId = itemMessage.getMessageId();
                crossReferencePropertyId.setItemId(itemId);
                crossReferencePropertyId.setMessageId(messageId);
                crossReferencePropertyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                crossReferencePropertyId.setPropertyCode(CawConstants.CAW_ITM_MSG_REF);
                try {
                    crossReferenceProperty = DataFactory.getObjectById(crossReferencePropertyId);
                    String strcrossRePValue = crossReferenceProperty.getStringValue();

                    if (CawConstants.CAW_ITM_MSG_FOR_BOTH.equalsIgnoreCase(strcrossRePValue)
                            || CawConstants.CAW_ITM_MSG_FOR_RECEIPT.equalsIgnoreCase(strcrossRePValue)) {

                        strMessage = CawItemHelper.getInstance().getMessageInfor(itemMessage, crossReferenceProperty);
                        CawItemMessage cawItemMessage = new CawItemMessage(messageId, strcrossRePValue, strMessage);
                        listCawItemMessages.add(cawItemMessage);

                    }
                } catch (Exception e) {
                    logger_.warn("Do not have item Specific Message of item in  itm_item_msg_cross_reference_p");
                }
            }

            if (CollectionUtils.isNotEmpty(listCawItemMessages)) {
                mapListCawItemMess.put(itemId + CawConstants.CAW_COLON_SIGN  + argLineItem.getLineItemSequence(), listCawItemMessages);
                _transactionScope.setValue(CawValueKeys.CAW_MAP_ITM_MSG, mapListCawItemMess);
            }
        }
    }
    /* END BZ45160 */
    //BEGIN BZ62987
    private void storeMembershipFromMiddleLayer(String argJsonMessage) {
        try {
            if(argJsonMessage != null && !argJsonMessage.isEmpty()) {
                JSONObject custLookupRespJson = new JSONObject(argJsonMessage.toString());
                if(custLookupRespJson.has(CawJSONConstant.JSON_MEMBERSHIPS) && !custLookupRespJson.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    JSONArray membershipJson = custLookupRespJson.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                    _transactionScope.setValue(CawValueKeys.CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER, membershipJson.toString());//BZ61159
                }
            }
        } catch (Exception ex) {
            logger_.debug("[Error at storeMembershipFromMiddleLayer - suspend]: " + ex.getMessage());
        }
    }
    private void storePricingFromMiddleLayer(String argJsonMessage) {
        try {
            if(argJsonMessage != null && !argJsonMessage.isEmpty()) {
                JSONObject custLookupRespJson = new JSONObject(argJsonMessage.toString());
                if(custLookupRespJson.has(CawJSONConstant.JSON_AVAILABLE_PRICING) && !custLookupRespJson.isNull(CawJSONConstant.JSON_AVAILABLE_PRICING)) {
                    JSONObject pricingJson = custLookupRespJson.getJSONObject(CawJSONConstant.JSON_AVAILABLE_PRICING);
                    _transactionScope.setValue(CawValueKeys.CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER, pricingJson.toString());//BZ61159
                }
            }
        } catch (Exception ex) {
            logger_.debug("[Error at storePricingFromMiddleLayer]: " + ex.getMessage());
        }
    }
    //END BZ62987
}
