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

package caw.pos.wondersign.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class CawWonderSignCart {

    private static final Logger _logger = LogManager.getLogger(CawWonderSignCart.class);

    private int                 id;

    private String              correlationKey;

    private String              customerFirstName;

    private String              customerLastName;

    private String              customerAddressLine1;

    private String              customerCity;

    private String              customerState;

    private String              customerPostal;

    private String              businessDate;

    private double              cartTotal; //BZ45869

    /**
     * 
     */
    public CawWonderSignCart() {

        super();
    }

    /**
     * @return the id
     */
    public int getId() {

        return id;
    }

    /**
     * @param argId the id to set
     */
    public void setId(int argId) {

        id = argId;
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

    /**
     * @return the businessDate
     */
    public String getBusinessDate() {

        return businessDate;
    }

    /**
     * @param argBusinessDate the businessDate to set
     */
    public void setBusinessDate(String argBusinessDate) {

        businessDate = argBusinessDate;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {

        String customerName = customerFirstName + " " + customerLastName;

        return customerName;
    }

    /**
     * @return the customerAddress1
     */
    public String getCustomerAddress1() {

        return customerAddressLine1;
    }

    /**
     * @return the customerAddress2
     */
    public String getCustomerAddress2() {
        
        String addressLine2 = "";
        
        if (customerCity != null) {
            addressLine2 = addressLine2 + customerCity;
            
            if (customerState != null) {
                addressLine2 = addressLine2 + ", " + customerState;
                
                if (customerPostal != null) {
                    addressLine2 = addressLine2 + " " + customerPostal;
                }
            }
        }

        return addressLine2;
    }

    /**
     * @return the customerFirstName
     */
    public String getCustomerFirstName() {
    
        return customerFirstName;
    }

    
    /**
     * @param argCustomerFirstName the customerFirstName to set
     */
    public void setCustomerFirstName(String argCustomerFirstName) {
    
        customerFirstName = argCustomerFirstName;
    }

    
    /**
     * @return the customerLastName
     */
    public String getCustomerLastName() {
    
        return customerLastName;
    }

    
    /**
     * @param argCustomerLastName the customerLastName to set
     */
    public void setCustomerLastName(String argCustomerLastName) {
    
        customerLastName = argCustomerLastName;
    }

    
    /**
     * @return the customerAddressLine1
     */
    public String getCustomerAddressLine1() {
    
        return customerAddressLine1;
    }

    
    /**
     * @param argCustomerAddressLine1 the customerAddressLine1 to set
     */
    public void setCustomerAddressLine1(String argCustomerAddressLine1) {
    
        customerAddressLine1 = argCustomerAddressLine1;
    }

    
    /**
     * @return the customerCity
     */
    public String getCustomerCity() {
    
        return customerCity;
    }

    
    /**
     * @param argCustomerCity the customerCity to set
     */
    public void setCustomerCity(String argCustomerCity) {
    
        customerCity = argCustomerCity;
    }

    
    /**
     * @return the customerState
     */
    public String getCustomerState() {
    
        return customerState;
    }

    
    /**
     * @param argCustomerState the customerState to set
     */
    public void setCustomerState(String argCustomerState) {
    
        customerState = argCustomerState;
    }

    
    /**
     * @return the customerPostal
     */
    public String getCustomerPostal() {
    
        return customerPostal;
    }

    
    /* BEGIN BZ45869 */
    /**
     * @return the cartTotal
     */
    public double getCartTotal() {
    
        return cartTotal;
    }

    
    /**
     * @param argCartTotal the cartTotal to set
     */
    public void setCartTotal(double argCartTotal) {
    
        cartTotal = argCartTotal;
    }
    /* END BZ45869 */

    /**
     * @param argCustomerPostal the customerPostal to set
     */
    public void setCustomerPostal(String argCustomerPostal) {
    
        customerPostal = argCustomerPostal;
    }

    public String getBusinessDateDisplay() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(CawConstants.MM_DD_YYYY);
        String businessDateDisplay = "";

        if (!StringUtils.isEmpty(this.businessDate)) {
            try {
                businessDateDisplay = dateTimeFormatter.format(LocalDateTime.parse(this.businessDate));
            } catch (DateTimeParseException ex) {
                _logger.error("Can't parse business date: " + ex.getMessage());
            }
        }

        return businessDateDisplay;
    }

    @Override
    public String toString() {

        return "CawWonderSignCart [id=" + id + ", correlationKey="
                + correlationKey + ", customerFirstName=" + customerFirstName
                + ", customerLastName=" + customerLastName
                + ", customerAddressLine1=" + customerAddressLine1
                + ", customerCity=" + customerCity + ", customerState="
                + customerState + ", customerPostal=" + customerPostal
                + ", businessDate=" + businessDate + ", cartTotal=" + cartTotal
                + "]";
    }
}
