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
 * BZ23052              120917    Implement Advanced Prompting
 * BZ23416              190917    [Advanced Prompting] Set default value is null or empty instead of "string" 
 * BZ23478              200917    [Prompting] Update Catalyst = 1 request
 * BZ23052              200917    Implement Advanced Prompting
 * BZ23541              270917    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4
 * BZ23637              280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23722              041017    [Prompting Engine] Missing the correlation key in the directive feedback
 * BZ23827              061017    [Prompting] missing data element in the catalyst 4 request
 * BZ23946              111017    [Certification] OLPS Request for instant credit must not send "null" 
 *                                in the <customerMemberId> field, leave this field blank for customers 
 *                                who are not club members
 * BZ23996              151017    [Advanced prompting] GSM Prompts again after adding it to the sale item screen
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins 
 * BZ24204              251017    Fee joining "Road side" club is not added into sale screen in case having more one response inputs from catalyst = 4
 * BZ24424              131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ24837              131217    Security Privileges Not Working Correctly for Users
 * BZ24868              181217    [PROD][XSTORE] Nueron Error while customer look up
 * BZ24601              221217    Price of customer is changed from RETL to CLUB unexpectedly when sending catalyst=1 request
 * BZ24944              271217    Club Pricing information doesn't display on top banner when attached GS join for transaction in offline case
 * BZ25434              210517    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ26398              310518    Club pricing is displayed on top banner once adding RA join item for transaction in offline case.
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28265              261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28510              041218    [Internal] PE (Prompting Engine) should be turned off when assign&Continue a customer into transaction is WHSL
 * BZ28529              051218    [Internal] Error with Prompt Engine when sending Prompt Engine result
 * BZ28567              071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28792              241218    [Bundle the fixed patch 2.1_ BZ28764 ] Invalid or incomplete JSON for "employee" in Order Service causes fatal condition and possible data loss
 * BZ28855              271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ28907              020118    [internal] Missing 'Retail pricing' text and logo on Top banner once join RA item in offline case
 * BZ30084              220419    [Internal] Failed to send /pe/catalyst request due to 'salesPerson' invalid format
 * BZ31753              030719    [INTERNAL] ESB responded Response is:400 After parsing a value an unexpected character was encountered
 * BZ33231              241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ35052              130220    [Porting the fix patch 8.0 to Xstore 6.0][PROD] Roadside Assistance applications being prompted for during Work Order processing
 * BZ36667              290620    Membership Sale Issue
 * BZ37609              070920    [Internal] Exception is thrown away from response Neuron API after made a call catalyst:4 at step Complete Delivery Order creation.
 * BZ37305              080920    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad
 * BZ38980              031120    [TASK] Prompt Engine - Add Item & Price
 * BZ40898              290121    Prompting for memberships on OB orders
 * BZ40798              240221    Modification to member savings calculation
 * BZ44053              150621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 * BZ45902              250821    [Internal] Exception after call Prompting Engine Catalyst API when an Electric World order is completed
 * BZ51922              260822    [UAT] Padding issue with the correlation key
 * BZ53287              081122    [Internal] EBS log appear error after pressing Add Tender during creating a new customer and joining GSAM membership.
 * BZ53457              111122    [UAT] Return transactions are not flowing to CW backend systems
 * BZ53722              181122    [UAT]Issues with Mixed transaction
 * BZ53752              211122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 * BZ53876              291122    [Internal] Mismatch information between Submit Order API request and Order Service request.
 * BZ54031              021222    [UAT] Points not printing on mixed transactions that contain IDS payments.
 * BZ54998              020222    BTM-286: Decimal Value in QTY for propane causes FATAL error.
 * BZ55978              290323    Loyalty Issue: Java Null Pointer
 * BZ54290              160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ59343              091023    [PROD] Submit Order response without customer loyalty information when the request contains properties "wp".
 * BZ61159              260224    [New Requirement] - Xstore AGIS Replacement
 * BZ62146              060324    [Internal] - The membership information should show on the Membership Info Tab.
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.math.BigDecimal;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.util.CawCheetahItemAdjustmentsModel;
import caw.pos.cheetah.util.CawCheetahSubmitRequestModel;
import caw.pos.common.*;
import caw.pos.common.rcpt.CawTotalAmountCouldSavedWorker;
import caw.pos.common.rcpt.CawTotalAmountSavedWorker;
//BZ23478
import caw.pos.customer.CawCustomerAddress;
import caw.pos.pricing.discount.CawDiscountCouponHelper;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.*;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.security.StationState;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.register.type.LineItemType;
import dtv.pos.warranty.WarrantyManager;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.IReasonCodeProperty;
//BZ23478
import dtv.xst.dao.crm.*;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.*;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;
import dtv.xst.dao.xom.*;

public class CawAdvancePromptingHelper {

    private static final String                       DATE_FORMAT                                = "yyyyMMdd";

    private static final String                       MEMBER_ID                                  = "!{memberId}";

    private static final String                       QUANTITY_ITEM                              = "!{quantityItem}";

    private static final String                       CODE_ITEM                                  = "!{codeItem}";

    private static final String                       QUANTITY_ATTR                              = "quantity";

    private static final String                       CUSTOMER_TYPE_ATTR                         = "customerType";

    private static final String                       NULL_STRING                                = "null";

    private static final String                       ORDER_TOTAL_WITH_TAX_ATTR                  = "!{orderTotalWithTax}";

    private static final String                       ORDER_DATE_ATTR                            = "!{orderDate}";

    private static final String                       NAME_CASHIER_ATTR                          = "!{nameCashier}";

    private static final String                       CODE_CASHIER_ATTR                          = "!{codeCashier}";

    private static final String                       ID_THE_ORDER_ATTR                          = "!{idTheOrder}";

    private static final String                       ID_SALE_CHANEL_ATTR                        = "!{idSaleChanel}";

    private static final char                         ZERO_CHAR                                  = '0';

    private static final String                       PRICE_CREW                                 = "CREW";

    private static final String                       PRICE_WHSL                                 = "WHSL";

    private static final String                       PRICE_CLUB                                 = "CLUB";

    private static final String                       PRICE_RETL                                 = "RETL";

    // Begin BZ23637
    private static final String                       PRICE_COMPARE_BAND_ID_ATTR                 = "priceCompareBandId";

    private static final String                       PRICE_COMPARE_BAND_ATTR                    = "priceCompareBand";

    private static final String                       BAND_ATTR                                  = "band";

    private static final String                       IDENTIFIER_ATTR                            = "identifier";

    private static final String                       PRICING_ATTR                               = "pricing";
    // End BZ23637

    private static final String                       VALUE_4                                    = "4";

    private static final String                       VALUE_1                                    = "1";

    private static final String                       OBJECT_REQUEST_ORACLEDETAIL_ATTR           = "!{OBJECT_REQUEST_ORACLEDETAIL_ATTR}";

    private static final String                       OBJECT_REQUEST_ERECEIPTDETAIL_ATTR         = "!{OBJECT_REQUEST_ERECEIPTDETAIL_ATTR}";

    private static final String                       PURCHASE_ORDER                             = "!{purchaseOrder}";

    private static final String                       OBJECT_REQUEST_PAIDINOUTDETAIL_ATTR        = "!{OBJECT_REQUEST_PAIDINOUTDETAIL_ATTR}";

    private static final String                       ARRAY_REQUEST_DISCOUNTS_ATTR               = "!{ARRAY_REQUEST_DISCOUNTS_ATTR}";

    private static final String                       ARRAY_REQUEST_TAXES_ATTR                   = "!{ARRAY_REQUEST_TAXES_ATTR}";

    private static final String                       ARRAY_REQUEST_INVOICES_ATTR                = "!{ARRAY_REQUEST_INVOICES_ATTR}";

    private static final String                       ARRAY_REQUEST_ITEMS_ATTR                   = "!{ARRAY_REQUEST_ITEMS_ATTR}";

    private static final String                       ARRAY_REQUEST_PROMPTS_ATTR                 = "!{ARRAY_REQUEST_PROMPTS_ATTR}";

    private static final String                       OBJECT_REQUEST_THIRDPARTYPAYER_ATTR        = "!{OBJECT_REQUEST_THIRDPARTYPAYER_ATTR}";

    private static final String                       OBJECT_REQUEST_CUSTOMER_ATTR               = "!{OBJECT_REQUEST_CUSTOMER_ATTR}";

    private static final String                       CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR = "!{CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR}";

    private static final String                       END_DATE_TIME                              = "!{endDateTime}";

    private static final String                       START_DATE_TIME                            = "!{startDateTime}";

    private static final String                       TAX_EXEMPT_CERTIFICATE                     = "!{taxExemptCertificate}";

    private static final String                       IS_PREPAY                                  = "!{isPrepay}";

    private static final String                       TOTAL_TAX                                  = "!{totalTax}";

    private static final String                       TOTAL                                      = "!{total}";

    private static final String                       TYPE_CODE                                  = "!{typeCode}";

    private static final String                       CREATE_DATE                                = "!{createDate}";

    private static final String                       CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR    = "!{CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR}";

    private static final String                       ORIGINAL_CORRELATION_KEY                   = "!{originalCorrelationKey}";

    private static final String                       SOURCE_CORRELATION_KEY                     = "!{sourceCorrelationKey}";

    private static final String                       IS_TAX_EXEMPT                              = "!{isTaxExempt}";

    protected static final String                     CUSTOMER_NAME_PROPERTY_CODE                = "CUSTOMER_NAME";

    private static final String                       NUMBER_DEFAULT                             = "0";

    private static final String                       BOOLEAN_DEFAULT                            = "true";

    private static final String                       ID                                         = "!{id}";

    private static final String                       TYPE                                       = "!{type}";

    private static final String                       DEPOSIT_LOCATION                           = "!{depositLocation}";

    private static final String                       PICKUP_LOCATION                            = "!{pickupLocation}";

    private static final String                       FILE_NUMBER                                = "!{fileNumber}";

    private static final String                       NAME                                       = "!{name}";

    private static final String                       CODE                                       = "!{code}";

    private static final String                       DESCRIPTION                                = "!{description}";

    private static final String                       ENTERPRISE_SYSTEM                          = "!{enterpriseSystem}";

    private static final String                       ENTERPRISE_DATE                            = "!{enterpriseDate}";

    private static final String                       USER_SYSTEM                                = "!{userSystem}";

    private static final String                       USER_DATE                                  = "!{userDate}";

    private static final String                       USER_NAME                                  = "!{userName}";

    private static final String                       ORIGIN                                     = "!{origin}";

    private static final String                       AUDIT                                      = "!{audit}";

    private static final String                       PREFIX                                     = "!{prefix}";

    private static final String                       FIRST                                      = "!{first}";

    private static final String                       MIDDLE                                     = "!{middle}";

    private static final String                       LAST                                       = "!{last}";

    private static final String                       SUFFIX                                     = "!{suffix}";

    private static final String                       COMPANY                                    = "!{company}";

    private static final String                       LINE1                                      = "!{line1}";

    private static final String                       LINE2                                      = "!{line2}";

    private static final String                       LINE3                                      = "!{line3}";

    private static final String                       LINE4                                      = "!{line4}";

    private static final String                       CITY                                       = "!{city}";

    private static final String                       STATE_PROVINCE                             = "!{stateProvince}";

    private static final String                       POSTAL_CODE                                = "!{postalCode}";

    private static final String                       COUNTRY                                    = "!{country}";

    private static final String                       COUNTY                                     = "!{county}";

    private static final String                       MESSAGE                                    = "!{message}";

    private static final String                       SEVERITY                                   = "!{severity}";

    private static final String                       IDENTIFIER                                 = "!{identifier}";

    private static final String                       IS_ACTIVE                                  = "!{isActive}";

    private static final String                       IS_PRIMARY                                 = "!{isPrimary}";

    private static final String                       ALERTS                                     = "!{alerts}";

    private static final String                       TYPE_DESCRIPTION                           = "!{typeDescription}";

    private static final String                       JOIN_DATE                                  = "!{joinDate}";

    private static final String                       STATUS_DESCRIPTION                         = "!{statusDescription}";

    private static final String                       DISPLAY_TEXT                               = "!{displayText}";

    private static final String                       IS_AUTO_RENEW                              = "!{isAutoRenew}";

    private static final String                       MEMBER_TYPE                                = "!{memberType}";

    private static final String                       MEMBER_TYPE_DESCRIPTION                    = "!{memberTypeDescription}";

    private static final String                       PSEUDO_NUMBER                              = "!{pseudoNumber}";

    private static final String                       BENEFIT_LEVEL_NUMBER                       = "!{benefitLevelNumber}";

    private static final String                       BENEFIT_LEVEL_NAME                         = "!{benefitLevelName}";

    private static final String                       BENEFIT_LEVEL_DESCRIPTION                  = "!{benefitLevelDescription}";

    private static final String                       CARD_COLOR                                 = "!{cardColor}";

    private static final String                       DISCOUNT_GAS                               = "!{discountGas}";

    private static final String                       DISCOUNT_DIESEL                            = "!{discountDiesel}";

    private static final String                       FIRST_NAME                                 = "!{firstName}";

    private static final String                       MIDDLE_NAME                                = "!{middleName}";

    private static final String                       LAST_NAME                                  = "!{lastName}";

    private static final String                       COMPANY_NAME                               = "!{companyName}";

    private static final String                       BAND                                       = "!{band}";

    private static final String                       PRICE_COMPARE_BAND                         = "!{priceCompareBand}";

    private static final String                       PRICE_COMPARE_BAND_ID                      = "!{priceCompareBandId}";

    private static final String                       MEMBERSHIPS                                = "!{memberships}";

    private static final String                       IS_SELECTED                                = "!{isSelected}";

    private static final String                       REQUIRE_PREFERENCE_CODE                    = "!{requiredPreferenceCode}";

    private static final String                       CHOICES                                    = "!{OBJECT_REQUEST_CHOICES_ATTR}";

    private static final String                       LABEL                                      = "!{label}";

    private static final String                       SCRIPT                                     = "!{script}";

    private static final String                       IS_REQUIRED                                = "!{isRequired}";

    private static final String                       IS_READ_ONLY                               = "!{isReadOnly}";

    private static final String                       IS_VISIBLE                                 = "!{isVisible}";

    private static final String                       LAST_UPDATE_DATE                           = "!{lastUpdateDate}";

    private static final String                       INPUT_TYPE                                 = "!{inputType}";

    private static final String                       CATEGORY                                   = "!{category}";

    private static final String                       EMAIL                                      = "!{email}";

    private static final String                       IS_REQUESTED                               = "!{isRequested}";

    private static final String                       REASON                                     = "!{reason}";

    private static final String                       IS_TAX_OVERRIDE                            = "!{isTaxOverride}";

    private static final String                       TAXABLE_AMOUNT                             = "!{taxableAmount}";

    private static final String                       EXPIRE_DATE                                = "!{expireDate}";

    private static final String                       STATE                                      = "!{state}";

    private static final String                       CHECK_NUMBER                               = "!{checkNumber}";

    private static final String                       CAPTURE_DESCRIPTION                        = "!{captureDescription}";

    private static final String                       CAPTURE_MODE                               = "!{captureMode}";

    private static final String                       AUTHORIZATION_NUMBER                       = "!{authorizationNumber}";

    private static final String                       EXPIRATION_DATE                            = "!{expirationDate}";

    private static final String                       CARD_NUMBER_MASKED                         = "!{cardNumberMasked}";

    private static final String                       TOKEN                                      = "!{token}";

    private static final String                       IS_AUTHORIZED                              = "!{isAuthorized}";

    private static final String                       CHANGE                                     = "!{change}";

    private static final String                       UOM                                        = "!{uom}";

    private static final String                       STATUS                                     = "!{status}";

    private static final String                       DEPARTMENT                                 = "!{department}";

    private static final String                       SUBCLASS_CODE                              = "!{subclassCode}";

    private static final String                       MERCHANDISE_CODE                           = "!{merchandiseCode}";

    private static final String                       VENDOR                                     = "!{OBJET_REQUEST_VENDOR_ATTR}";

    private static final String                       PRICING                                    = "!{OBJECT_REQUEST_TIEM_PRICING_ATTR}";

    private static final String                       BUYER                                      = "!{OBJECT_REQUEST_BUYER_ATTR}";

    private static final String                       HAZARD_CLASS                               = "!{hazardClass}";

    private static final String                       CLASS_CODE                                 = "!{classCode}";

    private static final String                       DIVISION                                   = "!{division}";

    private static final String                       POS_TAX_CODE                               = "!{posTaxCode}";

    private static final String                       IS_DISCOUNTABLE                            = "!{isDiscountable}";

    private static final String                       WEIGHT                                     = "!{weight}";

    private static final String                       IS_RETURNABLE                              = "!{isReturnable}";

    private static final String                       IS_SHIP_FREIGHT                            = "!{isShipFreight}";

    private static final String                       IS_SHIP_ALONE                              = "!{isShipAlone}";

    private static final String                       IS_INSTALLABLE                             = "!{isInstallable}";

    private static final String                       IS_CLEARANCE                               = "!{isClearance}";

    private static final String                       IS_INVENTORY                               = "!{isInventory}";

    private static final String                       IS_SHIPPABLE                               = "!{isShippable}";

    private static final String                       IS_DROPSHIP                                = "!{isDropship}";

    private static final String                       IS_LABOR_SKU                               = "!{isLaborSku}";

    private static final String                       PROMPTS                                    = "!{ARRAY_REQUEST_PROMPTS_ATTR}";

    private static final String                       DISCOUNTS                                  = "!{ARRAY_REQUEST_DISCOUNTS_ATTR}";

    private static final String                       REPRICE_ITEM                               = "!{repriceItem}";

    private static final String                       SALES_PERSON                               = "!{OBJECT_REQUEST_SALESPERSON_ATTR}";

    private static final String                       IS_RETURN                                  = "!{isReturn}";

    private static final String                       IS_SPECIAL_ORDER                           = "!{isSpecialOrder}";

    private static final String                       LINE_TOTAL                                 = "!{lineTotal}";

    private static final String                       UNIT_PRICE                                 = "!{unitPrice}";

    private static final String                       QUANTITY                                   = "!{quantity}";

    private static final String                       LINE_NUMBER                                = "!{lineNumber}";

    private static final String                       PART                                       = "!{part}";

    private static final String                       NUMBER                                     = "!{number}";

    private static final String                       CREW                                       = "!{crew}";

    private static final String                       WHOLESALE                                  = "!{wholesale}";

    private static final String                       CLUB                                       = "!{club}";

    private static final String                       REGULAR                                    = "!{regular}";

    private static final String                       COST                                       = "!{cost}";

    private static final String                       TODAYS_BEST_MEMBER                         = "!{todaysBestMember}";

    private static final String                       TODAYS_BEST_RETAIL                         = "!{todaysBestRetail}";

    private static final String                       SERIAL_NUMBER                              = "!{serialNumber}";

    private static final String                       COUPON_CODE                                = "!{couponCode}";

    private static final String                       AMOUNT                                     = "!{amount}";

    private static final String                       PERCENT                                    = "!{percent}";

    private static final String                       CORRELATION_KEY                            = "!{correlationKey}";

    private static final String                       VALUE                                      = "!{value}";

    private static final String                       SEQUENCE                                   = "!{sequence}";

    private static final String                       INPUT_VALUE                                = "value";

    private static final String                       INPUT_LABEL                                = "label";

    private static final String                       SQUARE_BRACKETS_OPEN                       = "[";

    private static final String                       SQUARE_BRACKETS_CLOSE                      = "]";

    private static final String                       DATE_TIME_FORMAT                           = "yyyy-MM-dd'T'HH:mm:ssZ";

