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
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.CawEigenHelper;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 * Prompt for entering the account payment amount.
 */
public class CawAccountPaymentAmountOp extends PromptOp {

    @Inject
    private CawEigenHelper _cawEigenHelper;

    /* Main Prompt.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_PAYMENT_AMOUNT");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        _cawEigenHelper.refreshPinpadScreen(_transactionScope);
        return HELPER.completeResponse();
    }

    /* Get and set entered amount.
     * @see dtv.pos.framework.op.AbstractPromptOp#handlePromptEvent(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        IXstActionKey key = ((IXstAction) argEvent).getActionKey();

        if (key.equals(XstDataActionKey.ACCEPT)) {
            setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, getBigDecimal(argEvent));
            return super.handlePromptEvent(argEvent);
        }
        return HELPER.completeCurrentChainResponse();
    }
}
