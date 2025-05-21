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
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.util.List;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.ttr.ICouponTenderLineItem;
import dtv.xst.dao.ttr.impl.CouponTenderLineItemModel;

/**
 *
 */
public class CawProcessResetCouponOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        List<IRetailTransactionLineItem> list = getScopedValue(ValueKeys.SELECTED_TRANSACTION)
                .getRetailTransactionLineItems();
        int size = list.size();
        ICouponTenderLineItem temp;

        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof CouponTenderLineItemModel
                    && !list.get(i).getVoid()) {
                temp = (ICouponTenderLineItem) list.get(i);
                CawPromotionHelper.getInstance()
                        .resetCoupon(temp.getSerialNumber());
            }
        }

        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(ValueKeys.SELECTED_TRANSACTION) != null) {
            return true;
        } else {
            return false;
        }
    }

}
