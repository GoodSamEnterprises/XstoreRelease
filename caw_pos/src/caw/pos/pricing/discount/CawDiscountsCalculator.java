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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction
 *===================================================================
 */

package caw.pos.pricing.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.pricing.discount.DiscountHelper;
import dtv.pos.pricing.discount.DiscountsCalculator;
import dtv.pos.pricing.discount.type.DiscountCalculationMethod;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailPriceModifier;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawDiscountsCalculator extends DiscountsCalculator {

    @Override
    protected void handleLineItemDiscount(ISaleReturnLineItem lineItem, IRetailPriceModifier modifier) {

        if (modifier.getStringProperty("IS_LOYALTY_MODIFIER") != null) {
            BigDecimal unitPrice = lineItem.getUnitPrice();
            BigDecimal discountAmount = null;
            int discountAmountAmountScale = 6;
            DiscountCalculationMethod calcMethod = DiscountHelper.getDiscountCalculationMethod(modifier);
            BigDecimal priceChangeAmt = BigDecimal.ZERO;
            BigDecimal maxDiscount = modifier.getDiscount().getMaxDiscount();
            if (calcMethod != null && calcMethod.isDollarAmountBased()) {
                discountAmount = modifier.getAmount();
                if (maxDiscount != null && NumberUtils.isGreaterThan(discountAmount.abs(), maxDiscount.abs())) {
                    discountAmount = maxDiscount;
                }

                if (discountAmount != null && NumberUtils.isGreaterThan(discountAmount.abs(), unitPrice.abs())) {
                    discountAmount = unitPrice;
                }
                unitPrice = unitPrice.subtract(discountAmount);
                if (calcMethod.usesPromptIfNeeded() && !lineItem.getReturn() && NumberUtils.isNegative(unitPrice)) {
                    unitPrice = BigDecimal.ZERO;
                }
            } else if (calcMethod == null || !calcMethod.isCompetitivePriceBased() && !calcMethod.isCompetitivePriceDiscountAmtBased()) {
                if (calcMethod != null && calcMethod.isPercentageBased()) {
                    int scale = ConfigurationMgr.getLineDiscountUseConfiguredScale() ? ConfigurationMgr.getLineItemDiscountPrecision() : this.getCurrency().getDefaultFractionDigits();
                    discountAmountAmountScale = scale;
                    discountAmount = unitPrice.multiply(modifier.getPercent()).setScale(scale, roundingMode_);
                    discountAmount = discountAmount.divide(lineItem.getQuantity(), 6, RoundingMode.HALF_UP);
                    if (maxDiscount != null && NumberUtils.isGreaterThan(discountAmount.abs(), maxDiscount.abs())) {
                        discountAmount = maxDiscount;
                    }

                    if (NumberUtils.isGreaterThan(discountAmount.abs(), unitPrice.abs())) {
                        discountAmount = unitPrice;
                    }

                    unitPrice = unitPrice.subtract(discountAmount);
                }
            }
            modifier.setPriceChangeAmount(priceChangeAmt);
            modifier.setAmount(discountAmount);
            modifier.setExtendedAmount(discountAmount.multiply(lineItem.getQuantity()).setScale(discountAmountAmountScale, roundingMode_).setScale(6, roundingMode_));
            lineItem.setUnitPrice(unitPrice);
        }else {
            super.handleLineItemDiscount(lineItem, modifier);
        }
        
    }
}
