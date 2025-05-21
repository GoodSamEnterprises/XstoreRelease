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
 * BZ42019          171121    Replace QAS with EAVS2
 * BZ47782          201221    Patch 18 - Question about mailing address rules
 * BZ47747          201221    [Internal] - Xstore should NOT continue calling the Mailing Address Validation API if it had already been validated as an exact address just before and no more update to the customer profile.
 * BZ47803          211221    [Internal patch 7.0.18] Xstore did not call to validate mailing address when creating a new customer with the address was entered from the Customer Search form
 *===================================================================
 */

package caw.mailingaddress;

import java.util.Locale;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.http.ResponseEntity;

import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.i18n.IFormattable;
import dtv.i18n.TranslationHelper;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.IQualifiedAddress;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.OpStatus;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawMailingAddressValidationOp extends Operation {
    
    @Override
    public boolean isOperationApplicable() {
        boolean shouldRun = super.isOperationApplicable();
        
        if (BooleanUtils.isTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {
            shouldRun = false;
        }
    
        if (!isValidCountry()) {
            shouldRun = false;
        }
        
        /* BEGIN BZ47747 */
        if (isMaillingValidatedJustBefore()) {
            shouldRun = false;
        }
        /* END BZ47747 */
        
        /* BEGIN BZ47803 */
        if (BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.CAW_IS_NEW_CUST_ADDR_INIT_VALIDATION))) {

        } else {
            if (!isMailingDifferentThanLastSaved()) {
                shouldRun = false;
            }
        }
        /* END BZ47803 */
        
        return shouldRun;
    }

    /* BEGIN BZ47782, BZ47803 */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
        
        IOpResponse response = HELPER.completeResponse();
        
        if (!(argParamIXstEvent instanceof IXstDataAction)) {
            CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
            
            if (currentEditCustomerMaintenanceModel != null) {
                
                IQualifiedAddress mainAddress = currentEditCustomerMaintenanceModel.getMainAddress();
                
                response = handleValidateMailingAddress(mainAddress.getAddress1(), mainAddress.getAddress2(), mainAddress.getCity(), mainAddress.getState(), mainAddress.getPostalCode(), mainAddress.getCountry());
            }
        }
        
        if (response.getOpStatus().equals(OpStatus.COMPLETE)) {
            _transactionScope.setValue(CawValueKeys.CAW_IS_NEW_CUST_ADDR_INIT_VALIDATION, Boolean.FALSE);
        }
        
        return response;
    }
    /* END BZ47782, BZ47803 */
    
    private IOpResponse handleValidateMailingAddress(String addressLine1, String addressLine2, String city, String state, String postal, String country) {
        
        IOpResponse result = HELPER.completeResponse();
        
        CawMailingAddressHelper helper = CawMailingAddressHelper.getInstance();
        CawMailingAddressRequest request = new CawMailingAddressRequest();
        
        request.setSalesChannelId(String.valueOf(_stationState.getRetailLocationId()));
        request.setChannelType(CawMailingAddressHelper.DEFAULT_CHANNEL_TYPE);
        request.setAddressType(String.valueOf(CawMailingAddressHelper.DEFAULT_ADDRESS_TYPE));
        request.setLine1(addressLine1);
        request.setLine2(addressLine2);
        request.setCity(city);
        request.setState(state);
        request.setPostal(postal);
        request.setCountry(country);
        
        clearScopedValue(CawValueKeys.CAW_MAILING_VALIDATION_LATEST_RESPONSE);
        
        ResponseEntity<String> response = helper.requestValidateMailingAddress(request);
        
        setScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_MAILING_REQUEST, request);
        
        setScopedValue(CawValueKeys.CAW_MAILING_ADDRESS_VALIDATION_RUN, Boolean.TRUE);
        
        if (response != null) {
            setScopedValue(CawValueKeys.CAW_MAILING_VALIDATION_LATEST_RESPONSE, response);
            
            CawMailingValidationStatus status = CawMailingAddressHelper.getMailingAddressValidationStatus(response);
            
            switch (status) {
            case UNAVAILABLE:
                
                IFormattable args[] = new IFormattable[2];
                
                args[0] = _formattables.getTranslatable("_cawMailingAddressValidationUnavailableTitle");
                args[1] = _formattables.getTranslatable("_cawMailingAddressValidationUnavailableMsg");
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_PROMPT"), args);
                break;
            case WARNING:
                setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                
                IFormattable warnArgs[] = new IFormattable[2];
                
                warnArgs[0] = _formattables.getTranslatable("_cawMailingAddressValidationWarningTitle");
                
                String warnMsg = TranslationHelper.translate(Locale.getDefault(), _formattables.getTranslatable("_cawMailingAddressValidationWarningMsg"));
                warnMsg = String.format(warnMsg, CawMailingAddressHelper.getWarningString(response));
                
                warnArgs[1] = _formattables.getSimpleFormattable(warnMsg);
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_PROMPT"), warnArgs);
                break;
            case ERROR:
                setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                
                IFormattable errorArgs[] = new IFormattable[2];
                
                errorArgs[0] = _formattables.getTranslatable("_cawMailingAddressValidationErrorTitle");
                
                String errorMsg = TranslationHelper.translate(Locale.getDefault(), _formattables.getTranslatable("_cawMailingAddressValidationErrorMsg"));
                errorMsg = String.format(errorMsg, CawMailingAddressHelper.getErrorString(response));
                
                errorArgs[1] = _formattables.getSimpleFormattable(errorMsg);
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_ERROR"), errorArgs);
                break;
            case SUCCESS:
                /* BEGIN BZ47782 */
                result = HELPER.completeResponse();

                CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
                
                // update current model with result from response
                if (currentEditCustomerMaintenanceModel != null) {
                    CawMailingAddressHelper.updateCustomerAddressWithCleanedAddress(currentEditCustomerMaintenanceModel, response);
                }
                /* END BZ47782 */
                break;
            }
        } else { // Unavailable
            IFormattable args[] = new IFormattable[2];
            
            args[0] = _formattables.getTranslatable("_cawMailingAddressValidationUnavailableTitle");
            args[1] = _formattables.getTranslatable("_cawMailingAddressValidationUnavailableMsg");
            
            result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_PROMPT"), args);
        }
        
        return result;
    }
    
    public boolean isValidCountry() {
        
        boolean result = false;
    
        CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
        
        if (currentEditCustomerMaintenanceModel != null) {
            
            IQualifiedAddress mainAddress = currentEditCustomerMaintenanceModel.getMainAddress();
            String country = mainAddress.getCountry();
            
            if (CawMailingAddressHelper.isMailingAddressValidatableCountry(country)) {
                result = true;
            }
        }
        
        return result;
    }
    
    private boolean isMailingDifferentThanLastSaved() {
        boolean result = false;
        
        CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
        IParty initModel = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        
        if (currentEditCustomerMaintenanceModel != null && initModel != null) {
            IQualifiedAddress mainAddress = currentEditCustomerMaintenanceModel.getMainAddress();
            
            if (!CawMailingAddressHelper.isIdenticalMailingAddress(mainAddress, initModel)) {
                result = true;
            }
            
        }
        
        return result;
    }
    
    /* BEGIN BZ47747 */
    /**
     * Check if the current mailing address is validated from the last validation
     * @return
     */
    private boolean isMaillingValidatedJustBefore() {
        boolean result = false;
        
        
        ResponseEntity<String> lastMailingValidationRes = getScopedValue(CawValueKeys.CAW_MAILING_VALIDATION_LATEST_RESPONSE);
        
        if (lastMailingValidationRes != null) {
            CawMailingValidationStatus lastMailingValidationStatus = CawMailingAddressHelper.getMailingAddressValidationStatus(lastMailingValidationRes);
            
            if (lastMailingValidationStatus.equals(CawMailingValidationStatus.SUCCESS)) {
                CawCustomerMaintenanceModel currentModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
                
                if (currentModel != null) {
                    
                    IQualifiedAddress currentAddress = currentModel.getMainAddress();
                        
                    if (CawMailingAddressHelper.isIdenticalMailingAddress(currentAddress, lastMailingValidationRes.getBody())) {
                        result = true;
                    }
                    
                }
            }
        }
        
        
        return result;
    }
    /* END BZ47747 */

}