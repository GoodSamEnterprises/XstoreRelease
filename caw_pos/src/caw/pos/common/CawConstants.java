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
 * BZ23477          200917    Need send back customer information to EBS WS when online
 * BZ23637          280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26289          180718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ26851          090818    [PROD] Register displayed an error when trying to print receipt
 * BZ27247          170818    Gift Card Reloads should have GC RELOAD for Item #
 * BZ27334          020818    Work Order Refund Receipts Lost Reason Codes
 * BZ27342          011018    [New Requirement] An approach to apply promo to club members with certain status
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27757          100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 * BZ27712          121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ27813          181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28567          071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28626          121218    Allow Has email input text box from EBS is not required
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28741          211218    [PLCC] The selection of customer on Pin Pad Credit Approval Form doesn't persist in TRN_TRANS_P
 * BZ28853          271218    [Internal][offline][2.9.7] Cannot found a customer which existed data from XCenter incase offline.
 * BZ28859          271218    [Internal]Declined Gift Card Tender Exchange Receipt shows Transaction Type as "Cash Out" instead of "Redemption".
 * BZ29124          280119    Port 29051 to Release 3.0 - Update Xstore to allow only one PO tender per transaction
 * BZ29205          280119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29134          290119    [Internal] The Account Lookup flow should be aborted after three failed attempts look up a customer hasn't found in system.
 * BZ28546          310119    Send item data to CC Auth Request for ADS Settlement
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ28012          180219    [New Requirement] Reprocess the ApplicationStatus calls if first attempt is unsuccessful
 * BZ29514          220219    Updated Requirement] ADS Feedback: Instant Credit API â€“ the phone number is not being sent. This is a required field.
 * BZ29454          220219    [Internal] Temporary Shopping Pass is missing Temporary Limit amount.
 * BZ29535          270219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 * BZ29580          280219    [New Requirement] Change GUI verbiage for the terminated employee notification
 * BZ29619          040319    [Internal][PLCC] Shopping Pass Changes
 * BZ29683          080319     [INTERNAL] [4.0.1] Review/Evaluate $20 GSVS on the current build
 * BZ29625          080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 * BZ27535          090593    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ28014          310519    [New Requirement] Xstore needs to allow stackability for/Allow multiple Merchant Certificates in a transaction
 * BZ30922          210619    [New Requirement] Price Check and Inventory Lookup
 * BZ32123          240719    [Prod] Gift Card Reload Activated Wrong Card Number
 * BZ33137          031019    Employee Logins - How to Deactivate
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ35053          170220    [Porting the fix from patch 8 to Xstore 6.0] [PROD] Difficulty determining which gift card option to pick without associated item number
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ36625          260620    [New Requirement] Customer Information Pinpad Verification
 * BZ39446          171120    [TASK] Not need to required the customer for Roundup transaction
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ45902          250821    [Internal] Exception after call Prompting Engine Catalyst API when an Electric World order is completed
 * BZ44971          150921    [New Requirement] IDS Payment Integration with Xstore
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 * BZ46879          221021    Xstore Patch 16 Receipt Issues
 * BZ42019          171121    Replace QAS with EAVS2
 * BZ45156          030821    [PROD] Update Miraserv auth request to include recurring payment indicator
 * BZ42307          221121    [Requirement] Add ability to reject at the item level for BOPIS
 * BZ47542          061221    RV Service Payments - Property Names
 * BZ46743          050122    Vehicle Identification Number (VIN) Capture for Xstore
 * BZ47123          050122    [PROD] Order Service Token Error
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction  
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 * BZ48564          150422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 * BZ50032          250522    [Task] Loyalty - Using Oauth2 security to access the new service
 * BZ48749          060122    [PROD] Issues in xStore vs DW sales report
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 * BZ53459          101122    [UAT] Accounts tab display multiple GSAM records with same points balance and redeemable points
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 * BZ55978          290323    Loyalty Issue: Java Null Pointer
 * BZ57844          080823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58779          110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added. 
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ62036          040324    [Task] - Suspend and Resume transaction.
 * BZ65612          260724    AGMOD Update to Membership SKU New Requirements
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.common;

import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstDataActionKey;

