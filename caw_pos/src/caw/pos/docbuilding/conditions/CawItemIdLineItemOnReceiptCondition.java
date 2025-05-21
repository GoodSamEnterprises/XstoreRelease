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
 * BZ65612          260724    AGMOD Update to Membership SKU New Requirements
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.CawValueKeys;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.register.giftreceipt.GiftReceiptPrintItemDataModel;
import dtv.xst.dao.cwo.impl.WorkOrderLineItemModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawItemIdLineItemOnReceiptCondition extends AbstractInvertableCondition {

    @Inject
    TransactionScope _transactionScope;
    
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof WorkOrderLineItemModel) {
            return false;
        }
        if (argSource instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argSource;
            if(isItemInPitchModel(lineItem.getItemId())) {
                return true;
            }
        } else if (argSource instanceof GiftReceiptPrintItemDataModel) {
            GiftReceiptPrintItemDataModel giftItem = (GiftReceiptPrintItemDataModel) argSource;
            ISaleReturnLineItem saleLine = giftItem.getItem();
            if(isItemInPitchModel(saleLine.getItemId())) {
                return true;
            }
        } else if (argSource instanceof IOrderLine) {
            ISaleReturnLineItem order = ((IOrderLine) argSource)
                    .getShadowedSaleItem();
            if (order == null) {
                String itemId = (((IOrderLine) argSource).getItemId());
                if (isItemInPitchModel(itemId)) {
                    return true;
                }
            }
        }
        return false;
    }
    //BEGIN BZ69391,BZ69389,BZ69389
    public Boolean isItemInPitchModel(String itemId) {
        CawAGISPitchesModel cawAGISPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        if(cawAGISPitchesModel != null) {
            List<CawAGISPitchesItemModel> listItem = new ArrayList<CawAGISPitchesItemModel>();
            listItem.addAll(cawAGISPitchesModel.getPitchItemsGroup1());
            listItem.addAll(cawAGISPitchesModel.getPitchItemsGroup2());
            
            List<String> itemIDs = listItem.stream()
                    .map(CawAGISPitchesItemModel::getItemCode)
                    .collect(Collectors.toList());
            if( !listItem.isEmpty() && itemIDs.contains(itemId)) {
                return true; 
            }
        }
        return false;
    }
    
    //END BZ69391,BZ69389,BZ69389
}
