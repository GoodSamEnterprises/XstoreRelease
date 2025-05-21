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
 * BZ24322          031117    Should be validated coupon number when using one coupon both serialized number and coupon tender in transaction
 *===================================================================
 */

package caw.pos.promotion.api.validation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 *
 */
public class CawValidateCouponSerializedRule extends AbstractValidationRule {

    private static final String SERIAL_NUMBER = "serialNumber";

    private static final Logger logger_       = LogManager
            .getLogger(CawValidateCouponSerializedRule.class);

    @Inject
    private TransactionScope    _transactionScope;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        String couponId = getScopedValue(ValueKeys.ENTERED_ITEM_ID);
        Map<String, List<JSONObject>> serialNumberActive = _transactionScope
                .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);
        Boolean isExist = Boolean.FALSE;
        if (couponId != null && serialNumberActive != null
                && serialNumberActive.size() > 0) {
            for (Map.Entry<String, List<JSONObject>> entry : serialNumberActive
                    .entrySet()) {
                if (entry.getValue() != null && entry.getValue().size() > 0) {
                    for (JSONObject jsonObject : entry.getValue()) {
                        try {
                            if (!jsonObject.isNull(SERIAL_NUMBER)
                                    && jsonObject.getString(SERIAL_NUMBER)
                                            .equals(couponId)) {
                                isExist = Boolean.TRUE;
                                break;
                            }
                        } catch (JSONException ex) {
                            logger_.error("Can not get attribute 'serialNumber' from response data of service."
                                    + ex.getMessage());
                        }
                    }
                }
            }

            if (isExist) {
                return SimpleValidationResult
                        .getFailed("_promotionalReadyUsedeMessage");
            }
        }

        return IValidationResult.SUCCESS;
    }

}
