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
 * 
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;

/**
 *
 */
public class CawGatherVoucherInfoConditionOp extends AbstractRunCondition {

    @Override
    protected boolean shouldRunImpl() {

        if (CawConstants.CARD_IN_ACTIVE
                .equalsIgnoreCase(getScopedValue(CawValueKeys.CARD_ACTIVE_STATUS))) {
            return true;
        }
        
        return false;
    }

}
