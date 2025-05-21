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
 * BZ26270          290618    New Requirement - Display UPC on both Xstore screens and on receipts
 *===================================================================
 */
package caw.pos.register;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.data2.access.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * Display full UPC text on Sale screen.
 *
 */
public class CawUPCHelper {

    private static final Logger                       _logger               = LogManager
            .getLogger(CawUPCHelper.class);

    private Map<String, String>                       _cachedUpcs           = new HashMap<>();

    /*Added BZ26270*/
    public static final IQueryKey<DefaultQueryResult> SQL_MANUFACTURERS_UPC = new QueryKey<DefaultQueryResult>(
            "SQL_MANUFACTURERS_UPC", DefaultQueryResult.class);

    /**
     * The singleton instance of the CawUPCHelper class
     */
    private static volatile CawUPCHelper              instance              = null;

    /**
     * Default constructor is private
     */
    private CawUPCHelper() {

        super();
    }

    /**
    * Returns a reference to the single instance of this object
    * 
    * @return CawUPCHelper
    */
    public static CawUPCHelper getInstance() {

        if (instance == null) {
            synchronized (CawUPCHelper.class) {
                if (instance == null) {
                    instance = new CawUPCHelper();
                }
            }
        }
        return instance;
    }

    /**
     * Added BZ26270
     * Check to be UPC
     * @param scannedItemId
     * @param itemId
     * @return
     */
    private String getUpcScanned(String scannedItemId, String itemId) {

        String upc = null;
        /*The UPC that is scanned or manually entered 
         * is the UPC to display and print on the receipt.*/
        if (scannedItemId != null && scannedItemId.length() > 0) {
            if (itemId != null && itemId.length() > 0
                    && scannedItemId.compareToIgnoreCase(itemId) != 0) {
                upc = scannedItemId;
            }
        }
        return upc;
    }

    /**
     * 
     * @param scannedItemId
     * @param itemId
     * @return null if UPC is not cached
     */
    private String getUpcCached(String scannedItemId, String itemId) {

        String upc = null;
        /*If the user enters or scans a SKU(item number), 
         * then the primary flag for the UPC will determine what is displayed*/
        if (itemId != null && itemId.length() > 0) {
            if (scannedItemId != null && scannedItemId.length() > 0) {
                upc = _cachedUpcs.get(itemId);
            }
        }
        return upc;
    }

    /**
     * Added BZ26270
     * Just check to get UPC that already scanned or cached
     * @param scannedItemId
     * @param itemId
     * @return
     */
    public String getUpcText(String scannedItemId, String itemId) {

        String upc = getUpcScanned(scannedItemId, itemId);
        if (upc == null || upc.length() == 0) {
            upc = getUpcCached(scannedItemId, itemId);
        }
        return upc;
    }

    /**
     * UPC
     * @param saleLineItm
     * @return
     */
    public String getUpcText(ISaleReturnLineItem saleLineItm) {

        String scannedItemId = saleLineItm.getScannedItemId();
        String itemID = saleLineItm.getItemId();
        IItem itm = saleLineItm.getItem();
        String upc = null;
        //if (itm != null && !(itm instanceof NonPhysicalItemModel)) {
        if (itm != null) {
            upc = getUpcText(scannedItemId, itemID);
        }
        return upc;
    }

