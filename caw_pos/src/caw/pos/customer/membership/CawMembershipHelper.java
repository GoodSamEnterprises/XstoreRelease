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
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27851              121018    [Internal][27339] Membership info is empty at Account tab when select&View customer has membership info.
 * BZ26893              291018    [New Requirement] - Xstore Transaction Receipt Changes
 * BZ48564              120422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 * BZ49628 -            250422    [Internal] - Expires date for non-point promotions is showing incorrectly at Customer Maintenance.
 * BZ49801              040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ49497              060522    [Internal] Customer Loyalty Banner is displaying incorrectly when customer assigned is non-membership.
 * BZ57844              040823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58779              110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 * BZ62218              150324    [Internal] Point balance and redeemable value must be in the same row as membership in Account Tab
 * BZ69515              120225    Display Good Sam Visa Cardholder indicator Icon
 *===================================================================
 */

package caw.pos.customer.membership;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerConstants;
import caw.pos.customer.CawCustomerPartyIdXrefQueryResult;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.cat.IAwardAccountCoupon;
import dtv.xst.dao.com.*;
import dtv.xst.dao.crm.IParty;

/**
 * The CawMembershipHelper class
 */
public class CawMembershipHelper {

    private static final Logger             _logger  = LogManager
            .getLogger(CawMembershipHelper.class);

    private static CawMembershipHelper      instance = null;

    private String                          membershipImage;
    
    //Start BZ48564
    
    private final String L_PROMOCODEID                  = "offerCode"; //BZ49801
    private final String L_PROMOMETRICVALUE             = "offerMetricValue";//BZ49801
    private final String L_EXPIRATION                   = "offerExpiration";//BZ49801
    private final String L_PROMOCODELABEL               = "offerLabel";//BZ49801
    private final String L_PROMOMETRICNAME              = "promoMetricName";
    private final String L_DESCRIPTION                  = "description";
    private final String L_PERCENTORDOLLAR              = "percentOrDollar";
    private final String L_TYPE                         = "type";
    private final String L_REWARDID                     = "rewardId";
    private final String L_REWARDMAXREDEEMABLEVALUE     = "rewardMaxRedeemableValue";
    private final String L_REWARDLABEL                  = "rewardLabel";
    private final String L_PROMOS                       = "promos";
    private final String L_EXPIRATION_FORMAT            = "yyyy-MM-dd'T'HH:mm:ss"; //BZ49628
    private final String L_STATUS                       = "status";
    //BEGIN BZ69515
    private final String JSON_CARDHOLDER                = "cardholder";
    private final String JSON_ISACTIVE                  = "isActive";
    private final String GS_VISA_ICON_ENABLED   = "GS_VISA_ICON_ENABLED";
    //End BZ48564, BZ69515

    /**
     * The Memberships of current customer
     */
    private List<CawCustomerMembershipView> memberships;

    /**
     * @return
     */
    public static CawMembershipHelper getInstance() {

        if (instance == null) {
            synchronized (CawMembershipHelper.class) {
                if (instance == null) {
                    instance = new CawMembershipHelper();
                }
            }
        }
        return instance;
    }

    private CawMembershipHelper() {

        reset();
    }

    public boolean isMembershipsExisted() {

        return getMemberships() != null && getMemberships().size() > 0;
    }

    /**
     * @return the memberships
     */
    public List<CawCustomerMembershipView> getMemberships() {
        return memberships;
    }

    /**
     * @param argMemberships the memberships to set
     */
    public void setMemberships(List<CawCustomerMembershipView> argMemberships) {
        memberships = argMemberships;
    }

    /**
     * @return the membershipImage
     */
    public String getMembershipImage() {
        return membershipImage;
    }

    /**
     * @param argMembershipImage the membershipImage to set
     */
    public void setMembershipImage(String argMembershipImage) {
        membershipImage = argMembershipImage;
    }

    /**
     * Reset static variables for membership
     * 
     */
    public void reset() {

        memberships = null;
        membershipImage = null;
    }

    /**
     * Get url for Customer Group Logo
     * @param imageCategory
     * @param imageCategory
     * @param imageCode
     * @return
     */
    public String getMembershipImageUrl(long imageOrganizationId,
            String imageCategory, String imageCode) {

        String url = null;
        ICodeValue value = null;
        CodeValueId id = new CodeValueId();
        id.setOrganizationId(Long.valueOf(imageOrganizationId));
        id.setCategory(imageCategory);
        id.setCode(imageCode);
        try {
            value = (ICodeValue) DataFactory.getObjectById(id);
            if (value != null) {
                url = value.getImageUrl();
            }
        } catch (Exception e) {
            _logger.warn("Could not find Customer Group [" + id.getCode() + "]"
                    + e.getMessage());
        }
        return url;
    }

