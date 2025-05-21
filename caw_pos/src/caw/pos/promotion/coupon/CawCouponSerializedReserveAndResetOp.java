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
 * BZ24150          251017    [DEV] Serialized Merchandise certificate (coupon) applied to transaction subtotal
 * BZ24278          311017    'HDE' screen is displayed after pressing 'OK' on Inapplicable Confirm screen
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.common.CawValueKeys;
import caw.pos.promotion.reserve.request.CawSerialReserveRequest;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.DateUtils;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.impl.RetailTransactionDealLineItemModel;

/**
 *
 */
public class CawCouponSerializedReserveAndResetOp extends Operation {

    private static final String JSON_SERIAL_NUMBER_ATTR = "serialNumber";

    private static final Logger logger_                 = LogManager
            .getLogger(CawCouponSerializedReserveAndResetOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        if (_transactionScope.getTransaction() != null && _transactionScope
                .getTransaction().getRetailTransactionLineItems() != null) {
            List<IRetailTransactionLineItem> saleLineItem = _transactionScope
                    .getTransaction().getRetailTransactionLineItems();
            Map<String, List<JSONObject>> serialNumberActive = _transactionScope
                    .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);

            List<JSONObject> couponReserve = new ArrayList<>();
            RetailTransactionDealLineItemModel retail = null;
            for (IRetailTransactionLineItem iRetailTransactionLineItem : saleLineItem) {
                if (iRetailTransactionLineItem instanceof RetailTransactionDealLineItemModel) {
                    retail = (RetailTransactionDealLineItemModel) iRetailTransactionLineItem;
                    if (serialNumberActive != null && retail.getDealId() != null
                            && serialNumberActive
                                    .get(retail.getDealId()) != null) {
                        couponReserve.addAll(serialNumberActive
                                .get(retail.getDealId()));
                        serialNumberActive.remove(retail.getDealId());
                    }
                }
            }

            List<JSONObject> couponReset = getListResetCoupons(serialNumberActive);
            sendReserveRequest(couponReserve);
            sendResetRequest(couponReset);
        }

        return HELPER.completeResponse();
    }

    /**
     * Get list coupon need to reset serial Number
     * @param serialNumberActive
     * @return
     */
    private List<JSONObject> getListResetCoupons(
            Map<String, List<JSONObject>> serialNumberActive) {

        List<JSONObject> serialNumberReservers = null;
        if (serialNumberActive != null && serialNumberActive.size() > 0) {
            serialNumberReservers = new ArrayList<>();
            for (Map.Entry<String, List<JSONObject>> entry : serialNumberActive
                    .entrySet()) {
                serialNumberReservers.addAll(entry.getValue());
            }
        }

        return serialNumberReservers;
    }

    /**
     * Send request for reserve coupon
     * @param couponReserve
     */
    private void sendReserveRequest(List<JSONObject> couponReserve) {

        if (couponReserve != null && couponReserve.size() > 0) {
            CawSerialReserveRequest reserveRequest = new CawSerialReserveRequest();
            for (JSONObject jsonObject : couponReserve) {
                if (!jsonObject.isNull(JSON_SERIAL_NUMBER_ATTR)) {
                    try {
                        reserveRequest.setSerialNumber(jsonObject
                                .getString(JSON_SERIAL_NUMBER_ATTR));
                        reserveRequest
                                .setBusinessDate(DateUtils.format(_stationState
                                        .getCurrentBusinessDate()));
                        reserveRequest.setRegister(String
                                .valueOf(_stationState.getWorkstationId()));
                        reserveRequest.setStore(String
                                .valueOf(_stationState.getRetailLocationId()));
                        reserveRequest.setTransaction(String
                                .valueOf(_transactionScope.getTransaction()
                                        .getTransactionSequence()));

                        ObjectMapper obj = new ObjectMapper();
                        String request = obj.writeValueAsString(reserveRequest);
                        logger_.info("Promotion reserve API request:"
                                + request);
                        CawPromotionHelper.getInstance()
                                .reserveCouponNumber(request);

                    } catch (JSONException ex) {
                        logger_.error("Json cannot get serial number attribute:"
                                + ex.getMessage());
                    } catch (JsonProcessingException ex) {
                        logger_.error("Json  Processing Exception: "
                                + ex.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Send request for reset coupon
     * @param couponReset
     */
    private void sendResetRequest(List<JSONObject> couponReset) {

        if (couponReset != null && couponReset.size() > 0) {
            for (JSONObject jsonObject : couponReset) {
                try {
                    if (!jsonObject.isNull(JSON_SERIAL_NUMBER_ATTR)) {
                        CawPromotionHelper.getInstance().resetCoupon(jsonObject
                                .getString(JSON_SERIAL_NUMBER_ATTR));
                    }
                } catch (Exception ex) {
                    logger_.error("Cannot send request reset a serialized coupon"
                            + ex.getMessage());
                }
            }
        }
    }

}
