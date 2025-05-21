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
 * BZ43207          221121    [Requirement] Add ability to reject at the item level for BOPIS
 * BZ47443          261121    [Internal patch 7.0.16] Partial Cancel - Wrong request sent to Order Service when partially cancelled an item in BOPIS order
 * BZ47730          161221    Blank Error When Attempting to Partial Cancel an Order
 * BZ47909          291221    Patch 15- Partial Cancel Incorrect price on Receipt and Screen
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.*;
import dtv.pos.shippingfee.config.Configurations;
import dtv.pos.spring.ValueKeys;
import dtv.util.NumberUtils;
import dtv.util.StringUtils;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.*;

public class CawCancelOrderOp extends CancelOrderOp {
    @Inject
    private OrderMgr _orderMgr;
    @Inject
    private OrderUtil _orderUtil;
    private static final Logger _logger = LogManager.getLogger(CawCancelOrderOp.class);
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        
        if (this.getScopedValue(CawValueKeys.IS_PARTIAL_CANCEL_ORDER) != null
                && this.getScopedValue(CawValueKeys.IS_PARTIAL_CANCEL_ORDER)) {
            
            IOrder currentOrder = this._orderMgr.getCurrentOrder();
            List<IOrderLine> orderLinesResult = new ArrayList<IOrderLine>();
            orderLinesResult = currentOrder.getOrderLines();
            
            IReasonCode reasonCode = this.getScopedValue(ValueKeys.SELECTED_REASON_CODE);

            List<BigDecimal> partialUpdateQtys = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY);
            List<IOrderLine> linesProcessToCancel = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
            List<IOrderLine> linesToCancel = updateQtyOrderLine(linesProcessToCancel, partialUpdateQtys);
            
            //Initial base parameter
            BigDecimal cancelledAmount = BigDecimal.ZERO;
            BigDecimal cancelledItemsTotalTax = BigDecimal.ZERO;
            BigDecimal cancelledItemSubTotalAmount = BigDecimal.ZERO;
            BigDecimal cancelledShippingFeeAmount = BigDecimal.ZERO;
            BigDecimal cancelledShippingFeeTaxAmount = BigDecimal.ZERO;
            BigDecimal balanceDue = BigDecimal.ZERO;
            
            List<IOrderLine> cancellableItemList = this._orderUtil.getCancellableItemList(currentOrder,
                    this._stationState.getRetailLocationId());
            List<IOrderLine> nonCancellableItemList = this._orderUtil.getNonCancellableItemList(currentOrder);
            boolean refundCancelledShippingFee = nonCancellableItemList.isEmpty()
                    && (linesToCancel.size() == cancellableItemList.size() || cancellableItemList.isEmpty());
            List<BigDecimal> orderLineQtys = this.getScopedValue(CawValueKeys.CAW_ORDER_QUANTITIES);
            
            Iterator<IOrderLine> line = linesToCancel.iterator();
            int orderLineCancelIndex = 0;
            int lastSequence = 0;
            
