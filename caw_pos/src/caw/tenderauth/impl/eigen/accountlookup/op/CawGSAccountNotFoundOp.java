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
 * BZ25762          121418      New Requirement - Credit Account Look up integration in Xstore
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawGSAccountNotFoundOp extends PromptOp {

    @Inject
    private CawEigenMgr _cawEigenMgr;

    @Inject
    private IBusyState  _busyState;

    /* Prompt Key
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_NOT_FOUND");
    }

    /* Session for customer choose to process Account Lookup again or not.
     * @see dtv.pos.framework.op.PromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        if (argEvent != null) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();

            if (key.equals(XstDataActionKey.ACCEPT)) {
                _busyState.start(getLongRunningMessage());
                if (_cawEigenMgr.retryAccountLookup()) {
                    _busyState.end();
                    return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_ACCOUNT_LOOKUP"));
                }
            }
        }
        return HELPER.completeResponse();
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.WAIT_FOR_SIGCAP;
    }

}
