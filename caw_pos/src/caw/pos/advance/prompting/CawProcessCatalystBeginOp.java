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
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 *===================================================================
 */

package caw.pos.advance.prompting;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessCatalystBeginOp extends Operation {

    private static final Logger       _logger                    = LogManager
            .getLogger(CawProcessCatalystTransactionTotalOp.class);

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper.getInstance();

    public static final String        STORE_NUMBER               = System.getProperty("dtv.location.storeNumber");

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            String employeeId = StringUtils.EMPTY;
            if (_stationState != null && _stationState.getSystemUser() != null
                    && _stationState.getSystemUser().getOperatorParty() != null) {
                employeeId = _stationState.getSystemUser().getOperatorParty().getEmployeeId();
            }
            if (StringUtils.isNotEmpty(STORE_NUMBER) && StringUtils.isNotEmpty(employeeId)) {
                String requestJson = _cawAdvancePromptingHelper.buildCatalystBeginRequest(STORE_NUMBER, employeeId);

                if (requestJson != null) {
                    {
                        _logger.info("[Call Prompting Engine Catalyst 0 API]:" + CawEBSHelper.URL_CATALYST_REQUEST);
                        _logger.info("[Prompting Engine Catalyst 0 Request]:" + requestJson);

                        ResponseEntity<String> response = CawEBSHelper.getInstance()
                                .sendCatalystRequestToEBS(requestJson);
                        if (response != null) {
                            if (CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                                _logger.info("[Prompting Engine Catalyst 0 Response]:" + response.getBody());
                                //Set value catalyst 0 into CAW_CATALYST_TYPE for RESULT REQUEST
                                _transactionScope
                                        .setValue(CawValueKeys.CAW_CATALYST_TYPE, CawConstants.VALUE_0.toString());
                                try {
                                    JSONObject jsonObjectResponse = new JSONObject(response.getBody());

                                    //  Catalyst =0 response data container inputs data
                                    JSONArray inputObj = CawCatalystHelper
                                            .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_INPUT_TYPE);
                                    if (inputObj != null) {
                                        CawCatalystHelper.setCatalystInputsResponse(inputObj);
                                    }

                                    //  Catalyst =0 response data container messages data
                                    JSONArray messagesObj = CawCatalystHelper
                                            .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_MESSAGES_TYPE);
                                    if (messagesObj != null) {
                                        CawCatalystHelper.setCatalystMessageResponse(messagesObj);
                                    }

                                    //  Catalyst =0 response data container directives data
                                    JSONArray directivesObj = CawCatalystHelper
                                            .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                                    if (directivesObj != null) {
                                        CawCatalystHelper.setCatalystDirectiveResponse(directivesObj);
                                    }
                                } catch (JSONException ex) {
                                    _logger.error("Cant not get data from JSON." + ex.getMessage());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Send request Catalyst = 0 to EBS service." + ex.getMessage());
        }
        return HELPER.completeResponse();
    }

    @Override
    public String getLongRunningMessage() {
        return CawConstants.BUSY_STATE_MSG;
    }
}