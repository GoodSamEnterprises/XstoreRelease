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
 * BZ37750          110920    Cannot close the message box informed Order Management System Offline when selecting Printing Pick List
 *===================================================================
 */

package caw.pos.order.maint;

import static dtv.data2.access.DataFactory.getObjectById;
import static dtv.data2.access.DataFactory.makePersistent;
import static dtv.pos.order.OrderConstants.ORDER_SEARCH_OFFLINE_PROMPT;
import static dtv.pos.order.OrderQueries.getAcceptedOrders;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.logging.log4j.*;
import caw.pos.common.CawValueKeys;
import dtv.pos.framework.op.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderHelper;
import dtv.service.ServiceException;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.exceptions.NotSupportedInTrainingModeException;
import dtv.xst.xom.impl.order.OrderLineStatus;
import dtv.xst.xom.impl.order.lookup.OrderPickSlipQueryResult;

/**
 *
 */
public class CawCheckForAcceptedOrdersOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawCheckForAcceptedOrdersOp.class);

    @Inject
    private OrderHelper         _orderHelper;

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        // BEGIN BZ37750
        Boolean isOrderBrokerOffline = getScopedValue(CawValueKeys.IS_ORDER_BORKER_OFFLINE);
        if (isOrderBrokerOffline != null
                && isOrderBrokerOffline.booleanValue() == true) {
            clearScopedValue(CawValueKeys.IS_ORDER_BORKER_OFFLINE);
            return HELPER.silentErrorResponse();
        }
        // END BZ37750

        IOpResponse response = HELPER.completeResponse();
        List<OrderPickSlipQueryResult> acceptedOrders = getAcceptedOrders(_stationState
                .getRetailLocationId());

        if (!acceptedOrders.isEmpty()) {
            // this holds the latest orders that has ACCEPTE item(s) in it.
            List<IOrder> finalAcceptedOrders = new ArrayList<IOrder>();
            List<IOrder> ordersToUpdate = new ArrayList<IOrder>();

            for (OrderPickSlipQueryResult queryResult : acceptedOrders) {
                OrderId orderId = (OrderId) queryResult.getObjectId();
                IOrder order = (IOrder) getObjectById(orderId);
                ordersToUpdate.add(order);
            }

            // get the latest status of each order from locate
            IOrder updatedOrder = null;

            for (IOrder order : ordersToUpdate) {
                try {
                    updatedOrder = _orderHelper.lookupOrder(order, _stationState
                            .getRetailLocationId());
                } catch (NotSupportedInTrainingModeException ex) {
                    _logger.warn(ex);
                    response = HELPER.getErrorResponse(_formattables
                            .getTranslatable(ex.getMessage()));
                    break;
                } catch (ServiceException ex) {
                    _logger.error("An exception occurred attempting to retrieve the status for order ["
                            + order + "] from the service provider.", ex);
                    setOpState(null);
                    response = HELPER.getPromptResponse(ORDER_SEARCH_OFFLINE_PROMPT);
                    
                    // BEGIN BZ37750
                    setScopedValue(CawValueKeys.IS_ORDER_BORKER_OFFLINE, true);
                    // END BZ37750
                    
                    break;
                }

                if (updatedOrder != null) {
                    // Persist the updated order so that functionality relying on data stored in Xstore (as opposed
                    // to stored in the the service provider) can have current data.
                    makePersistent(updatedOrder);
                    if (hasAcceptedItem(updatedOrder)) {
                        finalAcceptedOrders.add(updatedOrder);
                    }
                }
            }
        }

        return response;
    }

    /**
     * checks whether argOrder has an ACCEPTED item in it or not.
     *
     * @param argOrder the order
     * @return true, if successful
     */
    protected boolean hasAcceptedItem(IOrder argOrder) {

        boolean result = false;

        for (IOrderLine line : argOrder.getOrderLines()) {
            if (OrderLineStatus.ACCEPTED.getName()
                    .equals(line.getStatusCode())) {
                result = true;
                break;
            }
        }
        return result;
    }

}
