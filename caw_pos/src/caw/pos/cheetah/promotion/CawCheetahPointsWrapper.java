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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import java.util.HashMap;

/**
 *
 */
public class CawCheetahPointsWrapper {
    private String code;
    private String description;
    private int sortOrder;
    private HashMap<String, String> customerLoyaltyInformation; //BZ52876
    
    /**
     * 
     */
    public CawCheetahPointsWrapper() {

        super();
    }

    /**
     * 
     */
    public CawCheetahPointsWrapper(String argCode, String argDescription,int argSortOrder) {

        super();
        code = argCode;
        description = argDescription;
        sortOrder=argSortOrder;
    }

    /**
     * @return the code
     */
    public String getCode() {
    
        return code;
    }
    
    /**
     * @param argCode the code to set
     */
    public void setCode(String argCode) {
    
        code = argCode;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
    
        return description;
    }
    
    /**
     * @param argDescription the description to set
     */
    public void setDescription(String argDescription) {
    
        description = argDescription;
    }

    
    /**
     * @return the sortOrder
     */
    public int getSortOrder() {
    
        return sortOrder;
    }

    
    /**
     * @param argSortOrder the sortOrder to set
     */
    public void setSortOrder(int argSortOrder) {
    
        sortOrder = argSortOrder;
    }


    /* BEGIN BZ52876 */
    /**
     * @return the customerLoyaltyInformation
     */
    public HashMap<String, String> getCustomerLoyaltyInformation() {
    
        return customerLoyaltyInformation;
    }

    
    /**
     * @param argCustomerLoyaltyInformation the customerLoyaltyInformation to set
     */
    public void setCustomerLoyaltyInformation(
            HashMap<String, String> argCustomerLoyaltyInformation) {
    
        customerLoyaltyInformation = argCustomerLoyaltyInformation;
    }
    /* END BZ52876 */
}
