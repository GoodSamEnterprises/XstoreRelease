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
 *===================================================================
 */

package caw.pos.coupon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.pricing.CawMultipleDealMap;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.coupon.CouponType;
import dtv.pos.coupon.CouponUtil;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.dsc.ICoupon;
import dtv.xst.dao.prc.DealId;
import dtv.xst.dao.prc.IDeal;
import dtv.xst.dao.trl.ICouponLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawValidateDealCouponOnTransactionRule extends AbstractValidationRule {

    @Inject
    private TransactionScope _transactionScope;

    /* Check duplicate coupon and setting the times it applied.
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        ICoupon coupon = getScopedValue(ValueKeys.CURRENT_COUPON);
        CouponType couponType = CouponUtil.getCouponType(coupon);

        if (CouponType.DEAL.equals(couponType)) {
            IPosTransaction transaction = _transactionScope.getTransaction();
            Map<String, BigDecimal> multiApply = null;
            BigDecimal applyTimes = null;

            if (transaction != null) {
                for (ICouponLineItem couponLine : transaction.getLineItems(ICouponLineItem.class)) {
                    // The coupon id on the line item is a full serial number; the number on the coupon itself
                    // may just be a prefix for a series of coupons. Hence, we use startsWith instead of equals.
                    if (!couponLine.getVoid() && couponLine.getCouponId().startsWith(coupon.getCouponSerialNumber())) {
                        /* If it is allowed then marking times applied */
                        if (isAllow(coupon.getCouponSerialNumber())) {
                            /*Init the scope for multiple application coupon*/
                            multiApply = CawMultipleDealMap.getInstance().getMultiApply();
                            applyTimes = multiApply.get(couponLine.getCouponId());
                            /*Pass this step for serialized coupon, we will take care it here: CawEnterCouponSerialScreenOp*/
                            if (!coupon.getSerialized()) {
                                if (applyTimes == null) {
                                    applyTimes = BigDecimal.ONE;
                                }
                                applyTimes = applyTimes.add(BigDecimal.ONE);
                            }
                            CawMultipleDealMap.getInstance().putToMultipleDealMap(couponLine.getCouponId(), applyTimes);
                            break;
                        } else {
                            return SimpleValidationResult.getFailed("_couponDealCouponAlreadyPresent");
                        }
                    }
                }
            }
        }
        return IValidationResult.SUCCESS;
    }

    /**
     * Check deal's setting if It is allowed for multiple application
     * @param argDealId
     * @return
     */
    private boolean isAllow(String argDealId) {

        DealId dealId = new DealId();
        dealId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        dealId.setDealId(argDealId);
        /*This logic will prevent Xstore call SQL many times*/
        IDeal deal = DataFactory
                .getObjectByIdFromList(dealId, new ArrayList<>(CawMultipleDealMap.getInstance().getDealUsed()));
        if (deal == null) {
            deal = DataFactory.getObjectByIdNoThrow(dealId);
        }
        if (deal != null) {
            CawMultipleDealMap.getInstance().putToUsedDeal(deal);
            return deal.getBooleanProperty(CawConstants.CAW_ALLOW_MULTIPLE_DEAL);
        }
        return false;
    }
}
