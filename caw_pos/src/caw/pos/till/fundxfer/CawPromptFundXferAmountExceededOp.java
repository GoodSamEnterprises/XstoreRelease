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
 * BZ26896          260718    [New Requirement] Add security override for Paid Out transaction greater than the configured max
 *===================================================================
 */

package caw.pos.till.fundxfer;

import java.math.BigDecimal;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.IReasonCode;

public class CawPromptFundXferAmountExceededOp extends AbstractPromptOp {

    private static final PromptKey PAID_OUT_EXCEEDED = PromptKey
            .valueOf("PAID_OUT_EXCEEDED");

    /** {@inheritDoc} */
    @Override
    public PromptKey getDefaultPromptKey() {
        return PAID_OUT_EXCEEDED;
    }

    /** {@inheritDoc} */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        if (argEvent instanceof IXstDataAction && ((IXstDataAction) argEvent)
                .getActionKey().equals(XstDataActionKey.ACCEPT)) {
            return HELPER.completeResponse();
        }

        return HELPER.silentErrorResponse();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {

        BigDecimal amount = getScopedValue(ValueKeys.ENTERED_TILL_AMOUNT);
        IReasonCode reasonCode = getScopedValue(ValueKeys.SELECTED_REASON_CODE);
        // Check that fund transfer amount falls into the correct min and max range
        if ((amount == null) || NumberUtils
                .isGreaterThan(reasonCode.getMinimumAmt(), amount)) {
            return false;
        } else if (NumberUtils
                .isGreaterThan(amount, reasonCode.getMaximumAmt())) {
            return true;
        }

        return false;
    }
}
