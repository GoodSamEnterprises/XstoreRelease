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
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 *===================================================================
 */

package caw.orderservice.model;

/**
 *
 */
public class CawBrokeredOrdershipToInfo {

    private String name;

    private String line1;

    private String city;

    private String stateProvince;

    private String postalCode;

    private String country;

    private String addressType;

    private String shippingMethod;

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the line1
     */
    public String getLine1() {

        return line1;
    }

    /**
     * @param line1 the line1 to set
     */
    public void setLine1(String line1) {

        this.line1 = line1;
    }

    /**
     * @return the city
     */
    public String getCity() {

        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {

        this.city = city;
    }

    /**
     * @return the stateProvince
     */
    public String getStateProvince() {

        return stateProvince;
    }

    /**
     * @param stateProvince the stateProvince to set
     */
    public void setStateProvince(String stateProvince) {

        this.stateProvince = stateProvince;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {

        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {

        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {

        this.country = country;
    }

    /**
     * @return the addressType
     */
    public String getAddressType() {

        return addressType;
    }

    /**
     * @param addressType the addressType to set
     */
    public void setAddressType(String addressType) {

        this.addressType = addressType;
    }

    /**
     * @return the shippingMethod
     */
    public String getShippingMethod() {

        return shippingMethod;
    }

    /**
     * @param shippingMethod the shippingMethod to set
     */
    public void setShippingMethod(String shippingMethod) {

        this.shippingMethod = shippingMethod;
    }

    @Override
    public String toString() {

        return "CawBrokeredOrdershipToInfo [name=" + name + ", line1=" + line1
                + ", city=" + city + " stateProvince=" + stateProvince
                + ", postalCode=" + postalCode + ",country=" + country
                + ", addressType=" + addressType + ", shippingMethod="
                + shippingMethod + "]";
    }

}
