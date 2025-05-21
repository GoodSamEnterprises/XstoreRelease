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
 * Req/Bug ID#          ddMMyy    Description
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 * BZ57844              040823    Bug 57844 - [Task] Loyalty Phase 2.
 *===================================================================
 */

package caw.pos.customer.membership;

import java.util.List;

import dtv.xst.dao.cat.IAwardAccountCoupon;


/**
 * The CawCustomerMembershipView class
 */
public class CawCustomerMembershipView {

    /**
     * The memberShip
     */
    private String memberShip;
    /**
     * The club
     */
    private String club;
    /**
     * The benefitLevel
     */
    private String benefitLevel;
    /**
     * The status
     */
    private String status;
    /**
     * The renewal
     */
    private String renewal;

    //BEGIN BZ48564
    private String totalCouponAmount;
    private String totalPoints;
    private String pointsToNextReward;
    
    private List<IAwardAccountCoupon> coupon;
    
    private String pointsBalance;
    private String redeemableValue;
    //END BZ48564
    
    //BEGIN BZ57844
    private int                       daysExpired;
    private String                    type;
    //END BZ57844
    
    /**
     * @return the benefitLevel
     */
    public String getBenefitLevel() {

        return benefitLevel;

    }

    
    /**
     * @return the pointsBalance
     */
    public String getPointsBalance() {
    
        return pointsBalance;
    }

    
    /**
     * @param argPointsBalance the pointsBalance to set
     */
    public void setPointsBalance(String argPointsBalance) {
    
        pointsBalance = argPointsBalance;
    }

    
    /**
     * @return the redeemableValue
     */
    public String getRedeemableValue() {
    
        return redeemableValue;
    }

    
    /**
     * @param argRedeemableValue the redeemableValue to set
     */
    public void setRedeemableValue(String argRedeemableValue) {
    
        redeemableValue = argRedeemableValue;
    }

    /**
     * @param argBenefitLevel the benefitLevel to set
     */
    public void setBenefitLevel(String argBenefitLevel) {

        benefitLevel = argBenefitLevel;

    }

    /**
     * @return the renewal
     */
    public String getRenewal() {

        return renewal;

    }

    /**
     * @param argRenewal the renewal to set
     */
    public void setRenewal(String argRenewal) {

        renewal = argRenewal;

    }

    private String expDate;

    /**
     * @return the memberShip
     */
    public String getMemberShip() {

        return memberShip;

    }

    /**
     * @param argMemberShip the memberShip to set
     */
    public void setMemberShip(String argMemberShip) {

        memberShip = argMemberShip;

    }

    /**
     * @return the club
     */
    public String getClub() {

        return club;

    }

    /**
     * @param argClub the club to set
     */
    public void setClub(String argClub) {

        club = argClub;

    }

    /**
     * @return the status
     */
    public String getStatus() {

        return status;

    }

    /**
     * @param argStatus the status to set
     */
    public void setStatus(String argStatus) {

        status = argStatus;

    }

    /**
     * @return the expDate
     */
    public String getExpDate() {

        return expDate;

    }

    /**
     * @param argExpDate the expDate to set
     */
    public void setExpDate(String argExpDate) {

        expDate = argExpDate;

    }

    //BEGIN BZ48564
    /**
     * @return the totalCouponAmount
     */
    public String getTotalCouponAmount() {
    
        return totalCouponAmount;
    }

    
    /**
     * @param argTotalCouponAmount the totalCouponAmount to set
     */
    public void setTotalCouponAmount(String argTotalCouponAmount) {
    
        totalCouponAmount = argTotalCouponAmount;
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

    
    /**
     * @return the coupon
     */
    public List<IAwardAccountCoupon> getCoupon() {
    
        return coupon;
    }

    
    /**
     * @param argCoupon the coupon to set
     */
    public void setCoupon(List<IAwardAccountCoupon> argCoupon) {
    
        coupon = argCoupon;
    }
    //END BZ48564

    //BEGIN BZ57844
    /**
     * @return the daysExpired
     */
    public int getDaysExpired() {
        return daysExpired;
    }


    /**
     * @param argDaysExpired the daysExpired to set
     */
    public void setDaysExpired(int argDaysExpired) {
        daysExpired = argDaysExpired;
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
    //END BZ57844

}
