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
 * BZ23719          091017    Instant credit application doesn't allow New Good Sam visa to be tendered
 * BZ23890          101017    [GSVS] Apply discount $10 when apply GSVS for the current transaction
 * BZ23890          111017    [GSVS] Apply discount $10 when apply GSVS for the current transaction
 * BZ23993          191017    Should be removed coupon discount amount out of transaction when void line tender new good Sam visa
 * BZ25328          050218    [PROD] Good Sam Visa $20 Off Deal Reporting Issue
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.*;
import dtv.pos.coupon.CouponHelper;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.dsc.ICoupon;

/**
 *
 */
public class CawNewGoodSamCheckOp extends Operation {

    /* Begin BZ23890 */
    @Inject
    private CouponHelper            _couponHelper;

    private static final String     GOOD_SAM_VISA_DEAL = "GSVISA_DEAL";         //BZ25328

    private static final BigDecimal TEN_DOLLARS_CHECK  = new BigDecimal(10.00);
    /* End BZ23890 */

    /*Begin BZ-23406*/
    private final IOpState          DECLINE            = new OpState("DECLINE");

    private static final Logger     _logger            = LogManager
            .getLogger(CawNewGoodSamCheckOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        if (DECLINE.equals(this.getOpState())) {
            return HELPER.getOpChainRollBackRequest();
        }

        if (_transactionScope.getValue(CawValueKeys.ACCOUNT_NUMBER) == null
                || _transactionScope.getValue(CawValueKeys.EXP_DATE) == null) {
            this.setOpState(DECLINE);
            return HELPER.getPromptResponse(PromptKey
                    .valueOf("CAW.GOOD_SAM_NEW_VISA_EMPTY"));
        }

        /* Begin BZ23890 */
        BigDecimal checkAmountDue = _transactionScope.getTransaction()
                .getAmountDue();

        if (checkAmountDue != null) {
            /* Begin BZ23993 */
            if (checkAmountDue.compareTo(TEN_DOLLARS_CHECK) > 0
                    && (_transactionScope
                            .getValue(CawValueKeys.IS_COUPON_APPLIED) == null
                            || !_transactionScope
                                    .getValue(CawValueKeys.IS_COUPON_APPLIED))) {
                /* Begin BZ25328 */
                String couponId = null;
                if (CodeLocator
                        .getCodes(ConfigurationMgr
                                .getOrganizationId(), GOOD_SAM_VISA_DEAL)
                        .size() > 0) {
                    couponId = CodeLocator
                            .getCodes(ConfigurationMgr
                                    .getOrganizationId(), GOOD_SAM_VISA_DEAL)
                            .get(0);
                    if (couponId != null) {
                        ICoupon coupon = _couponHelper
                                .getForSerialNumber(couponId);
                        setScopedValue(ValueKeys.CURRENT_COUPON, coupon);
                        _transactionScope
                                .setValue(CawValueKeys.IS_COUPON_APPLIED, Boolean.TRUE);
                        /* End BZ23993 */
                        return HELPER.getCompleteStackChainResponse(OpChainKey
                                .valueOf("ADD_COUPON_LINE_ITEM"));
                    }
                } else {
                    _logger.error("GSVISA_DEAL does not found from Xstore Database!");
                    return HELPER.completeResponse();
                }
                /* End BZ25328 */
            } else if (checkAmountDue.compareTo(TEN_DOLLARS_CHECK) <= 0) {
                return HELPER.completeResponse();
            }
        }
        /* End BZ23890 */

        return HELPER.completeResponse();
    }
    /*End BZ-23406*/

}
