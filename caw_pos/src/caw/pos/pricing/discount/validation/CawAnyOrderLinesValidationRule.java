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
 * BZ41379          022221    Requirement - Disabled Mixed Order Transactions in Xstore
 *===================================================================
 */

package caw.pos.pricing.discount.validation;

import javax.inject.Inject;

import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.order.OrderMgr;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawAnyOrderLinesValidationRule extends AbstractValidationRule {

    @Inject
    private OrderMgr _orderMgr;

    @Override
    public IValidationResult validate() {

        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        if (currentOrder != null && !currentOrder.getOrderLines().isEmpty()) {
            return SimpleValidationResult.getFailed("_itemChangeNotAllowed");
        }
        return IValidationResult.SUCCESS;
    }

}
