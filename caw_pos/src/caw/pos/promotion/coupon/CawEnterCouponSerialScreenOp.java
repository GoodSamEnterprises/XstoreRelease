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
 * BZ28014          310519    [New Requirement] Xstore needs to allow stackability for/Allow multiple Merchant Certificates in a transaction
 * BZ34370          201219    [Internal] Unable to scan serial numbers of serialized coupon
 * BZ34438          271219    [Defect 33595] Xstore add many serialized coupons with same serial number
 * BZ34226          130220    [New Requirement] Add Warning beeps for any prompt requiring action
 *===================================================================
 */

package caw.pos.promotion.coupon;

import static dtv.hardware.types.InputType.*;

import java.math.BigDecimal;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.*;
import caw.pos.pricing.CawMultipleDealMap;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.dsc.ICoupon;
import dtv.hardware.types.InputType;

/**
 *
 */
public class CawEnterCouponSerialScreenOp extends AbstractPromptOp implements IXstEventObserver {

    private static final String PREFIX_R                = "R";

    private static final String PREFIX_A                = "A";

    private static final String JSON_SERIAL_NUMBER_ATTR = "serialNumber";

    private static final String JSON_STATUS_ATTR        = "status";

    private static boolean               IS_BEEP_FLAG   = false;         //BZ34226
 
    private static final Logger logger_                 = LogManager
            .getLogger(CawEnterCouponSerialScreenOp.class);

    /*BEGIN BZ34370*/
    private static final IXstEventType[] EVENTS;

