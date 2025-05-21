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

import java.math.BigDecimal;

/**
 *
 */
public class CawInventoryStoreInfo {
    
    private String       _storeId;             /*  BZ31759 */
    private String     _storeName;
    private String     _location;
    private String     _distance;
    private BigDecimal _quantity;
    
    /* BEGIN BZ31759 */
    /**
     * @return the storeId
     */
    public String getStoreId() {
        return _storeId;
    }

    /**
     * @param argStoreId the storeId to set
     */
    public void setStoreId(String argStoreId) {
        _storeId = argStoreId;
    }
    /* END BZ31759 */
    /**
     * @return the storeName
     */
    public String getStoreName() {
        return _storeName;
    }

    /**
     * @param argStoreName the storeName to set
     */
    public void setStoreName(String argStoreName) {
        _storeName = argStoreName;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return _location;
    }

    /**
     * @param argLocation the location to set
     */
    public void setLocation(String argLocation) {
        _location = argLocation;
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return _distance;
    }

    /**
     * @param argDistance the distance to set
     */
    public void setDistance(String argDistance) {
        _distance = argDistance;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return _quantity;
    }

    /**
     * @param argQuantity the quantity to set
     */
    public void setQuantity(BigDecimal argQuantity) {
        _quantity = argQuantity;
    }

}
