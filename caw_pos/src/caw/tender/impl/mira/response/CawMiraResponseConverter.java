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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 * BZ23383              180917    Return transaction by Credit Card tender
 * BZ23339              210917    [DEV] Implement Gift card authorization
 * BZ23339              260917    [DEV] Implement Gift card authorization
 * BZ23530              260917    Cash Drawer pops incorrectly after completing a credit/debit tender
 * BZ23527              260917    Amounts in appear to be multipled by hundred after auth is processed
 * BZ23517              260917    Not encoded card number on receipt when performing return transaction 
 *                                by tender credit card
 * BZ23558              270917    Receipts are missing EMV data
 * BZ23432              270917    No signature displays in Store receipt although the customer signed 
 *                                signature on Sig Cap when performing transaction with Credit tender
 * BZ23543              270917    [GC] The information of Gift Card displays incorrect in receipt when reload GC
 * BZ23585              270917    Xstore stuck in a loop when authorization service is offline
 * BZ23640              280917    Entry method of Fallback card doesn't display in receipt when performing transaction with EMV-Fallback card
 * BZ23652              290917    Can't complete the tender exchange GC transaction in BO when void Credit tender
 * BZ23559              021017    [Receipts] Gift Card Tender Exchange transaction receipt does not meet CW requirements
 * BZ23643              041017    [GC] Name of Reload Gift Card is displayed incorrectly in receipt
 * BZ23603              041017    Allow refund to original Credit and Debit card for Receipt Return transactions
 * BZ23697              041017    Decline receipt is printed for EMV- Fall back card
 * BZ23800              051017    Missing EMV tag in declined receipt when performing transaction with EMV is declined
 * BZ23860              091017    SigCap turned on the light and required to swipe card when return transaction with GS Visa card
 * BZ23937              111017    The SigCap is turned on and required to swipe card after Void line New Good Sam Visa card tender
 * BZ23892              161017    Missing Auth# in receipt when performing return no receipt a reload gift card transaction
 * BZ24105              191017    Should be distinguish Good Sam Visa card and Shopping Pass tender in DB
 * BZ24232              261017    [OrderService] Xstore needs to send the card holder in the order_service.out message
 * BZ24230              261017    [OrderService] Xstore must send the unencrypted credit card token in order_service.out message
 * BZ24230              301017    [OrderService] Xstore must send the unencrypted credit card token in order_service.out message
 * BZ24854              151217    [PROD] Return to GSVS transaction failed in order service with error "Tender.authorization is required for Credit tenders."
 * BZ24937              090118    [Prod Support] Disable line item displaying on pinpad 
 * BZ25958              010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ27757              100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 * BZ28562              071218    PINPAD doesn't reload items once complete transaction by partial Credit card
 * BZ28563              111218    Items is overwriting on PINPAD when selling a GC item
 * BZ28561              131218    [PINPAD] Items is overwriting on Gander Outdoor idle screen
 * BZ28744              261218    [2.9.7] Missing credit/EMV credit information on Tender exchange receipt.
 * BZ29360              150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29406              180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29383              190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc.
 * BZ29321              200219    [3.9.3][PLCC] PLCC plastic approval cards are only approving $0.00.
 * BZ29476              210219    [Internal] GS Account Payment is prompting signature on PinPad.
 * BZ29504              220219    [Internal] PLCC tender doesn't capture customer name in DB when using lookup functionality
 * BZ29536              260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29505              010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ30314              220419    [Port BZ30262 to Release 4.2.0] OS transaction failed due to token is missing when tender exchange GiftCard with Credit Card
 * BZ31568              250619    [Port BZ31110 to 5.0] [Prod] Xstore charged full WO total amount to the new approved PLCC
 * BZ32123              240719    [Prod] Gift Card Reload Activated Wrong Card Number
 * BZ35962              050520    [Prod] Don't need to encrypt the credit card token (GSVS/PLCC) for Xstore build 6.0
 * BZ37305              260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad.  
 * BZ33319              260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ41674              050321    ADS Settlement - ORIG_INVOICE_NO on the return needs to match the INVOICE_NO of the purchase.
 * BZ47123              050122    [PROD] Order Service Token Error
 *===================================================================
 */

package caw.tender.impl.mira.response;

import java.awt.Point;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.*;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.*;
import caw.pos.register.ufa.CawUFAConstants;
import caw.tender.impl.mira.CawMiraFormatter;
import caw.tender.impl.mira.CawMiraUtil;
import caw.tender.impl.mira.request.CawMiraRequest;
import caw.tenderauth.impl.eigen.*;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.*;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.data2.access.DataFactory;
import dtv.hardware.sigcap.ISignature;
import dtv.hardware.sigcap.Signature;
import dtv.hardware.types.HardwareFamilyType;
import dtv.hardware.types.HardwareType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.OperationDefaultScope;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.security.StationState;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.IAuthResponseConverter;
import dtv.tenderauth.event.IAuthResponse;
import dtv.util.StringUtils;
import dtv.util.crypto.DtvEncrypter;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.ttr.*;

@SuppressWarnings("deprecation")
public class CawMiraResponseConverter implements IAuthResponseConverter {

    private static final String   CCENC                 = "ccenc";

    private static final String   TAC                   = "TAC";

    private static final String   TAG                   = "Tag";

    private static final String   NONE                  = "NONE";

    private static final String   VERIFIED_BY_SIGNATURE = "Verified by Signature";

    private static final String   VERIFIED_BY_PIN       = "Verified by Pin";

    private static final String   NULL_VALUE            = "null";

    /*BEGIN BZ33319*/
    private static final String   IS_DEFER_FINANCIAL    = "IS_DEFER_FINANCIAL";

    private static final String   DEFER_FINANCIAL_MSG   = "DEFER_FINANCIAL_MSG";

    private static final String   TRUE_VALUE            = "TRUE";
    /*END BZ33319*/

    private static final String   PROMOTE_FINANCIAL     = "PROMOTE_FINANCIAL";    /*BZ41674*/

    public final String   VERIFONE              = "VERIFONE"; // BZ29476

    private CawMiraFormatter      _formatter            = new CawMiraFormatter();

    private static final Logger   logger_               = Logger
            .getLogger(CawMiraResponseConverter.class);

    @Inject
    private TenderHelper          _tenderHelper;

    @Inject
    protected TransactionScope    _transactionScope;                              // BZ23558

    @Inject
    protected StationState        _stationState;

    private BigDecimal            hundred               = new BigDecimal(100);    //BZ23530_BZ23527

    private OperationDefaultScope _defaultScope;

    @Inject
    private CawEigenMgr           _cawEigenMgr;
    
