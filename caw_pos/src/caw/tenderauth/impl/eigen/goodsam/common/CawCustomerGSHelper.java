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
 * BZ28740          201218    [PLCC] Can't do trans with New GSVisa Card
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ28942          300119    [Internal] Credit card name displays inconsistent on shopping Pass receipt and Xstore screen
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29379          140219    [Internal] Xstore should display the actual response provided by Eigen MiraServ once returning an unsuccessful GS Account Payment inquiry response
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ29360          150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29419          180219    [Internal] Xstore needs to change response screen for instant credit when offline.
 * BZ29454          220219    [Internal] Temporary Shopping Pass is missing Temporary Limit amount.
 * BZ29505          250219    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29535          270219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 * BZ29422          010319    [Internal] Existing Account Response screen is not prompted when customer has already an existing account.
 * BZ29505          010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29704          120319    [PLCC Cert] Xstore displays the incorrect message for instant credit timeout
 * BZ29960          280319    [Port the fixed BZ 29923 into 4.1 release] Cannot tender with GSV Account Lookup due to Invalid Expired date
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ57844          040823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58836          080923    [Internal] Disqualification of GS Membership offer displays unexpectedly at print receipt when using PLCC amount for Account Lookup
 * BZ58840          080923    [Internal] Disqualification of GS Membership offer display unexpectedly when not applied for GS Membership offer
 * BZ58779          110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.common;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.card.services.CawCardServiceHelper;
import caw.pos.common.*;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.op.CawAdsResponse;
import caw.tenderauth.impl.mira.constants.CawCardType;
import twitter4j.*;

import dtv.hardware.types.HardwareType;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.type.NonPhysicalItemType;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemModel;
import dtv.xst.dao.ttr.impl.TenderLineItemModel;

/**
 *
 */
public class CawCustomerGSHelper {

    private static volatile CawCustomerGSHelper _instance       = null;

    private static CawCustomerGSInfo            _customerGSInfo = null;

    /* BEGIN BZ29419 */

    private String                              eigenReturnCode;

    private String                              adsReturnCode;

    public String getEigenReturnCode() {
        return eigenReturnCode;
    }

    public void setEigenReturnCode(String argReturnCode) {
        eigenReturnCode = argReturnCode;
    }
    /* END BZ29419 */

    public String getAdsReturnCode() {
        return adsReturnCode;
    }

    public void setAdsReturnCode(String argAdsReturnCode) {
        adsReturnCode = argAdsReturnCode;
    }

    /* BEGIN BZ27973 */
    private String accountCode;

    public String getAccountCode() {

        return accountCode;
    }

    public void setAccountCode(String argAccountCode) {

        accountCode = argAccountCode;
    }

    /* END BZ27973 */

    /* BEGIN BZ29704 */
    private String adsAuxResponseCode;

    /**
     * @return the adsAuxResponseCode
     */
    public String getAdsAuxResponseCode() {

        return adsAuxResponseCode;
    }

    /**
     * @param argAdsAuxResponseCode the adsAuxResponseCode to set
     */
    public void setAdsAuxResponseCode(String argAdsAuxResponseCode) {

        adsAuxResponseCode = argAdsAuxResponseCode;
    }

    /* END BZ29704 */

    /* BEGIN BZ29280 */
    /**
     * The _cawCardServiceHelper
     */
    private static CawCardServiceHelper _cawCardServiceHelper = CawCardServiceHelper.getInstance();

    private static final Logger         _logger               = LogManager.getLogger(CawCustomerGSHelper.class);

    /* END BZ29280 */
    /* BEGIN BZ57844 */
    private final String                CAW_ENABLE_GS_MEMBERSHIP_OFFER      = "CAW_ENABLE_GS_MEMBERSHIP_OFFER";

    private final String                APPROVED              = "APPROVED";

    /* END BZ57844 */
    /**
     * 
     * @return
     */
    public static CawCustomerGSHelper getInstance() {

        if (_instance == null) {
            synchronized (CawCustomerGSHelper.class) {
                if (_instance == null) {
                    _instance = new CawCustomerGSHelper();
                }
            }
        }
        return _instance;
    }

    /**
     * 
     * Card type:
     * 1. VISA
     * 2. PLCC
     * 
     * Application type:
     * 1. PrescreenAccept
     * 2. InstantCredit
     * 
     * Application status:
     * 1. Approved
     * 2. Declined
     * 3. Other
     */
    protected CawCustomerGSHelper() {

        _customerGSInfo = new CawCustomerGSInfo();
    }

