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
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 * BZ29530          260219    [Technical] Xstore log issue (Invalid object id passed to getObjectById.)
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 *===================================================================
 */

package caw.pos.pricing.discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawJSONConstant;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.common.ConfigurationMgr;
import dtv.util.StringUtils;
import dtv.xst.dao.com.*;

/**
 * The collector Utils function using in Discount Coupon workflow.
 */
public class CawDiscountCouponHelper {

    private static final Logger _logger = LogManager
            .getLogger(CawDiscountCouponHelper.class);

    public CawDiscountCouponHelper() {

    }

    /**
     * BZ27028: this method will get reason code property(the configuration) 
     * and check if the configuration is enable or not.
     * @param reasonTypeCode
     * @param reasonCode
     * @return
     */
    public boolean isEnableReasonCode(String reasonTypeCode,
            String reasonCode) {

        boolean enable = false;

        IReasonCode iReasonCode = null;
        List<IReasonCodeProperty> listProperty = null;

        try {
            if (!StringUtils.isEmpty(reasonCode) && !StringUtils.isEmpty(reasonTypeCode)) {//BZ29530
                iReasonCode = CodeLocator
                        .getReasonCode(ConfigurationMgr.getOrganizationId(), reasonTypeCode, reasonCode);
            }
            if (iReasonCode != null) {
                listProperty = iReasonCode.getProperties();

                if (listProperty != null && listProperty.size() > 0) {
                    for (IReasonCodeProperty property : listProperty) {

                        if (property.getDecimalValue()
                                .compareTo(BigDecimal.ONE) == 0) {

                            if (reasonTypeCode
                                    .equals(CawConstants.RETURN_REASON_TYPE_CODE)
                                    && property.getPropertyCode()
                                            .equals(CawConstants.RETURN_PRODUCT_RECEIPT)) {
                                //Condition is used for enable Return product receipt
                                enable = true;
                            } else if (reasonTypeCode
                                    .equals(CawConstants.DISCOUNT_REASON_TYPE_CODE)
                                    && property.getPropertyCode()
                                            .equals(CawConstants.ENTER_COUPON_CODE)) {
                                //Condition is used for enable Enter coupon code prompt
                                enable = true;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("isEnableReasonCode -1" + ex.getMessage());
        }
        return enable;
    }

    /* BEGIN BZ31793 */
    /**
     * @param couponId
     * @param serialNumberActiveMap
     * @return String serialNumber
     */
    public String getSerialNumber(String couponId, Map<String, List<JSONObject>> serialNumberActiveMap) {

        String serialNumber = null;
        if (MapUtils.isNotEmpty(serialNumberActiveMap)) {
            if (serialNumberActiveMap.containsKey(couponId)) {
                List<JSONObject> serialNumbers = serialNumberActiveMap.get(couponId);
                if (CollectionUtils.isNotEmpty(serialNumbers)) {
                    //Go through the list -> get non null values -> collect them and join into a string
                    serialNumber = serialNumbers.stream()
                            .filter(serial -> !serial.isNull(CawJSONConstant.JSON_SERIAL_NUMBER_ATTR)).map(serial -> {
                                try {
                                    return serial.getString(CawJSONConstant.JSON_SERIAL_NUMBER_ATTR);
                                } catch (JSONException ex1) {
                                    return "";
                                }
                            }).collect(Collectors.joining(", "));
                }
            }
        }
        return serialNumber;
    }
    /* END BZ31793 */
}
