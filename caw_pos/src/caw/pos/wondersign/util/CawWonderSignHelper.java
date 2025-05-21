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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 * BZ45869          230821    [Internal] Electric World Cart Search Results - Cart total amount is not correct
 *===================================================================
 */

package caw.pos.wondersign.util;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.pos.wondersign.model.CawWonderSignCart;
import caw.pos.wondersign.model.CawWonderSignCartItem;
import caw.pos.wondersign.request.CawCartSearchRequest;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.hardware.types.HardwareType;
import dtv.pos.register.ItemLocator;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.SaleItemType;

/**
 *
 */
public class CawWonderSignHelper extends CawJSONConstant {

    private static final Logger                 _logger                  = LogManager
            .getLogger(CawWonderSignHelper.class);

    private static volatile CawWonderSignHelper instance                 = null;

    public static final int                     RETAIL_SALE_CHANNEL_TYPE = 4;
    
    public static final int                     SEARCH_CART_SUCCESS_STATUS = 2;

    public static final int                     SEARCH_CART_ERROR_STATUS   = 3;

    public static final String                  SPECIFIC_DATE            = "Specific date";

    public static final String                  TODAY_PRE                = "Today";

    public static final String                  CURRENT_WEEK_PRE         = "Current Week";

    public static final String                  CURRENT_MONTH_PRE        = "Current Month";

    public static final String                  CURRENT_QUARTER_PRE      = "Current Quarter";

    public static final String                  CURRENT_YEAR_PRE         = "Current Year";

    public static final String                  YESTERDAY_PRE            = "Yesterday";

    public static final String                  PREVIOUS_WEEK_PRE        = "Previous Week";

    public static final String                  PREVIOUS_MONTH_PRE       = "Previous Month";

    public static final String                  PREVIOUS_QUARTER_PRE     = "Previous Quarter";

    public static final String                  PREVIOUS_YEAR_PRE        = "Previous Year";

    private List<CawWonderSignCartItem>         cartSelectedItem         = null;

    private CawWonderSignHelper() {

    }

    public static CawWonderSignHelper getInstance() {

        if (instance == null) {
            synchronized (CawWonderSignHelper.class) {
                if (instance == null) {
                    instance = new CawWonderSignHelper();
                }
            }
        }
        return instance;
    }

