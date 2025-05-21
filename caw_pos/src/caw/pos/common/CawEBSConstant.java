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
 * Req/Bug ID#          ddMMyy    Description
 * INT-020              120417    EMV
 * INT-92               260817    Customer Integration
 * BZ23052              120917    Implement Advanced Prompting
 * BZ23478              200917    [Prompting] Update Catalyst = 1 request
 * BZ23976              121017    Need to send the ADS result to CareTaker after the credit application completes
 * BZ24424              131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ24944              271217    Club Pricing information doesn't display on top banner when attached GS join for transaction in offline case
 * BZ25318              300118    Missing Club information on top banner when sale/return transaction in offlined case.
 * BZ26453              050618    [Internal] Membership Info of customer does not display at customer search prompt when searching the customer in offline status.
 * BZ26564              140618    [Internal] QAS search sent tag country incorrectly the address of customer which country is CAN
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26596              150618    [New Requirement] Add Associate detail to the Card Services Caretaker Call
 * BZ25435              160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ26207              190718    New Requirement - Enable Work Order Functionality
 * BZ28265              261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28556              071218    [Internal[28265]PromptResultResponse from Neuron should return 'null' value in case choosing skip options: No,Thanks which has "isCallbackRequired": true
 * BZ28247              111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28907              020119    [internal] Missing 'Retail pricing' text and logo on Top banner once join RA item in offline case
 * BZ29326              130219    Card Service 2 - Read the makeCreditOffer atrribute from OLPS status call and make the credit offer if the flag is true
 * BZ30922              210619    [New Requirement] Price Check and Inventory Lookup
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ37023              120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37912              021020    Shipping Fee is being applied to the line item vs transaction level 
 * BZ37396              021020    Tax value calculation issue in Order transactions
 * BZ40898              290121    Prompting for memberships on OB orders
 * BZ40798              240221    Modification to member savings calculation
 * BZ44528              130821    Electric World & Mobile POS Implementation(Phase 1)
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ42019              171121    Replace QAS with EAVS2
 * BZ49929              120522    Loyalty - Need a configuration to determine which type of membership will be displayed the loyalty info on receipts
 * BZ49933              120522    Loyalty - Define a default reason code for Loyalty promotions that are applied to transaction
 * BZ52837              171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 * BZ57844              040823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ61159              190224    [New Requirement] - Xstore AGIS Replacement
 * BZ69691              210225    [AGIS Modification] The submitOrder response does not include information of “subscriberId” and “phoneNumber” in “attributes”
 *===================================================================
 */

package caw.pos.common;

/**
 * Define common constants used for EBS only
 */
public class CawEBSConstant {

    public static final String  CUSTOMER_SEARCH                                   = "CUSTOMER_SEARCH";

    public static final String  CUSTOMER_UPSERT                                   = "CUSTOMER_UPSERT";
    
    /* BEGIN BZ44528: Phase 1 */
    public static final String  CART_SEARCH                                       = "CART_SEARCH";
    /* END BZ44528: Phase 1 */
    
    /* BEGIN BZ42019 */
    public static final String  MAILING_ADDRESS_VALIDATE                          = "MAILING_ADDRESS_VALIDATE";
    /* BEGIN BZ42019 */

    public static final String  CUSTOMERS                                         = "customers";

    public static final String  CUSTOMER                                          = "CUSTOMER";

    public static final Long    ORGANIZATION_ID                                   = 1000L;

    public static final String  LOCATION_CODE                                     = "0001";

    public static final String  EBS_DATASOURCE                                    = "EBS Web Service";

    public static final String  MAXNUMBEROFCUSTOMERS                              = "MaxNumberOfCustomers";

    public static final String  USA                                               = "USA";

    public static final String  US                                                = "US";

    public static final String  CAN                                               = "CAN";

    public static final String  CA                                                = "CA";

    public static final String  ADDRESS_TYPE                                      = "1";

    public static final String  SSL                                               = "SSL";

    public static final String  ALTERNATE_ID_OWNER                                = "EBS";

    public static final String  PARTY_SEQUENCE_ID                                 = "PARTY";

    public static final String  CUSTOMER_SEQUENCE_ID                              = "CUSTOMER";

    //Customer template
    public static final String  CUSTOMER_TEMPLATE_NAME_AUDIT                      = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_PREFIX                     = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_FIRST                      = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_MIDDLE                     = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_LAST                       = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_SUFFIX                     = null;

    public static final String  CUSTOMER_TEMPLATE_NAME_COMPANY                    = null;

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_AUDIT                   = null;

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_TYPE                    = "0";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_TYPE_DESCRIPTION        = "NotSpecified";

    public static final Boolean CUSTOMER_TEMPLATE_IS_DELIVERABLE                  = false;

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_LINE1                   = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_LINE2                   = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_LINE3                   = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_LINE4                   = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_CITY                    = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_STATE_PROVINCE          = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_POSTAL_CODE             = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_COUNTRY                 = "";

    public static final String  CUSTOMER_TEMPLATE_ADDRESS_COUNTY                  = null;

    public static final String  CUSTOMER_TEMPLATE_MEMBERSHIPS                     = null;

    public static final String  CUSTOMER_TEMPLATE_PHONES                          = null;

    public static final String  CUSTOMER_TEMPLATE_PARTNERS                        = null;

    public static final Integer CUSTOMER_TEMPLATE_PRICE_IDENTIFIER                = 3;

    public static final String  CUSTOMER_TEMPLATE_PRICE_BAND                      = "RETAIL";

    public static final String  CUSTOMER_TEMPLATE_PRICE_DESCRIPTION               = "REG. PRICE";

    public static final String  CUSTOMER_TEMPLATE_PRICE_COMPARE_BAND              = "CLUB";

    public static final Integer CUSTOMER_TEMPLATE_PRICE_COMPARE_BAND_ID           = 24;

    public static final String  CUSTOMER_TEMPLATE_PRICE_MEMBERSHIP                = null;

    public static final Long    CUSTOMER_TEMPLATE_ACCOUNT_NUMBER                  = 0L;

    public static final Integer CUSTOMER_TEMPLATE_ACCOUNT_STATUS                  = 0;

    public static final String  CUSTOMER_TEMPLATE_ACCOUNT_STATUS_DESCRIPTION      = "Active";

    public static final Integer CUSTOMER_TEMPLATE_CUSTOMER_TYPE                   = 0;

    public static final String  CUSTOMER_TEMPLATE_ACXIOMIDENTIFIERS               = null;

    public static final Boolean CUSTOMER_TEMPLATE_ALLOW_EDIT                      = true;

    public static final String  CUSTOMER_TEMPLATE_EMAIL_ADDRESS                   = "";

    public static final Integer CUSTOMER_TEMPLATE_RVTYPE                          = 0;

    public static final String  CUSTOMER_TEMPLATE_RVTYPE_DESCRIPTION              = "NotSpecified";

    public static final Boolean CUSTOMER_TEMPLATE_IS_TAXEXEMPT                    = false;

    public static final String  CUSTOMER_TEMPLATE_TAX_CERTIFICATE                 = null;

    public static final Boolean CUSTOMER_TEMPLATE_ARINFO_IS_AR_CREDIT_HOLD        = false;

    public static final String  CUSTOMER_TEMPLATE_ARINFO_AVAILABLE_BALANCE        = "0";

    public static final String  CUSTOMER_TEMPLATE_ARINFO_LAST_PAYMENT             = "";

    public static final String  CUSTOMER_TEMPLATE_LAST_UPDATE_USER                = null;

    public static final String  CUSTOMER_TEMPLATE_LAST_UPDATE_SYSTEM              = "CAWXSTORE";

    public static final String  CUSTOMER_TEMPLATE_LAST_UPDATE_DATE                = "0001-01-01T00:00:00";

    public static final String  CUSTOMER_TEMPLATE_FEED                            = null;

    public static final Integer CUSTOMER_TEMPLATE_CRUD                            = 0;

    public static final String  CUSTOMER_TEMPLATE_CRUD_DESCRIPTION                = "NotSpecified";

    public static final String  CUSTOMER_TEMPLATE_ATTRIBUTES                      = null;

    public static final String  ORGANIZATION_NAME_FIELD                           = "organizationName";

    public static final String  NOT_FOUND_ERROR                                   = "404 Not Found";

    // Begin BZ23596
    public static final String  SALE_CHANNEL_TYPE_RETAIL                          = "1"; /* BZ-37642 */

    public static final String  PRESCREEN_ID_YES                                  = "1";

    public static final String  PRESCREEN_ID_NO                                   = "2";

    public static final String  PRESCREEN_ID_NOTPRE                               = "4";

    public static final String  PRESCREEN_ID_NOTPRI                               = "3";

    public static final String  NOTIFICATION_INCATOR_POS                          = "6";
    // End BZ23596

    // Begin BZ23052
    public static final String  CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR           = "CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR";

    public static final String  CATALYST_REQUEST_TRANSACTION_EMPLOYEE_ATTR        = "CATALYST_REQUEST_TRANSACTION_EMPLOYEE_ATTR";

    public static final String  CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR        = "CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR";

    public static final String  REQUEST_AUDIT_ATTR                                = "REQUEST_AUDIT_ATTR";

    public static final String  REQUEST_NAME_ATTR                                 = "REQUEST_NAME_ATTR";

    public static final String  REQUEST_ADDRESS_ATTR                              = "REQUEST_ADDRESS_ATTR";

    public static final String  REQUEST_MEMBERSHIPS_ALERTS_ATTR                   = "REQUEST_MEMBERSHIPS_ALERTS_ATTR";

    public static final String  REQUEST_MEMBERSHIPS_ATTR                          = "REQUEST_MEMBERSHIPS_ATTR";

    public static final String  REQUEST_PHONES_ATTR                               = "REQUEST_PHONES_ATTR";

    public static final String  REQUEST_PARTNERS_ATTR                             = "REQUEST_PARTNERS_ATTR";

    public static final String  REQUEST_PRICING_ATTR                              = "REQUEST_PRICING_ATTR";

    public static final String  REQUEST_CHOICES_ATTR                              = "REQUEST_CHOICES_ATTR";

    public static final String  REQUEST_PREFERENCES_ATTR                          = "REQUEST_PREFERENCES_ATTR";

    public static final String  REQUEST_CUSTOMER_ATTR                             = "REQUEST_CUSTOMER_ATTR";

    public static final String  REQUEST_THIRDPARTYPAYER_ATTR                      = "REQUEST_THIRDPARTYPAYER_ATTR";

    public static final String  REQUEST_PROMPTS_ATTR                              = "REQUEST_PROMPTS_ATTR";

    public static final String  REQUEST_DISCOUNTS_ATTR                            = "REQUEST_DISCOUNTS_ATTR";

    public static final String  REQUEST_SALESPERSON_ATTR                          = "REQUEST_SALESPERSON_ATTR";

    public static final String  REQUEST_BUYER_ATTR                                = "REQUEST_BUYER_ATTR";

    public static final String  REQUEST_TIEM_PRICING_ATTR                         = "REQUEST_TIEM_PRICING_ATTR";

    public static final String  REQUEST_VENDOR_ATTR                               = "REQUEST_VENDOR_ATTR";

    public static final String  REQUEST_ITEMS_ATTR                                = "REQUEST_ITEMS_ATTR";

    public static final String  REQUEST_INVOICES_ATTR                             = "REQUEST_INVOICES_ATTR";

    public static final String  REQUEST_PAYMENTS_ATTR                             = "REQUEST_PAYMENTS_ATTR";

    public static final String  REQUEST_TAXES_ATTR                                = "REQUEST_TAXES_ATTR";

    public static final String  REQUEST_PAIDINOUTDETAIL_ATTR                      = "REQUEST_PAIDINOUTDETAIL_ATTR";

    public static final String  REQUEST_ERECEIPTDETAIL_ATTR                       = "REQUEST_ERECEIPTDETAIL_ATTR";

    public static final String  REQUEST_ORACLEDETAIL_ATTR                         = "REQUEST_ORACLEDETAIL_ATTR";

    public static final String  RESULT_CHOICES_ATTR                               = "RESULT_CHOICES_ATTR";
    
    public static final String  REQUEST_BROKER_ITEM_DETAIL_ATTR                   = "REQUEST_BROKER_ITEM_DETAIL_ATTR";/*BZ40898*/
    // catalyst template response
    public static final String  CATALYST_DIRECTIVES_TYPE                          = "directives";

    public static final String  CATALYST_INPUT_TYPE                               = "inputs";

    public static final String  CATALYST_MESSAGES_TYPE                            = "messages";

    public static final String  TYPE_ATTR                                         = "type";

    public static final String  LABEL_ATTR                                        = "label";

    public static final String  DESCRIPTION_ATTR                                  = "description";

    public static final String  CATALYST_LONG_MESSAGES_TYPE                       = "0";

    public static final String  CATALYST_INFORMATION_MESSAGES_TYPE                = "0";

    public static final String  CATALYST_WARNING_MESSAGES_TYPE                    = "1";

    public static final String  CATALYST_CRITICAL_MESSAGES_TYPE                   = "2";

    public static final String  CATALYST_MESSAGES_TEXT_ATTR                       = "text";

    public static final String  PROPERTIES_ATTR                                   = "properties";

    public static final String  LINENUMBER_ATTR                                   = "lineNumber";
    // End BZ23052

    public static final String  OBJECT_PROPERTIES_ATTR                            = "OBJECT_PROPERTIES_ATTR";                           //BZ23478

    public static final String  ARRAY_INPUTS_ATTR                                 = "ARRAY_INPUTS_ATTR";

    public static final String  TRANSACTION_PROPERTIES_TYPE_STRING                = "STRING";

    public static final String  PROMPTING_ENGINE_CATALYST_ONE                     = "CATALYST_ONE";

    public static final String  PROMPTING_ENGINE_CATALYST_FOUR                    = "CATALYST_FOUR";

    public static final String  PROMPTING_ENGINE_CATALYST_RESULT                  = "CATALYST_RESULT";

    public static final String  PROMPTING_ENGINE_CATALYST_INPUT                   = "CATALYST_INUPT";
    /* BEGIN BZ28247 */
    /**
     * The GOODSAM_VISA_CARE_TAKER_TEMPLATE
     */
    public static final String  GOODSAM_VISA_CARE_TAKER_TEMPLATE               = "GOODSAM_VISA_CARE_TAKER_TEMPLATE";

    /**
     * The ATR_ADSRESPONSE_TEMPLETE_PRESCREEN
     */
    public static final String  ATR_ADSRESPONSE_TEMPLETE_PRESCREEN             = "ATR_ADSRESPONSE_TEMPLETE_PRESCREEN";

    /**
     * The ATR_ADSRESPONSE_TEMPLETE_INSTANT
     */
    public static final String  ATR_ADSRESPONSE_TEMPLETE_INSTANT              = "ATR_ADSRESPONSE_TEMPLETE_INSTANT";
    /* END BZ28247 */
    public static final String  GOODSAM_VISA_CARE_TAKER_CUSTOMER_ADDRESS_TEMPLATE = "GOODSAM_VISA_CARE_TAKER_CUSTOMER_ADDRESS_TEMPLATE";

    public static final String  GOODSAM_VISA_CARE_TAKER_CUSTOMER_NAME_TEMPLATE    = "GOODSAM_VISA_CARE_TAKER_CUSTOMER_NAME_TEMPLATE";

    public static final String  GOODSAM_VISA_CARE_TAKER_CUSTOMER_TEMPLATE         = "GOODSAM_VISA_CARE_TAKER_CUSTOMER_TEMPLATE";
    // End BZ23976

    // Begin BZ24424
    public static final String  CUSTOMER_ATTR                                     = "customer";

    public static final String  MEMBERSHIPS_IDENTIFIER_ATTR                       = "identifier";

    public static final String  MEMBERSHIPS_TYPE_ATTR                             = "type";

    public static final String  MEMBERSHIPS_TYPE_DESCRIPTION_ATTR                 = "typeDescription";

    public static final String  MEMBERSHIPS_JOIN_DATE_ATTR                        = "joinDate";

    public static final String  MEMBERSHIPS_EXPIRE_DATE_ATTR                      = "expireDate";

    public static final String  MEMBERSHIPS_STATUS_ATTR                           = "status";

    public static final String  MEMBERSHIPS_STATUS_DESCRIPTION_ATTR               = "statusDescription";

    public static final String  MEMBERSHIPS_IS_AUTO_RENEW_ATTR                    = "isAutoRenew";

    public static final String  MEMBERSHIPS_BENEFIT_LEVEL_ATTR                    = "benefitLevel";

    public static final String  MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR               = "benefitLevelName";

    // End BZ24424

    //Begin BZ24944
    public static final String  PRICE_IDENTIFIER                                  = "identifier";

    public static final String  PRICE_PRICE_COMPARE_BAND_ID                       = "priceCompareBandId";

    public static final String  PRICE_DESCRIPTION                                 = "description";

    public static final String  PRICE_BAND                                        = "band";

    public static final String  PRICE_PRICE_COMPARE_BAND                          = "priceCompareBand";

    public static final String  PRICE_MEMBERSHIP                                  = "membership";

    public static final String  PRICING_ATTR                                      = "pricing";
    /* BEGIN BZ28907 */
    public static final String  PRICE_IDENTIFIER_ID                               = "3";

    public static final String  PRICE_PRICE_COMPARE_BAND_VALUE                    = "24";
    /* END BZ28907 */
    public static final String  PRICE_DESCRIPTION_VALUE                           = "CLUB PRICE";

    public static final String  PRICE_BAND_VALUE                                  = "CLUB";
    //End BZ24944

    // BZ 25318
    public static final String  PRICING                                           = "PRICING";

    public static final String  MEMBERSHIPS_ATTR                                  = "MEMBERSHIPS";                                      //BZ26453

    // Begin BZ26575
    public static final String  THE_CUSTOMER_ATTR                                 = "customer"; //BZ61159

    public static final String  SALES_CHANNEL_ATTR                                = "salesChannel";

    public static final String  SALES_CHANNEL_ID_ATTR                             = "id";

    public static final String  US_COUNTRY                                        = "UNITED STATES OF AMERICA";

    public static final String  CAN_COUNTRY                                       = "CANADA";
    // End BZ26575

    public static final String  GOODSAM_VISA_CARE_TAKER_CASHIER_TEMPLATE          = "GOODSAM_VISA_CARE_TAKER_CASHIER_TEMPLATE";         //BZ26596

    // Begin BZ25435
    public static final String  REQUEST_ID                                        = "requestId";

    public static final String  CS_APP_USER                                       = "csAppUser";

    public static final String  CS_APP_PASSWORD                                   = "csAppPassword";

    public static final String  TERMINAL                                          = "terminal";

    public static final String  PRESCREEN_ID                                      = "prescreenId";

    public static final String  OLPS_PRESCREEN_ID                                 = "olpsPrescreenID";
    // End BZ25435

    // BZ26207 Begin Work Order Session
    public static final String  CAW_WORK_ORDER_SALE_CHANNEL                       = "CAW_WORK_ORDER_SALE_CHANNEL";

    public static final String  CAW_WORK_ORDER_SEARCH_REQUEST                     = "CAW_WORK_ORDER_SEARCH_REQUEST";

    public static final String  CAW_WORK_ORDER_LOOKUP_REQUEST                     = "CAW_WORK_ORDER_LOOKUP_REQUEST";

    public static final String  CAW_WORK_ORDER_UPDATE_STATUS_REQUEST              = "CAW_WORK_ORDER_UPDATE_STATUS_REQUEST";
    // BZ26207 End Work Order Session
    /* Begin BZ28265 */
    /**
     * The OBJECT_SALES_CHANNEL_ATTR
     */
    public static final String  OBJECT_SALES_CHANNEL_ATTR                         = "OBJECT_SALES_CHANNEL_ATTR";

    /**
     * The OBJECT_CASHIER_ATTR
     */
    public static final String  OBJECT_CASHIER_ATTR                               = "OBJECT_CASHIER_ATTR";

    /**
     * The OBJECT_ID_ATTR
     */
    public static final String  OBJECT_ID_ATTR                                    = "OBJECT_ID_ATTR";

    /* End BZ28265 */
    
    public static final String  ITEMCODE_ATTR                                   = "itemCode";//BZ28556
    
    /* BEGIN BZ28247*/
    /**
     * The CARD_TYPE
     */
    public static final String  CARD_TYPE                                         = "cardType";

    /**
     * The CARD_TYPE_DESCRIPTION
     */
    public static final String  CARD_TYPE_DESCRIPTION                             = "cardTypeDescription";

    /**
     * The THE_CUSTOMER_ATTR_V2
     */
    public static final String  THE_CUSTOMER_ATTR_V2                              = "customer";

    /**
     * The THE_CUSTOMER_SOURCE
     */
    public static final String  THE_CUSTOMER_SOURCE                               = "customerSource";

    /**
     * The THE_CUSTOMER_RESPONSE
     */
    public static final String  THE_CUSTOMER_RESPONSE                             = "customerResponse";
    /* END BZ28247 */
    /* BEGIN BZ29326 */
    /**
     * The MAKE_CREDIT_OFFER
     */
    public static final String  MAKE_CREDIT_OFFER                             = "makeCreditOffer";
    /* END BZ29326 */
    /*BEGIN BZ30922*/
    public static final String  CAW_INVENTORY_LOOKUP_REQUEST                       = "CAW_INVENTORY_LOOKUP_REQUEST";
    /*END BZ30922*/
    
    /*BEGIN BZ28036*/
    public static final String  CUSTOMER_PURCHASE_HISTORY                         = "CUSTOMER_PURCHASE_HISTORY";

    public static final String  CUSTOMER_PURCHASE_HISTORY_DETAIL                  = "CUSTOMER_PURCHASE_HISTORY_DETAIL";

    public static final String  ORDERS                                            = "orders";

    public static final String  ITEMS                                             = "items";

    public static final String  CODE                                              = "code";

    public static final String  ORDERTYPE                                         = "orderType";

    public static final String  QUANTITY                                          = "quantity";

    public static final String  LINETOTAL                                         = "lineTotal";

    public static final String  ATTRIBUTES                                        = "attributes";

    public static final String  ORDER                                             = "order";

    public static final String  ORDERDATE                                         = "orderDate";

    public static final String  ACCOUNTNUMBER                                     = "accountNumber";
    /*END BZ28036*/
    
    /* BEGIN BZ37023*/
    public static final String  CHANNEL_TYPE_DESCRIPTION                          = "Retail";
    
    public static final String  SHIPPING_CHANNEL_TYPE_RETAIL                          = "4"; /* BZ-37642 */
    
    public static final String  DESCRIPTION                                       = "Deliver to Home";
    /* END BZ37023*/
    /* BEGIN BZ37912 */
    public static final String  SHIPPING_RATE_ALL_ITEMS_TEMPLATE                  = "SHIPPING_RATE_ALL_ITEMS_TEMPLATE";

    public static final String  ORDER_SHIPPING_ITEMS                              = "ORDER_SHIPPING_ITEMS";

    public static final String  ORDER_SHIPPING_INFO                               = "ORDER_SHIPPING_INFO";
    /* END BZ37912 */
    
    /* BEGIN BZ37396 */
    public static final String  TAX_OBJECT_SALES_CHANNEL_ATTR                     = "TAX_OBJECT_SALES_CHANNEL_ATTR";

    public static final String  TAX_OBJECT_CUSTOMER_NAME_ATTR                     = "TAX_OBJECT_CUSTOMER_NAME_ATTR";

    public static final String  TAX_OBJECT_CUSTOMER_ADDRESS_ATTR                  = "TAX_OBJECT_CUSTOMER_ADDRESS_ATTR";

    public static final String  TAX_OBJECT_CUSTOMER_ATTR                          = "TAX_OBJECT_CUSTOMER_ATTR";

    public static final String  TAX_OBJECT_SHIP_TO_INFO_ATTR                      = "TAX_OBJECT_SHIP_TO_INFO_ATTR";

    public static final String  TAX_OBJECT_ITEMS_ATTR                             = "TAX_OBJECT_ITEMS_ATTR";

    public static final String  TAX_OBJECT_ADJUSTMENTS_ATTR                       = "TAX_OBJECT_ADJUSTMENTS_ATTR";

    public static final String  TAX_SALESPERSON_ATTR                              = "TAX_SALESPERSON_ATTR";

    public static final String  TAX_PROPERTIES_ATTR                               = "TAX_PROPERTIES_ATTR";

    public static final String  TAX_ATTRIBUTES_ATTR                               = "TAX_ATTRIBUTES_ATTR";

    public static final String  TAX_REQUEST_TEMPLATE                              = "TAX_REQUEST_TEMPLATE";
    /* END BZ37396 */

    /* BEGIN BZ40798 */
    public static final String  GOOD_SAM_SAVINGS                                  = "GOOD_SAM_SAVINGS";

    public static final String  COULD_SAVE                                        = "COULD_SAVE";
    /* END BZ40798 */
    
    public static final String  RV_PAYMENT_REQUEST_TEMPLATE                       = "RV_PAYMENT_REQUEST_TEMPLATE";/*BZ44917*/

    //BEGIN BZ48604
    public static final String  MOCKUP_ENABLE                                     = "MOCKUP_ENABLE";
    public static final String  CAW_LOYALTY_ENABLE                                = "CAW_LOYALTY_ENABLE";
    //END BZ48604

    public static final String  IS_CALL_NEW_API                                   = "IS_CALL_NEW_API";/*BZ48690*/
    
    public static final String  COUPONS                                           = "coupons";/*BZ48401*/
    
    //BEGIN BZ49929
    public static final String  CAW_LOYALTY_GSAM_MEMBER_TYPE                      = "CAW_LOYALTY_GSAM_MEMBER_TYPE";
    //END BZ49929
    
    //BEGIN BZ49933
    public static final String  CAW_LOYALTY_DISCOUNT_REASON_CODE                  = "CAW_LOYALTY_DIS_REASON_CODE";
    //END BZ49933

    //BEGIN BZ52837
    public static final String  CAW_LOYALTY_OFFER_DISCOUNT_REASON_CODE            = "CAW_LOY_OFFER_DIS_REASON_CODE";
    //END BZ52837
    
    //BEGIN BZ57844
    public static final String  MEMBERSHIPS_DAYS_EXPIRED                          = "daysExpired";

    public static final String  MEMBERSHIPS_TYPE                                  = "type";
    //END BZ57844
    
    public static final String  DATA                                              = "data"; //BZ61159
    
    public static final String  SUBSCRIBER_ID                                     = "subscriberId";
    public static final String  PHONE_NUMBER                                      = "phoneNumber";
    public static final String  MEMBERSHIP_SUBMIT_ORDER_RESPONSE                  = "membershipSubmitOrderResponse"; //BZ69691
}
