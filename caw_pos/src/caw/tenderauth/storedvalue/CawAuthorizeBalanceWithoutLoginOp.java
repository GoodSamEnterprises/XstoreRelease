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
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import javax.inject.Inject;

import caw.pos.common.CawUtilFunction;
import caw.pos.common.CawVoucherValue;
import caw.tender.impl.mira.response.CawMiraResponse;

import dtv.hardware.posprinting.RcptStack;
import dtv.hardware.rcptbuilding.IRcpt;
import dtv.hardware.rcptbuilding.IRcptBuilder;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.tenderauth.event.IAuthResponse;
import dtv.util.crypto.EncString;

/**
 *
 */
public class CawAuthorizeBalanceWithoutLoginOp extends CawAuthorizeBalanceOp {

    private OpChainKey         XPAY_BALANCE_INQUIRY_MCR = OpChainKey
            .valueOf("XPAY_BALANCE_INQUIRY_MCR");

    private VoucherBalanceInfo _balanceInfo             = null;

    @Inject
    private IRcptBuilder       _rcptBuilder;

    @Override
    protected IOpResponse handleAuthResponse(IAuthResponse argResponse) {

        if (argResponse != null) {
            _balanceInfo = new VoucherBalanceInfo(_transDateProvider);
            if (argResponse.isSuccess()) {
                _balanceInfo.setBalance(argResponse.getBalance());
                _balanceInfo.setAuthCode(argResponse.getAuthorizationCode());

                String traceNum = CawVoucherValue.getVOUCHER_TRACE_NUMBER();
                _balanceInfo.setTraceNumber(traceNum);

                String seriMask = CawUtilFunction
                        .maskVCardNbr(CawVoucherValue.getVOUCHER_CARD_NUMBER());
                if (seriMask != null && seriMask.length() > 0) {
                    _balanceInfo.setSerialNumber(EncString.valueOf(seriMask));
                }

                setScopedValue(ValueKeys.VOUCHER_BALANCE_INFO, _balanceInfo);
                return super.handleAuthResponse(argResponse);

            } else {
                if (argResponse instanceof CawMiraResponse
                        && this.PRINTING_END_RCPTS != this.getOpState()) {

                    IRcpt[] rcpts = this._rcptBuilder.getRcpts(argResponse);
                    if (rcpts != null && rcpts.length > 0) {
                        this.setOpState(this.PRINTING_END_RCPTS);
                        this.setScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK, new RcptStack(
                                rcpts));
                        return this.HELPER.getWaitStackChainResponse(OpChainKey
                                .valueOf("PRINT_ITEMS"));
                    }
                }
            }
        }

        return HELPER.getStartChainResponse(XPAY_BALANCE_INQUIRY_MCR);
    }
}
