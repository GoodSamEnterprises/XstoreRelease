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
 * BZ29879          270319    [Prod] Work Order Issues- missing warranty items
 *===================================================================
 */

package caw.pos.workorder.op.warranty.common;

import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.common.CreateWarrantyOp;
import dtv.xst.dao.itm.IWarrantyItem;

/**
 *
 */
public class CawWorkOrderCreateWarrantyOp extends CreateWarrantyOp {

    @Override
    public boolean isOperationApplicable() {

        IWarrantyItem warrantyPlan = getScopedValue(ValueKeys.SELECTED_WARRANTY_PLAN);
        if (warrantyPlan != null) {
            return true;
        }

        return false;
    }

}
