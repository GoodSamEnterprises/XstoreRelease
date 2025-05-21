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
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.tenderauth.storedvalue.DisplayBalanceOp;

/**
 *
 */
public class CawDisplayBalanceOp extends
        DisplayBalanceOp implements dtv.pos.iframework.op.IReversibleOp {

    @Override
    public IOpResponse handleOpReverse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[3];
        VoucherBalanceInfo balanceInfo = getScopedValue(ValueKeys.VOUCHER_BALANCE_INFO);
        args[0] = _ff
                .getSimpleFormattable(CawEigenConstants.MAX_VALUE_GIFTCARD, FormatterType.MONEY);
        args[1] = _ff.getSimpleFormattable(balanceInfo
                .getBalance(), FormatterType.MONEY);
        args[2] = _ff.getSimpleFormattable(CawEigenConstants.MAX_VALUE_GIFTCARD
                .subtract(balanceInfo.getBalance()), FormatterType.MONEY);

        return args;
    }

    @Override
    public boolean canceling() {

        clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
        clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);

        return super.canceling();
    }
}
