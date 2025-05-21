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
 * BZ31813          100719    [INTERNAL] Xstore did not displayed as the html code in prompting engines when ESB responded as message
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawEBSConstant;
import twitter4j.*;

import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.action.IXstDataActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessPEMessagesOp extends AbstractFormOp<CawInputFormModel> {

    public static final IXstDataActionKey BUTTON_PROCESS = XstDataActionKey
            .valueOf("ACCEPT");

    private static final Logger           _logger        = LogManager
            .getLogger(CawProcessInputPromptOp.class);

    private JSONObject                    objMessage     = null;

    private String                        PARAM_FORM_KEY = "formKey";

    private String                        _formKey;

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        try {
            if (CawCatalystHelper.getCatalystMessageResponse() != null
                    && CawCatalystHelper.getCatalystMessageResponse()
                            .length() > 0) {

                objMessage = CawCatalystHelper.getCatalystMessageResponse().getJSONObject(0);
                
                if (objMessage != null && _formKey!= null) {
                    if (!objMessage.isNull(CawEBSConstant.TYPE_ATTR)) {
                        String type = objMessage.getString(CawEBSConstant.TYPE_ATTR);
                        if (type.equalsIgnoreCase(_formKey)) {
                            ArrayList<JSONObject> tmpJsonObjects = new ArrayList<JSONObject>();
                            JSONArray messageJsonArray = CawCatalystHelper
                                    .getCatalystMessageResponse();

                            for (int i = 0; i < messageJsonArray.length(); i++) {
                                try {
                                    tmpJsonObjects
                                            .add((JSONObject) messageJsonArray.get(i));
                                } catch (JSONException ex) {
                                    _logger.debug("Can not add element from array to list."
                                            + ex.getMessage());
                                }
                            }
                            
                            tmpJsonObjects.remove(0);
                            JSONArray newMessageJsonArray = new JSONArray(tmpJsonObjects);
                            // Update new message array to catalystMessageResponse variable
                            CawCatalystHelper
                                    .setCatalystMessageResponse(newMessageJsonArray);
                            
                            isRun = Boolean.TRUE;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.debug("CawProcessCatalystMessagePromptHTMLOp throw exception."
                    + ex.getMessage());
        }

        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractFormOp#createModel()
     */
    @Override
    protected CawInputFormModel createModel() {

        String label = null;
        try {
            label = objMessage
                    .getString(CawEBSConstant.CATALYST_MESSAGES_TEXT_ATTR);
        } catch (JSONException ex) {
            _logger.error("The function createModel can not data."
                    + ex.getMessage());
        }

        CawInputFormModel catalystInputFormModel = new CawInputFormModel(null,
                null, null);
        catalystInputFormModel.setInputLable(label);
        catalystInputFormModel.setInputLabelPrompt(formatLabel(label));

        return catalystInputFormModel;
    }

    @Override
    protected FormKey getFormKey() {
        return FormKey.valueOf("CAW_CATALYST_MESSAGE_RESPONSE_FIELD");
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        if (CawCatalystHelper.getCatalystMessageResponse() != null
                && CawCatalystHelper.getCatalystMessageResponse()
                        .length() > 0) {
            return HELPER.getCompleteStackChainResponse(OpChainKey
                    .valueOf("CAW_PROCESS_CATALYST_CUSTOMER_IDENTIFIED_MESSAGE_REPSONSE"));
        }

        return HELPER.completeResponse();
    }

    @Override
    public void setParameter(String argName, String argValue) {

        if (PARAM_FORM_KEY.equalsIgnoreCase(argName)) {
            _formKey = argValue;
        }
    }

    /**
     * Format label.
     *
     * @param label the label
     * @return the string
     */
    protected String formatLabel(String label) {

        return "<html><head><style>#main{text-align: center; width: 640px}</style></head><body><div id=\"main\">"
                + label + "</div></body></html>";
    }
}
