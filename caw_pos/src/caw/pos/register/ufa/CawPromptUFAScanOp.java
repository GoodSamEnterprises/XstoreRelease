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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 * BZ35377          040419    [Internal] Unable to scan etrack ID when using scanner with inbound mode
 *===================================================================
 */

package caw.pos.register.ufa;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawPropertyUtils;

import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.types.HardwareType;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.op.OpState;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.hardware.IInput;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.util.crypto.EncString;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.crm.IParty;

/**
 * 
 */
public class CawPromptUFAScanOp
        extends AbstractPromptOp implements IXstEventObserver {

    boolean isScreenScanning = false; //BZ35377

    private static final PromptKey         PKEY_UFA_ENTER_ID        = PromptKey
            .valueOf("PAID_OUT_UFA_SCAN");

    private static final PromptKey         PKEY_UFA_NOTIFY          = PromptKey
            .valueOf("PAID_OUT_UFA_NOTIFY");

    private static final PromptKey         PKEY_UFA_ADD_COMMENT     = PromptKey
            .valueOf("PAID_OUT_UFA_COMMENT");

    private static final FormKey           FORMKEY_UFA_VIEW_DETAIL  = FormKey
            .valueOf("UFA_VIEW_DETAIL");

    private final IOpState                 OP_STATE_UFA_ENTER       = new OpState(
            "UFA_SCAN");

    private final IOpState                 OP_STATE_UFA_VIEW_DETAIL = new OpState(
            "UFA_DETAIL");

    private final IOpState                 OP_STATE_UFA_PROCEED     = new OpState(
            "UFA_PROCEED");

    private final IOpState                 OP_STATE_UFA_BACK        = new OpState(
            "UFA_BACK");

    private static final IXstDataActionKey ACT_UFA_ACCEPT_ENTRY     = XstDataActionKey
            .valueOf("UFA_ACCEPT_ENTRY");

    private static final IXstDataActionKey ACT_UFA_DETAIL_SELECT    = XstDataActionKey
            .valueOf("UFA_DETAIL_SELECT");

    private static final IXstDataActionKey ACT_UFA_DETAIL_BACK      = XstDataActionKey
            .valueOf("UFA_DETAIL_BACK");

    private static final IXstDataActionKey ACT_UFA_OK               = XstDataActionKey
            .valueOf("UFA_OK");

    private static final IXstDataActionKey ACT_UFA_CLOSE            = XstDataActionKey
            .valueOf("UFA_CLOSE");

    private static final IXstDataActionKey ACT_UFA_COMMENT_ADD      = XstDataActionKey
            .valueOf("UFA_COMMENT_ADD");

    private static final Logger            _logger                  = LogManager
            .getLogger(CawPromptUFAScanOp.class);

    private IOpState                       _opUFAState;

    @Inject
    private IBusyState                     _busyState;

    protected static final IXstEventType   EVENTS[];

    static {
        EVENTS = (new IXstEventType[] { InputType.INPUT_ITEM });
    }

    public CawPromptUFAScanOp() {

        super(true);
        _opUFAState = OP_STATE_UFA_ENTER;
    }

    /**
     * @return the opUFAState
     */
    public IOpState getOpUFAState() {

        return _opUFAState;
    }

    /**
     * @param argOpUFAState the opUFAState to set
     */
    public void setOpUFAState(IOpState argOpUFAState) {

        _opUFAState = argOpUFAState;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        //Check privileges with screens/prompts
        isScreenScanning = true; //BZ35377
        return PKEY_UFA_ENTER_ID;
    }

    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }

    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent,
            PromptKey argPromptKey, IFormattable argPromptArgs[]) {

        PromptKey promptKey = argPromptKey;
        return super.getPromptResponse(argEvent, promptKey, argPromptArgs);
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOpResponse response = null;
        IOpState state = getOpState();
        if (argEvent == null && POST_PROMPT.equals(state)) {
            setOpState(null);
            return HELPER.incompleteResponse();
        }
        response = super.handleOpExec(argEvent);
        return response;
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        isScreenScanning = false; //BZ35377
        IOpResponse ufaResponse = processUFAMainAction(argEvent);
        if (ufaResponse != null) {
            return ufaResponse;
        }

        return super.handleDataAction(argEvent);
    }

    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        /* BEGIN BZ35377 */
        if (argEvent instanceof ItemScanEvent) {
            if (isScreenScanning) {
                ItemScanEvent event = (ItemScanEvent) argEvent;
                IInput inputData = event.getInputData();
                if (inputData != null) {
                    String itemId = EncString
                            .getSensitiveData(inputData.getData());
                    setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemId);
                    isScreenScanning = false;
                    return processBarcodeScanPrompt(event);
                }
            } else {
                CawHardwareHelper.getInstance()
                        .sendBeepScanner(CawHardwareHelper.getInstance()
                                .getScanner(), CawHardwareHelper.getInstance()
                                        .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
                return HELPER.waitResponse();
            }
        }
        /* END BZ35377 */
        return super.handlePromptEvent(argEvent);
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return HELPER.completeResponse();
    }

    private void readETrackID(IXstEvent argEvent) {

        String itemId = argEvent.getStringData();
        setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemId);
    }

    private void readUFAComment(IXstEvent argEvent) {

        String comment = argEvent.getStringData();
        setScopedValue(ValueKeys.ENTERED_COMMENT, comment);
    }

    /**
     * process of UFA Actions 
     * @param argEvent
     * @return
     */
    public IOpResponse processUFAMainAction(IXstDataAction argEvent) {

        IXstActionKey key = argEvent.getActionKey();
        //IOpState state = getOpState();
        IOpState ufaState = getOpUFAState();
        if (ACT_UFA_ACCEPT_ENTRY.equals(key)) {
            readETrackID(argEvent);
            return processBarcodeScanPrompt(argEvent);
        } else if (ACT_UFA_DETAIL_SELECT.equals(key)) {
            return processUsedFirearmSelected(argEvent);
        } else if (ACT_UFA_DETAIL_BACK.equals(key) || ACT_UFA_OK.equals(key)) {
            if (OP_STATE_UFA_PROCEED.equals(ufaState)) {
                setOpUFAState(OP_STATE_UFA_PROCEED);
                return HELPER.getPromptResponse(PKEY_UFA_ADD_COMMENT);
            } else {
                setOpUFAState(OP_STATE_UFA_ENTER);
                isScreenScanning = true; //BZ35377
                return HELPER.getPromptResponse(PKEY_UFA_ENTER_ID);
            }

        } else if (ACT_UFA_CLOSE.equals(key)) {
            return HELPER.completeCurrentChainResponse();
        } else if (ACT_UFA_COMMENT_ADD.equals(key)) {
            readUFAComment(argEvent);
            return processUsedFirearmComment(argEvent);
        }

        return null;
    }

    /**
     * Process when eTrack ID entered
     * @param argEvent
     * @return
     */
    protected IOpResponse processBarcodeScanPrompt(IXstEvent argEvent) {

        if (argEvent instanceof ItemScanEvent) {
            ItemScanEvent event = (ItemScanEvent) argEvent;
            setScopedValue(ValueKeys.VALUE_ENTRY_METHOD, event.getSourceType());
        } else {
            setScopedValue(ValueKeys.VALUE_ENTRY_METHOD, HardwareType.KEYBOARD);
        }
        String eTrackId = getScopedValue(ValueKeys.ENTERED_ITEM_ID);

        //Validate Input
        boolean validData = false;
        if (CawUFAConstants.getInstance().vLong(eTrackId) > 0) {
            validData = true;
        }

        if (!validData) {
            setOpUFAState(OP_STATE_UFA_BACK);
            return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                    .getTranslatable("_caw_ufa_promptmsg_required"));
        }

        //DO SEACH USED_FIREARM IN NUERON ESB
        boolean result = searchUsedFirearmPurchase(eTrackId);

        //Case 1: Found, go to next screen to display Used firearm retail
        if (result) {
            return viewFirearmDetailPrompt();
        } else {
            //Case 2: Not found or any error, go to prompt for displaying error message
            setOpUFAState(OP_STATE_UFA_BACK);
            return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                    .getTranslatable("_caw_ufa_promptmsg_notfound"));

            //Just for testing
            //setOpUFAState(OP_STATE_UFA_PROCEED);
            //return HELPER.getPromptResponse(PKEY_UFA_ADD_COMMENT);
        }
    }

    /**
     * Search for customer and used firearm in Neuron ESB
     * Step1: Build request and get response
     * Step2: Parse the response to save into Customer & Used Firearm Objects
     * Step3: Put these objects into memory
     * @param eTrackId
     * @return
     */
    private boolean searchUsedFirearmPurchase(String eTrackId) {

        boolean found = false;
        CawUFAModel model = null;
        String storeId = "0";
        String registerId = "0";
        long orgId = 0;
        try {
            //Reset whatever model is found or not
            if (getScopedValue(ValueKeys.REPORT_SOURCE) != null) {
                clearScopedValue(ValueKeys.REPORT_SOURCE);
            }

            orgId = ConfigurationMgr.getOrganizationId();
            if (_stationState != null) {
                storeId = String.valueOf(_stationState.getRetailLocationId());
                registerId = String.valueOf(_stationState.getWorkstationId());
            }
            _busyState.start(CawConstants.BUSY_STATE_MSG);
            //Look for Used Firearm & Customer via Neuron ESB
            model = CawUFAHelper.getInstance()
                    .searchUFA(eTrackId, storeId, registerId, orgId);
            _busyState.end();
            //Save Used Firearm & Customer into Scoped Values
            if (model != null) {
                found = true;
                setScopedValue(ValueKeys.REPORT_SOURCE, model);
            }
        } catch (Exception ex) {
            _logger.error("searchUsedFirearmPurchase-1", ex);
        }
        return found;
    }

    /**
     * Check any paid out transaction created in xStore DB for ebsItemCode
     * @return
     */
    private boolean checkUFAPaidOutExsited() {

        boolean found = false;
        Object mObj = getScopedValue(ValueKeys.REPORT_SOURCE);
        if (mObj != null && _transactionScope != null
                && mObj instanceof CawUFAModel) {
            CawUFAModel model = (CawUFAModel) mObj;
            found = CawUFAQueryHelper
                    .checkUFAPaidOutExsited(model.getOrganizationId(), model
                            .getStoreId(), model.getRegisterId(), model
                                    .getEtrackId(), model.getEbsItemCode());
        }
        return found;

    }

    /**
     * Process after the used firearm selected
     * Prepare for Objects of Used firearm, Customer and UFA Reason code
     * @param argEvent
     * @return
     */
    protected IOpResponse processUsedFirearmSelected(IXstEvent argEvent) {

        /* Make sure that selected customer info & used firearm, 
         * Paid out amount assigned
         * Next, end of the operation to navigate the add comment screen*/
        boolean validAll = assignSelectedUFAScope();
        if (validAll) {
            boolean paidoutExisted = checkUFAPaidOutExsited();
            if (paidoutExisted) {
                setOpUFAState(OP_STATE_UFA_BACK);
                return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                        .getTranslatable("_caw_ufa_promptmsg_paidout_existed"));

            } else {
                IReasonCode reasonCode = autoSetUFAReasonCode();
                if (reasonCode != null) {
                    if (isCommentRequired(reasonCode)) {
                        setOpUFAState(OP_STATE_UFA_PROCEED);
                        return HELPER.getPromptResponse(PKEY_UFA_ADD_COMMENT);
                    } else {
                        setOpUFAState(OP_STATE_UFA_PROCEED);
                        return processUsedFirearmProceed(argEvent);
                    }
                } else {
                    setOpUFAState(OP_STATE_UFA_BACK);
                    return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                            .getTranslatable("_caw_ufa_promptmsg_reason_code_notfound"));
                }
            }
        } else {
            setOpUFAState(OP_STATE_UFA_BACK);
            return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                    .getTranslatable("_caw_ufa_promptmsg_amount_invalid"));
        }

    }

    /**
     * Assign values to transaction scope
     */
    private boolean assignSelectedUFAScope() {

        boolean valid = false;
        Object mObj = getScopedValue(ValueKeys.REPORT_SOURCE);

        if (mObj != null && _transactionScope != null
                && mObj instanceof CawUFAModel) {
            valid = true;
            CawUFAModel model = (CawUFAModel) mObj;

            setScopedValue(ValueKeys.REPORT_SOURCE, model);

            IParty selectedCustomer = model.getCustomerParty();
            if (selectedCustomer != null) {
                setScopedValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer);
            } else {
                valid = false;
            }

            BigDecimal vendorCostAmt = CawUFAConstants.getInstance()
                    .vBigDecimal(model.getFirearmDetail().getVendorCost());
            if (vendorCostAmt != null
                    && !vendorCostAmt.equals(BigDecimal.ZERO)) {
                setScopedValue(ValueKeys.ENTERED_TILL_AMOUNT, vendorCostAmt);
            } else {
                _logger.debug("assignSelectedUFAScope-1: Paid-out amout is invalid.");
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Assign values to transaction scope
     */
    private boolean assignUFATransaction() {

        boolean valid = false;
        if (_transactionScope != null) {
            valid = true;
            IParty selectedCustomer = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            if (selectedCustomer != null) {
                _transactionScope
                        .setValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer);
            } else {
                _logger.debug("assignUFATransaction-1: Customer not assigned.");
                valid = false;
            }

            Object ufa = getScopedValue(ValueKeys.REPORT_SOURCE);
            if (ufa != null && ufa instanceof CawUFAModel) {
                _transactionScope.setValue(ValueKeys.REPORT_SOURCE, ufa);
                //_transactionScope.setValue(ValueKeys.REPORT_SOURCE, ((CawUFAModel)ufa).getFirearm());
            } else {
                _logger.debug("assignUFATransaction-2: Used Firearm not assigned.");
                valid = false;
            }

            BigDecimal amount = getScopedValue(ValueKeys.ENTERED_TILL_AMOUNT);
            if (amount != null && !amount.equals(BigDecimal.ZERO)) {
                _transactionScope
                        .setValue(ValueKeys.ENTERED_TILL_AMOUNT, amount);
            } else {
                _logger.debug("assignUFATransaction-3: Paid-out amout not assigned.");
                valid = false;
            }

            IReasonCode reasonCode = getScopedValue(ValueKeys.SELECTED_REASON_CODE);
            if (reasonCode != null) {
                _transactionScope
                        .setValue(ValueKeys.SELECTED_REASON_CODE, reasonCode);
            } else {
                _logger.debug("assignUFATransaction-4: UFA Reason code not assigned.");
                valid = false;
            }

            String comment = getScopedValue(ValueKeys.ENTERED_COMMENT);
            if (comment != null && comment.length() > 0) {
                _transactionScope.setValue(ValueKeys.ENTERED_COMMENT, comment);
            } else {
                if (reasonCode == null || isCommentRequired(reasonCode)) {
                    _logger.debug("assignUFATransaction-5: UFA comment not assigned.");
                    valid = false;
                }
            }
        }
        return valid;
    }

    /**
     * Process after the used firearm's comment added
     * @param argEvent
     * @return
     */
    protected IOpResponse processUsedFirearmComment(IXstEvent argEvent) {

        String comment = getScopedValue(ValueKeys.ENTERED_COMMENT);
        if (comment != null && comment.length() > 0) {
            return processUsedFirearmProceed(argEvent);
        } else {
            setOpUFAState(OP_STATE_UFA_PROCEED);
            return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                    .getTranslatable("_caw_ufa_promptmsg_comment_required"));
        }
    }

    /**
     * Starting of Paid-out transaction
     * @param argEvent
     * @return
     */
    protected IOpResponse processUsedFirearmProceed(IXstEvent argEvent) {

        boolean proceed = assignUFATransaction();
        if (proceed) {
            return HELPER.completeResponse();
        } else {
            setOpUFAState(OP_STATE_UFA_BACK);
            return HELPER.getPromptResponse(PKEY_UFA_NOTIFY, _ff
                    .getTranslatable("_caw_ufa_promptmsg_notcompleted"));
        }
    }

    /**
     * Returns whether the user is required to enter a comment when selecting the specified reason code.
     *
     * @param argReason the just-selected reason code
     * @return <code>true</code> if the user is required to enter a comment when selecting
     * <code>argReason</code>; <code>false</code> if the user should be prompted for an optional comment or not
     * at all
     */
    private boolean isCommentRequired(IReasonCode argReason) {

        if (argReason != null) {
            return (CawUFAConstants.IND_COMMENT_REQUIRED
                    .equalsIgnoreCase(argReason.getCommentRequired()));
        } else {
            return false;
        }
    }

    /**
     * Check and get first Reason Code for Purchase of Used Firearm
     * from xStore COM_REASON_CODE table
     * @return
     */
    private IReasonCode autoSetUFAReasonCode() {

        IReasonCode reason = null;
        String type = CawUFAConstants.getDefaultUAFReasonTypeCode();
        String code = CawUFAConstants.getDefaultUAFReasonCode();
        try {
            //Example: reason = CodeLocator.getReasonCode(ConfigurationMgr
            //        .getOrganizationId(), "RETURN", "RET_PUF");

            reason = CawUFAQueryHelper.getReasonCode(ConfigurationMgr
                    .getOrganizationId(), type, code);
            if (reason == null) {
                _logger.debug("autoSetUFAReasonCode-0: Lookup for type = " + type
                        + ", code = " + code);
                reason = CodeLocator.getReasonCode(ConfigurationMgr
                        .getOrganizationId(), type, code);
            }
            if (reason == null) {
                _logger.debug("autoSetUFAReasonCode-0: Lookup for reason type = "
                        + type);
                @SuppressWarnings("rawtypes")
                List list = CodeLocator.getReasonCodes(ConfigurationMgr
                        .getOrganizationId(), type);
                Object ob = null;
                if (list != null && list.size() > 0) {
                    int len = list.size();
                    for (int i = 0; i < len; i++) {
                        ob = list.get(i);
                        if (ob instanceof IReasonCode) {
                            reason = (IReasonCode) ob;
                            break;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("autoSetUFAReasonCode-1", ex);
        }

        if (reason != null) {
            setScopedValue(ValueKeys.SELECTED_REASON_CODE, reason);
        } else {
            _logger.debug("autoSetUFAReasonCode-2: UFA Reason code is not found for type = "
                    + type + ", code = " + code);
        }
        return reason;
    }

    /**
     * View Firearm Detail screen
     * @return
     */
    protected IOpResponse viewFirearmDetailPrompt() {

        Object mObj = getScopedValue(ValueKeys.REPORT_SOURCE);
        CawUFAModel model = null;
        if (mObj != null && mObj instanceof CawUFAModel) {
            model = (CawUFAModel) mObj;
        } else {
            model = new CawUFAModel();
        }
        setOpUFAState(OP_STATE_UFA_VIEW_DETAIL);
        CawUFALayoutModel layoutModel = model.getLayoutModel();
        return HELPER
                .getShowFormResponse(FORMKEY_UFA_VIEW_DETAIL, layoutModel, DataActionGroupKey.VIEW);
    }

}