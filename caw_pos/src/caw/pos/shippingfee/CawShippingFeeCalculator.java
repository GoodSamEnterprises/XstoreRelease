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
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 *===================================================================
 */

package caw.pos.shippingfee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.shippingfee.*;
import dtv.pos.shippingfee.aggregation.AggregationHelper;
import dtv.pos.shippingfee.aggregation.IAggregation;
import dtv.util.StringUtils;
import dtv.xst.dao.com.IShippingFee;

/**
 *
 */
public class CawShippingFeeCalculator implements IShippingFeeCalculator {

    private static final Logger     _logger            = LogManager.getLogger(CawShippingFeeCalculator.class);

    private IShippingFeeRulesConfig shipFeeRulesConfig = null;

    /**
     * 
     */
    public CawShippingFeeCalculator(IShippingFeeRulesConfig argShippingFeeRulesConfig) {

        this.shipFeeRulesConfig = argShippingFeeRulesConfig;
    }

    /** {@inheritDoc} */
    @Override
    public ShippingFeeCalcResponse calculateShippingFee(ShippingFeeCalcRequest argRequest) {

        ShippingFeeCalcResponse response = new FailedShippingFeeCalcResponse();

        IFeeCalcStrategy feeCalcStrategy = new CawPerItemFeeCalcStrategy();

        _logger.debug("[Shipping Fee] selected strategy:" + feeCalcStrategy);

        IShippingFee applicableShippingFee = ShippingFeeApplicabilityHelper.getAppropriateShippingFee(argRequest, shipFeeRulesConfig);

        if (_logger.isDebugEnabled()) {
            _logger.debug("[Shipping Fee] selected shipping fee:" + applicableShippingFee);
        }

        if (applicableShippingFee != null) {
            IAggregation aggregation = AggregationHelper.getAggregation(applicableShippingFee.getAggregationType());

            if (_logger.isDebugEnabled()) {
                _logger.debug("[Shipping Fee] potential shipping fee tiers:" + StringUtils.join(applicableShippingFee.getTieredFees(), ", "));
                _logger.debug("[Shipping Fee] aggregation: " + aggregation);
            }

            response = feeCalcStrategy
                    .calculateShippingFee(applicableShippingFee.getTieredFees(), argRequest, 
                            aggregation, applicableShippingFee.getShipItemID());

            if (response.isSuccess()) {
                response.setShippingFeeItemID(applicableShippingFee.getShipItemID());
            }

            if (_logger.isDebugEnabled()) {
                _logger.debug("[Shipping Fee] " + response.toString());
            }
        }

        return response;
    }
}
