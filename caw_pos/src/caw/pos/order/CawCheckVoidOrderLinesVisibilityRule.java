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
 * BZ38354          091020    [Internal] Change Items and Add discount button should be disabled in case there are no any order items into the order transaction
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;

public class CawCheckVoidOrderLinesVisibilityRule extends AbstractVisibilityRule {

    @Inject
    private OrderMgr _orderMgr;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IAccessLevel access = AccessLevel.DENIED;
        IOrder order = _orderMgr.getCurrentOrder();
        boolean orderNotVoid = CawOrderHelper.getInstance().isOrderLinesNotVoid(order);
        if(orderNotVoid) {
            access = AccessLevel.GRANTED;
        }
        return access;
    }

}
