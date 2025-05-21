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
 * BZ23276          130917    Xstore displays 'The coupon is already used in this transaction'
 *                            after pressing 'ESC' button on Coupon amount filed
 * BZ23440          091017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ23440          111017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ31968          220719    [Port 31855 to 5.0] Incorrect Neuron Promotion API URL
 *===================================================================
 */

package caw.pos.promotion.coupon;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.common.CawValueKeys;
import caw.pos.promotion.api.response.CawCouponData;

import dtv.pos.common.OpChainKey;
import dtv.pos.coupon.PromptCouponOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.impl.CouponTenderLineItemModel;

/**
 *
 */
public class CawPromptCouponOp extends PromptCouponOp {

    private static final Logger logger_ = LogManager
            .getLogger(CawPromptCouponOp.class);

    private static String promotionResponse; //BZ31968

    /**
     * Handle the prompt response for asking the user to enter a coupon ID. This handler stores the coupon ID on
     * the scope.
     *
     * @param argEvent event object containing the coupon ID as entered by the user in the prompt.
     * @return <code>IOpResponse</code>
     */
    @Override
    public IOpResponse handlePromptEvent(IXstEvent argEvent) {

        String couponId = argEvent.getStringData();
        promotionResponse = CawPromotionHelper.getInstance().lookupPromotionSerialNumber(couponId); // BZ31968

        //BEGIN BZ23440
        if (promotionResponse != null && !promotionResponse.isEmpty()
                && !promotionResponse
                        .equals(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())) {
            ObjectMapper objMapper = new ObjectMapper();
            try {
                if (_transactionScope
                        .getValue(CawValueKeys.LIST_COUPON_DATA) == null) {
                    _transactionScope
                            .setValue(CawValueKeys.LIST_COUPON_DATA, new ArrayList<CawCouponData>());
                }
                CawCouponData couponData = objMapper
                        .readValue(promotionResponse, CawCouponData.class);
                _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                        .add(couponData);
            } catch (IOException ex) {
                logger_.error("Object mapping exception: " + ex.getMessage());
            }
        }
        //END BZ23440
        setScopedValue(ValueKeys.ENTERED_COUPON_ID, couponId);
        setScopedValue(ValueKeys.ENTERED_ITEM_ID, couponId);
        return null;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArgEvent) {

        // CAW: START Fix BZ 23276 
        List<ITenderLineItem> currentTenderLineItems = _transactionScope
                .getTransaction(RETAIL_SALE)
                .getLineItems(ITenderLineItem.class);
        ArrayList<String> listCouponTenderNum = new ArrayList<String>();
        if (currentTenderLineItems != null
                && !currentTenderLineItems.isEmpty()) {
            int sizeListTenderLine = currentTenderLineItems.size();
            for (int i = 0; i < sizeListTenderLine; i++) {
                if (currentTenderLineItems
                        .get(i) instanceof CouponTenderLineItemModel
                        && !currentTenderLineItems.get(i).getVoid()) {
                    listCouponTenderNum.add(currentTenderLineItems.get(i)
                            .getSerialNumber());
                }
            }
        }

        ArrayList<CawCouponData> listCouponData = _transactionScope
                .getValue(CawValueKeys.LIST_COUPON_DATA);
        ArrayList<String> listSerialNum = new ArrayList<String>();
        if (listCouponData != null && !listCouponData.isEmpty()) {
            int sizeListCouponData = listCouponData.size();
            for (int i = 0; i < sizeListCouponData; i++) {
                listSerialNum.add(listCouponData.get(i).getSerialNumber());
            }

            listSerialNum.removeAll(listCouponTenderNum);
            if (!listSerialNum.isEmpty()) {
                for (int j = 0; j < sizeListCouponData; j++) {
                    if (listCouponData.get(j).getSerialNumber()
                            .equalsIgnoreCase(listSerialNum.get(0))) {
                        listCouponData.remove(j);
                    }
                }
            }
        }
        // CAW: END Fix BZ 23276
        // BEGIN BZ23440
        if (_transactionScope.getValue(CawValueKeys.REQUEST_TIMEOUT) != null) {
            if (_transactionScope.getValue(CawValueKeys.REQUEST_TIMEOUT)
                    .equals(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())) {
                _transactionScope.clearValue(CawValueKeys.REQUEST_TIMEOUT);
                return HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("SALE_TENDER"));
            }
        }
        // END BZ23440
        return super.handleOpExec(argArgEvent);
    }

    /* BEGIN BZ31968 */
    public static String getPromotionResponse() {
        return promotionResponse;
    }
    /* END BZ31968 */
}
