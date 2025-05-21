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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 *===================================================================
 */

package caw.pos.cheetah;

import dtv.pos.framework.form.BasicEditModel;

/**
 *
 */
public class CawRewardLoyaltyPointsModel extends BasicEditModel {
    private String cardNumber;
    private String pointsEarned;
    private String currentPoints;
    private String totalRewards;
    private String pointNextRewards;
    
    
    /**
     * 
     */
    public CawRewardLoyaltyPointsModel() {

    }

    /**
     * 
     */
    public CawRewardLoyaltyPointsModel(String argCardNumber,
            String argPointsEarned, String argCurrentPoints,
            String argTotalRewards, String argPointNextRewards) {

        cardNumber = argCardNumber;
        pointsEarned = argPointsEarned;
        currentPoints = argCurrentPoints;
        totalRewards = argTotalRewards;
        pointNextRewards = argPointNextRewards;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
    
        return cardNumber;
    }
    
    /**
     * @param argCardNumber the cardNumber to set
     */
    public void setCardNumber(String argCardNumber) {
    
        cardNumber = argCardNumber;
    }
    
    /**
     * @return the pointsEarned
     */
    public String getPointsEarned() {
    
        return pointsEarned;
    }
    
    /**
     * @param argPointsEarned the pointsEarned to set
     */
    public void setPointsEarned(String argPointsEarned) {
    
        pointsEarned = argPointsEarned;
    }
    
    /**
     * @return the currentPoints
     */
    public String getCurrentPoints() {
    
        return currentPoints;
    }
    
    /**
     * @param argCurrentPoints the currentPoints to set
     */
    public void setCurrentPoints(String argCurrentPoints) {
    
        currentPoints = argCurrentPoints;
    }
    
    /**
     * @return the totalRewards
     */
    public String getTotalRewards() {
    
        return totalRewards;
    }
    
    /**
     * @param argTotalRewards the totalRewards to set
     */
    public void setTotalRewards(String argTotalRewards) {
    
        totalRewards = argTotalRewards;
    }
    
    /**
     * @return the pointNextRewards
     */
    public String getPointNextRewards() {
    
        return pointNextRewards;
    }
    
    /**
     * @param argPointNextRewards the pointNextRewards to set
     */
    public void setPointNextRewards(String argPointNextRewards) {
    
        pointNextRewards = argPointNextRewards;
    }
    
    
}
