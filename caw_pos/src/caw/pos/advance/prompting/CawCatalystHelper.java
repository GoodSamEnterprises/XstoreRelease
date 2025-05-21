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
 * BZ23052          200927    Implement Advanced Prompting
 * BZ23541          280817    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4 
 * BZ23637          280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28529          051218    [Internal] Error with Prompt Engine when sending Prompt Engine result
 * BZ28533          061218    [Internal] Help Desk Error when fisnish transaction with a customer
 * BZ28608          121218    [Internal][28441] PE 'GS RA JOIN' displays unexpectedly on Xstore at catalyst= 1 although there are no response PE data from Neuron API.
 * BZ28626          121218    Allow Has email input text box from EBS is not required
 * BZ30315          230419    [INTERNAL] Can not skip captured customer email
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ35054          180220    [Ported the fix from patch 8 to Xstore 6.0][Prod] Roadside Assistance prompt on a crew account
 * BZ39446          171120    [TASK] Not need to required the customer for Roundup transaction
 * BZ48848          270422    [Internal] - Loyalty information is NOT displayed on Membership Info tab.
 * BZ50032          250522    [Task] Loyalty - Using Oauth2 security to access the new service
 * BZ50442          130622    Redemption data missing in request
 * BZ53547          161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.cheetah.promotion.CawPromotionModel;
import caw.pos.cheetah.reward.CawRewardModel;
import caw.pos.cheetah.util.CawCheetahTokenModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawEBSConstant;
import twitter4j.*;

import dtv.pos.common.ConfigurationMgr;
import dtv.util.CollectionUtils;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.crm.IParty;

public class CawCatalystHelper {

    private static final Logger                                _logger                   = LogManager
            .getLogger(CawCatalystHelper.class);

    private static JSONArray                                   catalystDirectiveResponse = null;

    private static JSONArray                                   catalystMessageResponse   = null;

    private static JSONArray                                   catalystInputsResponse    = null;

    private static Long                                        customerPartyId           = 0L;

    private static String                                      lookupResponseData        = null;                                           //BZ23637

    private static String                                      lookupLoyaltyResponseData = null; //BZ48848
    
    public static CawCheetahTokenModel                         tokenResponseModel        = null;/*BZ50032*/
    
    private static final Map<Integer, CawCatalysCallBackModel> inputDataLs               = new HashMap<Integer, CawCatalysCallBackModel>();//BZ23541
    
    //Start BZ50442
    private static List<CawPromotionModel>                     offerApplyLoyalty         = null;
    
    private static CawRewardModel                              rewardApplyLoyalty        = null;
    //End BZ50442
    
    //BEGIN BZ53547 
    private static String                                      lookupResponseDataUseThirdPartyTender                = null; 
    private static String                                      lookupResponseLoyaltyDataUseThirdPartyTender         = null;
    private static IParty                                      selectedCustomerUseThirdPartyTender                  = null; 
    //END BZ53547 
    
    public static JSONArray getCatalystDirectiveResponse() {

        return catalystDirectiveResponse;
    }

    
    /**
     * @return the offerApplyLoyalty
     */
    public static List<CawPromotionModel> getOfferApplyLoyalty() {
    
        return offerApplyLoyalty;
    }

    
    /**
     * @param argOfferApplyLoyalty the offerApplyLoyalty to set
     */
    public static void setOfferApplyLoyalty(List<CawPromotionModel> argOfferApplyLoyalty) {
    
        offerApplyLoyalty = argOfferApplyLoyalty;
    }

    
    /**
     * @return the rewardApplyLoyalty
     */
    public static CawRewardModel getRewardApplyLoyalty() {
    
        return rewardApplyLoyalty;
    }

    
    /**
     * @param argRewardApplyLoyalty the rewardApplyLoyalty to set
     */
    public static void setRewardApplyLoyalty(CawRewardModel argRewardApplyLoyalty) {
    
        rewardApplyLoyalty = argRewardApplyLoyalty;
    }

    public static void setCatalystDirectiveResponse(JSONArray argCatalystDirectiveResponse) {

        catalystDirectiveResponse = argCatalystDirectiveResponse;
    }

