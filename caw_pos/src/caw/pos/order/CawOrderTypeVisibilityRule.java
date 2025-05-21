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
 * BZ38341          071020    [Internal] Need to be disable 'Pickup items' into detail screen for only Open Delivery order type.
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawOrderTypeVisibilityRule extends AbstractVisibilityRule {
    
    @Inject
    private OrderMgr             _oderMgr;;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        IOrder currentOrder = this._oderMgr.getCurrentOrder();
        IAccessLevel access = AccessLevel.DENIED;
        if (currentOrder != null && OrderType.STANDARD_PICKUP.matches(currentOrder.getOrderType())) {
            access = AccessLevel.GRANTED;
        }
        return access;
    }
}
