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
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ29123              210119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 * BZ32351              050819    API documentation change to serializedCouponCode instead of serializedCoupon
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ40561              140121    OB Reject Reasons and Order Status
 * BZ40798              240221    Modification to member savings calculation
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ51771              191022    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service.
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.orderservice.constant;

/**
 * Define Attributes for Web service, included
 * + Template file name, 
 * + Attributes in Web service package
 * + Identify field names 
 */
public class CawWSTemplateConstant {

    //DEFINE TEMPLATES -------------------------------
    public static final String TENDERS_TEMPLATE            = "TendersTemplate.txt";

    public static final String ITEMS_TEMPLATE              = "ItemsTemplate.txt";

    public static final String SHIP_TO_INFO_TEMPLATE       = "ShipToInfoTemplate.txt";

    public static final String CUSTOMER_TEMPLATE           = "CustomerTemplate.txt";

    public static final String CASHIER_TEMPLATE            = "CashierTemplate.txt";

    public static final String ADDRESS_CUSTOMER_TEMPLATE   = "AddressCustomerTemplate.txt";

    public static final String NAME_CUSTOMER_TEMPLATE      = "NameCustomerTemplate.txt";

    public static final String ADJUSTMENTS_TEMPLATE        = "AdjustmentsTemplate.txt";

    public static final String WORK_ORDER_DETAIL_TEMPLATE  = "WorkOrderDetail.txt";        //BZ26207

    public static final String PAID_IN_OUT_DETAIL_TEMPLATE = "PaidInOutTemplate.txt";

    public static final String ORDER_SERVICE_TEMPLATE      = "OrderServiceTemplate.txt";

    public static final String BROKER_DETAIL_TEMPLATE         = "BrokerDetailTemplate.txt";   // BZ37463 

    public static final String ORDER_STATUS_TEMPLATE          = "OrderStatusTemplate.txt";    // BZ37463
    
    public static final String ORDER_CAPTURE_TEMPLATE           = "OrderCaptureTemplate.txt";/*BZ48320*/
    // Begin BZ-40561
    public static final String ORDER_REASON_PROPERTIES_TEMPLATE = ", \"reasonCode\": !{obReasonCode}, \"reasonDescription\": !{obReasonDesc}";
    // End BZ-40561

    //DEFINE ATTRIBUTES -------------------------------

    public static final String COUNTRY_SHIP_ATTR           = "!{countryShip}";

    public static final String POSTAL_CODE_SHIP_ATTR       = "!{postalCodeShip}";

    public static final String STATE_PROVINCE_SHIP_ATTR    = "!{stateProvinceShip}";

    public static final String CITY_SHIP_ATTR              = "!{cityShip}";

    public static final String LINE2_SHIP_ATTR             = "!{line2Ship}";

    public static final String LINE1_SHIP_ATTR             = "!{line1Ship}";

    public static final String NAME_SHIP_ATTR              = "!{nameShip}";

    public static final String FILE_NUMBER_ATTR            = "!{fileNumber}";

    public static final String NAME_CASHIER_ATTR           = "!{nameCashier}";

    public static final String CODE_CASHIER_ATTR           = "!{codeCashier}";

    public static final String ADDRESS_CUSTOMER_ATTR       = "!{addressCustomer}";

    public static final String NAME_CUSTOMER_ATTR          = "!{nameCustomer}";

    public static final String ACCOUNT_NUMBER_ATTR         = "!{accountNumber}";

    public static final String CUSTOMER_TYPE_ATTR          = "!{customerType}";

    public static final String COMPANY_ATTR                = "!{company}";

    public static final String SUFFIX_ATTR                 = "!{suffix}";

    public static final String LAST_ATTR                   = "!{last}";

    public static final String MIDDLE_ATTR                 = "!{middle}";

    public static final String FIRST_ATTR                  = "!{first}";

    public static final String PREFIX_ATTR                 = "!{prefix}";

    public static final String COUNTY_ATTR                 = "!{county}";

    public static final String COUNTRY_ATTR                = "!{country}";

    public static final String POSTAL_CODE_ATTR            = "!{postalCode}";

    public static final String STATE_PROVINCE_ATTR         = "!{stateProvince}";

