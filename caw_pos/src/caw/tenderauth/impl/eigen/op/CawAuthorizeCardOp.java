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
 * BZ23359          021017    Gift cards can't be swiped at screen
 * BZ23359          041017    Gift cards can't be swiped at screen
 * BZ23359          091017    Gift cards can't be swiped at screen
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import java.math.BigDecimal;
import java.util.List;

import caw.pos.common.CawValueKeys;
import caw.tender.impl.mira.CawMiraUtil;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.MoreAuthInfoEditModel;
import dtv.tenderauth.IAuthInputField;
import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.event.AuthTenderFailedResponse;
import dtv.tenderauth.storedvalue.AuthorizeCardOp;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

/**
 *
 */
public class CawAuthorizeCardOp extends AuthorizeCardOp {

    /**
     * 
     */
    private static final OpChainKey OP_STANDARD_TENDER_VOUCHER_MCR = OpChainKey
            .valueOf("STANDARD_TENDER_VOUCHER_MCR");

    private static final OpChainKey OP_SALE_VOUCHER_FINISH_MCR     = OpChainKey
            .valueOf("SALE_VOUCHER_FINISH_MCR");

    private static final PromptKey  INVALID_RELOAD_AMOUNT          = PromptKey
            .valueOf("INVALID_RELOAD_GC_AMOUNT");

    PromptKey                       LAST_TRANS_SUCCEED             = PromptKey
            .valueOf("LAST_TRANS_SUCCEED");

