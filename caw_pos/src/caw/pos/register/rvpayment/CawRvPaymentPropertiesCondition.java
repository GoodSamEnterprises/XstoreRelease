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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 *===================================================================
 */

package caw.pos.register.rvpayment;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;

/**
 *
 */
public class CawRvPaymentPropertiesCondition extends AbstractRunCondition {

    @Override
    protected boolean shouldRunImpl() {

        Boolean isRun = Boolean.FALSE;
        isRun = this.getScopedValue(CawValueKeys.CAW_RV_PROPERTIES) == null;
        return isRun;
    }

}
