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
 * BZ30154          190619    [New Requirement] Xstore capture the Work Order line items' sale associate from S&I and forward it to Order Service as part of item attribute
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;

import javax.inject.Inject;

import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawDisplayWorkOrderMessageOp extends Operation {

    @Inject
    protected FormattableFactory _ff;

    @Inject
    private IBusyState           _busyState;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        String msg = " ";
        if (!CawWorkOrderHelper.getInstance().getNotExist().isEmpty()) {

            List<String> items = CawWorkOrderHelper.getInstance().getNotExist();

            for (String item : items) {
                msg += item + ", ";
            }
            msg = msg.substring(0, msg.length() - 2);
            items.clear();
            _busyState.endPermanent();
            return HELPER.getCompletePromptResponse(PromptKey
                    .valueOf("EMPLOYEE_NOT_ON_FILE_NOTIFY"), getPromptArgs(argVar1, msg));
        }
        return HELPER.completeResponse();

    }

    private IFormattable[] getPromptArgs(IXstEvent argEvent, String msg) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getSimpleFormattable(msg);
        return args;
    }

}
