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
 * CAW_OrderService     210817    Initial development framework              
 *== ================================================================
 */

package caw.orderservice.model;

public class CawAddressModel {

    private String  audit;

    private String  addressType;

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

    public String getAudit() {

        return audit;
    }

    public void setAudit(String audit) {

        this.audit = audit;
    }

    public String getAddressType() {

        return addressType;
    }

    public void setAddressType(String addressType) {

        this.addressType = addressType;
    }

    public Boolean getIsDeliverable() {

        return isDeliverable;
    }

    public void setIsDeliverable(Boolean isDeliverable) {

        this.isDeliverable = isDeliverable;
    }

    public String getLine1() {

        return line1;
    }

    public void setLine1(String line1) {

        this.line1 = line1;
    }

    public String getLine2() {

        return line2;
    }

    public void setLine2(String line2) {

        this.line2 = line2;
    }

    public String getLine3() {

        return line3;
    }

    public void setLine3(String line3) {

        this.line3 = line3;
    }

    public String getLine4() {

        return line4;
    }

    public void setLine4(String line4) {

        this.line4 = line4;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getStateProvince() {

        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {

        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getCounty() {

        return county;
    }

    public void setCounty(String county) {

        this.county = county;
    }
}