    /**
     * 
     * @return
     */
    public CawCustomerGSInfo getGSInfo() {

        return _customerGSInfo;
    }

    /**
     * 
     */
    public void clearGSInfo() {

        _customerGSInfo = new CawCustomerGSInfo(); /*BZ28740: should be create new with default value instead of set null*/
    }

    /**
     * BZ29360: change to AccountShortToken
     * BZ29536: change to Long Token
     * @param accNumber
     */
    public void setAccountLongToken(String accNumber) {

        _customerGSInfo.setAccountLongToken(accNumber);
    }

    /**
     * BZ29360: change to AccountShortToken
     * BZ29536: change to Long Token
     * @return
     */
    public String getAccountLongToken() {//BZ29406

        return _customerGSInfo.getAccountLongToken();
    }

    /**
     * 
     * @param preScreenId
     */
    public void setPreScreenId(String preScreenId) {

        _customerGSInfo.setPreScreenId(preScreenId);
    }

    /**
     * 
     * @return
     */
    public String getPreScreenId() {

        return _customerGSInfo.getPreScreenId();
    }

    /**
     * Card type:
     * 1. VISA
     * 2. PLCC
     * @param cardType
     */
    public void setCardType(int cardType) {

        _customerGSInfo.setCardType(cardType);
    }

    /**
     * Card type:
     * 1. VISA
     * 2. PLCC
     * @return
     */
    public int getCardType() {

        return _customerGSInfo.getCardType();
    }

    /**
     * Application type:
     * 1. PrescreenAccept
     * 2. InstantCredit
     * @param applicationType
     */
    public void setApplicationType(int applicationType) {

        _customerGSInfo.setApplicationType(applicationType);
    }

    /**
     * 
     * Application status:
     * 1. Approved
     * 2. Declined
     * 3. Other
     *
     * @param applicationStatus
     */
    public void setApplicationStatus(int applicationStatus) {

        _customerGSInfo.setApplicationStatus(applicationStatus);
    }

    /**
     * Application status:
     * 1. Approved
     * 2. Declined
     * 3. Other
     * @return
     */
    public int getApplicationStatus() {

        return _customerGSInfo.getApplicationStatus();
    }

    /**
     * 
     * @param creditLimit
     */
    public void setCreditLimit(String creditLimit) {

        _customerGSInfo.setCreditLimit(creditLimit);
    }

    /**
     * 
     * @param termLimit
     */
    public void setTermLimit(String termLimit) {

        _customerGSInfo.setTermLimit(termLimit);
    }

    /**
     * 
     * @param isVerified
     */
    public void isVerified(boolean isVerified) {

        _customerGSInfo.setVerified(isVerified);
    }

    /**
     * 
     * @return
     */
    public boolean isVerified() {

        return _customerGSInfo.isVerified();
    }

    /**
     * 
     * @param creditLimit
     */
    public void setApr(String apr) {

        _customerGSInfo.setRateAPR(apr);
    }

    /**
     * 
     * @param isApplyGS
     */
    public void isApplyGS(boolean isApplyGS) {

        _customerGSInfo.setApplyGS(isApplyGS);
    }

    /**
     * 
     * @param limitType
     */
    public void setTermLimitType(String limitType) {

        _customerGSInfo.setTermLimitType(limitType);
    }

    /**
     * @param argGetTField
     */
    public void setAccountId(String argGetTField) {

        _customerGSInfo.setAccountId(argGetTField);
    }

    /**
     * @return
     */
    public String getCreditLimit() {

        return _customerGSInfo.getCreditLimit();
    }

    /**
     * @return
     */
    public String getRateAPR() {

        return _customerGSInfo.getRateAPR();
    }

    /* BEGIN BZ25762 */
    public String getExpiryDay() {
        return _customerGSInfo.getExpiryDate();
    }

    public void setExpiryDay(String argExpiryDay) {
        _customerGSInfo.setExpiryDay(argExpiryDay);
    }

    /* END BZ25762 */

    /*BEGIN BZ27973*/
    public void setFirstNameADS(String argFirstName) {

        _customerGSInfo.setFirstNameADS(argFirstName);
    }

    public String getFirstNameADS() {

        return _customerGSInfo.getFirstNameADS();
    }

