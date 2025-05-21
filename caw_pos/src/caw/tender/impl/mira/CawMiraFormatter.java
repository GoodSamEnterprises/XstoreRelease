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
 * BZ23232              190917    Define Xstore Timeout
 * BZ23339              210917    [DEV] Implement Gift card authorization
 * BZ23339              260917    [DEV] Implement Gift card authorization
 * BZ23359              270917    Gift cards can't be swiped at screen
 * BZ23164              260917    [DEV] Implement EMV Payment Integration
 * BZ23585              270917    Xstore stuck in a loop when authorization service is offline
 * BZ23576              021017    Manual enter credit card number
 * BZ23603              041017    Allow refund to original Credit and Debit card for Receipt Return transactions
 * BZ23725              051017    [Payment] Missing shopping pass authorization information on the sale receipt
 * BZ23860              091017    SigCap turned on the light and required to swipe card when return transaction with GS Visa card
 * BZ23933              101017    Missing Credit card number/Authorization/Entry method and signature 
 *                                on receipt when competing transaction with tender new good Sam visa
 * BZ23937              111017    The SigCap is turned on and required to swipe card after Void line New Good Sam Visa card tender
 * BZ23892              161017    Missing Auth# in receipt when performing return no receipt a reload gift card transaction
 * BZ24287              311017    [Payments] Refund to original EMV credit card declined for INVALID CARD TYPE on Receipt Return transactions
 * BZ24582              221117    Need to specify the unique terminal Station ID in the MiraServ requests
 * BZ24854              151217    [PROD] Return to GSVS transaction failed in order service with error "Tender.authorization is required for Credit tenders."
 * BZ25602              110418    [PROD]New Requirement - Add "echo data" to all MiraServ payment transactions 
 * BZ25958              010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ27629              210918    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 * BZ27757              100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 * BZ27530              101118    [Prod] Customer "Double Charged" Issue
 * BZ27850              311218    SigCap required 'Swipe card' when selling Gift card on Sale Item screen
 * BZ28546              310119    Send item data to CC Auth Request for ADS Settlement
 * BZ29363              130219    [Internal] Tender with newly approved PLCC token declines for ITEM SIZE NOT MATCH
 * BZ29360              150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29406              180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29536              260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ29410              280219    [Internal] Xstore displaying Sale Tenders Options screen and not the Tender amount box.
 * BZ29505              010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29615              040319    [PLCC Pre_Cert] Xstore sending incorrect long token format in the return transaction
 * BZ29683              080319    [INTERNAL] [4.0.1] Review/Evaluate $20 GSVS on the current build
 * BZ29743              140319    [Internal] Modify Tender screen is prompted when there is no tenders to modify.
 * BZ29737              270319    [Internal] Customer asked to swipe/insert card during Offline Return.
 * BZ37305              260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad.  
 * BZ33319              260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ41704              050321    ADS Settlement - Unit pricing should be received in cents, but instead are received from the POS in dollars
 * BZ41674              050321    ADS Settlement - ORIG_INVOICE_NO on the return needs to match the INVOICE_NO of the purchase.
 * BZ47818              221221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 * BZ58779              110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 *===================================================================
 */

package caw.tender.impl.mira;

import static caw.tenderauth.impl.eigen.constants.CawEigenConstants.*;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyRoundingMode;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyScale;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.ejournal.CawTransactionSearchHelper;
import caw.tender.impl.mira.request.CawMiraRequest;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawCardType;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;

import dtv.i18n.FormattableFactory;
import dtv.pos.common.TransactionType;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.IAuthRequest;
import dtv.util.crypto.EncString;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;
import dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemModel;

@SuppressWarnings("deprecation")
public class CawMiraFormatter {

    /**
     * 
     */
    private static final String          MANUAL_INPUT   = "M";

    protected static final DecimalFormat moneyFormat_   = new DecimalFormat("0.00");

    protected static final DecimalFormat intFormat_     = new DecimalFormat("0");

    protected static final String        MESSAGE_TYPE   = "MessageType";

    protected static final String        MESSAGE_TYPE_Q = "Q";

    protected static final String        DOT            = ".";

    protected static final String        EMPTY_STR      = "";
    
