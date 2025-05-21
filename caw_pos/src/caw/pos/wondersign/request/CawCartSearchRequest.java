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

package caw.pos.wondersign.request;

import caw.pos.wondersign.util.CawWonderSignHelper;

/**
 *
 */
public class CawCartSearchRequest {

    private int    salesChannelId;

    private int    salesChannelTerminal;

    private int    salesChannelType  = CawWonderSignHelper.RETAIL_SALE_CHANNEL_TYPE;

    private int    cartSaleChannelId = 0;

    private String fromDate;

    private String toDate;
    
    private String firstName;
    
    private String lastName;
    
    private String phoneNumber;

    private int    pageSize          = 5;

    private int    pageNumber        = 1;

    /**
     * 
     */
    public CawCartSearchRequest() {

        super();
    }

    /**
     * @return the salesChannelId
     */
    public int getSalesChannelId() {

        return salesChannelId;
    }

    /**
     * @param argSalesChannelId the salesChannelId to set
     */
    public void setSalesChannelId(int argSalesChannelId) {

        salesChannelId = argSalesChannelId;
    }

    /**
     * @return the salesChannelTerminal
     */
    public int getSalesChannelTerminal() {

        return salesChannelTerminal;
    }

    /**
     * @param argSalesChannelTerminal the salesChannelTerminal to set
     */
    public void setSalesChannelTerminal(int argSalesChannelTerminal) {

        salesChannelTerminal = argSalesChannelTerminal;
    }

    /**
     * @return the salesChannelType
     */
    public int getSalesChannelType() {

        return salesChannelType;
    }

    /**
     * @param argSalesChannelType the salesChannelType to set
     */
    public void setSalesChannelType(int argSalesChannelType) {

        salesChannelType = argSalesChannelType;
    }

    /**
     * @return the cartSaleChannelId
     */
    public int getCartSaleChannelId() {

        return cartSaleChannelId;
    }

    /**
     * @param argCartSaleChannelId the cartSaleChannelId to set
     */
    public void setCartSaleChannelId(int argCartSaleChannelId) {

        cartSaleChannelId = argCartSaleChannelId;
    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {

        return fromDate;
    }

    /**
     * @param argFromDate the fromDate to set
     */
    public void setFromDate(String argFromDate) {

        fromDate = argFromDate;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {

        return pageSize;
    }

    /**
     * @param argPageSize the pageSize to set
     */
    public void setPageSize(int argPageSize) {

        pageSize = argPageSize;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {

        return pageNumber;
    }

    /**
     * @param argPageNumber the pageNumber to set
     */
    public void setPageNumber(int argPageNumber) {

        pageNumber = argPageNumber;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {

        return toDate;
    }

    /**
     * @param argToDate the toDate to set
     */
    public void setToDate(String argToDate) {

        toDate = argToDate;
    }

    
    /**
     * @return the firstName
     */
    public String getFirstName() {
    
        return firstName;
    }

    
    /**
     * @param argFirstName the firstName to set
     */
    public void setFirstName(String argFirstName) {
    
        firstName = argFirstName;
    }

    
    /**
     * @return the lastName
     */
    public String getLastName() {
    
        return lastName;
    }

    
    /**
     * @param argLastName the lastName to set
     */
    public void setLastName(String argLastName) {
    
        lastName = argLastName;
    }

    
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
    
        return phoneNumber;
    }

    
    /**
     * @param argPhoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String argPhoneNumber) {
    
        phoneNumber = argPhoneNumber;
    }

    @Override
    public String toString() {

        return "CawCartSearchRequest [salesChannelId=" + salesChannelId
                + ", salesChannelTerminal=" + salesChannelTerminal
                + ", salesChannelType=" + salesChannelType
                + ", cartSaleChannelId=" + cartSaleChannelId + ", fromDate="
                + fromDate + ", toDate=" + toDate + ", firstName=" + firstName
                + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
                + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + "]";
    }

}
