/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ25441              010318    [CW PROD] Order Service allows voided item discounts to be sent to Neuron
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ26735              290618    [PROD] Transaction with UOM as EACH submitted a quantity of 0 in the order service
 * BZ29156              210119    [Bundle the enhancement 2.1_29109] 0500 Property Names in the Order Service
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ40798              240221    Modification to member savings calculation
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import caw.orderservice.bean.CawOrderServiceUtils;
import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.utils.CawPropertiesConfig;
import twitter4j.JSONObject;

/**
 * This class is used to declare all variables 
 * using in CawOrderServiceApp.java
 */
public class CawTransactionModel {

    private JSONObject                customerTemplate     = CawOrderServiceUtils
            .getJsonContentByTemplate(CawWSTemplateConstant.CUSTOMER_TEMPLATE);
    
    private CawBrokeredOrderModel    brokeredOrderModel    = null; //BZ37463

    private CawTheOrderModel          orderModel           = null;

    private CawCustomerModel          custModel            = null;

    private CawNameModel              custName             = null;

    private CawAddressModel           cawAddressModel      = null;

    private List<CawAdjustmentsModel> adjustments          = null;

    private long                      updateStatusRes      = -1;

    private String                    rtlPriceModReason    = CawCommonConstant.EMPTY_STRING;

    private String                    requestOrderService  = CawCommonConstant.EMPTY_STRING;

    private String                    responseOrderService = CawCommonConstant.EMPTY_STRING;

    private String                    requestCustOffline   = CawCommonConstant.EMPTY_STRING;

    private String                    responseCustOffline  = CawCommonConstant.EMPTY_STRING;

    private boolean                   flagCheckQueue       = false;

    private String                    jsonCustomer         = CawCommonConstant.EMPTY_STRING;

    private String                    transTypCode         = CawCommonConstant.EMPTY_STRING;

    private String                    reasonCode           = CawCommonConstant.EMPTY_STRING;

    //Begin BZ23327
    private String                    storeID              = CawCommonConstant.EMPTY_STRING;

    private String                    regID                = CawCommonConstant.EMPTY_STRING;

    private String                    transSeq             = CawCommonConstant.EMPTY_STRING;

    private String                    bussinessDate        = CawCommonConstant.EMPTY_STRING;

    private String                    code                 = CawCommonConstant.EMPTY_STRING;

    private String                    name                 = CawCommonConstant.EMPTY_STRING;

    private String                    fileNumber           = CawCommonConstant.EMPTY_STRING;

    private String                    methodEMail          = CawCommonConstant.EMPTY_STRING;

    private int                       countTenders         = 0;

    private String                    tndCorRelationKey    = CawCommonConstant.EMPTY_STRING;

    private String                    tndType              = CawCommonConstant.EMPTY_STRING;

    private String                    tndCode              = CawCommonConstant.EMPTY_STRING;

    private String                    tndAuthNumber        = CawCommonConstant.EMPTY_STRING;

    private String                    tndExprDate          = CawCommonConstant.EMPTY_STRING;

    private BigDecimal                tndAmt               = BigDecimal
            .valueOf(0.00);

    private String                    emailAddress         = CawCommonConstant.EMPTY_STRING;

    private Timestamp                 bsnDate              = null;

    private BigDecimal                orderTotalWithTax    = BigDecimal
            .valueOf(0.00);

    private int                       countItem            = 0;

    private String                    itmCorRelationKey    = CawCommonConstant.EMPTY_STRING;

    private String                    itmCode              = CawCommonConstant.EMPTY_STRING;

    private BigDecimal                itmQuantity          = BigDecimal
            .valueOf(0.00);                                                                    //BZ26735

    private String                    itmUnitMeasure       = CawCommonConstant.EMPTY_STRING;

    private BigDecimal                itmListPrice         = BigDecimal
            .valueOf(0.00);

    private BigDecimal                itmRegBasePrice      = BigDecimal
            .valueOf(0.00);

    private BigDecimal                itmSellPrice         = BigDecimal
            .valueOf(0.00);

    private BigDecimal                itmGrossAmt          = BigDecimal
            .valueOf(0.00);

    private BigDecimal                itmExtendedAmt       = BigDecimal
            .valueOf(0.00);

    private BigDecimal                itmDiscountAmt       = null;

    private BigDecimal                itmBaseUnitPrice     = BigDecimal
            .valueOf(0.00);

    private String                    itmTaxCode           = CawCommonConstant.EMPTY_STRING;

    private BigDecimal                itmTaxAmt            = BigDecimal
            .valueOf(0.00);

    private boolean                   itmIsReturn          = false;                            //BZ25860

    private BigDecimal                itmLineAmtTotal      = BigDecimal
            .valueOf(0.00);

    private int                       responseCode         = 0;

    private String                    responseMessage      = CawCommonConstant.EMPTY_STRING;

    private String                    responseDesc         = CawCommonConstant.EMPTY_STRING;

    private SimpleDateFormat          dateFormat           = new SimpleDateFormat(
            CawCommonConstant.FORMAT_DATE, Locale.ENGLISH);

    private String                    updDate              = dateFormat
            .format(System.currentTimeMillis());

    private int                       customerType         = 0;

    private long                      accountNumber        = 0;

    private String                    partyId              = CawCommonConstant.EMPTY_STRING;

    private String                    prefix               = CawCommonConstant.EMPTY_STRING;

    private String                    firstName            = CawCommonConstant.EMPTY_STRING;

    private String                    lastName             = CawCommonConstant.EMPTY_STRING;

    private String                    middleName           = CawCommonConstant.EMPTY_STRING;

    private String                    suffixName           = CawCommonConstant.EMPTY_STRING;

    private String                    company              = CawCommonConstant.EMPTY_STRING;

    private String                    audit                = CawCommonConstant.EMPTY_STRING;

    private String                    addressType          = CawCommonConstant.EMPTY_STRING;

    private Boolean                   isDeliverable        = false;

    private String                    line1                = CawCommonConstant.EMPTY_STRING;

    private String                    line2                = CawCommonConstant.EMPTY_STRING;

    private String                    line3                = CawCommonConstant.EMPTY_STRING;

    private String                    line4                = CawCommonConstant.EMPTY_STRING;

    private String                    city                 = CawCommonConstant.EMPTY_STRING;

    private String                    stateProvince        = CawCommonConstant.EMPTY_STRING;

    private String                    postalCode           = CawCommonConstant.EMPTY_STRING;

    private String                    country              = CawCommonConstant.EMPTY_STRING;

