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
 * BZ23478          200917    [Prompting] Update Catalyst = 1 request
 * BZ23683          021017    Need to initiate a Catalyst 1 Customer Lookup call to the prompting engine when a new customer is created
 * BZ23741          051017    "Previous" button should be disabled for the first prompting engine with trigger catalyst = 4
 * BZ23722          061017    [Prompting Engine] Missing the correlation key in the directive feedback
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ23996          151017    [Advanced prompting] GSM Prompts again after adding it to the sale item screen
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24385          081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24383          091117    "Auto-Renew" term should be printed on receipt when choosing "Auto-renew membership sold"
 * BZ24556          201117    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ26025          200418    [Catalyst 4] No prompting engine request data at catalyst=4 is sent to ESB when assigning a new customer just created during transaction
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28567          071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ28033          200219    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ35052          130220    [Porting the fix patch 8.0 to Xstore 6.0][PROD] Roadside Assistance applications being prompted for during Work Order processing
 * BZ35054          180220    [Ported the fix from patch 8 to Xstore 6.0][Prod] Roadside Assistance prompt on a crew account
 * BZ40898          290121    Prompting for memberships on OB orders
 * BZ40798          240221    Modification to member savings calculation
 * BZ45160          100821    [Internal] Can complete the transaction paid other tender types not credit card even though the transaction receives directive: 10 for credit card required
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
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import twitter4j.*;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawProcessCatalystTransactionTotalOp class
 */
public class CawProcessCatalystTransactionTotalOp extends Operation {

    @Inject
    private TransactionScope             _transaction;

    private static final Logger          _logger                    = LogManager
            .getLogger(CawProcessCatalystTransactionTotalOp.class);

    private CawAdvancePromptingHelper    _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    @Inject
    protected StationState               stationState;

    public static final ValueKey<String> ACCOUNT_NUMBER_TEST        = new ValueKey<String>(
            String.class, "ACCOUNT_NUMBER_TEST");

    @Inject
    private OrderMgr                     _orderMgr; /*BZ40898*/
    
