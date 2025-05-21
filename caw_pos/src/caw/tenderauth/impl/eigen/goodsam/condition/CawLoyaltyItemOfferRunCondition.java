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
 * BZ59069          220923    HDE occurs after approval for GS Visa
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.condition;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

public class CawLoyaltyItemOfferRunCondition extends AbstractRunCondition {

	/* Start BZ59069 */
    @Override
    protected boolean shouldRunImpl() {

        ISaleReturnLineItem lineitem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        
        if (lineitem != null && lineitem.getItem() instanceof INonPhysicalItem) {
            return true;
        }
        return false;
    }
    /* End BZ59069 */
}
