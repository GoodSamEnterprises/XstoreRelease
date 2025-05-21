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
 * BZ23164              180917    [DEV] Implement EMV Payment Integration
 * BZ23381              190917    Can't print receipt when performing sale transaction with Credit Card tender
 * BZ23438              250917    Missing Credit/Debit name on the sale screen when completing transaction by credit card tender
 * BZ23359              270917    Gift cards can't be swiped at screen
 * BZ23359              021017    Gift cards can't be swiped at screen
 * BZ23359              041017    Gift cards can't be swiped at screen
 * BZ23629              051017    [Xstore] Help Desk Error after submitting ADD COMMENT screen during receipt return
 * BZ29505              010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29590              070319    [Internal] PLCC/CO-BRAND-Good Sam Visa should be displayed on receipt instead of Credit/Card when using authorized token tender of Credit application to tender.
 *===================================================================
 */

package caw.tender.impl.mira;

import static dtv.pos.common.ConfigurationMgr.getCurrency;
import static dtv.pos.common.ConfigurationMgr.isFeesLineDisplayed;
import static dtv.pos.register.type.NonPhysicalItemSubType.FEE;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import javax.inject.Inject;

import MiraServJava.MiraServJava;
import caw.tender.impl.mira.request.CawMiraRequest;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.mira.constants.*;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.hardware.types.HardwareFamilyType;
import dtv.i18n.*;
import dtv.pos.common.CommonHelper;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.tender.TenderHelper;
import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.ITenderAuthRequest;
import dtv.tenderauth.event.IAuthResponse;
import dtv.util.Money;
import dtv.util.StringUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.tnd.TenderCategory;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawMiraUtil {

    /**
     * 
     */
    private static final String NULL_VALUE     = "null";

    /**
     * 
     */
    private static final String CARD_NUM_ERROR = "CARD_NUM_ERROR";

    /**
     * 
     */
    private static final String USER_CANCEL    = "USER_CANCEL";

    @Inject
    private TransactionScope    _transactionScope;

    @Inject
    private TenderHelper        _tenderHelper;

    @Inject
    private CommonHelper        _commonHelper;

    /** Constructs a <code>CawMiraUtil</code>.
     * 
     */
    public CawMiraUtil() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    /**
     * Random 4 digit numbers for pairing
     * 
     * @return String of 4 digit number
     */
    public static int generate4DigitNumber() {

        Random randNum = new Random();
        return (1000 + randNum.nextInt(8000));
    }

    /**
     * 
     * @param argResponseCodeNumber
     * @return
     */
    public static String translateTransCode(String transCode, String displayMsg) {

        String returnMsg = "";
        if (transCode.equalsIgnoreCase(CawMiraCommand.BALANCE_INQUIRY)) {
            returnMsg = "_BALANCE_INQUIRY_";
            if (displayMsg.equalsIgnoreCase(CawEigenConstants.DM_INVALID_CARD_TYPE)) {
                return returnMsg + CawEigenConstants.DM_MSG_INVALID_CARD_TYPE;
            } else if (displayMsg.equalsIgnoreCase(CawEigenConstants.DM_INVALID_FORMAT)) {
                return returnMsg + CawEigenConstants.DM_MSG_INVALID_FORMAT;
            } else {
                return "_BALANCE_INQUIRY";
            }
        }

        if (transCode.equalsIgnoreCase(CawMiraCommand.ACTIVATE)) {
            returnMsg = "_ACTIVE_";
            if (displayMsg.equalsIgnoreCase(CawEigenConstants.DM_ACCT_ALREADY_ACTIVE)) {
                return returnMsg + CawEigenConstants.DM_MSG_ACCT_ALREADY_ACTIVE;
            } else if (displayMsg.equalsIgnoreCase(CawEigenConstants.DM_INVALID_FORMAT)) {
                return returnMsg + CawEigenConstants.DM_MSG_INVALID_FORMAT;
            } else {
                return "_ACTIVE";
            }
        }

        return "";
    }

    /**
     * Convert value constant from Point's result code to response 
     * 
     * @param sessionResponse
     * @return response code for POS response
     */
    public static ResponseCode translateResultCode(BigInteger argResponseCodeNumber) {

        ResponseCode returnValue = null;
        //1-9:Accepted and approved Financial Transaction
        if (CawEigenConstants.OK_START.compareTo(argResponseCodeNumber) <= 0
                && CawEigenConstants.OK_END.compareTo(argResponseCodeNumber) >= 0) {
            returnValue = ResponseCode.Success;
        } else if (CawEigenConstants.DECLINED.equals(argResponseCodeNumber))//50: General Decline
        {
            returnValue = ResponseCode.DECLINED;
        } else if (CawEigenConstants.COMM_ERROR.equals(argResponseCodeNumber))//703
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.PINPAD_COMM_ERROR.equals(argResponseCodeNumber))//708: cannot open the pinpad.
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.PINPAD_NOT_CONNECT.equals(argResponseCodeNumber))//708: cannot open the pinpad.
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.POS_TIMEOUT.equals(argResponseCodeNumber))//729: POS TIMEOUT.
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.TRANSACTION_CANCEL.equals(argResponseCodeNumber))//766: Transaction cancel
        {
            returnValue = ResponseCode.USER_CANCEL;
        } else if (CawEigenConstants.PINPAD_INPUT_TIMEOUT.equals(argResponseCodeNumber))//787: Pinpad input time out.
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.RC_TIMEOUT.equals(argResponseCodeNumber))//736: timeout
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.CANCELED.equals(argResponseCodeNumber))//799
        {
            returnValue = ResponseCode.USER_CANCEL;
        } else if (CawEigenConstants.USER_CANCELED.equals(argResponseCodeNumber))//797
        {
            returnValue = ResponseCode.USER_CANCEL;
        } else if (CawEigenConstants.PINPAD_NOT_CONNECT.equals(argResponseCodeNumber))//708: cannot open the pinpad.
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.VOIDED.equals(argResponseCodeNumber))//7
        {
            returnValue = ResponseCode.Voided;
        } else if (CawEigenConstants.VOICE_APPROVAL.equals(argResponseCodeNumber))//59024
        {
            returnValue = ResponseCode.VOICE_APPROVAL;
        } else if (CawEigenConstants.FIELD_NOT_EXIST.equals(argResponseCodeNumber))//59045
        {
            returnValue = ResponseCode.FIELD_INVALID;
        } else if (CawEigenConstants.NO_SESSION.equals(argResponseCodeNumber))//59004
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.MISMATCH.equals(argResponseCodeNumber))//59040
        {
            returnValue = ResponseCode.ErrorOrRetry;
        } else if (CawEigenConstants.IS_REQUIRED.equals(argResponseCodeNumber))//59042
        {
            returnValue = ResponseCode.OFFLINE;
        } else if (CawEigenConstants.ALREADY_EXISTS.equals(argResponseCodeNumber))//59044
        {
            returnValue = ResponseCode.AlreadyActive;
        } else if (CawEigenConstants.NOT_A_VALID_VALUE.equals(argResponseCodeNumber))//59046
        {
            returnValue = ResponseCode.Invalid;
        } else if (CawEigenConstants.CANNOT_BE_NEGATIVE.equals(argResponseCodeNumber))//59047
        {
            returnValue = ResponseCode.Invalid;
        } else if (CawEigenConstants.MUST_BE_GREATER_THAN_0.equals(argResponseCodeNumber))//59048
        {
            returnValue = ResponseCode.ApprovedZeroAmount;
        } else if (CawEigenConstants.CONFIGURATION_ERROR.equals(argResponseCodeNumber))//59028
        {
            returnValue = ResponseCode.ConfigurationError;
        } else if (CawEigenConstants.SESSION_IN_PROGRESS.equals(argResponseCodeNumber))//59003
        {
            returnValue = ResponseCode.AlreadyActive;
        } else if (CawEigenConstants.DEVICE_IS_BUSY.equals(argResponseCodeNumber))//59025
        {
            returnValue = ResponseCode.DEVICE_IS_BUSY;
        } else if (CawEigenConstants.ERROR_BAD_CARD.equals(argResponseCodeNumber)
                || CawEigenConstants.CARD_DATA_NOT_VALID.equals(argResponseCodeNumber))//59007
        {
            returnValue = ResponseCode.CARD_NUM_ERROR;
        }
        // PAYMENT_MEDIA is MC CVV2 length should be 3 length passed was 4
        // <RESULT_CODE>10100</RESULT_CODE>
        else if (CawEigenConstants.PAYMENT_MEDIA_ERROR.equals(argResponseCodeNumber))//10100
        {
            returnValue = ResponseCode.Expended;
        } else if (CawEigenConstants.ERROR_NOT_ELIGIBLE.equals(argResponseCodeNumber))//3705
        {
            returnValue = ResponseCode.ERROR_NOT_SUPPORT;
        } else if (CawEigenConstants.TIME_OUT.equals(argResponseCodeNumber))//59026
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.AUTH_CODE_MAX_LEN.equals(argResponseCodeNumber))//10098
        {
            returnValue = ResponseCode.InvalidMerchCall;
        } else if (CawEigenConstants.UNKONW.equals(argResponseCodeNumber))//0
        {
            returnValue = ResponseCode.TIMEOUT;
        } else if (CawEigenConstants.INVALID_AMOUNT.equals(argResponseCodeNumber))//1010
        {
            returnValue = ResponseCode.Expended;
        } else if (CawEigenConstants.ERROR_NOT_SUPPORT.equals(argResponseCodeNumber))//59006
        {
            returnValue = ResponseCode.ERROR_NOT_SUPPORT;
        } else if (CawEigenConstants.FIELD_INVALID.equals(argResponseCodeNumber))//59043
        {
            returnValue = ResponseCode.FIELD_INVALID;
        } else if (CawEigenConstants.RC_INVALID_CARD_TYPE.equals(argResponseCodeNumber))//717
        {
            returnValue = ResponseCode.Invalid;
        } else if (CawEigenConstants.CARD_NUM_ERROR.equals(argResponseCodeNumber))//BZ23629
        {
            returnValue = ResponseCode.CARD_NUM_ERROR;
        } else {
            returnValue = ResponseCode.Undefined;
        }
        return returnValue;
    }

    public Money getRoundedAmountDue() {

        IPosTransaction transaction = _transactionScope.getTransaction();

        if (transaction == null) {
            return new Money(BigDecimal.ZERO, null);
        }

        final java.util.Currency currency = getCurrency();
        Money balance = null;

        Money changeDue = TransactionHelper.getChangeDue(transaction);

        if (changeDue != null) {
            BigDecimal roundedChangeDue = _commonHelper.roundCurrency(changeDue);
            return new Money(roundedChangeDue, changeDue.getCurrency());
        } else if (transaction.getAmountDue() != null) {
            balance = new Money(_commonHelper.roundCurrency(_tenderHelper
                    .getRoundingAmountByTender(_tenderHelper.getLocalCurrency(), transaction.getAmountDue().abs())),
                    currency);
        }

        return balance;
    }

    public BigDecimal getSaleCount() {

        if (_transactionScope.getTransaction() == null) {
            return BigDecimal.ZERO;
        }
        return TransactionHelper.getSaleCount(_transactionScope.getTransaction());
    }

    public String getSaleCountLabel() {

        return FormattableFactory.getInstance().getSimpleFormattable("_transactionListFooterSoldItems")
                .toString(OutputContextType.VIEW);
    }

    public BigDecimal getSubtotal() {

        if (_transactionScope.getTransaction() == null) {
            return BigDecimal.ZERO;
        }
        return getSubtotal(_transactionScope.getTransaction());
    }

    public BigDecimal getTaxAmount() {

        if (_transactionScope.getTransaction() == null) {
            return BigDecimal.ZERO;
        }

        return _transactionScope.getTransaction().getTaxAmount() != null
                ? _transactionScope.getTransaction().getTaxAmount()
                : BigDecimal.ZERO;
    }

    public BigDecimal getTotalFees() {

        if (!isFeesLineDisplayed()) {
            return null;
        } else {
            if (_transactionScope.getTransaction() == null) {
                return BigDecimal.ZERO;
            }
            return getTotalFees(_transactionScope.getTransaction());
        }
    }

    public String getTotalFeesLabel() {

        if (!isFeesLineDisplayed()) {
            return null;
        } else {
            return FormattableFactory.getInstance().getSimpleFormattable("_transactionListFooterFees")
                    .toString(OutputContextType.VIEW);
        }
    }

    /**
     * Returns the subtotal of <code>argTransaction</code>. The subtotal is the total of the extended amount
     * of all items on the transaction, excluding fees and taxes.
     * @param argTransaction the transaction for which the subtotal is to be returned
     * @return the subtotal of the transaction that was provided
     */
    protected BigDecimal getSubtotal(IPosTransaction argTransaction) {

        BigDecimal subtotal = ZERO;

        if (isFeesLineDisplayed()) {
            // The subtotal should include the extended amount of all sale lines on the transaction that
            // are not fees.
            subtotal = ZERO;

            for (ISaleReturnLineItem saleLine : argTransaction.getLineItems(ISaleReturnLineItem.class)) {
                if (saleLine.getVoid()) {
                    continue;
                }

                if (saleLine.getItem() instanceof INonPhysicalItem) {
                    INonPhysicalItem item = (INonPhysicalItem) saleLine.getItem();

                    if (!FEE.matches(item.getNonPhysicalItemSubtype())) {
                        subtotal = subtotal.add(saleLine.getExtendedAmount());
                    }
                } else {
                    subtotal = subtotal.add(saleLine.getExtendedAmount());
                }
            }
        } else {
            subtotal = argTransaction.getSubtotal();
        }
        return subtotal;
    }

    /**
     * Returns the total amount of all fees on <code>argTransaction</code>.
     *
     * @param argTransaction the transaction for which the total fee amount is to be returned
     * @return the total amount of all fees on the transaction that was provided
     */
    protected BigDecimal getTotalFees(IPosTransaction argTransaction) {

        BigDecimal totalFees = ZERO;

        for (ISaleReturnLineItem saleLine : argTransaction.getLineItems(ISaleReturnLineItem.class)) {
            if ((saleLine.getItem() instanceof INonPhysicalItem) && !saleLine.getVoid()) {
                INonPhysicalItem item = (INonPhysicalItem) saleLine.getItem();

                if (FEE.matches(item.getNonPhysicalItemSubtype())) {
                    totalFees = totalFees.add(saleLine.getExtendedAmount());
                }
            }
        }
        return totalFees;
    }

    /**
     * Calculate and return current invoice number of retailTransaction
     * @param retailTransaction
     * @return invoice number with 6 digits
     */
    public static String getInvoiceNumber(IRetailTransaction retailTransaction) {

        //calculate invoice number that max char number is 6
        String registerId = StringUtils
                .leftPadZeros(retailTransaction.getRetailLocationId(), CawEigenConstants.INVOICE_REGISTER);
        String transactionSeq = StringUtils
                .leftPadZeros(retailTransaction.getTransactionSequence(), CawEigenConstants.INVOICE_TRANSACTION_SEQ);
        String invoiceNumber = StringUtils.right(registerId, CawEigenConstants.INVOICE_REGISTER)
                + StringUtils.right(transactionSeq, CawEigenConstants.INVOICE_TRANSACTION_SEQ);

        return invoiceNumber;
    }

    /**
     * BZ29505: add parameter
     * Convert the value of sub tender type to 
     * right values that are defined in base code
     * @param orgTenderSubType
     * @return 
     */
    public static String convertTenderSubType(String orgTenderSubType, ITenderLineItem tenderLineItem) {

        String subTenderType = orgTenderSubType;
        if (CawCardTypeCode.AMEX1.equalsIgnoreCase(orgTenderSubType)
                || CawCardTypeCode.AMEX2.equalsIgnoreCase(orgTenderSubType)) {//bz23438
            subTenderType = CawCardType.AMEX;
        } else if (CawCardTypeCode.DISCOVER.equalsIgnoreCase(orgTenderSubType)) {
            subTenderType = CawCardType.DISCOVER;//BZ23381
        } else if (CawCardTypeCode.MASTERCARD.equalsIgnoreCase(orgTenderSubType)) {
            subTenderType = CawCardType.MASTERCARD;
        } else if (CawCardTypeCode.VISA.equalsIgnoreCase(orgTenderSubType)) {
            /*BEGIN BZ29505*/
            if (CawCardType.GSVISA.equals(tenderLineItem.getTenderId())) {
                subTenderType = CawCardType.GSVISA;
            } else {
                subTenderType = CawCardType.VISA;
            }
            /*END BZ29505*/
        } else if (CawCardTypeCode.JCB.equalsIgnoreCase(orgTenderSubType)) {//BZ23438
            subTenderType = CawCardType.JCB;
        } else if (CawCardTypeCode.DINNER.equalsIgnoreCase(orgTenderSubType)) {//BZ23438
            subTenderType = CawCardType.DINNER;
        } else if (CawCardTypeCode.DEBIT.equalsIgnoreCase(orgTenderSubType)) {
            subTenderType = CawCardType.DEBIT;
        } else if (CawCardTypeCode.GIFT_CARD.equalsIgnoreCase(orgTenderSubType)) {
            subTenderType = CawCardType.GIFT_CARD;
        }
        /*BEGIN BZ29590*/
        else if (CawCardTypeCode.GSPLCC.equalsIgnoreCase(orgTenderSubType)) {
            subTenderType = CawCardType.GSPLCC;
        }
        /*END BZ29590*/
        else {
            subTenderType = CawCardType.OTHER;//BZ23381
        }
        return subTenderType;
    }

    /**
     * Returns the TenderType for the give authorizer tender type.
     * @param tenderType
     * @return the TenderType for the give authorizer tender type.
     */
    public static String formatTenderType(String tenderSubType) {

        String returnType = null;
        if (CawCardType.VISA.equals(tenderSubType) || CawCardType.MASTERCARD.equals(tenderSubType)
                || CawCardType.DISCOVER.equals(tenderSubType) || CawCardType.AMEX.equals(tenderSubType)
                || CawCardType.JCB.equals(tenderSubType)//BZ23438
                || CawCardType.DINNER.equals(tenderSubType))//BZ23438
        {
            returnType = TenderCategory.CREDIT_CARD.getName();
        } else if (CawCardType.DEBIT.equals(tenderSubType)) {
            returnType = CawCardType.DEBIT;
        } else {
            returnType = CawCardType.DEBIT;
        }
        return returnType;
    }

    /**
     * @param argRequest
     * @return
     */
    public static boolean isManualEntry(ITenderAuthRequest argRequest) {

        if (argRequest.getResponses().length > 0) {
            IAuthResponse lastResponse = argRequest.getResponses()[argRequest.getResponses().length - 1];
            if (lastResponse.getDataActionGroup().equals(DataActionGroupKey.createForName(USER_CANCEL))
                    || lastResponse.getDataActionGroup().equals(DataActionGroupKey.createForName(CARD_NUM_ERROR))) {
                return true;
            }
        }
        return false;
    }

    public static String maskField(String accountNumber) {

        if ((accountNumber == null) || (accountNumber.isEmpty())) {
            return null;
        }
        return mask(accountNumber.substring(0, accountNumber.length() - 4))
                .concat(accountNumber.substring(accountNumber.length() - 4));
    }

    public static String mask(Object o) {

        String result;
        if ((o instanceof IFormattable)) {
            result = ((IFormattable) o).toString(dtv.i18n.OutputContextType.LOG);
        } else {
            if (o == null) {
                return NULL_VALUE;
            }

            result = String.valueOf(o);
        }
        return StringUtils.fill("*", result.length());
    }

    public static boolean isKeyed(String argEntryMethod) {

        if (StringUtils.isEmpty(argEntryMethod)) {
            return false;
        }
        if (argEntryMethod.startsWith(HardwareFamilyType.KEYBOARD.getName())) {
            return true;
        }

        return false;
    }

    /**
     * @param argRequest
     * @param argLastTransRequest
     * @return
     */
    public static boolean isAuthRequest(IAuthRequest argRequest) {

        //todo
        CawMiraRequest miraRequest = null;
        if (argRequest instanceof CawMiraRequest) {
            miraRequest = (CawMiraRequest) argRequest;
        } else {
            return false;
        }
        if (CawMiraCommand.CAPTURE.equals(miraRequest.getCommand())) {
            return true;
        }
        return true;
    }

    /**
     * @param argRequest
     * @param argLastTransRequest
     * @return
     */
    public static boolean isValidLastTrans(IAuthRequest argRequest, IAuthResponse argLastTransResponse) {

        return false;
    }

    /**
     * @param argRequest
     * @param argLastTransRequest
     * @return
     */
    public static boolean isValidLastTranResponse(MiraServJava miraResponse) {

        return false;
    }
}
