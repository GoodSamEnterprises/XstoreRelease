/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ24395              081117    [OrderService]Paid In & Paid Out transactions in order_service.out
 *== ================================================================
 */

package caw.orderservice.model;

public class CawPaidInOutDetail {

    private String code;

    private String description;

    
    /**
     * @return the code
     */
    public String getCode() {
    
        return code;
    }

    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
    
        this.code = code;
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
    
        return description;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
    
        this.description = description;
    }
    

}