    public void setLastNameADS(String argLastName) {

        _customerGSInfo.setLastNameADS(argLastName);
    }

    public String getLastNameADS() {

        return _customerGSInfo.getLastNameADS();
    }

    public void setMinAmountDue(BigDecimal argMinAmountDue) {

        _customerGSInfo.setMinAmountDue(argMinAmountDue);
    }

    public BigDecimal getMinAmountDue() {

        return _customerGSInfo.getMinAmountDue();
    }

    public void setDueDate(String argDueDate) {

        _customerGSInfo.setDueDate(argDueDate);
    }

    public String getDueDate() {

        return _customerGSInfo.getDueDate();
    }

    public void setMarkedPAN(String argMarkedPAN) {

        _customerGSInfo.setMarkedPAN(argMarkedPAN);
    }

    public String getMarkedPAN() {

        return _customerGSInfo.getMarkedPAN();
    }

    public BigDecimal getBalance() {

        return _customerGSInfo.getBlance();
    }

    public void setBalance(BigDecimal argDueDate) {

        _customerGSInfo.setBlance(argDueDate);
    }
    /*END BZ27973*/

    /***
     * Method is used to get the description of card type to print the receipt.
     * @param cawEigenMgr is object of EigenMgr
     * @param keyTranslation is key in translations.property
     * @param paramVisa is Visa® Credit Card
     * @param paramPLCC is Credit Card
     * @return Description Card Type
     */
    /* BEGIN BZ28942 */
    public String getDescriptionCardType(CawEigenMgr cawEigenMgr, String keyTranslation, String paramVisa,
            String paramPLCC) {
        String txtDescriptionCardType = "";
        if (getCardType() == 1) {
            txtDescriptionCardType = cawEigenMgr.makeString(keyTranslation, paramVisa);
        } else if (getCardType() == 2) {
            txtDescriptionCardType = cawEigenMgr.makeString(keyTranslation, paramPLCC);
        }
        return txtDescriptionCardType;
    }

