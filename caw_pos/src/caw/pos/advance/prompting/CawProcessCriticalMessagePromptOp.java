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
 * BZ23052              120917    Implement Advanced Prompting
 * BZ23735              051017    Duplicate property name: _catalystprompttitle in translations.properties
 * BZ24094              261017    [Technical issue] - Method Invocation in Loop Condition
 *===================================================================
 */

package caw.pos.advance.prompting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawEBSConstant;
import twitter4j.*;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
*
*/
public class CawProcessCriticalMessagePromptOp extends AbstractPromptOp {

    private static final Logger _logger  = LogManager
            .getLogger(CawProcessInformationMessagePromptOp.class);

    private JSONArray           messages = null;

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;

        if (CawCatalystHelper.getCatalystMessageResponse() != null
                && CawCatalystHelper.getCatalystMessageResponse()
                        .length() > 0) {
            messages = CawCatalystHelper.getCatalystMessageResponse();
            JSONObject objMessage = null;
            int length = messages.length();
            for (int i = 0; i < length; i++) {
                try {
                    objMessage = messages.getJSONObject(i);
                    if (objMessage.getString(CawEBSConstant.TYPE_ATTR)
                            .equals(CawEBSConstant.CATALYST_CRITICAL_MESSAGES_TYPE)
                            && objMessage
                                    .getString(CawEBSConstant.CATALYST_MESSAGES_TEXT_ATTR)
                                    .length() < 100) {
                        isRun = Boolean.TRUE;
                        break;
                    }
                } catch (JSONException ex) {
                    _logger.error("Can not get json object." + ex.getMessage());
                }
            }
        }

        return isRun;
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        JSONObject objMessage = null;
        IFormattable args[] = new IFormattable[2];
        args[0] = _ff
                .getSimpleFormattable("_promptingEngineTitle", FormatterType.SIMPLE);//B23735
        int length = messages.length();
        for (int i = 0; i < length; i++) {
            try {
                objMessage = messages.getJSONObject(i);
                if (objMessage.getString(CawEBSConstant.TYPE_ATTR)
                        .equals(CawEBSConstant.CATALYST_CRITICAL_MESSAGES_TYPE)) {
                    args[1] = _ff.getSimpleFormattable(objMessage
                            .getString(CawEBSConstant.CATALYST_MESSAGES_TEXT_ATTR), FormatterType.SIMPLE);
                }
            } catch (JSONException ex) {
                _logger.error("Can not parse json object." + ex.getMessage());
            }
        }
        return args;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_CATALYST_MESSAGE_PROMPT");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        try {
            if (CawCatalystHelper.getCatalystMessageResponse() != null
                    && CawCatalystHelper.getCatalystMessageResponse()
                            .length() > 0) {
                CawCatalystHelper.setCatalystMessageResponse(CawCatalystHelper
                        .removeElementOfJsonArray(CawCatalystHelper
                                .getCatalystMessageResponse(), 2));
            }
        } catch (JSONException ex) {
            _logger.debug("Can not get json object" + ex.getMessage());
        }
        return HELPER.completeResponse();
    }
}
