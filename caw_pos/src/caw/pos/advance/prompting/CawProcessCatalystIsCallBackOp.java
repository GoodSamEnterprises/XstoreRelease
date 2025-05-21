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
 * BZ23564          240917    Prompting Engine - Catalyst 1 - Loops indefinitely
 * BZ23541          280817    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4 
 * BZ23637          280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23663          280917    Club# is not generated after registering to join in GS club successfuly
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24478          141117    Fee year for RA Join doesn't add to Sale item screen when removed the exists customer and then added a new customer
 * BZ24556          201017    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28567          071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28441          141218    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 3.0
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ29243          290118    [Internal][PLCC] The GS Renew items not add to sale transaction when select to join GS
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ35052          130220    [Porting the fix patch 8.0 to Xstore 6.0][PROD] Roadside Assistance applications being prompted for during Work Order processing
 * BZ37305          080920    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad
 * BZ39446          171120    [TASK] Not need to required the customer for Roundup transaction
 * BZ42363          050421    Issue displaying new email addresses on pinpad for customer verification
 * BZ47818          221221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Strings;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import twitter4j.*;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawProcessCatalystIsCallBackOp extends Operation {

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    private static final Logger       _logger                    = LogManager
            .getLogger(CawAdvancePromptingHelper.class);

    @Inject
    private TransactionScope          _transaction;

    @Inject
    protected StationState            stationState;

    @Override
    public boolean isOperationApplicable() {
        
        /*BEGIN BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*END BZ28855*/

        Boolean isRun = Boolean.FALSE;//BZ-28441
        if (getScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA) != null
                && getScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA)
                        .size() > 0) {
            isRun = Boolean.TRUE;
        }

        return isRun;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IOpResponse iOpResponse = HELPER.completeResponse();

        Map<Integer, CawCatalysCallBackModel> callBackModes = getScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA);
        String lookupResponse = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);
        // Begin BZ24478
        if (lookupResponse == null) {
            lookupResponse = CawCatalystHelper.getLookupResponseData(); // BZ29243
        }
        // End BZ24478
        IPosTransaction iPosTransaction = _transaction.getTransaction();
        IParty party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER); // BZ47818

        // Start BZ-39446
        boolean isPromptingRequireCust = CawCatalystHelper.checkPromtingResponseRequireCustomer(callBackModes);
        
        if (callBackModes != null && party != null
                && StringUtils.isNotEmpty(lookupResponse)
                && iPosTransaction != null) {
            iOpResponse = callCatalystlsResult(iPosTransaction, callBackModes, party, lookupResponse);
        } else if (callBackModes != null && iPosTransaction != null
                && !isPromptingRequireCust) {
            iOpResponse = callCatalystlsResult(iPosTransaction, callBackModes);
        } // End BZ-39446

        CawCatalystHelper.getInputdatals().clear();//BZ23541: Clear data at step select value of input
        return iOpResponse;
    }
    
    // Start BZ-39446
    private IOpResponse callCatalystlsResult(IPosTransaction iPosTransaction,
            Map<Integer, CawCatalysCallBackModel> callBackModes) {

        IOpResponse iOpResponse = HELPER.completeResponse();

        String request = preCallCatalystlsResult(iPosTransaction, callBackModes, null, null);
        iOpResponse = callCatalystlsResult(iPosTransaction, request);
        return iOpResponse;
    }
    
    /**
     * @param argRequest
     * @return
     */
    private IOpResponse callCatalystlsResult(IPosTransaction iPosTransaction, String request) {

        IOpResponse iOpResponse = HELPER.completeResponse();

        if (request != null) {
            _logger.info("[Call Prompting Engine Result API]:"
                    + CawEBSHelper.URL_CATALYST_RESULTS);//BZ29840
            _logger.info("[Prompting Engine Result Request]:" + request); //BZ29840

            //BZ26575 Changed
            ResponseEntity<String> response = CawEBSHelper.getInstance()
                    .sendCatalystResultsToEBS(request);

            if (response != null && StringUtils.isNotEmpty(response.getBody()) //BZ24556
                    && CawEBSHelper.RESPONSE_SUCCESS_CODE == response
                            .getStatusCodeValue()) {
                _logger.info("[Prompting Engine Result Response]:"
                        + response.getBody());//BZ29840
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
                        CawCatalystHelper
                                .setCatalystMessageResponse(messagesObj);
                    }
                    //  Catalyst =1 response data container directives data
                    JSONArray directivesObj = CawCatalystHelper
                            .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                    if (directivesObj != null && directivesObj.length() > 0) {//BZ23541
                        if (CawCatalystHelper
                                .getCatalystDirectiveResponse() == null) {
                            CawCatalystHelper
                                    .setCatalystDirectiveResponse(directivesObj);
                        } else {
                            JSONObject temp;
                            int length = directivesObj.length();
                            for (int i = 0; i < length; i++) {
                                temp = directivesObj.getJSONObject(i);
                                CawCatalystHelper
                                        .setCatalystDirectiveResponse(CawCatalystHelper
                                                .getCatalystDirectiveResponse()
                                                .put(temp));
                            }
                        }
                    }

                    //Save response to DB
                    _cawAdvancePromptingHelper
                            .saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.PROMPTING_ENGINE_CATALYST_RESULT, response
                                    .getBody(), CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);

                    if ((inputObj != null && inputObj.length() > 0)
                            || (messagesObj != null && messagesObj.length() > 0)) {
                        iOpResponse = HELPER
                                .getCompleteStackChainResponse(OpChainKey
                                        .valueOf("CAW_PROCESS_CATALYST_CUSTOMER_IDENTIFIED"));
                    }

                } catch (JSONException ex) {
                    _logger.error("Cant not get data from JSON." + ex.getMessage());
                }
            }
        }
        return iOpResponse;
    }

    private String preCallCatalystlsResult(IPosTransaction iPosTransaction,
            Map<Integer, CawCatalysCallBackModel> callBackModes, IParty party,
            String lookupResponse) {

        String request = null;

        // BZ24556, BZ-39446
        //1. Save data to DB
        _cawAdvancePromptingHelper
                .saveIsCallBackMode(callBackModes, iPosTransaction);

        //2. Send request 
        //Begin BZ28567
        String catalystType = _transactionScope
                .getValue(CawValueKeys.CAW_CATALYST_TYPE);
        if (Strings.isNullOrEmpty(catalystType)) {
            catalystType = "";//if catalystType is null then set blank to determine problem
        }

        /* BEGIN BZ35052: Add attribute workOrderDetail to request */
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        request = _cawAdvancePromptingHelper
                .buildIsCallBackRequest(callBackModes, lookupResponse, party, iPosTransaction, stationState, catalystType, workOrderResult);
        /* END BZ35052 */
        //End BZ28567

        return request;
    }

    /**
     * @param iOpResponse
     * @param callBackModes
     * @param lookupResponse
     * @param iPosTransaction
     * @param party
     * @return
     */
    private IOpResponse callCatalystlsResult(IPosTransaction iPosTransaction,
            Map<Integer, CawCatalysCallBackModel> callBackModes, IParty party,
            String lookupResponse) {

        IOpResponse iOpResponse = HELPER.completeResponse();

        String request = preCallCatalystlsResult(iPosTransaction, callBackModes, party, lookupResponse);

        iOpResponse = callCatalystlsResult(iPosTransaction, request); // BZ-42363

        /* BEGIN BZ37305 */
        boolean isPEUpdateEmail = _cawAdvancePromptingHelper
                .isPEUpdateCustomerEmail(request);
        if (isPEUpdateEmail) {

            _logger.debug("PE have updated the customer email.");
            try {
                JSONObject customerJson = CawJSONUtils.toJSONObject(lookupResponse);
                
                if (customerJson.has(CawEBSConstant.ACCOUNTNUMBER)
                        && customerJson.getString(CawEBSConstant.ACCOUNTNUMBER) != null) {
                    
                    String accountNumber = customerJson
                            .getString(CawEBSConstant.ACCOUNTNUMBER);
                    String locationCode = CawPropertyUtils.STORE_NUMBER;
                    _logger.debug("Call API to lookup the customer");
                    CawCatalystHelper.setLookupResponseData(null);//Clear the customer information before call lookup API
                    lookupResponse = CawEBSHelper.getInstance().lookupCustomerInEBS(accountNumber, locationCode);
                    if (StringUtils.isNotEmpty(lookupResponse)) {
                        CawCatalystHelper.setLookupResponseData(lookupResponse);
                    }
                }
            } catch (JSONException ex) {
                _logger.error("Cant not get data from JSON." + ex.getMessage());
            }
        }
        /* END BZ37305 */

        CawCatalystHelper.setCustomerPartyId(party.getPartyId());

        return iOpResponse;
    } // End BZ-39446

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

}
