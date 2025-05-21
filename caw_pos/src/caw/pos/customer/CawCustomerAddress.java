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
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 *== ================================================================
 */

package caw.pos.customer;

/**
 *
 */
public class CawCustomerAddress {

    private String  audit;

    private String  addressType;

    private String  addressTypeDescription;

    private Boolean isDeliverable;

    private String  line1;

    private String  line2;

    private String  line3;

    private String  line4;

    private String  city;

    private String  stateProvince;

    private String  postalCode;

    private String  country;

    private String  county;

    /**
     * @return
     */
    public String getAudit() {

        return audit;
    }

    /**
     * @param argAudit
     */
    public void setAudit(String argAudit) {

        audit = argAudit;
    }

    /**
     * @return
     */
    public String getAddressType() {

        return addressType;
    }

    /**
     * @param argAddressType
     */
    public void setAddressType(String argAddressType) {

        addressType = argAddressType;
    }

    /**
     * @return
     */
    public String getAddressTypeDescription() {

        return addressTypeDescription;
    }

    /**
     * @param argAddressTypeDescription
     */
    public void setAddressTypeDescription(String argAddressTypeDescription) {

        addressTypeDescription = argAddressTypeDescription;
    }

    /**
     * @return
     */
    public Boolean getIsDeliverable() {

        return isDeliverable;
    }

    /**
     * @param argIsDeliverable
     */
    public void setIsDeliverable(Boolean argIsDeliverable) {

        isDeliverable = argIsDeliverable;
    }

    /**
     * @return
     */
    public String getLine1() {

        return line1;
    }

    /**
     * @param argLine1
     */
    public void setLine1(String argLine1) {

        line1 = argLine1;
    }

    /**
     * @return
     */
    public String getLine2() {

        return line2;
    }

    /**
     * @param argLine2
     */
    public void setLine2(String argLine2) {

        line2 = argLine2;
    }

    /**
     * @return
     */
    public String getLine3() {

        return line3;
    }

    /**
     * @param argLine3
     */
    public void setLine3(String argLine3) {

        line3 = argLine3;
    }

    /**
     * @return
     */
    public String getLine4() {

        return line4;
    }

    /**
     * @param argLine4
     */
    public void setLine4(String argLine4) {

        line4 = argLine4;
    }

    /**
     * @return
     */
    public String getCity() {

        return city;
    }

    /**
     * @param argCity
     */
    public void setCity(String argCity) {

        city = argCity;
    }

    /**
     * @return
     */
    public String getStateProvince() {

        return stateProvince;
    }

    /**
     * @param argStateProvince
     */
    public void setStateProvince(String argStateProvince) {

        stateProvince = argStateProvince;
    }

    /**
     * @return
     */
    public String getPostalCode() {

        return postalCode;
    }

    /**
     * @param argPostalCode
     */
    public void setPostalCode(String argPostalCode) {

        postalCode = argPostalCode;
    }

    /**
     * @return
     */
    public String getCountry() {

        return country;
    }

    /**
     * @param argCountry
     */
    public void setCountry(String argCountry) {

        country = argCountry;
    }

    /**
     * @return
     */
    public String getCounty() {

        return county;
    }

    /**
     * @param argCounty
     */
    public void setCounty(String argCounty) {

        county = argCounty;
    }

}