    /**
     * 
     * @param salesChannelId
     * @param terminalId
     * @param fromDate
     * @param toDate
     * @param accountNumber
     * @return
     */
    public ResponseEntity<String> searchCart(int salesChannelId, int cartSalesChannelId, int terminalId,
            String fromDate, String toDate, String firstName, String lastName, String phoneNumber) {

        CawCartSearchRequest requestObj = 
                parseToCartSearchRequest(salesChannelId, cartSalesChannelId, terminalId, fromDate, toDate, firstName, lastName, phoneNumber);

        String searchCartBody = buildRequestOfCartSearch(requestObj);

        _logger.info("[Call Cart search API]:" + CawEBSHelper.URL_CART_SEARCH);
        _logger.info("[The Cart search API request]: " + searchCartBody);

        ResponseEntity<String> response = CawEBSHelper.getInstance()
                .sendRequestToEBS(CawEBSHelper.URL_CART_SEARCH, searchCartBody);
        
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                
                _logger.info("[The Cart search API response]: " + response.getBody());
            } else {
                _logger.info("[The Cart search API response with an error code]: " + response.getStatusCode());
            }
        }

        return response;
    }

    /**
     * 
     * @param requestObj
     * @return
     */
    private String buildRequestOfCartSearch(CawCartSearchRequest requestObj) {

        String body = null;

        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CART_SEARCH);

            body = request.getBody();

            body = body.replace(CawJSONConstant.SALES_CHANNEL_ID, String
                    .valueOf(requestObj.getSalesChannelId()));

            body = body.replace(CawJSONConstant.TERMINAL, String
                    .valueOf(requestObj.getSalesChannelTerminal()));

            body = body.replace(CawJSONConstant.CHANNEL_TYPE_ATTR, String
                    .valueOf(requestObj.getSalesChannelType()));

            body = body.replace(CawJSONConstant.CART_SALES_CHANNEL_ID, String
                    .valueOf(requestObj.getCartSaleChannelId()));

            body = body.replace(CawJSONConstant.FROM_DATE, CawUtilFunction
                    .formatParameter(requestObj.getFromDate()));

            body = body.replace(CawJSONConstant.TO_DATE, CawUtilFunction
                    .formatParameter(requestObj.getToDate()));
            
            body = body.replace(CawJSONConstant.FIRST_NAME, CawUtilFunction
                    .formatParameter(requestObj.getFirstName()));
            
            body = body.replace(CawJSONConstant.LAST_NAME, CawUtilFunction
                    .formatParameter(requestObj.getLastName()));
            
            body = body.replace(CawJSONConstant.PHONE_NUMBER, CawUtilFunction
                    .formatParameter(requestObj.getPhoneNumber()));

            body = body.replace(CawJSONConstant.PAGE_SIZE, String
                    .valueOf(requestObj.getPageSize()));

            body = body.replace(CawJSONConstant.PAGE_NUMBER, String
                    .valueOf(requestObj.getPageNumber()));

        } catch (Exception ex) {
            _logger.error("Fail to parse Cart Search Request to request body: " + ex.getMessage());
        }

        return body;
    }

    /**
     * 
     * @return
     */
    public static String getStringDateRange(String dateRangeIndicator) {

        Date now = new Date(); 
                
        String result = "(%s - %s)";

        switch (dateRangeIndicator) {
        case TODAY_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(now), 
                    CawUtilFunction.convertDateFormatMMDDYYY(now));
            break;

        case CURRENT_WEEK_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getWeekStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getWeekEnd(now)));
            break;

        case CURRENT_MONTH_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getMonthStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getMonthEnd(now)));
            break;

        case CURRENT_QUARTER_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getQuarterStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getQuarterEnd(now)));
            break;

        case CURRENT_YEAR_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getYearStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getYearEnd(now)));
            break;

        case YESTERDAY_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getYesterday(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getYesterday(now)));
            break;

        case PREVIOUS_WEEK_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousWeekStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousWeekEnd(now)));
            break;

        case PREVIOUS_MONTH_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousMonthStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousMonthEnd(now)));
            break;

        case PREVIOUS_QUARTER_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousQuarterStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousQuarterEnd(now)));
            break;

        case PREVIOUS_YEAR_PRE:
            result = String.format(result, 
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousYearStart(now)),
                    CawUtilFunction.convertDateFormatMMDDYYY(CawUtilFunction.getPreviousYearEnd(now)));
            break;

        default:
            result = "";
            break;
        }

        return result;
    }

    public void setCartSelectedItem(List<CawWonderSignCartItem> items) {

        this.cartSelectedItem = items;
    }

    public List<CawWonderSignCartItem> getCartSelectedItem() {

        return this.cartSelectedItem;
    }

    /**
     * Check Wonder Sign Item on File
     * @param itemId
     * @return
     */
    public IItem getWonderSignItemOnFile(String itemId) {

        boolean checked = false;

        IItem item = null;

        try {
            item = ItemLocator.getLocator().lookupItem(itemId);
            if (item != null) {
                if (ItemLocator.getLocator()
                        .getSaleLineItem(item, SaleItemType.SALE, false, true, HardwareType.KEYBOARD) != null) {
                    checked = true;
                }
            }
        } catch (Exception ex) {
            _logger.error("getWonderSignItemOnFile-1: Item not found.", ex);
        }

        if (checked) {
            return item;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @param salesChannelId
     * @param terminalId
     * @param fromDate
     * @param toDate
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @return
     */
    private CawCartSearchRequest parseToCartSearchRequest(int salesChannelId, int cartSalesChannelId,
            int terminalId, String fromDate, String toDate, String firstName,
            String lastName, String phoneNumber) {

        CawCartSearchRequest requestObj = new CawCartSearchRequest();

        requestObj.setSalesChannelId(salesChannelId);
        requestObj.setCartSaleChannelId(cartSalesChannelId);
        requestObj.setSalesChannelTerminal(terminalId);
        requestObj.setFromDate(fromDate);
        requestObj.setToDate(toDate);
        requestObj.setFirstName(firstName);
        requestObj.setLastName(lastName);
        requestObj.setPhoneNumber(phoneNumber);
        
        requestObj.setPageSize(CawPropertyUtils.WONDERSIGN_CART_SEARCH_PAGE_SIZE);

        return requestObj;
    }
    
    /**
     * 
     * @param cartJsonObject
     * @return
     */
    public static CawWonderSignCart parseToCart(JSONObject cartJsonObject) {
        CawWonderSignCart cart = null;
        
        if (cartJsonObject != null) {
            
            cart = new CawWonderSignCart();

            JSONObject customerJsonObject = CawJSONUtils
                    .getJSONObject(cartJsonObject, CawJSONConstant.JSON_CART_CUSTOMER);
            JSONObject customerNameJsonObject = CawJSONUtils
                    .getJSONObject(customerJsonObject, CawJSONConstant.JSON_CART_CUSTOMER_NAME);

            String firstName = CawJSONUtils
                    .getString(customerNameJsonObject, CawJSONConstant.JSON_CART_CUSTOMER_FIRST_NAME);
            String lastName = CawJSONUtils
                    .getString(customerNameJsonObject, CawJSONConstant.JSON_CART_CUSTOMER_LAST_NAME);

            cart.setCustomerFirstName(firstName);
            cart.setCustomerLastName(lastName);

            JSONObject customerAddressJsonObject = CawJSONUtils
                    .getJSONObject(customerJsonObject, CawJSONConstant.JSON_ADDRESS);

            String addressLine1 = CawJSONUtils
                    .getString(customerAddressJsonObject, CawJSONConstant.JSON_LINE1);
            String city = CawJSONUtils
                    .getString(customerAddressJsonObject, CawJSONConstant.JSON_CITY);
            String state = CawJSONUtils
                    .getString(customerAddressJsonObject, CawJSONConstant.JSON_STATE);
            String postal = CawJSONUtils
                    .getString(customerAddressJsonObject, CawJSONConstant.JSON_POSTAL_CODE);

            cart.setCustomerAddressLine1(addressLine1);
            cart.setCustomerCity(city);
            cart.setCustomerState(state);
            cart.setCustomerPostal(postal);

            double cartTotal = 0; //BZ45869
            try {
                /* BEGIN BZ45869 */
                String cartTotalStr = cartJsonObject.getString(CawJSONConstant.JSON_CART_TOTAL);
                cartTotal = Double.parseDouble(cartTotalStr);
                /* END BZ45869 */
            } catch (Exception ex) {
                _logger.error("Can't parse cart total: " + ex.getMessage());
            }

            cart.setCartTotal(cartTotal);
            
            String businessDate = CawJSONUtils.getString(cartJsonObject, CawJSONConstant.JSON_CART_BUSINESS_DATE);
            cart.setBusinessDate(businessDate);
            
            String correlationKey = CawJSONUtils.getString(cartJsonObject, CawJSONConstant.JSON_CART_CORELLATION_KEY);
            cart.setCorrelationKey(correlationKey);
        }
        
        return cart;
    }
    
    /**
     * 
     * @param cartCorrelationKey
     * @param cartsJSONArray
     * @return
     */
    public static List<CawWonderSignCartItem> getCartItems(String cartCorrelationKey, JSONArray cartsJSONArray) {
        
        List<CawWonderSignCartItem> items = null;
        
        if (cartsJSONArray != null && cartsJSONArray.length() > 0) {
            for (int i = 0; i < cartsJSONArray.length(); i++) {
                JSONObject cartJO = CawJSONUtils.getJSONObject(cartsJSONArray, i);
                
                String correlationKey = CawJSONUtils.getString(cartJO, CawJSONConstant.JSON_CART_CORELLATION_KEY);
                
                if (correlationKey.equals(cartCorrelationKey)) {
                    items = new ArrayList<CawWonderSignCartItem>();
                    JSONArray itemsJsonArray = CawJSONUtils.getJSONArray(cartJO, CawJSONConstant.JSON_ITEMS);
                    
                    for (int j = 0; j < itemsJsonArray.length(); j++) {
                        JSONObject itemJO = CawJSONUtils.getJSONObject(itemsJsonArray, j);
                        
                        CawWonderSignCartItem item = parseToCartItem(itemJO, correlationKey);
                        
                        items.add(item);
                    }
                    
                    break;
                }
            }
        }
        
        return items;
    }
    
    /**
     * 
     * @param itemJSONObject
     * @param correlationKey
     * @return
     */
    private static CawWonderSignCartItem parseToCartItem(JSONObject itemJSONObject, String correlationKey) {
        
        CawWonderSignCartItem item = null;
        
        if (itemJSONObject != null && correlationKey != null) {
            item = new CawWonderSignCartItem();
            
            String id = CawJSONUtils.getString(itemJSONObject, CawJSONConstant.JSON_ITEM_ID);
            Double lineTotal = Double.parseDouble(CawJSONUtils.getString(itemJSONObject, CawJSONConstant.JSON_LINE_TOTAL));
            
            try {
                int quantity =  itemJSONObject.getInt(CawJSONConstant.JSON_QTY);
                item.setQuantity(quantity);
            } catch (JSONException ex) {
                _logger.error("Can't parse item quantity: " + ex.getMessage());
            }
            
            item.setCode(id);
            item.setLineTotal(lineTotal);
            item.setCorrelationKey(correlationKey);
        }
        
        return item;
    }

}
