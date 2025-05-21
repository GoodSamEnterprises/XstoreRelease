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
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25435              160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ26207              190718    New Requirement - Enable Work Order Functionality
 * BZ28247              181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28033              110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ29840              210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ29841              080419    [Internal][Xstore log] MadeOffer request should be cleaned up into Xstore log since it is written into ESB log.
 * BZ30922              210619    [New Requirement] Price Check and Inventory Lookup
 * BZ31968              220719    [Port 31855 to 5.0] Incorrect Neuron Promotion API URL
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ37023              120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37396              021020    Tax value calculation issue in Order transactions
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ45995              141021    [New requirement] Email capture when good sam membership is sold
 * BZ42019              171121    Replace QAS with EAVS2
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 * BZ48604              140222    [Task] Need a configuration to enable/disable about getting customer loyalty program from Cheetah Loyalty service into Xstore afterward. 
 * BZ48690              160222    [Task] - Xstore will make a call to New Service instead of existing Neuron API to get search result.
 * BZ48692              240422    [Task] Process New Service is offline/time out when processing customer Search.
 * BZ49801              040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ50032              250522    [Task] Loyalty - Using Oauth2 security to access the new service
 * BZ50159              260522    [Internal] Loyalty - Xstore should build the API request with user/pass if the Token URL is null 
 * BZ53072              251022    [Internal] All requests related to the Customer tag were sent incorrectly in case Loyalty APIs down.
 * BZ54776              120123    Bug 54776 : [Patch 22.0] Extend ability to turn ON/OFF loyalty functionality into xstore to specific stores if needed.
 * BZ61159              190224    [New Requirement] - Xstore AGIS Replacement
 * BZ69388              030225    [AGIS Modification] - Update Customer Lookup API Call (Section 2.1.1)
 *===================================================================
 */

package caw.pos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.*;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.cheetah.util.CawCheetahTokenModel;
import caw.pos.common.*;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;

public class CawEBSHelper {

    static final String                  NEURON_USER                          = System
            .getProperty("caw.pos.customer.neuron.user");

    static final String                  NEURON_KEY                           = System
            .getProperty("caw.pos.customer.neuron.key");

    static final String                  URL_CUSTOMER_TEMPLATE                = System
            .getProperty("caw.pos.customer.template.url");

    public static final String           URL_CUSTOMER_UPSERT                  = System
            .getProperty("caw.pos.customer.upsert.url");                                                                //BZ29840

    static final String                  URL_CUSTOMER_LOOKUP                  = System
            .getProperty("caw.pos.customer.lookup.url");

    public static final String           URL_CUSTOMER_SEARCH                  = System
            .getProperty("caw.pos.customer.search.url");                                                                //BZ29840

    static final String                  URL_PROMOTION_LOOKUP                 = System
            .getProperty("caw.pos.promotion.api.url");

    /* BEGIN BZ31968 */
    static final String                  URL_PROMOTION_RESERVE                = System
            .getProperty("caw.pos.promotion.reserve.url");
    /* END BZ31968 */

    static final String                  URL_PROMOTION_RESET                  = System
            .getProperty("caw.pos.promotion.reset.url");

    // Begin BZ23052
    public static final String           URL_CATALYST_REQUEST                 = System
            .getProperty("caw.pos.catalyst.request.url");                                                               //BZ29840

    public static final String           URL_CATALYST_RESULTS                 = System
            .getProperty("caw.pos.catalyst.results.url");
    // End BZ23052, BZ29840

    /* BEGIN BZ28247 */
    static final String                  URL_MADE_OFFER_REQUEST               = System
            .getProperty("caw.pos.madeoffer.request.url");
    /* END BZ28247 */

    /* BEGIN BZ28247 */
    static final String                  URL_CARE_TAKER_REQUEST               = System
            .getProperty("caw.pos.caretaker.request.url");
    /* END BZ28247 */

    // Begin BZ23958
    static final String                  MEMBERSHIP_VALIDATE_REQUEST          = System
            .getProperty("caw.pos.membership.validate.request.url");
    // End BZ23958

    static final String                  URL_WORK_ORDER_SEARCH_REQUEST        = System
            .getProperty("caw.pos.work.order.search.request.url");

    static final String                  URL_WORK_ORDER_LOOKUP_REQUEST        = System
            .getProperty("caw.pos.work.order.lookup.request.url");

    static final String                  URL_WORK_ORDER_UPDATE_STATUS_REQUEST = System
            .getProperty("caw.pos.work.order.update.status.request.url");
    
    /* BEGIN BZ44528: Phase 1 */
    public static final String                  URL_CART_SEARCH               = System
            .getProperty("caw.pos.wondersign.cart.search.url");
    /* BEGIN BZ44528: Phase 1 */
    
    /* BEGIN BZ45995 */
    public static final String           URL_VALIDATE_EMAIL                   = System.getProperty("caw.pos.email.validation.url");
    
    public static final String           EMAIL_VALIDATION_EMAIL_PARAMETER_KEY = "theEmail";
    /* END BZ45995 */
    
    /* BEGIN BZ42019 */
    public static final String           URL_VALIDATE_MAILING                 = System
            .getProperty("caw.pos.mailing.validation.url");
    /* END BZ42019 */

    // Begin BZ23478
    public static final String           OLPS_PP_USERNAME                     = System.getProperty("olps.app.username");

    public static final String           OLPS_APP_PASSWORD                    = System.getProperty("olps.app.password");
    // End BZ23478

    /* BEGIN BZ28247 */
    public static final String           CARD_SERVICES_SUBMIT_REQUEST         = System
            .getProperty("caw.pos.card.services.submit.request");                                                       //BZ29840

