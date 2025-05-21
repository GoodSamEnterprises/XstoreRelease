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
 * BZ37396          021020    Tax value calculation issue in Order transactions
 * BZ38436          131020    [Internal] Xstore makes a call TAX API unexpectedly for Sale Transaction without any Order items into the transaction at "At tender" button
 * BZ45871          240821    [Internal] Exception after call Tax API during Electric World order creation with a Wholesale customer
 *===================================================================
 */
package caw.pos.order;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import caw.pos.advance.prompting.CawBuildTaxRequest;
import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.CawValueKeys;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.tax.TaxStrategyFactory;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;

public class CawCalculatetTaxViaTaxAPIOp extends Operation {
    
    private static final Logger  _logger                 = LogManager.getLogger(CawCalculatetTaxViaTaxAPIOp.class);

    @Inject
    private TransactionScope     _transaction;

    @Inject
    protected StationState       stationState;

    private CawBuildTaxRequest   _cawTaxRequest          = CawBuildTaxRequest
            .getInstance();

    @Inject
    private OrderMgr             _orderMgr;

    @Inject
    private TaxStrategyFactory   _taxStrategyFactory;
    
    private static final String  THE_ORDER               = "theOrder";
    
    private static final String  ITEMS                   = "items";
   
    @Override
    public boolean isOperationApplicable() {
        return CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {
        IOrder order = _orderMgr.getCurrentOrder();
        
        if (CawOrderHelper.getInstance().isOrderLinesNotVoid(order)) {  //BZ38436

            try {
                IPosTransaction iPosTransaction = _transaction.getTransaction();
                IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                JSONObject jsonObjectResponse = null;
    
                if (iPosTransaction != null) {
    
                    // send request to Tax API
                    jsonObjectResponse = sendRequestToTaxAPI(iPosTransaction, party, order);
                    
                    if (jsonObjectResponse != null) {
                        setScopedValue(CawValueKeys.CAW_TAX_RESPONSE, jsonObjectResponse);
                        // get response from transaction scope
                        JSONObject theOrder = jsonObjectResponse.getJSONObject(THE_ORDER);
                        JSONArray items = theOrder.getJSONArray(ITEMS);
                       
                        CawOrderHelper.getInstance().updateTaxModifier(items, order, iPosTransaction);
    
                    }
                }
            } catch (Exception ex) {
                _logger.error("[Exception happen when mapping Tax Response]: " + ex.getMessage());
            }
        }

        return HELPER.completeResponse();
    }

    /**
     * @param iPosTransaction
     * @param party
     * @param order
     * @param jsonObjectResponse
     * @return
     * @throws JSONException
     */
    private JSONObject sendRequestToTaxAPI(IPosTransaction iPosTransaction, IParty party, IOrder order) throws JSONException {

        JSONObject jsonObjectResponse = null;
        ResponseEntity<String> response;
        String taxRequestJson = _cawTaxRequest.buildTaxRequestTemplate(order, iPosTransaction, party, stationState, _taxStrategyFactory, getlookupData()); //BZ45871
        if (taxRequestJson != null) {
            _logger.info("[Call TAX API]:" + CawEBSHelper.URL_TAX_REQUEST);
            _logger.info("[TAX Request]:" + taxRequestJson);

            response = CawEBSHelper.getInstance().sendTaxRequestToEBS(taxRequestJson);
            if (response != null && CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                _logger.info("[Tax Response]: " + response.getBody());
                jsonObjectResponse = new JSONObject(response.getBody());
            }
        }
        return jsonObjectResponse;
    }
    
    /* BEGIN BZ45871 */
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
    /* END BZ45871 */
}
