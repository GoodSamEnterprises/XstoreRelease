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
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ24424          131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ25434          200418    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.xml.bind.annotation.*;

/**
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CawMembershipActivityModel {

    @XmlAttribute(name = "name")
    private String  name;

    @XmlElement(name = "ValidateMembershipID")
    private boolean validateMembershipID;

    /* Begin BZ25434*/
    @XmlElement(name = "PromptingMemberShipID")
    private boolean promptingMemberShipID;
    /* End BZ25434*/

    @XmlElement(name = "PromptTitle")
    private String  promptTitle;

    @XmlElement(name = "PromptMessage")
    private String  promptMessage;

    @XmlElement(name = "CustomerGroup")
    private String  customerGroup;

    @XmlElement(name = "IsAuto")
    private boolean autoRenew;

    // Begin BZ24424
    @XmlElement(name = "MembershipType")
    private String  membershipType;

    @XmlElement(name = "MembershipTypeDescription")
    private String  membershipTypeDescription;

    @XmlElement(name = "MembershipStatus")
    private String  membershipStatus;

    @XmlElement(name = "MembershipStatusDescription")
    private String  membershipStatusDescription;

    @XmlElement(name = "BenefitLevel")
    private String  benefitLevel;

    @XmlElement(name = "BenefitLevlName")
    private String  benefitLevlName;

    // End BZ24424

    public String getName() {

        return name;
    }

    public void setName(String argName) {

        name = argName;
    }

    public boolean isValidateMembershipID() {

        return validateMembershipID;
    }

    public void setValidateMembershipID(boolean argValidateMembershipID) {

        validateMembershipID = argValidateMembershipID;
    }

    public String getPromptTitle() {

        return promptTitle;
    }

    public void setPromptTitle(String argPromptTitle) {

        promptTitle = argPromptTitle;
    }

    public String getPromptMessage() {

        return promptMessage;
    }

    public void setPromptMessage(String argPromptMessage) {

        promptMessage = argPromptMessage;
    }

    public String getCustomerGroup() {

        return customerGroup;
    }

    public void setCustomerGroup(String argCustomerGroup) {

        customerGroup = argCustomerGroup;
    }

    public boolean isAutoRenew() {

        return autoRenew;
    }

    public void setAutoRenew(boolean argAutoRenew) {

        autoRenew = argAutoRenew;
    }

    // Begin BZ24424
    public String getMembershipType() {

        return membershipType;
    }

    public void setMembershipType(String argMembershipType) {

        membershipType = argMembershipType;
    }

    public String getMembershipStatus() {

        return membershipStatus;
    }

    public void setMembershipStatus(String argMembershipStatus) {

        membershipStatus = argMembershipStatus;
    }

    public String getMembershipTypeDescription() {

        return membershipTypeDescription;
    }

    public void setMembershipTypeDescription(
            String argMembershipTypeDescription) {

        membershipTypeDescription = argMembershipTypeDescription;
    }

    public String getBenefitLevel() {

        return benefitLevel;
    }

    public void setBenefitLevel(String argBenefitLevel) {

        benefitLevel = argBenefitLevel;
    }

    public String getBenefitLevlName() {

        return benefitLevlName;
    }

    public void setBenefitLevlName(String argBenefitLevlName) {

        benefitLevlName = argBenefitLevlName;
    }

    public String getMembershipStatusDescription() {

        return membershipStatusDescription;
    }

    public void setMembershipStatusDescription(
            String argMembershipStatusDescription) {

        membershipStatusDescription = argMembershipStatusDescription;
    }
    // End BZ24424

    /* Begin BZ25434*/
    /**
     * @return the promptingMemberShipID
     */
    public boolean isPromptingMemberShipID() {

        return promptingMemberShipID;
    }

    /**
     * @param argPromptingMemberShipID the promptingMemberShipID to set
     */
    public void setPromptingMemberShipID(boolean argPromptingMemberShipID) {

        promptingMemberShipID = argPromptingMemberShipID;
    }
    /* End BZ25434*/

}