    public boolean isUpcExisted(ISaleReturnLineItem saleLineItm) {

        String upc = getUpcText(saleLineItm);
        if (upc == null || upc.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check and get/add UPC
     * Here is splitted in sub-cases to optimize performance
     * 1. Check if UPC already entered or scanned
     * 2. Check if UPC already cached, if UPC is empty i.e UPC not existed in DB
     * 3. UPC is not cached or be null, need to get UPC from DB, and place to list
     * @param scannedItemId
     * @param itemId
     * @return
     */
    public String addUpc(String scannedItemId, String itemId) {

        String upc = null;
        try {
            //1. Check: UPC already entered or scanned
            upc = getUpcScanned(scannedItemId, itemId);
            if (upc != null && upc.length() > 0) {
                _cachedUpcs.put(itemId, upc);
            } else {
                //2. Check if UPC already cached, or if UPC is empty i.e UPC not existed in DB
                upc = getUpcCached(scannedItemId, itemId);
                if (upc == null) {
                    //3. UPC is not cached or be null, need to get UPC from DB, and place to list
                    upc = getCrossReferrenceUPCText(itemId);
                    if (upc == null) {
                        upc = CawConstants.EMPTY_SIGN;
                    }
                    _cachedUpcs.put(itemId, upc);
                }
            }
        } catch (Exception ex) {
            _logger.error("Error in addUpc:" + ex.getMessage());
        }
        return upc;
    }

    /**
     * Just add UPC of types of non-physical and physical items
     * @param saleLineItm
     * @return
     */
    public void addUpc(ISaleReturnLineItem saleLineItm) {

        try {
            if (saleLineItm != null) {
                IItem itm = saleLineItm.getItem();
                //if (itm != null && !(itm instanceof NonPhysicalItemModel)) {
                if (itm != null) {
                    if (saleLineItm.getScannedItemId() == null) {
                        saleLineItm.setScannedItemId(saleLineItm.getItemId());
                    }
                    String scannedItemId = saleLineItm.getScannedItemId();
                    String itemID = saleLineItm.getItemId();
                    addUpc(scannedItemId, itemID);
                }
            }
        } catch (Exception ex) {
            _logger.error("Error in addUpc-2:" + ex.getMessage());
        }
    }

    public void addUpc(IPosTransaction resumeTrans) {

        try {
            List<IRetailTransactionLineItem> lineItems = resumeTrans
                    .getSaleLineItems();
            for (IRetailTransactionLineItem lineItem : lineItems) {
                if (lineItem instanceof ISaleReturnLineItem) {
                    addUpc((ISaleReturnLineItem) lineItem);
                }
            }

        } catch (Exception ex) {
            _logger.error("Error in addUpc-3:" + ex.getMessage());
        }
    }

    /**
     * Added 26270 get UPC from DB: itm_item_cross_reference table
     * If the user enters or scans a SKU(item number), 
     * then the primary flag for the UPC will determine what is displayed
     * + If there are no UPCs associated with the item then only display the item number
     * + The primary UPC will display and print when there are one or multiple UPCs
     * + The first UPC will display and print if multiple UPCs exist and there is no primary assigned.
     * + The first primary UPC will display and print if there are multiple UPCs marked as primary. 
     * @param itemId
     */
    private String getCrossReferrenceUPCText(String itemId) {

        String upc = null;
        try {
            long orgId = ConfigurationMgr.getOrganizationId();
            Map<String, Object> params = new HashMap<>();
            params.put("argOrganizationId", orgId);
            params.put("argItemId", itemId);
            //params.put("argPrimaryFLag", "1");
            List<DefaultQueryResult> results = DataFactory
                    .getObjectByQueryNoThrow(SQL_MANUFACTURERS_UPC, params);
            if (results != null && !results.isEmpty()) {
                /*First item when primary_flag DESC, update_date DESC*/
                DefaultQueryResult item = results.get(0);
                Object ob = item.get("UPC");
                if (ob != null && ob instanceof String) {
                    upc = String.valueOf(ob);
                    _logger.info("getCrossReferrenceUPCText: " + itemId + " = "
                            + upc);
                }
            }
        } catch (Exception ex) {
            _logger.error("getCrossReferrenceUPCText-1", ex);
        }
        return upc;
    }

    /**
     * Remove all 
     */
    public void clearCache() {

        try {
            if (_cachedUpcs.size() > 0) {
                _cachedUpcs.clear();
            }
        } catch (Exception ex) {
            _logger.error("Error in clearCache:" + ex.getMessage());
        }
    }
}