            //BEGIN BZ47730
            for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                lastSequence = Math.max(lastSequence, orderLine.getSequence());                
            }
            //END BZ47730
            while (line.hasNext()) {       
                IOrderLine originalLine = line.next();
                BigDecimal originalQuantity = orderLineQtys.get(orderLineCancelIndex) != null ? orderLineQtys.get(orderLineCancelIndex):BigDecimal.ZERO;

                if (originalQuantity.compareTo(originalLine.getQuantity()) > 0) {
                    //Pre-pare new sequence for new cancel Order Line
                    lastSequence = lastSequence + 1;     
                    cancelledAmount = cancelledAmount.add(originalLine.getUnitPrice().multiply(originalLine.getQuantity())).setScale(2, ConfigurationMgr.getLocalCurrencyRoundingMode());

                    //Create the new cancel Order Line
                    IOrderLine orderLine = DataFactory.createObject(IOrderLine.class);                
                    orderLine = this.createCancelledOrderLine(originalLine, lastSequence, originalQuantity, OrderLineStatus.CANCELLED.getName());

                    //Set extendedPrice, tax amount, quantity for original Order Line
                    BigDecimal originalExtendedPrice = originalLine.getExtendedPrice().subtract(orderLine.getExtendedPrice());
                    BigDecimal originalTaxAmount = originalLine.getTaxAmount().subtract(orderLine.getTaxAmount());
                    
                    originalLine.setExtendedPrice(originalExtendedPrice);
                    originalLine.setTaxAmount(originalTaxAmount);
                    originalLine.setQuantity(originalQuantity.subtract(orderLine.getQuantity()));
                    
                    //Include VAT tax
                    boolean taxInclusive = StringUtils.equivalentIgnoreCase(orderLine.getTaxType(), "VatTax");
                                    
                    if (!taxInclusive) {
                        cancelledAmount = cancelledAmount.add(orderLine.getTaxAmount());
                    }
                    
                    //Include Item amount
                    cancelledItemSubTotalAmount = cancelledItemSubTotalAmount.add(orderLine.getExtendedPrice());
                    cancelledItemsTotalTax = cancelledItemsTotalTax.add(orderLine.getTaxAmount());
                    
                    //Include reason code
                    if (reasonCode != null) {
                        orderLine.setStatusCodeReason(reasonCode.getReasonCode());
                        orderLine.setStatusCodeReasonNote(reasonCode.getDescription());
                    }
                    
          
                    boolean adjustReceivedInventory = OrderUtils.isShippingNecessary(orderLine)
                            && OrderLineStatus.RECEIVED.getName().equals(orderLine.getStatusCode());                
                    this.addCancelledSaleItem(orderLine, adjustReceivedInventory);
                    
                    
                    for (IOrderLine orderLineResult : orderLinesResult) {
                        if (originalLine.getSequence() == orderLineResult.getSequence()) {
                            orderLineResult = originalLine;
                        }
                    }
                                                   
                    //Create Balance Modifier
                    List<IBalanceModifier> balanceArr = originalLine.getBalanceModifiers();
                    balanceArr.get(0).setAmount(originalLine.getExtendedPrice().add(originalLine.getTaxAmount()));

                    IBalanceModifier refundModifier = DataFactory.createObject(IBalanceModifier.class);
                    refundModifier.setTypeCode(PaymentType.REFUND.getName());
                    IBalanceModifier depositModifier = DataFactory.createObject(IBalanceModifier.class);
                    depositModifier.setTypeCode(PaymentType.DEPOSIT.getName());
                    
                    BigDecimal refundAmt = orderLine.getExtendedPrice().add(orderLine.getTaxAmount());
                    
                    if ("PER_TRANSACTION".equals(Configurations.getOrderShippingFeeCalcType())) {
                        if (!refundCancelledShippingFee) {
                            IFeeModifier shipFeeModifier = OrderUtils.getShippingFee(orderLine);
                            if (shipFeeModifier != null) {
                                refundAmt = refundAmt.subtract(NumberUtils.nonNull(shipFeeModifier.getAmount()));
                                refundAmt = refundAmt.subtract(NumberUtils.nonNull(shipFeeModifier.getTaxAmount()));
                                shipFeeModifier.setAmount(BigDecimal.ZERO);
                                shipFeeModifier.setTaxAmount(BigDecimal.ZERO);
                            }
                        }
                    } else {
                        BigDecimal feeAmt = OrderUtils.getShippingFeeAmount(orderLine);
                        BigDecimal feeTaxAmt = OrderUtils.getShippingFeeTaxAmount(orderLine);
                        cancelledShippingFeeAmount = cancelledShippingFeeAmount.add(feeAmt);
                        cancelledShippingFeeTaxAmount = cancelledShippingFeeTaxAmount.add(feeTaxAmt);
                        cancelledAmount = cancelledAmount.add(feeAmt);
                        cancelledAmount = cancelledAmount.add(feeTaxAmt);
                        cancelledItemsTotalTax = cancelledItemsTotalTax.add(feeTaxAmt);
                    }

                    refundModifier.setAmount(refundAmt.negate());
                    depositModifier.setAmount(refundAmt);
                    
                    orderLine.addBalanceModifier(depositModifier);
                    orderLine.addBalanceModifier(refundModifier);
                    orderLinesResult.add(orderLine);
                    
                    //Increase index line to get original quantity
                    orderLineCancelIndex = orderLineCancelIndex + 1;
                }
                else {
                    boolean adjustReceivedInventory = OrderUtils.isShippingNecessary(originalLine)
                            && OrderLineStatus.RECEIVED.getName().equals(originalLine.getStatusCode());
                    cancelledAmount = cancelledAmount.add(originalLine.getExtendedPrice());
                    boolean taxInclusive = StringUtils.equivalentIgnoreCase(originalLine.getTaxType(), "VatTax");
                    if (!taxInclusive) {
                        cancelledAmount = cancelledAmount.add(originalLine.getTaxAmount());
                    }

                    cancelledItemSubTotalAmount = cancelledItemSubTotalAmount.add(originalLine.getExtendedPrice());
                    cancelledItemsTotalTax = cancelledItemsTotalTax.add(originalLine.getTaxAmount());
                    originalLine.setStatusCode(OrderLineStatus.CANCELLED.getName());
                    if (reasonCode != null) {
                        originalLine.setStatusCodeReason(reasonCode.getReasonCode());
                        originalLine.setStatusCodeReasonNote(reasonCode.getDescription());
                    }

                    this.addCancelledSaleItem(originalLine, adjustReceivedInventory);
                    
                    //List<IBalanceModifier> balanceArr = originalLine.getBalanceModifiers();
                    //balanceArr.get(0).setAmount(originalLine.getExtendedPrice().add(originalLine.getTaxAmount()));
                    
                    IBalanceModifier refundModifier = DataFactory.createObject(IBalanceModifier.class);
                    refundModifier.setTypeCode(PaymentType.REFUND.getName());
                    
                    BigDecimal refundAmt = originalLine.getExtendedPrice().add(originalLine.getTaxAmount());
                    
                    if ("PER_TRANSACTION".equals(Configurations.getOrderShippingFeeCalcType())) {
                        if (!refundCancelledShippingFee) {
                            IFeeModifier shipFeeModifier = OrderUtils.getShippingFee(originalLine);
                            if (shipFeeModifier != null) {
                                refundAmt = refundAmt.subtract(NumberUtils.nonNull(shipFeeModifier.getAmount()));
                                refundAmt = refundAmt.subtract(NumberUtils.nonNull(shipFeeModifier.getTaxAmount()));
                                shipFeeModifier.setAmount(BigDecimal.ZERO);
                                shipFeeModifier.setTaxAmount(BigDecimal.ZERO);
                            }
                        }
                    } else {
                        BigDecimal feeAmt = OrderUtils.getShippingFeeAmount(originalLine);
                        BigDecimal feeTaxAmt = OrderUtils.getShippingFeeTaxAmount(originalLine);
                        cancelledShippingFeeAmount = cancelledShippingFeeAmount.add(feeAmt);
                        cancelledShippingFeeTaxAmount = cancelledShippingFeeTaxAmount.add(feeTaxAmt);
                        cancelledAmount = cancelledAmount.add(feeAmt);
                        cancelledAmount = cancelledAmount.add(feeTaxAmt);
                        cancelledItemsTotalTax = cancelledItemsTotalTax.add(feeTaxAmt);
                    }

                    refundModifier.setAmount(refundAmt.negate());
                    originalLine.addBalanceModifier(refundModifier);
                    
                    for (IOrderLine orderLineResult : orderLinesResult) {
                        if (originalLine.getSequence() == orderLineResult.getSequence()) {
                            orderLineResult = originalLine;
                        }
                    }
                    orderLineCancelIndex = orderLineCancelIndex + 1;
                }
            }
            
            if ("PER_TRANSACTION".equals(Configurations.getOrderShippingFeeCalcType())) {
                if (refundCancelledShippingFee) {
                    cancelledShippingFeeAmount = OrderUtils.getShippingFeeAmount(currentOrder);
                    cancelledShippingFeeTaxAmount = OrderUtils.getShippingFeeTaxAmount(currentOrder);
                    cancelledAmount = cancelledAmount.add(cancelledShippingFeeAmount);
                    cancelledAmount = cancelledAmount.add(cancelledShippingFeeTaxAmount);
                    cancelledItemsTotalTax = cancelledItemsTotalTax.add(cancelledShippingFeeTaxAmount);
                } else {
                    List<IOrderLine> distributionItemList = new ArrayList<IOrderLine>();
                    if (!cancellableItemList.isEmpty() && cancellableItemList.size() > linesToCancel.size()) {
                        Iterator<IOrderLine> var23 = cancellableItemList.iterator();

                        while (var23.hasNext()) {
                            IOrderLine lineItem = var23.next();
                            if (!lineItem.getStatusCode().equals(OrderLineStatus.CANCELLED.getName())
                                    && !lineItem.getVoid()) {
                                distributionItemList.add(lineItem);
                            }
                        }
                    }

                    distributionItemList.addAll(nonCancellableItemList);
                    if (!distributionItemList.isEmpty()) {
                        this._orderUtil.prorateShippingFee(currentOrder, distributionItemList);
                    }
                }
            }
            
            currentOrder.addOrderRefund(true);
            currentOrder.setCancelledItemsSubTotalAmt(
                    NumberUtils.nonNull(currentOrder.getCancelledItemsSubTotalAmt()).add(cancelledItemSubTotalAmount));
            currentOrder.setCancelledItemsTotalAmt(
                    NumberUtils.nonNull(currentOrder.getCancelledItemsTotalAmt()).add(cancelledAmount));
            currentOrder.setCancelledItemsTotalTax(
                    NumberUtils.nonNull(currentOrder.getCancelledItemsTotalTax()).add(cancelledItemsTotalTax));
            if (reasonCode != null) {
                currentOrder.setStatusCodeReason(reasonCode.getReasonCode());
                currentOrder.setStatusCodeReasonNote(reasonCode.getDescription());
            }

            currentOrder.setOrderLines(orderLinesResult);
                        
            currentOrder.setBalanceDue(balanceDue);
            
            this.setScopedValue(CawValueKeys.IS_PARTIAL_CANCEL_ORDER, false);
            return this.HELPER.completeResponse(); 
        }
        else {
            return super.handleOpExec(argEvent);
        }
    }

    /**
     * @param argOrderLine
     * @param argNewSequence
     */
    private IOrderLine createCancelledOrderLine(IOrderLine argOriginalOrderLine,
            int argLastSequence, BigDecimal argOriginalQuantity, String argOrderLineStatus) {
        
        /*insert a line into table xom_order_line*/
        IOrderLine orderLineCancel = this.createOrderLine(argOriginalOrderLine, argLastSequence, argOriginalQuantity, argOrderLineStatus);
        
        
        /*insert a line into table xom_source_mod*/
        ISourceModifier sourceModifier = this.createSourceModifier(argOriginalOrderLine, argLastSequence);
        orderLineCancel.setSourceModifier(sourceModifier);

        /*insert a line into table xom_fulfillment_mod*/
        IFulfillmentModifier fulfillmentModifier = this.createFulfillmentModifier(argOriginalOrderLine, argLastSequence);
        orderLineCancel.setFulfillmentModifier(fulfillmentModifier);
        
        /*insert a line into table xom_item_mod*/
        IItemModifier itemModifier = this.createItemModifier(argOriginalOrderLine, argLastSequence);
        orderLineCancel.setItem(itemModifier);
        
        ((IDataModelImpl) orderLineCancel).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
                
        return orderLineCancel;
    }

    /**
     * @param argOriginalOrderLine
     * @param argLastSequence
     * @return
     */
    private IItemModifier createItemModifier(IOrderLine argOriginalOrderLine,
            int argLastSequence) {

        ItemModifierId itemModifierId = new ItemModifierId();
        itemModifierId.setOrderId(argOriginalOrderLine.getOrderId());
        itemModifierId.setOrganizationId(argOriginalOrderLine.getOrganizationId());
        
        itemModifierId.setSequence(argLastSequence);
        
        IItemModifier itemModifier = DataFactory.createObject(itemModifierId, IItemModifier.class);
        itemModifier.setItemId(argOriginalOrderLine.getItem().getItemId());
        itemModifier.setDescription(argOriginalOrderLine.getItem().getDescription());
        itemModifier.setImageUrl(argOriginalOrderLine.getItem().getImageUrl());
        ((IDataModelImpl) itemModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return itemModifier;
    }

    /**
     * @param argOriginalOrderLine
     * @param argLastSequence
     * @return
     */
    private IFulfillmentModifier createFulfillmentModifier(
            IOrderLine argOriginalOrderLine, int argLastSequence) {

        FulfillmentModifierId fulfillmentModifierId = new FulfillmentModifierId();
        fulfillmentModifierId.setOrderId(argOriginalOrderLine.getOrderId());
        fulfillmentModifierId.setOrganizationId(argOriginalOrderLine.getOrganizationId());
        fulfillmentModifierId.setSequence(argLastSequence);
        
        IFulfillmentModifier fulfillmentModifier = DataFactory.createObject(fulfillmentModifierId, IFulfillmentModifier.class);
        
        fulfillmentModifier.setAddress(argOriginalOrderLine.getFulfillmentModifier().getAddress());
        fulfillmentModifier.setAddressSequence(argOriginalOrderLine.getFulfillmentModifier().getAddressSequence());
        fulfillmentModifier.setLocationId(argOriginalOrderLine.getFulfillmentModifier().getLocationId());
        fulfillmentModifier.setLocationName1(argOriginalOrderLine.getFulfillmentModifier().getLocationName1());
        fulfillmentModifier.setLocationName2(argOriginalOrderLine.getFulfillmentModifier().getLocationName2());
        fulfillmentModifier.setTelephone1(argOriginalOrderLine.getFulfillmentModifier().getTelephone1());
        fulfillmentModifier.setEmailAddress(argOriginalOrderLine.getFulfillmentModifier().getEmailAddress());
        ((IDataModelImpl)fulfillmentModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return fulfillmentModifier;
    }

    /**
     * @param argOriginalOrderLine
     * @param argLastSequence
     * @return
     */
    private ISourceModifier createSourceModifier(
            IOrderLine argOriginalOrderLine, int argLastSequence) {

        SourceModifierId sourceModifierId = new SourceModifierId();
        sourceModifierId.setOrderId(argOriginalOrderLine.getOrderId());
        sourceModifierId.setOrganizationId(argOriginalOrderLine.getOrganizationId());
        sourceModifierId.setSequence(argLastSequence);
        
        ISourceModifier sourceModifier = DataFactory.createObject(sourceModifierId, ISourceModifier.class);
        
        sourceModifier.setAddress(argOriginalOrderLine.getSourceModifier().getAddress());
        sourceModifier.setAddressSequence(argOriginalOrderLine.getSourceModifier().getAddressSequence());
        sourceModifier.setLocationId(argOriginalOrderLine.getSourceModifier().getLocationId());
        sourceModifier.setLocationType(argOriginalOrderLine.getSourceModifier().getLocationType());
        sourceModifier.setLocationName1(argOriginalOrderLine.getSourceModifier().getLocationName1());
        sourceModifier.setLocationName2(argOriginalOrderLine.getSourceModifier().getLocationName2());
        sourceModifier.setTelephone1(argOriginalOrderLine.getSourceModifier().getTelephone1());
        ((IDataModelImpl)sourceModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return sourceModifier;
    }

    /**
     * @param argLastSequence
     * @param argOrderLine
     * @param argOrderLineStatus
     * @return
     */
    private IOrderLine createOrderLine(IOrderLine argOriginalOrderLine,
            int argLastSequence, BigDecimal argOriginalQuantity, String argOrderLineStatus) {

        OrderLineId orderLineId = new OrderLineId();
        orderLineId.setOrderId(argOriginalOrderLine.getOrderId());
        orderLineId.setOrganizationId(argOriginalOrderLine.getOrganizationId());
        orderLineId.setSequence(argLastSequence);
        
        IOrderLine orderLineCancel = DataFactory.createObject(orderLineId, IOrderLine.class);
        
        orderLineCancel.setExtendedPrice(argOriginalOrderLine.getUnitPrice().multiply(argOriginalOrderLine.getQuantity()).setScale(2, ConfigurationMgr.getLocalCurrencyRoundingMode()));        
        orderLineCancel.setQuantity(argOriginalOrderLine.getQuantity());        
        orderLineCancel.setUnitPrice(argOriginalOrderLine.getUnitPrice());
        orderLineCancel.setLineNumber(argOriginalOrderLine.getLineNumber());
        orderLineCancel.setItemId(argOriginalOrderLine.getItemId());
        orderLineCancel.setItem(argOriginalOrderLine.getItem());
        orderLineCancel.setExternalOrderId(argOriginalOrderLine.getExternalOrderId());
        orderLineCancel.setFulfillmentType(argOriginalOrderLine.getFulfillmentType());
        orderLineCancel.setStatusCode(argOrderLineStatus);        
        orderLineCancel.setTaxAmount(argOriginalOrderLine.getTaxAmount().divide(argOriginalQuantity, 6, ConfigurationMgr.getLocalCurrencyRoundingMode()).multiply(argOriginalOrderLine.getQuantity()).setScale(2, ConfigurationMgr.getLocalCurrencyRoundingMode()));       
        orderLineCancel.setSelectedShipMethod(argOriginalOrderLine.getSelectedShipMethod());
        orderLineCancel.setExtendedFreight(argOriginalOrderLine.getExtendedFreight());
        orderLineCancel.setCustomizationCharge(argOriginalOrderLine.getCustomizationCharge());
        orderLineCancel.setShipWeight(argOriginalOrderLine.getShipWeight());
        
        // BEGIN BZ47909
        try {
            String oriOrderLineProperty = argOriginalOrderLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE);
            if (!StringUtils.isEmpty(oriOrderLineProperty)) {
                JSONObject jsonOrderLineProperty = new JSONObject(oriOrderLineProperty);
                if (jsonOrderLineProperty.has(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO)
                        && jsonOrderLineProperty.has(CawConstants.CAW_OB_LINE_NO)) {
                    int reqSysLineNo = jsonOrderLineProperty.getInt(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO);
                                        
                    String value = "{requesting_system_line_no:" + reqSysLineNo + "}";
                    IOrderLineProperty orderLineProperty = DataFactory.createObject(IOrderLineProperty.class);
                    
                    orderLineProperty.setOrganizationId(orderLineCancel.getOrganizationId());
                    orderLineProperty.setSequence(orderLineCancel.getSequence());
                    orderLineProperty.setPropertyCode(CawConstants.CAW_OB_MAPPING_LINE);
                    orderLineProperty.setType("STRING");
                    orderLineProperty.setStringValue(value);
                    orderLineCancel.addOrderLineProperty(orderLineProperty);
                }
            }
        } catch (JSONException ex) {
            _logger.error("[Exception happen when get order line property]: "
                    + ex.getMessage());
        }

        // END BZ47909
        ((IDataModelImpl) orderLineCancel).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return orderLineCancel;
    }

    /**
     * @param argLinesToCancel
     * @param argPartialUpdateQtys
     * @return
     */
    private List<IOrderLine> updateQtyOrderLine(
            List<IOrderLine> argLinesProcessToCancel,
            List<BigDecimal> argPartialUpdateQtys) {
        
        List<IOrderLine> orderLinesToUpdate = new ArrayList<IOrderLine>();
        for (int i = 0; i < argLinesProcessToCancel.size(); ++i) {
            IOrderLine orderLine = argLinesProcessToCancel.get(i);
            BigDecimal updateQty = orderLine.getQuantity();
            if (argPartialUpdateQtys != null) {
                updateQty = argPartialUpdateQtys.get(i);
            }
            orderLine.setQuantity(updateQty);
            orderLinesToUpdate.add(orderLine);
        }
        return orderLinesToUpdate;
    }

}
