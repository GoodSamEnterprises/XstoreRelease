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
 * BZ37467          210820    [INTERNAL] Cancel Order issue in Xstore
 * BZ38009          100720    [INTERNAL] Order Cancel must follow existing CW Refund tender Matrix
 * BZ47611          120921    [Internal patch 7.0.16] The HDE screen displays when attempt to cancel an item after cancelling partially an item previously in the same transaction.
 *===================================================================
 */

package caw.pos.order;

import static dtv.data2.access.DataFactory.createObject;
import static dtv.pos.register.ItemLocator.getAutomaticEntryMethod;
import static dtv.xst.dao.trl.RetailPriceModifierReasonCode.PROMPT_PRICE_CHANGE;
import static dtv.xst.dao.trl.SaleItemType.RETURN;
import static dtv.xst.xom.impl.order.OrderLineStatus.CANCELLED;
import static dtv.xst.xom.impl.order.OrderUtils.getRefundModifier;
import static dtv.xst.xom.impl.order.PaymentType.REFUND;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import caw.pos.ejournal.CawTransactionSearchHelper;
import caw.xst.query.result.CawOrderModQueryResult;

import dtv.data2.access.*;
import dtv.data2.access.pm.PersistenceManagerType;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.hardware.IHardwareType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderHelper;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.register.returns.ReturnType;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.dao.xom.*;

/**
 *
 */
public class CawAddOrderRefundOp extends Operation {

    @Inject
    private OrderHelper _orderHelper;

    @Inject
    private OrderMgr    _orderMgr;
    //BEGIN BZ38009
    @Inject
    OrderHelper                                      helper;
    @Inject
    private CawTransactionSearchHelper transHelper;

    @Inject
    ReturnManager                                    _returnManager;
    
    protected static final IQueryKey<CawOrderModQueryResult> QUERY_ORDER_MOD = new QueryKey<CawOrderModQueryResult>(
            "QUERY_ORDER_MOD", CawOrderModQueryResult.class);
    //END BZ38009

    /* (non-Javadoc)
     * @see dtv.pos.order.AddOrderRefundOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOrder currentOrder = _orderMgr.getCurrentOrder();
        
        BigDecimal refundAmount = ZERO;

        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
            if (!orderLine.getVoid() && CANCELLED.matches(orderLine.getStatusCode())
                    && (orderLine.getShadowedSaleItem() != null)) {
                
                IBalanceModifier refundMod = getRefundModifier(orderLine);
                BigDecimal lineRefund = (refundMod != null) ? refundMod.getAmount() : ZERO;
                refundAmount = refundAmount.add(lineRefund);
            }
        }
        /**
         * ohernando - Feb 22,2013 XSTORE-4902 - To prevent primary key violation when 2 different stores send a
         * replication to xcenter with the same sequence ID of the xom_order_payment. We prepend the store id to
         * the generated next sequence.
         */
        /*Long seq = SequenceFactory.getNextLongValue(OrderConstants.ORDER_PAYMENT_SEQUENCE);
        OrderPaymentId id = new OrderPaymentId();
        id.setOrderId(currentOrder.getOrderId());
        id.setOrganizationId(ConfigurationMgr.getOrganizationId());
        id.setSequence(seq.intValue());
        
        IOrderPayment refund = createObject(id, IOrderPayment.class);*/
        IOrderPayment refund = createObject(IOrderPayment.class);
        refund.setTypeCode(REFUND.getName());

        // If there is an accumulated refund amount, we need to subtract it from the current refundAmount value.
        // This is the refund line for this item
        if (currentOrder.getAccumulatedRefund() != null) {
            refund.setAmount(refundAmount.subtract(currentOrder.getAccumulatedRefund()));
        } else {
            refund.setAmount(refundAmount);
        }
        currentOrder.addOrderPayment(refund);

        IItem iSaleReturnLineItem = CawOrderHelper.getInstance().mockupItemDeposit();
        IHardwareType<?> automaticEntry = getAutomaticEntryMethod();

