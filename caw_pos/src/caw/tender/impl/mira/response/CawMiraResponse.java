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
 * BZ23164              180917    [DEV] Implement EMV Payment Integration
 * BZ23339              210917    [DEV] Implement Gift card authorization
 * BZ23339              260917    [DEV] Implement Gift card authorization
 * BZ23359              270917    Gift cards can't be swiped at screen
 * BZ23662              280917    The Manual option should be also disabled to the Debit in offline mode.
 * BZ23359              021017    Gift cards can't be swiped at screen
 * BZ23698              021017    The Manual option should be enable to the Credit in offline mode
 * BZ23694              041017    Text of prompting is displayed incorrectly after pressing "cancel(x)" on SigCap
 * BZ23697              041017    Decline receipt is printed for EMV- Fall back card
 * BZ23697              051017    Decline receipt is printed for EMV- Fall back card
 * BZ23629              051017    [Xstore] Help Desk Error after submitting ADD COMMENT screen during receipt return
 * BZ23800              051017    Missing EMV tag in declined receipt when performing transaction with EMV is declined
 * BZ23359              091017    Gift cards can't be swiped at screen
 * BZ23864              101017    CW address should be displayed below CW's logo on Declined receipt for EMV/non-EMV/GC
 * BZ24017              151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ23892              161017    Missing Auth# in receipt when performing return no receipt a reload gift card transaction
 * BZ24052              171017    Missing Cashier number and Date Time on GC decline receipt when performing Issues/Reload or let timeout transaction
 * BZ24132              201017    Missing Cashier number & Saleperson in Cash out receipt number when GC is declined
 * BZ24232              261017    [OrderService] Xstore needs to send the card holder in the order_service.out message
 * BZ24419              091117    [Order Service] 'ExpireDate is required for Credit tenders' message displayed in service log
 * BZ24437              131117    [OrderService] "null" is submitted for masked card number when authorized in offline mode
 * BZ28860              281218    [Internal]Associate and Salesperson ID is missing the leading zero on Tender Exchange Decline Receipt.
 *===================================================================
 */

package caw.tender.impl.mira.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.tender.impl.mira.CawMiraUtil;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;

import dtv.pos.common.LocationFactory;
import dtv.tenderauth.IAuthProcess;
import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.event.ICreditAuthResponse;
import dtv.tenderauth.impl.event.AbstractAuthResponse;
import dtv.util.DateUtils;
import dtv.util.StringUtils;
import dtv.xst.dao.crm.IParty;

