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
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ29400          210219    [Internal[Account Lookup] First&Last name displaying on Account Found prompt does not match exactly First&name retrieved from ADS.
 * BZ29338          220219    [Internal][Account Lookup] Xstore does not back processing status while the customer inputs again SSN to retry after account not found firstly.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;

/**
 * This is process Account Lookup in case customer's is not present.
 */
public class CawAccountPaymentLookupOp extends PromptOp {

    @Inject
    private CawEigenMgr    _cawEigenMgr;

    @Inject
    private IBusyState     _busyState;

    private final IOpState ACC_NOT_FOUND = new OpState("ACC_NOT_FOUND");
    
    private CawCustomerGSHelper _gsHelper = CawCustomerGSHelper.getInstance(); //BZ29400
    
    Integer                     countSSNEntryFalse = getScopedValue(CawValueKeys.CAW_THREE_FAILED_ATTEMPTS_SSN); // BZ29338

    /* Process flow step by step.
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /* BEGIN BZ29338 */
        if (countSSNEntryFalse == null) {
            countSSNEntryFalse = 0;
        }
        /* END BZ29338 */
        if (argArg0 != null) {
            IXstActionKey key = ((IXstAction) argArg0).getActionKey();
            /*Step 1: press OK on Enter SSN prompt*/
            if (key.equals(XstDataActionKey.ACCEPT)) {
                _busyState.start(CawConstants.WAIT_FOR_SIGCAP);
                /*After pre-Account not found step*/
                if (getOpState() != null && getOpState().equals(ACC_NOT_FOUND)) {
                    return retryAccountLookupResponse(argArg0); // BZ29338
                }
                /*Step 2: Wait for customer enter SSN and send account lookup request*/
                if (_cawEigenMgr.promptSocialSecurityEntryFull()) {
                    return accountLookupResponse(argArg0);
                }
            } else if (key.equals(XstDataActionKey.YES)) {
                /*Account Found Step: YES on Confirm Prompt to complete*/
                return HELPER.completeResponse();
            } else if (key.equals(XstDataActionKey.NO)) {
                /*Account Found Step: NO on Confirm Prompt to process pre-Account Not Found Step*/
                setOpState(ACC_NOT_FOUND);
                return HELPER.getPromptResponse(getErrorPromptKey());
            }
        }
        return HELPER.getPromptResponse(getInitPromptKey());
    }

    /**
     * Response, retry or no retry.
     * @return
     */
    private IOpResponse retryAccountLookupResponse(IXstEvent argArg0) {

        /*Account not found step: Ask if customer want to retry or not*/
        /*Account not found step: Retry to process back to step 1.*/
        /* BEGIN BZ29338 */
        _busyState.start(getLongRunningMessage());
        if (_cawEigenMgr.retryAccountLookup()) {
            setOpState(null);
            countSSNEntryFalse++;
            if (_cawEigenMgr.promptSocialSecurityEntryFull()) {
                _busyState.end();
                return accountLookupResponse(argArg0);
            } else {
                return HELPER.completeCurrentChainResponse();
            }
        }
        /*Account not found step: No retry to end all process.*/
        return HELPER.getPromptResponse(getInitPromptKey());
		/* END BZ29338 */
        
    }

    /**
     * Response, account found or account not found
     * @param argArg0
     * @return
     */
    private IOpResponse accountLookupResponse(IXstEvent argArg0) {
        if (_cawEigenMgr.requestAccountLookup()) {
            /*Account Found Step-Display Confirm Prompt*/
            _busyState.end();
            return HELPER.getPromptResponse(getDefaultPromptKey(), getPromptArgs(argArg0));
        } else {
            /*pre-Account not found step-Display Account Not Found Prompt*/
            /* BEGIN BZ29338 */
            if (countSSNEntryFalse == CawConstants.CAW_THREE_FAILED_ATTEMPTS_SSN) {
                _cawEigenMgr.displayAccountThreeFailedAttemptsSSN();
                _busyState.end();
                return HELPER
                        .getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_THREE_FAILED_ATTEMPTS_SSN"));
            }
            /* END BZ29338 */
            setOpState(ACC_NOT_FOUND);
            return HELPER.getPromptResponse(getErrorPromptKey());
        }
    }

    /* Show info on main prompt.
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[1];
        /*BEGIN BZ29400*/
        StringBuilder nameADS = new StringBuilder();
        nameADS.append(_gsHelper.getFirstNameADS())
                .append(CawConstants.SPACE_SIGN)
                .append(_gsHelper.getLastNameADS()).toString();
        args[0] = _ff.getSimpleFormattable(nameADS.toString());
        /*END BZ29400*/

        return args;
    }

    /**
     * Starting Account Lookup Prompt/Enter SSN Prompt
     * @return
     */
    private PromptKey getInitPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_LOOKUP");
    }

    /* Main prompt/Account Found Prompt/Confirm Name Prompt
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_CONFIRM");
    }

    /* Account Not Found prompt.
     * @see dtv.pos.framework.op.AbstractPromptOp#getErrorPromptKey()
     */
    @Override
    protected PromptKey getErrorPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_NOT_FOUND");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return super.handlePromptResponse(argEvent);
    }
}
