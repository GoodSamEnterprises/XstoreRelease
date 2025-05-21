/**
 * CONFIDENTIAL AND PROPRI   ETARY SOURCE CODE. 
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
 * BZ23478          200917    [Prompting] Update Catalyst = 1 request
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ24556          201117    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28567          071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28580          101218    Cannot turn off Prompt Engine with COM_CODE_VALUE
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ35054          180220    [Ported the fix from patch 8 to Xstore 6.0][Prod] Roadside Assistance prompt on a crew account
 * BZ47818          221221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawProcessCatalystOp class
 */
public class CawProcessCatalystOp extends Operation {

    private static final Logger       _logger                    = LogManager.getLogger(CawProcessCatalystOp.class);

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper.getInstance();

    @Inject
    private TransactionScope          _transaction;                                                                 //BZ23478

    @Inject
    private DefaultScope              _defaultScope;

    @Inject
    protected StationState            stationState;

    /* Begin BZ28265 */
    /** (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        /*BEGIN BZ23479, BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*BEGIN BZ23479, BZ28855, BZ33231*/
        Boolean isRun = _cawAdvancePromptingHelper.isRunOp(_transaction, CawCatalystHelper.getCustomerPartyId());

        if (CawCatalystHelper
                .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
            if (isRun && CawCatalystHelper
                    .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_ADD)) {
                /* BEGIN BZ35054 */
                if (CawCatalystHelper.checkCatalystDirectiveType8()) {
                    isRun = false;
                } else {
                    isRun = true;
                }
                /* END BZ35054 */
            } else {
                isRun = false;//BZ28580
            }
        } else {
            isRun = false;
        }
        /* END BZ33231 */
        return isRun;
    }
    /* End BZ28265 */

    /** (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction iPosTransaction = _transaction.getTransaction(); //BZ23478
        IParty party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER); //BZ47818
        String lookupResponse = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);//BZ23478

        if (party != null && StringUtils.isNotEmpty(lookupResponse)) {//BZ24556
            String requestJson = _cawAdvancePromptingHelper
                    .buildCatalystRequest(party, lookupResponse, iPosTransaction, stationState);//BZ23478

            if (requestJson != null) {
                _logger.info("[Call Prompting Engine Catalyst 1 API]:" + CawEBSHelper.URL_CATALYST_REQUEST);//BZ29840
                _logger.info("[Prompting Engine Catalyst 1 Request]:" + requestJson);//BZ23478, BZ29840

                ResponseEntity<String> response = CawEBSHelper.getInstance().sendCatalystRequestToEBS(requestJson);
                if (response != null) {
                    if (CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                        _logger.info("[Prompting Engine Catalyst 1 Response]:" + response.getBody());//BZ29840
                        //Set value catalyst 1 into CAW_CATALYST_TYPE for RESULT REQUEST
                        _transactionScope.setValue(CawValueKeys.CAW_CATALYST_TYPE, CawConstants.VALUE_1.toString());//Begin BZ28567
                        try {
                            JSONObject jsonObjectResponse = new JSONObject(response.getBody());

                            //  Catalyst =1 response data container inputs data
                            JSONArray inputObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_INPUT_TYPE);
                            if (inputObj != null) {
                                CawCatalystHelper.setCatalystInputsResponse(inputObj);
                            }

                            //  Catalyst =1 response data container messages data
                            JSONArray messagesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_MESSAGES_TYPE);
                            if (messagesObj != null) {
                                CawCatalystHelper.setCatalystMessageResponse(messagesObj);
                            }

                            //  Catalyst =1 response data container directives data
                            JSONArray directivesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                            if (directivesObj != null) {
                                CawCatalystHelper.setCatalystDirectiveResponse(directivesObj);
                            }

                            setScopedValue(CawValueKeys.CATALYST_CUSTOMER_IDENTIFIED_RESPONSE, response.getBody());
                            //Save response to DB
                            _cawAdvancePromptingHelper
                                    .saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.PROMPTING_ENGINE_CATALYST_ONE, response
                                            .getBody(), CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);

                        } catch (JSONException ex) {
                            _logger.error("Cant not get data from JSON." + ex.getMessage());
                        }
                    }
                }
            }
        }

        return HELPER.completeResponse();

    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
