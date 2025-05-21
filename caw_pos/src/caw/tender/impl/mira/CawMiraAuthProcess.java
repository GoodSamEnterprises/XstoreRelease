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
 * BZ23339              210917    [DEV] Implement Gift card authorization
 * BZ23339              260917    [DEV] Implement Gift card authorization
 * BZ23232              260917    Define Xstore Timeout
 * BZ23585              270917    Xstore stuck in a loop when authorization service is offline
 * BZ23359              021017    Gift cards can't be swiped at screen
 * BZ23698              021017    The Manual option should be enable to the Credit in offline mode
 * BZ23359              041017    Gift cards can't be swiped at screen
 * BZ23788              051017    [Payments][Eigen] Send call confirm instead of "reversal" for completed authorizations
 * BZ24017              161017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24019              161017    [Technical issue] - Empty method
 * BZ24537              171117    [Payment] Gift cards do not partial auth, auto decline if there is not enough balance on the card
 * BZ24549              201117    Cannot complete manual auth for EMV and MSR credit cards in offline mode
 * BZ27530              101118    [Prod] Customer "Double Charged" Issue
 * BZ47123              050122    [PROD] Order Service Token Error
 *===================================================================
 */

package caw.tender.impl.mira;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;

import MiraServJava.MiraServJavaException;
import caw.pos.common.*;
import caw.tender.impl.mira.request.CawMiraRequest;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawCardType;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.ResponseCode;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.SendRequestType;

import dtv.data2.access.DataFactory;
import dtv.hardware.auth.UserCancelledException;
import dtv.i18n.*;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.scope.OperationDefaultScope;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.assistance.ITrainingModeHelper;
import dtv.pos.pricing.discount.type.DiscountApplicationMethod;
import dtv.pos.register.type.LineItemType;
import dtv.pos.ui.text.TextFieldInputType;
import dtv.tenderauth.*;
import dtv.tenderauth.config.AuthFailedActionTypesConfig;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.AbstractAuthProcess;
import dtv.tenderauth.impl.event.AuthSuccessResponse;
import dtv.tenderauth.impl.event.AuthTenderFailedResponse;
import dtv.util.*;
import dtv.util.config.*;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.*;

@SuppressWarnings("deprecation")
@Configurable
public class CawMiraAuthProcess extends AbstractAuthProcess {

    private static Boolean                        isValidateReloadAmount              = Boolean.FALSE;

    /**
     * 
     */
    private static final String                   PARTIAL_APPROVAL                    = "PARTIAL_APPROVAL";

    /**
     * 
     */
    private static final String                   AUTH_NUMBER                         = "authNumber";

    /**
     * 
     */
    private static final String                   AMOUNT                              = "amount";

    /**
     * 
     */
    private static final String                   AUTHORIZED_AMOUNT                   = "AUTHORIZED_AMOUNT";

    /**
     * 
     */
    private static final String                   PARTIAL_CREDIT_REQUEST_AMOUNT       = "PartialCreditRequestAmount";

    /**
     * 
     */
    private static final String                   MANUAL_AUTH                         = "MANUAL_AUTH";

    /**
     * 
     */
    private static final String                   ALLOW_NEGATIVE                      = "allowNegative";

    /**
     * 
     */
    private static final String                   OFFLINE_CANT_PROCESS_TYPE           = "OFFLINE_CANT_PROCESS_TYPE";

    /**
     * 
     */
    private static final String                   ACTION_GROUP                        = "ActionGroup";

    /**
     * 
     */
    private static final String                   CARD_NUM_ERROR                      = "CARD_NUM_ERROR";

    /**
     * 
     */
    private static final String                   USER_CANCEL                         = "USER_CANCEL";

    private ConcurrentLinkedQueue<CawMiraRequest> requestQueue;

    private CawMiraRequest                        request_;

    private CustomerInteractionQueueThread        interactionThread;

    @Inject
    private TransactionScope                      _transactionScope;

    @Inject
    private OperationDefaultScope                 _defaultScope;

    @Inject
    private ITrainingModeHelper                   _trainingModeHelper;

    private boolean                               isManualAuthAmountEditable_;

    private String                                manualAuthInputFormatterType_       = FormatterType.SIMPLE.toString();

    private final Properties                      manualAuthInputFormatterProperties_ = new Properties();

    private boolean                               showExpirationDate_                 = getDefaultShowExpirationDate();

    private boolean                               showAccountNumber_                  = getDefaultShowAccountNumber();

    private boolean                               partialApprovals_                   = false;

    private boolean                               trackBalance_                       = false;

    private boolean                               mustManualAuthAmountMatch_;

    private int                                   manualAuthMinimumLength_            = 1;

    private int                                   manualAuthMaximumLength_            = 30;

    private final Set<String>                     blockedAuthNumbers_                 = new HashSet<String>();

    private Pattern                               manualAuthRegEx_                    = null;

    private boolean                               isVoidHandledLocally_               = false;

    private boolean                               isNegativeAmountHandledLocally_     = false;

    private static final Logger                   logger_                             = Logger
            .getLogger(CawMiraAuthProcess.class);

    private static final Logger                   adminLogger_                        = Logger
            .getLogger("dtv.xstore.comm.paysys");

    public CawMiraAuthProcess() {

        super();
        InjectionHammer.forceAtInjectProcessing(this);

        requestQueue = new ConcurrentLinkedQueue<CawMiraRequest>();
        interactionThread = null;
    }

    /** {@inheritDoc} */
    /* (non-Javadoc)
     * @see dtv.tenderauth.IAuthProcess#setExecutor(java.util.concurrent.ExecutorService)
     */
    @Override
    public void setExecutor(ExecutorService argParamExecutorService) {

    }

    /** {@inheritDoc} */
    /* (non-Javadoc)
     * @see dtv.tenderauth.impl.AbstractAuthProcess#cancelRequest(dtv.tenderauth.IAuthRequest)
     */
    @Override
    public void cancelRequest(IAuthRequest argRequest) {

        super.getAuthCommunicator().abortCommunications();

        IAuthorizableLineItem line = ((ITenderAuthRequest) argRequest).getLineItem();

        if ((line != null) && (line.getAdjudicationCode() == null)) {
            line.setAdjudicationCode(getAbortedAuthSuccessAdjucationCode());
        }
    }