    private String                    county               = CawCommonConstant.EMPTY_STRING;

    private int                       retry_count          = 0;

    private String                    beginDate            = CawCommonConstant.EMPTY_STRING;

    //End BZ24658
    private String                    itmTaxCodeExch       = CawCommonConstant.EMPTY_STRING;   //BZ24866

    //Begin BZ24869
    private String                    taxCodePaidInOut     = CawCommonConstant.EMPTY_STRING;

    private String                    rtransLineitmSeq     = CawCommonConstant.EMPTY_STRING;

    private String                    tndCardNbrMarked     = CawCommonConstant.EMPTY_STRING;

    private String                    tndTndrStatCode      = CawCommonConstant.EMPTY_STRING;

    private String                    tndCardHolder        = CawCommonConstant.EMPTY_STRING;

    private int                       countDisItem         = 0;

    private String                    serialNbr            = CawCommonConstant.EMPTY_STRING;

    private int                       promptForPriceFlag   = 0;

    private String                    itmPropStrVal        = CawCommonConstant.EMPTY_STRING;

    private String                    itmProDateVal        = CawCommonConstant.EMPTY_STRING;

    private String                    itmPropcode          = CawCommonConstant.EMPTY_STRING;

    private BigDecimal                itmPropDecimalVal    = BigDecimal
            .valueOf(0);

    private String                    pricePropCode        = CawCommonConstant.EMPTY_STRING;

    private String                    itmDisCode           = CawCommonConstant.EMPTY_STRING;

    private String                    adjCorRelationKey    = CawCommonConstant.EMPTY_STRING;

    private String                    adjType              = CawCommonConstant.DISCOUNT_STRING;

    private String                    adjSerialCoupon      = CawCommonConstant.EMPTY_STRING;

    private String                    itmDisDealId         = CawCommonConstant.EMPTY_STRING;

    //CONVERT DATE FORMAT VARIABLE
    private DateFormat                formatDtYMD          = new SimpleDateFormat(
            CawCommonConstant.YYYY_M_MDD);

    private String                    transID              = CawCommonConstant.EMPTY_STRING;

    private String                    propertyMapping      = CawCommonConstant.EMPTY_STRING; //BZ29156
    private boolean                   checkAcPayment       = false;//BZ29391
    
    /* BEGIN BZ40798*/
    private String                    goodSamSavings       = CawCommonConstant.GOOD_SAM_SAVINGS_STRING;
    
    private String                    couldSave            = CawCommonConstant.COULD_SAVE_STRING;
    /* End BZ40798*/
    
    /* BEGIN BZ63054 */
    private String channelTypeDescription = CawCommonConstant.EMPTY_STRING;
    private String physicalInfo = CawCommonConstant.EMPTY_STRING;
    private String salesChannelConfig = CawCommonConstant.EMPTY_STRING;
    private String receiptTypeDescription = CawCommonConstant.EMPTY_STRING;
    private String thirdPartyPayer = CawCommonConstant.EMPTY_STRING;
    /* END BZ63054 */
    /**
     * This method is used to initialize variables
     */
    public void iniTransactionModel() {

        this.taxCodePaidInOut = CawCommonConstant.EMPTY_STRING;
        this.transID = CawCommonConstant.EMPTY_STRING;
        this.flagCheckQueue = false;
        this.jsonCustomer = CawCommonConstant.EMPTY_STRING;
        this.customerTemplate = CawOrderServiceUtils
                .getJsonContentByTemplate(CawWSTemplateConstant.CUSTOMER_TEMPLATE);
        //Begin BZ24395
        this.transTypCode = CawCommonConstant.EMPTY_STRING;
        this.reasonCode = CawCommonConstant.EMPTY_STRING;
        //End BZ24395
        this.itmTaxAmt = BigDecimal.valueOf(0.00);//BZ24369
        //Begin BZ24270
        this.rtransLineitmSeq = CawCommonConstant.EMPTY_STRING;
        //End BZ24270
        this.storeID = CawCommonConstant.EMPTY_STRING;
        this.regID = CawCommonConstant.EMPTY_STRING;
        this.transSeq = CawCommonConstant.EMPTY_STRING;
        this.bussinessDate = CawCommonConstant.EMPTY_STRING;
        //Begin BZ24226
        this.beginDate = CawCommonConstant.EMPTY_STRING;
        //End BZ24226
        this.code = CawCommonConstant.EMPTY_STRING;
        this.name = CawCommonConstant.EMPTY_STRING;
        this.fileNumber = CawCommonConstant.EMPTY_STRING;
        this.methodEMail = CawCommonConstant.EMPTY_STRING;
        this.countTenders = 0;
        this.tndCorRelationKey = CawCommonConstant.EMPTY_STRING;
        this.tndType = CawCommonConstant.EMPTY_STRING;
        this.tndCode = CawCommonConstant.EMPTY_STRING;
        this.tndAuthNumber = CawCommonConstant.EMPTY_STRING;
        //Begin BZ24231
        this.tndCardNbrMarked = CawCommonConstant.EMPTY_STRING;
        //End BZ24231
        //Begin BZ24232
        this.tndCardHolder = CawCommonConstant.EMPTY_STRING;
        //End BZ24232
        this.tndExprDate = CawCommonConstant.EMPTY_STRING;
        this.tndAmt = BigDecimal.valueOf(0.00);
        this.emailAddress = null;
        this.bsnDate = null;
        this.orderTotalWithTax = BigDecimal.valueOf(0.00);
        this.countItem = 0;
        this.itmCorRelationKey = CawCommonConstant.EMPTY_STRING;
        this.itmCode = CawCommonConstant.EMPTY_STRING;
        this.itmQuantity = BigDecimal.valueOf(0.00);//BZ26735
        this.itmUnitMeasure = null;
        this.itmListPrice = BigDecimal.valueOf(0.00);
        this.itmSellPrice = BigDecimal.valueOf(0.00);
        this.itmGrossAmt = BigDecimal.valueOf(0.00);
        this.itmExtendedAmt = BigDecimal.valueOf(0.00);
        this.itmDiscountAmt = null;
        this.itmBaseUnitPrice = BigDecimal.valueOf(0.00);
        this.itmTaxCode = null;
        this.itmTaxAmt = BigDecimal.valueOf(0.00);
        this.itmLineAmtTotal = BigDecimal.valueOf(0.00);
        this.responseCode = 0;
        this.responseMessage = null;
        this.responseDesc = null;
        this.dateFormat = new SimpleDateFormat(CawCommonConstant.FORMAT_DATE,
                Locale.ENGLISH);
        this.updDate = this.dateFormat.format(System.currentTimeMillis());
        this.custModel = null;
        this.custName = null;
        this.cawAddressModel = null;
        this.customerType = 0;
        this.accountNumber = 0;
        this.partyId = null;
        this.prefix = null;
        this.firstName = null;
        this.lastName = null;
        this.middleName = null;
        this.suffixName = null;
        this.company = null;
        this.audit = null;
        this.addressType = null;
        this.isDeliverable = false;
        this.line1 = null;
        this.line2 = null;
        this.line3 = null;
        this.line4 = null;
        this.city = null;
        this.stateProvince = null;
        this.postalCode = null;
        this.country = null;
        this.county = null;
        this.itmIsReturn = false;//BZ25860
        
        /* BEGIN Z63054 */
        this.thirdPartyPayer = null;
        this.receiptTypeDescription = null;
        this.salesChannelConfig = null;
        this.physicalInfo = null;
        this.channelTypeDescription = null;
        /* END Z63054 */
    }

