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
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ38442          131020    [TASK] Handling about calculate shipping Fee of Delivery order included a regular item, restricted item with additional freight, and freight quote item
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;

/**
 *
 */
public class CawShipperMethodAPIModel {

	private String shipperMethodId;
	
    private String ShipperMethodDesc;
    
    private BigDecimal feePrice = null;
    /* BEGIN BZ38442 */
    private BigDecimal additionalPH = null;    
    
    private BigDecimal feeTotal = null;
    
    /**
     * @return the additionalPH
     */
    public BigDecimal getAdditionalPH() {
    
        return additionalPH;
    }

    
    /**
     * @param argAdditionalPH the additionalPH to set
     */
    public void setAdditionalPH(BigDecimal argAdditionalPH) {
    
        additionalPH = argAdditionalPH;
    }

    
    /**
     * @return the feeTotal
     */
    public BigDecimal getFeeTotal() {
    
        return feeTotal;
    }

    
    /**
     * @param argFeeTotal the feeTotal to set
     */
    public void setFeeTotal(BigDecimal argFeeTotal) {
    
        feeTotal = argFeeTotal;
    }
    /* END BZ38442 */
    /* BEGIN BZ37912 */
    private int groupId;
    /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }
 
    /**
     * @param argGroupId the groupId to set
     */
    public void setGroupId(int argGroupId) {
        groupId = argGroupId;
    }

    /* BEGIN BZ37912 */
    
    /**
     * @return the shipperMethodId
     */
    public String getShipperMethodId() {
    
        return shipperMethodId;
    }
    
    /**
     * @param argShipperMethodId the shipperMethodId to set
     */
    public void setShipperMethodId(String argShipperMethodId) {
    
        shipperMethodId = argShipperMethodId;
    }
    
    /**
     * @return the shipperMethodDesc
     */
    public String getShipperMethodDesc() {
    
        return ShipperMethodDesc;
    }

    /**
     * @param argShipperMethodDesc the shipperMethodDesc to set
     */
    public void setShipperMethodDesc(String argShipperMethodDesc) {
    
        ShipperMethodDesc = argShipperMethodDesc;
    }

    /**
     * @return the feePrice
     */
    public BigDecimal getFeePrice() {
    
        return feePrice;
    }
    
    /**
     * @param argFeePrice the feePrice to set
     */
    public void setFeePrice(BigDecimal argFeePrice) {
    
        feePrice = argFeePrice;
    }
}
