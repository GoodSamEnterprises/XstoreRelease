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
 * BZ42019          171121    Replace QAS with EAVS2
 *===================================================================
 */

package caw.mailingaddress;


/**
 *
 */
public class CawMailingAddressRequest {

    private String salesChannelId;
    
    private String channelType;
    
    private String addressType;
    
    private String line1;
    
    private String line2;
    
    private String line3;
    
    private String line4;
    
    private String city;
    
    private String state;
    
    private String postal;
    
    private String country;

    
    /**
     * @return the salesChannelId
     */
    public String getSalesChannelId() {
    
        return salesChannelId;
    }

    
    /**
     * @param argSalesChannelId the salesChannelId to set
     */
    public void setSalesChannelId(String argSalesChannelId) {
    
        salesChannelId = argSalesChannelId;
    }

    
    /**
     * @return the channelType
     */
    public String getChannelType() {
    
        return channelType;
    }

    
    /**
     * @param argChannelType the channelType to set
     */
    public void setChannelType(String argChannelType) {
    
        channelType = argChannelType;
    }

    
    /**
     * @return the addressType
     */
    public String getAddressType() {
    
        return addressType;
    }

    
    /**
     * @param argAddressType the addressType to set
     */
    public void setAddressType(String argAddressType) {
    
        addressType = argAddressType;
    }

    
    /**
     * @return the line1
     */
    public String getLine1() {
    
        return line1;
    }

    
    /**
     * @param argLine1 the line1 to set
     */
    public void setLine1(String argLine1) {
    
        line1 = argLine1;
    }

    
    /**
     * @return the line2
     */
    public String getLine2() {
    
        return line2;
    }

    
    /**
     * @param argLine2 the line2 to set
     */
    public void setLine2(String argLine2) {
    
        line2 = argLine2;
    }

    
    /**
     * @return the line3
     */
    public String getLine3() {
    
        return line3;
    }

    
    /**
     * @param argLine3 the line3 to set
     */
    public void setLine3(String argLine3) {
    
        line3 = argLine3;
    }

    
    /**
     * @return the line4
     */
    public String getLine4() {
    
        return line4;
    }

    
    /**
     * @param argLine4 the line4 to set
     */
    public void setLine4(String argLine4) {
    
        line4 = argLine4;
    }

    
    /**
     * @return the city
     */
    public String getCity() {
    
        return city;
    }

    
    /**
     * @param argCity the city to set
     */
    public void setCity(String argCity) {
    
        city = argCity;
    }

    
    /**
     * @return the state
     */
    public String getState() {
    
        return state;
    }

    
    /**
     * @param argState the state to set
     */
    public void setState(String argState) {
    
        state = argState;
    }

    
    /**
     * @return the postal
     */
    public String getPostal() {
    
        return postal;
    }

    
    /**
     * @param argPostal the postal to set
     */
    public void setPostal(String argPostal) {
    
        postal = argPostal;
    }

    
    /**
     * @return the country
     */
    public String getCountry() {
    
        return country;
    }

    
    /**
     * @param argCountry the country to set
     */
    public void setCountry(String argCountry) {
    
        country = argCountry;
    }

    @Override
    public String toString() {

        return "CawMailingAddressRequest [salesChannelId=" + salesChannelId
                + ", channelType=" + channelType + ", addressType="
                + addressType + ", line1=" + line1 + ", line2=" + line2
                + ", line3=" + line3 + ", line4=" + line4 + ", city=" + city
                + ", state=" + state + ", postal=" + postal + ", country="
                + country + "]";
    }
}