    /**
     * @param jsonMessage
     * @return
     */
    private List<CawCustomerMembershipView> parseCustomerMemberships(
            String jsonCustomerResponse) {

        JSONArray memberShips = null;
        //BEGIN BZ48564
        JSONObject loyaltyJsonObject = null;
        
        JSONObject status = null;
        
        JSONObject reward = null;
        
        String pointsBalance = null;
        String redeemableValue = null;

        boolean flag = false;
        List<IAwardAccountCoupon> listCoupons = new ArrayList<>();//BZ48564

        //END BZ48564
        JSONArray coupons = null;//BZ48564

        List<CawCustomerMembershipView> customerMSViews = new ArrayList<>();

        CawCustomerMembershipView cusMem = null;

        try {
            // BZ27851 start
            if (jsonCustomerResponse != null
                    && jsonCustomerResponse.length() > 0) {

                JSONObject req = CawJSONUtils
                        .toJSONObject(jsonCustomerResponse);
                
                if(!req.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                memberShips = CawJSONUtils
                        .getJSONArray(req, CawJSONConstant.JSON_MEMBERSHIPS);
                }
                //BEGIN BZ48564
                loyaltyJsonObject = CawJSONUtils.toJSONObject(CawCatalystHelper.getLookupLoyaltyResponseData());
                if(loyaltyJsonObject != null) {
                    
                    //Handle customer has membership type other 1 and loyalty attribute is null
                    if (loyaltyJsonObject.has(L_STATUS) && !loyaltyJsonObject.isNull(L_STATUS)) {
                        status = CawJSONUtils.getJSONObject(loyaltyJsonObject, CawJSONConstant.JSON_STATUS);
                        if (status.has(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE) && !status.isNull(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE)) {
                            pointsBalance = status.getString(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE);
                        }
                        if (status.has(CawJSONConstant.REDEEMABLE_AMOUNT) && !status.isNull(CawJSONConstant.REDEEMABLE_AMOUNT)) {
                            redeemableValue = status.getString(CawJSONConstant.REDEEMABLE_AMOUNT);
                        }
                    }
                    
                    
                    //handle set promos list to coupons
                    if(loyaltyJsonObject.has(L_PROMOS)&&!loyaltyJsonObject.isNull(L_PROMOS)) {
                        coupons = CawJSONUtils.getJSONArray(loyaltyJsonObject, L_PROMOS);
                        if(coupons != null && coupons.length() > 0) {
                            for (int iCoupon = 0; iCoupon < coupons.length(); iCoupon++) {
                                IAwardAccountCoupon coupon = DataFactory.createObject(IAwardAccountCoupon.class);

                                JSONObject record =  new JSONObject();
                                
                                if (coupons.get(iCoupon) instanceof JSONObject) {
                                    record = (JSONObject) coupons.get(iCoupon);
                                    
                                    if (record != null) {
                                        if(record.has(L_PROMOCODEID) && !record.isNull(L_PROMOCODEID)) {
                                            coupon.setCouponId(record.getString(L_PROMOCODEID));
                                        }
                                        if(record.has(L_PROMOMETRICVALUE) && !record.isNull(L_PROMOMETRICVALUE)) {
                                            coupon.setAmount(new BigDecimal(record.getString(L_PROMOMETRICVALUE)));
                                        }
                                        if(record.has(L_EXPIRATION) && !record.isNull(L_EXPIRATION)) {
                                            coupon.setExpirationDate(CawUtilFunction.formatDate(record.getString(L_EXPIRATION),L_EXPIRATION_FORMAT)); //BZ49628
                                        }
                                        if(record.has(L_PROMOCODELABEL) && !record.isNull(L_PROMOCODELABEL)) {
                                            coupon.setStringProperty(L_DESCRIPTION, record.getString(L_PROMOCODELABEL));
                                        }
                                        if(record.has(L_PROMOMETRICNAME) && !record.isNull(L_PROMOMETRICNAME)) {
                                            coupon.setStringProperty(L_PERCENTORDOLLAR, record.getString(L_PROMOMETRICNAME));
                                        }
                                        
                                        if (memberShips != null && memberShips.length() > 0) {
                                        String identifier = "";
                                        int len = memberShips.length();
                                        for (int i = 0; i < len; i++) {
                                            JSONObject jsonObject = (JSONObject) memberShips.get(i);
                                            if (jsonObject != null ) {
                                                if(jsonObject.has(L_TYPE)&&!jsonObject.isNull(L_TYPE)) {
                                                    String typeM = jsonObject.getString(L_TYPE);
                                                    if(typeM.equals("1") && !jsonObject.isNull(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR)) {
                                                        identifier = jsonObject.getString(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR);
                                                        coupon.setCardNumber(identifier);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        }
                                    }
                                    listCoupons.add(coupon);
                                }
                            }
                        }
                    }
                }
                //END BZ48564

                if (memberShips != null && memberShips.length() > 0) {

                    String typeDescription = "";

                    JSONObject jsonObject = null;

                    String identifier = "";

                    String benefitLevelName = "";

                    String statusDescription = "";

                    boolean isAutoRenew = false;

                    String expireDate = "";
                    
                    //BEGIN BZ57844                 
                    int daysExpired = 0;

                    String memberType = "";
                    //END BZ57844
                    
                    int len = memberShips.length();

                    for (int i = 0; i < len; i++) {

                        cusMem = new CawCustomerMembershipView();
                        
                        jsonObject = (JSONObject) memberShips.get(i);

                        if (jsonObject != null) {
                            typeDescription = jsonObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_TYPE_DESCRIPTION_ATTR);
                            identifier = jsonObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_IDENTIFIER_ATTR);
                            benefitLevelName = jsonObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR);
                            statusDescription = jsonObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_STATUS_DESCRIPTION_ATTR);
                            isAutoRenew = jsonObject
                                    .getBoolean(CawEBSConstant.MEMBERSHIPS_IS_AUTO_RENEW_ATTR);
                            expireDate = jsonObject
                                    .getString(CawEBSConstant.MEMBERSHIPS_EXPIRE_DATE_ATTR);
                            
                            // BEGIN BZ57844
                            // BEGIN BZ58779
                            if(jsonObject.has(CawEBSConstant.MEMBERSHIPS_DAYS_EXPIRED)) {
                                daysExpired = jsonObject
                                        .getInt(CawEBSConstant.MEMBERSHIPS_DAYS_EXPIRED);                              
                            }
                            // END BZ58779
                            memberType = jsonObject.getString(CawEBSConstant.MEMBERSHIPS_TYPE);
                            // END BZ57844
                            
                            //BEGIN BZ48564
                            boolean enable = true;
                            if(enable) {
                                String type = "0";
                                if(jsonObject.has(L_TYPE)&&!jsonObject.isNull(L_TYPE)) {
                                    type = jsonObject
                                            .getString(L_TYPE);
                                    if(type.equals("1")) {
                                        cusMem.setPointsBalance(pointsBalance);
                                        cusMem.setRedeemableValue(redeemableValue);
                                        cusMem.setCoupon(listCoupons);
                                        flag=true;
                                    }
                                }
                            }
                            
                            //END BZ48564
                            cusMem.setMemberShip(typeDescription);

                            cusMem.setClub(identifier);

                            cusMem.setBenefitLevel(benefitLevelName);

                            cusMem.setStatus(statusDescription);

                            if (isAutoRenew) {
                                cusMem.setRenewal(CawConstants.CUST_TAX_EXEMPT_YES);
                            } else {
                                cusMem.setRenewal(CawConstants.CUST_TAX_EXEMPT_NO);
                            }

                            cusMem.setExpDate(expireDate);

                            //BEGIN BZ57844
                            cusMem.setDaysExpired(daysExpired);
                            cusMem.setType(memberType);
                            //END BZ57844
                            customerMSViews.add(cusMem);
                        }

                    }
                    // Start BZ62218 - the code below commented because the temp vertion for test, should be un-comment after have the correct data for testing
                    //start BZ48564
                    /* if(flag==false && status != null) {
                           cusMem = new CawCustomerMembershipView();
                       if(pointsBalance!=null) {
                           cusMem.setPointsBalance(pointsBalance);
                       }
                       if(redeemableValue!=null) {
                           cusMem.setRedeemableValue(redeemableValue);
                       }
                       cusMem.setCoupon(listCoupons);
                       cusMem.setClub(" ");
                       customerMSViews.add(cusMem);
                       }*/
                    //end BZ48564 
                }
                /* else if (status != null) {
                    cusMem = new CawCustomerMembershipView();
                    if(pointsBalance!=null) {
                        cusMem.setPointsBalance(pointsBalance);
                    }
                    if(redeemableValue!=null) {
                        cusMem.setRedeemableValue(redeemableValue);
                    }
                    cusMem.setCoupon(listCoupons);
                    cusMem.setClub(" ");
                    customerMSViews.add(cusMem);
                }*/
                // BZ27851 end
                // END BZ62218
            }

        } catch (JSONException ex) {
            _logger.error("Error happened in method parseCustomerMemberships: "
                    + ex.getMessage());
        }
        //Begin BZ49497
        if (customerMSViews.size() == 0) {
            customerMSViews = null;
        }
        //End BZ49497
        return customerMSViews;
    }

