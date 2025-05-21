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
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37642          030920    [Internal] Xstore makes a Shipping Rates API request to Neuron API included a few value of attributes/tags into the body request does not match to specification Neuron API.
 * BZ37901          150920    [Internal] Xstore should be displayed exactly message retrieved from Neuron API for restricted shipping items instead of incorrectly offline status
 * BZ37630          140920    [Requirement] Configuring location makes shipping rates services method request for all BTM's store is default number: 951 for now.
 * BZ38022          210920    [Task] Xstore should use ServiceLevel of shipping method already selected into Xstore to parse data to OB during doing Delivery Order transaction.
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ38353          091020    [Internal] Need to be shown SKU items also shipping rate value of each service level displaying on the Shipping method screen.
 * BZ38387          091020    [Internal] Xstore should not make a call Shipping API at Add tender button when doing Cancel Delivery_Order
 * BZ38382          121020    [Internal] Shipping via/method should only be applied to line item when Xstore is completed selected method and fee for all items into transaction.
 * BZ38351          091020    [Internal] Xstore goes auto Authorizer Message prompt unexpected after Xstore receives exception shipping method about Item restricted
 * BZ38384          131020    [Internal] Xstore does not make a call Shipping API at Exit Order button when mixing order items firstly then Sale items types.
 * BZ38442          131020    [TASK] Handling about calculate shipping Fee of Delivery order included a regular item, restricted item with additional freight, and freight quote item
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.text.*;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawEBSConstant;
import caw.pos.common.CawUtilFunction;
import caw.pos.util.CawEBSHelper;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.inv.IShipperMethod;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.*;
import dtv.xst.dao.xom.impl.OrderModel;
import dtv.xst.xom.impl.order.OrderType;

/**
 * The CawShippingRateHelper
 */
public class CawShippingRateHelper implements CawShipperMethodConsIfc {

    /**
     * The logger
     */
    private static final Logger                   logger   = Logger
            .getLogger(CawShippingRateHelper.class);

    /**
     * The INSTANCE
     */
    private static volatile CawShippingRateHelper INSTANCE = null;

    public static CawShippingRateHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawShippingRateHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawShippingRateHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @param trans
     * @return
     */
    private String buildCorrelationKey(IRetailTransaction trans) {

        String storeID = String.valueOf(trans.getRetailLocationId());

        String regID = String.valueOf(trans.getWorkstationId());

        String transSeq = String.valueOf(trans.getTransactionSequence());

        Date bsnDate = trans.getBusinessDate();

        storeID = String.format("%4s", storeID).replace(' ', ZERO_CHAR);

        regID = String.format("%2s", regID).replace(' ', ZERO_CHAR);

        transSeq = String.format("%4s", transSeq).replace(' ', ZERO_CHAR);

        DateFormat df = new SimpleDateFormat(DATE_FORMAT);

        String correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID
                + ":" + transSeq;

        return correlationKey;
    }

    /**
     * @param argString
     * @return
     */
    public String formatParameter(String argString) {

        return argString != null ? "\"" + argString + "\"" : NULL_STRING;
    }
    
    /* BEGIN BZ37901 */
    /**
     * @param ebsResponse
     * @return
     */
    public static boolean hasErrorResponse(ResponseEntity<String> ebsResponse) {

        boolean hasError = false;

        if (ebsResponse != null && ebsResponse.getStatusCodeValue() == 200) {
            try {
                JSONObject jsonObjectRoot = new JSONObject(ebsResponse.getBody());

                if (jsonObjectRoot.has(HAS_ERROR)) {
                    hasError = jsonObjectRoot.getBoolean(HAS_ERROR);

                    if (hasError) {
                        hasError = false;
                    }
                }
            } catch (JSONException ex) {
                logger.error("Could not parse Shipper Methods "
                        + ex.getMessage());
            }
        } else if(ebsResponse != null && ebsResponse.getStatusCodeValue() != 200) {
            hasError = true;
        }

        return hasError;
    }