    @Override
    public boolean isOperationApplicable() {
        
        /*BEGIN BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*END BZ28855*/

        boolean isRun = false;
        if (_transaction != null
                && _transaction
                        .getTransaction(TransactionType.RETAIL_SALE) != null) { // BZ33231

            /* Begin BZ28265, BZ33231 */
            if (CawCatalystHelper
                    .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
                if (CawCatalystHelper
                        .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_TOTAL)) {
                    /* BEGIN BZ35054 */
                    if (CawCatalystHelper.checkCatalystDirectiveType8()) {
                        clearScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA);
                        isRun = false;
                    } else {
                        isRun = true;
                    }
                    /* END BZ35054 */
                } else {
                    CawCatalystHelper.setCatalystMessageResponse(null);
                    CawCatalystHelper.setCatalystInputsResponse(null);
                }
            }
            /* End BZ28265, BZ33231 */
            // Begin BZ23741
            clearScopedValue(CawValueKeys.ELEMENT_ACTIVE);
            clearScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT);
            clearScopedValue(CawValueKeys.IS_COMPLETED_VALIDATION); // BZ24385
            _transactionScope.clearValue(CawValueKeys.IS_AUTO_RENEW); // BZ24383
            // End BZ23741
            // Begin BZ23722
            // clearScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA);
            // End BZ23722
        } else {
            // Begin BZ23996
            CawCatalystHelper.setCatalystDirectiveResponse(null);
            CawCatalystHelper.setCatalystInputsResponse(null);
            CawCatalystHelper.setCatalystMessageResponse(null);
            // End BZ23996
        }

        return isRun;

    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /* BEGIN BZ28033 */
        if (_transactionScope != null) {
            _transactionScope.clearValue(CawValueKeys.IS_RESENT_CATALYST_4);
        }
        /* END BZ28033 */

        IOpResponse iOpResponse = HELPER.completeResponse();
        try {
            IPosTransaction iPosTransaction = _transaction.getTransaction();
            IParty party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER); //BZ47818
            //Begin BZ26025
            String lookupResponseDataResponse = getlookupData();
            //End BZ26025
       
            if (iPosTransaction != null) {//BZ24556, BZ33231
                /* BEGIN BZ35052: Add attribute workOrderDetail to request */
                CawWorkOrderEBSQueryResult workOrderResult = _transactionScope.getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
                String requestJson = _cawAdvancePromptingHelper
                        .buildCatalystTransactionTotalRequest(lookupResponseDataResponse, iPosTransaction, party, stationState, workOrderResult, _orderMgr
                                .getCurrentOrder());/*BZ40898*/
                /* END BZ35052 */
                
                if (requestJson != null) {
                    _logger.info("[Call Prompting Engine Catalyst 4 API]:"+ CawEBSHelper.URL_CATALYST_REQUEST);//BZ29840
                    _logger.info("[Prompting Engine Catalyst 4 Request]:"+ requestJson);//BZ23478, BZ29840

                    //BZ26575 changed
                    ResponseEntity<String> response = CawEBSHelper.getInstance()
                            .sendCatalystRequestToEBS(requestJson);
                    if (response != null
                            && CawEBSHelper.RESPONSE_SUCCESS_CODE == response
                                    .getStatusCodeValue()) {
                        _logger.info("[Prompting Engine Catalyst 4 Response]:"
                                + response.getBody()); //BZ23478
                        //Set value catalyst 4 into CAW_CATALYST_TYPE for results
                        _transactionScope
                                .setValue(CawValueKeys.CAW_CATALYST_TYPE, CawConstants.VALUE_4
                                        .toString());//BZ28567
                        try {
                            JSONObject jsonObjectResponse = new JSONObject(
                                    response.getBody());
                            //  Catalyst = 4 response data container inputs data
                            JSONArray inputObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_INPUT_TYPE);
                            if (inputObj != null) {
                                CawCatalystHelper
                                        .setCatalystInputsResponse(inputObj);
                            } else {
                                // Begin BZ23996
                                CawCatalystHelper
                                        .setCatalystInputsResponse(null);
                                // End BZ23996
                            }

                            //  Catalyst = 4 response data container messages data
                            JSONArray messagesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_MESSAGES_TYPE);
                            if (messagesObj != null) {
                                CawCatalystHelper
                                        .setCatalystMessageResponse(messagesObj);
                            } else {
                                // Begin BZ23996
                                CawCatalystHelper
                                        .setCatalystMessageResponse(null);
                                // End BZ23996
                            }

                            //  Catalyst = 4 response data container directives data
                            JSONArray directivesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                            if (directivesObj != null) {
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
                                        /* Begin BZ28265 */
                                        String olpsPrescreenID = CawCatalystHelper
                                                .getDirectiveType(temp);
                                        setScopedValue(CawValueKeys.OLPS_PRESCREEN_ID, olpsPrescreenID);
                                        /* End BZ28265 */
                                    }
                                }
                            /*BEGIN BZ45160*/
                            } else {
                                CawCatalystHelper.setCatalystDirectiveResponse(null);
                            }
                            /*END BZ45160*/
                            setScopedValue(CawValueKeys.CATALYST_TRANSACTION_TOTAL_RESPONSE, response
                                    .getBody());

                            //Save response to DB
                            _cawAdvancePromptingHelper
                                    .saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.PROMPTING_ENGINE_CATALYST_FOUR, response
                                            .getBody(), CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);

                            //Save New Attribute to DB
                            _cawAdvancePromptingHelper.saveGoodSamSavingInfo(_transactionScope, iPosTransaction, party); // BZ40798
                        } catch (Exception ex) {
                            _logger.error("Cant not get data from JSON."
                                    + ex.getMessage());
                        }
                    } else {
                        CawCatalystHelper.setCatalystInputsResponse(null);
                        iOpResponse = HELPER.completeCurrentChainResponse();
                    }
                }
            } else {//Begin BZ23683
                CawCatalystHelper.setCatalystInputsResponse(null);
                iOpResponse = HELPER.completeCurrentChainResponse();
            } //End BZ23683
        } catch (Exception ex) {
            _logger.error("Send request Catalyst = 4 to EBS service."
                    + ex.getMessage());
        }

        return iOpResponse;
    }
    
    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

    //Begin BZ26025
    /**
     * get lookup Data
     * @param argLookupResponseData
     */
    private String getlookupData() {

        try {
            String argLookupResponseData = CawCatalystHelper
                    .getLookupResponseData();
            if (StringUtils.isNotEmpty(argLookupResponseData)) {
                return argLookupResponseData;
            } else {
                String argValue = _transactionScope
                        .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
                if (StringUtils.isNotEmpty(argValue)) {
                    return argValue;
                } else {
                    String argScopedValue = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);
                    if (StringUtils.isNotEmpty(argScopedValue)) {
                        return argScopedValue;
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("getlookupData()-Can't get data from Lookup response data", ex);
        }
        return "";
    }
    //End BZ26025
}