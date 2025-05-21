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
 * BZ45947          260821     [Internal] Cannot apply a transaction discount to a kiosk order or a mix transaction of sale and kiosk order
 *===================================================================
 */

package caw.pos.pricing.discount.validation;

import javax.inject.Inject;

import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.order.OrderMgr;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawAnyOrderPickupLinesValidationRule extends AbstractValidationRule {

    @Inject
    private OrderMgr _orderMgr;

    @Override
    public IValidationResult validate() {
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        if (currentOrder != null) {
            OrderType orderType = OrderType.forName(currentOrder.getOrderType());
            if (OrderType.STANDARD_PICKUP == orderType) {
                if (!currentOrder.getOrderLines().isEmpty()) {
                    return SimpleValidationResult.getFailed("_itemChangeNotAllowed");
                }
            }
        }

        return IValidationResult.SUCCESS;
    }

}
