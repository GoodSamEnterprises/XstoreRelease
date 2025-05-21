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
 * BZ47630          131221    [Internal patch 7.0.16-17] Enable Reject Order button - Incorrect order line item status when do a partial reject
 *===================================================================
 */

package caw.pos.order;

import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawConstants;

import dtv.pos.common.TransactionHelper;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.pos.order.UpdateCancelledOrderOp;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.xom.impl.order.OrderLineStatus;

public class CawUpdateCancelledOrderOp extends UpdateCancelledOrderOp {
    @Inject
    private OrderMgr _orderMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        List<IOrderLine> cancelledLines = new ArrayList<IOrderLine>();
        List<IOrderLine> cancelledOriginalLines = new ArrayList<IOrderLine>();
        if (currentOrder != null) {
            Iterator<?> var4 = currentOrder.getOrderLines().iterator();

            while (var4.hasNext()) {
                IOrderLine orderLine = (IOrderLine) var4.next();
                if (!orderLine.getVoid() && OrderLineStatus.CANCELLED.matches(orderLine.getStatusCode())
                        && orderLine.getShadowedSaleItem() != null ) {
                    //BEGIN BZ47630
                    if (orderLine.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE) == null) {
                        cancelledLines.add(orderLine);
                    }
                    else {
                        cancelledOriginalLines.add(orderLine);
                    }
                    //END BZ47630
                }
            }
        }
        //BEGIN BZ47630
        for (IOrderLine cancelOriginalLine : cancelledOriginalLines) {
            cancelledLines.add(cancelOriginalLine);
        }
        //END BZ47630
        IOrder updatedOrder = CawOrderHelper.getInstance().updateOrderLinesStatus(currentOrder, cancelledLines,
                OrderLineStatus.CANCELLED, this._stationState.getRetailLocationId(),
                Long.toString(this._stationState.getSystemUser().getOperatorId())); //BZ47440
        TransactionHelper.addPersistable(updatedOrder);
        return this.HELPER.completeResponse();
    }
}
