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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction  
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 * BZ49450          220422    [Internal] - Cannot apply for the loyalty promotions in case customer belonging to GSAM Club but whose account expired
 * BZ48692          240422    [Task] Process New Service is offline/time out when processing customer Search.
 * BZ49445          250422    [Internal] - Update format/text on the POINTS REDEMPTION prompt
 * BZ49706          280422    [Internal] - The 'Points Redemption' prompt is displaying without value when reward is null.
 * BZ49750          090522    [Internal] Missing the message 'You could have saved $XX.XX' on the Sale receipt for non-Good Sam Club customer
 * BZ49929          120522    Loyalty - Need a configuration to determine which type of membership will be displayed the loyalty info on receipts
 * BZ49894          130522    Loyalty Member Get PromoRewards/Reward API - Request changes
 * BZ50112          240522    [Internal] Loyalty Member Order Submit API - Need to add memberId to the request body
 * BZ50032          250522    [Task] Loyalty - Using Oauth2 security to access the new service
 * BZ50121          260522    [Internal] - Description line of promos applied is showing incorrectly after applying reward to Sale transaction.
 * BZ50159          260522    [Internal] Loyalty - Xstore should build the API request with user/pass if the Token URL is null
 * BZ50442          130622    Redemption data missing in request
 * BZ51699          120822    [UAT] Loyalty Information is not printed on the receipt for GSAM Club member.
 * BZ51922          260822    [UAT] Padding issue with the correlation key
 * BZ52041          010922    Loyalty not printing on Receipts for Customers with Active Offers
 * BZ52874          181022    [UAT] Points Redeemed Today does not show redeemed amount in a receipt
 * BZ51770          181022    [Task[ Xstore needs to handle these additional updated submit order response from API
 * BZ52838          211022    [UAT] Getting loyalty offline prompt for new customers
 * BZ52837          171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 * BZ53287          041122    [Internal] EBS log appear error after pressing Add Tender during creating a new customer and joining GSAM membership.
 * BZ51771          161122    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service. 
 * BZ53547          161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 * BZ53876          291122    [Internal] Mismatch information between Submit Order API request and Order Service request.
 * BZ54776          120123    Bug 54776 : [Patch 22.0] Extend ability to turn ON/OFF loyalty functionality into xstore to specific stores if needed.
 * BZ55978          290323    Loyalty Issue: Java Null Pointer
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization
 * BZ59669          301023    [FreeTier short term] Update the membership resend [Catalyst=] call to a membership valdiation call
 * BZ63054          080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.pos.cheetah.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawAdvancePromptingHelper;
import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.promotion.CawPromotionModel;
import caw.pos.cheetah.reward.CawRewardModel;
import caw.pos.common.*;
import caw.pos.common.rcpt.CawTotalAmountCouldSavedWorker;
import caw.pos.common.rcpt.CawTotalAmountSavedWorker;
import caw.pos.pricing.discount.CawDiscountCouponHelper;
import caw.pos.util.CawEBSHelper;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.TransactionHelper;
import dtv.pos.iframework.security.StationState;
import dtv.pos.warranty.WarrantyManager;
import dtv.util.DateUtils;
import dtv.util.StringUtils;
import dtv.util.crypto.DtvDecrypter;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyProperty;
import dtv.xst.dao.cwo.impl.WorkOrderAccountModel;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.itm.IWarranty;
import dtv.xst.dao.tnd.ITenderProperty;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.*;
import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.impl.*;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawCheetahHelper {

    private static final Logger              _logger                   = LogManager.getLogger(CawCheetahHelper.class);

    private static volatile CawCheetahHelper instance                  = null;

    private CawRestConfigHelper              _restConfigHelper         = CawRestConfigHelper.getInstance();

    private CawEBSHelper                     _cawEBSHelper           = CawEBSHelper.getInstance();

    private static final String              URL_RETRIEVE_PROMOREWARDS = System.getProperty("caw.pos.cheetah.promorewards.api.url");

    private static final String              URL_RETRIEVE_REWARD       = System.getProperty("caw.pos.cheetah.reward.api.url");

    private static final String              URL_EARNINGS              = System.getProperty("caw.pos.cheetah.earnings.api.url");//BZ48629
    
    private static final String              PARAM_MEMBERID            = "{memberId}";

    private static final String              PARAM_CORRELATIONKEY      = "{correlationKey}";
    
    private static final int                 RESPONSE_SUCCESS_CODE     = 200;//BZ48692
    
    private static final String              ARRAY_REQUEST_ITEMS_ATTR  = "!{ARRAY_REQUEST_ITEMS_ATTR}";
    
    //Begin BZ49894
    private static final String                       ORDER_DATE_ATTR                            = "!{orderDate}";

    private static final String                       NULL_STRING                                = "null";

    /**
     * The SALES_CHANNEL
     */
    private static final String                       SALES_CHANNEL                              = "!{SALESCHANNEL}";

    private static final String                       SALES_CHANNEL_ATTR                              = "SALES_CHANNEL_ATTR";

    /**
     * The CAW_CASHIER
     */
    private static final String                       CAW_CASHIER                                = "!{CASHIER}";
    
    private static final String                       CAW_ORDER_TYPE           = "!{orderType}";
    
    private static final String                       CAW_ORDER_TYPE_DESCRIPTION           = "!{orderTypeDescription}";

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

    private static final String                       CAW_CHANNEL_TYPE_DESCRIPTION                            = "!{channelTypeDescription}";

    private static final String                       CAW_PHYSICAL_INFO                           = "!{physicalInfo}";

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

    private static final String                       ORDER_TOTAL_WITH_TAX_ATTR                  = "!{orderTotalWithTax}";

    private static final String                       CAW_THIRD_PARTY_PAYER        = "!{THIRDPARTYPAYER}";
    
    private static final String                       CAW_SHIP_TO_INFO        = "!{SHIPTOINFO}";
    
    private static final String                       CAW_TENDERS        = "!{TENDERS}";
    
    private static final String                       CAW_RECEIPT_TYPE        = "!{receiptType}";
    
    private static final String                       CAW_CUSTOMER        = "!{CUSTOMER}";
    
    private static final String                       CAW_RECEIPT_TYPE_DESCRIPTION        = "!{receiptTypeDescription}";
    
    private static final String                       CAW_E_RECEIPT_EMAIL        = "!{eReceiptEmail}";

    private static final String                       CAW_CONTACT_PHONEL        = "!{contactPhone}";
    
    private static final String                       CAW_PAID_IN_OUT_DETAIL        = "!{PAIDINOUTDETAIL}";
    
    private static final String                       CAW_PURCHASE_ORDER        = "!{purchaseOrder}";
    
    private static final String                       CAW_WORK_ORDER_DETAIL        = "!{WORKORDERDETAIL}";
    
    private static final String                       CAW_WORK_ORDER_DETAIL_ATTR        = "CAW_WORK_ORDER_DETAIL_ATTR";

    private static final String                       CAW_TYPE        = "!{type}";

    private static final String                       CAW_STATUS        = "!{status}";
    
    private static final String                       CAW_POS_STATUS        = "!{posStatus}";
    
    private static final String                       CAW_POS_STATUS_DESCRIPTION        = "!{posStatusDescription}";
    
    private static final String                       CAW_HAS_DEPOSIT        = "!{hasDeposit}";
    
    private static final String                       CAW_DEPOSIT_AMOUNT        = "!{depositAmount}";
    
    private static final String                       CAW_TOTAL_TAX        = "!{totalTax}";
    
    private static final String                       CAW_SHIPPING        = "!{shipping}";
    
    private static final String                       CAW_DESCRIPTION        = "!{description}";
    
    private static final String                       CAW_CORRELATION_KEY        = "!{correlationKey}";
    
    private static final String                       CAW_PROPERTIES        = "!{properties}";
    
    private static final String                       CAW_ATTRIBUTES        = "!{attributes}";
    
    private static final String                       CAW_ATTRIBUTES_ATTR        = "CAW_ATTRIBUTES_ATTR";
    
    private static final String                       CAW_GOODSAM_SAVINGS        = "!{goodSamSavings}";
    
    private static final String                       CAW_COULD_SAVE        = "!{couldSave}";

    private static final String                       CAW_OE_ORDER_CATEGORY        = "!{oeOrderCategory}";

    private static final String                       CAW_OE_BATCH_NAME        = "!{oeBatchName}";

    private static final String                       CAW_OE_ORDER_SOURCE        = "!{oeOrderSource}";

    private static final String                       CAW_OE_ORDER_TYPE        = "!{oeOrderType}";

    private static final String                       CAW_OE_HOLD_NAME        = "!{oeHoldName}";

    private static final String                       CAW_OE_CWI_PC_NUMBER        = "!{oeCwiPcNumber}";

    private static final String                       CAW_OE_PREPAY_MATCH_KEY        = "!{oePrepayMatchKey}";

    private static final String                       CAW_OE_PICKUP_WARE_HOUSE        = "!{oePickupWarehouse}";

    private static final String                       CAW_OE_RAKUTEN_ID        = "!{oeRakutenId}";

    private static final String                       CAW_OE_RAKUTEN_DATE        = "!{oeRakutenDate}";

    private static final String                       CAW_OE_AFFILIATE_ID        = "!{oeAffiliateId}";

    private static final String                       CAW_OE_WEB_ORDER_ID        = "!{oeWebOrderId}";

    private static final String                       CAW_OE_DELIVERY_BY_DATE_UTC        = "!{oeDeliveryByDateUtc}";
    //End BZ49894
    
    private static final String              URL_RETRIEVE_PROMOREWARDS_TOKEN = System.getProperty("caw.pos.cheetah.promorewards.api.url.token");

    private static final String              URL_RETRIEVE_REWARD_TOKEN       = System.getProperty("caw.pos.cheetah.reward.api.url.token");

    private static final String              URL_EARNINGS_TOKEN              = System.getProperty("caw.pos.cheetah.earnings.api.url.token");
    //Start BZ50442
    private static final String SQUARE_BRACKETS_OPEN                        = "[";

    private static final String SQUARE_BRACKETS_CLOSE                       = "]";
    
    private static final String OFFER_RESPONSE_CODE                         = "!{offerResponseCode}";
    
    private static final String OFFER_CODE                                  = "!{offerCode}";
    
    private static final String EBS_COUPON_CODE                             = "!{ebsCouponCode}";
    private static final String REWARD_POINTS_ALLOCATIONS                   = "!{REWARD_POINTS_ALLOCATIONS}";
    private static final String PROMO_OFFER_REDEMPTIONS                     = "!{PROMO_OFFER_REDEMPTIONS}";
    private static final String REWARD_REDEMPTION                           = "!{REWARD_REDEMPTION}";
    private static final String REWARD_CODE                                 = "!{rewardCode}";
    private static final String ITEM_CORRELATION_KEY                        = "!{itemCorrelationKey}";
    private static final String POINT_REDEEMED_ONLINE_ITEM                  = "!{pointRedeemedOnLineItem}";
    //End BZ50442
    
    //BEGIN BZ51770
    private static final String EMPTY_ARRAY                                 = "[]"; 
    private static final String REWARD_REDEMPTION_WITH_RESPONSE_CODE        = "!{REWARD_REDEMPTION_WITH_RESPONSE_CODE}";
    private static final String REWARD_REDEMPTION_WITH_RESPONSE_CODE_ATTR   = "!{rewardResponseCode}";
    //END BZ51770
    
    //BEGIN BZ53287
    private static final String PRICING         = "pricing";
    private static final String MEMBERSHIP      = "membership";
    private static final String BENEFIT_LEVEL   = "benefitLevel";
    private static final String STATUS          = "status";
    //END BZ53287
    
    //BEGIN BZ51771
    private static final String OFFER_LABEL                                  = "!{offerLabel}";
    private static final String OFFER_EXPIRATION                             = "!{offerExpiration}";
    private static final String PROMO_OFFER_CLAIM_ADJUSTMENTS                = "!{promoOfferClaimAdjustments}";
    //END BZ51771
    
    /* BEGIN BZ53752 */
    private static final String ID                              = "id";
    private static final String POS_STATUS                      = "posStatus";
    private static final String WORK_ORDER_DETAIL_ATTR          = "!{workOrderDetail}";
    private static final char   ZERO_CHAR                       = '0';
    private static final String ID_ORDER_ATTR                   = "!{idOrder}";
    private static final String TENDER_EXCHANGE_STRING          = "TENDER_EXCHANGE";
    private static final String CART_IDS_JSON_KEY               = "cartIDs";
    private static final String RV_PAYMENT_AMOUNT_JSON_KEY      = "rvPaymentAmount";
    private static final String ORDER_ATTRIBUTE_REQ_TEMPLATE    = "ORDER_ATTRIBUTE";
    private static final String TENDER_ATTR                     = "!{tenders}";
    private static final String TENDER_EXPIRE_DATE              = "!{expireDate}";
    private static final String TENDER_CARD_NUMBER_MASKED       = "!{cardNumberMasked}";
    private static final String TENDER_TOKEN                    = "!{token}";
    private static final String TENDER_AUTHORIZATION            = "!{authorization}";
    private static final String TENDER_AMOUNT                   = "!{amount}";
    private static final String TENDER_EXCHANGE                 = "TENDER_EXCHANGE";
    private static final String TENDER_MAPING_CODE              = "TENDER_MAPING_CODE";
    private static final String TENDER_MAPING_TYPE              = "TENDER_MAPING_TYPE";
    private static final String TENDER_ACCOUNT_CREDIT           = "ACCOUNT_CREDIT";
    private static final String TENDER_CARDHOLDER               = "!{cardholder}";
    
    private static final String CAW_GOODSAM_SAVINGS_KEY         = "goodSamSavings";
    private static final String CAW_COULD_SAVE_KEY              = "couldSave";
    /* END BZ53752 */
    //BEGIN BZ54290
    private static final String CAW_DEPOSIT                     = "DEPOSIT";
    private static final String CAW_STATUS_CHANGE               = "CHANGE";
    //END BZ54290
    
    /* BEGIN BZ63054 */
    private static final String CAW_LOYALTY_DETAILS               = "!{loyaltyDetails}";

    private static final String                       CAW_PHYSICAL_INFO_ATTR                           = "CAW_PHYSICAL_INFO_ATTR";

    private static final String                       CAW_SALE_CHANNEL_CONFIG                          = "!{salesChannelConfig}";

    private static final String                       CAW_SALE_CHANNEL_CONFIG_ATTR                           = "CAW_SALE_CHANNEL_CONFIG_ATTR";

    private static final String                       CAW_IS_LOYALTY_ACTIVE                         = "!{isLoyaltyActive}";

    /* END BZ63054 */

    public CawCheetahHelper() {
        super();
    }
    public static CawCheetahHelper getInstance() {
        if (instance == null) {
            synchronized (CawCheetahHelper.class) {
                if (instance == null) {
                    instance = new CawCheetahHelper();
                }
            }
        }
        return instance;
    }
    //BEGIN BZ49450
    public boolean isClubMembership(String argJsonMessage) {
        try {
            if (!StringUtils.isEmpty(argJsonMessage) && argJsonMessage.length() > 0) {
                JSONObject req = new JSONObject(argJsonMessage);
                if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                    req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
                }
                if(req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    JSONArray memberships = req.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                    for(int i = 0; i<memberships.length(); i++) {
                        JSONObject membership = (JSONObject) memberships.get(i);
                        
                        // BEGIN BZ49929
                        List<String> listGSAMMemberType = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), CawEBSConstant.CAW_LOYALTY_GSAM_MEMBER_TYPE);
                        if(!(listGSAMMemberType.isEmpty()) ) {
                            for(String typeGSAM : listGSAMMemberType) {
                                if (typeGSAM.equalsIgnoreCase(String.valueOf(membership.get("type")))) {
                                    return true;
                                }
                            }
                        }
                        // END BZ49929
                    }
                }
            }
            
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
        }
        return false;
    }
    //END BZ49450
    public boolean isClubMembershipExpired(String argJsonMessage) {
        try {
            if (!StringUtils.isEmpty(argJsonMessage) && argJsonMessage.length() > 0) {
                JSONObject req = new JSONObject(argJsonMessage);
                if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                    req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
                }
                if(req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    JSONArray memberships = req.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                    for(int i = 0; i<memberships.length(); i++) {
                        JSONObject membership = (JSONObject) memberships.get(i);
                        
                        // BEGIN BZ49929
                        List<String> listGSAMMemberType = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), CawEBSConstant.CAW_LOYALTY_GSAM_MEMBER_TYPE);
                        if(!(listGSAMMemberType.isEmpty()) ) {
                            for(String typeGSAM : listGSAMMemberType) {
                                if (typeGSAM.equalsIgnoreCase(String.valueOf(membership.get("type")))) {
                                    if(membership.has(CawEBSConstant.MEMBERSHIPS_EXPIRE_DATE_ATTR) && !membership.isNull(CawEBSConstant.MEMBERSHIPS_EXPIRE_DATE_ATTR)) {
                                        Date membershipDate = new SimpleDateFormat("MM/dd/yyyy").parse(membership.getString(CawEBSConstant.MEMBERSHIPS_EXPIRE_DATE_ATTR));  
                                        if(DateUtils.getNewDate().after(DateUtils.getEndOfDay(membershipDate))) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                        // END BZ49929
                    }
                }
            }
            
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
        }
        return false;
    }
    public boolean isMembershipNull(String argJsonMessage) {
        try {
            if (!StringUtils.isEmpty(argJsonMessage) && argJsonMessage.length() > 0) {
                JSONObject req = new JSONObject(argJsonMessage);
                if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                    req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
                }
                if(req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    if(req.getString(CawJSONConstant.JSON_MEMBERSHIPS) != null || req.getString(CawJSONConstant.JSON_MEMBERSHIPS).length()>0) {
                        return false;
                    }
                  }
                }

        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
        }
        return true;
    }
   //END BZ48629
   public ResponseEntity<String> callRetrievePromoRewardsAPI(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder, String argLoyaltyFreeTierSKU) {
        String promotionReq = buildPromotionReq(iPosTransaction, stationState, currentOrder, argLoyaltyFreeTierSKU);
        String memberId = getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
        /* BEGIN BZ59418 */
        if (!StringUtils.isEmpty(argLoyaltyFreeTierSKU) && StringUtils.isEmpty(memberId)) {
            memberId = argLoyaltyFreeTierSKU;
        }
        /* END BZ59418 */
        //Start BZ50032
        String retrievePromorewardsUrl = URL_RETRIEVE_PROMOREWARDS;
        if(CawCatalystHelper.getTokenResponseModel() == null) {
            CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
            CawCatalystHelper.setTokenResponseModel(tokenModel);
        }
        if(URL_RETRIEVE_PROMOREWARDS_TOKEN != null && !URL_RETRIEVE_PROMOREWARDS_TOKEN.isEmpty()) {  //BZ50159
            retrievePromorewardsUrl = URL_RETRIEVE_PROMOREWARDS_TOKEN;
            CawCatalystHelper.getTokenResponseModel().setUseToken(true);
        }
        else {
            CawCatalystHelper.getTokenResponseModel().setUseToken(false);
        }
        
        if (memberId.isEmpty()) {
            retrievePromorewardsUrl = retrievePromorewardsUrl.replace("/{memberId}", memberId);
        }
        
        retrievePromorewardsUrl = retrievePromorewardsUrl.replace(PARAM_MEMBERID, memberId);
        //End BZ50032
        
        String[] splitUrl = retrievePromorewardsUrl.trim().split("\\|");
        if(splitUrl != null && splitUrl.length == 3) {
            _logger.info("[Call Retrieve PromoRewards API - 0]:" + splitUrl[0]);
        } else {
            _logger.info("[Call Retrieve PromoRewards API - 1]:" + retrievePromorewardsUrl);
        }
        _logger.info("[Retrieve PromoRewards API request]:" + promotionReq);
        ResponseEntity<String> response = _cawEBSHelper.sendRequestToEBS(retrievePromorewardsUrl, promotionReq);
        if (response != null) {
            if(response.getStatusCode() == HttpStatus.OK) {
                if (getResultCodeFromEBS(response) == RESPONSE_SUCCESS_CODE) {//BZ48692
                    _logger.info("[Retrieve PromoRewards API Response]:" + response.getBody());
                } else {
                    _logger.info("[Retrieve PromoRewards API response code]:" + response.getStatusCode());
                    if(getErrorDetailFromEBS(response) != null && !getErrorDetailFromEBS(response).isEmpty()) {
                        _logger.error("[Error when retrieve PromoRewards] - Error result code: " + getResultCodeFromEBS(response));
                        _logger.error("[Error when retrieve PromoRewards] - Error detail: " + getErrorDetailFromEBS(response));
                    }
                }
            } else {
               _logger.error("[callRetrievePromoRewardsAPI response with an error]:" + response.toString());
            }
        }
        return response;
    }
    
    public String getMembershipId(String argJsonMessage, int type) {
        try {
            if(argJsonMessage != null && !argJsonMessage.isEmpty()) {
                JSONObject req = new JSONObject(argJsonMessage);
                if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                    req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
                }
                if (req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    JSONArray memberships = req
                            .getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                    for (int i = 0; i < memberships.length(); i++) {
                        JSONObject membership = (JSONObject) memberships.get(i);
                        if (membership.has(CawJSONConstant.JSON_TYPE) && !membership.isNull(CawJSONConstant.JSON_TYPE) 
                                && membership.getInt(CawJSONConstant.JSON_TYPE) == type) {
                            return membership.getString(CawJSONConstant.JSON_IDENTIFIER);
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method getMembershipId: "
                    + ex.getMessage());
        }
        return StringUtils.EMPTY;
    }

    public String getCorrelationKey(IPosTransaction iPosTransaction,StationState stationState) {

        String correlationKey = CawJSONConstant.NULL;
        try {
            if (iPosTransaction != null && stationState != null) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                Date bsnDate = iPosTransaction.getBusinessDate();
                String storeID = String.format("%4s", stationState.getRetailLocationId()).replace(' ', '0');
                String regID = String.format("%2s", stationState.getWorkstationId()).replace(' ', '0');
                String transSeq = String.format("%4s", iPosTransaction.getTransactionSequence()).replace(' ', '0');
                correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq;
            }
        } catch (Exception ex) {
            _logger.error("Can not build CorrelationKey: " + ex.getMessage());
        }
        return correlationKey;
    }
    public ResponseEntity<String> callRetrieveRewardAPI(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder, String argLoyaltyFreeTierSKU) {
        String promotionReq = buildPromotionReq(iPosTransaction, stationState, currentOrder, argLoyaltyFreeTierSKU);
        String memberId = getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
        /* BEGIN BZ59418 */
        if (!StringUtils.isEmpty(argLoyaltyFreeTierSKU) && StringUtils.isEmpty(memberId)) {
            memberId = argLoyaltyFreeTierSKU;
        }
        /* END BZ59418 */
        String correlationKey = getCorrelationKey(iPosTransaction, stationState);
         //Start BZ50032
        String retrievRewardUrl = URL_RETRIEVE_REWARD; 
        if(CawCatalystHelper.getTokenResponseModel() == null) {
            CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
            CawCatalystHelper.setTokenResponseModel(tokenModel);
        }
        if(URL_RETRIEVE_REWARD_TOKEN != null && !URL_RETRIEVE_REWARD_TOKEN.isEmpty()) {  //BZ50159
            retrievRewardUrl = URL_RETRIEVE_REWARD_TOKEN;
            CawCatalystHelper.getTokenResponseModel().setUseToken(true);
        }
        else {
            CawCatalystHelper.getTokenResponseModel().setUseToken(false);
        }
        
        if (memberId.isEmpty()) {
            retrievRewardUrl = retrievRewardUrl.replace("/{memberId}", memberId);
        }
        
        retrievRewardUrl = retrievRewardUrl.replace(PARAM_MEMBERID, memberId).replace(PARAM_CORRELATIONKEY, correlationKey);
        //End BZ50032
        String[] splitUrl = retrievRewardUrl.trim().split("\\|");
        if(splitUrl != null && splitUrl.length == 3) {
            _logger.info("[Call Retrieve Reward API] - 0:" + splitUrl[0]);
        }else {
            _logger.info("[Call Retrieve Reward API] - 1:" + retrievRewardUrl); 
        }
        _logger.info("[Retrieve Reward API request]:" + promotionReq);
        ResponseEntity<String> response = _cawEBSHelper.sendRequestToEBS(retrievRewardUrl, promotionReq);
        if (response != null) {
            if(response.getStatusCode() == HttpStatus.OK) {
                if (getResultCodeFromEBS(response) == RESPONSE_SUCCESS_CODE) {//BZ48692
                    _logger.info("[Retrieve Reward API Response]:" + response.getBody());
                } else {    //BZ59669
                    _logger.error("[Retrieve Reward API response] - Error result code: " + getResultCodeFromEBS(response));
                    _logger.error("[Retrieve Reward API response] - Error detail: " + getErrorDetailFromEBS(response));
                } 
            } else {
                _logger.error("[callRetrieveRewardAPI response with an error]:" + response.toString());
            }
        }
        return response;
    }

    private String buildPromotionReq(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder, String argLoyaltyFreeTierSKU) {
        CawRestConfig request = _restConfigHelper.getRestRequest(CawRestConfigHelper.REQUEST_LOYALTY_MEMBER_PROMOTIONS);
        String bodyReq = StringUtils.EMPTY;
        if(request != null && !StringUtils.isEmpty(request.getBody())) {
            String customer = CawCatalystHelper.getLookupResponseData(); //BZ49894
            customer = convertCustomerOfflineFormat(customer); //BZ53287
            bodyReq = request.getBody();
            /*BEGIN BZ50112*/
            String memberId = getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            
            /* BEGIN BZ59418 */
            if (!StringUtils.isEmpty(argLoyaltyFreeTierSKU) && StringUtils.isEmpty(memberId)) {
                memberId = argLoyaltyFreeTierSKU;
            }
            /* END BZ59418 */
            bodyReq = bodyReq.replace(CawJSONConstant.MEMBER_ID, CawUtilFunction.formatParameter(memberId));
            /*END BZ50112*/
            bodyReq = bodyReq.replace(CawJSONConstant.SALES_CHANNEL, Long.toString(iPosTransaction.getRetailLocationId()));
            bodyReq = bodyReq.replace(CawJSONConstant.CHANNEL_TYPE_ATTR, CawEBSConstant.SALE_CHANNEL_TYPE_RETAIL);
            //BZ48401
            bodyReq = bodyReq.replace(ARRAY_REQUEST_ITEMS_ATTR, CawAdvancePromptingHelper.getInstance().getItemsArrTemplate(iPosTransaction, stationState, currentOrder));
            
            //Begin BZ49894
            if (!StringUtils.isEmpty(customer)) {
                bodyReq = bodyReq.replace(CAW_CUSTOMER, customer);
            } else {
                bodyReq = bodyReq.replace(CAW_CUSTOMER, CawJSONConstant.NULL);
            }
            //End BZ49894
        }
        return bodyReq;
    }

    //BEGIN BZ53287
    private String convertCustomerOfflineFormat(String customerString) {
        String result = customerString;
        try {
            if(customerString != null && !customerString.isEmpty()) {
                JSONObject customerJson = new JSONObject(customerString);
                if(customerJson.has(PRICING) && !customerJson.isNull(PRICING)) {
                    JSONObject pricingJson = customerJson.getJSONObject(PRICING);
                    if(pricingJson.has(MEMBERSHIP) && !pricingJson.isNull(MEMBERSHIP)) {
                        int pricingIndex = result.indexOf(PRICING);
                        
                        JSONObject membershipJson = pricingJson.getJSONObject(MEMBERSHIP);
                        //convert benefitLevel field from char to numeric
                        if(membershipJson.getString(BENEFIT_LEVEL) != null && !membershipJson.getString(BENEFIT_LEVEL).isEmpty()) {
                            String benefitLevelJson = membershipJson.getString(BENEFIT_LEVEL);
                            int benefitIndex = result.lastIndexOf("\"" + BENEFIT_LEVEL + "\":", pricingIndex);
                            int lastBenefitIndex = result.indexOf(",", benefitIndex);
                            result = result.replace(result.substring(benefitIndex, lastBenefitIndex), "\"" + BENEFIT_LEVEL + "\":" + benefitLevelJson);
                        }
                        //convert status field from char to numeric
                        if(membershipJson.getString(STATUS) != null && !membershipJson.getString(STATUS).isEmpty()) {
                            String statusJson = membershipJson.getString(STATUS);
                            int statusIndex = result.indexOf("\"" + STATUS + "\":", pricingIndex);
                            int lastStatusIndex = result.indexOf("}", statusIndex);
                            result = result.replace(result.substring(statusIndex, lastStatusIndex), "\"" + STATUS + "\":" + statusJson);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.debug("[Error when validate customer string from Offline]: " + ex);
        }
        
        return result;
    }
    //END BZ53287
    
    //START BZ50442
    private String buildSubmitOrderReq(IPosTransaction iPosTransaction, StationState stationState
            , IOrder currentOrder, CawCheetahSubmitRequestModel requestModel, WarrantyManager argWarrantyMgr, Map<String, List<JSONObject>> argSerialNumberActive, CawDiscountCouponHelper argCawDiscountCouponHelper, List<IWarranty> argListWarranty, CawWorkOrderEBSQueryResult argWorkOrderResult, String argLoyaltyFreeTierSKU) {
        CawRestConfig request = _restConfigHelper.getRestRequest(CawRestConfigHelper.REQUEST_LOYALTY_SUBMIT_ORDER);
        String bodyReq = StringUtils.EMPTY;
        String customer = StringUtils.EMPTY;
        if(request != null && !StringUtils.isEmpty(request.getBody())) {
            //BEGIN BZ53547
            if(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender() != null && !CawCatalystHelper.getLookupResponseDataUseThirdPartyTender().isEmpty()) {
                customer = CawCatalystHelper.getLookupResponseDataUseThirdPartyTender(); 
            } else {
                customer = CawCatalystHelper.getLookupResponseData(); //BZ49894
            }
            bodyReq = request.getBody();
            String memberId = StringUtils.EMPTY;
            if(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender() != null && !CawCatalystHelper.getLookupResponseDataUseThirdPartyTender().isEmpty()) { 
                memberId = getMembershipId(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender(), 1);
            } else {
                memberId = getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            }
            //END BZ53547
            
            /* BEGIN BZ59418 */
            if (!StringUtils.isEmpty(argLoyaltyFreeTierSKU) && StringUtils.isEmpty(memberId)) {
                memberId = argLoyaltyFreeTierSKU;
            }
            /* END BZ59418 */
            
            bodyReq = bodyReq.replace(CawJSONConstant.MEMBER_ID, CawUtilFunction.formatParameter(memberId));
            //bodyReq = bodyReq.replace(CawJSONConstant.SALES_CHANNEL, Long.toString(iPosTransaction.getRetailLocationId())); // BZ63054
            bodyReq = bodyReq.replace(CawJSONConstant.CHANNEL_TYPE_ATTR, CawEBSConstant.SALE_CHANNEL_TYPE_RETAIL);
            bodyReq = bodyReq.replace(SALES_CHANNEL, buildSalesChannel(iPosTransaction));// BZ63054
            bodyReq = bodyReq.replace(CAW_CORRELATION_KEY, CawUtilFunction.formatParameter(getCorrelationKey(iPosTransaction, stationState)));//BZ51699
            
            bodyReq = bodyReq.replace(ARRAY_REQUEST_ITEMS_ATTR, CawAdvancePromptingHelper.getInstance().getItemsArrTemplateForCheetahReturn(iPosTransaction, stationState, currentOrder, requestModel, argWarrantyMgr, argSerialNumberActive, argCawDiscountCouponHelper, argListWarranty)); //BZ53876
            if (!StringUtils.isEmpty(customer)) {
                bodyReq = bodyReq.replace(CAW_CUSTOMER, customer);
            } else {
                bodyReq = bodyReq.replace(CAW_CUSTOMER, CawJSONConstant.NULL);
            }
            //START BZ50442
            if(CawCatalystHelper.getOfferApplyLoyalty() == null || CawCatalystHelper.getOfferApplyLoyalty().isEmpty()) {
                bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, CawJSONConstant.NULL);
            } else {
                bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, getOfferRedemptionsWithFullInfoArrTemplate(iPosTransaction)); //BZ53752 - Build submit order request with full offers info 
            }
            
            if(CawCatalystHelper.getRewardApplyLoyalty() == null) {
                bodyReq = bodyReq.replace(REWARD_REDEMPTION, CawJSONConstant.NULL);
            } else {
                bodyReq = bodyReq.replace(REWARD_REDEMPTION, getRewardRedemptionsArrTemplate(iPosTransaction));
            }
            
            /* BEGIN BZ53752 */
            //Order Type
            if(CawWorkOrderOptionsOp.isDepositAction()) {
                bodyReq = bodyReq.replace(CAW_ORDER_TYPE, "4");  
            } else if (CawWorkOrderOptionsOp.isCompleteAction()) {
                bodyReq = bodyReq.replace(CAW_ORDER_TYPE, "8");
            } else if (CawWorkOrderOptionsOp.isRefundAction()) {
                bodyReq = bodyReq.replace(CAW_ORDER_TYPE, "16");
            } else {
                bodyReq = bodyReq.replace(CAW_ORDER_TYPE, "0");
            }

            //Order ID
            String storeID = String.format("%4s", iPosTransaction.getRetailLocationId()).replace(' ', ZERO_CHAR);
            String regID = String.format("%2s", iPosTransaction.getWorkstationId()).replace(' ', ZERO_CHAR);
            String transID = String.format("%4s", iPosTransaction.getTransactionSequence()).replace(' ', ZERO_CHAR);
            String orderID = String.valueOf(Integer.parseInt(storeID + regID + transID));
            if(orderID != null && !orderID.isEmpty()) {
                bodyReq = bodyReq.replace(ID_ORDER_ATTR, orderID);
            } else {
                bodyReq = bodyReq.replace(ID_ORDER_ATTR, CawJSONConstant.NULL);
            }
            
            //Order Date
            String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = CawUtilFunction.formatParameter(simpleDateFormat.format(iPosTransaction.getBeginDateTimestamp()));
            bodyReq = bodyReq.replace(ORDER_DATE_ATTR, !date.isEmpty() ? date : CawJSONConstant.NULL);
            
            //Order Total With Tax
            if(iPosTransaction.getTransactionTypeCode().equalsIgnoreCase(TENDER_EXCHANGE_STRING)) {
                String amountDue = iPosTransaction.getAmountDue().multiply(BigDecimal.valueOf(-1)).toString();
                bodyReq = bodyReq.replace(ORDER_TOTAL_WITH_TAX_ATTR, !amountDue.isEmpty() ? amountDue : CawJSONConstant.NULL);
            } else {
                String totalWithTax = iPosTransaction.getTotal().toString();
                bodyReq = bodyReq.replace(ORDER_TOTAL_WITH_TAX_ATTR, !totalWithTax.isEmpty() ? totalWithTax : CawJSONConstant.NULL);
            }
            
            //Work Order
            String workOrderDetailsAttr = buildWorkOrderDetailAttr(requestModel);
            if (workOrderDetailsAttr != null) {
                bodyReq = bodyReq.replace(WORK_ORDER_DETAIL_ATTR, workOrderDetailsAttr);
            }else {
                bodyReq = bodyReq.replace(WORK_ORDER_DETAIL_ATTR, CawJSONConstant.NULL);
            }
            
            //Tender
            String tenderStr = buildTenderAttribute(iPosTransaction, stationState, argWorkOrderResult);
            if (tenderStr != null) {
                bodyReq = bodyReq.replace(TENDER_ATTR, tenderStr);
            } else {
                bodyReq = bodyReq.replace(TENDER_ATTR, CawJSONConstant.NULL);
            }
            
            //Purchase Order
            bodyReq = bodyReq.replace(CAW_PURCHASE_ORDER, formatParameter(purchaseOrderTemplate(iPosTransaction)));
            
            //Attributes
            String attributeSubmitOrder = StringUtils.EMPTY;
            attributeSubmitOrder = getAttributeSubmitReq(iPosTransaction, requestModel.getParty());
            if(!attributeSubmitOrder.isEmpty()) {
                bodyReq = bodyReq.replace(CAW_ATTRIBUTES, attributeSubmitOrder);
            } else {
                bodyReq = bodyReq.replace(CAW_ATTRIBUTES, CawJSONConstant.NULL);
            }
            
            //END BZ50442, BZ53752
            /* BEGIN BZ63054 */
            String cashierTemplate = buildCashier(iPosTransaction);
            bodyReq = bodyReq.replace(CAW_CASHIER, cashierTemplate);
            
            bodyReq = bodyReq.replace(CAW_LOYALTY_DETAILS, CawJSONConstant.NULL);
            //contactPhone
            bodyReq = bodyReq.replace(CAW_CONTACT_PHONEL, CawJSONConstant.NULL);
            //paidInOutDetail
            bodyReq = bodyReq.replace(CAW_PAID_IN_OUT_DETAIL, CawJSONConstant.NULL);
            //purchaseOrder
            bodyReq = bodyReq.replace(CAW_PURCHASE_ORDER, CawJSONConstant.NULL);
            //thirdPartyPayer
            bodyReq = bodyReq.replace(CAW_THIRD_PARTY_PAYER, CawJSONConstant.NULL);
            //shipToInfo
            bodyReq = bodyReq.replace(CAW_SHIP_TO_INFO, CawJSONConstant.NULL);           
            
            //receiptType
            bodyReq = bodyReq.replace(CAW_RECEIPT_TYPE, requestModel.getReceiptType()); 
            //receiptTypeDescription
            bodyReq = bodyReq.replace(CAW_RECEIPT_TYPE_DESCRIPTION, requestModel.getReceiptTypeDescription());
            //eReceiptEmail
            String emailReceipt = requestModel.getEmailReceipt();
            if(emailReceipt != null && !emailReceipt.isEmpty()) {
                bodyReq = bodyReq.replace(CAW_E_RECEIPT_EMAIL, emailReceipt);
            } else {
                bodyReq = bodyReq.replace(CAW_E_RECEIPT_EMAIL, CawJSONConstant.NULL);
            }
            /* END BZ63054 */
        }
        return bodyReq;
    }
    
    
    /**
     * @param argIPosTransaction
     * @return
     */
    private CharSequence getRewardRedemptionsArrTemplate(IPosTransaction iPosTransaction) {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REWARD_REDEMPTION);
        String body = request.getBody();
        String result = "";
        try {
            body = body.replace(REWARD_CODE, CawCatalystHelper.getRewardApplyLoyalty().getRewardCode());
            body = body.replace(EBS_COUPON_CODE, CawUtilFunction.formatParameter(CawCatalystHelper.getRewardApplyLoyalty().getEbsCouponCode())); //BZ52837
            body = body.replace(REWARD_POINTS_ALLOCATIONS, getPointRedeemedOnLineItemArrTemplate(iPosTransaction));
            result = body;
        } catch (Exception ex) {
            _logger.error("[Error when build RewardRedemptionsArr request: ]" + ex.getMessage());
        }
        
        return result;
    }
    /**
     * @param argIPosTransaction
     * @return
     */
    //START BZ50442
    private String getPointRedeemedOnLineItemArrTemplate(IPosTransaction iPosTransaction) throws JSONException {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REWARD_POINTS_ALLOCATIONS);
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = null;
        if (CawCatalystHelper.getRewardApplyLoyalty().getRewardClaimAllocations() != null) {
            JSONArray rewardClaimAllocations = CawCatalystHelper.getRewardApplyLoyalty().getRewardClaimAllocations();
            for (int i = 0; i < rewardClaimAllocations.length(); i++ ) {
                    temp = String.valueOf(body);
                    JSONObject jsonObj = rewardClaimAllocations.getJSONObject(i);
                    if (!jsonObj.isNull(CawJSONConstant.ITEM_CORRELATION_KEY)) {
                        temp = temp.replace(ITEM_CORRELATION_KEY, CawUtilFunction.formatParameter(jsonObj.getString(CawJSONConstant.ITEM_CORRELATION_KEY)));
                    } else {
                        temp = temp.replace(ITEM_CORRELATION_KEY, CawJSONConstant.NULL);
                    }
                    if (!jsonObj.isNull(CawJSONConstant.POINTS_REDEEMED_ONLINE_ITEM)) {
                        temp = temp.replace(POINT_REDEEMED_ONLINE_ITEM, jsonObj.getString(CawJSONConstant.POINTS_REDEEMED_ONLINE_ITEM)); //BZ52874
                    } else {
                        temp = temp.replace(POINT_REDEEMED_ONLINE_ITEM, CawJSONConstant.NULL);
                    }
                    resultBuilder.append(temp);
                    resultBuilder.append(",");
                
            }
            if (resultBuilder.length() > 0) {
                result = SQUARE_BRACKETS_OPEN
                        + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                        + SQUARE_BRACKETS_CLOSE;
            }
        }
        return result;
    }
    /**
     * @param argIPosTransaction
     * @param argStationState
     * @param argCurrentOrder
     * @return
     */
    
    private String getOfferRedemptionsArrTemplate(IPosTransaction iPosTransaction) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.PROMO_OFFER_REDEMPTIONS);
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = null;
        if (iPosTransaction != null) {
            List<CawPromotionModel> offersApplied = CawCatalystHelper.getOfferApplyLoyalty();
            for (CawPromotionModel offer : offersApplied) {
                    temp = String.valueOf(body);
                    if(offer.getOfferResponseCode() != null && !offer.getOfferResponseCode().isEmpty()) {
                        temp = temp.replace(OFFER_RESPONSE_CODE, offer.getOfferResponseCode()); 
                    }
                    if(offer.getEbsCouponCode() != null && !offer.getEbsCouponCode().isEmpty()) {
                        temp = temp.replace(EBS_COUPON_CODE, CawUtilFunction.formatParameter(offer.getEbsCouponCode())); //BZ52041
                    }
                    if(offer.getPromoCode() != null && !offer.getPromoCode().isEmpty()) {
                        temp = temp.replace(OFFER_CODE, offer.getPromoCode()); 
                    }
                    resultBuilder.append(temp);
                    resultBuilder.append(",");
            }
            if (resultBuilder.length() > 0) {
                result = SQUARE_BRACKETS_OPEN
                        + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                        + SQUARE_BRACKETS_CLOSE;
            }
        }
        return result;

    }
    //END BZ50442
    
    /**
     * @param argBody
     * @return
     */
    public List<CawPromotionModel> parseResponseToPromotions(String jsonMessage) {
        List<CawPromotionModel> promotions = new ArrayList<CawPromotionModel>();
        try {
            JSONObject jsonObject = new JSONObject(jsonMessage);
            if(jsonObject.has(CawJSONConstant.JSON_RESULT) && !jsonObject.isNull(CawJSONConstant.JSON_RESULT)) {
                JSONArray promosJson = CawJSONUtils.getJSONArray(jsonObject.getJSONObject(CawJSONConstant.JSON_RESULT), CawJSONConstant.JSON_PROMO_OFFERS);
                if(promosJson != null && promosJson.length() > 0) {
                    CawPromotionModel promotion = null;
                    JSONObject promoJsonOb = null;
                    for (int i = 0;i<promosJson.length(); i++) {
                        promotion = new CawPromotionModel();
                        promoJsonOb = promosJson.getJSONObject(i);
                        if(promoJsonOb.has(CawJSONConstant.JSON_PROMO_CODE) && !promoJsonOb.isNull(CawJSONConstant.JSON_PROMO_CODE)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_CODE))) {
                            promotion.setPromoCode(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_CODE));
                        }
                        if(promoJsonOb.has(CawJSONConstant.JSON_PROMO_CODE_LABEL) && !promoJsonOb.isNull(CawJSONConstant.JSON_PROMO_CODE_LABEL)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_CODE_LABEL))) {
                            promotion.setPromoCodeLabel(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_CODE_LABEL));
                        }
                        if(promoJsonOb.has(CawJSONConstant.JSON_PROMO_METRIC_NAME) && !promoJsonOb.isNull(CawJSONConstant.JSON_PROMO_METRIC_NAME)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_METRIC_NAME))) {
                            promotion.setPromoMetricName(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_METRIC_NAME));
                        }
                        if(promoJsonOb.has(CawJSONConstant.JSON_PROMO_METRIC_VALUE) && !promoJsonOb.isNull(CawJSONConstant.JSON_PROMO_METRIC_VALUE)
                                && promoJsonOb.get(CawJSONConstant.JSON_PROMO_METRIC_VALUE) != null) {
                            BigDecimal metricValue = new BigDecimal(promoJsonOb.getString(CawJSONConstant.JSON_PROMO_METRIC_VALUE));
                            promotion.setPromoMetricValue(metricValue);
                        }
                        if(promoJsonOb.has(CawJSONConstant.JSON_EXPIRATION) && !promoJsonOb.isNull(CawJSONConstant.JSON_EXPIRATION)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_EXPIRATION))) {
                            Date expirationDate = CawUtilFunction.formatDate(promoJsonOb.getString(CawJSONConstant.JSON_EXPIRATION), CawConstants.YYYY_MM_DD_DASH);
                            if(DateUtils.getNewDate().after(DateUtils.getEndOfDay(expirationDate))) {
                                continue;
                            }
                            promotion.setExpiration(expirationDate);
                            promotion.setExpirationString(promoJsonOb.getString(CawJSONConstant.JSON_EXPIRATION));//BZ51771
                        }
                        if(!promoJsonOb.isNull(CawJSONConstant.JSON_PROMO_OFFER_CLAIM_ALLOCATION)) {
                            JSONArray claimItemAllocations = CawJSONUtils.getJSONArray(promoJsonOb, CawJSONConstant.JSON_PROMO_OFFER_CLAIM_ALLOCATION);
                            promotion.setPromoOfferClaimAllocations(claimItemAllocations);
                        }
                        //Start BZ50442
                        if(promoJsonOb.has(CawJSONConstant.JSON_OFFER_RESPONSE_CODE) && !promoJsonOb.isNull(CawJSONConstant.JSON_OFFER_RESPONSE_CODE)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_OFFER_RESPONSE_CODE))) {
                            promotion.setOfferResponseCode(promoJsonOb.getString(CawJSONConstant.JSON_OFFER_RESPONSE_CODE));
                        }
                        if(promoJsonOb.has(CawJSONConstant.JSON_EBS_COUPON_CODE) && !promoJsonOb.isNull(CawJSONConstant.JSON_EBS_COUPON_CODE)
                                && !StringUtils.isEmpty(promoJsonOb.getString(CawJSONConstant.JSON_EBS_COUPON_CODE))) {
                            promotion.setEbsCouponCode(promoJsonOb.getString(CawJSONConstant.JSON_EBS_COUPON_CODE));
                        }
                        //End BZ50442
                        promotions.add(promotion);
                    }
                }
            }
            
        } catch (JSONException ex) {
            _logger.error("can't parse jsonObject to promotion model: " + ex.getMessage());
        }
        return promotions;
    }
    /**
     * @param argBody
     * @return
     */
    public CawRewardModel parseResponseToReward(String jsonMessage) {
        CawRewardModel reward = new CawRewardModel("_cawLoyaltyTitle","");//BZ49445
        String value = StringUtils.EMPTY ; 
        try {
            JSONObject jsonObject = new JSONObject(jsonMessage);
            if(jsonObject.has(CawJSONConstant.JSON_RESULT) && !jsonObject.isNull(CawJSONConstant.JSON_RESULT)) { //BZ52838
                JSONObject rewardJsonOb =  CawJSONUtils.getJSONObject(jsonObject.getJSONObject(CawJSONConstant.JSON_RESULT));
                if(!rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD)) {
                    rewardJsonOb = CawJSONUtils.getJSONObject(rewardJsonOb.getJSONObject(CawJSONConstant.JSON_REWARD));
                }
                if(rewardJsonOb.has(CawJSONConstant.JSON_REWARD_CODE) && !rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD_CODE)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_CODE))) {
                    reward.setRewardCode(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_CODE));
                }
                if(rewardJsonOb.has(CawJSONConstant.JSON_REWARDLABEL) && !rewardJsonOb.isNull(CawJSONConstant.JSON_REWARDLABEL)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_REWARDLABEL))) {
                    reward.setRewardLabel(rewardJsonOb.getString(CawJSONConstant.JSON_REWARDLABEL));
                }
                if(rewardJsonOb.has(CawJSONConstant.JSON_REWARD_HEADING) && !rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD_HEADING)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_HEADING))) {
                    reward.setRewardHeading(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_HEADING));
                }
                if(rewardJsonOb.has(CawJSONConstant.JSON_REWARD_MAX_REEDEMABLE_POINTS_BALANCE) && !rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD_MAX_REEDEMABLE_POINTS_BALANCE)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_MAX_REEDEMABLE_POINTS_BALANCE))) {
                    value = String.format("%,d",rewardJsonOb.getLong(CawJSONConstant.JSON_REWARD_MAX_REEDEMABLE_POINTS_BALANCE));
                    reward.setRewardMaxReedemablePointsBalance(value);
                    reward.setRewardMaxReedemablePointsBalanceLabel(value);//BZ49445
                }
                if(rewardJsonOb.has(CawJSONConstant.JSON_REWARD_MAX_REDEEMABLE_VALUE) && !rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD_MAX_REDEEMABLE_VALUE)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_MAX_REDEEMABLE_VALUE))) {
                    BigDecimal redeemableValue = new BigDecimal(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD_MAX_REDEEMABLE_VALUE));
                    reward.setRewardMaxRedeemableValue(redeemableValue);
                }
                if(!rewardJsonOb.isNull(CawJSONConstant.JSON_REWARD_CLAIM_ALLOCATION)) {
                    JSONArray claimItemAllocations = CawJSONUtils.getJSONArray(rewardJsonOb, CawJSONConstant.JSON_REWARD_CLAIM_ALLOCATION);
                    reward.setRewardClaimAllocations(claimItemAllocations);
                }
                //BEGIN BZ52837
                if(rewardJsonOb.has(CawJSONConstant.JSON_EBS_COUPON_CODE) && !rewardJsonOb.isNull(CawJSONConstant.JSON_EBS_COUPON_CODE)
                        && !StringUtils.isEmpty(rewardJsonOb.getString(CawJSONConstant.JSON_EBS_COUPON_CODE))) {
                    reward.setEbsCouponCode(CawJSONUtils.getString(rewardJsonOb, CawJSONConstant.JSON_EBS_COUPON_CODE));
                }
                //END BZ52837
            }
            
            //get points To Next Reward
            String custLookupJson = CawCatalystHelper.getLookupLoyaltyResponseData();
            if(!StringUtils.isEmpty(custLookupJson)) {
                jsonObject = new JSONObject(custLookupJson);
                if(jsonObject.has(CawJSONConstant.JSON_STATUS) && !jsonObject.isNull(CawJSONConstant.JSON_STATUS)) {
                    JSONObject statusJson = jsonObject.getJSONObject(CawJSONConstant.JSON_STATUS);
                    if(statusJson.has(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD) && !StringUtils.isEmpty(statusJson.getString(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD))) {
                        value = String.format("%,d",statusJson.getLong(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD));
                        reward.setPointsToNextReward(value);
                        reward.setPointsToNextRewardLabel(value); //BZ49445
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("can't parse jsonObject to promotion model: " + ex.getMessage());
        }
        return reward;
    }

    //BEGIN BZ48629
    public HashMap<String,String> getCheetahRctpPoint(String jsonMess) {
        Map<String,String> map = new HashMap<>();
       try {
        JSONObject jsonObj = new JSONObject(jsonMess);
        if(jsonObj.has(CawJSONConstant.JSON_RESULT) && !jsonObj.isNull(CawJSONConstant.JSON_RESULT)) {
            jsonObj = new JSONObject(jsonObj.getString(CawJSONConstant.JSON_RESULT));
        }
        //BEGIN BZ63054
        if(jsonObj.has(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE) && !jsonObj.isNull(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE)) {
            jsonObj = new JSONObject(jsonObj.getString(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE));
        }
        //END BZ63054
        if(!jsonObj.isNull(CawJSONConstant.JSON_SUBMIT_ORDER_RECEIPT_SUMMARY)) {
            jsonObj = CawJSONUtils.getJSONObject(jsonObj.getJSONObject(CawJSONConstant.JSON_SUBMIT_ORDER_RECEIPT_SUMMARY));
        }
        
        Iterator<?> keys = jsonObj.keys();
        
        while(keys.hasNext() ) {
            String key = String.valueOf(keys.next());
            String value=String.valueOf(jsonObj.get(key));
            //Begin BZ49706
            if (value == null) {
                value = "";
            }
            //End BZ49706
            map.put(key, value);
        }

 
       }catch(Exception ex) {
           _logger.error("[Can't Read Loyalty Point]: "+ex.getMessage());
       }
        return (HashMap<String, String>) map;
    }
 
    /*BEGIN BZ50112*/
    public ResponseEntity<String> callSubmitOrderAPI(IPosTransaction iPosTransaction, StationState stationState
            , IOrder currentOrder, CawCheetahSubmitRequestModel requestModel, WarrantyManager argWarrantyMgr, Map<String, List<JSONObject>> argSerialNumberActive, CawDiscountCouponHelper argCawDiscountCouponHelper, List<IWarranty> argListWarranty, CawWorkOrderEBSQueryResult argWorkOrderResult, String argLoyaltyFreeTierSKU)  {
        /*BEGIN BZ54776 */
        ResponseEntity<String> response = null;
        if (CawCheetahHelper.isEnableLoyalty()) {
            String submitOrderReq = buildSubmitOrderReq(iPosTransaction, stationState, currentOrder, requestModel, argWarrantyMgr, argSerialNumberActive, argCawDiscountCouponHelper, argListWarranty, argWorkOrderResult, argLoyaltyFreeTierSKU); //BZ50442, BZ53752, BZ53876
            //BEGIN BZ53547
            String memberId = StringUtils.EMPTY;
            if(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender() != null && !CawCatalystHelper.getLookupResponseDataUseThirdPartyTender().isEmpty()) {
                memberId = getMembershipId(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender(), 1);
            } else {
                memberId = getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            }
            /* BEGIN BZ59418 */
            if (!StringUtils.isEmpty(argLoyaltyFreeTierSKU) && StringUtils.isEmpty(memberId)) {
                memberId = argLoyaltyFreeTierSKU;
            }
            /* END BZ59418 */
            //END BZ53547
            //Start BZ50032
            String submitOrderUrl = URL_EARNINGS; 
            if(CawCatalystHelper.getTokenResponseModel() == null) {
                CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
                CawCatalystHelper.setTokenResponseModel(tokenModel);
            }
            if(URL_EARNINGS_TOKEN != null && !URL_EARNINGS_TOKEN.isEmpty()) { //BZ50159
                submitOrderUrl = URL_EARNINGS_TOKEN;
                CawCatalystHelper.getTokenResponseModel().setUseToken(true);
            }
            else {
                CawCatalystHelper.getTokenResponseModel().setUseToken(false);
            }
            submitOrderUrl = submitOrderUrl.replace(PARAM_MEMBERID, memberId);
            //End BZ50032
            String[] splitUrl = submitOrderUrl.trim().split("\\|");
            if(splitUrl != null && splitUrl.length == 3) {
                _logger.info("[Call Submit Order API - 0]:" + splitUrl[0]);
            }else {
                _logger.info("[Call Submit Order API - 1]:" + submitOrderUrl); 
            }
            _logger.info("[Submit Order API request]:" + submitOrderReq);
            response = _cawEBSHelper.sendRequestToEBS(submitOrderUrl, submitOrderReq);
            /*BEGIN BZ55978*/
            if (response != null) {
                if(response.getStatusCode() == HttpStatus.OK) {
                    if (getResultCodeFromEBS(response) == RESPONSE_SUCCESS_CODE) {//BZ48692
                        _logger.info("[Submit Order API Response]:" + response.getBody());
                    } else {   //BZ59669
                        _logger.error("[Submit Order API response] - Error result code: " + getResultCodeFromEBS(response));
                        _logger.error("[Submit Order API response] - Error detail: " + getErrorDetailFromEBS(response));
                    }    
                } else {
                    _logger.error("[Submit Order API response with an error]: " + response.toString());
                }
            }
            /*END BZ55978*/
        }
        /*END BZ54776 */
        return response;
    }
    /*END BZ50112*/
    
    //BEGIN BZ48692
    public int getResultCodeFromEBS(ResponseEntity<String> response) {
        int resultCode = 1;
        String responseBody = response.getBody();
        try {
            JSONObject jsonObj = new JSONObject(responseBody);
            if (jsonObj.has(CawJSONConstant.JSON_RESULT_CODE)) {
                resultCode = jsonObj.getInt(CawJSONConstant.JSON_RESULT_CODE);
            }
        } catch (Exception ex) {
            String errorDetail = getErrorDetailFromEBS(response);
            _logger.error("[Error detail] : " + errorDetail);
        }
        return resultCode;

    }
    
   public String getErrorDetailFromEBS(ResponseEntity<String> response) {
       String errorDetail = "";
       String responseBody = response.getBody();
       try {
           JSONObject jsonObj = new JSONObject(responseBody);
           if (jsonObj.has(CawJSONConstant.JSON_ERROR_DETAIL)) {
               errorDetail = jsonObj.getString(CawJSONConstant.JSON_ERROR_DETAIL);
           }
       } catch (Exception ex) {
           _logger.error("[Can't read response] : " + ex.getMessage());
       }
       return errorDetail;
   }
   //END BZ48629,BZ48692
   //BEGIN BZ49706
   public boolean isRewardNull(String argJsonMessage) {
       try {
       JSONObject jsonObject = new JSONObject(argJsonMessage);
       if(jsonObject.has(CawJSONConstant.JSON_RESULT) && !jsonObject.isNull(CawJSONConstant.JSON_RESULT)) {
           JSONObject rewardJsonOb =  CawJSONUtils.getJSONObject(jsonObject.getJSONObject(CawJSONConstant.JSON_RESULT));
           if(rewardJsonOb.getString(CawJSONConstant.JSON_REWARD) == null) {
               return true;
           }
        
       }
       }catch(Exception ex) {
           _logger.error("[Can't read the json Message: ]"+ex.getMessage());
       }
       
       return false;
   }
   //END BZ49706
   //Begin BZ49750
   public boolean isWhls(String argJsonMessage) {
       try {
           if(argJsonMessage != null && !argJsonMessage.isEmpty()) {
               JSONObject req = new JSONObject(argJsonMessage);
               if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                   req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
               }
               if (req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                   JSONArray memberships = req
                           .getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                   for (int i = 0; i < memberships.length(); i++) {
                       JSONObject membership = (JSONObject) memberships.get(i);
                       if (membership.has(CawJSONConstant.JSON_TYPE) && membership.getInt(CawJSONConstant.JSON_TYPE) == 8192) {
                           return true;
                       }
                   }
               }
           }
       } catch (JSONException ex) {
           _logger.error("Can not parse to JSON object: " + ex.getMessage());
       } catch (Exception ex) {
           _logger.error("Error happened in method isWhls: "
                   + ex.getMessage());
       }
       return false;      
   }
   public boolean isCrew(String argJsonMessage) {
       try {
           if(argJsonMessage != null && !argJsonMessage.isEmpty()) {
               JSONObject req = new JSONObject(argJsonMessage);
               if (req.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !req.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {
                   req = req.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
               }
               if (req.has(CawJSONConstant.JSON_MEMBERSHIPS) && !req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                   JSONArray memberships = req
                           .getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                   for (int i = 0; i < memberships.length(); i++) {
                       JSONObject membership = (JSONObject) memberships.get(i);
                       if (membership.has(CawJSONConstant.JSON_TYPE) && membership.getInt(CawJSONConstant.JSON_TYPE) == 256) {
                           return true;
                       }
                   }
               }
           }
       } catch (JSONException ex) {
           _logger.error("Can not parse to JSON object: " + ex.getMessage());
       } catch (Exception ex) {
           _logger.error("Error happened in method isWhls: "
                   + ex.getMessage());
       }
       return false;      
   }
   //End BZ49750
   //Begin BZ49894
   private String buildPromotionReqVer2(IPosTransaction iPosTransaction, StationState stationState, IOrder currentOrder) {
       CawRestConfig request = _restConfigHelper.getRestRequest(CawRestConfigHelper.REQUEST_LOYALTY_MEMBER_PROMOTIONS);
       String bodyReq = StringUtils.EMPTY;
       String fmtNull = CawJSONConstant.NULL;
       int lineNumber = 0;
       String customer = CawCatalystHelper.getLookupResponseData();
       JSONObject customerJson = CawJSONUtils.toJSONObject(customer);
       if(request != null && !StringUtils.isEmpty(request.getBody())) {
           bodyReq = request.getBody();
           bodyReq = bodyReq.replace(SALES_CHANNEL, buildSalesChannel(iPosTransaction));
           bodyReq = bodyReq.replace(CAW_ORDER_TYPE, CawJSONConstant.NULL);
           bodyReq = bodyReq.replace(CAW_ORDER_TYPE_DESCRIPTION,CawUtilFunction.formatParameter(String.format("%s", "WorkOrderComplete")) ); //not sure
           bodyReq = bodyReq.replace(CAW_ID, buildId(iPosTransaction));
           //cashier
           bodyReq = bodyReq.replace(CAW_CASHIER, buildCashier(iPosTransaction));//note
           //orderDate
           String bussinessDate = String.valueOf(iPosTransaction.getBusinessDate());
           String orderDate = bussinessDate.substring(0, 10);
           bodyReq = bodyReq.replace(ORDER_DATE_ATTR, formatParameter(orderDate));
           //orderTotalWithTax
           BigDecimal orderTotalWithTax = new BigDecimal(0.00);
           orderTotalWithTax = iPosTransaction.getTotal();
           if (orderTotalWithTax != null) {
               bodyReq = bodyReq.replace(ORDER_TOTAL_WITH_TAX_ATTR, String.valueOf(orderTotalWithTax));
           } else {
               bodyReq = bodyReq.replace(ORDER_TOTAL_WITH_TAX_ATTR, "0");
           }
           //customer 
           if (!StringUtils.isEmpty(customer)) {
               bodyReq = bodyReq.replace(CAW_CUSTOMER, customer);
           } else {
               bodyReq = bodyReq.replace(CAW_CUSTOMER, CawJSONConstant.NULL);
           }
           //thirdPartyPayer
           bodyReq = bodyReq.replace(CAW_THIRD_PARTY_PAYER, CawJSONConstant.NULL);
           //shipToInfo
           bodyReq = bodyReq.replace(CAW_SHIP_TO_INFO, CawJSONConstant.NULL);
           //items
           bodyReq = bodyReq.replace(ARRAY_REQUEST_ITEMS_ATTR, CawAdvancePromptingHelper.getInstance().getItemsArrTemplate(iPosTransaction, stationState, currentOrder));
           //tender
           bodyReq = bodyReq.replace(CAW_TENDERS, CawJSONConstant.NULL);
           //receiptType
           bodyReq = bodyReq.replace(CAW_RECEIPT_TYPE, CawJSONConstant.NULL); //not sure
           //receiptTypeDescription
           bodyReq = bodyReq.replace(CAW_RECEIPT_TYPE_DESCRIPTION, CawUtilFunction.formatParameter(String.format("%s", "NONE"))); //not sure
           //eReceiptEmail
           bodyReq = bodyReq.replace(CAW_E_RECEIPT_EMAIL, CawJSONConstant.NULL); //not sure
           //contactPhone
           bodyReq = bodyReq.replace(CAW_CONTACT_PHONEL, CawJSONConstant.NULL);
           //paidInOutDetail
           bodyReq = bodyReq.replace(CAW_PAID_IN_OUT_DETAIL, CawJSONConstant.NULL);
           //purchaseOrder
           bodyReq = bodyReq.replace(CAW_PURCHASE_ORDER, CawJSONConstant.NULL);
           //workOrderDetail
           //bodyReq = bodyReq.replace(CAW_WORK_ORDER_DETAIL, buildWorkOrderDetail());
           bodyReq = bodyReq.replace(CAW_WORK_ORDER_DETAIL, CawJSONConstant.NULL);
           //correlationKey
           String correlationKey = getCorrelationKey(iPosTransaction, stationState);
           if (!correlationKey.equals(fmtNull)) {
               correlationKey = correlationKey + ":" + String.valueOf(lineNumber);//BZ51922
           }
           bodyReq = bodyReq.replace(CAW_CORRELATION_KEY, CawUtilFunction.formatParameter(correlationKey));
           //properties
           bodyReq = bodyReq.replace(CAW_PROPERTIES, CawJSONConstant.NULL);
           //attributes
           //bodyReq = bodyReq.replace(CAW_ATTRIBUTES,buildAttributes() );
           bodyReq = bodyReq.replace(CAW_ATTRIBUTES,CawJSONConstant.NULL);

       }
       return bodyReq;
   }
   /* BEGIN BZ63054 */
        /**
     * @param argIPosTransaction
     * @return
     */
    private CharSequence buildSalesChannel(IPosTransaction argIPosTransaction) {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.SALES_CHANNEL_ATTR);
        String body = request.getBody();
        long storeId = 0;
        long terminalId = 0;
        if (argIPosTransaction != null) {
            storeId = argIPosTransaction.getRetailLocationId();
            terminalId = argIPosTransaction.getWorkstationId();
        }
        body = body.replace(CAW_ID, String.format("%s", storeId));
        body = body.replace(CAW_TERMINAL, String.format("%s", terminalId));
        body = body.replace(CAW_CHANNELTYPE, String.format("%s", Integer.valueOf(4)));
        body = body.replace(CAW_CHANNEL_TYPE_DESCRIPTION, CawUtilFunction.formatParameter(String.format("%s", "Retail")));
        body = body.replace(CAW_IS_LOYALTY_ACTIVE, String.format("%s", CawJSONConstant.NULL));
        body = body.replace(CAW_PHYSICAL_INFO, buildPhysicalInfo(argIPosTransaction));
        body = body.replace(CAW_SALE_CHANNEL_CONFIG, buildSaleChannelConfig(argIPosTransaction));
        return body;
    }
    /**
         * @param argIPosTransaction
         * @return
         */

    private CharSequence buildPhysicalInfo(IPosTransaction argIPosTransaction) {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CAW_PHYSICAL_INFO_ATTR);
        String body = request.getBody();
        body = CawJSONConstant.NULL;
        
        return body;
    }
    
    private CharSequence buildSaleChannelConfig(IPosTransaction argIPosTransaction) {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CAW_SALE_CHANNEL_CONFIG_ATTR);
        String body = request.getBody();
        body = CawJSONConstant.NULL;
        return body;
    }
    /* END BZ63054 */

    private CharSequence buildAttributes() {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CAW_ATTRIBUTES_ATTR);
        String body = request.getBody();
        
        body = body.replace(CAW_GOODSAM_SAVINGS, CawJSONConstant.NULL);
        body = body.replace(CAW_COULD_SAVE, CawJSONConstant.NULL);
        body = body.replace(CAW_OE_ORDER_CATEGORY, CawJSONConstant.NULL);
        body = body.replace(CAW_OE_BATCH_NAME, CawJSONConstant.NULL);
        body = body.replace(CAW_OE_ORDER_SOURCE, CawJSONConstant.NULL);
        body = body.replace(CAW_OE_ORDER_TYPE, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_OE_HOLD_NAME, StringUtils.EMPTY);
        body = body.replace(CAW_OE_CWI_PC_NUMBER, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_OE_PREPAY_MATCH_KEY, StringUtils.EMPTY);
        body = body.replace(CAW_OE_PICKUP_WARE_HOUSE, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_OE_RAKUTEN_ID, StringUtils.EMPTY);
        body = body.replace(CAW_OE_RAKUTEN_DATE, StringUtils.EMPTY);
        body = body.replace(CAW_OE_AFFILIATE_ID, StringUtils.EMPTY);
        body = body.replace(CAW_OE_WEB_ORDER_ID, StringUtils.EMPTY);
        body = body.replace(CAW_OE_DELIVERY_BY_DATE_UTC, StringUtils.EMPTY);
    
    
        return body;
    }
    /**
     * @param argIPosTransaction
     * @return
     */
    private CharSequence buildWorkOrderDetail() {
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CAW_WORK_ORDER_DETAIL_ATTR);
        String body = request.getBody();
        
        body = body.replace(CAW_ID, CawJSONConstant.NULL);
        body = body.replace(CAW_TYPE, CawJSONConstant.NULL);
        body = body.replace(CAW_STATUS, CawJSONConstant.NULL);
        body = body.replace(CAW_POS_STATUS, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_POS_STATUS_DESCRIPTION, CawJSONConstant.NULL);
        body = body.replace(CAW_HAS_DEPOSIT, CawJSONConstant.NULL);
        body = body.replace(CAW_DEPOSIT_AMOUNT, CawJSONConstant.NULL);
        body = body.replace(CAW_TOTAL_TAX, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_SHIPPING, String.valueOf(CawJSONConstant.ZERO));
        body = body.replace(CAW_DESCRIPTION, CawJSONConstant.NULL);

        return body;

    }
    private String buildProperties() {
       CawRestConfig request = _restConfigHelper.getRestRequest("REQUEST_LOYALTY_PROPERTIES");
       String bodyReq = StringUtils.EMPTY;
       String fmtNull = CawJSONConstant.NULL;
       if(request != null && !StringUtils.isEmpty(request.getBody())) {
           bodyReq = request.getBody();

           bodyReq = bodyReq.replace("!{\"additionalProp1\"}", fmtNull );
           
           bodyReq = bodyReq.replace("!{\"additionalProp2\"}", fmtNull);
           
           bodyReq = bodyReq.replace("!{\"additionalProp3\"}", fmtNull);
       }
       return bodyReq;
   }

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
   public String formatParameter(String argString) {

       return argString != null ? "\"" + argString + "\"" : NULL_STRING;
   }
   //End BZ49894
   /*BEGIN BZ50121*/
   public IDiscount cloneDiscount(IDiscount discount) {
       if(discount != null) {
           IDiscount discountClone = DataFactory.createObject(discount.getObjectId(), IDiscount.class);
           discountClone.setDiscountCode(discount.getDiscountCode());
           discountClone.setEffectiveDatetime(discount.getEffectiveDatetime());
           discountClone.setTypeCode(discount.getTypeCode());
           discountClone.setApplicationMethodCode(discount.getApplicationMethodCode());
           discountClone.setDescription(discount.getDescription());
           discountClone.setCalculationMethodCode(discount.getCalculationMethodCode());
           discountClone.setPercent(discount.getPercent());
           discountClone.setPrivilegeType(discount.getPrivilegeType());
           discountClone.setAmount(discount.getAmount());
           return discountClone;
       }
       return discount;
   }
   /*END BZ50121*/
   
   //BEGIN BZ51770 
   public String saveLoyaltyInfoForOS(String submitOrderResponse, IPosTransaction iPosTransaction) {
       String result = "";
       try {
           CawRestConfig request = _restConfigHelper.getRestRequest(CawRestConfigHelper.LOYALTY_INFO_FOR_OS);
           String bodyReq = StringUtils.EMPTY;
           //check submit response if null or not. If null, replace null to pointEarnings and receiptSummary
           if (request != null && !StringUtils.isEmpty(request.getBody())
                   && submitOrderResponse != null && !submitOrderResponse.isEmpty()) {
               bodyReq = request.getBody();
               //PROMO_OFFER_REDEMPTIONS
               if (CawCatalystHelper.getOfferApplyLoyalty() == null || CawCatalystHelper.getOfferApplyLoyalty().isEmpty()) {
                   bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, EMPTY_ARRAY);
               } else {
                   bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, getOfferRedemptionsWithFullInfoArrTemplate(iPosTransaction));//BZ51771
               }

               JSONObject subOrdResJson = new JSONObject(submitOrderResponse);
               if (subOrdResJson.has(CawJSONConstant.JSON_RESPONSE_RESULT) && !subOrdResJson.isNull(CawJSONConstant.JSON_RESPONSE_RESULT)) {//BZ59669
                   subOrdResJson = subOrdResJson.getJSONObject(CawJSONConstant.JSON_RESPONSE_RESULT);
               }
               //BEGIN BZ63054
               if(subOrdResJson.has(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE) && !subOrdResJson.isNull(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE)) {
                   subOrdResJson = new JSONObject(subOrdResJson.getString(CawJSONConstant.JSON_LOYALTY_SUBMIT_ORDER_RESPONSE));
               }
               //END BZ63054
               //receiptSummary
               if(subOrdResJson.has(CawJSONConstant.JSON_SUBMIT_ORDER_RECEIPT_SUMMARY) 
                       && !subOrdResJson.isNull(CawJSONConstant.JSON_SUBMIT_ORDER_RECEIPT_SUMMARY)) {
                   bodyReq = bodyReq
                           .replace(CawJSONConstant.SUBMIT_ORDER_RECEIPT_SUMMARY_VALUE, subOrdResJson
                                   .getString(CawJSONConstant.JSON_SUBMIT_ORDER_RECEIPT_SUMMARY));
               } else {
                   bodyReq = bodyReq
                           .replace(CawJSONConstant.SUBMIT_ORDER_RECEIPT_SUMMARY_VALUE, CawJSONConstant.NULL);
               }
               //pointEarnings
               if (subOrdResJson.has(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS) 
                       && !subOrdResJson.isNull(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS)
                       && subOrdResJson.getJSONArray(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS).length() >= 0) {
                   bodyReq = bodyReq.replace(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS_VALUE, subOrdResJson
                           .getJSONArray(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS).toString());
               } else {
                   bodyReq = bodyReq
                           .replace(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS_VALUE, EMPTY_ARRAY);
               }
               //REWARD_REDEMPTION
               if (CawCatalystHelper.getRewardApplyLoyalty() == null) {
                   bodyReq = bodyReq.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE, CawJSONConstant.NULL);
               } else if(subOrdResJson.has(CawJSONConstant.JSON_REWARD_RESPONSE_CODE) && !subOrdResJson.isNull(CawJSONConstant.JSON_REWARD_RESPONSE_CODE)) {
                   bodyReq = bodyReq.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE, getRewardRedemptionsWithRewardResponseCodeArrTemplate(iPosTransaction, subOrdResJson
                           .getString(CawJSONConstant.JSON_REWARD_RESPONSE_CODE)));   
               } else {
                   bodyReq = bodyReq.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE, getRewardRedemptionsWithRewardResponseCodeArrTemplate(iPosTransaction, "0"));
               }
               
               
           } else if(request != null && !StringUtils.isEmpty(request.getBody())
                   && (submitOrderResponse == null || submitOrderResponse.isEmpty())){
               bodyReq = request.getBody();
               //PROMO_OFFER_REDEMPTIONS
               if (CawCatalystHelper.getOfferApplyLoyalty() == null || CawCatalystHelper.getOfferApplyLoyalty().isEmpty()) {
                   bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, EMPTY_ARRAY);
               } else {
                   bodyReq = bodyReq.replace(PROMO_OFFER_REDEMPTIONS, getOfferRedemptionsArrTemplate(iPosTransaction));
               }
               //receiptSummary
               bodyReq = bodyReq
                       .replace(CawJSONConstant.SUBMIT_ORDER_RECEIPT_SUMMARY_VALUE, CawJSONConstant.NULL);
               //pointEarnings
               bodyReq = bodyReq
                       .replace(CawJSONConstant.JSON_SUBMIT_POINT_EARNINGS_VALUE, EMPTY_ARRAY);
               //REWARD_REDEMPTION
               if (CawCatalystHelper.getRewardApplyLoyalty() == null) {
                   bodyReq = bodyReq.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE, CawJSONConstant.NULL);
               } else {
                   bodyReq = bodyReq.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE, getRewardRedemptionsWithRewardResponseCodeArrTemplate(iPosTransaction, "0"));
               }
           }
           result = bodyReq;
       } catch (Exception ex) {
           _logger.error("[Build json loyalty request and save to DB error]: " + ex);
       }
       _logger.debug("[Build json loyalty request and save to DB - saveLoyaltyInfoForOS()]: " + result);
       return result;
   }
   
   private CharSequence getRewardRedemptionsWithRewardResponseCodeArrTemplate(IPosTransaction iPosTransaction, String rewardResponseCode) {
       CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.REWARD_REDEMPTION_WITH_RESPONSE_CODE_TEMPLATE);
       String body = request.getBody();
       String result = "";
       try {
           body = body.replace(REWARD_CODE, CawCatalystHelper.getRewardApplyLoyalty().getRewardCode());
           body = body.replace(REWARD_REDEMPTION_WITH_RESPONSE_CODE_ATTR, rewardResponseCode);
           body = body.replace(EBS_COUPON_CODE, CawUtilFunction.formatParameter(CawCatalystHelper.getRewardApplyLoyalty().getEbsCouponCode())); //BZ52837
           body = body.replace(REWARD_POINTS_ALLOCATIONS, getPointRedeemedOnLineItemArrTemplate(iPosTransaction));
           result = body;
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       
       return result;
   }
   //END BZ51770
   //BEGIN BZ51771
   private String getOfferRedemptionsWithFullInfoArrTemplate(IPosTransaction iPosTransaction)  {

       CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.PROMO_OFFER_REDEMPTIONS_FULL_INFO);
       String body = request.getBody();
       StringBuilder resultBuilder = new StringBuilder();
       String result = "";
       String temp = null;
       if (iPosTransaction != null) {
           List<CawPromotionModel> offersApplied = CawCatalystHelper.getOfferApplyLoyalty();
           for (CawPromotionModel offer : offersApplied) {
                   temp = String.valueOf(body);
                   if(offer.getOfferResponseCode() != null && !offer.getOfferResponseCode().isEmpty()) {
                       temp = temp.replace(OFFER_RESPONSE_CODE, offer.getOfferResponseCode()); 
                   }
                   if(offer.getEbsCouponCode() != null && !offer.getEbsCouponCode().isEmpty()) {
                       temp = temp.replace(EBS_COUPON_CODE, CawUtilFunction.formatParameter(offer.getEbsCouponCode())); //BZ52041
                   }
                   else {
                       temp = temp.replace(EBS_COUPON_CODE, CawJSONConstant.NULL); 
                   }
                   
                   if(offer.getPromoCode() != null && !offer.getPromoCode().isEmpty()) {
                       temp = temp.replace(OFFER_CODE, offer.getPromoCode()); 
                   }
                   else {
                       temp = temp.replace(OFFER_CODE, CawJSONConstant.NULL); 
                   }
                   
                   if(offer.getPromoCodeLabel() != null && !offer.getPromoCodeLabel().isEmpty()) {
                       temp = temp.replace(OFFER_RESPONSE_CODE, offer.getOfferResponseCode()); 
                   }
                   else {
                       temp = temp.replace(OFFER_RESPONSE_CODE, CawJSONConstant.NULL); 
                   }
                   
                   if(offer.getExpirationString() != null && !offer.getExpirationString().isEmpty()) {
                       temp = temp.replace(OFFER_EXPIRATION, CawUtilFunction.formatParameter(offer.getExpirationString())); 
                   }
                   else {
                       temp = temp.replace(OFFER_EXPIRATION, CawJSONConstant.NULL); 
                   }
                   
                   if(offer.getPromoCodeLabel() != null && !offer.getPromoCodeLabel().isEmpty()) {
                       temp = temp.replace(OFFER_LABEL, CawUtilFunction.formatParameter(offer.getPromoCodeLabel())); 
                   }
                   else {
                       temp = temp.replace(OFFER_LABEL, CawJSONConstant.NULL); 
                   }
                   
                   if(offer.getPromoOfferClaimAllocations() != null && !offer.getPromoOfferClaimAllocations().toString().isEmpty()) {
                       temp = temp.replace(PROMO_OFFER_CLAIM_ADJUSTMENTS, offer.getPromoOfferClaimAllocations().toString()); 
                   }
                   else {
                       temp = temp.replace(PROMO_OFFER_CLAIM_ADJUSTMENTS, EMPTY_ARRAY); 
                   }
                   
                   resultBuilder.append(temp);
                   resultBuilder.append(",");
           }
           if (resultBuilder.length() > 0) {
               result = SQUARE_BRACKETS_OPEN
                       + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                       + SQUARE_BRACKETS_CLOSE;
           }
       }
       return result;
   }
   //END BZ51771
   
   /* BEGIN BZ53752 */
   /**
    * @param requestModel
    * @param bodyReq
    * @return
    */
   private String buildWorkOrderDetailAttr(CawCheetahSubmitRequestModel requestModel) {
       String workOrderDetailStr = CawJSONConstant.NULL;
       if (requestModel != null && requestModel.getWorkOrderDetail() != null) {
           JSONObject workOrderDetailsJson = new JSONObject();
           try {
               workOrderDetailsJson.put(ID, requestModel.getWorkOrderDetail().getWorkOrderId());
               workOrderDetailsJson.put(POS_STATUS, requestModel.getWorkOrderDetail().getPosStatus());
               workOrderDetailStr = workOrderDetailsJson.toString();
           } catch (JSONException ex) {
               _logger.error("Can not build workOrderDetail attribute:" +  ex.getMessage());
           }
       } 
       
       return workOrderDetailStr;
   }
   public static String purchaseOrderTemplate(IPosTransaction iPosTransaction) {

       String PO = StringUtils.EMPTY; 
       List<IRetailTransactionLineItem> tenderLines =  iPosTransaction.getTenderLineItems();
       for (IRetailTransactionLineItem tenderLine : tenderLines) {
           if (tenderLine instanceof IAccountReceivableTenderLineItem) {
               IAccountReceivableTenderLineItem aRTenderLineItem = (IAccountReceivableTenderLineItem) tenderLine;
               return aRTenderLineItem.getPoNumber() != null ? aRTenderLineItem.getPoNumber() : PO;
           }
       }
       return PO;
   }
   
   private String buildTenderAttribute(IPosTransaction iPosTransaction,StationState stationState, CawWorkOrderEBSQueryResult argWorkOrderResult) {

       String body = null;
       String tmpStr = null;
       StringBuilder tenderStr = new StringBuilder();
       CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawRestConfigHelper.CAW_REQUEST_CHEETAH_TENDER_ATTR);
       if (request != null && request.getBody() != null) {
           List<CawCheetahTenderModel> tenderModels = getTenderLineModel(iPosTransaction, stationState, argWorkOrderResult);
           if (tenderModels != null && tenderModels.size() > 0) {
               for (CawCheetahTenderModel model : tenderModels) {
                   tmpStr = request.getBody();
                   tmpStr = tmpStr.replace(CAW_CORRELATION_KEY, CawUtilFunction.formatParameter(model.getCorrelationKey()));
                   
                   if (model.getType() != null) {
                       tmpStr = tmpStr.replace(CAW_TYPE, model.getType());
                   } else {
                       tmpStr = tmpStr.replace(CAW_TYPE, CawJSONConstant.NULL);
                   }
                   
                   tmpStr = tmpStr.replace(CAW_CODE, CawUtilFunction.formatParameter(model.getCode()));
                    
                   if (model.getAmount() != null) {
                       tmpStr = tmpStr.replace(TENDER_AMOUNT, String.valueOf(model.getAmount()));
                   } else {
                       tmpStr = tmpStr.replace(TENDER_AMOUNT, CawJSONConstant.NULL);
                   }
                   
                   tmpStr = tmpStr.replace(TENDER_AUTHORIZATION, CawUtilFunction.formatParameter(model.getAuthorization()));
                   tmpStr = tmpStr.replace(TENDER_TOKEN, CawUtilFunction.formatParameter(model.getToken()));
                   tmpStr = tmpStr.replace(TENDER_CARD_NUMBER_MASKED, CawUtilFunction.formatParameter(model.getCardNumberMasked()));
                   tmpStr = tmpStr.replace(TENDER_CARDHOLDER, CawUtilFunction.formatParameter(model.getCardholder()));
                   tmpStr = tmpStr.replace(TENDER_EXPIRE_DATE, CawUtilFunction.formatParameter(model.getExpireDate()));
                   tenderStr.append(tmpStr);
                   tenderStr.append(",");
               }
           }
       }
       
       if (tenderStr.length() > 0) {
           body = "["+ tenderStr.substring(0, tenderStr.length() - 1) +"]";
       }

       return body;
   }
  
   private List<CawCheetahTenderModel> getTenderLineModel(IPosTransaction iPosTransaction
           , StationState stationState, CawWorkOrderEBSQueryResult argWorkOrderResult) {

       List<CawCheetahTenderModel> tenderModel = new ArrayList<CawCheetahTenderModel>();
       if (iPosTransaction != null && stationState != null) {
           if (iPosTransaction.getTenderLineItems() != null
                   && iPosTransaction.getTenderLineItems().size() > 0) {
               String correlationKey = getCorrelationKey(iPosTransaction, stationState);
               List<IRetailTransactionLineItem> tenderLines = iPosTransaction.getTenderLineItems();
               ITenderLineItem tender = null;
               CawCheetahTenderModel cawTenderModel = null;
               if (!TENDER_EXCHANGE.equalsIgnoreCase(iPosTransaction.getTransactionTypeCode())) {
                   int countLine = 1;
                   
                   //Begin BZ54290
                   for (IRetailTransactionLineItem tenderLine : tenderLines) {
                       tender = (ITenderLineItem) tenderLine;
                       if (TENDER_ACCOUNT_CREDIT.equalsIgnoreCase(tender.getTenderId()) && !tenderLine.getVoid()) {
                           countLine ++;
                           break;
                       }
                   }
                   //End BZ54290
                   
                   for (IRetailTransactionLineItem tenderLine : tenderLines) {
                       try {
                           if (!tenderLine.getVoid()) {
                               tender = (ITenderLineItem) tenderLine;
                               if (!TENDER_ACCOUNT_CREDIT.equalsIgnoreCase(tender.getTenderId())  && !CAW_STATUS_CHANGE.equalsIgnoreCase(tender.getTenderStatusCode())) { //BZ BZ54290
                                   cawTenderModel = new CawCheetahTenderModel();
                                   cawTenderModel.setCorrelationKey(correlationKey + ":" +countLine);
                                   countLine ++;
                                   cawTenderModel.setAmount(tender.getAmount());
           
                                   if (tender.getTender() != null) {
                                       List<ITenderProperty> tenderProperties = tender.getTender().getProperties();
                                       if (tenderProperties != null && tenderProperties.size() > 0) {
                                           for (ITenderProperty tenderProperty : tenderProperties) {
                                               if (TENDER_MAPING_TYPE.equalsIgnoreCase(tenderProperty.getPropertyCode())
                                                       && tenderProperty.getPropertyValue() != null) {
                                                   cawTenderModel.setType(tenderProperty.getPropertyValue().toString());
                                               }
                                               
                                               if (TENDER_MAPING_CODE.equalsIgnoreCase(tenderProperty.getPropertyCode())
                                                       && tenderProperty.getPropertyValue() != null) {
                                                   cawTenderModel.setCode(tenderProperty.getPropertyValue().toString());
                                               }
                                           }
                                       }
                                   }
                                   
                                   if (tenderLine instanceof IAuthorizableLineItem) {
                                       IAuthorizableLineItem authTender = (IAuthorizableLineItem) tenderLine;
                                       if (authTender.getAuthorizationCode() != null) {
                                           if (!(tenderLine instanceof VoucherTenderLineItemModel)) {
                                               cawTenderModel.setAuthorization(DtvDecrypter.getInstance("ccenc").decryptIfEncrypted(authTender.getAuthorizationCode()));
                                           }
                                       }
                                       
                                       if (authTender.getTransactionReferenceData() != null) {
                                           cawTenderModel.setToken(DtvDecrypter.getInstance("ccenc").decryptIfEncrypted(authTender.getTransactionReferenceData()));
                                       }
                                   }
                                   
                                   if (tenderLine instanceof CreditDebitTenderLineItemModel) {
                                       CreditDebitTenderLineItemModel debitTenderLineItemModel = (CreditDebitTenderLineItemModel) tenderLine;
                                       if (debitTenderLineItemModel.getAccountNumber() != null) {
                                           cawTenderModel.setCardNumberMasked(maskField(debitTenderLineItemModel.getAccountNumber()));
                                       }
                                       
                                       if (debitTenderLineItemModel.getCustomerName() != null) {
                                           cawTenderModel.setCardholder(StringEscapeUtils.escapeJson(debitTenderLineItemModel.getCustomerName()));
                                       }
                                       
                                       if (debitTenderLineItemModel.getExpirationDateString() != null) {
                                           cawTenderModel.setExpireDate(debitTenderLineItemModel.getExpirationDateString());
                                       }
                                   }
                                   
                                   tenderModel.add(cawTenderModel);
                               }
                           }
                       } catch (Exception ex) {
                           _logger.error("[Error when build TenderModel model for submit request: ]" + ex.getMessage());
                       }
                   }
               }
           }
       }

       if (tenderModel.size() > 0 && iPosTransaction!= null) {
           List<CawCheetahTenderModel> listTenderWODeposit = getOriginalTenderOfWorkOrderDeposit(argWorkOrderResult);//BZ54290
           BigDecimal totalTenderWODeposit = BigDecimal.ZERO;
           if (listTenderWODeposit != null) {
               for (CawCheetahTenderModel tenderWODeposit : listTenderWODeposit) {
                   totalTenderWODeposit = totalTenderWODeposit.add(tenderWODeposit.getAmount());
               }
           }
           
           if (tenderModel.size() > 0 || listTenderWODeposit != null) { //BZ54290
               if (tenderModel.size() > 0) {
                   BigDecimal transactionTotal = iPosTransaction.getTotal();
                   BigDecimal tenderedTotal = totalTenderWODeposit;
                   for (CawCheetahTenderModel cheetahTenderModel : tenderModel) {
                       if (cheetahTenderModel.getAmount() != null) {
                           tenderedTotal = tenderedTotal.add(cheetahTenderModel.getAmount());
                       }
                   }

                   if (transactionTotal.compareTo(tenderedTotal) == -1) {
                       BigDecimal changeDue = tenderedTotal.subtract(transactionTotal);
                       tenderModel.get(tenderModel.size()-1).setAmount(tenderModel.get(tenderModel.size() -1).getAmount().subtract(changeDue));
                   }
               }

               //Begin BZ54290
               if (listTenderWODeposit != null) {
                   for (CawCheetahTenderModel tenderWODeposit : listTenderWODeposit) {
                       tenderModel.add(tenderWODeposit);
                   }
               }
               //End BZ54290

               return tenderModel;
           }
       }

      return null;
   }
   
   //Begin BZ54290
   protected List<CawCheetahTenderModel> getOriginalTenderOfWorkOrderDeposit(CawWorkOrderEBSQueryResult workOrderResult) {

       List<CawCheetahTenderModel> tenderModel = new ArrayList<CawCheetahTenderModel>();
       
       if (workOrderResult != null && workOrderResult.getPopulatedObject() != null
                   && workOrderResult.getPopulatedObject() instanceof WorkOrderAccountModel) {
           WorkOrderAccountModel accountModel = (WorkOrderAccountModel) workOrderResult.getPopulatedObject();
           List<ICustomerItemAccountDetail> accountDetails = accountModel.getCustItemAccountDetails();
           int countLine = 1;
           
           if (accountDetails != null && accountDetails.size() > 0) {
               for (ICustomerItemAccountDetail detail : accountDetails) {
                   if (CAW_DEPOSIT.equalsIgnoreCase(detail.getTypeCode())) {
                       long location = detail.getRetailLocationId();
                       Date bussinees = detail.getBusinessDate();
                       long workstation = detail.getWorkstationId();
                       long trans = detail.getTransactionSequence();

                       DateFormat df = new SimpleDateFormat("yyyyMMdd");
                       Date bsnDate = bussinees;
                       String storeID = String.format("%4s", location).replace(' ', '0');
                       String regID = String.format("%2s", workstation).replace(' ', '0');
                       String transSeq = String.format("%4s", trans).replace(' ', '0');
                       String correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq;

                       IPosTransaction iPosTransaction = TransactionHelper.searchTransaction(bussinees, trans, workstation, location);
                       if (iPosTransaction != null && iPosTransaction.getTenderLineItems() != null) {
                           List<IRetailTransactionLineItem> tenderLineItemModels = iPosTransaction.getTenderLineItems();
                           if (tenderLineItemModels != null && tenderLineItemModels.size() > 0) {

                               CawCheetahTenderModel cawTenderModel = null;
                               
                               for (IRetailTransactionLineItem tenderLine : tenderLineItemModels) {
                                   if (tenderLine instanceof TenderLineItemModel && !tenderLine.getVoid()) {
                                       
                                       TenderLineItemModel tender = (TenderLineItemModel) tenderLine;
                                       if (!CAW_STATUS_CHANGE.equalsIgnoreCase(tender.getTenderStatusCode())) {
                                           cawTenderModel = new CawCheetahTenderModel();
                                           cawTenderModel.setCorrelationKey(correlationKey + ":" + countLine);
                                           
                                           countLine ++;
                                           cawTenderModel.setAmount(tender.getAmount());
                                           
                                           if (tender.getTender() != null) {
                                               List<ITenderProperty> tenderProperties = tender.getTender().getProperties();
                                               if (tenderProperties != null && tenderProperties.size() > 0) {
                                                   for (ITenderProperty tenderProperty : tenderProperties) {
                                                       if (TENDER_MAPING_TYPE.equalsIgnoreCase(tenderProperty.getPropertyCode())
                                                               && tenderProperty.getPropertyValue() != null) {
                                                           cawTenderModel.setType(tenderProperty.getPropertyValue().toString());
                                                       }
                                                       
                                                       if (TENDER_MAPING_CODE.equalsIgnoreCase(tenderProperty.getPropertyCode())
                                                               && tenderProperty.getPropertyValue() != null) {
                                                           cawTenderModel.setCode(tenderProperty.getPropertyValue().toString());
                                                       }
                                                   }
                                               }
                                           }
                                           
                                           if (tenderLine instanceof IAuthorizableLineItem) {
                                               IAuthorizableLineItem authTender = (IAuthorizableLineItem) tenderLine;
                                               if (authTender.getAuthorizationCode() != null) {
                                                   if (!(tenderLine instanceof VoucherTenderLineItemModel)) {
                                                       cawTenderModel.setAuthorization(DtvDecrypter.getInstance("ccenc").decryptIfEncrypted(authTender.getAuthorizationCode()));
                                                   }
                                               }
                                               
                                               if (authTender.getTransactionReferenceData() != null) {
                                                   cawTenderModel.setToken(DtvDecrypter.getInstance("ccenc").decryptIfEncrypted(authTender.getTransactionReferenceData()));
                                               }
                                           }
                                           
                                           if (tenderLine instanceof CreditDebitTenderLineItemModel) {
                                               CreditDebitTenderLineItemModel debitTenderLineItemModel = (CreditDebitTenderLineItemModel) tenderLine;
                                               if (debitTenderLineItemModel.getAccountNumber() != null) {
                                                   cawTenderModel.setCardNumberMasked(maskField(debitTenderLineItemModel.getAccountNumber()));
                                               }
                                               
                                               if (debitTenderLineItemModel.getCustomerName() != null) {
                                                   cawTenderModel.setCardholder(StringEscapeUtils.escapeJson(debitTenderLineItemModel.getCustomerName()));
                                               }
                                               
                                               if (debitTenderLineItemModel.getExpirationDateString() != null) {
                                                   cawTenderModel.setExpireDate(debitTenderLineItemModel.getExpirationDateString());
                                               }
                                           }
                                           tenderModel.add(cawTenderModel);
                                       }
                                   }
                               }
                           }
                       }
                       
                       if (tenderModel.size() > 0 && iPosTransaction!= null) {
                           BigDecimal transactionTotal = detail.getExtendedAmount();
                           BigDecimal tenderedTotal = BigDecimal.ZERO;
                           for (CawCheetahTenderModel cheetahTenderModel : tenderModel) {
                               if (cheetahTenderModel.getAmount() != null) {
                                   tenderedTotal = tenderedTotal.add(cheetahTenderModel.getAmount());
                               }
                           }

                           if (transactionTotal.compareTo(tenderedTotal) == -1) {
                               BigDecimal changeDue = tenderedTotal.subtract(transactionTotal);
                               tenderModel.get(tenderModel.size()-1).setAmount(tenderModel.get(tenderModel.size() -1).getAmount().subtract(changeDue));
                           }
                           return tenderModel;
                       }
                   }
               }
           }
       }
       
       return null;
    }
    //End BZ54290
    protected static String maskField(String accountNumber) {

        if ((accountNumber == null) || (accountNumber.isEmpty())
                || (accountNumber.length() < 4)) {
            return null;
        }
        return mask(accountNumber.substring(0, accountNumber.length() - 4))
                .concat(accountNumber.substring(accountNumber.length() - 4));
    }

    protected static String mask(Object o) {

        String result;
        if ((o instanceof IFormattable)) {
            result = ((IFormattable) o)
                    .toString(dtv.i18n.OutputContextType.LOG);
        } else {
            if (o == null) {
                return CawJSONConstant.NULL;
            }

            result = String.valueOf(o);
        }

        return StringUtils.fill("*", result.length());
    }
    

    public String getAttributeSubmitReq(IPosTransaction argIPosTransaction,
            IParty argParty) {
        
        BigDecimal saveAmt = new CawTotalAmountSavedWorker((IRetailTransaction) argIPosTransaction).call();
        BigDecimal couldSaveAmt = new CawTotalAmountCouldSavedWorker((IRetailTransaction) argIPosTransaction).call();
        boolean isClubGroup = CawCustomerUtil.isClubOnlyCustomer(argParty);
        JSONObject attributeJson = new JSONObject();
        try {
            if (isClubGroup) {
                if (saveAmt.compareTo(BigDecimal.ZERO) >= 0) {
                    attributeJson.put(CAW_GOODSAM_SAVINGS_KEY, saveAmt.toString());
                } else {
                    attributeJson.put(CAW_GOODSAM_SAVINGS_KEY, CawConstants.VALUE_00);
                }
                attributeJson.put(CAW_COULD_SAVE_KEY, CawConstants.VALUE_00);
            } else {
                if (couldSaveAmt.compareTo(BigDecimal.ZERO) >= 0) {
                    attributeJson.put(CAW_COULD_SAVE_KEY, couldSaveAmt.toString());
                } else {
                    attributeJson.put(CAW_COULD_SAVE_KEY, CawConstants.VALUE_00);
                }
                attributeJson.put(CAW_GOODSAM_SAVINGS_KEY, CawConstants.VALUE_00);
            }
            return attributeJson.toString();
        } catch (Exception ex) {
            return StringUtils.EMPTY;
        }
    }
    /* END BZ53752 */

    /* BEGIN BZ54776 */
    /**
     * The method check codes exist in a configuration CAW_LOYALTY_ENABLE in the COM_CODE_VALUE table.
     * @return TRUE if loyalty is enabling otherwise return FALSE.
     */
    public static boolean isEnableLoyalty() {

        boolean isEnable = false;
        try {
            List<String> codes = CodeLocator.getCodes(ConfigurationMgr
                    .getOrganizationId(), CawEBSConstant.CAW_LOYALTY_ENABLE);
            if (codes != null && codes.size() > 0) {
                String isLoyalty = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), CawEBSConstant.CAW_LOYALTY_ENABLE).get(0);
                if (Boolean.valueOf(isLoyalty)) {
                    isEnable = true;
                }
            }

        } catch (Exception ex) {
            _logger.error("[Cannot get CAW_LOYALTY_ENABLE code from DB: " + ex);
        }

        return isEnable;
    }
    /* END BZ54776 */
    
    /* BEGIN BZ55978 */
    public void savePropertyExceedMaxLength(IPosTransaction tran,
            String propertyName, String propertyValue, String type) {

        try {
            PosTransactionPropertyId id = new PosTransactionPropertyId();
            id.setOrganizationId(ConfigurationMgr.getOrganizationId());
            id.setRetailLocationId(tran.getRetailLocationId());
            id.setBusinessDate(tran.getBusinessDate());
            id.setWorkstationId(tran.getWorkstationId());
            id.setTransactionSequence(tran.getTransactionSequence());
            id.setPropertyCode(propertyName);

            if (propertyValue.length() <= CawConstants.TRANSACTION_PROPERTY_MAX_LENGTH) {
                IPosTransactionProperty transProperty = DataFactory.createObject(id, IPosTransactionProperty.class);
                id.setPropertyCode(propertyName + "_" + 0);
                transProperty.setObjectId(id);
                transProperty.setType(type);
                transProperty.setStringValue(propertyValue);
                tran.addPosTransactionProperty(transProperty);
                _logger.debug("[SavePropertyExceedMaxLength]: " + id.getPropertyCode());//update correct log display
            } else {
                String str = propertyValue;
                String line;
                int maxCharline = CawConstants.TRANSACTION_PROPERTY_MAX_LENGTH;
                ArrayList<String> arr = new ArrayList<>();
                while (str.length() >= maxCharline) {
                    line = str.substring(0, maxCharline);
                    arr.add(line);
                    str = str.substring(maxCharline);
                }
                
                if (str.length() > 0) {
                    arr.add(str);
                }
                
                for (int i = 0; i < arr.size(); i++) {
                    IPosTransactionProperty transProperty = DataFactory.createObject(id, IPosTransactionProperty.class);
                    transProperty.setType(type);
                    id.setPropertyCode(propertyName + "_" + i);
                    transProperty.setObjectId(id);
                    transProperty.setStringValue(arr.get(i));
                    tran.addPosTransactionProperty(transProperty);
                    _logger.debug("[SavePropertyExceedMaxLength]: " + id.getPropertyCode());//update correct log display
                }
            }
        } catch (Exception ex) {
            _logger.error("[Cannot save transaction property " + propertyName + " into DB: " + ex);
        }
    }
    /* END BZ55978 */
    
    //BEGIN BZ54290
    public IPartyProperty addCustomerLoyaltyProperty(JSONObject responseData, IParty party) {
        IPartyProperty isLoyaltyCustomer = null;
        try {
            
            isLoyaltyCustomer = DataFactory.createObject(IPartyProperty.class);
            isLoyaltyCustomer.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
            isLoyaltyCustomer.setPartyId(party.getPartyId());
            isLoyaltyCustomer.setPropertyCode("IS_LOYALTY_CUSTOMER");
            isLoyaltyCustomer.setType(CawConstants.PROP_STRING_TYPE);
            isLoyaltyCustomer.setStringValue("TRUE");
        } catch (Exception ex) {
            _logger.error("Method addCustomerLoyaltyProperty can not create IPartyProperty object:" + ex.getMessage());
        }
        return isLoyaltyCustomer;
    }
    
    public boolean checkIsLoyaltyCustomer(String argJsonMessage) {
        try {
            if (!StringUtils.isEmpty(argJsonMessage) && argJsonMessage.length() > 0) {
                JSONObject req = new JSONObject(argJsonMessage);
                if((req.has(CawJSONConstant.JSON_STATUS) && !req.isNull(CawJSONConstant.JSON_STATUS))
                        || (req.has(CawJSONConstant.JSON_PROMOS) && !req.isNull(CawJSONConstant.JSON_PROMOS))) {
                    return true;
                }
            }
        } catch (Exception ex) {
            _logger.error("Error happened in method checkIsLoyaltyCustomer: " + ex.getMessage());
        }
        return false;
    }
    //END BZ54290
}
