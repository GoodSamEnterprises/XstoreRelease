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
 * BZ23339          210917    [DEV] Implement Gift card authorization
 * BZ23339          260917    [DEV] Implement Gift card authorization
 * BZ23359          270917    Gift cards can't be swiped at screen
 * BZ23359          021017    Gift cards can't be swiped at screen
 * BZ23359          041017    Gift cards can't be swiped at screen
 * BZ23917          111017    [Payments] Xstore is stuck "Waiting for sigcap input" 
 *                            even after customer cancels credit application on pin pad
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import java.util.Arrays;

import org.apache.log4j.Logger;

import caw.pos.common.*;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.hardware.events.IVoucherEvent;
import dtv.pos.common.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.tenderauth.*;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.event.AuthTenderFailedResponse;
import dtv.tenderauth.impl.op.AbstractAuthorizeOp;
import dtv.tenderauth.storedvalue.IStoredValueAuthRequest;
import dtv.util.crypto.EncString;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawAuthorizeBalanceOp extends AbstractAuthorizeOp {

    /**
     * 
     */
    private static final OpChainKey BALANCE_INQUIRY_MCR = OpChainKey
            .valueOf("XPAY_BALANCE_INQUIRY_MCR");

    /**
     * 
     */
    private static final String     EIGEN               = "EIGEN";

    private static final Logger     logger_             = Logger
            .getLogger(CawAuthorizeBalanceOp.class);

    private VoucherBalanceInfo      _balanceInfo        = null;

    @Override
    protected IAuthProcess buildAuthProcessor() {

        return AuthFactory.getInstance().getAuthProcess(EIGEN);
    }

    @Override
    protected IAuthRequest buildAuthRequest() {

        IVoucherEvent inputEvent = getScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
        EncString voucherNumber = getScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);
        _balanceInfo = new VoucherBalanceInfo(_transDateProvider);
        _balanceInfo.setSerialNumber(voucherNumber);

        IStoredValueAuthRequest request = (IStoredValueAuthRequest) AuthFactory
                .getInstance()
                .makeAuthRequest(EIGEN, AuthRequestType.INQUIRE_BALANCE, null, true);

        request.setAccountId(voucherNumber);
        request.setCurrencyId(ConfigurationMgr.getCurrency().getCurrencyCode());
        request.setInputEvent(inputEvent);
        request.setPIN(getScopedValue(ValueKeys.ENTERED_PIN));

        return request;
    }

    @Override
    protected IOpResponse handleVoid() {

        clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
        clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);

        IRetailTransaction trans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);

        //Check the Transaction is a retail sale transaction or not. If It is, This means a session started for VF before
        //So, we don't close session in this case. but we will displays the line item screen on the terminal.
        if (trans != null) {
            logger_.info("sending a message to display the line item screen.");
            logger_.info("finish sending a message to display the line item screen.");
            return HELPER.completeResponse();
        }
        logger_.info("Failed Response. Sending a close session message to MIRA.");

        return null;
    }

    @Override
    protected IOpResponse handleTrainingMode() {

        return null;
    }

    @Override
    protected IOpResponse handleAuthResponse(IAuthResponse argResponse) {

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

        } else {
            _balanceInfo.setReceiptRequired(false);
            return super.handleAuthResponse(argResponse);
        }

        setScopedValue(ValueKeys.VOUCHER_BALANCE_INFO, _balanceInfo);
        return super.handleAuthResponse(argResponse);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        _transactionScope.clearValue(TransactionScopeKeys.SAVED_TENDER_INPUT);

        if (Arrays.asList(argResponse.getAvailableActions())
                .contains(AuthFailedActionType.AUTO_MANUAL)) {
            return handleManualAuth();
        }

        setOpState(SHOWING_FAILED);

        if (!argResponse.isSuccess() && argResponse.getResponseCode() != null
                && argResponse.getResponseCode()
                        .equalsIgnoreCase(ResponseCode.USER_CANCEL
                                .toString())) {
            // Balance Inquiry User Cancelled Case
            return HELPER.getStartChainResponse(BALANCE_INQUIRY_MCR);
        } else if (!argResponse.isSuccess()
                && argResponse.getResponseCode() != null
                && argResponse.getResponseCode()
                        .equalsIgnoreCase(ResponseCode.TIMEOUT.toString())) {
            // Balance Inquiry Timeout Case
            return HELPER.getStartChainResponse(BALANCE_INQUIRY_MCR);
        } else if (argResponse instanceof AuthTenderFailedResponse
                && getScopedValue(CawValueKeys.IS_OPCHAIN_MCR) != null
                && !getScopedValue(CawValueKeys.IS_OPCHAIN_MCR)) {
            // Balance Inquiry Timeout Case
            return HELPER.getStartChainResponse(BALANCE_INQUIRY_MCR);
        } else {
            return super.handleFailed(argResponse);
        }
    }

    //Begin BZ25958
    /**
     * @return the balanceInfo
     */
    public VoucherBalanceInfo getBalanceInfo() {
        return _balanceInfo;
    }

    /**
     * @param argBalanceInfo the balanceInfo to set
     */
    public void setBalanceInfo(VoucherBalanceInfo argBalanceInfo) {
        _balanceInfo = argBalanceInfo;
    }
    //End BZ25958
}
