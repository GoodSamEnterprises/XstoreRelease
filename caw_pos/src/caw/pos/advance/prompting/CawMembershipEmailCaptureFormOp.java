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
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 * BZ46840          191021    [Internal] Email Capture - Order Service should send crud=4 under customer attribute into the request when an existing customer is updated an email address into offline mode.
 * BZ49356          080421    [PROD] Orders Completing With Credit Decline
 * BZ61159          190224    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.emailaddress.CawEmailAddressHelper;
import caw.emailaddress.CawEmailValidationStatus;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeValueId;
import dtv.xst.dao.com.impl.CodeValueModel;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyIdCrossReference;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawMembershipEmailCaptureFormOp extends AbstractFormOp<CawMembershipEmailCaptureModel> {

    private static final Logger _logger     = LogManager.getLogger(CawMembershipEmailCaptureFormOp.class);
    
    private CawEmailAddressHelper _emailHelper = CawEmailAddressHelper.getInstance();
    
    private CawCustomerHelper   _custHelper = CawCustomerHelper.getInstance();/*BZ46840*/

    @Override
    protected CawMembershipEmailCaptureModel createModel() {
        
        IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
        
        CawMembershipEmailCaptureModel model = new CawMembershipEmailCaptureModel(item.getMerchLevel4Id());
        
        return model;
    }

    @Override
    protected FormKey getFormKey() {
        return FormKey.valueOf("CAW_MEMBERSHIP_EMAIL_CAPTURE");
    }
    
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        /*BEGIN BZ49356*/
        //Disable buttons
        IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
        disableActions(promptActionModel.getActions());
        /*END BZ49356*/
        IXstActionKey actionKey = argAction.getActionKey();
        if (actionKey == XstDataActionKey.valueOf("BACK")) {
            return handleInitialState();
        } else if (actionKey == XstDataActionKey.valueOf("OK_UPDATE")) {
            handleSaveCustomerEmail(getModel().getEmail());
            return HELPER.completeResponse();
        }
    
        return super.handleDataAction(argAction);
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {
    
        CawMembershipEmailCaptureModel model = getModel();
        
        if (isEqualNoThanksEmail(model.getEmail())) {
            return HELPER.completeResponse();
        } else {
            ResponseEntity<String> emailAddressValidationReponse = _emailHelper.requestValidateEmail(model.getEmail());
            
            CawEmailValidationStatus emailValidationStatus = CawEmailAddressHelper.getMailingAddressValidationStatus(emailAddressValidationReponse);
            
            if (emailValidationStatus.equals(CawEmailValidationStatus.UNAVAILABLE)) {
                return HELPER.getPromptResponse(PromptKey.valueOf("CAW_MEMBERSHIP_EMAIL_CAPTURE_EMAIL_UNAVAILABLE")
                        , IFormattable.EMPTY);
            } else if (emailValidationStatus.equals(CawEmailValidationStatus.ERROR)) {
                String errorMsg = CawEmailAddressHelper.getErrorString(emailAddressValidationReponse);
                
                IFormattable[] format = new IFormattable[1];
                
                format[0] = _formattables.getLiteral(errorMsg);
                
                return HELPER.getPromptResponse(PromptKey.valueOf("CAW_MEMBERSHIP_EMAIL_CAPTURE_EMAIL_ERROR"), format);
            } else if (emailValidationStatus.equals(CawEmailValidationStatus.INVALID)) {
                return HELPER.getPromptResponse(PromptKey.valueOf("CAW_MEMBERSHIP_EMAIL_CAPTURE_EMAIL_INVALID")
                        , IFormattable.EMPTY);
            } else {
                handleSaveCustomerEmail(model.getEmail());
                setScopedValue(CawValueKeys.IS_MEMBERSHIP_EMAIL_CAPTURED, Boolean.TRUE);
            }
        }
        
        return super.handleFormResponse(argEvent);
    }
    
    private boolean isEqualNoThanksEmail(String inputEmail) {
        boolean result = false;
        
        CodeValueId codeValueId = new CodeValueId();
        
        codeValueId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        codeValueId.setCategory(CawConstants.CAW_NO_THANKS_EMAIL);
        codeValueId.setCode(CawConstants.CAW_NO_THANKS_EMAIL_CODE);
        
        CodeValueModel preDefineEmail = DataFactory.getObjectByIdNoThrow(codeValueId);
        
        if (preDefineEmail != null && StringUtils.isNotEmpty(preDefineEmail.getDescription())) {
            if (preDefineEmail.getDescription().equals(inputEmail)) {
                result = true;
            }
        }
        
        return result;
    }
    
    private void handleSaveCustomerEmail(String email) {
        
        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        IParty customer = trans.getCustomerParty();
        customer.setEmailAddress(email);
        
        Long accountNumber = 0L;
        String accNumber = "";
        List<IPartyIdCrossReference> listPartyIdCrossRef = customer.getAlternatePartyIds();
        if (CollectionUtils.isNotEmpty(listPartyIdCrossRef)) {
            accNumber = listPartyIdCrossRef.get(0).getAlternateId();
            if (accNumber != null) {
                accountNumber = Long.valueOf(CawJSONUtils.vLong(accNumber));
            }
        }
        
        String upsertRequest = CawCustomerHelper.getInstance().buildUpsertRequest(customer, accountNumber);
        if (CawUtilFunction.allowEBSConnection()) {
            if (StringUtils.isNotEmpty(upsertRequest)) {
                JSONObject upsertRequestseJson = null;
                ResponseEntity<String> upSertResponse = CawEBSHelper.getInstance().upsertCustomterToEBS(upsertRequest);
                if (upSertResponse != null && upSertResponse.getStatusCode() == HttpStatus.OK) {/*BZ46840*/
                    _logger.info("Update email address of customer success.");
                    CawCatalystHelper.setLookupResponseData(upSertResponse.getBody());
                    //clean up PartyProperties by DELETE statement
                    _custHelper.deteleCustomerOfflineQueue(customer, upSertResponse.getBody());/*BZ46840*/
                } else {
                    /*BEGIN BZ46840*/
                    _logger.info("Cannot sent upsert request -> process offline");
                    upsertRequestseJson = CawJSONUtils.toJSONObject(upsertRequest);
                    String customerAttrKey = CawEBSConstant.CUSTOMER_ATTR;   //BZ61159
                    if(upsertRequestseJson != null && upsertRequestseJson.has(customerAttrKey)) {
                        try {
                            //BEGIN BZ61159
                            upsertRequestseJson.getJSONObject(customerAttrKey).put("crud", 4);
                            upsertRequestseJson.getJSONObject(customerAttrKey).put("crudDescription", "Updated");
                            //END BZ61159
                        } catch (JSONException ex) {
                            _logger.error("Cannot update the crud and crudDescription" + ex.getMessage());
                        }
                    }
                    _custHelper.processCustomerOffline(customer, upsertRequestseJson.toString());
                    /*END BZ46840*/
                }
            }
        }
    }
    
    /*Begin BZ49356*/
    protected void disableActions(Collection<IXstAction> argActions) {
        for (IXstAction action : argActions) {
            _logger.debug("Disabling action: " + action);
            action.setEnabled(false);
        }
    }
    /*END BZ49356*/
}