/**
 * Define common constants used for all functions
 */
public class CawConstants {

    public static final String            DECLINED                         = "DECLINED";

    /*String type used in _p tables*/
    public static final String            PROP_STRING_TYPE                 = "STRING";

    public static final String            CATALYST_CUSTOMER_IDENTIFY       = "CATALYST_CUSTOMER_IDENTIFY";

    /* BZ23477 added */
    public static final String            ESB_QUEUE_ONLINE_STATUS          = "ESB_QUEUE";
    
    public static final String            ESB_QUEUE_ONLINE_STATUS_2        = "ESB_QUEUE_2"; //BZ48564

    public static final String            BUSY_STATE_MSG                   = "Processing...";

    public static final String            STAR_SIGN                        = "*".intern();

    public static final String            NEW_LINE_SIGN                    = "\n".intern();

    public static final String            SEMICOLON_SIGN                   = ";".intern();

    public static final String            EMPTY_SIGN                       = "".intern();

    public static final String            VERTICAL_BAR_SIGN                = "|";                           /*BZ28546*/

    // Begin BZ26575
    public static final String            NOTIFY                           = "NOTIFY";

    public static final String            CONFIRM                          = "CONFIRM";

    public static final String            NOT_DISPAY                       = "NOT_DISPAY";

    public static final String            MULTIPLE_DISPAY                  = "MULTIPLE_DISPAY";

    public static final String            QAS_OFFLINE                      = "QAS_OFFLINE";

    public static final String            QAS_NOTFOUND                     = "QAS_NOTFOUND";

    public static final String            QAS_APPLIED                      = "QAS_APPLIED";
    
    public static final String            HISTORY_PURCHASE                 = "HISTORY_PURCHASE";            /*BZ28036*/

    // End BZ26575
    // BZ26289 start
    public static final String            CUST_TAX_EXEMPT_YES              = "Yes";

    public static final String            CUST_TAX_EXEMPT_NO               = "No";
    /*BEGIN BZ27535*/
    public static final String            REASON_TYPCODE                   = "TAX_EXEMPT";

    public static final String            PROPERTY_CODE                    = "TAX_EXEMPT_REASON";
    /*END BZ27535*/

    public static final String            HOUSE_ACCOUNT_TYPE               = "HOUSE_ACCOUNT";
    // BZ26289 end

    public static final String            PROP_COUPON_CODE                 = "couponCode";

    /* BZ25958 added */
    public static final String            CARD_IN_ACTIVE                   = "IN_ACTIVE";

    // Begin BZ26978
    public static final String            TRANSACTION_TYPE_ACTIVATION      = "Activation";

    public static final String            TRANSACTION_TYPE_ISSUE           = "Issue";

    public static final String            TRANSACTION_TYPE_RELOAD          = "Reload";

    public static final String            TRANSACTION_TYPE_REDEEM          = "Redeem";

    public static final String            TRANSACTION_TYPE_CASH_OUT        = "Cash out";

    public static final String            TRANSACTION_TYPE_REDEMPTION      = "Redemption";
    // End BZ26978

    /* BZ26851 added */
    public static final String            MAX_DISCOUNT_CONS                = "9999999.99";

    /*BZ27247 added */
    public static final String            ITM_GC_RELOAD_ID                 = "GC RELOAD";

    public static final String            ITM_GC_RELOAD_DESC               = "Gift Card Reload";

    public static final String            RETURN_REASON_TYPE_CODE          = "RETURN";                      // BZ27334

    public static final String            DEFAULT_CONSTANT                 = "DEFAULT";                     //BZ27342: added constant

    // Begin BZ27028
    public static final String            RETURN_PRODUCT_RECEIPT           = "RETURN_PRODUCT_RECEIPT";

    public static final String            DISCOUNT_REASON_TYPE_CODE        = "DISCOUNT";

    public static final String            ENTER_COUPON_CODE                = "ENTER_COUPON_CODE";
    // End BZ27028

    // BZ27339 start
    public static final String            OPEN                             = "OPEN";

    // BZ27339 end

    // Begin BZ27757
    /**
     * The ITEM_GC_RELOAD
     */
    public static final String            ITEM_GC_RELOAD                   = "GC RELOAD";

