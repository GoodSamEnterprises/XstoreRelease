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
 * BZ24124              201017    Entering amount coupon requires unexpectedly when pressing Yes on "Confirm amount coupon" in case amount due < coupon amount
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.math.BigDecimal;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.TransactionType;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.PromptTenderAmtOp;

/**
 * Print out the max amount value of coupon
 */
public class CawPromptCouponTenderAmtOp extends PromptTenderAmtOp {

    @Override
    protected BigDecimal getDefaultAmountDue() {

        int size = _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                .size();
        BigDecimal amt = new BigDecimal(
                _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                        .get(size - 1).getMaxValue());

        BigDecimal transAmtDue = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE).getAmountDue();
        if (amt.compareTo(transAmtDue) > 0) {
            return _tenderHelper
                    .getRoundingAmountByTender(getScopedValue(ValueKeys.CURRENT_TENDER), transAmtDue);
        } else {
            return _tenderHelper
                    .getRoundingAmountByTender(getScopedValue(ValueKeys.CURRENT_TENDER), amt);
        }
    }

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA) != null
                && _transactionScope.getValue(CawValueKeys.LIST_COUPON_DATA)
                        .size() > 0) {
            return super.isOperationApplicable();
        } else {
            return false;
        }
    }

    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        //Start BZ24124
        //If the client accepted coupon amount greater than amount due, skip prompt enter amount.
        Boolean isCouponCreaterEqualAmountDue = getScopedValue(CawValueKeys.IS_COUPON_AMOUNT_GREATER_EQUAL_AMOUNT_DUE);
        if ((isCouponCreaterEqualAmountDue != null)
                && (isCouponCreaterEqualAmountDue == true)) {
            BigDecimal amtDue = _transactionScope
                    .getTransaction(TransactionType.RETAIL_SALE).getAmountDue();
            getScopedValue(ValueKeys.CURRENT_TENDER_LINE).setAmount(amtDue);
            clearScopedValue(CawValueKeys.IS_COUPON_AMOUNT_GREATER_EQUAL_AMOUNT_DUE);
            return HELPER.completeResponse();
        }
        //End BZ24124

        return super.handleInitialState(argEvent);
    }

}