    private static final String                       INPUT_ID                                   = "id";

    private static final String                       INPUT_CHOICES                              = "choices";

    private static final String                       ARRAY_INPUTS_ATTR                          = "!{ARRAY_INPUTS_ATTR}";

    private static final String                       COST_LANDED                                = "!{costLanded}";

    private static final Logger                       _logger                                    = LogManager
            .getLogger(CawAdvancePromptingHelper.class);

    private static volatile CawAdvancePromptingHelper INSTANCE                                   = null;

    private static final String                       ANSWER                                     = "!{answer}";

    private static final String                       IS_CALLBACK_REQUIRED                       = "!{isCallbackRequired}";

    private static final String                       RESULT_CHOICES_ATTR                        = "!{RESULT_CHOICES_ATTR}";

    private static final String                       POSTAL_CODE_ATTR                           = "postalCode";

    private static final String                       STATE_PROVINCE_ATTR                        = "stateProvince";

    private static final String                       CITY_ATTR                                  = "city";

    private static final String                       COUNTRY_ATTR                               = "country";

    private static final String                       COUNTY_ATTR                                = "county";

    private static final String                       LINE4_ATTR                                 = "line4";

    private static final String                       LINE3_ATTR                                 = "line3";

    private static final String                       LINE2_ATTR                                 = "line2";

    private static final String                       LINE1_ATTR                                 = "line1";

    private static final String                       ADDRESS_ATTR                               = "address";

    private static final String                       LAST_ATTR                                  = "last";

    private static final String                       FIRST_ATTR                                 = "first";

    private static final String                       NAME_ATTR                                  = "name";

    private static final String                       YYYY_M_MDD                                 = DATE_FORMAT;

    private static final String                       ITEM_CODE                                  = "itemCode";

    private static final String                       LOC_PREPEND_FORMAT                         = "0000";

    private static final String                       MEMBERSHIPS_KEY                            = "memberships";

    /*BEGIN BZ40898*/
    private static final String                       BROKER_ITEM_DETAIL                         = "!{brokerItemDetail}";

    private static final String                       BROKER_ACTION                              = "!{brokerAction}";

    private static final String                       FULFILLMENT_SYSTEM                         = "!{fulfillmentSystem}";

    private static final String                       FULFILLMENT_LOCATION                       = "!{fulfillmentLocation}";

    private static final String                       OB_ORDER_ID                                = "!{obOrderId}";
    /*END BZ40898*/

    /* BEGIN BZ45902 */
    private static final String                       OB_REQUEST_ID                              = "!{obRequestId}";
    
    private static final String                       OB_ACTION_DESCRIPTION                      = "!{brokerActionDescription}";
    /* END BZ45902 */
    
    /* BEGIN BZ35052*/
    private static final String                       WORK_ORDER_ID                              = "id";
    private static final String                       WORK_ORDER_POS_STATUS                      = "posStatus";
    private static final String                       WORK_ORDER_DEPOSIT_POS_STATUS              = "4";
    private static final String                       WORK_ORDER_COMPLETE_POS_STATUS             = "8";
    private static final String                       WORK_ORDER_REFUND_POS_STATUS               = "16";
    
    private static final String                       CATALYST_REQUEST_ORDER_TYPE_ATTR           = "!{orderType}";
    /* END BZ35052*/

    IQueryKey<ICustomerAffiliation>                   CRM_CUSTOMER_GROUP_LOOKUP                  = new QueryKey<ICustomerAffiliation>(
            "CRM_CUSTOMER_GROUP_LOOKUP", ICustomerAffiliation.class);                                                                              // BZ24601

    /* Begin BZ28265 */

    /**
     * The SALES_CHANNEL
     */
    private static final String                       SALES_CHANNEL                              = "!{salesChannel}";

    /**
     * The CAW_CASHIER
     */
    private static final String                       CAW_CASHIER                                = "!{cashier}";

    /**
     * The CAW_ID
     */
    /**
     * The CAW_ID
     */
    private static final String                       CAW_ID                                     = "!{id}";

    /**
     * The CAW_TERMINAL
     */
    private static final String                       CAW_TERMINAL                               = "!{terminal}";

    /**
     * The CAW_CHANNELTYPE
     */
    private static final String                       CAW_CHANNELTYPE                            = "!{channelType}";

    /**
     * The CAW_CODE
     */
    private static final String                       CAW_CODE                                   = "!{code}";

    /**
     * The CAW_CASHIER_NAME
     */
    private static final String                       CAW_CASHIER_NAME                           = "!{name}";

    /**
     * The CAW_CASHIER_FILE_NUMBER
     */
    private static final String                       CAW_CASHIER_FILE_NUMBER                    = "!{fileNumber}";

    /* End BZ28265 */
    
    /*BEGIN BZ40798*/
    /**
     * The CAW_CUSTOMER_ATTTRIBUTE
     */
    private static final String                       CAW_CUSTOMER_ATTTRIBUTE                    = "!{attributes}";
    
    /**
     * The CAW_GOOD_SAM_SAVINGS
     */
    private static final String                       CAW_GOOD_SAM_SAVINGS                    = "!{goodSamSavings}";
    
    /**
     * The CAW_COULD_SAVE
     */
    private static final String                       CAW_COULD_SAVE                    = "!{couldSave}";
    /*END BZ40798*/
    
    private static final String                       CAW_REASON_CODE                    = "!{returnReason}"; //BZ53457
    
    private static final String                       CAW_ATTRIBUTES_RETURN              = ",\"attributes\": {\"returnReason\": !{returnReason},\"originalCorrelationKey\": !{originalCorrelationKey},!{wo}}"; //BZ53722
    
    /*BEGIN BZ53752*/
    private static final String                       CAW_UNIT_OF_MEASURE_ATTR                      = "!{unitOfMeasure}";
    private static final String                       CAW_UNIT_OF_LIST_PRICE_ATTR                   = "!{unitListPrice}";
    private static final String                       CAW_TAX_CODE_ATTR                             = "!{taxCode}";
    private static final String                       CAW_TAX_AMOUNT_ATTR                           = "!{taxAmount}";
    
    private static final String                       CAW_SHIP_TO_INFO_ATTR                         = "!{shipToInfo}";
    private static final String                       CAW_NAME_SHIP_TO_INFO_ATTR                    = "!{nameShip}";
    private static final String                       CAW_LINE1_SHIP_TO_INFO_ATTR                   = "!{line1Ship}";
    private static final String                       CAW_CITY_SHIP_TO_INFO_ATTR                    = "!{cityShip}";
    private static final String                       CAW_STATE_PROVINCE_SHIP_TO_INFO_ATTR          = "!{stateProvinceShip}";
    private static final String                       CAW_POSTAL_CODE_SHIP_TO_INFO_ATTR             = "!{postalCodeShip}";
    private static final String                       CAW_COUNTRY_SHIP_TO_INFO_ATTR                 = "!{countryShip}";
    private static final String                       CAW_SHIP_VIA_SHIP_TO_INFO_ATTR                = "!{shipVia}";
    private static final String                       CAW_SERVICE_SHIP_TO_INFO_ATTR                 = "!{serviceLevel}";
    
    private static final String                       CAW_ADJUSTMENTS_ATTR                          = "!{adjustments}";
    private static final String                       CAW_ADJUSTMENTS_CORRELATION_KEY_ATTR          = "!{correlationKey}";
    private static final String                       CAW_ADJUSTMENTS_TYPE_ATTR                     = "!{type}";
    private static final String                       CAW_ADJUSTMENTS_AMOUNT_ATTR                   = "!{amount}";
    private static final String                       CAW_ADJUSTMENTS_COUPON_CODE_ATTR              = "!{couponCode}";
    private static final String                       CAW_ADJUSTMENTS_SERIALIZED_ATTR               = "!{serializedCouponCode}";
    
    private static final String                       CAW_PROPERTIES_ATTR                           = "!{properties}";
    
    private static final String                       CAW_WO_ATTR_SALE                              = "!{wo}";
    private static final String                       CAW_WO_ATTR_RETURN                            = ",!{wo}";
    private static final String                       CAW_ATTRIBUTES_WO_SALE                        = ",\"attributes\": {!{wo}}";
    
    
    /*END BZ53752*/
    
