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
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 *===================================================================
 */

package caw.pos.shippingfee;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import caw.pos.order.CawShipperMethodAPIModel;
import caw.pos.order.CawShippingGroupsModel;

/**
 *
 */
public class CawGetListsShippingFee {
    
    public static List<CawShipperMethodAPIModel> shipperMethodAPIModels =null;
    
    public static List<CawShipperMethodAPIModel> shipperMethodEnterFeeeModels =null;

    /* BEGIN BZ37912 */
    public static List<CawShippingGroupsModel>   shippingGroupsModels         = null;

    /**
     * @return the shippingGroupsModels
     */
    public static List<CawShippingGroupsModel> getShippingGroupsModels() {

        return shippingGroupsModels;
    }

    /**
     * @param argShippingGroupsModels the shippingGroupsModels to set
     */
    public static void setShippingGroupsModels(
            List<CawShippingGroupsModel> argShippingGroupsModels) {

        shippingGroupsModels = argShippingGroupsModels;
    }

    /* END BZ37912 */
    public static boolean isEBSOffile = false;
    
    public static boolean hasError = false; // BZ37901
    /* BEGIN BZ37912 */
    public static HashMap<String, BigDecimal> totalOrderShippingFee;  
    /**
     * @return the totalFee
     */
    public static HashMap<String, BigDecimal> getTotalOrderShippingFee() {
        return totalOrderShippingFee;
    }
   
    /**
     * @param argTotalFee the totalFee to set
     */
    public static void setTotalOrderShippingFee(HashMap<String, BigDecimal> argTotalFee) {   
        totalOrderShippingFee = argTotalFee;
    }
    /* END BZ37912 */
    /**
     * @return the isEBSOffile
     */
    public static boolean getIsEBSOffile() {
    
        return isEBSOffile;
    }

    /**
     * @param argIsEBSOffile the isEBSOffile to set
     */
    public static void setIsEBSOffile(boolean argIsEBSOffile) {
    
        isEBSOffile = argIsEBSOffile;
    }
    
    // Start BZ37901
    public static boolean isShippingHasError() {
        return hasError;
    }
    
    public static void setShippingHasError(boolean argsHasError) {
        hasError = argsHasError;
    }
    // End BZ37901

    /**
     * @return the shipperMethodEnterFeeeModels
     */
    public static List<CawShipperMethodAPIModel> getShipperMethodEnterFeeeModels() {
    
        return shipperMethodEnterFeeeModels;
    }

    /**
     * @param argShipperMethodEnterFeeeModels the shipperMethodEnterFeeeModels to set
     */
    public static void setShipperMethodEnterFeeeModels(
            List<CawShipperMethodAPIModel> argShipperMethodEnterFeeeModels) {
    
        shipperMethodEnterFeeeModels = argShipperMethodEnterFeeeModels;
    }

    /**
     * @return the shipperMethodAPIModels
     */
    public static List<CawShipperMethodAPIModel> getShipperMethodAPIModels() {
    
        return shipperMethodAPIModels;
    }
    
    /**
     * @param argShipperMethodAPIModels the shipperMethodAPIModels to set
     */
    public static void setShipperMethodAPIModels(
            List<CawShipperMethodAPIModel> argShipperMethodAPIModels) {
    
        shipperMethodAPIModels = argShipperMethodAPIModels;
    }
}
