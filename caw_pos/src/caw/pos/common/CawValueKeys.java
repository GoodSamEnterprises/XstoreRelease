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
 * BZ23052              070817    Advance Prompting
 * BZ23458              210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                                largely the same as the non-receipted return flow
 * BZ23339              210917    [DEV] Implement Gift card authorization
 * BZ23339              260917    [DEV] Implement Gift card authorization
 * BZ23558              270917    Receipts are missing EMV data
 * BZ23263              250917    Implement House Account
 * BZ23406              290917    Implement tender by "Create Good Sam Visa" card function
 * BZ23359              021017    Gift cards can't be swiped at screen
 * BZ23356              011017    CWS Will Require a Printed Decline Receipt for EMV Tenders
 * BZ23356              011017    CWS Will Require a Printed Decline Receipt for EMV Tenders
 * BZ23725              051017    [Payment] Missing shopping pass authorization information on the sale receipt
 * BZ23688              091017    Good Sam application returns a second approval & different account number even though customer already has an account
 * BZ23933              101017    Missing Credit card number/Authorization/Entry method and signature 
 *                                on receipt when competing transaction with tender new good Sam visa
 * BZ23676              101017    [Tender] The New Good Sam VISA tender option button should only be available on the transaction that the application was approved for.
 * BZ23440              111017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ23955              131017    Should be removed return information on return product receipt
 * BZ24051              171017    price of reload GC is displayed incorrectly at return screen when performing return no receipt a Reload GC
 * BZ24105              191017    Should be distinguish Good Sam Visa card and Shopping Pass tender in DB
 * BZ23993              191017    Should be removed coupon discount amount out of transaction when void line tender new good Sam visa
 * BZ24124              201017    Entering amount coupon requires unexpectedly when pressing Yes on "Confirm amount coupon" in case amount due < coupon amount
 * BZ24173              241017    "Credit card is required" prompt is looping unexpectedly when backing from "Tender option" list
 * BZ24150              241017    [DEV] Serialized Merchandise certificate (coupon) applied to transaction subtotal
 * BZ24219              011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard
 * BZ24317              011117    Membership validate response data from EBS should be displayed instead of Xstore messages in case the customer has already membership ID
 * BZ24324              021117    Membership validation prompt should be distinguish when joining in GS club and GS RS (Roadside assistance)
 * BZ24326              021117    "Credit Card tender is required" prompt should be trigger after fee selected "Auto-renew" joining in GS RA added into sale screen
 * BZ24356              031117    [Advance Prompting] Xstore needs to return to Membership Info prompt after a failed membership validation response
 * BZ24385              081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24354              081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ24404              091117    'Picked up by' of Third- party tender displayed incorrect in receipt when doing transaction between AR and Third- party
 * BZ24414              091117    When Adding New Customer for Warranty Item New 'Logoff' Button Appears
 * BZ24561              221117    Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ24945              281217    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ24957              291217    'Confirmation to Join Good Sam Club' screen displays unexpectedly when pressing Cancel on 'Insert Check/MCR Read error' screen
 * BZ23405              160118    [QAS] There are problem when integrate Xstore with QAS service of Camping World
 * BZ25068              220118    New Requirement to Process Web Order Returns
 * BZ25207              240118    Return Tender Options displays incorrectly tender types when refunding Web Order items.
 * BZ25916              120418    New customer is attached account# of previous customer info unexpectedly at Dashboard also prompting request with catalyst 1 or 4
 * BZ25115              180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ25358              290418    Enhancements to QAS Integration with POS
 * BZ25434              110518    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25958              100718    New Requirement - Remove Gift Card transactions from the Pin Pad
 * BZ25435              160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ26836              170718    [Internal][QAS]There are not consistent result found from QAS validation when doing QAS process via Assign&Continue and Save&Changes with the same address.
 * BZ26289              170718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ26207              190718    New Requirement - Enable Work Order Functionality
 * BZ25958              010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ27024              060818    [1.6.2] WO- Refund check doesn't display on return tender options screen when doing WO refund
 * BZ27107              080818    [1.6.5][Internal] Item Quantity in S&I did not flow to Xstore for Work Order Transaction
 * BZ26978              060818    Gift Card Receipt not printing for activation/reload
 * BZ27192              150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27256              200818    Extend price doesn't show on WO refund UI as well as receipt.
 * BZ27286              210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ27248              210818     Warranty Items from S&I are not associated with the items covered
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ27813              181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 * BZ27924              231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 * BZ28265              261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28567              071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28247              111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ29205              280119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29134              290119    [Internal] The Account Lookup flow should be aborted after three failed attempts look up a customer hasn't found in system.
 * BZ29387              140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ28033              200219    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ29407              260219    [Internal] Xstore continues to prompt prescreen after application has been successfully completed.
 * BZ29743              260319    [Internal] Modify Tender screen is prompted when there is no tenders to modify.
 * BZ29884              270319    [Prod] Work Order Issues- warranty item price was changed after import into xstore
 * BZ29625              080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 * BZ31943              170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 * BZ32517              251019    [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory.
 * BZ30259              120220    [New Requirement] Customer Specific Messages on Receipts
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ35513              120320    [NEW REQ] Need option for "No Receipt" as a Receipt Method on Sales Complete screen
 * BZ36405              030620    Issue with Credit Customer placed on credit hold 
 * BZ37109              240820    [Task] Call QAS integration in Delivery Order to verify customer shipping address
 * BZ37382          	270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ37750              110920    Cannot close the message box informed Order Management System Offline when selecting Printing Pick List
 * BZ37753              160920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ37912              021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ37396              051020    Tax value calculation issue in Order transactions
 * BZ38349              071020    [Internal] Updated value for other fields (emails, phone,..) into Delivery Information ae reverted to old value after applied correct address from QAS address verification.
 * BZ40798              240221    Modification to member savings calculation
 * BZ41674              050321    ADS Settlement - ORIG_INVOICE_NO on the return needs to match the INVOICE_NO of the purchase.
 * BZ45156              030821    [PROD] Update Miraserv auth request to include recurring payment indicator
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ46257              150921    [Internal] IDS Payment - Xstore displays 'RV service payment not found' instead of 'RV service payment search screen' when hit Add another payment after selected all payment result into transaction.
 * BZ42307              200921    [Requirement] Add ability to reject at the item level for BOPIS
 * BZ45995              141021    [New requirement] Email capture when good sam membership is sold
 * BZ46682              131021    [Internal] Partial Rejected items does not display on the Order Maintenance screen - BOPIS
 * BZ42019              171121    Replace QAS with EAVS2
 * BZ46381              110821    IDS Payment - Should be able to scan a barcode of IDS Customer Number and IDS WO Number when doing a RV Service Payment Search in Xstore
 * BZ47803              211221    [Internal patch 7.0.18] Xstore did not call to validate mailing address when creating a new customer with the address was entered from the Customer Search form
 * BZ46743              050122    Vehicle Identification Number (VIN) Capture for Xstore
 * BZ47123              050122    [PROD] Order Service Token Error
 * BZ48629              250222    [Task] Print Points Balances - Sale transaction
 * BZ48401              210222    [Task] Apply Reward to Redeem in Sales Transaction 
 * BZ49706              280422    [Internal] - The 'Points Redemption' prompt is displaying without value when reward is null.
 * BZ49893              100522    [Internal] - The message in case the customer is not eligible meets the offer threshold did not show
 * BZ53752              221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 * BZ54208              261222    [BTM-280] Production Issue | Applying funds onto gift card without charging
 * BZ54290              160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ57844              080823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58779              090723    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 * BZ59418              181023    Free Tier Opt In Loyalty SKU customization
 * BZ59669              301023    [FreeTier short term] Update the membership resend [Catalyst=] call to a membership valdiation call
 * BZ63225              230424    Issue with refunds from Work Order Completes
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62146              060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ69391              020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389              020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390              020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 * BZ69644              170225    [Internal][AGIS Modification] The 'Item Not On File' prompt is NOt displayed when entering Membership items do not exist in Xstore
 *===================================================================
 */

package caw.pos.common;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.http.ResponseEntity;

import caw.mailingaddress.CawMailingAddressRequest;
import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.advance.prompting.CawMembershipActivityModel;
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.card.services.CawSubmitStatusResponse;
import caw.pos.cheetah.promotion.CawPromotionModel;
import caw.pos.customer.CawCustomerMaintenanceModel;
import caw.pos.order.CawShippingGroupsModel;
import caw.pos.promotion.api.response.CawCouponData;
import caw.pos.register.rvpayment.CawRvPaymentModel;
import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;
import caw.pos.wondersign.model.CawWonderSignCart;
import caw.pos.wondersign.model.CawWonderSignCartItem;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderItem;
import caw.qas.proweb.CawAddressLineType;
import caw.qas.proweb.CawQASearchResult;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.CawDeclinedReferenceData;
import oracle.retail.xstore.avs.impl.response.AddressVerificationResponse;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.data2.access.IHasDataProperty;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.order.DeliveryInfoModel;
import dtv.tenderauth.event.IAuthResponse;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.crm.IPartyLocaleInformation;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.inv.IShipperMethod;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 * The CawValueKeys class
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public final class CawValueKeys {

    public static final ValueKey<Long>                                    ESB_ACCOUNT_NUMBER                        = new ValueKey<Long>(
            Long.class, "ESB_ACCOUNT_NUMBER");

    public static final ValueKey<Boolean>                                 IS_EBS_OFFLINE                            = new ValueKey(
            Boolean.class, "IS_EBS_OFFLINE");

    public static final ValueKey<JSONArray>                               CATALYST_MESSAGES                         = new ValueKey<JSONArray>(
            JSONArray.class, "CATALYST_MESSAGES");

    public static final ValueKey<JSONArray>                               CATALYST_INPUTS                           = new ValueKey<JSONArray>(
            JSONArray.class, "CATALYST_INPUTS");

    public static final ValueKey<JSONArray>                               CATALYST_DIRECTIVES                       = new ValueKey<JSONArray>(
            JSONArray.class, "CATALYST_DIRECTIVES");

    public static final ValueKey<ArrayList<String>>                       CATALYST_ITEM_SELECTED                    = new ValueKey(
            ArrayList.class, "CATALYST_ITEM_SELECTED");

    public static final ValueKey<ArrayList<String>>                       LIST_ITEM_ADDED                           = new ValueKey(
            ArrayList.class, "LIST_ITEM_ADDED");

    public static final ValueKey<ArrayList<CawCouponData>>                LIST_COUPON_DATA                          = new ValueKey(
            ArrayList.class, "SERIAL_INFO_RESPONSE");

    public static final ValueKey<String>                                  LOOKUP_RESPONSE                           = new ValueKey<String>(
            String.class, "LOOKUP_RESPONSE");

    // Begin BZ23052
    public static final ValueKey<String>                                  CATALYST_CUSTOMER_IDENTIFIED_RESPONSE     = new ValueKey<String>(
            String.class, "CATALYST_CUSTOMER_IDENTIFIED_RESPONSE");

    public static final ValueKey<String>                                  CATALYST_TRANSACTION_TOTAL_RESPONSE       = new ValueKey<String>(
            String.class, "CATALYST_TRANSACTION_TOTAL_RESPONSE");

    public static final ValueKey<Integer>                                 ELEMENT_ACTIVE                            = new ValueKey<Integer>(
            Integer.class, "ELEMENT_ACTIVE");

    public static final ValueKey<Boolean>                                 IS_INPUT_BACK_BUTTON                      = new ValueKey<Boolean>(
            Boolean.class, "IS_INPUT_BACK_BUTTON");

    public static final ValueKey<String>                                  API_LOOKUP_RESPONSE                       = new ValueKey<String>(
            String.class, "API_LOOKUP_RESPONSE");

    public static final ValueKey<String>                                  MAKE_CREDIT_OFFER                         = new ValueKey<String>(
            String.class, "MAKE_CREDIT_OFFER");

    public static final ValueKey<String>                                  CASH_ONLY                                 = new ValueKey<String>(
            String.class, "CASH_ONLY");

    public static final ValueKey<String>                                  CREDIT_CARD_ONLY                          = new ValueKey<String>(
            String.class, "CREDIT_CARD_ONLY");

    public static final ValueKey<String>                                  NO_CHECK                                  = new ValueKey<String>(
            String.class, "NO_CHECK");

    public static final ValueKey<String>                                  ADD_ITEM                                  = new ValueKey<String>(
            String.class, "ADD_ITEM");

    public static final ValueKey<String>                                  VOID_ITEM                                 = new ValueKey<String>(
            String.class, "VOID_ITEM");

    public static final ValueKey<String>                                  VOID_TRANSACTION                          = new ValueKey<String>(
            String.class, "VOID_TRANSACTION");

    public static final ValueKey<String>                                  SUSPEND_PROMPTING                         = new ValueKey<String>(
            String.class, "SUSPEND_PROMPTING");

    public static final ValueKey<String>                                  STORE_VALUE                               = new ValueKey<String>(
            String.class, "VOID_ITEM");

    public static final ValueKey<String>                                  CREDIT_CARD_REQUIRED                      = new ValueKey<String>(
            String.class, "CREDIT_CARD_REQUIRED");

    public static final ValueKey<JSONArray>                               CATALYST_CUSTOMER_RESPONSE_MESSAGES       = new ValueKey<JSONArray>(
            JSONArray.class, "CATALYST_CUSTOMER_RESPONSE_MESSAGES");

    public static final ValueKey<JSONArray>                               CATALYST_CUSTOMER_RESPONSE_INPUTS         = new ValueKey<JSONArray>(
            JSONArray.class, "CATALYST_CUSTOMER_RESPONSE_INPUTS");

    public static final ValueKey<Map>                                     CATALYST_CUSTOMER_RESPONSE_DIRECTIVES     = new ValueKey<Map>(
            Map.class, "CATALYST_CUSTOMER_RESPONSE_DIRECTIVES");

    public static final ValueKey<Boolean>                                 IS_CALL_BACK                              = new ValueKey<Boolean>(
            Boolean.class, "IS_CALL_BACK");

    // End BZ23052

    public static final ValueKey<BigDecimal>                              CURRENT_VOUCHER_BALANCE                   = new ValueKey<BigDecimal>(
            BigDecimal.class, "CURRENT_VOUCHER_BALANCE");

    public static final ValueKey<Map>                                     CATALYST_IS_CALL_BACK_DATA                = new ValueKey<Map>(
            Map.class, "CATALYST_IS_CALL_BACK_DATA");

    public static final ValueKey<CawMiraResponse>                         SAVED_MIRA_RESPONSE                       = new ValueKey<CawMiraResponse>(
            CawMiraResponse.class, "SAVED_MIRA_RESPONSE");

    /* Begin BZ23458 */
    /*
     * Set Purchase Used Firearm
     */
    public static final ValueKey<Boolean>                                 IS_PURCHASE_USED_FIREARM                  = new ValueKey<Boolean>(
            Boolean.class, "IS_PURCHASE_USED_FIREARM");
    /* End BZ23458 */

    public static final ValueKey<String>                                  NO_ITEM                                   = new ValueKey<String>(
            String.class, "NO_ITEM");

    public static final ValueKey<String>                                  CATALYS_CALL_BACK_TO_OP                   = new ValueKey<String>(
            String.class, "CATALYS_CALL_BACK_TO_OP");
    // BZ23558
    //Begin BZ23263

    public static final ValueKey<Boolean>                                 IS_ALLOW_DISPLAY_AR_ACCOUNT               = new ValueKey<Boolean>(
            Boolean.class, "IS_ALLOW_DISPLAY_AR_ACCOUNT");

    public static final ValueKey<BigDecimal>                              AR_ACCOUNT_BALANCE                        = new ValueKey<BigDecimal>(
            BigDecimal.class, "AR_ACCOUNT_BALANCE");

    public static final ValueKey<Boolean>                                 IS_ALLOW_DISPLAY_PROMPT_AMT               = new ValueKey<Boolean>(
            Boolean.class, "IS_ALLOW_DISPLAY_PROMPT_AMT");

    public static final ValueKey<Boolean>                                 IS_ALLOW_DISPLAY_THIRD_PARTY              = new ValueKey<Boolean>(
            Boolean.class, "IS_ALLOW_DISPLAY_THIRD_PARTY");

    //END BZ23263
    public static final ValueKey<Map<Integer, CawEmvPaymentCardInfo>>     EMV_DATA                                  = new ValueKey(
            Map.class, "EMV_DATA");                                                                                                                            // BZ23558

    public static final ValueKey<Map<Integer, String>>                    VERIFICATION                              = new ValueKey(
            Map.class, "VERIFICATION");                                                                                                                        // BZ23558

    /*Begin BZ-23406*/
    public static final ValueKey<String>                                  SHOPPING_PASS_NUMBER                      = new ValueKey<String>(
            String.class, "SHOPPING_PASS_NUMBER");

    public static final ValueKey<String>                                  SHOPPING_PASS_EXP                         = new ValueKey<String>(
            String.class, "SHOPPING_PASS_EXP");
    /*End BZ-23406*/

    /*Begin BZ23725*/
    public static final ValueKey<Boolean>                                 IS_SHOPPING_PASS_CREDIT                   = new ValueKey<Boolean>(
            Boolean.class, "IS_SHOPPING_PASS_CREDIT");
    /*End BZ23725*/

    public static final ValueKey<Boolean>                                 IS_EXCEED_MAX_GC_BALANCE                  = new ValueKey<Boolean>(
            Boolean.class, "IS_EXCEED_MAX_GC_BALANCE");

    public static final ValueKey<Boolean>                                 IS_USER_CANCEL                            = new ValueKey<Boolean>(
            Boolean.class, "IS_USER_CANCEL");

    public static final ValueKey<Boolean>                                 IS_OPCHAIN_MCR                            = new ValueKey<Boolean>(
            Boolean.class, "IS_OPCHAIN_MCR");

    public static final ValueKey<CawDeclinedReferenceData>                DECLINED_DATA                             = new ValueKey<CawDeclinedReferenceData>(
            CawDeclinedReferenceData.class, "DECLINED_DATA");

    // BZ23688
    public static final ValueKey<String>                                  ACCOUNT_NUMBER                            = new ValueKey<String>(
            String.class, "SHOPPING_PASS_ACCOUNT_NUMBER");

    public static final ValueKey<String>                                  EXP_DATE                                  = new ValueKey<String>(
            String.class, "SHOPPING_PASS_EXP_DATE");

    public static final ValueKey<Boolean>                                 IS_NEW_GSV_TENDER                         = new ValueKey<Boolean>(
            Boolean.class, "IS_NEW_GSV_TENDER");

    // BZ23676
    public static final ValueKey<Boolean>                                 SAY_YES_GSV_TENDER                        = new ValueKey<Boolean>(
            Boolean.class, "SAY_YES_GSV_TENDER");

    // BZ23440
    public static final ValueKey<String>                                  REQUEST_TIMEOUT                           = new ValueKey<String>(
            String.class, "REQUEST_TIMEOUT");

    // BZ23955
    public static final ValueKey<String>                                  ACC_USER_NAME                             = new ValueKey<String>(
            String.class, "ACC_USER_NAME");

    public static final ValueKey<String>                                  CASHOUT_NOTIFY_MSG                        = new ValueKey<String>(
            String.class, "CASHOUT_NOTIFY_MSG");

    public static final ValueKey<Boolean>                                 IS_SHOPPING_PASS_TENDER                   = new ValueKey<Boolean>(
            Boolean.class, "IS_SHOPPING_PASS_TENDER");

    // BZ23993
    public static final ValueKey<Boolean>                                 IS_COUPON_APPLIED                         = new ValueKey<Boolean>(
            Boolean.class, "IS_COUPON_APPLIED");

    // BZ24124
    public static final ValueKey<Boolean>                                 IS_COUPON_AMOUNT_GREATER_EQUAL_AMOUNT_DUE = new ValueKey<Boolean>(
            Boolean.class, "IS_COUPON_AMOUNT_GREATER_EQUAL_AMOUNT_DUE");

    // BZ24173
    public static final ValueKey<Boolean>                                 IS_REQUIRED_CREDIT_CARD                   = new ValueKey<Boolean>(
            Boolean.class, "IS_REQUIRED_CREDIT_CARD");

    // Begin BZ24150
    public static final ValueKey<JSONObject>                              RESERVE_JSON_OBJECT                       = new ValueKey<JSONObject>(
            JSONObject.class, "RESERVE_OBJECT");

    public static final ValueKey<Map<String, List<JSONObject>>>           SERIAL_NUMBER_ACTIVE                      = new ValueKey(
            Map.class, "SERIAL_NUMBER_ACTIVE");

    // End BZ24150
    // Begin BZ23958
    public static final ValueKey<Integer>                                 IS_MEMBERSHIP_COUNT                       = new ValueKey<Integer>(
            Integer.class, "IS_MEMBERSHIP_COUNT");

    public static final ValueKey<Integer>                                 IS_MEMBERSHIP_ACTIVATED                   = new ValueKey<Integer>(
            Integer.class, "IS_MEMBERSHIP_ACTIVATED");

    public static final ValueKey<Boolean>                                 IS_MEMBERSHIP_RUN                         = new ValueKey<Boolean>(
            Boolean.class, "IS_MEMBERSHIP_RUN");

    public static final ValueKey<String>                                  RESPONSE_VALIDATE_MEMBERSHIP              = new ValueKey<String>(
            String.class, "RESPONSE_VALIDATE_MEMBERSHIP");

    public static final ValueKey<ArrayList<IRetailTransactionLineItem>>   LIST_VOID_LINEITMS                        = new ValueKey(
            ArrayList.class, "LIST_VOID_LINEITMS");

    // End BZ23958

    // Begin BZ24317
    public static final ValueKey<String>                                  RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG       = new ValueKey<String>(
            String.class, "RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG");
    // End BZ24317

    // Begin BZ24324
    public static final ValueKey<CawMembershipActivityModel>              MEMBERSHIP_ACTIVITY_MODEL                 = new ValueKey<CawMembershipActivityModel>(
            CawMembershipActivityModel.class, "MEMBERSHIP_ACTIVITY_MODEL");
    // End BZ24324

    // Begin BZ24326
    public static final ValueKey<Boolean>                                 IS_AUTO_RENEW                             = new ValueKey<Boolean>(
            Boolean.class, "IS_AUTO_RENEW");
    // End BZ24326

    // Begin BZ24356
    public static final ValueKey<Set<String>>                             MEMBERSHIP_ITEM_ID_FAILED                 = new ValueKey(
            Set.class, "MEMBERSHIP_ITEM_ID_FAILED");

    public static final ValueKey<Boolean>                                 IS_RETRY_VALIDATE                         = new ValueKey<Boolean>(
            Boolean.class, "IS_RETRY_VALIDATE");

    public static final ValueKey<Integer>                                 ACTIVE_CODE_ACTIVATED_FAILED              = new ValueKey<Integer>(
            Integer.class, "ACTIVE_CODE_ACTIVATED_FAILED");
    // End BZ24356

    // Begin BZ24385
    public static final ValueKey<Boolean>                                 IS_COMPLETED_VALIDATION                   = new ValueKey<Boolean>(
            Boolean.class, "IS_COMPLETED_VALIDATION");
    // End BZ24385

    // Begin BZ24354
    public static final ValueKey<CawMembershipActivityModel>              ITEM_NON_PHYSICAL_GROUP                   = new ValueKey<CawMembershipActivityModel>(
            CawMembershipActivityModel.class, "ITEM_NON_PHYSICAL_GROUP");

    public static final ValueKey<String>                                  VALIDATE_MEMBERSHIP_MSG                   = new ValueKey<String>(
            String.class, "VALIDATE_MEMBERSHIP_MSG");

    // End BZ24354
    //Begin BZ24404
    public static final ValueKey<String>                                  COMPANYNAME                               = new ValueKey<String>(
            String.class, "COMPANYNAME");
    //End BZ24404

    // Begin BZ 24414
    public static final ValueKey<Boolean>                                 FN_BACK_CUST_SEARCH                       = new ValueKey<Boolean>(
            Boolean.class, "FN_BACK_CUST_SEARCH");

    // End BZ 24414
    //Begin BZ24561
    public static final ValueKey<Boolean>                                 EBS_TIMEOUT                               = new ValueKey<Boolean>(
            Boolean.class, "EBS_TIMEOUT");

    //End BZ24561
    //Begin BZ24945
    public static final ValueKey<Boolean>                                 IS_RETURN_AR_ACCOUNT                      = new ValueKey(
            Boolean.class, "IS_RETURN_AR_ACCOUNT");
    //End BZ24945

    // BZ 24957
    public static final ValueKey<Boolean>                                 DISPL_JOIN_CLUB_PROMPT                    = new ValueKey(
            Boolean.class, "DISPL_JOIN_CLUB_PROMPT");

    //Begin BZ23405
    public static final ValueKey<AddressVerificationResponse>             ADDRESS_RESPONSE                          = new ValueKey(
            AddressVerificationResponse.class, "ADDRESS_RESPONSE");
    //End BZ23405

    // Begin BZ25068
    public static final ValueKey<Boolean>                                 IS_RETURN_WEB_ORDER                       = new ValueKey(
            Boolean.class, "IS_RETURN_WEB_ORDER");
    // End BZ25068

    // Begin BZ25207
    public static final ValueKey<Boolean>                                 IS_SALE_SCREEN                            = new ValueKey(
            Boolean.class, "IS_SALE_SCREEN");
    // End BZ25207

    //Begin BZ25916
    public static final ValueKey<Long>                                    EDIT_ACCOUNT_NUMBER                       = new ValueKey<Long>(
            Long.class, "EDIT_ACCOUNT_NUMBER");
    //End BZ25916

    // Begin BZ25115
    public static final ValueKey<Boolean>                                 IS_APPLY_CLUB_PRICE                       = new ValueKey(
            Boolean.class, "IS_APPLY_CLUB_PRICE");

    public static final ValueKey<List>                                    MEMBER_PRICE_OVERRIDE_VOID_LINES          = new ValueKey(
            List.class, "MEMBER_PRICE_OVERRIDE_VOID_LINES");

    // End BZ25115
    //Begin BZ25358
    public static final ValueKey<Boolean>                                 IS_ADDRESS_FOUND                          = new ValueKey(
            Boolean.class, "IS_ADDRESS_FOUND");

    public static final ValueKey<Boolean>                                 IS_MANY_RESULTS_FOUND                     = new ValueKey(
            Boolean.class, "IS_MANY_RESULTS_FOUND");

    public static final ValueKey<Boolean>                                 IS_SELECT_VIEW                            = new ValueKey(
            Boolean.class, "IS_SELECT_VIEW");

    public static final ValueKey<Boolean>                                 IS_BACK                                   = new ValueKey(
            Boolean.class, "IS_BACK");
    //End BZ25358

    // Begin BZ25434
    public static final ValueKey<Boolean>                                 MEMBERSHIP_IS_EMPTY                       = new ValueKey<Boolean>(
            Boolean.class, "MEMBERSHIP_IS_EMPTY");

    // End BZ25434
    //Begin BZ26313
    public static final ValueKey<Boolean>                                 IS_SEARCH_CUSTOMER                        = new ValueKey(
            Boolean.class, "IS_SEARCH_CUSTOMER");

    public static final ValueKey<Boolean>                                 IS_REMOVE_CUSTOMER                        = new ValueKey(
            Boolean.class, "IS_REMOVE_CUSTOMER");
    //End BZ26313

    // Begin BZ26575
    public static final ValueKey<IPartyLocaleInformation>                 CAW_CUSTOMER_ADDRESS_INFO                 = new ValueKey<IPartyLocaleInformation>(
            IPartyLocaleInformation.class, "CAW_CUSTOMER_ADDRESS_INFO");

    public static final ValueKey<List<CawAddressLineType>>                CAW_CUSTOMER_ADDRESS_LINES                = new ValueKey(
            List.class, "CAW_CUSTOMER_ADDRESS_LINES");

    public static final ValueKey<String>                                  IS_ADDRESS_DIALOG_DISPLAY                 = new ValueKey<String>(
            String.class, "IS_ADDRESS_DIALOG_DISPLAY");

    public static final ValueKey<Boolean>                                 IS_NOT_RUN_ADDRESS_VALIDATION_OP          = new ValueKey<Boolean>(
            Boolean.class, "IS_NOT_RUN_ADDRESS_VALIDATION_OP");

    public static final ValueKey<String>                                  IS_ADDRESS_MULTIPLE_DISPLAY               = new ValueKey<String>(
            String.class, "IS_ADDRESS_MULTIPLE_DISPLAY");

    public static final ValueKey<CawQASearchResult>                       CAW_QAS_SEARCH_RESULT                     = new ValueKey(
            CawQASearchResult.class, "CAW_QAS_SEARCH_RESULT");

    public static final ValueKey<Boolean>                                 IS_ADD_NEW_CUST_ASSOC                     = new ValueKey(
            Boolean.class, "IS_ADD_NEW_CUST_ASSOC");

    public static final ValueKey<IPartyLocaleInformation>                 CAW_CUSTOMER_ADDRESS_INFO_OFF             = new ValueKey(
            IPartyLocaleInformation.class, "CAW_CUSTOMER_ADDRESS_INFO_OFF");

    // End BZ26575
    //Begin BZ25958
    public static final ValueKey<Boolean>                                 IS_NOT_ACTIVE                             = new ValueKey<Boolean>(
            Boolean.class, "IS_NOT_ACTIVE");

    public static final ValueKey<Boolean>                                 IS_RELOAD                                 = new ValueKey<Boolean>(
            Boolean.class, "IS_RELOAD");

    public static final ValueKey<Boolean>                                 IS_ACTIVE                                 = new ValueKey<Boolean>(
            Boolean.class, "IS_ACTIVE");
    //End BZ25958 

    // Begin BZ25435
    public static final ValueKey<String>                                  SUBMIT_REQUEST_ID                         = new ValueKey<String>(
            String.class, "SUBMIT_REQUEST_ID");

    public static final ValueKey<String>                                  STATUS_PRESCREEN_ID                       = new ValueKey<String>(
            String.class, "STATUS_PRESCREEN_ID");
    // End BZ25435

    // Begin BZ26836
    public static final ValueKey<String>                                  ADDRESS_MESSAGES_DISPLAY                  = new ValueKey<String>(
            String.class, "ADDRESS_MESSAGES_DISPLAY");

    // End BZ26836
    // BZ26289 start
    public static final ValueKey<String>                                  HOUSE_ACCOUNT_NUMBER                      = new ValueKey<String>(
            String.class, "HOUSE_ACCOUNT_NUMBER");

    public static final ValueKey<Boolean>                                 HAS_WHLS_HOUSE_ACCOUNT                    = new ValueKey<Boolean>(
            Boolean.class, "HAS_WHLS_HOUSE_ACCOUNT");
    // BZ26289 end

    // BZ26207 Begin work order session
    public static final ValueKey<Boolean>                                 IS_WORK_ORDER_TRANS                       = new ValueKey(
            Boolean.class, "IS_WORK_ORDER_TRANS");

    public static final ValueKey<CawWorkOrderEBSQueryResult>              CAW_WORK_ORDER_SELECTED_ACCOUNT           = new ValueKey(
            CawWorkOrderEBSQueryResult.class, "CAW_WORK_ORDER_SELECTED_ACCOUNT");

    // Begin BZ27192
    public static final ValueKey<List<Map<IItem, CawWorkOrderItem>>>      PART_ITEM_LIST                            = new ValueKey(
            List.class, "PART_ITEM_LIST");

    public static final ValueKey<List<Map<IItem, CawWorkOrderItem>>>      TASK_ITEM_LIST                            = new ValueKey(
            List.class, "TASK_ITEM_LIST");
    // End BZ27192

    public static final ValueKey<String>                                  CAW_WORK_ORDER_NUMBER                     = new ValueKey(
            String.class, "CAW_WORK_ORDER_NUMBER");

    public static final ValueKey<List<ICustomerItemAccountDetail>>        CAW_WORK_ORDER_LINE_ITEMS                 = new ValueKey(
            List.class, "CAW_WORK_ORDER_LINE_ITEMS");

    public static final ValueKey<IWorkOrderAccount>                       CAW_WORK_ORDER_ACCOUNT                    = new ValueKey(
            IWorkOrderAccount.class, "CAW_WORK_ORDER_ACCOUNT");                                                                                                //BZ27024

    public static final ValueKey<IPosTransaction>                         CAW_LATEST_TRANSACTION                    = new ValueKey<IPosTransaction>(
            IPosTransaction.class, "CAW_LATEST_TRANSACTION");                                                                                                  //BZ27256
    // BZ26207 End work order session

    // Begin BZ25958
    public static final ValueKey<String>                                  CARD_ACTIVE_STATUS                        = new ValueKey<String>(
            String.class, "CARD_ACTIVE_STATUS");

    public static final ValueKey<String>                                  BALANCE_INQUIRY_COME_FROM                 = new ValueKey<String>(
            String.class, "BALANCE_INQUIRY_COME_FROM");

    public static final ValueKey<IAuthResponse>                           MIRASERV_AUTH_RESPONSE                    = new ValueKey<IAuthResponse>(
            IAuthResponse.class, "MIRASERV_AUTH_RESPONSE");

    // Begin BZ26978
    public static final ValueKey<List<CawVoucherBalanceReloadActiveInfo>> VOUCHER_BALANCE_RELOAD_ACTIVE_INFO        = new ValueKey(
            List.class, "VOUCHER_BALANCE_RELOAD_ACTIVE_INFO");
    // End BZ26978
    // End BZ25958

    /* BEGIN BZ27286, BZ31943 */
    public static final ValueKey<Map<String, BigDecimal>>                 WO_LIST_DISCOUNT                          = new ValueKey(
            Map.class, "WO_LIST_DISCOUNT");
    /* END BZ27286, BZ31943 */

    // Begin BZ27248
    public static final ValueKey<Map>                                     ITM_WARRANTY_ITEM_LIST                    = new ValueKey(
            Map.class, "ITM_WARRANTY_ITEM_LIST");

    public static final ValueKey<List<String>>                            CAW_WO_LINE_ITEM_WRRANTY                  = new ValueKey(
            List.class, "CAW_WO_LINE_ITEM_WRRANTY");

    // End BZ27248
    // BZ27339 start
    public static final ValueKey<String>                                  CAW_CUSTOMER_AVATAR_ICON_KEY              = new ValueKey(
            String.class, "CAW_CUSTOMER_AVATAR_ICON_KEY");
    // BZ27339 end

    //Begin BZ27712: value key for work order item attributes
    public static final ValueKey<String>                                  CAW_WO_ITEM_ATTRIBUTES                    = new ValueKey(
            String.class, "CAW_WO_ITEM_ATTRIBUTES");
    //End BZ27712

    // Begin BZ27813
    public static final ValueKey<BigDecimal>                              TP_ACCOUNT_BALANCE                        = new ValueKey<BigDecimal>(
            BigDecimal.class, "TP_ACCOUNT_BALANCE");

    // End BZ27813
    //Begin BZ27924
    public static final ValueKey<List<ISaleReturnLineItem>>               LIST_ITEM_RETURN_WEB_ORDER                = new ValueKey(
            ArrayList.class, "LIST_ITEM_RETURN_WEB_ORDER");
    //End BZ27924
    /* Begin BZ28265 */
    public static final ValueKey<String>                                  OLPS_PRESCREEN_ID                         = new ValueKey<String>(
            String.class, "OLPS_PRESCREEN_ID");
    /* End BZ28265 */

    /* Begin BZ28567 */
    public static final ValueKey<String>                                  CAW_CATALYST_TYPE                         = new ValueKey(
            String.class, "CAW_CATALYST_TYPE");
    /* End BZ28567 */

    /* BEGIN BZ28247 */
    public static final ValueKey<CawSubmitStatusResponse>                 CAW_SUBMIT_STATUS_RESPONSE                = new ValueKey(
            CawSubmitStatusResponse.class, "CAW_SUBMIT_STATUS_RESPONSE");
    /* END BZ28247*/

    /*BEGIN BZ29205*/
    public static final ValueKey<JSONObject>                              CAW_WO_ITEM_PROPERTIES                    = new ValueKey(
            JSONObject.class, "CAW_WO_ITEM_PROPERTIES");
    /*END BZ29205*/

    /* BEGIN BZ29134 */
    public static final ValueKey<Integer>                                 CAW_THREE_FAILED_ATTEMPTS_SSN             = new ValueKey<Integer>(
            Integer.class, "CAW_THREE_FAILED_ATTEMPTS_SSN");
    /* END BZ29134 */
    /* BEGIN BZ29387 */
    public static final ValueKey<Boolean>                                 IS_ACCOUNT_PAYMENT                        = new ValueKey<Boolean>(
            Boolean.class, "IS_ACCOUNT_PAYMENT");
    /* END BZ29387 */
    /* BEGIN BZ28033 */
    public static final ValueKey<Boolean>                                 IS_RESENT_CATALYST_4                      = new ValueKey<Boolean>(
            Boolean.class, "IS_RESENT_CATALYST_4");
    /* END BZ28033 */
    /* BEGIN BZ29407 */
    public static final ValueKey<Boolean>                                 IS_COMPLETED_MADE_OFFER                   = new ValueKey<Boolean>(
            Boolean.class, "IS_COMPLETED_MADE_OFFER");
    /* END BZ29407 */
    /*BEGIN BZ29743*/
    public static final ValueKey<Boolean>                                 IS_PRE_TENDERING_OP                       = new ValueKey<Boolean>(
            Boolean.class, "IS_PRE_TENDERING_OP");
    /*END BZ29743*/
    /* BEGIN BZ29884 */
    public static final ValueKey<List<CawWorkOrderItem>>                  WO_WARRANTY_ITEMS                         = new ValueKey(
            ArrayList.class, "WO_WARRANTY_ITEMS");
    /* END BZ29884 */

    /* BEGIN BZ29625 */
    public static final ValueKey<Map>                                     CAW_MAP_ITM_MSG                           = new ValueKey<Map>(
            Map.class, "CAW_MAP_ITM_MSG");
    /* END BZ29625 */
    
   /* BEGIN BZ32517 */
   public static final ValueKey<String> CAW_SKU_TYPE = new ValueKey<String>(String.class, "CAW_SKU_TYPE");
   /* END BZ32517 */

    /* BEGIN BZ30259 */
    public static final ValueKey<String>                                  CAW_CUSTOMER_MESSAGE                      = new ValueKey<String>(
            String.class, "CAW_CUSTOMER_MESSAGE");
    /* END BZ30259 */

    /*BEGIN BZ28036*/
    public static final ValueKey<Boolean>                                 IS_SELECT_SALE_TRANSACTION                = new ValueKey(
            Boolean.class, "IS_SELECT_SALE_TRANSACTION");

    public static final ValueKey<Boolean>                                 IS_SELECT_RETURN_TRANSACTION              = new ValueKey(
            Boolean.class, "IS_SELECT_RETURN_TRANSACTION");

    public static final ValueKey<CustomerTransHistoryResult>              ITEM_SELECTED                             = new ValueKey(
            CustomerTransHistoryResult.class, "ITEM_SELECTED");

    public static final ValueKey<String>                                  ACCOUNT_API                               = new ValueKey(
            String.class, "ACCOUNT_API");

    public static final ValueKey<Boolean>                                 IS_RETURN_CONTINUTE                       = new ValueKey(
            Boolean.class, "IS_RETURN_CONTINUTE");
    /*END BZ28036*/

    /*BEGIN BZ35513*/
    public static final ValueKey<Boolean>                                 NO_PRINT_RECEIPTS                         = new ValueKey<Boolean>(
            Boolean.class, "NO_PRINT_RECEIPTS");
    /*END BZ35513*/
    /*BEGIN BZ36405*/
    public static final ValueKey<Boolean>                                 IS_AR_CREDIT_HOLD                         = new ValueKey<Boolean>(
            Boolean.class, "IS_AR_CREDIT_HOLD");
    /*END BZ36405*/
    
    /* BEGIN BZ37109 */
    public static final ValueKey<Boolean>                                 IS_DELIVERY_INFO                          = new ValueKey<Boolean>(
            Boolean.class, "IS_DELIVERY_INFO");
    
    public static final ValueKey<IPartyLocaleInformation>                 CAW_DELIVERY_ADDRESS_INFO_OFF             = new ValueKey(
            IPartyLocaleInformation.class, "CAW_DELIVERY_ADDRESS_INFO_OFF");
   
    /* END BZ37109 */
    /*BEGIN BZ37382*/
    public static final ValueKey<String>                                 IS_ORDER_TRANSACTION                          = new ValueKey<String>(
            String.class, "IS_ORDER_TRANSACTION");
    /*END BZ37382*/
    
    /* BEGIN BZ37750 */
    public static ValueKey<Boolean>                                     IS_ORDER_BORKER_OFFLINE                      = new ValueKey<Boolean>(
            Boolean.class,"IS_ORDER_BORKER_OFFLINE");
    /* END BZ37750 */
    
    /* BEGIN BZ37753 */
    public static final ValueKey<IPartyLocaleInformation>                 CAW_MULTI_ADDRESS_FORM_OFF             = new ValueKey(
            IPartyLocaleInformation.class, "CAW_MULTI_ADDRESS_FORM_OFF");
      
    public static final ValueKey<String>                                 MULTI_ADDRESS_FORM_ADD_OR_EDIT                          = new ValueKey<String>(
              String.class, "MULTI_ADDRESS_FORM_ADD_OR_EDIT");
    /* END BZ37753 */  
    /* BEGIN BZ37912 */
    public static final ValueKey<List<CawShippingGroupsModel>>            CAW_SHIPPING_GROUP_MODEL                  = new ValueKey(
            ArrayList.class, "CAW_SHIPPING_GROUP_MODEL");

    public static final ValueKey<List<IShipperMethod>>                    CAW_SHIPPER_METHODS                       = new ValueKey(
            ArrayList.class, "CAW_SHIPPER_METHODS");

    public static final ValueKey<Integer>                                 CAW_GROUP_ID                              = new ValueKey<Integer>(
            Integer.class, "CAW_GROUP_ID");
    
    public static final ValueKey<HashMap>                                 TEMP_SHIPPING_FEE                       = new ValueKey(
            Map.class, "TEMP_SHIPPING_FEE");
    /* END BZ37912 */ 

    /* BEGIN BZ37396 */
    public static final ValueKey<JSONObject>                              CAW_TAX_RESPONSE                          = new ValueKey<>(JSONObject.class, "CAW_TAX_RESPONSE");
    /* END BZ37396 */
    
    /* BEGIN BZ38349 */
    public static final ValueKey<DeliveryInfoModel>                      CAW_DELIVERY_INFO_MODEL_BEFORE            = new ValueKey<>(DeliveryInfoModel.class, "CAW_DELIVERY_INFO_MODEL_BEFORE");
    /* END BZ38349 */
    
    /* BEGIN BZ40798 */
    public static final ValueKey<BigDecimal>                              GOOD_SAM_SAVINGS                           = new ValueKey<BigDecimal>(
            BigDecimal.class, "GOOD_SAM_SAVING");

    public static final ValueKey<BigDecimal>                              COULD_SAVE                                = new ValueKey<BigDecimal>(
            BigDecimal.class, "COULD_SAVE");
    /* END BZ40798 */
    /*BEGIN BZ41674*/
    public static final ValueKey<String>                                  RETURN_OG_FIELD                           = new ValueKey<String>(
            String.class, "RETURN_OG_FIELD");

    public static final ValueKey<String>                                  RETURN_VN_FIELD                           = new ValueKey<String>(
            String.class, "RETURN_VN_FIELD");
    /*END BZ41674*/
    
    public static final ValueKey<Boolean>                                 IS_DIRECTIVE_TEN                          = new ValueKey<Boolean>(
            Boolean.class, "IS_DIRECTIVE_TEN");/*BZ45156*/
    
    /* BEGIN BZ44528: Phase 1 */
    public static final ValueKey<List<CawWonderSignCartItem>>             WS_SELECTED_ITEM_LIST                     = new ValueKey(
            List.class, "WS_SELECTED_ITEM_LIST");
    
    public static final ValueKey<String>                                  CAW_CART_SEARCH_RESPONSE                  = new ValueKey<String>(
            String.class, "CAW_CART_SEARCH_RESPONSE");
    
    public static final ValueKey<List<CawWonderSignCart>>                 WS_SELECTED_CART                         = new ValueKey(
            List.class, "WS_SELECTED_CART");
    
    public static final ValueKey<List<CawWonderSignCartItem>>             WS_VALID_CART_ITEM                       = new ValueKey(
            List.class, "WS_VALID_CART_ITEM");
    
    public static final ValueKey<String>                                  WONDERSIGN_CART_ID                        = new ValueKey<String>(
            String.class, "WONDERSIGN_CART_ID");
    /* END BZ44528: Phase 1 */
    /*BEGIN BZ44917*/
    public static final ValueKey<List<CawRvPaymentModel>>                 CAW_RV_PAYMENT_ITEM_LIST                  = new ValueKey(
            ArrayList.class, "CAW_RV_PAYMENT_ITEM_LIST");

    public static final ValueKey<CawRvPaymentModel>                       CAW_RV_PAYMENT_ITEM_SELECTED              = new ValueKey(
            CawRvPaymentModel.class, "CAW_RV_PAYMENT_ITEM_SELECTED");

    public static final ValueKey<CawRvPaymentModel>                       CAW_RV_PAYMENT_SEARCH_MODEL               = new ValueKey(
            CawRvPaymentModel.class, "CAW_RV_PAYMENT_SEARCH_MODEL");

    public static final ValueKey<String>                                  CAW_RV_PROPERTIES                         = new ValueKey<String>(
            String.class, "CAW_RV_PROPERTIES");
    /*END BZ44917*/
    public static final ValueKey<Boolean>                 IS_ADD_ANOTHER_RV_PAYMENT                  = new ValueKey(
            Boolean.class, "IS_ADD_ANOTHER_RV_PAYMENT");/*BZ46257*/
    
    /*BEGIN BZ42307*/
    public static final ValueKey<List<IOrderLine>>                        ORDER_LINE_DETAILS_TO_PROCESS             = new ValueKey(
            List.class, "ORDER_LINE_DETAILS_TO_PROCESS");

    public static final ValueKey<IOrderLine>                              CURRENT_ORDER_LINE_DETAIL                 = new ValueKey(
            IOrderLine.class, "CURRENT_ORDER_LINE_DETAIL");

    public static final ValueKey<List<BigDecimal>>                        ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY     = new ValueKey(
            List.class, "ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY");

    public static final ValueKey<Boolean>                                 IS_REJECT_ORDER                           = new ValueKey(
            Boolean.class, "IS_REJECT_ORDER");

    public static final ValueKey<List<IOrderLine>>                        ORDER_REJECTED_LINES                      = new ValueKey(
            List.class, "ORDER_REJECTED_LINES");
    
    public static final ValueKey<List<BigDecimal>>                        CAW_ORDER_QUANTITIES                      = new ValueKey(
            List.class, "CAW_ORDER_QUANTITIES");/*BZ46682*/
    /*END BZ42307*/
    
    /* BEGIN BZ45995 */
    public static final ValueKey<Boolean>                                 IS_MEMBERSHIP_EMAIL_CAPTURED              = new ValueKey(
            Boolean.class, "IS_MEMBERSHIP_EMAIL_CAPTURED");
    /* END BZ45995 */
    
    /* BEGIN BZ42019 */
    public static final ValueKey<CawCustomerMaintenanceModel>             CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE   = new ValueKey(
            CawCustomerMaintenanceModel.class,"CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE");
    
    public static final ValueKey<CawMailingAddressRequest>                CAW_LATEST_VALIDATE_MAILING_REQUEST       = new ValueKey(
            CawMailingAddressRequest.class, "CAW_LATEST_VALIDATE_MAILING_REQUEST");

    public static final ValueKey<String>                                  CAW_LATEST_VALIDATE_EMAIL                 = new ValueKey<String>(
            String.class, "CAW_LATEST_VALIDATE_EMAIL");

    public static final ValueKey<ResponseEntity<String>>                  CAW_MAILING_VALIDATION_LATEST_RESPONSE    = new ValueKey(
            ResponseEntity.class, "CAW_MAILING_VALIDATION_LATEST_RESPONSE");

    public static final ValueKey<ResponseEntity<String>>                  CAW_EMAIL_VALIDATION_LATEST_RESPONSE      = new ValueKey(
            ResponseEntity.class, "CAW_EMAIL_VALIDATION_LATEST_RESPONSE");
    
    public static final ValueKey<Boolean>                                 CAW_MAILING_ADDRESS_VALIDATION_RUN        = new ValueKey(
            Boolean.class, "CAW_MAILING_ADDRESS_VALIDATION_RUN");
    
    public static final ValueKey<Boolean>                                 CAW_EMAIL_ADDRESS_VALIDATION_RUN          = new ValueKey(
            Boolean.class, "CAW_EMAIL_ADDRESS_VALIDATION_RUN");

    public static final ValueKey<Boolean>                                 CAW_ADDRESS_REVALIDATION_NEEDED           = new ValueKey(
            Boolean.class, "CAW_ADDRESS_REVALIDATION_NEEDED");
    
    public static final ValueKey<String>                                  CAW_CUSTOMER_SAVED_EMAIL                  = new ValueKey<String>(
            String.class, "CAW_CUSTOMER_SAVED_EMAIL");
    /* END BZ42019 */
    
    /* BEGIN BZ47803 */
    public static final ValueKey<Boolean>                                 CAW_IS_NEW_CUST_ADDR_INIT_VALIDATION      = new ValueKey(
            Boolean.class, "CAW_IS_NEW_CUST_ADDR_INIT_VALIDATION");
    /* END BZ47803 */
    
    public static final ValueKey<String>                                  CAW_RV_PAYMENT_BARCODE                    = new ValueKey<String>(
            String.class, "CAW_RV_PAYMENT_BARCODE");/*BZ46381*/
    
    /* BEGIN BZ42307 - Partial Cancel */
    public static final ValueKey<Boolean>                                 IS_PARTIAL_CANCEL_ORDER                   = new ValueKey(Boolean.class, "IS_PARTIAL_CANCEL_ORDER");
    /* END BZ42307 - Partial Cancel */
    
    /* BEGIN BZ46743 */
    public static final ValueKey<IHasDataProperty<?>>                     VIN_LINE_ITEM                             = new ValueKey(
            IHasDataProperty.class, "VIN_LINE_ITEM");
    public static final ValueKey<Boolean>                                 IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN  = new ValueKey(
            Boolean.class, "IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN");
    public static final ValueKey<Boolean>                                 IS_VIN_LINE_VIN_SET              = new ValueKey(
            Boolean.class, "IS_VIN_LINE_VIN_SET");
    /* END BZ46743 */
    
    /*BEGIN BZ47123*/
    public static final ValueKey<Boolean> CAW_CASH_DRAWER_CLOSE_FLAG = new ValueKey<Boolean>(Boolean.class, "CAW_CASH_DRAWER_CLOSE_FLAG");
    
    public static final ValueKey<Boolean> IS_DISPLAY_CUSTOMER_VERIFICATION_OP = new ValueKey<Boolean>(Boolean.class, "CAW_CASH_DRAWER_CLOSE_FLAG");
    
    public static final ValueKey<CawMiraResponse> CAW_VERIFY_CUSTOMER_MIRA_RESPONSE = new ValueKey<CawMiraResponse>(CawMiraResponse.class, "CAW_VERIFY_CUSTOMER_MIRA_RESPONSE");
    /*END BZ47123*/
    public static final ValueKey<HashMap> CAW_REWARD_LOYALTY_POINTS = new ValueKey<HashMap>(HashMap.class, "CAW_REWARD_LOYALTY_POINTS");/*BZ48629*/

    /*BEGIN BZ48401*/
    public static final ValueKey<List<CawPromotionModel>> CAW_PROMOTIONS_SELECTED = new ValueKey(ArrayList.class, "CAW_PROMOTIONS_SELECTED");

    public static final ValueKey<Boolean>  IS_APPLY_PROMOS_REWARD = new ValueKey(Boolean.class, "IS_APPLY_PROMOS_REWARD");
    
    /*END BZ48401*/
    
    //BEGIN BZ53752
    public static final ValueKey<String>                                  WONDERSIGN_CART_ID_SUBMIT_ORDER                        = new ValueKey<String>(
            String.class, "WONDERSIGN_CART_ID_SUBMIT_ORDER");
    
    public static final ValueKey<String>                                  CAW_RV_PROPERTIES_SUBMIT_ORDER                         = new ValueKey<String>(
            String.class, "CAW_RV_PROPERTIES_SUBMIT_ORDER");
    //END BZ53752
    
    public static final ValueKey<Boolean>                                 CAW_IS_BACK_OFFICE_STATE                               = new ValueKey<Boolean>(
            Boolean.class, "CAW_IS_BACK_OFFICE"); //BZ54208

    public static final ValueKey<Boolean>                                 IS_LOYALTY_CUSTOMER                               = new ValueKey<Boolean>(
            Boolean.class, "IS_LOYALTY_CUSTOMER"); //BZ54290

    public static final ValueKey<Boolean>                                 CAW_IS_NEWAL_GS_MEMBERSHIP_SKU                       = new ValueKey(Boolean.class, "CAW_IS_NEWAL_GS_MEMBERSHIP_SKU");//BZ58779

    public static final ValueKey<Boolean>                                 CAW_DISABLE_TOKEN_IS_USED                            = new ValueKey(Boolean.class, "CAW_DISABLE_TOKEN_IS_USED");//BZ58779
    
    //BEGIN BZ59418
    public static final ValueKey<Boolean>                                 CAW_SHOULD_ADD_ITEM_AFTER_INPUT_PHONE_NUMBER         = new ValueKey<Boolean>(Boolean.class, "CAW_ADD_ITEM_AFTER_INPUT_PHONE_NUMBER");
    public static final ValueKey<String>                                  CAW_LOYALTY_FREE_TIER_SKU                            = new ValueKey<String>(String.class, "CAW_LOYALTY_FREE_TIER_SKU");
    public static final ValueKey<List<ICodeValue>>                        CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE                  = new ValueKey(List.class, "CATALYST_ITEM_SELECTED");
    public static final ValueKey<Boolean>                                 CAW_IS_ORIGINAL_LOYALTY_CUSTOMER                     = new ValueKey<Boolean>(Boolean.class, "CAW_IS_ORIGINAL_LOYALTY_CUSTOMER");
    public static final ValueKey<Boolean>                                 CAW_SHOULD_SEND_VALIDATE_MEMBERSHIP_AFTER_ADD_ITEM         = new ValueKey<Boolean>(Boolean.class, "CAW_SHOULD_SEND_VALIDATE_MEMBERSHIP_AFTER_ADD_ITEM");//BZ59669
    //END BZ59418
    
    public static final ValueKey<Map<PosTransactionId, PosTransactionId>>    CAW_WO_DEPOSIT_TRANSACTION_MAPPING                = new ValueKey(
            Map.class, "CAW_WO_DEPOSIT_TRANSACTION_MAPPING");//BZ63225
    
    //BEGIN BZ61159
    public static final ValueKey<Integer>                                 CAW_AGIS_PICHES_LENGTH                                  = new ValueKey(
            Integer.class, "CAW_AGIS_PICHES_LENGTH");

    public static final ValueKey<CawAGISPitchesModel>                     CAW_AGIS_PICHES_MODEL                                   = new ValueKey(
            CawAGISPitchesModel.class, "CAW_AGIS_PICHES_MODEL");

    public static final ValueKey<Integer>                                 CAW_AGIS_PICHES_COUNT                                   = new ValueKey(
            Integer.class, "CAW_AGIS_PICHES_COUNT");

    public static final ValueKey<String>                                  CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER                    = new ValueKey(
            String.class, "CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER");
    //BEGIN BZ62146
    public static final ValueKey<String>                                  CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER                 = new ValueKey(
            String.class, "CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER");
    
    public static final ValueKey<String>                                  CAW_AGIS_PRICING_ID                                     = new ValueKey(
    		String.class, "CAW_AGIS_PRICING_ID");
    
    public static final ValueKey<String>                                  CAW_AGIS_PITCHES_JSON                                   = new ValueKey(
            String.class, "CAW_AGIS_PITCHES_JSON");
    //BEGIN BZ69391,BZ69389,BZ69389
    public static final ValueKey<List<CawAGISPitchesItemModel>>           CAW_AGIS_LIST_ACCEPTED                                   = new ValueKey(
            ArrayList.class, "CAW_AGIS_LIST_ACCEPTED");
    
    public static final ValueKey<List<CawAGISPitchesItemModel>>           CAW_AGIS_LIST_NOT_ON_FILE                                   = new ValueKey(
            ArrayList.class, "CAW_AGIS_LIST_NOT_ON_FILE"); //BZ69644
    //END BZ61159, BZ62146,BZ69391,BZ69389,BZ69389
}