    public static final String CITY_ATTR                   = "!{city}";

    public static final String LINE4_ATTR                  = "!{line4}";

    public static final String LINE3_ATTR                  = "!{line3}";

    public static final String LINE2_ATTR                  = "!{line2}";

    public static final String LINE1_ATTR                  = "!{line1}";

    public static final String IS_DELIVERABLE_ATTR         = "!{isDeliverable}";

    public static final String ADDRESS_TYPE_ATTR           = "!{addressType}";

    public static final String AUDIT_ATTR                  = "!{audit}";

    public static final String EXPIRE_DATE_ATTR            = "!{expireDate}";

    public static final String CARDHOLDER_ATTR             = "!{cardholder}";

    public static final String CARD_NUMBER_MASKED_ATTR     = "!{cardNumberMasked}";

    public static final String TOKEN_ATTR                  = "!{token}";

    public static final String AUTHORIZATION_ATTR          = "!{authorization}";

    public static final String PROPERTIES_ATTR             = "!{properties}";

    public static final String ADJUSTMENTS_ATTR            = "!{adjustments}";

    public static final String LINE_TOTAL_ATTR             = "!{lineTotal}";

    public static final String TAX_AMOUNT_ATTR             = "!{taxAmount}";

    public static final String TAX_CODE_ATTR               = "!{taxCode}";

    public static final String UNIT_SELLING_PRICE_ATTR     = "!{unitSellingPrice}";

    public static final String UNIT_LIST_PRICE_ATTR        = "!{unitListPrice}";

    public static final String UNIT_OF_MEASURE_ATTR        = "!{unitOfMeasure}";

    public static final String QUANTITY_ATTR               = "!{quantity}";

    public static final String SALES_PERSON_ATTR           = "!{salesPerson}";

    public static final String CODE_ATTR                   = "!{code}";

    /* BEGIN BZ32351: change "serializedCoupon" to "serializedCouponCode" in this constant and in AdjustmentsTemplate.txt file */
    public static final String SERIALIZED_COUPON_ATTR      = "!{serializedCouponCode}";
    /* END BZ32351 */

    public static final String COUPON_CODE_ATTR            = "!{couponCode}";

    public static final String AMOUNT_ATTR                 = "!{amount}";

    public static final String TYPE_ATTR                   = "!{type}";

    public static final String ATTRIBUTES_ATTR             = "!{attributes}";

    public static final String E_RECEIPT_EMAIL_ATTR        = "!{eReceiptEmail}";

    public static final String RECEIPT_TYPE_ATTR           = "!{receiptType}";

    public static final String TENDERS_ATTR                = "!{tenders}";

    public static final String ITEMS_ATTR                  = "!{items}";

    public static final String SHIP_TO_INFO_ATTR           = "!{shipToInfo}";

    public static final String CUSTOMER_ATTR               = "!{customer}";

    public static final String ORDER_TOTAL_WITH_TAX_ATTR   = "!{orderTotalWithTax}";

    public static final String ORDER_DATE_ATTR             = "!{orderDate}";

    public static final String CASHIER_ATTR                = "!{cashier}";

    public static final String CORRELATION_KEY_ATTR        = "!{correlationKey}";

    public static final String ID_ORDER_ATTR               = "!{idOrder}";

    public static final String TERMINAL_ATTR               = "!{terminal}";

    public static final String ORDER_TYPE_ATTR             = "!{orderType}";

    public static final String CHANNEL_TYPE_ATTR           = "!{channelType}";

    public static final String ID_SALE_CHANEL_ATTR         = "!{idSaleChanel}";

    // Begin BZ26207
    public static final String WORK_ORDER_DETAIL_ATTR      = "!{workOrderDetail}";

    public static final String WORK_ORDER_ID               = "!{idWorkOrder}";

    public static final String WORK_ORDER_STATUS           = "!{posStatus}";
    // End BZ26207

    public static final String PAID_IN_OUT_DETAIL_ATTR     = "!{paidInOutDetail}";

    public static final String CODE_PAIDINOUT_ATTR         = "!{codePaidInOut}";

    public static final String DESCRIPTION_PAIDINOUT_ATTR  = "!{descriptionPaidInOut}";

