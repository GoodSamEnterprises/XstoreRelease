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
 * BZ45962          260821    [Internal] Phase 1 Electric World - Xstore should not send the Product Availability request to OB when changing qty for a kiosk order item
 *===================================================================
 */

package caw.pos.order;

import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawPropertyUtils;
import caw.pos.ejournal.CawTransactionSearchHelper;
import oracle.retail.xstore.inv.lookup.ILocationResult;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.order.*;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderType;

/**
 *
 */
public class CawLocateItemChangeQuantityOp extends LocateItemChangeQuantityOp {
    
    @Inject
    private OrderMgr _orderMgr;
    
    @Inject
    private OrderHelper _orderHelper;
    
    @Inject
    private CawTransactionSearchHelper   _cawTransactionSearchHelper;
    
    @SuppressWarnings("cast")
    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {
        String enableWondersign = _cawTransactionSearchHelper.getCodeValue(CawConstants.CAW_KIOSK_ORDER_ENABLE);
        if (CawConstants.TRUE_STRING.equalsIgnoreCase(enableWondersign)) {
            IOrder currentOrder = _orderMgr.getCurrentOrder();
            if (currentOrder != null && currentOrder.getOrderType() != null) {
                OrderType orderType = OrderType.forName(currentOrder.getOrderType());

                if (OrderType.STANDARD_DELIVERY == orderType && CawPropertyUtils.CAW_WONDERSIGN_SKIP_PRODUCT_AVAILABILITY_API) {

                    ISaleReturnLineItem lineItem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
                    if (lineItem != null && lineItem.getProperty(CawConstants.WONDERSIGN_CART_ID) != null) {
                        
                        List<? extends ILocationResult> locations = null;
                        List<ILocationResult> results = Collections.singletonList(_orderHelper.getGenericShippingLocation());

                        if (results != null && results.size() == 1) {
                            locations = results;
                        }

                        List<? extends ILocationResult> filteredResults = getLocationFilter().filter(locations, currentOrder.getOrderType());
                        
                        return filteredResults.toArray();
                    }
                }
            }
        }
        
        return super.getPromptList(argEvent);
    }

}
