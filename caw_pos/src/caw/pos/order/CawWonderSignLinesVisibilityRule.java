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

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawConstants;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.order.OrderMgr;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;
/**
 *
 */
public class CawWonderSignLinesVisibilityRule extends AbstractVisibilityRule {

    @Inject
    private OrderMgr _orderMgr;

    @Override
    protected IAccessLevel checkVisibilityImpl() {
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        AccessLevel accessLevel = AccessLevel.GRANTED;
        if (currentOrder != null && !currentOrder.getOrderLines().isEmpty()) {
            List<IOrderLine> orderLines = currentOrder.getOrderLines();
            ISaleReturnLineItem lineItem = null;
            for(IOrderLine oderLineItem : orderLines) {
                lineItem = oderLineItem.getShadowedSaleItem();
                //has wondersign item => allow exit order
                if(lineItem != null && !StringUtils.isEmpty(lineItem.getStringProperty(CawConstants.WONDERSIGN_CART_ID))) {
                    return AccessLevel.GRANTED;
                }
            }
            //has order item => not allow exit order
            accessLevel = AccessLevel.DENIED;
        }
        return accessLevel;
    }
}