    /*
     * REVERT VARIABLE TO AVOID MISSING/DUPLICATING DATA
     * old name: initializeData()
     */
    public void resetLocalData() {

        this.countItem = 0;
        this.countTenders = 0;
        this.methodEMail = CawCommonConstant.EMPTY_STRING;
        this.emailAddress = CawCommonConstant.EMPTY_STRING;//BZ29391
        this.responseCode = 0;
        this.responseMessage = null;
        this.responseDesc = null;
      //hluong
        checkAcPayment = false;
    }

    public String getCorrelationKey() {

        String correlationKey = null;
        try {
            correlationKey = formatDtYMD.format(bsnDate) + ":" + storeID + ":"
                    + regID + ":" + transSeq;
        } catch (RuntimeException e) {
            //Nothing
        } catch (Exception e) {
            //Nothing
        }
        return correlationKey;
    }

    /**
     * Get data record to set to model object
     * @param rsTransations
     * @param model
     * @throws SQLException 
     */
    public void loadTransacitonInfo(ResultSet rsTransations)
            throws SQLException {

        String tmp = null;
        //Begin BZ24395
        setTransTypCode(rsTransations
                .getString(CawDBFieldConstant.TRANS_TYPCODE_FIELD));
        //End BZ24395
        tmp = rsTransations.getString(CawDBFieldConstant.RTL_LOC_ID_FIELD);
        setStoreID(String.format("%4s", tmp)
                .replace(' ', CawCommonConstant.ZERO_CHAR));

        tmp = rsTransations.getString(CawDBFieldConstant.WKSTN_ID_FIELD);
        setRegID(String.format("%2s", tmp)
                .replace(' ', CawCommonConstant.ZERO_CHAR));

        tmp = rsTransations.getString(CawDBFieldConstant.TRANS_SEQ_FIELD);
        setTransSeq(String.format("%4s", tmp)
                .replace(' ', CawCommonConstant.ZERO_CHAR));

        setTransID(getStoreID() + getRegID() + getTransSeq());

        //@TODO

        bussinessDate = rsTransations
                .getString(CawDBFieldConstant.BUSINESS_DATE_FIELD);
        //Begin BZ24226
        beginDate = rsTransations
                .getString(CawDBFieldConstant.BEGIN_DATETIME_FIELD);
        //End BZ24226
        bsnDate = rsTransations
                .getTimestamp(CawDBFieldConstant.BUSINESS_DATE_FIELD);
        orderTotalWithTax = rsTransations
                .getBigDecimal(CawDBFieldConstant.TOTAL_FIELD);
        code = rsTransations.getString(CawDBFieldConstant.EMPLOYEE_ID_FIELD);
        name = rsTransations.getString(CawDBFieldConstant.EMP_FULL_NAME_FIELD);
        fileNumber = rsTransations
                .getString(CawDBFieldConstant.EMP_PARTY_ID_FIELD);

        // BZ24886
        retry_count = rsTransations
                .getInt(CawDBFieldConstant.RETRY_COUNT_FIELD);

        setPartyId(rsTransations.getString(CawDBFieldConstant.PARTY_ID_FIELD));

        if (getPartyId() != null) {
            //BZ24886
            loadCustomerInfo(rsTransations);
        }
    }

    /**
     * Load info for Customer
     * @param rsTransations
     * @throws SQLException
     */
    private void loadCustomerInfo(ResultSet rsTransations) throws SQLException {

        // Begin BZ23327
        if (rsTransations
                .getString(CawDBFieldConstant.ORGANIZATION_NAME_FIELD) == null) {
            setCustomerType(1);
            setFirstName(rsTransations
                    .getString(CawDBFieldConstant.FIRST_NAME_FIELD));
            setLastName(rsTransations
                    .getString(CawDBFieldConstant.LAST_NAME_FIELD));
        } else {
            setCustomerType(2);
            setCompany(rsTransations
                    .getString(CawDBFieldConstant.ORGANIZATION_NAME_FIELD));
            setFirstName(null);
            setLastName(null);
        }
        // End BZ23327
        setAccountNumber(rsTransations
                .getLong(CawDBFieldConstant.ALTERNATE_ID_FIELD));
        prefix = rsTransations.getString(CawDBFieldConstant.SALUTATION_FIELD);
        middleName = rsTransations
                .getString(CawDBFieldConstant.MIDDLE_NAME_FIELD);
        suffixName = rsTransations.getString(CawDBFieldConstant.SUFFIX_FIELD);
        //Address Info
        addressType = rsTransations
                .getString(CawDBFieldConstant.ADDRESS_TYPE_FIELD);
        //Begin BZ23986
        if (addressType != null
                && addressType.equals(CawCommonConstant.HOME_FIELD)) {
            addressType = CawCommonConstant.RESIDENTIAL_STRING;
        } else if (addressType == null) {
            addressType = CawCommonConstant.NOT_SPECIFIED_STRING;
        }
        //End BZ23986
        line1 = rsTransations.getString(CawDBFieldConstant.ADDRESS1_FIELD);
        line2 = rsTransations.getString(CawDBFieldConstant.ADDRESS2_FIELD);
        line3 = rsTransations.getString(CawDBFieldConstant.ADDRESS3_FIELD);
        line4 = rsTransations.getString(CawDBFieldConstant.ADDRESS4_FIELD);
        city = rsTransations.getString(CawDBFieldConstant.CITY_FIELD);
        stateProvince = rsTransations.getString(CawDBFieldConstant.STATE_FIELD);
        postalCode = rsTransations
                .getString(CawDBFieldConstant.POSTAL_CODE_FIELD);
        if (rsTransations.getString(CawDBFieldConstant.COUNTRY_FIELD) != null) {
            country = rsTransations.getString(CawDBFieldConstant.COUNTRY_FIELD);
        } else {
            country = CawCommonConstant.COUNTRY_US;
        }
        county = rsTransations.getString(CawDBFieldConstant.COUNTY_FIELD);
        custModel = new CawCustomerModel();
        custModel.setCustomerType(customerType);
        custModel.setAccountNumber(accountNumber);
        custName = new CawNameModel();
        custName = setCustomerName(prefix, firstName, middleName, lastName, suffixName, company);

        //cawAddressModel = new CawAddressModel();
        cawAddressModel = getCustomerAddress(audit, addressType, isDeliverable, line1, line2, line3, line4, city, stateProvince, country, postalCode, county);
        custModel.setName(custName);
        custModel.setAddress(cawAddressModel);
        custModel.setPartyId(getPartyId());
    }

