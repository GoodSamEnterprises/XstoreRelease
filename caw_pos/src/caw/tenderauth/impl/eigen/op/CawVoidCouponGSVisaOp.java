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
 * BZ23993          191017    Should be removed coupon discount amount out of transaction when void line tender new good Sam visa
 * BZ25328          050218    [PROD] Good Sam Visa $20 Off Deal Reporting Issue
 * BZ29302          210219    [Internal] Auto apply discount when first time tender using the new Good Sam Visa
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29505          010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29683          080319    [INTERNAL] [4.0.1] Review/Evaluate $20 GSVS on the current build
 * BZ29683          080319     [INTERNAL] [4.0.1] Review/Evaluate $20 GSVS on the current build
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.FormattableFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.trl.ICouponLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Remove GS Deal after voiding tender line with GS token
 */
/* Begin BZ23993 */
public class CawVoidCouponGSVisaOp extends Operation {

    @Inject
    protected FormattableFactory _ff;

    private CawCustomerGSHelper  _gsHelper = CawCustomerGSHelper.getInstance();

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /*BEGIN BZ29302: only remove Deal if tender line is used token*/
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        boolean isGSToken = false;
        if (tenderLine instanceof ICreditDebitTenderLineItem) {
            if (_gsHelper.getAccountShortToken()
                    .equals(((ICreditDebitTenderLineItem) tenderLine).getAuthorizationToken())) {/*BZ29536/BZ29505/BZ29683*/
                isGSToken = true;
            }
        }
        /*BEGIN BZ29302*/
        /*BEGIN BZ29683*/
        if (argArg0 != null) {
            IXstActionKey key = ((IXstAction) argArg0).getActionKey();
            if (CawConstants.PRESSING_BACK.equals(key)) {
                isGSToken = true;
            }
        }
        /*END BZ29683*/
        /*BEGIN BZ29302: Remove GS Deal after voiding tender line with GS token*/
        if (BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.IS_COUPON_APPLIED)) && isGSToken) {
            IPosTransaction trans = getTransaction();
            //Begin BZ25328
            String couponId = CodeLocator
                    .getCodes(ConfigurationMgr.getOrganizationId(), _ff.getTranslatable("_gsDeal").toString()).get(0);
            //End BZ25328
            for (ICouponLineItem couponLine : trans.getLineItems(ICouponLineItem.class)) {
                if (couponLine.getCouponId().equalsIgnoreCase(couponId)) {//BZ25328
                    if (!couponLine.getVoid()) {
                        couponLine.setVoid(true);
                        _transactionScope.setValue(CawValueKeys.IS_COUPON_APPLIED, Boolean.FALSE);
                        return HELPER.completeResponse();
                    }
                }
            }
        }
        /*END BZ29302*/
        return HELPER.completeResponse();
    }

    /**
     * Gets the transaction.
     *
     * @return the transaction
     */
    protected IPosTransaction getTransaction() {

        return _transactionScope.getTransaction();
    }
}
