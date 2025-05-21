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
 * BZ29443          190219    [Internal][Account Payment]GS Account Payment amount should be validated incase inputting invalid amount.
 * BZ29535          260219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 *===================================================================
 */

package caw.pos.accountpayment.validation;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractSecuredValidationRule;

/**
 * The CawValidateAccountPaymentAmountRule class
 */
public class CawValidateAccountPaymentAmountRule extends AbstractSecuredValidationRule {

    @Inject
    protected TransactionScope _transactionScope;

    private CawCustomerGSHelper _gsHelper       = CawCustomerGSHelper.getInstance(); // BZ29535

    @Override
    public IValidationResult validate() {

        BigDecimal amount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
        if ((amount != null && amount.doubleValue() <= 0) || amount == null) {
            return SimpleValidationResult.getFailed("_notallowedEnterZero");
        }
        /* BEGIN BZ29535 */
        if (amount.compareTo(_gsHelper.getMinAmountDue()) == -1) {
            return SimpleValidationResult.getFailed("_gsMsValidateMiniPaymentAmountDue", _gsHelper.getMinAmountDue());
        }
        /* END BZ29535*/
        return IValidationResult.SUCCESS;
    }
}
