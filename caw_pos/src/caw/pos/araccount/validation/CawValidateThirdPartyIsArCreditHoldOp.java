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
 * BZ36405          030620    Issue with Credit Customer placed on credit hold
 *===================================================================
 */

package caw.pos.araccount.validation;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawValidateThirdPartyIsArCreditHoldOp extends AbstractPromptOp {

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope.getValue(CawValueKeys.IS_AR_CREDIT_HOLD) != null
                && _transactionScope.getValue(CawValueKeys.IS_AR_CREDIT_HOLD)) {
            return  true;
        }
        return false;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_TP_IS_AR_CREDIT_HOLD_VALIDATION");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {
        return HELPER
                .getStartChainResponse(OpChainKey.valueOf("PRE_TENDERING"));
    }

}