    private CawCustomerGSHelper   _gsHelper             = CawCustomerGSHelper.getInstance(); /*BZ29360*/
    
    @Inject
    protected FormattableFactory  _ff;                                            /*BZ33319*/

    public CawMiraResponseConverter() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    public IAuthResponse convertResponse(Object argObject,
            IAuthRequest argIAuthRequest) {

        ((CawMiraRequest) argIAuthRequest).getTransactionScope();
        _defaultScope = ((CawMiraRequest) argIAuthRequest).getDefaultScope();
        CawMiraResponse cawResponse = convert2CawResponse(_formatter
                .getMiraData(), (CawMiraRequest) argIAuthRequest);

        if (_cawEigenMgr != null
                && argIAuthRequest instanceof CawMiraGiftCardRequest
                && _transactionScope != null
                && _transactionScope.getTransaction() != null
                && _transactionScope.getTransaction().getAmountDue() != null
                && _transactionScope.getTransaction().getTaxAmount() != null) {
                /* Begin BZ28563 */
                //_cawEigenMgr.updateTransAmt(_transactionScope.getTransaction()
                //.getAmountDue().toString(), _transactionScope
                //.getTransaction().getTaxAmount().toString());
                /* End BZ28563 */
        }

        return cawResponse;
    }

    /**
     * Translate the response from VeriFone device to the Caw response
     */
    public CawMiraResponse convert2CawResponse(MiraServJava miraResponse,
            CawMiraRequest cawRequest) {

        CawMiraResponse cawResponse = cawRequest.getResponse(miraResponse);
        cawResponse.setMiraServerData(miraResponse);

        // check Declined Action Code to print Declined Gift Card Receipt
        if (cawResponse.getActionCode() != null && cawResponse.getActionCode()
                .equalsIgnoreCase(CawEigenConstants.FN_DECLINED_VALUE)) {
            cawResponse.setIsDeclinedActionCode(Boolean.TRUE);
        }

        //set response code that is control fail actions if response is fail 
        try {
            if (CawMiraUtil.translateResultCode(new BigInteger(miraResponse
                    .GetTField(CawEigenConstants.FN_RESPONSE_CODE))) == ResponseCode.Success) {
                cawResponse.setSuccess(true);
            }
        } catch (MiraServJavaException ex) {
            logger_.error("Exception when get response" + ex.getMessage());
            cawResponse.setSuccess(false);
        }
        try {
            //handle response
            if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.CAPTURE)) {
                return handleAuthorizeResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.REFUND)) {
                return handleCreditResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.VOID_CAPTURE)) {
                return handleVoidResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.VOID_REFUND)) {
                return handleVoidResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.ACTIVATE)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.DEACTIVATE)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.REDEEM)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.REDEEM_VOID)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.BALANCE_INQUIRY)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.RELOAD)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.RELOAD_VOID)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.CASH_OUT)) {
                return handleGiftCardResponse(cawResponse, cawRequest);
            } else if (cawRequest.getCommand()
                    .equalsIgnoreCase(CawMiraCommand.AUTHORIZATION_BY_PHONE)) {
                return handleAuthorizeByPhoneResponse(cawResponse, cawRequest);//BZ23585
            }
            /*BEGIN BZ37305*/
            else if (cawRequest.getCommand().equalsIgnoreCase(CawMiraCommand.DISPLAY_CUSTOMER_INFORMATION)) {
                _transactionScope.setValue(CawValueKeys.CAW_VERIFY_CUSTOMER_MIRA_RESPONSE, cawResponse);/*BZ47123*/
                return handleDisplayCustomerRespone(cawResponse);
            }
            /*END BZ37305*/

        } catch (Exception e) {
            logger_.error("Cannot build Caw response message "
                    + e.getMessage());
        }

        return cawResponse;
    }

    /**
     * @param argCawResponse
     * @param argCawRequest
     * @return
     */
    private CawMiraResponse handleVoidResponse(CawMiraResponse cawResponse,
            CawMiraRequest cawRequest) {
        /* Begin BZ28562, BZ28561, BZ29383*/
        CawPinpadItemModelHelper.handleRefreshPinPadScreen(true);
        /* End BZ28562, BZ2856, BZ29383 */
        
        if (cawResponse.isSuccess()) {
            //Store information of response in database
            ITenderLineItem tenderLineItem = _defaultScope
                    .getValue(ValueKeys.CURRENT_TENDER_LINE);
            if (tenderLineItem == null) {
                tenderLineItem = _transactionScope
                        .getValue(ValueKeys.CURRENT_TENDER_LINE);
            }
            if (tenderLineItem != null
                    && tenderLineItem instanceof IAuthorizableTenderLineItem) {
                IAuthorizableTenderLineItem argLineItem = (IAuthorizableTenderLineItem) tenderLineItem;
                argLineItem.setAdjudicationCode(cawResponse.getResponseCode());
            }
            if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
                //following functional specification, update DB
                ICreditDebitTenderLineItem creditDebitLine = (ICreditDebitTenderLineItem) tenderLineItem;
                creditDebitLine.setTraceNumber(StringUtils
                        .nonEmpty(cawResponse.getTraceNumber()));
                updateCreditDebitTenderLineItem(cawResponse, tenderLineItem);

                // set ShortToken data into TransactionReferenceData column
                creditDebitLine
                        .setTransactionReferenceData(encryptField(CCENC, cawResponse
                                .getShortToken()));

                creditDebitLine
                        .setExpirationDateString(cawResponse.getExpiryDate());
            }
        }

        return cawResponse;
    }

    /**
     * @param cawResponse
     * @param cawRequest
     * @return
     */
    @SuppressWarnings("deprecation")
    private CawMiraResponse handleGiftCardResponse(CawMiraResponse cawResponse,
            CawMiraRequest cawRequest) {
        /* Begin BZ28563, BZ28561, BZ29383 */
        CawPinpadItemModelHelper.handleRefreshPinPadScreen(true);
        /* End BZ28563, BZ28561, BZ29383 */
        if (cawResponse.isSuccess()) {
            cawResponse.setBalance(cawResponse.getBalance());
            cawResponse.setAmount(cawRequest.getAmount());
            /* CawVoucherValue
                    .setVOUCHER_CARD_NUMBER(cawResponse.getMaskAccountNumber());*/
            CawVoucherValue
                    .setVOUCHER_TRACE_NUMBER(cawResponse.getTraceNumber());

            CawVoucherValue.setGiftCardToken(cawResponse.getToken());//BZ25958

            //Store information of response in database
            ITenderLineItem tenderLineItem = _defaultScope
                    .getValue(ValueKeys.CURRENT_TENDER_LINE);
            IAuthorizableLineItem authLineItem = cawRequest.getLineItem();
            //Begin BZ25958
            if (authLineItem == null) {
                try {
                    ((CawMiraGiftCardRequest) cawResponse.getRequest())
                            .getDefaultScope()
                            .getValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                            .setBankReferenceNumber(cawResponse
                                    .getMiraServResponse().GetTField("TK"));
                    ((CawMiraGiftCardRequest) cawResponse.getRequest())
                            .getDefaultScope()
                            .getValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                            .setTraceNumber(CawVoucherValue
                                    .getVOUCHER_TRACE_NUMBER());
                    ((CawMiraGiftCardRequest) cawResponse.getRequest())
                            .getDefaultScope()
                            .getValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                            .setAuthorizationCode(cawResponse
                                    .getAuthorizationCode());

                } catch (MiraServJavaException ex) {
                    logger_.error("Exception when get line item "
                            + ex.getMessage());
                }
            } else {
                try {
                    authLineItem.setBankReferenceNumber(cawResponse
                            .getMiraServResponse().GetTField("TK"));
                    authLineItem.setAuthorizationCode(cawResponse
                            .getAuthorizationCode());
                    authLineItem.setTraceNumber(CawVoucherValue
                            .getVOUCHER_TRACE_NUMBER());
                } catch (MiraServJavaException ex) {
                    logger_.error("Cannot get fields from Caw response"
                            + ex.getMessage());
                }
            }
            //End BZ25958

            if (tenderLineItem != null) {
                tenderLineItem
                        .setSerialNumber(cawResponse.getMaskAccountNumber());

                if (tenderLineItem instanceof IAuthorizableTenderLineItem) {
                    IAuthorizableTenderLineItem argLineItem = (IAuthorizableTenderLineItem) tenderLineItem;

                    argLineItem
                            .setAdjudicationCode(cawResponse.getResponseCode());
                    copyBankReferenceNumber(argLineItem, cawResponse);

                    //More information in verifone response needed to save database
                    if (CawEntryMethodCode.SWIPE
                            .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                        argLineItem
                                .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_SWIPED);
                    } else if (CawEntryMethodCode.KEYED
                            .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                        argLineItem
                                .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_KEYED);
                    } else {
                        argLineItem.setEntryMethodCode(null);
                        logger_.info("Not handle entry method code");
                    }

                    if (cawResponse.getAuthorizationCode() != null) {
                        argLineItem.setAuthorizationCode(cawResponse
                                .getAuthorizationCode());
                    }
                }

                if (tenderLineItem instanceof IVoucherTenderLineItem) {
                    //following functional specification.
                    IVoucherTenderLineItem voucherTenderLine = (IVoucherTenderLineItem) tenderLineItem;

                    voucherTenderLine.setUnspentBalanceAmount(NumberUtils
                            .createBigDecimal(String
                                    .valueOf(cawResponse.getBalance())));
                    voucherTenderLine.setAuthorizationToken(cawResponse
                            .getAuthorizationToken());

                    voucherTenderLine
                            .setBankReferenceNumber(cawResponse.getToken());
                    voucherTenderLine
                            .setTraceNumber(cawResponse.getTraceNumber());

                    if (CawEntryMethodCode.SWIPE
                            .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                        voucherTenderLine
                                .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_SWIPED);
                    } else if (CawEntryMethodCode.KEYED
                            .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                        voucherTenderLine
                                .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_KEYED);
                    } else {
                        voucherTenderLine.setEntryMethodCode(null);
                        logger_.info("Not handle entry method code");
                    }

                    if (cawResponse.getAuthorizationCode() != null) {
                        voucherTenderLine.setAuthorizationCode(StringUtils
                                .nonEmpty(cawResponse.getAuthorizationCode()));
                    }
                }
            } else if (authLineItem != null) {
                authLineItem.setSerialNumber(CawVoucherValue
                        .getVOUCHER_CARD_NUMBER());

                authLineItem.setAdjudicationCode(cawResponse.getResponseCode());
                copyBankReferenceNumber(authLineItem, cawResponse);

                if (authLineItem instanceof IVoucherSaleLineItem) {
                    //following functional specification.
                    IVoucherSaleLineItem voucherSaleLine = (IVoucherSaleLineItem) authLineItem;
                    voucherSaleLine
                            .setBankReferenceNumber(cawResponse.getToken());
                    voucherSaleLine
                            .setTraceNumber(cawResponse.getTraceNumber());
                    /*BEGIN BZ23543*/
                    voucherSaleLine.setUnspentBalanceAmount(NumberUtils
                            .createBigDecimal(String
                                    .valueOf(cawResponse.getBalance())));
                    voucherSaleLine.setAuthorizationToken(cawResponse
                            .getAuthorizationToken());
                    voucherSaleLine.setSerialNumber(CawVoucherValue
                            .getVOUCHER_CARD_NUMBER());
                    /*END BZ23543*/

                    if (cawRequest.getCommand() != null && cawRequest
                            .getCommand()
                            .equalsIgnoreCase(CawMiraCommand.CASH_OUT)) {
                        if (voucherSaleLine.getExtendedAmount()
                                .compareTo(BigDecimal.ZERO) < 0) {
                            voucherSaleLine.setExtendedAmount(cawResponse
                                    .getBalance().negate());
                        } else {
                            voucherSaleLine.setExtendedAmount(cawResponse
                                    .getBalance());
                        }
                    }
                }

                if (authLineItem instanceof IVoucherTenderLineItem) {
                    //following functional specification.
                    IVoucherTenderLineItem voucherTenderLine = (IVoucherTenderLineItem) authLineItem;
                    voucherTenderLine
                            .setBankReferenceNumber(cawResponse.getToken());
                    voucherTenderLine
                            .setTraceNumber(cawResponse.getTraceNumber());

                    /*BEGIN BZ23543*/
                    voucherTenderLine.setUnspentBalanceAmount(NumberUtils
                            .createBigDecimal(String
                                    .valueOf(cawResponse.getBalance())));
                    voucherTenderLine.setAuthorizationToken(cawResponse
                            .getAuthorizationToken());
                    voucherTenderLine.setSerialNumber(cawResponse
                            .getMaskAccountNumber());
                    /*END BZ23543*/
                }

                //More information in verifone response needed to save database
                if (CawEntryMethodCode.SWIPE
                        .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                    authLineItem
                            .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_SWIPED);
                } else if (CawEntryMethodCode.KEYED
                        .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                    authLineItem
                            .setEntryMethodCode(CawEigenConstants.VERIFONE_ENTRY_METHOD_KEYED);
                } else {
                    authLineItem.setEntryMethodCode(null);
                    logger_.info("Not handle entry method code");
                }

                if (cawResponse.getAuthorizationCode() != null) {
                    authLineItem.setAuthorizationCode(StringUtils
                            .nonEmpty(cawResponse.getAuthorizationCode()));
                }
            }
            //Begin BZ25958
        } else {

            try {
                if (cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_AUX_RESPONSE_CODE)
                        .equalsIgnoreCase(CawEigenConstants.GIFT_CARD_NOT_ACTIVE_CODE)) {//BZ27757
                    _transactionScope
                            .setValue(CawValueKeys.IS_NOT_ACTIVE, true);
                    CawVoucherValue.setGiftCardToken(CawConstants.CAW_STRING_EMPTY);//BZ32123: Clear token is cached
                }
            } catch (MiraServJavaException ex) {
                logger_.error("Exception when get display message"
                        + ex.getMessage());
            }
            //End BZ25958
        }

        return cawResponse;

    }

    /**
     * Handle credit response from VeriFone device
     * @param argCawResponse
     * @param argCawRequest
     * @return
     */
    private CawMiraResponse handleCreditResponse(CawMiraResponse cawResponse,
            CawMiraRequest cawRequest) {
        /*Begin BZ28562, BZ28561, BZ29383*/
        CawPinpadItemModelHelper.handleRefreshPinPadScreen(true);
        /*End BZ28562, BZ28561, BZ29383*/
        /*Begin BZ-23383*/
        ITenderLineItem tenderLineItem = _defaultScope
                .getValue(ValueKeys.CURRENT_TENDER_LINE);
        logger_.info("get tenderIdName");
        /*Begin BZ30314*/
        if(tenderLineItem == null)
        {
            tenderLineItem = _cawEigenMgr.getTenderLineExchange();
        }
        /*End BZ30314*/
        String tenderIdName = CawMiraUtil
                .convertTenderSubType(cawResponse.getCardTypeCode(), tenderLineItem); /*BZ29505: add parameter*/
        logger_.info("check condition and set TenderID");

        if (tenderLineItem == null
                && cawRequest.getLineItem() instanceof ITenderLineItem) {
            tenderLineItem = (ITenderLineItem) cawRequest.getLineItem();
        }
        if (!CawCardType.OTHER.equalsIgnoreCase(tenderIdName)) {
            _tenderHelper.setTenderIdType(tenderLineItem, tenderIdName);
        } else {
            logger_.info("Cannot find tenderId Name ");
        }
        logger_.info("set a response is successful or not");
        if (cawResponse.isSuccess()) {
            cawResponse.setSuccess(true);
            BigDecimal amt = null;
            if (!StringUtils.isEmpty(cawResponse.getApprovedAmount())) {
                // Begin BZ23530_BZ23527
                amt = NumberUtils
                        .createBigDecimal((cawResponse.getApprovedAmount()))
                        .divide(hundred, 2, BigDecimal.ROUND_HALF_UP);
                cawResponse.setAmount(amt);
                // End BZ23530_BZ23527
            }
            if (tenderLineItem != null) {
                tenderLineItem.setAmount(cawResponse.getAmount());
            }
        }
        logger_.info("set tenderLineItem");
        if (tenderLineItem instanceof IAuthorizableTenderLineItem) {
            IAuthorizableTenderLineItem argLineItem = (IAuthorizableTenderLineItem) tenderLineItem;

            argLineItem.setAdjudicationCode(cawResponse.getResponseCode());
            copyBankReferenceNumber(argLineItem, cawResponse);

            argLineItem
                    .setAuthorizationToken(cawResponse.getAuthorizationToken());

            if (CawEntryMethodCode.CHIP
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_CHIP);
            } else if (CawEntryMethodCode.SWIPE
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_SWIPED);
            } else if (CawEntryMethodCode.MANUAL
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_KEYED);
            } else if (CawEntryMethodCode.FALLBACK
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_FBACK);
            } else {
                argLineItem.setEntryMethodCode(null);
                logger_.info("Not handle entry method code");
            }

            if (cawResponse.getAuthorizationCode() != null) {
                argLineItem.setAuthorizationCode(StringUtils
                        .nonEmpty(cawResponse.getAuthorizationCode()));
            }
        }

        if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
            updateCreditDebitTenderLineItem(cawResponse, tenderLineItem);

            // Card holder name
            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setCustomerName(cawResponse.getCardHolderName()); // BZ 24232
            setCardHolderName(cawResponse, tenderLineItem); /*BZ29504*/

            // set ShortToken data into TransactionReferenceData column
            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setTransactionReferenceData(encryptField(CCENC, cawResponse
                            .getShortToken()));

            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setExpirationDateString(cawResponse.getExpiryDate());
        }

        return cawResponse;
        /*End BZ-23383*/
    }

    public void updateCreditDebitTenderLineItem(CawMiraResponse cawResponse,
            ITenderLineItem tenderLineItem) {

        //following functional specification
        ICreditDebitTenderLineItem creditDebitLine = (ICreditDebitTenderLineItem) tenderLineItem;

        /* START BZ 24854 */
        if (cawResponse.getAuthorizationToken() != null) {
            creditDebitLine
                    .setAuthorizationToken(cawResponse.getAuthorizationToken());
        } else {
            creditDebitLine.setAuthorizationToken(cawResponse.getShortToken());
        }
        /* END BZ 24854 */

        creditDebitLine.setAccountNumber(cawResponse.getAccountNumber());
        creditDebitLine.setMaskAccountNumberDao(maskField(cawResponse
                .getAccountNumber()));
        ((ICreditDebitTenderLineItem) tenderLineItem)
                .setExpirationDateString(cawResponse.getExpiryDate());

        creditDebitLine.setCustomerName(cawResponse.getCardHolderName()); // BZ 24232
        setCardHolderName(cawResponse, tenderLineItem); /*BZ29504*/

        creditDebitLine
                .setTransactionReferenceData(encryptField(CCENC, cawResponse
                        .getShortToken()));

        creditDebitLine.setBankReferenceNumber(cawResponse.getToken()); // BZ23603

        //More information in verifone response needed to save database
        if (CawEntryMethodCode.CHIP
                .equalsIgnoreCase(cawResponse.getEntryMethod())) {
            creditDebitLine
                    .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_CHIP);
        } else if (CawEntryMethodCode.SWIPE
                .equalsIgnoreCase(cawResponse.getEntryMethod())) {
            creditDebitLine
                    .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_SWIPED);
        } else if (CawEntryMethodCode.MANUAL
                .equalsIgnoreCase(cawResponse.getEntryMethod())) {
            creditDebitLine
                    .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_KEYED);
        } else if (CawEntryMethodCode.FALLBACK // BZ23640
                .equalsIgnoreCase(cawResponse.getEntryMethod())) {
            creditDebitLine
                    .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_FBACK);
        } else {
            creditDebitLine.setEntryMethodCode(null);
            logger_.info("Not handle entry method code");
        }
        // Begin BZ23603
        Map<ICreditDebitTenderLineItem, ICreditDebitTenderLineItem> refMap = _transactionScope
                .getValue(TransactionScopeKeys.ORIGINAL_CREDITCARD_MAPPING);
        if (refMap != null && refMap.size() > 0) {
            ICreditDebitTenderLineItem lineItem = refMap.get(tenderLineItem);
            if (lineItem != null && lineItem.getEntryMethodCode() != null) {
                creditDebitLine
                        .setEntryMethodCode(lineItem.getEntryMethodCode());
                creditDebitLine.setMaskAccountNumberDao(lineItem
                        .getMaskAccountNumberDao());
            }
        }
        // End BZ23603
        if (cawResponse.getAuthorizationCode() != null) {
            creditDebitLine
                    .setAuthorizationCode(cawResponse.getAuthorizationCode());
        }

        // Begin BZ23558
        Map<Integer, String> mapVerification = _transactionScope
                .getValue(CawValueKeys.VERIFICATION);
        if (mapVerification == null) {
            mapVerification = new HashMap<Integer, String>();
        }
        try {
            if (CawEigenConstants.FN_SIGNATURE_B
                    .equals(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))
                    || CawEigenConstants.FN_SIGNATURE_P.equals(cawResponse
                            .getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
                mapVerification.put(creditDebitLine
                        .getRetailTransactionLineItemSequence(), VERIFIED_BY_PIN);
            } else if (CawEigenConstants.FN_SIGNATURE_Y
                    .equals(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))
                    || CawEigenConstants.FN_SIGNATURE_C.equals(cawResponse
                            .getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
                mapVerification.put(creditDebitLine
                        .getRetailTransactionLineItemSequence(), VERIFIED_BY_SIGNATURE);
            } else {
                mapVerification.put(creditDebitLine
                        .getRetailTransactionLineItemSequence(), NONE);
            }
            _transactionScope
                    .setValue(CawValueKeys.VERIFICATION, mapVerification);
        } catch (Exception ex) {
            logger_.error("Cannot get verification: " + ex.getMessage());
        }
        // Handle EMV Data
        handleEMVInfo(creditDebitLine, cawResponse);
        // handle persist defer financial into TRL_RTRANS_LINEITM_P table
        addLineItemProperty(cawResponse, tenderLineItem);/*BZ33319*/
        // End BZ23558
        // Handle declined
        try {
            /*if (DECLINED.equals(creditDebitLine.getAdjudicationCode())
                    || CawEigenConstants.FN_DECLINED_VALUE.equals(cawResponse
                            .getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                handleEmvDeclined(creditDebitLine);
            }*/
            handleEmvDeclined(creditDebitLine, cawResponse); // BZ23800
        } catch (Exception ex) {
            logger_.error("Cannot handle EMV Declined: " + ex.getMessage());
        }

        try {
            convertSignatureData(cawResponse, tenderLineItem); // BZ23432
        } catch (Exception ex) {
            logger_.error("Cannot convert signature data: " + ex.getMessage());
        }

    }

    /**
     * @param argCreditDebitLine
     */
    private void handleEmvDeclined(
            ICreditDebitTenderLineItem argCreditDebitLine,
            CawMiraResponse miraResponse) {

        long orgID = ConfigurationMgr.getOrganizationId();
        int rtlLocId = _stationState.getRetailLocationId();
        int wkstnId = _stationState.getWorkstationId();
        Date busDate = _stationState.getCurrentBusinessDate();
        int lineItmSeq = argCreditDebitLine
                .getRetailTransactionLineItemSequence();
        CawDeclinedReferenceData declineBean = new CawDeclinedReferenceData(
                orgID, rtlLocId, wkstnId, busDate, lineItmSeq,
                _transactionScope.getTransaction());
        declineBean.setTenderDescription(((ITenderLineItem) argCreditDebitLine)
                .getTender().getDescription());
        declineBean.setNumberCard(argCreditDebitLine.getMaskAccountNumberDao());
        declineBean.setEntryMethod(argCreditDebitLine.getEntryMethodCode());
        declineBean.setAuthAmout(argCreditDebitLine.getAmount());
        declineBean
                .setEmvTag(getDeclineEMVTag(miraResponse.getReceiptResponse())); // BZ23800
        _transactionScope.setValue(CawValueKeys.DECLINED_DATA, declineBean);

    }

    // Begin BZ23800
    /**
     * 
     * @param emvTagMira
     * @return
     */
    public String getDeclineEMVTag(String emvTagMira) {

        if (emvTagMira != null) {
            StringBuilder result = new StringBuilder();
            String[] emvTAG = emvTagMira.split(TAG);
            if (emvTAG.length > 1) {
                for (int i = 1; i < emvTAG.length - 1; i++) {
                    result.append(TAG).append(emvTAG[i]);
                }
                String[] emvTAC = emvTAG[23].split(TAC);
                result.append(TAG).append(emvTAC[0]);

                for (int i = 1; i < emvTAC.length - 1; i++) {
                    result.append(TAC).append(emvTAC[i]);
                }
                String[] temp = emvTAC[emvTAC.length - 1].split("\n");
                result.append(TAC).append(temp[0]);

                return result.toString();
            }
        }
        return null;
    }

    // End BZ23800

    /**
     * Handle authorization response from VeriFone device
     * 
     * @param cawResponse
     * @param cawRequest
     */
    private CawMiraResponse handleAuthorizeResponse(CawMiraResponse cawResponse,
            CawMiraRequest cawRequest) {
        /* Begin BZ28562, BZ28561, BZ29383*/
        CawPinpadItemModelHelper.handleRefreshPinPadScreen(true);
        /* End BZ28562, BZ28561, BZ29383 */
        //Store information of response in database
        ITenderLineItem tenderLineItem = _defaultScope
                .getValue(ValueKeys.CURRENT_TENDER_LINE);
        /*Begin BZ31568*/
        if(tenderLineItem == null)
        {
            tenderLineItem = _cawEigenMgr.getTenderLineExchange();
        }
        /*End BZ31568*/
        logger_.info("get tenderIdName");
        String tenderIdName = CawMiraUtil
                .convertTenderSubType(cawResponse.getCardTypeCode(), tenderLineItem); /*BZ29505: add parameter*/
        logger_.info("check condition and set TenderID");
        if (!CawCardType.OTHER.equalsIgnoreCase(tenderIdName)) {
            _tenderHelper.setTenderIdType(tenderLineItem, tenderIdName);
        } else {
            logger_.info("Cannot find tenderId Name ");
        }
        logger_.info("set a response is successful or not");
        if (cawResponse.isSuccess()) {
            cawResponse.setSuccess(true);

            if (!StringUtils.isEmpty(cawResponse.getApprovedAmount())) {
                /* BEGIN BZ29321 */
                BigDecimal approvedAmount = NumberUtils.createBigDecimal((cawResponse.getApprovedAmount()))
                        .divide(hundred, 2, BigDecimal.ROUND_HALF_UP);
                if (BigDecimal.ZERO.compareTo(approvedAmount) == 0) {
                    approvedAmount = cawResponse.getAmount();
                }
                // Begin BZ23530_BZ23527
                cawResponse.setAmount(approvedAmount);
                tenderLineItem.setAmount(approvedAmount);
                // End BZ23530_BZ23527
                /* END BZ29321 */
            } else {
                tenderLineItem.setAmount(cawResponse.getAmount());
            }
        }
        logger_.info("set tenderLineItem");
        if (tenderLineItem instanceof IAuthorizableTenderLineItem) {
            IAuthorizableTenderLineItem argLineItem = (IAuthorizableTenderLineItem) tenderLineItem;

            argLineItem.setAdjudicationCode(cawResponse.getResponseCode());
            copyBankReferenceNumber(argLineItem, cawResponse);

            argLineItem
                    .setAuthorizationToken(cawResponse.getAuthorizationToken());

            //More information in verifone response needed to save database

            if (CawEntryMethodCode.CHIP
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_CHIP);
            } else if (CawEntryMethodCode.SWIPE
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_SWIPED);
            } else if (CawEntryMethodCode.MANUAL
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                argLineItem
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_KEYED);
            } else {
                argLineItem.setEntryMethodCode(null);
                logger_.info("Not handle entry method code");
            }

            if (cawResponse.getAuthorizationCode() != null) {
                argLineItem.setAuthorizationCode(StringUtils
                        .nonEmpty(cawResponse.getAuthorizationCode()));
            }
        }

        if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
            updateCreditDebitTenderLineItem(cawResponse, tenderLineItem);

            // Card holder name
            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setCustomerName(cawResponse.getCardHolderName()); // BZ 24232
            setCardHolderName(cawResponse, tenderLineItem); /*BZ29504*/

            // set ShortToken data into TransactionReferenceData column
            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setTransactionReferenceData(encryptField(CCENC, cawResponse
                            .getShortToken()));

            ((ICreditDebitTenderLineItem) tenderLineItem)
                    .setExpirationDateString(cawResponse.getExpiryDate());

            /*BEGIN BZ29360/BZ29536/BZ29505*/
            ICreditDebitTenderLineItem creditDebitlineItem = (ICreditDebitTenderLineItem) tenderLineItem;
            if (_gsHelper.isApplyGS() && _gsHelper.isTokenUsed()
                    && _gsHelper.getAccountShortToken().equals(cawResponse.getShortToken())) {
                /*BEGIN BZ35962*/
                creditDebitlineItem.setAuthorizationToken(_gsHelper.getAccountShortToken());
                creditDebitlineItem.setBankReferenceNumber(_gsHelper.getAccountLongToken());/*BZ29406, BZ29504*/
                /*END BZ35962*/
                if (_gsHelper.getCardType() == 1) {
                    creditDebitlineItem.setExpirationDateString(_gsHelper.getExpiryDay());
                }
            }
            /*END BZ29360/BZ29536/BZ29505*/
        }
        return cawResponse;
    }

    // Begin BZ23558
    /**
     * 
     * @param creditDebitLine
     * @param cawResponse
     */
    private void handleEMVInfo(ICreditDebitTenderLineItem creditDebitLine,
            CawMiraResponse cawResponse) {

        Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope
                .getValue(CawValueKeys.EMV_DATA);
        if (mapEMVInfo == null) {
            mapEMVInfo = new HashMap<Integer, CawEmvPaymentCardInfo>();
        }
        try {
            CawEmvPaymentCardInfo emvInfo = new CawEmvPaymentCardInfo();
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_CHIP_APPLICATION_ID) != null) {
                emvInfo.setAidTag(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_CHIP_APPLICATION_ID));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_CHIP_APPLICATION_NAME) != null) {
                emvInfo.setAppNameTag(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_CHIP_APPLICATION_NAME));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_EMV_TVR) != null) {
                emvInfo.setTvrTag(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_EMV_TVR));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_EMV_TSI) != null) {
                emvInfo.setTsiTag(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_EMV_TSI));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_APPROVAL_CD) != null) {
                emvInfo.setAcTag(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_APPROVAL_CD));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_RECEIPT_REF_NUM) != null) {
                emvInfo.setSeqNumber(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_RECEIPT_REF_NUM));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_RESPONSE_CODE) != null) {
                emvInfo.setHostResCode(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_RESPONSE_CODE));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE) != null) {
                emvInfo.setIsoResCode(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_CURRENCY_RESPONSE_CODE) != null) {
                if (CawEigenConstants.CAD_CURRENCY_CODE.equals(cawResponse
                        .getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_CURRENCY_RESPONSE_CODE))) {
                    emvInfo.setCurrency(CawEigenConstants.CAD_CURRENCY_DESC);
                } else {
                    emvInfo.setCurrency(CawEigenConstants.USA_CURRENCY_DESC);
                }
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_RECEIPT_REF_NUM) != null) {
                emvInfo.setTraceNumber(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_RECEIPT_REF_NUM));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_DEVICE_ID) != null) {
                emvInfo.setDeviceId(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_DEVICE_ID));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_MERCH_ID) != null) {
                emvInfo.setMerchId(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_MERCH_ID));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_TERMINAL_NUMBER) != null) {
                emvInfo.setTerminalNumber(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_TERMINAL_NUMBER));
            }
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FN_DISPLAY_MSG) != null) {
                emvInfo.setDeclineReason(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_DISPLAY_MSG));
            } else {
                emvInfo.setDeclineReason(StringUtils.EMPTY);
            }

            /* BEGIN BZ28744 */
            /* Set value for Verification*/
            emvInfo.setVerification(NONE);
            if (CawEigenConstants.FN_SIGNATURE_B
                    .equals(cawResponse.getMiraServResponse().GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))
                    || CawEigenConstants.FN_SIGNATURE_P.equals(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
                emvInfo.setVerification(VERIFIED_BY_PIN);
            } else if (CawEigenConstants.FN_SIGNATURE_Y
                    .equals(cawResponse.getMiraServResponse().GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))
                    || CawEigenConstants.FN_SIGNATURE_C.equals(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
                emvInfo.setVerification(VERIFIED_BY_SIGNATURE);
            }
            /* END BZ28744 */
            /*BEGIN BZ33319*/
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FIELF_T8) != null) {
                String deferFinancial = cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FIELF_T8);
                String deferFinancialGSVS = _ff.getTranslatable("_deferFinancialADSResponseGSVS").toString();
                String deferFinancialSymbolGSVS = _ff.getTranslatable("_deferFinancialSymbolGSVS").toString();
                deferFinancial = deferFinancial.replaceAll(deferFinancialGSVS,deferFinancialSymbolGSVS);
                emvInfo.setDeferFinancial(deferFinancial);
            }
            /*END BZ33319*/
            mapEMVInfo.put(creditDebitLine.getRetailTransactionLineItemSequence(), emvInfo);
        } catch (Exception ex) {
            logger_.error("Cannot get EMV data from Eigen: " + ex.getMessage());
        }
        _transactionScope.setValue(CawValueKeys.EMV_DATA, mapEMVInfo);
        CawVoucherValue.setEmvInfo(mapEMVInfo); // BZ23559
    }
    // End BZ23558

    // Begin BZ23432
    /**
     * 
     * @param cawResponse
     * @param tenderLineItem
     * @throws MiraServJavaException
     * @throws Exception
     */
    private void convertSignatureData(CawMiraResponse cawResponse,
            ITenderLineItem tenderLineItem)
            throws MiraServJavaException, Exception {

        Point[] points = null;
        if ((cawResponse.isSuccess())
                && (cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_SIGNATURE_DATA) != null)
                && CawEigenConstants.FN_SIGNATURE_C.equals(cawResponse
                        .getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
            try {
                points = convertSig2Point(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_SIGNATURE_DATA));
                ISignature argSignature = new Signature(true,
                        HardwareType
                                .forUse(HardwareFamilyType.SIG_CAP, VERIFONE),
                        points, true, false);

                ITenderSignature tenderSignature = this._tenderHelper
                        .createTenderSignature(tenderLineItem, argSignature);
                if (tenderSignature != null) {
                    tenderLineItem.setSignature(tenderSignature);
                    tenderLineItem.setSignatureCaptureSkipped(false);
                }
            } catch (Exception ex) {
                logger_.error(ex.getMessage());
            }
        } else if (CawEigenConstants.FN_SIGNATURE_Y
                .equals(cawResponse.getMiraServResponse()
                        .GetTField(CawEigenConstants.FN_SIGNATURE_REQUIRED))) {
            tenderLineItem.setSignatureCaptureSkipped(true);
        } else {
            tenderLineItem.setSignatureCaptureSkipped(false);

        }
    }

    /**
     * 
     * @param veriFoneData
     * @return
     * @throws Exception
     */
    public Point[] convertSig2Point(String veriFoneData) // BZ29476
            throws Exception {

        ArrayList<Point> points = new ArrayList<Point>();

        byte[] bytes = Base64.getDecoder().decode(veriFoneData);
        ShortBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
                .asShortBuffer();
        int npoints = bytes.length / 4;
        short x, y;
        Point point;
        for (int i = 0; i < npoints; ++i) {
            x = buf.get();
            y = buf.get();
            point = new Point(x, y);
            points.add(point);
        }

        Point[] pArray = new Point[points.size()];
        points.toArray(pArray);
        return pArray;
    }

    // End BZ23432
    /**
     * @param accountNumber
     * @return
     */
    protected String maskField(String accountNumber) {

        if ((accountNumber == null) || (accountNumber.isEmpty())
                || (accountNumber.length() < 4)) {
            return null;
        }
        return mask(accountNumber.substring(0, accountNumber.length() - 4))
                .concat(accountNumber.substring(accountNumber.length() - 4));
    }

    /**
     * @param accountNumber
     * @return
     */
    protected String maskFieldCreditDebit(String accountNumber) {

        if ((accountNumber == null) || (accountNumber.isEmpty())) {
            return null;
        }
        return accountNumber.substring(0, 6)
                .concat(mask(accountNumber
                        .substring(6, accountNumber.length() - 4)))
                .concat(accountNumber.substring(accountNumber.length() - 4));
    }

    /**
     * @param o
     * @return
     */
    protected String mask(Object o) {

        String result;
        if ((o instanceof IFormattable)) {
            result = ((IFormattable) o)
                    .toString(dtv.i18n.OutputContextType.LOG);
        } else {
            if (o == null) {
                return NULL_VALUE;
            }

            result = String.valueOf(o);
        }
        return StringUtils.fill("*", result.length());
    }

    /**
     * @param argLineItem
     * @param response
     */
    protected void copyBankReferenceNumber(IAuthorizableLineItem argLineItem,
            CawMiraResponse response) {

        String responseBankReferenceNumber = response.getToken();
        String lineBankReferenceNumber = argLineItem.getBankReferenceNumber();

        if (!StringUtils.isEmpty(responseBankReferenceNumber)) {
            if ((!StringUtils.isEmpty(lineBankReferenceNumber))
                    && (!responseBankReferenceNumber
                            .equals(lineBankReferenceNumber))) {
                logger_.warn("overriding bank reference number from '"
                        + lineBankReferenceNumber + "' to '"
                        + responseBankReferenceNumber + "'");
            }
            argLineItem.setBankReferenceNumber(responseBankReferenceNumber);
        }
    }

    /*Begin BZ23585*/
    /**
     * Handle authorization response from VeriFone device
     * 
     * @param cawResponse
     * @param cawRequest
     */
    private CawMiraResponse handleAuthorizeByPhoneResponse(
            CawMiraResponse cawResponse, CawMiraRequest cawRequest) {

        //Store information of response in database
        ITenderLineItem tenderLineItem = _defaultScope
                .getValue(ValueKeys.CURRENT_TENDER_LINE);
        /*Begin BZ31568*/
        if(tenderLineItem == null)
        {
            tenderLineItem = _cawEigenMgr.getTenderLineExchange();
        }
        /*End BZ31568*/
        logger_.info("set tenderLineItem");
        if (tenderLineItem instanceof IAuthorizableTenderLineItem
                && cawResponse.isSuccess()) {
            IAuthorizableTenderLineItem argLineItem = (IAuthorizableTenderLineItem) tenderLineItem;
            copyBankReferenceNumber(argLineItem, cawResponse);
            argLineItem
                    .setAuthorizationToken(cawResponse.getAuthorizationToken());
        }
        if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
            //following functional specification
            ICreditDebitTenderLineItem creditDebitLine = (ICreditDebitTenderLineItem) tenderLineItem;
            creditDebitLine.setCustomerName(cawResponse.getCardHolderName()); // BZ 24232
            setCardHolderName(cawResponse, tenderLineItem); /*BZ29504*/
            creditDebitLine.setAccountNumber(cawResponse.getAccountNumber());

            // set ShortToken data into TransactionReferenceData column
            creditDebitLine
                    .setTransactionReferenceData(encryptField(CCENC, cawResponse
                            .getShortToken()));

            creditDebitLine
                    .setExpirationDateString(cawResponse.getExpiryDate());

            //More information in verifone response needed to save database
            if (CawEntryMethodCode.CHIP
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                creditDebitLine
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_CHIP);
            } else if (CawEntryMethodCode.SWIPE
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                creditDebitLine
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_SWIPED);
            } else if (CawEntryMethodCode.MANUAL
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                creditDebitLine
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_KEYED);
            } else if (CawEntryMethodCode.FALLBACK
                    .equalsIgnoreCase(cawResponse.getEntryMethod())) {
                creditDebitLine
                        .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_FBACK);//BZ23640
            } else {
                creditDebitLine.setEntryMethodCode(null);
                logger_.info("Not handle entry method code");
            }

            if (cawResponse.getAuthorizationCode() != null) {
                creditDebitLine.setAuthorizationCode(cawResponse
                        .getAuthorizationCode());
            }
            // handle EMV data
            handleEMVInfo(creditDebitLine, cawResponse);
            try {
                convertSignatureData(cawResponse, tenderLineItem); // BZ23432
            } catch (Exception ex) {
                logger_.error("Cannot convert signature data: "
                        + ex.getMessage());
            }
        }

        return cawResponse;
    }
    /*End BZ23585*/

    private String encryptField(String argEncryptionService, String value) {

        if (value == null) {
            return null;
        }
        return DtvEncrypter.getInstance(argEncryptionService).encrypt(value);
    }
    
    /*BEGIN BZ29504*/
    /**
     * Set card holder name into credit/debit tender line in case using GS token from Credit Application & Account Lookup
     * @param cawResponse
     * @param tenderLineItem
     */
    private void setCardHolderName(CawMiraResponse cawResponse, ITenderLineItem tenderLineItem) {

        if (StringUtils.isEmpty(cawResponse.getCardHolderName())
                && tenderLineItem instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem tenderCreditDebitLine = (ICreditDebitTenderLineItem) tenderLineItem;

            if (_gsHelper.getAccountShortToken().equals(cawResponse.getShortToken())) {/*BZ29536: change to Long Token*/
                StringBuilder cardHolderName = new StringBuilder();
                cardHolderName.append(_gsHelper.getFirstNameADS()).append(CawConstants.VERTICAL_BAR_SIGN)
                        .append(_gsHelper.getLastNameADS());
                tenderCreditDebitLine.setCustomerName(cardHolderName.toString());
            }
        }
    }
    /*END BZ29504*/
    /*BEGIN BZ37305*/
    private CawMiraResponse handleDisplayCustomerRespone(CawMiraResponse cawResponse) {
        try {
            if (CawEigenConstants.EIGEN_APPROVE.equals(cawResponse.getMiraServResponse().GetTField(CawEigenConstants.FN_ACTION_CODE))
                    && CawEigenConstants.KEY_F6.equals(cawResponse.getMiraServResponse().GetTField(CawEigenConstants.FN_KEY_PRESS))) {
                cawResponse.setData(CawConstants.CAW_VERIFY_CUSTOMER_NO);
            } else {
                cawResponse.setSuccess(true);
                cawResponse.setData(CawConstants.CAW_VERIFY_CUSTOMER_YES);
            }
        } catch (MiraServJavaException ex) {
            logger_.error("Exception when get line item "
                    + ex.getMessage());
        }
        return cawResponse;
        
    }
    /*END BZ37305*/
    /*BEGIN BZ33319*/
    /**
     * 
     * @param propertyCode
     * @param strValue
     */
    private IRetailTransactionLineItemProperty createLineItemProperty(
            String propertyCode, String strValue) {

        IRetailTransactionLineItemProperty property = null;
        try {
            RetailTransactionLineItemPropertyId id = new RetailTransactionLineItemPropertyId();
            id.setPropertyCode(propertyCode);
            property = DataFactory
                    .createObject(id, IRetailTransactionLineItemProperty.class);
            property.setStringValue(strValue);
            property.setType(CawUFAConstants.PROPERTY_TYPE);
        } catch (Exception ex) {
            logger_.error("can't create LineItemProperty", ex);
        }
        return property;
    }
    private void addLineItemProperty(CawMiraResponse cawResponse, ITenderLineItem tenderLineItem) {
        try {
            if (cawResponse.getMiraServResponse()
                    .GetTField(CawEigenConstants.FIELF_T8) != null
                    && !StringUtils.isEmpty(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FIELF_T8))) {
                IRetailTransactionLineItemProperty property = createLineItemProperty(IS_DEFER_FINANCIAL, TRUE_VALUE);
                tenderLineItem.addRetailTransactionLineItemProperty(property);
                property = createLineItemProperty(DEFER_FINANCIAL_MSG, cawResponse
                        .getMiraServResponse()
                        .GetTField(CawEigenConstants.FIELF_T8));
                tenderLineItem.addRetailTransactionLineItemProperty(property);
            }
            /*BEGIN BZ41674*/
            if (cawResponse.getMiraServResponse().GetTField(CawEigenConstants.FN_VOUCH_SER_NUM) != null
                    && !StringUtils.isEmpty(cawResponse.getMiraServResponse()
                            .GetTField(CawEigenConstants.FN_VOUCH_SER_NUM))) {
                IRetailTransactionLineItemProperty property = createLineItemProperty(PROMOTE_FINANCIAL, cawResponse
                        .getMiraServResponse().GetTField(CawEigenConstants.FN_VOUCH_SER_NUM));
                tenderLineItem.addRetailTransactionLineItemProperty(property);
            }
            /*END BZ41674*/
        } catch (Exception ex) {
            logger_.error("Cannot persist TRL_RTRANS_LINEITM_P table: "
                    + ex.getMessage());
        }
    }
    /*END BZ33319*/

}