    /* END BZ28942 */
    /* BEGIN BZ29280 */
    /**
     * Convert GR to Object data
     * @param grValue
     */
    public void convertGRToObject(String grValue) {
        String valueResponse = "";

        if (StringUtils.isNotEmpty(grValue)) {

            byte[] decoded = Base64.getDecoder().decode(grValue);

            valueResponse = new String(decoded, StandardCharsets.UTF_8);

        }

        // 1. Check and execute string is XML response

        if (isXMLResponse(valueResponse)) {

            CawAdsResponse adsResponse = _cawCardServiceHelper.parseXmlResponse(valueResponse, grValue);

            if (adsResponse != null) {
                _customerGSInfo.setReturnCode(adsResponse.getReturnCode());

                _customerGSInfo.setMessage(adsResponse.getErrorMessage());

                _customerGSInfo.setAccountId(adsResponse.getAccountId());

                _customerGSInfo.setApplicationId(adsResponse.getApplicationId());

                _customerGSInfo.setCardType(adsResponse.getCardType());

                _customerGSInfo.setCreditLimit(adsResponse.getCreditLimit());

                _customerGSInfo.setApr(adsResponse.getApr());

                _customerGSInfo.setVitualCreditLimit(adsResponse.getVirtualCreditLimit());
            }
        }
        // 2. Check and parse string is JSON response
        else if (isJSONResponse(valueResponse)) {
            JSONObject parentJsonObect = CawJSONUtils.toJSONObject(valueResponse);

            if (parentJsonObect != null) {
                try {

                    if (parentJsonObect.has(CawConstants.RETURN_CODE)) {
                        _customerGSInfo.setReturnCode(parentJsonObect.getString(CawConstants.RETURN_CODE));
                    }
                    if (parentJsonObect.has(CawConstants.ERROR_MESSAGE)) {
                        _customerGSInfo.setMessage(parentJsonObect.getString(CawConstants.ERROR_MESSAGE));
                    }

                    if (parentJsonObect.has(CawEBSConstant.CARD_TYPE)) {

                        String cardType = parentJsonObect.getString(CawEBSConstant.CARD_TYPE);

                        if (CawConstants.VISA_SHORT.equals(cardType)) { /*BZ28741: changed VISA to VISA_SHORT*/
                            _customerGSInfo.setCardType(1);
                        } else if (CawConstants.PLCC_SHORT.equals(cardType)) { /*BZ28741: changed VISA to VISA_SHORT*/
                            _customerGSInfo.setCardType(2);
                        }

                    }
                    // Process Pre-screen Acceptance
                    JSONObject prescreenAcceptance = null;
                    if (parentJsonObect.has(CawConstants.PRESCREEN_ACCEPTANCE)) {
                        prescreenAcceptance = parentJsonObect.getJSONObject(CawConstants.PRESCREEN_ACCEPTANCE);
                    }

                    if (prescreenAcceptance != null) {
                        _customerGSInfo.setAccountResponseType(CawConstants.PRESCREEN_ACCEPTANCE); //BZ29422

                        if (prescreenAcceptance.has(CawConstants.ACCOUNT_ID)) {
                            _customerGSInfo.setAccountId(prescreenAcceptance.getString(CawConstants.ACCOUNT_ID));
                        }
                        if (prescreenAcceptance.has(CawConstants.APPLICATION_ID)) {
                            _customerGSInfo
                                    .setApplicationId(prescreenAcceptance.getString(CawConstants.APPLICATION_ID));
                        }

                        if (prescreenAcceptance.has(CawConstants.CREDIT_LIMIT)) {
                            _customerGSInfo.setCreditLimit(prescreenAcceptance.getString(CawConstants.CREDIT_LIMIT));
                        } else {
                            _customerGSInfo.setCreditLimit(prescreenAcceptance.getString("0"));
                        }

                        if (prescreenAcceptance.has(CawConstants.APR)) {
                            Object apr = prescreenAcceptance.get(CawConstants.APR);
                            if (apr != null) {
                                _customerGSInfo.setApr(apr.toString());
                            }
                        }
                        /* BEGIN BZ29280 */
                        JSONObject vtcPreAcceptance = null;

                        if (prescreenAcceptance.has(CawConstants.VIRTUAL_CARD)) {
                            vtcPreAcceptance = prescreenAcceptance.getJSONObject(CawConstants.VIRTUAL_CARD);

                            if (vtcPreAcceptance != null) {
                                if (vtcPreAcceptance.has(CawConstants.CREDIT_LIMIT)) {
                                    _customerGSInfo.setVitualCreditLimit(vtcPreAcceptance
                                            .getString(CawConstants.CREDIT_LIMIT));
                                } else {
                                    _customerGSInfo.setVitualCreditLimit(CawConstants.DEFAULT_VIRTUAL_CREDIT_LIMIT);
                                }
                                if (StringUtils.isEmpty(_customerGSInfo.getExpiryDate())
                                        && vtcPreAcceptance.has(CawConstants.EXPIRATION_DATE)) {
                                    /*BEGIN BZ29960*/
                                    _customerGSInfo.setExpiryDay(applyFormat(vtcPreAcceptance
                                            .getString(CawConstants.EXPIRATION_DATE)));
                                    /*END BZ29960*/
                                }

                            }
                        }

                    }
                    // Process Instant Credit;

                    JSONObject instantCredit = null;

                    if (parentJsonObect.has(CawConstants.JSON_INSTANT_CREDIT)) {
                        instantCredit = parentJsonObect.getJSONObject(CawConstants.JSON_INSTANT_CREDIT);
                    }

                    if (instantCredit != null) {
                        _customerGSInfo.setAccountResponseType(CawConstants.JSON_INSTANT_CREDIT); //BZ29422

                        if (instantCredit.has(CawConstants.ACCOUNT_ID)) {
                            _customerGSInfo.setAccountId(instantCredit.getString(CawConstants.ACCOUNT_ID));
                        }
                        if (instantCredit.has(CawConstants.APPLICATION_ID)) {
                            _customerGSInfo.setApplicationId(instantCredit.getString(CawConstants.APPLICATION_ID));
                        }

                        if (instantCredit.has(CawConstants.CREDIT_LIMIT)) {
                            _customerGSInfo.setCreditLimit(instantCredit.getString(CawConstants.CREDIT_LIMIT));
                        } else {
                            _customerGSInfo.setCreditLimit(instantCredit.getString("0"));
                        }

                        if (instantCredit.has(CawConstants.APR)) {
                            Object apr = instantCredit.get(CawConstants.APR);
                            if (apr != null) {
                                _customerGSInfo.setApr(apr.toString());
                            }
                        }

                        JSONObject vtcInstantCredit = null;

                        if (instantCredit.has(CawConstants.VIRTUAL_CARD)) {
                            vtcInstantCredit = instantCredit.getJSONObject(CawConstants.VIRTUAL_CARD);

                            if (vtcInstantCredit != null) {
                                if (vtcInstantCredit.has(CawConstants.CREDIT_LIMIT)) {
                                    _customerGSInfo.setVitualCreditLimit(vtcInstantCredit
                                            .getString(CawConstants.CREDIT_LIMIT));
                                } else {
                                    _customerGSInfo.setVitualCreditLimit(CawConstants.DEFAULT_VIRTUAL_CREDIT_LIMIT);
                                }
                                if (StringUtils.isEmpty(_customerGSInfo.getExpiryDate())
                                        && vtcInstantCredit.has(CawConstants.EXPIRATION_DATE)) {
                                    /*BEGIN BZ29960*/
                                    _customerGSInfo.setExpiryDay(applyFormat(vtcInstantCredit
                                            .getString(CawConstants.EXPIRATION_DATE)));
                                    /*END BZ29960*/
                                }
                            }
                        }
                    }
                    /* END BZ29280 */

                    /* BEGIN BZ29454 */
                    // Process accountSummary;
                    JSONObject accountSummary = null;
                    if (parentJsonObect.has(CawConstants.CAW_ACCOUNT_SUMMARY)) {
                        accountSummary = parentJsonObect.getJSONObject(CawConstants.CAW_ACCOUNT_SUMMARY);
                    }

                    if (accountSummary != null) {
                        _customerGSInfo.setAccountResponseType(CawConstants.CAW_ACCOUNT_SUMMARY); //BZ29422

                        if (accountSummary.has(CawConstants.ACCOUNT_ID)) {
                            _customerGSInfo.setAccountId(accountSummary.getString(CawConstants.ACCOUNT_ID));
                        }

                        if (accountSummary.has(CawConstants.APPLICATION_ID)) {
                            _customerGSInfo.setApplicationId(accountSummary.getString(CawConstants.APPLICATION_ID));
                        }

                        if (accountSummary.has(CawConstants.CREDIT_LIMIT)) {
                            _customerGSInfo.setCreditLimit(accountSummary.getString(CawConstants.CREDIT_LIMIT));
                        } else {
                            _customerGSInfo.setCreditLimit(accountSummary.getString("0"));
                        }

                        if (accountSummary.has(CawConstants.APR)) {
                            Object apr = accountSummary.get(CawConstants.APR);
                            if (apr != null) {
                                _customerGSInfo.setApr(apr.toString());
                            }
                        }
                    }
                    /* END BZ29454 */
                } catch (JSONException ex) {
                    _logger.error("Could not parse Json ADS response " + ex.getMessage());
                }
            }
        }
        // 3. We are not supported response is invalid
        else {
            _logger.info("We are not supported format invalid data " + valueResponse);
            _customerGSInfo = new CawCustomerGSInfo();// Clear all variables
        }
    }

