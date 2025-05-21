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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47618          121321    RV Service Payment requires Customer# in order to search with RV WO#
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import caw.pos.common.*;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.pos.iframework.security.StationState;

/**
 *
 */
public class CawBuildRvPaymentRequest {

    private static final String             CAW_ID          = "!{id}";

    private static final String             CAW_TERMINAL    = "!{terminal}";

    private static final String             CAW_CHANNELTYPE = "!{channelType}";

    private static final String             SALES_CHANNEL   = "!{salesChannel}";
    
    private static final String             SALES_CHANNEL_ID   = "!{salesChannelId}";

    private static final String             IDS_CUSTOMER_ID = "!{idsCustomerId}";

    private static final String             IDS_WORK_ORDER  = "!{idsWorkOrder}";

    private static final String             FIRST_NAME      = "!{firstName}";

    private static final String             LAST_NAME       = "!{lastName}";

    private static final String             POSTAL_CODE     = "!{postalCode}";

    private static final String             PAGE_SIZE       = "!{pageSize}";

    private static CawBuildRvPaymentRequest INSTANCE        = null;

    public static CawBuildRvPaymentRequest getInstance() {

        if (INSTANCE == null) {
            synchronized (CawBuildRvPaymentRequest.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawBuildRvPaymentRequest();
                }
            }
        }
        return INSTANCE;
    }

    public String buildRvPaymentRequest(CawRvPaymentModel rvPayment,
            StationState argStationState) {

        String body = CawJSONConstant.NULL;
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.RV_PAYMENT_REQUEST_TEMPLATE);
        String maxResult = CawConfigurationMgr.getMaxNumberOfResults();
        if (request != null && request.getBody() != null) {
            body = request.getBody();
            body = body.replace(SALES_CHANNEL, buildSalesChannel(argStationState));
            long storeId = 0;
            if (argStationState != null) {
                storeId = argStationState.getRetailLocationId();
            }
            body = body.replace(SALES_CHANNEL_ID, String.format("%s", storeId));
            body = body.replace(IDS_CUSTOMER_ID, CawUtilFunction.formatParameter(rvPayment.getRvServiceCustomer()));
            body = body.replace(IDS_WORK_ORDER, CawUtilFunction.formatParameter(rvPayment.getRvServiceWo()));
            body = body.replace(FIRST_NAME, CawUtilFunction.formatParameter(rvPayment.getRvFistName()));
            body = body.replace(LAST_NAME, CawUtilFunction.formatParameter(rvPayment.getRvLastName()));
            body = body.replace(POSTAL_CODE, CawUtilFunction.formatParameter(rvPayment.getRvPostalCode()));
            body = body.replace(PAGE_SIZE, maxResult);
        }
        return body;
    }

    private String buildSalesChannel(StationState argStationState) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.OBJECT_SALES_CHANNEL_ATTR);
        String body = request.getBody();
        long storeId = 0;
        long terminalId = 0;

        if (argStationState != null) {
            storeId = argStationState.getRetailLocationId();
            terminalId = argStationState.getWorkstationId();
        }

        body = body.replace(CAW_ID, String.format("%s", storeId));

        body = body.replace(CAW_TERMINAL, String.format("%s", terminalId));

        body = body.replace(CAW_CHANNELTYPE, String.format("%s", Integer.valueOf(4)));
        return body;
    }

    /**
     * @param argJsonObjectResponse
     * @return
     */
    public List<CawRvPaymentModel> convertResponse(JSONObject jsonObject)
            throws JSONException {

        List<CawRvPaymentModel> rvPaymentList = new ArrayList<CawRvPaymentModel>();
        if (jsonObject != null) {
            JSONArray jSonRvPaymentItems = CawJSONUtils.getJSONArray(jsonObject, CawJSONConstant.JSON_ITEMS);
            if (jSonRvPaymentItems != null && jSonRvPaymentItems.length() > 0) {
                JSONObject jSonRvPaymentItem = null;
                CawRvPaymentModel RvPaymentItem = null;
                BigDecimal rvAmount = new BigDecimal(0);
                JSONObject properties = null;
                for (int i = 0; i < jSonRvPaymentItems.length(); i++) {
                    jSonRvPaymentItem = (JSONObject) jSonRvPaymentItems.get(i);
                    RvPaymentItem = new CawRvPaymentModel();
                    if (jSonRvPaymentItem.has(CawJSONConstant.JSON_LINE_TOTAL)) {/*BZ47618*/
                        rvAmount = CawUtilFunction.vBigDecimal(jSonRvPaymentItem.getString(CawJSONConstant.JSON_LINE_TOTAL), BigDecimal.ZERO);
                        RvPaymentItem.setRvAmount(rvAmount);
                    }
                    if (jSonRvPaymentItem.has(CawJSONConstant.JSON_ITEM_ID)) {/*BZ47618*/
                        RvPaymentItem.setItemCode(jSonRvPaymentItem.getString(CawJSONConstant.JSON_ITEM_ID));
                    }
                    if (jSonRvPaymentItem.has(CawJSONConstant.JSON_QTY)) {/*BZ47618*/
                        RvPaymentItem.setRvQty(new BigDecimal(jSonRvPaymentItem.getInt(CawJSONConstant.JSON_QTY)));
                    }
                    properties = CawJSONUtils.getJSONObject(jSonRvPaymentItem, CawJSONConstant.JSON_PROPERTIES);
                    if (properties != null) {
                        RvPaymentItem.setProperties(properties.toString());
                        if (properties.has(CawJSONConstant.JSON_CUSTOMER_ID)) {/*BZ47618*/
                            RvPaymentItem.setRvServiceCustomer(properties.getString(CawJSONConstant.JSON_CUSTOMER_ID));
                        }
                        if (properties.has(CawJSONConstant.JSON_WORK_ORDER)) {/*BZ47618*/
                            RvPaymentItem.setRvServiceWo(properties.getString(CawJSONConstant.JSON_WORK_ORDER));
                        }
                        if (properties.has(CawJSONConstant.JSON_LOCATION_CODE)) {/*BZ47618*/
                            RvPaymentItem.setLocationCode(properties.getString(CawJSONConstant.JSON_LOCATION_CODE));
                        }
                        if (properties.has(CawJSONConstant.JSON_SALES_CHANNEL_ID)) {/*BZ47618*/
                            RvPaymentItem.setSalesChannelId(properties.getString(CawJSONConstant.JSON_SALES_CHANNEL_ID));
                        }
                        if (properties.has(CawJSONConstant.JSON_WO_DESCRIPTION)) {/*BZ47618*/
                            RvPaymentItem.setRvDescription(properties.getString(CawJSONConstant.JSON_WO_DESCRIPTION));
                        }
                    }
                    rvPaymentList.add(RvPaymentItem);
                }
            }
        }
        return rvPaymentList;
    }

}