    public static JSONArray getCatalystMessageResponse() {

        return catalystMessageResponse;
    }

    public static void setCatalystMessageResponse(JSONArray argCatalystMessageResponse) {

        catalystMessageResponse = argCatalystMessageResponse;
    }

    public static JSONArray getCatalystInputsResponse() {

        return catalystInputsResponse;
    }
    
    //Start BZ50032

    public static CawCheetahTokenModel getTokenResponseModel() {
    
        return tokenResponseModel;
    }

    public static void setTokenResponseModel(
            CawCheetahTokenModel argTokenResponseModel) {
    
        tokenResponseModel = argTokenResponseModel;
    }
    //End BZ50032
    /* Begin BZ28529/BZ28533 */
    /**
     * @param argCatalystInputsResponse
     */
    public static void setCatalystInputsResponse(JSONArray argCatalystInputsResponse) {

        JSONArray perfectJsonResponse = new JSONArray();
        /*Begin BZ-28608*/
        if (argCatalystInputsResponse == null) {
            catalystInputsResponse = null;
        } else {
            try {
                for (int i = 0; i < argCatalystInputsResponse.length(); i++) {
                    Object object = argCatalystInputsResponse.get(i);
                    if (object instanceof JSONObject) {
                        perfectJsonResponse.put(argCatalystInputsResponse.get(i));
                    }
                }
                catalystInputsResponse = perfectJsonResponse;

            } catch (JSONException ex) {
                _logger.error("Can not parse the perfectJsonResponse Data from Catalyst API response."
                        + ex.getMessage());
            }
        }
        /*End BZ-28608*/
    }

    /* End BZ28529/BZ28533 */

    public static JSONArray removeElementOfJsonArray(JSONArray jsonArray, int type) throws JSONException {

        JSONArray list = new JSONArray();
        int len = jsonArray.length();

        for (int i = 0; i < len; i++) {
            if (jsonArray.getJSONObject(i).getLong(CawEBSConstant.TYPE_ATTR) != type) {
                list.put(jsonArray.get(i));
            }
        }

        return list;
    }

    /**
     * 
     * @param jsonArray
     * @param itemCode
     * @return
     * @throws JSONException
     */
    public static JSONArray removeItemOfJsonArray(JSONArray jsonArray, String itemCode) throws JSONException {

        JSONArray list = new JSONArray();
        int len = jsonArray.length();

        JSONObject tempObj = null;
        String itemCodeTemp = null;
        for (int i = 0; i < len; i++) {
            if (jsonArray.getJSONObject(i).getLong(CawEBSConstant.TYPE_ATTR) == 3) {
                tempObj = jsonArray.getJSONObject(i);
                if (tempObj != null && !tempObj.isNull(CawEBSConstant.PROPERTIES_ATTR)
                        && !tempObj.getJSONObject(CawEBSConstant.PROPERTIES_ATTR).isNull("itemCode")) {
                    itemCodeTemp = tempObj.getJSONObject(CawEBSConstant.PROPERTIES_ATTR).getString("itemCode");
                    if (!itemCode.equals(itemCodeTemp)) {
                        list.put(jsonArray.get(i));
                    }
                }
            } else {
                list.put(jsonArray.get(i));
            }
        }

        return list;
    }

    /**
     * 
     * @param jsonObject
     * @param directiveType
     * @return
     */
    public static JSONArray catalystDataByType(JSONObject jsonObject, String directiveType) {

        JSONArray jsonData = null;
        if (jsonObject != null && directiveType != null) {
            try {
                if (jsonObject.getJSONArray(directiveType).length() > 0) {
                    jsonData = jsonObject.getJSONArray(directiveType);
                }
            } catch (Exception ex) {
                _logger.error("Can not get data from Catalyst API response." + ex.getMessage());
            }
        }
        return jsonData;

    }

    public static Long getCustomerPartyId() {

        return customerPartyId;
    }

    public static void setCustomerPartyId(Long argCustomerPartyId) {

        customerPartyId = argCustomerPartyId;
    }