    /**
     * Check XML Response
     * @param valueResponse
     * @return
     */
    public boolean isXMLResponse(String valueResponse) {

        String xmlResponse = "";

        if (StringUtils.isNotEmpty(valueResponse)) {

            xmlResponse = valueResponse.trim();

            return xmlResponse.startsWith("<?") && xmlResponse.endsWith(">");

        }
        return false;

    }

    /**
     * Check JSON Response
     * @param valueResponse
     * @return
     */
    public boolean isJSONResponse(String valueResponse) {

        String jsonResponse = "";

        if (StringUtils.isNotEmpty(valueResponse)) {

            jsonResponse = valueResponse.trim();

            return jsonResponse.startsWith("{") && jsonResponse.endsWith("}");

        }
        return false;

    }
    /* END BZ29280 */

    /*BEGIN BZ29379*/
    public void setResMgs(String argResMgs) {

        _customerGSInfo.setResponseMgs(argResMgs);
    }

    public String getResMgs() {

        return _customerGSInfo.getResponseMgs();
    }
    /*END BZ29379*/

    /* BEGIN BZ29387 */
    public void revertAttributes() {
        NonPhysicalItemType ACCOUNT_PAYMENT = NonPhysicalItemType.forName(CawConstants.ITEM_AR_PAYMENT, true);
        INonPhysicalItem[] items = ItemLocator.getLocator().getNonPhysicalItemsForType(ACCOUNT_PAYMENT);
        ISaleReturnLineItem lineItem = ItemLocator.getLocator()
                .getSaleLineItem(items[0], SaleItemType.SALE, false, false, HardwareType.KEYBOARD);
        lineItem.getItem().setDescription(lineItem.getItem().getName());
    }
    /* END BZ29387 */

