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
 * BZ49445          040522    [Internal] - Update format/text on the POINTS REDEMPTION prompt
 * BZ52837          171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 *===================================================================
 */

package caw.pos.cheetah.reward;

import java.math.BigDecimal;

import twitter4j.JSONArray;

import dtv.pos.framework.form.BasicEditModel;

/**
 *
 */
public class CawRewardModel extends BasicEditModel{
    private String rewardCode;
    private String rewardLabel;
    private String rewardHeading;
    private String rewardMaxReedemablePointsBalance;
    private BigDecimal rewardMaxRedeemableValue;
    private String pointsToNextReward;
    private JSONArray rewardClaimAllocations;
    //START BZ49445
    private String rewardMaxReedemablePointsBalanceLabel;
    private String pointsToNextRewardLabel;
    private final String POINT_TO_NEXT_REWARD_LABEL = "Points to Next Reward: ";
    private final String POINT_BALANCE = "Points Balance: ";    
    
    //BEGIN BZ52837
    private String ebsCouponCode;
    
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
    //END BZ52837
    /**
     * @return the pointsToNextRewardLabel
     */
    public String getPointsToNextRewardLabel() {
    
        return pointsToNextRewardLabel;
    }
    /**
     * @param argPointsToNextRewardLabel the pointsToNextRewardLabel to set
     */
    public void setPointsToNextRewardLabel(String argPointsToNextRewardLabel) {
    
        pointsToNextRewardLabel = POINT_TO_NEXT_REWARD_LABEL + argPointsToNextRewardLabel;
    }
    /**
     * @return the rewardMaxReedemablePointsBalanceLabel
     */
    public String getRewardMaxReedemablePointsBalanceLabel() {
    
        return rewardMaxReedemablePointsBalanceLabel;
    }
    /**
     * @param argRewardMaxReedemablePointsBalanceLabel the rewardMaxReedemablePointsBalanceLabel to set
     */
    public void setRewardMaxReedemablePointsBalanceLabel(
            String argRewardMaxReedemablePointsBalanceLabel) {
    
        rewardMaxReedemablePointsBalanceLabel = POINT_BALANCE + argRewardMaxReedemablePointsBalanceLabel;
    }
    //END BZ49445
    public CawRewardModel() {
        super();
        setFields();
    }
    
   public CawRewardModel(String title,String description) {
       super(FF.getTranslatable(title), FF.getTranslatable(description));
       setFields();
   }
 //START BZ49445
    private void setFields() {
        addField("rewardMaxRedeemableValue", BigDecimal.class);
        addField("rewardMaxReedemablePointsBalance", String.class);
        addField("pointsToNextReward", String.class);
        addField("rewardMaxReedemablePointsBalanceLabel", String.class);
        addField("pointsToNextRewardLabel", String.class);
    }
  //END BZ49445
    /**
     * @return the rewardCode
     */
    public String getRewardCode() {
    
        return rewardCode;
    }
    
    /**
     * @param argRewardCode the rewardCode to set
     */
    public void setRewardCode(String argRewardCode) {
    
        rewardCode = argRewardCode;
    }
    
    /**
     * @return the rewardLabel
     */
    public String getRewardLabel() {
    
        return rewardLabel;
    }
    
    /**
     * @param argRewardLabel the rewardLabel to set
     */
    public void setRewardLabel(String argRewardLabel) {
    
        rewardLabel = argRewardLabel;
    }
    
    
    /**
     * @return the rewardHeading
     */
    public String getRewardHeading() {
    
        return rewardHeading;
    }
    
    /**
     * @param argRewardHeading the rewardHeading to set
     */
    public void setRewardHeading(String argRewardHeading) {
    
        rewardHeading = argRewardHeading;
    }
    /**
     * @return the rewardMaxReedemablePointsBalance
     */
    public String getRewardMaxReedemablePointsBalance() {
    
        return rewardMaxReedemablePointsBalance;
    }
    
    /**
     * @param argRewardMaxReedemablePointsBalance the rewardMaxReedemablePointsBalance to set
     */
    public void setRewardMaxReedemablePointsBalance(
            String argRewardMaxReedemablePointsBalance) {
    
        rewardMaxReedemablePointsBalance = argRewardMaxReedemablePointsBalance;
    }
    
    /**
     * @return the rewardMaxRedeemableValue
     */
    public BigDecimal getRewardMaxRedeemableValue() {
    
        return rewardMaxRedeemableValue;
    }
    
    /**
     * @param argRewardMaxRedeemableValue the rewardMaxRedeemableValue to set
     */
    public void setRewardMaxRedeemableValue(
            BigDecimal argRewardMaxRedeemableValue) {
    
        rewardMaxRedeemableValue = argRewardMaxRedeemableValue;
    }
    
    
    /**
     * @return the pointsToNextReward
     */
    public String getPointsToNextReward() {
    
        return pointsToNextReward;
    }

    
    /**
     * @param argPointsToNextReward the pointsToNextReward to set
     */
    public void setPointsToNextReward(String argPointsToNextReward) {
    
        pointsToNextReward = argPointsToNextReward;
    }
    
    public JSONArray getRewardClaimAllocations() {
    
        return rewardClaimAllocations;
    }
    
    public void setRewardClaimAllocations(JSONArray argRewardClaimAllocations) {
    
        rewardClaimAllocations = argRewardClaimAllocations;
    }

}
