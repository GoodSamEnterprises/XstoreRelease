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
 *===================================================================
 */

package caw.pos.araccount;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.houseaccount.validation.ValidateHouseAccountTenderAmountRule;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawValidateTPTenderAmountRule
        extends ValidateHouseAccountTenderAmountRule {

    @Inject
    protected TransactionScope _transactionScope;

    /** {@inheritDoc} */
    @Override
    public IValidationResult validate() {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderAmountData enteredAmount = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA);
        IPosTransaction iPosTransaction = _transactionScope.getTransaction();
        //Check tender type is third party and check transaction total amount > 0 (handle for Sale, Work order deposit and Word order refund)
        if (CawConstants.THIRD_PARTY
                .equals(tenderLine.getTender().getTenderId())
                && iPosTransaction.getAmountDue()
                        .compareTo(BigDecimal.ZERO) == 1) {

            BigDecimal tpBalance = BigDecimal.ZERO;
            if (_transactionScope
                    .getValue(CawValueKeys.TP_ACCOUNT_BALANCE) != null) {
                tpBalance = _transactionScope
                        .getValue(CawValueKeys.TP_ACCOUNT_BALANCE);
                if (enteredAmount.getEnteredAmount().compareTo(tpBalance) == 1) {
                    return SimpleValidationResult
                            .getFailed("_cawTPAvailableBalanceValidation", tpBalance
                                    .toString());
                }

            }
            return IValidationResult.SUCCESS;
        }

        return IValidationResult.SUCCESS;
    }
}
