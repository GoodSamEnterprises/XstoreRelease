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
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ25488          220218    [PROD][OrderService]Missing Tax Code in Order Service for Membership Items
 * BZ25434          110518    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ34226          271219    [New Requirement] Add Warning beeps for any prompt requiring action
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.hardware.types.InputType.*;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawPropertyUtils;
import caw.pos.common.CawValueKeys;

import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessMembershipItemValidMsgOp extends AbstractPromptOp implements IXstEventObserver {

    private static final IXstEventType[] EVENTS = { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE }; //BZ34226
    
    protected static final IXstDataActionKey RETRY    = XstDataActionKey
            .valueOf("RETRY");

    protected static final IXstDataActionKey CONTINUE = XstDataActionKey
            .valueOf("CONTINUE");

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isMembershipEmpty = getScopedValue(CawValueKeys.MEMBERSHIP_IS_EMPTY); //BZ25434
        if (isMembershipEmpty == null
                || isMembershipEmpty.booleanValue() == false) {//BZ25434
            if (getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG) != null) {
                return true;
            }
        }
        return false;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_ACTIVE_MEMBERSHIP_MESSAGE");
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getTranslatable("_promptTitleNotify");
        args[1] = _ff.getTranslatable("_activeMembershipApproved");

        if (getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG) != null) {
            args[1] = _ff
                    .getSimpleFormattable(getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG));
        }

        return args;
    }

    //Begin BZ34226
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        if (argEvent != null && argEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if (key == RETRY) {
                return HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("PROCESS_MEMBERSHIP_VALIDATE")); // BZ 25488
            } else {
                return super.handleOpExec(argEvent);
            }
        } else if (argEvent != null && !(argEvent instanceof IXstAction)) {
            return handlePromptEvent(argEvent);
        }
        return super.handleOpExec(argEvent);
    }

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {
        if (!(argEvent instanceof IXstAction)) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper
                    .getInstance().getScanner(), CawHardwareHelper.getInstance()
                            .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            return HELPER.waitResponse();
        }
        return super.handlePromptEvent(argEvent);
    }
    //End BZ34226

}