        ISaleReturnLineItem refundLine = ItemLocator.getLocator().getSaleLineItem(iSaleReturnLineItem, RETURN, true, false, automaticEntry);
        //BEGIN BZ38009
        IOrder order = getScopedValue(ValueKeys.SELECTED_ORDER);
        
        //Start BZ47611
        if (order == null) {
            order = _orderMgr.getCurrentOrder();
        }
        //End BZ47611
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("argOrganizationId", ConfigurationMgr.getOrganizationId());
        params.put("argOrderId", order.getOrderId());
        
        List<CawOrderModQueryResult> xrefResults = DataFactory
                .getObjectByQueryNoThrow(QUERY_ORDER_MOD, params, PersistenceManagerType
                        .forName("XCENTER_STANDARD"));
        if (xrefResults != null && xrefResults.size()>0) {
            CawOrderModQueryResult temp = xrefResults.get(0);
            refundLine.setOriginalRetailLocationId(Long.parseLong(temp.getRtlId()));
            refundLine.setOriginalWorkstationId(Long.parseLong(temp.getWstId()));
            refundLine.setOriginalTransactionSequence(temp.getTransSeq());
            refundLine.setOriginalBusinessDate(temp.getBDate());
            refundLine.setOriginalLineItemSequence(temp.getTransLineItmSeq());
            
            PosTransactionId pos = new PosTransactionId();
            pos.setOrganizationId(temp.getOrgId());
            pos.setRetailLocationId(Long.parseLong(temp.getRtlId()));
            pos.setWorkstationId(Long.parseLong(temp.getWstId()));
            pos.setTransactionSequence(temp.getTransSeq());
            pos.setBusinessDate(temp.getBDate());
            IRetailTransaction transaction = (IRetailTransaction) transHelper.getTransaction(pos, PersistenceManagerType
                    .forName("XCENTER_STANDARD"));
            _returnManager.addOrigTransaction(transaction);
            
        }

        //END BZ38009

        refundLine.setReturnTypeCode(ReturnType.VERIFIED.name());
        /* bsanchin - 06/23/14. Not only original business date, we also need to set orig {org_id, rtl_loc_id, and
         * trans_seq}, if we are to set the original business date. Otherwise, incomplete transaction reference
         * information will be output in the PosLog.xml file. It may not be necessary to include original
         * transaction information onto the payment/refund line since canceled line items would have order id
         * information. Therefore, commenting out line below. */
        // refundLine.setOriginalBusinessDate(currentOrder.getOrderDate());

        // Create a price override modifier so the price is not reset later
        IRetailPriceModifier priceModifier = createObject(IRetailPriceModifier.class);
        if (currentOrder.getAccumulatedRefund() != null) {
            refundLine.setUnitPrice(refundAmount.subtract(currentOrder.getAccumulatedRefund()));
        } else {
            refundLine.setUnitPrice(refundAmount);
        }

        // Save off the accumulated refund amount in case the user cancel the order 1 item at a time.
        currentOrder.setAccumulatedRefund(refundAmount);

        priceModifier.setPriceChangeAmount(refundLine.getUnitPrice());
        priceModifier.setRetailPriceModifierReasonCode(PROMPT_PRICE_CHANGE.getName());
        refundLine.addRetailPriceModifier(priceModifier);

        IOrderModifier orderMod = _orderHelper.createOrderModifier(refund, currentOrder.getOrderType(), null);
        refundLine.setOrderModifier(orderMod);
        refund.setShadowedSaleItem(refundLine);
        IPosTransaction _trans = _transactionScope.getTransaction();
        List<ISaleReturnLineItem> lstSaleReturnLineItem = _trans.getLineItems(ISaleReturnLineItem.class);
        _trans.addRetailTransactionLineItem(refundLine);
        //BEGIN BZ38009

        return HELPER.completeResponse();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        return currentOrder.addOrderRefund();
    }
}
