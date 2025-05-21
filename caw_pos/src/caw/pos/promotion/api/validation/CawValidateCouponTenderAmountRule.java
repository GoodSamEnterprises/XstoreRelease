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
 * BZ23147          070917    Implement Serialized coupon
 *===================================================================
 */

package caw.pos.promotion.api.validation;

import static dtv.util.NumberUtils.isGreaterThan;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.promotion.api.response.CawCouponData;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 *
 */
public class CawValidateCouponTenderAmountRule extends AbstractValidationRule {

    /**
     * 
     */
    private static final String COUPON = "COUPON";

    @Inject
    private TransactionScope    _transactionScope;

    /**
     * Can not enter the amount that greater than coupon's amount.  
     */
    @Override
    public IValidationResult validate() {

        ArrayList<CawCouponData> list = _transactionScope
                .getValue(CawValueKeys.LIST_COUPON_DATA);

        if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE).getTenderId()
                .equalsIgnoreCase(COUPON) && list != null && !list.isEmpty()) {
            BigDecimal enteredAmount = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA)
                    .getEnteredAmount();
            CawCouponData selectedCouponTender = getSelectedCouponData(list, getScopedValue(ValueKeys.CURRENT_TENDER_LINE)
                    .getSerialNumber());

            BigDecimal couponAmount = new BigDecimal(
                    selectedCouponTender.getMaxValue());
            if (isGreaterThan(enteredAmount, couponAmount)) {
                return SimpleValidationResult.getFailed("_promptmsg101");
            }
        }
        return IValidationResult.SUCCESS;
    }

    private CawCouponData getSelectedCouponData(ArrayList<CawCouponData> list,
            String serialNum) {

        int size = _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                .size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).getSerialNumber().equalsIgnoreCase(serialNum)) {
                return list.get(i);
            }
        }

        return null;

    }

}
