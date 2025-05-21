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
 * BZ29468          210219    [Internal] Invalid search data provided response received after swiping PLCC for Account Payment
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Check current customer's card is present or not.
 */
public class CawCustomerCardPresentConfirmOp extends PromptOp {

    private static final IXstDataActionKey CARD_PRESENT = XstDataActionKey.valueOf("CARD_PRESENT");

    @Inject
    private CawEigenMgr                    _cawEigenMgr;

    @Inject
    private IBusyState                     _busyState;

    /* Main prompt.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_PAYMENT_CAPTURE");
    }

    /* Swipe customer's card.
     * @see dtv.pos.framework.op.AbstractPromptOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey key = argEvent.getActionKey();
        if (key.equals(CARD_PRESENT)) {
            _busyState.start(CawConstants.WAIT_FOR_SIGCAP);
            /*BZ29468: need to input SSN then swipe card*/
            if (_cawEigenMgr.swipeCardRequest()) {/*BZ29536: change to Long Token, remove entry SSN*/
                _busyState.end();
                return HELPER.completeResponse();
            }
        }
        return HELPER.completeCurrentChainResponse();
    }
}
