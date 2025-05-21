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
 * BZ26500          060618    Xstore allows to complete trans with Third-party tender which customer has belong club pricing once EBS is offline
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 *===================================================================
 */

package caw.pos.araccount;

import caw.pos.common.CawUtilFunction;
import caw.pos.util.CawEBSHelper;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/*
 * this class is used to check ESB offline or not.
 */
public class CawPromptThirdPartyEBSOfflineOp extends AbstractPromptOp {

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_PROMPT_EBS_OFFLINE");
    }

    @Override
    public boolean isOperationApplicable() {

        //BZ26575 fixed by using CawEBSHelper
        if (!CawUtilFunction.allowEBSConnection()
                || CawEBSHelper.getInstance().isCustomerTemplateOnline()) {
            return false;
        }
        return true;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return HELPER
                .getStartChainResponse(OpChainKey.valueOf("PRE_TENDERING"));
    }
}
