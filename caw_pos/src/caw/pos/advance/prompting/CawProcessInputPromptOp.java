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
 * BZ23052          120917    Implement Advanced Prompting
 * BZ23433          180917    [Advanced Prompting]Should be displayed 'processing ...' screen when sending prompting catalyst ='1', '4'
 * BZ23541          280817    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4
 * BZ23483          091017    [Advanced prompting] Should have trigger one selected item in case single/multiple select input response
 * BZ23982          131017    Registers are constantly frozen and required rebooting 
 * BZ24018          171017    [Technical issue] - Empty if statement
 * BZ28626          121218    Allow Has email input text box from EBS is not required
 * BZ30928          060619    [New Requirement] Investigate capability to update prompting screens
 * BZ31753          030719    [INTERNAL] ESB responded Response is:400 After parsing a value an unexpected character was encountered
 * BZ33231          301019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ38980          041120    [TASK] Prompt Engine - Add Item & Price
 * BZ39446          171120    [TASK] Not need to required the customer for Roundup transaction
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization 
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import twitter4j.JSONArray;
import twitter4j.JSONException;

import dtv.pos.common.*;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.IUIController;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * 
 */
public class CawProcessInputPromptOp extends AbstractFormOp<CawInputFormModel> {

    private static final int              ACTIVE_2_STATUS            = 2;

    private static final int              ACTIVE_1_STATUS            = 1;

    private static final int              ACTIVE_0_STATUS            = 0;

    private static final String           IS_CALLBACK_REQUIRED       = "isCallbackRequired";

    private static final String           ID_ATTR                    = "id";

    private static final String           BUTTON_PREVIOUS            = "PREVIOUS";

    /*BEGIN BZ23433*/
    public static final IXstDataActionKey BUTTON_PROCESS             = XstDataActionKey
            .valueOf("ACCEPT");
    /*END BZ23433*/

    private static final String           CHOICES                    = "choices";

    private JSONArray                     inputFileds                = null;

    private static int                    active                     = 0;

    private static final int              SINGLE_SELECT_INPUT        = 1;

    private static final int              MULTI_SELECT_INPUT         = 2;

    private static final Logger           _logger                    = LogManager
            .getLogger(CawProcessInputPromptOp.class);

    private CawAdvancePromptingHelper     _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        if (CawCatalystHelper.getCatalystInputsResponse() != null
                && CawCatalystHelper.getCatalystInputsResponse().length() > 0) {
            inputFileds = CawCatalystHelper.getCatalystInputsResponse();
            try {
                if (inputFileds.length() == 1
                        && inputFileds.getJSONObject(0) != null
                        && inputFileds.getJSONObject(0)
                                .getInt(CawEBSConstant.TYPE_ATTR) != 2) {
                    isRun = Boolean.TRUE;
                } else if (inputFileds.length() > 1) {
                    isRun = Boolean.TRUE;
                }
            } catch (JSONException ex) {
                _logger.error("Can not get input type." + ex.getMessage());
            }
        }

        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#handleFormResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        /* BEGIN BZ33231 */
        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        CawCatalysCallBackModel backModel = null;
        String selectAnser = StringUtils.EMPTY;
        /* END BZ33231 */
        IOpResponse response = null;
        try {
            if (argEvent.getData() != null
                    && argEvent.getData() instanceof CawInputFormModel) {
                CawInputFormModel cawInputFormModel = (CawInputFormModel) argEvent
                        .getData();
                 backModel = _cawAdvancePromptingHelper
                        .buildCatalystCallBackModel(cawInputFormModel, inputFileds
                                .getJSONObject(active));
                if (backModel != null) {
                    selectAnser = backModel.getAnswer(); //BZ33231
                    CawCatalystHelper.getInputdatals().put(active, backModel); //BZ23541
                }
            }

            if (active < inputFileds.length() - 1) {
                active = active + 1;
                setScopedValue(CawValueKeys.ELEMENT_ACTIVE, active);
                response = HELPER.getWaitStackChainResponse(OpChainKey
                        .valueOf("CAW_PROCESS_CATALYST_CUSTOMER_IDENTIFIED_INPUT_REPSONSE"));
            } else {
                active = 0;
                response = super.handleFormResponse(argEvent);
            }
            setScopedValue(CawValueKeys.ELEMENT_ACTIVE, active);
            setScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA, CawCatalystHelper
                    .getInputdatals()); //BZ23541
            
