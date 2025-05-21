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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction  
 * BZ50442          130622    Redemption data missing in request
 * BZ51771          161122    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service. 
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import java.math.BigDecimal;
import java.util.Date;

import twitter4j.JSONArray;

import dtv.pos.framework.form.BasicEditModel;

/**
 *
 */
public class CawPromotionModel extends BasicEditModel{
    private String promoCode;
    private String promoCodeLabel;
    private String promoMetricName;
    private BigDecimal promoMetricValue;
    private Date expiration;
    private JSONArray promoOfferClaimAllocations;
    //START BZ50442
    private String offerResponseCode;
    private String ebsCouponCode;
    //End BZ50442
    
    private String expirationString; //BZ51771
    
    /**
     * 
     */
    public CawPromotionModel() {
        super();
        setFields();
    }
    
    /**
     * 
     */
    private void setFields() {
        addField("promoCodeLabel", String.class);
        addField("expiration",Date.class);
    }

    
    /**
     * @return the promoCode
     */
    public String getPromoCode() {
    
        return promoCode;
    }

    
    /**
     * @param argPromoCode the promoCode to set
     */
    public void setPromoCode(String argPromoCode) {
    
        promoCode = argPromoCode;
    }

    
    /**
     * @return the promoCodeLabel
     */
    public String getPromoCodeLabel() {
    
        return promoCodeLabel;
    }

    
    /**
     * @param argPromoCodeLabel the promoCodeLabel to set
     */
    public void setPromoCodeLabel(String argPromoCodeLabel) {
    
        promoCodeLabel = argPromoCodeLabel;
    }

    
    /**
     * @return the promoMetricName
     */
    public String getPromoMetricName() {
    
        return promoMetricName;
    }

    
    /**
     * @param argPromoMetricName the promoMetricName to set
     */
    public void setPromoMetricName(String argPromoMetricName) {
    
        promoMetricName = argPromoMetricName;
    }

    
    /**
     * @return the promoMetricValue
     */
    public BigDecimal getPromoMetricValue() {
    
        return promoMetricValue;
    }

    
    /**
     * @param argPromoMetricValue the promoMetricValue to set
     */
    public void setPromoMetricValue(BigDecimal argPromoMetricValue) {
    
        promoMetricValue = argPromoMetricValue;
    }

    
    /**
     * @return the expiration
     */
    public Date getExpiration() {
    
        return expiration;
    }

    
    /**
     * @param argExpiration the expiration to set
     */
    public void setExpiration(Date argExpiration) {
    
        expiration = argExpiration;
    }

    public JSONArray getPromoOfferClaimAllocations() {
    
        return promoOfferClaimAllocations;
    }

    public void setPromoOfferClaimAllocations(
            JSONArray argPromoOfferClaimAllocations) {
    
        promoOfferClaimAllocations = argPromoOfferClaimAllocations;
    }

    
    /**
     * @return the offerResponseCode
     */
    public String getOfferResponseCode() {
    
        return offerResponseCode;
    }

    
    /**
     * @param argOfferResponseCode the offerResponseCode to set
     */
    public void setOfferResponseCode(String argOfferResponseCode) {
    
        offerResponseCode = argOfferResponseCode;
    }

    
    /**
     * @return the ebsCouponCode
     */
    public String getEbsCouponCode() {
    
        return ebsCouponCode;
    }

    
    /**
     * @param argEbsCouponCode the ebsCouponCode to set
     */
    public void setEbsCouponCode(String argEbsCouponCode) {
    
        ebsCouponCode = argEbsCouponCode;
    }

    /**
     * @return the expirationString
     */
    public String getExpirationString() {
    
        return expirationString;
    }

    
    /**
     * @param argExpirationString the expirationString to set
     */
    public void setExpirationString(String argExpirationString) {
    
        expirationString = argExpirationString;
    }

}
