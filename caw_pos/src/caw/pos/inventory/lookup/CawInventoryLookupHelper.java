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
 * BZ30922          210619    [New Requirement] Price Check and Inventory Lookup
 * BZ31759          080719    Inventory Lookup Error Prompt Change
 *===================================================================
 */

package caw.pos.inventory.lookup;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.LocationFactory;
import dtv.util.CollectionUtils;
import dtv.util.StringUtils;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.loc.IRetailLocation;

/**
 *@return INSTANCE
 */
public class CawInventoryLookupHelper {

    private static volatile CawInventoryLookupHelper INSTANCE = null;

    private static final Logger                      _logger  = LogManager.getLogger(CawInventoryLookupHelper.class);

    public static CawInventoryLookupHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (CawInventoryLookupHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawInventoryLookupHelper();
                }
            }
        }
        return INSTANCE;
    }

    private List<CawInventoryStoreInfo> _listInventoryStoreInfo = null;
    
    private boolean                     _isCommunicationError   = false;

    /**
     * @return the isCommunicationError
     */
    public boolean isCommunicationError() {
        return _isCommunicationError;
    }

    /**
     * @return the listInventoryStoreInfo
     */
    public List<CawInventoryStoreInfo> getListInventoryStoreInfo() {
        return _listInventoryStoreInfo;
    }

    /**
     * @param argListInventoryStoreInfo the listInventoryStoreInfo to set
     */
    public void setListInventoryStoreInfo(List<CawInventoryStoreInfo> argListInventoryStoreInfo) {
        _listInventoryStoreInfo = argListInventoryStoreInfo;
    }

    /**
     * 
     * @param itemId
     * @param rtlLoctionId
     */
    public void loadInventories(String itemId, long rtlLoctionId) {

        _listInventoryStoreInfo = lookupInventoryEBS(itemId, rtlLoctionId);
    }

    /**
     * 
     * @return radius
     */
    @SuppressWarnings("static-access")
    private String getRadius() {

        String radius = "";
        List<String> codeValues = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_INVENTORY_RADIUS);
        if (CollectionUtils.isNotEmpty(codeValues)) {
            radius = codeValues.get(0);
        }
        return radius;
    }

    /**
     * 
     * @return maxResults
     */
    @SuppressWarnings("static-access")
    private String getMaxResults() {

        String maxResults = "";
        List<String> codeValues = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_INV_LOOKUP_MAX_RESULTS);
        if (CollectionUtils.isNotEmpty(codeValues)) {
            maxResults = codeValues.get(0);
        }
        return maxResults;
    }

    /**
     * 
     * @param itemCodes
     * @param currentLocation
     * @return body
     */
    private String getInventoryLookupTemplate(String itemCodes, long currentLocation) {

        String body = null;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CAW_INVENTORY_LOOKUP_REQUEST);
            body = request.getBody();
            body = body.replace(CawJSONConstant.ITEM_CODES, itemCodes);
            body = body.replace(CawJSONConstant.CURRENT_LOCATION, String.valueOf(currentLocation));
            body = body.replace(CawJSONConstant.IS_PROXIMITY_SEARCH, String
                    .valueOf(CawConfigurationMgr.isProximitySearch()));
            body = body.replace(CawJSONConstant.RADIUS, getRadius());
            body = body.replace(CawJSONConstant.MAX_RESULT, getMaxResults());
        } catch (Exception ex) {
            _logger.error("getInventoryLookupTemplate-1:", ex);
            body = null;
        }
        return body;
    }

    /**
     * 
     * @param itemCodes
     * @param currentLocation
     * @return listItemIds
     */
    public List<CawInventoryStoreInfo> lookupInventoryEBS(String itemCodes, long currentLocation) {

        List<CawInventoryStoreInfo> listItemIds = null;
        _isCommunicationError = false;
        try {
            String body = getInventoryLookupTemplate(itemCodes, currentLocation);
            //Inventory: send the request and get response
            ResponseEntity<String> result = CawEBSHelper.getInstance().responseInventorySearch(body);
            //Inventory: parse the response to work order object
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    listItemIds = parseInventory(result.getBody(), itemCodes);
                } else {
                    _isCommunicationError = true;
                }
            }
        } catch (Exception ex) {
            _logger.error("Inventory send lookup request error - lookupInventoryEBS: " + ex.getMessage());
        }
        return listItemIds;
    }

    /**
     * 
     * @param responseOfOneInventory
     * @param itemCodes
     * @return listInventory
     */
    @SuppressWarnings("null")
    private List<CawInventoryStoreInfo> parseInventory(String responseOfOneInventory, String itemCodes) {

        List<CawInventoryStoreInfo> listInventory = null;
        try {
            if (responseOfOneInventory != null && responseOfOneInventory.length() > 0) {
                JSONObject object = new JSONObject(responseOfOneInventory);
                JSONArray inventoryArray = CawJSONUtils.getJSONArray(object, CawJSONConstant.JSON_INVENTORY_INFOS);
                listInventory = parseInventoryDetail(inventoryArray, itemCodes);
            }
        } catch (Exception ex) {
            _logger.error("Inventory parse lookup result error-parseInventory: " + ex.getMessage());
        }
        if (listInventory == null) {
            listInventory = new ArrayList<CawInventoryStoreInfo>();
        }
        return listInventory;
    }

    /**
     * 
     * @param inventoryArray
     * @param itemCodes
     * @return listInventoryDetail
     */
    private List<CawInventoryStoreInfo> parseInventoryDetail(JSONArray inventoryArray, String itemCodes) {

        List<CawInventoryStoreInfo> listInventoryDetail = new ArrayList<CawInventoryStoreInfo>();
        CawInventoryStoreInfo inventory = null;
        JSONObject inventoryObject = null;
        JSONArray inventoryDetailArray = null;
        JSONObject inventoryDetailObject = null;
        int inventoryArrayLength = 0;
        int inventoryDetailArrayLength = 0;
        try {
            inventoryArrayLength = inventoryArray.length();
            for (int i = 0; i < inventoryArrayLength; i++) {
                inventoryObject = inventoryArray.getJSONObject(i);
                if (itemCodes.equals(inventoryObject.getString(CawJSONConstant.JSON_ITEM_CODES))) {
                    inventoryDetailArray = CawJSONUtils
                            .getJSONArray(inventoryObject, CawJSONConstant.JSON_LOCATION_LEVELS);
                    inventoryDetailArrayLength = inventoryDetailArray.length();
                    for (int j = 0; j < inventoryDetailArrayLength; j++) {
                        inventoryDetailObject = inventoryDetailArray.getJSONObject(j);
                        inventory = new CawInventoryStoreInfo();
                        loadDetails(inventory, inventoryDetailObject);
                        listInventoryDetail.add(inventory);
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Inventory parse lookup result error-parseInventoryDetail: " + ex.getMessage());
        }
        return listInventoryDetail;
    }
    /**
     * 
     * @param inventory
     * @param inventoryDetailObject
     */
    private void loadDetails(CawInventoryStoreInfo inventory, JSONObject inventoryDetailObject) {

        StringJoiner distance = null;
        IRetailLocation rtlLoc = null;
        StringJoiner locationAddress = null;
        try {
            inventory.setStoreId(CawUtilFunction
                    .vString(inventoryDetailObject.getString(CawJSONConstant.JSON_STORE_ID))); /* BZ31759 */
            inventory.setStoreName(CawUtilFunction
                    .vString(inventoryDetailObject.getString(CawJSONConstant.JSON_STORE_NAME)));
            distance = new StringJoiner(" ");
            distance.add(CawUtilFunction.vString(inventoryDetailObject.getString(CawJSONConstant.JSON_DISTANCE)));
            distance.add(CawConstants.CAW_MILES);
            inventory.setDistance(distance.toString());
            inventory.setQuantity(CawUtilFunction
                    .vBigDecimal(inventoryDetailObject.getString(CawJSONConstant.JSON_QUANTITY)));
            rtlLoc = LocationFactory.getInstance().getStoreById(Long.parseLong(inventory.getStoreId())); /* BZ31759 */
            locationAddress = new StringJoiner(", ");
            /* BEGIN BZ31759 */
            if (rtlLoc != null) {
                if (!StringUtils.isEmpty(rtlLoc.getAddress1()) 
                        && !StringUtils.isEmpty(rtlLoc.getCity())
                        && !StringUtils.isEmpty(rtlLoc.getState())) {
                    locationAddress.add(rtlLoc.getAddress1());
                    locationAddress.add(rtlLoc.getCity());
                    locationAddress.add(rtlLoc.getState());
                }
            }
            /* END BZ31759 */
            inventory.setLocation(locationAddress.toString());
        } catch (JSONException ex) {
            _logger.error("Inventory parse lookup result error-loadDetails: " + ex.getMessage());
        }
    }
}