    /**
     * The CARD_ACTIVE
     */
    public static final String            CARD_ACTIVE                      = "CARD_ACTIVE";

    /**
     * The NON_PHYSICAL_ITEM_TYPE_VOUCHER
     */
    public static final String            NON_PHYSICAL_ITEM_TYPE_VOUCHER   = "VOUCHER";
    // End BZ27757

    public static final String            MM_DD_YYYY                       = "MM/dd/yyyy";

    public static final String            NULL_TEXT                        = "null";

    public static final String            UNDEFINED_TEXT                   = "undefined";

    //Begin BZ27712: constant for property code-line item property
    public static final String            WO_CODE                          = "WA";                          /*BZ29205*/

    public static final String            DATE_TIME_FORMAT_NOSPACE         = "MMddyyyyhhmmssaa";
    //End BZ27712

    /**
     * The THIRD_PARTY BZ27813 added
     */
    public static final String            THIRD_PARTY                      = "THIRD_PARTY";

    //Begin BZ27922
    public static final String            REFUND_TENDER_CONFIG             = "CawRefundTenderConfig";

    public static final String            RETURN_WEB_ORDER                 = "RETURN_WEB_ORDER";
    //End BZ27922

    /* Begin BZ28265 */
    /**
     * The CARD_SEVICES
     */
    public static final String            CARD_SEVICES                     = "ON";

    /**
     * The CAW_TURN_ON_CARD_SERVICES
     */
    public static final String            CAW_TURN_ON_CARD_SERVICES        = "CAW_TURN_ON_CARD_SERVICES";

    /**
     * The PROMPTING_ENGINE
     */
    public static final String            PROMPTING_ENGINE                 = "ON";

    /**
     * The CAW_TURN_ON_PROMPTING_ENGINE
     */
    public static final String            CAW_TURN_ON_PROMPTING_ENGINE     = "CAW_TURN_ON_PROMPTING_ENGINE";

    /**
     * The OLPS_TYPE
     */
    public static final String            OLPS_TYPE                        = "type";

    /**
     * The OLPS_PROPERTIES
     */
    public static final String            OLPS_PROPERTIES                  = "properties";

    /**
     * The OLPS_PRESCREEN_ID
     */
    public static final String            OLPS_PRESCREEN_ID                = "olpsPrescreenID";

    /* End BZ28265 */

    /* Begin BZ28567 */
    public static final String            VALUE_4                          = "4";

    public static final String            VALUE_1                          = "1";
    /* End BZ28567 */

    // Begin BZ25761
    public static final String            HOME                             = "HOME";

    public static final String            MOBILE                           = "MOBILE";

    public static final String            COMMA_SIGN                       = ", ";

    public static final String            SPACE_SIGN                       = " ";

    public static final String            WAIT_FOR_SIGCAP                  = "Waiting for Sigcap input";

    public static final String            FORM_STATE                       = "FORM_STATE";

    public static final String            VISA_SHORT                       = "VI";                          /*BZ28741: changed VISA to VISA_SHORT*/

    public static final String            PLCC_SHORT                       = "PL";                          /*BZ28741: changed VISA to VISA_SHORT*/
    // End BZ25761

    /* Begin BZ28741*/
    public static final String            CARD_TYPE                        = "CARDTYPE:";

    public static final String            VISA_LONG                        = "VISA";

    public static final String            PLCC_LONG                        = "PLCC";

    public static final String            UNDERSCORE_SIGN                  = "_";

    public static final String            SELECTED                         = "SELECTED:";

    public static final String            YES_CONSTANT                     = "YES";

    public static final String            NO_CONSTANT                      = "NO";

    public static final String            GOODSAM_CARD_APPLY               = "GOODSAM_CARD_APPLY";
    /* End BZ28741*/

    /* Begin BZ28626
    /**
     * The CAW_CAT_INPUT_OPTIONAL_FIELD
     */
    public static final String            CAW_CAT_INPUT_OPTIONAL_FIELD     = "CAW_CAT_INPUT_OPTIONAL_FIELD";
    /* End BZ28626*/

