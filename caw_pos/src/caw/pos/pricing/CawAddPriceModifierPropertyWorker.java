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
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 * BZ32239          290719    [INTERNAL] Response message return error when return transactin that have serialized coupons
 * BZ33481          221019    [PROD] serialized coupon throwing blank error when trying to complete the transaction
 * BZ48699          040322    [PROD] Store 84 terminal 4 Issue - Unable to complete sale transaction
 *===================================================================
 */

package caw.pos.pricing;

import java.math.BigDecimal;
import java.util.*;
import javax.inject.Inject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import caw.pos.common.CawValueKeys;
import caw.pos.pricing.discount.CawDiscountCouponHelper;
import twitter4j.JSONObject;
import dtv.data2.access.DataPropertyUtils;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.worker.AbstractWorker;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailPriceModifier;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawAddPriceModifierPropertyWorker extends AbstractWorker {

    @Inject
    private TransactionScope        _transactionScope;

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    /*
     * Calculator discount amt for a serial and save as a price modifier property
     * @see dtv.pos.framework.worker.WorkerAdapter#performWorkImpl()
     */
    @Override
    protected void performWorkImpl() throws Exception {
        IPosTransaction transaction = _transactionScope.getTransaction();
        Map<String, List<JSONObject>> serialNumberActiveMaps = _transactionScope
                .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);
        Map<String, BigDecimal> preDealUnitPriceMap = CawMultipleDealMap.getInstance().getPreDealUnitPriceMap();

        if (MapUtils.isNotEmpty(serialNumberActiveMaps) && MapUtils.isNotEmpty(preDealUnitPriceMap)) { /*BZ33481*/
            if (transaction != null) {
                List<ISaleReturnLineItem> lineItems = transaction.getLineItems(ISaleReturnLineItem.class);
                lineItems.stream().forEach(lineItem -> {
                    lineItem.getRetailPriceModifiers().stream().forEach(lineModifier -> {
                        // Set merged serial
                        lineModifier.setSerialNumber(_cawDiscountCouponHelper
                                .getSerialNumber(lineModifier.getDealId(), serialNumberActiveMaps));
                        // Calculate discount amt for each serial
                        addPriceModifierProp(lineItem.getQuantity(), lineModifier, preDealUnitPriceMap
                                .get(lineModifier.getDealId()
                                        + String.valueOf(lineItem.getLineItemSequence())), lineModifier
                                                .getDealAmount());
                    });
                });
            }
        }
    }

    /**
     * @param mod
     * @param unitPrice
     * @param baseDealAmt
     */
    protected void addPriceModifierProp(BigDecimal itemQty, IRetailPriceModifier mod, BigDecimal preDealUnitPrice,
            BigDecimal baseDealAmt) {

        if (StringUtils.isNotEmpty(mod.getSerialNumber())
                && CawMultipleDealMap.getInstance().getMultiApply().containsKey(mod.getDealId())) { /*BZ33481*/
            String[] separatedSerials = mod.getSerialNumber().split("\\s*,\\s*");

            if (separatedSerials != null && separatedSerials.length > 0) {
                BigDecimal tmpValue = BigDecimal.ZERO;
                BigDecimal applyTime = BigDecimal.ZERO;
                int nbr = separatedSerials.length;

                for (int i = 0; i < nbr; i++) {
                    applyTime = BigDecimal.valueOf(i + 1);

                    // BEGIN BZ48699
                    if (preDealUnitPrice == null) {
                        if(mod.getExtendedAmount() != null) {
                            DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], mod.getExtendedAmount().negate());
                        }
                        continue;
                    }
                    // END BZ48699

                    tmpValue = preDealUnitPrice.multiply(itemQty).subtract(baseDealAmt.multiply(applyTime));
                    /*
                     * Check the actual amt is used. Ex:
                     * Item 50$, coupon A with serial 1, serial 2
                     * Apply 1st: serial 1 take 40$
                     * Apply 2nd: serial 2 take 10$
                     */
                    if (NumberUtils.isZero(tmpValue)) {
                        DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], baseDealAmt.negate()); /* BZ32239 */

                    } else if (NumberUtils.isPositive(tmpValue)) {
                        DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], baseDealAmt.negate()); /* BZ32239 */

                    } else {
                        if (tmpValue.abs().compareTo(preDealUnitPrice) < 0) {
                            DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], baseDealAmt
                                    .subtract(tmpValue.abs()).multiply(itemQty).negate()); /* BZ32239 */
                        /*BEGIN BZ33481*/
                        } else if (i < 1) {
                            // code will be run for case that amount of coupon is large than amount of item.
                            DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], baseDealAmt.negate());
                        /*END BZ33481*/
                        } else {
                            DataPropertyUtils.setPropertyValue(mod, separatedSerials[i], BigDecimal.ZERO);
                        }
                    }
                }
            }
        }
    }
}
