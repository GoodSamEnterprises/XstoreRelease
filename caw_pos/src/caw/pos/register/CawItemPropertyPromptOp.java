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
 * BZ34226          271219    [New Requirement] Add Warning beeps for any prompt requiring action
 * BZ46743          050122    Vehicle Identification Number (VIN) Capture for Xstore
 *===================================================================
 */

package caw.pos.register;

import static dtv.hardware.types.InputType.*;

import org.apache.commons.lang3.BooleanUtils;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawPropertyUtils;
import caw.pos.common.CawValueKeys;

import dtv.hardware.types.InputType;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemPropertyPromptOp;


public class CawItemPropertyPromptOp extends ItemPropertyPromptOp implements IXstEventObserver {

    private static final IXstEventType[] EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE };

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    
    /* BEGIN BZ46743 */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        
        if (BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN))) {
            _transactionScope.clearValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN);
            return handleNextProperty(argEvent);
        }
        
        return super.handleOpExec(argEvent);
    }
    
    @Override
    protected IOpResponse handleNextProperty(IXstEvent argEvent) {
    
        _transactionScope.clearValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN);
        
        return super.handleNextProperty(argEvent);
    }
    /* END BZ46743 */
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
}