public class CawMiraResponse
        extends AbstractAuthResponse implements ICreditAuthResponse {

    private static final String REGISTER_NUMBER      = "dtv.location.terminalNumber";

    private static final String STORE_NUMBER         = "dtv.location.storeNumber";

    private static final Logger logger               = Logger
            .getLogger(CawMiraResponse.class);

    private static final String NOT_COMPLETED        = "Not Completed";

    private static final String DECLINE_REASON       = "Decline Reason: ";

    private static final String TRACE_NUMBER         = "Trace Number: ";

    private static final String TRANSACTION_TYPE     = "Transaction Type: ";

    private static final String NEW_LINE             = "\n";

    private static final String GIFT_CARD            = "Gift Card";

    private ArrayList<String>   giftCardCommand      = new ArrayList<String>();

    private static final String VALUE_D              = "D";

    private static final String STR_EQUAL            = "=";

    private MiraServJava        miraResponse;

    private ResponseCode        miraResponseCode;

    private String              retailLocationId     = "";

    private String              workstationId        = "";

    private Date                transactionDate      = new Date();

    private Long                beginDateTimestamp   = 0L;

    private String              transactionSequence  = "";

    private IParty              operatorParty        = null;

    private String              employeeId           = "";

    private String              requestType          = "";

    private String              receiptText          = "";

    private Boolean             isDeclinedActionCode = Boolean.FALSE;

    public CawMiraResponse(IAuthProcess argAuthProcess, IAuthRequest argRequest,
            String argAuthorizationCode, MiraServJava response) {

        super(argAuthProcess, argRequest, argAuthorizationCode);
        this.setMiraServResponse(response);

        logger.info("start to get decline gift card receipt");
        if (argRequest instanceof CawMiraGiftCardRequest) {
            setRetailLocationId(System.getProperty(STORE_NUMBER));
            setWorkstationId(System.getProperty(REGISTER_NUMBER));
            setTransactionDate(DateUtils.getNewDate());
            setBeginDateTimestamp(DateUtils.getNewDate().getTime());
            setTransactionSequence(String
                    .valueOf(argRequest.getLineItem() != null
                            ? argRequest.getLineItem().getTransactionSequence()
                            : ""));
            requestType = argRequest.getRequestType() != null
                    ? argRequest.getRequestType().getDescription()
                    : "";
            setReceiptText(getGiftCardDeclinedRcpt());

            if (((CawMiraGiftCardRequest) argRequest)
                    .getTransactionScope() != null
                    && ((CawMiraGiftCardRequest) argRequest)
                            .getTransactionScope().getTransaction() != null
                    && ((CawMiraGiftCardRequest) argRequest)
                            .getTransactionScope().getTransaction()
                            .getOperatorParty() != null) {
                setOperatorParty(((CawMiraGiftCardRequest) argRequest)
                        .getTransactionScope().getTransaction()
                        .getOperatorParty());
                setEmployeeId(getOperatorParty().getEmployeeId());
            } 
            /*BEGIN BZ28860*/
            else if (((CawMiraGiftCardRequest) argRequest).getLineItem() != null
                    && ((CawMiraGiftCardRequest) argRequest).getLineItem().getParentTransaction() != null
                    && ((CawMiraGiftCardRequest) argRequest).getLineItem().getParentTransaction()
                            .getOperatorParty() != null) {
                setEmployeeId(((CawMiraGiftCardRequest) argRequest).getLineItem().getParentTransaction()
                        .getOperatorParty().getEmployeeId());
            }
            /*END BZ28860*/
        }

    }

    public ResponseCode getEnumResponseCode() {

        return miraResponseCode;
    }

    @Override
    public String getResponseCode() {

        BigInteger responseCodeNumber = CawEigenConstants.NOT_A_VALID_VALUE;
        String trans = "";
        try {
            responseCodeNumber = new BigInteger(
                    miraResponse.GetTField(CawEigenConstants.FN_RESPONSE_CODE));
            String transCode = getTransactionCode();
            String displayMsg = getDisplayMessage();
            trans = CawMiraUtil.translateTransCode(transCode, displayMsg);
            /*Begin BZ23662*/
            ResponseCode responseCode = CawMiraUtil
                    .translateResultCode(responseCodeNumber);
            /*BEGIN BZ23629*/
            if (responseCode == ResponseCode.CARD_NUM_ERROR
                    && VALUE_D.equalsIgnoreCase(miraResponse
                            .GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                return ResponseCode.CARD_NUM_ERROR.toString();
            } /*END BZ23629*/
            else if ((responseCode == ResponseCode.TIMEOUT
                    || responseCode == ResponseCode.Undefined)
                    && VALUE_D.equalsIgnoreCase(getActionCode())
                    && !getAllGiftCardCommand().contains(transCode)) {
                return ResponseCode.OFFLINE_CANT_PROCESS_TYPE.toString();
            } /*BEGIN BZ23694*/
            else if (responseCode == ResponseCode.USER_CANCEL
                    && VALUE_D.equalsIgnoreCase(getActionCode())
                    && !getAllGiftCardCommand().contains(transCode)) {
                responseCode = ResponseCode.USER_CANCEL;
            } /*END BZ23694*/
            else if (VALUE_D.equalsIgnoreCase(getActionCode())
                    && !getAllGiftCardCommand().contains(transCode)) {
                responseCode = ResponseCode.DECLINED;
            }
            return responseCode.toString() + trans;
            /*End BZ23662*/
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
            return null;
        }
    }

    private ArrayList<String> getAllGiftCardCommand() {

        if (giftCardCommand.isEmpty()) {
            giftCardCommand.add(CawMiraCommand.ACTIVATE);
            giftCardCommand.add(CawMiraCommand.DEACTIVATE);
            giftCardCommand.add(CawMiraCommand.REDEEM);
            giftCardCommand.add(CawMiraCommand.REDEEM_VOID);
            giftCardCommand.add(CawMiraCommand.BALANCE_INQUIRY);
            giftCardCommand.add(CawMiraCommand.CASH_OUT);
            giftCardCommand.add(CawMiraCommand.RELOAD_VOID);
            giftCardCommand.add(CawMiraCommand.RELOAD);
        }
        return giftCardCommand;
    }

    @Override
    public BigDecimal getBalance() {

        try {
            String s = miraResponse
                    .GetTField(CawEigenConstants.FN_ACCOUNT_BALANCE);
            if (s != null && !s.isEmpty()) {
                return new BigDecimal(s).movePointLeft(2);
            }

        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get balance response"
                    + ex.getMessage());
            return super.getBalance() != null ? super.getBalance()
                    : BigDecimal.ZERO;
        }
        return super.getBalance() != null ? super.getBalance()
                : BigDecimal.ZERO;
    }

    public String getResponseText() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_RESPONSE_MSG);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get response text" + ex.getMessage());
            return null;
        }
    }

    public String getCardTypeCode() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_CARD_TYPE);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get card type code" + ex.getMessage());
            return null;
        }
    }

    public String getDisplayMessage() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_DISPLAY_MSG);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get display message"
                    + ex.getMessage());
            return null;
        }
    }

    @Override
    public String getAuthorizationCode() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_APPROVAL_CD);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get authorization code"
                    + ex.getMessage());
            return null;
        }
    }

    public String getApprovedAmount() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_APPROVE_AMOUNT);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get approved amount"
                    + ex.getMessage());
            return null;
        }
    }

    public String getToken() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_TOKEN);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get token" + ex.getMessage());
            return null;
        }
    }

    public String getShortToken() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_SHORT_TOKEN);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get short token" + ex.getMessage());
            return null;
        }
    }

    public String getTraceNumber() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_TRACE_NUMBER);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get trace number" + ex.getMessage());
            return null;
        }
    }

    public String getEntryMethod() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_ENTRY_METHOD);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get entry method" + ex.getMessage());
            return null;
        }
    }

    public String getAccountNumber() {

        String accountNumber = null;
        try {
            accountNumber = miraResponse
                    .GetTField(CawEigenConstants.FN_BANK_ACCOUNT_NUMBER);
            if (StringUtils.isEmpty(accountNumber)) {
                String track2 = miraResponse
                        .GetTField(CawEigenConstants.FN_TRACK_2_ACC);
                if (track2 != null && !track2.isEmpty()) {
                    int cardEndPos = track2.indexOf(STR_EQUAL);
                    //some cases the response do not the track 2 tag.
                    //check it to prevent the error
                    if (cardEndPos > 0) {
                        accountNumber = track2.substring(1, cardEndPos);
                    }
                }
                // Begin BZ24437
                else if (getToken() != null
                        && !StringUtils.isEmpty(getToken())) {
                    String value = getToken();
                    String[] parts = value.split(":");
                    String acctNbr = parts[5];
                    if (acctNbr != null) {
                        String s1 = "************";
                        String s2 = acctNbr.substring(2, 6);
                        return s1 + s2;
                    } else {
                        return null;
                    }
                }
                // End BZ24437
                else {
                    return getMaskShortToken();
                }

            }
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get account number" + ex.getMessage());
            return null;
        }
        return accountNumber;
    }

    public String getMaskAccountNumber() {

        String accountNumber = getAccountNumber();
        if (accountNumber != null && accountNumber.length() == 19) {
            String s1 = accountNumber.substring(0, 6);
            String s2 = "*********";
            String s3 = accountNumber.substring(15, 19);
            return (s1 + s2 + s3);
        }
        return accountNumber;
    }

    public String getMaskShortToken() {

        String shortToken = getShortToken();
        if (shortToken != null && shortToken.length() == 19) {
            String s1 = "***************";
            String s2 = shortToken.substring(15, 19);
            return (s1 + s2);
        }
        return shortToken;
    }

    /** {@inheritDoc} */
    @Override
    public String getPosDataCode() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String getPs2000() {

        return null;
    }

    /**
     * Returns 
     * @return 
     */
    public MiraServJava getMiraServResponse() {

        return miraResponse;
    }

    /**
     * Specifies
     * @param miraResponse 
     */
    public void setMiraServResponse(MiraServJava miraResponse) {

        this.miraResponse = miraResponse;
    }

    public void setMiraServerData(MiraServJava data) {

        miraResponse = data;
    }

    /*Begin BZ23698*/
    public String getActionCode() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_ACTION_CODE);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get action code" + ex.getMessage());
            return null;
        }
    }
    /*End BZ23698*/

    public String getReceiptResponse() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_RECEIPT_MSG_TXT)
                    .replaceAll("\\\\n", NEW_LINE); // BZ23800
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get receipt response"
                    + ex.getMessage());
            return null;
        }
    }

    public String getTransactionCode() {

        try {
            return miraResponse.GetTField(CawEigenConstants.FN_TRANS_CODE);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get transaction code"
                    + ex.getMessage());
            return null;
        }
    }

    public String getCardHolderName() {

        try {
            return miraResponse
                    .GetTField(CawEigenConstants.FN_CARD_HOLDER_NAME);
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get Card Holder Name response"
                    + ex.getMessage());
            return "";
        }
    }

    public String getExpiryDate() {

        try {
            //Begin BZ24419: In case, testing Credit in Offline mode, shortToken of exp_dt is null/blank, due to this empty is stored in DB and Order service coundn't decrypt this value
            //. In order fix for case, when Short Token is null, the exp_date will be taken from Long Token.
            if (miraResponse.GetTField(CawEigenConstants.FN_EXPIRY_DATE) == null
                    || miraResponse.GetTField(CawEigenConstants.FN_EXPIRY_DATE)
                            .isEmpty()) {
                String value = miraResponse
                        .GetTField(CawEigenConstants.FN_TOKEN);
                String[] parts = value.split(":");
                String expDate = parts[2];
                if (expDate != null) {
                    return expDate;
                } else {
                    return null;
                }
                //End BZ24419
            } else {
                return miraResponse.GetTField(CawEigenConstants.FN_EXPIRY_DATE);
            }
        } catch (MiraServJavaException ex) {
            logger.debug("Exception when get Expiry Date response"
                    + ex.getMessage());
            return "";
        }
    }

    private String getGiftCardDeclinedRcpt() {

        String rcpt = GIFT_CARD;
        if (getAmount() != null && getAmount() != BigDecimal.ZERO) {
            rcpt += ": " + String.valueOf(getAmount()) + NEW_LINE;
        } else {
            rcpt += NEW_LINE;
        }

        rcpt += getMaskShortToken() + NEW_LINE;
        rcpt += TRANSACTION_TYPE + requestType + NEW_LINE;
        rcpt += TRACE_NUMBER + getTraceNumber() + NEW_LINE;
        rcpt += DECLINE_REASON
                + (getDisplayMessage() != null ? getDisplayMessage()
                        : NOT_COMPLETED)
                + NEW_LINE + NEW_LINE;
        return rcpt;
    }

    /**
     * @return the retailLocationId
     */
    public String getRetailLocationId() {

        return retailLocationId;
    }

    /**
     * @param argRetailLocationId the retailLocationId to set
     */
    public void setRetailLocationId(String argRetailLocationId) {

        retailLocationId = argRetailLocationId;
    }

    /**
     * @return the workstationId
     */
    public String getWorkstationId() {

        return workstationId;
    }

    /**
     * @param argWorkstationId the workstationId to set
     */
    public void setWorkstationId(String argWorkstationId) {

        workstationId = argWorkstationId;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {

        return transactionDate;
    }

    /**
     * @param argTransactionDate the transactionDate to set
     */
    public void setTransactionDate(Date argTransactionDate) {

        transactionDate = argTransactionDate;
    }

    /**
     * @return the beginDateTimestamp
     */
    public Long getBeginDateTimestamp() {

        return beginDateTimestamp;
    }

    /**
     * @param argBeginDateTimestamp the beginDateTimestamp to set
     */
    public void setBeginDateTimestamp(Long argBeginDateTimestamp) {

        beginDateTimestamp = argBeginDateTimestamp;
    }

    /**
     * @return the transactionSequence
     */
    public String getTransactionSequence() {

        return transactionSequence;
    }

    /**
     * @param argTransactionSequence the transactionSequence to set
     */
    public void setTransactionSequence(String argTransactionSequence) {

        transactionSequence = argTransactionSequence;
    }

    /**
     * @return the requestType
     */
    public String getRequestType() {

        return requestType;
    }

    /**
     * @param argRequestType the requestType to set
     */
    public void setRequestType(String argRequestType) {

        requestType = argRequestType;
    }

    /**
     * @return the receiptText
     */
    public String getReceiptText() {

        return receiptText;
    }

    /**
     * @param argReceiptText the receiptText to set
     */
    public void setReceiptText(String argReceiptText) {

        receiptText = argReceiptText;
    }

    /**
     * @return the isDeclinedActionCode
     */
    public Boolean getIsDeclinedActionCode() {

        return isDeclinedActionCode;
    }

    /**
     * @param argIsDeclinedActionCode the isDeclinedActionCode to set
     */
    public void setIsDeclinedActionCode(Boolean argIsDeclinedActionCode) {

        isDeclinedActionCode = argIsDeclinedActionCode;
    }

    // Begin BZ23864
    /**
     * @return getStoreName
     */
    public String getStoreName() {

        if (STORE_NUMBER != null) {
            return LocationFactory.getInstance()
                    .getStoreById(Long.valueOf(retailLocationId))
                    .getStoreName();
        }
        return null;
    }

    /**
     * 
     * @return getAddress
     */
    public String getAddress() {

        if (STORE_NUMBER != null) {
            return LocationFactory.getInstance()
                    .getStoreById(Long.valueOf(retailLocationId)).getAddress1();
        }
        return null;
    }

    /**
     * 
     * @return getLocation
     */
    public String getLocation() {

        if (STORE_NUMBER != null) {
            String city = LocationFactory.getInstance()
                    .getStoreById(Long.valueOf(retailLocationId)).getCity();
            String state = LocationFactory.getInstance()
                    .getStoreById(Long.valueOf(retailLocationId)).getState();
            String postalCode = LocationFactory.getInstance()
                    .getStoreById(Long.valueOf(retailLocationId))
                    .getPostalCode();

            return city + ", " + state + " " + postalCode;
        }
        return null;
    }
    // End BZ23864

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {

        return employeeId;
    }

    /**
     * @param argEmployeeId the employeeId to set
     */
    public void setEmployeeId(String argEmployeeId) {

        employeeId = argEmployeeId;
    }

    /**
     * @param argOperatorParty the operatorParty to set
     */
    public void setOperatorParty(IParty argOperatorParty) {

        operatorParty = argOperatorParty;
    }

    /**
     * @return the operatorParty
     */
    public IParty getOperatorParty() {

        return operatorParty;
    }
}