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
 * BZ23302          130917    Displayed message to inform for customer the maximum of Coupon amount
 * BZ24124          201017    Entering amount coupon requires unexpectedly when pressing Yes on "Confirm amount coupon" in case amount due < coupon amount.
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;

/**
 * Check amount due >= coupon amount and prompt confirm message.
 */
public class CawPromptConfirmCouponAmountOp extends AbstractPromptOp {

    @Inject
    private TenderHelper _tenderHelper;

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_CONFIRM_COUPON_AMOUNT");
    }

    @Override
    public boolean isOperationApplicable() {

        int size = _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                .size();
        BigDecimal couponAmt = BigDecimal.ZERO;
        if (size > 0) {
            couponAmt = new BigDecimal(
                    _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                            .get(size - 1).getMaxValue());
        }
        BigDecimal amtDue = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE).getAmountDue();
        if (couponAmt.compareTo(amtDue) > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argArgEvent) {

        int size = _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                .size();
        BigDecimal couponAmt = new BigDecimal(
                _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                        .get(size - 1).getMaxValue());
        couponAmt = _tenderHelper
                .getRoundingAmountByTender(getScopedValue(ValueKeys.CURRENT_TENDER), couponAmt);
        IFormattable args[] = new IFormattable[1];
        args[0] = _ff.getSimpleFormattable(couponAmt, FormatterType.SIMPLE);
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        //Start BZ24124
        // The client accept coupon amount.
        if (XstDataActionKey.ACCEPT.equals(argEvent.getActionKey())) {
            setScopedValue(CawValueKeys.IS_COUPON_AMOUNT_GREATER_EQUAL_AMOUNT_DUE, true);
            return HELPER.completeResponse();
        }
        //End BZ24124

        return super.handleDataAction(argEvent);
    }

}