            /* BEGIN BZ33231 */
            // Call back customer search screen
            if (isRequireCustomer(party, backModel)) { // BZ-38980, BZ-39446
                active = 0;
                clearScopedValue(CawValueKeys.ELEMENT_ACTIVE);
                _transactionScope.clearValue(CawValueKeys.FN_BACK_CUST_SEARCH);
                CawCatalystHelper.setCatalystInputsResponse(null);
                CawCatalystHelper.getInputdatals().clear();
                return HELPER.getStartChainResponse(OpChainKey.valueOf("PRE_SALE_TRANSACTION"));
            }
            /* END BZ33231 */

            //BEGIN BZ59418
            if(selectAnser != null && !selectAnser.isEmpty()) {
                boolean result = false;
                ICodeValue iSKUCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), "CAW_GSL_FREE_SIGN_UP", selectAnser);
                if (iSKUCode != null) {
                    result = true;
                }
                if(result) {
                    IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
                    
                    if(trans.getCustomerParty().getTelephone1() == null && trans.getCustomerParty().getTelephone2() == null && 
                            trans.getCustomerParty().getTelephone3() == null && trans.getCustomerParty().getTelephone4() == null) {
                        _transactionScope.setValue(CawValueKeys.CAW_SHOULD_ADD_ITEM_AFTER_INPUT_PHONE_NUMBER, true);
                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_CUSTOMER_NEED_PHONE_NUMBER"), null);
                    }
                }
            }
            //END BZ59418
        } catch (Exception ex) {
            _logger.error("Can not process data for input form"
                    + ex.getMessage());
        }

        return response;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#createModel()
     */
    @Override
    protected CawInputFormModel createModel() {

        String label = null;
        String description = null;
        Boolean isCallBack = Boolean.FALSE;
        String id = null;
        Integer type = null;
        List<CawInputSingleChoice> cawInputSingleChoice = new ArrayList<CawInputSingleChoice>();
        List<String> multiSelect = new ArrayList<String>();
        try {
            if (inputFileds.getJSONObject(active) != null) {
                if (inputFileds.getJSONObject(active)
                        .get(CawEBSConstant.TYPE_ATTR) != null) {

                    id = inputFileds.getJSONObject(active).getString(ID_ATTR);

                    label = inputFileds.getJSONObject(active)
                            .getString(CawEBSConstant.LABEL_ATTR);

                    description = inputFileds.getJSONObject(active)
                            .getString(CawEBSConstant.DESCRIPTION_ATTR);

                    isCallBack = inputFileds.getJSONObject(active)
                            .getBoolean(IS_CALLBACK_REQUIRED);

                    type = inputFileds.getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR);

                    if (SINGLE_SELECT_INPUT == inputFileds.getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR)) {
                        if (inputFileds.getJSONObject(active)
                                .getJSONArray(CHOICES) != null) {
                            cawInputSingleChoice = _cawAdvancePromptingHelper
                                    .getSingleSelectData(inputFileds
                                            .getJSONObject(active)
                                            .getJSONArray(CHOICES));
                        }
                    } else if (MULTI_SELECT_INPUT == inputFileds
                            .getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR)) {
                        multiSelect = _cawAdvancePromptingHelper
                                .getMultiSelectData(inputFileds
                                        .getJSONObject(active)
                                        .getJSONArray(CHOICES));
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("The function createModel can not data."
                    + ex.getMessage());
        }

        CawInputFormModel catalystInputFormModel = new CawInputFormModel(
                description, cawInputSingleChoice, multiSelect);
        catalystInputFormModel.setInputLable(label); /*BZ31753*/
        catalystInputFormModel.setInputLabelPrompt(formatLabel(label));//BZ30928
        catalystInputFormModel.setIsCallback(isCallBack);
        catalystInputFormModel.setId(id);
        catalystInputFormModel.setDescription(description);
        catalystInputFormModel.setType(type);
        return catalystInputFormModel;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#getFormKey()
     */
    @Override
    protected FormKey getFormKey() {

        FormKey formKey = null;
        try {
            if (inputFileds.getJSONObject(active) != null) {
                if (inputFileds.getJSONObject(active)
                        .get(CawEBSConstant.TYPE_ATTR) != null) {
                    if (ACTIVE_0_STATUS == inputFileds.getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR)) {
                        formKey = FormKey.valueOf("CATALYST_INPUT_TEXT_FIELD");
                    } else if (ACTIVE_1_STATUS == inputFileds
                            .getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR)) {
                        formKey = FormKey
                                .valueOf("CATALYST_INPUT_SINGLE_SELECT_FIELD");
                    } else if (ACTIVE_2_STATUS == inputFileds
                            .getJSONObject(active)
                            .getInt(CawEBSConstant.TYPE_ATTR)) {
                        formKey = FormKey
                                .valueOf("CATALYST_MULTI_SELECT_FIELD");
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("The function getFormKey can not data."
                    + ex.getMessage());
        }

        return formKey;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#handleDisplayAgain()
     */
    @Override
    protected IOpResponse handleDisplayAgain() {

        return HELPER.completeResponse();
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        // Begin BZ23634
        IUIController con = _modeProvider.get().getUiController();
        con.showFocusBar();
        // End BZ23634
        //Flag mark when user press button previous. It used class CawAllowPreviousButtonVisibilityRule.java
        setScopedValue(CawValueKeys.IS_INPUT_BACK_BUTTON, Boolean.FALSE);
        IXstActionKey key = argAction.getActionKey();
        if (BUTTON_PREVIOUS.equals(key.toString())) {
            setScopedValue(CawValueKeys.IS_INPUT_BACK_BUTTON, Boolean.TRUE);
            if (active > 0) {
                active = active - ACTIVE_1_STATUS;
                setScopedValue(CawValueKeys.ELEMENT_ACTIVE, active);
                return HELPER.getWaitStackChainResponse(OpChainKey
                        .valueOf("CAW_PROCESS_CATALYST_CUSTOMER_IDENTIFIED_INPUT_REPSONSE"));
            } else {
                return this.handleExit();
            }
            /*BEGIN BZ23433*/
        }
        /*END BZ23433*/

        return super.handleDataAction(argAction);
    }
    
    // Start BZ-39446
    /**
     * @param party
     * @param selectAnser
     * @return
     */
    private boolean isRequireCustomer(IParty party, CawCatalysCallBackModel argBackModel) {
        boolean isRequireCustomer = false;
        boolean isPromptingRequireCust = CawCatalystHelper.checkPromtingResponseRequireCustomer(argBackModel.getDescription());
        String selectAnser = argBackModel.getAnswer();
        
        // Check question and answer for Round up transaction.
        if (party == null && isPromptingRequireCust 
                && !CawConstants.VALUE_0.equals(selectAnser)
                && !CawConstants.VALUE_NO.equals(selectAnser)) {
            isRequireCustomer = true;
        }
        
        return isRequireCustomer;
    } // End BZ-39446

    // Begin BZ23483
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#validateForm(dtv.pos.iframework.form.IEditModel)
     */
    @Override
    protected IValidationResultList validateForm(CawInputFormModel argModel) {
        /* Begin BZ28626*/
        IValidationResultList valid = new ValidationResultList();

        try {
            if (inputFileds.getJSONObject(active) != null) {
                Object desObject = inputFileds.getJSONObject(active).get(CawEBSConstant.DESCRIPTION_ATTR);
                String description = "";
                if (desObject != null) {
                    description = (String) desObject;
                }
                if (inputFileds.getJSONObject(active).get(CawEBSConstant.TYPE_ATTR) != null) {
                    if (ACTIVE_0_STATUS == inputFileds.getJSONObject(active).getInt(CawEBSConstant.TYPE_ATTR)) {
                        if (!CawCatalystHelper.checkInputOptionalField(description)
                                && StringUtils.isEmpty(argModel.getInputValue())) {
                            valid.add(SimpleValidationResult.getFailed("_editField_inputValue"));
                        }
                    } else if (ACTIVE_1_STATUS == inputFileds.getJSONObject(active).getInt(CawEBSConstant.TYPE_ATTR)) {
                        if (argModel != null && argModel.getSingleList() == null) {
                            valid.add(SimpleValidationResult.getFailed("_editField_singleList"));
                        }
                    } else if (ACTIVE_2_STATUS == inputFileds.getJSONObject(active).getInt(CawEBSConstant.TYPE_ATTR)) {
                        if (CollectionUtils.isEmpty(argModel.getMultipleList())) {
                            valid.add(SimpleValidationResult.getFailed("_editField_multipleList"));
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Can not data from Json." + ex.getMessage());
        }
        /* End BZ28626*/

        return valid;
    }
    // End BZ23483

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
    
    /* BEGIN BZ30928 */
    /**
     * Format label.
     *
     * @param label
     * @return the string
     */
    protected String formatLabel(String label) {
        return "<html><head><style>div{ width: 650px }</style></head><body><div>" + label + "</div></body></html>";
    }
    /* END BZ30928 */
}
