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
 * BZ26289          240718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.houseaccount.op;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * The CawCheckHouseAccountPaymentStatusOp
 */
public class CawCheckHouseAccountPaymentStatusOp extends AbstractPromptOp {

    /**
     * The BACK_TO_SELL
     */
    private static final String BACK_TO_SELL    = "BACKTOSELL";

    /**
     * The SALE_ITEM_START
     */
    private static final String SALE_ITEM_START = "SALE_ITEM_START";

    private String              promptKey       = "CAW_PROMPT_HOUSE_ACCOUNT_EBS_OFFLINE";

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope != null) {

            //Customer has available balance
            Boolean valid = _transactionScope.getValue(CawValueKeys.HAS_WHLS_HOUSE_ACCOUNT);
            if (valid != null && !valid.booleanValue()) {
                promptKey = "CAW_PROMPT_NO_HOUSE_ACCOUNT";
                return true;
            }
        }
        return false;
    }

    /**
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf(this.promptKey);
    }

    /**
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent event) {
        return HELPER.completeResponse();
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IXstActionKey key = argAction.getActionKey();
        if (key.toString().equalsIgnoreCase(BACK_TO_SELL)) {
            return HELPER
                    .getStartChainResponse(OpChainKey.valueOf(SALE_ITEM_START));
        }
        return super.handleDataAction(argAction);
    }
}
