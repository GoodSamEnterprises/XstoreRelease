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
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins 
 * BZ24219          011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard
 * BZ24317          011117    Membership validate response data from EBS should be displayed instead of Xstore messages in case the customer has already membership ID
 * BZ24356          031117    [Advance Prompting] Xstore needs to return to Membership Info prompt after a failed membership validation response
 *===================================================================
 */

package caw.pos.advance.prompting;

import caw.pos.common.CawValueKeys;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessNotifyJoinGoodSamPromptOp extends AbstractPromptOp {

    protected static final IXstDataActionKey RETRY    = XstDataActionKey
            .valueOf("RETRY");

    protected static final IXstDataActionKey CONTINUE = XstDataActionKey
            .valueOf("CONTINUE");

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN) != null) {
            if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) != null
                    && getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) != 1) {//BZ24317
                isRun = Boolean.TRUE;
            }
        }

        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_ACTIVE_MEMBERSHIP_MESSAGE");//BZ24317
    }

    // Begin BZ24317
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];

        if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) != null
                && getScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED) == 0) {
            args[0] = _ff.getTranslatable("_error");
            if (getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG) != null) {
                args[1] = _ff
                        .getSimpleFormattable(getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG), FormatterType.SIMPLE);
            } else {
                args[1] = _ff.getTranslatable("_activeMembershipDeclined");
            }
        } else {
            args[0] = _ff.getTranslatable("_promptTitleNotify");
            args[1] = _ff.getTranslatable("_activeMembershipApproved");
        }

        return args;
    }
    // End BZ24317

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        // Begin BZ24356
        if (argEvent != null) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if (key == RETRY) {
                setScopedValue(CawValueKeys.IS_RETRY_VALIDATE, Boolean.TRUE);
                clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
                return HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("CAW_CUSTOMER_VALIDATE_MEMBERSHIP"));
            } else if (key == CONTINUE) {
                clearScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED);
                clearScopedValue(CawValueKeys.IS_RETRY_VALIDATE);
                return super.handleOpExec(argEvent);
            } else if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN) == Boolean.FALSE) {
                clearScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT);
                return HELPER.completeCurrentChainResponse();
            }
        }
        // End BZ24356

        return super.handleOpExec(argEvent);
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent arg) {

        if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN) == Boolean.FALSE) {
            return HELPER.completeCurrentChainResponse();
        }
        clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);//BZ24317
        return HELPER.getCompleteStackChainResponse(OpChainKey
                .valueOf("CAW_CUSTOMER_VALIDATE_MEMBERSHIP"));
    }
}