    /** {@inheritDoc} */
    /* (non-Javadoc)
     * @see dtv.tenderauth.impl.AbstractAuthProcess#processRequest(dtv.tenderauth.IAuthRequest)
     */
    @Override
    public void processRequest(IAuthRequest argRequest) {

        if (argRequest == null || !(argRequest instanceof CawMiraRequest)) {
            throw new NullPointerException("Request is null or Request type is not compitable");
        }
        //addRequestToAttributeModel(argRequest);
        request_ = (CawMiraRequest) argRequest;
        request_.setTransactionScope(_transactionScope);
        request_.setDefaultScope(_defaultScope);
        IAuthResponse response = null;
        // execute request immediately
        if (SendRequestType.ONE_THREAD.equals(request_.getSendType())) {
            response = doProcess(request_);
            processFailResponse(response, request_);
            argRequest.addResponse(response, request_.isThrowEvent());
        } else { // put request into queue
            /*BEGIN BZ47123*/
            if(!CawConstants.CAW_DISPLAY_CUSTOMER.equals(request_.getRequestType().getName())
                    || (CawConstants.CAW_DISPLAY_CUSTOMER.equals(request_.getRequestType().getName()) 
                            && _transactionScope.getValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG) == null)) {
            addRequest(request_);
        }
            /*END BZ47123*/
    }
    }

    /**
     * @param argResponse
     */
    private void processFailResponse(IAuthResponse argResponse, IAuthRequest argRequest) {

        if (argResponse instanceof CawMiraResponse && !argResponse.isSuccess()) {
            List<String> messageIds = new ArrayList<String>();
            messageIds.addAll(Arrays.asList(argRequest.getMessageKeys(argResponse)));
            messageIds.add(getUnknownResponseMessageId());
            argResponse.setMessage(getMessage(argResponse, messageIds));
            getAuthFailedActions(argResponse);
        }
    }

    /**
     * Call communicator to send request to MIRA
     * @param argRequest
     * @return
     */
    public IAuthResponse doProcess(CawMiraRequest argRequest) {

        // send last_tran to check the previous transaction is success or not only for capture, credit,  
        if (CawMiraUtil.isAuthRequest(argRequest)) {
            //Saves off the current state of the transaction into a temporary store.
            IPosTransaction tran = _transactionScope.getTransaction();
            if (!_trainingModeHelper.isTrainingMode() && tran != null) {
                TransactionHelper.saveTransactionToTempStorage(tran);
            }

        }

        IAuthResponse cawResponse = null;
        argRequest.prepRequest();

        if (argRequest.getMoreAuthInfo() != null && !isManualSuccessBefore(argRequest)) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.getClass().getName()).append(".handleMoreAuthInfoResponse(");
            appendAuthInfo(sb, argRequest.getMoreAuthInfo());
            sb.append(")");
            logger_.info(sb);
            cawResponse = handleMoreAuthInfoResponse(argRequest);
        } else {
            if (!(isValidRequest(argRequest))) {
                logger_.warn(new StringBuilder().append("invalid request [").append(argRequest).append("] for ")
                        .append(getAuthMethodCode()).toString());
                cawResponse = handleException(argRequest);
            } else if (isOffline()) {
                logger_.info(new StringBuilder().append(super.getClass().getName()).append(".handleOffline")
                        .toString());
                argRequest.setProcessLastTrans(true);
                cawResponse = handleOffline(argRequest);
            } else {
                logger_.info(new StringBuilder().append(super.getClass().getName()).append(".handleOnline").toString());
                cawResponse = handleOnline(argRequest);
            }
        }
        logger_.info(new StringBuilder().append(super.getClass().getName()).append("->response::")
                .append(toLogString(cawResponse)).toString());

        return cawResponse;
    }

    /**
     * @param argRequest
     * @return
     */
    private boolean isManualSuccessBefore(ITenderAuthRequest argRequest) {

        for (IAuthResponse response : argRequest.getResponses()) {
            if (response instanceof AuthSuccessResponse && response.isSuccess()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleOnline(CawMiraRequest argRequest) {

        IAuthResponse response = null;
        try {
            logger_.info(new StringBuilder().append(super.getClass().getName()).append(".handleOnline->sendRequest")
                    .toString());
            response = getAuthCommunicator().sendRequest(argRequest);

            //handle pwc timeout flow and customer click X button (cancel button)
            if (response == null || (ResponseCode.DEVICE_TIME_OUT.toString().equals(response.getResponseCode()))) {
                response = handleDeviceTimeOut(response, argRequest);
            }

            if (response.getResponseCode() != null
                    && response.getResponseCode().contains(ResponseCode.USER_CANCEL.toString())) {
                _defaultScope.setValue(CawValueKeys.IS_USER_CANCEL, true);
                return handleUserCancel(argRequest);
            }
            return response;
        } catch (ReceiveTimeoutException ex) {
            getAuthLog().warn(new StringBuilder().append("Timeout waiting for response: ").append(ex).toString());
            adminLogger_.error(new StringBuilder().append("Timeout Waiting For Response: ").append(ex).toString());
            argRequest.setProcessLastTrans(true);
            return handleOffline(argRequest);
        } catch (OfflineException ex) {
            getAuthLog().warn(new StringBuilder().append("Host offline: ").append(ex).toString());
            adminLogger_.error(new StringBuilder().append("Payment Systems Host Offline: ").append(ex).toString());
            argRequest.setProcessLastTrans(true);
            if (response == null) {
                return handleOffline(argRequest);
            }
            return response;
        } catch (UserCancelledException ex) {
            getAuthLog().warn(new StringBuilder().append("Host offline: ").append(ex).toString());
            return handleUserCancel(argRequest);
        }
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleOffline(ITenderAuthRequest argRequest) {

        logger_.info(new StringBuilder().append(super.getClass().getName()).append(".getFailedResponse(offline)")
                .toString());
        return getFailedResponse(argRequest, argRequest, getMessageKeyOffline(argRequest));
    }

    /**
     * @param argResponse
     * @param argRequest
     * @return
     */
    private IAuthResponse handleDeviceTimeOut(IAuthResponse argResponse, CawMiraRequest argRequest) {

        return handleOffline(argRequest);
    }

    /**
     * Add request into queue
     * @param request
     */
    protected void addRequest(CawMiraRequest request) {

        requestQueue.offer(request);
        if (interactionThread == null) {
            interactionThread = new CustomerInteractionQueueThread();
            interactionThread.start();
        }
    }

    /**
     * Create failed response
     * @param argRequest
     * @param argMessageTarget
     * @param argMessageKey
     * @return
     */
    protected IAuthResponse getFailedResponse(ITenderAuthRequest argRequest, Object argMessageTarget,
            String[] argMessageKey) {

        IFormattable message = getMessage(argMessageTarget, argMessageKey);
        IAuthResponse response = new AuthTenderFailedResponse(this, argRequest, message);
        AuthFailedActionTypesConfig c = getAuthFailedActionTypesConfig(argMessageKey);
        AuthFailedActionType[] availableActions = getAuthFailedActionTypes(c, response);
        response.setAvailableActions(availableActions);
        response.setDataActionGroup(c.getDataActionGroupKey());
        return response;
    }

    /**
     * Get Auth Failed Actions
     * @param response
     */
    protected void getAuthFailedActions(IAuthResponse response) {

        String responseCode = response.getResponseCode();
        AuthFailedActionTypesConfig defaultConfig = getAuthFailedActionTypesConfig(responseCode);
        AuthFailedActionType[] availableActions = getAuthFailedActionTypes(defaultConfig, response);
        response.setAvailableActions(availableActions);

        if (USER_CANCEL.equals(responseCode) || CARD_NUM_ERROR.equals(responseCode)) {
            AuthFailedActionTypesConfig c = new AuthFailedActionTypesConfig();
            c.setConfigObject(ACTION_GROUP, new StringConfig(responseCode));
            response.setDataActionGroup(c.getDataActionGroupKey());
        } else if (OFFLINE_CANT_PROCESS_TYPE.equals(responseCode)) {
            AuthFailedActionTypesConfig c = new AuthFailedActionTypesConfig();
            c.setConfigObject(ACTION_GROUP, new StringConfig(responseCode));
            response.setDataActionGroup(c.getDataActionGroupKey());
        } else {
            response.setDataActionGroup(defaultConfig.getDataActionGroupKey());
        }
    }

    /**
     * Get default unknown message id.
     * @return
     */
    protected String getUnknownResponseMessageId() {

        return "MESSAGE_CODE_OTHER";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IAuthRequest getManualAuthInfo(IAuthRequest argRequest) {

        IFormattable message = getMessage(argRequest, getMessageKeyManual(argRequest));

        IAuthInfo manualAuthInfo = getManualAuthInfoObject(argRequest, message);
        argRequest.setMoreAuthInfo(manualAuthInfo);
        return argRequest;
    }

    protected IAuthInfo getManualAuthInfoObject(IAuthRequest argRequest, IFormattable argMessage) {

        IAuthInfoField[] infoFields = getManualAuthInfoFields(argRequest);
        IAuthInputField[] inputFields = getManualAuthInputFields(argRequest);

        return AuthInfo.forManual(argMessage, infoFields, inputFields);
    }

    protected IAuthInfoField[] getManualAuthInfoFields(IAuthRequest argRequest) {

        String tenderId = null;
        if (argRequest.getLineItem() instanceof ITenderLineItem) {
            ITenderLineItem tenderLine = (ITenderLineItem) argRequest.getLineItem();
            tenderId = tenderLine.getTenderId();
        }

        if (tenderId == null) {
            return null;
        }

        List<AuthInfoField> fields = new LinkedList<AuthInfoField>();

        if (tenderId.equalsIgnoreCase(CawCardType.DISCOVER)) {
            IResourceFormattable authCreditDISCOVEROffline = (IResourceFormattable) FF
                    .getTranslatable("_authCreditDISCOVEROffline");
            authCreditDISCOVEROffline.setResourceBundleName("dtv.pos.i18n.phone");
            if (authCreditDISCOVEROffline != IFormattable.EMPTY) {
                fields.add(new AuthInfoField("callForAuth", FF.getTranslatable("_authManualCallForAuth"),
                        authCreditDISCOVEROffline));
            }
        } else if (tenderId.equalsIgnoreCase(CawCardType.MASTERCARD) || tenderId.equalsIgnoreCase(CawCardType.VISA)
                || tenderId.equalsIgnoreCase(CawCardType.JCB)) {
            IResourceFormattable authCreditMasterCardOffline = (IResourceFormattable) FF
                    .getTranslatable("_authCreditCallCenter");
            authCreditMasterCardOffline.setResourceBundleName("dtv.pos.i18n.phone");
            if (authCreditMasterCardOffline != IFormattable.EMPTY) {
                fields.add(new AuthInfoField("callForAuth", FF.getTranslatable("_authManualCallForAuth"),
                        authCreditMasterCardOffline));
            }
        } else if (tenderId.equalsIgnoreCase(CawCardType.AMEX)) {
            IResourceFormattable authCreditAMEXOffline = (IResourceFormattable) FF
                    .getTranslatable("_authCreditAMEXOffline");
            authCreditAMEXOffline.setResourceBundleName("dtv.pos.i18n.phone");
            if (authCreditAMEXOffline != IFormattable.EMPTY) {
                fields.add(new AuthInfoField("callForAuth", FF.getTranslatable("_authManualCallForAuth"),
                        authCreditAMEXOffline));
            }
        }
        IResourceFormattable authManualMerchantNumber = (IResourceFormattable) FF
                .getTranslatable("_authManualMerchantNumber");
        authManualMerchantNumber.setResourceBundleName("dtv.pos.i18n.phone");
        if (authManualMerchantNumber != IFormattable.EMPTY) {
            fields.add(new AuthInfoField("merchantNumber", FF.getTranslatable("_authManualMerchantNumber"),
                    authManualMerchantNumber));
        }

        if (!(isManualAuthAmountEditable())) {
            BigDecimal amount = getAmount(argRequest);
            if (amount != null) {
                fields.add(new AuthInfoField(AMOUNT, FF.getTranslatable("_authManualAmount"),
                        FF.getSimpleFormattable(amount, FormatterType.MONEY)));
            }

        }

        return (fields.toArray(new IAuthInfoField[fields.size()]));
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthInputField[] getManualAuthInputFields(IAuthRequest argRequest) {

        List<AuthInputField> fields = new LinkedList<AuthInputField>();

        if (isManualAuthAmountEditable()) {
            Properties formatterSettings = new Properties();
            formatterSettings.setProperty(ALLOW_NEGATIVE, Boolean.FALSE.toString());
            AuthInputField amountInputField = new AuthInputField(AMOUNT, FF.getTranslatable("_authManualAmount"),
                    TextFieldInputType.MONEY.toString(), formatterSettings);

            IAuthorizableLineItem lineItem = argRequest.getLineItem();
            BigDecimal amount = NumberUtils.nonNull(lineItem.getAmount()).abs();
            amountInputField.setValue(amount);
            fields.add(amountInputField);
        }
        fields.add(new AuthInputField(AUTH_NUMBER, FF.getTranslatable("_authManualAuthNumber"),
                getManualAuthNumInFieldFormatterType(), getManualAuthNumInFieldFormatProp()));

        return (fields.toArray(new IAuthInputField[fields.size()]));
    }

    /**
     * @param argAuthRequest
     * @return
     */
    protected String getAccountNumber(IAuthRequest argAuthRequest) {

        IAuthorizableLineItem lineItem = argAuthRequest.getLineItem();
        if (lineItem instanceof ICreditDebitTenderLineItem) {
            return ((ICreditDebitTenderLineItem) lineItem).getAccountNumber();
        }
        if (lineItem instanceof ICheckTenderLineItem) {
            return ((ICheckTenderLineItem) lineItem).getCheckAccountNumber();
        }

        return lineItem.getSerialNumber();
    }

    /**
     * @param argRequest
     * @return
     */
    protected IFormattable getAuthorizationResponse(IAuthRequest argRequest) {

        if (argRequest.getResponses().length > 0) {
            IAuthResponse lastResponse = argRequest.getResponses()[argRequest.getResponses().length - 1];
            if (lastResponse instanceof CawMiraResponse) {
                CawMiraResponse response = (CawMiraResponse) lastResponse;
                return FF.getLiteral(response.getResponseText());
            }
        }
        return null;
    }

    /**
     * @param argAuthRequest
     * @return
     */
    protected String getTransitNumber(IAuthRequest argAuthRequest) {

        IAuthorizableLineItem lineItem = argAuthRequest.getLineItem();
        return ((lineItem instanceof ICheckTenderLineItem) ? ((ICheckTenderLineItem) lineItem).getBankId() : null);
    }

    /**
     * @param argAccountNumber
     * @return
     */
    protected boolean getShowAccountNumber(String argAccountNumber) {

        if (argAccountNumber == null) {
            return false;
        }
        return this.showAccountNumber_;
    }

    /**
     * @param argAuthRequest
     * @return
     */
    protected String getCheckNumber(IAuthRequest argAuthRequest) {

        IAuthorizableLineItem lineItem = argAuthRequest.getLineItem();
        return ((lineItem instanceof ICheckTenderLineItem) ? ((ICheckTenderLineItem) lineItem).getCheckSequenceNumber()
                : null);
    }

    /**
     * @return
     */
    protected boolean getDefaultShowAccountNumber() {

        return true;
    }

    /**
     * @return
     */
    protected boolean getDefaultShowExpirationDate() {

        return true;
    }

    /**
     * @param argExpirationDate
     * @return
     */
    protected boolean getShowExpirationDate(Date argExpirationDate) {

        if (argExpirationDate == null) {
            return false;
        }
        return this.showExpirationDate_;
    }

    /**
     * @param argAuthRequest
     * @return
     */
    protected Date getExpirationDate(IAuthRequest argAuthRequest) {

        IAuthorizableLineItem lineItem = argAuthRequest.getLineItem();
        return ((lineItem instanceof ICreditDebitTenderLineItem)
                ? ((ICreditDebitTenderLineItem) lineItem).getExpirationDate()
                : null);
    }

    /**
     * @param argAuthRequest
     * @return
     */
    protected BigDecimal getAmount(IAuthRequest argAuthRequest) {

        return argAuthRequest.getLineItem().getAmount();
    }

    /**
     * @return
     */
    protected Properties getManualAuthNumInFieldFormatProp() {

        return new Properties(this.manualAuthInputFormatterProperties_);
    }

    /**
     * @return
     */
    protected String getManualAuthNumInFieldFormatterType() {

        return this.manualAuthInputFormatterType_;
    }

    /**
     * @return
     */
    protected boolean isManualAuthAmountEditable() {

        return this.isManualAuthAmountEditable_;
    }

    /**
     * @param argRequest
     * @return
     */
    protected String[] getMessageKeyTimeout(IAuthRequest argRequest) {

        return getMessageKey(argRequest, "TIMEOUT");
    }

    /**
     * @param argRequest
     * @return
     */
    protected String[] getMessageKeyCardNumError(IAuthRequest argRequest) {

        return getMessageKey(argRequest, "TIMEOUT");
    }

    /**
     * @param sb
     * @param authInfo
     */
    protected void appendAuthInfo(StringBuilder sb, IAuthInfo authInfo) {

        appendNonNull(sb, "type", authInfo.getType());
        appendNonNull(sb, "msg", authInfo.getMessage());
        IAuthInfoField[] infoFields = authInfo.getInfoFields();

        if ((infoFields != null) && (infoFields.length > 0)) {
            sb.append("infoFields=[");
            for (IAuthInfoField f : infoFields) {
                sb.append(safeToString(f.getLabel()));
                sb.append(":");
                sb.append(safeToString(f.getValue()));
            }
            sb.append("];");
        }
        IAuthInputField[] inputFields = authInfo.getInputFields();
        if ((infoFields != null) && (infoFields.length > 0)) {
            sb.append("infoFields=[");
            for (IAuthInputField f : inputFields) {
                sb.append(safeToString(f.getFieldKey()));
                sb.append("(");
                sb.append(safeToString(f.getLabel()));
                sb.append(")=");
                sb.append(safeToString(f.getValue()));
            }
            sb.append("]");
        }
        sb.append("]");
    }

    /**
     * @param sb
     * @param argTag
     * @param argValue
     */
    protected void appendNonNull(StringBuilder sb, String argTag, Object argValue) {

        if (argValue == null) {
            return;
        }
        sb.append(";");
        sb.append(argTag);
        sb.append("=");
        sb.append(safeToString(argValue));
    }

    /**
     * @param o
     * @return
     */
    protected String safeToString(Object o) {

        if (o instanceof IFormattable) {
            return ((IFormattable) o).toString(OutputContextType.LOG);
        }
        return String.valueOf(o);
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleMoreAuthInfoResponse(CawMiraRequest argRequest) {

        IAuthInfo moreAuthInfo = argRequest.getMoreAuthInfo();

        //Source code for Bug #16479
        if (MANUAL_AUTH.equals(moreAuthInfo.getType())) {
            IAuthResponse manualResponse = handleManual(argRequest);
            try {
                if (!manualResponse.isSuccess()) {
                    return manualResponse;
                }
                argRequest.setCommand(CawMiraCommand.AUTHORIZATION_BY_PHONE);//BZ23585
                IAuthResponse onlineResponse = handleOnline(argRequest);
                if (onlineResponse.isSuccess() && isValidTenderInfo(argRequest)) {
                    return manualResponse;
                } else {
                    return onlineResponse;
                }
            } catch (Exception ex) {
                logger_.debug("handleMoreAuthInfoResponse" + ex.getMessage());
                return handleException(argRequest);
            }
        }
        return handleException(argRequest);
    }

    /**
     * @param argRequest
     * @return
     */
    private boolean isValidTenderInfo(CawMiraRequest argRequest) {

        //source for bug BZ#16479
        IAuthorizableLineItem tenderLine = argRequest.getLineItem();
        if (tenderLine != null && !StringUtils.isEmpty(tenderLine.getAuthorizationCode())) {
            return true;
        }

        return false;
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleManual(ITenderAuthRequest argRequest) {

        Object v = getManualAuthNumber(argRequest.getMoreAuthInfo());

        if (validAuthNumber(argRequest, v)) {
            Date startTimestamp = DateUtils.getNewDate();

            IAuthorizableLineItem lineItem = argRequest.getLineItem();
            BigDecimal originalAmount = (lineItem.getAmount() != null) ? lineItem.getAmount().abs() : null;
            BigDecimal amount = originalAmount;
            if (isManualAuthAmountEditable()) {
                amount = getManualAuthAmount(argRequest.getMoreAuthInfo());
                if (amount == null) {
                    return getFailedResponse(argRequest, argRequest, new String[] { "INVALID_AUTH_AMOUNT" });
                }

                if (mustManualAuthAmountMatch()) {
                    BigDecimal manuallyAuthorizedAmount = getManualAuthAmount(argRequest.getMoreAuthInfo());
                    if (!(NumberUtils.equivalent(originalAmount, manuallyAuthorizedAmount))) {
                        return getFailedResponse(argRequest, argRequest, new String[] { "MISMATCH_AUTH_AMOUNT" });
                    }

                }

                if (originalAmount != null) {
                    amount = originalAmount.min(amount);
                }
                setAuthorizedAmount(lineItem, amount);
            }

            updateLineForManual(lineItem, v.toString());

            IAuthResponse response = null;
            try {
                response = storeManualAuthForForwarding(argRequest);
            } catch (Exception ex) {
                logger_.error("CAUGHT EXCEPTION", ex);
                return handleException(argRequest);
            }
            //clearTracksForManual(lineItem);

            String authorizationCode = lineItem.getAuthorizationCode();
            String adjudicationCode = lineItem.getAdjudicationCode();
            if (response == null) {
                response = argRequest
                        .getSuccessfulManualAuthResponse(this, amount, authorizationCode, adjudicationCode);
            } else if (!(response.isSuccess())) {
                List<String> ids = new ArrayList<String>();
                ids.addAll(Arrays.asList(argRequest.getMessageKeys(response)));
                ids.add(getUnknownResponseMessageId());
                response.setMessage(getMessage(response, ids));
                getAuthFailedActions(response);
            }
            response.setStartTimestamp(startTimestamp);
            response.setEndTimestamp(DateUtils.getNewDate());

            updateLineAmount(argRequest, response, lineItem);

            return response;
        }

        logger_.info(new StringBuilder().append(super.getClass().getName()).append(".handleInvalidManualAuthNumber")
                .toString());
        return handleInvalidManualAuthNumber(argRequest, StringUtils.nonNull(v));
    }

    /**
     * @param argRequest
     * @param argAuthNumber
     * @return
     */
    protected IAuthResponse handleInvalidManualAuthNumber(ITenderAuthRequest argRequest, String argAuthNumber) {

        return getFailedResponse(argRequest, argAuthNumber, getMessageKeyInvalidAuthNumber(argRequest));
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLineItem
     */
    protected void updateLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IAuthorizableLineItem argLineItem) {

        if (partialApprovals()) {
            BigDecimal requestedAmount = argRequest.getAmount();
            BigDecimal approvedAmount = argResponse.getAmount();
            if (NumberUtils.isGreaterThan(requestedAmount, approvedAmount)) {
                setLineAmount(argRequest, argResponse, argLineItem, approvedAmount);
                setPartialCreditProperty(argLineItem, requestedAmount);
            }
        }
        if (getTrackBalance()) {
            BigDecimal balance = argResponse.getBalance();
            if (balance != null)
                if (argLineItem instanceof IVoucherLineItem) {
                    ((IVoucherLineItem) argLineItem).setUnspentBalanceAmount(balance);
                } else
                    argLineItem.setStringProperty(getReportBalancePropertyName(), balance.toString());
        }
    }

    /**
     * @return
     */
    protected boolean partialApprovals() {

        return this.partialApprovals_;
    }

    /**
     * @return
     */
    protected String getReportBalancePropertyName() {

        return "REPORTED_BALANCE";
    }

    /**
     * @return
     */
    protected boolean getTrackBalance() {

        return this.trackBalance_;
    }

    /**
     * @param argLine
     * @param argRequestAmount
     */
    protected void setPartialCreditProperty(IAuthorizableLineItem argLine, BigDecimal argRequestAmount) {

        RetailTransactionLineItemPropertyId id = new RetailTransactionLineItemPropertyId();
        id.setOrganizationId(Long.valueOf(argLine.getOrganizationId()));
        id.setRetailLocationId(Long.valueOf(argLine.getRetailLocationId()));
        id.setWorkstationId(Long.valueOf(argLine.getWorkstationId()));
        id.setBusinessDate(argLine.getBusinessDate());
        id.setTransactionSequence(Long.valueOf(argLine.getTransactionSequence()));
        id.setRetailTransactionLineItemSequence(Integer.valueOf(argLine.getRetailTransactionLineItemSequence()));
        id.setPropertyCode(PARTIAL_CREDIT_REQUEST_AMOUNT);

        IRetailTransactionLineItemProperty property = DataFactory
                .createObject(id, IRetailTransactionLineItemProperty.class);
        property.setDecimalValue(argRequestAmount);
        argLine.addRetailTransactionLineItemProperty(property);
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IAuthorizableLineItem argLine, BigDecimal argValue) {

        if (argLine instanceof IVoucherLineItem) {
            setVoucherLineAmount(argRequest, argResponse, (IVoucherLineItem) argLine, argValue);
        } else if (argLine instanceof ITenderLineItem) {
            setTenderLineAmount(argRequest, argResponse, (ITenderLineItem) argLine, argValue);
        } else
            logger_.warn(new StringBuilder().append("unable to set amount on ")
                    .append(ObjectUtils.getClassNameFromObject(argLine)).toString());
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setVoucherLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IVoucherLineItem argLine, BigDecimal argValue) {

        if (argLine instanceof IVoucherRedeemedLineItem) {
            setVoucherRedeemedLineAmount(argRequest, argResponse, (IVoucherRedeemedLineItem) argLine, argValue);
        } else if (argLine instanceof IVoucherSaleLineItem) {
            setVoucherSoldLineAmount(argRequest, argResponse, (IVoucherSaleLineItem) argLine, argValue);
        } else
            argLine.setFaceValueAmount(argValue);
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setVoucherRedeemedLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IVoucherRedeemedLineItem argLine, BigDecimal argValue) {

        if (argLine instanceof IVoucherDiscountLineItem) {
            setVoucherDiscountLineAmount(argRequest, argResponse, (IVoucherDiscountLineItem) argLine, argValue);
        } else if (argLine instanceof IVoucherTenderLineItem) {
            setTenderLineAmount(argRequest, argResponse, (ITenderLineItem) argLine, argValue);
        } else
            argLine.setAmount(argValue);
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setTenderLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            ITenderLineItem argLine, BigDecimal argValue) {

        String tenderStatusCode = argLine.getTenderStatusCode();
        BigDecimal tmp = argValue;
        if ((TenderStatus.CHANGE.equals(tenderStatusCode)) || (TenderStatus.REFUND.equals(tenderStatusCode))) {
            tmp = argValue.negate();
        }

        argLine.setAmount(tmp);
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setVoucherDiscountLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IVoucherDiscountLineItem argLine, BigDecimal argValue) {

        argLine.setFaceValueAmount(argValue);

        IDiscount discount = argLine.getLineItemDiscount();
        if (DiscountApplicationMethod.LINE_ITEM.getName().equals(discount.getApplicationMethodCode())) {
            List<ISaleReturnLineItem> items = argLine.getParentTransaction()
                    .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);

            for (ISaleReturnLineItem item : items) {
                if (item.getVoid()) {
                    continue;
                }
                List<IRetailPriceModifier> mods = item
                        .getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());

                for (IRetailPriceModifier mod : mods) {
                    if (mod.getVoid()) {
                        continue;
                    }
                    if (mod.getDiscount().equals(discount)) {
                        mod.setAmount(argValue);
                        return;
                    }
                }
            }
        }
    }

    /**
     * @param argRequest
     * @param argResponse
     * @param argLine
     * @param argValue
     */
    protected void setVoucherSoldLineAmount(ITenderAuthRequest argRequest, IAuthResponse argResponse,
            IVoucherSaleLineItem argLine, BigDecimal argValue) {

        IRetailPriceModifier modifier;
        try {
            modifier = DataFactory.createObject(IRetailPriceModifier.class);
        } catch (Exception ex) {
            throw new ReflectionException(ex);
        }
        modifier.setPriceChangeAmount(argValue);
        modifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.PRICE_OVERRIDE.getName());
        modifier.setPriceChangeReasonCode(AUTHORIZED_AMOUNT);

        argLine.addRetailPriceModifier(modifier);
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleException(ITenderAuthRequest argRequest) {

        return getFailedResponse(argRequest, argRequest, getMessageKeyException(argRequest));
    }

    /**
     * @param argLineItem
     * @param argAuthorizationNumber
     */
    protected void updateLineForManual(IAuthorizableLineItem argLineItem, String argAuthorizationNumber) {

        argLineItem.setAdjudicationCode(getManualAuthSuccessAdjucationCode());
        argLineItem.setAuthorizationMethodCode(getAuthMethodCode());
        argLineItem.setAuthorizationCode(argAuthorizationNumber);
    }

    /**
     * @param argLineItem
     * @param argAmount
     */
    protected void setAuthorizedAmount(IAuthorizableLineItem argLineItem, BigDecimal argAmount) {

        if (argLineItem instanceof IAuthorizableTenderLineItem) {
            IAuthorizableTenderLineItem tenderLine = (IAuthorizableTenderLineItem) argLineItem;
            tenderLine.setAmount(argAmount);
        } else if (argLineItem instanceof IVoucherLineItem) {
            IVoucherLineItem tenderLine = (IVoucherLineItem) argLineItem;
            tenderLine.setFaceValueAmount(argAmount);
            tenderLine.setUnspentBalanceAmount(argAmount);
        } else {
            logger_.error(new StringBuilder().append("unable to set the amount on line of type ")
                    .append(ObjectUtils.getClassNameFromObject(argLineItem)).toString());
        }
    }

    /**
     * @return
     */
    protected boolean mustManualAuthAmountMatch() {

        return this.mustManualAuthAmountMatch_;
    }

    /**
     * @param argManualAuthInfo
     * @return
     */
    protected BigDecimal getManualAuthAmount(IAuthInfo argManualAuthInfo) {

        return (argManualAuthInfo.getInputFieldValue(AMOUNT, BigDecimal.class));
    }

    /**
     * @param argRequest
     * @param argValue
     * @return
     */
    protected boolean validAuthNumber(ITenderAuthRequest argRequest, Object argValue) {

        // Begin BZ24549
        if ((argValue == null) && (this.manualAuthMinimumLength_ > 0)) {
            logger_.debug("manual auth number is null");
            return false;
        }
        // End BZ24549
        String s = "";
        if (argValue != null) {
            s = CawUtilFunction.vString(argValue.toString());
        }
        if (this.blockedAuthNumbers_.contains(s)) {
            if (logger_.isDebugEnabled()) {
                logger_.debug(new StringBuilder().append("manual auth number '").append(s).append("' is blocked")
                        .toString());
            }
            return false;
        }
        if (s.length() < this.manualAuthMinimumLength_) {
            if (logger_.isDebugEnabled()) {
                logger_.debug(new StringBuilder().append("manual auth number '").append(s).append("' is shorter than ")
                        .append(this.manualAuthMinimumLength_).append(" characters").toString());
            }

            return false;
        }
        if (s.length() > this.manualAuthMaximumLength_) {
            if (logger_.isDebugEnabled()) {
                logger_.debug(new StringBuilder().append("manual auth number '").append(s).append("' is longer than ")
                        .append(this.manualAuthMaximumLength_).append(" characters").toString());
            }

            return false;
        }
        if (null == this.manualAuthRegEx_) {
            return true;
        }
        Matcher matcher = this.manualAuthRegEx_.matcher(s);

        return (!(matcher.find()));
    }

    /**
     * @param argManualAuthInfo
     * @return
     */
    protected Object getManualAuthNumber(IAuthInfo argManualAuthInfo) {

        return argManualAuthInfo.getInputFieldValue(AUTH_NUMBER, Object.class);
    }

    /**
     * @param argResponse
     * @return
     */
    protected String toLogString(IAuthResponse argResponse) {

        StringBuilder sb = new StringBuilder();
        // Begin BZ27530
        if (argResponse != null) {
            sb.append(argResponse.getClass().getName());
            appendNonNull(sb, "success", Boolean.valueOf(argResponse.isSuccess()));
            if (argResponse.getAuthorizationCode() != null) {
                appendNonNull(sb, "authCode", argResponse.getAuthorizationCode());
            }

            if (argResponse.getResponseCode() != null) {
                appendNonNull(sb, "responseCode", argResponse.getResponseCode());
            }

            if (argResponse.getAmount() != null) {
                appendNonNull(sb, AMOUNT, argResponse.getAmount());
            }

            if (argResponse.getBalance() != null) {
                appendNonNull(sb, "balance", argResponse.getBalance());
            }

            if (argResponse.getBankReferenceNumber() != null) {
                appendNonNull(sb, "bankRefNbr", argResponse.getBankReferenceNumber());
            }

            if (argResponse.getMessage() != null) {
                appendNonNull(sb, "msg", argResponse.getMessage());
            }

            appendAvailableActions(argResponse, sb);
            appendRequiredInfo(sb, argResponse);

            if (argResponse.getName() != null) {
                appendNonNull(sb, "name", argResponse.getName());
            }

            if (argResponse.getType() != null) {
                appendNonNull(sb, "type", argResponse.getType());
            }
        }
        // End BZ27530
        return sb.toString();
    }

    /**
     * @param argResponse
     * @param sb
     */
    private void appendAvailableActions(IAuthResponse argResponse, StringBuilder sb) {

        AuthFailedActionType[] acts = argResponse.getAvailableActions();

        if ((acts != null) && (acts.length != 0)) {
            sb.append(";actions=[");

            for (AuthFailedActionType act : acts) {
                sb.append(act).append(",");
            }

            sb.setLength(sb.length() - 1);
            sb.append("]");
        }
    }

    /**
     * @param sb
     * @param argResponse
     */
    protected void appendRequiredInfo(StringBuilder sb, IAuthResponse argResponse) {

        IAuthInfo requiredInfo = argResponse.getRequiredInfo();
        if (requiredInfo == null) {
            return;
        }
        sb.append(";requiredInfo=[");
        appendAuthInfo(sb, requiredInfo);
    }

    /**
     * @param argRequest
     * @return
     */
    protected boolean isVoid(ITenderAuthRequest argRequest) {

        AuthRequestType type = argRequest.getRequestType();
        if (type == AuthRequestType.VOID_ACTIVATE) {
            return true;
        }
        if (type == AuthRequestType.VOID_RELOAD) {
            return true;
        }

        return (type != AuthRequestType.VOID_TENDER);
    }

    /**
     * @return
     */
    protected boolean isVoidHandledLocally() {

        return this.isVoidHandledLocally_;
    }

    /**
     * @param argRequest
     * @return
     */
    protected boolean isValidRequest(ITenderAuthRequest argRequest) {

        IAuthorizableLineItem lineItem = argRequest.getLineItem();
        if (lineItem instanceof ICreditDebitTenderLineItem) {
            return true;
        }
        if (lineItem instanceof ITenderLineItem) {
            return true;
        }
        if (lineItem instanceof IVoucherSaleLineItem) {
            return true;
        }
        if (argRequest instanceof CawMiraGiftCardRequest) {
            return true;
        }
        return false;
    }

    /**
     * @param argRequest
     * @return
     */
    protected boolean isAuthorizationTokenNotAvailable(ITenderAuthRequest argRequest) {

        if (!(isTokenizationEnabled())) {
            return (!(StringUtils.isEmpty(null)));
        }
        IAuthorizableLineItem lineItem = argRequest.getLineItem();
        String authToken = (lineItem != null) ? StringUtils.nonNull(lineItem.getAuthorizationToken()) : "";

        return (!(StringUtils.isEmpty(authToken)));
    }

    /**
     * @param argRequest
     * @return
     */
    protected IFormattable getTenderDescription(ITenderAuthRequest argRequest) {

        return FF.getLiteral(argRequest.getTender().getDescription());
    }

    /**
     * @return
     */
    protected boolean isNegativeAmountHandledLocally() {

        return this.isNegativeAmountHandledLocally_;
    }

    /* (non-Javadoc)
     * @see dtv.tenderauth.impl.AbstractAuthProcess#setParameter(dtv.util.config.ParameterConfig)
     */
    @Override
    public void setParameter(ParameterConfig argConfig) {

        String name = argConfig.getName();
        IConfigObject value = argConfig.getValue();
        if ("isManualAuthAmountEditable".equalsIgnoreCase(name)) {
            this.isManualAuthAmountEditable_ = ConfigUtils.toBoolean(value);
        } else if ("manualAuthInput.formatter".equalsIgnoreCase(name)) {
            this.manualAuthInputFormatterType_ = value.toString();
        } else if (name.toLowerCase().startsWith("manualAuthInput.formatter".toLowerCase())) {
            String propName = name.substring("manualAuthInput.formatter".length() + 1);
            this.manualAuthInputFormatterProperties_.put(propName, value.toString());
        } else if ("manualAuthValidation.length.minimum".equalsIgnoreCase(name)) {
            this.manualAuthMinimumLength_ = ConfigUtils.toInt(value);
        } else if ("manualAuthValidation.length.maximum".equalsIgnoreCase(name)) {
            this.manualAuthMaximumLength_ = Math.min(ConfigUtils.toInt(value), 30);
            this.manualAuthInputFormatterProperties_
                    .put("maxCharacters", String.valueOf(this.manualAuthMaximumLength_));
        } else if ("manualAuthValidation.regex".equalsIgnoreCase(name)) {
            this.manualAuthRegEx_ = Pattern.compile(value.toString());
        } else if ("manualAuthValidation.blocked".equalsIgnoreCase(name)) {
            this.blockedAuthNumbers_.add(value.toString());
        } else if ("mustManualAuthAmountMatch".equalsIgnoreCase(name)) {
            this.mustManualAuthAmountMatch_ = ConfigUtils.toBoolean(value);
        }
        /*else if ("repollTimeMillis".equalsIgnoreCase(name)) {
          this.repollTimeMillis_ = ConfigUtils.toInt(value);
        }*/
        else if ("showAccountNumber".equalsIgnoreCase(name)) {
            this.showAccountNumber_ = ConfigUtils.toBoolean(value);
        } else if ("showExpirationDate".equalsIgnoreCase(name)) {
            this.showExpirationDate_ = ConfigUtils.toBoolean(value);
        }

        else if ("partialApprovals".equalsIgnoreCase(name)) {
            this.partialApprovals_ = ConfigUtils.toBoolean(value);
        } else if ("trackBalance".equalsIgnoreCase(name)) {
            this.trackBalance_ = ConfigUtils.toBoolean(value);
        } else if ("isVoidHandledLocally".equalsIgnoreCase(name)) {
            this.isVoidHandledLocally_ = ConfigUtils.toBoolean(value);
        } else if ("isNegativeAmountHandledLocally".equalsIgnoreCase(name)) {
            this.isNegativeAmountHandledLocally_ = ConfigUtils.toBoolean(value);
        }

        super.setParameter(argConfig);
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleLocalNegative(ITenderAuthRequest argRequest) {

        IAuthorizableLineItem lineItem = argRequest.getLineItem();
        String adjucationCode = getReturnFloorAuthAdjudicationCode(argRequest, isOffline());
        lineItem.setAdjudicationCode(adjucationCode);

        return new AuthSuccessResponse(this, argRequest, getAuthMethodCode(), adjucationCode);
    }

    /**
     * @param argResponse
     */
    protected void setApprovedMessage(IAuthResponse argResponse) {

        if (argResponse.getMessage() == null) {
            List<String> messageKeys = new ArrayList<String>();
            messageKeys.addAll(Arrays.asList(argResponse.getRequest().getMessageKeys(argResponse)));

            if ((partialApprovals())
                    && (!NumberUtils.equivalent(argResponse.getAmount(), argResponse.getRequest().getAmount()))) {
                messageKeys.add(getPartialApprovalMessageId());
            }

            IFormattable message = buildMessage(false, argResponse, messageKeys.toArray(new String[0]));

            if (message != null) {
                argResponse.setMessage(message);
            }
        }
    }

    /**
     * @return
     */
    protected String getPartialApprovalMessageId() {

        return PARTIAL_APPROVAL;
    }

    /**
     * @return
     */
    protected boolean supportsSuspending() {

        return false;
    }

    /**
     * @param argLineItem
     * @param argResponse
     */
    protected void copyTokenInformation(IAuthorizableLineItem argLineItem, IAuthResponse argResponse) {

        String authorizationToken = !StringUtils.isEmpty(argResponse.getAuthorizationToken())
                ? argResponse.getAuthorizationToken()
                : null;

        if ((argLineItem != null) && (!StringUtils.isEmpty(authorizationToken)) && (isTokenizationEnabled())
                && ((argLineItem instanceof ICreditDebitTenderLineItem))) {
            argLineItem.setAuthorizationToken(authorizationToken);
            ((ICreditDebitTenderLineItem) argLineItem).clearTokenInformation();
        }
    }

    /**
     * @param argLineItem
     * @param response
     */
    protected void copyBankReferenceNumber(IAuthorizableLineItem argLineItem, IAuthResponse response) {

        String responseBankReferenceNumber = response.getBankReferenceNumber();
        String lineBankReferenceNumber = argLineItem.getBankReferenceNumber();

        if (!StringUtils.isEmpty(responseBankReferenceNumber)) {
            if ((!StringUtils.isEmpty(lineBankReferenceNumber))
                    && (!responseBankReferenceNumber.equals(lineBankReferenceNumber))) {
                logger_.warn("overriding bank reference number from '" + lineBankReferenceNumber + "' to '"
                        + responseBankReferenceNumber + "'");
            }

            argLineItem.setBankReferenceNumber(responseBankReferenceNumber);
        }
    }

    /**
     * @param argRequest
     * @return
     */
    protected IAuthResponse handleUserCancel(ITenderAuthRequest argRequest) {

        return getFailedResponse(argRequest, argRequest, getMessageKeyUserCancel(argRequest));
    }

    /**
     * Returns 
     * @return 
     */
    public ConcurrentLinkedQueue<CawMiraRequest> getRequestQueue() {

        return requestQueue;
    }

    /**
     * Specifies
     * @param argRequestQueue 
     */
    public void setRequestQueue(ConcurrentLinkedQueue<CawMiraRequest> argRequestQueue) {

        requestQueue = argRequestQueue;
    }

    /**
     * @return
     */
    public CawMiraAuthProcess getOuter() {

        return this;
    }

    /* (non-Javadoc)
     * @see dtv.tenderauth.impl.AbstractAuthProcess#disabled()
     */
    @Override
    protected boolean disabled() {

        return false;
    }

    /**
     * Process the request queue
     */
    /**
     *
     */
    protected class CustomerInteractionQueueThread extends Thread {

        CustomerInteractionQueueThread() {

            setDaemon(true);
            setName("CustomerInteractionQueueThread");
        }

        @Override
        public void run() {

            while (true) {
                CawMiraRequest request = requestQueue.poll();
                IAuthResponse response = null;
                IAuthResponse redeemResponse = null;
                if (request != null) {
                    String temp = request.getCommand();
                    redeemResponse = validateRedeemAmount(request);
                    if (redeemResponse != null) {
                        response = redeemResponse;
                    }
                    if (response == null || isValidateReloadAmount) {
                        try {
                            isValidateReloadAmount = Boolean.FALSE;
                            request.setCommand(temp);
                            request.setDefaultScope(_defaultScope);
                            response = CawMiraAuthProcess.this.doProcess(request);
                        } catch (MiraServJavaException ex) {
                            logger_.error("MiraServ Java Exception: " + ex.getMessage());
                        }
                    } else {
                        try {
                            request.setCommand(temp);
                        } catch (MiraServJavaException ex) {
                            logger_.error("MiraServ Java Exception: " + ex.getMessage());
                        }
                    }

                    response = runCashOutFunc(request, response);

                    CawMiraAuthProcess.this.processFailResponse(response, request);
                    //When coming to this step, meaning that the author line item is assigned
                    //all item from the response.

                    // Begin BZ27530
                    if (!CawMiraFormatter.REVERSE_FLAG) {
                        try {
                            // For declined/not completed transactions, must call the confirm()
                            // Reverse() function is called only for a transaction that was say.. approved, but the POS was unable to store the result/print or process the response
                            CawMiraFormatter.miraRequest.Confirm();
                            CawMiraFormatter.REVERSE_FLAG = false;
                        } catch (MiraServJavaException ex) {
                            CawMiraFormatter.miraRequest.Reverse();
                            logger_.error("Error occur when sending the comfirm to Mira server." + ex.getMessage());
                        } catch (IOException ex) {
                            logger_.error("Error occur when sending the comfirm to Mira server." + ex.getMessage());
                        }
                    } else {
                        CawMiraFormatter.miraRequest.Reverse();
                        CawMiraFormatter.REVERSE_FLAG = false;
                    }
                    // End BZ27530

                    request.addResponse(response, request.isThrowEvent());
                }
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException ie) {
                    getAuthLog().warn("CAUGHT InterruptedException : " + ie.getMessage());
                }
            }
        }
    }

    /**
     * BZ 24537: [Payment] Gift cards do not partial auth, auto decline if there is not enough balance on the card
     * @param request
     * @return
     */
    private IAuthResponse validateRedeemAmount(CawMiraRequest request) {

        if (request.getCommand().equalsIgnoreCase(CawMiraCommand.REDEEM)) {
            try {
                request.setCommand(CawMiraCommand.BALANCE_INQUIRY);
            } catch (MiraServJavaException ex) {
                logger_.error("MiraServ Java Exception: " + ex.getMessage());
            }
            IAuthResponse response = CawMiraAuthProcess.this.doProcess(request);
            if (response instanceof CawMiraResponse && response.isSuccess()) {
                BigDecimal strBalance = ((CawMiraResponse) response).getBalance();
                _defaultScope.setValue(CawValueKeys.CURRENT_VOUCHER_BALANCE, strBalance);
                if (strBalance.compareTo(BigDecimal.ZERO) > 0 && request.getAmount().compareTo(strBalance) > 0
                        && request.getLineItem() instanceof ITenderLineItem) {
                    ((ITenderLineItem) request.getLineItem()).setAmount(strBalance);
                    request.setAmount(strBalance);
                }
            } else {
                return response;
            }
        }

        return null;
    }

    private IAuthResponse runCashOutFunc(CawMiraRequest request, IAuthResponse response) {

        if (response != null && response.isSuccess() && request.getCommand().equalsIgnoreCase(CawMiraCommand.CASH_OUT)
                && response.getBalance().compareTo(BigDecimal.ZERO) > 0
                && response.getBalance().compareTo(CawConfigurationMgr.maximumTenderExchangeBalance()) <= 0) {
            try {
                request.setCommand(CawMiraCommand.REDEEM);
                request.setAmount(response.getBalance());
                return CawMiraAuthProcess.this.doProcess(request);
            } catch (MiraServJavaException ex) {
                logger_.error("MiraServ Java Exception: " + ex.getMessage());
            }
        }

        return response;

    }

    /*Begin BZ23698*/
    @Override
    public boolean isManualAuthAllowed(IAuthResponse argResponse) {

        if (argResponse instanceof CawMiraResponse) {
            CawMiraResponse miraResponse = (CawMiraResponse) argResponse;
            if ("R".equalsIgnoreCase(miraResponse.getActionCode())) {
                return true;
            }

        }
        return false;
    }
    /*End BZ23698*/

}
