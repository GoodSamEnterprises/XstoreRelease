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
 * BZ26963          310718    Missing Serialize number each line item on receipt after complete sale transaction
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import dtv.pos.docbuilding.conditions.NonPhysicalLineItemTypeCondition;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawNonPhysicalLineItemTypeCondition
        extends NonPhysicalLineItemTypeCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        boolean result = false;

        if (argSource instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argSource;
            if (lineItem.getItem() instanceof INonPhysicalItem) {
                return super.conditionMetImpl(argSource);
            } else {
                result = lineItem.getItem().getSerializedItem();
            }
        }
        return result;
    }
}