    //DEFINE OBJECT NAME/ FIELD NAME/ IDENTIFY NAME IN WEB-SERVICE PACKAGE ---------------------------
    public static final String IDENTIFIER                  = "identifier";

    public static final String DESCRIPTION                 = "description";

    public static final String BAND                        = "band";

    public static final String NAME                        = "name";

    public static final String CLUB_PRICE                  = "CLUB PRICE";

    public static final String LAST_UPDATE_SYSTEM          = "lastUpdateSystem";

    public static final String CREW_PRICE                  = "CREW PRICE";

    public static final String EMAIL_ADDRESS               = "emailAddress";

    public static final String MEMBERSHIP                  = "membership";

    public static final String CUSTOMER_TYPE               = "customerType";

    public static final String CW                          = "CW";

    public static final String AUDIT                       = "audit";

    public static final String PREFIX                      = "prefix";

    public static final String COUNTY                      = "county";

    public static final String COUNTRY                     = "country";

    public static final String POSTAL_CODE                 = "postalCode";

    public static final String STATE_PROVINCE              = "stateProvince";

    public static final String CITY                        = "city";

    public static final String LINE4                       = "line4";

    public static final String LINE3                       = "line3";

    public static final String LINE2                       = "line2";

    public static final String LINE1                       = "line1";

    public static final String ADDRESS_TYPE                = "addressType";

    public static final String ADDRESS                     = "address";

    public static final String COMPANY                     = "company";

    public static final String SUFFIX                      = "suffix";

    public static final String LAST                        = "last";

    public static final String MIDDLE                      = "middle";

    public static final String FIRST                       = "first";

    public static final String JSON_ACCOUNT_NUMBER         = "accountNumber";

    public static final String ALTERNATE_ID_OWNER          = "EBS";

    public static final String COUPONCODEDEFAULT           = "1111";

    public static final String CLUB_CODE                   = "CLUB";

    public static final String WHOLESALE_CODE              = "WHSL";

    public static final String CREW_CODE                   = "CREW";

    public static final String MEMBERSHIPS                 = "memberships";

    public static final String PRICING                     = "pricing";

    public static final String WHSL_PRICE                  = "WHSL PRICE";

    public static final String VALUE_24                    = "24";

    public static final String VALUE_25                    = "25";

    public static final String VALUE_26                    = "26";

    public static final String VALUE_3                     = "3";

    public static final String VALUE_100                   = "100";

    public static final String STR_VAL_0                   = "0";

    public static final String THE_CUSTOMER                = "theCustomer";

    public static final String RETAIL                      = "RETAIL";

    public static final String REG_PRICE                   = "REG. PRICE";

    public static final String PRICE_COMPARE_BAND          = "priceCompareBand";

    public static final String PRICE_COMPARE_BAND_ID       = "priceCompareBandId";

    public static final String CRUD                        = "crud";

    public static final String CRUD_DESCRIPTION            = "crudDescription";

    public static final String IS_RETURN_ATTR              = "!{isReturn}";                //BZ25860

    public static final String COUPON_CODE_LABEL           = "couponcode";
    
    public static final String PURCHASE_ORDER_ATTR         = "!{purchaseOrder}";//BZ29123
    
    /* BEGIN BZ37463 */
    public static final String THE_ORDER_ATTR_NAME            = "theOrder";

    public static final String SALES_CHANNEL_ATTR_NAME        = "salesChannel";

    public static final String ID_ATTR_NAME                   = "id";

    public static final String TERMINAL_ATTR_NAME             = "terminal";

    public static final String CHANNEL_TYPE_ATTR_NAME         = "channelType";

    public static final String ORDER_DETAIL_ATTR_NAME         = "orderDetail";

    public static final String POS_STATUS_ATTR_NAME           = "posStatus";

    public static final String ORDER_TYPE_ATTR_NAME           = "orderType";

    public static final String ORDER_ITEMS_TEMPLATE           = "OrderItemsTemplate.txt";

    public static final String ORDER_SHIPPING_METHOD          = "!{shippingmethod}";

    public static final String CHANNEL_TYPE_DES               = "!{channelTypeDescription}";

