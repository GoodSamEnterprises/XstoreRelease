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
 * BZ40776          290121    [UAT] Duplicate and Missed Order service Messages on order status change in Xstore
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.TransactionHelper;
import dtv.pos.common.TransactionStatus;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.maint.CreateStatusUpdateTransactionOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawCreateStatusUpdateTransactionOp
        extends CreateStatusUpdateTransactionOp {

    /*BEGIN BZ42307*/
    private static final String REJECT_ITEM_PROPERTY       = "ORDER_REJECT_ITEM";

    private static final String REJECT_ITEM_QTY_PROPERTY   = "ORDER_REJECT_ITEM_QTY";

    private static final String ORDER_UNFULFILLABLE_STATUS = "UNFULFILLABLE";

    private static final String ORDER_CANCELLED_STATUS     = "CANCELLED";
    /*END BZ42307*/
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IPosTransaction transaction = this.getTransaction();
        IOrder modeledOrder = this.getScopedValue(ValueKeys.SELECTED_ORDER);
        IReasonCode reasonCode = this.getScopedValue(ValueKeys.SELECTED_REASON_CODE);
        transaction.setStringProperty("ORDER_ID", modeledOrder.getOrderId());
        /*BEGIN BZ40776*/
        if (modeledOrder.getOrderLines() != null
                && modeledOrder.getOrderLines().size() > 0) {
            for (IOrderLine line : modeledOrder.getOrderLines()) {
                if (line.getStatusCode() != null && line.getStatusCode().length() > 0 
                        && !ORDER_UNFULFILLABLE_STATUS.equals(line.getStatusCode())
                        && !ORDER_CANCELLED_STATUS.equals(line.getStatusCode())) {
                    transaction.setStringProperty("ORDER_STATUS_LINES", line.getStatusCode());
                    break;
                }
            }
        }
        /*END BZ40776*/
        if (reasonCode != null) {
            transaction.setStringProperty("ORDER_REJECT_REASON", reasonCode.getReasonCode());
        }
        /*BEGIN BZ42307*/
        //save items attribute into DB to sent OS
        List<IOrderLine> orderRectedLines = this.getScopedValue(CawValueKeys.ORDER_REJECTED_LINES);
        if(orderRectedLines != null && orderRectedLines.size() > 0) {
            rejectAddProperties(orderRectedLines, transaction);
        }
        /*END BZ42307*/
        TransactionHelper.completeTransaction(transaction, TransactionStatus.COMPLETE);

        return this.HELPER.completeResponse();

    }

    /*BEGIN BZ42307*/
    private void rejectAddProperties(List<IOrderLine> argOrderLines, IPosTransaction argtransaction) {
        String itemProperty = null;
        String itemQtyProperty = null;
        for (int i = 0; i < argOrderLines.size(); ++i) {
            IOrderLine orderLine = argOrderLines.get(i);
            itemProperty = String.format("%s_%x", REJECT_ITEM_PROPERTY, i+1);
            itemQtyProperty = String.format("%s_%x", REJECT_ITEM_QTY_PROPERTY, i+1);
            argtransaction.setStringProperty(itemProperty, orderLine.getItemId());
            argtransaction.setDecimalProperty(itemQtyProperty, orderLine.getQuantity());
        }
        argtransaction.setStringProperty("ORDER_STATUS_LINES", "REJECTED");
    }
    /*END BZ42307*/
    
}
