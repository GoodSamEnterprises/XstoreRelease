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
 * BZ35326          120320    [PROD] [NEW REQ] Non-credited Wholesale using Credit / AR and 3rd Party Credit mapped to same Tender Type/Trans Code
 * BZ46016          310820    [Internal] Xstore makes a call to Card status and catalyst 4 unexpectedly when back from Validation Third party account is zero.
 *===================================================================
 */

package caw.pos.araccount.validation;

import java.math.BigDecimal;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawValidateThirdPartyAvailableBalanceZeroOp
        extends AbstractPromptOp {

    @Override
    public boolean isOperationApplicable() {

        boolean tpAvailableBalanceZero = false;
        IPosTransaction iPosTransaction = _transactionScope.getTransaction();

        if (iPosTransaction.getAmountDue().compareTo(BigDecimal.ZERO) == 1
                && _transactionScope
                        .getValue(CawValueKeys.TP_ACCOUNT_BALANCE) != null
                && _transactionScope.getValue(CawValueKeys.TP_ACCOUNT_BALANCE)
                        .compareTo(BigDecimal.ZERO) == 0) {
            tpAvailableBalanceZero = true;
        }
        return tpAvailableBalanceZero;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_TP_AVAILABLE_BALANCE_ZERO_VALIDATION");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.getStartChainResponse(OpChainKey.valueOf("CHECK_SALE_COMPLETE"));/*BZ46016*/
    }

}
