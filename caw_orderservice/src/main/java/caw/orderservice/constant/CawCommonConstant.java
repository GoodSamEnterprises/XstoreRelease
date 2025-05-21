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
 * BZ25640              051518    New Requirement - Used Firearm System Process Redesign
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ27117              080818    [OS] Should be handled account credit tender like Item deposit for WO complete transaction.
 * BZ27584              190918    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29205              250119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ30261              240419    [Prod] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ32517              291019    [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ41065              030221    [UAT] Order Service send accept status with the reason code/desc for the subsequent reject/cancel
 * BZ40798              240221    Modification to member savings calculation
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47542              071221    RV Service Payments - Property Names
 * BZ48749              052422    [PROD] Issues in xStore vs DW sales report
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ50835              300622    [Order Service] Loyalty - OS request has error when making a Sales transaction with a customer has loyalty
 * BZ52349              201022    [Internal][Order Service] Loyalty - OS request include the error detail in customer tag when making Sale with customers belonging to GSAM Club without Loyalty.
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *== ================================================================
 */

package caw.orderservice.constant;

/**
 * Declare constants for Order Service
 */
public class CawCommonConstant {

    public static final String NEW_LINE                       = "\n";

    public static final char   ZERO_CHAR                      = '0';

    public static final String EMPTY_STRING                   = "";

    public static final String SPACE                          = " ";

    public static final String FORMAT_DATE                    = "dd-MMM-YYYY hh.mm.ss.SSSSSSSSS aa";

    public static final String NULL_STRING                    = "null";

    public static final String YYYY_M_MDD                     = "yyyyMMdd";

    public static final String HTML                           = "HTML";

    public static final String UTF_8                          = "UTF-8";

    public static final String ENC_8BIT                       = "8bit";

    public static final String CONTENT_TRANSFER_ENCODING      = "Content-Transfer-Encoding";

    public static final String TEXT_HTML_CHARSET_UTF_8        = "text/HTML; charset=UTF-8";

    public static final String CONTENT_TYPE                   = "Content-type";

    public static final String CUSTOMER_EMAIL_UPDATED_STRING  = "CUSTOMER_EMAIL_UPDATED";

    public static final String PAPER_STRING                   = "PAPER";

    public static final String RECEIPT_EMAIL_ADDRESS_STRING   = "RECEIPT_EMAIL_ADDRESS";

    public static final String STRING_VALUE                   = "STRING_VALUE";

    public static final String RECEIPT_DELIVERY_METHOD_STRING = "RECEIPT_DELIVERY_METHOD";

    public static final String NONE_METHOD                    = "None";

    public static final String EMAIL_PAPER_STRING             = "EMAIL+PAPER";

    public static final String PRINT_AND_EMAIL_METHOD         = "PrintAndEmail";

    public static final String PRINT_METHOD                   = "Print";

    public static final String EMAIL_ONLY_STRING              = "EMAIL";

    public static final String EMAIL_METHOD                   = "Email";

    public static final String COUNTRY_USA                    = "USA";

    public static final String COUNTRY_US                     = "US";

    public static final String TENDER_EXCHANGE                = "TENDER_EXCHANGE";

    public static final String SALES_TRANSACTION              = "SalesTransaction";

    public static final String EACHES                         = "Eaches";

    public static final String HOME_FIELD                     = "HOME";

    //ABLE TO MOVE TO OTHER CLASSES -----------------------------------------

    public static final String ESB_QUEUE_VALUE                = "ESB_QUEUE";

    public static final String DISCOUNT_STRING                = "Discount";

    public static final String NOT_SPECIFIED_STRING           = "NotSpecified";

    public static final String RESIDENTIAL_STRING             = "Residential";

    public static final String TENDER_CONTROL                 = "TENDER_CONTROL";

    public static final String PAID_OUT                       = "PAID_OUT";

    public static final String PAID_IN                        = "PAID_IN";

    public static final String PAIDOUT                        = "PaidOut";

    public static final String PAIDIN                         = "PaidIn";

    public static final String REFUND                         = "Refund";

    public static final String CHANGE_TNDSTATUSCODE           = "Change";

    public static final String CCENC                          = "ccenc";

    public static final String TAXCODE_NT                     = "NT";

    public static final String CRUD_NOT_SPECIFIED             = "NotSpecified";

    public static final String CRUD_CREATED                   = "Created";

    public static final String ORDER_SERVICE                  = "OrderService";

    public static final String FLOWED                         = "flowed";

    public static final String FORMAT                         = "format";

    public static final String FULL_NAME_FIELD                = "FULL_NAME";

    public static final String ITM_TAX_CODE_PAID_IN_OUT       = "ZZ";

    public static final String P_CODE_SALES_ORD_INF           = "SALESORDERINFORMATION";

    public static final String VAL_RETURN_REASON_TYPCODE      = "RETURN";

    /*Begin BZ25640 */
    public static final String UFA_REASON_TYPE_CODE           = "PAID_OUT_UFA";

    public static final String UFA_REASON_CODE                = "PO12";

    public static final String UFA_PROPERTY_EBS_ITEM_CODE     = "EBS_ITEM_CODE";

    public static final String UFA_PROPERTY_ETRACK_ID         = "ETRACK_ID";

    public static final String UFA_PROPERTY_UFA_DETAIL        = "UFA_DETAIL";

    /*End BZ25640 */
    //Begin BZ26207
    public static final String WO_COMPLETE_CODE               = "PAYMENT_TENDER";

    public static final String WO_CANCEL_CODE                 = "PAYMENT_REFUND";

    public static final String WORK_ORDER_DEPOSIT             = "WorkOrderDeposit";

    public static final String WORK_ORDER_CANCEL              = "WorkOrderCancel";

    public static final String WORK_ORDER_COMPLETE            = "WorkOrderComplete";

    public static final String WO_DEPOSIT_CODE                = "DEPOSIT";

    //End BZ26207
    public static final String COUPON_CODE_FIELD              = "COUPONCODE:";

    public static final String ACCOUNT_CREDIT                 = "ACCOUNT_CREDIT";                   //BZ27117

    public static final String WO_CANCEL_CODE_VALUE           = "16";                               //BZ27584

    // Begin BZ27712: some format for work order item's attributes
    public static final String WA_CODE                        = "WA";

    public static final String DATE_TIME_FORMAT_NOSPACE       = "MMddyyyyhhmmssaa";

    public static final String PREFIX_ZERO                    = "^0+(?!$)";
    // End BZ27712
    public static final String WO_PROPERTIES_CODE             = "WP";                               //BZ29205

    //Begin BZ29391
    public static final String CAW_TRANSACTION_TYPE           = "CAW_TRANSACTION_TYPE";

    public static final String ACCOUNT_PAYMENT                = "ACCOUNT_PAYMENT";
    //End BZ29391

    // Begin BZ30261
    public static final String LINEITM_TYPCODE_WORK_ORDER     = "WORK_ORDER";

    public static final String LINEITM_TYPCODE_SALE           = "SALE";
    // End BZ30261
    /*BEGIN BZ32517*/
    public static final String SERIAL_NUMBER_TEXT               = "{\"serialNumber\": \"%s\"}";
    /*END BZ32517*/

    /* BEGIN BZ37463 */
    public static final String BROKERED_ORDER_CHANNEL_TYPE         = "4";

    public static final String BROKERED_ORDER_TYPE_PICKUP          = "Pickup";

    public static final String BROKERED_ORDER_TYPE_DELIVERY        = "Delivery";

    public static final String BROKERED_ORDER_STANDARD_PICKUP      = "STANDARD_PICKUP";

    public static final String BROKERED_ORDER_STANDARD_DELIVERY    = "STANDARD_DELIVERY";

    public static final String ATTR_ORDER_DETAIL                   = "!{orderDetail}";

    public static final String ATTR_POS_STATUS                     = "!{posStatus}";

    public static final String ATTR_BROKERED_ORDER_ID              = "!{brokeredOrderID}";

    public static final String TRANS_TYPE_ORDER_CODE               = "ORDER";

    public static final String ORDER_STATUS                        = "OPEN";

    public static final String ORDER_STATUS_NEW                    = "New";

    public static final String TRANS_TYPE_ORDER_RETAIL_TRANSACTION = "RetailTransaction";

    public static final String BROKER_ACTION                       = " !{brokerAction}";

    /* END BZ37463 */
    
    /* BEGIN BZ41065 */   
    public static final String BROKERED_ORDER_STT_CODE_CANCELLED   = "CANCELLED";
    
    public static final String BROKERED_ORDER_STT_CODE_REJECTED    = "REJECTED";
    /* END BZ41065 */
    
    /* BEGIN BZ40798 */
    public static final String ATTR_ATTRIBUTES                     = "!{attributes}";

    public static final String GOOD_SAM_SAVINGS_STRING             = "GOOD_SAM_SAVINGS";

    public static final String COULD_SAVE_STRING                   = "COULD_SAVE";
    
    public static final String VALUE_00                            = "0.00"; // BZ40798 check null for WHSL and CREW 
    /* END BZ40798 */
    /*BEGIN BZ44528*/
    public static final String WONDERSIGN_CART_ID                  = "wondersign_cart_id";

    public static final String ATTRIBUTES_CARTIDS                  = "cartIDs";

    public static final String OB_SHIP_TO_CUSTOMER                 = "ShipToCustomer";

    public static final String OB_PICKUP_IN_STORE                  = "PickupInStore";
    /*END BZ44528*/
    public static final String ATTRIBUTES_RV_PAYMENT_AMOUNT        = "rvPaymentAmount";/*BZ44917*/
    
    public static final String RV_SERVICE_PAYMENT_PROPERTIES       = "rv_service_payment_properties";/*BZ47542*/
    
    public static final String IS_WO_ITEM                          = "IS_WO_ITEM";/*BZ31944*/
    
    
    //BEGIN BZ48630
    public static final String JSON_RESULT_CODE                    = "resultCode";
    
    public static final String JSON_ERROR_DETAIL                   = "errorDetail";
    
    public static final String JSON_RESULT                         = "result";
    
    /* Handle to use TOKEN */
    public static final String CAW_AUTHORIZATION                    = "authorization";
    
    public static final String CAW_TOKEN_TYPE                       = "token_type";
    
    public static final String CAW_ACCESS_TOKEN                     = "access_token";
    
    public static final String CAW_TOKEN_EXPIRES_IN                 = "expires_in";
    
    public static final String CAW_TOKEN_EXPIRED_TIME_FORMAT        = "yyyy-MM-dd HH:mm:ss";
    //END BZ48630
    
    //Start BZ50835
    
    public static final String JSON_CUSTOMER                        = "customer"; 
    
    public static final String JSON_LOYALTY                         = "loyalty"; 
    //End BZ50835
    
    //BEGIN BZ52349
    public static final String ACCOUNT_NUMBER                       = "{accountNumber}"; 
    public static final String LOCATION_CODE                        = "{locationCode}"; 
    public static final String LOYALTY_SEARCH_IS_TRUE               = "loyaltySearch=true"; 
    public static final String LOYALTY_SEARCH_IS_FALSE              = "loyaltySearch=false"; 
    //END BZ52349
    
    //BEGIN BZ61159
    public static final String JSON_DATA                            = "data";
    public static final String JSON_META                            = "meta";
    public static final String JSON_ATTRIBUTES                      = "attributes";
    public static final String JSON_ORDER_RESPONSE                  = "theOrderResponse";
    public static final String JSON_STATUS                          = "status";
    public static final String JSON_DETAIL                          = "detail";
    public static final String JSON_ERROR                           = "error";
    public static final String JSON_ERROR_DESCRIPTION               = "error_description";
    //END BZ61159
    
    public static final String RETAIL                               = "Retail"; //BZZ63054
}