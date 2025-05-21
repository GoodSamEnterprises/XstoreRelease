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
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawConstants;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderPayment;

public class CawOrderReceiptSumRefundAmountCondition extends AbstractInvertableCondition {
    @Inject
    private OrderMgr _orderMgr;
    @Override
    protected boolean conditionMetImpl(Object argArg0) {
        
        boolean isSummaryRefundAmount = false;
        
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        List<IOrderPayment> listOrderPayments = currentOrder.getPayments();
        
        for (IOrderPayment orderPayment : listOrderPayments) {
            if (!orderPayment.getVoid()) {
                if (CawConstants.CAW_REFUND_CONSTANT.equalsIgnoreCase(orderPayment.getTypeCode())) {
                    isSummaryRefundAmount = true;
                }
            }
        }
        
        return isSummaryRefundAmount;
    }

}
