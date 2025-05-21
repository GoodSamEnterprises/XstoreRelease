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
public class CawPromptArReturnEBSOffline extends AbstractPromptOp {

    private static final String CAW_PROMPT_AR_RETURN_EBS_OFFLINE = "CAW_PROMPT_AR_RETURN_EBS_OFFLINE";

    private static final String PRE_TENDERING                    = "PRE_TENDERING";

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf(CAW_PROMPT_AR_RETURN_EBS_OFFLINE);
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        IXstDataAction action = (IXstDataAction) argArg0;
        IXstActionKey key = action.getActionKey();
        if (XstDataActionKey.YES == key) {
            return HELPER
                    .getStartChainResponse(OpChainKey.valueOf(PRE_TENDERING));
        }
        return HELPER.completeResponse();
    }

}