    /**
     * @param orderModel
     * @return
     */
    public String buildShippingItems(IOrder orderModel) {

        StringBuilder sbItem = new StringBuilder();

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.ORDER_SHIPPING_ITEMS);

        String body = request.getBody();

        String result = "";

        if (orderModel != null) {
            List<IOrderLine> orderLines = orderModel.getOrderLines();

            if (orderLines != null && orderLines.size() > 0) {
                sbItem.append("[");
                for (IOrderLine itm : orderLines) {
                    /* BEGIN BZ37912 */
                    
                    if (!itm.getVoid()) {
                        result = body;

                        result = result.replace(ITEM_CODE, CawUtilFunction
                                .formatParameter(itm.getItemId()));

                        result = result
                                .replace(QUANTITY, itm.getQuantity() != null
                                        ? itm.getQuantity().toString()
                                        : "1");
                        if (sbItem.length() > 1) {
                            sbItem.append(",");
                        }
                        sbItem.append(result);
                    }
                    /* END BZ37912 */

                }
                if (sbItem.length() > 0) {
                    sbItem.append("]");
                }

            }
            return sbItem.toString();
        }
        return null;
    }

    /**
     * @param trans
     * @param xmlResponse
     * @param ebsResponse
     * @param applicationType
     * @return
     */
    public String getShippingRateAllItemsTemplate(IRetailTransaction trans, IOrder orderModel) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.SHIPPING_RATE_ALL_ITEMS_TEMPLATE);

        String body = request.getBody();

        if (trans != null && orderModel != null) {

            body = body
                    .replace(SALE_CHANEL_ID, orderModel.getOrderLocationId());

            body = body
                    .replace(SALE_CHANNEL_TYPE, CawEBSConstant.SHIPPING_CHANNEL_TYPE_RETAIL);

            body = body.replace(CHANNEL_TYPE_DESCRIPTION, CawUtilFunction
                    .formatParameter(CawEBSConstant.CHANNEL_TYPE_DESCRIPTION));

            body = body
                    .replace(CORRELATION_KEY, formatParameter(buildCorrelationKey(trans)));

            body = body.replace(DESCRIPTION, CawUtilFunction
                    .formatParameter(CawEBSConstant.DESCRIPTION));

            body = body.replace(PREFERENCE, "1");
        }

        // BUILD ITEMS
        String items = buildShippingItems(orderModel);

        if (StringUtils.isNotEmpty(items)) {
            body = body.replace(ORDER_SHIPPING_ITEMS, items);
        }

        // BUILD SHIPPING INFO
        String shippingInfo = buildShippingInfo(orderModel);
        if (StringUtils.isNotEmpty(shippingInfo)) {
            body = body.replace(ORDER_SHIPPING_INFO, shippingInfo);
        }

        // BUILD CLUD MEMBERSHIP PRICING AND ORDER TOTAL
        if (trans != null) {

            IParty party = trans.getCustomerParty();

            if (party != null && CawCustomerUtil.isUseMemberPricing(party)) {
                body = body
                        .replace(USE_MEMBER_PRICING, Boolean.TRUE.toString());
            } else {
                body = body
                        .replace(USE_MEMBER_PRICING, Boolean.FALSE.toString());
            }
        }

        // BUILD ORDER TOTAL
        BigDecimal orderTotal = buildOrderTotal(orderModel);
        if (orderTotal != null) {
            body = body.replace(ORDER_TOTAL, orderTotal.toString());
        } else {
            body = body.replace(ORDER_TOTAL, BigDecimal.ZERO.toString());
        }

        return body;
    }

    /**
     * @param orderModel
     * @return
     */
    public BigDecimal buildOrderTotal(IOrder orderModel) {

        BigDecimal orderTotal = new BigDecimal(0);
        BigDecimal extPrice;
        
        if (orderModel != null) {
            List<IOrderLine> orderLines = orderModel.getOrderLines();

            for (IOrderLine orderLine : orderLines) {
                extPrice = orderLine.getExtendedPrice();

                if (extPrice != null) {
                    orderTotal = orderTotal.add(extPrice);
                }
            }
        }
        return orderTotal;
    }

    /**
     * @param argOrderModel
     * @return
     */
    public String buildShippingInfo(IOrder argOrderModel) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.ORDER_SHIPPING_INFO);

        String body = "";
        String value;
        if (request != null) {
            body = request.getBody();
        }

        if (argOrderModel != null && StringUtils.isNotEmpty(body)) {

            List<IOrderLine> orderLines = argOrderModel.getOrderLines();

            if (orderLines != null && orderLines.size() > 0) {
                IFulfillmentModifier fulfillment = orderLines.get(0)
                        .getFulfillmentModifier();

                if (fulfillment != null) {

                    body = body.replace(NAME, CawUtilFunction.formatParameter(fulfillment.getLocationName1()
                                    + " " + fulfillment.getLocationName2()));
                    if (fulfillment.getAddress() != null) {
                        
                        value = fulfillment.getAddress().getAddress1();
                        body = body.replace(LINE1, CawUtilFunction.formatParameter(value));

                        value = fulfillment.getAddress().getCity();
                        body = body.replace(CITY, CawUtilFunction.formatParameter(value));

                        value = fulfillment.getAddress().getState();
                        body = body.replace(STATEPROVINCE, CawUtilFunction.formatParameter(value));

                        value = fulfillment.getAddress().getPostalCode();
                        body = body.replace(POSTAL_CODE, CawUtilFunction.formatParameter(value));

                        value = fulfillment.getAddress().getCountry();
                        body = body.replace(COUNTRY, CawUtilFunction.formatParameter(value));
                    }
                }
            }
        }

        return body;
    }

    /**
     * @param jsonObjEachGroup
     * @return
     */
    public static List<String> parseListDescription(JSONObject jsonObjEachGroup) {

        String[] shippingDes = null;
        String jsonDescription;
        List<String> descriptions = new ArrayList<String>();

        if (jsonObjEachGroup != null && jsonObjEachGroup.has("description")) {
            
            try {
                jsonDescription = jsonObjEachGroup.getString("description");

                if (StringUtils.isNotEmpty(jsonDescription)) {
                    shippingDes = jsonDescription.split(",");

                    if (shippingDes != null && shippingDes.length > 0) {

                        for (int i = 0; i < shippingDes.length; i++) {
                            descriptions.add(shippingDes[i]);
                        }
                    }

                }
            } catch (JSONException ex) {
                logger.error("Could not parse description " + ex.getMessage());
            }

        }
        return descriptions;
    }

    /**
     * @param ebsResponse
     * @return
     */
    public static List<CawShippingGroupsModel> parseShippingGroupRates(
            ResponseEntity<String> ebsResponse)

    {
        //String responseTest="{\"hasErrors\":false,\"errors\":[],\"hasHolds\":false,\"holds\":[],\"shippingPreferences\":[{\"correlationKey\":\"20200312:0645:02:3150\",\"description\":\"Deliver to Home\",\"preference\":1,\"preferenceDescription\":\"ShipToHome\",\"items\":[{\"itemCode\":\"100006\",\"quantity\":1.0,\"properties\":null},{\"itemCode\":\"100008\",\"quantity\":2.0,\"properties\":null},{\"itemCode\":\"100039\",\"quantity\":2.0,\"properties\":null}],\"shipToInfo\":{\"name\":\"THANH NGUYEN\",\"company\":null,\"line1\":\"2944 GLEN ALDEN CT\",\"line2\":null,\"line3\":null,\"city\":\"SAN JOSE\",\"stateProvince\":\"CA\",\"postalCode\":\"95148-4103\",\"country\":\"US\",\"addressType\":1,\"addressTypeDescription\":\"Residential\",\"shipVia\":null,\"serviceLevel\":0,\"serviceLevelDescription\":\"NotSpecified\"},\"useMemberPricing\":false,\"minZone\":3,\"maxZone\":8,\"shippingGroups\":[{\"description\":\"Standard Ground, Expedited Ground, Two Day Air, Next Day Air\",\"items\":[{\"itemCode\":\"100006\",\"quantity\":1.0,\"properties\":null},{\"itemCode\":\"100008\",\"quantity\":2.0,\"properties\":null}],\"shippingOptions\":[{\"serviceLevel\":1,\"serviceLevelDescription\":\"StandardGround\",\"price\":9.95,\"additionalPH\":0.0,\"total\":9.95,\"minDeliveryDate\":\"2020-10-13\",\"maxDeliveryDate\":\"2020-10-14\"},{\"serviceLevel\":2,\"serviceLevelDescription\":\"ExpeditedGround\",\"price\":14.95,\"additionalPH\":0.0,\"total\":14.95,\"minDeliveryDate\":\"2020-10-09\",\"maxDeliveryDate\":\"2020-10-12\"},{\"serviceLevel\":4,\"serviceLevelDescription\":\"TwoDayAir\",\"price\":24.95,\"additionalPH\":0.0,\"total\":24.95,\"minDeliveryDate\":\"2020-10-05\",\"maxDeliveryDate\":\"2020-10-05\"},{\"serviceLevel\":8,\"serviceLevelDescription\":\"NextDayAir\",\"price\":29.95,\"additionalPH\":0.0,\"total\":29.95,\"minDeliveryDate\":\"2020-10-02\",\"maxDeliveryDate\":\"2020-10-02\"}],\"shipWeight\":1},{\"description\":\"Standard Ground\",\"items\":[{\"itemCode\":\"100039\",\"quantity\":2.0,\"properties\":null}],\"shippingOptions\":[{\"serviceLevel\":1,\"serviceLevelDescription\":\"StandardGround\",\"price\":9.95,\"additionalPH\":0.0,\"total\":9.95,\"minDeliveryDate\":\"2020-10-13\",\"maxDeliveryDate\":\"2020-10-14\"}],\"shipWeight\":2}]}]}";

        List<CawShippingGroupsModel> shippingGroupsModels = new ArrayList<CawShippingGroupsModel>();
        List<String> descriptions = new ArrayList<String>();
        List<CawShipperMethodAPIModel> shipperMethodApiModels = new ArrayList<CawShipperMethodAPIModel>();
        List<CawShippingItemsModel> shippingItemsModels = new ArrayList<CawShippingItemsModel>();
        JSONArray jsonArrayShippingGroups;
        JSONObject jsonObject;
        JSONObject jsonObjEachGroup;
        CawShippingGroupsModel shippingGroupsModel;

        try {
            JSONObject jsonObjectRoot = new JSONObject(ebsResponse.getBody());

            if (jsonObjectRoot.has(SHIPPING_PREFERENCES)) {
                JSONArray jsonArrayShippPre = jsonObjectRoot.getJSONArray(SHIPPING_PREFERENCES);

                if (jsonArrayShippPre != null && jsonArrayShippPre.length() > 0) {
                    
                    jsonObject = jsonArrayShippPre.getJSONObject(0);
                    if (jsonObject != null && jsonObject.has(SHIPPING_GROUPS)) {
                        
                        jsonArrayShippingGroups = jsonObject.getJSONArray(SHIPPING_GROUPS);
                        if (jsonArrayShippingGroups != null && jsonArrayShippingGroups.length() > 0) {
                            for (int i = 0; i < jsonArrayShippingGroups.length(); i++) {

                                jsonObjEachGroup = jsonArrayShippingGroups.getJSONObject(i);
                                
                                shippingGroupsModel = new CawShippingGroupsModel();
                                shippingGroupsModel.setGroupId(i);
                                
                                // GET THE LIST DESCRIPTION
                                descriptions = parseListDescription(jsonObjEachGroup);
                                // SET DESCRIPTION TO SHIPPING GROUP MODEL
                                shippingGroupsModel.setDescription(descriptions);
                                // PARSE ITEM LIST OF THIS GROUP
                                shippingItemsModels = parseListItemsGroup(jsonObjEachGroup);
                                shippingGroupsModel.setShippingItemsModels(shippingItemsModels);

                                // PARSE SHIPPING METHODS
                                shipperMethodApiModels = parseListShippingMethods(jsonObjEachGroup, i);
                                shippingGroupsModel.setShipperMethodAPIModels(shipperMethodApiModels);

                                shippingGroupsModels.add(shippingGroupsModel);
                            }
                        }
                    }
                }
            }

        } catch (JSONException ex) {
            logger.error("Could not parse Shipper Methods " + ex.getMessage());
        }

        return shippingGroupsModels;
    }

    /**
     * @param argJsonObjEachGroup
     * @return
     */
    private static List<CawShipperMethodAPIModel> parseListShippingMethods(JSONObject argJsonObjEachGroup, int groupId) {

        List<CawShipperMethodAPIModel> shipperMethodApiModels = new ArrayList<CawShipperMethodAPIModel>();
        CawShipperMethodAPIModel shippingMethodApiModel;
        JSONArray jsonArrayShippOptions;
        String shippingMethodId = "";
        String serviceLevelDescription = "";
        Double price = null;
        /* BEGIN BZ38442 */
        Double total = null;
        Double addtionalPH = null;
        /* END BZ38442 */
        
        try {

            if (argJsonObjEachGroup != null && argJsonObjEachGroup.has(SHIPPING_OPTIONS)) {
                jsonArrayShippOptions = argJsonObjEachGroup.getJSONArray(SHIPPING_OPTIONS);

                for (int i = 0; i < jsonArrayShippOptions.length(); i++) {

                    JSONObject jsonShippingMethod = jsonArrayShippOptions.getJSONObject(i);

                    if (jsonShippingMethod != null) {

                        shippingMethodApiModel = new CawShipperMethodAPIModel();

                        if (jsonShippingMethod.has(SERVICE_LEVEL)) {
                            shippingMethodId = jsonShippingMethod.getString(SERVICE_LEVEL);
                        }
                        if (jsonShippingMethod.has(SERVICE_DES)) {
                            serviceLevelDescription = jsonShippingMethod
                                    .getString(SERVICE_DES);
                        }
                        if (jsonShippingMethod.has(PRICE)) {
                            price = (Double) jsonShippingMethod.get(PRICE);
                        }
                        
                        /* BEGIN BZ38442 */
                        if(jsonShippingMethod.has(ADDITIONNAL_PH)) {
                            addtionalPH = (Double) jsonShippingMethod.get(ADDITIONNAL_PH);                            
                        }
                        
                        if(jsonShippingMethod.has(TOTAL)) {
                            total = (Double) jsonShippingMethod.get(TOTAL);                            
                        }
                        /* END BZ38442 */

                        if (StringUtils.isNotEmpty(shippingMethodId)
                                && StringUtils.isNotEmpty(serviceLevelDescription)
                                && price != null && total!=null) {

                            shippingMethodApiModel.setGroupId(groupId);
                            shippingMethodApiModel.setShipperMethodId(shippingMethodId);
                            shippingMethodApiModel.setShipperMethodDesc(serviceLevelDescription);
                            shippingMethodApiModel.setFeePrice(BigDecimal.valueOf(price.doubleValue()));
                            /* BEGIN BZ38442 */
                            if (addtionalPH != null) {
                                shippingMethodApiModel.setAdditionalPH(BigDecimal.valueOf(addtionalPH.doubleValue()));
                            }
                            shippingMethodApiModel.setFeeTotal(BigDecimal
                                    .valueOf(total.doubleValue()));
                            /* END BZ38442 */
                            shipperMethodApiModels.add(shippingMethodApiModel);
                        }
                    }
                }
            }

        } catch (Exception ex) {
            logger.error("Could not parse Shipping Methods " + ex.getMessage());
        }

        return shipperMethodApiModels;
    }

    /**
     * @param argJsonObjEachGroup
     * @return
     */
    private static List<CawShippingItemsModel> parseListItemsGroup(JSONObject jsonObjEachGroup) {

        List<CawShippingItemsModel> shippingItemsModels = new ArrayList<CawShippingItemsModel>();
        CawShippingItemsModel shippingItemsModel = null;
        JSONArray jsonObjArray;
        JSONObject jsonObj;
        Double quantity;
        String itemCode;

        if (jsonObjEachGroup != null && jsonObjEachGroup.has(SHIPPING_ITEMS_ARRAY)) {

            try {
                jsonObjArray = jsonObjEachGroup.getJSONArray(SHIPPING_ITEMS_ARRAY);

                if (jsonObjArray != null && jsonObjArray.length() > 0) {

                    for (int i = 0; i < jsonObjArray.length(); i++) {

                        jsonObj = jsonObjArray.getJSONObject(i);

                        if (jsonObj != null) {
                            if (jsonObj.has(SHIPPING_QUANTITY) && jsonObj.has(SHIPPING_ITEM_CODE)) {

                                quantity = (Double) jsonObj.get(SHIPPING_QUANTITY);
                                itemCode = jsonObj.getString(SHIPPING_ITEM_CODE);

                                shippingItemsModel = new CawShippingItemsModel();
                                shippingItemsModel.setItemCode(itemCode);
                                
                                if (quantity != null) {
                                    shippingItemsModel.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));
                                }
                            }
                        }
                        shippingItemsModels.add(shippingItemsModel);
                    }
                }
            } catch (JSONException ex) {
                logger.error("Could not parse Items " + ex.getMessage());
            }

        }

        return shippingItemsModels;
    }

    /**
     * @param shippingGroupsModel
     * @return
     */
    public List<IShipperMethod> getShippingMethods(CawShippingGroupsModel shippingGroupsModel) {

        List<IShipperMethod> shipperMethods = new ArrayList<IShipperMethod>();
        List<CawShipperMethodAPIModel> shipperMethodAPIModels = null;
        String shipperMethodDesc = null;
        BigDecimal additionalDesc = null; // BZ38442
        
        if (shippingGroupsModel != null) {
            shipperMethodAPIModels = shippingGroupsModel.getShipperMethodAPIModels();
            
            if (CollectionUtils.isNotEmpty(shipperMethodAPIModels)) {
                for (CawShipperMethodAPIModel shipperMethodAPIModel : shipperMethodAPIModels) {
                    IShipperMethod shipperMethod = DataFactory.createObject(IShipperMethod.class);
                    shipperMethod.setShipperId(shipperMethodAPIModel.getShipperMethodId());
                    shipperMethodDesc = getShipperMethodDesc(shippingGroupsModel.getDescription(), shipperMethodAPIModel.getShipperMethodDesc());
                    /* BEGIN BZ38353 */
                    /* BEGIN BZ38442 */
                    additionalDesc = shipperMethodAPIModel.getAdditionalPH();
                    if (StringUtils.isNotEmpty(shipperMethodDesc)) {
                        shipperMethodDesc = shipperMethodDesc + " - $"
                                + formatPrice(shipperMethodAPIModel.getFeePrice());
                        if (additionalDesc != null 
                        		&& additionalDesc.compareTo(BigDecimal.ZERO) != 0) {

                            String addtion = " (Additional Freight: $"
                                    + formatPrice(shipperMethodAPIModel.getAdditionalPH()) + ")";
                            shipperMethodDesc = shipperMethodDesc + addtion;
                        }
                        shipperMethod.setShipperMethodDesc(shipperMethodDesc);
                        /* BEGIN BZ38442 */
                    }
                    /* END BZ38353 */
                    shipperMethods.add(shipperMethod);
                }
            }
        }
        return shipperMethods;
    }

    /**
     * @param shipDesc
     * @param serlevelDesc
     * @return
     */
    private String getShipperMethodDesc(List<String> shipDesc, String serlevelDesc) {
        String lineWithoutSpace = null;
        
        for (int i = 0; i < shipDesc.size(); i++) {
            if (StringUtils.isNotEmpty(shipDesc.get(i))
                    && StringUtils.isNotEmpty(serlevelDesc)) {
                lineWithoutSpace = StringUtils.deleteWhitespace(shipDesc.get(i));
                
                if (StringUtils.isNotEmpty(lineWithoutSpace) && serlevelDesc.equalsIgnoreCase(lineWithoutSpace)) {
                    return shipDesc.get(i);
                    
                }
            }
        }
        return null;
    }

    /**
     * @param trans
     * @param order
     * @return
     */
    public List<CawShippingGroupsModel> getShippingGroupModels(IRetailTransaction trans, IOrder order) {

        List<CawShippingGroupsModel> shippingGroupsModels = null;
        ResponseEntity<String> shippingRateResponse = null;

        String shippingRateRequest = getShippingRateAllItemsTemplate(trans, order);

        if (shippingRateRequest != null) {
            shippingRateResponse = CawEBSHelper.getInstance().sendShippingRateToEBS(shippingRateRequest);
            
            if (!hasErrorResponse(shippingRateResponse)) {
                // GET THE SHIPPER METHOD FROM THE EBS
                shippingGroupsModels = parseShippingGroupRates(shippingRateResponse);
            }
        }
        return shippingGroupsModels;
    }
    /* END BZ37901 */
    /* BEGIN BZ38353 */
    /**
     * @param shippingGroupModels
     * @param groupId
     * @return
     */
    public List<CawShippingItemsModel> getListShippingItemsByGroup(List<CawShippingGroupsModel> shippingGroupModels, Integer groupId) {

        if (CollectionUtils.isNotEmpty(shippingGroupModels) && groupId != null) {
            for (CawShippingGroupsModel cawShippingGroupsModel : shippingGroupModels) {
                if (cawShippingGroupsModel.getGroupId() == groupId.intValue()) {
                    return cawShippingGroupsModel.getShippingItemsModels();
                }
            }
        }
        return null;
    }
    
    /**
     * @param shippingGroupModels
     * @return
     */
    public StringBuffer getListItemIds(List<CawShippingItemsModel> shippingGroupModels) {

        StringBuffer listItemIds = new StringBuffer();
        if (CollectionUtils.isNotEmpty(shippingGroupModels)) {
            for (int i = 0; i < shippingGroupModels.size(); i++) {

                listItemIds.append(shippingGroupModels.get(i).getItemCode());

                if (i < shippingGroupModels.size() - 1) {
                    listItemIds.append(",");
                }
            }
        }
        return listItemIds;
    }

    /* END BZ38353 */
    
    /**
     * 
     */
    /* BEGIN BZ38351 */
    public boolean isAddingShippingMethod(IPosTransaction iPosTransaction) {
        boolean result = true;
        int count = 0;
        
        if (iPosTransaction != null) {
        
            List<ISaleReturnLineItem> transLineItems1 = iPosTransaction
                    .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);

            for (ISaleReturnLineItem transLineItem : transLineItems1) {
                if (!transLineItem.getVoid()) {
                    count++;
                    break;
                }
            }
        }
        if (count == 0) {
            result = false;
        }
        
        return result;
    } /* END BZ38351*/
    
    /**
     * 
     */
    /* BEGIN BZ-38384 */
    public boolean isExistShipMethod(IOrder currOrder) {
        boolean result = true;
        int count = 0;
        int numOfItems = 0;
        
        if (currOrder != null) {
            
            for (IOrderLine orderLine : currOrder.getOrderLines()) {

                if (!orderLine.getVoid()) {
                    numOfItems++;
                    if (StringUtils.isNotEmpty(orderLine.getSelectedShipMethod())) {
                        count++;
                    } 
                }
            }
        }

        if (count == 0
                || count < numOfItems) {
            // there is no item that has shipping method
            // OR another item that has not shipping method
            result = false;
        }

        return result;
    } /* END BZ-38384 */

    /**
     * @param orderMgr
     * @return
     */
    public boolean isNewDeliveryOrder(OrderMgr orderMgr) {

        boolean isRun = false;
        IOrder currentOrder = null;
        OrderType orderType = null;
        boolean isNewOrder = false;

        if (orderMgr != null) {

            currentOrder = orderMgr.getCurrentOrder();

            if (currentOrder != null) {
                if (currentOrder instanceof OrderModel) {
                    isNewOrder = currentOrder.isNew();

                }
                orderType = OrderType.forName(currentOrder.getOrderType());
                if (OrderType.STANDARD_DELIVERY == orderType
                        && orderType.isForDelivery() && isNewOrder) {
                    // Is Ship to Customer
                    isRun = true;
                }
            }
        }
        return isRun;
    }
    /* ENDs BZ38387 */ 

    /* BEGIN BZ38382 */
    public void assignShipMethodsToAllItems(List<CawShippingGroupsModel> shippingGroupModels,
            OrderMgr _orderMgr, IShipperMethod shippingMethod, Integer curentGroupId) {

        IOrder currentOrder = null;
        List<IOrderLine> currentOrderLines;
        List<IOrderLine> newOrderLines;
        List<CawShippingItemsModel> shippingItemsModels = null;

        if (CollectionUtils.isNotEmpty(shippingGroupModels)
                && curentGroupId != null) {
            currentOrder = _orderMgr.getCurrentOrder();

            for (CawShippingGroupsModel cawShippingGroupsModel : shippingGroupModels) {

                if (curentGroupId.intValue() == cawShippingGroupsModel.getGroupId()) {

                    shippingItemsModels = cawShippingGroupsModel.getShippingItemsModels();
                    
                    if (CollectionUtils.isNotEmpty(shippingItemsModels)) {

                        for (CawShippingItemsModel cawShippingItemsModel : shippingItemsModels) {

                            currentOrderLines = currentOrder.getOrderLines();
                            newOrderLines = new ArrayList<IOrderLine>();

                            for (IOrderLine orderLine : currentOrderLines) {
                    
                                newOrderLines.add(orderLine);
                                if (orderLine.getItem() != null
                                        && orderLine.getItem().getItemId().equals(cawShippingItemsModel.getItemCode())) {
                                    
                                    if (shippingMethod != null) {
                                        orderLine.setSelectedShipMethod(shippingMethod.getShipperId());
                                    } else {
                                        orderLine.setSelectedShipMethod(null);
                                    }
                                }
                            }
                            currentOrderLines = newOrderLines;
                            currentOrder.setOrderLines(currentOrderLines);
                            newOrderLines = new ArrayList<IOrderLine>();
                            _orderMgr.setCurrentOrder(currentOrder);
                        }
                    }
                }
            }
        }
    }
    /* END BZ38382 */
    /* BEGIN BZ38442 */
    /**
     * @param price
     * @return
     */
    public String formatPrice(BigDecimal price) {

        DecimalFormat df = new DecimalFormat("0.00");
        
        String totalPrice = df.format(price);

        return totalPrice;
    }
    /* END BZ38442 */
    /*
     * Unit test
     */
    public static void main(String[] a) {

        parseShippingGroupRates(null);
    }
    
    /* END BZ37912 */
}