    /*BEGIN BZ29360*/
    public boolean isApplyGS() {

        return _customerGSInfo.isApplyGS();
    }

    public void isTokenUsed(boolean isTokenUsed) {

        _customerGSInfo.setTokenUsed(isTokenUsed);
    }

    public boolean isTokenUsed() {

        return _customerGSInfo.isTokenUsed();
    }

    public String getGSExpiryDate(String format) {

        //BZ29505: Temporary remove Need to remove out of TRUNK BRANCH
        //String expiryDate = "";
        //DateTimeFormatter formatter = null;
        //LocalDate localTime = null;
        String monthValue = "";
        String yearValue = "";
        try {
            //formatter = DateTimeFormatter.ofPattern(format);
            //localTime = LocalDate.now().plusMonths(1);
            //expiryDate = localTime.format(formatter);
            monthValue = String.format("%02d", LocalDate.now().plusMonths(1).getMonthValue());
            yearValue = String.valueOf(LocalDate.now().getYear());
            yearValue = yearValue.substring(yearValue.length() - 2);
        } catch (Exception ex) {
            _logger.error("Error in getting Expiry Date " + ex.getMessage());
        }
        //return expiryDate;
        return monthValue + yearValue;
    }

    /*END BZ29360*/
    /* BEGIN BZ27973 */
    public CawCustomerGSInfo parseCustomerInfo(String encodeResponse) {

        String decodeResponse = "";

        CawCustomerGSInfo cus = new CawCustomerGSInfo();

        if (StringUtils.isNotEmpty(encodeResponse)) {

            try {
                byte[] decoded = Base64.getDecoder().decode(encodeResponse);

                decodeResponse = new String(decoded, StandardCharsets.UTF_8);
            } catch (IllegalArgumentException ex1) {
                _logger.error("Catch IllegalArgumentException encodeResponse in the method parseCustomerInfo:" + ex1);
            } catch (Exception ex2) {
                _logger.error("Catch Exception encodeResponse in the method parseCustomerInfo:" + ex2);
            }

        }
        if (isJSONResponse(decodeResponse)) {

            JSONObject parentJsonObect = CawJSONUtils.toJSONObject(decodeResponse);

            JSONArray jsonAccountSummaries = null;

            JSONObject jsonAccountSummarys = null;

            JSONObject jsonAccountSummary = null;

            JSONObject jsonAddress = null;

            JSONObject jsonVirtualCard = null;

            if (parentJsonObect.has(CawConstants.CAW_ACCOUNT_SUMMARIES)) {
                try {
                    jsonAccountSummaries = parentJsonObect.getJSONArray(CawConstants.CAW_ACCOUNT_SUMMARIES);
                } catch (JSONException ex) {
                    _logger.error("Could not parse the accountSummaries " + ex.getMessage());
                }
            }

            if (jsonAccountSummaries != null && jsonAccountSummaries.length() > 0) {
                try {
                    jsonAccountSummarys = jsonAccountSummaries.getJSONObject(0);
                } catch (JSONException ex) {
                    _logger.error("Could not get element at " + ex.getMessage());
                }
            }
            if (jsonAccountSummarys != null && jsonAccountSummarys.has(CawConstants.CAW_ACCOUNT_SUMMARY)) {
                try {
                    jsonAccountSummary = jsonAccountSummarys.getJSONObject(CawConstants.CAW_ACCOUNT_SUMMARY);
                } catch (JSONException ex) {
                    _logger.error("Could not parse the accountSummary " + ex.getMessage());
                }
            }

            if (jsonAccountSummary != null) {
                if (jsonAccountSummary.has(CawJSONConstant.JSON_ADDRESS)) {
                    try {
                        jsonAddress = jsonAccountSummary.getJSONObject(CawJSONConstant.JSON_ADDRESS);

                        if (jsonAddress != null && jsonAddress.has(CawConstants.CAW_ADDRESS1_LOWCASE)) {
                            cus.setAddress1(jsonAddress.getString(CawConstants.CAW_ADDRESS1_LOWCASE));
                        }
                        if (jsonAddress != null && jsonAddress.has(CawJSONConstant.JSON_CITY)) {
                            cus.setCity(jsonAddress.getString(CawJSONConstant.JSON_CITY));
                        }
                        if (jsonAddress != null && jsonAddress.has(CawConstants.CAW_STATE_LOWCASE)) {
                            cus.setState(CawConstants.CAW_STATE_LOWCASE);
                        }
                        if (jsonAddress != null && jsonAddress.has(CawConstants.CAW_STATE_LOWCASE)) {
                            cus.setZipCode(CawConstants.CAW_STATE_LOWCASE);
                        }
                    } catch (JSONException ex) {
                        _logger.error("Could not parse the address " + ex.getMessage());
                    }
                }
                /*BEGIN BZ29960*/
                if (jsonAccountSummary.has(CawConstants.VIRTUAL_CARD)) {
                    try {
                        jsonVirtualCard = jsonAccountSummary.getJSONObject(CawConstants.VIRTUAL_CARD);

                        if (StringUtils.isEmpty(_customerGSInfo.getExpiryDate()) && jsonVirtualCard != null
                                && jsonVirtualCard.has(CawConstants.EXPIRATION_DATE)) {
                            _customerGSInfo
                                    .setExpiryDay(applyFormat(jsonVirtualCard.getString(CawConstants.EXPIRATION_DATE)));
                        }
                    } catch (JSONException ex) {
                        _logger.error("Could not parse the virtual card " + ex.getMessage());
                    }
                }
                /*END BZ29960*/
                /*Move out of JSON_ADDRESS block since tabs below is not belong to JSON_ADDRESS*/
                /* BEGIN BZ29535 */
                if (jsonAccountSummary.has(CawConstants.CAW_MINIMUM_PAYMENT_DUE)) {
                    try {
                        _customerGSInfo.setMinAmountDue(CawUtilFunction.vBigDecimal(jsonAccountSummary
                                .getString(CawConstants.CAW_MINIMUM_PAYMENT_DUE), BigDecimal.ZERO));
                    } catch (JSONException ex) {
                        _logger.error("Could not parse the minimum payment due " + ex.getMessage());
                    }
                }
                if (jsonAccountSummary.has(CawConstants.CAW_PAYMENT_DUE_DATE)) {
                    try {
                        _customerGSInfo.setDueDate(jsonAccountSummary.getString(CawConstants.CAW_PAYMENT_DUE_DATE));
                    } catch (JSONException ex) {
                        _logger.error("Could not parse the payment due date " + ex.getMessage());
                    }
                }
                /* END BZ29535 */

                /* BEGIN BZ29505*/
                if (jsonAccountSummary.has(CawEBSConstant.CARD_TYPE)) {
                    try {
                        String cardType = jsonAccountSummary.getString(CawEBSConstant.CARD_TYPE);
                        if (CawConstants.VISA_SHORT.equals(cardType)) {
                            _customerGSInfo.setCardType(1);
                        } else if (CawConstants.PLCC_SHORT.equals(cardType)) {
                            _customerGSInfo.setCardType(2);
                        }
                    } catch (JSONException ex) {
                        _logger.error("Could not parse the card type " + ex.getMessage());
                    }
                }
                /* END BZ29505*/

                /* BEGIN BZ29535 */
                if (jsonAccountSummary.has(CawConstants.CAW_ACCOUNT_SUMMARY_OTB)) {
                    try {
                        String obtStr = jsonAccountSummary.getString(CawConstants.CAW_ACCOUNT_SUMMARY_OTB);
                        if (StringUtils.isNotEmpty(obtStr)) {
                            _customerGSInfo.setBlance(CawUtilFunction.vBigDecimal(obtStr, BigDecimal.ZERO));
                        }
                    } catch (JSONException ex) {
                        _logger.error("Could not get the attribute " + CawConstants.CAW_ACCOUNT_SUMMARY_OTB + ":"
                                + ex.getMessage());
                    }
                }
                /* END BZ29535 */
            }
        }
        return cus;
    }
    /* END BZ27973 */

