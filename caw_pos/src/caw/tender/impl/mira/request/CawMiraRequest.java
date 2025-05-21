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
 * BZ24019              161017    [Technical issue] - Empty method
 *== ================================================================
 */

package caw.tender.impl.mira.request;

import java.security.KeyPair;

import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.SendRequestType;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.framework.scope.OperationDefaultScope;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.tenderauth.*;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.AbstractAuthRequest;
import dtv.util.StringUtils;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawMiraRequest
        extends AbstractAuthRequest implements ICreditAuthRequest {

    /**
     * 
     */
    private static final String       MESSAGE_CODE       = "MESSAGE_CODE_";

    /**
     * 
     */
    private static final String       AUTHORIZING        = "AUTHORIZING";

    /**
     * 
     */
    private static final String       REQUEST_TYPE       = "RequestType";

    /**
     * 
     */
    private static final String       SEND_TYPE          = "SendType";

    /**
     * 
     */
    private static final String       IS_THROW_EVENT     = "isThrowEvent";

    private final TenderUsageCodeType tenderUsageCode_;

    private ISaleReturnLineItem       saleReturnItem;

    private IAuthProcess              authProcess;

    private TransactionScope          transactionScope;

    private SendRequestType           sendType           = SendRequestType.ONE_THREAD;

    private int                       entryCode;

    private boolean                   isThrowEvent       = false;

    private boolean                   isProcessLastTrans = false;

    private OperationDefaultScope     defaultScope;

    private String                    customerEmail      = StringUtils.EMPTY;

    private String                    _command           = StringUtils.EMPTY;

    private static final Logger       logger_            = Logger
            .getLogger(CawMiraRequest.class);

    /**
     * Returns 
     * @return 
     */
    public OperationDefaultScope getDefaultScope() {

        return defaultScope;
    }

    /**
     * Specifies
     * @param argDefaultScope 
     */
    public void setDefaultScope(OperationDefaultScope argDefaultScope) {

        defaultScope = argDefaultScope;
    }

    private ITender                         tender_;

    /**
     * The Key generate public key then send to VeriFone device
     */
    private KeyPair                         localKeyPair = null;

    private static final FormattableFactory FF           = FormattableFactory
            .getInstance();

    public CawMiraRequest(AuthRequestType argType,
            IAuthorizableLineItem argLine) {

        this(argType, argLine, null);
    }

    public CawMiraRequest(AuthRequestType argType,
            IAuthorizableLineItem argLine,
            TenderUsageCodeType argTenderUsageCode) {

        super(argType, argLine);
        this.tenderUsageCode_ = argTenderUsageCode;
        tender_ = getTender(argLine);
    }

    /**
     * @param argLine
     * @return
     */
    private ITender getTender(IAuthorizableLineItem argLine) {

        if ((argLine instanceof ITenderLineItem)) {
            return ((ITenderLineItem) argLine).getTender();
        }
        return null;
    }

    public CawMiraResponse getResponse(MiraServJava argResponse) {

        return new CawMiraResponse(authProcess, this,
                authProcess.getAuthMethodCode(), argResponse);
    }

    /** {@inheritDoc} */
    @Override
    public ITender getTender() {

        return tender_;
    }

    /** {@inheritDoc} */
    @Override
    public String getTenderDescription() {

        return getTender().getDescription();
    }

    /** {@inheritDoc} */
    @Override
    public final TenderUsageCodeType getTenderUsageCode() {

        return this.tenderUsageCode_;
    }

    /** {@inheritDoc} */
    @Override
    protected void addingResponse(IAuthResponse argParamIAuthResponse) {

        logger_.info("Do nothing");
    }

    /**
     * Returns 
     * @return 
     */
    public String getCommand() {

        return _command;
    }

    /**
     * Specifies
     * @param command 
     */
    public void setCommand(String command) throws MiraServJavaException {

        _command = command;
    }

    /**
     * Returns 
     * @return 
     */
    public ISaleReturnLineItem getSaleReturnItem() {

        return saleReturnItem;
    }

    /**
     * Specifies
     * @param returnItem 
     */
    public void setSaleReturnItem(ISaleReturnLineItem returnItem) {

        this.saleReturnItem = returnItem;
    }

    /**
     * Returns 
     * @return 
     */
    public IAuthProcess getAuthProcess() {

        return authProcess;
    }

    /**
     * Specifies
     * @param authProcess 
     */
    public void setAuthProcess(IAuthProcess authProcess) {

        this.authProcess = authProcess;
    }

    /**
     * Returns 
     * @return 
     */
    public TransactionScope getTransactionScope() {

        return transactionScope;
    }

    /**
     * Specifies
     * @param transactionScope 
     */
    public void setTransactionScope(TransactionScope transactionScope) {

        this.transactionScope = transactionScope;
    }

    /**
     * Returns 
     * @return 
     */
    public SendRequestType getSendType() {

        return sendType;
    }

    /**
     * Specifies
     * @param sendType 
     */
    public void setSendType(SendRequestType sendType) {

        this.sendType = sendType;
    }

    /**
     * Returns 
     * @return 
     */
    public KeyPair getLocalKeyPair() {

        return localKeyPair;
    }

    /**
     * Specifies
     * @param localKeyPair 
     */
    public void setLocalKeyPair(KeyPair localKeyPair) {

        this.localKeyPair = localKeyPair;
    }

    /**
     * Returns 
     * @return 
     */
    public int getEntryCode() {

        return entryCode;
    }

    /**
     * Specifies
     * @param entryCode 
     */
    public void setEntryCode(int entryCode) {

        this.entryCode = entryCode;
    }

    /**
     * Returns 
     * @return 
     */
    public boolean isThrowEvent() {

        return isThrowEvent;
    }

    /**
     * Specifies
     * @param isThrowEvent 
     */
    public void setThrowEvent(boolean isThrowEvent) {

        this.isThrowEvent = isThrowEvent;
    }

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, Object argValue) {

        if (REQUEST_TYPE.equals(argName)) {
            try {
                setCommand(argValue.toString());
            } catch (MiraServJavaException ex) {
                logger_.error("Cannot set command: " + ex.getMessage());
            }
        } else if (SEND_TYPE.equals(argName)) {
            if (SendRequestType.ONE_THREAD.toString()
                    .equals(argValue.toString())) {
                this.sendType = SendRequestType.ONE_THREAD;
            } else if (SendRequestType.MULTI_THREAD.toString()
                    .equals(argValue.toString())) {
                this.sendType = SendRequestType.MULTI_THREAD;
            }
        } else if (IS_THROW_EVENT.equals(argName)) {
            if (CawEigenConstants.TRUE_BOOLEAN
                    .equalsIgnoreCase(argValue.toString())) {
                this.setThrowEvent(true);
            } else {
                this.setThrowEvent(false);
            }
        } else {
            super.setParameter(argName, argValue);
        }

    }

    /** {@inheritDoc} */
    @Override
    protected String getMessageIdPrefix(IAuthResponse argArgResponse) {

        return MESSAGE_CODE;
    }

    /** {@inheritDoc} */
    @Override
    public IFormattable getMessage(String argMessageId) {

        if (AUTHORIZING.equals(argMessageId)) {
            return getAuthorizingMessage();
        }
        return super.getMessage(argMessageId);
    }

    /**
     * @return
     */
    private IFormattable getAuthorizingMessage() {

        return FF.getTranslatable("_miraCommunicatorAuthorizing");
    }

    public String getAuthorizationResponse() {

        if (this.getResponses().length > 0) {
            IAuthResponse lastResponse = this
                    .getResponses()[this.getResponses().length - 1];
            if (lastResponse instanceof CawMiraResponse) {
                CawMiraResponse response = (CawMiraResponse) lastResponse;
                return response.getResponseText();
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * Returns 
     * @return 
     */
    public boolean isProcessLastTrans() {

        return isProcessLastTrans;
    }

    /**
     * Specifies
     * @param isProcessLastTrans 
     */
    public void setProcessLastTrans(boolean isProcessLastTrans) {

        this.isProcessLastTrans = isProcessLastTrans;
    }

    /**
     * Returns 
     * @return 
     */
    public String getCustomerEmail() {

        return customerEmail;
    }

    /**
     * Specifies
     * @param argCustomerEmail 
     */
    public void setCustomerEmail(String argCustomerEmail) {

        customerEmail = argCustomerEmail;
    }
}
