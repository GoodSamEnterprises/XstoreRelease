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
 * BZ47440          071221    [Internal patch 7.0.16] Order Complete Receipt - Deposit/Payments and Balance Due printed incorrectly when picking up an BOPIS that contained cancelled item
 *===================================================================
 */

package caw.xst.xom.locate.impl.order.lookup.resp;

import java.util.Iterator;

import com.microsretail.locate.FulfillmentResponseMessageItemTypeBean;
import com.microsretail.locate.FulfillmentResponseMessageOrderTypeBean;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.OrderType;
import dtv.xst.xom.locate.impl.Utils;
import dtv.xst.xom.locate.impl.order.LocateOrderType;
import dtv.xst.xom.locate.impl.order.lookup.resp.LocateFulfillmentItemDetailsToXstoreOrderLinesAdapter;

/**
 *
 */
public class CawLocateFulfillmentItemDetailsToXstoreOrderLinesAdapter extends LocateFulfillmentItemDetailsToXstoreOrderLinesAdapter {

    @Override
    public void adapt(Object argSource, Object argTarget) {
        FulfillmentResponseMessageOrderTypeBean locateOrder = (FulfillmentResponseMessageOrderTypeBean) argSource;
        IOrder xstoreOrder = (IOrder) argTarget;
        OrderType orderType = Utils.getOrderType(locateOrder);
        LocateOrderType locateOrderType = LocateOrderType.valueOf(locateOrder.getTransactionTypeId());
        String externalId = String.valueOf(locateOrder.getRequestId());
        Iterator var8 = locateOrder.getItems().getItemDetails().iterator();

        while (var8.hasNext()) {
            FulfillmentResponseMessageItemTypeBean locateItem = (FulfillmentResponseMessageItemTypeBean) var8.next();
            IOrderLine xstoreItem = this._dataServices.create(IOrderLine.class);
            long organizationId = this._persistenceDefaults.getOrganizationId();
            xstoreItem.setOrganizationId(organizationId);
            xstoreItem.setFulfillmentType(orderType.getFulfillmentMethod().getName());
            xstoreItem.setOrderId(locateOrder.getOrderId());
            xstoreItem.setExternalOrderId(externalId);
            xstoreItem.setLineNumber(locateItem.getLineItemNo());
            xstoreItem = this.adaptItem(locateItem, xstoreItem);
            xstoreItem = this.adaptTaxes(locateItem, xstoreItem);
            xstoreItem = this.adaptSourceInfo(locateOrderType, locateOrder, locateItem, xstoreItem);
            xstoreItem = this.adaptFulfillmentInfo(locateOrderType, locateOrder, locateItem, xstoreItem);
            xstoreItem.setSelectedShipMethod(locateOrder.getShipVia());
            xstoreOrder.addOrderLine(xstoreItem);
            
            xstoreItem.setSequence(Integer.parseInt(locateItem.getRequestingSystemLineNo()));
            

           
            if (xstoreItem.getStringProperty(CawConstants.CAW_OB_MAPPING_LINE) == null) {
                IOrderLineProperty orderLineProperty = DataFactory.createObject(IOrderLineProperty.class);
                orderLineProperty.setOrganizationId(xstoreItem.getOrganizationId());
                orderLineProperty.setSequence(xstoreItem.getSequence());
                orderLineProperty.setPropertyCode(CawConstants.CAW_OB_MAPPING_LINE);
                orderLineProperty.setType("STRING");
                orderLineProperty.setStringValue("{requesting_system_line_no:" + Integer.parseInt(locateItem.getRequestingSystemLineNo()) + ",line_no:" + locateItem.getLineItemNo() + "}" );
                xstoreItem.addOrderLineProperty(orderLineProperty);
            }
        }

        xstoreOrder = this.adaptItemShipping(locateOrder, xstoreOrder);
        this.adaptBalanceDue(locateOrder, xstoreOrder);
    }
}
