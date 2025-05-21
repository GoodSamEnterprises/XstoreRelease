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
 * BZ23440          091017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ23440          111017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ31968          220719    [Port 31855 to 5.0] Incorrect Neuron Promotion API URL
 *===================================================================
 */

package caw.pos.promotion.api.validation;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;

import caw.pos.common.CawValueKeys;
import caw.pos.promotion.api.response.CawCouponData;
import caw.pos.promotion.coupon.CawPromptCouponOp;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 *
 */
public class CawValidateCouponIdRule extends AbstractValidationRule {

    /**
     * 
     */
    private static final String STATUS_R = "R";
    
    @Inject
    private TransactionScope    _transactionScope;

    @Override
    public IValidationResult validate() {

        ArrayList<CawCouponData> list = _transactionScope
                .getValue(CawValueKeys.LIST_COUPON_DATA);

        String promotionResponse = CawPromptCouponOp.getPromotionResponse(); //BZ31968

        //BEGIN BZ23440
        if (promotionResponse != null && promotionResponse
                .equals(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())) {
            _transactionScope
                    .setValue(CawValueKeys.REQUEST_TIMEOUT, HttpStatus.REQUEST_TIMEOUT
                            .getReasonPhrase());
            return SimpleValidationResult
                    .getFailed("_authProcessFailedOffline");
        }
        //END BZ23440
        if (promotionResponse != null && promotionResponse.isEmpty()) {
            return SimpleValidationResult
                    .getFailed("_invalidBounceBackCouponNumber");
        }

        if (list == null || list.isEmpty()) {
            return SimpleValidationResult
                    .getFailed("_invalidBounceBackCouponNumber");
        }

        int size = list.size();
        CawCouponData couponData = list.get(size - 1);
        IValidationResult result = IValidationResult.SUCCESS;

        if (countSerialNum(list, size, couponData) > 1) {
            list.remove(couponData);
            return SimpleValidationResult.getFailed("_usedCouponNumber");
        }

        if (couponData.getStatus().equalsIgnoreCase(STATUS_R)) {
            list.remove(couponData);
            return SimpleValidationResult.getFailed("_invalidCouponStatus");
        }

        return result;
    }

    
   

    /**
     * Check this serial number already exist in Coupon List
     * @param list
     * @param size
     * @param couponData
     * @return
     */
    private int countSerialNum(ArrayList<CawCouponData> list, int size,
            CawCouponData couponData) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list.get(i).getSerialNumber()
                    .equalsIgnoreCase(couponData.getSerialNumber())) {
                count++;
            }
        }
        return count;
    }
}
