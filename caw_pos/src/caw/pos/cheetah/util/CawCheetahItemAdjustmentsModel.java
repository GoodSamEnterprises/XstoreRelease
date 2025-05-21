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
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.cheetah.util;

import java.math.BigDecimal;

/**
 *
 */
public class CawCheetahItemAdjustmentsModel {
    private String     correlationKey;

    private String     type;

    private BigDecimal amount;

    private String     couponCode;

    private String     serializedCoupon;

    
    /**
     * @return the correlationKey
     */
    public String getCorrelationKey() {
    
        return correlationKey;
    }

    
    /**
     * @param argCorrelationKey the correlationKey to set
     */
    public void setCorrelationKey(String argCorrelationKey) {
    
        correlationKey = argCorrelationKey;
    }

    
    /**
     * @return the type
     */
    public String getType() {
    
        return type;
    }

    
    /**
     * @param argType the type to set
     */
    public void setType(String argType) {
    
        type = argType;
    }

    
    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
    
        return amount;
    }

    
    /**
     * @param argAmount the amount to set
     */
    public void setAmount(BigDecimal argAmount) {
    
        amount = argAmount;
    }

    
    /**
     * @return the couponCode
     */
    public String getCouponCode() {
    
        return couponCode;
    }

    
    /**
     * @param argCouponCode the couponCode to set
     */
    public void setCouponCode(String argCouponCode) {
    
        couponCode = argCouponCode;
    }

    
    /**
     * @return the serializedCoupon
     */
    public String getSerializedCoupon() {
    
        return serializedCoupon;
    }

    
    /**
     * @param argSerializedCoupon the serializedCoupon to set
     */
    public void setSerializedCoupon(String argSerializedCoupon) {
    
        serializedCoupon = argSerializedCoupon;
    }
}
