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
 * BZ43625          190521    [Internal] [7.0.10] HDE every time the order is updated from the Order Maintenance screen 
 * BZ43753          240521    [Internal] Xstore Order Worklist should not display delivery orders
 * BZ62616          032624    Disable BOPIS in Xstore
 *===================================================================
 */

package caw.pos.order;

import static dtv.pos.order.OrderConstants.getDownloadInterval;
import static dtv.pos.order.OrderConstants.getStatusRequestInterval;
import static java.util.concurrent.TimeUnit.MINUTES;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

import javax.inject.Inject;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IQueryResultList;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.*;
import dtv.util.IDateProvider;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.xom.impl.order.OrderType;
import dtv.xst.xom.order.IOrderQueryResult;

/**
 *
 */
public class CawOrderUtil extends OrderUtil {

    private boolean                  _backgroundProcessesStarted     = false;

    private OrderDownloadWorker      _downloadWorker;

    private static final int         DEFAULT_DOWNLOAD_INTERVAL       = 15;

    private static final int         DEFAULT_STATUS_REQUEST_INTERVAL = 60;

    public static final String CAW_ORDER_ENABLE = System.getProperty("caw.pos.order.enable");//BZ62616
    
    @Inject
    private ScheduledExecutorService _executorService;

    private StatusRequestWorker      _statusRequestWorker;

    /* BEGIN BZ43753 */
    /**
     * Returns the current order work list.
     *
     * @param argRetailLocationId the retail location id
     * @return the current order work list
     */
    @Override
    public List<IOrderQueryResult> getOrderWorkList(long argRetailLocationId) {

        Map<String, Object> queryParams = new HashMap<String, Object>();

        queryParams.put("argOrganizationId", ConfigurationMgr.getOrganizationId());
        queryParams.put("argWorklistSourceLocationId", String.valueOf(argRetailLocationId));
        queryParams.put("argNotOrderType", OrderType.STANDARD_DELIVERY.getName()); // BZ-43753

        List<IOrderQueryResult> results = DataFactory
                .getObjectByQueryNoThrow(OrderConstants.ORDER_SEARCH_QUERY, queryParams);
        cleanUpResults(results, argRetailLocationId);
        Collections.sort(results, new OrderResultWithPriorityComparator());

        return results;
    }

    /**
     * Two logic is done here so we don't need to do 2 DB queries in getting the order lines of the order local
     * to the store. The order lines will determine the action required text and the priority of the each order
     * in the work list.
     * @param argResults
     */
    private void cleanUpResults(List<IOrderQueryResult> argResults,
            long argRetailLocationId) {

        Map<String, Object> queryParams = new HashMap<String, Object>();

        for (IOrderQueryResult result : argResults) {
            queryParams.clear();
            queryParams.put("argOrganizationId", ConfigurationMgr.getOrganizationId());
            queryParams.put("argOrderId", result.getOrderId());

            // Retrieve an order's order lines sourced from this store location
            IQueryResultList<IOrderLine> orderLines = DataFactory
                    .getObjectByQueryNoThrow(OrderConstants.ORDER_LINES_SEARCH_BY_ORDER_ID_QUERY, queryParams);

            // determine the action key using the line item statuses. the action key is based on order lines
            // sourced from this store location only.
            String actionRequired = determineActionKey(orderLines, argRetailLocationId);

            if (result.isUnderReview()) {
                actionRequired = "_orderWorklistUnderReview";
            }

            result.setActionRequired(actionRequired);
            // determine the priority of the order that are used in sorting order work list prompt.
            result.setPriority(determinePriority(orderLines, argRetailLocationId));
        }
    }
    /* END BZ43753 */

    /**
     * Starts the background processes to periodically download new orders and to periodically request existing
     * orders' statuses from the order service provider. If the processes have already been started, then this
     * method does nothing. Only one set of background processes will ever be started regardless of how many
     * OrderHelper instances may exist.
     *
     * @param argOrderHelper the order helper
     * @param argStationState the station state
     * @param argDateProvider the date provider
     */
    @Override
    public void startPollingProcesses(OrderHelper argOrderHelper,
            StationState argStationState, IDateProvider argDateProvider) {

        if(CAW_ORDER_ENABLE != null && CAW_ORDER_ENABLE.equalsIgnoreCase(CawConstants.TRUE_STRING)) {//BZ62616
            if (!_backgroundProcessesStarted) {
                _backgroundProcessesStarted = true;
                _downloadWorker = new CawOrderDownloadWorker(argOrderHelper,
                        argStationState, argDateProvider);
                int downloadInterval = getDownloadInterval();
                int dlInterval = (downloadInterval == 0) ? DEFAULT_DOWNLOAD_INTERVAL : downloadInterval;
    
                _statusRequestWorker = new StatusRequestWorker();
                int statusInterval = getStatusRequestInterval();
                int srInterval = (statusInterval == 0) ? DEFAULT_STATUS_REQUEST_INTERVAL : statusInterval;
    
                _executorService
                        .scheduleWithFixedDelay(_downloadWorker, dlInterval, dlInterval, MINUTES);
                _executorService
                        .scheduleWithFixedDelay(_statusRequestWorker, srInterval, srInterval, MINUTES);
            }
        }
    }
    
    // Begin BZ-43625
    /**
     * Forces the order notification logic to run.
     */
    @Override
    public void updateNotification() {

        _downloadWorker.updateNotifications();
    } // End BZ-43625
}
