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
 * 
 *===================================================================
 */

package caw.pos.customer;

import dtv.pos.framework.form.BasicEditModel;

/**
 *
 */
public class CawApplyRewardModel extends BasicEditModel{
    private String totalPoints;
    private String redeemablePointsBalance;
    private String redeemableAmount;
    private String pointsExpiringAtEndOfMonth;
    private String pointsToNextReward;

    
    public CawApplyRewardModel(String title, String message) {
        super(FF.getTranslatable(title), FF.getTranslatable(message));
    }
    
    public CawApplyRewardModel() {
        
    }
    
    
    
    /**
     * @return the totalPoints
     */
    public String getTotalPoints() {
    
        return totalPoints;
    }

    
    /**
     * @param argTotalPoints the totalPoints to set
     */
    public void setTotalPoints(String argTotalPoints) {
    
        totalPoints = argTotalPoints;
    }

    
    /**
     * @return the redeemablePointsBalance
     */
    public String getRedeemablePointsBalance() {
    
        return redeemablePointsBalance;
    }

    
    /**
     * @param argRedeemablePointsBalance the redeemablePointsBalance to set
     */
    public void setRedeemablePointsBalance(String argRedeemablePointsBalance) {
    
        redeemablePointsBalance = argRedeemablePointsBalance;
    }

    
    /**
     * @return the redeemableAmount
     */
    public String getRedeemableAmount() {
    
        return redeemableAmount;
    }

    
    /**
     * @param argRedeemableAmount the redeemableAmount to set
     */
    public void setRedeemableAmount(String argRedeemableAmount) {
    
        redeemableAmount = argRedeemableAmount;
    }

    
    /**
     * @return the pointsExpiringAtEndOfMonth
     */
    public String getPointsExpiringAtEndOfMonth() {
    
        return pointsExpiringAtEndOfMonth;
    }

    
    /**
     * @param argPointsExpiringAtEndOfMonth the pointsExpiringAtEndOfMonth to set
     */
    public void setPointsExpiringAtEndOfMonth(
            String argPointsExpiringAtEndOfMonth) {
    
        pointsExpiringAtEndOfMonth = argPointsExpiringAtEndOfMonth;
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

    

    
}
