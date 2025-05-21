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
 * BZ47440          071221    [Internal patch 7.0.16] Order Complete Receipt - Deposit/Payments and Balance Due printed incorrectly when picking up an BOPIS that contained cancelled item 
 * BZ47630          131231    [Internal patch 7.0.16-17] Enable Reject Order button - Incorrect order line item status when do a partial reject
 * BZ47909          291221    Patch 15- Partial Cancel Incorrect price on Receipt and Screen
 * BZ47862          060121    Patch 16 - Partial Cancel item receipt is not printing correct tax amount
 * BZ48496          100222    [PROD] BOPIS non-service exception occurred processing order
 *===================================================================
 */

package caw.xst.xom.locate.impl.order.lookup.resp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsretail.locate.StatusInquiryResponseMessageItemTypeBean;
import com.microsretail.locate.StatusInquiryResponseMessageOrderTypeBean;

import caw.pos.common.CawConstants;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IObjectId;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.util.StringUtils;
import dtv.xst.dao.xom.*;
import dtv.xst.dao.xom.impl.OrderModel;
import dtv.xst.xom.impl.order.*;
import dtv.xst.xom.locate.impl.order.LocateOrderType;
import dtv.xst.xom.locate.impl.order.lookup.resp.LocateStatusRequestToXstoreRetrieveAdapter;

public class CawLocateStatusRequestToXstoreRetrieveAdapter extends LocateStatusRequestToXstoreRetrieveAdapter {
    private static final Logger      _logger                   = LogManager.getLogger(CawLocateStatusRequestToXstoreRetrieveAdapter.class);
    @Override
    public void adapt(Object argSource, Object argTarget) {
        List<Object> locateOrders = (List)argSource;
        IOrder xstoreOrder = (IOrder)argTarget;
        OrderModel orderModel = (OrderModel)xstoreOrder;
        Set<IObjectId> processedLines = new HashSet<>();
        double balanceDue = 0.0D;
        double subtotal = 0.0D;
        double total = 0.0D;
        double totalTax = 0.0D;
        BigDecimal shippingFee = BigDecimal.ZERO;
        double deposit = 0.0D;
        List<StatusInquiryResponseMessageItemTypeBean> cancelledItems = new ArrayList<>();
        List<StatusInquiryResponseMessageItemTypeBean> nonCancelledItems = new ArrayList<>();
        double cleanTotal = 0.0D;
        double cleanBalanceDue = 0.0D;
        double cancelledItemsTotalRefund = 0.0D;
        for (Object order : locateOrders) {
          StatusInquiryResponseMessageOrderTypeBean locateOrder = (StatusInquiryResponseMessageOrderTypeBean)order;
          LocateOrderType locateOrderType = LocateOrderType.codeOf(locateOrder.getOrderType());
          xstoreOrder.setAdditionalFreightCharges(locateOrder.getOrderAdditionalFreightCharges());
          xstoreOrder.setAdditionalCharges(locateOrder.getOrderAdditionalCharges());
          xstoreOrder.setFreightTax(locateOrder.getFreightTax());
          xstoreOrder.setShipComplete("Y".equalsIgnoreCase(locateOrder.getShipComplete()));
          xstoreOrder.setOrderMessage(locateOrder.getOrderMessage());
          xstoreOrder.setGiftMessage(locateOrder.getGiftMessage());
          xstoreOrder.setUnderReview("Y".equalsIgnoreCase(locateOrder.getUnderReview()));
          List<StatusInquiryResponseMessageItemTypeBean> fulfilledAndCancelledItems = new ArrayList<>();
          List<StatusInquiryResponseMessageItemTypeBean> unfulfillableItems = new ArrayList<>();
          cleanBalanceDue += locateOrder.getBalanceDue().doubleValue();
          balanceDue += locateOrder.getBalanceDue().doubleValue();
          
          // BEGIN BZ47440
          List<String> listProperties = new ArrayList<>();
          for (IOrderLine orderLine : xstoreOrder.getOrderLines()) {
              if (orderLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE) != null) {
                  listProperties.add(orderLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE));
              }
          }
          // END BZ47440
          
