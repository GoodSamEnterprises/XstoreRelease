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
 * BZ27651          200918    [New Requirement] Add the saleperson to the requests of Card Services API
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 * BZ29240          290119    [Internal][PLCC] The Pre-Approved Credit Offer screen always display thought the EBS response pre-screenID =0
 * BZ29326          130219    Card Service 2 - Read the makeCreditOffer atrribute from OLPS status call and make the credit offer if the flag is true
 * BZ29979          290319    [INTERNAL] Xstore got decline when tendering by Token of GSVS.
 * BZ33136          191119    [Prod] Issue with GS Visa credit card applications during work orders.
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ37623          100120    [Requirement] Existing Card Services API should be prevented at Pickup process for the order broker transaction. 
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
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import twitter4j.JSONObject;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;

/**
 * The status service allows clients to check the status of a previously submitted OLPS request
 */
public class CawCardServiceAPIStatusOp extends Operation {

    private static final Logger _logger = LogManager.getLogger(CawCardServiceAPIStatusOp.class);

    @Inject
    protected StationState      stationState;
    /* BEGIN BZ28247 */
    /**
     * The _gsHelper
     */
    private CawCustomerGSHelper  _gsHelper             = CawCustomerGSHelper.getInstance();

    /* END BZ28247 */

    //BEGIN BZ37623
    @Inject
    private OrderMgr            _orderMgr;
    //END BZ37623

    @Override
    public boolean isOperationApplicable() {
        
        /*BEGIN BZ28855*/
        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }
        /*END BZ28855*/
        //BEGIN BZ37623
        IOrder curentOrder = _orderMgr.getCurrentOrder();
        if (curentOrder != null) {
            OrderStatus orderStatus = OrderStatus.forName(curentOrder.getStatusCode());
            if (!OrderStatus.NEW.equals(orderStatus)) {
                return false;
            }
        }
        //END BZ37623
        if (_transactionScope != null
                && StringUtils.isNotEmpty(_transactionScope.getValue(CawValueKeys.SUBMIT_REQUEST_ID))
                && CawCatalystHelper.isCardServicesTurnedOn()//BZ28265
                && !CawWorkOrderOptionsOp.isDepositAction())/*BZ33136*/
        {
            return true;
        }

        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            String requestId = _transactionScope.getValue(CawValueKeys.SUBMIT_REQUEST_ID);
            // Prepare the Status request for sent to EBS
            /* BEGIN BZ28247 */
            String statusRequest = "";
            if (StringUtils.isNotEmpty(requestId)) {
                statusRequest = buildStatusRequest(requestId);
            }
            if (StringUtils.isNotEmpty(statusRequest)) {
                ResponseEntity<String> response = CawEBSHelper.getInstance()
                        .sendCardServicesSatusRequestToEBS(statusRequest);
                if (response != null && CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {

                    // Convert the response to JSon object.
                    /* BEGIN BZ28247 */
                    //String repre = "{'prescreenId':'1234','cardType':1,'cardTypeDescription':'', 'makeCreditOffer': true}"; //"Need to remove out of TRUNK BRANCH"
                    JSONObject statusResponse = CawJSONUtils.toJSONObject(response.getBody());

                    if (statusResponse == null) {
                        CawSubmitStatusResponse submitStatusResponse = new CawSubmitStatusResponse("", 0,
                                CawConstants.CARD_TYPE_NOT_SPECIFIED);
                        _transactionScope.setValue(CawValueKeys.CAW_SUBMIT_STATUS_RESPONSE, submitStatusResponse);
                    }

                    // Check the response have container prescreenId and check prescreenId != 0 for BZ29240
                    
                    /* BEGIN BZ29326 */
                    /* BEGIN BZ29240*/
                    if (statusResponse != null && !statusResponse.isNull(CawEBSConstant.PRESCREEN_ID)) {

                        String prescreenId = statusResponse.getString(CawEBSConstant.PRESCREEN_ID);
                        
                        boolean makeCreditOffer = statusResponse.getBoolean(CawEBSConstant.MAKE_CREDIT_OFFER);

                        if (StringUtils.isNotEmpty(prescreenId) && !CawConstants.VALUE_0.equals(prescreenId)
                                && !statusResponse.isNull(CawEBSConstant.CARD_TYPE)
                                && !statusResponse.isNull(CawEBSConstant.CARD_TYPE_DESCRIPTION) && makeCreditOffer) {

                            int cardType = statusResponse.getInt(CawEBSConstant.CARD_TYPE);

                            String cardTypeDescription = statusResponse.getString(CawEBSConstant.CARD_TYPE_DESCRIPTION);
                            if (cardType == 0 && StringUtils.isEmpty(cardTypeDescription)) {
                                cardType = 1;
                                cardTypeDescription = CawConstants.CARD_TYPE_DESCRIPTION;
                            }
                            /* END BZ29240 */
                            CawSubmitStatusResponse submitStatusResponse = new CawSubmitStatusResponse(prescreenId,
                                    cardType, cardTypeDescription);
                            /** 
                             * The prescreenId save temporary to transaction scope. 
                             * The class CawCallGSPreScreenOp in CAW_CARD_SERVICE_STATUS opChain will be run when the prescreenId is exist in transaction scope
                             */
                            _gsHelper.setPreScreenId(prescreenId);
                            /*BEGIN BZ29979
                             * Since card type only be updated through Credit Application, Account Lookup
                             * After that, the card type value != 0 and should not override by card type
                             * from Card Service API status's response*/
                            if (_gsHelper.getCardType() == 0) {
                                _gsHelper.setCardType(submitStatusResponse.getCardType());
                            }
                            /*END BZ29979*/
                            _transactionScope.setValue(CawValueKeys.CAW_SUBMIT_STATUS_RESPONSE, submitStatusResponse);
                            /* END BZ28247 */
                        } else {
                            _gsHelper.setPreScreenId("0");
                        }
                        /* END BZ29326 */
                    }
                }
            }

        } catch (Exception ex) {
            _logger.info("The status request can not sent to ESB." + ex.getMessage());
        }

