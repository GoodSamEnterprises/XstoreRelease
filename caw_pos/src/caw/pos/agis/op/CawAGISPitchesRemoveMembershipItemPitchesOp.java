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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62146          030324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ62216          030324    [Internal] Information on the Customer Tab is not remove when doing remove item membership
 *===================================================================
 */

package caw.pos.agis.op;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.*;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import twitter4j.*;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.impl.NonPhysicalItemModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawAGISPitchesRemoveMembershipItemPitchesOp extends Operation{
    @Inject
    private CawMembershipActivityHelper _cawMembershipActivityHelper;
    private CawAGISPitchesHelper _agisPitchesHelper = CawAGISPitchesHelper.getInstance();//BZ62216
    private static final Logger _logger     = LogManager.getLogger(CawAGISPitchesRemoveMembershipItemPitchesOp.class);
    @Override
    public boolean isOperationApplicable() {    
        //BEGIN BZ62148
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        int length = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null ? Integer.valueOf(_transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH)) : 0;
        if(cawPitchesModel != null && length > 0 ) {
            return Boolean.TRUE;
        }         
        //END BZ62148
        return Boolean.FALSE;
    }
    
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
       //BEGIN BZ62148, BZ62216
        ArrayList<String> remainTypeMembershipList = new ArrayList<>();
        ArrayList<IItem> remainTypeMembershipItemList = new ArrayList<>();
        String customerInfo = CawCatalystHelper.getLookupResponseData();;
        String membershipType = null;
        IPosTransaction trans = _transactionScope.getTransaction();
        List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
        for (ISaleReturnLineItem iSaleReturnLineItem : lineItems) {
            if(!iSaleReturnLineItem.getVoid()) {
                CawMembershipActivityModel activityModel = null;
                IItem item = iSaleReturnLineItem.getItem();
                if (item != null && item instanceof NonPhysicalItemModel && item.getMerchLevel4Id() != null) {
                    String itemSubtype = item.getMerchLevel4Id();
                    activityModel = _cawMembershipActivityHelper.getGroupItemByGroupName(itemSubtype);
                    if(activityModel != null) {
                        membershipType = activityModel.getMembershipType().toString();
                        if(!remainTypeMembershipList.contains(membershipType)) {
                            remainTypeMembershipList.add(membershipType);
                            remainTypeMembershipItemList.add(item);
                        }
                    }
                }
            }
        }
        if(remainTypeMembershipList != null) {
            customerInfo = removePitchesMembershipItemVoided(customerInfo, remainTypeMembershipList, remainTypeMembershipItemList);
        }
        if(customerInfo != null && customerInfo.length() > 0) {
            CawCatalystHelper.setLookupResponseData(customerInfo.toString());
            _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerInfo.toString());
            setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, customerInfo.toString());
            updateCustomerLoyaltyFlag();
        }
        //END BZ62148
        return HELPER.completeResponse();
    }
    
    private JSONObject updateCustomerPricing(String cusomterInfo, JSONArray argNewMembershipList, 
            ArrayList<IItem> argRemainTypeMembershipItemList) {
        JSONObject pricingUpdate = null;
        try {
            CawMembershipActivityModel activityModel = null;
            CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
            int cawAGISPitchesLength = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null ? _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) : 0;
            
            if(argRemainTypeMembershipItemList.size() > 0) {
                for (IItem item : argRemainTypeMembershipItemList) {
                    if (item != null && item instanceof NonPhysicalItemModel && item.getMerchLevel4Id() != null) {
                        Boolean autoRenew = _agisPitchesHelper.getAutoRenewByItemId(cawPitchesModel, cawAGISPitchesLength, item.getItemId());
                        String itemSubtype = item.getMerchLevel4Id();
                        activityModel = _cawMembershipActivityHelper.getGroupItemByGroupName(itemSubtype);
                        if(!activityModel.getCustomerGroup().equalsIgnoreCase(CawConstants.CLUB_CODE)) {
                            continue;
                        }
                        activityModel.setAutoRenew(autoRenew.booleanValue());
                    }
                    pricingUpdate = CawAdvancePromptingHelper.getInstance()
                            .updatePricingAttrPitches(cusomterInfo, item.getItemId(), activityModel, _transactionScope);
                } 
            } 
            if (pricingUpdate == null) {
                pricingUpdate = new JSONObject(_transactionScope.getValue(CawValueKeys.CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER));
            }
        } catch (Exception ex) {
            _logger.debug("[Error at updateCustomerPricing]: " + ex.getMessage());
        }
        return pricingUpdate;
    }

    private String removePitchesMembershipItemVoided(String cusomterInfo,
            ArrayList<String> argRemainTypeMembershipList, ArrayList<IItem> argRemainTypeMembershipItemList) {
        
        JSONObject pricingUpdate = null;
        String cusomterInfoResult = cusomterInfo;
        try {
            if (StringUtils.isNotEmpty(cusomterInfoResult)) {
                JSONObject membership = null;
                JSONArray membershipList = new JSONArray(); //BZ25434
                JSONArray newMembershipList = new JSONArray();
                JSONObject customerObj = new JSONObject(cusomterInfoResult);
                if (!customerObj.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    membershipList = customerObj.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS); //BZ25434
                }
                if (membershipList != null && membershipList.length() > 0) {
                    for (int i = 0; i < membershipList.length(); i++) {
                        membership = membershipList.getJSONObject(i);
                        if(membership.has(CawJSONConstant.JSON_TYPE) && !membership.isNull(CawJSONConstant.JSON_TYPE)
                                && argRemainTypeMembershipList.contains(membership.getString(CawJSONConstant.JSON_TYPE))) {
                            newMembershipList.put(membership);
                        }
                    }
                }
                newMembershipList = checkOrigMembership(newMembershipList);
                pricingUpdate = updateCustomerPricing(cusomterInfoResult, newMembershipList, argRemainTypeMembershipItemList);
                if(pricingUpdate != null) {
                    customerObj.put(CawEBSConstant.PRICING_ATTR, pricingUpdate);
                }
                
                customerObj.put(CawJSONConstant.JSON_MEMBERSHIPS, newMembershipList);
                cusomterInfoResult = customerObj.toString();
            } 
        } catch (Exception ex) {
            _logger.warn(ex.getMessage());
        }
        return cusomterInfoResult;
    }

    private JSONArray checkOrigMembership(JSONArray argNewMembershipList) {

        String membershipFromML = _transactionScope.getValue(CawValueKeys.CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER) != null 
                ? _transactionScope.getValue(CawValueKeys.CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER) : StringUtils.EMPTY;
        try {
            if(!membershipFromML.isEmpty()) {
                JSONArray membershipFromMLJsonArrayList = new JSONArray(membershipFromML);
                if(membershipFromMLJsonArrayList != null && membershipFromMLJsonArrayList.length() > 0) {
                    for (int i = 0; i < membershipFromMLJsonArrayList.length(); i++) {
                        if(!checkMembershipExist(membershipFromMLJsonArrayList.getJSONObject(i), argNewMembershipList)) {
                            argNewMembershipList.put(membershipFromMLJsonArrayList.getJSONObject(i));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.warn("Error checkOrigMembership: " + ex.getMessage());
        }
        return argNewMembershipList;
    }
  
    public boolean checkMembershipExist(JSONObject argJsonObject, JSONArray arrayList) {

        if (arrayList != null && arrayList.length() > 0) {
            JSONObject tempJSONObject = null;
            for (int i = 0; i < arrayList.length(); i++) {
                try {
                    tempJSONObject = (JSONObject) arrayList.get(i);
                    if (tempJSONObject.has(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                            && !tempJSONObject.isNull(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                            && argJsonObject.has(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                            && !argJsonObject.isNull(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                            && argJsonObject.getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                                    .equalsIgnoreCase(tempJSONObject.getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR))) {
                        return true;
                    }
                } catch (JSONException ex) {
                    _logger.warn("Error at checkMembershipExist: " + ex.getMessage());
                }
            }
        }
        return false;
    }
    
    private void updateCustomerLoyaltyFlag() {
        if(_transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) ==  null
                || !_transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER).booleanValue()){
            String memberId = CawCheetahHelper.getInstance().getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            if(memberId != null && !memberId.isEmpty()) {
                _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
            }
        }
    }
}