    protected static final String        DASH_STR       = "-";/*BZ33319*/    

    /**
     * BZ27530 Added
     * The variable REVERSE_FLAG use mark that we will be sent Reverse to MiraServ.
     * In Case the MiraServ response an exception. Please do not use it in another case.
     */
    public static boolean                REVERSE_FLAG   = false;

    @Inject
    protected TransactionScope           _transactionScope;                                              // BZ23603
    @Inject
    protected static final String        XSTORE_TIMEOUT = System.getProperty("caw.eigen.timeout") != null
            ? System.getProperty("caw.eigen.timeout")
            : "";

    /**
     * Default logger
     */
    private static final Logger          logger         = Logger.getLogger(CawMiraFormatter.class);

    public static MiraServJava           miraRequest    = new MiraServJava();

    private CawMiraRequest               _miraRequest;

    @Inject
    private CawEigenHelper               _cawEigenHelper;                                                // BZ24582
    
    /*BEGIN  BZ37305*/
    @Inject
    protected FormattableFactory         _ff;

    @Inject
    private DefaultScope                 _defaultScope;

    @Inject
    private CustomerHelper               _customerHelper;
    /*END BZ37305*/
    
    private CawCustomerGSHelper          _gsHelper      = CawCustomerGSHelper.getInstance();             /*BZ29360*/

