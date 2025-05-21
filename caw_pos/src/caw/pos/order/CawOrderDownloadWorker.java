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
 * BZ42630          170521    [Requirement] What is the effort and timeline to suppress the display of delivery orders from appearing in other areas of Xstore?
 *===================================================================
 */

package caw.pos.order;

import static dtv.data2.access.DataFactory.getObjectByIdNoThrow;
import static dtv.data2.access.DataFactory.makePersistent;
import static dtv.pos.order.OrderConstants.isReceivingDocumentCreationEnabled;
import static dtv.xst.xom.impl.order.OrderLineStatus.*;
import static dtv.xst.xom.impl.order.OrderType.*;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.IDataModel;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderDownloadWorker;
import dtv.pos.order.OrderHelper;
import dtv.util.IDateProvider;
import dtv.xst.dao.inv.IInventoryDocument;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderDownloadWorker extends OrderDownloadWorker {

    private static final Logger  _logger                  = LogManager.getLogger(CawOrderDownloadWorker.class);

    private static final boolean _debugLogging            = _logger.isDebugEnabled();

    private OrderHelper          _orderHelper;

    private StationState         _stationState;

    private IDateProvider        _transDateProvider;

    private final boolean        _createReceivingDocument = isReceivingDocumentCreationEnabled();

    /**
     * 
     */
    public CawOrderDownloadWorker(OrderHelper argOrderHelper,
            StationState argStationState, IDateProvider argDateProvider) {
        
        super(argOrderHelper, argStationState, argDateProvider);
        
        this._orderHelper = argOrderHelper;
        this._stationState = argStationState;
        this._transDateProvider = argDateProvider;
        
        super.updateNotifications();
    }

    /** {@inheritDoc} */
    @Override
    public void run() {

        if (_debugLogging) {
            _logger.debug("Running CawOrderDownloadWorker...");
        }

        List<? extends IOrder> downloadedOrders = super.download();
        List<IDataModel> modelsToPersist = new ArrayList<IDataModel>();
        Map<String, IOrder> cachedOrders = new HashMap<String, IOrder>();

        // Acknowledge that the order has been downloaded.
        for (IOrder downloadedOrder : downloadedOrders) {
            IOrder existingOrder = null, orderToPersist = null;
            List<IOrderLine> newLines = new ArrayList<IOrderLine>();
            List<IOrderLine> intransitLines = new ArrayList<IOrderLine>();

            boolean isCachedOrder = cachedOrders.containsKey(downloadedOrder.getOrderId());
            if (isCachedOrder) {
                // First try to get the order already loaded into memory cache. This step is necessary since there can
                // be two downloaded orders of the same order id: one with new lines and the other with intransit
                // lines.
                existingOrder = cachedOrders.get(downloadedOrder.getOrderId());
            } else {
                // Check if an order with this id already exists. If it does, any new details will be added to it.
                existingOrder = (IOrder) getObjectByIdNoThrow(downloadedOrder.getObjectId());
            }

            if (existingOrder != null) {
                orderToPersist = handleExistingOrder(existingOrder, downloadedOrder, newLines, intransitLines);

                if (THIRD_PARTY_PICKUP.matches(orderToPersist.getOrderType())) {
                    newLines = downloadedOrder.getOrderLines().stream()
                            .filter(orderLine -> NEW
                                    .matches(orderLine.getStatusCode()))
                            .collect(Collectors.toList());
                    
                    intransitLines = downloadedOrder.getOrderLines().stream()
                            .filter(orderLine -> IN_TRANSIT
                                    .matches(orderLine.getStatusCode()))
                            .collect(Collectors.toList());
                }
            } else {
                orderToPersist = handleNonExistingOrder(downloadedOrder, newLines, intransitLines);
            }

            // No need to add the order to cache or persist it again. We are just adding lines to an order in
            // the cache and in modelsToPersist already.
            if (!isCachedOrder) {
                // Start BZ42630: do not add Order Delivery into database
                if (!STANDARD_DELIVERY.matches(orderToPersist.getOrderType())) {
                    modelsToPersist.add(orderToPersist);
                    cachedOrders.put(orderToPersist.getOrderId(), orderToPersist);
                }
                // End BZ42630
            }

            if (newLines.size() > 0) {
                _orderHelper
                        .updateOrderLinesStatus(downloadedOrder, newLines, POLLED, _stationState
                                .getRetailLocationId(), Long
                                        .toString(_stationState.getSystemUser()
                                                .getOperatorId()));
            }

            if (intransitLines.size() > 0) {
                _orderHelper
                        .updateOrderLinesStatus(downloadedOrder, intransitLines, IN_TRANSIT_POLLED, _stationState
                                .getRetailLocationId(), Long
                                        .toString(_stationState.getSystemUser()
                                                .getOperatorId()));

                // Add downloaded intransit polled order items to receiving document. We are only doing this for
                // standard pickup orders in this worker. For delayed pickup and thirdparty pickup orders,
                // StatusRequestWorker is responsible for adding intransit order lines to its receiving document.
                if (_createReceivingDocument && STANDARD_PICKUP
                        .matches(downloadedOrder.getOrderType())) {
                    IInventoryDocument receivingDoc = _orderHelper
                            .processReceivingDocumentForOrderItems(_transDateProvider, downloadedOrder, intransitLines, _stationState
                                    .getRetailLocationId());
                    if (receivingDoc != null) {
                        modelsToPersist.add(receivingDoc);
                    }
                }
            }
        }

        // Store the downloaded orders so action can be taken on them.
        if (!modelsToPersist.isEmpty()) {
            makePersistent(modelsToPersist);
        }

        // Post a notification so that users are aware of new orders.
        updateNotifications();
    }
}