    /* BEGIN BZ28247 */
    /**
     * The CARD_TYPE_DESCRIPTION
     */
    public static final String            CARD_TYPE_DESCRIPTION            = "Visa";

    /**
     * The CARD_TYPE_NOT_SPECIFIED
     */
    public static final String            CARD_TYPE_NOT_SPECIFIED          = "NotSpecified";

    /**
     * The VALUE_0
     */
    public static final String            VALUE_0                          = "0";
    
    /**
     * The VALUE_0
     */
    public static final String            VALUE_NO                          = "no";

    /**
     * The VALUE_2
     */
    public static final String            VALUE_2                          = "2";

    /**
     * The PRESCREEN_ACCEPT
     */
    public static final String            PRESCREEN_ACCEPT                 = "PrescreenAccept";

    /**
     * The INSTANT_CREDIT
     */
    public static final String            INSTANT_CREDIT                   = "InstantCredit";

    /**
     * The APPPROVED
     */
    public static final String            APPPROVED                        = "Approved";

    /**
     * The RESPONSE_DECLINED
     */
    public static final String            RESPONSE_DECLINED                = "Declined";

    /**
     * The OTHER
     */
    public static final String            OTHER                            = "Other";
    /* END BZ28247 */

    /* BEGIN BZ28853 */

    /**
     * The PHONE
     */
    public static final String            PHONE                            = "phones";

    /**
     * The MOBILE_PHONE
     */
    public static final String            MOBILE_PHONE                     = "MOBILE";

    /**
     * The PHONE_NUMBER
     */
    public static final String            PHONE_NUMBER                     = "number";

    /* END BZ28853 */

    public static final String            CAW_REGEX_REPLACE                = "(?i)";                        /*BZ28859*/

    /* BEGIN BZ29124 */
    public static final String            AR_ACCOUNT                       = "AR_ACCOUNT";
    /* END BZ29124 */

    public static final String            WOP_PREFIX                       = "WP";                          /*BZ29205*/

    public static final int               CAW_THREE_FAILED_ATTEMPTS_SSN    = 2;                             /*BZ29134*/
    /* BEGIN BZ29280 */
    /**
     * The RETURN_CODE
     */
    public static final String            RETURN_CODE                      = "returnCode";

    /**
     * The ERROR_MESSAGE
     */
    public static final String            ERROR_MESSAGE                    = "errorMessage";

    public static final String            PRESCREEN_ACCEPTANCE             = "prescreenAcceptance";

    /**
     * The ACCOUNT_ID
     */
    public static final String            ACCOUNT_ID                       = "accountId";

    /**
     * The APPLICATION_ID
     */
    public static final String            APPLICATION_ID                   = "applicationId";

    /**
     * The CREDIT_LIMIT
     */
    public static final String            CREDIT_LIMIT                     = "creditLimit";

    /**
     * The APR
     */
    public static final String            APR                              = "apr";

    /**
     * The VIRTUAL_CARD
     */
    public static final String            VIRTUAL_CARD                     = "virtualCard";

    /**
     * The DEFAULT_VIRTUAL_CREDIT_LIMIT
     */
    public static final String            DEFAULT_VIRTUAL_CREDIT_LIMIT     = "0";

    /**
     * The EXPIRATION_DATE
     */
    public static final String            EXPIRATION_DATE                  = "expirationDate";

    /**
     * The JSON_INSTANT_CREDIT
     */
    public static final String            JSON_INSTANT_CREDIT              = "instantCredit";               //BZ29280

    /* END BZ29280 */
    /* BEGIN BZ29387 */
    public static final String            ACCOUNT_ID_LABEL                 = "Account ID: ";

    public static final String            GS_ACCOUNT_PAYMENT               = "GS Account Payment";

    public static final String            CAW_MARKED_PAN                   = "************";

    public static final String            CAW_TRANSACTION_TYPE             = "CAW_TRANSACTION_TYPE";

    public static final String            ACCOUNT_PAYMENT                  = "ACCOUNT_PAYMENT";

    public static final String            ITEM_AR_PAYMENT                  = "AR_PAYMENT";
    /* END BZ29387 */
    /* BEGIN BZ27973 */
    public static final String            CAW_ACCOUNTID                    = "ACCOUNTID";

