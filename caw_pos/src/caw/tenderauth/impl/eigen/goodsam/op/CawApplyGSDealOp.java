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
 * BZ29302          140219    [Internal] Auto apply discount when first time tender using the new Good Sam Visa
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.FormattableFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.OpChainKey;
import dtv.pos.coupon.CouponHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.dsc.ICoupon;

/**
 * Apply GS Deal if customer want to apply New Credit Application to current transaction.
 */
public class CawApplyGSDealOp extends Operation {

    private static final Logger  _logger   = LogManager.getLogger(CawApplyGSDealOp.class);

    @Inject
    private CouponHelper         _couponHelper;

    private CawCustomerGSHelper  _gsHelper = CawCustomerGSHelper.getInstance();

    @Inject
    protected FormattableFactory _ff;

    /* Apply GS Deal if customer want to apply New Credit Application to current transaction.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /*BEGIN BZ29302: apply New Good Sam Deal*/
        if (_gsHelper.isApplyGS() && !BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.IS_COUPON_APPLIED))
                && BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.SAY_YES_GSV_TENDER))) {
            String couponId = null;
            List<String> listDeal = CodeLocator
                    .getCodes(ConfigurationMgr.getOrganizationId(), _ff.getTranslatable("_gsDeal").toString());
            if (CollectionUtils.isNotEmpty(listDeal)) {
                couponId = listDeal.get(0);
                if (couponId != null) {
                    ICoupon coupon = _couponHelper.getForSerialNumber(couponId);
                    setScopedValue(ValueKeys.CURRENT_COUPON, coupon);
                    _transactionScope.setValue(CawValueKeys.IS_COUPON_APPLIED, Boolean.TRUE);
                    return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("ADD_COUPON_LINE_ITEM"));
                }
            } else {
                _logger.error("GSVISA_DEAL does not found from Xstore Database!");
                return HELPER.completeResponse();
            }
        }
        /*END BZ29302*/
        return HELPER.completeResponse();
    }
}
