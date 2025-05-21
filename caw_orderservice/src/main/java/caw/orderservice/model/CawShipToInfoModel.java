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
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup storeâ€™s address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores          
 *== ================================================================
 */

package caw.orderservice.model;

public class CawShipToInfoModel {

    private String name;

    private String line1;

    private String line2;

    private String city;

    private String stateProvince;

    private String postalCode;

    private String country;

    /* BEGIN BZ37463 */
    private String shipVia;

    private String serviceLevel;
    
    private String fullfillLocation;
    /* BEGIN BZ38716 */
    private int detailSeq;  
    /**
     * @return the detailSeq
     */
    public int getDetailSeq() {  
        return detailSeq;
    }    
    /**
     * @param detailSeq the detailSeq to set
     */
    public void setDetailSeq(int detailSeq) {
        this.detailSeq = detailSeq;
    }
    /* END BZ38716 */
    /**
     * @return the fullfillLocation
     */
    public String getFullfillLocation() {
    
        return fullfillLocation;
    }

    
    /**
     * @param fullfillLocation the fullfillLocation to set
     */
    public void setFullfillLocation(String fullfillLocation) {
    
        this.fullfillLocation = fullfillLocation;
    }

    /**
     * @return the serviceLevel
     */
    public String getServiceLevel() {

        return serviceLevel;
    }

    /**
     * @param serviceLevel the serviceLevel to set
     */
    public void setServiceLevel(String serviceLevel) {

        this.serviceLevel = serviceLevel;
    }

    /**
     * @return the shipVia
     */
    public String getShipVia() {

        return shipVia;
    }

    /**
     * @param shipVia the shipVia to set
     */
    public void setShipVia(String shipVia) {

        this.shipVia = shipVia;
    }

    /* END BZ37463 */

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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
}
