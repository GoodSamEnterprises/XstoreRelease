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
 * BZ23892          161017    Missing Auth# in receipt when performing return no receipt a reload gift card transaction
 * BZ24051          171017    price of reload GC is displayed incorrectly at return screen when performing return no receipt a Reload GC
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import java.math.BigDecimal;

import caw.pos.common.CawConfigurationMgr;
import caw.pos.common.CawValueKeys;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;

import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.storedvalue.AuthorizeCardOp;
import dtv.xst.dao.trl.IVoucherLineItem;

public class CawRefundCashOutAuthorizeCardOp extends AuthorizeCardOp {

    private static final OpChainKey CAW_NOTIFY_CASHOUT_MSG_OP = OpChainKey
            .valueOf("CAW_NOTIFY_CASHOUT_MSG_OP");

    private static final String     MAX_BALANCE_EXCHANGE_MSG  = "_relateMaxBalanceExceeded";

    private static final String     INVALID_TENDER_EXCH_AMT   = "_invalidTenderExchangeAmount";

    /*
     * check empty AuthCode
     * @see dtv.tenderauth.storedvalue.AuthorizeCardOp#updateVoucher(dtv.xst.dao.trl.IVoucherLineItem, dtv.tenderauth.event.IAuthResponse)
     */
    @Override
    protected void updateVoucher(IVoucherLineItem argVoucherLine,
            IAuthResponse response) {

        if ((response.getBalance() != null) && (argVoucherLine != null)) {
            argVoucherLine.setUnspentBalanceAmount(response.getBalance());
            argVoucherLine.setFaceValueAmount(response.getBalance());
        }

        if (response.getAuthorizationCode() != null
                && !response.getAuthorizationCode().isEmpty()) {
            argVoucherLine
                    .setAuthorizationCode(response.getAuthorizationCode());
        }
    }

    @Override
    protected IOpResponse handleSuccess(IAuthResponse response) {

        if (response.isSuccess()
                && response.getBalance().compareTo(BigDecimal.ZERO) > 0
                && response.getBalance()
                        .compareTo(CawConfigurationMgr
                                .maximumTenderExchangeBalance()) > 0
                && response instanceof CawMiraResponse
                && response.getRequest() instanceof CawMiraGiftCardRequest) {
            CawMiraGiftCardRequest request = (CawMiraGiftCardRequest) (response
                    .getRequest());
            if (request.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.CASH_OUT)) {
                setScopedValue(CawValueKeys.CASHOUT_NOTIFY_MSG, MAX_BALANCE_EXCHANGE_MSG);
                return HELPER.getStartChainResponse(CAW_NOTIFY_CASHOUT_MSG_OP);
            }
        }

        CawMiraGiftCardRequest request = (CawMiraGiftCardRequest) (response
                .getRequest());
        if (response.isSuccess() && request.getLineItem().getAmount()
                .compareTo(BigDecimal.ZERO) == 0) {
            setScopedValue(CawValueKeys.CASHOUT_NOTIFY_MSG, INVALID_TENDER_EXCH_AMT);
            return HELPER.getStartChainResponse(CAW_NOTIFY_CASHOUT_MSG_OP);
        }
        return super.handleSuccess(response);
    }
}
