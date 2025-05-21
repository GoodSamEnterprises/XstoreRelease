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
 * BZ45877          130821    [Internal] Xstore should not call Shipping Rates and Tax API if there is no item in the Electric World order
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderValidationCondition extends AbstractRunCondition {

    private static final Logger _logger = LogManager.getLogger(CawOrderValidationCondition.class);

    @Inject
    private OrderMgr            _orderMgr;

    @Override
    protected boolean shouldRunImpl() {

        boolean isExistOrderLine = Boolean.FALSE;
        try {
            IOrder currentOrder = this._orderMgr.getCurrentOrder();
            if (currentOrder != null && currentOrder.getOrderLines() != null 
                    && currentOrder.getOrderLines().size() > 0) {
                for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                    if (!orderLine.getVoid()) {
                        isExistOrderLine = Boolean.TRUE;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Cannot find the Order line item in the transaction.", ex.getMessage());
        }
        
        return isExistOrderLine;
    }

}
