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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 * BZ46682          131021    [Internal] Partial Rejected items does not display on the Order Maintenance screen - BOPIS
 * BZ47443          261121    [Internal patch 7.0.16] Partial Cancel - Wrong request sent to Order Service when partially cancelled an item in BOPIS order
 * BZ47730          161221    Blank Error When Attempting to Partial Cancel an Order
 * BZ47909          291221    Patch 15- Partial Cancel Incorrect price on Receipt and Screen
 *===================================================================
 */

package caw.pos.order.maint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import javax.inject.Inject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderHelper;
import dtv.pos.order.OrderUtil;
import dtv.pos.order.maint.UpdateOrderStatusOp;
import dtv.pos.spring.ValueKeys;
import dtv.util.StringUtils;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.exceptions.NotSupportedInTrainingModeException;
import dtv.xst.xom.impl.order.OrderLineStatus;

/**
 *
 */
public class CawUpdateOrderStatusOp extends UpdateOrderStatusOp {

    private static final String NEW_STATUS = "NewStatus";

    private static final String REJECTED   = "REJECTED";

    private static final Logger _logger    = LogManager.getLogger(CawUpdateOrderStatusOp.class);

    private OrderLineStatus     _newStatus;

    @Inject
    private OrderUtil           _orderUtil;

    @Inject
    private OrderHelper         _orderHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        List<IOrderLine> orderLines = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
        List<BigDecimal> partialUpdateQtys = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY);
        this.setScopedValue(CawValueKeys.IS_REJECT_ORDER, Boolean.TRUE);
        IOrder currentOrder = this.getScopedValue(ValueKeys.SELECTED_ORDER);
        if (orderLines != null && orderLines.size() > 0) {
            List<IOrderLine> OrderLinesToUpdate = updateQtyOrderLine(orderLines, partialUpdateQtys);
            OrderLineStatus newStatus = _newStatus;
            try {
                //send request to OB to update status for the items
                IOrder updateResponse = this._orderHelper.updateOrderLinesStatus(currentOrder
                        , OrderLinesToUpdate, newStatus, this._stationState.getRetailLocationId()
                        , Long.toString(this._stationState.getSystemUser().getOperatorId()));
                this.setScopedValue(CawValueKeys.ORDER_REJECTED_LINES, OrderLinesToUpdate);
                //update EXTENDED_PRICE 
                updateExtPrice(updateResponse);/*BZ46682*/
                //persistent order update to DB
                DataFactory.makePersistent(updateResponse);
            } catch (NotSupportedInTrainingModeException var9) {
                _logger.warn(var9);
                return this.HELPER.getErrorResponse(this._formattables.getTranslatable(var9.getMessage()));
            }
            this._orderUtil.updateNotification();
            return this.HELPER.completeResponse();
        } else {
            if (currentOrder != null) {
                List<IOrderLine> currentOrderLines = currentOrder.getOrderLines();
                String orderLineStatus = null;
                for (int i = 0; i < currentOrderLines.size(); ++i) {
                    orderLineStatus = currentOrderLines.get(i).getStatusCode();
                    if (orderLineStatus != null && !REJECTED.equalsIgnoreCase(this._newStatus.getCode())) {
                        currentOrderLines.get(i).setStatusCodeReason(null);
                        currentOrderLines.get(i).setStatusCodeReasonNote(null);
                    }
                }
                currentOrder.setOrderLines(currentOrderLines);
            }
            return super.handleOpExec(argEvent);
        }
    }

    /*BEGIN BZ46682*/
    private void updateExtPrice(IOrder argUpdateResponse) {
        BigDecimal extendedPrice = BigDecimal.ZERO;
        BigDecimal itemRejectPrice = BigDecimal.ZERO;
        List<IOrderLine> orderLineResult = new ArrayList<IOrderLine>();
        Iterator<IOrderLine> var2 = argUpdateResponse.getOrderLines().iterator();
        int sequence = 0;
        
        //BEGIN BZ47730
        for (IOrderLine orderLine : argUpdateResponse.getOrderLines()) {
            sequence = Math.max(sequence, orderLine.getSequence());                
        }
        //END BZ47730
        
        int orderLineRejectIndex = 0;
        List<BigDecimal> orderLineQtys = this.getScopedValue(CawValueKeys.CAW_ORDER_QUANTITIES);
        while (var2.hasNext()) {
            IOrderLine orderLine = var2.next();
            orderLineResult.add(orderLine);
            if (OrderLineStatus.REJECTED.getCode().equals(orderLine.getStatusCode()) && orderLineQtys != null) {
                itemRejectPrice = orderLine.getUnitPrice().multiply(orderLine.getQuantity());
                itemRejectPrice = itemRejectPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                extendedPrice = orderLine.getExtendedPrice().subtract(itemRejectPrice);
                BigDecimal quantity = orderLineQtys.get(orderLineRejectIndex) != null ? orderLineQtys.get(orderLineRejectIndex):BigDecimal.ZERO;
                orderLineRejectIndex = orderLineRejectIndex + 1;
                if (quantity != null && quantity.compareTo(orderLine.getQuantity()) == 1) {
                    sequence = sequence + 1;
                    try {
                        /*insert a line into table xom_order_line*/
                        IOrderLine orderLineReject = createOrderLine(sequence, orderLine, quantity);
                        
                        orderLine.setExtendedPrice(extendedPrice);
                        orderLine.setTaxAmount(orderLine.getTaxAmount().subtract(orderLineReject.getTaxAmount()));
                        
                        /*insert a line into table xom_source_mod*/
                        ISourceModifier sourceModifier = createSourceModifier(orderLine, sequence);
                        orderLineReject.setSourceModifier(sourceModifier);
    
                        /*insert a line into table xom_fulfillment_mod*/
                        IFulfillmentModifier fulfillmentModifier = createFulfillmentModifier(sequence, orderLine);
                        orderLineReject.setFulfillmentModifier(fulfillmentModifier);
                        
                        /*insert a line into table xom_balance_mod*/
                        List<IBalanceModifier> balanceArr = orderLine.getBalanceModifiers();
                        balanceArr.get(0).setAmount(orderLine.getExtendedPrice().add(orderLine.getTaxAmount()));
                       
                        ArrayList<IBalanceModifier> balanceModifiers = createBalanceModifier(sequence, orderLine);
                        BigDecimal amount = orderLineReject.getExtendedPrice().add(orderLineReject.getTaxAmount());
                        amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        balanceModifiers.get(0).setAmount(amount);
                        orderLineReject.setBalanceModifiers(balanceModifiers);
                        
                        /*insert a line into table xom_item_mod*/
                        IItemModifier itemModifier = createItemModifier(sequence, orderLine);
                        orderLineReject.setItem(itemModifier);
                        
                        orderLineResult.add(orderLineReject);
                    } catch (Exception ex) {
                        _logger.error("error during insert data into DB" + ex.getMessage());
                }
            }
        }
        }
        argUpdateResponse.setOrderLines(orderLineResult);
    }

    /**
     * @param argSequence
     * @param argOrderLine
     * @return
     */
    private IItemModifier createItemModifier(int argSequence,
            IOrderLine argOrderLine) {
        ItemModifierId itemModifierId = new ItemModifierId();
        itemModifierId.setOrderId(argOrderLine.getOrderId());
        itemModifierId.setOrganizationId(argOrderLine.getOrganizationId());
        itemModifierId.setSequence(argSequence);
        IItemModifier itemModifier = DataFactory.createObject(itemModifierId, IItemModifier.class);
        itemModifier.setItemId(argOrderLine.getItem().getItemId());
        itemModifier.setDescription(argOrderLine.getItem().getDescription());
        itemModifier.setImageUrl(argOrderLine.getItem().getImageUrl());
        ((IDataModelImpl) itemModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return itemModifier;
    }

    /**
     * @param itemRejectPrice
     * @param sequence
     * @param orderLine
     * @return
     */
    private ArrayList<IBalanceModifier> createBalanceModifier(int sequence, IOrderLine orderLine) {

        BalanceModifierId balanceModifierId = new BalanceModifierId();
        balanceModifierId.setOrderId(orderLine.getOrderId());
        balanceModifierId.setOrganizationId(orderLine.getOrganizationId());
        balanceModifierId.setSequence(sequence);
        balanceModifierId.setModSequence(1);
        IBalanceModifier balanceModifier = DataFactory.createObject(balanceModifierId, IBalanceModifier.class);
        balanceModifier.setAmount(BigDecimal.ZERO);
        String typeCode = orderLine.getBalanceModifiers().get(0).getTypeCode();
        balanceModifier.setTypeCode(typeCode);
        ((IDataModelImpl) balanceModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        ArrayList<IBalanceModifier> balanceModifiers = new ArrayList<IBalanceModifier>();
        balanceModifiers.add(balanceModifier);
        return balanceModifiers;
    }

    /**
     * @param sequence
     * @param orderLine
     * @return
     */
    private IFulfillmentModifier createFulfillmentModifier(int sequence,
            IOrderLine orderLine) {
        FulfillmentModifierId fulfillmentModifierId = new FulfillmentModifierId();
        fulfillmentModifierId.setOrderId(orderLine.getOrderId());
        fulfillmentModifierId.setOrganizationId(orderLine.getOrganizationId());
        fulfillmentModifierId.setSequence(sequence);
        IFulfillmentModifier fulfillmentModifier = DataFactory.createObject(fulfillmentModifierId, IFulfillmentModifier.class);
        fulfillmentModifier.setAddress(orderLine.getFulfillmentModifier().getAddress());
        fulfillmentModifier.setAddressSequence(orderLine.getFulfillmentModifier().getAddressSequence());
        fulfillmentModifier.setLocationId(orderLine.getFulfillmentModifier().getLocationId());
        fulfillmentModifier.setLocationName1(orderLine.getFulfillmentModifier().getLocationName1());
        fulfillmentModifier.setLocationName2(orderLine.getFulfillmentModifier().getLocationName2());
        fulfillmentModifier.setTelephone1(orderLine.getFulfillmentModifier().getTelephone1());
        fulfillmentModifier.setEmailAddress(orderLine.getFulfillmentModifier().getEmailAddress());
        ((IDataModelImpl) fulfillmentModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return fulfillmentModifier;
    }

    /**
     * @param orderLine
     * @param sourceModifierId
     * @return
     */
    private ISourceModifier createSourceModifier(IOrderLine orderLine, int sequence) {
        SourceModifierId sourceModifierId = new SourceModifierId();
        sourceModifierId.setOrderId(orderLine.getOrderId());
        sourceModifierId.setOrganizationId(orderLine.getOrganizationId());
        sourceModifierId.setSequence(sequence);
        ISourceModifier sourceModifier = DataFactory.createObject(sourceModifierId, ISourceModifier.class);
        sourceModifier.setAddress(orderLine.getSourceModifier().getAddress());
        sourceModifier.setAddressSequence(orderLine.getSourceModifier().getAddressSequence());
        sourceModifier.setLocationId(orderLine.getSourceModifier().getLocationId());
        sourceModifier.setLocationType(orderLine.getSourceModifier().getLocationType());
        sourceModifier.setLocationName1(orderLine.getSourceModifier().getLocationName1());
        sourceModifier.setLocationName2(orderLine.getSourceModifier().getLocationName2());
        sourceModifier.setTelephone1(orderLine.getSourceModifier().getTelephone1());
        ((IDataModelImpl) sourceModifier).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return sourceModifier;
    }

    /**
     * @param itemRejectPrice
     * @param orderLine
     * @param orderLineId
     * @return
     */
    private IOrderLine createOrderLine(int sequence, IOrderLine argOrderLine, BigDecimal quantity) {
        OrderLineId orderLineId = new OrderLineId();
        orderLineId.setOrderId(argOrderLine.getOrderId());
        orderLineId.setOrganizationId(argOrderLine.getOrganizationId());
        orderLineId.setSequence(sequence);
        IOrderLine orderLineReject = DataFactory.createObject(orderLineId, IOrderLine.class);
        
        BigDecimal itemRejectPrice = argOrderLine.getUnitPrice().multiply(argOrderLine.getQuantity());
        itemRejectPrice = itemRejectPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        orderLineReject.setExtendedPrice(itemRejectPrice);
        
        orderLineReject.setQuantity(argOrderLine.getQuantity());
        
        orderLineReject.setUnitPrice(argOrderLine.getUnitPrice());
        orderLineReject.setLineNumber(argOrderLine.getLineNumber());
        orderLineReject.setItemId(argOrderLine.getItemId());
        orderLineReject.setItem(argOrderLine.getItem());
        orderLineReject.setExternalOrderId(argOrderLine.getExternalOrderId());
        orderLineReject.setFulfillmentType(argOrderLine.getFulfillmentType());
        orderLineReject.setStatusCode(OrderLineStatus.UNFULFILLABLE.getCode());
        
        orderLineReject.setTaxAmount((argOrderLine.getTaxAmount().divide(quantity, 4, RoundingMode.HALF_UP)).multiply(argOrderLine.getQuantity()));
        
        orderLineReject.setSelectedShipMethod(argOrderLine.getSelectedShipMethod());
        orderLineReject.setExtendedFreight(argOrderLine.getExtendedFreight());
        orderLineReject.setCustomizationCharge(argOrderLine.getCustomizationCharge());
        orderLineReject.setShipWeight(argOrderLine.getShipWeight());
        
        //BEGIN BZ47909
        try {
            String oriOrderLineProperty = argOrderLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE);
            if (!StringUtils.isEmpty(oriOrderLineProperty)) {
                JSONObject jsonOrderLineProperty = new JSONObject(oriOrderLineProperty);
                if (jsonOrderLineProperty.has(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO)
                        && jsonOrderLineProperty.has(CawConstants.CAW_OB_LINE_NO)) {
                    int reqSysLineNo = jsonOrderLineProperty.getInt(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO);
                                       
                    String value = "{requesting_system_line_no:" + reqSysLineNo + "}";
                    IOrderLineProperty orderLineProperty = DataFactory.createObject(IOrderLineProperty.class);
                    
                    orderLineProperty.setOrganizationId(orderLineReject.getOrganizationId());
                    orderLineProperty.setSequence(orderLineReject.getSequence());
                    orderLineProperty.setPropertyCode(CawConstants.CAW_OB_MAPPING_LINE);
                    orderLineProperty.setType("STRING");
                    orderLineProperty.setStringValue(value);
                    orderLineReject.addOrderLineProperty(orderLineProperty);
                }
            }
        } catch (JSONException ex) {
            _logger.error("[Exception happen when get order line property]: "
                    + ex.getMessage());
        }
        // END BZ47909
        ((IDataModelImpl) orderLineReject).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());/*BZ47443*/
        return orderLineReject;
    }
    /*END BZ46682*/
    private List<IOrderLine> updateQtyOrderLine(List<IOrderLine> argOrderLines,
            List<BigDecimal> argPartialUpdateQtys) {

        List<IOrderLine> OrderLinesToUpdate = new ArrayList<IOrderLine>();
        for (int i = 0; i < argOrderLines.size(); ++i) {
            IOrderLine orderLine = argOrderLines.get(i);
            BigDecimal updateQty = orderLine.getQuantity();
            if (argPartialUpdateQtys != null) {
                updateQty = argPartialUpdateQtys.get(i);
            }
            orderLine.setQuantity(updateQty);
            OrderLinesToUpdate.add(orderLine);
        }
        return OrderLinesToUpdate;
    }

    @Override
    public void setParameter(String argName, String argValue) {

        super.setParameter(argName, argValue);
        if (NEW_STATUS.equalsIgnoreCase(argName)) {
            OrderLineStatus newStatus = OrderLineStatus.forName(argValue);
            if (newStatus == null) {
                throw new IllegalArgumentException(
                        argValue + " is not a valid order status.");
            }
            this._newStatus = newStatus;
        }

    }
}
