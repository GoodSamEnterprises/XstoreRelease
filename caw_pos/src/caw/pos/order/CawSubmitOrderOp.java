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
 * BZ44528          220821    Electric World & Mobile POS Implementation (Phase 1)
 *===================================================================
 */

package caw.pos.order;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawPropertyUtils;
import caw.pos.ejournal.CawTransactionSearchHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.TransactionHelper;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.*;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;
import dtv.xst.xom.impl.order.OrderType;
import dtv.xst.xom.order.IOrderSubmitResponse;

/**
 *
 */
public class CawSubmitOrderOp extends SubmitOrderOp {
    private static final Logger _logger = LogManager.getLogger(CawSubmitOrderOp.class);

    @Inject
    private OrderMgr            _orderMgr;

    @Inject
    private OrderHelper         _orderHelper;
    
    @Inject
    private CawTransactionSearchHelper   _cawTransactionSearchHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IOpResponse response = this.HELPER.completeResponse();
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        TransactionHelper.addPersistable(currentOrder);
        IPosTransaction trans = this._transactionScope.getTransaction();
        String orderTransId = String.valueOf(trans.getTransactionSequence());

        try {
            if (!this.isWonderSignOrder()) {
                IOrderSubmitResponse submitResponse = _orderHelper.submitOrder(currentOrder, orderTransId
                        , Long.toString(this._stationState.getSystemUser().getOperatorId()));
                currentOrder = submitResponse.getOrder();
                currentOrder.setStatusCode(OrderStatus.OPEN.getName());
                this._orderMgr.setCurrentOrder(currentOrder);
                if (submitResponse.containsCriticalFailure()) {
                    response = this.HELPER.getCompletePromptResponse(OrderConstants.CRITICAL_ERROR_PROMPT, new IFormattable[0]);
                }
            }
            
        }  catch (Exception var8) {
            _logger.error("An exception was caught submitting order [" + currentOrder.getOrderId() + "]", var8);
        }

        return response;
    }

    /**
     * The method returns true if this is an Order create by WonderSign workflow.
     * @return
     */
    protected boolean isWonderSignOrder() {
        boolean isWonderSignOrder = false;
        String enableWondersign = _cawTransactionSearchHelper.getCodeValue(CawConstants.CAW_KIOSK_ORDER_ENABLE);
        if (CawConstants.TRUE_STRING.equalsIgnoreCase(enableWondersign)) {
            IOrder currentOrder = _orderMgr.getCurrentOrder();
            if (currentOrder != null && currentOrder.getOrderType() != null) {

                OrderType orderType = OrderType.forName(currentOrder.getOrderType());
                if (OrderType.STANDARD_DELIVERY == orderType && CawPropertyUtils.CAW_WONDERSIGN_SKIP_ORDER_SUBMIT_API) {
                    List<IRetailTransactionLineItem> lineItems = _transactionScope.getTransaction()
                            .getRetailTransactionLineItems();

                    for (IRetailTransactionLineItem line : lineItems) {
                        if (line.getProperty(CawConstants.WONDERSIGN_CART_ID) != null) {
                            isWonderSignOrder = true;
                            break;
                        }
                    }
                }
            }
        }

        return isWonderSignOrder;
    }

}