    /**
     * @return the customerTemplate
     */
    public JSONObject getCustomerTemplate() {

        return customerTemplate;
    }

    /**
     * @param customerTemplate the customerTemplate to set
     */
    public void setCustomerTemplate(JSONObject customerTemplate) {

        this.customerTemplate = customerTemplate;
    }

    /**
     * @return the updateStatusRes
     */
    public long getUpdateStatusRes() {

        return updateStatusRes;
    }

    /**
     * @param updateStatusRes the updateStatusRes to set
     */
    public void setUpdateStatusRes(long updateStatusRes) {

        this.updateStatusRes = updateStatusRes;
    }

    /**
     * @return the rtlPriceModReason
     */
    public String getRtlPriceModReason() {

        return rtlPriceModReason;
    }

    /**
     * @param rtlPriceModReason the rtlPriceModReason to set
     */
    public void setRtlPriceModReason(String rtlPriceModReason) {

        this.rtlPriceModReason = rtlPriceModReason;
    }

    /**
     * @return the requestOrderService
     */
    public String getRequestOrderService() {

        return requestOrderService;
    }

    /**
     * @param requestOrderService the requestOrderService to set
     */
    public void setRequestOrderService(String requestOrderService) {

        this.requestOrderService = requestOrderService;
    }

    /**
     * @return the responseOrderService
     */
    public String getResponseOrderService() {

        return responseOrderService;
    }

    /**
     * @param responseOrderService the responseOrderService to set
     */
    public void setResponseOrderService(String responseOrderService) {

        this.responseOrderService = responseOrderService;
    }

    /**
     * @return the requestCustOffline
     */
    public String getRequestCustOffline() {

        return requestCustOffline;
    }

    /**
     * @param requestCustOffline the requestCustOffline to set
     */
    public void setRequestCustOffline(String requestCustOffline) {

        this.requestCustOffline = requestCustOffline;
    }

    /**
     * @return the responseCustOffline
     */
    public String getResponseCustOffline() {

        return responseCustOffline;
    }

    /**
     * @param responseCustOffline the responseCustOffline to set
     */
    public void setResponseCustOffline(String responseCustOffline) {

        this.responseCustOffline = responseCustOffline;
    }

    /**
     * @return the flagCheckQueue
     */
    public boolean isFlagCheckQueue() {

        return flagCheckQueue;
    }

    /**
     * @param flagCheckQueue the flagCheckQueue to set
     */
    public void setFlagCheckQueue(boolean flagCheckQueue) {

        this.flagCheckQueue = flagCheckQueue;
    }

    /**
     * @return the jsonCustomer
     */
    public String getJsonCustomer() {

        return jsonCustomer;
    }

    /**
     * @param jsonCustomer the jsonCustomer to set
     */
    public void setJsonCustomer(String jsonCustomer) {

        this.jsonCustomer = jsonCustomer;
    }

    /**
     * @return the transTypCode
     */
    public String getTransTypCode() {

        return transTypCode;
    }

    /**
     * @param transTypCode the transTypCode to set
     */
    public void setTransTypCode(String transTypCode) {

        this.transTypCode = transTypCode;
    }

    /**
     * @return the reasonCode
     */
    public String getReasonCode() {

        return reasonCode;
    }

    /**
     * @param reasonCode the reasonCode to set
     */
    public void setReasonCode(String reasonCode) {

        this.reasonCode = reasonCode;
    }

    /**
     * @return the storeID
     */
    public String getStoreID() {

        return storeID;
    }

    /**
     * @param storeID the storeID to set
     */
    public void setStoreID(String storeID) {

        this.storeID = storeID;
    }

