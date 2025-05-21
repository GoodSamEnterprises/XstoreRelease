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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 *===================================================================
 */

package caw.pos.docbuilding.returns;

import caw.pos.register.returns.common.CawPurchaseUsedFirearmConstant;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 * Print return comment if return item is purchased used item.
 */
public class CawPurchaseUsedFirearmCondition
        extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof SaleReturnLineItemModel) {
            SaleReturnLineItemModel lineItem = (SaleReturnLineItemModel) argSource;
            if ((lineItem.getReasonCodeObject() != null)
                    && (CawPurchaseUsedFirearmConstant.REASON_TYPE_CODE
                            .equals(lineItem.getReasonCodeObject()
                                    .getReasonTypeCode()))
                    && (CawPurchaseUsedFirearmConstant.TYPE_CODE.equals(lineItem
                            .getReasonCodeObject().getReasonCode()))) {
                return true;
            }
        }
        return false;
    }

}
