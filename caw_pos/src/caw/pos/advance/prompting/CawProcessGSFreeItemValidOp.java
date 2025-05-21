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
 * BZ59669          301023    [FreeTier short term] Update the membership resend [Catalyst=] call to a membership valdiation call
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.cheetah.promotion.CawPromotionModel;
import caw.pos.common.CawUtilFunction;
import caw.pos.common.CawValueKeys;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawProcessGSFreeItemValidOp extends Operation{
	//BEGIN BZ59669
    @Inject
    private TransactionScope               _transaction;

    private static final String         QUANTITY                   = "quantity";

    private static final String         ITEM_CODE                  = "itemCode";

    private static final int            ONE_ITEM                   = 1;

    // Begin BZ25434
    private static final String         CAN_PURCHASE_ATTR          = "canPurchase";

    private static final String         CUSTOMER_ATTR              = "customer";

    /** The Constant PRICING_TAG. */
    public static final String          PRICING_TAG                = "pricing";

    /** The Constant MEMBERSHIP_TAG. */
    public static final String          MEMBERSHIP_TAG             = "membership";

    /** The Constant IDENTIFIER_TAG. */
    public static final String          IDENTIFIER_TAG             = "identifier";

    // End BZ25434 

    private CawAdvancePromptingHelper   _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();
    
    @Override
    public boolean isOperationApplicable() {
        Boolean isRun = false;
        Boolean shouldSendValidate = _transactionScope.getValue(CawValueKeys.CAW_SHOULD_SEND_VALIDATE_MEMBERSHIP_AFTER_ADD_ITEM);
        if(shouldSendValidate != null && shouldSendValidate) {
            isRun = true;
        }
        return isRun;
    }
    
    private static final Logger         _logger                    = LogManager
            .getLogger(CawProcessMembershipItemValidOp.class);
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /* BEGIN BZ33595 */
        String dataEntered = StringUtils.EMPTY;
        dataEntered = _transaction.getValue(CawValueKeys.CAW_LOYALTY_FREE_TIER_SKU);
        /* END BZ33595 */
        IPosTransaction trans = _transactionScope.getTransaction();
        String custLookupData = getLookupResponseData();//BZ26255

        if (StringUtils.isNotEmpty(custLookupData) //BZ24556
                && getScopedValue(ValueKeys.CURRENT_ITEM) != null) {
            IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
            String itemId = item.getItemId();
            JSONObject itemJson = createItemJson(itemId);
            
            String requestMembershipValidate = _cawAdvancePromptingHelper
                    .getMembershipValidateTemplate(trans, custLookupData, itemJson, dataEntered);
            getResponseValidate(requestMembershipValidate, dataEntered);//BZ25434
        }

        return HELPER.completeResponse();
    }
    private String getLookupResponseData() {

        String lookupResponseDataResponse = CawCatalystHelper
                .getLookupResponseData();//BZ26255
        //Begin BZ24944
        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = _transactionScope
                    .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
        }

        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);//BZ26255
        }
        //End BZ24944

        return lookupResponseDataResponse;
    }
    
    private JSONObject createItemJson(String itemId) {

        JSONObject itemJson = new JSONObject();
        try {
            itemJson.put(ITEM_CODE, itemId);
            itemJson.put(QUANTITY, ONE_ITEM);
        } catch (JSONException ex) {
            _logger.error("Can not create Item json object" + ex.getMessage());
        }

        return itemJson;
    }
    
    private void getResponseValidate(String requestMembershipValidate,
            String dataEntered) {

        if (requestMembershipValidate != null) {
            //BZ BZ26398 changed and BZ26575 changed
            // Begin BZ27889 check EBS online or offline
            ResponseEntity<String> membershipValidateResponse = null;
            if (CawUtilFunction.allowEBSConnection()) {
                membershipValidateResponse = CawEBSHelper.getInstance()
                        .sendMembershipValidateToEBS(requestMembershipValidate);
            }
            //End BZ27889
            if (membershipValidateResponse != null) {
                if (membershipValidateResponse
                        .getStatusCodeValue() == CawEBSHelper.RESPONSE_SUCCESS_CODE) {
                    try {
                        JSONObject bodyResponse = new JSONObject(
                                membershipValidateResponse.getBody());
                        if (!bodyResponse.isNull(CAN_PURCHASE_ATTR)) {
                            boolean canPurchase = bodyResponse
                                    .getBoolean(CAN_PURCHASE_ATTR);
                            if (canPurchase == Boolean.TRUE) {
                                clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);
                                setScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP, bodyResponse
                                        .getString(CUSTOMER_ATTR));
                                CawCatalystHelper
                                        .setLookupResponseData(bodyResponse
                                                .getString(CUSTOMER_ATTR));//BZ25434
                                _transactionScope
                                        .setValue(CawValueKeys.API_LOOKUP_RESPONSE, bodyResponse
                                                .getString(CUSTOMER_ATTR));//BZ25434
                                // BZ 25318

                                _transactionScope
                                        .clearValue(CawValueKeys.IS_APPLY_CLUB_PRICE); //BZ25677
                            }
                        }
                    } catch (Exception ex) {
                        _logger.error("Validate Membership Exception:"
                                + ex.getMessage());
                    }
                }
            } else {
                // Begin BZ24424
                //Handle offline mode
                //handleOfflineMode(dataEntered);
                // End BZ24424
            }
            
            _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
        }
    }
    //END BZ59669
}
