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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * 
 *===================================================================
 */

package caw.pos.order;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawRemovedAllOrderItemsOp extends Operation {

    @Inject
    private OrderMgr _orderMgr;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IOrder currentOrder = this._orderMgr.getCurrentOrder();

        List<IOrderLine> currentOrderLines = currentOrder.getOrderLines();

        List<IOrderLine> newOrderLines = new ArrayList<IOrderLine>();

        for (IOrderLine orderLine : currentOrderLines) {

            orderLine.setVoid(true);
            orderLine.getShadowedSaleItem().setVoid(true);
            newOrderLines.add(orderLine);
        }

        currentOrderLines = newOrderLines;
        currentOrder.setOrderLines(currentOrderLines);
        newOrderLines = new ArrayList<IOrderLine>();
        _orderMgr.setCurrentOrder(currentOrder);

        return HELPER.completeResponse();
    }
}
