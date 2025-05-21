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
 * BZ26851          090818    [PROD] Register displayed an error when trying to print receipt
 *===================================================================
 */

package caw.pos.pricing.discount.validation;

import java.math.BigDecimal;

import caw.pos.common.CawConstants;

import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.util.NumberUtils;

/**
 *
 */
public class CawDiscountAmountLimitValidRule extends AbstractValidationRule {

    @Override
    public IValidationResult validate() {

        BigDecimal maxDiscount = new BigDecimal(CawConstants.MAX_DISCOUNT_CONS);

        if (this.getScopedValue(ValueKeys.ENTERED_DISCOUNT_AMOUNT) != null) {
            BigDecimal newPriceQuantity = this
                    .getScopedValue(ValueKeys.ENTERED_DISCOUNT_AMOUNT);
            if (NumberUtils.isLessThanOrEqual(maxDiscount, newPriceQuantity)) {
                return SimpleValidationResult
                        .getFailed("_cawInvalidDiscountAmountEntered");
            }
        }

        return IValidationResult.SUCCESS;
    }

}
