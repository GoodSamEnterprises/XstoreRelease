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
 * BZ25435          160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ26982          290818    [1.6.2] Do NOT submit OLPS request if the customer is a wholesale customer
 * BZ27651          200918    [New Requirement] Add the saleperson to the requests of Card Services API
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 *===================================================================
 */

package caw.pos.card.services;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.JSONObject;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * Call to the submit service, The submit service allows clients to initiate 
 * the Online Prescreen (OLPS) process for a customer. The OLPS process consists of two service calls. 
 * The process begins with a submit request which returns a request ID. 
 * At some later time, the client will call the status method to determine the status of the request.
 * 
 */
public class CawCardServiceAPISubmitOp extends Operation {

    private static final Logger _logger = LogManager.getLogger(CawCardServiceAPISubmitOp.class);

    @Inject
    protected StationState      stationState;

    @Override
    public boolean isOperationApplicable() {
        
        /*BEGIN BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*END BZ28855*/
        // Begin BZ26982
        JSONObject cutomerInfoJson = CawJSONUtils.toJSONObject(CawCatalystHelper.getLookupResponseData());
        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        IParty party = null;
        if (trans != null) {
            party = trans.getCustomerParty();
        }
        // End BZ26982
        /* Begin BZ28265 */
        if ((_transactionScope.getValue(CawValueKeys.SUBMIT_REQUEST_ID) == null)
                && (CawCatalystHelper.isCardServicesTurnedOn())
                && (StringUtils.isNotEmpty(CawCatalystHelper.getLookupResponseData()))
                && (!CawCustomerUtil.isWhslCustomer(party)) && (!CawCustomerUtil.isNullName(cutomerInfoJson))) {
            return true;
        }
        /* End BZ28265 */
        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            // Convert the customer info to JSon object.
            JSONObject cutomerInfoJson = CawJSONUtils.toJSONObject(CawCatalystHelper.getLookupResponseData());
            // Prepare the Submit request for sent to EBS
            /* BEGIN BZ28247 */
            String submitRequest = buildSubmitRequest(cutomerInfoJson);
            /* END BZ28247 */
            if (StringUtils.isNotEmpty(submitRequest)) {
                ResponseEntity<String> response = CawEBSHelper.getInstance()
                        .sendCardServicesSubmitRequestToEBS(submitRequest);

                if (response != null && CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                    // Convert the result response from Submit API to Json Object
                    JSONObject submitResponse = CawJSONUtils.toJSONObject(response.getBody());
                    // Check the response have container requestId
                    if (submitResponse != null && !submitResponse.isNull(CawEBSConstant.REQUEST_ID)) {
                        String requestId = submitResponse.getString(CawEBSConstant.REQUEST_ID);
                        /** 
                         * The requestId save temporary to transaction scope. 
                         * The class CawCardServiceAPIStatusOp in CAW_CARD_SERVICE_STATUS opChain will be run when the requestId is exist in transaction scope
                         */
                        _transactionScope.setValue(CawValueKeys.SUBMIT_REQUEST_ID, requestId);
                    }
                }
            }
        } catch (Exception ex) {
            _logger.info("The submit request can not sent to ESB." + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

    
    
    /* BEGIN BZ28247 */
    /**
     * Build submit request.
     * @param cutomerInfoJson
     * @return
     */
    private String buildSubmitRequest(JSONObject cutomerInfoJson) {

        CawRestConfig templateContentObj = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.CARD_SERVICES_API_SUBMIT_REQUEST_TEMPLATE);

        String submitRequest = "";
        if (templateContentObj != null && StringUtils.isNotEmpty(templateContentObj.getBody())) {
            try {
                JSONObject submitRequestJson = new JSONObject(templateContentObj.getBody());

                if (!submitRequestJson.isNull(CawEBSConstant.SALES_CHANNEL_ATTR)
                        && submitRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR) != null) {
                    submitRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                            .put(CawEBSConstant.SALES_CHANNEL_ID_ATTR, stationState.getRetailLocationId());
                    submitRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                            .put(CawEBSConstant.TERMINAL, stationState.getWorkstationId());
                }

                // Begin BZ27651
                IPosTransaction iPosTransaction = _transactionScope.getTransaction();
                if (iPosTransaction != null && iPosTransaction.getOperatorParty() != null) {
                    JSONObject cashierInfo = CawCustomerUtil
                            .buildCashierInfoJSONObject(iPosTransaction.getOperatorParty());
                    if (cashierInfo != null) {
                        submitRequestJson.put(CawJSONConstant.CASHIER, cashierInfo);
                    }
                }
                // End BZ27651

                if (cutomerInfoJson != null) {
                    submitRequestJson.put(CawEBSConstant.THE_CUSTOMER_SOURCE, Integer.parseInt(CawConstants.VALUE_1));
                }

                if (cutomerInfoJson != null) {
                    submitRequestJson.put(CawEBSConstant.THE_CUSTOMER_ATTR_V2, cutomerInfoJson);
                }

                submitRequest = submitRequestJson.toString();

            } catch (Exception ex) {
                _logger.debug("The submit request can not build from template." + ex.getMessage());
            }
        }

        return submitRequest;

    }
    /* END BZ28247 */

}
