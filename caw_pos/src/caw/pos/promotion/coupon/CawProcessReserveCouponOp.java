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
 * BZ23147          070917    Implement Serialized coupon
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.promotion.api.response.CawCouponData;
import caw.pos.promotion.reserve.request.CawSerialReserveRequest;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.DateUtils;

/**
 *
 */
public class CawProcessReserveCouponOp extends Operation {

    private static final Logger logger_ = LogManager
            .getLogger(CawProcessReserveCouponOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        ArrayList<CawCouponData> listCouponData = _transactionScope
                .getValue(CawValueKeys.LIST_COUPON_DATA);
        int lastIndex = listCouponData.size();
        for (int i = 0; i < lastIndex; i++) {
            sendReserveRequest(listCouponData.get(i).getSerialNumber());
        }
        return HELPER.completeResponse();
    }

    /**
     * Send Reserve Request
     * @param num
     */
    private void sendReserveRequest(String num) {

        CawSerialReserveRequest reserveRequest = new CawSerialReserveRequest();
        reserveRequest.setSerialNumber(num);
        reserveRequest.setBusinessDate(DateUtils
                .format(_stationState.getCurrentBusinessDate()));
        reserveRequest
                .setRegister(String.valueOf(_stationState.getWorkstationId()));
        reserveRequest
                .setStore(String.valueOf(_stationState.getRetailLocationId()));
        reserveRequest.setTransaction(String.valueOf(_transactionScope
                .getTransaction().getTransactionSequence()));

        ObjectMapper obj = new ObjectMapper();
        try {
            CawPromotionHelper.getInstance().reserveCouponNumber(obj
                    .writeValueAsString(reserveRequest));
        } catch (JsonProcessingException ex) {
            logger_.error("Json  Processing Exception: " + ex.getMessage());
        }
    }

    /**
     * Check null and check size of List
     */
    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA) != null
                && _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                        .size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
