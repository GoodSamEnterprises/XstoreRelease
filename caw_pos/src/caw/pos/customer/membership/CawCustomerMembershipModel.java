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
 * BZ48567              100222    [Task] - Display Loyalty Information on the Membership Info tab
 *===================================================================
 */

package caw.pos.customer.membership;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;
import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NO_SETTER;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dtv.pos.framework.form.BasicEditModel;
import dtv.pos.framework.form.EditModelField;
import dtv.pos.iframework.form.ICardinality;
import dtv.pos.iframework.form.IEditModelField;

/**
 * The CawCustomerMembershipModel
 */
public class CawCustomerMembershipModel extends BasicEditModel {

    /**
     * The accountValue
     */
    private String                          accountValue;
    /**
     * The statusValue
     */
    private String                          statusValue;
    /**
     * The availableCreditValue
     */
    private String                          availableCreditValue;
    /**
     * The taxExemptStatusValue
     */
    private String                          taxExemptStatusValue;
    /**
     * The accountOnHoldValue
     */
    private String                          accountOnHoldValue;

    /**
     * The avatarIcon
     */
    private String                          avatarIcon;
    
    /*Begin BZ48567*/
    private String                          pointsBalance;

    private String                          redeemableAmount;

    private String                          redeemableValue;
    
    private String                          pointsExpiring;

    private String                          pointsToNextReward;   
    
    /*End BZ48567*/
    
    
    /** The Constant CUSTOMER_MEMBER_SHIP_LIST. */
    public static final String              CUSTOMER_MEMBER_SHIP_LIST = "customerMembershipList";

    /**
     * The customerMembershipList
     */
    private List<CawCustomerMembershipView> customerMembershipList    = new ArrayList<>();

    /**
     * The CawCustomerMembershipModel default constructor
     */
    public CawCustomerMembershipModel() {

    }

    /**
     * Initial field values
     */
    public void initFieldValues() {

        addField("avatarIcon", String.class, 10);
        addField("accountValue", String.class);
        addField("statusValue", String.class);
        addField("availableCreditValue", String.class);
        addField("taxExemptStatusValue", String.class);
        addField("accountOnHoldValue", String.class);
        /*Begin BZ48567*/
        addField("pointsBalance", String.class);
        addField("redeemableAmount", String.class);
        addField("redeemableValue", String.class);
        addField("pointsExpiring", String.class);
        addField("pointsToNextReward", String.class);
        /*End BZ48567*/
        
        

        IEditModelField<?> membershipField = EditModelField
                .makeFieldDefUnsafe(this, CUSTOMER_MEMBER_SHIP_LIST, List.class, ATTR_NEW
                        + ATTR_NO_SETTER, null, ICardinality.OPTIONAL, getCustomerMembershipList(), null, null, null);
        addField(membershipField);

        initializeFieldState();

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
     * @return the pointsExpiring
     */
    public String getPointsExpiring() {
    
        return pointsExpiring;
    }

    
    /**
     * @param argPointsExpiring the pointsExpiring to set
     */
    public void setPointsExpiring(String argPointsExpiring) {
    
        pointsExpiring = argPointsExpiring;
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
     * @return the accountValue
     */
    public String getAccountValue() {

        return accountValue;

    }

    /**
     * @param argAccountValue the accountValue to set
     */
    public void setAccountValue(String argAccountValue) {

        accountValue = argAccountValue;

    }

    /**
     * @return the statusValue
     */
    public String getStatusValue() {

        return statusValue;

    }

    /**
     * @param argStatusValue the statusValue to set
     */
    public void setStatusValue(String argStatusValue) {

        statusValue = argStatusValue;

    }

    /**
     * @return the availableCreditValue
     */
    public String getAvailableCreditValue() {

        return availableCreditValue;

    }

    /**
     * @param argAvailableCreditValue the availableCreditValue to set
     */
    public void setAvailableCreditValue(String argAvailableCreditValue) {

        availableCreditValue = argAvailableCreditValue;

    }

    /**
     * @return the taxExemptStatusValue
     */
    public String getTaxExemptStatusValue() {

        return taxExemptStatusValue;

    }

    /**
     * @param argTaxExemptStatusValue the taxExemptStatusValue to set
     */
    public void setTaxExemptStatusValue(String argTaxExemptStatusValue) {

        taxExemptStatusValue = argTaxExemptStatusValue;

    }

    /**
     * @return the accountOnHoldValue
     */
    public String getAccountOnHoldValue() {

        return accountOnHoldValue;

    }

    /**
     * @param argAccountOnHoldValue the accountOnHoldValue to set
     */
    public void setAccountOnHoldValue(String argAccountOnHoldValue) {

        accountOnHoldValue = argAccountOnHoldValue;

    }

    /**
     * @return the avatarIcon
     */
    public String getAvatarIcon() {

        return avatarIcon;

    }

    /**
     * @param argAvatarIcon the avatarIcon to set
     */
    public void setAvatarIcon(String argAvatarIcon) {

        avatarIcon = argAvatarIcon;

    }

    /**
     * @return the memberShipList
     */
    public List<CawCustomerMembershipView> getCustomerMembershipList() {

        return customerMembershipList;

    }

    /**
     * @param argMemberShipList the memberShipList to set
     */
    public void setCustomerMembershipList(
            List<CawCustomerMembershipView> argMemberShipList) {

        customerMembershipList = argMemberShipList;

    }
}
