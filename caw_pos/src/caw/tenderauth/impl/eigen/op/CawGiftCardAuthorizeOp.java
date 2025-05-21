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
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27182          140818    Gift Card Receipt Title Not Appearing 
 * BZ27247          170818    Gift Card Reloads should have GC RELOAD for Item #
 * BZ27269          230818    Doing more 2 items GC reload into transaction are taking so long
 * BZ27364          240818    [1.6.14][26207] HDE when performing WO Refund to GC. 
 * BZ33085          241019    [5.0 UAT] Void the gift card Tender line for a Sales transaction
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;
import caw.tender.impl.mira.response.CawMiraResponse;

import dtv.pos.common.LocationFactory;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.tenderauth.event.IAuthResponse;
import dtv.util.crypto.EncString;
import dtv.xst.dao.loc.IRetailLocation;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawGiftCardAuthorizeOp extends CawAuthorizeCardOp {

    @Inject
    protected StationState                    stationState;

    private CawVoucherBalanceReloadActiveInfo _balanceInfo = new CawVoucherBalanceReloadActiveInfo(
            _transDateProvider);

    private static final Logger               _logger      = LogManager
            .getLogger(CawGiftCardAuthorizeOp.class);

    @SuppressWarnings("deprecation")
    @Override
    protected IOpResponse handleSuccess(IAuthResponse argResponse) {

        if (argResponse.isSuccess()) {
            _logger.debug("Begin handleSuccess-0");
            if (argResponse instanceof CawMiraResponse) {
                CawMiraResponse cawMiraResponse = (CawMiraResponse) argResponse;

                _balanceInfo.setBalance(argResponse.getBalance());
                _balanceInfo.setAmount(argResponse.getAmount());

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

                //BZ26978 Begin
                String tranType = cawMiraResponse.getRequestType();
                if (StringUtils.isNotEmpty(tranType)) {
                    if (CawConstants.TRANSACTION_TYPE_ISSUE
                            .equalsIgnoreCase(tranType)) {
                        _balanceInfo
                                .setTransactionType(CawConstants.TRANSACTION_TYPE_ACTIVATION);
                    } else if (CawConstants.TRANSACTION_TYPE_RELOAD
                            .equalsIgnoreCase(tranType)) {
                        _balanceInfo.setTransactionType(tranType);
                    } else if (CawConstants.TRANSACTION_TYPE_REDEEM
                            .equalsIgnoreCase(tranType)
                            || CawConstants.TRANSACTION_TYPE_CASH_OUT
                                    .equalsIgnoreCase(tranType)) {
                        _balanceInfo
                                .setTransactionType(CawConstants.TRANSACTION_TYPE_REDEMPTION);

                        // Begin BZ27182
                        _balanceInfo.setAmount(argResponse.getAmount());
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
        }
        return super.handleSuccess(argResponse);
    }

    /**
     * Added 26978
     */
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
