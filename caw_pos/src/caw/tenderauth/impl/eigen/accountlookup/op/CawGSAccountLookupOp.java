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
 * BZ29134          290119      [Internal] The Account Lookup flow should be aborted after three failed attempts look up a customer hasn't found in system.
 * BZ29338          140219      [Internal][Account Lookup] Xstore does not back processing status while the customer inputs again SSN to retry after account not found firstly.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawGSAccountLookupOp extends PromptOp {

    @Inject
    private CawEigenMgr    _cawEigenMgr;

    @Inject
    private IBusyState     _busyState;

    @Inject
    private DefaultScope   _defaultScope;

    /* BEGIN BZ29338 */
    @Inject
    private CawEigenHelper _cawEigenHelper;
    Integer                coutSSNEntryFalse = _defaultScope.getValue(CawValueKeys.CAW_THREE_FAILED_ATTEMPTS_SSN);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArgEvent) {

        if (coutSSNEntryFalse != null) {
            return handlePromptResponse(argArgEvent);
        }

        return super.handleOpExec(argArgEvent);
    }
    /* END BZ29338 */

    /* Prompt Key
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_LOOKUP");
    }

    /* Session for customer input SSN and send Account Lookup to ADS
     * @see dtv.pos.framework.op.PromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        /* BEGIN BZ29134 */
        if (coutSSNEntryFalse == null) {
            coutSSNEntryFalse = 0;
        }
        /* END BZ29134 */
        IXstActionKey key = null;
        //Show customer detail on prompt and handle YES/NO
        /* BEGIN BZ29338 */
        if (argEvent != null) {
            key = ((IXstAction) argEvent).getActionKey();
        }

        if (XstDataActionKey.ACCEPT.equals(key) || coutSSNEntryFalse != null) {
            /* END BZ29338 */
            //Customer start input SSN
            _busyState.start(getLongRunningMessage());
            if (_cawEigenMgr.promptSocialSecurityEntryFull()) {
                //Send Account Lookup to ADS
                //If account is found, go to confirm info
                if (_cawEigenMgr.requestAccountLookup()) {
                    _busyState.end();
                    return HELPER.completeResponse();
                }
                //If account is not found, go to not found chain
                /* BEGIN BZ29134 */
                else if (coutSSNEntryFalse == CawConstants.CAW_THREE_FAILED_ATTEMPTS_SSN) {
                    _cawEigenMgr.displayAccountThreeFailedAttemptsSSN();
                    return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_THREE_FAILED_ATTEMPTS_SSN"));
                } else {
                    coutSSNEntryFalse += 1;
                    setScopedValue(CawValueKeys.CAW_THREE_FAILED_ATTEMPTS_SSN, coutSSNEntryFalse);
                    return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_ACCOUNT_NOT_FOUND"));
                }
                /* END BZ29134 */
            } else {
                /* BEGIN BZ29338 */
                if (coutSSNEntryFalse != 0) {
                    _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                    return HELPER.completeCurrentChainResponse();
                } else {
                    return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_ACCOUNT_LOOKUP"));
                }
                /* END BZ29338 */
            }
        }
        return HELPER.completeCurrentChainResponse();
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.WAIT_FOR_SIGCAP;
    }
}
