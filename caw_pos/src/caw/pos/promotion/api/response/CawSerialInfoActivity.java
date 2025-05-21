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

/**
 * Received Activity template
 */
public class CawSerialInfoActivity {

    private String identifier;

    private String businessDate;

    private String storeNumber;

    private String tillNumber;

    private String transactionNumber;

    private String couponCode;

    private String amountUsed;

    private String status;

    private String createDate;

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
     * @return the businessDate
     */
    public String getBusinessDate() {

        return businessDate;
    }

    /**
     * @param argBusinessDate the businessDate to set
     */
    public void setBusinessDate(String argBusinessDate) {

        businessDate = argBusinessDate;
    }

    /**
     * @return the storeNumber
     */
    public String getStoreNumber() {

        return storeNumber;
    }

    /**
     * @param argStoreNumber the storeNumber to set
     */
    public void setStoreNumber(String argStoreNumber) {

        storeNumber = argStoreNumber;
    }

    /**
     * @return the tillNumber
     */
    public String getTillNumber() {

        return tillNumber;
    }

    /**
     * @param argTillNumber the tillNumber to set
     */
    public void setTillNumber(String argTillNumber) {

        tillNumber = argTillNumber;
    }

    /**
     * @return the transactionNumber
     */
    public String getTransactionNumber() {

        return transactionNumber;
    }

    /**
     * @param argTransactionNumber the transactionNumber to set
     */
    public void setTransactionNumber(String argTransactionNumber) {

        transactionNumber = argTransactionNumber;
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
     * @return the amountUsed
     */
    public String getAmountUsed() {

        return amountUsed;
    }

    /**
     * @param argAmountUsed the amountUsed to set
     */
    public void setAmountUsed(String argAmountUsed) {

        amountUsed = argAmountUsed;
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
}