    /**
     * BZ23603
     */
    @SuppressWarnings("deprecation")
    public CawMiraFormatter() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    public Serializable formatConnectorMessage(IAuthRequest argRequest) {

        this._miraRequest = (CawMiraRequest) argRequest;
        // send message if there is one device
        if (logger.isDebugEnabled()) {
            logger.debug(this + " formatting message: " + _miraRequest);
            logger.debug("start formatting a command:" + _miraRequest.getCommand());
        }
        try {
            //BZ23585: In case the tender line item is already have 
            // the authorization code -> Build Authorization by phone request.
            if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.AUTHORIZATION_BY_PHONE)) {
                return setManualRequest(_miraRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.CAPTURE)) {
                return setCaptureTField(_miraRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.ACTIVATE)
                    && argRequest instanceof CawMiraGiftCardRequest) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toActiveGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.DEACTIVATE)
                    && argRequest instanceof CawMiraGiftCardRequest) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toDeactiveGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.BALANCE_INQUIRY)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toBalanceGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.REDEEM)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toRedeemGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.REDEEM_VOID)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toRedeemVoidGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.RELOAD)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toReloadGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.RELOAD_VOID)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;
                return toReloadVoidGiftCardXML(giftCardRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.CASH_OUT)) {
                CawMiraGiftCardRequest giftCardRequest = (CawMiraGiftCardRequest) argRequest;

                return toBalanceGiftCardXML(giftCardRequest);
            }
            /*Begin BZ-23383*/
            else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.REFUND)) {
                return setRefundTField(_miraRequest);
            }
            /*End BZ-23383*/
            /*Begin BZ23164*/
            else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.VOID_CAPTURE)) {
                return setVoidCaptureTField(_miraRequest);
            } else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.VOID_REFUND)) {
                return setVoidRefundTField(_miraRequest);
            }
            /*BEGIN BZ37305*/
            else if (_miraRequest.getCommand().equalsIgnoreCase(CawMiraCommand.DISPLAY_CUSTOMER_INFORMATION)) {
                return handleDisplayCustomerRequest(_miraRequest);
            }
            /*END BZ37305*/
            /*End BZ23164*/
        } catch (Exception e) {
            logger.debug("Cannot build verifone message " + e.getMessage());
        }

        return null;

    }

    /**
     * @param argGiftCardRequest
     * @return
     */
    private Serializable toBalanceGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest) throws MiraServJavaException {

        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.BALANCE_INQUIRY);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);

        EncString accId = argGiftCardRequest.getAccountId();
        if (accId != null) {
            miraRequest.SetTField(CawEigenConstants.FN_PAN, EncString.getSensitiveData(accId));
        }
        return (Serializable) miraRequest;
    }

    /**
     * Capture request for Mira device
     * 
     * @param request
     * @return
     * @throws MessageException
     */
    private Serializable setCaptureTField(CawMiraRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.CAPTURE);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        /*BEGIN BZ28546*/
        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        setStringItemData(1, trans);
        /*END BZ28546*/
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest
                    .SetTField(CawEigenConstants.FN_AMOUNT_1, request.getAmount().toString().replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        if (CawVoucherValue.getIS_MANUAL_INPUT_CREDIT()) {
            miraRequest.SetTField(CawEigenConstants.FN_ENTRY_METHOD, MANUAL_INPUT);
            CawVoucherValue.setIS_MANUAL_INPUT_CREDIT(false);
        }
        /*BEGIN BZ29743*/
        if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem creditDebitTender = (ICreditDebitTenderLineItem) tenderLineItem;
            if (CawCardType.GSVISA.equals(creditDebitTender.getTenderId())
                    || CawCardType.GSPLCC.equals(creditDebitTender.getTenderId())) {
                setGoodSamToken(); /*BZ29360: set GS token to request*/
            }
        }
        /*END BZ29743*/
        /*BEGIN BZ33319*/
        String transNumber = getTransNumber(trans);
        if(!EMPTY_STR.equals(transNumber)) {
            miraRequest.SetTField(FN_INVOICE_NUM, transNumber);
        }
        /*END BZ33319*/
        return (Serializable) miraRequest;
    }

    private Serializable toActiveGiftCardXML(CawMiraGiftCardRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        if (tenderLineItem == null) {
            tenderLineItem = request.getDefaultScope().getValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM);
        }
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.ACTIVATE);
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582

        if (tenderLineItem instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) tenderLineItem;
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, voucherSaleLineItem.getBaseUnitPrice().toString()
                    .replace(DOT, EMPTY_STR));
        } else if (tenderLineItem instanceof IVoucherTenderLineItem) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, request.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }

        miraRequest.SetTField(CawEigenConstants.FN_PAN, EncString.getSensitiveData(request.getAccountId()));

        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    /**
     * @param argGiftCardRequest
     * @return
     */
    private Serializable toDeactiveGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest) throws MiraServJavaException {

        IAuthorizableLineItem tenderLineItem = argGiftCardRequest.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.DEACTIVATE);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());
        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        if (tenderLineItem instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) tenderLineItem;
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, voucherSaleLineItem.getBaseUnitPrice().toString()
                    .replace(DOT, EMPTY_STR));
        } else if (tenderLineItem instanceof IVoucherTenderLineItem) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, argGiftCardRequest.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    /**
     * @param argGiftCardRequest
     * @return
     */
    private Serializable toRedeemGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest) throws MiraServJavaException {

        IAuthorizableLineItem tenderLineItem = argGiftCardRequest.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.REDEEM);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, argGiftCardRequest.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }

        if (tenderLineItem.getBankReferenceNumber() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        }

        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    /**
     * @param argGiftCardRequest
     * @return
     */
    private Serializable toRedeemVoidGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest)
            throws MiraServJavaException {

        IAuthorizableLineItem lineItem = argGiftCardRequest.getLineItem();

        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.REDEEM_VOID);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, lineItem.getAuthorizationCode());
        if (lineItem instanceof IVoucherTenderLineItem) {
            IVoucherTenderLineItem voucherTenderLineItem = (IVoucherTenderLineItem) lineItem;
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, voucherTenderLineItem.getBankReferenceNumber());
        } else if (lineItem instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) lineItem;
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, voucherSaleLineItem.getBankReferenceNumber());
        }

        if (lineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, lineItem.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, argGiftCardRequest.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    /**
     * @param argGiftCardRequest
     * @return
     */
    private Serializable toReloadGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest) throws MiraServJavaException {

        IAuthorizableLineItem tenderLineItem = argGiftCardRequest.getLineItem();

        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.RELOAD);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        if (tenderLineItem instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) tenderLineItem;
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, voucherSaleLineItem.getBaseUnitPrice().toString()
                    .replace(DOT, EMPTY_STR));
        } else if (tenderLineItem instanceof IVoucherTenderLineItem) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, argGiftCardRequest.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }
        //Begin BZ27629
        if (tenderLineItem.getBankReferenceNumber() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        } else if (CawVoucherValue.IS_TENDER_EXCHANGE_AUTHORIZE) {
            miraRequest.SetTField(CawEigenConstants.FN_PAN, tenderLineItem.getSerialNumber());
            CawVoucherValue.setIsTenderExchange(false);//BZ27850
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, CawVoucherValue.GIFT_CARD_TOKEN);
        }
        //End BZ27629
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;

    }

    /**
     * @param argGiftCardRequest
     * @return
     */

    private Serializable toReloadVoidGiftCardXML(CawMiraGiftCardRequest argGiftCardRequest)
            throws MiraServJavaException {

        IAuthorizableLineItem tenderLineItem = argGiftCardRequest.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.RELOAD_VOID);
        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        // Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(argGiftCardRequest));
        //End BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());
        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());

        if (tenderLineItem instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem = (IVoucherSaleLineItem) tenderLineItem;

            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, voucherSaleLineItem.getBaseUnitPrice().toString()
                    .replace(DOT, EMPTY_STR));

        } else if (tenderLineItem instanceof IVoucherTenderLineItem) {
            IVoucherTenderLineItem voucherTenderLineItem = (IVoucherTenderLineItem) tenderLineItem;

            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, voucherTenderLineItem.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    public MiraServJava getMiraData() {

        return miraRequest;
    }

    /*Begin BZ-23383*/
    private Serializable setRefundTField(CawMiraRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.REFUND);

        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        /*BEGIN BZ28546*/
        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        setStringItemData(2, trans);
        /*END BZ28546*/
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, request

                    .getAmount().abs().toString().replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        // Begin BZ23603 - BZ23860
        Map<ICreditDebitTenderLineItem, ICreditDebitTenderLineItem> refMap = _transactionScope
                .getValue(TransactionScopeKeys.ORIGINAL_CREDITCARD_MAPPING);
        if (refMap != null && refMap.size() > 0) {
            ICreditDebitTenderLineItem lineItem = refMap.get(tenderLineItem);
            if (lineItem != null && lineItem.getBankReferenceNumber() != null) {
                if (lineItem.getExpirationDateString() != null) {
                    /* BEGIN BZ29615 */
                    if (StringUtils.isNotEmpty(lineItem.getAuthorizationToken())) {
                        miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, lineItem.getAuthorizationToken());
                    /* BEGIN BZ29737 */
                    } else { 
                        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber());
                    }
                    /* END BZ29737 */
                    
                    // Back up for when implement BZ29615
                    /*if (lineItem.getBankReferenceNumber().length() > 20) {
                        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber()); // BZ 24287
                    } else {
                        miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, lineItem.getBankReferenceNumber()); // BZ 24287    
                    }*/
                    /* END BZ29615 */

                    miraRequest.SetTField(CawEigenConstants.FN_EXPIRY_DATE, lineItem.getExpirationDateString());
                } else {
                    miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber());
                }
            }
        }
        // End BZ23603 - BZ23860
        if (CawVoucherValue.getIS_MANUAL_INPUT_CREDIT()) {
            miraRequest.SetTField(CawEigenConstants.FN_ENTRY_METHOD, MANUAL_INPUT);
            CawVoucherValue.setIS_MANUAL_INPUT_CREDIT(false);
        }
        /*BEGIN BZ33319*/
        String transNumber = getTransNumber(trans);
        if(!EMPTY_STR.equals(transNumber)) {
            miraRequest.SetTField(FN_INVOICE_NUM, transNumber);
        }
        /*END BZ33319*/
        handleDeferFinancialTrans();/*BZ41674*/
        return (Serializable) request;
    }

    /*End BZ-23383*/
    /*Begin BZ23164*/
    private Serializable setManualRequest(CawMiraRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.AUTHORIZATION_BY_PHONE);

        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, request

                    .getAmount().toString().replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }
    /*End BZ23164*/

    /**
     * BZ 23232: Define Xstore timeout
     * @param time
     */
    private void setTimeOut(String time) {

        if (miraRequest != null && !time.isEmpty()) {
            miraRequest.SetTField(HOST_TIMEOUT, time);
            miraRequest.SetTField(SIGCAP_TIMEOUT, time);
            miraRequest.SetTField(SOCKET_CONNECT_TIMEOUT, time);
            miraRequest.SetTField(FN_PINPAD_DISP_TIMEOUT, time);
        }
    }

    private Serializable setVoidCaptureTField(CawMiraRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        boolean isGSToken = false; /*BZ29410*/
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.VOID_CAPTURE);

        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest
                    .SetTField(CawEigenConstants.FN_AMOUNT_1, request.getAmount().toString().replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());
        // Begin BZ23937
        if (tenderLineItem instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) tenderLineItem;
            if (lineItem.getBankReferenceNumber() != null) {
                if (lineItem.getExpirationDateString() != null) {

                    /* BEGIN BZ29615 */

                    /*if (lineItem.getBankReferenceNumber().length() > 20) {
                        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber()); // BZ 24287
                    } else {
                        miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, lineItem.getBankReferenceNumber()); // BZ 24287    
                    }*/
                    if (StringUtils.isNotEmpty(lineItem.getAuthorizationToken())) {
                        miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, lineItem.getAuthorizationToken());
                        /*BEGIN BZ29410/BZ29505/BZ29683: check if tender line really is GS token tender line*/
                        if (_gsHelper.getAccountShortToken().equals(lineItem.getAuthorizationToken())) {
                            isGSToken = true;
                        }
                        /*END BZ29410/BZ29505/BZ29683*/

                        /* BEGIN BZ29737 */
                    } else {
                        miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber());
                    }
                    /* END BZ29737 */

                    /* END BZ29615 */
                    miraRequest.SetTField(CawEigenConstants.FN_EXPIRY_DATE, lineItem.getExpirationDateString());
                } else {
                    miraRequest.SetTField(CawEigenConstants.FN_TOKEN, lineItem.getBankReferenceNumber());
                }
            }
        }
        // End BZ23937
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        /*BEGIN BZ29360, BZ29410: reset token used after voiding tender line used GS token*/
        if (_gsHelper.isApplyGS() && _gsHelper.isTokenUsed() && isGSToken) {
            _gsHelper.isTokenUsed(false);
        }
        /*END BZ29360, BZ29410*/
        return (Serializable) miraRequest;
    }

    private Serializable setVoidRefundTField(CawMiraRequest request) throws Exception {

        IAuthorizableLineItem tenderLineItem = request.getLineItem();
        miraRequest.Init();
        setTimeOut(XSTORE_TIMEOUT);
        miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawMiraCommand.VOID_REFUND);

        miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId()); // BZ24582
        //Begin BZ25602
        miraRequest.SetTField(CawEigenConstants.FN_ECHO_DATA, echoData(request));
        //End BZ25602
        if (tenderLineItem.getAmount() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, tenderLineItem.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_AMOUNT_1, request.getAmount().abs().toString()
                    .replace(DOT, EMPTY_STR));
        }
        miraRequest.SetTField(CawEigenConstants.FN_APPROVAL_CD, tenderLineItem.getAuthorizationCode());
        /* START BZ 24854, BZ29615 */
        if (StringUtils.isNotEmpty(tenderLineItem.getAuthorizationToken())
                && !tenderLineItem.getAuthorizationToken().equals("R")) { /* BZ29737 */
            miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, tenderLineItem.getAuthorizationToken());
            miraRequest.SetTField(CawEigenConstants.FN_EXPIRY_DATE, ((CreditDebitTenderLineItemModel) tenderLineItem)
                    .getExpirationDateString());
            /* BEGIN BZ29737*/
        } else {
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        }
        /* END BZ29737*/

        // Back up for when implement BZ29615
        /*if (tenderLineItem.getBankReferenceNumber() != null) {
            miraRequest.SetTField(CawEigenConstants.FN_TOKEN, tenderLineItem.getBankReferenceNumber());
        } else if (tenderLineItem instanceof CreditDebitTenderLineItemModel) {
             Void Return if tendered by New GSVS or Shopping Pass 
            miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, tenderLineItem.getAuthorizationToken());
            miraRequest.SetTField(CawEigenConstants.FN_EXPIRY_DATE, ((CreditDebitTenderLineItemModel) tenderLineItem)
                    .getExpirationDateString());
        }*/
        /* END BZ 24854, BZ29615 */
        miraRequest.SetTField(MESSAGE_TYPE, MESSAGE_TYPE_Q);
        return (Serializable) miraRequest;
    }

    //Begin BZ25602
    private String echoData(CawMiraRequest argCawMiraRequest) {

        try {
            String echoData = EMPTY_STR;
            IAuthorizableLineItem tenderLineItem = argCawMiraRequest.getLineItem();
            if (tenderLineItem != null) {
                echoData = String.format("%1$04d", tenderLineItem.getRetailLocationId())
                        + String.format("%1$04d", tenderLineItem.getWorkstationId())
                        + String.format("%1$06d", tenderLineItem.getTransactionSequence());
            }
            return echoData;
        } catch (Exception ex) {
            logger.error(" Can not build message: " + ex.getMessage());
        }
        return EMPTY_STR;
    }
    //End BZ25602

    /*BEGIN BZ28546, BZ29363: add unit price and quantity of items for request.*/
    /**
     * Handle setting by type of request/transType
     * 1: sale
     * 2: return
     * @param type
     */
    private void setStringItemData(int transType, IRetailTransaction trans) {

        Map<Integer, String> stringDataMap = getStringItemData(trans);
        /**
         * typeData = 1: Item Id
         * typeData = 2: Item Description
         * typeData = 3: Item Unit Price
         * typeData = 4: Item Quantity
         */
        if (transType == 1) {
            miraRequest.SetTField(CawEigenConstants.FN_ITEMCODE, stringDataMap.get(1));
            miraRequest.SetTField(CawEigenConstants.FN_ITEMDES, stringDataMap.get(2));
            miraRequest.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, stringDataMap.get(3));
            miraRequest.SetTField(CawEigenConstants.FN_ITEM_QTY, stringDataMap.get(4));
        } else if (transType == 2) {
            miraRequest.SetTField(CawEigenConstants.FN_ITEMCODE, stringDataMap.get(1));
            miraRequest.SetTField(CawEigenConstants.FN_ITEMDES, stringDataMap.get(2));
            miraRequest.SetTField(CawEigenConstants.FN_ITEM_UNIT_PRICE, stringDataMap.get(3));
            miraRequest.SetTField(CawEigenConstants.FN_ITEM_QTY, stringDataMap.get(4));
        }
    }

    /**
     * Build a string with format: |itemId1|itemId2|...|itemIdn|
     * typeData = 1: Item Id
     * typeData = 2: Item Description
     * @param trans
     * @param typeData
     * @return stringDataMap
     */
    private Map<Integer, String> getStringItemData(IRetailTransaction trans) {

        Map<Integer, String> stringDataMap = new HashMap<Integer, String>();
        StringJoiner stringItemId = new StringJoiner(CawConstants.VERTICAL_BAR_SIGN);
        StringJoiner stringItemDes = new StringJoiner(CawConstants.VERTICAL_BAR_SIGN);
        StringJoiner stringItemUnitPrice = new StringJoiner(CawConstants.VERTICAL_BAR_SIGN);
        StringJoiner stringItemQty = new StringJoiner(CawConstants.VERTICAL_BAR_SIGN);

        if (trans != null) {
            List<IRetailTransactionLineItem> itemList = trans.getSaleLineItems();

            if (CollectionUtils.isNotEmpty(itemList)) {
                ISaleReturnLineItem item = null;
                BigDecimal itemUnitPrice = BigDecimal.ZERO;/*BZ41704*/
                for (IRetailTransactionLineItem itemLine : itemList) {
                    if (!itemLine.getVoid() && itemLine instanceof ISaleReturnLineItem) {
                        item = (ISaleReturnLineItem) itemLine;
                        stringItemId.add(item.getItemId());
                        stringItemDes.add(item.getItemDescription());
                        /*BEGIN BZ41704*/
                        itemUnitPrice = item.getUnitPrice().setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode());
                        itemUnitPrice = itemUnitPrice.multiply(BigDecimal.TEN.pow(getLocalCurrencyScale()));
                        itemUnitPrice = itemUnitPrice.setScale(0, getLocalCurrencyRoundingMode());
                        stringItemUnitPrice.add(itemUnitPrice.toString());
                        /*END BZ41704*/
                        stringItemQty.add(item.getQuantity().toString());
                    }
                }
            }
        }
        /*
         * 1: item id
         * 2: item description
         * 3: item unit price
         * 4: item quantity
         */
        stringDataMap.put(1, stringItemId.toString());
        stringDataMap.put(2, stringItemDes.toString());
        stringDataMap.put(3, stringItemUnitPrice.toString());
        stringDataMap.put(4, stringItemQty.toString());
        return stringDataMap;
    }
    /*END BZ28546, BZ29363*/

    /*BEGIN BZ29360/BZ29505*/
    /**
     * GoodSam: Set token to request if token is existed.
     * 
     */
    private void setGoodSamToken() {

        /*Set token*/
        if (_gsHelper.isApplyGS() && !_gsHelper.isTokenUsed()) {
        	/* BEGIN BZ58779 */
            if(_transactionScope.getValue(CawValueKeys.CAW_DISABLE_TOKEN_IS_USED) != null) {
                _transactionScope.setValue(CawValueKeys.CAW_DISABLE_TOKEN_IS_USED, false);
            }
            /* END BZ58779 */
            _gsHelper.isTokenUsed(true);
            miraRequest.SetTField(CawEigenConstants.FN_SHORT_TOKEN, _gsHelper.getAccountShortToken());/*BZ29536*/
            /*Only GS Visa card that need expiry date*/
            if (_gsHelper.getCardType() == 1) {
                miraRequest.SetTField(CawEigenConstants.FN_EXPIRY_DATE, _gsHelper.getExpiryDay());
            }
            /*BEGIN BZ33319*/
            if(!StringUtils.isEmpty(_gsHelper.getExtendedCardType())) {
                miraRequest.SetTField(CawEigenConstants.FN_EXTENDED_CARD_TYPE, _gsHelper.getExtendedCardType());
            }
            /*END BZ33319*/
        }
    }
    /*END BZ29360/BZ29505*/
    /*BEGIN BZ37305*/
    private Serializable handleDisplayCustomerRequest(CawMiraRequest request) throws Exception {
        if(_transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER) != null) { //BZ47818
            IParty custParty =  _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER); //BZ47818
            String timeOut = CawUtilFunction.getSystemProperty(CawConstants.CAW_CUSTOMER_VERIFICATION_TIMEOUT, CawConstants.CAW_VERIFY_DEFAULT_TIME_OUT);
            miraRequest.Init();
            miraRequest.SetTField(FN_PINPAD_DISP_TIMEOUT, timeOut);
            miraRequest.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.TRANS_CODE_ITM_DISP);
            miraRequest.SetTField(CawEigenConstants.FN_TRANS_TYPE, CawEigenConstants.CONFIRM_PROMPT);
            miraRequest.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper.getStationId());
            miraRequest.SetTField(CawEigenConstants.FN_PINPAD_DISP_OPTION, CawEigenConstants.VALUE_SUcK);
            miraRequest.SetTField(CawEigenConstants.FIELD_L1, _ff.getTranslatable("_verifyCusInfoL1").toString());
            //Customer name or Company name
            miraRequest.SetTField(CawEigenConstants.FIELD_L3, makeString("_verifyCusInfoL3", _customerHelper
                    .getCustomerDisplayName(custParty)));
            //Address line 1
            miraRequest.SetTField(CawEigenConstants.FIELD_L4, makeString("_verifyCusInfoL4", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 1)));
            //City
            miraRequest.SetTField(CawEigenConstants.FIELD_L5, makeString("_verifyCusInfoL5", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 2)));
            //State
            miraRequest.SetTField(CawEigenConstants.FIELD_L6, makeString("_verifyCusInfoL6", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 3)));
            //Zipcode
            miraRequest.SetTField(CawEigenConstants.FIELD_L7, makeString("_verifyCusInfoL7", CawCustomerUtil
                    .getAddressInfoIParty(custParty, 4)));
            //Phone numbers
            Map<String, String> phoneNumbers = CawCustomerUtil.getPhoneNumberIParty(custParty);
            String home = "";
            String mobile = "";
            if (!CollectionUtils.sizeIsEmpty(phoneNumbers)) {
                home = phoneNumbers.get(CawConstants.HOME);
                home = (home == null) ? "" : home;
                mobile = phoneNumbers.get(CawConstants.MOBILE);
                mobile = (mobile == null) ? "" : mobile;
            }
            miraRequest.SetTField(CawEigenConstants.FIELD_L8, makeString("_verifyCusInfoL8", home));
            miraRequest.SetTField(CawEigenConstants.FIELD_L9, makeString("_verifyCusInfoL9", mobile));
            //Email
            String email = custParty.getEmailAddress();
            if (email == null) {
                email = "";
            }
            miraRequest.SetTField(CawEigenConstants.FIELD_L0, makeString("_verifyCusInfoL10", email));
            String subEmail = "";
            int lengthEmail = email.length();
            if (lengthEmail > CawEigenConstants.MAX_LENGTH_FIRST_LINE_EMAIL) {
                subEmail = email.substring(CawEigenConstants.MAX_LENGTH_FIRST_LINE_EMAIL, lengthEmail);
                //If length of subEmail after split > MAX_LENGTH_SECOND_LINE_EMAIL. Get MAX_LENGTH_SECOND_LINE_EMAIL character first.
                if (subEmail.length() > CawEigenConstants.MAX_LENGTH_SECOND_LINE_EMAIL) {
                    subEmail = subEmail.substring(0, CawEigenConstants.MAX_LENGTH_SECOND_LINE_EMAIL);
                }
                miraRequest.SetTField(CawEigenConstants.FIELD_LA, subEmail);
            }
            miraRequest.SetTField(CawEigenConstants.FIELD_KE, CawEigenConstants.KEY_F6_F7);
            miraRequest.SetTField(CawEigenConstants.KEY_TEXT_F6, CawEigenConstants.TEXT_NO);
            miraRequest.SetTField(CawEigenConstants.KEY_TEXT_F7, CawEigenConstants.TEXT_YES);
        }
        return (Serializable) miraRequest;
    }
    public String makeString(String keyTranslation, String parameter) {
        return String.format(_ff.getTranslatable(keyTranslation).toString(), parameter);
    }
    /*END BZ37305*/
    /*BEGIN BZ33319*/
    private String getTransNumber(IRetailTransaction trans) {
        try {
            if(trans != null) {
                String businessDate = String.format("%tF", trans.getBusinessDate()).replaceAll(DASH_STR, "");
                String transNumber = String.format("%s0%d0%d%d", businessDate, trans
                        .getRetailLocationId(), trans
                                .getWorkstationId(), trans.getTransactionSequence());
                return transNumber;
            }
            
        } catch (Exception ex) {
            logger.error(" Can not build transNumber: " + ex.getMessage());
        }
        return EMPTY_STR;
    }
    /*END BZ33319*/
    /*BEGIN BZ41674*/
    private void handleDeferFinancialTrans() {
        try {
            if (_transactionScope.getValue(CawValueKeys.RETURN_OG_FIELD) != null
                    && !StringUtils.isEmpty(_transactionScope
                            .getValue(CawValueKeys.RETURN_OG_FIELD))) {
                miraRequest.SetTField(ORIG_INVOICE_NO, _transactionScope
                        .getValue(CawValueKeys.RETURN_OG_FIELD));
            }
            if (_transactionScope.getValue(CawValueKeys.RETURN_VN_FIELD) != null
                    && !StringUtils.isEmpty(_transactionScope
                            .getValue(CawValueKeys.RETURN_VN_FIELD))) {
                miraRequest.SetTField(FN_VOUCH_SER_NUM, _transactionScope
                        .getValue(CawValueKeys.RETURN_VN_FIELD));
            }
        } catch (Exception ex) {
            logger.error(" Can not set OG or VN field: " + ex.getMessage());
        }
    }
    /*END BZ41674*/
}