    /**
     * @param response
     * @param orgId
     * @return
     */
    public String getMembershipImage(String jsonCusotmerResponse ,JSONObject obMembership, String band,
            long orgId, boolean bMembershipsFound) {

        String outputLoyaltyIconIrl = null;
        String outputImageCode = null;
        
        boolean isActive = getIsActive(jsonCusotmerResponse);
        
        try {
            if (obMembership != null) {
                if (band != null && band.length() > 0) {
                    String benefitLevelName = obMembership
                            .getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR);
                    if (!StringUtils.isEmpty(benefitLevelName)
                            && CawCustomerConstants.CAW_CUSTOMER_ELITE_LEVEL
                                    .equals(benefitLevelName)) {
                        //BEGIN BZ69515
                        if(isActive) {
                            outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME;
                            outputLoyaltyIconIrl = getMembershipImageUrl(orgId, CawCustomerConstants.CUSTOMER_GROUPS, outputImageCode);
                        }else {
                            outputImageCode = StringUtils.upperCase(benefitLevelName);
                            outputLoyaltyIconIrl = getMembershipImageUrl(orgId, CawCustomerConstants.CAW_CUSTOMER_GROUPS_LEVEL, outputImageCode);
                        }
                        
                        //END BZ69515
                    } else {
                        if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME
                                .equalsIgnoreCase(band)) {
                            outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME;
                        } else {
                            //BEGIN BZ69515
                            if(isActive) {
                                outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME;
                            }else {
                                outputImageCode = band;
                            }
                            //END BZ69515
                        }
                        outputLoyaltyIconIrl = getMembershipImageUrl(orgId, CawCustomerConstants.CUSTOMER_GROUPS, outputImageCode);
                    }
                }
            } else {
                if (bMembershipsFound) {
                    if (band != null) {
                        if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME
                                .equalsIgnoreCase(band)) {
                            outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME;
                        } else {
                            //BEGIN BZ69515
                            if(isActive) {
                                outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME;
                            }else {
                                outputImageCode = band;
                            }
                            //END BZ69515
                        }
                        outputLoyaltyIconIrl = getMembershipImageUrl(orgId, CawCustomerConstants.CUSTOMER_GROUPS, outputImageCode);
                    }
                } else {
                    outputImageCode = CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME;
                    outputLoyaltyIconIrl = getMembershipImageUrl(orgId, CawCustomerConstants.CUSTOMER_GROUPS, outputImageCode);
                }
            }
        } catch (Exception ex) {
            _logger.error("Membership not found! There is no membership from EBS response. "
                    + ex.getMessage());
        }
        return outputLoyaltyIconIrl;
    }
    
    private boolean getIsActive(String jsonCustomerResponse) {
        boolean isActive = false;
        
        List<String> codes = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), GS_VISA_ICON_ENABLED);
        if (codes != null && codes.size() > 0) {
            String isEnable = codes.get(0);
            if (!Boolean.valueOf(isEnable)) {
                return false;
            }
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonCustomerResponse);
            JsonNode cardholderNode = rootNode.path(JSON_CARDHOLDER);

            if (cardholderNode.isMissingNode()) {
                _logger.warn("Cardholder node not found in EBS customer response.");
                return false;  // Return false if the cardholder node is missing
            }

            JsonNode isActiveNode = cardholderNode.path(JSON_ISACTIVE);
            if (isActiveNode.isMissingNode()) {
                _logger.warn("isActive field not found in EBS customer response.");
                return false;
            }

            isActive = isActiveNode.asBoolean(false);
        } catch (IOException ex) {
            _logger.error("Failed to parse EBS customer response: " + ex.getMessage());
        }

        return isActive;
    }


    /**
     * @param response
     * @param orgId
     * @return
     */
    public String getMembershipImageFromJsonCustomer(
            String jsonCusotmerResponse, long orgId,
            boolean bMembershipsFound) {

        String outputLoyaltyIconIrl = null;
        try {
            if (jsonCusotmerResponse != null
                    && jsonCusotmerResponse.length() > 0) {

                JSONObject obCustomer = CawJSONUtils
                        .toJSONObject(jsonCusotmerResponse);

                JSONObject obPricing = CawJSONUtils
                        .getJSONObject(obCustomer, CawJSONConstant.JSON_AVAILABLE_PRICING);

                if (obPricing != null) {
                    JSONObject obMembership = CawJSONUtils
                            .getJSONObject(obPricing, CawJSONConstant.JSON_MEMBERSHIP);
                    String band = CawJSONUtils
                            .getString(obPricing, CawJSONConstant.JSON_BAND);

                    outputLoyaltyIconIrl = getMembershipImage(jsonCusotmerResponse,obMembership, band, orgId, bMembershipsFound); // BZ69515

                }
            }
        } catch (Exception ex) {
            _logger.error("getMembershipImageFromJsonCustomer-1: "
                    + ex.getMessage());
        }
        // BZ27339 End
        return outputLoyaltyIconIrl;
    }

    /**
     * @param response
     * @param argCustomer
     * @return
     */
    public String getMembershipImageFromJsonPricing(String jsonCusotmerResponse,String jsonPricingresponse,
            long orgId, boolean bMembershipsFound) {

        String outputLoyaltyIconIrl = null;
        try {
            if (jsonPricingresponse != null
                    && jsonPricingresponse.length() > 0) {

                JSONObject obPricing = CawJSONUtils
                        .toJSONObject(jsonPricingresponse);

                if (obPricing != null) {
                    JSONObject obMembership = CawJSONUtils
                            .getJSONObject(obPricing, CawJSONConstant.JSON_MEMBERSHIP);
                    String band = CawJSONUtils
                            .getString(obPricing, CawJSONConstant.JSON_BAND);

                    outputLoyaltyIconIrl = getMembershipImage(jsonCusotmerResponse, obMembership, band, orgId, bMembershipsFound); //BEGIN BZ69515
                }
            }

        } catch (Exception ex) {
            _logger.error("getMembershipImageFromJsonPricing: Membership not found!"
                    + ex.getMessage());
        }
        return outputLoyaltyIconIrl;
    }

    /**
     * Get image of membership from database
     * @param argCustomer
     * @param bMembershipsFound
     * @return
     */
    public String getMembershipImageFromDatabase(String jsonCusotmerResponse, IParty argCustomer,
            boolean bMembershipsFound) {

        String outMembershipImageUrl = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put(CawQueryConstants.ARG_PARTY_ID, argCustomer
                    .getPartyId());
            List<CawCustomerPartyIdXrefQueryResult> xrefResults = DataFactory
                    .getObjectByQueryNoThrow(CawQueryConstants.CUSTOMER_PARTY_ID_XREF_LOOKUP, params);

            if (!xrefResults.isEmpty()) {
                String jsonPricing = xrefResults.get(0).getStringValue();
                outMembershipImageUrl = getMembershipImageFromJsonPricing(jsonCusotmerResponse, jsonPricing, argCustomer
                        .getOrganizationId(), bMembershipsFound); //BEGIN BZ69515
            }
        } catch (Exception ex) {
            _logger.error("getMembershipImageFromDatabase: Membership not found in DB!"
                    + ex.getMessage());
        }
        return outMembershipImageUrl;
    }

    /**
     * 
     * @param jsonCustomerResponse
     * @return
     */
    public List<CawCustomerMembershipView> getCacheMemberships(
            String jsonCustomerResponse) {

        List<CawCustomerMembershipView> outMemberships = null;
        outMemberships = getMemberships();
        // BZ27851 start
        if ((outMemberships == null || outMemberships.size() == 0)
                && (jsonCustomerResponse != null
                        && jsonCustomerResponse.length() > 0)) {
            // if it hasn't been assigned, need to get from json customer
            outMemberships = getReloadMemberships(jsonCustomerResponse);
        }
        // BZ27851 end
        return outMemberships;
    }

    public List<CawCustomerMembershipView> getReloadMemberships(
            String jsonCustomerResponse) {

        List<CawCustomerMembershipView> outMemberships = null;
        outMemberships = parseCustomerMemberships(jsonCustomerResponse);
        setMemberships(outMemberships);
        return outMemberships;
    }

    /**
     * Added to use for BZ26893/BZ27937
     * Get value from code
     * @param organizationId
     * @param category
     * @param code
     * @return
     */
    public String getMembershipValue(long organizationId,
            String category, String code) {

        String desc = null;
        ICodeValue value = null;
        CodeValueId id = new CodeValueId();
        id.setOrganizationId(Long.valueOf(organizationId));
        id.setCategory(category);
        id.setCode(code);
        try {
            value = (ICodeValue) DataFactory.getObjectById(id);
            if (value != null) {
                desc = value.getDescription();
            }
        } catch (Exception e) {
            _logger.warn("Could not find description of [" + id.getCode() + "]"
                    + e.getMessage());
        }
        return desc;
    }
}
