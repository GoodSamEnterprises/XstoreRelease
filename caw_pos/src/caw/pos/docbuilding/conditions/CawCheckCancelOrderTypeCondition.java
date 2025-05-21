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
 * BZ37709          080920    [Internal] Removing the customer's signature line on Store Copy receipt of Create Order transaction
 * BZ37954          180920    [Internal] - Changing Barcode on Order Customer Copy receipt to Barcode of transaction
 *===================================================================
 */
package caw.pos.docbuilding.conditions;

import static dtv.xst.xom.impl.order.OrderLineStatus.CANCELLED;

import javax.inject.Inject;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.order.OrderMgr;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawCheckCancelOrderTypeCondition extends AbstractInvertableCondition {

    @Inject
    private OrderMgr      _orderMgr;
    
    public CawCheckCancelOrderTypeCondition() {
        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }
    
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        IOrder currentOrder = _orderMgr.getCurrentOrder();

        if (currentOrder != null) {
            for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                if (CANCELLED.matches(orderLine.getStatusCode())) {
                    // print BARCODE ORDER for cancel order
                    return true;
                }
            }
        }
        return false;
    }
}