    /**
     * @return the regID
     */
    public String getRegID() {

        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {

        this.regID = regID;
    }

    /**
     * @return the transSeq
     */
    public String getTransSeq() {

        return transSeq;
    }

    /**
     * @param transSeq the transSeq to set
     */
    public void setTransSeq(String transSeq) {

        this.transSeq = transSeq;
    }

    /**
     * @return the bussinessDate
     */
    public String getBussinessDate() {

        return bussinessDate;
    }

    /**
     * @param bussinessDate the bussinessDate to set
     */
    public void setBussinessDate(String bussinessDate) {

        this.bussinessDate = bussinessDate;
    }

    /**
     * @return the code
     */
    public String getCode() {

        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the fileNumber
     */
    public String getFileNumber() {

        return fileNumber;
    }

    /**
     * @param fileNumber the fileNumber to set
     */
    public void setFileNumber(String fileNumber) {

        this.fileNumber = fileNumber;
    }

    /**
     * @return the methodEMail
     */
    public String getMethodEMail() {

        return methodEMail;
    }

    /**
     * @param methodEMail the methodEMail to set
     */
    public void setMethodEMail(String methodEMail) {

        this.methodEMail = methodEMail;
    }

    /**
     * @return the countTenders
     */
    public int getCountTenders() {

        return countTenders;
    }

    /**
     * @param countTenders the countTenders to set
     */
    public void setCountTenders(int countTenders) {

        this.countTenders = countTenders;
    }

    /**
     * @return the tndCorRelationKey
     */
    public String getTndCorRelationKey() {

        return tndCorRelationKey;
    }

    /**
     * @param tndCorRelationKey the tndCorRelationKey to set
     */
    public void setTndCorRelationKey(String tndCorRelationKey) {

        this.tndCorRelationKey = tndCorRelationKey;
    }

    /**
     * @return the tndType
     */
    public String getTndType() {

        return tndType;
    }

    /**
     * @param tndType the tndType to set
     */
    public void setTndType(String tndType) {

        this.tndType = tndType;
    }

    /**
     * @return the tndCode
     */
    public String getTndCode() {

        return tndCode;
    }

    /**
     * @param tndCode the tndCode to set
     */
    public void setTndCode(String tndCode) {

        this.tndCode = tndCode;
    }

    /**
     * @return the tndAuthNumber
     */
    public String getTndAuthNumber() {

        return tndAuthNumber;
    }

    /**
     * @param tndAuthNumber the tndAuthNumber to set
     */
    public void setTndAuthNumber(String tndAuthNumber) {

        this.tndAuthNumber = tndAuthNumber;
    }

    /**
     * @return the tndExprDate
     */
    public String getTndExprDate() {

        return tndExprDate;
    }

    /**
     * @param tndExprDate the tndExprDate to set
     */
    public void setTndExprDate(String tndExprDate) {

        this.tndExprDate = tndExprDate;
    }

    /**
     * @return the tndAmt
     */
    public BigDecimal getTndAmt() {

        return tndAmt;
    }

    /**
     * @param tndAmt the tndAmt to set
     */
    public void setTndAmt(BigDecimal tndAmt) {

        this.tndAmt = tndAmt;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {

        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    /**
     * @return the bsnDate
     */
    public Timestamp getBsnDate() {

        return bsnDate;
    }

    /**
     * @param bsnDate the bsnDate to set
     */
    public void setBsnDate(Timestamp bsnDate) {

        this.bsnDate = bsnDate;
    }

    /**
     * @return the orderTotalWithTax
     */
    public BigDecimal getOrderTotalWithTax() {

        return orderTotalWithTax;
    }

    /**
     * @param orderTotalWithTax the orderTotalWithTax to set
     */
    public void setOrderTotalWithTax(BigDecimal orderTotalWithTax) {

        this.orderTotalWithTax = orderTotalWithTax;
    }

    /**
     * @return the countItem
     */
    public int getCountItem() {

        return countItem;
    }

    /**
     * @param countItem the countItem to set
     */
    public void setCountItem(int countItem) {

        this.countItem = countItem;
    }

    /**
     * @return the itmCorRelationKey
     */
    public String getItmCorRelationKey() {

        return itmCorRelationKey;
    }

    /**
     * @param itmCorRelationKey the itmCorRelationKey to set
     */
    public void setItmCorRelationKey(String itmCorRelationKey) {

        this.itmCorRelationKey = itmCorRelationKey;
    }

    /**
     * @return the itmCode
     */
    public String getItmCode() {

        return itmCode;
    }

    /**
     * @param itmCode the itmCode to set
     */
    public void setItmCode(String itmCode) {

        this.itmCode = itmCode;
    }

    //Begin BZ26735
    /**
     * @return the itmQuantity
     */
    public BigDecimal getItmQuantity() {

        return itmQuantity;
    }

    /**
     * @param itmQuantity the itmQuantity to set
     */
    public void setItmQuantity(BigDecimal itmQuantity) {

        this.itmQuantity = itmQuantity;
    }

    //End BZ26735
    /**
     * @return the itmUnitMeasure
     */
    public String getItmUnitMeasure() {

        return itmUnitMeasure;
    }

    /**
     * @param itmUnitMeasure the itmUnitMeasure to set
     */
    public void setItmUnitMeasure(String itmUnitMeasure) {

        this.itmUnitMeasure = itmUnitMeasure;
    }

    /**
     * @return the itmListPrice
     */
    public BigDecimal getItmListPrice() {

        return itmListPrice;
    }

    /**
     * @param itmListPrice the itmListPrice to set
     */
    public void setItmListPrice(BigDecimal itmListPrice) {

        this.itmListPrice = itmListPrice;
    }

    /**
     * @return the itmRegBasePrice
     */
    public BigDecimal getItmRegBasePrice() {

        return itmRegBasePrice;
    }

    /**
     * @param itmRegBasePrice the itmRegBasePrice to set
     */
    public void setItmRegBasePrice(BigDecimal itmRegBasePrice) {

        this.itmRegBasePrice = itmRegBasePrice;
    }

    /**
     * @return the itmSellPrice
     */
    public BigDecimal getItmSellPrice() {

        return itmSellPrice;
    }

    /**
     * @param itmSellPrice the itmSellPrice to set
     */
    public void setItmSellPrice(BigDecimal itmSellPrice) {

        this.itmSellPrice = itmSellPrice;
    }

    /**
     * @return the itmGrossAmt
     */
    public BigDecimal getItmGrossAmt() {

        return itmGrossAmt;
    }

    /**
     * @param itmGrossAmt the itmGrossAmt to set
     */
    public void setItmGrossAmt(BigDecimal itmGrossAmt) {

        this.itmGrossAmt = itmGrossAmt;
    }

    /**
     * @return the itmExtendedAmt
     */
    public BigDecimal getItmExtendedAmt() {

        return itmExtendedAmt;
    }

    /**
     * @param itmExtendedAmt the itmExtendedAmt to set
     */
    public void setItmExtendedAmt(BigDecimal itmExtendedAmt) {

        this.itmExtendedAmt = itmExtendedAmt;
    }

    /**
     * @return the itmDiscountAmt
     */
    public BigDecimal getItmDiscountAmt() {

        return itmDiscountAmt;
    }

    /**
     * @param itmDiscountAmt the itmDiscountAmt to set
     */
    public void setItmDiscountAmt(BigDecimal itmDiscountAmt) {

        this.itmDiscountAmt = itmDiscountAmt;
    }

    /**
     * @return the itmBaseUnitPrice
     */
    public BigDecimal getItmBaseUnitPrice() {

        return itmBaseUnitPrice;
    }

    /**
     * @param itmBaseUnitPrice the itmBaseUnitPrice to set
     */
    public void setItmBaseUnitPrice(BigDecimal itmBaseUnitPrice) {

        this.itmBaseUnitPrice = itmBaseUnitPrice;
    }

    /**
     * @return the itmTaxCode
     */
    public String getItmTaxCode() {

        return itmTaxCode;
    }

    /**
     * @param itmTaxCode the itmTaxCode to set
     */
    public void setItmTaxCode(String itmTaxCode) {

        this.itmTaxCode = itmTaxCode;
    }

    /**
     * @return the itmTaxAmt
     */
    public BigDecimal getItmTaxAmt() {

        return itmTaxAmt;
    }

    /**
     * @param itmTaxAmt the itmTaxAmt to set
     */
    public void setItmTaxAmt(BigDecimal itmTaxAmt) {

        this.itmTaxAmt = itmTaxAmt;
    }

    /**
     * @return the itmLineAmtTotal
     */
    public BigDecimal getItmLineAmtTotal() {

        return itmLineAmtTotal;
    }

    /**
     * @param itmLineAmtTotal the itmLineAmtTotal to set
     */
    public void setItmLineAmtTotal(BigDecimal itmLineAmtTotal) {

        this.itmLineAmtTotal = itmLineAmtTotal;
    }

    /**
     * @return the responseCode
     */
    public int getResponseCode() {

        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(int responseCode) {

        this.responseCode = responseCode;
    }

    /**
     * @return the responseMessage
     */
    public String getResponseMessage() {

        return responseMessage;
    }

    /**
     * @param responseMessage the responseMessage to set
     */
    public void setResponseMessage(String responseMessage) {

        this.responseMessage = responseMessage;
    }

    /**
     * @return the responseDesc
     */
    public String getResponseDesc() {

        return responseDesc;
    }

    /**
     * @param responseDesc the responseDesc to set
     */
    public void setResponseDesc(String responseDesc) {

        this.responseDesc = responseDesc;
    }

    /**
     * @return the dateFormat
     */
    public SimpleDateFormat getDateFormat() {

        return dateFormat;
    }

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(SimpleDateFormat dateFormat) {

        this.dateFormat = dateFormat;
    }

    /**
     * @return the updDate
     */
    public String getUpdDate() {

        return updDate;
    }

    /**
     * @param updDate the updDate to set
     */
    public void setUpdDate(String updDate) {

        this.updDate = updDate;
    }

    /**
     * @return the custModel
     */
    public CawCustomerModel getCustModel() {

        return custModel;
    }

    /**
     * @param custModel the custModel to set
     */
    public void setCustModel(CawCustomerModel custModel) {

        this.custModel = custModel;
    }

    /**
     * @return the custName
     */
    public CawNameModel getCustName() {

        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(CawNameModel custName) {

        this.custName = custName;
    }

    /**
     * @return the customerType
     */
    public int getCustomerType() {

        return customerType;
    }

    /**
     * @param customerType the customerType to set
     */
    public void setCustomerType(int customerType) {

        this.customerType = customerType;
    }

    /**
     * @return the accountNumber
     */
    public long getAccountNumber() {

        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(long accountNumber) {

        this.accountNumber = accountNumber;
    }

    /**
     * @return the partyId
     */
    public String getPartyId() {

        return partyId;
    }

    /**
     * @param partyId the partyId to set
     */
    public void setPartyId(String partyId) {

        this.partyId = partyId;
    }

    /**
     * @return the cawAddressModel
     */
    public CawAddressModel getCawAddressModel() {

        return cawAddressModel;
    }

    /**
     * @param cawAddressModel the cawAddressModel to set
     */
    public void setCawAddressModel(CawAddressModel cawAddressModel) {

        this.cawAddressModel = cawAddressModel;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {

        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {

        this.prefix = prefix;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {

        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {

        this.middleName = middleName;
    }

    /**
     * @return the suffixName
     */
    public String getSuffixName() {

        return suffixName;
    }

    /**
     * @param suffixName the suffixName to set
     */
    public void setSuffixName(String suffixName) {

        this.suffixName = suffixName;
    }

    /**
     * @return the company
     */
    public String getCompany() {

        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {

        this.company = company;
    }

    /**
     * @return the audit
     */
    public String getAudit() {

        return audit;
    }

    /**
     * @param audit the audit to set
     */
    public void setAudit(String audit) {

        this.audit = audit;
    }

    /**
     * @return the addressType
     */
    public String getAddressType() {

        return addressType;
    }

    /**
     * @param addressType the addressType to set
     */
    public void setAddressType(String addressType) {

        this.addressType = addressType;
    }

    /**
     * @return the isDeliverable
     */
    public Boolean getIsDeliverable() {

        return isDeliverable;
    }

    /**
     * @param isDeliverable the isDeliverable to set
     */
    public void setIsDeliverable(Boolean isDeliverable) {

        this.isDeliverable = isDeliverable;
    }

    /**
     * @return the line1
     */
    public String getLine1() {

        return line1;
    }

    /**
     * @param line1 the line1 to set
     */
    public void setLine1(String line1) {

        this.line1 = line1;
    }

    /**
     * @return the line2
     */
    public String getLine2() {

        return line2;
    }

    /**
     * @param line2 the line2 to set
     */
    public void setLine2(String line2) {

        this.line2 = line2;
    }

    /**
     * @return the line3
     */
    public String getLine3() {

        return line3;
    }

    /**
     * @param line3 the line3 to set
     */
    public void setLine3(String line3) {

        this.line3 = line3;
    }

    /**
     * @return the line4
     */
    public String getLine4() {

        return line4;
    }

    /**
     * @param line4 the line4 to set
     */
    public void setLine4(String line4) {

        this.line4 = line4;
    }

    /**
     * @return the city
     */
    public String getCity() {

        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {

        this.city = city;
    }

    /**
     * @return the stateProvince
     */
    public String getStateProvince() {

        return stateProvince;
    }

    /**
     * @param stateProvince the stateProvince to set
     */
    public void setStateProvince(String stateProvince) {

        this.stateProvince = stateProvince;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {

        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {

        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {

        this.country = country;
    }

    /**
     * @return the county
     */
    public String getCounty() {

        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {

        this.county = county;
    }

    /**
     * @return the retry_count
     */
    public int getRetry_count() {

        return retry_count;
    }

    /**
     * @param retry_count the retry_count to set
     */
    public void setRetry_count(int retry_count) {

        this.retry_count = retry_count;
    }

    /**
     * @return the beginDate
     */
    public String getBeginDate() {

        return beginDate;
    }

    /**
     * @param beginDate the beginDate to set
     */
    public void setBeginDate(String beginDate) {

        this.beginDate = beginDate;
    }

    /**
     * @return the itmTaxCodeExch
     */
    public String getItmTaxCodeExch() {

        return itmTaxCodeExch;
    }

    /**
     * @param itmTaxCodeExch the itmTaxCodeExch to set
     */
    public void setItmTaxCodeExch(String itmTaxCodeExch) {

        this.itmTaxCodeExch = itmTaxCodeExch;
    }

    /**
     * @return the taxCodePaidInOut
     */
    public String getTaxCodePaidInOut() {

        return taxCodePaidInOut;
    }

    /**
     * @param taxCodePaidInOut the taxCodePaidInOut to set
     */
    public void setTaxCodePaidInOut(String taxCodePaidInOut) {

        this.taxCodePaidInOut = taxCodePaidInOut;
    }

    /**
     * @return the rtransLineitmSeq
     */
    public String getRtransLineitmSeq() {

        return rtransLineitmSeq;
    }

    /**
     * @param rtransLineitmSeq the rtransLineitmSeq to set
     */
    public void setRtransLineitmSeq(String rtransLineitmSeq) {

        this.rtransLineitmSeq = rtransLineitmSeq;
    }

    /**
     * @return the tndCardNbrMarked
     */
    public String getTndCardNbrMarked() {

        return tndCardNbrMarked;
    }

    /**
     * @param tndCardNbrMarked the tndCardNbrMarked to set
     */
    public void setTndCardNbrMarked(String tndCardNbrMarked) {

        this.tndCardNbrMarked = tndCardNbrMarked;
    }

    /**
     * @return the tndTndrStatCode
     */
    public String getTndTndrStatCode() {

        return tndTndrStatCode;
    }

    /**
     * @param tndTndrStatCode the tndTndrStatCode to set
     */
    public void setTndTndrStatCode(String tndTndrStatCode) {

        this.tndTndrStatCode = tndTndrStatCode;
    }

    /**
     * @return the tndCardHolder
     */
    public String getTndCardHolder() {

        return tndCardHolder;
    }

    /**
     * @param tndCardHolder the tndCardHolder to set
     */
    public void setTndCardHolder(String tndCardHolder) {

        this.tndCardHolder = tndCardHolder;
    }

    /**
     * @return the countDisItem
     */
    public int getCountDisItem() {

        return countDisItem;
    }

    /**
     * @param countDisItem the countDisItem to set
     */
    public void setCountDisItem(int countDisItem) {

        this.countDisItem = countDisItem;
    }

    /**
     * @return the serialNbr
     */
    public String getSerialNbr() {

        return serialNbr;
    }

    /**
     * @param serialNbr the serialNbr to set
     */
    public void setSerialNbr(String serialNbr) {

        this.serialNbr = serialNbr;
    }

    /**
     * @return the promptForPriceFlag
     */
    public int getPromptForPriceFlag() {

        return promptForPriceFlag;
    }

    /**
     * @param promptForPriceFlag the promptForPriceFlag to set
     */
    public void setPromptForPriceFlag(int promptForPriceFlag) {

        this.promptForPriceFlag = promptForPriceFlag;
    }

    /**
     * @return the itmPropStrVal
     */
    public String getItmPropStrVal() {

        return itmPropStrVal;
    }

    /**
     * @param itmPropStrVal the itmPropStrVal to set
     */
    public void setItmPropStrVal(String itmPropStrVal) {

        this.itmPropStrVal = itmPropStrVal;
    }

    /**
     * @return the itmProDateVal
     */
    public String getItmProDateVal() {

        return itmProDateVal;
    }

    /**
     * @param itmProDateVal the itmProDateVal to set
     */
    public void setItmProDateVal(String itmProDateVal) {

        this.itmProDateVal = itmProDateVal;
    }

    /**
     * @return the itmPropcode
     */
    public String getItmPropcode() {

        return itmPropcode;
    }

    /**
     * @param itmPropcode the itmPropcode to set
     */
    public void setItmPropcode(String itmPropcode) {

        this.itmPropcode = itmPropcode;
    }

    /**
     * @return the itmPropDecimalVal
     */
    public BigDecimal getItmPropDecimalVal() {

        return itmPropDecimalVal;
    }

    /**
     * @param itmPropDecimalVal the itmPropDecimalVal to set
     */
    public void setItmPropDecimalVal(BigDecimal itmPropDecimalVal) {

        this.itmPropDecimalVal = itmPropDecimalVal;
    }

    /**
     * @return the pricePropCode
     */
    public String getPricePropCode() {

        return pricePropCode;
    }

    /**
     * @param pricePropCode the pricePropCode to set
     */
    public void setPricePropCode(String pricePropCode) {

        this.pricePropCode = pricePropCode;
    }

    /**
     * @return the itmDisCode
     */
    public String getItmDisCode() {

        return itmDisCode;
    }

    /**
     * @param itmDisCode the itmDisCode to set
     */
    public void setItmDisCode(String itmDisCode) {

        this.itmDisCode = itmDisCode;
    }

    /**
     * @return the adjCorRelationKey
     */
    public String getAdjCorRelationKey() {

        return adjCorRelationKey;
    }

    /**
     * @param adjCorRelationKey the adjCorRelationKey to set
     */
    public void setAdjCorRelationKey(String adjCorRelationKey) {

        this.adjCorRelationKey = adjCorRelationKey;
    }

    /**
     * @return the adjType
     */
    public String getAdjType() {

        return adjType;
    }

    /**
     * @param adjType the adjType to set
     */
    public void setAdjType(String adjType) {

        this.adjType = adjType;
    }

    /**
     * @return the adjSerialCoupon
     */
    public String getAdjSerialCoupon() {

        return adjSerialCoupon;
    }

    /**
     * @param adjSerialCoupon the adjSerialCoupon to set
     */
    public void setAdjSerialCoupon(String adjSerialCoupon) {

        this.adjSerialCoupon = adjSerialCoupon;
    }

    /**
     * @return the adjustment
     */
    public List<CawAdjustmentsModel> getAdjustments() {

        return adjustments;
    }

    /**
     * @param adjustment the adjustment to set
     */
    public void setAdjustments(List<CawAdjustmentsModel> adjustments) {

        this.adjustments = adjustments;
    }

    /**
     * @return the itmDisDealId
     */
    public String getItmDisDealId() {

        return itmDisDealId;
    }

    /**
     * @param itmDisDealId the itmDisDealId to set
     */
    public void setItmDisDealId(String itmDisDealId) {

        this.itmDisDealId = itmDisDealId;
    }

    /**
     * @return the orderModel
     */
    public CawTheOrderModel getOrderModel() {

        return orderModel;
    }

    /**
     * @param orderModel the orderModel to set
     */
    public void setOrderModel(CawTheOrderModel orderModel) {

        this.orderModel = orderModel;
    }

    /**
     * @return the formatDtYMD
     */
    public DateFormat getFormatDtYMD() {

        return formatDtYMD;
    }

    /**
     * @param formatDtYMD the formatDtYMD to set
     */
    public void setFormatDtYMD(DateFormat formatDtYMD) {

        this.formatDtYMD = formatDtYMD;
    }

    /**
     * @return the transID
     */
    public String getTransID() {

        return transID;
    }

    /**
     * @param transID the transID to set
     */
    public void setTransID(String transID) {

        this.transID = transID;
    }

    public static CawNameModel setCustomerName(String prefix, String first,
            String middle, String last, String suffix, String company) {

        CawNameModel cawNameModel = new CawNameModel();
        cawNameModel.setPrefix(prefix);
        cawNameModel.setFirst(first);
        cawNameModel.setMiddle(middle);
        cawNameModel.setLast(last);
        cawNameModel.setSuffix(suffix);
        cawNameModel.setCompany(company);
        return cawNameModel;
    }

    /**
     * Create object of Customer address
     * @param audit
     * @param addressType
     * @param isDeliverable
     * @param line1
     * @param line2
     * @param line3
     * @param line4
     * @param city
     * @param stateProvince
     * @param country
     * @param postalCode
     * @param county
     * @return
     */
    private static CawAddressModel getCustomerAddress(String audit,
            String addressType, Boolean isDeliverable, String line1,
            String line2, String line3, String line4, String city,
            String stateProvince, String country, String postalCode,
            String county) {

        CawAddressModel cawAddressModel = new CawAddressModel();
        ;
        cawAddressModel.setAudit(audit);
        cawAddressModel.setAddressType(addressType);
        cawAddressModel.setIsDeliverable(isDeliverable);
        cawAddressModel.setLine1(line1);
        cawAddressModel.setLine2(line2);
        cawAddressModel.setLine3(line3);
        cawAddressModel.setLine4(line4);
        cawAddressModel.setCity(city);
        cawAddressModel.setStateProvince(stateProvince);
        //Begin BZ23565

        //Begin BZ23986
        if (country != null && !country.trim().isEmpty()
                && CawPropertiesConfig.get(country) != null) {
            country = CawPropertiesConfig.get(country);
        } else {
            country = CawCommonConstant.COUNTRY_USA;
        }
        cawAddressModel.setCountry(country);
        //End BZ23986
        //End BZ23565
        cawAddressModel.setPostalCode(postalCode);
        cawAddressModel.setCounty(county);
        return cawAddressModel;
    }
    //Begin BZ25860

    /**
     * @return the itmIsReturn
     */
    public boolean isItmIsReturn() {

        return itmIsReturn;
    }

    /**
     * @param itmIsReturn the itmIsReturn to set
     */
    public void setItmIsReturn(boolean itmIsReturn) {

        this.itmIsReturn = itmIsReturn;
    }
    //End BZ25860

    //BEGIN BZ29156
    /***
     * set propertyMapping by execute the query QUERY_ITEM_PRO_RTL
     */
    public String getPropertyMapping() {

        return propertyMapping;
    }

    /***
     * get propertyMapping by execute the query QUERY_ITEM_PRO_RTL
     */
    public void setPropertyMapping(String _propertyMapping) {

        this.propertyMapping = _propertyMapping;
    }
    //END BZ29156

    //Begin BZ29391
    /**
     * @return the checkAcPayment
     */
    public boolean isCheckAcPayment() {
    
        return checkAcPayment;
    }

    
    /**
     * @param checkAcPayment the checkAcPayment to set
     */
    public void setCheckAcPayment(boolean checkAcPayment) {
    
        this.checkAcPayment = checkAcPayment;
    }
    //End BZ29391

    
    /* BEGIN BZ37463 */
    /**
     * @return the brokeredOrderModel
     */
    public CawBrokeredOrderModel getBrokeredOrderModel() {
    
        return brokeredOrderModel;
    }

    
    /**
     * @param brokeredOrderModel the brokeredOrderModel to set
     */
    public void setBrokeredOrderModel(CawBrokeredOrderModel brokeredOrderModel) {
    
        this.brokeredOrderModel = brokeredOrderModel;
    }
    /* END BZ37463 */

    
    /**BZ40798
     * @return the goodSamSavings
     */
    public String getGoodSamSavings() {
    
        return goodSamSavings;
    }

    
    /**BZ40798
     * @param goodSamSavings the goodSamSavings to set
     */
    public void setGoodSamSavings(String goodSamSavings) {
    
        this.goodSamSavings = goodSamSavings;
    }

    
    /**BZ40798
     * @return the couldSave
     */
    public String getCouldSave() {
    
        return couldSave;
    }

    
    /**BZ40798
     * @param couldSave the couldSave to set
     */
    public void setCouldSave(String couldSave) {
    
        this.couldSave = couldSave;
    }

    /*BEGIN BZ63054*/
    /**
     * @return the channelTypeDescription
     */
    public String getChannelTypeDescription() {
    
        return channelTypeDescription;
    }

    
    /**
     * @param channelTypeDescription the channelTypeDescription to set
     */
    public void setChannelTypeDescription(String channelTypeDescription) {
    
        this.channelTypeDescription = channelTypeDescription;
    }

    
    /**
     * @return the physicalInfo
     */
    public String getPhysicalInfo() {
    
        return physicalInfo;
    }

    
    /**
     * @param physicalInfo the physicalInfo to set
     */
    public void setPhysicalInfo(String physicalInfo) {
    
        this.physicalInfo = physicalInfo;
    }

    
    /**
     * @return the salesChannelConfig
     */
    public String getSalesChannelConfig() {
    
        return salesChannelConfig;
    }

    
    /**
     * @param salesChannelConfig the salesChannelConfig to set
     */
    public void setSalesChannelConfig(String salesChannelConfig) {
    
        this.salesChannelConfig = salesChannelConfig;
    }

    
    /**
     * @return the receiptTypeDescription
     */
    public String getReceiptTypeDescription() {
    
        return receiptTypeDescription;
    }

    
    /**
     * @param receiptTypeDescription the receiptTypeDescription to set
     */
    public void setReceiptTypeDescription(String receiptTypeDescription) {
    
        this.receiptTypeDescription = receiptTypeDescription;
    }

    
    /**
     * @return the thirdPartyPayer
     */
    public String getThirdPartyPayer() {
    
        return thirdPartyPayer;
    }

    
    /**
     * @param thirdPartyPayer the thirdPartyPayer to set
     */
    public void setThirdPartyPayer(String thirdPartyPayer) {
    
        this.thirdPartyPayer = thirdPartyPayer;
    }
    /*END BZ63054*/
    
    
}
