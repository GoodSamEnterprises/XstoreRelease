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
 * BZ28247          181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

/**
 * The CawAdsResponse
 */
public class CawAdsResponse {
    /**
     * The returnCode
     */
    private String returnCode;

    /**
     * The errorMessage
     */
    private String errorMessage;

    /**
     * The accountId
     */
    private String accountId;

    /**
     * The applicationId
     */
    private String applicationId;
    
    /* BEGIN BZ29280 */
    
    private int cardType;
    
    private String creditLimit;
    
    private String apr;
    
    private String virtualCreditLimit;

    /**
     * @return
     */
    public String getVirtualCreditLimit() {
        return virtualCreditLimit;
    }

    /**
     * @param argVirtualCreditLimit
     */
    public void setVirtualCreditLimit(String argVirtualCreditLimit) {
        virtualCreditLimit = argVirtualCreditLimit;
    }

    /**
     * @return
     */
    public String getApr() {
        return apr;
    }

    /**
     * @param argApr
     */
    public void setApr(String argApr) {
        apr = argApr;
    }

    /**
     * @return
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param argCreditLimit
     */
    public void setCreditLimit(String argCreditLimit) {
        creditLimit = argCreditLimit;
    }

    /**
     * @return
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * @param argCardType
     */
    public void setCardType(int argCardType) {
        cardType = argCardType;
    }
    /* END BZ29280 */
    public CawAdsResponse(String argReturnCode, String argErrorMessage, String argAccountId, String argApplicationId,
            int argCardType, String argCreditLimit, String argApr, String argVirtualCreditLimit) {
        super();
        returnCode = argReturnCode;
        errorMessage = argErrorMessage;
        accountId = argAccountId;
        applicationId = argApplicationId;
        /* BEGIN BZ29280 */
        cardType = argCardType;
        creditLimit = argCreditLimit;
        apr = argApr;
        virtualCreditLimit = argVirtualCreditLimit;
        /* END BZ29280 */
    }

    /**
     * @return
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * @param argReturnCode
     */
    public void setReturnCode(String argReturnCode) {
        returnCode = argReturnCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param argErrorMessage
     */
    public void setErrorMessage(String argErrorMessage) {
        errorMessage = argErrorMessage;
    }

    /**
     * @return
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param argAccountId
     */
    public void setAccountId(String argAccountId) {
        accountId = argAccountId;
    }

    /**
     * @return
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * @param argApplicationId
     */
    public void setApplicationId(String argApplicationId) {
        applicationId = argApplicationId;
    }

}