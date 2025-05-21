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
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawWonderSignDisableRule extends AbstractVisibilityRule {

    @Inject
    private OrderMgr         _orderMgr;

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        AccessLevel accessLevel = AccessLevel.GRANTED;
        if (currentOrder != null && this._transactionScope.getValue(CawValueKeys.WS_SELECTED_ITEM_LIST) != null) {
            accessLevel = AccessLevel.DENIED;
        }
        return accessLevel;
    }
}