    public static final String            CAW_BALANCEAMOUNT                = "BALANCEAMOUNT";

    public static final String            CAW_CARDTYPE                     = "CARDTYPE";

    public static final String            CAW_CARDMASK                     = "CARDMASK";

    public static final String            CAW_ACCOUNT_SUMMARIES            = "accountSummaries";

    public static final String            CAW_ACCOUNT_SUMMARY              = "accountSummary";

    public static final String            CAW_ADDRESS1_LOWCASE             = "address1";

    public static final String            CAW_ADDRESS1_UPCASE              = "ADDRESS1";

    public static final String            CAW_STATE_LOWCASE                = "state";

    public static final String            CAW_STATE_UPCASE                 = "STATE";

    public static final String            CAW_ZIPCODE_LOWCASE              = "zipCode";

    public static final String            CAW_ZIPCODE_UPCASE               = "ZIPCODE";

    public static final String            CAW_CITY_UPCASE                  = "CITY";

    /* END BZ27973 */
    /* BEGIN BZ28012 */
    public static final String            CAW_APP_STATUS_RETRY_TIMES       = "CAW_APP_STATUS_RETRY_TIMES";

    public static final String            CAW_ESB_QUEUE_PATH               = "CAW_ESB_QUEUE_PATH";

    public static final String            CAW_APPLICATION_STAUS            = "applicationstatus_";

    public static final String            CAW_UNDER_LINE                   = "_";

    public static final String            CAW_FILE_EXTENDTION              = ".0";

    public static final String            CAW_ERROR_FOLDER                 = "/error";

    /* END BZ28012 */

    public static final String            CAW_COLON_SIGN                   = ":";                           /*BZ29514*/

    /* BEIGN BZ29454 */
    public static final String            VALUE_00                         = "0.00";

    public static final String            VALUE_0_PERCENT                  = "0.00%";
    /* END BZ29454 */

    /* BEGIN BZ29535 */
    public static final String            CAW_MINIMUM_PAYMENT_DUE          = "minimumPaymentDue";

    public static final String            CAW_PAYMENT_DUE_DATE             = "paymentDueDate";

    public static final String            CAW_ACCOUNT_SUMMARY_OTB          = "otb";
    /* END BZ29535 */

    /* BEGIN BZ29580 */
    public static final String            ACCOUNT_TERMINATED               = "ACCOUNT_TERMINATED";

    public static final String            LOGIN_IS_LOCKED                  = "LOGIN_IS_LOCKED";

    public static final String            LOGIN_IS_TERMINATED              = "LOGIN_IS_TERMINATED";
    /* END BZ29580 */

    public static final String            PERCENT                          = "%";                           //BZ29619

    public static final IXstDataActionKey PRESSING_BACK                    = XstDataActionKey
            .valueOf("PRESSING_BACK");                                                                      /*BZ29683*/

    /* BEGIN BZ29625 */
    public static final String            CAW_ITM_MESS                     = "CAW_ITM_MESS";

    public static final String            CAW_ITM_MSG_REF                  = "CAW_ITM_MSG_REF";

    public static final String            CAW_ITM_MSG_FOR_CASHIER          = "CASHIER";

    public static final String            CAW_ITM_MSG_FOR_BOTH             = "BOTH";

    public static final String            CAW_ITM_MSG_FOR_RECEIPT          = "RECEIPT";

    public static final String            CAW_ITM_LINE_ITEM_SALE_TYPE_CODE = "Sale";
    /* END BZ29625 */

    public static final String            CAW_ALLOW_MULTIPLE_DEAL          = "ALLOW_MULTIPLE";              /*BZ28014*/

    /*BEGIN BZ30922*/
    public static final String            CAW_INV_LOOKUP_MAX_RESULTS       = "CAW_INV_LOOKUP_MAX_RESULTS";

    public static final String            CAW_INVENTORY_RADIUS             = "CAW_INVENTORY_LOOKUP_RADIUS";

    public static final String            CAW_MILES                        = "Miles";
    /*END BZ30922*/

    /*BEGIN BZ32123*/
    public static final String            CAW_STRING_EMPTY                 = "";
    /*END BZ32123*/
    
