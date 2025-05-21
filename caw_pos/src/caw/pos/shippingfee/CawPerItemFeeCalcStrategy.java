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
 * BZ38022          210920    [Task] Xstore should use ServiceLevel of shipping method already selected into Xstore to parse data to OB during doing Delivery Order transaction.
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 *===================================================================
 */

package caw.pos.shippingfee;

import static dtv.util.ObjectUtils.coalesce;

import java.math.BigDecimal;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.order.CawShippingFeeHandler;

import dtv.data2.access.IObjectId;
import dtv.pos.shippingfee.*;
import dtv.pos.shippingfee.aggregation.IAggregation;
import dtv.xst.dao.com.IShippingFeeTier;

/**
 *
 */
public class CawPerItemFeeCalcStrategy extends PerItemFeeCalcStrategy {

    private static final Logger _logger = LogManager.getLogger(CawPerItemFeeCalcStrategy.class);

    /** {@inheritDoc} */
    @Override
    public ShippingFeeCalcResponse calculateShippingFee(
            List<IShippingFeeTier> argShippingFeeTiers,
            ShippingFeeCalcRequest argRequest, IAggregation argAggregation,
            String argShippingFeeItemId) {

        ShippingFeeCalcResponse response = new ShippingFeeCalcResponse();

        if ((argRequest == null) 
                || (argAggregation == null)
                || (argShippingFeeTiers == null)
                || (argShippingFeeTiers.size() == 0)) {
            response.setSuccess(false);
        } else {
            String shippingFeeType = null;
            Map<IObjectId, BigDecimal> itemToShipFee = new HashMap<IObjectId, BigDecimal>();
            for (ShippableLineItem lineItem : argRequest.getItems()) {
                BigDecimal subtotal = getExtendedPrice(lineItem);
                String itemId = lineItem.getLineItem().getItemId();
                String shipMethod = coalesce(lineItem.getShipMethod(), argRequest.getShipMethod());
                IShippingFeeTier selectedTier = ShippingFeeApplicabilityHelper
                        .getFirstAppplicableTier(argRequest, argShippingFeeTiers, 
                                subtotal, shipMethod, itemId); // BZ38022
                // if no applicable tier found, cancel fee calculation
                if (selectedTier == null) {
                    response.setSuccess(false);
                    break;
                }
                if (_logger.isDebugEnabled()) {
                    _logger.debug("[Shipping Fee] selected shipping tier for item: " + lineItem.getLineItem().getItemDescription() + ", $" + subtotal + ": " + selectedTier);
                }
                // take first item's fee type as the fee type reported for the group in the response
                if (shippingFeeType == null) {
                    shippingFeeType = selectedTier.getFeeType();
                }

                BigDecimal itemShippingFee = FeeTypeHelper.getShippingFee(selectedTier.getFeeValue(), selectedTier
                                .getFeeType(), subtotal, argShippingFeeItemId);
                // GET AND UPDATE PRICE FROM API
                /* BEGIN BZ37912 */
                BigDecimal priceFromApi = CawShippingFeeHandler.getInstance()
                        .getShippingFeePrice(shipMethod, itemId);
                /* END BZ37912 */
                if (priceFromApi != null
                        && (priceFromApi.compareTo(BigDecimal.ZERO) != 0)) {
                    itemShippingFee = priceFromApi;
                }
                // END TO GET AND UPDATE PRICE FROM API
                argAggregation.addValue(itemShippingFee);
                // if the aggregation does not require prorated shipping fee tracking then assign this fee to this
                // item
                if (!argAggregation.isProratedAggregation()) {
                    itemToShipFee.put(lineItem.getLineItem()
                            .getObjectId(), itemShippingFee);
                }
            }
            if (response.isSuccess() && argAggregation.isProratedAggregation()) {
                response.setItemToShipFee(getSplitItemFeeMap(argAggregation.getAggregateValue(), argRequest.getItems()));
            } else if (response.isSuccess()) {
                response.setItemToShipFee(itemToShipFee);
            }
            if (response.isSuccess()) {
                response.setShippingFeeType(shippingFeeType);
                /* BEGIN BZ37912 */
                HashMap<String, BigDecimal> hashOrderShippingFee = CawGetListsShippingFee.getTotalOrderShippingFee();

                BigDecimal totalOrderShippingFee = CawShippingFeeHandler.getInstance().getTotalOrderShippingFeeByGroup(hashOrderShippingFee);

                response.setShippingFee(totalOrderShippingFee);
                /* END BZ37912 */
            }
        }

        return response;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {

        return "PER_ITEM";
    }

    /**
     * Returns a map of shippable line item ids to shipping fees, where the shipping fee of each item is an
     * equal protion of the provided total shipping fee.
     * @param argShippingFee the total shipping fee to be split evenly between each item in argItems
     * @param argItems a collection of items
     * @return a map of shippable line items to shipping fees
     */
    private Map<IObjectId, BigDecimal> getSplitItemFeeMap(
            BigDecimal argShippingFee, List<ShippableLineItem> argItems) {

        Map<IObjectId, BigDecimal> itemToShipFee = new HashMap<IObjectId, BigDecimal>();
        loadItemToShipFeeMapWithProratedFee(itemToShipFee, argItems, argShippingFee);
        return itemToShipFee;
    }
}