    static {
        EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE }; //BZ34226
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.event.IXstEventObserver#getObservedEvents()
     */
    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }
    /*END BZ34370*/

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        ICoupon coupon = getScopedValue(ValueKeys.CURRENT_COUPON);
        if (coupon != null && coupon.getSerialized()) {
            isRun = Boolean.TRUE;
        }

        return isRun;
    }

    /* BEGIN BZ34226 */
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#handleInitialState(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        IS_BEEP_FLAG = false;
        // @todo Auto-generated method stub
        return super.handleInitialState(argEvent);
    }
    /* END BZ34226 */

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ENTER_COUPON_SERIAL_SCREEN");
    }
    
    /*BEGIN BZ34438: handleDataAction cannot handle scan event, resolve it by using handlePromptEvent*/
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#handlePromptEvent(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        Map<String, List<JSONObject>> serialActive = _transactionScope
                .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);

        /* BEGIN BZ34226 */
        if (argEvent != null && argEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if ("CANCEL_ACTION".equalsIgnoreCase(key.toString())) {
                IS_BEEP_FLAG = false;
                return HELPER.completeResponse();
            }
        }

        if (!(argEvent instanceof IXstAction) && IS_BEEP_FLAG) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper
                    .getInstance().getScanner(), CawHardwareHelper.getInstance()
                            .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            IS_BEEP_FLAG = true;
            return HELPER.waitResponse();
        }
        /* END BZ34226 */
        else if (serialActive != null && serialActive.size() > 0) {
            final String couponId = getScopedValue(ValueKeys.ENTERED_COUPON_ID);

            if (argEvent != null && argEvent.getStringData() != null
                    && couponId != null) {
                String serialNumber = argEvent.getStringData();
                List<JSONObject> serialNumberLine = null;
                if (serialActive.size() > 0) {
                    serialNumberLine = new ArrayList<>();
                    for (Map.Entry<String, List<JSONObject>> entry : serialActive
                            .entrySet()) {
                        serialNumberLine.addAll(entry.getValue());
                    }

                    if (serialNumberLine.size() > 0) {
                        for (JSONObject jsonObject : serialNumberLine) {
                            if (jsonObject != null && !jsonObject
                                    .isNull(JSON_SERIAL_NUMBER_ATTR)) {
                                try {
                                    String serialNumberResponse = jsonObject
                                            .getString(JSON_SERIAL_NUMBER_ATTR);
                                    if (serialNumberResponse
                                            .equals(serialNumber)) {
                                        setScopedValue(ValueKeys.CURRENT_COUPON, null);
                                        return HELPER
                                                .getCompletePromptResponse(PromptKey
                                                        .valueOf("CAW_COUPON_ALREADY_USED_MSG"));
                                    }
                                } catch (JSONException ex) {
                                    logger_.error("Cannot parse promotion response to Json."
                                            + ex.getMessage());
                                }

                            }
                        }
                    }
                }
            }
        }
        return super.handlePromptEvent(argEvent);
    }
    /*END BZ34438*/
    
    @Override
    public IOpResponse handlePromptResponse(IXstEvent arg) {

        final ICoupon coupon = getScopedValue(ValueKeys.CURRENT_COUPON);
        final String couponId = getScopedValue(ValueKeys.ENTERED_COUPON_ID);

        if (arg != null && arg.getStringData() != null) {
            String serial = arg.getStringData();
            String promotionResponse = CawPromotionHelper.getInstance()
                    .lookupPromotionSerialNumber(serial);

            if (promotionResponse != null && promotionResponse.isEmpty()) {
                setScopedValue(ValueKeys.CURRENT_COUPON, null);
                /* BEGIN BZ34226 */
                IS_BEEP_FLAG = true;
                return HELPER.getPromptResponse(PromptKey
                        .valueOf("CAW_INVALID_SERIALIZED_COUPON_MSG"));
                /* END BZ34226 */
            } else if (promotionResponse != null && !promotionResponse.isEmpty()
                    && !promotionResponse.equals(HttpStatus.REQUEST_TIMEOUT
                            .getReasonPhrase())) {
                try {
                    JSONObject serialInfo = new JSONObject(promotionResponse);
                    if (!serialInfo.isNull(JSON_STATUS_ATTR)
                            && !serialInfo.isNull(JSON_SERIAL_NUMBER_ATTR)) {
                        if (PREFIX_A.equals(serialInfo
                                .getString(JSON_STATUS_ATTR))) {
                            Map<String, List<JSONObject>> serialNumberActive = _transactionScope
                                    .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);
                            if (serialNumberActive != null
                                    && serialNumberActive.size() > 0) {
                                if (serialNumberActive.get(couponId) != null) {
                                    List<JSONObject> temp = serialNumberActive
                                            .get(couponId); /*BZ28014*/
                                    temp.add(serialInfo);
                                    serialNumberActive.put(couponId, temp);
                                } else {
                                    List<JSONObject> temp = new ArrayList<JSONObject>();
                                    temp.add(serialInfo);
                                    serialNumberActive.put(couponId, temp);
                                }
                            } else {
                                serialNumberActive = new HashMap<String, List<JSONObject>>();
                                List<JSONObject> temp = new ArrayList<JSONObject>();
                                temp.add(serialInfo);
                                serialNumberActive.put(couponId, temp);
                            }
                            //The coupon info will save temp to transaction scope for process Reserve and Reset atCawSerializedReserveOrResetCouponOp.java
                            _transactionScope
                                    .setValue(CawValueKeys.SERIAL_NUMBER_ACTIVE, serialNumberActive);
                            //Coupon set serialized to false for ignore Authorize Serialized
                            coupon.setSerialized(Boolean.FALSE);
                            setScopedValue(ValueKeys.CURRENT_COUPON, coupon);
                            /* BEGIN BZ28014 Marking apply time for multiple coupon*/
                            Map<String, BigDecimal> multiApply= CawMultipleDealMap.getInstance().getMultiApply();
                            BigDecimal applyTimes = multiApply.get(couponId);
                            if (applyTimes == null) {
                                applyTimes = BigDecimal.ZERO;
                            }
                            CawMultipleDealMap.getInstance().putToMultipleDealMap(couponId, applyTimes.add(BigDecimal.ONE));
                            /* BEGIN BZ28014 */
                            
                        } else if (PREFIX_R.equals(serialInfo
                                .getString(JSON_STATUS_ATTR))) {
                            setScopedValue(ValueKeys.CURRENT_COUPON, null);
                            return HELPER.getCompletePromptResponse(PromptKey
                                    .valueOf("CAW_COUPON_ALREADY_USED_MSG"));
                        } else {
                            setScopedValue(ValueKeys.CURRENT_COUPON, null);
                            /* BEGIN BZ34226 */
                            IS_BEEP_FLAG = true;
                            return HELPER.getPromptResponse(PromptKey
                                    .valueOf("CAW_INVALID_SERIALIZED_COUPON_MSG"));
                            /* BEGIN BZ34226 */
                        }
                    }

                } catch (JSONException ex) {
                    logger_.error("Cannot parse promotion response to Json."
                            + ex.getMessage());
                }
            } else {
                setScopedValue(ValueKeys.CURRENT_COUPON, null);
                return HELPER.getCompletePromptResponse(PromptKey
                        .valueOf("CAW_ERROR_COUPON_MSG"));
            }
        }

        return HELPER.completeResponse();
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

}
