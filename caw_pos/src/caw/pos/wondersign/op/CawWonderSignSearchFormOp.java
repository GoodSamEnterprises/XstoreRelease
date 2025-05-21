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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 *===================================================================
 */

package caw.pos.wondersign.op;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawInputSingleChoice;
import caw.pos.common.*;
import caw.pos.wondersign.model.CawWonderSignSearchFormModel;
import caw.pos.wondersign.util.CawWonderSignHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.FormKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawWonderSignSearchFormOp extends AbstractFormOp<CawWonderSignSearchFormModel> {

    private static final Logger            _logger           = LogManager.getLogger(CawWonderSignSearchFormOp.class);
    private CawWonderSignHelper            _wonderSignHelper = CawWonderSignHelper.getInstance();

    @Override
    protected CawWonderSignSearchFormModel createModel() {

        CawWonderSignSearchFormModel model = new CawWonderSignSearchFormModel();

        CawInputSingleChoice dateRange = new CawInputSingleChoice();
        dateRange.setInputId(CawWonderSignHelper.SPECIFIC_DATE);
        dateRange.setInputLable(CawWonderSignHelper.SPECIFIC_DATE);
        
        IParty selectedCustomer = getScopedValue(ValueKeys.SELECTED_CUSTOMER);

        model.setDateRange(dateRange);
        model.setFirstName(selectedCustomer.getFirstName());
        model.setLastName(selectedCustomer.getLastName());
        
        if (StringUtils.isNotEmpty(selectedCustomer.getTelephone3())) {
            model.setPhoneNumber(selectedCustomer.getTelephone3());
        } else if (StringUtils.isNotEmpty(selectedCustomer.getTelephone1())) {
            model.setPhoneNumber(selectedCustomer.getTelephone1());
        } else if (StringUtils.isNotEmpty(selectedCustomer.getTelephone2())) {
            model.setPhoneNumber(selectedCustomer.getTelephone2().substring(0, 11));
        }

        return model;
    }

    @Override
    protected FormKey getFormKey() {

        return FormKey.valueOf("CAW_WONDER_SIGN_SEARCH");
    }

    @Override
    protected DataActionGroupKey getActionGroupKey() {

        return DataActionGroupKey.DEFAULT;
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        CawWonderSignSearchFormModel model = getModel();

        String fromDate = "";
        String toDate = "";

        fromDate = CawUtilFunction.convertDateFormatMMDDYYY(model.getFromDate());
        toDate = CawUtilFunction.convertDateFormatMMDDYYY(model.getToDate());
        
        int cartSalesChannelId = getCartSalesChannelId();

        ResponseEntity<String> response = _wonderSignHelper.searchCart(_stationState.getRetailLocationId(), cartSalesChannelId
                , _stationState.getWorkstationId(), fromDate, toDate, model.getFirstName(), model.getLastName(), model.getPhoneNumber());
        
        if (response != null) {
            if (response.getStatusCode() == HttpStatus.OK) { // Response code is 200
                try {
                    
                    JSONObject resJsonObject = new JSONObject(response.getBody());

                    int searchStatus = resJsonObject.getInt(CawJSONConstant.JSON_CART_SEARCH_STATUS);

                    if (searchStatus == CawWonderSignHelper.SEARCH_CART_SUCCESS_STATUS) { // status: success
                        _transactionScope.setValue(CawValueKeys.CAW_CART_SEARCH_RESPONSE, response.getBody());
                        return HELPER.completeResponse();
                    } else if (searchStatus == CawWonderSignHelper.SEARCH_CART_ERROR_STATUS) {
                        String errorMsg = "";

                        JSONObject errorJsonObject = resJsonObject.getJSONObject(CawJSONConstant.JSON_CART_SEARCH_ERRORS);
                        errorMsg = getErrorMsg(errorJsonObject);

                        IFormattable[] formattable = new IFormattable[1];
                        formattable[0] = FormattableFactory.getInstance().getSimpleFormattable(errorMsg);

                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_WONDERSIGN_CART_SEARCH_ERROR")
                                , formattable);
                    }

                } catch (JSONException ex) {
                    _logger.error("Unable to parse JSON: " + ex.getMessage());
                }
                
            } else {
                _logger.error("Neuron response not 200");
            }
        } else {
            _logger.error("Null response from search cart");
        }

        return HELPER.completeResponse();
    }
    
    @SuppressWarnings("unchecked")
    private String getErrorMsg(JSONObject errorJsonObject) throws JSONException {
        String errorMsg = "";
        List<String> errorMsgList = new ArrayList<>();
        Iterator<String> keys = errorJsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();

            if (errorJsonObject.get(key) instanceof String) {
                String value = errorJsonObject.getString(key);

                errorMsgList.add(key + ": " + value);
            }
        }
        
        if (errorMsgList.size() > 0) {
            errorMsg = String.join("\n", errorMsgList);
        }
        
        return errorMsg;
    }
    
    private int getCartSalesChannelId() {
        int cartSalesChannelId = _stationState.getRetailLocationId();
        
        String wonderSignTestStr = System.getProperty("caw.pos.wondersign.development");
        
        if (StringUtils.isNotEmpty(wonderSignTestStr)) {
            Boolean isWonderSignTest = Boolean.parseBoolean(wonderSignTestStr);
            
            if (isWonderSignTest) cartSalesChannelId = 300;
        }
        
        return cartSalesChannelId;
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {
    
        IXstActionKey actionKey = argAction.getActionKey();
        
        if (actionKey == XstDataActionKey.valueOf("BACK_SEARCH")) {
            return HELPER.getOpChainRollBackRequest();
        }
        
        return super.handleDataAction(argAction);
    }

}
