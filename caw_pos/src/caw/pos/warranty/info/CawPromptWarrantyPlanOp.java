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
 * BZ33305          171019    [New Requirement] Need changing about formatting, color, displaying on Current Warranty Plans Screen
 * BZ33478          211019    [Internal] Lose focus at Warranty Plans Prompt screen when Scan/Press Enter key
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 *===================================================================
 */
package caw.pos.warranty.info;

import static dtv.hardware.types.InputType.INPUT_ACCOUNT_RECEIVABLE;
import static dtv.hardware.types.InputType.INPUT_CUSTOMER_CARD;
import static dtv.hardware.types.InputType.INPUT_DRIVERS_LICENSE;
import static dtv.hardware.types.InputType.INPUT_EMPLOYEE_CARD;
import static dtv.hardware.types.InputType.INPUT_ID_CARD;
import static dtv.hardware.types.InputType.INPUT_MSR_OTHER;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawPropertyUtils;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.action.IXstDataActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.event.IXstEventObserver;
import dtv.pos.iframework.event.IXstEventType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.info.PromptWarrantyPlanOp;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

public class CawPromptWarrantyPlanOp extends PromptWarrantyPlanOp implements IXstEventObserver { // BZ33595

    /* BEGIN BZ33595 */
    private static final IXstEventType[] EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE };

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    /* END BZ33595 */

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable[] args = new IFormattable[2];

        IItem itemToCover = getScopedValue(ValueKeys.CURRENT_COVERED_ITEM);
        ISaleReturnLineItem lineToCover = getScopedValue(ValueKeys.CURRENT_COVERED_LINE_ITEM);
        if (itemToCover == null && lineToCover != null) {
            itemToCover = lineToCover.getItem();
        }
        if (itemToCover != null) {
            args[0] = _ff.getLiteral(itemToCover.getDescription());
        }
        args[1] = _ff.getTranslatable("+WARRANTY_TITLE");
        return args;
    }
    
    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {
      
        //Begin BZ33478
        IXstDataActionKey PLAN_ENTER = XstDataActionKey.valueOf("PLAN_ENTER");
        
        if (PLAN_ENTER.equals(argAction.getActionKey())) {
            return HELPER.waitResponse();
        }
        else {
            return super.handleDataAction(argAction);
        }
        //End BZ33478
    }

    /* BEGIN BZ33595 */
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        /* For event when press Accept or Reject */
        if (!(argEvent instanceof IXstAction)) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper.getInstance().getScanner(), CawHardwareHelper.getInstance()
                    .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            return HELPER.waitResponse();
        }
        return super.handlePromptEvent(argEvent);
    }
    /* END BZ33595 */

}
