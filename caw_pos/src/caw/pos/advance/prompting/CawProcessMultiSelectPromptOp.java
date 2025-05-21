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
 * BZ23541          280817    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4
 * BZ23483          091017    [Advanced prompting] Should have trigger one selected item in case single/multiple select input response 
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawEBSConstant;
import caw.pos.common.CawValueKeys;
import twitter4j.JSONArray;
import twitter4j.JSONException;

import dtv.pos.common.FormKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;

/**
 *
 */
public class CawProcessMultiSelectPromptOp
        extends AbstractFormOp<CawInputFormModel> {

    private static final String       ID_ATTR                    = "id";

    private static final Logger       _logger                    = LogManager
            .getLogger(CawProcessMultiSelectPromptOp.class);

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    private static final String       CHOICES_ATTR               = "choices";

    private JSONArray                 inputFileds                = null;

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
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
                                .getInt(CawEBSConstant.TYPE_ATTR) == 2) {
                    isRun = Boolean.TRUE;
                }
            } catch (JSONException ex) {
                _logger.error("Can not get input type." + ex.getMessage());
            }
        }
        return isRun;
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
            if (inputFileds.getJSONObject(0) != null) {
                if (inputFileds.getJSONObject(0)
                        .get(CawEBSConstant.TYPE_ATTR) != null) {
                    id = inputFileds.getJSONObject(0).getString(ID_ATTR);

                    label = inputFileds.getJSONObject(0)
                            .getString(CawEBSConstant.LABEL_ATTR);
                    description = inputFileds.getJSONObject(0)
                            .getString(CawEBSConstant.DESCRIPTION_ATTR);

                    isCallBack = inputFileds.getJSONObject(0)
                            .getBoolean("isCallbackRequired");

                    type = inputFileds.getJSONObject(0)
                            .getInt(CawEBSConstant.TYPE_ATTR);

                    multiSelect = _cawAdvancePromptingHelper
                            .getMultiSelectData(inputFileds.getJSONObject(0)
                                    .getJSONArray(CHOICES_ATTR));
                }
            }
        } catch (JSONException ex) {
            _logger.error("The function createModel can not data."
                    + ex.getMessage());
        }

        CawInputFormModel catalystInputFormModel = new CawInputFormModel(
                description, cawInputSingleChoice, multiSelect);
        catalystInputFormModel.setInputLable(label);
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

        return FormKey.valueOf("CATALYST_MULTI_SELECT_FIELD");
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#handleFormResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        try {
            if (argEvent.getData() != null
                    && argEvent.getData() instanceof CawInputFormModel) {
                CawInputFormModel cawInputFormModel = (CawInputFormModel) argEvent
                        .getData();
                CawCatalysCallBackModel backModel;
                backModel = _cawAdvancePromptingHelper
                        .buildCatalystCallBackModel(cawInputFormModel, inputFileds
                                .getJSONObject(0));
                if (backModel != null) {
                    CawCatalystHelper.getInputdatals().put(0, backModel);
                    setScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA, CawCatalystHelper
                            .getInputdatals());//BZ23541
                }
            }
        } catch (JSONException ex) {
            _logger.error("Can not process data for input form"
                    + ex.getMessage());
        }

        return super.handleFormResponse(argEvent);
    }

    // Begin BZ23483
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#validateForm(dtv.pos.iframework.form.IEditModel)
     */
    @Override
    protected IValidationResultList validateForm(CawInputFormModel argModel) {

        IValidationResultList list = super.validateForm(argModel);
        IValidationResultList valid = new ValidationResultList();

        if (list != null && list.size() > 0) {
            valid.add(SimpleValidationResult
                    .getFailed("_editField_multipleList"));
        }

        return valid;
    }
    // End BZ23483

}
