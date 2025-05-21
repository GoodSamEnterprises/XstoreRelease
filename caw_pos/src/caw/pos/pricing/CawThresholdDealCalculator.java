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
 * BZ28014          310519    [New Requirement] Xstore needs to allow stackability for/Allow multiple Merchant Certificates in a transaction
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 *===================================================================
 */

package caw.pos.pricing;

import static dtv.data2.access.DataFactory.createObject;
import static dtv.pos.common.ConfigurationMgr.getDisplayProportionDealAmt;
import static dtv.pos.coupon.CouponHelper.COUPON_ID_PROPERTY;
import static dtv.util.NumberUtils.*;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import dtv.pos.framework.ui.model.InfoTabHelper;
import dtv.pos.pricing.ThresholdDealCalculator;
import dtv.pricing2.PricingDeal;
import dtv.pricing2.ResultAppPredication;
import dtv.xst.dao.trl.*;
import dtv.xst.pricing.XSTPricingDescriptor;

/**
 *
 */
public class CawThresholdDealCalculator extends ThresholdDealCalculator {

    @Inject
    private Optional<InfoTabHelper> _tabHelper;

    /* Keep the base code modifyLineItem() in case we need to compare later. 
     * Check duplicate coupon and the times it applied then re-calculating deal amount
     * @see dtv.pos.pricing.AbstractDealCalculator#modifyLineItem(dtv.pricing2.PricingDeal, dtv.pricing2.ResultAppPredication, dtv.xst.dao.trl.IRetailTransactionLineItem, boolean)
     */
    @Override
    protected void modifyLineItem(PricingDeal argDeal, ResultAppPredication argPred,
            IRetailTransactionLineItem argDealLine, boolean argIsTransDeal) {
        XSTPricingDescriptor deal = (XSTPricingDescriptor) argDeal.getNativeDeal();
        IRetailPriceModifier mod = null;
        boolean newMod = true;
        /* First, search for a price modifier that we might have used before. If found, unvoid, and set to our
         * worker. */
        ISaleReturnLineItem saleLine = (ISaleReturnLineItem) argPred.getLineItem().getNativeItem();
        List<IRetailPriceModifier> mods = saleLine.getRetailPriceModifierByTypeCode(deal.getReason().getName());
        if (CollectionUtils.isNotEmpty(mods)) {
            for (IRetailPriceModifier cMod : mods) {
                if (cMod.getDealId().equals(deal.getDealId())) {
                    mod = cMod;
                    mod.setVoid(false);
                    newMod = false;
                }
            }
        }
        // Fallback to creating the modifier if it doesn't exist.
        if (newMod) {
            mod = createObject(IRetailPriceModifier.class);
            mod.setDealId(deal.getDealId());
        }
        //Modify deal mount
        BigDecimal amount = (saleLine.getReturn()) ? argPred.getAmountBrokered().negate() : argPred.getAmountBrokered();
        BigDecimal dealAmt = (saleLine.getReturn()) ? argPred.getDealAmount().negate() : argPred.getDealAmount();
        BigDecimal baseDealAmt = (saleLine.getReturn()) ? argPred.getDealAmount().negate() : argPred.getDealAmount();
        /* Begin BZ28014 Check the multiples apply of a coupon*/
        Map<String, BigDecimal> allowApply = CawMultipleDealMap.getInstance().getMultiApply();
        if (allowApply != null && allowApply.containsKey(deal.getDealId())) {
            amount = amount.multiply(allowApply.get(deal.getDealId()));
            dealAmt = dealAmt.multiply(allowApply.get(deal.getDealId()));
        }
        /* End BZ28014 Check the multiples apply of a coupon*/
        BigDecimal baseAmount = (getDisplayProportionDealAmt()) ? dealAmt : amount;

        if (mod != null) {
            /* (stinyaev 3/13/2012) increment discount amount instead of resetting it to prevent a case where single
             * line (qty > 1) that participates several times in same deal (contains qualifying and award items at the
             * same time) gets overwritten. Why? because deal engine actually returns a deal discount for each item
             * even if it is 0.00$. */
            mod.setTaxabilityCode(deal.getTaxabilityCode());
            mod.setRetailPriceModifierReasonCode(deal.getReason().getName());
            mod.setAmount(nonNull(mod.getAmount()).add(baseAmount));
            mod.setExtendedAmount(nonNull(mod.getExtendedAmount()).add(baseAmount));
            mod.setDealAmount(nonNull(mod.getDealAmount()).add(baseDealAmt));
            mod.setPriceChangeAmount((deal.getReason().isOverride()) ? saleLine.getUnitPrice() : ZERO);
            mod.setNotes(deal.getDescription());
            mod.setDescription(deal.getDescription());

            if (argIsTransDeal) {
                /* Only associate the deal line with this modifier if this is a transaction-wide deal. Why? Because
                 * pre-5.0 we only ever had deal lines for transaction-wide deals, and now we're carrying around
                 * transient lines to represent line-level deals so that we can attach the serialized coupon ID to them.
                 * Just trying to preserve legacy behavior/assumptions here. */
                mod.setReasonLineItem(argDealLine);
            }
            final String couponId = argDealLine.getStringProperty(COUPON_ID_PROPERTY);
            if (couponId != null) {
                mod.setSerialNumber(couponId);
            }
            if (newMod) {
                saleLine.addRetailPriceModifier(mod);

                if (_tabHelper.isPresent()) {
                    long voidedDealCouponMods = saleLine.getRetailPriceModifiers().stream() //
                            .filter(p -> p.getVoid()) //
                            .filter(p -> RetailPriceModifierReasonCode.DEAL
                                    .matches(p.getRetailPriceModifierReasonCode())) //
                            .filter(p -> p.getSerialNumber() != null) //
                            .count();
                    if ((newMod && mod.getSerialNumber() != null)
                            || (mod.getSerialNumber() == null && voidedDealCouponMods > 0)) {
                        _tabHelper.get().setTabUpdated("TRANSACTION_COUPONS");
                    }
                }
            }
            /* BEGIN BZ31793 */
            CawMultipleDealMap.getInstance().putToPreDealUnitPriceMap(mod.getDealId()
                    + String.valueOf(saleLine.getLineItemSequence()), saleLine.getUnitPrice());
            /* END BZ31793 */
        }
        BigDecimal unitPrice = saleLine.getUnitPrice().subtract(baseAmount.divide(saleLine.getQuantity(), 6, HALF_UP));
        saleLine.setUnitPrice((!saleLine.getReturn() && isNegative(unitPrice)) ? ZERO : unitPrice);
    }
}