    /* BEGIN BZ29505*/
    /**
     * 
     * @param accountShortToken
     */
    public void setAccountShortToken(String accountShortToken) {

        _customerGSInfo.setAccountShortToken(accountShortToken);
    }

    /**
     * 
     * @return
     */
    public String getAccountShortToken() {

        return _customerGSInfo.getAccountShortToken();
    }
    /* END BZ29505*/

    /*BEGIN BZ29960*/
    /**
     * 
     * @param inputExpDate
     * @return expDate string MMYY format
     */
    private String applyFormat(String inputExpDate) {
        String expDate = "";
        if (StringUtils.length(inputExpDate) > 2) {
            String month = inputExpDate.substring(0, 2);
            String last2DigitOfYear = inputExpDate.substring(inputExpDate.length() - 2, inputExpDate.length());
            expDate = month + last2DigitOfYear;
        }
        return expDate;
    }
    /*END BZ29960*/
    
    /*BEGIN BZ33319*/
    /**
     * @return the extendedCardType
     */
    public String getExtendedCardType() {

        return _customerGSInfo.getExtendedCardType();
    }

    /**
     * @param argExtendedCardType the extendedCardType to set
     */
    public void setExtendedCardType(String argExtendedCardType) {

        _customerGSInfo.setExtendedCardType(argExtendedCardType);
    }
    /*END BZ33319*/
    
