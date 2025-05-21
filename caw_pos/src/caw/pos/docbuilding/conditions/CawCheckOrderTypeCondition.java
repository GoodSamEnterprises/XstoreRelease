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
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import javax.inject.Inject;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawCheckOrderTypeCondition extends AbstractInvertableCondition {

    @Inject
    private OrderMgr      _orderMgr;

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        IOrder currentOrder = _orderMgr.getCurrentOrder();
       
        if (OrderType.STANDARD_PICKUP.matches(currentOrder.getOrderType()) 
                && OrderStatus.READY_FOR_PICK_UP.matches(currentOrder.getStatusCode())) {
            // Order pickup
            return true;
        }
        
        // Order Creation
        return false;
    }
}