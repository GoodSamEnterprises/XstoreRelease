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
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ27584              190818    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ40798              240221    Modification to member savings calculation
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 *== ================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;

public class CawAttributesModel {

    private String orderHoldName;

    private String affiliateId;

    private String returnReason;         //BZ25558 added

    private String orignalCorrelationKey;//BZ27584

    private String woAttributes;         //BZ27712
    
    private String oRequestId; //BZ37463

    /* BEGIN BZ40798 */
    private String goodSamSavings;
    
    private String couldSave;
    /* END BZ40798 */
    
    private String cartIDs; /*BZ44528*/
    
    private BigDecimal rvPaymentAmount;/*BZ44917*/
    
    public String getOrderHoldName() {

        return orderHoldName;
    }

    public void setOrderHoldName(String orderHoldName) {

        this.orderHoldName = orderHoldName;
    }

    public String getAffiliateId() {

        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {

        this.affiliateId = affiliateId;
    }

    /**
     * @return the returnReason
     */
    public String getReturnReason() {

        return returnReason;
    }

    /**
     * @param returnReason the returnReason to set
     */
    public void setReturnReason(String returnReason) {

        this.returnReason = returnReason;
    }

    //Begin BZ27584

    /**
     * @return the orignalCorrelationKey
     */
    public String getOrignalCorrelationKey() {

        return orignalCorrelationKey;
    }

    /**
     * @param orignalCorrelationKey the orignalCorrelationKey to set
     */
    public void setOrignalCorrelationKey(String orignalCorrelationKey) {

        this.orignalCorrelationKey = orignalCorrelationKey;
    }

    /**
     * @return the woAttributes
     */
    public String getWoAttributes() {

        return woAttributes;
    }

    /**
     * @param woAttributes the woAttributes to set
     */
    public void setWoAttributes(String woAttributes) {

        this.woAttributes = woAttributes;
    }

    //End BZ27584
    
    /* BEGIN BZ37463 */
    
    /**
     * @return the oRequestId
     */
    public String getoRequestId() {
    
        return oRequestId;
    }

    
    /**
     * @param oRequestId the oRequestId to set
     */
    public void setoRequestId(String oRequestId) {
    
        this.oRequestId = oRequestId;
    }
    /* END BZ37463*/

    /* BEGIN BZ40798 */
    /**
     * @return the goodSamSavings
     */
    public String getGoodSamSavings() {
    
        return goodSamSavings;
    }

    
    /**
     * @param goodSamSavings the goodSamSavings to set
     */
    public void setGoodSamSavings(String goodSamSavings) {
    
        this.goodSamSavings = goodSamSavings;
    }

    /**
     * @return the couldSave
     */
    public String getCouldSave() {
    
        return couldSave;
    }

    
    /**
     * @param couldSave the couldSave to set
     */
    public void setCouldSave(String couldSave) {
    
        this.couldSave = couldSave;
    }
    /* END BZ40798 */

    /*BEGIN BZ44528*/
    /**
     * @return the cartIDs
     */
    public String getCartIDs() {
    
        return cartIDs;
    }

    
    /**
     * @param cartIDs the cartIDs to set
     */
    public void setCartIDs(String cartIDs) {
    
        this.cartIDs = cartIDs;
    }
    /*END BZ44528*/

    /*BEGIN BZ44917*/
    /**
     * @return the rvPaymentAmount
     */
    public BigDecimal getRvPaymentAmount() {
    
        return rvPaymentAmount;
    }

    
    /**
     * @param rvPaymentAmount the rvPaymentAmount to set
     */
    public void setRvPaymentAmount(BigDecimal rvPaymentAmount) {
    
        this.rvPaymentAmount = rvPaymentAmount;
    }
    /*END BZ44917*/
    
}
