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
 * BZ25740              032118    [Order Service] Adjustment of item line displayed incorrect in Order service log when performing return web order
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ25640              220518    New Requirement - Used Firearm System Process Redesign
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ26879              300718    [New Requirement] Add reference to Original item on Order Service
 * BZ27117              080818    [OS] Should be handled account credit tender like Item deposit for WO complete transaction.
 * BZ27289              210818    [1.6.11] WO Discounted item price doesnt reflect in xstore
 * BZ27584              190918    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29123              210119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 * BZ29156              210119    [Port 29109 to release 3.0] 0500 Property Names in the Order Service
 * BZ29205              250119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29661              060319    [Port 29616 to 4.0] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ29324              060319    [3.1] Returns for Item 500 that was in a WO is causing a 400 error
 * BZ30261              190419    [Prod] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ31525              250619    [Port BZ29685 to 5.0]  Associate and Map Coupon Codes to Oracle Order
 * BZ29668              200619    [Internal] OS Logging the transaction output to database table journal
 * BZ31664              090718    [Prod]BZ31596 - Sale transaction is pending in OS queue
 * BZ31944              170719    [Port BZ31258 to 5.0]The OS did not pull the discount for prompt price item
 * BZ31793              250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 * BZ33390				111019    [Prod] Order Service Issue - Error converting value {null} to type 'Decimal
 * BZ32517              291019    [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory
 * BZ33984              261119    [Port 33954 to 5.2]Bounce Back Coupon reporting not showing all data
 * BZ35016              060320    [New Requirement] WO complete should not override WO deposit data in CAT_CUST_ITEM_ACCT_DETAIL
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup store address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores
 * BZ38841              221020    [Internal] - The request of Order is sent Incorrectly when executing Mixed Sale transaction and Order transaction
 * BZ40561              140121    OB Reject Reasons and Order Status
 * BZ40776              280121    [UAT] Duplicate and Missed Order service Messages on order status change in Xstore
 * BZ40798              240221    Modification to member savings calculation
 * BZ45903              250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48806              010322    [PROD] Order Service (Internal Server Error)
 * BZ48749              052422    [PROD] Issues in xStore vs DW sales report
 * BZ51771              191022    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service. 
 * BZ52837              011122    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes
 * BZ52706              121222    Sales missing tender data when processing in OS
 * BZ55978              290323    Loyalty Issue: Java Null Pointer
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.orderservice.constant;

/**
 * Define SQL 
 */
public class CawSQLConstant {

    public static final String QUERY_COUNT_TRANSACTIONS                  = "SELECT COUNT(*) as COUNT FROM CAW_TRN_ORD_SER_VIEW";

    public static final String QUERY_TRANSACTIONS                        = "SELECT TRANS_SEQ, RTL_LOC_ID, WKSTN_ID, BUSINESS_DATE, BEGIN_DATETIME, TOTAL,  "
            + " OPERATOR_PARTY_ID, TRANS_TYPCODE, EMPLOYEE_ID, EMP_FULL_NAME,  "
            + " EMP_PARTY_ID, STORE_NAME, LOC_ADDRESS1, LOC_ADDRESS2, LOC_CITY, LOC_STATE, LOC_POSTAL_CODE,  "
            + " LOC_COUNTRY, PARTY_ID, ALTERNATE_ID, ORGANIZATION_TYPCODE, SALUTATION, FIRST_NAME, MIDDLE_NAME, LAST_NAME,  "
            + " SUFFIX, ORGANIZATION_NAME, ADDRESS_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, ADDRESS4, CITY, STATE, POSTAL_CODE, COUNTRY, COUNTY, RETRY_COUNT, CREATE_DATE "
            + " FROM CAW_TRN_ORD_SER_VIEW WHERE ROWNUM<=? ORDER BY CREATE_DATE ASC";

    public static final String QUERY_EMAIL_RECEIPT                       = "SELECT STRING_VALUE, PROPERTY_CODE FROM TRN_TRANS_P WHERE TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";

    //Begin BZ27584
    //Begin BZ25860
    public static final String QUERY_ITEMS_INFO                          = "SELECT TSL.ITEM_ID, COALESCE(HRE.LOGIN_ID, EMP.EMPLOYEE_ID) AS LOGIN_ID, CONCAT(CONCAT(EMP.FIRST_NAME, ' ')"
            + " , EMP.LAST_NAME) AS FULL_NAME, EMP.PARTY_ID EMP_PARTY_ID, TSL.QUANTITY, IIO.UNIT_OF_MEASURE_CODE"
            + " , IIO.PROMPT_FOR_PRICE_FLAG, TSL.UNIT_PRICE, TSL.EXTENDED_AMT, TSL.BASE_UNIT_PRICE, TSL.REGULAR_BASE_PRICE"
            + " , TSL.BASE_EXTENDED_PRICE, TSL.GROSS_AMT, ITM.LIST_PRICE, TSL.TAX_GROUP_ID, TSL.PRICE_PROPERTY_CODE"
            + " , TSL.RTRANS_LINEITM_SEQ, TSTL.TAX_AMT, TSL.SERIAL_NBR, TSL.RETURN_REASCODE, TSL.RETURN_FLAG, TSL.ORIGINAL_BUSINESS_DATE"
            + " , TSL.ORIGINAL_RTL_LOC_ID, TSL.ORIGINAL_WKSTN_ID, TSL.ORIGINAL_TRANS_SEQ, TSL.ORIGINAL_RTRANS_LINEITM_SEQ"
            + " FROM TRL_RTRANS_LINEITM RTL LEFT JOIN TRL_SALE_LINEITM TSL ON RTL.ORGANIZATION_ID = TSL.ORGANIZATION_ID"
            + "  AND RTL.RTL_LOC_ID = TSL.RTL_LOC_ID"
            + "  AND RTL.BUSINESS_DATE = TSL.BUSINESS_DATE"
            + "  AND RTL.WKSTN_ID = TSL.WKSTN_ID"
            + "  AND RTL.TRANS_SEQ = TSL.TRANS_SEQ"
            + "  AND RTL.RTRANS_LINEITM_SEQ = TSL.RTRANS_LINEITM_SEQ"
            + " LEFT JOIN (SELECT ORGANIZATION_ID, RTL_LOC_ID, BUSINESS_DATE, WKSTN_ID, TRANS_SEQ, RTRANS_LINEITM_SEQ, SUM(TAX_AMT) AS TAX_AMT "
            + " FROM TRL_SALE_TAX_LINEITM "
            + " GROUP BY ORGANIZATION_ID, RTL_LOC_ID, BUSINESS_DATE, WKSTN_ID, TRANS_SEQ, RTRANS_LINEITM_SEQ) TSTL ON RTL.ORGANIZATION_ID = TSTL.ORGANIZATION_ID"
            + "  AND RTL.RTL_LOC_ID = TSTL.RTL_LOC_ID"
            + "  AND RTL.BUSINESS_DATE = TSTL.BUSINESS_DATE"
            + "  AND RTL.WKSTN_ID = TSTL.WKSTN_ID"
            + "  AND RTL.TRANS_SEQ = TSTL.TRANS_SEQ"
            + "  AND RTL.RTRANS_LINEITM_SEQ = TSTL.RTRANS_LINEITM_SEQ"
            + " LEFT JOIN TRL_COMMISSION_MOD TCM ON"
            + "  RTL.ORGANIZATION_ID = TCM.ORGANIZATION_ID"
            + "  AND RTL.RTL_LOC_ID = TCM.RTL_LOC_ID"
            + "  AND RTL.BUSINESS_DATE = TCM.BUSINESS_DATE"
            + "  AND RTL.WKSTN_ID = TCM.WKSTN_ID"
            + "  AND RTL.TRANS_SEQ = TCM.TRANS_SEQ"
            + "  AND RTL.RTRANS_LINEITM_SEQ = TCM.RTRANS_LINEITM_SEQ"
            + " LEFT JOIN ITM_ITEM ITM ON TSL.ITEM_ID = ITM.ITEM_ID"
            + " LEFT JOIN ITM_ITEM_OPTIONS IIO ON ITM.ITEM_ID = IIO.ITEM_ID"
            + "  AND ITM.ORG_CODE = IIO.LEVEL_CODE"
            + "  AND ITM.ORG_VALUE = IIO.LEVEL_VALUE"
            + " LEFT JOIN LOC_RTL_LOC LOC ON RTL.RTL_LOC_ID = LOC.RTL_LOC_ID"
            + " LEFT JOIN (CRM_PARTY EMP JOIN HRS_EMPLOYEE HRE ON EMP.PARTY_ID = HRE.PARTY_ID)"
            + " ON TCM.EMPLOYEE_PARTY_ID = EMP.PARTY_ID AND EMP.PARTY_TYPCODE = 'EMPLOYEE'"
            + " WHERE TSL.TRANS_SEQ=? AND TSL.RTL_LOC_ID=? AND TSL.WKSTN_ID=? AND TSL.BUSINESS_DATE=? AND RTL.VOID_FLAG = 0 "
            + " ORDER BY RTRANS_LINEITM_SEQ ASC ";

    //End BZ25860
    //End BZ27584

    //Begin BZ29123 
    /*public static final String QUERY_TENDERS_INFO                        = "SELECT TTL.TNDR_ID,TTL.TNDR_STATCODE, TTL.AMT, CDT.AUTH_NBR, CDT.ACCT_NBR_HASH,CDT.TRANSACTION_REFERENCE_DATA, CDT.ACCT_NBR,CDT.CUSTOMER_NAME, CDT.EXPR_DATE FROM TRL_RTRANS_LINEITM RTL JOIN TTR_TNDR_LINEITM TTL   "
            + " ON RTL.ORGANIZATION_ID = TTL.ORGANIZATION_ID "
            + "  AND RTL.RTL_LOC_ID = TTL.RTL_LOC_ID "
            + "  AND RTL.BUSINESS_DATE = TTL.BUSINESS_DATE "
            + "  AND RTL.WKSTN_ID = TTL.WKSTN_ID "
            + "  AND RTL.TRANS_SEQ = TTL.TRANS_SEQ "
            + "  AND RTL.RTRANS_LINEITM_SEQ = TTL.RTRANS_LINEITM_SEQ "
            + " LEFT JOIN TTR_CREDIT_DEBIT_TNDR_LINEITM CDT "
            + " ON TTL.ORGANIZATION_ID = CDT.ORGANIZATION_ID "
            + "  AND TTL.RTL_LOC_ID = CDT.RTL_LOC_ID "
            + "  AND TTL.BUSINESS_DATE = CDT.BUSINESS_DATE "
            + "  AND TTL.WKSTN_ID = CDT.WKSTN_ID "
            + "  AND TTL.TRANS_SEQ = CDT.TRANS_SEQ "
            + "  AND TTL.RTRANS_LINEITM_SEQ = CDT.RTRANS_LINEITM_SEQ "
            + " WHERE TTL.TRANS_SEQ=? AND TTL.RTL_LOC_ID=? AND TTL.WKSTN_ID=? AND TTL.BUSINESS_DATE=? AND RTL.VOID_FLAG = 0";*/
    /*BEGIN BZ32517, 52706*/
    public static final String QUERY_TENDERS_INFO                        = "SELECT  ttl.serial_nbr, tvtl.orig_stan, TTL.TNDR_ID,TTL.TNDR_STATCODE, TTL.AMT, CDT.AUTH_NBR, CDT.ACCT_NBR_HASH,CDT.TRANSACTION_REFERENCE_DATA, CDT.ACCT_NBR,CDT.CUSTOMER_NAME, CDT.EXPR_DATE,ARTL.PO_NUMBER,ARTL.ACCT_USER_NAME FROM TRL_RTRANS_LINEITM RTL JOIN TTR_TNDR_LINEITM TTL   "
            + " ON RTL.ORGANIZATION_ID = TTL.ORGANIZATION_ID "
            + "  AND RTL.RTL_LOC_ID = TTL.RTL_LOC_ID "
            + "  AND RTL.BUSINESS_DATE = TTL.BUSINESS_DATE "
            + "  AND RTL.WKSTN_ID = TTL.WKSTN_ID "
            + "  AND RTL.TRANS_SEQ = TTL.TRANS_SEQ "
            + "  AND RTL.RTRANS_LINEITM_SEQ = TTL.RTRANS_LINEITM_SEQ "
            + " LEFT JOIN TTR_AR_TNDR_LINEITM ARTL"
            + " ON ARTL.ORGANIZATION_ID = TTL.ORGANIZATION_ID "
            + "  AND ARTL.RTL_LOC_ID = TTL.RTL_LOC_ID "
            + "  AND ARTL.BUSINESS_DATE = TTL.BUSINESS_DATE "
            + "  AND ARTL.WKSTN_ID = TTL.WKSTN_ID "
            + "  AND ARTL.TRANS_SEQ = TTL.TRANS_SEQ "
            + "  AND ARTL.RTRANS_LINEITM_SEQ = TTL.RTRANS_LINEITM_SEQ"
            + " LEFT JOIN TTR_CREDIT_DEBIT_TNDR_LINEITM CDT "
            + " ON TTL.ORGANIZATION_ID = CDT.ORGANIZATION_ID "
            + "  AND TTL.RTL_LOC_ID = CDT.RTL_LOC_ID "
            + "  AND TTL.BUSINESS_DATE = CDT.BUSINESS_DATE "
            + "  AND TTL.WKSTN_ID = CDT.WKSTN_ID "
            + "  AND TTL.TRANS_SEQ = CDT.TRANS_SEQ "
            + "  AND TTL.RTRANS_LINEITM_SEQ = CDT.RTRANS_LINEITM_SEQ "
            + " LEFT JOIN ttr_voucher_tndr_lineitm tvtl "
            + " ON TTL.ORGANIZATION_ID = tvtl.ORGANIZATION_ID "
            + "  AND TTL.RTL_LOC_ID = tvtl.RTL_LOC_ID "
            + "  AND TTL.BUSINESS_DATE = tvtl.BUSINESS_DATE "
            + "  AND TTL.WKSTN_ID = tvtl.WKSTN_ID "
            + "  AND TTL.TRANS_SEQ = tvtl.TRANS_SEQ "
            + "  AND TTL.RTRANS_LINEITM_SEQ = tvtl.RTRANS_LINEITM_SEQ "
            + " WHERE TTL.TRANS_SEQ=? AND TTL.RTL_LOC_ID=? AND TTL.WKSTN_ID=? AND TTL.BUSINESS_DATE=? AND RTL.VOID_FLAG = 0 "
            + " ORDER BY TTL.RTRANS_LINEITM_SEQ ";
    /*END BZ32517, 52706*/
    //End BZ29123
    //BZ25441; BZ27289
    /* BEGIN BZ33390, BZ31525, BZ31944: add expression TRPM.RTL_PRICE_MOD_REASCODE != 'PRICE_OVERRIDE', BZ31793: add expression LEFT JOIN TRL_RTL_PRICE_MOD_P 
     * BZ33984: TRPM.DISCOUNT_CODE AS BOUNCE_BACK_COUPON*/
    public static final String QUERY_ITEM_DISCOUNT                       = "SELECT TRPM.EXTENDED_AMT,TRPM.DEAL_ID,TRPM.SERIAL_NUMBER, "
            + " CASE "
            + " WHEN "
            + " trpm.discount_reascode = crcp.reason_code "
            + " AND crcp.property_code = 'ENTER_COUPON_CODE' "
            + " AND crcp.decimal_value = 1 "
            + " THEN trpm.notes "
            + " ELSE discount_reascode " 
            + " END " 
            + " AS DISCOUNT_CODE "
            + " ,TRPM.RTL_PRICE_MOD_REASCODE, TRPM.VOID_FLAG, "
            + " TRPM.DISCOUNT_CODE AS BOUNCE_BACK_COUPON, "
            + " CASE "
            + " WHEN "
            + " TRPMP.PROPERTY_CODE IS NOT NULL " 
            + " THEN TRPMP.PROPERTY_CODE " 
            + " ELSE TRPM.SERIAL_NUMBER " 
            + " END AS PROPERTY_CODE, "
            + " CASE "
            + " WHEN  "
            + " TRPMP.DECIMAL_VALUE IS NOT NULL " 
            + " THEN TRPMP.DECIMAL_VALUE " 
            + " ELSE TRPM.EXTENDED_AMT " 
            + " END AS DECIMAL_VALUE "
            + " FROM TRL_RTRANS_LINEITM RTL "
            + " JOIN TRL_SALE_LINEITM TSL ON RTL.ORGANIZATION_ID = TSL.ORGANIZATION_ID "
                                    + "  AND RTL.RTL_LOC_ID = TSL.RTL_LOC_ID "
                                    + "  AND RTL.BUSINESS_DATE = TSL.BUSINESS_DATE "
                                    + "  AND RTL.WKSTN_ID = TSL.WKSTN_ID "
                                    + "  AND RTL.TRANS_SEQ = TSL.TRANS_SEQ "
                                    + "  AND RTL.RTRANS_LINEITM_SEQ = TSL.RTRANS_LINEITM_SEQ "
            + " JOIN TRL_RTL_PRICE_MOD TRPM ON TSL.ORGANIZATION_ID = TRPM.ORGANIZATION_ID "
                                    + "  AND TSL.RTL_LOC_ID = TRPM.RTL_LOC_ID "
                                    + "  AND TSL.BUSINESS_DATE = TRPM.BUSINESS_DATE "
                                    + "  AND TSL.WKSTN_ID = TRPM.WKSTN_ID "
                                    + "  AND TSL.TRANS_SEQ = TRPM.TRANS_SEQ "
                                    + "  AND TSL.RTRANS_LINEITM_SEQ = TRPM.RTRANS_LINEITM_SEQ "
            + " LEFT JOIN TRL_RTL_PRICE_MOD_P TRPMP ON TRPMP.ORGANIZATION_ID = TRPM.ORGANIZATION_ID "
                                    + "  AND TRPMP.RTL_LOC_ID = TRPM.RTL_LOC_ID "
                                    + "  AND TRPMP.BUSINESS_DATE = TRPM.BUSINESS_DATE "
                                    + "  AND TRPMP.WKSTN_ID = TRPM.WKSTN_ID "
                                    + "  AND TRPMP.TRANS_SEQ = TRPM.TRANS_SEQ "
                                    + "  AND TRPMP.RTRANS_LINEITM_SEQ = TRPM.RTRANS_LINEITM_SEQ "
                                    + "  AND TRPMP.RTL_PRICE_MOD_SEQ_NBR = TRPM.RTL_PRICE_MOD_SEQ_NBR "
            + " LEFT JOIN com_reason_code_p crcp ON trpm.discount_reascode = crcp.reason_code "
            + " LEFT JOIN ITM_ITEM ITM ON TSL.ITEM_ID = ITM.ITEM_ID "
            + " LEFT JOIN ITM_ITEM_OPTIONS IIO ON ITM.ITEM_ID = IIO.ITEM_ID "
                                        + "  AND ITM.ORG_CODE = IIO.LEVEL_CODE "
                                        + "  AND ITM.ORG_VALUE = IIO.LEVEL_VALUE "
            + " WHERE TSL.TRANS_SEQ=? "
                + " AND TSL.RTL_LOC_ID=? "
                + " AND TSL.WKSTN_ID=? "
                + " AND TSL.BUSINESS_DATE=? "
                + " AND TSL.ITEM_ID = ? "
                + " AND TSL.RTRANS_LINEITM_SEQ = ? "
                + " AND RTL.VOID_FLAG = 0 "
                + " AND TRPM.VOID_FLAG = 0 "
                + " AND TRPM.RTL_PRICE_MOD_REASCODE != 'PROMPT_PRICE_CHANGE' "
                + " AND TRPM.RTL_PRICE_MOD_REASCODE != 'PRICE_OVERRIDE'"
                + " AND (TRPMP.PROPERTY_CODE != 'IS_LOYALTY_MODIFIER' OR TRPMP.PROPERTY_CODE IS NULL)"; //BZ52837
    /* END BZ33390, BZ31525, BZ31944, BZ31793, BZ33984 */

    public static final String QUERY_PAID_IN_PAID_OUT                    = "SELECT TYPCODE,REASCODE FROM TSN_TNDR_CONTROL_TRANS WHERE TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";

    public static final String QUERY_PAID_IN_OUT_DETAIL_OUT              = "SELECT DESCRIPTION FROM COM_REASON_CODE WHERE  REASON_CODE = ?";

    //BEGIN BZ29156,BZ29205, BZ29324: added param in TRL_P.PROPERTY_CODE
    /* public static final String QUERY_ITEM_PRO_RTL                        = "SELECT TRL_P.PROPERTY_CODE, TRL_P.TYPE,TRL_P.STRING_VALUE,TRL_P.DATE_VALUE,TRL_P.DECIMAL_VALUE"
    + " FROM TRL_RTRANS_LINEITM TRL JOIN TRL_RTRANS_LINEITM_P TRL_P  "
    + " ON TRL.ORGANIZATION_ID = TRL_P.ORGANIZATION_ID  "
    + " AND TRL.RTL_LOC_ID = TRL_P.RTL_LOC_ID "
    + " AND TRL.BUSINESS_DATE = TRL_P.BUSINESS_DATE "
    + " AND TRL.WKSTN_ID = TRL_P.WKSTN_ID "
    + " AND TRL.TRANS_SEQ = TRL_P.TRANS_SEQ "
    + " AND TRL.RTRANS_LINEITM_SEQ = TRL_P.RTRANS_LINEITM_SEQ "
    + " WHERE TRL.TRANS_SEQ=? AND TRL.RTL_LOC_ID=? AND TRL.WKSTN_ID=? AND TRL.BUSINESS_DATE=? AND TRL.RTRANS_LINEITM_SEQ =? "
    + " AND TRL.RTRANS_LINEITM_TYPCODE = 'ITEM'";*/
public static final String QUERY_ITEM_PRO_RTL                        = "SELECT TRL_P.PROPERTY_CODE,  "
    + " ITEM_PPP.STRING_VALUE AS PROPERTY_MAPPING,  "
    + " TRL_P.TYPE ,  "
    + " TRL_P.STRING_VALUE ,   "
    + " TRL_P.DATE_VALUE ,  "
    + " TRL_P.DECIMAL_VALUE  "
    + " FROM TRL_RTRANS_LINEITM TRL  "
    + " JOIN TRL_RTRANS_LINEITM_P TRL_P  "
    + " ON TRL.ORGANIZATION_ID     = TRL_P.ORGANIZATION_ID  "
    + "  AND TRL.RTL_LOC_ID         = TRL_P.RTL_LOC_ID  "
    + "  AND TRL.BUSINESS_DATE      = TRL_P.BUSINESS_DATE  "
    + "  AND TRL.WKSTN_ID           = TRL_P.WKSTN_ID  "
    + "  AND TRL.TRANS_SEQ          = TRL_P.TRANS_SEQ  "
    + "  AND TRL.RTRANS_LINEITM_SEQ = TRL_P.RTRANS_LINEITM_SEQ  "
    + " JOIN TRL_SALE_LINEITM TSL ON TRL.ORGANIZATION_ID = TSL.ORGANIZATION_ID"
    + "  AND TRL.RTL_LOC_ID = TSL.RTL_LOC_ID"
    + "  AND TRL.BUSINESS_DATE = TSL.BUSINESS_DATE"
    + "  AND TRL.WKSTN_ID = TSL.WKSTN_ID"
    + "  AND TRL.TRANS_SEQ = TSL.TRANS_SEQ"
    + "  AND TRL.RTRANS_LINEITM_SEQ = TSL.RTRANS_LINEITM_SEQ"
    + " LEFT JOIN ITM_ITEM_PROMPT_PROPERTIES_P ITEM_PPP  "
    + "  ON TRL_P.ORGANIZATION_ID         = ITEM_PPP.ORGANIZATION_ID  "
    + "  AND UPPER(ITEM_PPP.ITM_PROMPT_PROPERTY_CODE) = UPPER(TRL_P.PROPERTY_CODE)  "
    + "  AND ITEM_PPP.PROPERTY_CODE       = 'MAPPING'  "
    + "  AND ITEM_PPP.ITEM_ID = TSL.ITEM_ID "
    + " WHERE TRL.TRANS_SEQ              =?  "
    + "  AND TRL.RTL_LOC_ID               =?  "
    + "  AND TRL.WKSTN_ID                 =?  "
    + "  AND TRL.BUSINESS_DATE            =?  "
    + "  AND TRL.RTRANS_LINEITM_SEQ       =?  "
    + "  AND TRL_P.PROPERTY_CODE NOT IN (?, ?, ?, ?)"
    + "  AND TRL.RTRANS_LINEITM_TYPCODE   = 'ITEM'";
    //END BZ29156,BZ29205, BZ29324

    public static final String QUERY_CHK_WEB_ORD_LINE_ITM_RETURN         = "SELECT TRL_P.PROPERTY_CODE"
            + " FROM TRL_RTRANS_LINEITM TRL JOIN TRL_RTRANS_LINEITM_P TRL_P  "
            + " ON TRL.ORGANIZATION_ID = TRL_P.ORGANIZATION_ID  "
            + " AND TRL.RTL_LOC_ID = TRL_P.RTL_LOC_ID "
            + " AND TRL.BUSINESS_DATE = TRL_P.BUSINESS_DATE "
            + " AND TRL.WKSTN_ID = TRL_P.WKSTN_ID "
            + " AND TRL.TRANS_SEQ = TRL_P.TRANS_SEQ "
            + " AND TRL.RTRANS_LINEITM_SEQ = TRL_P.RTRANS_LINEITM_SEQ "
            + " WHERE TRL.TRANS_SEQ=? AND TRL.RTL_LOC_ID=? AND TRL.WKSTN_ID=? AND TRL.BUSINESS_DATE=? AND TRL.RTRANS_LINEITM_SEQ =? "
            + " AND TRL.RTRANS_LINEITM_TYPCODE = 'ITEM'";

    public static final String QUERY_UPDATE_STATUS                       = "UPDATE CAW_TRN_ORD_SER SET  STATUS=?, RESPONSE_MESSAGE=?, RESPONSE_CODE=?, RESPONSE_DESC=?, UPDATE_DATE=? WHERE TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";

    public static final String QUERY_UPDATE_RETRY_COUNT                  = "UPDATE CAW_TRN_ORD_SER SET  RETRY_COUNT=? WHERE TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";

    public static final String QUERY_INSERT_CRM_PARTY_ID_XREF_STATUS     = "INSERT INTO CRM_PARTY_ID_XREF (ORGANIZATION_ID, PARTY_ID, ALTERNATE_ID_OWNER, ALTERNATE_ID, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID, RECORD_STATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_STATUS_CUSTOMER_OFFLINE             = "SELECT RECORD_STATE, STRING_VALUE FROM CRM_PARTY_P WHERE PARTY_ID=? AND PROPERTY_CODE=?";

    public static final String QUERY_DELETE_CUSTOMER_OFFLINE             = "DELETE FROM CRM_PARTY_P WHERE PARTY_ID=? AND PROPERTY_CODE=?";

    public static final String QUERY_PAID_IN_OUT_TAX_CODE                = "SELECT TAX_GROUP_ID FROM ITM_ITEM_OPTIONS WHERE  ITEM_ID = ?";

    public static final String QUERY_MEMBERSHIPS                         = "SELECT STRING_VALUE FROM CRM_PARTY_ID_XREF_P WHERE PARTY_ID=? AND PROPERTY_CODE='MEMBERSHIPS'";
    
    public static final String QUERY_PRICING_MEMBERSHIP                  = "SELECT STRING_VALUE FROM CRM_PARTY_ID_XREF_P WHERE PARTY_ID=? AND PROPERTY_CODE='PRICING'"; // BZ48806

    public static final String QUERY_GROUP_PRICING                       = "SELECT CUST_GROUP_ID FROM CRM_CUSTOMER_AFFILIATION WHERE PARTY_ID=?";

    public static final String QUERY_CRM_PARTY_ID_XREF_BY_ACCOUNT_NUMBER = "SELECT ALTERNATE_ID FROM CRM_PARTY_ID_XREF WHERE PARTY_ID=? AND ALTERNATE_ID_OWNER='EBS'";

    public static final String QUERY_COM_REASON_CODE                     = "SELECT DESCRIPTION FROM COM_REASON_CODE WHERE REASON_TYPCODE=? AND REASON_CODE=?";

    //Begin BZ25640
    public static final String QUERY_UFA_PROPERTIES                      = "SELECT PROPERTY_CODE, STRING_VALUE "
            + " FROM TRL_RTRANS_LINEITM_P P "
            + " WHERE (PROPERTY_CODE = 'UFA_DETAIL' OR PROPERTY_CODE = 'ETRACK_ID' OR PROPERTY_CODE = 'EBS_ITEM_CODE' ) "
            + " AND TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=? AND RTRANS_LINEITM_SEQ=1 ";

    //End BZ25640
    //Begin BZ26289
    public static final String QUERY_AR_PAYMENT                          = "SELECT 1 "
            + " FROM TRL_CUST_ITEM_ACCT_MOD "
            + " WHERE CUST_ACCT_CODE='HOUSE_ACCOUNT' AND CUST_ACCT_CODE = 'HOUSE_ACCOUNT' "
            + " AND TRANS_SEQ = ? AND RTL_LOC_ID =? AND WKSTN_ID=? AND BUSINESS_DATE=? "
            + " AND RTRANS_LINEITM_SEQ=?";

    //End BZ26289
    //Begin BZ26207/29661
    public static final String QUERY_WORK_ORDER                          = "SELECT CUST_ACCT_ID, TRANS_SEQ, LINE_TYPCODE "
            + " FROM CAT_CUST_ITEM_ACCT_DETAIL A"
            + " WHERE CUST_ACCT_CODE='WORK_ORDER' "
            + " AND CUST_ITEM_ACCT_DETAIL_ITEM_NBR = ("
            + " SELECT MAX(CUST_ITEM_ACCT_DETAIL_ITEM_NBR) FROM "
            + " CAT_CUST_ITEM_ACCT_DETAIL B WHERE B.RTL_LOC_ID = A.RTL_LOC_ID and  B.WKSTN_ID = A.WKSTN_ID and  B.TRANS_SEQ = A.TRANS_SEQ and  B.BUSINESS_DATE = A.BUSINESS_DATE) "
            + " AND TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";
    //End BZ26207/29661

    //Begin BZ26879
    public static final String QUERY_ITEM_WARRANTY                       = "SELECT COVERED_LINE_RTL_LOC_ID,COVERED_LINE_WKSTN_ID,"
            + " COVERED_LINE_TRANS_SEQ,COVERED_RTRANS_LINEITM_SEQ,COALESCE( COVERED_LINE_BUSINESS_DATE, WARRANTY_LINE_BUSINESS_DATE) AS COVERED_LINE_BUSINESS_DATE "
            + " FROM ITM_WARRANTY "
            + " WHERE WARRANTY_PLAN_ID =? AND WARRANTY_LINE_TRANS_SEQ=? AND WARRANTY_LINE_RTL_LOC_ID=? AND WARRANTY_LINE_WKSTN_ID=? "
            + " AND WARRANTY_RTRANS_LINEITM_SEQ =? AND WARRANTY_TYPCODE = 'WARRANTY'";

    public static final String QUERY_ITEM_WARRANTY_AND_RETURN_SEQUENCE   = "SELECT RTL.RTRANS_LINEITM_SEQ "
            + " FROM TRL_RTRANS_LINEITM RTL LEFT JOIN TRL_SALE_LINEITM TSL ON RTL.ORGANIZATION_ID = TSL.ORGANIZATION_ID "
            + " AND RTL.RTL_LOC_ID = TSL.RTL_LOC_ID "
            + " AND RTL.BUSINESS_DATE = TSL.BUSINESS_DATE "
            + " AND RTL.WKSTN_ID = TSL.WKSTN_ID "
            + " AND RTL.TRANS_SEQ = TSL.TRANS_SEQ "
            + " AND RTL.RTRANS_LINEITM_SEQ = TSL.RTRANS_LINEITM_SEQ "
            + " WHERE RTL.RTRANS_LINEITM_TYPCODE = 'ITEM' AND RTL.VOID_FLAG = 0 "
            + " AND TSL.TRANS_SEQ=? AND TSL.RTL_LOC_ID=? AND TSL.WKSTN_ID=? AND TSL.BUSINESS_DATE=? "
            + " ORDER BY RTRANS_LINEITM_SEQ ASC";

    //End BZ26879
    //Begin BZ27117
    public static final String QUERY_ITEM_WORK_ORDER_FOR_ACCOUNT_CREDIT  = " SELECT IIO.ITEM_ID, IIO.TAX_GROUP_ID from ITM_NON_PHYS_ITEM ITM "
            + " JOIN ITM_ITEM_OPTIONS IIO ON ITM.ITEM_ID = IIO.ITEM_ID "
            + " WHERE  NON_PHYS_ITEM_TYPCODE = 'WORK_ORDER_DEPOSIT' ";
    //End BZ27117

    //Begin BZ27712: query line item property
    public static final String QUERY_RETAIL_TRANS_LINE_ITEM_PROPERTY     = "SELECT PROPERTY_CODE, TYPE, STRING_VALUE, DATE_VALUE, DECIMAL_VALUE"
            + " FROM TRL_RTRANS_LINEITM_P P " + " WHERE PROPERTY_CODE = ?";
    //End BZ27712

    /*BEGIN BZ30261, BZ31664*/
    public static final String QUERY_TRANS_LINE_ITEM_WORK_ORDER           = "SELECT TSL.TRANS_SEQ, TSL.RETURN_FLAG, TSL.SALE_LINEITM_TYPCODE, TLP.PROPERTY_CODE "
            + " FROM TRL_SALE_LINEITM TSL "
            + " JOIN TRL_RTRANS_LINEITM TRL ON TSL.ORGANIZATION_ID = TRL.ORGANIZATION_ID "
                                        + " AND TSL.RTL_LOC_ID = TRL.RTL_LOC_ID "
                                        + " AND TSL.WKSTN_ID = TRL.WKSTN_ID "
                                        + " AND TSL.TRANS_SEQ = TRL.TRANS_SEQ "
                                        + " AND TSL.RTRANS_LINEITM_SEQ = TRL.RTRANS_LINEITM_SEQ "
                                        + " AND TSL.BUSINESS_DATE  = TRL.BUSINESS_DATE "
                                        + " AND TRL.VOID_FLAG NOT IN 1 "
            + " JOIN TRL_RTRANS_LINEITM_P TLP  ON TSL.ORGANIZATION_ID  = TLP.ORGANIZATION_ID "
                                        + " AND TSL.RTL_LOC_ID = TLP.RTL_LOC_ID "
                                        + " AND TSL.WKSTN_ID = TLP.WKSTN_ID "
                                        + " AND TSL.TRANS_SEQ = TLP.TRANS_SEQ "
                                        + " AND TSL.RTRANS_LINEITM_SEQ = TLP.RTRANS_LINEITM_SEQ "
                                        + " AND TSL.BUSINESS_DATE = TLP.BUSINESS_DATE "
            + " WHERE TSL.TRANS_SEQ =? "
            + " AND TSL.RTL_LOC_ID =? "
            + " AND TSL.WKSTN_ID =? "
            + " AND TSL.BUSINESS_DATE =? "
            + " AND TLP.PROPERTY_CODE LIKE ? "
            + " AND ROWNUM <=1";
    /*END BZ30261, BZ31664*/

    /* BEGIN BZ29668 */
    public static final String QUERY_INSERT_ORD_SER_LOG = "INSERT INTO CAW_TRN_ORD_SER_LOG" 
            + " (TIMESTAMP, TRANS_SEQ, RTL_LOC_ID, WKSTN_ID, BUSINESS_DATE, REQUEST_MESSAGE, RESPONSE_MESSAGE, RESPONSE_CODE)" 
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    public static final String QUERY_UPDATE_ORD_SER_LOG = "UPDATE CAW_TRN_ORD_SER_LOG" 
            + " SET RESPONSE_MESSAGE=?, RESPONSE_CODE=?"
            + " WHERE TIMESTAMP=?"
            + " AND TRANS_SEQ=?"
            + " AND RTL_LOC_ID=?"
            + " AND WKSTN_ID=?";
    /* END BZ29668 */

    /* BEGIN BZ35016 */
    public static final String QUERY_WORK_ORDER_TRANS = "SELECT PROPERTY_CODE, STRING_VALUE "
            + " FROM TRN_TRANS_P "
            + " WHERE TRANS_SEQ = ? "
            + " AND RTL_LOC_ID = ? "
            + " AND WKSTN_ID = ? "
            + " AND BUSINESS_DATE = ? "
            + " AND property_code LIKE 'WO:%'";
    /* END BZ35016 */
    
    /* BEGIN BZ37463 */
    public static final String QUERY_BROKERED_ORDER_TRANS                = "SELECT XOMMOD.TRANS_SEQ, XOMORDER.ORDER_ID, XOMORDER.ORDER_TYPE, XOMORDER.STATUS_CODE "
            + " FROM XOM_ORDER_MOD XOMMOD INNER JOIN XOM_ORDER XOMORDER ON XOMMOD.ORGANIZATION_ID=XOMORDER.ORGANIZATION_ID AND XOMMOD.ORDER_ID=XOMORDER.ORDER_ID"
            + " WHERE XOMMOD.RTL_LOC_ID=?" + " AND BUSINESS_DATE = ? "
            + " AND XOMMOD.WKSTN_ID=?" + " AND XOMMOD.TRANS_SEQ=?"
            + " FETCH FIRST 1 ROWS ONLY";
    /* BEGIN BZ38716, BZ38841, BZ-40561, BZ45903, BZ48320*/
    public static final String QUERY_BROKERED_ORDER_LINES                = "SELECT (TO_CHAR(XOMMOD.BUSINESS_DATE, 'YYYYMMDD') || ':' || LPAD(XOMMOD.RTL_LOC_ID, 4, '0') || ':' || LPAD(XOMMOD.WKSTN_ID, 2, '0') || ':' || XOMMOD.TRANS_SEQ || ':' || XOMMOD.RTRANS_LINEITM_SEQ) AS CORRELATION_KEY, XOMORDERLINE.EXTERNAL_ORDER_ID, XOMORDERLINE.ITEM_ID, XOMORDERLINE.SELECTED_SHIP_METHOD, ISM.SHIPPER_METHOD_DESC , XOMORDERLINE.FULFILLMENT_TYPE, XOMORDERLINE.ORDER_ID, XOMORDERLINE.STATUS_CODE, XOMORDERLINE.DETAIL_SEQ, XOMORDERLINE.STATUS_CODE_REASON, XOMORDERLINE.STATUS_CODE_REASON_NOTE, XOMORDERLINE.STATUS_CODE_REASON_NOTE, XOMMOD.RTRANS_LINEITM_SEQ, XOMORDERLINEP.STRING_VALUE"
            + " FROM XOM_ORDER_MOD XOMMOD "
            + " INNER JOIN XOM_ORDER_LINE XOMORDERLINE ON XOMMOD.ORGANIZATION_ID=XOMORDERLINE.ORGANIZATION_ID "
            + "  AND XOMMOD.ORDER_ID=XOMORDERLINE.ORDER_ID  AND XOMMOD.DETAIL_SEQ=XOMORDERLINE.DETAIL_SEQ "
            + " LEFT JOIN XOM_ORDER_LINE_P XOMORDERLINEP ON XOMORDERLINE.ORGANIZATION_ID = XOMORDERLINEP.ORGANIZATION_ID"
            + " AND XOMORDERLINE.ORDER_ID = XOMORDERLINEP.ORDER_ID AND XOMORDERLINE.DETAIL_SEQ = XOMORDERLINEP.DETAIL_SEQ AND XOMORDERLINEP.PROPERTY_CODE='VIN'"
            + " LEFT JOIN INV_SHIPPER_METHOD ISM ON XOMORDERLINE.SELECTED_SHIP_METHOD= ISM.SHIPPER_METHOD_ID "
            + " WHERE  BUSINESS_DATE=? AND XOMMOD.RTL_LOC_ID=? AND XOMMOD.WKSTN_ID=? AND XOMMOD.TRANS_SEQ=?";
    /* END BZ38716, BZ38841, BZ-40561, BZ45903, BZ48320 */
    public static final String QUERY_BROKERED_ORDER_FROM_TRANS_P         = "SELECT PROPERTY_CODE, STRING_VALUE "
            + " FROM TRN_TRANS_P " + " WHERE TRANS_SEQ = ? "
            + " AND RTL_LOC_ID = ? " + " AND WKSTN_ID = ? "
            + " AND BUSINESS_DATE = ? "
            + " AND (PROPERTY_CODE='ORDER_ID' or PROPERTY_CODE='ORDER_STATUS' or PROPERTY_CODE='ORDER_STATUS_LINES')"; // BZ-40776

    public static final String QUERY_BROKERED_ORDER_BY_ID                = "SELECT ORDER_ID, ORDER_TYPE, STATUS_CODE "
            + " FROM XOM_ORDER" + " WHERE ORDER_ID = ? "
            + " FETCH FIRST 1 ROWS ONLY";
    // Begin BZ-40561
    public static final String QUERY_BROKERED_ORDER_LINES_BY_ID          = "SELECT ORDER_ID, DETAIL_SEQ, EXTERNAL_ORDER_ID, ITEM_ID, QUANTITY, FULFILLMENT_TYPE, STATUS_CODE, STATUS_CODE_REASON, STATUS_CODE_REASON_NOTE "
            + " FROM XOM_ORDER_LINE WHERE  ORDER_ID=? ORDER BY UPDATE_DATE DESC ";
    // End BZ-40561
    /* BEGIN BZ38716 */
    /**
     * The QUERY_SHIPPING_INFO
     */
    public static final String QUERY_SHIPPING_INFO                       = "SELECT XFM.LOC_ID, LOC_NAME1, LOC_NAME2, XAM.ADDRESS1, XAM.CITY, XAM.STATE, XAM.POSTAL_CODE, XAM.COUNTRY, XFM.DETAIL_SEQ FROM XOM_FULFILLMENT_MOD XFM INNER JOIN XOM_ADDRESS_MOD XAM "
            + " ON XFM.ORDER_ID = XAM.ORDER_ID "
            + " AND XFM.ORGANIZATION_ID = XAM.ORGANIZATION_ID "
            + " AND XFM.ADDRESS_SEQ = XAM.ADDRESS_SEQ "
            + " WHERE XFM.ORDER_ID=?";
    /* END BZ38716 */
    /* END BZ37463 */

    /* BEGIN BZ40798 */
    public static final String QUERY_SAVINGS_AMOUNT                       = "SELECT STRING_VALUE, PROPERTY_CODE FROM TRN_TRANS_P WHERE TRANS_SEQ=? AND RTL_LOC_ID=? AND WKSTN_ID=? AND BUSINESS_DATE=?";
    /* END BZ40798 */
    
    //Begin BZ48749 query line item property
    public static final String QUERY_RTRANS_LINE_ITEM_PROPERTY     = "SELECT PROPERTY_CODE, TYPE, STRING_VALUE, DATE_VALUE, DECIMAL_VALUE"
            + " FROM TRL_RTRANS_LINEITM_P P " 
            + " WHERE RTL_LOC_ID =? AND   WKSTN_ID =? AND   TRANS_SEQ =? AND   BUSINESS_DATE =? AND   RTRANS_LINEITM_SEQ =? AND   PROPERTY_CODE =?";
    //End BZ48749
    // BEGIN BZ51771
    public static final String QUERY_GET_LOYALTY_DETAIL                       = "SELECT STRING_VALUE FROM TRN_TRANS_P "
            + " WHERE RTL_LOC_ID = ? "
            + " AND WKSTN_ID = ? "
            + " AND TRANS_SEQ = ? "
            + " AND BUSINESS_DATE = ? "
            + " AND PROPERTY_CODE='CAW_LOYALTY_FOR_OS'";
    public static final String QUERY_GET_LOYALTY_DETAIL2                       = "SELECT STRING_VALUE FROM TRN_TRANS_P "
            + " WHERE RTL_LOC_ID = ? "
            + " AND WKSTN_ID = ? "
            + " AND TRANS_SEQ = ? "
            + " AND PROPERTY_CODE='CAW_LOYALTY_FOR_OS'";
    //END BZ51771
    //BEGIN BZ55978
    public static final String QUERY_GET_ALL_PART_LOYALTY_DETAIL                       = "SELECT STRING_VALUE FROM TRN_TRANS_P "
            + " WHERE RTL_LOC_ID = ? "
            + " AND WKSTN_ID = ? "
            + " AND TRANS_SEQ = ? "
            + " AND BUSINESS_DATE = ? "
            + " AND PROPERTY_CODE LIKE 'CAW_LOYALTY_FOR_OS%' ORDER BY to_number(SUBSTR(PROPERTY_CODE,20,10)) asc";
    //END BZ55978
    //BEGIN BZ61159
    public static final String QUERY_GET_ALL_PART_PITCHES_INFO                       = "SELECT STRING_VALUE FROM TRN_TRANS_P "
            + " WHERE RTL_LOC_ID = ? "
            + " AND WKSTN_ID = ? "
            + " AND TRANS_SEQ = ? "
            + " AND BUSINESS_DATE = ? "
            + " AND PROPERTY_CODE LIKE 'CAW_AGIS_PITCHES_JSON%' ORDER BY to_number(SUBSTR(PROPERTY_CODE,23,10)) asc";
    //END BZ61159
}