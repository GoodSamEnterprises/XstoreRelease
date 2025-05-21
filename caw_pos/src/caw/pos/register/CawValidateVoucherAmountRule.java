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
 * 
 *===================================================================
 */

package caw.pos.register;

import java.math.BigDecimal;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 *
 */
public class CawValidateVoucherAmountRule extends AbstractValidationRule {

    @Override
    public IValidationResult validate() {

        VoucherBalanceInfo voucherBalanceInfo = getScopedValue(ValueKeys.VOUCHER_BALANCE_INFO);
        BigDecimal itemAmount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);

        if (itemAmount != null && voucherBalanceInfo != null
                && voucherBalanceInfo.getBalance() != null) {
            BigDecimal banlance = voucherBalanceInfo.getBalance();
            if (banlance.add(itemAmount)
                    .compareTo(CawEigenConstants.MAX_VALUE_GIFTCARD) > 0) {
                BigDecimal currentAmount = CawEigenConstants.MAX_VALUE_GIFTCARD
                        .subtract(banlance);
                IFormattable idArg = FF.getLiteral(currentAmount);
                return SimpleValidationResult
                        .getFailed("_giftCardReloadAmount", idArg);
            }
        }

        return IValidationResult.SUCCESS;
    }

}