    public static final String           CARD_SERVICES_STATUS_REQUEST         = System
            .getProperty("caw.pos.card.services.status.request");                                                       //BZ29840
    /* END BZ28247 */

    /* BEGIN BZ30922 */
    static final String                  URL_STORE_INVENTORY_REQUEST          = System
            .getProperty("caw.pos.inventory.search.request.url");
    /* END BZ30922 */
    
    /*BEGIN BZ28036*/
    public static final String           URL_CUSTOMER_PURCHASE_HISTORY        = System
            .getProperty("caw.pos.customer.purchase.history.url");

    public static final String           URL_CUSTOMER_PURCHASE_HISTORY_DETAIL = System
            .getProperty("caw.pos.customer.purchase.history.detail.url");
    /*END BZ28036*/
    
    public static final int              RESPONSE_SUCCESS_CODE                = 200;

    private static final Logger          _logger                              = LogManager
            .getLogger(CawEBSHelper.class);

    private static final String          PARAM_LOOKUP_ACCOUNT_NUMBER          = "{accountNumber}";

    private static final String          PARAM_LOOKUP_LOCATION_CODE           = "{locationCode}";

    private static volatile CawEBSHelper instance                             = null;
    
    /* BEGIN BZ37023 */
    static final String                  URL_SHIPPING_RATE_REQUEST            = System.getProperty("caw.pos.shippingrate.request.url");
    /* END BZ37023 */

    /* BEGIN BZ37396 */
    public static final String           URL_TAX_REQUEST                      = System.getProperty("caw.pos.tax.request.url"); 
    /* END BZ37396 */
    public static final String           URL_RV_PAYMENT_REQUEST               = System.getProperty("caw.pos.rv.payment.request.url");/*BZ44917*/
    
    //Start BZ50032
    private CawRestConfigHelper              _restConfigHelper                = CawRestConfigHelper.getInstance();
    
    public static final String           URL_TOKEN_REQUEST                    = System.getProperty("caw.pos.cheetah.token.url");
    
    public static final String           CAW_TOKEN_CONTINGENCY_TIME           = System.getProperty("caw.pos.cheetah.contingency.time");
    
    public static final String           TOKEN_TEMPLATE_REQUEST               = "REQ_TOKEN";
    
    public static final String           CAW_CLIENT_ID                        = System.getProperty("caw.pos.cheetah.client.id");
    
    public static final String           CAW_CLIENT_SECRET                    = System.getProperty("caw.pos.cheetah.client.secret");
    
    public static final String           CAW_GRANT_TYPE                       = System.getProperty("caw.pos.cheetah.grant.type");
    
    static final String                  URL_CUSTOMER_LOOKUP_TOKEN            = System.getProperty("caw.pos.customer.lookup.url.token");

    public static final String           URL_CUSTOMER_SEARCH_TOKEN            = System.getProperty("caw.pos.customer.search.url.token"); 
    
    public static final String           URL_CUSTOMER_UPSERT_TOKEN            = System.getProperty("caw.pos.customer.upsert.url.token");//BZ61159
    
    //Begin BZ69388
    public static final String           CAW_ENABLE_AGIS_GROUP_PITCHES        = "CAW_ENABLE_AGIS_GROUP_PITCHES";
    public static final String           CAW_AGIS_PARAM_GROUP_PITCHES        = "CAW_AGIS_PARAM_GROUP_PITCHES";
    //End BZ69388
    //End BZ50032
    private CawEBSHelper() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawEBSHelper
     */
    public static CawEBSHelper getInstance() {

        if (instance == null) {
            synchronized (CawEBSHelper.class) {
                if (instance == null) {
                    instance = new CawEBSHelper();
                }
            }
        }
        return instance;
    }

    /**
     * Send the request and get response via Neuron service
     * @param body
     * @return
     */
    public ResponseEntity<String> sendRequestToEBS(String serviceUrl, String requestBody) {

        return sendRequestToEBS(serviceUrl, requestBody, HttpMethod.POST);
    }

    /**
     * Send the request and get response via Neuron service
     * @param body
     * @return
     */
    public ResponseEntity<String> sendRequestToEBS(String serviceUrl, String requestBody, HttpMethod httpMethod) {
        ResponseEntity<String> result = null;
        if (serviceUrl != null && serviceUrl.length() > 0) {
            try {
                /*BEGIN BZ48690*/
                String neuronUser = NEURON_USER;
                String neuronKey = NEURON_KEY;
                String[] splitUrl = serviceUrl.trim().split("\\|");
                if(splitUrl != null && splitUrl.length == 3) {
                    serviceUrl = splitUrl[0];
                    neuronUser = splitUrl[1];
                    neuronKey = splitUrl[2];
                }
               
                HttpHeaders httpHeaders = CawRestClientUtil.createHttpHeader(neuronUser, neuronKey);
                /*END BZ48690*/
                
                /* BEGIN BZ50032, BZ54776 */
                if (CawCheetahHelper.isEnableLoyalty()) {
                    if(CawCatalystHelper.getTokenResponseModel() != null && CawCatalystHelper.getTokenResponseModel().isUseToken() 
                            && !serviceUrl.equals(URL_TOKEN_REQUEST)) {
                        String authorization = StringUtils.EMPTY;
                        if((CawCatalystHelper.getTokenResponseModel().getExpiresTime() == null 
                                && CawCatalystHelper.getTokenResponseModel().getTokenAccess() == null 
                                    && CawCatalystHelper.getTokenResponseModel().getTokenType() == null) 
                                || (CawCatalystHelper.getTokenResponseModel().getExpiresTime() != null 
                                    && isExpiredToken(CawCatalystHelper.getTokenResponseModel().getExpiresTime()))) {
                            getTokenFromApi();
                        }
                        authorization = CawCatalystHelper.getTokenResponseModel().getTokenType() + StringUtils.SPACE + CawCatalystHelper.getTokenResponseModel().getTokenAccess();
                        httpHeaders.set(CawConstants.CAW_AUTHORIZATION, authorization);
                        CawCatalystHelper.getTokenResponseModel().setUseToken(false);
                    }
                }
                /*END BZ50023, BZ54776 */
                
                HttpEntity<String> entity = null;
                if (requestBody != null && requestBody.length() > 0) {
                    entity = new HttpEntity<String>(requestBody, httpHeaders);
                } else {
                    entity = new HttpEntity<String>(httpHeaders);
                }
                result = CawRestClientUtil.callServiceAPIResponseEntity(serviceUrl, httpMethod, entity);
            } catch (Exception ex) {
                _logger.error("sendRequestToEBS-0: " + ex.getMessage());
            }
        } else {
            _logger.info("sendRequestToEBS: URL is null or empty");
        }
        return result;
    }
    
