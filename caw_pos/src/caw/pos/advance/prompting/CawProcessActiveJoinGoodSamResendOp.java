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
 * BZ24324          021117    Membership validation prompt should be distinguish when joining in GS club and GS RS (Roadside assistance)
 *===================================================================
 */

package caw.pos.advance.prompting;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessActiveJoinGoodSamResendOp extends Operation {

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) != null
                && getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) == 1
                && getScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN) == Boolean.TRUE) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        return HELPER.getCompleteStackChainResponse(OpChainKey
                .valueOf("CAW_CUSTOMER_VALIDATE_MEMBERSHIP"));
    }

}