    /*BEGIN BZ33137*/
    public static final String            LOGIN_EMPLOYEE_INACTIVE           = "LOGIN_EMPLOYEE_INACTIVE";
    public static final String            EMPLOYEE_INACTIVE                 = "EMPLOYEE_INACTIVE";
    /*END BZ33137*/
    
    /* BEGIN BZ33231 */
    /**
     * The CAW_TURN_ON_PROMPTING_ENGINE
     */
    public static final String            CAW_TURN_ON_PE_BEGIN             = "CAW_TURN_ON_PE_BEGIN";

    public static final String            CAW_TURN_ON_PE_ADD               = "CAW_TURN_ON_PE_ADD";

    public static final String            CAW_TURN_ON_PE_TOTAL             = "CAW_TURN_ON_PE_TOTAL";
    /* END BZ33231 */
    
    /* BEGIN BZ33595 */
    public static final String            CAW_FIELD_LOYALTY_NUMBER         = "loyaltyNumber";

    public static final String            CAW_BARCODE_SCANNER              = "BARCODE_SCANNER";

    public static final String            CAW_SCANNER_TAG                  = "scanner";

    public static final String            CAW_SCANNER_MODELNUMBER          = "modelnumber";

    public static final String            CAW_SCANNERID                    = "scannerID";
    /* END BZ33595 */

    /* BEGIN BZ35053 */
    public static final String            CAW_GIFT_CARD                    = "GIFT_CARD";

    public static final String            CAW_ISSUE_XPAY_GIFT_CARD         = "CAW_ISSUE_XPAY_GIFT_CARD";
    /* END BZ35053 */
    /*BEGIN BZ36625*/
    public static final String            CAW_VERIFY_DEFAULT_TIME_OUT                = "60";

    public static final int               CAW_VERIFY_CUSTOMER_NO                     = -1;

    public static final int               CAW_VERIFY_CUSTOMER_YES                    = 1;

    public static final String            CAW_CUSTOMER_VERIFICATION_TIMEOUT          = "caw.customer.verification.timeout";
    /*END BZ36625*/

    public static final String            CAW_CAT_NOT_REQUIRED_CUSTOMER    = "CAW_CAT_NOT_REQUIRED_CUSTOMER"; // BZ-39446
    
    /*BEGIN BZ33319*/
    public static final String            CAW_STRING_SPACE                  = " ";

    public static final String            CAW_STRING_COMMA                  = ",";
    /*END BZ33319*/
    
    /* BEGIN BZ44528 */
    public static final String            DD_MM_YYYY                        = "dd/MM/yyyy";
    
    public static final String            YYYY_MM_DD_DASH                   = "yyyy-MM-dd";
    
    public static final String            WONDERSIGN_CART_ID                = "WONDERSIGN_CART_ID";
    /* END BZ44528 */
    
    /* BEGIN BZ45902 */
    public static final String            BROKERED_ORDER_STANDARD_PICKUP    = "STANDARD_PICKUP";

    public static final String            BROKERED_ORDER_STANDARD_DELIVERY  = "STANDARD_DELIVERY";

    public static final String            OB_SHIP_TO_CUSTOMER               = "ShipToCustomer";

    public static final String            OB_PICKUP_IN_STORE                = "PickupInStore";

    public static final String            FULL_FILL_SYSTEM_DES              = "XSTORE";
    /* BEGIN BZ45902 */
    
    /* BEGIN BZ47542 */
    public static final String            RV_SERVICE_PAYMENT_PROPERTIES     = "RV_SERVICE_PAYMENT_PROPERTIES";
    /* END BZ47542 */
    
    /* BEGIN BZ45995 */
    public static final String            QUESTION_MARK_STRING                 = "?";

    public static final String            EQUAL_STRING                         = "=";
    
    public static final String            LOCALE_DEFAULT                       = "DEFAULT";

    public static final String            MEMBERSHIP_EMAIL_PROMPT_TITLE_PREFIX = "+CAW_MEMBERSHIP_EMAIL_PROMPT_TITLE_";
    
    public static final String            MEMBERSHIP_EMAIL_PROMPT_MSG_PREFIX   = "+CAW_MEMBERSHIP_EMAIL_PROMPT_MSG_";

