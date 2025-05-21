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
 * BZ24150          251017    [DEV] Serialized Merchandise certificate (coupon) applied to transaction subtotal
 *===================================================================
 */

package caw.pos.promotion.coupon;

import caw.pos.common.CawValueKeys;

import dtv.pos.coupon.AddCouponLineItemOp;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawAddCouponLineItemOp extends AddCouponLineItemOp {
    @Override
    public boolean isOperationApplicable() {

        _transactionScope.getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);

        Boolean isRun = Boolean.TRUE;
        if (getScopedValue(ValueKeys.CURRENT_COUPON) == null) {
            isRun = Boolean.FALSE;
        }

        return isRun;
    }
}
