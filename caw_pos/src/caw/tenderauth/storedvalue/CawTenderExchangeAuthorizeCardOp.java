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
 * BZ23359          091017    Gift cards can't be swiped at screen
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27182          140818    Gift Card Receipt Title Not Appearing 
 * BZ33085          241019    [5.0 UAT] Void the gift card Tender line for a Sales transaction
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.*;
import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.pos.common.LocationFactory;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.event.AuthTenderFailedResponse;
import dtv.tenderauth.storedvalue.AuthorizeCardOp;
import dtv.util.crypto.EncString;
import dtv.xst.dao.loc.IRetailLocation;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trl.IVoucherLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

public class CawTenderExchangeAuthorizeCardOp extends AuthorizeCardOp {

    private static final String               MAX_BALANCE_EXCHANGE_MSG = "_relateMaxBalanceExceeded";

    @Inject
    protected StationState                    stationState;
    //Begin BZ26978
    private CawVoucherBalanceReloadActiveInfo _balanceInfo             = new CawVoucherBalanceReloadActiveInfo(
            _transDateProvider);

    //End BZ26978
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

        if (response.isSuccess()) {
            if (response instanceof CawMiraResponse) {
                CawMiraResponse cawMiraResponse = (CawMiraResponse) response;

                _balanceInfo.setBalance(response.getBalance());
                _balanceInfo.setAmount(response.getAmount());

                String traceNum = CawVoucherValue.getVOUCHER_TRACE_NUMBER();
                _balanceInfo.setTraceNumber(traceNum);

                /* BEGIN BZ33085*/
                if (cawMiraResponse.getRequest() != null) {
                    IAuthorizableLineItem lineItem = cawMiraResponse.getRequest().getLineItem();
                    if (lineItem != null) {
                        _balanceInfo.setAuthorizationCode(lineItem.getAuthorizationCode());
                        _balanceInfo.setLineSequence((lineItem.getRetailTransactionLineItemSequence()));
                    }
                }
                /* END BZ33085*/

                String seriMask = CawUtilFunction
                        .maskVCardNbr(CawVoucherValue.getVOUCHER_CARD_NUMBER());
                if (seriMask != null && seriMask.length() > 0) {
                    _balanceInfo.setSerialNumber(EncString.valueOf(seriMask));
                    _balanceInfo.setCardNumber(seriMask);
                }

                // Begin BZ27182
                _balanceInfo.setValueAddText(_ff
                        .getTranslatable("_cawGCValueAddedReceipt").toString());
                // End BZ27182
                
                //Begin BZ26978 
                if (StringUtils.isNotEmpty(cawMiraResponse.getRequestType())) {
                    if (CawConstants.TRANSACTION_TYPE_ISSUE
                            .equalsIgnoreCase(cawMiraResponse
                                    .getRequestType())) {
                        _balanceInfo
                                .setTransactionType(CawConstants.TRANSACTION_TYPE_ACTIVATION);
                    } else if (CawConstants.TRANSACTION_TYPE_RELOAD
                            .equalsIgnoreCase(cawMiraResponse
                                    .getRequestType())) {
                        _balanceInfo.setTransactionType(cawMiraResponse
                                .getRequestType());
                    } else if (CawConstants.TRANSACTION_TYPE_REDEEM
                            .equalsIgnoreCase(cawMiraResponse.getRequestType())
                            || CawConstants.TRANSACTION_TYPE_CASH_OUT
                                    .equalsIgnoreCase(cawMiraResponse
                                            .getRequestType())) {
                        _balanceInfo
                                .setTransactionType(CawConstants.TRANSACTION_TYPE_REDEMPTION);
                        
                        // Begin BZ27182
                        _balanceInfo.setAmount(response.getAmount());
                        _balanceInfo.setValueAddText(_ff
                                .getTranslatable("_cawGCValueAddedRedeemedReceipt")
                                .toString());
                        //End BZ27182
                    }
                }
                buildGiftCardDataReceipts();
                // The class CawPrintGiftCardReceiptOp.java using CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO variable to print the receipt
                List<CawVoucherBalanceReloadActiveInfo> balanceReloadActiveInfos = _transactionScope
                        .getValue(CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO);
                balanceReloadActiveInfos = CawUtilFunction
                        .modifierGiftCardReceiptInfo(balanceReloadActiveInfos, _balanceInfo);
                if (balanceReloadActiveInfos != null) {
                    _transactionScope
                            .setValue(CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO, balanceReloadActiveInfos);
                }
                //BZ26978 End
            }
            if (response.getBalance().compareTo(BigDecimal.ZERO) > 0
                    && response.getBalance()
                            .compareTo(CawConfigurationMgr
                                    .maximumTenderExchangeBalance()) > 0
                    && response instanceof CawMiraResponse && response
                            .getRequest() instanceof CawMiraGiftCardRequest) {
                CawMiraGiftCardRequest request = (CawMiraGiftCardRequest) (response
                        .getRequest());
                if (request.getCommand()
                        .equalsIgnoreCase(CawMiraCommand.CASH_OUT)) {
                    return HELPER.getErrorResponse(_formattables
                            .getTranslatable(MAX_BALANCE_EXCHANGE_MSG));
                }
            }
        }
        return super.handleSuccess(response);
    }

    @Override
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        if (!argResponse.isSuccess() && argResponse.getResponseCode() != null
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
            // Timeout case in Tender Exchange Reload Gift Card
            getScopedValue(ValueKeys.CURRENT_TENDER_LINE).setVoid(true);
            return HELPER.getStartChainResponse(OpChainKey
                    .valueOf("OUTGOING_TENDER_EXCHANGE_VOUCHER_TENDER_MCR"));
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
            clearScopedValue(CawValueKeys.IS_USER_CANCEL);
            clearScopedValue(ValueKeys.VOUCHER_INPUT_EVENT);
            clearScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER);

            if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) instanceof IVoucherTenderLineItem) {
                getScopedValue(ValueKeys.CURRENT_TENDER_LINE).setVoid(true);
                // User Cancelled in Tender Exchange Reload Gift Card
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf("OUTGOING_TENDER_EXCHANGE_VOUCHER_TENDER_MCR"));
            }
        }

        return super.handleFailed(argResponse);
    }

    private void buildGiftCardDataReceipts() {

        IPosTransaction iPosTransaction = _transactionScope.getTransaction();
        if (stationState != null && iPosTransaction != null) {
            IRetailLocation store = LocationFactory.getInstance()
                    .getStoreById(stationState.getRetailLocationId());

            if (store != null) {
                _balanceInfo.setStoreNbr(store.getStoreNbr());
                _balanceInfo.setRegisterNumber(stationState.getWorkstationId());

                _balanceInfo
                        .setTranId(iPosTransaction.getTransactionSequence());

                _balanceInfo.setBeginDateTimestamp(iPosTransaction
                        .getBeginDateTimestamp());

                if (StringUtils.isNotEmpty(store.getStoreName())) {
                    _balanceInfo.setStoreName(store.getStoreName());
                }

                if (StringUtils.isNotEmpty(store.getAddress1())) {
                    _balanceInfo.setStoreAddress(store.getAddress1());
                }

                String city = "";
                if (StringUtils.isNotEmpty(store.getCity())) {
                    city = store.getCity();
                }

                String state = "";
                if (StringUtils.isNotEmpty(store.getState())) {
                    state = store.getState();
                }

                String postalCode = "";
                if (StringUtils.isNotEmpty(store.getPostalCode())) {
                    postalCode = store.getPostalCode();
                }

                String storeLoacation = city + ", " + state + " " + postalCode;
                _balanceInfo.setStoreLocation(storeLoacation);
            }

            if (iPosTransaction.getOperatorParty() != null) {
                _balanceInfo.setTranCashierId(iPosTransaction.getOperatorParty()
                        .getEmployeeId());
            }
        }
    }
}
