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
 * BZ24904          201217    Multiple transaction total calls for each order when the first 
 *                            transaction total call doesn't return any messages, directives or inputs.
 * BZ24904          261217    Multiple transaction total calls for each order when the first 
 *                            transaction total call doesn't return any messages, directives or inputs.
 * BZ26025          200418    [Catalyst 4] No prompting engine request data at catalyst=4 is sent to ESB when assigning a new customer just created during transaction
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28567          071218    [Internal] (patch issue)Missing item for Prompting Engine Catalyst 4 calls to the new PE Services for Xstore 2.1
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ28033          200219    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ35052          130220    [Porting the fix patch 8.0 to Xstore 6.0][PROD] Roadside Assistance applications being prompted for during Work Order processing
 * BZ35054          180220    [Ported the fix from patch 8 to Xstore 6.0][Prod] Roadside Assistance prompt on a crew account
 * BZ40898          290121    Prompting for memberships on OB orders
 * BZ40798          240221    Modification to member savings calculation
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
import twitter4j.JSONArray;
import twitter4j.JSONObject;

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
 * The CawProcessResendCatalyst4Op
 */
public class CawProcessResendCatalyst4Op extends Operation {

    @Inject
    private TransactionScope             _transaction;

    private static final Logger          _logger                    = LogManager
            .getLogger(CawProcessResendCatalyst4Op.class);

    private CawAdvancePromptingHelper    _cawAdvancePromptingHelper = CawAdvancePromptingHelper.getInstance();

    @Inject
    protected StationState               stationState;
    
    @Inject
    private OrderMgr                     _orderMgr; /*BZ40898*/
    
    public static final ValueKey<String> ACCOUNT_NUMBER_TEST        = new ValueKey<String>(String.class,
            "ACCOUNT_NUMBER_TEST");

    @Override
    public boolean isOperationApplicable() {
        
        /*BEGIN BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*END BZ28855*/
        Boolean isRun = Boolean.FALSE;
        /* BEGIN BZ28033 */
        Boolean isResendCatalyst4 = _transactionScope.getValue(CawValueKeys.IS_RESENT_CATALYST_4);

        // Begin BZ24904, BZ28265, BZ33231: set parameter check catalyst4: CAW_TURN_ON_PE_TOTAL 
        if (CawCatalystHelper
                .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
            if (CawCatalystHelper.getCatalystInputsResponse() != null
                    && isResendCatalyst4 != null
                    && isResendCatalyst4.booleanValue() && CawCatalystHelper
                            .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_TOTAL)) {
                /* BEGIN BZ35054 */
                if (CawCatalystHelper.checkCatalystDirectiveType8()) {
                    isRun = Boolean.FALSE;
                } else {
                    isRun = Boolean.TRUE;
                }
                /* END BZ35054 */
            }
        }
        // End BZ24904, BZ28265, BZ33231
        /* END BZ28033 */
        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IOpResponse iOpResponse = HELPER.completeResponse();
        try {
            IPosTransaction iPosTransaction = _transaction.getTransaction();
            IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            //Begin BZ26025
            String lookupResponseDataResponse = getlookupData();
            //End BZ26025
            if (iPosTransaction != null && party != null && StringUtils.isNotEmpty(lookupResponseDataResponse)) {//BZ24556
                /* BEGIN BZ35052: Add attribute workOrderDetail to request */
                CawWorkOrderEBSQueryResult workOrderResult = _transactionScope.getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
                String requestJson = _cawAdvancePromptingHelper
                        .buildCatalystTransactionTotalRequest(lookupResponseDataResponse, iPosTransaction, party, stationState, workOrderResult, _orderMgr
                                .getCurrentOrder());/*BZ40898*/
                /* END BZ35052 */
                
                //setScopedValue(CawValueKeys.RESQUEST_CATALYST_4, requestJson);
                //Set value catalyst 4 into CAW_CATALYST_TYPE for results
                _transactionScope.setValue(CawValueKeys.CAW_CATALYST_TYPE, CawConstants.VALUE_4.toString());//BZ28567
                if (requestJson != null) {
                    _logger.info("Membership resend [Catalyst=4] request:" + requestJson);//BZ24354
                    //BZ26575 changed with CawEBSHelper
                    ResponseEntity<String> response = CawEBSHelper.getInstance().sendCatalystRequestToEBS(requestJson);
                    if (response != null && CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                        _logger.info("Membership resend [Catalyst=4] response data:" + response.getBody()); //BZ24354

                        try {
                            JSONObject jsonObjectResponse = new JSONObject(response.getBody());
                            //  Catalyst = 4 response data container inputs data
                            JSONArray inputObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_INPUT_TYPE);
                            if (inputObj != null) {
                                CawCatalystHelper.setCatalystInputsResponse(inputObj);
                            } else {
                                CawCatalystHelper.setCatalystInputsResponse(null);
                            }

                            //  Catalyst = 4 response data container messages data
                            JSONArray messagesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_MESSAGES_TYPE);
                            if (messagesObj != null) {
                                CawCatalystHelper.setCatalystMessageResponse(messagesObj);
                            } else {
                                CawCatalystHelper.setCatalystMessageResponse(null);
                            }

                            //  Catalyst = 4 response data container directives data
                            JSONArray directivesObj = CawCatalystHelper
                                    .catalystDataByType(jsonObjectResponse, CawEBSConstant.CATALYST_DIRECTIVES_TYPE);
                            if (directivesObj != null) {
                                if (CawCatalystHelper.getCatalystDirectiveResponse() == null) {
                                    CawCatalystHelper.setCatalystDirectiveResponse(directivesObj);
                                } else {
                                    JSONObject temp;
                                    int length = directivesObj.length();
                                    for (int i = 0; i < length; i++) {
                                        temp = directivesObj.getJSONObject(i);
                                        CawCatalystHelper.setCatalystDirectiveResponse(CawCatalystHelper
                                                .getCatalystDirectiveResponse().put(temp));
                                    }
                                }
                            }

                            setScopedValue(CawValueKeys.CATALYST_TRANSACTION_TOTAL_RESPONSE, response.getBody());
                            //Save New Attribute to DB
                            _cawAdvancePromptingHelper
                                    .saveGoodSamSavingInfo(_transactionScope, iPosTransaction, party); // BZ40798 - Update to DB since customer upgrade
                        } catch (Exception ex) {
                            _logger.error("Membership resend cant not get data from JSON." + ex.getMessage());
                        }
                    } else {
                        CawCatalystHelper.setCatalystInputsResponse(null);
                    }
                }
            } else {
                CawCatalystHelper.setCatalystInputsResponse(null);
            }

        } catch (Exception ex) {
            _logger.error("Membership resend Catalyst = 4 to EBS service." + ex.getMessage());
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
            String argLookupResponseData = CawCatalystHelper.getLookupResponseData();
            if (StringUtils.isNotEmpty(argLookupResponseData)) {
                return argLookupResponseData;
            } else {
                String argValue = _transactionScope.getValue(CawValueKeys.API_LOOKUP_RESPONSE);
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
            _logger.error("getlookupData-1: Can't get data from Lookup response data", ex);
        }
        return "";
    }
    //End BZ26025
}