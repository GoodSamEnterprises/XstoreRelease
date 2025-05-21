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
 * BZ23359          270917    Gift cards can't be swiped at screen
 * BZ23559          021017    [Receipts] Gift Card Tender Exchange transaction receipt does not meet CW requirements
 * BZ23535          021017    Not displayed "Enter Merchandise Certificate number" screen when performing sale transaction by Merchandise Certificate tender
 * BZ23359          051017    Gift cards can't be swiped at screen
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27123          090818    Gift Card - refund goes to the pin pad
 *===================================================================
 */

package caw.pos.tender.voucher;

import caw.pos.common.CawVoucherValue;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.PromptVoucherNumberOp;
import dtv.util.crypto.EncString;

/**
 *
 */
public class CawPromptVoucherNumberOp extends PromptVoucherNumberOp {

    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM) != null) {
            getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                    .setSerialNumber(null);
        }

        if (getScopedValue(ValueKeys.CURRENT_VOUCHER) != null) {
            getScopedValue(ValueKeys.CURRENT_VOUCHER).setSerialNumber(null);
        }
        clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
        clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);

        //BZ27123: remove code handle to return false, we don't need function swipe cared on pinpad currently.
        return super.isOperationApplicable();
    }

    //Begin BZ26978
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        String voucherNumber = EncString
                .getSensitiveData(getScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER));
        if (voucherNumber != null) {
            CawVoucherValue.setVOUCHER_CARD_NUMBER(voucherNumber);
        }
        return super.handlePromptResponse(argEvent);
    }
    //End BZ26978
}
