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
 * BZ38384          121020    [Internal] Xstore does not make a call Shipping API at Exit Order button when mixing order items firstly then Sale items types.
 * BZ38546          141020    [Internal] Xstore does not back to Sale screen when Hit Exit Order button during creating a Pickup Order
 * BZ45877          130821    [Internal] Xstore should not call Shipping Rates and Tax API if there is no item in the Electric World order
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

public class CawValidateShipMethodHasNotChangedOp extends Operation {
    
    private static final Logger _logger = LogManager.getLogger(CawValidateShipMethodHasNotChangedOp.class);

    @Inject
    private OrderMgr _orderMgr;
    
    /* BEGIN BZ38546 */
    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {

        /*BEGIN BZ45877*/
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
        /*END BZ45877*/
        return isExistOrderLine && CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
        
    } /* END BZ38546 */
    
   
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        IOpResponse response = HELPER.completeResponse();
        IOrder currOrder = _orderMgr.getCurrentOrder();
        IPosTransaction trans = this._transactionScope.getTransaction();
        boolean isExistShipMethod = CawShippingRateHelper.getInstance().isExistShipMethod(currOrder);
        boolean isAddingShipMethod = CawShippingRateHelper.getInstance().isAddingShippingMethod(trans);
        
        if (isAddingShipMethod && !isExistShipMethod) {
            return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_SETUP_SHIPPING_METHODS"));
        } 
        
        return response;  
    }

}
