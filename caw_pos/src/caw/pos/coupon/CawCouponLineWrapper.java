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
 * BZ53186          281022    [Internal] Green check mark should display in the applied column on Offers tab when offer is applied.
 *===================================================================
 */

package caw.pos.coupon;

import dtv.pos.coupon.CouponLineWrapper;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.IDiscountLineItem;

/**
 *
 */
public class CawCouponLineWrapper extends CouponLineWrapper {

    private String promoCode;
    private String promoCodeLabel;
    
    //BEGIN BZ53186
    private boolean applied;
    
    
    
    
    /**
     * @return the applied
     */
    public boolean isApplied() {
    
        return applied;
    }

    
    /**
     * @param argApplied the applied to set
     */
    public void setApplied(boolean argApplied) {
    
        applied = argApplied;
    }
    //END BZ53186 

    public CawCouponLineWrapper(IDiscountLineItem argDiscountLine) {

        super(argDiscountLine);
    }

    @Override
    public String getId() {
        if(!StringUtils.isEmpty(promoCode)) {
            return this.promoCode;
        }
        return super.getId();
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

}
