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
 * BZ37179          140820    Remove non-physical items (Deposit, Payment, Shipping Fee) in Order Transactions
 * BZ38351          131020    [Internal] Xstore goes auto Authorizer Message prompt unexpected after Xstore receives exception shipping method about Item restricted
 *===================================================================
 */

package caw.pos.order;

import static dtv.data2.access.DataFactory.createObject;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyRoundingMode;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyScale;
import static dtv.util.NumberUtils.isZero;
import static dtv.xst.dao.trl.RetailPriceModifierReasonCode.PROMPT_PRICE_CHANGE;
import static dtv.xst.dao.trl.SaleItemType.ORDER;
import static dtv.xst.xom.impl.order.OrderLineStatus.NEW;
import static dtv.xst.xom.impl.order.OrderUtils.*;
import static dtv.xst.xom.impl.order.PaymentType.DEPOSIT;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_EVEN;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import caw.pos.shippingfee.CawGetListsShippingFee;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.hardware.IHardwareType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderHelper;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.tax.*;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawUpdateDepositInfoOp extends Operation {

    @Inject
    private OrderHelper        _orderHelper;

    @Inject
    private OrderMgr           _orderMgr;

    @Inject
    private TaxStrategyFactory _taxStrategyFactory;

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        IOrderPayment deposit = getDeposit(currentOrder);
        IItem iSaleReturnLineItem = null;
        BigDecimal depositAmount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);

        if (deposit == null) {
            iSaleReturnLineItem = CawOrderHelper.getInstance()
                    .mockupItemDeposit();
            deposit = addDeposit(iSaleReturnLineItem, currentOrder);
        }

        //BEGIN BZ37179
        IPosTransaction _trans = _transactionScope.getTransaction();
        List<ISaleReturnLineItem> lstSaleReturnLineItem = _trans.getLineItems(ISaleReturnLineItem.class);
        for  (ISaleReturnLineItem line : lstSaleReturnLineItem) {
            line.setForceZeroExtendedAmt(false);
        } 
        //END BZ37179

        deposit.setVoid(false);
        deposit.getShadowedSaleItem().setVoid(true);
        deposit.setAmount(depositAmount);
        deposit.getShadowedSaleItem().setUnitPrice(depositAmount);

        for (IRetailPriceModifier modifier : deposit.getShadowedSaleItem()
                .getRetailPriceModifiers()) {
            RetailPriceModifierReasonCode reason = RetailPriceModifierReasonCode
                    .forName(modifier.getRetailPriceModifierReasonCode());

            if (!modifier.getVoid() && reason.isOverride()) {
                modifier.setPriceChangeAmount(deposit.getAmount());
            }
        }

        BigDecimal totalAmountApplied = ZERO;
        IBalanceModifier lastOne = null;

        IBalanceModifier depositMod;
        for (IOrderLine orderLine : getNonVoidedLines(currentOrder)) {
            // handle VAT tax items
            ISaleReturnLineItem shadowedItem = orderLine.getShadowedSaleItem();
            BigDecimal taxAmount = ZERO;
            if (shadowedItem != null) {
                for (ISaleTaxModifier mod : shadowedItem.getTaxModifiers()) {
                    final String taxTypeCode = mod.getSaleTaxGroupRule()
                            .getTaxTypeCode();
                    final ITaxStrategy taxStategy = _taxStrategyFactory
                            .createTaxStrategy(taxTypeCode);
                    if (!taxStategy.isPriceTaxInclusive()) {
                        taxAmount = orderLine.getTaxAmount();
                    }
                }
            }

            // I just need to limit the scale to something that will prevent a non-terminating decimal
            // expansion, but will impact the ratio as little as possible. I arbitrarily chose a number.
            BigDecimal lineTotal = orderLine.getExtendedPrice().add(taxAmount);
            lineTotal = lineTotal.add(getShippingFeeAmount(orderLine));
            lineTotal = lineTotal.add(getShippingFeeTaxAmount(orderLine));
            BigDecimal thisLineRatio = lineTotal.divide(currentOrder
                    .getTotal(), 20, getLocalCurrencyRoundingMode());
            BigDecimal thisLineDeposit = depositAmount.multiply(thisLineRatio);
            // HALF_EVEN rounding is used here to try and eliminate too much rounding error. Minor rounding
            // errors are handled in the extra pennies logic below.
            thisLineDeposit = thisLineDeposit
                    .setScale(getLocalCurrencyScale(), HALF_EVEN);
            totalAmountApplied = totalAmountApplied.add(thisLineDeposit);
            depositMod = getOrCreateDepositModifier(orderLine);
            depositMod.setAmount(thisLineDeposit);
            lastOne = depositMod;
        }

        /* There is always the possibility of rounding issues, so account for any extra pennies that may or may
         * not have been applied by adding them to first non-voided line. */
        BigDecimal extraPennies = depositAmount.subtract(totalAmountApplied);

        if (lastOne != null && !isZero(extraPennies)) {
            lastOne.setAmount(lastOne.getAmount().add(extraPennies));
        }

        return HELPER.completeResponse();
    }

    /**
     * Creates the appropriate deposit objects for <code>argCurrentOrder</code> and adds them to the current
     * order and transaction.
     *
     * @param argCurrentOrder the order to which the deposit should be added
     * @return the order that was passed with the newly created deposit added
     */
    protected IOrderPayment addDeposit(IItem argISaleReturnLineItem, IOrder argCurrentOrder) {

        IOrderPayment deposit = (IOrderPayment) DataFactory.createObject(IOrderPayment.class);
        deposit.setTypeCode(DEPOSIT.getName());
        argCurrentOrder.addOrderPayment(deposit);

        IHardwareType<?> automaticEntry = ItemLocator.getLocator()
                .getAutomaticEntryMethod();

        ISaleReturnLineItem depositLine = ItemLocator.getLocator()
                .getSaleLineItem(argISaleReturnLineItem, ORDER, false, automaticEntry);

        // Create a price override modifier so the price is not reset later
        IRetailPriceModifier priceModifier = DataFactory
                .createObject(IRetailPriceModifier.class);
        priceModifier.setPriceChangeAmount(ZERO);
        priceModifier.setRetailPriceModifierReasonCode(PROMPT_PRICE_CHANGE
                .getName());
        depositLine.addRetailPriceModifier(priceModifier);

        IOrderModifier orderMod = _orderHelper
                .createOrderModifier(deposit, argCurrentOrder
                        .getOrderType(), null);
        depositLine.setOrderModifier(orderMod);

        deposit.setShadowedSaleItem(depositLine);
        IPosTransaction trans = _transactionScope.getTransaction();
        trans.addRetailTransactionLineItem(depositLine);

        // Calculate the tax due on this item. Since this is a deposit, it should theoretically
        // always have zero tax, but the tax group, rules, etc. must still be set. This is the
        // most straightforward way, although I admit it is a bit unorthodox.
        setScopedValue(ValueKeys.CURRENT_SALE_LINE, depositLine);
        CalculateSaleItemTaxOp taxOp = new CalculateSaleItemTaxOp();
        taxOp.handleOpExec(null);

        return deposit;
    }

    /**
     * Gets the non voided lines.
     *
     * @param argOrder the order
     * @return the non voided lines
     */
    protected List<IOrderLine> getNonVoidedLines(IOrder argOrder) {

        List<IOrderLine> nonVoidedLines = new ArrayList<IOrderLine>();

        if (argOrder != null) {
            for (IOrderLine orderLine : argOrder.getOrderLines()) {
                if (!orderLine.getVoid()) {
                    nonVoidedLines.add(orderLine);
                }
            }
        }

        return nonVoidedLines;
    }

    /**
     * Returns the deposit modifier associated with <code>argOrderLine</code>. If a balance modifier for a
     * deposit does not exist, one is created and add to <code>argOrderLine</code>.
     * @param argOrderLine the order for which a setup fee is being returned
     * @return the deposit modifier associated with <code>argOrderLine</code>
     */
    protected IBalanceModifier getOrCreateDepositModifier(
            IOrderLine argOrderLine) {

        IBalanceModifier depositMod = getDepositModifier(argOrderLine);

        if (depositMod == null) {
            depositMod = createObject(IBalanceModifier.class);
            depositMod.setTypeCode(DEPOSIT.getName());
            argOrderLine.addBalanceModifier(depositMod);
        }

        return depositMod;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {

        boolean applicable = false;
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        BigDecimal depositAmount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);

        if ((currentOrder != null) && NEW.matches(currentOrder.getStatusCode())
                && (depositAmount != null)) {
            /* BEGIN BZ38351 */
            if (OrderType.STANDARD_DELIVERY.matches(currentOrder.getOrderType())) {
                HashMap<String, BigDecimal> hashOrderShippingFee = CawGetListsShippingFee
                        .getTotalOrderShippingFee();
                if (hashOrderShippingFee == null) {
                    applicable = false;
                } else {
                    applicable = true;
                }

            } /* END BZ38351 */
            else {
                applicable = true;
            }
        }
        return applicable;
    }
}