          for (StatusInquiryResponseMessageItemTypeBean locateItem : locateOrder.getItems().getItems()) {
            BigDecimal taxAmount = taxgetTaxAmountFromXstore(locateItem, xstoreOrder); //BZ47862

            if ("Tax".equals(getTaxType(locateItem.getTaxes()))) {             
              cleanTotal += locateItem.getUnitPrice() * locateItem.getItemQty() + taxAmount.doubleValue();//BZ47862
            } else {
              cleanTotal += locateItem.getUnitPrice() * locateItem.getItemQty();
            } 
            if (!OrderLineStatus.CANCELLED.getDescription().equalsIgnoreCase(locateItem.getItemStatus())) {
              nonCancelledItems.add(locateItem);
              subtotal += locateItem.getUnitPrice() * locateItem.getItemQty();
              if ("Tax".equals(getTaxType(locateItem.getTaxes()))) {
                total += locateItem.getUnitPrice() * locateItem.getItemQty() + taxAmount.doubleValue();//BZ47862
              } else {
                total += locateItem.getUnitPrice() * locateItem.getItemQty();
              } 
              totalTax += taxAmount.doubleValue();//BZ47862
              if (OrderLineStatus.UNFULFILLABLE.getCode().equalsIgnoreCase(locateItem.getItemStatus())) {
                unfulfillableItems.add(locateItem);
              } else if (OrderLineStatus.FULFILLED.getCode().equalsIgnoreCase(locateItem.getItemStatus())) {
                orderModel.hasFulfilledItemFromOtherStore(true);
                fulfilledAndCancelledItems.add(locateItem);
              } 
            } else {
              orderModel.hasCancelledItem(true);
              fulfilledAndCancelledItems.add(locateItem);
              cancelledItems.add(locateItem);
            } 
            
            // BEGIN BZ47440, BZ47909
            for (IOrderLine xstoreLine : xstoreOrder.getOrderLines()) {   
                try {
                    String oriOrderLineProperty = xstoreLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE);
                    if (!StringUtils.isEmpty(oriOrderLineProperty)) {
                        JSONObject jsonOrderLineProperty = new JSONObject(oriOrderLineProperty);
                        if (jsonOrderLineProperty.has(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO)) {
                            int requestLineNo = jsonOrderLineProperty.getInt(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO);
                            if (!jsonOrderLineProperty.has(CawConstants.CAW_OB_LINE_NO)){
                                this.adaptNewOrderLineDetail(locateOrder, locateOrderType,
                                        locateItem, xstoreLine, listProperties, requestLineNo);
                                listProperties.add(xstoreLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE));
                            }
                        }
                    }
                } catch (JSONException ex) {
                    _logger.error("[Exception happen when get order line property]: "
                            + ex.getMessage());
                }
            }
            // END BZ47440, BZ47909
            // BEGIN BZ47630
            for (final IOrderLine xstoreLine : xstoreOrder.getOrderLines()) {
                if (!xstoreLine.getVoid() && !processedLines.contains(xstoreLine.getObjectId()) && orderLineMapping(xstoreLine, locateItem)) {
                    
                    if (xstoreLine.getCustomizationCharge() != null) {
                        locateItem.setOrderLineCustomizationCharge(xstoreLine.getCustomizationCharge().setScale(6, 1));
                    }

                    if (xstoreLine.getExtendedFreight() != null) {
                        locateItem.setOrderLineExtendedFreight(xstoreLine.getExtendedFreight().setScale(6, 1));
                    }

                    if (xstoreLine.getShipWeight() != null) {
                        locateItem.setOrderLineShipWeight(xstoreLine.getShipWeight().setScale(6, 1));
                    }
                    
                    this.adaptItem(locateOrderType, locateItem, xstoreLine);
                    
                    processedLines.add(xstoreLine.getObjectId());
                    break;
                }
            }
            //END BZ47630
          } 
          if (!OrderType.STANDARD_DELIVERY.getName().equals(xstoreOrder.getOrderType())) {
            if (OrderLineStatus.CANCELLED.getDescription().equalsIgnoreCase(locateOrder.getOrderStatus()) 
                    || OrderLineStatus.FULFILLED.getCode().equalsIgnoreCase(locateOrder.getOrderStatus()) 
                    || OrderLineStatus.COMPLETE.getCode().equalsIgnoreCase(locateOrder.getOrderStatus())) {
              for (StatusInquiryResponseMessageItemTypeBean locateItem : fulfilledAndCancelledItems) {
                double itemAmountPaid = getItemBalance(locateItem, xstoreOrder);
                cleanBalanceDue += itemAmountPaid;
              } 
              for (StatusInquiryResponseMessageItemTypeBean locateItem : unfulfillableItems) {
                double itemAmountPaid = getItemBalance(locateItem, xstoreOrder);
                cleanBalanceDue += itemAmountPaid;
                balanceDue += itemAmountPaid;
              } 
              continue;
            } 
            for (StatusInquiryResponseMessageItemTypeBean locateItem : fulfilledAndCancelledItems) {
              double itemAmountPaid = getItemBalance(locateItem, xstoreOrder);
              balanceDue -= itemAmountPaid;
            } 
          } 
        } 
        OrderStatus newStatus = determineOverAllOrderStatus(locateOrders);
        xstoreOrder.setStatusCode(newStatus.getName());
        shippingFee = OrderUtils.getShippingFeeAmount(xstoreOrder);
        totalTax += OrderUtils.getShippingFeeTaxAmount(xstoreOrder).doubleValue();
        cleanTotal += shippingFee.doubleValue();
        if (OrderType.STANDARD_DELIVERY.getName().equals(xstoreOrder.getOrderType())) {
          deposit = cleanTotal;
        } else {
          deposit = cleanTotal - cleanBalanceDue;
        } 
        for (StatusInquiryResponseMessageItemTypeBean locateItem : cancelledItems) {
            
          BigDecimal taxAmount = taxgetTaxAmountFromXstore(locateItem, xstoreOrder);//BZ47862
          
          double itemAmount = locateItem.getUnitPrice() * locateItem.getItemQty() + taxAmount.doubleValue();//BZ47862
          if (!contains(locateItem, xstoreOrder)) {
            double itemDeposit = itemAmount / cleanTotal * deposit;
            cancelledItemsTotalRefund += itemDeposit;
            continue;
          } 
          if (!hasRefund(locateItem, xstoreOrder)) {
            double itemDeposit = itemAmount / cleanTotal * deposit;
            cancelledItemsTotalRefund += itemDeposit;
          } 
        } 
        // BEGIN BZ48496
        if (Double.isInfinite(cancelledItemsTotalRefund) || Double.isNaN(cancelledItemsTotalRefund)) {
            cancelledItemsTotalRefund = 0.0;
        }
        // END BZ48496
        orderModel.setCancelledItemsTotalRefund((new BigDecimal(cancelledItemsTotalRefund))
            .setScale(6, RoundingMode.HALF_UP));
        for (StatusInquiryResponseMessageItemTypeBean locateItem : nonCancelledItems) {
          IOrderLine line = getOrderLine(locateItem, xstoreOrder);
          total += OrderUtils.getShippingFeeAmount(line).doubleValue();
          total += OrderUtils.getShippingFeeTaxAmount(line).doubleValue();
        } 
        orderModel.setTotalDeposit((new BigDecimal(deposit)).setScale(6, RoundingMode.HALF_UP));
        if (OrderStatus.COMPLETE.getName().equalsIgnoreCase(newStatus.getName()) || OrderStatus.CANCELLED
          .getName().equals(newStatus.getName()) || OrderType.STANDARD_DELIVERY
          .getName().equals(xstoreOrder.getOrderType())) {
          xstoreOrder.setBalanceDue(BigDecimal.ZERO);
        } else {
          xstoreOrder.setBalanceDue((new BigDecimal(balanceDue)).setScale(6, 4));
        } 
        xstoreOrder.setTaxAmount((new BigDecimal(totalTax)).setScale(6, 4));
        xstoreOrder.setSubtotal((new BigDecimal(subtotal)).setScale(6, 4));
        xstoreOrder.setTotal((new BigDecimal(total)).setScale(6, 4));
      }

    // Begin BZ47862
    /**
     * @param argLocateItem
     * @param argXstoreOrder
     * @return
     */
    private BigDecimal taxgetTaxAmountFromXstore(StatusInquiryResponseMessageItemTypeBean argLocateItem, IOrder argXstoreOrder) {
        BigDecimal taxAmount = BigDecimal.ZERO;
        for (IOrderLine orderLine : argXstoreOrder.getOrderLines()) {
            if (!orderLine.getVoid() && orderLineMapping(orderLine, argLocateItem)) {
                if (orderLine.getTaxAmount().compareTo(new BigDecimal(argLocateItem.getTaxAmount())) < 0) {
                    taxAmount = orderLine.getTaxAmount();
                }
                else {
                    taxAmount = new BigDecimal(argLocateItem.getTaxAmount());
                }                
            }               
        }
        return taxAmount;
    }
    // End BZ47862

    private boolean contains(StatusInquiryResponseMessageItemTypeBean argLocateItem, IOrder argXstoreOrder) {
        for (IOrderLine line : argXstoreOrder.getOrderLines()) {
          if (orderLineMapping(line, argLocateItem))
            return true; 
        } 
        return false;
      }
      
      private double getItemBalance(StatusInquiryResponseMessageItemTypeBean argLocateItem, IOrder argXstoreOrder) {
          IOrderLine line = this.getOrderLine(argLocateItem, argXstoreOrder);
          BigDecimal itemShippingFee = OrderUtils.getShippingFeeAmount(line);
          
          BigDecimal taxAmount = taxgetTaxAmountFromXstore(argLocateItem, argXstoreOrder);//BZ47862
          
          double itemBalance = argLocateItem.getUnitPrice() * argLocateItem.getItemQty() 
                  + taxAmount.doubleValue() + itemShippingFee.doubleValue();//BZ47862
          BigDecimal itemDeposit = OrderUtils.getDepositAmount(line);
          itemBalance -= itemDeposit.doubleValue();
          return itemBalance;
      }
      
      private IOrderLine getOrderLine(StatusInquiryResponseMessageItemTypeBean argLocateItem, IOrder argOrder) {
          for (IOrderLine line : argOrder.getOrderLines()) {
              if (!line.getVoid() && orderLineMapping(line, argLocateItem))
                  return line;
          }
          return null;
      }
      private boolean hasRefund(StatusInquiryResponseMessageItemTypeBean argLocateItem, IOrder argXstoreOrder) {
        for (IOrderLine line : argXstoreOrder.getOrderLines()) {
          if (orderLineMapping(line, argLocateItem) && 
            OrderUtils.getRefundModifier(line) == null)
            return false; 
        } 
        return true;
      }

      // BEGIN BZ47440
      private boolean orderLineMapping(IOrderLine line,StatusInquiryResponseMessageItemTypeBean argLocateItem) {
          try {
              String orderLineProperty = line.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE);
              if (!StringUtils.isEmpty(orderLineProperty)) {
                  JSONObject jsonOrderLineProperty = new JSONObject(orderLineProperty);
                  if (jsonOrderLineProperty.has(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO)
                          && jsonOrderLineProperty.has(CawConstants.CAW_OB_LINE_NO)) {
                      int reqSysLineNo = jsonOrderLineProperty.getInt(CawConstants.CAW_OB_REQUESTING_SYSTEM_LINE_NO);
                      int lineNo = jsonOrderLineProperty.getInt(CawConstants.CAW_OB_LINE_NO);
                      if (reqSysLineNo == argLocateItem.getRequestingSystemLineNo() && lineNo == argLocateItem.getLineNo())
                          return true;
                  }
              }
          } catch (JSONException ex) {
              _logger.error("[Exception happen when get order line property]: "
                      + ex.getMessage());
          }
          return false;
      }
      
      protected IOrderLineProperty adaptNewOrderLineDetail(StatusInquiryResponseMessageOrderTypeBean argLocateOrder,
              LocateOrderType argLocateOrderType, StatusInquiryResponseMessageItemTypeBean argLocateItem,
              IOrderLine argXstoreLine, List<String> argListProperties, int argRequestLineNo) {
          String value = "{requesting_system_line_no:" + argLocateItem.getRequestingSystemLineNo() + ",line_no:" + argLocateItem.getLineNo() + "}";
          IOrderLineProperty orderLineProperty = DataFactory.createObject(IOrderLineProperty.class);
          
          if (!argListProperties.contains(value) && argRequestLineNo == argLocateItem.getRequestingSystemLineNo()) {              
              orderLineProperty.setOrganizationId(argXstoreLine.getOrganizationId());
              orderLineProperty.setSequence(argXstoreLine.getSequence());
              orderLineProperty.setPropertyCode(CawConstants.CAW_OB_MAPPING_LINE);
              orderLineProperty.setType("STRING");
              orderLineProperty.setStringValue(value);
              argXstoreLine.addOrderLineProperty(orderLineProperty);
                           
          }
          ((IDataModelImpl) orderLineProperty).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal()); //BZ47909
          return orderLineProperty;

      }
      // END BZ47440
}
