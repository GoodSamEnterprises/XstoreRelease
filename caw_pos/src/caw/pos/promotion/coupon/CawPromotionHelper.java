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
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 *===================================================================
 */

package caw.pos.promotion.coupon;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.util.CawEBSHelper;

import dtv.pos.iframework.security.StationState;

public class CawPromotionHelper {

    private static volatile CawPromotionHelper INSTANCE = null;

    @Inject
    protected StationState                     _stationState;

    public static CawPromotionHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawPromotionHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawPromotionHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 
     * @param catalystRequest
     * @param neuronUser
     * @param neuronKey
     */
    public String lookupPromotionSerialNumber(String serialNum) {

        //BZ26575 changed by using CawEBSHelper
        ResponseEntity<String> response = CawEBSHelper.getInstance()
                .lookupPromotionInEBS(serialNum);

        if (response == null) {
            return "";
        }
        //BEGIN BZ23440
        if (response.getStatusCode().equals(HttpStatus.REQUEST_TIMEOUT)) {
            return HttpStatus.REQUEST_TIMEOUT.getReasonPhrase();
        }
        //END BZ23440
        return response.getBody();
    }

    /**
     * Send Reserve Request
     * @param reserveRequest
     */
    public void reserveCouponNumber(String reserveRequest) {

        //BZ26575 changed by using CawEBSHelper
        CawEBSHelper.getInstance().reservePromotionInEBS(reserveRequest);
    }

    /**
     * Send Reset coupon request
     * @param serialNum
     */
    public void resetCoupon(String serialNum) {

        //BZ26575 changed by using CawEBSHelper
        CawEBSHelper.getInstance().resetPromotionInEBS(serialNum);
    }
}
