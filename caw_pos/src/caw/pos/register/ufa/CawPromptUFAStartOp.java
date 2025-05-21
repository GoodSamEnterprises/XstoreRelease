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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

public class CawPromptUFAStartOp extends AbstractPromptOp {

    private static final IXstDataActionKey ACT_UFA_CLOSE = XstDataActionKey
            .valueOf("UFA_CLOSE");

    private static final Logger            _logger       = LogManager
            .getLogger(CawPromptUFAStartOp.class);

    private boolean                        isChecked     = false;

    public CawPromptUFAStartOp() {

        super();
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("PAID_OUT_UFA_INVALID");
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable msgDef = _ff.getTranslatable("_caw_ufa_promptmsg_warning");
        return (new IFormattable[] { msgDef });
    }

    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        IOpResponse response = null;
        try {
            if (!isChecked) {
                setOpState(POST_PROMPT);
                response = this
                        .runValidationCheck(argEvent, getErrorPromptKey());
                isChecked = true;
                if (response != null && response.getOpStatus().isComplete()) {
                    return HELPER.completeResponse();
                }
            } else {
                if (argEvent instanceof IXstDataAction) {
                    response = handleDataAction((IXstDataAction) argEvent);
                }
            }
        } catch (Exception ex) {
            _logger.error("handleInitialState-1", ex);
        }

        if (response == null) {
            response = super.handleInitialState(argEvent);
        }
        return response;
    }

    @Override
    public IOpResponse handlePromptEvent(IXstEvent argEvent) {

        return super.handlePromptEvent(argEvent);
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return HELPER.completeResponse();
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey key = argEvent.getActionKey();
        if (ACT_UFA_CLOSE.equals(key)) {
            //Stop the process
            return HELPER.completeCurrentChainResponse();
        }
        return super.handleDataAction(argEvent);
    }

    @Override
    public IOpResponse runValidationCheck(IXstEvent argEvent,
            PromptKey argFailedPrompt) {

        IOpResponse response = null;
        IPosTransaction rettx = getCurrentTransaction();
        if (rettx != null) {
            //prompt warning message and stop the process
            response = getPromptResponse(argEvent, getPromptKey(), getPromptArgs(argEvent));
        }

        if (response == null) {
            //Continue to check other rules
            response = super.runValidationCheck(argEvent, argFailedPrompt);
        }

        if (response == null) {
            //Continue to handle 
            response = handlePromptResponse(argEvent);
        }

        return response;
    }

    /**
     * Check current transaction exists or not
     * @return
     */
    protected final IPosTransaction getCurrentTransaction() {

        if (_transactionScope != null) {
            IPosTransaction tran = _transactionScope.getTransaction();
            return tran;
        } else {
            return null;
        }

    }

}
