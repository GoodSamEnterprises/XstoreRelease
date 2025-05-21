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
 * BZ38158          071020    [Task] Need to require email address on orders for Customer Notification
 *===================================================================
 */

package caw.pos.customer;

import javax.inject.Inject;

import dtv.pos.customer.EnsureExistingCustInfoPresentOp;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;
import dtv.xst.xom.impl.order.OrderType;

public class CawEnsureExistingCustInfoPresentOp extends EnsureExistingCustInfoPresentOp {

    @Inject
    private OrderMgr _oderMgr;

    @Override
    public boolean isOperationApplicable() {

        IOrder iOrder = _oderMgr.getCurrentOrder();
        if (iOrder != null) {
            if (OrderType.STANDARD_PICKUP.matches(iOrder.getOrderType())
                    && OrderStatus.NEW.matches(iOrder.getStatusCode())) {
                return true;
            }
        }
        return false;
    }
}