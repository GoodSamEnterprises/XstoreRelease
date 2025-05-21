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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.ui.model.DefaultListInputModel;
import dtv.pos.order.OrderHelper;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderItemListModel extends DefaultListInputModel {

    private static final Logger _logger = LogManager.getLogger(CawOrderItemListModel.class);

    public CawOrderItemListModel(List<IOrderLine> argOrderLines) {
        super();
        try {
            getModel().setElements(argOrderLines);
            getSelectionModel().clearSelection();
        } catch (Exception ex) {
            _logger.error("An exception occurred in during get CawOrderItemListModel.getModel()" + ex.getMessage());
        }
    }

    public void refreshOrderLines(OrderHelper orderHelper, IOrder order,
            int retailLocationId) {

        try {
            IOrder updatedOrder = orderHelper.lookupOrder(order, retailLocationId);
            if (updatedOrder != null) {
                getModel().setElements(updatedOrder.getOrderLines());
                getSelectionModel().clearSelection();
                DataFactory.makePersistent(updatedOrder);
            }
        } catch (Exception var7) {
            _logger.error("An exception occurred attempting to retrieve the status for order ["
                    + order + "] from the service provider.", var7);
        }
    }
}
