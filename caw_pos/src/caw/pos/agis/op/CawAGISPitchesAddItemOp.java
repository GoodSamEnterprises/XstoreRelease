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
 * BZ62147          020324    [Internal] - Xstore flashes many times when adding membership items on the Pitches form to transaction.
 * BZ62142          020324    [Internal]- The price of membership item shows incorrectly on the Pitches form and Sale screen.
 * BZ62169          040324    [Internal] - the Pitches form is NOT displayed when changing a NOT GS customer to GS customer
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ62924          020424    [Internal] The verbiage on the Banner Save Story is not updated when doing a Suspended transaction
 * BZ69391          060225    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          060225    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          060225    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 * BZ69535          100225    [AGIS Modification] - HDE occurs when selecting "Loyalty Basic Tier - $0.0" in Good Sam Club
 * BZ69592          120225    [Internal][AGIS Modification] The The Exp, Banner customer, logo are displayed incorrectly
 * BZ69644          170225    [Internal][AGIS Modification] The 'Item Not On File' prompt is NOt displayed when entering Membership items do not exist in Xstore
 *===================================================================
 */

package caw.pos.agis.op;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.*;
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.impl.NonPhysicalItemModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trn.IPosTransaction;

public class CawAGISPitchesAddItemOp extends Operation{
    
    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper.getInstance();
    @Inject
    private CawMembershipActivityHelper _cawMembershipActivityHelper;
    
    private static final Logger _logger = LogManager.getLogger(CawAGISPitchesAddItemOp.class);
    
    private final String CAW_AGIS_REFRESH_CUSTOMER = "CAW_AGIS_REFRESH_CUSTOMER"; // BZ62924
    
    private static final PromptKey SCANNED_ITEMS_NOT_FOUND = PromptKey.valueOf("SCANNED_ITEMS_NOT_FOUND");
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {        
        final String CAW_AGIS_MEMBERSHIP_ITEM_VALIDATION = "CAW_AGIS_MEMBERSHIP_ITEM_VALIDATION";
        final String CAW_AGIS_REFRESH_ITEM_PRICE = "CAW_AGIS_REFRESH_ITEM_PRICE";
        
        //BEGIN BZ62147, BZ69391,BZ69389,BZ69389
        List<CawAGISPitchesItemModel> itemModels = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        
        List<CawAGISPitchesItemModel> itemIds = new ArrayList<>();
        List<CawAGISPitchesItemModel> itemNOFModels = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_NOT_ON_FILE);
        
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        int cawAGISPitchesLength = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null ? _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) : 0;
        IPosTransaction suspended = getScopedValue(ValueKeys.SELECTED_SUSPENDED_TRANSACTION);
        if(cawPitchesModel != null && cawAGISPitchesLength > 0 && itemModels != null && !itemModels.isEmpty()) {
            for (CawAGISPitchesItemModel itemModel : itemModels) {
                if(itemModel.getItemCode().equals(CawConstants.CAW_MEMBERSHIP_OPTION_CODE)||
                        itemModel.getItemCode().equals(CawConstants.CAW_NOTHANKS_OPTION_CODE) ) {
                    continue;
                }
                
                IItem item = ItemLocator.getLocator().lookupItem(itemModel.getItemCode());
                IPosTransaction trans = _transactionScope.getTransaction();
                List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
                String description = itemModel.getDescriptions();
                boolean isItemIdExisted = lineItems.stream().filter(t -> !t.getVoid() && t.getItemId().equals(itemModel.getItemCode()) && t.getItemDescription().equals(description)).findFirst().isPresent();
                
                if (item != null && !isItemIdExisted) {
                    ISaleReturnLineItem newLineItem = ItemLocator.getLocator().getSaleLineItem(item, SaleItemType.SALE, "");
                    //BEGIN  BZ62142
                    BigDecimal itemPrice = BigDecimal.valueOf(itemModel.getPlanPrice());
                    
                    Boolean autoRenew = itemModel.isAutoRenew();
                    
                    setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, itemPrice);
                    item.setDescription(description);
                    //END  BZ62142
                    setScopedValue(ValueKeys.CURRENT_ITEM, item);
                    setScopedValue(ValueKeys.CURRENT_SALE_LINE, newLineItem);
                    
//                    itemModels.remove(itemModel);
//                    _transactionScope.setValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED, itemModels);
//                    
                    updateCustMembershipInfo(item, autoRenew);//BZ62146
                    
                    return HELPER.getWaitStackChainResponse(OpChainKey.valueOf(CAW_AGIS_MEMBERSHIP_ITEM_VALIDATION));
                }
                // BEGIN BZ62924, BZ69592
                if (item != null && suspended instanceof RetailTransactionModel) {
                    setScopedValue(ValueKeys.CURRENT_ITEM, item);
                    return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf(CAW_AGIS_REFRESH_CUSTOMER));
                }
                // END BZ62924, BZ69391,BZ69389,BZ69389, BZ69592
                
                if (item == null) {
                    itemIds.add(itemModel);
                    continue;
                }
            }
        }
        _transactionScope.setValue(CawValueKeys.CAW_AGIS_LIST_NOT_ON_FILE, itemIds);
        clearScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
        return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf(CAW_AGIS_REFRESH_ITEM_PRICE));
        //END BZ62147
    }

    private void updateCustMembershipInfo(IItem item, Boolean autoRenew) {//BZ62146
        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);//BZ25434
        
        if (iParty != null) {//BZ25434
            String customerInfo = getLookupResponseData();
            CawMembershipActivityModel activityModel = null;
            
            if (item != null && item instanceof NonPhysicalItemModel && item.getMerchLevel4Id() != null) {
                String itemSubtype = item.getMerchLevel4Id();
                activityModel = _cawMembershipActivityHelper.getGroupItemByGroupName(itemSubtype);
                if(activityModel != null) {
                    activityModel.setAutoRenew(autoRenew.booleanValue());//BZ62146
                }
            }
            if (activityModel != null) {
                customerInfo = _cawAdvancePromptingHelper
                        .updateMembershipsAttrPitches(customerInfo, item.getItemId(), activityModel);//BZ26398, BZ69535
            }
            CawCatalystHelper.setLookupResponseData(customerInfo);
            _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerInfo);//BZ25434
            _transactionScope.clearValue(CawValueKeys.IS_APPLY_CLUB_PRICE); //BZ25115
            
            // Begin BZ59283 - update flag to true when validate GSAM membership item
            String memberId = CawCheetahHelper.getInstance().getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            
            if(memberId != null && !memberId.isEmpty()) {
                _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
            }
            // End BZ59283
        }
    }
    
    private String getLookupResponseData() {

        String lookupResponseDataResponse = CawCatalystHelper
                .getLookupResponseData();//BZ26255
        
        //Begin BZ24944
        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = _transactionScope
                    .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
        }

        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);//BZ26255
        }
        //End BZ24944

        return lookupResponseDataResponse;
    }
}