    /* BEGIN BZ57844 */
    public boolean isEnableLoyalty() {
        ICodeValue codeValue = CodeLocator
                .getCodeValue(ConfigurationMgr.getOrganizationId(), CAW_ENABLE_GS_MEMBERSHIP_OFFER, CAW_ENABLE_GS_MEMBERSHIP_OFFER);
        if (codeValue == null || codeValue.getDescription() == null) {
            return false;
        }
        return CawConstants.TRUE_STRING.equalsIgnoreCase(codeValue.getDescription());
    }

    public boolean getRunEnableLoyalty(IPosTransaction trans) {

        List<CreditDebitTenderLineItemModel> tenderLineItemList = trans
                .getLineItems(CreditDebitTenderLineItemModel.class);
        /* BEGIN BZ58836, BZ58840 */
        TenderLineItemModel tenderLineItemModel = tenderLineItemList.stream()
                .filter(tenderLine -> (CawCardType.GSVISA
                        .equals(tenderLine.getTenderId()) && !tenderLine.getVoid())
                        || (CawCardType.GSPLCC.equals(tenderLine.getTenderId())) && !tenderLine.getVoid())
                .findFirst().orElse(null);
        /* END BZ58836, BZ58840 */
        if (tenderLineItemModel == null) {
            return true;
        }

        return false;
    }

    public void setVoidGSMembershipSKU(IPosTransaction trans, String gsMembershipSKUId) {

        List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
        for (ISaleReturnLineItem iSaleReturnLineItem : lineItems) {
            if (gsMembershipSKUId.equals(iSaleReturnLineItem.getItemId())) {
                iSaleReturnLineItem.setVoid(true);
            }
        }

    }
    /* END BZ57844 */
    
    /* BEGIN BZ58836, BZ58840 */
    public String getGSMembershipSKU(IPosTransaction trans) {
        ICodeValue renewalGSMembershipSKU = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_RENEWAL_GS_MEMBERSHIP_SKU, CawConstants.CAW_RENEWAL_GS_MEMBERSHIP_SKU);
        ICodeValue newGSMembershipSKU = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_NEW_GS_MEMBERSHIP_SKU, CawConstants.CAW_NEW_GS_MEMBERSHIP_SKU);
        
        String renewalGSMembershipSKUId= null;
        String newGSMembershipSKUId = null;
        
        if(renewalGSMembershipSKU != null) {
            renewalGSMembershipSKUId = renewalGSMembershipSKU.getDescription();
        }
        if(newGSMembershipSKU != null) {
            newGSMembershipSKUId = newGSMembershipSKU.getDescription();
        }
        
        List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
        for (ISaleReturnLineItem iSaleReturnLineItem : lineItems) {
            if (((renewalGSMembershipSKUId != null && renewalGSMembershipSKUId
                    .equals(iSaleReturnLineItem.getItemId()))
                    || (newGSMembershipSKUId != null && newGSMembershipSKUId
                            .equals(iSaleReturnLineItem.getItemId())))
                            && !iSaleReturnLineItem.getVoid()
                            && !iSaleReturnLineItem.getReturn()) {
                return iSaleReturnLineItem.getItemId();
            }
        }
        return null;
    }
    /* END BZ58836, BZ58840 */
}