    // Begin BZ23541
    public static Map<Integer, CawCatalysCallBackModel> getInputdatals() {

        return inputDataLs;
    }
    // End BZ23541

    // Begin BZ23637
    public static String getLookupResponseData() {

        return lookupResponseData;
    }

    public static void setLookupResponseData(String argLookupResponseData) {

        lookupResponseData = argLookupResponseData;
    }

    // End BZ23637
    
    /* Begin BZ48848 */
    public static String getLookupLoyaltyResponseData() {

        return lookupLoyaltyResponseData;
    }

    public static void setLookupLoyaltyResponseData(String argLookupLoyaltyResponseData) {

        lookupLoyaltyResponseData = argLookupLoyaltyResponseData;
    }
    // End BZ48848
    /* Begin BZ28265 */
    /**
     * Get olpsPrescreenId from JSON object
     * @param jsonObject
     * @return
     */
    public static String getDirectiveType(JSONObject jsonObject) {
        try {
            if (jsonObject != null && jsonObject.getInt(CawConstants.OLPS_TYPE) == 7) {
                JSONObject properties = jsonObject.getJSONObject(CawConstants.OLPS_PROPERTIES);

                String olpsPrescreenID = properties.getString(CawConstants.OLPS_PRESCREEN_ID);

                return olpsPrescreenID;

            }
        } catch (JSONException ex) {
            _logger.error("Can not get the PRESCREEN ID from JSONObject." + ex.getMessage());
        }
        return "";
    }

    /**
     * Check if the Card Services is turned ON
     * @return
     */
    public static boolean isCardServicesTurnedOn() {

        ICodeValue iCodeValue = CodeLocator.getCodeValue(ConfigurationMgr
                .getOrganizationId(), CawConstants.CAW_TURN_ON_CARD_SERVICES, CawConstants.CARD_SEVICES);

        if (iCodeValue != null) {
            return true;
        }
        return false;
    }

    /* BEGIN BZ33231 */
    /**
     * Check if the Prompting Engine is turned ON
     * @return
     */
    public static boolean isCardPromptingEngineTurnedOn(String typeCatalyst) {

        ICodeValue iCodeValue = CodeLocator
                .getCodeValue(ConfigurationMgr.getOrganizationId(), typeCatalyst, CawConstants.PROMPTING_ENGINE);

        if (iCodeValue != null) {
            return true;
        }
        return false;
    }
    /* END BZ33231 */
    /*End BZ28265 */

    /* Begin BZ28626
    /**
     * Check if the input Optional 
     * @return
     */
    public static boolean checkInputOptionalField(String inputDescription) {

        /* Begin BZ30315 */
        boolean isValid = false;
        if (StringUtils.isNotEmpty(inputDescription)) {
            List<? extends ICodeValue> codeValues = CodeLocator
                    .getCodeValues(ConfigurationMgr
                            .getOrganizationId(), CawConstants.CAW_CAT_INPUT_OPTIONAL_FIELD);
            if (codeValues != null && codeValues.size() > 0) {
                for (ICodeValue iCodeValue : codeValues) {
                    if (inputDescription.contains(iCodeValue.getCode())) {
                        isValid = true;
                        break;
                    }
                }
            }
        }
        /* End BZ30315 */

        return isValid;
    }

    /* End BZ28626*/

