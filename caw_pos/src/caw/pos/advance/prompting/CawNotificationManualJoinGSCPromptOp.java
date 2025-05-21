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
 * BZ69574          130225    [Internal][AGIS Modification] The prompt 'GS JOIN MEMBERSHIP NUMBER' display when entering item offers 
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.hardware.types.InputType.*;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawPropertyUtils;

import dtv.hardware.types.InputType;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawNotificationManualJoinGSCPromptOp extends AbstractPromptOp implements IXstEventObserver {

    private static final String OK = "OK_JOIN";
    private static final IXstEventType[] EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE }; //BZ34226

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        final IXstActionKey key = ((IXstAction) argEvent).getActionKey();

        if (key.toString().equalsIgnoreCase(OK)) {
            return HELPER.getStartChainResponse(OpChainKey
                    .valueOf("BACKTO_SALE_ITEM"));
        }

        return HELPER.completeResponse();
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("JOIN_MANUAL_GSC_CONFIRM_PROMPT");
    }
    
    //Begin BZ34226
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

