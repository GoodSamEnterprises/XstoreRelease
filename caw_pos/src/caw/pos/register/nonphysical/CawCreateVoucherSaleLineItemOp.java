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
 * 
 *===================================================================
 */

package caw.pos.register.nonphysical;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.nonphysical.CreateVoucherSaleLineItemOp;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawCreateVoucherSaleLineItemOp
        extends CreateVoucherSaleLineItemOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        super.handleOpExec(argEvent);
        getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                .setVoucherTypeCode(CawEigenConstants.XPAY_GIFT_CARD);
        return HELPER.completeResponse();
    }
}
