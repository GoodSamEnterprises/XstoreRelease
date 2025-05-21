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
 * BZ24051          171017    price of reload GC is displayed incorrectly at return screen when performing return no receipt a Reload GC
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import caw.pos.common.CawValueKeys;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawRefundCashOutDisplayPromptOp extends AbstractPromptOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        if (getScopedValue(CawValueKeys.CASHOUT_NOTIFY_MSG) != null
                && !getScopedValue(CawValueKeys.CASHOUT_NOTIFY_MSG).isEmpty()) {
            IFormattable msg = _formattables
                    .getTranslatable(getScopedValue(CawValueKeys.CASHOUT_NOTIFY_MSG));
            return HELPER.getErrorResponse(msg);
        }
        return HELPER.completeResponse();
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.DEFAULT;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

}
