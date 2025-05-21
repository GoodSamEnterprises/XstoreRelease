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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ46259          150921    [Internal] IDS Payment - RV Service Payments Search Results screen should exclude the payments that already added to the current transaction.
 * BZ46257          150921    [Internal] IDS Payment - Xstore displays 'RV service payment not found' instead of 'RV service payment search screen' when hit Add another payment after selected all payment result into transaction.
 * BZ47542          061221    RV Service Payments - Property Names
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawRvPaymentSearchListOp extends AbstractListPromptOp {

    private CawBuildRvPaymentRequest _cawBuildRvPaymentRequest = CawBuildRvPaymentRequest
            .getInstance();

    private static final Logger      _logger                   = LogManager.getLogger(CawRvPaymentSearchListOp.class);

    private boolean                  isSearchError             = Boolean.FALSE;
    
    private boolean                  isBackToSearchScren       = Boolean.FALSE;/*BZ46257*/

    private static final String      BUTTON_RETRY              = "RETRY";

    private static final String      BUTTON_SELECTION_COMPLETE = "SELECTION_COMPLETE";

    @Inject
    private IBusyState               _busyState;

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_RV_PAYMENT_ITEMS");
    }

    @Override
    protected Object[] getPromptList(IXstEvent argVar1) {

        //call RV payment service
        List<CawRvPaymentModel> rvPaymentList = callRvPaymentService();
        //remove item existed into transaction
        removeItemExistInTrans(rvPaymentList);/*BZ46259*/
        //remove item selected
        List<CawRvPaymentModel> rvSelectedItems = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST);
        if(rvSelectedItems != null && rvSelectedItems.size() > 0) {
            BigDecimal rvAmount = null;
            String properties = null;
            for(CawRvPaymentModel rvPaymentSelected : rvSelectedItems) {
                for(int i = 0; i < rvPaymentList.size();i++) {
                    CawRvPaymentModel rvPayment = rvPaymentList.get(i);
                    rvAmount = rvPayment.getRvAmount();
                    properties = rvPayment.getProperties();
                    if(rvAmount.compareTo(rvPaymentSelected.getRvAmount()) == 0 && properties.equals(rvPaymentSelected.getProperties())) {
                        rvPaymentList.remove(rvPayment);
                    }
                }
            }
            /*BEGIN BZ46257*/
            if(rvPaymentList.size() == 0) {
                isBackToSearchScren = Boolean.TRUE;
            }
            /*END BZ46257*/
        }
        
        return rvPaymentList.toArray();
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        Object data = argArg0.getData();
        if (data instanceof CawRvPaymentModel) {
            CawRvPaymentModel rvItemSelected = (CawRvPaymentModel) data;
            this.setScopedValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_SELECTED, rvItemSelected);
        }
        return HELPER.completeResponse();
    }

    @Override
    protected PromptKey getEmptyListPromptKey() {

        if (isSearchError) {
            return PromptKey.valueOf("CAW_RV_PAYMENT_ERROR");
        }
        return PromptKey.valueOf("CAW_RV_PAYMENT_NOT_FOUND");
    }

    /*BEGIN BZ46257*/
    @Override
    protected IOpResponse getEmptyListPromptResponse() {
    
        if(isBackToSearchScren && this.getScopedValue(CawValueKeys.IS_ADD_ANOTHER_RV_PAYMENT) != null) {
            this.clearScopedValue(CawValueKeys.IS_ADD_ANOTHER_RV_PAYMENT);
            return this.HELPER.getBackupResponse();
        }
        return super.getEmptyListPromptResponse();
    }
    /*END BZ46257*/
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        if (argEvent != null && argEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if (BUTTON_RETRY.equals(key.toString())) {
                return handleInitialState(argEvent);
            } else if (BUTTON_SELECTION_COMPLETE.equals(key.toString())) {
                return this.HELPER.silentErrorResponse();
            }
        }
        return super.handleOpExec(argEvent);
    }

    private List<CawRvPaymentModel> callRvPaymentService() {

        try {
            _busyState.start(CawConstants.BUSY_STATE_MSG);
            JSONObject jsonObjectResponse = sendRequestToRvPaymentApi();
            _busyState.end();
            if (jsonObjectResponse == null || jsonObjectResponse.getInt(CawJSONConstant.JSON_WO_STATUS) == 3) {
                isSearchError = Boolean.TRUE;
            } else {
                return _cawBuildRvPaymentRequest.convertResponse(jsonObjectResponse);
            }
        } catch (JSONException ex) {
            _busyState.end();
            _logger.error("[Exception happen when mapping RV Payment Response]: " + ex.getMessage());
        }
        return new ArrayList<CawRvPaymentModel>();
    }

    private JSONObject sendRequestToRvPaymentApi() throws JSONException {

        JSONObject jsonObjectResponse = null;
        ResponseEntity<String> response;
        CawRvPaymentModel searModel = this.getScopedValue(CawValueKeys.CAW_RV_PAYMENT_SEARCH_MODEL);
        if (_stationState != null && searModel != null) {
            String rvPaymentRequestJson = _cawBuildRvPaymentRequest.buildRvPaymentRequest(searModel, _stationState);
            if (rvPaymentRequestJson != null) {
                response = CawEBSHelper.getInstance().searchRvPayment(rvPaymentRequestJson);
                if (response != null && CawEBSHelper.RESPONSE_SUCCESS_CODE == response.getStatusCodeValue()) {
                    jsonObjectResponse = new JSONObject(response.getBody());
                }
            }
        }
        return jsonObjectResponse;
    }

    /*BEGIN BZ46259*/
    /**
     * 
     * @param rvItemList
     */
    private void removeItemExistInTrans(List<CawRvPaymentModel> rvItemList){
        IRetailTransaction retailTrans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        for (IRetailTransactionLineItem retailLineItem : retailTrans.getRetailTransactionLineItems()) {
            if (retailLineItem instanceof ISaleReturnLineItem) {
                ISaleReturnLineItem saleLineItem = (ISaleReturnLineItem) retailLineItem;
                if(!saleLineItem.getVoid() && CawRvPaymentHelper.isRvPaymentSaleLineItem(saleLineItem)) {
                    String rvWorkorder = org.apache.commons.lang3.StringUtils.isNotEmpty(retailLineItem.getStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES)) 
                            ? CawRvPaymentHelper.getRvProperty(retailLineItem.getStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES), CawJSONConstant.JSON_WORK_ORDER)
                            : StringUtils.EMPTY; //BZ47542
                    for(int i = 0; i<rvItemList.size(); i++) {
                        CawRvPaymentModel rvItem = rvItemList.get(i);
                        if (StringUtils.equivalentIgnoreCase(rvWorkorder, rvItem.getRvServiceWo())) {
                            rvItemList.remove(rvItem);
                        }
                    }
                }
            }
        }
    }
    /*END BZ46259*/
}
