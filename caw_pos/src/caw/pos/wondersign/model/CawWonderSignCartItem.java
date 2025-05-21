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
 *===================================================================
 */

package caw.pos.wondersign.model;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class CawWonderSignCartItem {

    private String code;

    private int    quantity;

    private double lineTotal;

    private String name;
    
    private String correlationKey;

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
     * @return the quantity
     */
    public int getQuantity() {

        return quantity;
    }

    /**
     * @param argQuantity the quantity to set
     */
    public void setQuantity(int argQuantity) {

        quantity = argQuantity;
    }

    /**
     * @return the lineTotal
     */
    public double getLineTotal() {

        return lineTotal;
    }

    /**
     * @param argLineTotal the lineTotal to set
     */
    public void setLineTotal(double argLineTotal) {

        lineTotal = argLineTotal;
    }

    public String getName() {

        return name;
    }

    public void setName(String argName) {

        this.name = argName;
    }

    
    /**
     * @return the correlationKey
     */
    public String getCorrelationKey() {
    
        return correlationKey;
    }
    
    public String getUpperCaseCorrelationKey() {
        return StringUtils.upperCase(correlationKey);
    }

    
    /**
     * @param argCorrelationKey the correlationKey to set
     */
    public void setCorrelationKey(String argCorrelationKey) {
    
        correlationKey = argCorrelationKey;
    }

    @Override
    public String toString() {

        return "CawWonderSignCartItem [code=" + code + ", quantity=" + quantity
                + ", lineTotal=" + lineTotal + ", name=" + name
                + ", correlationKey=" + correlationKey + "]";
    }

}
