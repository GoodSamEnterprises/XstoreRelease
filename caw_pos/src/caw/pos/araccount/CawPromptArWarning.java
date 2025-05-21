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
 * BZ23263          250917    Implement House Account
 *===================================================================
 */

package caw.pos.araccount;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawPromptArWarning extends AbstractPromptOp {

    private static final String CAW_TENDER_AMOUNT_OP = "CAW_TENDER_AMOUNT_OP";

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_PROMPT_AR_WARNING");
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        IXstDataAction action = (IXstDataAction) argArg0;
        IXstActionKey key = action.getActionKey();
        if (XstDataActionKey.YES == key) {
            _transactionScope
                    .setValue(CawValueKeys.IS_ALLOW_DISPLAY_PROMPT_AMT, true);
            return HELPER.getStartChainResponse(OpChainKey
                    .valueOf(CAW_TENDER_AMOUNT_OP));
        }
        return HELPER.completeResponse();
    }

}
