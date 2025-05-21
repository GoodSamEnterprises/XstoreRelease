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
 * BZ27757          100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 * BZ29520          250219    [Internal] The messaging when authorizer is offline/timed out is missing the word, Gift Card during GC issuance.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import caw.pos.common.*;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.storedvalue.CawAuthorizeBalanceOp;

import dtv.hardware.posprinting.RcptStack;
import dtv.hardware.rcptbuilding.IRcpt;
import dtv.hardware.rcptbuilding.IRcptBuilder;
import dtv.i18n.IFormattable;
import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.tenderauth.AuthRequestType;
import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.form.TenderAuthEditModel;
import dtv.util.crypto.EncString;

/**
 *
 */
public class CawSaleBalanceInquiryAuthorizeCardOp
        extends CawAuthorizeBalanceOp {

    // Begin BZ27757
    private static final Logger  logger_ = Logger
            .getLogger(CawSaleBalanceInquiryAuthorizeCardOp.class);
    // End BZ27757

    @Inject
    private IRcptBuilder         _rcptBuilder;

    // Begin BZ27757
    /**
     * The variable iAuthResponse use keep the value of the response.
     * In case, The Gift card declined receipt need to print.
     */
    private static IAuthResponse iAuthResponse;
    // End BZ27757

    @SuppressWarnings("deprecation")
    @Override
    protected IOpResponse handleAuthResponse(IAuthResponse argResponse) {

        if (argResponse != null) { //BZ27757
            iAuthResponse = argResponse; //BZ27757

            /**
             * The request TC28 is successful. It means Gift Card is active.
             */
            if (argResponse.isSuccess()) {
                logger_.info("The gift card is active.");
                if (getBalanceInfo() == null) {
                    setBalanceInfo(new VoucherBalanceInfo(_transDateProvider));
                }
                getBalanceInfo().setBalance(argResponse.getBalance());
                getBalanceInfo()
                        .setAuthCode(argResponse.getAuthorizationCode());

                String traceNum = CawVoucherValue.getVOUCHER_TRACE_NUMBER();
                getBalanceInfo().setTraceNumber(traceNum);

                String seriMask = CawUtilFunction
                        .maskVCardNbr(CawVoucherValue.getVOUCHER_CARD_NUMBER());
                if (seriMask != null && seriMask.length() > 0) {
                    getBalanceInfo()
                            .setSerialNumber(EncString.valueOf(seriMask));
                }

                setScopedValue(ValueKeys.VOUCHER_BALANCE_INFO, getBalanceInfo());
                setScopedValue(CawValueKeys.CARD_ACTIVE_STATUS, CawConstants.CARD_ACTIVE); //BZ27757

                return HELPER.completeResponse();
                // Begin BZ27757
                /**
                 * The handle the case, the request TC28 response card not active or response error.
                 */
            } else {
                /**
                 * The process active the gift card.
                 */
                if (_transactionScope
                        .getValue(CawValueKeys.IS_NOT_ACTIVE) != null
                        && _transactionScope
                                .getValue(CawValueKeys.IS_NOT_ACTIVE)) {
                    logger_.info("The gift need to active.");
                    setScopedValue(CawValueKeys.CARD_ACTIVE_STATUS, CawConstants.CARD_IN_ACTIVE);
                    setScopedValue(CawValueKeys.MIRASERV_AUTH_RESPONSE, iAuthResponse);
                    return HELPER.completeResponse();
                    /**
                     * Print the receipt when the gift card does not check status.
                    */
                } else {
                    logger_.info("The gift card is not active.");
                    if (this.getOpState() == null
                            || this.PRINTING_END_RCPTS != this.getOpState()) {
                        if (argResponse instanceof CawMiraResponse) {
                            CawMiraResponse cawMiraResponse = (CawMiraResponse) argResponse;
                            IRcpt[] rcpts = this._rcptBuilder
                                    .getRcpts(cawMiraResponse);
                            if (rcpts != null && rcpts.length > 0) {
                                this.setOpState(this.PRINTING_END_RCPTS);
                                this.setScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK, new RcptStack(
                                        rcpts));
                                _transactionScope
                                        .clearValue(CawValueKeys.IS_NOT_ACTIVE);

                                return this.HELPER
                                        .getWaitStackChainResponse(OpChainKey
                                                .valueOf("PRINT_ITEMS"));
                            }
                        }
                    }
                }
            }
            // End BZ27757
        }

        // Begin BZ27757
        /**
         * The screen "AUTH_FAILED" display after print the error receipt. 
         */
        if (iAuthResponse != null) {
            logger_.info("The gift card is displayed AUTH_FAILED screen.");
            /* BEGIN: BZ29520*/
            IAuthRequest request = iAuthResponse.getRequest();
            if (request != null) {
                if (AuthRequestType.INQUIRE_BALANCE.equals(request.getRequestType())) {
                    IFormattable obj = iAuthResponse.getMessage();
                    if (obj != null && obj.getUnformattedData() != null) {
                        String value = obj.getUnformattedData().toString();
                        value = value.replace("{0}", _ff.getTranslatable("_XPAY_GIFT_CARD").toString());
                        iAuthResponse.setMessage(_ff.getLiteral(value));
                    }
                }
            }
            /* END: BZ29520*/
            setScopedValue(CawValueKeys.CARD_ACTIVE_STATUS, CawConstants.CARD_IN_ACTIVE);
            setScopedValue(CawValueKeys.MIRASERV_AUTH_RESPONSE, iAuthResponse);
            this.setOpState(this.SHOWING_FAILED);
            DataActionGroupKey actionGroup = this
                    .getFailedDataActionGroup(iAuthResponse);
            TenderAuthEditModel editModel = this.makeEditModel(iAuthResponse);
            return this.HELPER.getShowFormResponse(FormKey
                    .valueOf("AUTH_FAILED"), editModel, actionGroup);

        } else {
            return HELPER.completeResponse();
        }
        // End BZ27757
    }

    @Override
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        if (!argResponse.isSuccess() && argResponse.getResponseCode() != null) {
            setScopedValue(CawValueKeys.CARD_ACTIVE_STATUS, CawConstants.CARD_IN_ACTIVE);
            return HELPER.completeResponse();
        } else {
            return super.handleFailed(argResponse);
        }
    }

}