        return HELPER.completeResponse();
    }
    
    /* BEGIN BZ28247 */
    /**
     * The build Status request
     * @param requestId
     * @return
     */
    private String buildStatusRequest(String requestId) {

        CawRestConfig templateContentObj = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.CARD_SERVICES_API_STATUS_REQUEST_TEMPLATE);
        String statusRequest = "";
        if (templateContentObj != null && StringUtils.isNotEmpty(templateContentObj.getBody())) {
            try {
                JSONObject statusRequestJson = new JSONObject(templateContentObj.getBody());
                if (!statusRequestJson.isNull(CawEBSConstant.SALES_CHANNEL_ATTR)
                        && statusRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR) != null) {
                    statusRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                            .put(CawEBSConstant.SALES_CHANNEL_ID_ATTR, stationState.getRetailLocationId());
                    statusRequestJson.getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                            .put(CawEBSConstant.TERMINAL, stationState.getWorkstationId());
                }

                // Begin BZ27651
                IPosTransaction iPosTransaction = _transactionScope.getTransaction();
                if (iPosTransaction != null && iPosTransaction.getOperatorParty() != null) {
                    JSONObject cashierInfo = CawCustomerUtil
                            .buildCashierInfoJSONObject(iPosTransaction.getOperatorParty());
                    if (cashierInfo != null) {
                        statusRequestJson.put(CawJSONConstant.CASHIER, cashierInfo);
                    }
                }
                // End BZ27651

                if (StringUtils.isNotEmpty(_transactionScope.getValue(CawValueKeys.SUBMIT_REQUEST_ID))) {
                    statusRequestJson.put(CawEBSConstant.REQUEST_ID, CawJSONUtils.vLong(requestId));
                }

                statusRequest = statusRequestJson.toString();

            } catch (Exception ex) {
                _logger.debug("The status request can not build from tempplate." + ex.getMessage());
            }
        }

        return statusRequest;

    }
    /* END BZ28247 */

}