    public static final String            CAW_NO_THANKS_EMAIL                  = "CAW_NO_THANKS_EMAIL";

    public static final String            CAW_NO_THANKS_EMAIL_CODE             = "ON";
    /* END BZ45995 */
    
    /*BEGIN BZ46879*/
    public static final String            CAW_ORDER_LINE_UNAVAILABLE           = "UNAVAILABLE";

    public static final String            CAW_ORDER_TYPE                       = "CAW_ORDER_TYPE";
    /*END BZ46879*/
    
    /* BEGIN BZ42019 */
    public static final String            US                                   = "US";

    public static final String            CA                                   = "CA";
    /* END BZ42019 */
    /*BEGIN BZ45156*/
    public static final String            CAW_RECURRING_PAYMENT_ENABLE         = "CAW_RECURRING_PAYMENT_ENABLE";

    public static final String            CAW_KIOSK_ORDER_ENABLE               = "CAW_KIOSK_ORDER_ENABLE";

    public static final String            CAW_RV_PAYMENT_ENABLE                = "CAW_RV_PAYMENT_ENABLE";

    public static final String            CAW_MEM_EMAIL_CAPTURE_ENABLE         = "CAW_MEM_EMAIL_CAPTURE_ENABLE";
    
    public static final String            TRUE_STRING                          = "true";
    /*END BZ45156*/
    
    /* BEGIN BZ42307 - Partial Cancel */
    public static final String            CAW_ORDER_LINE_CANCELLED             = "CANCELLED";
    public static final String            CAW_DISALLOW_RECEIPT_ORDER_SUMMARY_REFUND_AMOUNT = "caw.dissalow.receipt.order.summary.refund.amount";
    public static final String            CAW_REFUND_CONSTANT                  = "REFUND";
    
    public static final String            CAW_ORDER_BROKER_MAPPING_VALUE       = "{requesting_system_line_no:{0},line_no:{1}}";
    public static final String            CAW_OB_MAPPING_LINE                  = "CAW_ORDER_BROKER_MAPPING_LINE";

    public static final String            CAW_OB_LINE_NO                       = "line_no";

    public static final String            CAW_OB_REQUESTING_SYSTEM_LINE_NO     = "requesting_system_line_no";
    /* END BZ42307 - Partial Cancel */
    
    /* BEGIN BZ46743 */
    public static final String            CAW_VEHICLE_IDENTIFICATION_NUMBER    = "VIN";
    public static final String            CAW_VIN_VERIFICATION_CHAIN_NAME      = "CAW_VIN_VERIFY";
    /* END BZ46743 */
    
    public static final String            CAW_DISPLAY_CUSTOMER                 = "DISPLAY_CUSTOMER";/*BZ47123*/
    
    public static final String            CAW_LOYALTY_POINTS                   = "CAW_LOYALTY_POINTS"; //BZ48629
    //Start BZ50032
    public static final String            CAW_AUTHORIZATION                    = "authorization";
    
    public static final String            CAW_TOKEN_TYPE                       = "token_type";
    
    public static final String            CAW_ACCESS_TOKEN                     = "access_token";
    
    public static final String            CAW_TOKEN_EXPIRES_IN                 = "expires_in";
    
    public static final String            CAW_TOKEN_EXPIRED_TIME_FORMAT        = "yyyy-MM-dd HH:mm:ss";
    //End BZ50032
    
    public static final String            IS_WO_ITEM                           = "IS_WO_ITEM"; //BZ48749
    
    public static final String            CAW_LOYALTY_POINTS_INFORMATION       = "CAW_LOYALTY_POINTS_INFORMATION"; //BZ52876
    
    /* BEGIN BZ53459*/
    public static final String           LOYALTY_MEMBERSHIP_REDEEMABLE_VALUE   = "LOYALTY_REDEEMABLE";
    public static final String           LOYALTY_MEMBERSHIP_POINTS_BALANCE     = "LOYALTY_POINTS_BALANCE";
    public static final String           LOYALTY_MEMBERSHIP                    = "LOYALTY_MEMBERSHIP";
    /* END BZ53459*/
    
