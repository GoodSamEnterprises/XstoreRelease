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
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 *===================================================================
 */

package caw.pos.order;

import dtv.pos.common.PromptKey;
import dtv.pos.order.PromptOrderTypeOp;

/**
 *
 */
public class CawWonderSignPromptOrderTypeOp extends PromptOrderTypeOp {

    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf("CAW_WONDER_SIGN_ORDER_TYPE");
    }
}