    public static CawAdvancePromptingHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawAdvancePromptingHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawAdvancePromptingHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Get work order template of transaction
     * @return
     */
    public String getWorkOderDetailTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR);
        String body = request.getBody();
        body = body.replace(ID, NUMBER_DEFAULT);
        body = body.replace(TYPE, CawJSONConstant.NULL);
        body = body.replace(DEPOSIT_LOCATION, CawJSONConstant.NULL);
        body = body.replace(PICKUP_LOCATION, CawJSONConstant.NULL);

        return body;
    }

    /**
     * Get audit attribute
     * @return
     */
    public String getAuditTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_AUDIT_ATTR);
        String body = request.getBody();
        body = body.replace(ENTERPRISE_SYSTEM, CawJSONConstant.NULL);
        body = body.replace(ENTERPRISE_DATE, CawUtilFunction.formatParameter("2016-10-31T18:16:26.002Z"));
        body = body.replace(USER_SYSTEM, CawJSONConstant.NULL);
        body = body.replace(USER_DATE, CawUtilFunction.formatParameter("2016-10-31T18:16:26.002Z"));
        body = body.replace(USER_NAME, CawJSONConstant.NULL);
        body = body.replace(ORIGIN, CawJSONConstant.NULL);

        return body;
    }

    /**
     * 
     * @param party
     * @return
     */
    public String getNameTemplate(IParty party) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_NAME_ATTR);
        String body = request.getBody();
        body = body.replace(AUDIT, getAuditTemplate());
        body = body.replace(PREFIX, CawJSONConstant.NULL);
        body = body.replace(FIRST, CawUtilFunction.formatParameter(party.getFirstName()));
        body = body.replace(MIDDLE, CawJSONConstant.NULL);
        body = body.replace(LAST, CawUtilFunction.formatParameter(party.getLastName()));
        body = body.replace(SUFFIX, CawJSONConstant.NULL);
        body = body.replace(COMPANY, CawJSONConstant.NULL);

        return body;
    }

    //Begin BZ23478
    /**
     * 
     * @param party
     * @param response
     * @return
     */
    public void changeCustomerNameAttr(IParty party, JSONObject response) {

        if (response != null && party != null) {

            try {
                /* Begin BZ28510 */
                int customerType = response.getInt(CUSTOMER_TYPE_ATTR);

                if (customerType == CawJSONConstant.ONE) {
                    if (party.getFirstName() != null) {
                        response.getJSONObject(NAME_ATTR)
                                .put(FIRST_ATTR, CawUtilFunction.formatParameter(party.getFirstName()));//BZ23637
                    }

                    if (party.getLastName() != null) {
                        response.getJSONObject(NAME_ATTR)
                                .put(LAST_ATTR, CawUtilFunction.formatParameter(party.getLastName()));//BZ23637
                    }
                } else {
                    response.getJSONObject(NAME_ATTR).putOnce(FIRST_ATTR, null);

                    response.getJSONObject(NAME_ATTR).putOnce(LAST_ATTR, null);
                }
                /* End BZ28510 */
            } catch (JSONException ex) {
                _logger.error("Can not build name attribute of customer." + ex.getMessage());
            }
        }
    }
    //End BZ23478

    /**
     * 
     * @return
     */
    public String getAddressTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_ADDRESS_ATTR);
        String body = request.getBody();
        body = body.replace(AUDIT, getAuditTemplate());
        body = body.replace(LINE1, CawJSONConstant.NULL);
        body = body.replace(LINE2, CawJSONConstant.NULL);
        body = body.replace(LINE3, CawJSONConstant.NULL);
        body = body.replace(LINE4, CawJSONConstant.NULL);
        body = body.replace(CITY, CawJSONConstant.NULL);
        body = body.replace(STATE_PROVINCE, CawJSONConstant.NULL);
        body = body.replace(POSTAL_CODE, CawJSONConstant.NULL);
        body = body.replace(COUNTRY, CawJSONConstant.NULL);
        body = body.replace(COUNTY, CawJSONConstant.NULL);

        return body;
    }

    //Begin BZ23478
    /**
     * 
     * @param argIParty
     * @param response
     * @return
     */
    public void changeAddressAttr(IParty argIParty, JSONObject response) {

        try {
            if (argIParty != null && argIParty.getLocaleInformation() != null) {
                CawCustomerAddress address = new CawCustomerAddress();
                for (IPartyLocaleInformation localeInfo : argIParty.getLocaleInformation()) {
                    address.setAddressType(CawEBSConstant.ADDRESS_TYPE);
                    address.setAddressTypeDescription(localeInfo.getAddressType());
                    address.setIsDeliverable(localeInfo.getContact());
                    address.setLine1(localeInfo.getAddress1());
                    address.setLine2(localeInfo.getAddress2());
                    address.setLine3(localeInfo.getAddress3());
                    address.setLine4(localeInfo.getAddress4());
                    address.setCity(localeInfo.getCity());
                    address.setStateProvince(localeInfo.getState());
                    address.setPostalCode(localeInfo.getPostalCode());
                    address.setCountry(localeInfo.getCountry());
                    address.setCounty(localeInfo.getCounty());
                }

                if (address.getLine1() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(LINE1_ATTR, CawUtilFunction.formatParameter(address.getLine1()));//BZ23637
                }

                if (address.getLine2() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(LINE2_ATTR, CawUtilFunction.formatParameter(address.getLine2()));//BZ23637
                }

                if (address.getLine3() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(LINE3_ATTR, CawUtilFunction.formatParameter(address.getLine3()));//BZ23637
                }

                if (address.getLine4() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(LINE4_ATTR, CawUtilFunction.formatParameter(address.getLine4()));//BZ23637
                }

                if (address.getCity() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(CITY_ATTR, CawUtilFunction.formatParameter(address.getCity()));//BZ23637
                }

                if (address.getStateProvince() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(STATE_PROVINCE_ATTR, CawUtilFunction.formatParameter(address.getStateProvince()));//BZ23637
                }

                if (address.getPostalCode() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(POSTAL_CODE_ATTR, CawUtilFunction.formatParameter(address.getPostalCode()));//BZ23637
                }

                if (address.getCountry() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(COUNTRY_ATTR, CawUtilFunction.formatParameter(address.getCountry()));//BZ23637
                }

                if (address.getCounty() != null) {
                    response.getJSONObject(ADDRESS_ATTR)
                            .put(COUNTY_ATTR, CawUtilFunction.formatParameter(address.getCounty()));//BZ23637
                }

            }
        } catch (Exception ex) {
            _logger.error("Can not build adress attribute of customer." + ex.getMessage());
        }
    }
    //End BZ23478

    /**
     * Get membership attribute
     * @return
     */
    public String getMembershipAlertTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_MEMBERSHIPS_ALERTS_ATTR);
        String body = request.getBody();
        body = body.replace(CODE, CawJSONConstant.NULL);
        body = body.replace(DESCRIPTION, CawJSONConstant.NULL);
        body = body.replace(MESSAGE, CawJSONConstant.NULL);
        body = body.replace(SEVERITY, CawJSONConstant.NULL);

        return body;
    }

    /**
     * 
     * @return
     */
    public String getMembershipTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_MEMBERSHIPS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(ALERTS, getMembershipAlertTemplate());
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(IDENTIFIER, fmtNull);
        body = body.replace(TYPE, fmtNull);
        body = body.replace(TYPE_DESCRIPTION, fmtNull);
        body = body.replace(JOIN_DATE, fmtNull);
        body = body.replace(EXPIRE_DATE, fmtNull);
        body = body.replace(STATUS, fmtNull);
        body = body.replace(STATUS_DESCRIPTION, fmtNull);
        body = body.replace(DISPLAY_TEXT, fmtNull);
        body = body.replace(IS_AUTO_RENEW, Boolean.TRUE.toString());
        body = body.replace(MEMBER_TYPE, fmtNull);
        body = body.replace(MEMBER_TYPE_DESCRIPTION, fmtNull);
        body = body.replace(PSEUDO_NUMBER, fmtNull);
        body = body.replace(BENEFIT_LEVEL_NUMBER, NUMBER_DEFAULT);
        body = body.replace(BENEFIT_LEVEL_NAME, fmtNull);
        body = body.replace(BENEFIT_LEVEL_DESCRIPTION, fmtNull);
        body = body.replace(CARD_COLOR, fmtNull);
        body = body.replace(DISCOUNT_GAS, NUMBER_DEFAULT);
        body = body.replace(DISCOUNT_DIESEL, NUMBER_DEFAULT);

        return body;
    }

    /**
     * Get Phone attribute of json
     * @return
     */
    public String getPhoneTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_PHONES_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(IDENTIFIER, NUMBER_DEFAULT);
        body = body.replace(TYPE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(NUMBER, fmtNull);
        body = body.replace(IS_ACTIVE, Boolean.TRUE.toString());
        body = body.replace(IS_PRIMARY, Boolean.TRUE.toString());

        return body;
    }

    /**
     * 
     * @return
     */
    public String getPartnerTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_PARTNERS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(IDENTIFIER, NUMBER_DEFAULT);
        body = body.replace(TYPE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(STATUS, fmtNull);
        body = body.replace(STATUS_DESCRIPTION, fmtNull);
        body = body.replace(FIRST_NAME, fmtNull);
        body = body.replace(MIDDLE_NAME, fmtNull);
        body = body.replace(LAST_NAME, fmtNull);
        body = body.replace(COMPANY_NAME, fmtNull);

        return body;
    }

    /**
     * 
     * @return
     */
    public String getPricingTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_PRICING_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(IDENTIFIER, NUMBER_DEFAULT);
        body = body.replace(BAND, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(PRICE_COMPARE_BAND, fmtNull);
        body = body.replace(PRICE_COMPARE_BAND_ID, NUMBER_DEFAULT);
        body = body.replace(MEMBERSHIPS, getMembershipTemplate());

        return body;
    }

    /**
     * 
     * @return
     */
    public String getChoiceTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_CHOICES_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(VALUE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(IS_SELECTED, Boolean.TRUE.toString());
        body = body.replace(REQUIRE_PREFERENCE_CODE, fmtNull);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getPreferencesTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_PREFERENCES_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(CHOICES, getChoiceTemplate());
        body = body.replace(CODE, fmtNull);
        body = body.replace(LABEL, fmtNull);
        body = body.replace(SCRIPT, fmtNull);
        body = body.replace(IS_REQUIRED, Boolean.TRUE.toString());
        body = body.replace(IS_REQUESTED, Boolean.TRUE.toString());
        body = body.replace(IS_READ_ONLY, Boolean.TRUE.toString());
        body = body.replace(IS_VISIBLE, Boolean.TRUE.toString());
        body = body.replace(LAST_UPDATE_DATE, fmtNull);
        body = body.replace(INPUT_TYPE, fmtNull);

        return body;
    }

    //Begin BZ23478
    /**
     * 
     * @param party
     * @param lookupResponse
     * @return
     */
    public String getCustomerTemplate(IParty party, String lookupResponse) {

        String body = CawJSONConstant.NULL;
        if (party != null && StringUtils.isNotEmpty(lookupResponse)) {
            try {
                CawRestConfig request = CawRestConfigHelper.getInstance()
                        .getRestRequest(CawEBSConstant.REQUEST_CUSTOMER_ATTR);
                body = request.getBody();

                JSONObject response = new JSONObject(lookupResponse);
                changeCustomerNameAttr(party, response);
                changeAddressAttr(party, response);
                changePricingOfCustomer(party, response);
                body = response.toString();

                body = body.replace("\\\"", "");

            } catch (Exception ex) {
                _logger.error("Can get customer from Lookup API response json." + ex.getMessage());
            }
        }
        return body;
    }
    //End BZ23478

    /**
     * 
     * @return
     */
    public String getPromptsObjTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_PROMPTS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(SEQUENCE, NUMBER_DEFAULT);
        body = body.replace(CODE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(VALUE, fmtNull);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getDiscountsArrTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_DISCOUNTS_ATTR);
        String body = request.getBody();
        body = body.replace(CORRELATION_KEY, CawJSONConstant.NULL);
        body = body.replace(TYPE, CawJSONConstant.NULL);
        body = body.replace(PERCENT, NUMBER_DEFAULT);
        body = body.replace(AMOUNT, NUMBER_DEFAULT);
        body = body.replace(DESCRIPTION, CawJSONConstant.NULL);
        body = body.replace(COUPON_CODE, CawJSONConstant.NULL);
        body = body.replace(SERIAL_NUMBER, CawJSONConstant.NULL);
        return body;
    }

    /* Begin BZ28265 */
    /**
     * @param commission
     * @return
     */
    public String getSalesPersonObjTemplate(ICommissionModifier commission) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_SALESPERSON_ATTR);

        String body = request.getBody();

        String name = "";

        if (commission != null) {
            IParty party = commission.getEmployeeParty();
            if (party != null) {
                body = body.replace(CODE, CawUtilFunction.formatParameter(String.format("%s", party.getEmployeeId())));
                body = body.replace(FILE_NUMBER, CawUtilFunction
                        .formatParameter(String.format("%s", commission.getEmployeePartyId())));
                name = party.getFirstName() + " " + party.getLastName();
                body = body.replace(NAME, CawUtilFunction.formatParameter(String.format("%s", name)));
            }
        }

        return body;
    }

    /* End BZ28265 */

    /**
     * 
     * @return
     */
    public String getBuyerObjTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_BUYER_ATTR);
        String body = request.getBody();
        body = body.replace(ID, NUMBER_DEFAULT);
        body = body.replace(NAME, CawJSONConstant.NULL);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getItemPricingObjTemplate(ISaleReturnLineItem lineItem) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_TIEM_PRICING_ATTR);
        String body = request.getBody();
        body = body.replace(TODAYS_BEST_RETAIL, NUMBER_DEFAULT);
        body = body.replace(TODAYS_BEST_MEMBER, NUMBER_DEFAULT);
        body = body.replace(COST_LANDED, NUMBER_DEFAULT);

        if (lineItem != null && lineItem.getItem() != null) {
            if (lineItem.getItem().getOptions() != null) {
                body = body.replace(COST, String.valueOf(lineItem.getItem().getOptions().getUnitCost()));
            }

            List<String> argPriceTypes = new ArrayList<String>();
            argPriceTypes.add(PRICE_CLUB);
            argPriceTypes.add(PRICE_CLUB);
            argPriceTypes.add(PRICE_WHSL);
            argPriceTypes.add(PRICE_CREW);

            Collection<IItemPrices> iItemPrices = PriceProvider.getAllBestPricesByType(lineItem.getItemId(), lineItem
                    .getBusinessDate(), null, lineItem.getQuantity(), argPriceTypes);

            body = body.replace(REGULAR, getPriceOfItem(iItemPrices, PRICE_RETL));
            body = body.replace(CLUB, getPriceOfItem(iItemPrices, PRICE_CLUB));
            body = body.replace(WHOLESALE, getPriceOfItem(iItemPrices, PRICE_WHSL));
            body = body.replace(CREW, getPriceOfItem(iItemPrices, PRICE_CREW));
        } else {
            body = body.replace(REGULAR, NUMBER_DEFAULT);
            body = body.replace(CLUB, NUMBER_DEFAULT);
            body = body.replace(WHOLESALE, NUMBER_DEFAULT);
            body = body.replace(CREW, NUMBER_DEFAULT);
        }

        return body;
    }

    /**
     * 
     * @param iItemPrices
     * @param pricePropertyCode
     * @return
     */
    private String getPriceOfItem(Collection<IItemPrices> iItemPrices, String pricePropertyCode) {

        String price = NUMBER_DEFAULT;
        if (iItemPrices != null && iItemPrices.size() > 0) {
            for (IItemPrices catalystItemPriceModel : iItemPrices) {
                if (pricePropertyCode != null && catalystItemPriceModel.getItemPricePropertyCode() != null) {
                    if (pricePropertyCode.equals(catalystItemPriceModel.getItemPricePropertyCode())) {
                        if (catalystItemPriceModel.getPrice() != null) {
                            price = String.valueOf(catalystItemPriceModel.getPrice());
                            break;
                        }
                    }
                }
            }
        }

        return price;
    }

    /**
     * 
     * @param transLineItem
     * @return
     */
    public String getVendorObjTemplate(ISaleReturnLineItem transLineItem) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_VENDOR_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        // Begin BZ23416
        if (transLineItem.getVendorId() != null) {//BZ23541
            if (transLineItem.getVendorId() != null) {
                body = body.replace(NUMBER, CawUtilFunction.formatParameter(transLineItem.getVendorId()));
            } else {
                body = body.replace(NUMBER, fmtNull);
            }

            if (transLineItem.getItem() != null //BZ23541
                    && transLineItem.getItem().getOptions() != null
                    && transLineItem.getItem().getOptions().getItemVendor().getName() != null) {
                body = body.replace(NAME, CawUtilFunction
                        .formatParameter(transLineItem.getItem().getOptions().getItemVendor().getName()));
            } else {
                body = body.replace(NAME, fmtNull);
            }

            if (transLineItem.getItem() != null //BZ23541
                    && transLineItem.getItem().getOptions() != null
                    && transLineItem.getItem().getOptions().getItemVendor() != null
                    && transLineItem.getItem().getOptions().getItemVendor().getAddressId() != null) {
                body = body.replace(PART, CawUtilFunction
                        .formatParameter(transLineItem.getItem().getOptions().getItemVendor().getAddressId()));
            } else {
                body = body.replace(PART, fmtNull);
            }
        } else {
            body = fmtNull;
        }
        // End BZ23416

        return body;
    }

    /**
     * 
     * @param iPosTransaction
     * @return
     */
    public String getItemsArrTemplate(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder) {/*BZ40898*/
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_ITEMS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = null;
        int lineNumber = 0;
        if (iPosTransaction != null) {
            List<ISaleReturnLineItem> transLineItems = iPosTransaction
                    .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);

            for (ISaleReturnLineItem transLineItem : transLineItems) {
                // Begin BZ23722
                if (!transLineItem.getVoid()) {
                    lineNumber++;
                    temp = String.valueOf(body);
                    String correlationKey = getCorrelationKey(iPosTransaction, stationState);
                    if (!correlationKey.equals(fmtNull)) {
                        correlationKey = correlationKey + ":" + String.valueOf(lineNumber); //BZ51922
                    }
                    // End BZ23722

                    temp = temp.replace(CORRELATION_KEY, CawUtilFunction.formatParameter(correlationKey));
                    // End BZ23722
                    temp = temp.replace(LINE_NUMBER, Integer.toString(lineNumber));

                    if (transLineItem.getQuantity() != null) {//BZ23541
                        temp = temp.replace(QUANTITY, String.valueOf(transLineItem.getQuantity().doubleValue())); //BZ54998
                    } else {
                        temp = temp.replace(QUANTITY, fmtNull);
                    }

                    if (transLineItem.getUnitCost() != null) {//BZ23541
                        temp = temp.replace(COST, transLineItem.getUnitCost().toString());
                    } else {
                        temp = temp.replace(COST, fmtNull);
                    }

                    if (transLineItem.getUnitPrice() != null) {//BZ23541
                        temp = temp.replace(UNIT_PRICE, transLineItem.getUnitPrice().toString());
                    } else {
                        temp = temp.replace(UNIT_PRICE, fmtNull);
                    }

                    if (transLineItem.getExtendedAmount() != null) {//BZ23541
                        temp = temp.replace(LINE_TOTAL, transLineItem.getExtendedAmount().toString());
                    } else {
                        temp = temp.replace(LINE_TOTAL, fmtNull);
                    }

                    temp = temp.replace(IS_SPECIAL_ORDER, fmtNull);
                    temp = temp.replace(IS_RETURN, Boolean.toString(transLineItem.getReturn()));
                    /* Begin BZ28265 */
                    if (transLineItem.getCommissionModifiers() != null
                            && transLineItem.getCommissionModifiers().size() > 0) {
                        temp = temp.replace(SALES_PERSON, getSalesPersonObjTemplate(transLineItem
                                .getCommissionModifiers().get(0)));
                    }
                    // Begin BZ37609
                    else if (transLineItem.getCommissionModifiers().size() <= 0) {                       
                        IParty party = iPosTransaction.getOperatorParty();
                        String name = party.getFirstName() + " " + party.getLastName();
                   
                        JSONObject salesPersion = new JSONObject();
                        try {
                            salesPersion.put("code", party.getEmployeeId());
                            salesPersion.put("fileNumber",party.getEmployeeId());
                            salesPersion.put("name", name);
                        } catch (JSONException ex) {
                            _logger.error("Can not build json request for catalyst service :" + ex.getMessage());
                        }
                                                
                        temp = temp.replace(SALES_PERSON, salesPersion.toString());       
                    }
                    // End BZ37609
                    
                    /* BEGIN BZ30084 */
                    else {
                        temp = temp.replace(SALES_PERSON, fmtNull);
                    }
                    /* END BZ30084 */
                    /* End BZ28265 */
                    temp = temp.replace(REPRICE_ITEM, BOOLEAN_DEFAULT);

                    temp = temp.replace(DISCOUNTS, getDiscountsArrTemplate());
                    temp = temp.replace(PROMPTS, getPromptsObjTemplate());

                    temp = temp.replace(CODE, CawUtilFunction.formatParameter(transLineItem.getItemId()));

                    temp = temp.replace(TYPE, fmtNull);
                    temp = temp.replace(STATUS, fmtNull);

                    if (transLineItem.getTareUnitOfMeasureCode() != null) {//BZ23637
                        temp = temp.replace(UOM, transLineItem.getTareUnitOfMeasureCode());
                    } else {
                        temp = temp.replace(UOM, fmtNull);
                    }

                    temp = temp.replace(DIVISION, fmtNull);

                    if (transLineItem.getItem() != null) {//BZ23637
                        temp = temp.replace(DEPARTMENT, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel1Id()));
                        temp = temp.replace(CLASS_CODE, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel3Id()));
                        temp = temp.replace(SUBCLASS_CODE, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel4Id()));
                    } else {
                        temp = temp.replace(DEPARTMENT, fmtNull);
                        temp = temp.replace(CLASS_CODE, fmtNull);
                        temp = temp.replace(SUBCLASS_CODE, fmtNull);
                    }

                    temp = temp.replace(HAZARD_CLASS, fmtNull);
                    /*BEGIN BZ40898*/
                    if(transLineItem.getOrderModifier() != null) {
                        int lineItemSequence = transLineItem.getRetailTransactionLineItemSequence();
                        int oderLineItemSequence = 0;
                        IOrderLine order = null;
                        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                            
                            oderLineItemSequence = orderLine.getShadowedSaleItem().getRetailTransactionLineItemSequence();
                            if(lineItemSequence == oderLineItemSequence) {
                                order = orderLine;
                                break;
                            }
                        }
                        if(order != null) {
                            temp = temp.replace(BROKER_ITEM_DETAIL, getBrokerItemDetailTemplate(order, currentOrder.getOrderType())); //BZ45902
                        } else {
                            temp = temp.replace(BROKER_ITEM_DETAIL, CawJSONConstant.NULL);
                        } 
                        
                    } else {
                        temp = temp.replace(BROKER_ITEM_DETAIL, CawJSONConstant.NULL);
                    }
                    /*END BZ40898*/
                    temp = temp.replace(MERCHANDISE_CODE, fmtNull);

                    temp = temp.replace(BUYER, getBuyerObjTemplate());

                    temp = temp.replace(PRICING, getItemPricingObjTemplate(transLineItem));
                    temp = temp.replace(VENDOR, getVendorObjTemplate(transLineItem));

                    if (transLineItem.getItemDescription() != null) {
                        String itemDescription = StringEscapeUtils.escapeJson(transLineItem.getItemDescription());
                        temp = temp.replace(DESCRIPTION, CawUtilFunction.formatParameter(itemDescription));//BZ23722
                    } else {
                        temp = temp.replace(DESCRIPTION, fmtNull);
                    }

                    if (transLineItem.getTaxGroupId() != null) {
                        temp = temp
                                .replace(POS_TAX_CODE, CawUtilFunction.formatParameter(transLineItem.getTaxGroupId()));
                    } else {
                        temp = temp.replace(POS_TAX_CODE, fmtNull);
                    }

                    temp = temp.replace(IS_INSTALLABLE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_RETURNABLE, Boolean
                            .toString(!(transLineItem.getItem().getOptions().getNotReturnable())));
                    temp = temp.replace(WEIGHT, NUMBER_DEFAULT);
                    temp = temp.replace(IS_SHIPPABLE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_INVENTORY, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_CLEARANCE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_DROPSHIP, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_SHIP_FREIGHT, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_SHIP_ALONE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_DISCOUNTABLE, Boolean
                            .toString(!(transLineItem.getItem().getOptions().getDisallowDiscounts())));
                    temp = temp.replace(IS_LABOR_SKU, BOOLEAN_DEFAULT);
                    
                    resultBuilder.append(temp);
                    resultBuilder.append(",");
                }
                if (resultBuilder.length() > 0) {
                    result = SQUARE_BRACKETS_OPEN
                            + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                            + SQUARE_BRACKETS_CLOSE;
                }
            }
        }

        return result;
    }

    /**
     * 
     * @return
     */
    public String getPaymentsArrTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_PAYMENTS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(CORRELATION_KEY, fmtNull);
        body = body.replace(TYPE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(AMOUNT, NUMBER_DEFAULT);
        body = body.replace(CHANGE, NUMBER_DEFAULT);
        body = body.replace(IS_AUTHORIZED, BOOLEAN_DEFAULT);
        body = body.replace(TOKEN, fmtNull);
        body = body.replace(CARD_NUMBER_MASKED, fmtNull);
        body = body.replace(EXPIRATION_DATE, fmtNull);
        body = body.replace(AUTHORIZATION_NUMBER, fmtNull);
        body = body.replace(CAPTURE_MODE, fmtNull);
        body = body.replace(CAPTURE_DESCRIPTION, fmtNull);
        body = body.replace(CHECK_NUMBER, fmtNull);
        body = body.replace(NUMBER, fmtNull);
        body = body.replace(STATE, fmtNull);
        body = body.replace(EXPIRE_DATE, fmtNull);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getTaxesArrTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.REQUEST_TAXES_ATTR);
        String body = request.getBody();
        body = body.replace(CORRELATION_KEY, CawJSONConstant.NULL);
        body = body.replace(CODE, CawJSONConstant.NULL);
        body = body.replace(DESCRIPTION, CawJSONConstant.NULL);
        body = body.replace(COUPON_CODE, CawJSONConstant.NULL);
        body = body.replace(SERIAL_NUMBER, CawJSONConstant.NULL);
        body = body.replace(TAXABLE_AMOUNT, NUMBER_DEFAULT);
        body = body.replace(AMOUNT, NUMBER_DEFAULT);
        body = body.replace(IS_TAX_OVERRIDE, BOOLEAN_DEFAULT);

        return body;
    }

    /**
     * 
     * @return
     */
    public String getPaidInOutDetailObjTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_PAIDINOUTDETAIL_ATTR);
        String body = request.getBody();
        body = body.replace(TYPE, CawJSONConstant.NULL);
        body = body.replace(CODE, CawJSONConstant.NULL);
        body = body.replace(REASON, CawJSONConstant.NULL);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getEReceiptDetailObjTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_ERECEIPTDETAIL_ATTR);
        String body = request.getBody();
        body = body.replace(IS_REQUESTED, CawJSONConstant.NULL);
        body = body.replace(EMAIL, CawJSONConstant.NULL);
        body = body.replace(NAME, CawJSONConstant.NULL);
        return body;
    }

    /**
     * 
     * @return
     */
    public String getOracleDetailObjTemplate() {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_ORACLEDETAIL_ATTR);
        String body = request.getBody();
        body = body.replace(TYPE, CawJSONConstant.NULL);
        body = body.replace(CATEGORY, CawJSONConstant.NULL);
        return body;
    }

    /**
     * 
     * @param party
     * @param lookupResponse
     * @param iPosTransaction
     * @return
     */
    public String buildCatalystRequest(IParty party, String lookupResponse, IPosTransaction iPosTransaction,
            StationState stationState) {//BZ23478

        // End BZ23722
        String body = CawJSONConstant.NULL;
        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.CATALYST_REQUEST_TEMPLATE);
        if (request != null && request.getBody() != null) {
            body = request.getBody();
            /* Begin BZ28265 */
            body = body.replace(SALES_CHANNEL, buildSalesChannel(iPosTransaction));

            body = body.replace(CAW_CASHIER, buildCashier(iPosTransaction));

            body = body.replace(CAW_ID, buildId(iPosTransaction));
            /* End BZ28265 */
            //transaction
            body = body.replace(CORRELATION_KEY, CawUtilFunction
                    .formatParameter(getCorrelationKey(iPosTransaction, stationState)));//BZ23722
            body = body.replace(SOURCE_CORRELATION_KEY, CawJSONConstant.NULL);
            body = body.replace(ORIGINAL_CORRELATION_KEY, CawJSONConstant.NULL);
            //workOrderDetail
            body = body.replace(CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR, CawJSONConstant.NULL);
            body = body.replace(CATALYST_REQUEST_ORDER_TYPE_ATTR, CawConstants.VALUE_0); //BZ35052

            body = body.replace(CREATE_DATE, CawJSONConstant.NULL);
            body = body.replace(TYPE_CODE, CawJSONConstant.NULL);
            body = body.replace(STATUS, CawJSONConstant.NULL);
            body = body.replace(DESCRIPTION, CawJSONConstant.NULL);
            body = body.replace(TOTAL, NUMBER_DEFAULT);
            body = body.replace(TOTAL_TAX, NUMBER_DEFAULT);
            body = body.replace(IS_TAX_EXEMPT, BOOLEAN_DEFAULT);
            body = body.replace(IS_TAX_OVERRIDE, BOOLEAN_DEFAULT);
            body = body.replace(IS_PREPAY, BOOLEAN_DEFAULT);
            body = body.replace(TAX_EXEMPT_CERTIFICATE, CawJSONConstant.NULL);
            // body = body.replace(CATALYST_REQUEST_TRANSACTION_EMPLOYEE_ATTR, CawJSONConstant.NULL); // BZ28792 removed employee
            body = body.replace(START_DATE_TIME, CawJSONConstant.NULL);
            body = body.replace(END_DATE_TIME, CawJSONConstant.NULL);

            //location
            body = body
                    .replace(CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR, getTransactionLocationDetailTemplate(iPosTransaction, stationState));

            //customer
            body = body.replace(OBJECT_REQUEST_CUSTOMER_ATTR, getCustomerTemplate(party, lookupResponse));

            //thirdPartyPayer
            body = body.replace(OBJECT_REQUEST_THIRDPARTYPAYER_ATTR, CawJSONConstant.NULL);

            //prompts
            body = body.replace(ARRAY_REQUEST_PROMPTS_ATTR, CawJSONConstant.NULL);
            //items
            body = body.replace(ARRAY_REQUEST_ITEMS_ATTR, CawJSONConstant.NULL);
            //invoices
            body = body.replace(ARRAY_REQUEST_INVOICES_ATTR, CawJSONConstant.NULL);
            //taxes
            body = body.replace(ARRAY_REQUEST_TAXES_ATTR, CawJSONConstant.NULL);
            //discounts
            body = body.replace(ARRAY_REQUEST_DISCOUNTS_ATTR, CawJSONConstant.NULL);
            //paidInOutDetail
            body = body.replace(OBJECT_REQUEST_PAIDINOUTDETAIL_ATTR, CawJSONConstant.NULL);
            //purchaseOrder
            body = body.replace(PURCHASE_ORDER, CawJSONConstant.NULL);
            // BZ28265 removed redundant code here(receipt type and email receipt)
            //oracleDetail
            body = body.replace(OBJECT_REQUEST_ORACLEDETAIL_ATTR, CawJSONConstant.NULL);

            body = body.replace(TYPE, VALUE_1);

            // body = body.replace(PROPERTIES, buildProperties(stationState)); // BZ28265
            
            // Start BZ40798
            // Do not send goodSamSaving and couldSave in catalyst 1.
            body = body.replace(CAW_CUSTOMER_ATTTRIBUTE, CawJSONConstant.SPACE_CHARACTER);
            // End BZ40798
        }
        return body;
    }

    /**
     * 
     * @param tran
     * @param propertyName
     * @param propertyValue
     * @param type
     */
    public void saveAdvancePromptingInfo(IPosTransaction tran, String propertyName, String propertyValue, String type) {

        PosTransactionPropertyId id = new PosTransactionPropertyId();
        id.setOrganizationId(ConfigurationMgr.getOrganizationId()); // BZ24837
        id.setRetailLocationId(tran.getRetailLocationId());
        id.setBusinessDate(tran.getBusinessDate());
        id.setWorkstationId(tran.getWorkstationId());
        id.setTransactionSequence(tran.getTransactionSequence());
        id.setPropertyCode(propertyName);

        // BEGIN BZ40798
        IPosTransactionProperty transProperty = DataFactory
                .createObject(id, IPosTransactionProperty.class);
        transProperty.setType(type);
        transProperty.setStringValue(propertyValue);

        ((IDataModelImpl) transProperty).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
        
        DataFactory.makePersistent(transProperty);
        // END BZ40798
    }

    /**
     * 
     * @param catalystResponse
     * @param key
     * @return
     */
    public JSONArray getCatalystInputsField(String catalystResponse, String key) {

        JSONArray inputFileds = null;
        if (StringUtils.isNotEmpty(catalystResponse)) {
            try {
                JSONObject responseData = new JSONObject(catalystResponse);
                inputFileds = responseData.getJSONArray(key);
            } catch (JSONException ex) {
                _logger.error("Can not parse json response from catalyst service to Json:" + ex.getMessage());
            }
        }

        return inputFileds;
    }

    /**
     * 
     * @param choices
     * @return
     * @throws JSONException
     */
    public List<CawInputSingleChoice> getSingleSelectData(JSONArray choices) throws JSONException {

        List<CawInputSingleChoice> cawInputSingleChoices = new ArrayList<CawInputSingleChoice>();
        if (choices != null && choices.length() > 0) {
            for (int i = 0; i < choices.length(); i++) {
                CawInputSingleChoice cawInputSingleChoice = new CawInputSingleChoice();
                cawInputSingleChoice.setInputLable(choices.getJSONObject(i).getString(INPUT_LABEL));
                cawInputSingleChoice.setInputId(choices.getJSONObject(i).getString(INPUT_VALUE));
                cawInputSingleChoices.add(cawInputSingleChoice);
            }
        }

        return cawInputSingleChoices;

    }

    /**
     * 
     * @param choices
     * @return
     * @throws JSONException
     */
    public List<String> getMultiSelectData(JSONArray choices) throws JSONException {

        List<String> cawInputSingleChoices = new ArrayList<String>();
        if (choices != null && choices.length() > 0) {
            for (int i = 0; i < choices.length(); i++) {
                cawInputSingleChoices.add(choices.getJSONObject(i).getString(INPUT_LABEL));
            }
        }

        return cawInputSingleChoices;
    }

    /**
     * 
     * @param type
     * @param directiveData
     * @return
     */
    public Boolean isExistDirectiveType(int type, JSONObject directiveData) {

        Boolean isExist = Boolean.FALSE;
        if (directiveData != null) {
            try {
                JSONArray jsonArray = directiveData.getJSONArray(CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (type == jsonArray.getJSONObject(i).getInt("type")) {
                        isExist = Boolean.TRUE;
                        break;
                    }
                }
            } catch (JSONException ex) {
                _logger.error("Can not get property from Json data." + ex.getMessage());
            }
        }

        return isExist;
    }

    /**
     * 
     * @param iPosTransaction
     * @return retail location message
     */
    public String getTransactionLocationDetailTemplate(IPosTransaction iPosTransaction, StationState stationState) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR);

        String body = request.getBody();
        // Begin BZ23722
        DecimalFormat df = new DecimalFormat(LOC_PREPEND_FORMAT);
        int locCode = stationState.getRetailLocationId();
        body = body.replace(CODE, CawUtilFunction.formatParameter(df.format(locCode)));
        // End BZ23722
        body = body.replace(TYPE, CawUtilFunction.formatParameter(LocationFactory.getInstance()
                .getStoreById(iPosTransaction.getRetailLocationId()).getLocationType()));
        body = body.replace(DESCRIPTION, CawUtilFunction.formatParameter(LocationFactory.getInstance()
                .getStoreById(iPosTransaction.getRetailLocationId()).getStoreName()));

        return body;
    }

    /**
     * @param cusIdentifiedrResponse
     * @param iPosTransaction
     * @param party
     * @return transaction total message
     */
    public String buildCatalystTransactionTotalRequest(String cusIdentifiedrResponse, IPosTransaction iPosTransaction,
            IParty party, StationState stationState, CawWorkOrderEBSQueryResult workOrderResult, IOrder currentOrder) {//BZ35052, BZ40898

        SimpleDateFormat sd = new SimpleDateFormat(DATE_TIME_FORMAT);
        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.CATALYST_REQUEST_TEMPLATE);
        String body = request.getBody();
        /* Begin BZ28265 */
        body = body.replace(SALES_CHANNEL, buildSalesChannel(iPosTransaction));

        body = body.replace(CAW_CASHIER, buildCashier(iPosTransaction));

        body = body.replace(CAW_ID, buildId(iPosTransaction));
        /* End BZ28265 */
        body = body.replace(CORRELATION_KEY, CawUtilFunction
                .formatParameter(getCorrelationKey(iPosTransaction, stationState))); //BZ23722
        body = body.replace(SOURCE_CORRELATION_KEY, CawJSONConstant.NULL);
        body = body.replace(ORIGINAL_CORRELATION_KEY, CawJSONConstant.NULL);
        
        /* BEGIN BZ35052 */
        if (workOrderResult != null) {
            body = body.replace(CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR, buildAttrWorkOrderDetail(workOrderResult));
            body = body.replace(CATALYST_REQUEST_ORDER_TYPE_ATTR, buildOrderTypeAttribute(workOrderResult));
        } else {
            body = body.replace(CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR, CawJSONConstant.NULL); //BZ23416
            body = body.replace(CATALYST_REQUEST_ORDER_TYPE_ATTR, CawConstants.VALUE_0);
        }
        /* END BZ35052 */
        
        body = body.replace(CREATE_DATE, CawJSONConstant.NULL);

        if (iPosTransaction.getTransactionTypeCode() != null) {//BZ23541
            body = body.replace(TYPE_CODE, CawUtilFunction.formatParameter(iPosTransaction.getTransactionTypeCode()));
        } else {
            body = body.replace(TYPE_CODE, CawJSONConstant.NULL);
        }

        if (iPosTransaction.getTransactionStatusCode() != null) {//BZ23541
            body = body.replace(STATUS, CawUtilFunction.formatParameter(iPosTransaction.getTransactionStatusCode()));
        } else {
            body = body.replace(STATUS, CawJSONConstant.NULL);
        }

        body = body.replace(DESCRIPTION, CawJSONConstant.NULL);

        if (iPosTransaction.getTotal() != null) {//BZ23541
            body = body.replace(TOTAL, iPosTransaction.getTotal().toString());
        } else {
            body = body.replace(TOTAL, CawJSONConstant.NULL);
        }
        if (iPosTransaction.getTaxAmount() != null) { //BZ23541
            body = body.replace(TOTAL_TAX, iPosTransaction.getTaxAmount().toString());
        } else {
            body = body.replace(TOTAL_TAX, CawJSONConstant.NULL);
        }

        body = body.replace(IS_TAX_EXEMPT, BOOLEAN_DEFAULT);
        body = body.replace(IS_TAX_OVERRIDE, BOOLEAN_DEFAULT);
        body = body.replace(IS_PREPAY, BOOLEAN_DEFAULT);

        body = body.replace(TAX_EXEMPT_CERTIFICATE, CawJSONConstant.NULL);
        body = body.replace(START_DATE_TIME, CawUtilFunction
                .formatParameter(sd.format(iPosTransaction.getBeginDateTimestamp())));
        body = body.replace(END_DATE_TIME, CawJSONConstant.NULL);

        body = body
                .replace(CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR, getTransactionLocationDetailTemplate(iPosTransaction, stationState));

        body = body
                .replace(OBJECT_REQUEST_CUSTOMER_ATTR, getCustomerJsonForCatalystFour(party, cusIdentifiedrResponse));//BZ23478
        body = body.replace(OBJECT_REQUEST_THIRDPARTYPAYER_ATTR, CawJSONConstant.NULL); //BZ23416

        body = body.replace(ARRAY_REQUEST_PROMPTS_ATTR, CawJSONConstant.NULL); //BZ23416
        body = body
                .replace(ARRAY_REQUEST_ITEMS_ATTR, getItemsArrTemplate(iPosTransaction, stationState, currentOrder));/*BZ40898*/
        body = body.replace(ARRAY_REQUEST_INVOICES_ATTR, CawJSONConstant.NULL); //BZ23416
        body = body.replace(ARRAY_REQUEST_TAXES_ATTR, CawJSONConstant.NULL); //BZ23416

        body = body.replace(ARRAY_REQUEST_DISCOUNTS_ATTR, CawJSONConstant.NULL); //BZ23416
        body = body.replace(OBJECT_REQUEST_PAIDINOUTDETAIL_ATTR, CawJSONConstant.NULL); //BZ23416
        body = body.replace(PURCHASE_ORDER, CawJSONConstant.NULL);
        // BZ28265 removed redundant code here(receipt type and email receipt)
        body = body.replace(OBJECT_REQUEST_ORACLEDETAIL_ATTR, CawJSONConstant.NULL); //BZ23416

        body = body.replace(TYPE, VALUE_4);

        // body = body.replace(PROPERTIES, buildProperties(stationState));//BZ23478,BZ28265
        
        body = body.replace (CAW_CUSTOMER_ATTTRIBUTE, getCouldSaveAmt(iPosTransaction, party));//BZ40798
        //body = getCouldSaveAmt(iPosTransaction, party, body); 
        
        return body;
    }

    /* Begin BZ28265 */
    /**
     * Build Sales Channel
     * @param iPosTransaction
     * @return
     */
    private String buildSalesChannel(IPosTransaction posTrans) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.OBJECT_SALES_CHANNEL_ATTR);
        String body = request.getBody();
        long storeId = 0;
        long terminalId = 0;

        if (posTrans != null) {
            storeId = posTrans.getRetailLocationId();
            terminalId = posTrans.getWorkstationId();
        }

        body = body.replace(CAW_ID, String.format("%s", storeId));

        body = body.replace(CAW_TERMINAL, String.format("%s", terminalId));

        body = body.replace(CAW_CHANNELTYPE, String.format("%s", Integer.valueOf(4)));

        return body;
    }

    /**
     * Build cashier
     * @param posTrans
     * @return
     */
    private String buildCashier(IPosTransaction posTrans) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.OBJECT_CASHIER_ATTR);
        String body = request.getBody();
        String code = "";
        String cashierName = "";
        long fileNumber = 0;
        if (posTrans != null) {
            IParty party = posTrans.getOperatorParty();
            if (party != null) {
                code = party.getEmployeeId();
                cashierName = party.getFirstName() + " " + party.getLastName();
                fileNumber = party.getPartyId();
            }

        }

        body = body.replace(CAW_CODE, CawUtilFunction.formatParameter(String.format("%s", code)));

        body = body.replace(CAW_CASHIER_NAME, CawUtilFunction.formatParameter(String.format("%s", cashierName)));

        body = body.replace(CAW_CASHIER_FILE_NUMBER, CawUtilFunction.formatParameter(String.format("%s", fileNumber)));

        return body;
    }

    /**
     * Build ID
     * @param posTrans
     * @return
     */
    private String buildId(IPosTransaction posTrans) {

        long storeId = 0;
        long terminalId = 0;
        long transId = 0;
        String uniqueueId = "";

        if (posTrans != null) {
            storeId = posTrans.getRetailLocationId();
            terminalId = posTrans.getWorkstationId();
            transId = posTrans.getTransactionSequence();
            uniqueueId = String.format("%s", storeId) + String.format("%2s", terminalId).replace(' ', '0')
                    + String.format("%s", transId);

        }

        return uniqueueId;
    }

    /* End BZ28265 */

    /**
     * 
     * @param cawInputFormModel
     * @return
     */
    public CawCatalysCallBackModel buildCatalystCallBackModel(CawInputFormModel cawInputFormModel,
            JSONObject inputFileds) {

        CawCatalysCallBackModel callBackModel = new CawCatalysCallBackModel();
        if (cawInputFormModel.getId() != null) {
            callBackModel.setId(cawInputFormModel.getId());
        }

        if (cawInputFormModel.getInputLable() != null) {
            callBackModel.setLabel(cawInputFormModel.getInputLable());
        }

        if (cawInputFormModel.getInputValue() != null) {
            callBackModel.setAnswer(cawInputFormModel.getInputValue());
        }

        if (cawInputFormModel.getIsCallback() != null) {
            callBackModel.setIsCallbackRequired(cawInputFormModel.getIsCallback());
        }

        if (cawInputFormModel.getType() != null) {
            callBackModel.setType(cawInputFormModel.getType());

            if (callBackModel.getType() == 1) {
                if (cawInputFormModel.getId() != null && cawInputFormModel.getSingleList() != null) {
                    if (cawInputFormModel.getSingleList() instanceof CawInputSingleChoice) {
                        CawInputSingleChoice inputSingleChoice = (CawInputSingleChoice) cawInputFormModel
                                .getSingleList();
                        String choice = buildChoiceSingleSelected(inputSingleChoice, inputFileds, callBackModel);
                        callBackModel.setChoices(choice);
                        callBackModel.setAnswer(inputSingleChoice.getInputId());
                    }
                }
            }

            if (callBackModel.getType() == 2) {
                if (cawInputFormModel.getId() != null && cawInputFormModel.getMultipleList() != null) {
                    List<CawInputSingleChoice> inputSingleChoice = cawInputFormModel.getMultipleList();
                    buildChoiceMultiSelected(inputSingleChoice, inputFileds, callBackModel);
                }
            }

        }

        if (cawInputFormModel.getDescription() != null) {
            callBackModel.setDescription(cawInputFormModel.getDescription());
        }

        return callBackModel;

    }

    /**
     * 
     * @param inputSingleChoice
     * @param inputFileds
     * @return
     */
    public String buildChoiceSingleSelected(CawInputSingleChoice inputSingleChoice, JSONObject inputFileds,
            CawCatalysCallBackModel callBackModel) {

        String choice = null;
        try {
            if (inputSingleChoice != null && inputFileds != null && inputFileds.length() > 0 && callBackModel != null) {
                JSONArray node = inputFileds.getJSONArray(INPUT_CHOICES);
                for (int i = 0; i < node.length(); i++) {
                    if (node.getJSONObject(i) != null && !node.getJSONObject(i).isNull(INPUT_ID)
                            && node.getJSONObject(i).getString(INPUT_VALUE).equals(inputSingleChoice.getInputId())) {
                        if (callBackModel.getIsCallbackRequired()) {
                            node.getJSONObject(i).put("isSelected", "true");
                        }
                        choice = node.getJSONObject(i).toString();
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not get value selected." + ex.getMessage());
        }

        if (choice != null) {
            choice = "[" + choice + "]";
        } else {
            choice = "null";
        }

        return choice;

    }

    /**
     * 
     * @param inputSingleChoice
     * @param inputFileds
     * @param callBackModel
     */
    @SuppressWarnings("null")
    public void buildChoiceMultiSelected(List<CawInputSingleChoice> inputSingleChoice, JSONObject inputFileds,
            CawCatalysCallBackModel callBackModel) {

        StringBuilder builder = new StringBuilder();
        try {
            if (inputFileds != null && !inputFileds.isNull(INPUT_CHOICES)) {
                JSONArray node = inputFileds.getJSONArray(INPUT_CHOICES);
                String valueSelected = null;
                for (Object cawInputSingleChoice : inputSingleChoice) {
                    valueSelected = cawInputSingleChoice.toString();
                    for (int i = 0; i < node.length(); i++) {
                        if (valueSelected.equals(node.getJSONObject(i).getString(INPUT_LABEL))) {
                            builder.append(node.getJSONObject(i).toString());
                            builder.append(",");
                        }
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not get attribute from Json." + ex.getMessage());
        }

        String choice = "null";
        if (builder != null) {
            choice = "[" + builder.substring(0, builder.length() - 1) + "]";
        }

        callBackModel.setChoices(choice);
    }

    public void saveIsCallBackMode(Map<Integer, CawCatalysCallBackModel> callBackModes,
            IPosTransaction iPosTransaction) {

        try {
            if (iPosTransaction != null && callBackModes != null && callBackModes.size() > 0) {
                String mapAsJson = new ObjectMapper().writeValueAsString(callBackModes);
                if (mapAsJson != null) {
                    //Save response to DB
                    saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.PROMPTING_ENGINE_CATALYST_INPUT, mapAsJson, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not insert input data to DB." + ex.getMessage());
        }

    }

    /**
     * 
     * @param callBackModes
     * @param lookupResponse
     * @param iParty
     * @param iPosTransaction
     * @return
     */
    public String buildIsCallBackRequest(Map<Integer, CawCatalysCallBackModel> callBackModes, String lookupResponse,
            IParty iParty, IPosTransaction iPosTransaction, StationState stationState
            , String catalystType, CawWorkOrderEBSQueryResult workOrderResult) {//BZ28567, BZ35052

        // End BZ23722
        String body = CawJSONConstant.NULL;
        if (callBackModes != null) {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawRestConfigHelper.CATALYST_RESULT_TEMPLATE);
            if (request != null && request.getBody() != null) {
                body = request.getBody();

                /* Begin BZ28529 */
                body = body.replace(TYPE, catalystType);//BZ28567
                body = body.replace(SALES_CHANNEL, buildSalesChannel(iPosTransaction));
                body = body.replace(CAW_CASHIER, buildCashier(iPosTransaction));
                body = body.replace(CAW_ID, buildId(iPosTransaction));
                /* End BZ28529 */

                //transaction
                // Begin BZ23722
                body = body.replace(CORRELATION_KEY, CawUtilFunction
                        .formatParameter(getCorrelationKey(iPosTransaction, stationState)));

                body = body.replace(SOURCE_CORRELATION_KEY, CawJSONConstant.NULL);
                body = body.replace(ORIGINAL_CORRELATION_KEY, CawJSONConstant.NULL);

                //workOrderDetail
                /* BEGIN BZ35052 */
                if (workOrderResult != null) {
                    body = body.replace(CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR, buildAttrWorkOrderDetail(workOrderResult));
                    body = body.replace(CATALYST_REQUEST_ORDER_TYPE_ATTR, buildOrderTypeAttribute(workOrderResult));
                } else {
                    body = body.replace(CATALYST_REQUEST_WORK_ORDER_DETAIL_ATTR, CawJSONConstant.NULL); //BZ23416
                    body = body.replace(CATALYST_REQUEST_ORDER_TYPE_ATTR, CawConstants.VALUE_0);
                }
                /* END BZ35052 */
                
                body = body.replace(CREATE_DATE, CawJSONConstant.NULL);
                body = body.replace(TYPE_CODE, CawJSONConstant.NULL);
                body = body.replace(STATUS, CawJSONConstant.NULL);
                body = body.replace(DESCRIPTION, CawJSONConstant.NULL);
                // Start BZ-38980
                if (iPosTransaction.getTotal() != null) {
                    body = body.replace(TOTAL, iPosTransaction.getTotal().toString());
                } else {
                    body = body.replace(TOTAL, NUMBER_DEFAULT);
                } // End BZ-38980
                body = body.replace(TOTAL_TAX, NUMBER_DEFAULT);
                body = body.replace(IS_TAX_EXEMPT, BOOLEAN_DEFAULT);
                body = body.replace(IS_TAX_OVERRIDE, BOOLEAN_DEFAULT);
                body = body.replace(IS_PREPAY, BOOLEAN_DEFAULT);
                body = body.replace(TAX_EXEMPT_CERTIFICATE, CawJSONConstant.NULL);

                //employee

                body = body.replace(START_DATE_TIME, CawJSONConstant.NULL);
                body = body.replace(END_DATE_TIME, CawJSONConstant.NULL);

                //location
                body = body
                        .replace(CATALYST_REQUEST_TRANSACTION_LOCATION_ATTR, getTransactionLocationDetailTemplate(iPosTransaction, stationState));

                //customer
                body = body.replace(OBJECT_REQUEST_CUSTOMER_ATTR, getCustomerTemplate(iParty, lookupResponse));

                //thirdPartyPayer
                body = body.replace(OBJECT_REQUEST_THIRDPARTYPAYER_ATTR, CawJSONConstant.NULL);

                //prompts
                body = body.replace(ARRAY_REQUEST_PROMPTS_ATTR, CawJSONConstant.NULL);

                //items
                body = body.replace(ARRAY_REQUEST_ITEMS_ATTR, CawJSONConstant.NULL);

                //invoices
                body = body.replace(ARRAY_REQUEST_INVOICES_ATTR, CawJSONConstant.NULL);

                //taxes
                body = body.replace(ARRAY_REQUEST_TAXES_ATTR, CawJSONConstant.NULL);

                //discounts
                body = body.replace(ARRAY_REQUEST_DISCOUNTS_ATTR, CawJSONConstant.NULL);

                //paidInOutDetail
                body = body.replace(OBJECT_REQUEST_PAIDINOUTDETAIL_ATTR, CawJSONConstant.NULL);

                body = body.replace(PURCHASE_ORDER, CawJSONConstant.NULL);

                //eReceiptDetail
                body = body.replace(OBJECT_REQUEST_ERECEIPTDETAIL_ATTR, CawJSONConstant.NULL);

                //oracleDetail
                body = body.replace(OBJECT_REQUEST_ORACLEDETAIL_ATTR, CawJSONConstant.NULL);

                //inputs
                body = body.replace(ARRAY_INPUTS_ATTR, buildInputCallBack(callBackModes));//BZ23478
            }
        }

        return body;
    }

    /**
     * Build input attribute when sent is call back
     * @param callBackModes
     * @return
     */
    @SuppressWarnings("null")
    public String buildInputCallBack(Map<Integer, CawCatalysCallBackModel> callBackModes) {

        String body = CawJSONConstant.NULL;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.ARRAY_INPUTS_ATTR);

            if (request != null && request.getBody() != null) {
                StringBuilder builder = new StringBuilder();

                if (callBackModes != null) {
                    String temp = null;
                    // Begin BZ24204
                    for (Entry<Integer, CawCatalysCallBackModel> model : callBackModes.entrySet()) {
                        if (model.getValue() != null && model.getValue().getIsCallbackRequired() == Boolean.TRUE) {
                            temp = request.getBody();
                            if (model.getValue().getId() != null) {
                                temp = temp.replace(ID, CawUtilFunction.formatParameter(model.getValue().getId()));
                            } else {
                                temp = temp.replace(ID, CawJSONConstant.NULL);
                            }

                            if (model.getValue().getType() != null) {
                                temp = temp.replace(TYPE, String.valueOf(model.getValue().getType()));
                            } else {
                                temp = temp.replace(TYPE, NUMBER_DEFAULT);
                            }

                            if (model.getValue().getDescription() != null) {
                                temp = temp.replace(DESCRIPTION, CawUtilFunction
                                        .formatParameter(model.getValue().getDescription()));
                            } else {
                                temp = temp.replace(DESCRIPTION, CawJSONConstant.NULL);
                            }
                            
                            /* Begin BZ31753 */
                            String label = StringEscapeUtils.escapeJson(model.getValue().getLabel());
                            if (label != null) {
                                temp = temp.replace(LABEL, CawUtilFunction.formatParameter(label));
                            } else {
                                temp = temp.replace(LABEL, CawJSONConstant.NULL);
                            }
                            /* End BZ31753 */

                            if (model.getValue().getChoices() != null) {
                                temp = temp.replace(RESULT_CHOICES_ATTR, model.getValue().getChoices());
                            } else {
                                temp = temp.replace(RESULT_CHOICES_ATTR, CawJSONConstant.NULL);
                            }

                            if (model.getValue().getIsCallbackRequired() != null) {
                                temp = temp.replace(IS_CALLBACK_REQUIRED, String
                                        .valueOf(model.getValue().getIsCallbackRequired()));
                            } else {
                                temp = temp.replace(IS_CALLBACK_REQUIRED, CawJSONConstant.NULL);
                            }

                            if (model.getValue().getAnswer() != null) {
                                temp = temp
                                        .replace(ANSWER, CawUtilFunction.formatParameter(model.getValue().getAnswer()));
                            } else {
                                temp = temp.replace(ANSWER, CawJSONConstant.NULL);
                            }

                            builder.append(temp);
                            builder.append(",");
                        }
                    }
                    // End BZ24204
                }

                if (builder != null && builder.length() > 0) {
                    body = "[" + builder.substring(0, builder.length() - 1) + "]";
                } else {
                    // Begin BZ23996 
                    // Must initial empty data for inputs to send request to EBS in catalyst = 4
                    JSONArray jsonArray = new JSONArray("[{}]");
                    body = jsonArray.toString();
                    // End BZ23996
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not build input data for catalys result." + ex.getMessage());
        }

        return body;
    }

    public String getCorrelationKey(IPosTransaction iPosTransaction, StationState stationState) {

        String correlationKey = CawJSONConstant.NULL;
        try {
            if (iPosTransaction != null && stationState != null) {
                DateFormat df = new SimpleDateFormat(YYYY_M_MDD);
                Date bsnDate = iPosTransaction.getBusinessDate();

                String storeID = String.format("%4s", stationState.getRetailLocationId()).replace(' ', '0');
                String regID = String.format("%2s", stationState.getWorkstationId()).replace(' ', '0');
                String transSeq = String.format("%4s", iPosTransaction.getTransactionSequence()).replace(' ', '0');

                correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq;

                /* correlationKey = cawCustomerHelper
                        .formatParameter(correlationKey);*/ //BZ23722
            }
        } catch (Exception ex) {
            _logger.error("Can not build CorrelationKey" + ex.getMessage());
        }

        return correlationKey;
    }

    /**
     * 
     * @param iPosTransaction
     * @param customerId
     * @return
     */
    public Boolean isRunOp(TransactionScope iPosTransaction, Long customerId) {

        Boolean isRun = Boolean.FALSE;

        if (iPosTransaction != null && iPosTransaction.getTransaction(TransactionType.RETAIL_SALE) != null) {
            long partyId = iPosTransaction.getTransaction(TransactionType.RETAIL_SALE).getCustomerPartyId();
            if (partyId > 0) {
                if (customerId == null || customerId.longValue() == 0) {
                    isRun = Boolean.TRUE;
                } else if (partyId != customerId.longValue()) {
                    isRun = Boolean.TRUE;
                }
            }
        }

        return isRun;
    }

    // Begin BZ23637
    /**
     * 
     * @param iParty
     * @param clubName
     * @return
     */
    public ICustomerAffiliation joinCutomerToGoodSamClub(IParty iParty, String clubName) {

        ICustomerAffiliation iCustomerAffiliation = null;
        try {
            if (iParty != null && clubName != null) {

                CustomerAffiliationId customerAffiliationId = new CustomerAffiliationId();
                customerAffiliationId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                customerAffiliationId.setPartyId(iParty.getPartyId());
                customerAffiliationId.setCustomerGroupId(clubName);

                iCustomerAffiliation = DataFactory.getObjectByIdNoThrow(customerAffiliationId);
                if (iCustomerAffiliation == null) {
                    iCustomerAffiliation = DataFactory.createObject(ICustomerAffiliation.class);
                    iCustomerAffiliation.setObjectId(customerAffiliationId);
                    iCustomerAffiliation.setOrganizationId(ConfigurationMgr.getOrganizationId());
                    iCustomerAffiliation.setCustomerGroupId(clubName);
                    iCustomerAffiliation = DataFactory.makePersistent(iCustomerAffiliation);
                }
                List<ICustomerAffiliation> customerAffiliations = new ArrayList<ICustomerAffiliation>();
                customerAffiliations.add(iCustomerAffiliation);
                iParty.setCustomerGroups(customerAffiliations);
            }

        } catch (Exception ex) {
            _logger.error("Can not create CustomerAffiliation." + ex.getMessage());
        }

        return iCustomerAffiliation;
    }

    // End BZ23637

    public void changePricingOfCustomer(IParty iParty, JSONObject response) {

        if (iParty != null && response != null) {
            if (iParty.getCustomerGroups() != null && iParty.getCustomerGroups().size() > 0) {
                // Begin BZ24601
                Boolean isClub = Boolean.FALSE;
                List<ICustomerAffiliation> customerAffiliations = iParty.getCustomerGroups();
                for (ICustomerAffiliation iCustomerAffiliation : customerAffiliations) {
                    if (CawCustomerGroupType.CLUB.getNewName().equals(iCustomerAffiliation.getCustomerGroupId())) {
                        isClub = Boolean.TRUE;
                        break;
                    }
                }

                if (isClub) {
                    try {
                        if (!response.isNull(PRICING_ATTR)) {
                            response.getJSONObject(PRICING_ATTR)
                                    .put(IDENTIFIER_ATTR, CawCustomerGroupType.CLUB.getType());

                            response.getJSONObject(PRICING_ATTR).put(BAND_ATTR, CawCustomerGroupType.CLUB.getNewName());

                            response.getJSONObject(PRICING_ATTR).put(CawEBSConstant.DESCRIPTION_ATTR, "CLUB PRICE");

                            response.getJSONObject(PRICING_ATTR).put(PRICE_COMPARE_BAND_ATTR, CawJSONConstant.NULL);

                            response.getJSONObject(PRICING_ATTR).put(PRICE_COMPARE_BAND_ATTR, JSONObject.NULL); // BZ 23946

                            response.getJSONObject(PRICING_ATTR).put(PRICE_COMPARE_BAND_ID_ATTR, 0);
                        }
                    } catch (JSONException ex) {
                        _logger.error("Can not build Pricing attribute of customer." + ex.getMessage());
                    }
                }
                // End BZ24601
            }
        }
    }

    /**
     * Build custom Json for request catalyst 4
     * @param party
     * @param lookupResponse
     * @return
     */
    public String getCustomerJsonForCatalystFour(IParty party, String lookupResponse) {

        String body = CawJSONConstant.NULL;
        if (party != null && StringUtils.isNotEmpty(lookupResponse)) {
            try {
                CawRestConfig request = CawRestConfigHelper.getInstance()
                        .getRestRequest(CawEBSConstant.REQUEST_CUSTOMER_ATTR);
                body = request.getBody();

                JSONObject response = new JSONObject(lookupResponse);
                party.getCustomerGroups();
                changeCustomerNameAttr(party, response);
                changeAddressAttr(party, response);
                changePricingOfCustomer(party, response);
                body = response.toString();

                body = body.replace("\\\"", "");

            } catch (Exception ex) {
                _logger.error("Can get customer from Lookup API response json." + ex.getMessage());
            }
        }
        return body;
    }

    // Begin BZ23958
    /**
     * @param argEbsResponse
     * @return
     */
    public String getMembershipValidateTemplate(IPosTransaction trans, String lookupData, JSONObject itemJson,
            String dataEntered) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.MEMBERSHIP_VALIDATE_REQUEST_TEMPLATE);
        String body = request.getBody();
        body = body.replace(ID_SALE_CHANEL_ATTR, String.valueOf(trans.getRetailLocationId()));
        body = body.replace(ID_THE_ORDER_ATTR, "1");

        String storeID = String.valueOf(trans.getRetailLocationId());
        String regID = String.valueOf(trans.getWorkstationId());
        String transSeq = String.valueOf(trans.getTransactionSequence());
        Date bsnDate = trans.getBusinessDate();
        storeID = String.format("%4s", storeID).replace(' ', ZERO_CHAR);
        regID = String.format("%2s", regID).replace(' ', ZERO_CHAR);
        transSeq = String.format("%4s", transSeq).replace(' ', ZERO_CHAR);
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        String correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq;
        body = body.replace(CORRELATION_KEY, formatParameter(correlationKey));

        body = body.replace(CODE_CASHIER_ATTR, formatParameter(trans.getOperatorParty().getEmployeeId()));
        body = body.replace(NAME_CASHIER_ATTR, formatParameter(trans.getOperatorParty().getLastName() + " "
                + trans.getOperatorParty().getFirstName()));

        String bussinessDate = String.valueOf(trans.getBusinessDate());
        String orderDate = bussinessDate.substring(0, 10);
        body = body.replace(ORDER_DATE_ATTR, formatParameter(orderDate));

        BigDecimal orderTotalWithTax = new BigDecimal(0.00);
        orderTotalWithTax = trans.getTotal();
        if (orderTotalWithTax != null) {
            body = body.replace(ORDER_TOTAL_WITH_TAX_ATTR, String.valueOf(orderTotalWithTax));
        } else {
            body = body.replace(ORDER_TOTAL_WITH_TAX_ATTR, "0");
        }

        // Customer
        try {
            /* BEGIN BZ28855, BZ36667 */
            if (StringUtils.isNotEmpty(lookupData)) {
                String customerInfo = lookupData;
                JSONObject custLookup = new JSONObject(lookupData);
                /* BEGIN BZ28855 */
                if (custLookup.has(CawEBSConstant.THE_CUSTOMER_ATTR)) {
                    customerInfo = custLookup.getJSONObject(CawEBSConstant.THE_CUSTOMER_ATTR).toString();
                }  
                body = body.replace(CawJSONConstant.CUSTOMER_INFORMATION, customerInfo);
            } else {
                body = body.replace(CawJSONConstant.CUSTOMER_INFORMATION, CawJSONConstant.NULL);
            }
            /* END BZ28855, BZ36667 */
             
            // ITEMS
            String codeItem = null;
            String quantityItem = null;
            try {
                codeItem = itemJson.getString(ITEM_CODE);
                quantityItem = itemJson.getString(QUANTITY_ATTR);
            } catch (JSONException ex) {
                _logger.error("Cannot get JSON item: " + ex.getMessage());
            }

            body = body.replace(CODE_ITEM, formatParameter(codeItem));
            if (quantityItem != null) {
                body = body.replace(QUANTITY_ITEM, quantityItem);
            } else {
                body = body.replace(QUANTITY_ITEM, NULL_STRING);
            }
            body = body.replace(MEMBER_ID, formatParameter(dataEntered));
        } catch (Exception ex) {
            _logger.error("Exception in Customer: " + ex.getMessage());
        }

        return body;
    }

    /**
     * @param argString
     * @return
     */
    public String formatParameter(String argString) {

        return argString != null ? "\"" + argString + "\"" : NULL_STRING;
    }

    // End BZ23958

    // Begin BZ24424
    /**
     * 
     * @param cusomterInfo
     * @param membershipsIdentifier
     * @param membershipActivityModel
     * @return
     */
    public String changeMembershipsAttrOffline(String cusomterInfo, String membershipsIdentifier,
            CawMembershipActivityModel membershipActivityModel) {

        String customerStr = null;
        if (StringUtils.isNotEmpty(cusomterInfo)) {
            _logger.info("Build membership info when service is offline." + cusomterInfo);//BZ25434
            try {
                JSONArray arrayList = new JSONArray(); //BZ25434
                JSONObject customerObj = new JSONObject(cusomterInfo);
                if (!customerObj.isNull(MEMBERSHIPS_KEY)) {
                    arrayList = customerObj.getJSONArray(MEMBERSHIPS_KEY); //BZ25434
                }

                JSONObject membershipObj = makeUpMembershipInfo(membershipsIdentifier, membershipActivityModel);
                int position = checkMembershipExist(membershipsIdentifier, membershipActivityModel, arrayList);
                if (position > -1) {
                    // Modify identifier of membership.
                    try {
                        JSONObject tempJSONObject = (JSONObject) arrayList.get(position);
                        tempJSONObject.put(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR, membershipsIdentifier);
                        customerObj.put(MEMBERSHIPS_KEY, arrayList);
                    } catch (Exception ex) {
                        _logger.error("Can not modify identifier of membership." + ex.getMessage());
                    }
                } else {
                    arrayList.put(membershipObj); //BZ25434
                    customerObj.put(MEMBERSHIPS_KEY, arrayList);
                }

                // The customer has joined club pricing.
                if (!customerObj.isNull(CawEBSConstant.PRICING_ATTR)) {
                    JSONObject pricingObj = customerObj.getJSONObject(CawEBSConstant.PRICING_ATTR);
                    if (!pricingObj.isNull(CawEBSConstant.PRICE_BAND)) {
                        if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())
                                && !PRICE_CLUB.equalsIgnoreCase(pricingObj.getString(CawEBSConstant.PRICE_BAND))) {
                            pricingObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                            customerObj.put(CawEBSConstant.PRICING_ATTR, pricingObj);
                        }
                    }
                } else {
                    //Begin BZ24944
                    // Price attribute
                    JSONObject priceObj = new JSONObject();
                    /* BEGIN BZ28907 */
                    if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())) {
                        priceObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                    } else {
                        priceObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_DESCRIPTION);
                        priceObj.put(CawEBSConstant.PRICE_BAND, PRICE_RETL);
                    }
                    /* END BZ28907 */
                    priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND, "");
                    priceObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                    customerObj.put(CawEBSConstant.PRICING_ATTR, priceObj);
                    //End BZ24944
                }
                //End BZ26398

                customerStr = customerObj.toString();

            } catch (Exception ex) {
                _logger.error("Can not parse string Customer object to Json object." + ex.getMessage());
            }
        }

        return customerStr;
    }
    // End BZ24424

    /**
     * @param membershipsIdentifier
     * @param membershipActivityModel
     * @return
     * @throws JSONException
     */
    private JSONObject makeUpMembershipInfo(String membershipsIdentifier,
            CawMembershipActivityModel membershipActivityModel) throws JSONException {

        JSONObject membershipObj = new JSONObject();
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR, membershipsIdentifier);
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR, Integer.valueOf(membershipActivityModel.getMembershipType()));//BZ53287
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_TYPE_DESCRIPTION_ATTR, membershipActivityModel
                .getMembershipTypeDescription());

        Date currentDate = new Date();
        membershipObj
                .put(CawEBSConstant.MEMBERSHIPS_JOIN_DATE_ATTR, CawUtilFunction.convertDateFormatMMDDYYY(currentDate));

        Date expireDate = CawUtilFunction.getCurrentDateAddDayNumber(7);
        membershipObj
                .put(CawEBSConstant.MEMBERSHIPS_EXPIRE_DATE_ATTR, CawUtilFunction.convertDateFormatMMDDYYY(expireDate));

        membershipObj.put(CawEBSConstant.MEMBERSHIPS_STATUS_ATTR, Integer.valueOf(membershipActivityModel.getMembershipStatus()));//BZ53287
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_STATUS_DESCRIPTION_ATTR, membershipActivityModel
                .getMembershipStatusDescription());
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_IS_AUTO_RENEW_ATTR, membershipActivityModel.isAutoRenew());
        membershipObj.put(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_ATTR, Integer.valueOf(membershipActivityModel.getBenefitLevel()));//BZ53287
        membershipObj
                .put(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR, membershipActivityModel.getBenefitLevlName());
        return membershipObj;
    }

    /**
     * The method check the customer have joined GS/RA/TA. Return -1 if the customer not joined GS/RA/TA.
     * @param membershipsIdentifier
     * @param membershipActivityModel
     * @param arrayList
     * @throws JSONException
     */
    public int checkMembershipExist(String membershipsIdentifier, CawMembershipActivityModel membershipActivityModel,
            JSONArray arrayList) {

        int position = -1;
        if (arrayList != null && arrayList.length() > 0) {
            JSONObject tempJSONObject = null;
            for (int i = 0; i < arrayList.length(); i++) {
                try {
                    tempJSONObject = (JSONObject) arrayList.get(i);
                    if (!tempJSONObject.isNull(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                            && membershipActivityModel.getMembershipType().equals(tempJSONObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR))) { // Bz-44053
                        position = i;
                    }
                } catch (JSONException ex) {
                    _logger.error("Can not parse string MembershipTypeDescription object to Json object."
                            + ex.getMessage());
                }
            }
        }

        return position;
    }

    /* BEGIN BZ33231 */
    /***
     * 
     * @param storeNumber
     * @param employeeId
     * @return
     */
    public String buildCatalystBeginRequest(String storeNumber, String employeeId) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.CATALYST0_REQUEST_TEMPLATE);
        String body = request.getBody();
        body = body.replace(CAW_ID, storeNumber);
        body = body.replace(CAW_CODE, CawUtilFunction.formatParameter(String.format("%s", employeeId)));
        return body;
    }
    /* END BZ33231 */
    
    /* BEGIN BZ35052 */
    /**
     * 
     * @param workOrderResult
     * @return
     */
    public String buildAttrWorkOrderDetail(CawWorkOrderEBSQueryResult workOrderResult) {
       String workOrderDetail = CawJSONConstant.NULL;
        try {
            if (workOrderResult != null && (CawWorkOrderOptionsOp.isDepositAction() 
                    || CawWorkOrderOptionsOp.isCompleteAction() 
                        || CawWorkOrderOptionsOp.isRefundAction())) {
                JSONObject workOrderDetailJS = new JSONObject();
                workOrderDetailJS.put(WORK_ORDER_ID, CawJSONConstant.NULL);
                if (workOrderResult.getWoNumber() != null) {
                    workOrderDetailJS.put(WORK_ORDER_ID, workOrderResult.getWoNumber());
                }
                
                String posStatus = CawJSONConstant.NULL;
                if (CawWorkOrderOptionsOp.isDepositAction()) {
                    posStatus = WORK_ORDER_DEPOSIT_POS_STATUS;
                }
                
                if (CawWorkOrderOptionsOp.isCompleteAction()) {
                    posStatus = WORK_ORDER_COMPLETE_POS_STATUS;
                }
                
                if (CawWorkOrderOptionsOp.isRefundAction()) {
                    posStatus = WORK_ORDER_REFUND_POS_STATUS;
                }
                
                workOrderDetailJS.put(WORK_ORDER_POS_STATUS, posStatus);
                workOrderDetail = workOrderDetailJS.toString();
            }  
        } catch (Exception ex) {
            _logger.error("The method buildAttrWorkOrderDetail() cannot create 'workOrderDetail' json attribute." + ex.getMessage());
        }
        
        return workOrderDetail;
    }
    
    public String buildOrderTypeAttribute(CawWorkOrderEBSQueryResult workOrderResult) {
        String orderType = "0";
         try {
             if (workOrderResult != null && (CawWorkOrderOptionsOp.isDepositAction() 
                     || CawWorkOrderOptionsOp.isCompleteAction() 
                         || CawWorkOrderOptionsOp.isRefundAction())) {
                 JSONObject workOrderDetailJS = new JSONObject();
                 workOrderDetailJS.put(WORK_ORDER_ID, CawJSONConstant.NULL);
                 if (workOrderResult.getWoNumber() != null) {
                     workOrderDetailJS.put(WORK_ORDER_ID, workOrderResult.getWoNumber());
                 }
                 
                 if (CawWorkOrderOptionsOp.isDepositAction()) {
                     orderType = WORK_ORDER_DEPOSIT_POS_STATUS;
                 }
                 
                 if (CawWorkOrderOptionsOp.isCompleteAction()) {
                     orderType = WORK_ORDER_COMPLETE_POS_STATUS;
                 }
                 
                 if (CawWorkOrderOptionsOp.isRefundAction()) {
                     orderType = WORK_ORDER_REFUND_POS_STATUS;
                 }
             }  
         } catch (Exception ex) {
             _logger.error("The method buildOrderTypeAttribute() cannot get orderType." + ex.getMessage());
         }
         
         return orderType;
     }
    /* END BZ35052 */
    
    /* BEGIN BZ37305 */
    public boolean isPEUpdateCustomerEmail(String pEResultsRequestStr) {

        boolean isUpdateEmail = false;
        if (StringUtils.isNotEmpty(pEResultsRequestStr)) {
            JSONObject pEResultsRequestJson = CawJSONUtils
                    .toJSONObject(pEResultsRequestStr);
            try {
                if (pEResultsRequestJson != null && pEResultsRequestJson.has(CawEBSConstant.CATALYST_INPUT_TYPE)) {
                    JSONArray inputArrJson = CawJSONUtils.getJSONArray(pEResultsRequestJson, CawEBSConstant.CATALYST_INPUT_TYPE);
                    if (inputArrJson != null && inputArrJson.length() > 0) {
                        JSONObject inputTemp = null;
                        for (int i = 0; i < inputArrJson.length(); i++) {
                            inputTemp = (JSONObject) inputArrJson.get(i);
                            if (inputTemp.has(CawEBSConstant.TYPE_ATTR) && CawConstants.VALUE_0.equals(inputTemp.getString(CawEBSConstant.TYPE_ATTR))) {
                                isUpdateEmail = true;
                                break;
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                _logger.error("The method isPEUpdateCustomerEmail() cannot get input type 1." + ex.getMessage());
            }
        }

        return isUpdateEmail;
    }

    /* END BZ37305 */
    /*BEGIN BZ40898*/
    public String getBrokerItemDetailTemplate(IOrderLine orderLine, String orderType) {
        
        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_BROKER_ITEM_DETAIL_ATTR);
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = null;
        temp = String.valueOf(body);
        
        /* BEIGN BZ45902 */
        // BUILD SHIP TO CUSTOMER
        if (CawConstants.BROKERED_ORDER_STANDARD_DELIVERY.equalsIgnoreCase(orderType)) {
            temp = temp.replace(BROKER_ACTION, CawConstants.VALUE_1);
            temp = temp.replace(FULFILLMENT_SYSTEM, CawConstants.NULL_TEXT);
            temp = temp.replace(FULFILLMENT_LOCATION, CawConstants.NULL_TEXT);
            String obRequestId = orderLine.getExternalOrderId() != null
                    ? orderLine.getExternalOrderId()
                    : CawConstants.VALUE_0;
            temp = temp.replace(OB_REQUEST_ID, obRequestId);
            temp = temp.replace(OB_ORDER_ID, formatParameter(orderLine.getOrderId()));
            temp = temp.replace(OB_ACTION_DESCRIPTION, formatParameter(CawConstants.OB_SHIP_TO_CUSTOMER));
        } else {
            // BUILD SHIP TO OTHER STORE
            temp = temp.replace(BROKER_ACTION, CawConstants.VALUE_2);
            temp = temp.replace(FULFILLMENT_SYSTEM, formatParameter(CawConstants.FULL_FILL_SYSTEM_DES));
            temp = temp.replace(FULFILLMENT_LOCATION, orderLine.getFulfillmentModifier().getLocationId());
            temp = temp.replace(OB_REQUEST_ID, orderLine.getExternalOrderId());
            temp = temp.replace(OB_ORDER_ID, formatParameter(orderLine.getOrderId()));
            temp = temp.replace(OB_ACTION_DESCRIPTION, formatParameter(CawConstants.OB_PICKUP_IN_STORE));/*BZ44528*/
        }
        /* END BZ45902 */
        
        resultBuilder.append(temp);
        resultBuilder.append(",");
        if (resultBuilder.length() > 0) {
            result = (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1);
        }
        return result;
    }
    /*END BZ40898*/
    
    /*BEGIN BZ40798*/
    /**
     * BZ40798
     * @param argIPosTransaction
     * @return
     */
    public String getCouldSaveAmt(IPosTransaction argIPosTransaction,
            IParty argParty) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.CUST_MEMBER_ATTR);
        String result = request.getBody();
        
        BigDecimal saveAmt = new CawTotalAmountSavedWorker((IRetailTransaction) argIPosTransaction).call();
        BigDecimal couldSaveAmt = new CawTotalAmountCouldSavedWorker((IRetailTransaction) argIPosTransaction).call();
        boolean isClubGroup = CawCustomerUtil.isClubOnlyCustomer(argParty);
        
        if (isClubGroup) {
            if (saveAmt.compareTo(BigDecimal.ZERO) >= 0) {
                result = result.replace(CAW_GOOD_SAM_SAVINGS, CawUtilFunction
                        .formatParameter(saveAmt.toString()));
            } else {
                result = result.replace(CAW_GOOD_SAM_SAVINGS, CawUtilFunction
                        .formatParameter(CawConstants.VALUE_00));
            }
            result = result.replace(CAW_COULD_SAVE, CawUtilFunction
                    .formatParameter(CawConstants.VALUE_00));
        } else {
            if (couldSaveAmt.compareTo(BigDecimal.ZERO) >= 0) {
                result = result.replace(CAW_COULD_SAVE, CawUtilFunction
                        .formatParameter(couldSaveAmt.toString()));
            } else {
                result = result.replace(CAW_COULD_SAVE, CawUtilFunction
                        .formatParameter(CawConstants.VALUE_00));
            }
            result = result.replace(CAW_GOOD_SAM_SAVINGS, CawUtilFunction
                    .formatParameter(CawConstants.VALUE_00));
        }

        return result;
    }
    
    /**
     * @param iPosTransaction
     * @param party
     */
    public void saveGoodSamSavingInfo(TransactionScope scope, IPosTransaction iPosTransaction, IParty party) {

        String attrValue = null;
        boolean isClub = false;
        isClub = CawCustomerUtil.isClubOnlyCustomer(party);
        if (isClub == true) {
            attrValue = scope.getValue(CawValueKeys.GOOD_SAM_SAVINGS).toString();
            saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.GOOD_SAM_SAVINGS, attrValue, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
            saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.COULD_SAVE, CawConstants.VALUE_00, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
        } else {
            attrValue = scope.getValue(CawValueKeys.COULD_SAVE).toString();
            saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.GOOD_SAM_SAVINGS, CawConstants.VALUE_00, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
            saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.COULD_SAVE, attrValue, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
        }
    }
    /*END BZ40798*/
    
    
    public String getOriginalCorrelationKey(ISaleReturnLineItem argTransLineItem, StationState stationState) {

        String correlationKey = CawJSONConstant.NULL;
        try {
            if (argTransLineItem != null && stationState != null) {
                DateFormat df = new SimpleDateFormat(YYYY_M_MDD);
                Date bsnDate = argTransLineItem.getOriginalBusinessDate();

                String storeID = String.format("%4s", argTransLineItem.getOriginalRetailLocationId()).replace(' ', '0');
                String regID = String.format("%2s", argTransLineItem.getOriginalWorkstationId()).replace(' ', '0');
                String transSeq = String.format("%4s", argTransLineItem.getOriginalTransactionSequence()).replace(' ', '0');

                /* BEGIN BZ53752 */
                int countLine = 1;
                if (argTransLineItem.getOriginalTransactionObjectId() != null) {
                    IPosTransaction orgTransaction = TransactionHelper.searchTransFromHost(argTransLineItem.getOriginalTransactionObjectId());
                    if (orgTransaction != null) {
                        List<ISaleReturnLineItem> orgTransLineItems = orgTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName()
                                , ISaleReturnLineItem.class);
                        if (orgTransLineItems != null && orgTransLineItems.size() > 0) {
                            for (ISaleReturnLineItem orgSaleLineItem : orgTransLineItems) {
                                if (!orgSaleLineItem.getVoid()) {
                                    if (argTransLineItem.getOrganizationId() == orgSaleLineItem.getOrganizationId()
                                            && argTransLineItem.getOriginalBusinessDate().equals(orgSaleLineItem.getBusinessDate())
                                            && argTransLineItem.getOriginalRetailLocationId() == orgSaleLineItem.getRetailLocationId() 
                                            && argTransLineItem.getOriginalWorkstationId() == orgSaleLineItem.getWorkstationId() 
                                            && argTransLineItem.getOriginalTransactionSequence() == orgSaleLineItem.getTransactionSequence()
                                            && argTransLineItem.getOriginalLineItemSequence() == orgSaleLineItem.getLineItemSequence()) {
                                        break;
                                    } else {
                                        ++ countLine;
                                    }
                                }
                            }
                        }
                    }
                }
                
                correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq + ":" + countLine;
                correlationKey = CawUtilFunction.formatParameter(correlationKey);
                /* END BZ53752 */
            }
        } catch (Exception ex) {
            _logger.error("Can not build CorrelationKey" + ex.getMessage());
        }

        return correlationKey;
    }

    //BEGIN BZ53752
    private String getShippingInfoTemplate(IOrderLine argOrderLine) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REQUEST_ITEMS_ATTR_ORDER_SHIPPING_INFO);

        String body = "";
        String value;
        if (request != null) {
            body = request.getBody();
        }

        if (argOrderLine != null && StringUtils.isNotEmpty(body)) {
            IFulfillmentModifier fulfillment = argOrderLine.getFulfillmentModifier();
            
            if (fulfillment != null) {
                
                String name = null;
                if (StringUtils.isNotEmpty(fulfillment.getLocationName1())) {
                    name = fulfillment.getLocationName1();
                }
                if (StringUtils.isNotEmpty(fulfillment.getLocationName2())) {
                    name = name + " " + fulfillment.getLocationName2();
                }
                
                body = body.replace(CAW_NAME_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(name));
                
                if (fulfillment.getAddress() != null) {

                    body = body.replace(CAW_LINE1_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(fulfillment.getAddress().getAddress1()));
                    body = body.replace(CAW_CITY_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(fulfillment.getAddress().getCity()));
                    body = body.replace(CAW_STATE_PROVINCE_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(fulfillment.getAddress().getState()));
                    body = body.replace(CAW_POSTAL_CODE_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(fulfillment.getAddress().getPostalCode()));
                    body = body.replace(CAW_COUNTRY_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(fulfillment.getAddress().getCountry()));
                }
                else {
                    body = body.replace(CAW_LINE1_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                    body = body.replace(CAW_CITY_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                    body = body.replace(CAW_STATE_PROVINCE_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                    body = body.replace(CAW_POSTAL_CODE_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                    body = body.replace(CAW_COUNTRY_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                }
                
                if (argOrderLine.getSelectedShipMethodObject() != null && argOrderLine.getSelectedShipMethodObject().getShipperMethodDesc() != null) {
                    value = argOrderLine.getSelectedShipMethodObject().getShipperMethodDesc();
                    body = body.replace(CAW_SHIP_VIA_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(value));
                }                
                else {
                    body = body.replace(CAW_SHIP_VIA_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);
                }
               
                if (argOrderLine.getSelectedShipMethod() != null) {
                    body = body.replace(CAW_SERVICE_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(argOrderLine.getSelectedShipMethod()));
                }
                else {
                    body = body.replace(CAW_SERVICE_SHIP_TO_INFO_ATTR, CawUtilFunction.formatParameter(CawConstants.VALUE_0));
                }
                             
            }

        }

        return body;
    }
    
    private BigDecimal getSignValue(BigDecimal amount, int caseNum, boolean isReturn) {

        BigDecimal tmpValue = BigDecimal.ZERO;
        if (NumberUtils.isZeroOrNull(amount)) {
            tmpValue = BigDecimal.ZERO;
        } else {
            if (caseNum == 1) {
                tmpValue = isReturn ? amount.abs().negate() : amount.abs();
            } else if (caseNum == 2) {
                tmpValue = isReturn ? amount.abs() : amount.abs().negate();
            }
        }
        return tmpValue;
    }
    
    /**
     * @param argRequestModel
     * @return
     */
    private String getAdjustmentsRequest(
            CawCheetahSubmitRequestModel argRequestModel) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REQUEST_ITEMS_ATTR_ADJUSTMENTS);
        
        StringBuilder sbAdjustment = new StringBuilder();
        String result = null;
        String body = "";
        if (request != null) {
            body = request.getBody();
        }
        
        if (StringUtils.isNotEmpty(body) && argRequestModel.getItemAdjustmentsModel() != null && argRequestModel.getItemAdjustmentsModel().size() > 0) {
            String templateRequest = null;
            sbAdjustment.append("[");
            
            for (CawCheetahItemAdjustmentsModel adjustmentModel : argRequestModel.getItemAdjustmentsModel()) {
                if (adjustmentModel.getCouponCode() != null) {
                    
                    templateRequest = String.valueOf(body);
                    if (adjustmentModel.getCorrelationKey() != null) {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_CORRELATION_KEY_ATTR, CawUtilFunction.formatParameter(adjustmentModel.getCorrelationKey()));
                    }
                    else {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_CORRELATION_KEY_ATTR, CawJSONConstant.NULL);
                    }
                    
                    if (adjustmentModel.getType() != null) {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_TYPE_ATTR, adjustmentModel.getType());
                    }
                    else {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_TYPE_ATTR, CawJSONConstant.NULL);
                    }
                    
                    if (adjustmentModel.getAmount() != null) {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_AMOUNT_ATTR, String.valueOf(adjustmentModel.getAmount()));
                    }
                    else {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_AMOUNT_ATTR, String.valueOf(BigDecimal.valueOf(0.00)));
                    }
                    
                    if (adjustmentModel.getCouponCode() != null) {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_COUPON_CODE_ATTR, CawUtilFunction.formatParameter(adjustmentModel.getCouponCode()));
                    }
                    else {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_COUPON_CODE_ATTR, CawJSONConstant.NULL);
                    }
                    
                    if (adjustmentModel.getSerializedCoupon() != null) {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_SERIALIZED_ATTR, CawUtilFunction.formatParameter(adjustmentModel.getSerializedCoupon()));
                    }
                    else {
                        templateRequest = templateRequest.replace(CAW_ADJUSTMENTS_SERIALIZED_ATTR, CawJSONConstant.NULL);
                    }
                    
                    sbAdjustment.append(templateRequest);
                    sbAdjustment.append(",");
                }
                
            }
            result = sbAdjustment.substring(0, sbAdjustment.length() - 1);
            if (result != null && result.length() > 0) {//BZ55978
                result = result + "]";
            }

        }
        return result;
    }
    
    public String getWarrantyCorrelationKey(IPosTransaction argIPosTransaction, List<IWarranty> argListWarranty, ISaleReturnLineItem argTransLineItem, int lineNumber) {

        String correlationKey = null;
        try {
            if (argListWarranty != null && argTransLineItem != null) {
                DateFormat df = new SimpleDateFormat(YYYY_M_MDD);

                /* BEGIN BZ53752, BZ53876 */

                for (IWarranty warranty : argListWarranty) {
                    if (warranty.getWarrantyLineTransLineItemSeq() == argTransLineItem.getLineItemSequence()) {

                        String storeID = String.format("%4s", warranty.getCoveredLineRtlLocId()).replace(' ', '0');
                        String regID = String.format("%2s", warranty.getCoveredLineWkstnId()).replace(' ', '0');
                        String transSeq = String.format("%4s", warranty.getCoveredLineTransSeq()).replace(' ', '0');
                        Date bsnDate = warranty.getCoveredLineBusinessDate();
                        
                        int countLine = 1;
                        
                        if (warranty.getCoveredLineTransSeq() == argTransLineItem.getTransactionSequence()) {
                            List<ISaleReturnLineItem> coverTransLineItems = argIPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
                            for (ISaleReturnLineItem coverTransLineItem : coverTransLineItems) {
                                if (!coverTransLineItem.getVoid()) {
                                    if (coverTransLineItem.getRetailTransactionLineItemSequence() == warranty.getCoveredLineTransLineItemSeq()) {
                                        break;
                                    }
                                    else {
                                        ++countLine;
                                    }
                                }
                            }
                        }
                        else {
                            PosTransactionId coverPosId = new PosTransactionId();
                            coverPosId.setOrganizationId(warranty.getOrganizationId());
                            coverPosId.setRetailLocationId(warranty.getCoveredLineRtlLocId());
                            coverPosId.setBusinessDate(warranty.getCoveredLineBusinessDate());
                            coverPosId.setWorkstationId(warranty.getCoveredLineWkstnId());
                            coverPosId.setTransactionSequence(warranty.getCoveredLineTransSeq());
                            
                            IPosTransaction coverPosTransaction = DataFactory.getObjectByIdNoThrow(coverPosId);
                            
                            List<ISaleReturnLineItem> coverTransLineItems = coverPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
                            for (ISaleReturnLineItem coverTransLineItem : coverTransLineItems) {
                                if (!coverTransLineItem.getVoid()) {
                                    if (coverTransLineItem.getRetailTransactionLineItemSequence() == warranty.getCoveredLineTransLineItemSeq()) {
                                        break;
                                    }
                                    else {
                                        ++countLine;
                                    }
                                }
                            }
                        }
                        correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq + ":" + countLine;
                    } 
                }
                /* END BZ53752, BZ53876 */
            }
        } catch (Exception ex) {
            _logger.error("Can not build CorrelationKey" + ex.getMessage());
        }

        return correlationKey;
    }

    //END BZ53752
    
    public String getItemsArrTemplateForCheetahReturn(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder, CawCheetahSubmitRequestModel argRequestModel, WarrantyManager argWarrantyMgr, Map<String, List<JSONObject>> argSerialNumberActive, CawDiscountCouponHelper argCawDiscountCouponHelper, List<IWarranty> argListWarranty) {/*BZ40898*/
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REQUEST_ITEMS_ATTR_FOR_CHEETAH_SALE);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = null;
        int lineNumber = 0;
        boolean isRunTransaction = false;
        if (iPosTransaction != null) {
            List<ISaleReturnLineItem> transLineItems = iPosTransaction
                    .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);

            for (ISaleReturnLineItem transLineItem : transLineItems) {
                // Begin BZ23722
                if (!transLineItem.getVoid()) {
                    request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REQUEST_ITEMS_ATTR_FOR_CHEETAH_SALE);
                    body = request.getBody();
                    
                    lineNumber++;
                    
                    String tempCodePropertyWO = null; //BZ54290 - Init value to check WO with Warranty to export correctly
                    
                    if (transLineItem.getReturn()) {
                        request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REQUEST_ITEMS_ATTR_FOR_CHEETAH_RETURN);
                        body = request.getBody();
                        isRunTransaction = true;
                    }
                    
                    temp = String.valueOf(body);
                    String correlationKey = getCorrelationKey(iPosTransaction, stationState);
                    if (!correlationKey.equals(fmtNull)) {
                        correlationKey = correlationKey + ":" + String.valueOf(lineNumber); //BZ51922
                    }
                    // End BZ23722

                    temp = temp.replace(CORRELATION_KEY, CawUtilFunction.formatParameter(correlationKey));
                    // End BZ23722
                    temp = temp.replace(LINE_NUMBER, Integer.toString(lineNumber));

                    if (transLineItem.getQuantity() != null) {//BZ23541
                        temp = temp.replace(QUANTITY, String.valueOf(transLineItem.getQuantity().doubleValue())); //BZ54998
                    } else {
                        temp = temp.replace(QUANTITY, fmtNull);
                    }

                    if (transLineItem.getUnitCost() != null) {//BZ23541
                        temp = temp.replace(COST, transLineItem.getUnitCost().toString());
                    } else {
                        temp = temp.replace(COST, fmtNull);
                    }

                    if (transLineItem.getUnitPrice() != null) {//BZ23541
                        temp = temp.replace(UNIT_PRICE, transLineItem.getUnitPrice().toString());
                    } else {
                        temp = temp.replace(UNIT_PRICE, fmtNull);
                    }

                    temp = temp.replace(IS_SPECIAL_ORDER, fmtNull);
                    temp = temp.replace(IS_RETURN, Boolean.toString(transLineItem.getReturn()));
                    /* Begin BZ28265 */
                    if (transLineItem.getCommissionModifiers() != null
                            && transLineItem.getCommissionModifiers().size() > 0) {
                        temp = temp.replace(SALES_PERSON, getSalesPersonObjTemplate(transLineItem
                                .getCommissionModifiers().get(0)));
                    }
                    // Begin BZ37609
                    else if (transLineItem.getCommissionModifiers().size() <= 0) {                       
                        IParty party = iPosTransaction.getOperatorParty();
                        String name = party.getFirstName() + " " + party.getLastName();
                   
                        JSONObject salesPersion = new JSONObject();
                        try {
                            salesPersion.put("code", party.getEmployeeId());
                            salesPersion.put("fileNumber",party.getEmployeeId());
                            salesPersion.put("name", name);
                        } catch (JSONException ex) {
                            _logger.error("Can not build json request for catalyst service :" + ex.getMessage());
                        }
                                                
                        temp = temp.replace(SALES_PERSON, salesPersion.toString());       
                    }
                    // End BZ37609
                    
                    /* BEGIN BZ30084 */
                    else {
                        temp = temp.replace(SALES_PERSON, fmtNull);
                    }
                    /* END BZ30084 */
                    /* End BZ28265 */
                    temp = temp.replace(REPRICE_ITEM, BOOLEAN_DEFAULT);

                    temp = temp.replace(DISCOUNTS, getDiscountsArrTemplate());
                    temp = temp.replace(PROMPTS, getPromptsObjTemplate());

                    temp = temp.replace(CODE, CawUtilFunction.formatParameter(transLineItem.getItemId()));

                    temp = temp.replace(TYPE, fmtNull);
                    temp = temp.replace(STATUS, fmtNull);

                    if (transLineItem.getTareUnitOfMeasureCode() != null) {//BZ23637
                        temp = temp.replace(UOM, transLineItem.getTareUnitOfMeasureCode());
                    } else {
                        temp = temp.replace(UOM, fmtNull);
                    }

                    temp = temp.replace(DIVISION, fmtNull);

                    if (transLineItem.getItem() != null) {//BZ23637
                        temp = temp.replace(DEPARTMENT, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel1Id()));
                        temp = temp.replace(CLASS_CODE, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel3Id()));
                        temp = temp.replace(SUBCLASS_CODE, CawUtilFunction
                                .formatParameter(transLineItem.getItem().getMerchLevel4Id()));
                    } else {
                        temp = temp.replace(DEPARTMENT, fmtNull);
                        temp = temp.replace(CLASS_CODE, fmtNull);
                        temp = temp.replace(SUBCLASS_CODE, fmtNull);
                    }

                    temp = temp.replace(HAZARD_CLASS, fmtNull);
                    /*BEGIN BZ40898*/
                    if(transLineItem.getOrderModifier() != null) {
                        int lineItemSequence = transLineItem.getRetailTransactionLineItemSequence();
                        int oderLineItemSequence = 0;
                        IOrderLine order = null;
                        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
                            
                            oderLineItemSequence = orderLine.getShadowedSaleItem().getRetailTransactionLineItemSequence();
                            if(lineItemSequence == oderLineItemSequence) {
                                order = orderLine;
                                break;
                            }
                        }
                        if(order != null) {
                            temp = temp.replace(BROKER_ITEM_DETAIL, getBrokerItemDetailTemplate(order, currentOrder.getOrderType())); //BZ45902
                            temp = temp.replace(CAW_SHIP_TO_INFO_ATTR, getShippingInfoTemplate(order));//BZ53752
                        
                        } else {
                            temp = temp.replace(BROKER_ITEM_DETAIL, CawJSONConstant.NULL);
                            temp = temp.replace(CAW_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);//BZ53752
                        } 
                        
                    } else {
                        temp = temp.replace(BROKER_ITEM_DETAIL, CawJSONConstant.NULL);
                        temp = temp.replace(CAW_SHIP_TO_INFO_ATTR, CawJSONConstant.NULL);//BZ53752
                    }
                    /*END BZ40898*/
                    temp = temp.replace(MERCHANDISE_CODE, fmtNull);

                    temp = temp.replace(BUYER, getBuyerObjTemplate());

                    temp = temp.replace(PRICING, getItemPricingObjTemplate(transLineItem));
                    temp = temp.replace(VENDOR, getVendorObjTemplate(transLineItem));

                    if (transLineItem.getItemDescription() != null) {
                        String itemDescription = StringEscapeUtils.escapeJson(transLineItem.getItemDescription());
                        temp = temp.replace(DESCRIPTION, CawUtilFunction.formatParameter(itemDescription));//BZ23722
                    } else {
                        temp = temp.replace(DESCRIPTION, fmtNull);
                    }

                    if (transLineItem.getTaxGroupId() != null) {
                        temp = temp
                                .replace(POS_TAX_CODE, CawUtilFunction.formatParameter(transLineItem.getTaxGroupId()));
                        temp = temp
                                .replace(CAW_TAX_CODE_ATTR, CawUtilFunction.formatParameter(transLineItem.getTaxGroupId()));
                        
                        
                        //BEGIN BZ53752
                        BigDecimal taxAmount = BigDecimal.valueOf(0.00);
                        if (transLineItem.getTaxModifiers() != null) {
                            
                            for (ISaleTaxModifier saleTax : transLineItem.getTaxModifiers()) {
                                if (transLineItem.getTaxGroupId().equalsIgnoreCase(saleTax.getTaxGroupId())) {
                                    taxAmount = taxAmount.add(saleTax.getTaxAmount());
                                }
                            }
                        }
                        
                        temp = temp.replace(CAW_TAX_AMOUNT_ATTR, String.valueOf(taxAmount));
                        
                        if (transLineItem.getExtendedAmount() != null) {//BZ23541
                            temp = temp.replace(LINE_TOTAL, transLineItem.getExtendedAmount().add(taxAmount).toString());
                        } else {
                            temp = temp.replace(LINE_TOTAL, taxAmount.toString());
                        }
                            
                    } else {
                        temp = temp.replace(POS_TAX_CODE, fmtNull);
                        temp = temp.replace(CAW_TAX_CODE_ATTR, fmtNull);
                        
                        temp = temp.replace(CAW_TAX_AMOUNT_ATTR, String.valueOf(BigDecimal.valueOf(0.00)));
                        
                        if (transLineItem.getExtendedAmount() != null) {//BZ23541
                            temp = temp.replace(LINE_TOTAL, transLineItem.getExtendedAmount().toString());
                        } else {
                            temp = temp.replace(LINE_TOTAL, fmtNull);
                        }
                    }
                    //END BZ53752

                    temp = temp.replace(IS_INSTALLABLE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_RETURNABLE, Boolean
                            .toString(!(transLineItem.getItem().getOptions().getNotReturnable())));
                    temp = temp.replace(WEIGHT, NUMBER_DEFAULT);
                    temp = temp.replace(IS_SHIPPABLE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_INVENTORY, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_CLEARANCE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_DROPSHIP, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_SHIP_FREIGHT, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_SHIP_ALONE, BOOLEAN_DEFAULT);
                    temp = temp.replace(IS_DISCOUNTABLE, Boolean
                            .toString(!(transLineItem.getItem().getOptions().getDisallowDiscounts())));
                    temp = temp.replace(IS_LABOR_SKU, BOOLEAN_DEFAULT);
                    
                    //Start BZ53457, BZ53876
                    boolean isCoverWarranty = false;
                    
                    for (IWarranty warranty : argListWarranty) {
                        if (transLineItem.getLineItemSequence() == warranty.getCoveredLineTransLineItemSeq()) {
                            isCoverWarranty = true;
                            break;
                        }
                    }
                    //End BZ53876
                    if (temp.contains(CAW_REASON_CODE) && temp.contains(ORIGINAL_CORRELATION_KEY) && transLineItem.getReturn()) {
                        String returnReasonCode = transLineItem.getReturnReasonCode();
                        
                        String returnReasonDescription = CawJSONConstant.NULL;
                        if (CodeLocator.getReasonCode(ConfigurationMgr.getOrganizationId(), "RETURN", returnReasonCode) != null) {
                            returnReasonDescription = CodeLocator.getReasonCode(ConfigurationMgr.getOrganizationId(), "RETURN", returnReasonCode).getDescription();
                            returnReasonDescription = CawUtilFunction.formatParameter(returnReasonDescription);
                        }

                        /* BEGIN BZ53752 */
                        String originalCorrelationKey = getOriginalCorrelationKey(transLineItem, stationState);
                        if (originalCorrelationKey.equals(fmtNull)) {
                            originalCorrelationKey = CawJSONConstant.NULL;
                        }
                        /* END BZ53752 */
                        
                        temp = temp.replace(CAW_REASON_CODE, returnReasonDescription);
                        temp = temp.replace(ORIGINAL_CORRELATION_KEY, originalCorrelationKey);
                        
                        boolean isWO = false;
                        if (transLineItem.getProperties() != null) {
                            for (IRetailTransactionLineItemProperty property : transLineItem.getProperties()) {
                                if ((property.getPropertyCode().startsWith("WA") && !property.getPropertyCode().equalsIgnoreCase("WARRANTY_STATUS"))) { //BZ53876, BZ54290-Update condtion to prevent case WO+Warranty
                                    temp = temp.replace(CAW_WO_ATTR_SALE, property.getStringValue());
                                    tempCodePropertyWO = property.getPropertyCode();//BZ54290-Capture the property code of WO
                                    isWO = true;
                                }
                            }
                        }
                        if (!isWO) {
                            temp = temp.replace(CAW_WO_ATTR_RETURN, StringUtils.EMPTY);
                        }
                        
                    }
                    else {
                        boolean isWO = false;
                        if (transLineItem.getProperties() != null) {
                            for (IRetailTransactionLineItemProperty property : transLineItem.getProperties()) {
                                if ((property.getPropertyCode().startsWith("WA") && !property.getPropertyCode().equalsIgnoreCase("WARRANTY_STATUS"))) { //BZ53876, BZ54290
                                    temp = temp.replace(CAW_WO_ATTR_SALE, property.getStringValue());
                                    tempCodePropertyWO = property.getPropertyCode();//BZ54290
                                    isWO = true;
                                }
                            }
                        }
                        if (!isWO) {
                            temp = temp.replace(CAW_ATTRIBUTES_WO_SALE, StringUtils.EMPTY);
                            //Start BZ53722
                            if (temp.contains(CAW_ATTRIBUTES_RETURN)) {
                                temp = temp.replace(CAW_ATTRIBUTES_RETURN, StringUtils.EMPTY);
                            }
                            //End BZ53722
                        }
                        
                    }
                    //End BZ53457
                    
                    //BEGIN BZ53752
                    //Item unit of measure
                    AtomicReference<Integer> dataMapping = new AtomicReference<>();
                    dataMapping.set(0);
                    
                    if (transLineItem.getItem().getOptions().getUnitOfMeasureCode() != null) {
                        
                        CawMappingEnum.stream().filter(rpc -> rpc.getKey().equals(transLineItem.getItem().getOptions().getUnitOfMeasureCode())).forEach((tmp) -> {
                            dataMapping.set(tmp.getValue());
                        });
                    }
                    temp = temp.replace(CAW_UNIT_OF_MEASURE_ATTR, String.valueOf(dataMapping.get()));
    
                    //Item list price
                    BigDecimal unitListPrice = BigDecimal.valueOf(0.00);
                    boolean isPromptPrice = false;
                    boolean isReturnWebOrdLineItem = false;
                    
                    if (transLineItem.getRegularBasePrice() != null) {
                        unitListPrice = transLineItem.getRegularBasePrice();
                        
                        //check line item is WO and ItmListPrice < BaseUnitPrice(price response from S&I) 
                        if (StringUtils.isNotEmpty(transLineItem.getStringProperty(CawConstants.IS_WO_ITEM))
                            && unitListPrice != null
                            && transLineItem.getBaseUnitPrice() != null
                            && unitListPrice.compareTo(transLineItem.getBaseUnitPrice()) == -1) {
                            
                            unitListPrice = transLineItem.getBaseUnitPrice();
                        }
                        else {                            
                            for (IItemOptions itemOption : transLineItem.getItem().getItemOptions()) {
                                if (itemOption.getPromptForPrice()) {
                                    isPromptPrice = true;
                                    break;
                                }     
                            }
                            
                            if (transLineItem.getProperties() != null) {
                                for (IRetailTransactionLineItemProperty property : transLineItem.getProperties()) {
                                    if (CawConstants.P_CODE_SALES_ORD_INF.equalsIgnoreCase(property.getPropertyCode())) {
                                        isReturnWebOrdLineItem = true;
                                        break;
                                    }
                                }
                            }
                                                        
                            if (transLineItem.getRegularBasePrice().compareTo(BigDecimal.ZERO) == 0 || isPromptPrice || isReturnWebOrdLineItem) {
                                
                                if (isPromptPrice) {
                                    unitListPrice = transLineItem.getBaseUnitPrice();
                                }
                                else {
                                    unitListPrice = transLineItem.getUnitPrice();
                                }
                            }
                        }
                        
                        temp = temp.replace(CAW_UNIT_OF_LIST_PRICE_ATTR, String.valueOf(unitListPrice));
                    } else {
                        temp = temp.replace(CAW_UNIT_OF_LIST_PRICE_ATTR, CawJSONConstant.NULL);
                    }
                    
                    //Item adjustment
                    try {
                        int countDiscountItem = 1;
                        String couponCodecConfig = null;
                        String pricePropertyCode = transLineItem.getPricePropertyCode();
                        boolean checkHouseAccountPayment = false;
                        
                        if (pricePropertyCode == null) {
                            couponCodecConfig = CawConstants.COUPONCODEDEFAULT;
                        } else {
                            if (CawConstants.CLUB_CODE.equalsIgnoreCase(pricePropertyCode)) {
                                couponCodecConfig = CawConstants.CLUB_VALUE;
                                
                            } else if (CawConstants.WHOLESALE_CODE.equalsIgnoreCase(pricePropertyCode)) {
                                couponCodecConfig = CawConstants.WHOLESALE_VALUE;
                                
                            } else if (CawConstants.CREW_CODE.equalsIgnoreCase(pricePropertyCode)) {
                                couponCodecConfig = CawConstants.CREW_VALUE;
                                
                            } else {
                                couponCodecConfig = CawConstants.COUPONCODEDEFAULT;
                            }
                            
                        }
                        
                        if (transLineItem.getBaseUnitPrice().compareTo(unitListPrice) != 0
                            && !(transLineItem.getRegularBasePrice().compareTo(BigDecimal.ZERO) == 0 || isPromptPrice || isReturnWebOrdLineItem)) {
                            
                            String adjustmentCorrelationKey = correlationKey + ":" + countDiscountItem;
                            
                            BigDecimal itemDiscountAmount = unitListPrice.subtract(transLineItem.getBaseUnitPrice());
                            itemDiscountAmount = itemDiscountAmount.multiply(transLineItem.getQuantity()).multiply(BigDecimal.valueOf(-1));
                            
                            BigDecimal adjAmount = getSignValue(itemDiscountAmount, 2, transLineItem.getReturn());
                             
                            CawCheetahItemAdjustmentsModel adjustmentModel = new CawCheetahItemAdjustmentsModel();
                            adjustmentModel.setCorrelationKey(adjustmentCorrelationKey);
                            adjustmentModel.setType(String.valueOf(1));
                            adjustmentModel.setCouponCode(couponCodecConfig);
                            adjustmentModel.setSerializedCoupon(null);
                            adjustmentModel.setAmount(adjAmount);
                            argRequestModel.setItemAdjustmentsModel(new ArrayList());
                            argRequestModel.getItemAdjustmentsModel().add(adjustmentModel);
                            countDiscountItem++;
                        } 
                        
                        if (!checkHouseAccountPayment) {
                            
                            if (transLineItem.getRetailPriceModifiers() != null) {
                                for (IRetailPriceModifier modLine : transLineItem.getRetailPriceModifiers()) {
                                    
                                    if (!((transLineItem.getRegularBasePrice().compareTo(BigDecimal.ZERO) == 0
                                            && !isPromptPrice) || isReturnWebOrdLineItem) 
                                            && modLine.getExtendedAmount().compareTo(BigDecimal.ZERO) != 0) {
                                            
                                            String adjustmentCorrelationKey = correlationKey + ":" + countDiscountItem;
                                            
                                            BigDecimal adjAmount = getSignValue(modLine.getExtendedAmount().multiply(BigDecimal.valueOf(-1)), 2, transLineItem.getReturn());
                                            

                                            CawCheetahItemAdjustmentsModel adjustmentModel = new CawCheetahItemAdjustmentsModel();
                                            adjustmentModel.setCorrelationKey(adjustmentCorrelationKey);
                                            adjustmentModel.setType(String.valueOf(1));
                                            adjustmentModel.setAmount(adjAmount);
                                            
                                            if (!"PROMPT_PRICE_CHANGE".equalsIgnoreCase(modLine.getRetailPriceModifierReasonCode())
                                                &&  !"PRICE_OVERRIDE".equalsIgnoreCase(modLine.getRetailPriceModifierReasonCode())) {
                                                
                                                
                                                if (modLine.getDiscountReasonCode() != null) {
                                                    
                                                    adjustmentModel.setCouponCode(modLine.getDiscountReasonCode());
                                                    adjustmentModel.setSerializedCoupon(null);
                                                    
                                                    if (CodeLocator.getReasonCode(ConfigurationMgr.getOrganizationId(), "DISCOUNT", modLine.getDiscountReasonCode()) != null) {
                                                        List<IReasonCodeProperty> reasonCodeProps = CodeLocator.getReasonCode(ConfigurationMgr.getOrganizationId(), "DISCOUNT", modLine.getDiscountReasonCode()).getProperties();

                                                        for (IReasonCodeProperty prop : reasonCodeProps) {
                                                            if ("ENTER_COUPON_CODE".equalsIgnoreCase(prop.getPropertyCode())) {
                                                                if (prop.getDecimalValue().compareTo(BigDecimal.ONE) == 0) {
                                                                    adjustmentModel.setCouponCode(modLine.getNotes());
                                                                }
                                                            }
                                                        }
                                                    }

                                                }
                                                else {
                                                    if (modLine.getDealId() == null) {
                                                        adjustmentModel.setCouponCode(modLine.getDiscountCode());
                                                        adjustmentModel.setSerializedCoupon(modLine.getSerialNumber());
                                                        
                                                    } else {
                                                    	//Begin BZ53876
                                                        if (modLine.getDealId() != null) {
                                                                       
                                                            String serialNumber = argCawDiscountCouponHelper.getSerialNumber(modLine.getDealId(), argSerialNumberActive);
                                                            
                                                            adjustmentModel.setCouponCode(modLine.getDealId());
                                                            adjustmentModel.setSerializedCoupon(null);
                                                            
                                                            if (serialNumber != null) {
                                                                adjustmentModel.setSerializedCoupon(serialNumber);
                                                            }
                                                            
                                                            if (modLine.getProperties() != null) {
                                                                for (IRetailPriceModifierProperty property : modLine.getProperties()) {
                                                                    if (!"IS_LOYALTY_MODIFIER".equalsIgnoreCase(property.getPropertyCode())
                                                                            || property.getPropertyCode() != null) {
                                                                       
                                                                        adjustmentModel.setSerializedCoupon(property.getPropertyCode());
                                                                        adjustmentModel.setAmount(property.getDecimalValue());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        //End BZ53876
                                                    }
                                                }
                                            }
                                            /* BEGIN BZ55978 */
                                            if (argRequestModel.getItemAdjustmentsModel() != null) {
                                                argRequestModel.getItemAdjustmentsModel().add(adjustmentModel);
                                            } else {
                                                argRequestModel.setItemAdjustmentsModel(new ArrayList<CawCheetahItemAdjustmentsModel>());
                                                argRequestModel.getItemAdjustmentsModel().add(adjustmentModel);
                                            }
                                            /* END BZ55978 */
                                            countDiscountItem++;
                                        }
                                }
                            }
                        }
                        
                        String adjRequest = getAdjustmentsRequest(argRequestModel);
                        if (adjRequest != null && adjRequest.length() >0 
                                && argRequestModel.getItemAdjustmentsModel() != null 
                                    && argRequestModel.getItemAdjustmentsModel().size() > 0) {//BZ55978
                            temp = temp.replace(CAW_ADJUSTMENTS_ATTR, adjRequest);
                        } else {
                            temp = temp.replace(CAW_ADJUSTMENTS_ATTR, CawJSONConstant.NULL);
                        }
                       
                        argRequestModel.setItemAdjustmentsModel(null); //reset adjustment of item
                    }
                    catch (Exception ex) {
                        _logger.warn("Cannot build adjustment attribute for item '"+ transLineItem.getItemId() +"' due to:" + ex.getMessage());//BZ55978
                        temp = temp.replace(CAW_ADJUSTMENTS_ATTR, CawJSONConstant.NULL);
                        argRequestModel.setItemAdjustmentsModel(null); //reset adjustment of item
                    }

                    //property
                    try {
                    	//Begin BZ53876
                        boolean isWarranty = false;
                        
                        for (IWarranty warranty : argListWarranty) {
                            if (transLineItem.getLineItemSequence() == warranty.getWarrantyLineTransLineItemSeq()) {
                                isWarranty = true;
                                break;
                            }
                        }
                        //End BZ53876
                        StringBuilder sbPro = new StringBuilder();
                        StringBuilder finalProperty4 = new StringBuilder();
                        if (transLineItem.getItem().getItemPromptProperties() != null
                                || transLineItem.getProperties() != null
                                || transLineItem.getSerialNumber() != null
                                || isWarranty) {
                            
                            for (IRetailTransactionLineItemProperty property : transLineItem.getProperties()) {

                                if (!(property.getPropertyCode().equalsIgnoreCase(tempCodePropertyWO))) { //BZ53876, BZ54290-Add condition difference WO property code
                                     
                                    if (sbPro.length() > 0) {
                                        sbPro.append(",");
                                    }
                                    
                                    /* BEGIN BZ54031 */
                                    if ("RV_SERVICE_PAYMENT_PROPERTIES".equalsIgnoreCase(property.getPropertyCode())) {
                                        String rvServicePaymentProperties = property.getStringValue();
                                        if (rvServicePaymentProperties != null && rvServicePaymentProperties.length() > 0) {
                                            String rvPropertise = rvServicePaymentProperties.substring(1, rvServicePaymentProperties.length() -1);
                                            if (rvPropertise != null && rvPropertise.length() > 0) {
                                                sbPro.append(rvPropertise);
                                            }
                                        }
                                    /* END BZ54031 */
                                    /* BEGIN BZ59343 */
                                    } else if(property.getPropertyCode().startsWith(CawConstants.WOP_PREFIX)) {
                                        if (property.getStringValue() != null && !property.getStringValue().isEmpty()) {
                                            sbPro.append(property.getStringValue()); //add all item properties value to request
                                        } else {
                                            //remove the last character "," append above because don't add property "WP" to request
                                            sbPro.deleteCharAt(sbPro.length() - 1);
                                        }
                                    /* END BZ59343 */
                                    } else {
                                        sbPro.append("\"");
                                        sbPro.append(property.getPropertyCode().toLowerCase());
                                        sbPro.append("\":");
                                        if (property.getDateValue() != null) {
                                            sbPro.append(CawUtilFunction.formatParameter(String.valueOf(property.getDateValue())));
                                        } else if (property.getDecimalValue() != null) {
                                            sbPro.append(CawUtilFunction.formatParameter(String.valueOf(property.getDecimalValue())));
                                        } else {
                                            sbPro.append(CawUtilFunction.formatParameter(property.getStringValue()));
                                        }
                                    }
                                }
                            }
                            if (transLineItem.getSerialNumber() != null) {
                                if (sbPro.length() > 0) {
                                    sbPro.append(",");
                                }
                                sbPro.append("\"serialNumber\":");
                                sbPro.append(CawUtilFunction.formatParameter(transLineItem.getSerialNumber()));
                            }

                            if (isWarranty) {
                                String warrantyCorrelationKey = getWarrantyCorrelationKey(iPosTransaction, argListWarranty, transLineItem, lineNumber); //BZ53876
                                
                                if (warrantyCorrelationKey != null) {
                                    if (sbPro.length() > 0) {
                                        sbPro.append(",");
                                    }
                                    sbPro.append("\"warrantedItem\":");
                                    sbPro.append(CawUtilFunction.formatParameter(warrantyCorrelationKey));
                                }
                            }

                            
                            if (sbPro.length() > 0) {
                                finalProperty4.append("{").append(sbPro).append("}");
                                temp = temp.replace(CAW_PROPERTIES_ATTR, finalProperty4);
                            }
                            else {
                                temp = temp.replace(CAW_PROPERTIES_ATTR, CawJSONConstant.NULL);
                            }
                            
                        }
                    }
                    catch (Exception exp) {
                        _logger.warn("Cannot build propertie attribute for item '"+ transLineItem.getItemId() +"' due to:" + exp.getMessage());//BZ55978
                        temp = temp.replace(CAW_PROPERTIES_ATTR, CawJSONConstant.NULL);
                    }
                    //END BZ53752
                    resultBuilder.append(temp);
                    resultBuilder.append(",");
                }
            }
            if (resultBuilder.length() > 0) {
                if (isRunTransaction || CawWorkOrderOptionsOp.isCompleteAction()) {//BZ54290
                    int countLineItem = 0;
                    List<ISaleReturnLineItem> transLineItemsList = iPosTransaction
                            .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
                    if(transLineItemsList != null && transLineItemsList.size() > 0) {
                        for (ISaleReturnLineItem lineItem : transLineItems) {
                            if(!lineItem.getVoid()) {
                                countLineItem = countLineItem + 1;
                            }
                        }
                    }
                    List<IRetailTransactionLineItem> tenderLines = iPosTransaction.getTenderLineItems();
                    if (tenderLines != null && tenderLines.size() > 0) {
                        for (IRetailTransactionLineItem tenderLine : tenderLines) {
                            if (tenderLine instanceof VoucherTenderLineItemModel) {
                                VoucherTenderLineItemModel voucherLine = (VoucherTenderLineItemModel) tenderLine;
                                if ("ISSUED".equalsIgnoreCase(voucherLine.getActivityCode()) && !voucherLine.getVoid()) {
                                    if (voucherLine.getOrigSTAN() != null && voucherLine.getSerialNumber() != null) {
                                        countLineItem = countLineItem + 1;
                                        String giftCardJson = buildGCJsonTemplate(iPosTransaction, stationState
                                                , voucherLine.getOrigSTAN(), voucherLine.getSerialNumber()
                                                , countLineItem);
                                        if (giftCardJson != null) {
                                            resultBuilder.append(giftCardJson);
                                            resultBuilder.append(",");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            result = SQUARE_BRACKETS_OPEN
                    + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                    + SQUARE_BRACKETS_CLOSE;
        }
        return result;
    }
    
    public String buildGCJsonTemplate(IPosTransaction iPosTransaction, StationState stationState
            , String giftCardId, String serialNumber, int lineNumber) {
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest("REQUEST_CHEETAH_ITEM_GIFT_CARD_ATTR");
            if (request != null && request.getBody() != null) {
                String temp = request.getBody();
                String correlationKey = getCorrelationKey(iPosTransaction, stationState) + ":" +  lineNumber;
                temp = temp.replace("!{correlationKey}", CawUtilFunction.formatParameter(correlationKey));
                
                IParty party = iPosTransaction.getOperatorParty();
                String name = party.getFirstName() + " " + party.getLastName();
                
                temp = temp.replace("!{salePersonCode}", CawUtilFunction.formatParameter(party.getEmployeeId()));
                temp = temp.replace("!{fileNumber}", CawUtilFunction.formatParameter(party.getEmployeeId()));
                temp = temp.replace("!{name}", CawUtilFunction.formatParameter(name));
                
                temp = temp.replace("!{code}", CawUtilFunction.formatParameter(giftCardId));
                temp = temp.replace("!{serialNumber}", CawUtilFunction.formatParameter(serialNumber));
                return temp;
            }
           
        } catch (Exception ex) {
            return null;
        }
        
        return null;
    }

    /* BEGIN BZ61159 */
    public String updateMembershipsAttrPitches(String cusomterInfo, String membershipsIdentifier,
            CawMembershipActivityModel membershipActivityModel) {

        String customerStr = null;
        if (StringUtils.isNotEmpty(cusomterInfo)) {
            try {
                JSONArray arrayList = new JSONArray(); //BZ25434
                JSONObject customerObj = new JSONObject(cusomterInfo);
                if (!customerObj.isNull(MEMBERSHIPS_KEY)) {
                    arrayList = customerObj.getJSONArray(MEMBERSHIPS_KEY); //BZ25434
                }
                JSONObject membershipObj = makeUpMembershipInfo(membershipsIdentifier, membershipActivityModel);
                int position = checkMembershipExist(membershipsIdentifier, membershipActivityModel, arrayList);
                if (position > -1) {
                    // Modify identifier of membership.
                    try {
                        JSONObject tempJSONObject = (JSONObject) arrayList.get(position);
                        tempJSONObject.put(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR, membershipsIdentifier);
                        customerObj.put(MEMBERSHIPS_KEY, arrayList);
                    } catch (Exception ex) {
                        _logger.error("Can not modify identifier of membership." + ex.getMessage());
                    }
                } else {
                    arrayList.put(membershipObj); //BZ25434
                    customerObj.put(MEMBERSHIPS_KEY, arrayList);
                }

                // The customer has joined club pricing.
                if (!customerObj.isNull(CawEBSConstant.PRICING_ATTR)) {
                    JSONObject pricingObj = customerObj.getJSONObject(CawEBSConstant.PRICING_ATTR);
                    if (!pricingObj.isNull(CawEBSConstant.PRICE_BAND)) {
                        if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())
                                && !PRICE_CLUB.equalsIgnoreCase(pricingObj.getString(CawEBSConstant.PRICE_BAND))) {
                            pricingObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                            customerObj.put(CawEBSConstant.PRICING_ATTR, pricingObj);
                        }
                    }
                } else {
                    //Begin BZ24944
                    // Price attribute
                    JSONObject priceObj = new JSONObject();
                    /* BEGIN BZ28907 */
                    if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())) {
                        priceObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                    } else {
                        priceObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        priceObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_DESCRIPTION);
                        priceObj.put(CawEBSConstant.PRICE_BAND, PRICE_RETL);
                    }
                    /* END BZ28907 */
                    priceObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND, "");
                    priceObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                    customerObj.put(CawEBSConstant.PRICING_ATTR, priceObj);
                    //End BZ24944
                }
                //End BZ26398
                customerStr = customerObj.toString();
            } catch (Exception ex) {
                _logger.error("Can not parse string Customer object to Json object." + ex.getMessage());
            }
        }
        return customerStr;
    }
    //BEGIN BZ62146
    public JSONObject updatePricingAttrPitches(String cusomterInfo, String membershipsIdentifier,
            CawMembershipActivityModel membershipActivityModel, TransactionScope _transactionScope) {
        JSONObject pricingObj = new JSONObject();
        if (StringUtils.isNotEmpty(cusomterInfo)) {
            try {
                JSONObject customerObj = new JSONObject(cusomterInfo);
                JSONObject membershipObj = makeUpMembershipInfo(membershipsIdentifier, membershipActivityModel);
                // The customer has joined club pricing.
                if (!customerObj.isNull(CawEBSConstant.PRICING_ATTR)) {
                    pricingObj = customerObj.getJSONObject(CawEBSConstant.PRICING_ATTR);
                    if (!pricingObj.isNull(CawEBSConstant.PRICE_BAND)) {
                        if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())
                                && !PRICE_CLUB.equalsIgnoreCase(pricingObj.getString(CawEBSConstant.PRICE_BAND))) {
                            pricingObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                            pricingObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                        }
                    }
                } else {
                    //Begin BZ24944
                    // Price attribute
                    
                    /* BEGIN BZ28907 */
                    if (PRICE_CLUB.equals(membershipActivityModel.getCustomerGroup())) {
                        pricingObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        pricingObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        pricingObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.PRICE_DESCRIPTION_VALUE);
                        pricingObj.put(CawEBSConstant.PRICE_BAND, CawEBSConstant.PRICE_BAND_VALUE);
                    } else {
                        pricingObj.put(CawEBSConstant.PRICE_IDENTIFIER, CawEBSConstant.PRICE_IDENTIFIER_ID);
                        pricingObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND_ID, CawEBSConstant.PRICE_PRICE_COMPARE_BAND_VALUE);
                        pricingObj.put(CawEBSConstant.PRICE_DESCRIPTION, CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_DESCRIPTION);
                        pricingObj.put(CawEBSConstant.PRICE_BAND, PRICE_RETL);
                    }
                    /* END BZ28907 */
                    pricingObj.put(CawEBSConstant.PRICE_PRICE_COMPARE_BAND, "");
                    pricingObj.put(CawEBSConstant.PRICE_MEMBERSHIP, membershipObj);
                    //End BZ24944
                }
                //End BZ26398
            } catch (Exception ex) {
                _logger.error("Can not parse string Customer object to Json object." + ex.getMessage());
            }
        }
        return pricingObj;
    }
    //END BZ62146
    /* END BZ61159 */
}