    //BEGIN BZ53752
    public static final String           P_CODE_SALES_ORD_INF                  = "SALESORDERINFORMATION";
    
    public static final String           COUPONCODEDEFAULT                     = "1111";
    public static final String           CLUB_CODE                             = "CLUB";

    public static final String           WHOLESALE_CODE                        = "WHSL";

    public static final String           CREW_CODE                             = "CREW";
    
    public static final String           CLUB_VALUE                             = "1111";

    public static final String           WHOLESALE_VALUE                        = "1111";

    public static final String           CREW_VALUE                             = "1111";
    //END BZ53752
    
    /* BEGIN BZ55978 */
    public static final int            TRANSACTION_PROPERTY_MAX_LENGTH          = 4000;
    /* END BZ55978 */
    
    /* BEGIN BZ57844 */
    public static final String            CAW_BACK_BUTTON                       = "_cawBACK";

    public static final String            CAW_OK_BUTTON                         = "_cawOK";

    public static final String            CAW_PLCC_OR_GSVISA_NOT_FOUND          = "CAW_PLCC_OR_GSVISA_NOT_FOUND";

    public static final String            CAW_PLCC_OR_GSVISA_CANCEL             = "CAW_PLCC_OR_GSVISA_CANCEL";
    /* END BZ57844 */
    
    /* BEGIN BZ58779 */
    public static final String            CAW_RENEWAL_GS_MEMBERSHIP_SKU         = "CAW_RENEWAL_GS_MEMBERSHIP_SKU";
    
    public static final String            CAW_NEW_GS_MEMBERSHIP_SKU             = "CAW_NEW_GS_MEMBERSHIP_SKU";
    /* END BZ58779 */
    
    /* BEGIN BZ61159 */
    public static final String            CAW_AGIS_PITCHES_TITLE                = "_cawAGISPitchesTitle";

    public static final String            CAW_AGIS_PITCHES_MSG                  = "_cawAGISPitchesMsg";

    public static final String            CAW_ITEM_ID_FIELD                     = "itemId_";

    public static final String            CAW_ITEM_NAME_FIELD                   = "itemName_";
    
    public static final String            CAW_ITEM_DESCRIPTION_FIELD            = "description_";

    public static final String            CAW_ITEM_PRICE_FIELD                  = "price_";

    public static final String            CAW_ACCEPT_FIELD                      = "accept_";

    public static final String            CAW_DECLINE_FIELD                     = "decline_";
    
    public static final String            CAW_AUTO_RENEW_FIELD                  = "autoRenew_";//BZ62146

    public static final String            CAW_AGIS_PITCHES_FORM                 = "CAW_AGIS_PITCHES";
    
    public static final String            CAW_TOTAL_POINTS_COULD_SAVED          = "CAW_TOTAL_POINTS_COULD_SAVED";
    
    public static final String            CAW_IS_TEMPOPARY_MEMBERSHIP_CARD      = "CAW_IS_TEMP_MEMBERSHIP_CARD";
    
    public static final String            CAW_QR_CODE_RECEIPT                   = "CAW_QR_CODE_RECEIPT";
    
    public static final String            CAW_ENABLE                            = "ENABLE";
    
    //BEGIN BZ62036
    public static final String            CAW_PRICING_INFO                      = "CAW_PRICING_INFO";
    
    public static final String            CAW_MEMBERSHIP_INFO                   = "CAW_MEMBERSHIP_INFO";
    //END BZ62036
    /* END BZ61159 */
    //BEGIN BZ65612
    public static final String            CAW_PITCHES_ITEM_LIST                 = "CAW_PITCHES_ITEM_LIST";
    //END BZ65612
    //BEGIN BZ69391,BZ69389,BZ69389
    public static final String            CAW_MEMBERSHIP_OPTION_CODE            = "MEMBERSHIP";
    public static final String            CAW_MEMBERSHIP_OPTION_DES             = "_cawMembershipSelectionOption";
    public static final String            CAW_NOTHANKS_OPTION_CODE              = "NOTHANKS";
    public static final String            CAW_NOTHANKS_OPTION_DES               = "_cawNoThanksOption";
    //END BZ69391,BZ69389,BZ69389
}
