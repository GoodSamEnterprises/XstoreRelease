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
 * BZ25358          210518    Enhancements to QAS Integration with POS
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26289          240718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27000          030818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 * BZ26207          130818    New Requirement - Enable Work Order Functionalitys
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ27651          200118    [New Requirement] Add the saleperson to the requests of Card Services API
 * BZ29205          280119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ30154          190619    [New Requirement] Xstore capture the Work Order line items' sale associate from S&I and forward it to Order Service as part of item attribute
 * BZ30922          210619    [New Requirement] Price Check and Inventory Lookup
 * BZ31943          170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 * BZ33615          311019    [Prod] Issue with tax being charged on tax exempt wholesale customer
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ36667          290620    Membership Sale Issue
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 * BZ42019          171121    Replace QAS with EAVS2
 * BZ47542          061221    RV Service Payments - Property Names
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction  
 * BZ48564          120422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 * BZ48692          240422    [Task] Process New Service is offline/time out when processing customer Search.
 * BZ49801          040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ50442          130622    Redemption data missing in request
 * BZ51770          181022    [Task[ Xstore needs to handle these additional updated submit order response from API
 * BZ51469          251022    [NEW] Points Expiring needs to change the way it appears in Xstore
 * BZ63054          080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.pos.common;

/**
 * Define utility methods for JSON Object
 */
public class CawJSONConstant {

    // CUSTOMER_SEARCH API
    public static final String CHANNEL_TYPE_ATTR                     = "!{channelType}";             // BZ23591

    public static final String LAST_NAME                             = "!{lastName}";

    public static final String FIRST_NAME                            = "!{firstName}";

    public static final String CITY                                  = "!{city}";

    public static final String STATE                                 = "!{stateProvince}";

    public static final String POSTAL_CODE                           = "!{postalCode}";

    public static final String COUNTRY                               = "!{country}";                 // BZ23270

    public static final String PHONE_NUMBER                          = "!{phoneNumber}";

    public static final String MEMBER_ID                             = "!{memberID}";

    public static final String ACCOUNT_NUMBER                        = "!{accountNumber}";

    public static final String LIMIT_RESULT                          = "!{limit}";

    public static final String COMPANY_NAME                          = "!{companyName}";

    public static final String ADDRESS                               = "!{address}";

    // CUSTOMER_UPSERT API
    public static final String SALES_CHANNEL                         = "!{id}";

    public static final String NAME_AUDIT                            = "!{audit}";

    public static final String NAME_PREFIX                           = "!{prefix}";

    public static final String NAME_FIRST                            = "!{first}";

    public static final String NAME_MIDDLE                           = "!{middle}";

    public static final String NAME_LAST                             = "!{last}";

    public static final String NAME_SUFFIX                           = "!{suffix}";

    public static final String NAME_COMPANY                          = "!{company}";

    public static final String ADDRESS_AUDIT                         = "!{addressAudit}";

    public static final String ADDRESS_ADDRESS_TYPE                  = "!{addressType}";

    public static final String ADDRESS_TYPE_DESCRIPTION              = "!{addressTypeDescription}";

    public static final String ADDRESS_IS_DELIVERABLE                = "!{isDeliverable}";

    public static final String ADDRESS_LINE1                         = "!{line1}";

    public static final String ADDRESS_LINE2                         = "!{line2}";

    public static final String ADDRESS_LINE3                         = "!{line3}";

    public static final String ADDRESS_LINE4                         = "!{line4}";

    public static final String ADDRESS_CITY                          = "!{city}";

    public static final String ADDRESS_STATE_PROVINCE                = "!{stateProvince}";

    public static final String ADDRESS_POSTAL_CODE                   = "!{postalCode}";

    public static final String ADDRESS_COUNTRY                       = "!{country}";

    public static final String ADDRESS_COUNTY                        = "!{county}";

    public static final String MEMBERSHIPS                           = "!{memberships}";

    public static final String PHONES                                = "!{phones}";

    public static final String PARTNERS                              = "!{partners}";

    public static final String PRICING                               = "!{pricing}";

    public static final String ACCOUNT_STATUS                        = "!{accountStatus}";

    public static final String ACCOUNT_STATUS_DESCRIPTION            = "!{accountStatusDescription}";

    public static final String CUSTOMER_TYPE                         = "!{customerType}";

    public static final String ACXIOMIDENTIFIERS                     = "!{acxiomIdentifiers}";

    public static final String ALLOWEDIT                             = "!{allowEdit}";

    public static final String EMAIL_ADDRESS                         = "!{emailAddress}";

    public static final String RV_TYPE                               = "!{rvType}";

    public static final String RV_TYPE_DESCRIPTION                   = "!{rvTypeDescription}";

    public static final String IS_TAXEXEMPT                          = "!{isTaxExempt}";

    public static final String TAX_CERTIFICATE                       = "!{taxCertificate}";

    public static final String AR_INFO                               = "!{arInfo}";

    public static final String LAST_UPDATE_USER                      = "!{lastUpdateUser}";

    public static final String LAST_UPDATE_SYSTEM                    = "!{lastUpdateSystem}";

    public static final String LAST_UPDATE_DATE                      = "!{lastUpdateDate}";

    public static final String FEED                                  = "!{feed}";

    public static final String ATTRIBUTES                            = "!{attributes}";

    public static final String CRUD                                  = "!{crud}";

    public static final String CRUD_DESCRIPTION                      = "!{crudDescription}";

    public static final String WORK_ORDER_SALES_CHANNEL              = "!{saleChannel}";

    public static final String SALES_CHANNEL_ID                      = "!{id}";

    public static final String TERMINAL                              = "!{terminal}";

    public static final String MAX_RESULTS                           = "!{maxResults}";

    public static final String WORK_ORDER_ID                         = "!{workOrderId}";

    public static final String WORK_ORDER_STATUS                     = "!{posStatus}";
    
    /*BEGIN BZ48401*/
    public static final String ITEM_CODE                               = "!{code}";

    public static final String ITEMS_ATTR                              = "!{items}";

    public static final String ITEM_QUANTITY                           = "!{quantity}";

    public static final String ITEM_SELLING_PRICE                      = "!{sellingPrice}";

    public static final String ITEMS_TAX_AMOUNT                        = "!{taxAmount}";

    public static final String ITEM_LINE_TOTAL                         = "!{lineTotal}";
    /*END BZ48401*/

    // JSON attributes
    public static final String JSON_ACCOUNT_NUMBER                   = "accountNumber";

    public static final String JSON_NAME                             = "name";

    public static final String JSON_AUDIT                            = "audit";

    public static final String JSON_FIRST_NAME                       = "first";

    public static final String JSON_LAST_NAME                        = "last";

    public static final String JSON_ADDRESS                          = "address";

    public static final String JSON_LINE1                            = "line1";

    public static final String JSON_LINE2                            = "line2";

    public static final String JSON_LINE3                            = "line3";

    public static final String JSON_LINE4                            = "line4";

    public static final String JSON_CITY                             = "city";

    public static final String JSON_STATE                            = "stateProvince";

    public static final String JSON_POSTAL_CODE                      = "postalCode";

    public static final String JSON_COUNTY                           = "county";

    public static final String JSON_COUNTRY                          = "country";

    public static final String JSON_COMPANY                          = "company";

    public static final String JSON_EMAIL_ADDRESS                    = "emailAddress";

    public static final String JSON_ADDRESS_TYPE                     = "addressType";

    public static final String JSON_ADDRESS_TYPE_DESCRIPTION         = "addressTypeDescription";

    public static final String JSON_MEMBERSHIPS                      = "memberships";
    
    public static final String JSON_LOYALTY                          = "loyalty";                   //BZ48564

    public static final String JSON_RESPONSE_RESULT                  = "result";                    //BZ48564
    
    public static final String JSON_PHONES                           = "phones";                     //BZ24202

    public static final String JSON_PARTNERS                         = "partners";

    public static final String JSON_ACCOUNT_STATUS                   = "accountStatus";

    public static final String JSON_ACCOUNT_STATUS_DESCRIPTION       = "accountStatusDescription";

    public static final String JSON_CUSTOMER_TYPE                    = "customerType";

    public static final String JSON_ACXIOM_IDENTIFIERS               = "acxiomIdentifiers";

    public static final String JSON_ACXIOM_INDIVIDUAL_ID             = "individualId";

    public static final String JSON_ACXIOM_HOUSEHOLD_ID              = "householdId";

    public static final String JSON_ALLOW_EDIT                       = "allowEdit";

    public static final String JSON_RV_TYPE                          = "rvType";

    public static final String JSON_RV_TYPE_DESCRIPTION              = "rvTypeDescription";

    public static final String JSON_IS_TAX_EXEMPT                    = "isTaxExempt";

    public static final String JSON_TAX_CERTIFICATE                  = "taxCertificate";

    public static final String JSON_AR_INFO                          = "arInfo";

    public static final String JSON_AR_CREDIT_HOLD                   = "isArCreditHold";

    public static final String JSON_AR_AVAILABLE_BALANCE             = "availableBalance";

    public static final String JSON_AR_LAST_PAYMENT                  = "lastPayment";

    public static final String JSON_FEED                             = "feed";

    public static final String JSON_ATTRIBUTES                       = "attributes";

    public static final String JSON_CRUD                             = "crud";

    public static final String JSON_CRUD_DESCRIPTION                 = "crudDescription";

    public static final String STORE_TAG                             = "Store";

    public static final String SYSTEM_CONFIG_TAG                     = "SystemConfig";

    public static final String CUSTOMER_SEARCH                       = "CustomerSearch";

    public static final String MAXNUMBEROFCUSTOMERS                  = "MaxNumberOfCustomers";

    public static final String STRING                                = "String";

    public static final String PROPERTIES_NAME_AUDIT                 = "NAME_AUDIT";

    public static final String PROPERTIES_ADDRESS_AUDIT              = "ADDRESS_AUDIT";

    public static final String PROPERTIES_ADDRESS_TYPE               = "ADDRESS_TYPE";

    public static final String PROPERTIES_ADDRESS_TYPE_DESCRIPTION   = "ADDRESS_TYPE_DESCRIPTION";

    public static final String PROPERTIES_MEMBERSHIPS                = "MEMBERSHIPS";

    public static final String PROPERTIES_PHONES                     = "PHONES";                     //BZ24202

    public static final String PROPERTIES_PARTNERS                   = "PARTNERS";

    public static final String PROPERTIES_ACCOUNT_STATUS             = "ACCOUNT_STATUS";

    public static final String PROPERTIES_ACCOUNT_STATUS_DESCRIPTION = "ACCOUNT_STATUS_DESCRIPTION";

    public static final String PROPERTIES_CUSTOMER_TYPE              = "CUSTOMER_TYPE";

    public static final String PROPERTIES_ACXIOM_INDIVIDUAL          = "ACXIOM_INDIVIDUAL";

    public static final String PROPERTIES_ACXIOM_HOUSEHOLD           = "ACXIOM_HOUSEHOLD";

    public static final String PROPERTIES_ALLOW_EDIT                 = "ALLOW_EDIT";

    public static final String PROPERTIES_RV_TYPE_DESCRIPTION        = "RV_TYPE_DESCRIPTION";

    public static final String PROPERTIES_IS_TAX_EXEMPT              = "IS_TAX_EXEMPT";

    public static final String PROPERTIES_TAX_CERTIFICATE            = "TAX_CERTIFICATE";

    public static final String PROPERTIES_IS_AR_INFO_CREDIT_HOLD     = "IS_AR_INFO_CREDIT_HOLD";

    public static final String PROPERTIES_AR_INFO_AVAILABLE_BALANCE  = "AR_INFO_AVAILABLE_BALANCE";

    public static final String PROPERTIES_AR_INFO_LAST_PAYMENT       = "AR_INFO_LAST_PAYMENT";

    public static final String PROPERTIES_FEED                       = "FEED";

    public static final String PROPERTIES_ATTRIBUTES                 = "ATTRIBUTES";

    public static final String PROPERTIES_CRUD                       = "CRUD";

    public static final String PROPERTIES_CRUD_DESCRIPTION           = "ATTRIBUTES_DESCRIPTION";

    public static final String NULL                                  = "null";

    public static final String ONE_STRING                            = "1";

    public static final int    ZERO                                  = 0;

    public static final int    ONE                                   = 1;

    public static final int    TWO                                   = 2;

    public static final String MOBILE_TYPE                           = "MOBILE";

    public static final String HOME_TYPE                             = "HOME";

    public static final String TWO_STRING                            = "2";

    public static final String SPECIAL_CHARACTER                     = "[\\t\\n\\r]+";

    public static final String SPACE_CHARACTER                       = "";

    public static final int    POSTAL_CODE_FIRST_INDEX               = 0;

    public static final int    POSTAL_CODE_LAST_INDEX                = 5;

    // Begin BZ26575
    public static final String JSON_IS_DELIVERABLE                   = "isDeliverable";

    public static final String JSON_NOT_SPECIFIED                    = "NotSpecified";
    // End BZ26575

    // BZ26289 start
    public static final String JSON_CUSTOMER_TAX_EXEMPT              = "isTaxExempt";
    // BZ26289 end

    // BZ27000 start
    public static final String JSON_AVAILABLE_PRICING                = "pricing";

    public static final String JSON_MEMBERSHIP                       = "membership";

    public static final String JSON_JOIN_DATE                        = "joinDate";

    public static final String JSON_BAND                             = "band";
    // BZ27000 end

    // BZ26207 start
    public static final String JSON_RETAIL                           = "Retail";

    public static final String JSON_ORDERS                           = "orders";

    public static final String JSON_ORDER                            = "order";

    public static final String JSON_WO_DATE                          = "orderDate";

    public static final String JSON_WO_CUSTOMER                      = "customer";

    public static final String JSON_WO_CUSTOMER_ACCOUNT_NUMBER       = "accountNumber";

    public static final String JSON_WO_DETAIL                        = "workOrderDetail";

    public static final String JSON_WO_NUMBER                        = "id";

    public static final String JSON_WO_TYPE                          = "type";

    public static final String JSON_WO_STATUS                        = "status";

    public static final String JSON_WO_POS_STATUS                    = "posStatus";

    public static final String JSON_WO_POS_STATUS_DESCRIPTION        = "posStatusDescription";

    public static final String JSON_WO_HAS_DEPOSIT                   = "hasDeposit";

    public static final String JSON_WO_DEPOSIT_AMT                   = "depositAmount";

    public static final String JSON_WO_TOTAL_TAX                     = "totalTax";

    public static final String JSON_WO_SHIPPING_AMT                  = "shipping";

    public static final String JSON_WO_DESCRIPTION                   = "description";

    public static final String JSON_ITEMS                            = "items";

    public static final String JSON_ITEM_ID                          = "code";

    public static final String JSON_QTY                              = "quantity";

    public static final String JSON_ITEM_PRICE                       = "unitSellingPrice";           //BZ27192

    public static final String JSON_ITEM_ADJUSTMENT                  = "adjustments";
    
    public static final String JSON_ITEM_ADJ_COUPON_CODE             = "couponCode";                /* BZ31943 */

    public static final String JSON_ITEM_ADJ_AMOUNT                  = "amount";                     //BZ27286

    public static final String JSON_WO_SALES_SCHANNEL                = "salesChannel";

    public static final String JSON_WO_SALES_SCHANNEL_LOC_ID         = "id";

    public static final String JSON_WO_TOTAL_WITH_TAX                = "orderTotalWithTax";

    public static final String JSON_WO_CORRELATION_KEY               = "correlationKey";
    // BZ26207 End

    // Begin BZ27651
    public static final String CASHIER_FILE_NUMBER                   = "fileNumber";

    public static final String CASHIER_NAME                          = "name";

    public static final String CASHIER_CODE                          = "code";

    public static final String CASHIER                               = "cashier";
    // End BZ27651

    public static final String JSON_PROPERTIES                       = "properties";                 /*BZ29205*/
    
    public static final String JSON_SALESPERSON                      = "salesPerson";                /*BZ30154*/
    /*BEGIN BZ30922*/
    public static final String ITEM_CODES                            = "!{itemCodes}";
    public static final String CURRENT_LOCATION                      = "!{currentLocation}";
    public static final String IS_PROXIMITY_SEARCH                   = "!{isProximitySearch}";
    public static final String RADIUS                                = "!{radius}";
    public static final String MAX_RESULT                            = "!{maxResults}";
    public static final String JSON_INVENTORY_INFOS                  = "inventoryInfos";
    public static final String JSON_LOCATION_LEVELS                  = "locationLevels";
    public static final String JSON_STORE_ID                         = "location";
    public static final String JSON_STORE_NAME                       = "name";
    public static final String JSON_DISTANCE                         = "distance";
    public static final String JSON_QUANTITY                         = "onHand";
    public static final String JSON_ITEM_CODES                       = "itemCode";
    /*END BZ30922*/
    public static final String JSON_SERIAL_NUMBER_ATTR               = "serialNumber";               /* BZ31793 */
    public static final String NO_CERTIFICATE                        = "ON-FILE";             /* BZ33615 */
    
    public static final String JSON_TRANSACTIONID                    = "!{transactionId}";           /*BZ28036*/
    
    public static final String  CUSTOMER_INFORMATION                 = "!{customerInformation}";//BZ36667
    
    /* BEGIN BZ44528: Phase 1 */
    public static final String JSON_CART_SEARCH_STATUS               ="status";
    public static final String JSON_CART_SEARCH_ERRORS               ="errors";
    public static final String JSON_CART_SEARCH_RESULTS              ="results";
    public static final String JSON_CART_TOTAL                       ="cartTotal";
    public static final String JSON_CART_BUSINESS_DATE               ="businessDate";
    public static final String JSON_CART_CORELLATION_KEY             ="correlationKey";
    
    public static final String JSON_CART_CUSTOMER                    ="customer";
    public static final String JSON_CART_CUSTOMER_NAME               ="name";
    public static final String JSON_CART_CUSTOMER_FIRST_NAME         ="first";
    public static final String JSON_CART_CUSTOMER_LAST_NAME          ="last";
    public static final String JSON_LINE_TOTAL                       ="lineTotal";
    
    public static final String CART_SALES_CHANNEL_ID                 = "!{salesChannelId}";
    public static final String FROM_DATE                             = "!{fromDate}";
    public static final String TO_DATE                               = "!{toDate}";
    public static final String CART_ACCOUNT_NUMBER                   = "!{accountNumber}";
    public static final String PAGE_SIZE                             = "!{pageSize}";
    public static final String PAGE_NUMBER                           = "!{pageNumber}";
    /* END BZ44528: Phase 1 */
    
    /*BEGIN BZ44917*/
    public static final String JSON_WORK_ORDER                       = "workOrder";

    public static final String JSON_CUSTOMER_ID                      = "customerId";

    public static final String JSON_LOCATION_CODE                    = "locationCode";

    public static final String JSON_SALES_CHANNEL_ID                 = "salesChannelId";
    /*END BZ44917*/
    
    public static final String JSON_DESCRIPTION                      = "description"; //BZ47542
    
    /* BEGIN BZ45995 */
    public static final String JSON_STATUS                           = "status";
    public static final String JSON_ERRORS                           = "errors";
    public static final String JSON_WARNINGS                         = "warnings";
    
    public static final String JSON_EMAIL_VALIDATION_IS_EMAIL_VALID  = "isEmailAddressValid";
    /* END BZ45995 */
    
    /* BEGIN BZ42019 */    
    public static final String JSON_MAILING_VALIDATION_REQUEST_ADDRESS = "requestedAddress";
    public static final String JSON_MAILING_VALIDATION_CLEAN_ADDRESS   = "cleansedAddress";
    /* END BZ42019 */
    
    /*BEGIN BZ48401*/
    public static final String SQUARE_BRACKETS_OPEN                    = "[";

    public static final String SQUARE_BRACKETS_CLOSE                   = "]";
    
    public static final String JSON_PROMOS                             = "promos";
    
    public static final String JSON_PROMO_OFFERS                       = "promoOffers";
    
    public static final String JSON_REWARD                             = "reward";

    public static final String JSON_POS_REWARD                         = "posReward";

    public static final String JSON_RESULT                             = "result";

    public static final String JSON_PROMO_CODE                         = "offerCode";

    public static final String JSON_PROMO_CODE_LABEL                   = "offerLabel";

    public static final String JSON_PROMO_METRIC_NAME                  = "offerMetricName";

    public static final String JSON_PROMO_METRIC_VALUE                 = "offerMetricValue";

    public static final String JSON_ELIGIBLE_SUB_CLASSES               = "eligibleSubclasses";

    public static final String JSON_ELIGIBLE_ITEMS                     = "eligibleItems";

    public static final String JSON_EXPIRATION                         = "offerExpiration";
    
    public static final String JSON_REWARD_CODE                          = "rewardCode";

    public static final String JSON_REWARDLABEL                          = "rewardLabel";
    
    public static final String JSON_REWARD_HEADING                       = "rewardHeading";
    
    public static final String JSON_REWARD_MAX_REEDEMABLE_POINTS_BALANCE = "rewardRedeemablePoints";

    public static final String JSON_REWARD_MAX_REDEEMABLE_VALUE          = "rewardRedeemableValue";

    public static final String JSON_POINTS_TO_NEXT_REWARD                = "pointsToNextReward";
    
    public static final String JSON_TOTAL_POINTS_BALANCE                = "totalPointsBalance";
    
    public static final String JSON_POINTS_EXPIRING_END_OF_MONTH         = "pointsExpiringEndOfMonth";

    public static final String JSON_PROMO_OFFER_CLAIM_ALLOCATION         = "promoOfferClaimAdjustments";

    public static final String JSON_REWARD_CLAIM_ALLOCATION              = "rewardClaimAllocations";

    public static final String JSON_ITEM_CORRELATION_KEY                 = "itemCorrelationKey";

    public static final String JSON_LINE_TOTAL_ADJUSTMENT                = "lineTotalAdjustment";
    
    public static final String JSON_SUBMIT_ORDER_RECEIPT_SUMMARY         = "receiptSummary";
    /*END BZ48401*/
    public static final String JSON_PERCENT_OFF                          = "%OFF";
    
    public static final String JSON_AMOUNT_OFF                           = "$OFF";

    public static final String JSON_TYPE                                 = "type";

    public static final String JSON_IDENTIFIER                           = "identifier";
    //BEGIN BZ48692
    public static final String JSON_RESULT_CODE                          = "resultCode";
    
    public static final String JSON_ERROR_DETAIL                         = "errorDetail";
    //END BZ48692
    //START BZ49801
    public static final String REDEEMABLE_AMOUNT                          = "redeemableAmount";
    
    public static final String REDEEMABLE_POINTS                          = "redeemablePoints";
    
    public static final String OFFER_LABEL                                = "offerLabel";
    
    public static final String OFFER_CODE                                 = "offerCode";
    //END BZ49801
    /*BEGIN BZ50032*/
    public static final String           TOKEN_TEMPLATE_CLIENT_ID             = "!{client_id}";
    
    public static final String           TOKEN_TEMPLATE_CLIENT_SECRET         = "!{client_secret}";
    
    public static final String           TOKEN_TEMPLATE_GRANT_TYPE            = "!{grant_type}";
    /*END BZ50032*/
    //START BZ50442
    public static final String JSON_OFFER_RESPONSE_CODE               = "offerResponseCode";
    public static final String JSON_EBS_COUPON_CODE                   = "ebsCouponCode";
    public static final String ITEM_CORRELATION_KEY                   = "itemCorrelationKey";
    public static final String POINTS_REDEEMED_ONLINE_ITEM            = "pointsRedeemedOnLineItem";
    //End BZ50442
    
    //BEGIN BZ51770 
    public static final String JSON_SUBMIT_POINT_EARNINGS             = "pointEarnings";
    public static final String SUBMIT_ORDER_RECEIPT_SUMMARY_VALUE     = "!{receiptSummary}";
    public static final String JSON_SUBMIT_POINT_EARNINGS_VALUE       = "!{pointEarnings}";
    public static final String JSON_REWARD_RESPONSE_CODE              = "rewardResponseCode";
    //END BZ51770
    
    public static final String JSON_POINTS_TO_EXPIRE            = "pointsToExpire";//BZ51469
    
    public static final String JSON_LOYALTY_SUBMIT_ORDER_RESPONSE     = "loyaltySubmitOrderResponse";//BZ63054
}
