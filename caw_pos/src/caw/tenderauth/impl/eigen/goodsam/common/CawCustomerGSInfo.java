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
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ25762          121418    New Requirement - Credit Account Look up integration in Xstore
 * BZ28012          211218    [New Requirement] Update the Caretaker Calls to include all credit application responses
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29379          140219    [Internal] Xstore should display the actual response provided by Eigen MiraServ once returning an unsuccessful GS Account Payment inquiry response
 * BZ29360          150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29422          010319    [Internal] Existing Account Response screen is not prompted when customer has already an existing account.
 * BZ29505          010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.common;

import java.math.BigDecimal;

/**
 *
 */
public class CawCustomerGSInfo {
    /* BEGIN BZ29280 */
    private String returnCode        = "";

    private String message           = "";

    private String applicationId     = "";

    private String vitualCreditLimit = "0";
    /* BEGIN BZ27973 */

    private String address1;

    private String city;

    private String state;

    private String zipCode;
    
    private String extendedCardType;/*BZ33319*/

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String argAddress1) {
        address1 = argAddress1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String argCity) {
        city = argCity;
    }

    public String getState() {
        return state;
    }

    public void setState(String argState) {
        state = argState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String argZipCode) {
        zipCode = argZipCode;
    }

    /* END BZ27973 */
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String argApplicationId) {
        applicationId = argApplicationId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String argReturnCode) {
        returnCode = argReturnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String argMessage) {
        message = argMessage;
    }

    public String getVitualCreditLimit() {
        return vitualCreditLimit;
    }

    public void setVitualCreditLimit(String argVitualCreditLimit) {
        vitualCreditLimit = argVitualCreditLimit;
    }

    public String apr = "";

    public String getApr() {
        return apr;
    }

    public void setApr(String argApr) {
        apr = argApr;
    }

    /* END BZ29280 */
    private String     accountId         = "";
    
    private String     accountShortToken = "";             /*BZ29505*/

    private String     accountLongToken  = "";             /*BZ25762, BZ29536: change to Long Token*/

    private String     preScreenId       = "";

    /**
     * Card type:
     * 1. VISA
     * 2. PLCC
     */
    private int        cardType          = 0;

    /**
     * Application type:
     * 1. PrescreenAccept
     * 2. InstantCredit
     */
    private int        applicationType   = 0;

    /* BEGIN BZ28012 */
    /**
     * Application status:
     * 0. Not specified
     * 1. Approved
     * 2. Declined
     * 4. Other
     */
    private int        applicationStatus = 4;
    /* END BZ28012 */

    private String     creditLimit       = "";

    private String     termLimit         = "";

    private String     termLimitType     = "";

    private String     rateAPR           = "";

    private boolean    isVerified        = false;

    private boolean    applyGS           = false;

    /*BEGIN BZ27973*/
    private String     firstNameADS      = "";

    private String     lastNameADS       = "";

    private BigDecimal minAmountDue      = BigDecimal.ZERO;

    private String     dueDate           = "";

    private String     markedPAN         = "";

    private BigDecimal blance            = BigDecimal.ZERO;
    /*END BZ27973*/

    /* BEGIN BZ25762 */
    private String     expiryDay         = "";

    /**
     * @return the expiryDate
     */
    public String getExpiryDate() {
        return expiryDay;
    }

    /**
     * @param argExpiryDate the expiryDate to set
     */
    public void setExpiryDay(String argExpiryDay) {
        expiryDay = argExpiryDay;
    }
    /* END BZ25762 */

    /**
     * @return the termLimitType
     */
    public String getTermLimitType() {

        return termLimitType;
    }

    /**
     * @param argTermLimitType the termLimitType to set
     */
    public void setTermLimitType(String argTermLimitType) {

        termLimitType = argTermLimitType;
    }

    /**
     * @return the applyGS
     */
    public boolean isApplyGS() {

        return applyGS;
    }

    /**
     * @param argApplyGS the applyGS to set
     */
    public void setApplyGS(boolean argApplyGS) {

        applyGS = argApplyGS;
    }

    /**
     * @return the isVerified
     */
    public boolean isVerified() {

        return isVerified;
    }

    /**
     * @param argIsVerified the isVerified to set
     */
    public void setVerified(boolean argIsVerified) {

        isVerified = argIsVerified;
    }

    /**
     * @return the termLimit
     */
    public String getTermLimit() {

        return termLimit;
    }

    /**
     * @param argTermLimit the termLimit to set
     */
    public void setTermLimit(String argTermLimit) {

        termLimit = argTermLimit;
    }

    /**
     * @return the creditLimit
     */
    public String getCreditLimit() {

        return creditLimit;
    }

    /**
     * @param argCreditLimit the creditLimit to set
     */
    public void setCreditLimit(String argCreditLimit) {

        creditLimit = argCreditLimit;
    }

    /**
     * @return the rateAPR
     */
    public String getRateAPR() {

        return rateAPR;
    }

    /**
     * @param argRateAPR the rateAPR to set
     */
    public void setRateAPR(String argRateAPR) {

        rateAPR = argRateAPR;
    }

    /**
     * BZ29360: change to AccountShortToken
     * BZ29536: change to Long Token
     * @return the accountNumber
     */
    public String getAccountLongToken() {

        return accountLongToken;
    }

    /**
     * BZ29360: change to AccountShortToken
     * BZ29536: change to Long Token
     * @param argAccountNumber the accountNumber to set
     */
    public void setAccountLongToken(String argAccountNumber) {

        accountLongToken = argAccountNumber;
    }

    /**
     * @return the preScreenId
     */
    public String getPreScreenId() {

        return preScreenId;
    }

    /**
     * @param argPreScreenId the preScreenId to set
     */
    public void setPreScreenId(String argPreScreenId) {

        preScreenId = argPreScreenId;
    }

    /**
     * @return the cardType
     */
    public int getCardType() {

        return cardType;
    }

    /**
     * @param argCardType the cardType to set
     */
    public void setCardType(int argCardType) {

        cardType = argCardType;
    }

    /**
     * @return the applicationType
     */
    public int getApplicationType() {

        return applicationType;
    }

    /**
     * @param argApplicationType the applicationType to set
     */
    public void setApplicationType(int argApplicationType) {

        applicationType = argApplicationType;
    }

    /**
     * @return the applicationStatus
     */
    public int getApplicationStatus() {

        return applicationStatus;
    }

    /**
     * @param argApplicationStatus the applicationStatus to set
     */
    public void setApplicationStatus(int argApplicationStatus) {

        applicationStatus = argApplicationStatus;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {

        return accountId;
    }

    /**
     * @param argAccountId the accountId to set
     */
    public void setAccountId(String argAccountId) {

        accountId = argAccountId;
    }

    /*BEGIN BZ27973*/
    /**
     * @return the firstNameADS
     */
    public String getFirstNameADS() {
        return firstNameADS;
    }

    /**
     * @param argFirstNameADS the firstNameADS to set
     */
    public void setFirstNameADS(String argFirstNameADS) {
        firstNameADS = argFirstNameADS;
    }

    /**
     * @return the lastNameADS
     */
    public String getLastNameADS() {
        return lastNameADS;
    }

    /**
     * @param argLastNameADS the lastNameADS to set
     */
    public void setLastNameADS(String argLastNameADS) {
        lastNameADS = argLastNameADS;
    }

    /**
     * @return the minAmountDue
     */
    public BigDecimal getMinAmountDue() {
        return minAmountDue;
    }

    /**
     * @param argMinAmountDue the minAmountDue to set
     */
    public void setMinAmountDue(BigDecimal argMinAmountDue) {
        minAmountDue = argMinAmountDue;
    }

    /**
     * @return the markedPAN
     */
    public String getMarkedPAN() {
        return markedPAN;
    }

    /**
     * @param argMarkedPAN the markedPAN to set
     */
    public void setMarkedPAN(String argMarkedPAN) {
        markedPAN = argMarkedPAN;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param argDueDate the dueDate to set
     */
    public void setDueDate(String argDueDate) {
        dueDate = argDueDate;
    }

    /**
     * @return the blance
     */
    public BigDecimal getBlance() {
        return blance;
    }

    /**
     * @param argBlance the blance to set
     */
    public void setBlance(BigDecimal argBlance) {
        blance = argBlance;
    }
    /*END BZ27973*/

    /*BEGIN BZ29379*/
    private String responseMgs = "";

    /**
     * @return the responseMgs
     */
    public String getResponseMgs() {

        return responseMgs;
    }

    /**
     * @param argResponseMgs the responseMgs to set
     */
    public void setResponseMgs(String argResponseMgs) {

        responseMgs = argResponseMgs;
    }
    /*END BZ29379*/

    /*BEGIN BZ29360*/
    private boolean isTokenUsed = false;

    /**
     * @return the isTokenUsed
     */
    public boolean isTokenUsed() {

        return isTokenUsed;
    }

    /**
     * @param argIsTokenUsed the isTokenUsed to set
     */
    public void setTokenUsed(boolean argIsTokenUsed) {

        isTokenUsed = argIsTokenUsed;
    }
    /*END BZ29360*/

    /* BEGIN BZ29422 */
    private String accountResponseType = "";

    /**
     * @return the accountResponseType
     */
    public String getAccountResponseType() {

        return accountResponseType;
    }

    /**
     * @param argAccountResponseType the accountResponseType to set
     */
    public void setAccountResponseType(String argAccountResponseType) {

        accountResponseType = argAccountResponseType;
    }
    /* BEGIN BZ29422 */

    /*BEGIN BZ29505*/
    /**
     * @return the accountShortToken
     */
    public String getAccountShortToken() {
    
        return accountShortToken;
    }

    
    /**
     * @param argAccountShortToken the accountShortToken to set
     */
    public void setAccountShortToken(String argAccountShortToken) {
    
        accountShortToken = argAccountShortToken;
    }
    /*END BZ29505*/
    /*BEGIN BZ33319*/
    /**
     * @return the extendedCardType
     */
    public String getExtendedCardType() {

        return extendedCardType;
    }

    /**
     * @param argExtendedCardType the extendedCardType to set
     */
    public void setExtendedCardType(String argExtendedCardType) {

        extendedCardType = argExtendedCardType;
    }

    /*END BZ33319*/
}
