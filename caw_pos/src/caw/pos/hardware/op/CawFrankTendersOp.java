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
 * BZ24217          261017    Receipt should be printed after selecting 'Cancel' on Insert franking instead of displayed Franking error screen.
 * BZ24296          011117    No action occurs when pressing 'Retry' button on Franking error screen
 * BZ24380          071117    "Franking Error" prompt is ignored when reaching to time out in case splitting 2 tenders required Franking action.
 * BZ26439          060618    [1.4.2][Internal] FRANKING ERROR screen does not allow Retry of Traveler Check Franking
 *===================================================================
 */

package caw.pos.hardware.op;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.hardware.*;
import dtv.hardware.franking.ITenderFranking;
import dtv.hardware.micr.IDtvMicr;
import dtv.hardware.posprinting.*;
import dtv.hardware.types.*;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.hardware.op.FrankTendersOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.event.IXstEventType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawFrankTendersOp extends FrankTendersOp {

    /*BZ26439 Removed out as it already defined in FrankTendersOp*/
    //protected static final IXstDataActionKey RETRY                    = XstDataActionKey
    //        .valueOf("RETRY");

    private static final IXstEventType[] EVENTS                   = { DtvHardwareEventType.DOCUMENT_INSERT_FAILED, DtvHardwareEventType.DOCUMENT_INSERT_BEGUN, DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN, DtvHardwareEventType.DOCUMENT_REMOVAL_FAILED, DtvHardwareEventType.DOCUMENT_TIMEOUT };

    private static final Logger          logger_                  = LogManager
            .getLogger(CawFrankTendersOp.class);

    @Inject
    private IHardwareMgr                 _hardwareMgr;

    private int                          _currentFrankingDocIndex = 0;

    private final IOpState               ERROR_PROMPT             = new OpState(
            "ERROR_PROMPT");

    private final IOpState               ERROR_REMOVING           = new OpState(
            "ERROR_REMOVING");

    private final IOpState               REMOVING                 = new OpState(
            "REMOVING");

    /* Begin BZ26439*/
    public CawFrankTendersOp() {
        super();
        this._currentFrankingDocIndex = 0;
        this.setOpState(null);
    }
    /* End BZ26439*/

    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IXstEventType eventType;

        if (argEvent != null) {
            eventType = argEvent.getType();
            logger_.debug("handleOpExec: Event Type - " + eventType);
        } else {
            logger_.debug("handleOpExec: Event Type - null");
            this._hardwareMgr.setDocumentPresent(false);//Added BZ26439
            eventType = null;
        }
        IOpState opState = getOpState();
        if (logger_.isDebugEnabled()) {
            logger_.debug("handleOpExec: Op state=" + opState);
        }

        /* Priority 1: Whenever prompt of CANCEL and RETRY displaying */
        if ((opState == ERROR_PROMPT) && ((argEvent instanceof IXstAction))) {
            logger_.info("handleOpExec: opState == ERROR_PROMPT");
            return handleErrorPromptResponse((IXstAction) argEvent);
        }

        /* Priority 2: Whenever CANCEL pressed to complete the process to print receipt */
        if (((argEvent instanceof IXstDataAction)) && (CANCEL_ACTION
                .equals(((IXstDataAction) argEvent).getActionKey()))) {
            logger_.info("handleOpExec: Action Key == CANCEL_ACTION");
            /* Begin BZ24217 */
            return HELPER.completeResponse();
            /* End BZ24217 */
        }

        if (eventType == DtvHardwareEventType.DOCUMENT_INSERT_FAILED) {
            logger_.debug("handleOpExec: eventType=DOCUMENT_INSERT_FAILED");
            return handleErrorPrompt(PromptKey.valueOf("FRANK_ERROR"));
        }

        if (eventType == DtvHardwareEventType.DOCUMENT_TIMEOUT) {
            if ((opState == null) || (opState == ERROR_PROMPT)) {
                logger_.debug("handleOpExec: eventType=DOCUMENT_TIMEOUT and ERROR_PROMPT ");
                return handleErrorPrompt(PromptKey
                        .valueOf("FRANK_ERROR_TIMEOUT"));
            } else if (opState == REMOVING) {
                logger_.debug("handleOpExec: eventType=DOCUMENT_TIMEOUT and REMOVING");
                return handleRemoveAgain();//BZ26439 Added; Removed fix of BZ24380 here
            }
        }

        if (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_FAILED) {
            logger_.info("handleOpExec: eventType=DOCUMENT_REMOVAL_FAILED");
            return handleNextDoc();
        }

        if (eventType == DtvHardwareEventType.DOCUMENT_INSERT_BEGUN) {
            logger_.info("handleOpExec: eventType=DOCUMENT_INSERT_BEGUN");
            return handleDocInsertBegun(false);
        }
        if (eventType == DtvHardwareEventType.DOCUMENT_REMOVAL_BEGUN) {
            logger_.info("handleOpExec: eventType=DOCUMENT_REMOVAL_BEGUN");
            return handleDocRemovalBegun();
        }

        if (opState == null) {
            logger_.info("handleOpExec: opState is null");
            _hardwareMgr.setDocumentPresent(false);
            return handleNextDoc();
        }

        if ((opState == ERROR_REMOVING) && ((argEvent instanceof IXstAction))) {
            logger_.info("handleOpExec: opState == ERROR_REMOVING");
            return handleRemoveAgain();
        }

        if ((opState == REMOVING) && ((argEvent instanceof IXstAction))) {
            logger_.info("handleOpExec: opState == REMOVING");
            return handleRemoveAgain();
        }

        logger_.error("Unexpected event type [" + eventType + "] for state ["
                + opState + "].");
        return HELPER.waitResponse();
    }

    /* Begin BZ24296 */
    @Override
    public boolean isOperationApplicable() {

        List<ITenderFranking> tenderDocs = (List) getScopedValue(ValueKeys.CURRENT_TENDER_FRANKING);
        if ((tenderDocs != null) && (!tenderDocs.isEmpty())
                && (isStationEnabled())) {
            return true;
        }
        return false;
    }

    @Override
    protected IOpResponse ensureOldDocumentEjected() {

        if (this._hardwareMgr.getDocumentPresent()) {
            logger_.warn("UNEXPECTED DOCUMENT STILL IN PLACE THAT HAS NO FRANKING CONFIGURATION OR THERE IS NO VALIDATION STATION... EJECTING...");

            IDtvMicr micr = this._hardwareMgr.getMicr();
            if ((micr.isPresent()) && (micr.useMicrEjectForFrankingEject())) {
                micr.beginRemoval();
            } else {
                ITenderFranking doc = getCurrentTenderFrankingDoc();
                if (doc != null) {
                    ISlipStation station = getSlipStation(doc
                            .getPrinterTargetInfo().getPrinterType());
                    try {
                        station.endRemoval();
                    } catch (Exception ex) {
                        logger_.info("ensureOldDocumentEjected-1: CAUGHT EXCEPTION", ex);
                    }
                } else {
                    IDtvDevice[] devices = this._hardwareMgr
                            .getDevices(HardwareFamilyType.POSPRINTER);
                    for (IDtvDevice device2 : devices) {
                        try {
                            IDtvPosPrinter device = (IDtvPosPrinter) device2;
                            ISlipStation station = device.getSlipStation();
                            if (station.isPresent()) {
                                station.endRemoval();
                            }
                        } catch (Exception ex) {
                            logger_.info("ensureOldDocumentEjected-2: CAUGHT EXCEPTION", ex);
                        }
                    }
                }
            }
            setOpState(this.REMOVING);

            return this.HELPER.getPromptResponse(PromptKey
                    .valueOf("FRANKING_REMOVE_CHECK"), new IFormattable[0]);
        }
        resetFrankingStations();

        return this.HELPER.completeResponse();
    }

    @Override
    protected ITenderFranking getCurrentTenderFrankingDoc() {

        Object object = getScopedValue(ValueKeys.CURRENT_TENDER_FRANKING);
        if (object != null && object instanceof List) {
            @SuppressWarnings("rawtypes")
            List frankingDocs = (List) object;
            if (this._currentFrankingDocIndex >= 0
                    && this._currentFrankingDocIndex < frankingDocs.size()) {
                Object child = frankingDocs.get(this._currentFrankingDocIndex);
                if (child != null && child instanceof ITenderFranking) {
                    return (ITenderFranking) child;
                }
            }
        }
        return null;
    }

    @Override
    protected IFormattable[] getPromptStrings() {

        ITenderFranking doc = getCurrentTenderFrankingDoc();
        if (doc == null) {
            IFormattable defaultFormattable = this._formattables
                    .getTranslatable("_frankingdefaultdocumentdescription");

            return new IFormattable[] { defaultFormattable };
        }
        return new IFormattable[] { doc.getLineItemDescription() };
    }

    @Override
    protected ISlipStation getSlipStation(String printerUse) {

        IDtvPosPrinter ptr = this._hardwareMgr.getPOSPrinter(printerUse);
        if (ptr == null) {
            return null;
        }
        return ptr.getSlipStation();
    }

    @Override
    protected IOpResponse handleDocInsertBegun(boolean alreadyInserted) {

        logger_.debug("entering handleDocInsertBegun");
        try {
            ITenderFranking doc = getCurrentTenderFrankingDoc();
            ISlipStation station = getSlipStation(doc.getPrinterTargetInfo()
                    .getPrinterType());
            if (alreadyInserted) {
                if (station.needsFlipAfterMICR()) {
                    station.changePrintSide(PosPrintSideType.OPPOSITE);
                }
            } else {
                station.endInsertion();
            }
            PageBreakException pbex = null;
            try {
                station.print(doc, pbex);
            } catch (PageBreakException ex) {
                pbex = ex;
            } catch (PosPrinterException ex) {
                if ((ex.getCause() instanceof PageBreakException)) {
                    pbex = (PageBreakException) ex.getCause();
                } else {
                    throw ex;
                }
            }
            if (pbex != null) {
                logger_.info("handleDocInsertBegun-2:", pbex);
            }
            station.beginRemoval();
            return handleRemoveDocPrompt();
        } catch (PosPrinterException ex) {
            logger_.error("handleDocInsertBegun-3:", ex);
            return handleErrorPrompt(PromptKey.valueOf("FRANK_ERROR"));
        } catch (NoDocumentException ex) {
            logger_.error("handleDocInsertBegun-4:", ex);
            //this._hardwareMgr.setDocumentPresent(false);
        } catch (Exception ex) {
            logger_.error("handleDocInsertBegun-5:", ex);
            //this._hardwareMgr.setDocumentPresent(false);
        }
        //this._hardwareMgr.setDocumentPresent(false);//Added BZ26439
        return handleErrorPrompt(PromptKey.valueOf("FRANK_ERROR_NO_DOC"));
    }

    @Override
    protected IOpResponse handleDocRemovalBegun() {

        logger_.debug("entering handleDocRemovalBegun");
        try {
            ITenderFranking doc = getCurrentTenderFrankingDoc();
            if (doc != null) {
                ISlipStation station = getSlipStation(doc.getPrinterTargetInfo()
                        .getPrinterType());

                station.endRemoval();
            } else {
                IDtvDevice[] devices = this._hardwareMgr
                        .getDevices(HardwareFamilyType.POSPRINTER);
                for (IDtvDevice device2 : devices) {
                    try {
                        IDtvPosPrinter device = (IDtvPosPrinter) device2;
                        ISlipStation station = device.getSlipStation();
                        if (station.isPresent()) {
                            station.endRemoval();
                        }
                    } catch (Exception ex) {
                        logger_.error("handleDocRemovalBegun: ", ex);
                    }
                }
            }
            this._currentFrankingDocIndex += 1;
            return handleNextDoc();
        } catch (PosPrinterException ex) {
            logger_.error("handleDocRemovalBegun-2:", ex);
        } catch (DocumentStillPresentException ex) {
            logger_.error("handleDocRemovalBegun-3: ", ex);
        }
        return handleErrorRemovePrompt();
    }

    @Override
    protected IOpResponse handleErrorPrompt(PromptKey argPromptKey) {

        logger_.debug("entering handleErrorPrompt");
        setOpState(this.ERROR_PROMPT);
        return this.HELPER.getPromptResponse(argPromptKey, getPromptStrings());
    }

    @Override
    protected IOpResponse handleErrorPromptResponse(IXstAction argActionEvent) {

        logger_.debug("entering handleErrorPromptResponse-1: state="
                + getOpState());

        boolean retryAfterError = false;

        IXstActionKey key = argActionEvent.getActionKey();
        logger_.debug("entering handleErrorPromptResponse-1: key="
                + key.toString());
        if (RETRY.equals(key)) {
            retryAfterError = true;
        } else {
            if (!CANCEL_ACTION.equals(key)) {
                logger_.warn("Unexpected event [" + argActionEvent
                        + "] for state[" + getOpState() + "].");
            }
            this._currentFrankingDocIndex += 1;
        }
        return handleNextDoc(retryAfterError);
    }

    protected IOpResponse handleNextDoc() {

        return handleNextDoc(false);
    }

    @Override
    protected IOpResponse handleNextDoc(boolean retryAfterError) {

        logger_.debug("entering handleNextDoc");

        ITenderFranking doc = getCurrentTenderFrankingDoc();
        if (doc == null) {
            logger_.info("handleNextDoc-1: No current franking document.");
            return ensureOldDocumentEjected();
        }
        ISlipStation station = getSlipStation(doc.getPrinterTargetInfo()
                .getPrinterType());
        if (!station.isPresent()) {
            logger_.info("handleNextDoc-2: No current franking document.");
            return ensureOldDocumentEjected();
        }
        setCancelable(false);
        if (this._hardwareMgr.getDocumentPresent()) {
            logger_.info("handleNextDoc-3: getDocumentPresent()");
            return handleDocInsertBegun(true);
        }
        if (retryAfterError) {
            try {
                station.endInsertion();
            } catch (Exception e) {
                logger_.warn("endInsertion() returned an exception when clearing out the insertions for a retry.", e);
            }
        }
        station.beginInsertion();
        logger_.info("handleNextDoc-4: Insert document");
        return handleInsertDocPrompt();
    }

    protected IOpResponse handleRemoveAgain() {

        logger_.debug("entering handleRemoveAgain");
        ITenderFranking doc = getCurrentTenderFrankingDoc();
        if (doc == null) {
            return ensureOldDocumentEjected();
        }
        ISlipStation station = getSlipStation(doc.getPrinterTargetInfo()
                .getPrinterType());

        station.beginRemoval();
        return handleRemoveDocPrompt();
    }

    @Override
    protected boolean isStationEnabled() {

        ITenderFranking doc = null;
        List<ITenderFranking> tendrFranks = (List) getScopedValue(ValueKeys.CURRENT_TENDER_FRANKING);
        ITenderFranking d = null;
        for (int i = this._currentFrankingDocIndex; i >= 0; i--) {
            if (i < tendrFranks.size()) {
                d = (ITenderFranking) tendrFranks.get(i);
                if (d != null) {
                    doc = d;
                    break;
                }
            }
        }
        if (doc == null) {
            logger_.debug("No document on the command -- reporting franking station disabled.");
            return false;
        }
        String printerType = doc.getPrinterTargetInfo().getPrinterType();
        ISlipStation station = getSlipStation(printerType);
        if (!station.isPresent()) {
            logger_.info(printerType + " is either not present or disabled");
            return false;
        }
        return true;
    }

    @Override
    protected void resetFrankingStations() {

        IDtvDevice[] devices = this._hardwareMgr
                .getDevices(HardwareFamilyType.POSPRINTER);
        for (IDtvDevice device2 : devices) {
            try {
                IDtvPosPrinter device = (IDtvPosPrinter) device2;
                ISlipStation station = device.getSlipStation();
                if (station.isPresent()) {
                    station.endRemoval();
                }
            } catch (Exception ex) {
                logger_.info("resetFrankingStations: CAUGHT EXCEPTION", ex);
            }
        }
    }
    /* End BZ24296 */

    private IOpResponse handleRemoveDocPrompt() {

        logger_.debug("entering handleRemoveDocPrompt");
        setOpState(this.REMOVING);
        return this.HELPER.getPromptResponse(PromptKey
                .valueOf("FRANKING_REMOVE_DOC"), getPromptStrings());
    }

    private IOpResponse handleErrorRemovePrompt() {

        logger_.debug("entering handleErrorRemovePrompt");
        setOpState(this.ERROR_REMOVING);
        return handleErrorPrompt(PromptKey.valueOf("FRANK_ERROR_REMOVING"));
    }

    private IOpResponse handleInsertDocPrompt() {

        logger_.debug("entering handleInsertDocPrompt");
        setOpState(null);
        return this.HELPER.getPromptResponse(PromptKey
                .valueOf("FRANKING_INSERT_DOC"), getPromptStrings());
    }

}
