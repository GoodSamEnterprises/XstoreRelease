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
 * INT-92               260817    Customer Integration
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25435              150718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ28247              181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ33231              241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ40798              240221    Modification to member savings calculation
 * BZ48629              250222    [Task] Print Points Balances - Sale transaction
 * BZ50442              130622    Redemption data missing in request
 * BZ51770              181022    [Task[ Xstore needs to handle these additional updated submit order response from API
 * BZ51771              161122    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service. 
 * BZ53752              221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *== ================================================================
 */

package caw.rest.services;

import java.util.List;

import dtv.util.config.ConfigHelper;

/**
 * Helper class for getting the soap request from configuration file
 */
public class CawRestConfigHelper extends ConfigHelper<CawRestSetConfig> {
    public static final String  CATALYST0_REQUEST_TEMPLATE                = "CATALYST0_REQUEST_TEMPLATE"; //BZ33231

    private static final String REST_REQUEST_CONFIG                       = "RestRequestConfig";

    /*Begin BZ26575*/
    public static final String  MEMBERSHIP_VALIDATE_REQUEST_TEMPLATE      = "MEMBERSHIP_VALIDATE_REQUEST_TEMPLATE";

    public static final String  CATALYST_REQUEST_TEMPLATE                 = "CATALYST_REQUEST_TEMPLATE";

    public static final String  CATALYST_RESULT_TEMPLATE                  = "CATALYST_RESULT_TEMPLATE";

    /*end BZ26575 */
    
    /* BEGIN BZ28247 */
    public static final String  CARD_SERVICES_API_SUBMIT_REQUEST_TEMPLATE = "CARD_SERVICES_API_SUBMIT_REQUEST_TEMPLATE";

    public static final String  CARD_SERVICES_API_STATUS_REQUEST_TEMPLATE = "CARD_SERVICES_API_STATUS_REQUEST_TEMPLATE";
    
    public static final String  GOODSAM_VISA_MADEOFFER_TEMPLATE           = "GOODSAM_VISA_MADEOFFER_TEMPLATE";
    /* END BZ28247 */

    /* BEGIN BZ40798 */
    public static final String  CUST_MEMBER_ATTR                          = "CUST_MEMBER_ATTR";
    /* END BZ40798 */
    
    /*BEGIN BZ48629*/
    public static final String  REQUEST_LOYALTY_MEMBER_PROMOTIONS         = "REQUEST_LOYALTY_MEMBER_PROMOTIONS";

    public static final String  ITEMS_ATTR                                = "ITEMS_ATTR";
    /*END BZ48629*/
    
    //START BZ50442
    public static final String  REQUEST_LOYALTY_SUBMIT_ORDER              = "REQUEST_LOYALTY_SUBMIT_ORDER";
    public static final String  PROMO_OFFER_REDEMPTIONS                   = "PROMO_OFFER_REDEMPTIONS";
    public static final String  REWARD_POINTS_ALLOCATIONS                 = "REWARD_POINTS_ALLOCATIONS";
    public static final String  REWARD_REDEMPTION                         = "REWARD_REDEMPTION";
    //END BZ50442
    
    //BEGIN BZ51770 
    public static final String  LOYALTY_INFO_FOR_OS                            = "LOYALTY_INFO_FOR_OS";
    public static final String  POINT_EARNINGS_TEMPLATE                        = "POINT_EARNINGS_TEMPLATE";
    public static final String  REWARD_REDEMPTION_WITH_RESPONSE_CODE_TEMPLATE  = "REWARD_REDEMPTION_WITH_RESPONSE_CODE";
    //END BZ51770
    
    //BEGIN BZ51771
    public static final String  REQUEST_ITEMS_ATTR_FOR_CHEETAH_RETURN     = "REQUEST_ITEMS_ATTR_FOR_CHEETAH_RETURN";
    public static final String  PROMO_OFFER_REDEMPTIONS_FULL_INFO         = "PROMO_OFFER_REDEMPTIONS_FULL_INFO";
    //END BZ51771
    
    //BEGIN BZ53752
    public static final String  REQUEST_ITEMS_ATTR_FOR_CHEETAH_SALE       = "REQUEST_ITEMS_ATTR_FOR_CHEETAH_SALE";
    public static final String  REQUEST_ITEMS_ATTR_ORDER_SHIPPING_INFO    = "REQUEST_ITEMS_ATTR_ORDER_SHIPPING_INFO";
    public static final String  REQUEST_ITEMS_ATTR_ADJUSTMENTS            = "REQUEST_ITEMS_ATTR_ADJUSTMENTS";
    public static final String  CAW_REQUEST_CHEETAH_TENDER_ATTR           = "REQUEST_CHEETAH_TENDER_ATTR";
    //END BZ53752
    /**
     * 
     */
    public CawRestConfigHelper() {

        initialize();
    }

    /**
     * @return
     */
    public static CawRestConfigHelper getInstance() {

        return RestConfigHolder.INSTANCE;
    }

    /**
     * @param argRestRequestName
     * @return
     */
    public CawRestConfig getRestRequest(String argRestRequestName) {

        return getRootConfig().getRestConfig(argRestRequestName);
    }

    /**
     * @return
     */
    public List<CawRestConfig> getAllSoapRequest() {

        List<CawRestConfig> allSequences = getRootConfig().getAllRestConfigs();
        return allSequences;
    }

    /* (non-Javadoc)
     * @see dtv.util.config.ConfigHelper#getConfigFileName()
     */
    @Override
    protected String getConfigFileName() {

        return REST_REQUEST_CONFIG;
    }

    /**
     *
     */
    private static class RestConfigHolder {

        private static final CawRestConfigHelper INSTANCE = new CawRestConfigHelper();
    }
}