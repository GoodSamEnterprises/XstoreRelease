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
 * BZ26207          190718    New Requirement - Enable Work Order Functionalitys
 * BZ27107          080818    [1.6.5][Internal] Item Quantity in S&I did not flow to Xstore for Work Order Transaction
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ27248          230818    Warranty Items from S&I are not associated with the items covered
 * BZ27379          270818    [1.6.15] WO Xstore reflects the discount incorrectly for the WO line item
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 * BZ27712          121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29205          250119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29210          250119    [Internal] Order Service cannot send WO to EBS
 * BZ29245          300118    [Internal][OS] Attributes item#500 is sent to OS incorrectly info when doing WO REFUND after bundling these fixed related to WO into 2.1
 * BZ29884          270319    [Prod] Work Order Issues- warranty item price was changed after import into xstore
 * BZ30005          010419    [INTERNAL] Incorrect number of work order items displayed in Xstore
 * BZ30754          160519    [PORT 30531 to 5.0] [Prod] Unable to complete the WO if WO deposit is created in xstore offline mode
 * BZ30154          190619    [New Requirement] Xstore capture the Work Order line items' sale associate from S&I and forward it to Order Service as part of item attribute
 * BZ31943          170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 * BZ48749          060122    [PROD] Issues in xStore vs DW sales report
 * BZ61330          290124    Update tender options for Verified return, Unverified return, web orders and Tender Exchange
 *===================================================================
 */

package caw.pos.workorder.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.ejournal.CawTransactionSearchHelper;
import caw.pos.util.CawEBSHelper;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.data2.access.pm.PersistenceManagerType;
import dtv.hardware.types.HardwareType;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.type.LineItemType;
import dtv.pos.warranty.WarrantyHelper;
import dtv.util.CompositeObject.TwoPiece;
import dtv.util.DateUtils;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.cwo.IWorkOrderLineItem;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.*;

/**
 * Caw work order helper.
 */
public class CawWorkOrderHelper extends CawWorkOrderConstants {

    private static volatile CawWorkOrderHelper INSTANCE         = null;

    private static final Logger                _logger          = LogManager.getLogger(CawWorkOrderHelper.class);

    private boolean                            _ebsOnline       = true;

    private List<String>                       _notExist  = new ArrayList<>();
    
    public static CawWorkOrderHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawWorkOrderHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawWorkOrderHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @return the isEBSUnavailable
     */
    public boolean isEbsOnline() {

        return _ebsOnline;
    }

    /**
     * Get current customer id.
     * @param party
     * @return string
     */
    public String getCurrentCustomerId(IParty party) {

        String customerId = CawCustomerUtil.getAccountNumber(CawCatalystHelper.getLookupResponseData());

        if (customerId == null) {
            try {
                customerId = party.getAlternatePartyIds().get(0).getAlternateId();
            } catch (Exception ex) {
                _logger.error("WO customer is null: " + ex.getMessage());
            }
        }
        return customerId;
    }

