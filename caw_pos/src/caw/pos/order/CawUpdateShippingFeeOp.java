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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ38351          091020    [Internal] Xstore goes auto Authorizer Message prompt unexpected after Xstore receives exception shipping method about Item restricted
 * BZ38387          091020    [Internal] Xstore should not make a call Shipping API at Add tender button when doing Cancel Delivery_Order
 *===================================================================
 */

package caw.pos.order;

import static dtv.data2.access.DataFactory.createObject;
import static dtv.data2.access.DataFactory.getObjectById;
import static dtv.pos.common.ConfigurationMgr.getOrganizationId;
import static dtv.pos.order.OrderConstants.isShippingFeeOnDelayedPickup;
import static dtv.xst.dao.trl.RetailPriceModifierReasonCode.PROMPT_PRICE_CHANGE;
import static dtv.xst.dao.trl.SaleItemType.ORDER;
import static dtv.xst.xom.impl.order.FeeType.SHIPPING;
import static dtv.xst.xom.impl.order.OrderUtils.getShippingFee;
import static dtv.xst.xom.impl.order.OrderUtils.isShippingNecessary;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawUtilFunction;

import dtv.data2.access.IObjectId;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.ILocationFactory;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.hardware.IHardwareType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.*;
import dtv.pos.register.ItemLocator;
import dtv.pos.shippingfee.*;
import dtv.pos.shippingfee.config.ShipAccountType;
import dtv.pos.spring.ValueKeys;
import dtv.util.address.IAddress;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.ItemId;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.FulfillmentMethod;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawUpdateShippingFeeOp extends Operation {

    @Inject
    private OrderHelper      _orderHelper;

    @Inject
    private OrderMgr         _orderMgr;

    @Inject
    private ILocationFactory _locationFactory;

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IOpResponse reponse = null; //BZ38351
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        
        /* BEGIN BZ38351 */       
        if(CawOrderHelper.getInstance().isOrderLinesNotVoid(currentOrder)) { /* END BZ38351 */
            
            OrderType orderType = OrderType.forName(currentOrder.getOrderType());
            List<ShippableLineItem> shippableItems = getShippableItems(currentOrder);
    
            if (shippableItems.isEmpty()) {
                // There is no ship line in the order, remove its shipping fee. This can happen when a standard pickup
                // order is changed from shipping required to shipping not required.
                // remove shipping fee from the order
                removeCurrentShipFee(currentOrder);
            } else {
                // There are ship lines in the order. Calculate shipping fee for the ship lines
                ShippingFeeCalcResponse feeResponse = getShipFeeFromExternal(orderType, shippableItems);
    
                if (feeResponse.isSuccess()) {
                    updateShipFee(currentOrder, feeResponse);
                }
            }
            
            reponse = HELPER.completeResponse();
        } else {
            reponse = HELPER.silentErrorResponse();
        }

        return reponse;
    }


    /**
     * @param currentOrder
     * @return
     */
    private List<ShippableLineItem> getShippableItems(IOrder currentOrder) {

        List<ShippableLineItem> shipLines = new ArrayList<ShippableLineItem>();
   
        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
            FulfillmentMethod fulfillMethod = FulfillmentMethod.forName(orderLine.getFulfillmentType());
            boolean requiresShippingFee = fulfillMethod.isForDelivery() //
                    || (isShippingNecessary(orderLine)
                            && isShippingFeeOnDelayedPickup());
   
            if (!orderLine.getVoid() && requiresShippingFee
                    && (orderLine.getShadowedSaleItem() != null)) {
                ShippableLineItem shipLine = new ShippableLineItem(orderLine.getShadowedSaleItem());
                shipLine.setShipMethod(orderLine.getSelectedShipMethod());
                shipLines.add(shipLine);
            }
        }
        return shipLines;
    }


    /**
     * @param currentOrder
     * @param feeResponse
     */
    private void updateShipFee(IOrder currentOrder,
            ShippingFeeCalcResponse feeResponse) {

        IOrderFee shippingFee = getOrAddShippingFee(currentOrder, feeResponse.getShippingFeeItemID());
   
        shippingFee.setVoid(false);
        shippingFee.getShadowedSaleItem().setVoid(false);
        shippingFee.setAmount(feeResponse.getShippingFee());
        shippingFee.getShadowedSaleItem()
                .setUnitPrice(feeResponse.getShippingFee());
   
        for (IRetailPriceModifier modifier : shippingFee
                .getShadowedSaleItem().getRetailPriceModifiers()) {
            RetailPriceModifierReasonCode reason = RetailPriceModifierReasonCode
                    .forName(modifier
                            .getRetailPriceModifierReasonCode());
   
            if (!modifier.getVoid() && reason.isOverride()) {
                modifier.setPriceChangeAmount(feeResponse
                        .getShippingFee());
            }
        }
   
        Map<IObjectId, BigDecimal> feeMap = feeResponse
                .getItemToShipFee();
   
        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
            if (!orderLine.getVoid()
                    && (orderLine.getShadowedSaleItem() != null)) {
                IObjectId shadowedId = orderLine.getShadowedSaleItem()
                        .getObjectId();
                BigDecimal lineFee = feeMap.get(shadowedId);
                if (lineFee == null) {
                    // There are ship lines in the order, but this line does not require shipping. Remove its
                    // shipping fee.
                    IFeeModifier shippingFeeMod = getShippingFee(orderLine);
                    if (shippingFeeMod != null) {
                        orderLine.removeFeeModifier(shippingFeeMod);
                    }
                } else {
                    IFeeModifier shippingFeeMod = getOrAddShippingFeeModifier(orderLine);
                    shippingFeeMod.setAmount(lineFee);
                }
            }
        }
    }


    /**
     * 
     * @param orderType
     * @param shippableItems
     * @return
     */
    private ShippingFeeCalcResponse getShipFeeFromExternal(OrderType orderType, List<ShippableLineItem> shippableItems) {

        ShippingFeeCalcResponse feeResponse = null;
        
        IAddress destination = (orderType.isForDelivery()) //
                ? _orderMgr.getDeliveryInfo().getLocationAddress() //
                : _locationFactory.getStoreById(_stationState.getRetailLocationId());
   
        if (CawUtilFunction.allowEBSConnection()
                && orderType == OrderType.STANDARD_DELIVERY) {
            // get ship fee from ESB system
            feeResponse = CawShippingFeeHandler.getInstance()
                    .getShippingFee(null, destination, ShipAccountType.ORDER, shippableItems, _stationState.getRetailLocationId());
        } else {
            // get ship fee from Xstore database (base flow)
            feeResponse = ShippingFeeHandler.getInstance()
                    .getShippingFee(null, destination, ShipAccountType.ORDER, shippableItems, _stationState.getRetailLocationId());
        }
        return feeResponse;
    }


    /**
     * Remove shipping fee from order items.
     * @param currentOrder
     */
    private void removeCurrentShipFee(IOrder currentOrder) {

        IOrderFee shippingFee = getShippingFee(currentOrder);
        if (shippingFee != null) {
            shippingFee.getShadowedSaleItem().setVoid(true);
            currentOrder.removeOrderFee(shippingFee);
        }
        // remove shipping fee from each order line
        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
            if (!orderLine.getVoid()) {
                IFeeModifier shippingFeeMod = getShippingFee(orderLine);
                if (shippingFeeMod != null) {
                    orderLine.removeFeeModifier(shippingFeeMod);
                }
            }
        }
    }


    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {
        /* BEGIN BZ38387 */
        return CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
        /* END BZ38387 */
    }

    /**
     * Returns the Creates the appropriate shipping fee objects for <code>argOrder</code> and adds them to
     * current order and to the current transaction.
     *
     * @param argOrder the order to which a shipping fee should be added
     * @param argItemId the item id
     * @return the shipping fee object that was added to this <code>argOrder</code>
     */
    protected IOrderFee getOrAddShippingFee(IOrder argOrder, String argItemId) {

        IOrderFee shippingFee = getShippingFee(argOrder);

        if (shippingFee == null) {
            IPosTransaction trans = _transactionScope.getTransaction();
            shippingFee = createObject(IOrderFee.class);
            shippingFee.setTypeCode(SHIPPING.getName());
            shippingFee.setItemId(argItemId);
            argOrder.addOrderFee(shippingFee);

            IHardwareType<?> automaticEntry = ItemLocator.getLocator().getAutomaticEntryMethod();

            ItemId id = new ItemId();
            id.setOrganizationId(getOrganizationId());
            id.setItemId(argItemId);
            IItem item = (IItem) getObjectById(id);

            ISaleReturnLineItem shippingFeeLine = ItemLocator.getLocator()
                    .getSaleLineItem(item, ORDER, true, automaticEntry);

            // Create a price override modifier so the price is not reset later
            IRetailPriceModifier priceModifier = createObject(IRetailPriceModifier.class);
            priceModifier.setPriceChangeAmount(ZERO);
            priceModifier.setRetailPriceModifierReasonCode(PROMPT_PRICE_CHANGE.getName());
            shippingFeeLine.addRetailPriceModifier(priceModifier);

            IOrderModifier orderMod = _orderHelper
                    .createOrderModifier(shippingFee, argOrder.getOrderType(), null);
            shippingFeeLine.setOrderModifier(orderMod);

            shippingFee.setShadowedSaleItem(shippingFeeLine);

            trans.addRetailTransactionLineItem(shippingFeeLine);

            // Calculate the tax due on this item. This is the most straightforward way, although I
            // admit it is a bit unorthodox for Xstore to instantiate an operation within another one.
            setScopedValue(ValueKeys.CURRENT_SALE_LINE, shippingFeeLine);
            clearScopedValue(ValueKeys.CURRENT_ORDER_LINE);
            CalculateOrderLineTaxOp taxOp = new CalculateOrderLineTaxOp();
            taxOp.handleOpExec(null);
        }

        return shippingFee;
    }

    /**
     * Returns the shipping fee modifier for <code>argOrderLine</code>. If one does not exist, it creates one
     * and adds it to <code>argOrderLine</code> before returning.
     *
     * @param argOrderLine the order line
     * @return the shipping fee modifier object that was added to this <code>argOrder</code>
     */
    protected IFeeModifier getOrAddShippingFeeModifier(IOrderLine argOrderLine) {

        IFeeModifier shippingFeeMod = getShippingFee(argOrderLine);

        if (shippingFeeMod == null) {
            shippingFeeMod = createObject(IFeeModifier.class);
            shippingFeeMod.setTypeCode(SHIPPING.getName());
            argOrderLine.addFeeModifier(shippingFeeMod);
        }

        return shippingFeeMod;
    }
}
