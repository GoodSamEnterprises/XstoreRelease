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
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ26879              300718    [New Requirement] Add reference to Original item on Order Service
 * BZ27584              190918    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ29123              210119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 * BZ29156              210119    [Bundle the enhancement 2.1_29109] 0500 Property Names in the Order Service
 * BZ30261              240419    [Prod] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ32517              291019    [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory
 * BZ33984              261119    [Port 33954 to 5.2]Bounce Back Coupon reporting not showing all data
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup store address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores
 * BZ40561              140121    OB Reject Reasons and Order Status
 * BZ40776              280121    [UAT] Duplicate and Missed Order service Messages on order status change in Xstore
 *== ================================================================
 */

package caw.orderservice.constant;

/**
 * Define Data Fields 
 */
public class CawDBFieldConstant {

    public static final String ITEMCODE                          = "ItemCode";

    public static final String LOC_COUNTRY_FIELD                 = "LOC_COUNTRY";

    public static final String LOC_POSTAL_CODE_FIELD             = "LOC_POSTAL_CODE";

    public static final String LOC_STATE_FIELD                   = "LOC_STATE";

    public static final String LOC_CITY_FIELD                    = "LOC_CITY";

    public static final String LOC_ADDRESS2_FIELD                = "LOC_ADDRESS2";

    public static final String LOC_ADDRESS1_FIELD                = "LOC_ADDRESS1";

    public static final String EMP_PARTY_ID_FIELD                = "EMP_PARTY_ID";

    public static final String EMP_FULL_NAME_FIELD               = "EMP_FULL_NAME";

    public static final String STRING_VALUE_FIELD                = "STRING_VALUE";

    public static final String RECORD_STATE_FIELD                = "RECORD_STATE";

    public static final String EXPR_DATE_FIELD                   = "EXPR_DATE";

    public static final String AUTH_NBR_FIELD                    = "AUTH_NBR";

    public static final String EXTENDED_AMT_FIELD                = "EXTENDED_AMT";

    public static final String GROSS_AMT_FIELD                   = "GROSS_AMT";

    public static final String PROPERTY_CODE_FIELD               = "PROPERTY_CODE";

    public static final String AMT_FIELD                         = "AMT";

    public static final String TNDR_ID_FIELD                     = "TNDR_ID";

    public static final String TAX_GROUP_ID_FIELD                = "TAX_GROUP_ID";

    public static final String BASE_UNIT_PRICE_FIELD             = "BASE_UNIT_PRICE";

    public static final String UNIT_PRICE_FIELD                  = "UNIT_PRICE";

    public static final String UNIT_OF_MEASURE_CODE_FIELD        = "UNIT_OF_MEASURE_CODE";

    public static final String PROMPT_FOR_PRICE_FLAG             = "PROMPT_FOR_PRICE_FLAG";

    public static final String QUANTITY_FIELD                    = "QUANTITY";

    public static final String ITEM_ID_FIELD                     = "ITEM_ID";

    public static final String COUNTY_FIELD                      = "COUNTY";

    public static final String ADDRESS4_FIELD                    = "ADDRESS4";

    public static final String ADDRESS3_FIELD                    = "ADDRESS3";

    public static final String ADDRESS_TYPE_FIELD                = "ADDRESS_TYPE";

    public static final String SUFFIX_FIELD                      = "SUFFIX";

    public static final String MIDDLE_NAME_FIELD                 = "MIDDLE_NAME";

    public static final String SALUTATION_FIELD                  = "SALUTATION";

    public static final String ALTERNATE_ID_FIELD                = "ALTERNATE_ID";

    public static final String ORGANIZATION_NAME_FIELD           = "ORGANIZATION_NAME";

    public static final String COUNTRY_FIELD                     = "COUNTRY";

    public static final String POSTAL_CODE_FIELD                 = "POSTAL_CODE";

    public static final String STATE_FIELD                       = "STATE";

    public static final String CITY_FIELD                        = "CITY";

    public static final String ADDRESS2_FIELD                    = "ADDRESS2";

    public static final String ADDRESS1_FIELD                    = "ADDRESS1";

    public static final String STORE_NAME_FIELD                  = "STORE_NAME";

    public static final String PARTY_ID_FIELD                    = "PARTY_ID";

    public static final String LAST_NAME_FIELD                   = "LAST_NAME";

    public static final String FIRST_NAME_FIELD                  = "FIRST_NAME";

    public static final String EMPLOYEE_ID_FIELD                 = "EMPLOYEE_ID";

    public static final String TOTAL_FIELD                       = "TOTAL";

    public static final String BUSINESS_DATE_FIELD               = "BUSINESS_DATE";

    public static final String TRANS_SEQ_FIELD                   = "TRANS_SEQ";

    public static final String WKSTN_ID_FIELD                    = "WKSTN_ID";

    public static final String RTL_LOC_ID_FIELD                  = "RTL_LOC_ID";

    public static final String ACCT_NBR_FIELD                    = "ACCT_NBR";

    public static final String TRANSACTION_REFERENCE_DATA_FIELD  = "TRANSACTION_REFERENCE_DATA";

    public static final String CUSTOMER_NAME_FIELD               = "CUSTOMER_NAME";

    public static final String BEGIN_DATETIME_FIELD              = "BEGIN_DATETIME";

    public static final String SERIAL_NUMBER_FIELD               = "SERIAL_NUMBER";

    public static final String DEAL_ID_FIELD                     = "DEAL_ID";

    public static final String REGURLAR_BASE_PRICE_FIELD         = "REGULAR_BASE_PRICE";

    public static final String DISCOUNT_CODE_FIELD               = "DISCOUNT_CODE";

    public static final String PRICE_PROPERTY_CODE_FIELD         = "PRICE_PROPERTY_CODE";

    public static final String RTRANS_LINEITM_SEQ_FIELD          = "RTRANS_LINEITM_SEQ";

    public static final String RTL_PRICE_MOD_REASON_FIELD        = "RTL_PRICE_MOD_REASCODE";

    public static final String TAX_AMT_FIELD                     = "TAX_AMT";

    public static final String TRANS_TYPCODE_FIELD               = "TRANS_TYPCODE";

    public static final String TYPCODE_FIELD                     = "TYPCODE";

    public static final String REASCODE_FIELD                    = "REASCODE";

    public static final String DESCRIPTION_FIELD                 = "DESCRIPTION";

    public static final String TNDR_STATCODE_FIELD               = "TNDR_STATCODE";

    public static final String SERIAL_NBR_FIELD                  = "SERIAL_NBR";

    public static final String LOGIN_ID_FIELD                    = "LOGIN_ID";

    public static final String DATE_VALUE_FIELD                  = "DATE_VALUE";

    public static final String DECIMAL_VALUE_FIELD               = "DECIMAL_VALUE";

    public static final String RETRY_COUNT_FIELD                 = "RETRY_COUNT";

    public static final String CUST_GROUP_ID                     = "CUST_GROUP_ID";

    public static final String RETURN_REASCODE_FIELD             = "RETURN_REASCODE";

    public static final String RETURN_FLAG_FIELD                 = "RETURN_FLAG";                //BZ25860

    public static final String CUST_ACCT_ID_FIELD                = "CUST_ACCT_ID";               //BZ26207

    public static final String LINE_TYPCODE_FIELD                = "LINE_TYPCODE";               //BZ26207

    //Begin BZ26879
    public static final String COVERED_LINE_RTL_LOC_ID_FIELD     = "COVERED_LINE_RTL_LOC_ID";

    public static final String COVERED_LINE_WKSTN_ID_FIELD       = "COVERED_LINE_WKSTN_ID";

    public static final String COVERED_LINE_TRANS_SEQ_FIELD      = "COVERED_LINE_TRANS_SEQ";

    public static final String COVERED_RTRANS_LINEITM_SEQ_FIELD  = "COVERED_RTRANS_LINEITM_SEQ";

    public static final String COVERED_LINE_BUSINESS_DATE_FIELD  = "COVERED_LINE_BUSINESS_DATE";

    //End BZ26879
    //Begin BZ27584
    public static final String ORIGINAL_BUSINESS_DATE_FIELD      = "ORIGINAL_BUSINESS_DATE";

    public static final String ORIGINAL_RTL_LOC_ID_FIELD         = "ORIGINAL_RTL_LOC_ID";

    public static final String ORIGINAL_WKSTN_ID_FIELD           = "ORIGINAL_WKSTN_ID";

    public static final String ORIGINAL_TRANS_SEQ_FIELD          = "ORIGINAL_TRANS_SEQ";

    public static final String ORIGINAL_RTRANS_LINEITM_SEQ_FIELD = "ORIGINAL_RTRANS_LINEITM_SEQ";
    //End BZ27584

    public static final String PO_NUMBER_FIELD                   = "PO_NUMBER";                  //BZ29123

    public static final String PROPERTY_MAPPING                  = "PROPERTY_MAPPING";           //BZ29156

    // Begin BZ30261
    public static final String SALE_LINEITM_TYPCODE_FIELD        = "SALE_LINEITM_TYPCODE";
    // End BZ30261
    
    /*BEGIN BZ32517*/
    public static final String ORIG_STAN                         = "ORIG_STAN";
    public static final String serial_nbr_gc                     = "serial_nbr";
    /*END BZ32517*/
    
    public static final String BOUNCE_BACK_COUPON                = "BOUNCE_BACK_COUPON"; // BZ33984
    
    /* BEGIN BZ37463 */
    public static final String BROKERED_ORDER_ID                 = "ORDER_ID";

    public static final String BROKERED_ORDER_TYPE               = "ORDER_TYPE";

    public static final String BROKERED_ORDER_STATUS_CODE        = "STATUS_CODE";

    // Begin BZ-40561
    public static final String BROKERED_ORDER_STATUS_CODE_REASON = "STATUS_CODE_REASON";
    
    public static final String BROKERED_ORDER_STATUS_CODE_REASON_NOTE = "STATUS_CODE_REASON_NOTE";
    // End BZ-40561

    public static final String BROKERED_CORRELATION_KEY          = "CORRELATION_KEY";

    public static final String BROKERED_EXTERNAL_ORDER_ID        = "EXTERNAL_ORDER_ID";

    public static final String BROKERED_ORDER_ORDER_STATUS       = "ORDER_STATUS";
    
    public static final String BROKERED_ORDER_ORDER_STATUS_LINES = "ORDER_STATUS_LINES"; // BZ-40776 

    public static final String BROKERED_LOC_NAME1                = "LOC_NAME1";

    public static final String BROKERED_LOC_NAME2                = "LOC_NAME2";

    public static final String BROKERED_ADDRESS1                 = "ADDRESS1";

    public static final String BROKERED_CITY                     = "CITY";

    public static final String BROKERED_STATE                    = "STATE";

    public static final String BROKERED_POSTAL_CODE              = "POSTAL_CODE";

    public static final String BROKERED_COUNTRY                  = "COUNTRY";

    public static final String SELECTED_SHIP_METHOD              = "SELECTED_SHIP_METHOD";

    public static final String SHIPPER_METHOD_DESC               = "SHIPPER_METHOD_DESC";

    public static final String EXTERNAL_ORDER_ID                 = "EXTERNAL_ORDER_ID";

    public static final String FULFILLMENT_TYPE                  = "FULFILLMENT_TYPE";

    public static final String FULLFILLLOCATION_ID               = "LOC_ID";

    public static final String DETAIL_SEQ                        = "DETAIL_SEQ"; // BZ38716
    /* END BZ37463 */
}