    /**
     * WO sales channel template.
     * @param retailLocationId
     * @param workstationId
     * @return
     */
    private String workOrderSalesChannelTemplate(int retailLocationId, int workstationId) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.CAW_WORK_ORDER_SALE_CHANNEL);
        String body = request.getBody();
        body = body.replace(SALES_CHANNEL_ID, String.valueOf(retailLocationId));
        body = body.replace(CHANNEL_TYPE_ATTR, CawUtilFunction.formatParameter(JSON_RETAIL));
        body = body.replace(TERMINAL, String.valueOf(workstationId));

        return body;
    }

    /**
     * WO search request template.
     * @param retailLocationId
     * @param workstationId
     * @param currentCustomerId
     * @param maxResult
     * @return
     */
    private String getWorkOrderSearchTemplateBuf(int retailLocationId, int workstationId, String currentCustomerId,
            String maxResult) {

        String body = null;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CAW_WORK_ORDER_SEARCH_REQUEST);
            body = request.getBody();
            body = body
                    .replace(WORK_ORDER_SALES_CHANNEL, workOrderSalesChannelTemplate(retailLocationId, workstationId));
            body = body.replace(ACCOUNT_NUMBER, currentCustomerId);
            body = body.replace(MAX_RESULTS, maxResult);
        } catch (Exception ex) {
            _logger.error("getWorkOrderSearchTemplateBuf-1:", ex);
            body = null;
        }
        return body;
    }

    /**
     * WO lookup request template.
     * @param retailLocationId
     * @param workstationId
     * @param workOrderNumber
     * @return
     */
    private String getWorkOrderLookupTemplate(int retailLocationId, int workstationId, String workOrderNumber) {

        String body = null;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CAW_WORK_ORDER_LOOKUP_REQUEST);
            body = request.getBody();

            body = body
                    .replace(WORK_ORDER_SALES_CHANNEL, workOrderSalesChannelTemplate(retailLocationId, workstationId));
            body = body.replace(WORK_ORDER_ID, workOrderNumber);

        } catch (Exception ex) {
            _logger.error("getWorkOrderLookupTemplate-1:", ex);
            body = null;
        }
        return body;
    }

    /**
     * WO update status request template.
     * @param retailLocationId
     * @param workstationId
     * @param account
     * @param stateType
     * @return
     */
    private String workOrderUpdateStatusTemplate(int retailLocationId, int workstationId, String workOrderId,
            String stateType) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.CAW_WORK_ORDER_UPDATE_STATUS_REQUEST);
        String body = request.getBody();
        body = body.replace(WORK_ORDER_SALES_CHANNEL, workOrderSalesChannelTemplate(retailLocationId, workstationId));
        body = body.replace(WORK_ORDER_ID, workOrderId);
        body = body.replace(WORK_ORDER_STATUS, CawUtilFunction.formatParameter(stateType));

        return body;
    }

    /**
     * WO send update status request to EBS.
     * @param retailLocationId
     * @param workstationId
     * @param workOrderId
     * @param stateType
     */
    public void sendUpdateStatusToEBS(int retailLocationId, int workstationId, String workOrderId, String stateType) {

        try {
            //Build JSON template for update status template
            String body = this.workOrderUpdateStatusTemplate(retailLocationId, workstationId, workOrderId, stateType);
            //Send the request to EBS
            ResponseEntity<String> result = CawEBSHelper.getInstance().responseWorkOrderUpdateStatus(body);
            //No need to do anything here, we only send status
            if (result != null) {
                _logger.info("WO update status response: " + result.getStatusCode());
            }
        } catch (Exception ex) {
            _logger.error("WO send update status error: " + ex.getMessage());
        }
    }

    /**
     * WO send search request to EBS and get response.
     * @param retailLocationId
     * @param workstationId
     * @param currentCustomerId
     * @param maxResult
     * @return
     */
    public IQueryResultList<CawWorkOrderEBSQueryResult> searchWorkOrderEBS(int retailLocationId, int workstationId,
            String currentCustomerId, String maxResult) {

        IQueryResultList<CawWorkOrderEBSQueryResult> results = null;
        _ebsOnline = true;
        try {
            //Work Order: Build JSON template for Work Order Search request-------------
            String body = this
                    .getWorkOrderSearchTemplateBuf(retailLocationId, workstationId, currentCustomerId, maxResult);
            //Work Order: Send the request and get response via Neuron service-------
            ResponseEntity<String> result = CawEBSHelper.getInstance().responseWorkOrderSearch(body);
            //Work Order:: Parse the response to list of work order --------------
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    List<CawWorkOrderEBSQueryResult> workOrderQueryResults = this
                            .parseResponseOfWorkOrderSearch(result.getBody());
                    results = QueryResultList.makeList(workOrderQueryResults, CawWorkOrderEBSQueryResult.class);
                } else {
                    _ebsOnline = false;
                }
            }
        } catch (Exception ex) {
            _logger.error("WO send search request error: " + ex.getMessage());
        }
        return results;
    }

    /**
     * WO send lookup request to EBS and get response.
     * @param retailLocationId
     * @param workstationId
     * @param workOrderNumber
     * @return
     */
    public List<CawWorkOrderItem> lookupWorkOrderEBS(int retailLocationId, int workstationId, String workOrderNumber) {

        List<CawWorkOrderItem> listItemIds = null;

        _ebsOnline = true;
        try {
            //Work Order: build JSON template for work order lookup
            String body = this.getWorkOrderLookupTemplate(retailLocationId, workstationId, workOrderNumber);
            //Work Order: send the request and get response
            ResponseEntity<String> result = CawEBSHelper.getInstance().responseWorkOrderLookup(body);
            //Work Order: parse the response to work order object
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    listItemIds = this.parseWorkOrderItems(result.getBody());
                } else {
                    _ebsOnline = false;
                }
            }
        } catch (Exception ex) {
            _logger.error("WO send lookup request error: " + ex.getMessage());
        }
        return listItemIds;
    }

    /**
     * WO parse response to result object.
     * @param response
     * @return List<CawWorkOrderEBSQueryResult>
     */
    private List<CawWorkOrderEBSQueryResult> parseResponseOfWorkOrderSearch(String response) {

        List<CawWorkOrderEBSQueryResult> workOrderQueryResults = new ArrayList<>();
        try {

            JSONObject objects = new JSONObject(response);
            JSONArray orders = CawJSONUtils.getJSONArray(objects, JSON_ORDERS);

            if (orders != null && orders.length() > 0) {
                int nOrders = orders.length();
                CawWorkOrderEBSQueryResult order = null;
                JSONObject currentOrder = null;
                for (int i = 0; i < nOrders; i++) {

                    currentOrder = orders.getJSONObject(i);
                    order = parseWorkOrderHeader(currentOrder, false);
                    if (order != null) {
                        workOrderQueryResults.add(order);
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("WO parse search result error: " + ex.getMessage());
        }
        return workOrderQueryResults;
    }

    /**
     * Parse WO Header Information
     * @param currentOrder
     * @return
     */
    private CawWorkOrderEBSQueryResult parseWorkOrderHeader(JSONObject currentOrder, boolean isItemsRequired) {

        CawWorkOrderEBSQueryResult order = null;
        try {
            Date date = null;
            JSONObject customer = null;
            JSONArray items = null;

            //General Information for Work Order
            order = new CawWorkOrderEBSQueryResult();

            parseWorkOrderBase(order, currentOrder);

            date = CawUtilFunction.formatDateTime(currentOrder.getString(JSON_WO_DATE));
            order.setWoDateTime(date);
            order.setWoTotalWithTax(CawUtilFunction.vBigDecimal(currentOrder.getString(JSON_WO_TOTAL_WITH_TAX)));
            order.setWoCorrelationKey(currentOrder.getString(JSON_WO_CORRELATION_KEY));

            //Customer Information for Work Order
            customer = currentOrder.getJSONObject(JSON_WO_CUSTOMER);
            order.setWoCustomerAccountNumber(customer.getString(JSON_WO_CUSTOMER_ACCOUNT_NUMBER));

            //Detailed Information for Work Order
            parseWorkOrderDetailInfo(order, currentOrder);

            if (isItemsRequired) {
                items = CawJSONUtils.getJSONArray(currentOrder, JSON_ITEMS);
                order.setWoItems(parseWorkOrderItems(items));
            }

        } catch (Exception ex) {
            _logger.error("Parse WO from search result: " + ex.getMessage());
            order = null;
        }
        return order;
    }

    /**
     * 
     * @param order
     * @param currentOrder
     */
    private void parseWorkOrderBase(CawWorkOrderEBSQueryResult order, JSONObject currentOrder) {

        Date date = null;
        JSONObject orderDetail = null;
        JSONObject salesChannel = null;
        try {

            long orgId = ConfigurationMgr.getOrganizationId();
            order.setOrganizationId(orgId);
            order.setDataSource(CawWorkOrderConstants.EBS);
            order.setAccountCode(CawWorkOrderConstants.WORK_ORDER);

            salesChannel = currentOrder.getJSONObject(JSON_WO_SALES_SCHANNEL);
            order.setOriginatingRetailLocationId(salesChannel.getString(JSON_WO_SALES_SCHANNEL_LOC_ID));
            date = CawUtilFunction.formatDateTime(currentOrder.getString(JSON_WO_DATE));
            order.setAccountSetupDate(date);

            orderDetail = currentOrder.getJSONObject(JSON_WO_DETAIL);
            order.setAccountId(CawWorkOrderConstants.WO_PREFIX + orderDetail.getString(JSON_WO_NUMBER));
            order.setAccountStateCode(orderDetail.getString(JSON_WO_POS_STATUS));

        } catch (Exception ex) {
            _logger.error("Parse Base WO Account from search result: " + ex.getMessage());
        }
    }

    /**
     * Get info from workOrderDetail tag, 
     * and parse to set to Order object
     * @param order
     * @param currentOrder
     */
    private void parseWorkOrderDetailInfo(CawWorkOrderEBSQueryResult order, JSONObject currentOrder) {

        JSONObject orderDetail = null;
        try {
            orderDetail = currentOrder.getJSONObject(JSON_WO_DETAIL);
            order.setWoNumber(orderDetail.getString(JSON_WO_NUMBER));
            order.setWoType(orderDetail.getString(JSON_WO_TYPE));
            order.setWoStatus(orderDetail.getString(JSON_WO_STATUS));
            order.setWoPosStatus(orderDetail.getString(JSON_WO_POS_STATUS));
            order.setWoPosStatusDescription(orderDetail.getString(JSON_WO_POS_STATUS_DESCRIPTION));
            order.setWoHasDeposit(orderDetail.getBoolean(JSON_WO_HAS_DEPOSIT));
            order.setWoDepositAmt(CawUtilFunction.vBigDecimal(orderDetail.getString(JSON_WO_DEPOSIT_AMT)));
            order.setWoTotalTax(CawUtilFunction.vBigDecimal(orderDetail.getString(JSON_WO_TOTAL_TAX)));
            order.setWoShippingAmt(CawUtilFunction.vBigDecimal(orderDetail.getString(JSON_WO_SHIPPING_AMT)));
            order.setWoDescription(orderDetail.getString(JSON_WO_DESCRIPTION));

        } catch (Exception ex) {
            _logger.error("Parse WO Detail from search result: " + ex.getMessage());
        }
    }

    /**
     * WO parse response...
     * @param response
     * @return List<String>
     */
    private List<CawWorkOrderItem> parseWorkOrderItems(String responseOfOneWO) {

        List<CawWorkOrderItem> listWoItems = null;

        try {
            if (responseOfOneWO != null && responseOfOneWO.length() > 0) {
                JSONObject object = new JSONObject(responseOfOneWO);
                JSONObject order = CawJSONUtils.getJSONObject(object, JSON_ORDER);
                JSONArray items = CawJSONUtils.getJSONArray(order, JSON_ITEMS);
                listWoItems = parseWorkOrderItems(items);
            }
        } catch (Exception ex) {
            _logger.error("WO parse lookup result error: " + ex.getMessage());
        }

        if (listWoItems == null) {
            listWoItems = new ArrayList<CawWorkOrderItem>();
        }
        return listWoItems;
    }

    /**
     * WO parse response of JSONArray
     * @param items
     * @return
     */
    private List<CawWorkOrderItem> parseWorkOrderItems(JSONArray items) {

        List<CawWorkOrderItem> listWoItems = new ArrayList<CawWorkOrderItem>();
        try {
            CawWorkOrderItem woItm = null;
            if (items != null && items.length() > 0) {
                int nItem = items.length();
                String itemId = null;
                JSONObject item = null;
                BigDecimal qty = null;
                BigDecimal price = null;
                JSONObject adj = null;
                JSONArray adjustments = null;
                /* BEGIN BZ31943 */
                Map<String, BigDecimal> adjAmountList = null;
                String couponCode = null;
                /* END BZ31943 */
                BigDecimal adjAmount = null;
                JSONObject attributes = null;
                JSONObject properties = null; /*BZ29205*/
                String attributesString = null;
                String salesperson = null; /*BZ30154*/

                for (int i = 0; i < nItem; i++) {
                    item = items.getJSONObject(i);
                    itemId = item.getString(JSON_ITEM_ID);
                    if (itemId != null && itemId.length() > 0) {
                        
                        //Begin BZ27107 Added
                        qty = CawUtilFunction.vBigDecimal(item.getString(JSON_QTY), BigDecimal.ONE);
                        price = CawUtilFunction.vBigDecimal(item.getString(JSON_ITEM_PRICE), BigDecimal.ZERO); //BZ27192
                        //End BZ27107

                        //Begin BZ27286: Get discount form response
                        adjustments = CawJSONUtils.getJSONArray(item, JSON_ITEM_ADJUSTMENT);
                        adjAmountList = new HashMap<String, BigDecimal>(); /* BZ31943 */
                        if (adjustments != null && adjustments.length() > 0) {
                            boolean lQtyNotZero = (qty != null && qty.compareTo(BigDecimal.ZERO) != 0);
                            int length = adjustments.length();
                            for (int j = 0; j < length; j++) {
                                adj = adjustments.getJSONObject(j);
                                couponCode = CawUtilFunction.vString(adj.getString(JSON_ITEM_ADJ_COUPON_CODE)); /*BZ31943*/
                                adjAmount = CawUtilFunction
                                        .vBigDecimal(adj.getString(JSON_ITEM_ADJ_AMOUNT), BigDecimal.ZERO);
                                // BZ27379 start
                                if (lQtyNotZero) {
                                    adjAmount = adjAmount.divide(qty, 6, RoundingMode.HALF_UP);
                                }
                                // BZ27379 end
                                adjAmountList.put(couponCode, adjAmount); /*BZ31943*/
                            }
                        }

                        woItm = new CawWorkOrderItem(itemId, qty, price, adjAmountList);
                        // End BZ27286
                        // Begin BZ27712: get work order item attributes
                        attributes = CawJSONUtils.getJSONObject(item, JSON_ATTRIBUTES);
                        if (attributes != null) {
                            attributesString = attributes.toString();
                            woItm.setAttributes(attributesString);
                        }
                        // End BZ27712
                        /*BEGIN BZ29205*/
                        properties = CawJSONUtils.getJSONObject(item, JSON_PROPERTIES);
                        if (properties != null) {
                            woItm.setProperties(properties);
                        }
                        /*END BZ29205*/
                        /*BEGIN BZ30154*/
                        salesperson = CawJSONUtils.getJSONObject(item, JSON_SALESPERSON).getString(CASHIER_CODE);
                        if (salesperson != null) {
                            woItm.setSalesPerson(salesperson);
                        }
                        /*END BZ30154*/
                        listWoItems.add(woItm);
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("parseWorkOrderItems-1: " + ex.getMessage());
            listWoItems = new ArrayList<CawWorkOrderItem>();
        }

        return listWoItems;
    }

    /**
     * Check Work Order Item on File
     * @param itemId
     * @return
     */
    public IItem getWoItemOnFile(String itemId) {

        boolean checked = false;
        IItem item = null;
        try {
            item = ItemLocator.getLocator().lookupItem(itemId);
            if (item != null) {
                if (ItemLocator.getLocator()
                        .getSaleLineItem(item, SaleItemType.WORK_ORDER, false, true, HardwareType.KEYBOARD) != null) {
                    checked = true;
                }
            }
        } catch (Exception ex) {
            _logger.error("getWoItemOnFile-1: Item Not found.", ex);
        }

        if (checked) {
            return item;
        } else {
            return null;
        }
    }

    // Begin BZ27192
    /**
     * The function mock up item deposit
     * @return
     */
    private IItem mockupItemDeposit() {

        IItem item = ItemLocator.getLocator().getEmptyItem(DEPOSIT_MOCKUP_ITEM_ID);
        item.setOrganizationId(ConfigurationMgr.getOrganizationId());
        item.setOrgCode(ITEM_DEFAULT_VALUE);
        item.setOrgValue(ITEM_DEFAULT_VALUE);
        item.setMerchLevel1Id(MERCH_LEVEL_1);
        item.setName(DEPOSIT_MOCKUP_ITEM_NAME);
        item.setDescription(DEPOSIT_MOCKUP_ITEM_NAME);

        IItemOptions iItemOption = DataFactory.createObject(IItemOptions.class);
        iItemOption.setOrganizationId(ConfigurationMgr.getOrganizationId());
        iItemOption.setItem(item);
        iItemOption.setVendorId(CawConstants.EMPTY_SIGN);
        iItemOption.setLevelCode(ITEM_DEFAULT_VALUE);
        iItemOption.setLevelValue(ITEM_DEFAULT_VALUE);
        iItemOption.setNotReturnable(false);
        iItemOption.setExcludeFromNetSales(false);

        ((IDataModelImpl) iItemOption).getDAO().setObjectState(DaoState.CLEAN.intVal());

        List<IItemOptions> iItemOptions = new ArrayList<IItemOptions>();
        iItemOptions.add(iItemOption);
        item.setItemOptions(iItemOptions);

        // The IItem object dose not insert to database.
        ((IDataModelImpl) item).getDAO().setObjectState(DaoState.CLEAN.intVal());

        return item;
    }

    /**
     * The function mock up sale line item object
     * @return
     */
    public ISaleReturnLineItem createDepositAmountLine(BigDecimal depositAmount) {

        RetailTransactionLineItemId id = new RetailTransactionLineItemId();
        ISaleReturnLineItem result = DataFactory.createObject(id, IWorkOrderLineItem.class);

        IItem item = mockupItemDeposit();

        result.setItem(item);
        result.setScannedItemId(item.getItemId());
        result.setMerchLevel1Id(item.getMerchLevel1Id());
        result.setVendorId(item.getOptions().getVendorId());
        result.setUnitCost(item.getOptions().getUnitCost());
        result.setNotReturnable(item.getOptions().getNotReturnable());
        result.setExcludeFromNetSales(item.getOptions().getExcludeFromNetSales());
        if (depositAmount != null) {
            result.setBaseUnitPrice(depositAmount);
            result.setUnitPrice(depositAmount);
        } else {
            result.setBaseUnitPrice(BigDecimal.ZERO);
            result.setUnitPrice(BigDecimal.ZERO);
        }
        result.setRegularBasePrice(BigDecimal.ZERO);

        result.setBeginDateTimestamp(DateUtils.getNewDate());
        result.setQuantity(BigDecimal.ONE);
        result.setInitialQuantity(BigDecimal.ONE);

        result.setQuantityToAllocate(BigDecimal.ONE);
        result.setSaleReturnLineItemTypeCode(SALE_RETURN_LINE_ITEM_TYPE_CODE);
        result.setLineItemTypeCode(LineItemType.ITEM.getName());
        result.setItemIdEntryMethodCode(ENTRY_METHOD_CODE);

        // The IWorkOrderLineItem object dose not insert to database.
        ((IDataModelImpl) result).getDAO().setObjectState(DaoState.CLEAN.intVal());

        return result;
    }
    // End BZ27192

    /**
     * Get warranty items, 
     * @param workOrderResult
     * @return
     */
    public Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> moveWarrantyItemsOnly(
            CawWorkOrderEBSQueryResult workOrderResult, WarrantyHelper warrantyHelper,
            List<CawWorkOrderItem> woItemRemoves ) {//BZ29884

        Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warrantyItems = new HashMap<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem>();
        try {
            if (workOrderResult != null) {
                List<TwoPiece<IWarrantyItem, IWarrantyItem>> warrantyItemCrossReferences;
                List<CawWorkOrderItem> itemList = workOrderResult.getWoItems();
                for (CawWorkOrderItem cawWorkOrderItem : itemList) {
                    IItem item = CawWorkOrderHelper.getInstance().getWoItemOnFile(cawWorkOrderItem.getItemId());
                    if (item != null) {
                        // Get warranty item from table ITM_WARRANTY_ITEM_XREF
                        warrantyItemCrossReferences = warrantyHelper
                                .getAvailableWarrantyPlans(item, CawWorkOrderConstants.WARRANTY_TYPCODE, null);

                        //Select warranty items from list if it is found in table
                        addWarrantyItemCrossReferences(item, itemList, warrantyItemCrossReferences, warrantyItems, woItemRemoves);
                    }
                }

                if (woItemRemoves.size() > 0) {
                    /* BEGIN BZ30005*/
                    /**
                     * We going in to remove all warranty item from Work Order list.
                     */
                    CawWorkOrderItem orderItem = new CawWorkOrderItem();

                    for (CawWorkOrderItem itemRemoves : woItemRemoves) {
                        for (Iterator<CawWorkOrderItem> iterator = itemList.iterator(); iterator.hasNext();) {
                            orderItem = iterator.next();
                            if (itemRemoves.getItemId().equalsIgnoreCase(orderItem.getItemId())) {
                                iterator.remove();
                            }
                        }
                    }
                    /* END BZ30005*/

                    workOrderResult.setWoItems(itemList);
                }
            }
        } catch (Exception ex) {
            _logger.debug("Work Order can not filter warranty Item." + ex.getMessage());
        }
        return warrantyItems;
    }

    /**
     * The method check item have define warranty in table ITM_WARRANTY_ITEM_XREF
     * @param currentLineItem
     */
    private void addWarrantyItemCrossReferences(IItem item, List<CawWorkOrderItem> woItemList,
            List<TwoPiece<IWarrantyItem, IWarrantyItem>> warrantyItemCrossReferences,
            Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> outWarrantyItems,
            List<CawWorkOrderItem> outWoItemRemoves) {

        if (item != null) {
            // if the work order is the warranty item. It will remove out _transactionScope
            CawWorkOrderItem woWarrantyItem = null;
            for (TwoPiece<IWarrantyItem, IWarrantyItem> piece : warrantyItemCrossReferences) {
                if (piece.b() != null && piece.b().getItemId() != null) {
                    woWarrantyItem = isExistedWoWarrantyItem(piece.b().getItemId(), woItemList);
                    if (woWarrantyItem != null) {
                        outWoItemRemoves.add(woWarrantyItem);
                        outWarrantyItems.put(piece, item);
                    }
                }
            }
        }

    }

    /**
     * The method removes Work Order item response from S&I if that item is warranty.
     * @param twoPiece
     * @return
     */
    private CawWorkOrderItem isExistedWoWarrantyItem(String warrantyItemId, List<CawWorkOrderItem> woItemList) {

        if (warrantyItemId != null && woItemList != null && woItemList.size() > 0) {
            for (CawWorkOrderItem workOrderItem : woItemList) {
                if (StringUtils.isNotEmpty(workOrderItem.getItemId())
                        && workOrderItem.getItemId().equals(warrantyItemId)) {
                    return workOrderItem;
                }
            }
        }
        return null;
    }

    /**
     * BZ27378
     * Retrieve account from database.
     * @param workOrderResult
     * @return
     */
    public ICustomerAccount retrieveAccount(CawWorkOrderEBSQueryResult workOrderResult) {

        ICustomerAccount account = null;
        IDataModel model = workOrderResult.getPopulatedObject(CustomerAccountType.WORK_ORDER, PersistenceManagerType
                .forName("CAW_WO_XCENTER_STANDARD")); /*BZ30754*/

        if (model != null && model instanceof ICustomerAccount) {
            account = (ICustomerAccount) model;
        }
        return account;
    }
    

    /**
     * BEGIN BZ30754
     * Change strategy for retrieving WO data
     * @param account
     * @param helper
     * @return
     */
    public IPosTransaction retrieveLatestTransaction(ICustomerAccount account, CawTransactionSearchHelper helper) {

        IPosTransaction transaction = null;
        if (account instanceof ICustomerItemAccount) {
            List<ICustomerItemAccountDetail> details = ((ICustomerItemAccount) account).getCustItemAccountDetails();

            for (ICustomerItemAccountDetail detail : details) {
                /*Create PosTransactionId object id */
                PosTransactionId id = new PosTransactionId();
                id.setRetailLocationId(detail.getRetailLocationId());
                id.setWorkstationId(detail.getWorkstationId());
                id.setTransactionSequence(detail.getTransactionSequence());
                id.setBusinessDate(detail.getBusinessDate());

                transaction = helper.getTransaction(CustomerAccountType.WORK_ORDER, id, PersistenceManagerType
                        .forName("CAW_WO_XCENTER_STANDARD"));
                if (transaction != null && !transaction.getPostVoid()) {
                    break;
                }
            }
        }
        return transaction;
    }
    /*END BZ30754*/

    /**
     * BZ27379
     * Check the WO is refund status or not
     * @param pos
     * @return
     */
    public boolean isWorkOrderRedundStatus(IPosTransaction pos) {

        if (pos != null) {
            List<IRetailTransactionLineItem> lineItems = pos.getSaleLineItems();
            ICustomerItemAccountModifier modifier = null;
            ISaleReturnLineItem line = null;
            if (lineItems != null && lineItems.size() > 0) {
                for (IRetailTransactionLineItem lineItem : lineItems) {
                    if (lineItem instanceof ISaleReturnLineItem) {
                        line = (ISaleReturnLineItem) lineItem;
                        modifier = line.getCustomerAccountModifier();

                        if (line.getReturn() && (modifier != null)
                                && modifier.getCustAccountCode().equals(CawWorkOrderConstants.WORK_ORDER)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /***
     * BZ27712/BZ29210/BZ29245: create line item property object
     * Create line item property.
     * @param perfix
     * @param saleReturnLineItem
     * @param attribute
     * @return
     */
    public IRetailTransactionLineItemProperty createLineItemPropertyObject(String perfix,
            ISaleReturnLineItem saleReturnLineItem, String attribute) {

        IRetailTransactionLineItemProperty tranLineItemProperty = null;
        try {
            tranLineItemProperty = DataFactory.createObject(IRetailTransactionLineItemProperty.class);
            tranLineItemProperty.setOrganizationId(saleReturnLineItem.getOrganizationId());
            tranLineItemProperty.setRetailLocationId(saleReturnLineItem.getRetailLocationId());
            tranLineItemProperty.setBusinessDate(saleReturnLineItem.getBusinessDate());
            tranLineItemProperty.setWorkstationId(saleReturnLineItem.getWorkstationId());
            tranLineItemProperty.setTransactionSequence(saleReturnLineItem.getTransactionSequence());
            tranLineItemProperty
                    .setRetailTransactionLineItemSequence(saleReturnLineItem.getRetailTransactionLineItemSequence());

            //Build property code
            String tmpPropertyCode = CawUtilFunction
                    .queryKeyFormat(perfix, saleReturnLineItem.getRetailLocationId(), saleReturnLineItem
                            .getBusinessDate(), saleReturnLineItem.getWorkstationId(), saleReturnLineItem
                                    .getTransactionSequence(), saleReturnLineItem
                                            .getRetailTransactionLineItemSequence());
            //Save work order item's attributes
            tranLineItemProperty.setPropertyCode(tmpPropertyCode);
            tranLineItemProperty.setType(CawConstants.PROP_STRING_TYPE);
            tranLineItemProperty.setPropertyValue(attribute);
        } catch (Exception ex) {
            tranLineItemProperty = null;
            _logger.info("createLineItemPropertyObject-1." + ex.getMessage());
        }

        return tranLineItemProperty;
    }
    
    
    
    /*BEGIN BZ30154*/
    /**
     * @return the notExist
     */
    public List<String> getNotExist() {

        return _notExist;
    }

    /**
     * @param argNotExist the notExist to set
     */
    public void setNotExist(List<String> argNotExist) {

        _notExist = argNotExist;
    }

    public void putToNotExist(String id) {

        _notExist.add(id);
    }
    /*END BZ30154*/
    
    /*BEGIN BZ48749*/
    public IRetailTransactionLineItemProperty createLineItemPropertyObject(
            ISaleReturnLineItem saleReturnLineItem, String propertyCode, String stringValue) {

        IRetailTransactionLineItemProperty tranLineItemProperty = null;
        try {
            tranLineItemProperty = DataFactory.createObject(IRetailTransactionLineItemProperty.class);
            tranLineItemProperty.setOrganizationId(saleReturnLineItem.getOrganizationId());
            tranLineItemProperty.setRetailLocationId(saleReturnLineItem.getRetailLocationId());
            tranLineItemProperty.setBusinessDate(saleReturnLineItem.getBusinessDate());
            tranLineItemProperty.setWorkstationId(saleReturnLineItem.getWorkstationId());
            tranLineItemProperty.setTransactionSequence(saleReturnLineItem.getTransactionSequence());
            tranLineItemProperty.setRetailTransactionLineItemSequence(saleReturnLineItem.getRetailTransactionLineItemSequence());

            
            //Save work order item's properties
            tranLineItemProperty.setPropertyCode(propertyCode);
            tranLineItemProperty.setType(CawConstants.PROP_STRING_TYPE);
            tranLineItemProperty.setPropertyValue(stringValue);
        } catch (Exception ex) {
            tranLineItemProperty = null;
            _logger.info("createLineItemPropertyObject-1." + ex.getMessage());
        }

        return tranLineItemProperty;
    }
    /*END BZ48749*/
    //BEGIN BZ61330
    public boolean checkWOTransOrReturnWOCompleteTrans(
            List<IRetailTransaction> origTrans) {
        if(CawWorkOrderOptionsOp.isDepositAction() || CawWorkOrderOptionsOp.isRefundAction()
                || CawWorkOrderOptionsOp.isCompleteAction()) { //ignore WO transaction
            return true;
        }
        if (origTrans != null && origTrans.size()> 0) {
            for (IRetailTransaction retailTrans : origTrans) {
                List<IPosTransactionProperty> propertyList = retailTrans.getProperties();
                if (propertyList != null && propertyList.size()> 0) {
                    for (IPosTransactionProperty property : propertyList) {
                        if (property != null && property.getPropertyCode() != null
                                && property.getPropertyCode().length() > 1) {
                            if("WO".equalsIgnoreCase(property.getPropertyCode().substring(0,2))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    //END BZ61330
}
