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

import java.util.ArrayList;

import caw.pos.common.CawValueKeys;
import caw.pos.promotion.api.response.CawCouponData;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.ttr.impl.CouponTenderLineItemModel;

/**
 * Void coupon tender line item
 */
public class CawVoidCouponTenderLineItemOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        ArrayList<CawCouponData> list = _transactionScope
                .getValue(CawValueKeys.LIST_COUPON_DATA);
        int size = list.size();
        String selectedVoidNum = getScopedValue(ValueKeys.CURRENT_TENDER_LINE)
                .getSerialNumber();

        for (int i = 0; i < size; i++) {
            if (list.get(i).getSerialNumber()
                    .equalsIgnoreCase(selectedVoidNum)) {
                list.remove(i);
                break;
            }
        }

        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) instanceof CouponTenderLineItemModel
                && _transactionScope
                        .getValue(CawValueKeys.LIST_COUPON_DATA) != null
                        & _transactionScope
                                .getValue(CawValueKeys.LIST_COUPON_DATA)
                                .size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