    /* BEGIN BZ35054 */
    /***
     * The function to check catalyst directive exist type value equal 8 
     * @param directivesObj JSONArray is catalyst directive
     * @return
     */
    public static boolean checkCatalystDirectiveType8() {

        boolean isDirectivetype8 = false;
        try {
            JSONArray directivesObj = getCatalystDirectiveResponse();
            if (directivesObj != null && directivesObj.length() > 0) {

                JSONObject directive = null;
                int length = directivesObj.length();
                for (int i = 0; i < length; i++) {
                    directive = directivesObj.getJSONObject(i);
                    if (directive != null) {
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == CawDirectiveType.SUSPEND_PROMPTING
                                                .getType()) {
                            isDirectivetype8 = true;
                            break;
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Method checkCatalystDirectiveType8() cannot get directive 8." + ex.getMessage());
        }
        return isDirectivetype8;
    }
    
    public static void clearDirectiveExceptType8() {

        if (checkCatalystDirectiveType8()) {
            try {
                JSONObject directive8 = new JSONObject();
                directive8.put(CawEBSConstant.TYPE_ATTR, CawDirectiveType.SUSPEND_PROMPTING.getType());
                directive8.put(CawEBSConstant.PROPERTIES_ATTR, "");
                
                JSONArray directiveJSArr = new JSONArray();
                directiveJSArr.put(directive8);
                
                setCatalystDirectiveResponse(directiveJSArr);
            } catch (JSONException ex) {
                _logger.error("Method clearDirectiveExceptType8() cannot create directive 8." + ex.getMessage());
            }
        } else {
            setCatalystDirectiveResponse(null);
        }
    }
    /* END BZ35054 */
    
    // Start BZ-39446
    /**
     * Check if the prompting require customer 
     * @param promptingResponse
     * @return 
     */
    public static boolean checkPromtingResponseRequireCustomer(String promptingResponse) {

        boolean isRequestCustomer = true;
        Collection<? extends ICodeValue> codes = 
                CodeLocator.getCodeValues(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_CAT_NOT_REQUIRED_CUSTOMER);
        
        if (StringUtils.isNotEmpty(promptingResponse)
                && CollectionUtils.isNotEmpty(codes)) {

            for (ICodeValue code : codes) {
                if (promptingResponse.contains(code.getCode())) {
                    isRequestCustomer = false;
                    break;
                }
            }
        }

        return isRequestCustomer;
    }
    
    /**
     * @param argCallBackModes
     * @return
     */
    public static boolean checkPromtingResponseRequireCustomer(Map<Integer, CawCatalysCallBackModel> argCallBackModes) {
        boolean isRequestCustomer = true;
        
        for (Entry<Integer, CawCatalysCallBackModel> model : argCallBackModes.entrySet()) {
            if(!CawCatalystHelper.checkPromtingResponseRequireCustomer(model.getValue().getDescription())) {
                isRequestCustomer = false;
                break;
            }
        }
        
        return isRequestCustomer;
    }
    // End BZ-39446
    

    
    /**
     * @return the lookupResponseDataUseThirdPartyTender
     */
    public static String getLookupResponseDataUseThirdPartyTender() {
    
        return lookupResponseDataUseThirdPartyTender;
    }


    
    /**
     * @param argLookupResponseDataUseThirdPartyTender the lookupResponseDataUseThirdPartyTender to set
     */
    public static void setLookupResponseDataUseThirdPartyTender(
            String argLookupResponseDataUseThirdPartyTender) {
    
        lookupResponseDataUseThirdPartyTender = argLookupResponseDataUseThirdPartyTender;
    }


    
    /**
     * @return the lookupResponseLoyaltyDataUseThirdPartyTender
     */
    public static String getLookupResponseLoyaltyDataUseThirdPartyTender() {
    
        return lookupResponseLoyaltyDataUseThirdPartyTender;
    }


    
    /**
     * @param argLookupResponseLoyaltyDataUseThirdPartyTender the lookupResponseLoyaltyDataUseThirdPartyTender to set
     */
    public static void setLookupResponseLoyaltyDataUseThirdPartyTender(
            String argLookupResponseLoyaltyDataUseThirdPartyTender) {
    
        lookupResponseLoyaltyDataUseThirdPartyTender = argLookupResponseLoyaltyDataUseThirdPartyTender;
    }


    
    /**
     * @return the selectedCustomerUseThirdPartyTender
     */
    public static IParty getSelectedCustomerUseThirdPartyTender() {
    
        return selectedCustomerUseThirdPartyTender;
    }


    
    /**
     * @param argSelectedCustomerUseThirdPartyTender the selectedCustomerUseThirdPartyTender to set
     */
    public static void setSelectedCustomerUseThirdPartyTender(
            IParty argSelectedCustomerUseThirdPartyTender) {
    
        selectedCustomerUseThirdPartyTender = argSelectedCustomerUseThirdPartyTender;
    }



}