    /**
     * 
     */
    //Start BZ50032
    private String getTokenFromApi() {
            String tokenUrl = URL_TOKEN_REQUEST;
            
            CawRestConfig request = _restConfigHelper.getRestRequest(TOKEN_TEMPLATE_REQUEST);
            String bodyReq = StringUtils.EMPTY;
            _logger.info("[Call Token url]: " + tokenUrl);
            if(request != null && !StringUtils.isEmpty(request.getBody())) {
                bodyReq = request.getBody();
                bodyReq = bodyReq.replace(CawJSONConstant.TOKEN_TEMPLATE_CLIENT_ID, CAW_CLIENT_ID);
                bodyReq = bodyReq.replace(CawJSONConstant.TOKEN_TEMPLATE_CLIENT_SECRET, CAW_CLIENT_SECRET);
                bodyReq = bodyReq.replace(CawJSONConstant.TOKEN_TEMPLATE_GRANT_TYPE, CAW_GRANT_TYPE);
                _logger.info("[Call Token request]: " + bodyReq);
            }
            ResponseEntity<String> response = sendRequestToEBS(tokenUrl, bodyReq, HttpMethod.POST);
            
            CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
            if(response != null ) {
                if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null && !response.getBody().isEmpty()) {
                    JSONObject tokenJson = CawJSONUtils.toJSONObject(response.getBody());
                    tokenModel.setTokenType(CawJSONUtils.getString(tokenJson, CawConstants.CAW_TOKEN_TYPE));
                    tokenModel.setTokenAccess(CawJSONUtils.getString(tokenJson, CawConstants.CAW_ACCESS_TOKEN));
                    
                    if(CawJSONUtils.getString(tokenJson, CawConstants.CAW_TOKEN_EXPIRES_IN) != null 
                            && CawJSONUtils.getString(tokenJson, CawConstants.CAW_TOKEN_EXPIRES_IN) != StringUtils.EMPTY) {
                        Date now = new Date();
                        long seconds = now.getTime();
                        seconds = seconds + (Long.parseLong(CawJSONUtils.getString(tokenJson, CawConstants.CAW_TOKEN_EXPIRES_IN)) * 1000) - (Long.parseLong(CAW_TOKEN_CONTINGENCY_TIME) * 1000); 
                        Date expired = new Date(seconds);
                        DateFormat dateFormat = new SimpleDateFormat(CawConstants.CAW_TOKEN_EXPIRED_TIME_FORMAT);  
                        tokenModel.setExpiresTime(dateFormat.format(expired));
                    }
                    _logger.info("[Call Token response]: " + response.getBody());
                    CawCatalystHelper.setTokenResponseModel(tokenModel);
                    return response.getBody();
                }else {
                    _logger.info("[Call Token response with an error code]:" + response.getStatusCode());
                }
            }
            return StringUtils.EMPTY;
        
    }

    /**
     * @param argExpiresTime
     * @return
     */
    private boolean isExpiredToken(String argExpiresTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CawConstants.CAW_TOKEN_EXPIRED_TIME_FORMAT);
        Date expiredDate;
        try {
            expiredDate = dateFormat.parse(argExpiresTime);
            Date now = new Date();
            if(now.after(expiredDate)) {
                return true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //End BZ50032
    /**
     * Started for BZ26398; The method is moved here
     * @param argRequestMembershipValidate
     * @param argNeuronUser
     * @param argNeuronKey
     * @return
     */
    public ResponseEntity<String> sendMembershipValidateToEBS(String requestMembershipValidate) {

        ResponseEntity<String> response = null;
        try {
            _logger.info("[Call Membership Validate API]:" + MEMBERSHIP_VALIDATE_REQUEST); //BZ29840
            _logger.info("[Membership Validate request]:" + requestMembershipValidate); //BZ29840

            HttpHeaders httpHeaders = CawRestClientUtil.createHttpHeader(NEURON_USER, NEURON_KEY);
            HttpEntity<String> entity = new HttpEntity<String>(requestMembershipValidate, httpHeaders);
            response = CawRestClientUtil
                    .callMembershipAPIResponseEntity(MEMBERSHIP_VALIDATE_REQUEST, HttpMethod.POST, entity);
        } catch (Exception ex) {
            _logger.error("Validate Membership Exception:" + ex.getMessage());
        }

        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Membership Validate response]:" + response.getBody());
            } else {
                _logger.info("[Membership Validate response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */

        return response;
    }

    /**
     * Upsert Json Customer to EBS
     * @param upSertRequest
     * @return
     */
    public ResponseEntity<String> upsertCustomterToEBS(String upSertRequest) {                
        /* BEGIN BZ61159 */
        //BEGIN ENABLE TO USE MOCKUP
        try {
            if (Files.exists(Paths.get("/opt/xstore/mockupResponse/mockupCustomerUpsertResponse.txt"))) {
                String mockupResponse = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/mockupCustomerUpsertResponse.txt")));
                ResponseEntity<String> mockupResult = null;
                JSONObject jsonLookup = new JSONObject(mockupResponse);
                if(!jsonLookup.isNull(CawJSONConstant.JSON_RESULT)) {
                    jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_RESULT);
                    if(!jsonLookup.isNull(CawJSONConstant.JSON_LOYALTY)) {
                        CawCatalystHelper.setLookupLoyaltyResponseData(jsonLookup.getJSONObject(CawJSONConstant.JSON_LOYALTY).toString()); 
                    }
                    if(!jsonLookup.isNull(CawJSONConstant.JSON_WO_CUSTOMER)) {
                        jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_WO_CUSTOMER);
                    }
                    mockupResult = new ResponseEntity<String>(jsonLookup.toString(), HttpStatus.CREATED);
                    _logger.info("[Upsert API mockup response 1]:" + mockupResult.getBody());
                    return mockupResult;
                }
                mockupResult = new ResponseEntity<String>(jsonLookup.toString(), HttpStatus.CREATED);
                _logger.info("[Upsert API mockup response 2]:" + mockupResult.getBody());
                return mockupResult;
            }
        } catch (JSONException ex) {
            _logger.error("Can not mockup customer response from API." + ex.getMessage());
        } catch (IOException ex) {
            _logger.error("Can not mockup customer response from API." + ex.getMessage());
        } 
        //END ENABLE TO USE MOCKUP
        
    	String urlCustomerUpsert = URL_CUSTOMER_UPSERT;
        if (CawCheetahHelper.isEnableLoyalty()) {
            if (CawCatalystHelper.getTokenResponseModel() == null) {
                CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
                CawCatalystHelper.setTokenResponseModel(tokenModel);
            }
            if (URL_CUSTOMER_UPSERT_TOKEN != null
                    && !URL_CUSTOMER_UPSERT_TOKEN.isEmpty()) {
                urlCustomerUpsert = URL_CUSTOMER_UPSERT_TOKEN;
                CawCatalystHelper.getTokenResponseModel().setUseToken(true);
            } else {
                CawCatalystHelper.getTokenResponseModel().setUseToken(false);
            }
        }
        /* END BZ61159*/
        
        /* BEGIN BZ69388 */
        if (CawEBSHelper.isEnableGroupPitches()) {
            urlCustomerUpsert = urlCustomerUpsert  + "?" + CawEBSHelper.getAdditionalParamGroupPitches();
        }
        /* END BZ69388 */
        
        String[] splitUrl = urlCustomerUpsert.trim().split("\\|");
        if(splitUrl != null && splitUrl.length == 3) {
            urlCustomerUpsert = splitUrl[0];
        }
        _logger.info("[Call Upsert API]:" + urlCustomerUpsert); //BZ29840
        _logger.info("[Upsert API request]:" + upSertRequest);//BZ29840
        /* BEGIN BZ29840 */
        ResponseEntity<String> response = sendRequestToEBS(urlCustomerUpsert, upSertRequest, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Upsert API response]:" + response.getBody());
                response = updateResponseFromMiddleLayer(response); //BZ61159
            } else {
                _logger.info("[Upsert API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
        return response;
    }
    
    //BEGIN BZ61159
    public ResponseEntity<String> updateResponseFromMiddleLayer(ResponseEntity<String> response) {
        String body = response.getBody();
        ResponseEntity<String> result = response;
        try {
            if(body != null && body.length() > 0) {
                JSONObject bodyJson = new JSONObject(body);
                if(bodyJson.has(CawEBSConstant.DATA) && !bodyJson.isNull(CawEBSConstant.DATA)) {
                    JSONObject dataJson = bodyJson.getJSONObject(CawEBSConstant.DATA);
                    if(dataJson.has(CawEBSConstant.ATTRIBUTES)) {
                        if(!dataJson.isNull(CawEBSConstant.ATTRIBUTES) && dataJson.getString(CawEBSConstant.ATTRIBUTES).length() > 0) {
                            result = new ResponseEntity<String>(dataJson.getJSONObject(CawEBSConstant.ATTRIBUTES).toString(), response.getStatusCode()); 
                        } else {
                            result = new ResponseEntity<String>(StringUtils.EMPTY, HttpStatus.NOT_FOUND);
                        }
                    } 
                }
            }
        } catch (JSONException ex) {
            _logger.info("[Upsert API updateResponseFromMiddleLayer error]: " + ex.getMessage());
        }
        return result;
    }
    //END BZ61159
    /**
     * Send the request and get response via Neuron service
     * @param searchCustomerBody
     * @return
     */
    public ResponseEntity<String> searchRequestToEBS(String searchCustomerBody) {
        /* BEGIN BZ48690 */ 
        /* BEGIN BZ50032, BZ54776 */
        String urlCustomerSearch = URL_CUSTOMER_SEARCH;
        if (CawCheetahHelper.isEnableLoyalty()) {
            if (CawCatalystHelper.getTokenResponseModel() == null) {
                CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
                CawCatalystHelper.setTokenResponseModel(tokenModel);
            }
            if (URL_CUSTOMER_SEARCH_TOKEN != null
                    && !URL_CUSTOMER_SEARCH_TOKEN.isEmpty()) { //BZ50159
                urlCustomerSearch = URL_CUSTOMER_SEARCH_TOKEN;
                CawCatalystHelper.getTokenResponseModel().setUseToken(true);
            } else {
                CawCatalystHelper.getTokenResponseModel().setUseToken(false);
            }
        }
        /* END BZ50032, BZ54776 */
        
        String[] splitUrl = urlCustomerSearch.trim().split("\\|");
        if(splitUrl != null && splitUrl.length == 3) {
            urlCustomerSearch = splitUrl[0];
        }
         _logger.info("[Call Customer search API]:" + urlCustomerSearch); //BZ29840
        /*END BZ48690*/
        _logger.info("[The customer search API request]:" + searchCustomerBody);//BZ29840
        /* BEGIN BZ29840 */
        ResponseEntity<String> response = sendRequestToEBS(urlCustomerSearch, searchCustomerBody, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("The customer search API response]:" + response.getBody());
            } else {
                _logger.info("[The customer search API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */

        return response;
    }
    
    /* BEGIN BZ69388 */
    public static boolean isEnableGroupPitches() {
        ICodeValue codeValue = CodeLocator
                .getCodeValue(ConfigurationMgr.getOrganizationId(), CAW_ENABLE_AGIS_GROUP_PITCHES, CAW_ENABLE_AGIS_GROUP_PITCHES);
        if (codeValue == null || codeValue.getDescription() == null) {
            return false;
        }
        return CawConstants.TRUE_STRING.equalsIgnoreCase(codeValue.getDescription());
    }
    
    public static String getAdditionalParamGroupPitches() {
        ICodeValue codeValue = CodeLocator
                .getCodeValue(ConfigurationMgr.getOrganizationId(), CAW_AGIS_PARAM_GROUP_PITCHES, CAW_AGIS_PARAM_GROUP_PITCHES);
        if (codeValue == null || codeValue.getDescription() == null) {
            return StringUtils.EMPTY;
        }
        return codeValue.getDescription();
    }
    /* END BZ69388 */

    /**
     * Look for a customer for selected item
     * @param accountNumber
     * @param locationCode
     * @return
     */
    public String lookupCustomerInEBS(String accountNumber, String locationCode) {
        /* BEGIN BZ28033 */
        try {
            String esbResponse = CawCatalystHelper.getLookupResponseData();
            
            //BEGIN BZ48564: ENABLE TO USE MOCKUP
            try {
                if (Files.exists(Paths.get("/opt/xstore/mockupResponse/mockupCustomerLookupResponse.txt"))) {
                    String mockupResponse = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/mockupCustomerLookupResponse.txt")));
                    JSONObject jsonLookup = new JSONObject(mockupResponse);
                    if(!jsonLookup.isNull(CawJSONConstant.JSON_RESULT)) {
                        jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_RESULT);
                        //Start BZ49801
                        if(!jsonLookup.isNull(CawJSONConstant.JSON_LOYALTY)) {
                            CawCatalystHelper.setLookupLoyaltyResponseData(jsonLookup.getJSONObject(CawJSONConstant.JSON_LOYALTY).toString()); 
                        }
                        if(!jsonLookup.isNull(CawJSONConstant.JSON_WO_CUSTOMER)) {
                            jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_WO_CUSTOMER);
                        }
                        return jsonLookup.toString();
                        //End BZ49801
                    }
                    return mockupResponse;  
                }

            } catch (IOException ex) {
                _logger.error("Can not mockup customer response from API." + ex.getMessage());//BZ53072
            }
            
            //END BZ48564: ENABLE TO USE MOCKUP
            if (StringUtils.isEmpty(esbResponse)) {

                if (accountNumber != null && locationCode != null) {
                    /* BEGIN BZ50032, BZ54776 */
                    String customerLookupUrl = URL_CUSTOMER_LOOKUP;
                    if (CawCheetahHelper.isEnableLoyalty()) {
                        if (CawCatalystHelper.getTokenResponseModel() == null) {
                            CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
                            CawCatalystHelper.setTokenResponseModel(tokenModel);
                        }
                        if (URL_CUSTOMER_LOOKUP_TOKEN != null && !URL_CUSTOMER_LOOKUP_TOKEN.isEmpty()) { //BZ50159
                            customerLookupUrl = URL_CUSTOMER_LOOKUP_TOKEN;
                            CawCatalystHelper.getTokenResponseModel().setUseToken(true);
                        } else {
                            CawCatalystHelper.getTokenResponseModel().setUseToken(false);
                        }
                    }
                    customerLookupUrl = customerLookupUrl.replace(PARAM_LOOKUP_ACCOUNT_NUMBER, accountNumber).replace(PARAM_LOOKUP_LOCATION_CODE, locationCode);
                    /* END BZ50032, BZ54776 */ 
                    
                    /* BEGIN BZ69388 */
                    if (CawEBSHelper.isEnableGroupPitches()) {
                        customerLookupUrl = customerLookupUrl + "&" + CawEBSHelper.getAdditionalParamGroupPitches();
                    }
                    /* END BZ69388 */
                    
                    /*BEGIN BZ48690*/
                    String[] splitUrl = customerLookupUrl.trim().split("\\|");
                    if(splitUrl != null && splitUrl.length == 3) {
                        _logger.info("[Call Customer Lookup API Request]:" + splitUrl[0]);
                    }else {
                        _logger.info("[Call Customer Lookup API Request]:" + customerLookupUrl); //BZ29840
                    }
                    /*END BZ48690*/
                    ResponseEntity<String> customerTemplate = sendRequestToEBS(customerLookupUrl, null, HttpMethod.GET);

                    /* BEGIN BZ25118 */
                    if (customerTemplate == null) {
                        return "";
                    } else {
                        /* BEGIN BZ54776 */
                        if (!CawCheetahHelper.isEnableLoyalty()) {
                            if (customerTemplate.getStatusCodeValue() == CawEBSHelper.RESPONSE_SUCCESS_CODE) {
                                _logger.info("[The Customer Lookup API Response]:" + customerTemplate.getBody());
                                return customerTemplate.getBody();
                            }
                        /* END BZ54776 */
                        } else {
                            if(customerTemplate.getStatusCode() == HttpStatus.OK) {
                                /* BEGIN BZ29840 */
                                if (CawCheetahHelper.getInstance().getResultCodeFromEBS(customerTemplate) == RESPONSE_SUCCESS_CODE) {// BZ48692
                                    _logger.info("[The Customer Lookup API Response]:"+ customerTemplate.getBody());
                                    /* BEGIN BZ53072*/
                                    if (StringUtils.isNotEmpty(customerTemplate.getBody())) {
                                        JSONObject jsonLookup = new JSONObject(customerTemplate.getBody());
                                        if (!jsonLookup.isNull(CawJSONConstant.JSON_RESULT)) {
                                            jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_RESULT);
                                            /* BEGIN BZ49801 */
                                            if (!jsonLookup.isNull(CawJSONConstant.JSON_LOYALTY)) {
                                                CawCatalystHelper.setLookupLoyaltyResponseData(
                                                        jsonLookup.getJSONObject(CawJSONConstant.JSON_LOYALTY).toString());
                                            }
                                            if (!jsonLookup.isNull(CawJSONConstant.JSON_WO_CUSTOMER)) {
                                                jsonLookup = jsonLookup.getJSONObject(CawJSONConstant.JSON_WO_CUSTOMER);
                                            }
                                            return jsonLookup.toString();
                                            /* END BZ49801 */
                                        }
                                    }
                                    /* END BZ53072*/
                                }
                                /* END BZ29840 */
                            } else {
                                _logger.error("[lookupCustomerInEBS API response with an error]:" + customerTemplate.toString());
                            }
                        }
                        /* END BZ25118 */
                    }
                }
            } else {
                return esbResponse;
            }
            /* END BZ28033 */
        } catch (Exception ex) {
            _logger.error("Validate lookupCustomerInEBS:" + ex.getMessage());
        }
        return "";
    }

    /**
     * Look for Promotion for serial number
     * @param serialNumber
     * @return
     */
    public ResponseEntity<String> lookupPromotionInEBS(String serialNumber) {

        String promtionUrl = URL_PROMOTION_LOOKUP + "?serialNumber=" + serialNumber;
        _logger.info("[Call Promotion Lookup API Request]:" + promtionUrl); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(promtionUrl, null, HttpMethod.GET);
        /* BEGIN BZ29840 */
        if (response != null) {
            if(response.getStatusCode() == HttpStatus.OK) {
                if (CawCheetahHelper.getInstance().getResultCodeFromEBS(response) == RESPONSE_SUCCESS_CODE) {// BZ48692
                    _logger.info("[Promotion Lookup API Response]:" + response.getBody());
                } else {
                    _logger.info("[Promotion Lookup API response with an error code]:" + response.getStatusCode());
                }
            } else {
                _logger.error("[lookupPromotionInEBS API response with an error]:" + response.toString());
            }
        }
        /* END BZ29840 */
        return response;
    }

    /**
     * Reset Promotion for serial number
     * @param serialNumber
     */
    public void resetPromotionInEBS(String serialNumber) {

        String promtionUrl = URL_PROMOTION_RESET + "?serialNumber=" + serialNumber;
        _logger.info("[Call Promotion Reset API Request]:" + promtionUrl); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(promtionUrl, null, HttpMethod.PUT);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("Promotion Reset Response]:" + response.getBody());
            } else {
                _logger.info("[Promotion Reset response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
    }

    /**
     * reserve Promotion for Coupon number
     * @param reserveRequest
     */
    public void reservePromotionInEBS(String reserveRequest) {
        _logger.info("[Call Promotion Reserve API ]:" + URL_PROMOTION_RESERVE); //BZ29840
        _logger.info("[Call Promotion Reserve Request ]:" + reserveRequest); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(URL_PROMOTION_RESERVE, reserveRequest, HttpMethod.PUT);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Promotion Reserve Response]" + response.getBody());
            } else {
                _logger.info("[Promotion Reserve response with an error code]" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
    }

    /**
     * To check Customer Template is online or not
     * @return
     */
    public boolean isCustomerTemplateOnline() {

        try {
            ResponseEntity<String> result = sendRequestToEBS(URL_CUSTOMER_TEMPLATE, null, HttpMethod.GET);
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    return true;
                } else if (result.getStatusCode() == HttpStatus.REQUEST_TIMEOUT) {
                    return false;
                } else if (result.getStatusCode() == HttpStatus.BAD_REQUEST) {
                    return false;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    /**
     * 
     * @param careTakerRequest
     * @return
     */
    public ResponseEntity<String> sendCareTakerToEBS(String careTakerRequest) {

        /* BEGIN BZ28247 */
        _logger.info("[Call The Caretaker API]:" + URL_CARE_TAKER_REQUEST); //BZ29840
        _logger.info("[The Caretaker API Request]:" + careTakerRequest); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(URL_CARE_TAKER_REQUEST, careTakerRequest, HttpMethod.PUT);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Caretaker API response]:" + response.getStatusCodeValue());
            } else {
                _logger.info("[Caretaker API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
        return response;
        /* END BZ28247 */
    }

    /**
     * 
     * @param madeOfferRequest
     */
    public ResponseEntity<String> sendMadeOfferToEBS(String madeOfferRequest) {
        _logger.info("[Call The Made Offer API]:" + URL_MADE_OFFER_REQUEST); //BZ29840
        _logger.info("[The Made Offer API Request]:" + madeOfferRequest); //BZ29840
        /* BEGIN BZ28247*/
        ResponseEntity<String> response = sendRequestToEBS(URL_MADE_OFFER_REQUEST, madeOfferRequest, HttpMethod.PUT);
        /* END BZ28247*/
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Made Offer API Response]:" + response.getBody());
            } else {
                _logger.info("[Made Offer API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
        return response;
    }

    /**
     * Send the request and get catalyst results via Neuron service
     * @param catalystBody
     * @return
     */
    public ResponseEntity<String> sendCatalystResultsToEBS(String catalystBody) {

        ResponseEntity<String> response = sendRequestToEBS(URL_CATALYST_RESULTS, catalystBody, HttpMethod.POST);

        return response;
    }

    /**
     * Send the catalyst request and get response via Neuron service
     * @param catalystBody
     * @return
     */
    public ResponseEntity<String> sendCatalystRequestToEBS(String catalystBody) {
        ResponseEntity<String> response = sendRequestToEBS(URL_CATALYST_REQUEST, catalystBody, HttpMethod.POST);
        return response;
    }

    // Begin  BZ25435
    /**
     * Send the submit request and get response via Neuron service
     * @param submitRequest
     * @return
     */
    public ResponseEntity<String> sendCardServicesSubmitRequestToEBS(String submitRequest) {
        _logger.info("[Call Card Service Submit API]:" + CawEBSHelper.CARD_SERVICES_SUBMIT_REQUEST); //BZ29841
        _logger.info("[Card Service Submit API Request]:" + submitRequest);//BZ29841
        /* BEGIN BZ28247 */
        ResponseEntity<String> response = sendRequestToEBS(CARD_SERVICES_SUBMIT_REQUEST, submitRequest);
        /* END BZ28247 */
        /* BEGIN BZ29841*/
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Card Service Submit API Response]:" + response.getBody());
            } else {
                _logger.info("[Card Service Submit API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29841*/
        return response;
    }

    /**
     * Send the status request and get response via Neuron service
     * @param statusRequest
     * @return
     */
    public ResponseEntity<String> sendCardServicesSatusRequestToEBS(String statusRequest) {
        _logger.info("[Call Card Service Status API]:" + CawEBSHelper.CARD_SERVICES_STATUS_REQUEST); //BZ29841
        _logger.info("[Card Service Status API Request]:" + statusRequest);//BZ29841
        /* BEGIN BZ28247 */
        ResponseEntity<String> response = sendRequestToEBS(CARD_SERVICES_STATUS_REQUEST, statusRequest);
        /* END BZ28247 */
        /* BEGIN BZ29841*/
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Card Service Status API Response]:" + response.getBody());
            } else {
                _logger.info("[Card Service Status API response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29841*/
        return response;
    }
    // End  BZ25435

    // BZ26207 Begin Work Order session
    public ResponseEntity<String> responseWorkOrderSearch(String body) {

        _logger.info("[Call Work Order API Search]:" + URL_WORK_ORDER_SEARCH_REQUEST); //BZ29840
        _logger.info("[Work Order API Search Request]:" + body); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(URL_WORK_ORDER_SEARCH_REQUEST, body, HttpMethod.POST);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Work Order API Search Response]:" + response.getBody());
            } else {
                _logger.info("[Work Order API Search response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */

        return response;
    }

    /* BEGIN BZ30922 */
    public ResponseEntity<String> responseInventorySearch(String body) {

        _logger.info("[Call Inventory API Search]:" + URL_STORE_INVENTORY_REQUEST);
        _logger.info("[Inventory Search Request]:" + body);
        ResponseEntity<String> response = sendRequestToEBS(URL_STORE_INVENTORY_REQUEST, body, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Inventory API Search Response]:" + response.getBody());
            } else {
                _logger.info("[Inventory API Search response with an error code]:" + response.getStatusCode());
            }
        }

        return response;
    }
    /* END BZ30922 */

    public ResponseEntity<String> responseWorkOrderLookup(String body) {
        _logger.info("[Call Work Order API Lookup]:" + URL_WORK_ORDER_LOOKUP_REQUEST); //BZ29840
        _logger.info("[Work Order API Lookup Request]:" + body); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(URL_WORK_ORDER_LOOKUP_REQUEST, body, HttpMethod.POST);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Work Order API Lookup Response]:" + response.getBody());
            } else {
                _logger.info("[Work Order API Lookup response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */

        return response;
    }

    public ResponseEntity<String> responseWorkOrderUpdateStatus(String body) {

        _logger.info("[Call Work Order API Status]:" + URL_WORK_ORDER_UPDATE_STATUS_REQUEST); //BZ29840
        _logger.info("[Work Order API Status Request]:" + body); //BZ29840
        ResponseEntity<String> response = sendRequestToEBS(URL_WORK_ORDER_UPDATE_STATUS_REQUEST, body, HttpMethod.POST);
        /* BEGIN BZ29840 */
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Work Order API Status Response]:" + response.getBody());
            } else {
                _logger.info("[Work Order API Status response with an error code]:" + response.getStatusCode());
            }
        }
        /* END BZ29840 */
        return response;
    }
    // BZ26207 End Work Order session
    
    /*BEGIN BZ28036*/
    /**
     * Send the customer purchase history request and get response via Neuron service
     * @param historyBody
     * @return
     */
    public ResponseEntity<String> searchPurchaseHistoryToEBS(
            String historyBody) {

        _logger.info("[Call Customer purchase history API]:"
                + URL_CUSTOMER_PURCHASE_HISTORY);
        _logger.info("[The Customer purchase history request]:" + historyBody);

        ResponseEntity<String> response = sendRequestToEBS(URL_CUSTOMER_PURCHASE_HISTORY, historyBody, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("The Customer purchase history API response]:"
                        + response.getBody());
            } else {
                _logger.info("[The Customer purchase history API response with an error code]:"
                        + response.getStatusCode());
            }
        }
        return response;
    }

    /**
     * Send the detail history request and get response via Neuron service
     * @param detailHistoryBody
     * @return
     */
    public ResponseEntity<String> searchDetailHistoryToEBS(
            String detailHistoryBody) {

        _logger.info("[Call Customer detail history API]:"
                + URL_CUSTOMER_PURCHASE_HISTORY_DETAIL);
        _logger.info("[The Customer detail history request]:"
                + detailHistoryBody);

        ResponseEntity<String> response = sendRequestToEBS(URL_CUSTOMER_PURCHASE_HISTORY_DETAIL, detailHistoryBody, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("The Customer detail history API response]:"
                        + response.getBody());
            } else {
                _logger.info("[The Customer detail history API response with an error code]:"
                        + response.getStatusCode());
            }
        }
        return response;
    }
    /*END BZ28036*/
    
    /* BEGIN BZ37023 */
    /**
     * @param shippingRateRequest
     * @return
     */
    public ResponseEntity<String> sendShippingRateToEBS(String shippingRateRequest) {

        _logger.info("[Call The Shipping Rate API]:" + URL_SHIPPING_RATE_REQUEST);
        _logger.info("[The Shipping Rate API Request]:" + shippingRateRequest); 
        ResponseEntity<String> response = sendRequestToEBS(URL_SHIPPING_RATE_REQUEST, shippingRateRequest, HttpMethod.POST);
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Shipping Rate API response]:" + response.getBody());
            } else {
                _logger.info("[Shipping Rate API response with an error code]:" + response.getStatusCode());
            }
        }
        return response;
    }
    /* END BZ37023 */
    
    /* BEGIN BZ37396 */
    public ResponseEntity<String> sendTaxRequestToEBS(String taxBody) {
        _logger.info("[Call TAX API]:" + CawEBSHelper.URL_TAX_REQUEST);
        _logger.info("[TAX Request]:" + taxBody);
        ResponseEntity<String> response = sendRequestToEBS(URL_TAX_REQUEST, taxBody, HttpMethod.POST);
        _logger.info("[Tax Response]: " + response.getBody());
        return response;
    }
    /* END BZ37396 */
    
    /*BEGIN BZ44917*/
    public ResponseEntity<String> searchRvPayment(String rvPaymentBody) {
        _logger.info("[Call Rv Payment API]:" + CawEBSHelper.URL_RV_PAYMENT_REQUEST);
        _logger.info("[Rv Payment Request]:" + rvPaymentBody);
        ResponseEntity<String> response = null;
        if (CawEBSHelper.URL_RV_PAYMENT_REQUEST != null && CawEBSHelper.URL_RV_PAYMENT_REQUEST.length() > 0) {
            try {
                HttpHeaders httpHeaders = CawRestClientUtil.createHttpHeader(NEURON_USER, NEURON_KEY);
                HttpEntity<String> entity = null;
                if (rvPaymentBody != null && rvPaymentBody.length() > 0) {
                    entity = new HttpEntity<String>(rvPaymentBody, httpHeaders);
                } else {
                    entity = new HttpEntity<String>(httpHeaders);
                }
                response = CawRestClientUtil.callServiceAPIResponseEntity(CawEBSHelper.URL_RV_PAYMENT_REQUEST, HttpMethod.POST, entity);
                _logger.info("[Rv Payment Response]: " + response.getBody());
            } catch (Exception ex) {
                _logger.error("sendRequestToEBS-0: " + ex.getMessage());
            }
        } else {
            _logger.info("sendRequestToEBS: URL is null or empty");
        }
        return response;
    }
    /*END BZ44917*/
    
    /* BEGIN BZ45995 */
    public ResponseEntity<String> sendEmailValidationRequestToESB(String email) {
        
        String url = CawEBSHelper.URL_VALIDATE_EMAIL + CawConstants.QUESTION_MARK_STRING 
                + EMAIL_VALIDATION_EMAIL_PARAMETER_KEY + CawConstants.EQUAL_STRING + email;
        
        _logger.info("[Call Email validation API]: " + url );
        ResponseEntity<String> response = sendRequestToEBS(url, null, HttpMethod.GET);
        
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Email Validation Response]: " + response.getBody());
            } else {
                _logger.info("[Email Validation Response with an error code]:" + response.getStatusCode());
            }
        }
        
        return response;
    }
    /* END BZ45995 */
    
    /* BEGIN BZ42019 */
    public ResponseEntity<String> sendMailingValidationRequestToESB(String requestBody) {
        _logger.info("[Call Mailing validation API]: " + CawEBSHelper.URL_VALIDATE_MAILING);
        _logger.info("[Mailing Validation Request]: " + requestBody);
        ResponseEntity<String> response = sendRequestToEBS(CawEBSHelper.URL_VALIDATE_MAILING, requestBody);
        
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) {
                _logger.info("[Mailing Validation Response]: " + response.getBody());
            } else {
                _logger.info("[Mailing Validation Response with an error code]:" + response.getStatusCode());
            }
        }
        
        return response;
    }
    /* END BZ42019 */
}