    /**
     * clear serial number after canceling
     */
    @Override
    public boolean isCancelable() {

        clearScopedValue(ValueKeys.CURRENT_AUTH_REQUEST);
        return super.isCancelable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IOpResponse handlePostPrompt(IXstEvent argEvent,
            IOpState argState) {

        disableAllButton();
        IAuthRequest request = getScopedValue(ValueKeys.CURRENT_AUTH_REQUEST);
        if ((argEvent instanceof IXstDataAction)) {
            IXstDataAction action = (IXstDataAction) argEvent;
            IXstActionKey actionKey = action.getActionKey();
            if (RETRY == actionKey || MANUAL_AUTH == actionKey) {
                IAuthResponse lastTransResponse = handleLastTrans();
                if (isValidResponse(request, lastTransResponse)) {
                    handleAuthResponse(lastTransResponse);
                    setComplete(true);
                    return HELPER.getPromptResponse(LAST_TRANS_SUCCEED);
                }
            }
        }
        return super.handlePostPrompt(argEvent, argState);
    }

    @Override
    protected IOpResponse handleManualAuthInfoResponse(IXstEvent argArgEvent) {

        String authCode = "";
        ISaleReturnLineItem lineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if (argArgEvent instanceof IXstDataAction) {
            IXstDataAction dataAction = (IXstDataAction) argArgEvent;
            if (dataAction.getData() instanceof MoreAuthInfoEditModel) {
                MoreAuthInfoEditModel authInfo = ((MoreAuthInfoEditModel) dataAction
                        .getData());
                IAuthInputField[] inputField = authInfo.getMoreAuthInfo()
                        .getInputFields();
                if (inputField.length > 0) {
                    authCode = inputField[0].getValue().toString();
                }
            }
        }
        if ((lineItem instanceof IVoucherSaleLineItem)) {
            ((IVoucherSaleLineItem) lineItem).setAuthorizationCode(authCode);
        }
        return HELPER.completeResponse();
    }

    private void disableAllButton() {

        IPromptActionModel actionModel = _modeProvider.get().getStationModel()
                .getPromptActionModel();

        List<IXstAction> actionList = (List<IXstAction>) actionModel
                .getActions();
        for (IXstAction action : actionList) {
            action.setEnabled(false);
        }
    }

    /**
     * check the last transaction is valid or not.
     * @param request
     * @param lastTransResponse
     * @return
     */
    private boolean isValidResponse(IAuthRequest request,
            IAuthResponse lastTransResponse) {

        return (lastTransResponse != null
                && lastTransResponse instanceof CawMiraResponse
                && lastTransResponse.isSuccess()
                && CawMiraUtil.isValidLastTrans(request, lastTransResponse));
    }

    /**
     * Send LAST_TRANS message to MIRA and process the response if successfully
     * @return
     */
    private IAuthResponse handleLastTrans() {

        return null;
    }

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
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        if (argResponse instanceof CawMiraResponse) {
            CawMiraResponse miraResponse = (CawMiraResponse) argResponse;
            if (miraResponse.getRequest() instanceof CawMiraGiftCardRequest) {
                CawMiraGiftCardRequest miraGiftCardReq = (CawMiraGiftCardRequest) miraResponse
                        .getRequest();
                Boolean isExceedMaxGcValue = getScopedValue(CawValueKeys.IS_EXCEED_MAX_GC_BALANCE);
                if (miraGiftCardReq.getCommand() != null
                        && miraGiftCardReq.getCommand()
                                .equalsIgnoreCase(CawMiraCommand.RELOAD)
                        && isExceedMaxGcValue != null
                        && isExceedMaxGcValue.booleanValue()) {
                    clearScopedValue(CawValueKeys.IS_EXCEED_MAX_GC_BALANCE);
                    setOpState(SHOWING_FAILED);
                    IFormattable args[] = new IFormattable[1];
                    BigDecimal balance = getScopedValue(CawValueKeys.CURRENT_VOUCHER_BALANCE);
                    args[0] = _ff
                            .getSimpleFormattable(CawEigenConstants.MAX_VALUE_GIFTCARD
                                    .subtract(balance), FormatterType.MONEY);

                    return HELPER
                            .getPromptResponse(INVALID_RELOAD_AMOUNT, args);
                }
            }
        }

        if (!argResponse.isSuccess() && argResponse.getResponseCode() != null
                && getScopedValue(CawValueKeys.IS_USER_CANCEL) != null
                && getScopedValue(CawValueKeys.IS_USER_CANCEL)
                && argResponse.getRequest() instanceof CawMiraGiftCardRequest
                && ((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand() != null
                && !((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand().equalsIgnoreCase(CawMiraCommand.REDEEM)) {
            // Balance Inquiry User Cancelled Case
            clearScopedValue(CawValueKeys.IS_USER_CANCEL);
            return HELPER.getStartChainResponse(OP_SALE_VOUCHER_FINISH_MCR);
        } else if (!argResponse.isSuccess()
                && argResponse.getResponseCode() != null
                && argResponse.getResponseCode()
                        .contains(ResponseCode.TIMEOUT.toString())
                && argResponse.getRequest() instanceof CawMiraGiftCardRequest
                && ((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand() != null
                && ((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand().equalsIgnoreCase(CawMiraCommand.RELOAD)
                && getScopedValue(CawValueKeys.IS_OPCHAIN_MCR) != null
                && !getScopedValue(CawValueKeys.IS_OPCHAIN_MCR)) {
            clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
            clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);
            // Reload timeout case
            if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) == null) {
                return HELPER.getStartChainResponse(OP_SALE_VOUCHER_FINISH_MCR);
            } else if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) instanceof IVoucherTenderLineItem) {
                getScopedValue(ValueKeys.CURRENT_TENDER_LINE).setVoid(true);
                return HELPER
                        .getStartChainResponse(OP_STANDARD_TENDER_VOUCHER_MCR);
            }
        } else if (argResponse instanceof AuthTenderFailedResponse
                && argResponse.getRequest() instanceof CawMiraGiftCardRequest
                && ((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand() != null
                && !((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand().equalsIgnoreCase(CawMiraCommand.ACTIVATE)
                && !((CawMiraGiftCardRequest) argResponse.getRequest())
                        .getCommand().equalsIgnoreCase(CawMiraCommand.REDEEM)
                && getScopedValue(CawValueKeys.IS_OPCHAIN_MCR) != null
                && !getScopedValue(CawValueKeys.IS_OPCHAIN_MCR)) {
            // Balance Inquiry Timeout Case
            clearScopedValue(CawValueKeys.IS_USER_CANCEL);
            clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
            clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);

            if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) == null) {
                return HELPER.getStartChainResponse(OP_SALE_VOUCHER_FINISH_MCR);
            } else if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) instanceof IVoucherTenderLineItem) {
                getScopedValue(ValueKeys.CURRENT_TENDER_LINE).setVoid(true);
                return HELPER
                        .getStartChainResponse(OP_STANDARD_TENDER_VOUCHER_MCR);
            }
        }

        return super.handleFailed(argResponse);
    }
}
