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
 * BZ23693              091017    Can't scan Check on device when performing transaction by split tender Cash and Check
 * BZ23982              131017    Registers are constantly frozen and required rebooting
 * BZ24017              151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24019              161017    [Technical issue] - Empty method
 * BZ24104              191017    Inputting manual check should not be allowed when doing "Check" tender
 * BZ26247              220518    [Tenders] Manual entry of checks should be enabled (just removed some code lines)
 *===================================================================
 */

package caw.pos.hardware.op;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.hardware.*;
import dtv.hardware.events.MicrReadEvent;
import dtv.hardware.micr.*;
import dtv.hardware.types.DtvHardwareEventType;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.validation.ValidationHelper;
import dtv.pos.framework.validation.ValidationRuleList;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.hardware.IHardwareType;
import dtv.pos.iframework.op.*;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.IValidationRule;
import dtv.pos.spring.ValueKeys;
import dtv.util.crypto.EncString;
import dtv.xst.dao.ttr.ICheckTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
* The xstore base, we cannot retry scan a check again when error happen. This class fix that. 
*/
public class CawReadMicrOp extends
        Operation implements IXstEventObserver, IReversibleOp, IValidationOp {

    protected static final IXstDataActionKey CANCEL_ACTION        = XstDataActionKey
            .valueOf("CANCEL_ACTION");

    protected static final IXstDataActionKey RETRY                = XstDataActionKey
            .valueOf("RETRY");

    private static final Logger              logger_              = LogManager
            .getLogger(CawReadMicrOp.class);

    private static IXstEventType[]           events_              = { DtvHardwareEventType.DOCUMENT_INSERT_FAILED, DtvHardwareEventType.DOCUMENT_INSERT_BEGUN, DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN, DtvHardwareEventType.DOCUMENT_REMOVAL_FAILED, DtvHardwareEventType.DOCUMENT_TIMEOUT, DtvHardwareEventType.MICR_READ_FAILED, InputType.INPUT_MICR };

    protected final IOpState                 POST_MICR_PROMPT     = new OpState(
            "POST_MICR_PROMPT");

    protected final IOpState                 POST_CHECKNUM_PROMPT = new OpState(
            "POST_CHECKNUM_PROMPT");

    protected final IOpState                 ERROR_PROMPT         = new OpState(
            "ERROR_PROMPT");

    protected final IOpState                 REMOVING             = new OpState(
            "REMOVING");

    protected final IOpState                 REMOVING_PREVIOUS    = new OpState(
            "REMOVING_PREVIOUS");

    protected final IOpState                 REMOVING_BAD_READ    = new OpState(
            "REMOVING_BAD_READ");

    protected final IOpState                 ERROR_REMOVING       = new OpState(
            "ERROR_REMOVING");

    private boolean                          _isAborting          = false;

    private String                           _manuallyEnteredMicr = null;

    @Inject
    @Named("checkManualEntryRules")
    private ValidationRuleList               _manualEntryRules;

    @Inject
    @Named("micrRules")
    private ValidationRuleList               _micrRules;

    @Inject
    private ValidationHelper                 _validationHelper;

    @Inject
    private IHardwareMgr                     _hardwareMgr;

    @Override
    public IXstEventType[] getObservedEvents() {

        return events_;
    }

    @Override
    public List<IValidationRule> getValidationRules() {

        IOpState opState = getOpState();
        if ((opState == POST_MICR_PROMPT)
                || (opState == POST_CHECKNUM_PROMPT)) {
            return _manualEntryRules.getRules();
        }
        return _micrRules.getRules();
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        logger_.info("Check: handleOpExec");
        IXstEventType eventType;
        if (argEvent != null) {
            eventType = argEvent.getType();
            logger_.info("Check: Event Type - " + argEvent.getType());
        } else {
            logger_.info("Check: Event Type - null. ");
            _hardwareMgr.setDocumentPresent(false);
            eventType = null;
        }
        IOpState opState = getOpState();

        if (logger_.isDebugEnabled()) {
            logger_.debug("entering handleOpExec state=" + opState
                    + ",eventType=" + eventType);
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_INSERT_FAILED) {
            logger_.info("Check: eventType = DOCUMENT_INSERT_FAILED");
            return handleErrorPrompt(getMicrReadErrorPrompt());
        }
        if ((eventType == DtvHardwareEventType.DOCUMENT_TIMEOUT)
                && (opState == null)) {
            logger_.info("Check: eventType = DOCUMENT_TIMEOUT && Opstate = null");
            return handleErrorPrompt(getMicrReadErrorTimeoutPrompt());
        }
        if ((eventType == DtvHardwareEventType.DOCUMENT_TIMEOUT)
                && (opState == REMOVING)) {
            logger_.info("Check: eventType = DOCUMENT_TIMEOUT && Opstate = REMOVING ");
            return handleRemoveAgain();
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_INSERT_BEGUN) {
            logger_.info("Check: eventType = DOCUMENT_INSERT_BEGUN");
            return handleDocInsertBegun();
        }
        if (eventType == DtvHardwareEventType.MICR_READ_FAILED) {
            logger_.info("Check: eventType = MICR_READ_FAILED");
            return handleBadRead();
        }
        if (eventType == InputType.INPUT_MICR) {
            logger_.info("Check: eventType = INPUT_MICR");
            return handleMicrRead(argEvent);
        }
        if ((_isAborting) && (opState != ERROR_PROMPT)) {
            logger_.info("Check: _isAborting = true && Opstate = ERROR_PROMPT");
            return handleMicrAbort();
        }
        if ((opState == REMOVING_BAD_READ)
                && (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN)) {
            logger_.info("Check: eventType = DOCUMENT_REMOVAL_BEGUN && Opstate = REMOVING_BAD_READ");
            return handleDocRemovalAfterBadRead(argEvent);
        }
        if ((eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN)
                && (opState != ERROR_PROMPT)) {
            logger_.info("Check: eventType = DOCUMENT_REMOVAL_BEGUN && Opstate = ERROR_PROMPT");
            return handleDocRemovalBegun(argEvent);
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_FAILED) {
            logger_.info("Check: eventType = DOCUMENT_REMOVAL_FAILED");
            return handleErrorRemoving();
        }
        if ((opState == ERROR_PROMPT) && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: Opstate = null && argEvent instanceof IXstAction ");
            return handleErrorPromptResponse(argEvent);
        }
        if (((argEvent instanceof IXstDataAction)) && (CANCEL_ACTION
                .equals(((IXstDataAction) argEvent).getActionKey()))) {
            logger_.info("Check: argEvent instanceof IXstAction && actionKey = CANCEL_ACTION");
            return handleMicrCancel();
        }
        if (opState == null) {
            logger_.info("Check: Opstate = null");
            logger_.info("Set document present = null if error. ");
            _hardwareMgr.setDocumentPresent(false);
            return handleInitialState();
        }
        if (opState == POST_MICR_PROMPT) {
            logger_.info("Check: Opstate = POST_MICR_PROMPT");
            return handleManualPromptResponse(argEvent);
        }
        if (opState == POST_CHECKNUM_PROMPT) {
            logger_.info("Check: Opstate = POST_CHECKNUM_PROMPT");
            return handleManualCheckNumberResponse(argEvent);
        }
        if (((opState == ERROR_REMOVING) || (opState == REMOVING_PREVIOUS))
                && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: Opstate = ERROR_REMOVING || Opstate = REMOVING_PREVIOUS && argEvent instanceof IXstAction ");
            return handleErrorRemovingResponse();
        }
        if (((opState == REMOVING) || (opState == REMOVING_PREVIOUS))
                && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: Opstate = REMOVING || Opstate = REMOVING_PREVIOUS && argEvent instanceof IXstAction ");
            return handleRemoveAgain();
        }
        if ((opState == REMOVING_BAD_READ)
                && (eventType == DtvHardwareEventType.DOCUMENT_TIMEOUT)) {
            logger_.info("Check: Opstate = REMOVING_BAD_READ || eventType = DOCUMENT_TIMEOUT");
            return handleRemoveAgainAfterBadRead();
        }
        logger_.warn("Unexpected event [" + argEvent + "] for state [" + opState
                + "].");
        return handleInitialState();
    }

    @Override
    public IOpResponse handleOpReverse(IXstEvent argEvent) {

        logger_.info("Check: handleOpReverse");
        IXstEventType eventType;
        if (argEvent != null) {
            eventType = argEvent.getType();
        } else {
            eventType = null;
        }
        IOpState opState = getOpState();
        if (logger_.isDebugEnabled()) {
            logger_.debug("entering handleOpExec state=" + opState
                    + ",eventType=" + eventType);
        }
        if ((eventType == DtvHardwareEventType.DOCUMENT_TIMEOUT)
                && (opState == REMOVING)) {
            logger_.info("Check: eventType = DOCUMENT_TIMEOUT && Opstate = REMOVING ");
            return handleRemoveAgain();
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN) {
            logger_.info("Check: eventType = DOCUMENT_REMOVAL_BEGUN ");
            return handleDocRemovalBegun(argEvent);
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_FAILED) {
            logger_.info("Check: eventType = DOCUMENT_REMOVAL_FAILED ");
            return handleErrorRemoving();
        }
        if ((opState == ERROR_PROMPT) && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: Opstate = ERROR_PROMPT && argEvent instanceof IXstAction ");
            return handleErrorPromptResponse(argEvent);
        }
        if (((argEvent instanceof IXstDataAction)) && (CANCEL_ACTION
                .equals(((IXstDataAction) argEvent).getActionKey()))) {
            logger_.info("Check: argEvent instanceof IXstAction && actionKey = CANCEL_ACTION");
            return HELPER.completeResponse();
        }
        if (opState == null) {
            if (_hardwareMgr.getDocumentPresent()) {
                logger_.info("_hardwareMgr.getDocumentPresent() = "
                        + _hardwareMgr.getDocumentPresent());
                return handleRemove();
            }
            return HELPER.completeResponse();
        }
        if (((opState == ERROR_REMOVING) || (opState == REMOVING_PREVIOUS))
                && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: (Opstate = ERROR_REMOVING || Opstate = REMOVING_PREVIOUS) && argEvent instanceof IXstAction");
            return handleErrorRemovingResponse();
        }
        if (((opState == REMOVING) || (opState == REMOVING_PREVIOUS))
                && ((argEvent instanceof IXstAction))) {
            logger_.info("Check: (Opstate = REMOVING || Opstate = REMOVING_PREVIOUS) && argEvent instanceof IXstAction");
            return handleRemoveAgain();
        }
        logger_.warn("Unexpected event [" + argEvent + "] for state [" + opState
                + "].");
        return handleRemoveAgain();
    }

    @Override
    public boolean isOperationApplicable() {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        return tenderLine.getTender().getTenderTypecode().equals("CHECK");
    }

    @Override
    public IOpResponse runValidationCheck(IXstEvent argEvent,
            PromptKey argFailedPrompt) {

        IValidationResultList results = _validationHelper
                .applyValidationRules(argEvent, getValidationRules());
        if (!results.isValid()) {
            return HELPER
                    .getPromptResponse(argFailedPrompt, new IFormattable[] { results
                            .getInvalidResults(0).getMessage() });
        }
        return HELPER.completeResponse();
    }

    @Override
    public void setValidationRules(List<IValidationRule> argRules) {

        logger_.info("No validation rules required");
    }

    protected void cancelInsertOrRemoval() {

        logger_.debug("cancelInsertOrRemoval");
        _hardwareMgr.getMicr().cancelInsertOrRemoval();
    }

    protected PromptKey getEnterCheckNumberPrompt() {

        return PromptKey.valueOf("ENTER_CHECK_NUMBER");
    }

    protected PromptKey getEnterRouteAccCheckPrompt() {

        return PromptKey.valueOf("ENTER_ROUTE_ACC_CHECK");
    }

    protected PromptKey getMicrBadReadRemovePrompt() {

        return PromptKey.valueOf("MICR_BAD_READ_REMOVE");
    }

    protected PromptKey getMicrInsertCheckPrompt() {

        return PromptKey.valueOf("MICR_INSERT_CHECK");
    }

    protected PromptKey getMicrReadErrorNoDocPrompt() {

        return PromptKey.valueOf("MICR_READ_ERROR_NO_DOC");
    }

    protected PromptKey getMicrReadErrorPrompt() {

        return PromptKey.valueOf("MICR_READ_ERROR");
    }

    protected PromptKey getMicrReadErrorRemovingPrompt() {

        return PromptKey.valueOf("MICR_READ_ERROR_REMOVING");
    }

    protected PromptKey getMicrReadErrorTimeoutPrompt() {

        return PromptKey.valueOf("MICR_READ_ERROR_TIMEOUT");
    }

    protected PromptKey getMicrReadingPrompt() {

        return PromptKey.valueOf("MICR_READING");
    }

    protected PromptKey getMicrRemoveCheckPrompt() {

        return PromptKey.valueOf("MICR_REMOVE_CHECK");
    }

    protected PromptKey getValidationErrorMessagePrompt() {

        return PromptKey.valueOf("VALIDATION_ERROR_MESSAGE");
    }

    protected IOpResponse handleBadRead() {

        logger_.debug("entering handleBadRead");
        setOpState(REMOVING_BAD_READ);
        _hardwareMgr.getMicr().beginRemoval();
        return HELPER
                .getPromptResponse(getMicrBadReadRemovePrompt(), new IFormattable[0]);
    }

    protected IOpResponse handleDocInsertBegun() {

        logger_.debug("entering handleDocInsertBegun");
        try {
            _hardwareMgr.getMicr().endInsertion();
            return HELPER
                    .getPromptResponse(getMicrReadingPrompt(), new IFormattable[0]);
        } catch (MicrException ex) {
            logger_.info("Check: Start - MicrException");
            logger_.error("Micr Exception: " + ex.getMessage());
            logger_.info("Check: End - MicrException");
            return handleErrorPrompt(getMicrReadErrorPrompt());
        } catch (NoDocumentException ex) {
            logger_.info("Check: Start - NoDocumentException");
            logger_.error("No Document Exception: " + ex.getMessage());
            logger_.info("Check: End - NoDocumentException");
        }
        return handleErrorPrompt(getMicrReadErrorNoDocPrompt());
    }

    protected IOpResponse handleDocRemovalAfterBadRead(IXstEvent argEvent) {

        logger_.debug("entering handleDocRemovalAfterBadRead");
        try {
            _hardwareMgr.getMicr().endRemoval();
            setCancelable(true);
            setOpState(null);
            return handleInitialState();
        } catch (MicrException ex) {
            logger_.info("Check: Start - MicrException");
            logger_.error("Micr Exception: " + ex.getMessage());
            logger_.info("Check: End - MicrException");
            return handleErrorRemoving();
        } catch (DocumentStillPresentException ex) {
            logger_.info("Check: Start - DocumentStillPresentException");
            logger_.error("Document Still Present Exception: "
                    + ex.getMessage());
            logger_.info("Check: End - DocumentStillPresentException");

            setOpState(ERROR_REMOVING);
        }
        return handleErrorPrompt(getMicrReadErrorRemovingPrompt());
    }

    protected IOpResponse handleDocRemovalBegun(IXstEvent argEvent) {

        logger_.debug("entering handleDocRemovalBegun");
        try {
            _hardwareMgr.getMicr().endRemoval();
            setCancelable(true);
            if (getOpState() == REMOVING) {
                return HELPER.completeResponse();
            }
            if (_isAborting) {
                _isAborting = false;
                return HELPER.silentErrorResponse();
            }
            return handleInitialState();
        } catch (MicrException ex) {
            logger_.info("Check: Start - MicrException");
            logger_.error("Micr Exception: " + ex.getMessage());
            logger_.info("Check: End - MicrException");
            return handleErrorRemoving();
        } catch (DocumentStillPresentException ex) {
            logger_.info("Check: Start - DocumentStillPresentException");
            logger_.error("Document Still Present Exception: "
                    + ex.getMessage());
            logger_.info("Check: End - DocumentStillPresentException");
            setOpState(ERROR_REMOVING);
        }
        return handleErrorPrompt(getMicrReadErrorRemovingPrompt());
    }

    protected IOpResponse handleErrorPrompt(PromptKey argPromptKey) {

        logger_.debug("entering handleErrorPrompt");
        setOpState(ERROR_PROMPT);
        return HELPER
                .getPromptResponse(argPromptKey, new IFormattable[] { IFormattable.EMPTY });
    }

    protected IOpResponse handleErrorPromptResponse(IXstEvent argEvent) {

        logger_.debug("entering handleErrorPromptResponse");

        IXstActionKey key = ((IXstAction) argEvent).getActionKey();
        if (key == CANCEL_ACTION) {
            return startManualEntry();
        }
        if (key != RETRY) {
            logger_.warn("Unexpected event [" + argEvent + "] for state["
                    + getOpState() + "].");
        }
        setOpState(null);
        return HELPER.incompleteResponse();
    }

    protected IOpResponse handleErrorRemoving() {

        logger_.debug("entering handleErrorRemoving");
        setOpState(ERROR_REMOVING);
        return handleErrorPrompt(getMicrReadErrorRemovingPrompt());
    }

    protected IOpResponse handleErrorRemovingResponse() {

        logger_.debug("entering handleErrorRemovingResponse");

        _hardwareMgr.getMicr().beginRemoval();
        setOpState(REMOVING);
        return HELPER
                .getPromptResponse(getMicrRemoveCheckPrompt(), new IFormattable[0]);
    }

    protected IOpResponse handleInitialState() {

        logger_.debug("handleInitialState");
        logger_.info("handleInitialState()");

        IDtvMicr micr = _hardwareMgr.getMicr();
        if (micr.isPresent()) {
            setCancelable(false);
            if (_hardwareMgr.getDocumentPresent()) {
                logger_.info("Check: _hardwareMgr.getDocumentPresent() = "
                        + _hardwareMgr.getDocumentPresent());
                return removePrevious();
            }

            logger_.info("Check: Begin Insertion");
            micr.beginInsertion();
            return HELPER
                    .getPromptResponse(getMicrInsertCheckPrompt(), new IFormattable[0]);
        }
        return startManualEntry();
    }

    protected IOpResponse handleManualCheckNumberResponse(IXstEvent argEvent) {

        logger_.debug("entering handleManualCheckNumberResponse");
        if (argEvent == null) {
            return showEnterCheckNumber();
        }
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        ICheckTenderLineItem checkTender = (ICheckTenderLineItem) tenderLine;
        String checkNum;
        if (argEvent.getData() == null) {
            checkNum = null;
        } else {
            checkNum = argEvent.getStringData();
        }
        setScopedValue(ValueKeys.CHECK_MANUAL_ENTRY_DATA, checkNum);
        IOpResponse resp = runValidationCheck(argEvent, getValidationErrorMessagePrompt());
        if (!resp.getOpStatus().equals(OpStatus.COMPLETE)) {
            setOpState(ERROR_PROMPT);
            return resp;
        }
        try {
            @SuppressWarnings("null")
            MicrRead read = new MicrRead(_manuallyEnteredMicr.trim(),
                    checkNum.trim());
            checkTender.setMicrData(EncString.getSensitiveData(read.getData()));
            checkTender.setCheckAccountNumber(read.getAccountNumber());
            checkTender.setBankId(read.getTransitNumber());
            checkTender.setCheckSequenceNumber(read.getSerialNumber());
            IHardwareType<?> entryMethodType = read.getSourceType();
            if (entryMethodType == null) {
                logger_.warn("null entry method?!?!?!");
            } else {
                checkTender.setEntryMethodCode(entryMethodType.getName());
            }
        } catch (Exception e) {
            setOpState(ERROR_PROMPT);
            logger_.debug("Exception when reading MICR" + e.getMessage());
            return HELPER
                    .getPromptResponse(getValidationErrorMessagePrompt(), new IFormattable[] { _formattables
                            .getTranslatable("_micrInvalidEntry") });
        }
        return resp;
    }

    protected IOpResponse handleManualPromptResponse(IXstEvent argEvent) {

        logger_.debug("entering handleManualPromptResponse");
        if (argEvent == null) {
            return startManualEntry();
        }
        String micrData = argEvent.getStringData();

        setScopedValue(ValueKeys.CHECK_MANUAL_ENTRY_DATA, micrData);
        IOpResponse resp = runValidationCheck(argEvent, getValidationErrorMessagePrompt());
        if (resp.getOpStatus().isComplete()) {
            _manuallyEnteredMicr = micrData;
            return showEnterCheckNumber();
        }
        setOpState(ERROR_PROMPT);
        return resp;
    }

    protected IOpResponse handleMicrAbort() {

        handleRemove();
        return HELPER.silentErrorResponse();
    }

    protected IOpResponse handleMicrCancel() {

        cancelInsertOrRemoval();
        return handleErrorPrompt(getMicrReadErrorPrompt());
    }

    protected IOpResponse handleMicrRead(IXstEvent argEvent) {

        logger_.debug("entering handleMicrRead");

        MicrRead micrRead = ((MicrReadEvent) argEvent).getMicrData();
        if (micrRead.isError()) {
            return handleErrorPrompt(getMicrReadErrorPrompt());
        }
        setScopedValue(ValueKeys.CHECK_MICR_DATA, micrRead);
        IOpResponse resp = runValidationCheck(argEvent, getValidationErrorMessagePrompt());
        if (!resp.getOpStatus().equals(OpStatus.COMPLETE)) {
            _isAborting = true;
            setOpState(ERROR_PROMPT);
            _hardwareMgr.getMicr().beginRemoval();
            return resp;
        }
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        ICheckTenderLineItem checkLine = (ICheckTenderLineItem) tenderLine;

        setCheckTenderLineItem(checkLine, argEvent);
        if ((tenderLine.getTender().getOptions().getEndorsementRequired())
                && (_hardwareMgr.getMicr().holdChecksForFranking())) {
            setCancelable(true);
            return HELPER.completeResponse();
        }
        return handleRemove();
    }

    protected IOpResponse handleRemove() {

        _hardwareMgr.getMicr().beginRemoval();
        setOpState(REMOVING);
        return HELPER
                .getPromptResponse(getMicrRemoveCheckPrompt(), new IFormattable[0]);
    }

    protected IOpResponse handleRemoveAgain() {

        logger_.debug("entering handleRemoveAgain");
        _hardwareMgr.getMicr().beginRemoval();
        setOpState(REMOVING);
        return HELPER
                .getPromptResponse(getMicrRemoveCheckPrompt(), new IFormattable[0]);
    }

    protected IOpResponse handleRemoveAgainAfterBadRead() {

        logger_.debug("entering handleRemoveAgainAfterBadRead");
        _hardwareMgr.getMicr().beginRemoval();
        setOpState(REMOVING_BAD_READ);
        return HELPER
                .getPromptResponse(getMicrRemoveCheckPrompt(), new IFormattable[0]);
    }

    protected IOpResponse removePrevious() {

        logger_.debug("entering removePrevious");
        _hardwareMgr.getMicr().beginRemoval();
        setOpState(REMOVING_PREVIOUS);
        return HELPER
                .getPromptResponse(getMicrRemoveCheckPrompt(), new IFormattable[0]);
    }

    protected void setCheckTenderLineItem(ICheckTenderLineItem argCheckTender,
            IXstEvent argEvent) {

        MicrRead data = ((MicrReadEvent) argEvent).getMicrData();
        argCheckTender.setMicrData(EncString.getSensitiveData(data.getData()));
        argCheckTender.setBankId(data.getTransitNumber());
        argCheckTender.setCheckAccountNumber(data.getAccountNumber());
        argCheckTender.setCheckSequenceNumber(data.getSerialNumber());
        IHardwareType<?> entryMethodType = data.getSourceType();
        if (entryMethodType == null) {
            logger_.warn("null entry method.");
        } else {
            argCheckTender.setEntryMethodCode(entryMethodType.getName());
        }
    }

    protected IOpResponse showEnterCheckNumber() {

        setOpState(POST_CHECKNUM_PROMPT);
        return HELPER
                .getPromptResponse(getEnterCheckNumberPrompt(), new IFormattable[] { IFormattable.EMPTY });
    }

    protected IOpResponse startManualEntry() {

        logger_.debug("entering startManualEntry");
        setOpState(POST_MICR_PROMPT);
        setCancelable(true);
        return HELPER
                .getPromptResponse(getEnterRouteAccCheckPrompt(), new IFormattable[] { IFormattable.EMPTY });
    }
}
