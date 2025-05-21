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
 * BZ23147          070917    Implement Serialized coupon
 *===================================================================
 */

package caw.pos.promotion.api.response;

import java.util.List;

/**
 * Coupon template
 */
public class CawCouponData {

    private String                      identifier;

    private String                      serialNumber;

    private String                      groupCode;

    private String                      promotion;

    private String                      maxValue;

    private String                      status;

    private String                      validFrom;

    private String                      validTo;

    private String                      createDate;

    private String                      createUser;

    private String                      updateDate;

    private String                      updateUser;

    private List<CawSerialInfoActivity> activities;

    /**
     * @return the identifier
     */
    public String getIdentifier() {

        return identifier;
    }

    /**
     * @param argIdentifier the identifier to set
     */
    public void setIdentifier(String argIdentifier) {

        identifier = argIdentifier;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {

        return serialNumber;
    }

    /**
     * @param argSerialNumber the serialNumber to set
     */
    public void setSerialNumber(String argSerialNumber) {

        serialNumber = argSerialNumber;
    }

    /**
     * @return the groupCode
     */
    public String getGroupCode() {

        return groupCode;
    }

    /**
     * @param argGroupCode the groupCode to set
     */
    public void setGroupCode(String argGroupCode) {

        groupCode = argGroupCode;
    }

    /**
     * @return the promotion
     */
    public String getPromotion() {

        return promotion;
    }

    /**
     * @param argPromotion the promotion to set
     */
    public void setPromotion(String argPromotion) {

        promotion = argPromotion;
    }

    /**
     * @return the maxValue
     */
    public String getMaxValue() {

        return maxValue;
    }

    /**
     * @param argMaxValue the maxValue to set
     */
    public void setMaxValue(String argMaxValue) {

        maxValue = argMaxValue;
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
     * @return the validFrom
     */
    public String getValidFrom() {

        return validFrom;
    }

    /**
     * @param argValidFrom the validFrom to set
     */
    public void setValidFrom(String argValidFrom) {

        validFrom = argValidFrom;
    }

    /**
     * @return the validTo
     */
    public String getValidTo() {

        return validTo;
    }

    /**
     * @param argValidTo the validTo to set
     */
    public void setValidTo(String argValidTo) {

        validTo = argValidTo;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {

        return createDate;
    }

    /**
     * @param argCreateDate the createDate to set
     */
    public void setCreateDate(String argCreateDate) {

        createDate = argCreateDate;
    }

    /**
     * @return the createUser
     */
    public String getCreateUser() {

        return createUser;
    }

    /**
     * @param argCreateUser the createUser to set
     */
    public void setCreateUser(String argCreateUser) {

        createUser = argCreateUser;
    }

    /**
     * @return the updateDate
     */
    public String getUpdateDate() {

        return updateDate;
    }

    /**
     * @param argUpdateDate the updateDate to set
     */
    public void setUpdateDate(String argUpdateDate) {

        updateDate = argUpdateDate;
    }

    /**
     * @return the updateUser
     */
    public String getUpdateUser() {

        return updateUser;
    }

    /**
     * @param argUpdateUser the updateUser to set
     */
    public void setUpdateUser(String argUpdateUser) {

        updateUser = argUpdateUser;
    }

    /**
     * @return the activities
     */
    public List<CawSerialInfoActivity> getActivities() {

        return activities;
    }

    /**
     * @param argActivities the activities to set
     */
    public void setActivities(List<CawSerialInfoActivity> argActivities) {

        activities = argActivities;
    }

}