    public static final String WEB_DESCRIPTION_CONST          = "Web";

    public static final String ORDER_ID                       = "!{orderId}";

    public static final String ADDRESS_TYPE_DESCRIPTION       = "!{addressTypeDescription}";

    public static final String ADDRESS_TYPE_DESCRIPTION_CONST = "NotSpecified";

    public static final String EMAIL_ATR                      = "!{emailAddress}";

    public static final String LINE_TOTAL                     = "!{lineTotal}";

    public static final String CONTACT_PHONE                  = "!{contactPhone}";

    public static final String PHYSICAL_INFO                  = "!{physicalInfo}";

    public static final String BROKER_ITEM_DETAIL             = "!{brokerItemDetail}";

    public static final String SHIP_VIA                       = "!{shipVia}";

    public static final String SERVICE_LEVEL                  = "!{serviceLevel}";

    public static final String BROKER_ACTION                  = "!{brokerAction}";

    public static final String FULL_FILL_SYSTEM               = "!{fulfillmentSystem}";

    public static final String FULL_FILL_LOCATION             = "!{fulfillmentLocation}";

    public static final String OB_REQUEST_ID                  = "!{obRequestId}";

    public static final String OB_ORDER_ID                    = "!{obOrderId}";
    
    public static final String OB_ACTION_DESCRIPTION          = "!{brokerActionDescription}";/*BZ44528*/
    // Begin BZ-40561
    public static final String OB_ORDER_REASON_PROPERTIES     = "!{obOrderReasonProperties}";
    
    public static final String OB_ORDER_STAUS_CODE           = "!{obStatus}";
    
    public static final String OB_ORDER_REASON_CODE           = "!{obReasonCode}";
    
    public static final String OB_ORDER_REASON_DESC           = "!{obReasonDesc}";
    // End BZ-40561
    /*BEGIN BZ48320*/
    public static final String OB_ORDER_CORRELATION_KEY         = "!{orderCorrelationKey}";

    public static final String OB_ORDER_ITEM_CORRELATION_KEY    = "!{itemCorrelationKey}";

    public static final String OB_ORDER_VIN_ID                  = "!{vinId}";
    /*END BZ48320*/
    
    public static final String FULL_FILL_SYSTEM_DES           = "XSTORE";

    /* END BZ37463 */
    
    /* BEGIN BZ40798 */
    public static final String ATTRIBUTES_TEMPLATE      = "{\r\n" + 
            "                            \"goodSamSavings\": !{goodSamSavings},\r\n" + 
            "                            \"couldSave\": !{couldSave}\r\n" + 
            "                        }";
    public static final String ATTRIBUTES_GOOD_SAM_SAVINGS ="!{goodSamSavings}";
    public static final String ATTRIBUTES_COULD_SAVE = "!{couldSave}";
    /* END BZ40798 */
    
    /* BEGIN BZ48630: Handle to use TOKEN */
    public static final String TOKEN_TEMPLATE            = "TokenTemplate.txt";
    
    public static final String TOKEN_CLIENT_ID           = "!{client_id}";
    
    public static final String TOKEN_CLIENT_SECRET       = "!{client_secret}";
    
    public static final String TOKEN_GRANT_TYPE          = "!{grant_type}";
    /* END BZ48630: Handle to use TOKEN */
    
    //BEGIN BZ51771
    public static final String LOYALTY_DETAILS                      = "!{loyalty_details}";
    public static final String LOYALTY_DETAILS_FIELD_NAME           = "loyaltyDetails";
    
    //END BZ51771
    
    //BEGIN BZ61159
    public static final String JSON_CUSTOMER                     = "customer";
    public static final String PITCHES_INFO_FIELD_NAME           = "pitches";
    //END BZ61159
    
    //BEGIN BZ63054
    public static final String RECEIPT_TYPE_ATTR_DESCRIPTION_ATTR           = "!{receiptTypeDescription}"; 
    public static final String SALES_CHANNEL_CONFIG_ATTR           = "!{salesChannelConfig}"; 
    public static final String THIRD_PARTY_PAYER_ATTR           = "!{thirdPartyPayer}"; 
    //END BZ63054
}