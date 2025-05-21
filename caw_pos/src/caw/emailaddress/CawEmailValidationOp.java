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
 *===================================================================
 */

package caw.emailaddress;

import java.util.Locale;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.i18n.IFormattable;
import dtv.i18n.TranslationHelper;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawEmailValidationOp extends Operation {
    
    @Override
    public boolean isOperationApplicable() {
    
        boolean result = false;
        
        if (BooleanUtils.isNotTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {
        
            CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
            
            if (currentEditCustomerMaintenanceModel != null) {
                String currentEmail = currentEditCustomerMaintenanceModel.getCustomer().getEmailAddress();
                
                if (StringUtils.isNotEmpty(currentEmail)) {
                    String specifiedNoThanksEmail = CawEmailAddressHelper.getSpecifiedNoThanksEmail();
                    
                    if (StringUtils.isNotEmpty(specifiedNoThanksEmail)) {
                        if (!currentEmail.equals(specifiedNoThanksEmail)) {
                            if (!isIdenticalThanLastSaved()) {
                                result = super.isOperationApplicable();
                            }
                        }
                    }
                }
            }
            
        }
        
        return result;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        
        if (!(argArg0 instanceof IXstDataAction)) {
            IOpResponse response = HELPER.completeResponse();
            
            CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
            String currentEmail = currentEditCustomerMaintenanceModel.getCustomer().getEmailAddress();
            
            response = handleValidateEmailAddress(currentEmail);
            
            return response;
        } else {
            IOpResponse response = HELPER.completeResponse();
            
            return response;
        }
    }
    
    private IOpResponse handleValidateEmailAddress(String email) {
        IOpResponse result = HELPER.completeResponse();
        
        CawEmailAddressHelper emailHelper = CawEmailAddressHelper.getInstance();
        
        ResponseEntity<String> emailValidationResponse = emailHelper.requestValidateEmail(email);
        
        setScopedValue(CawValueKeys.CAW_EMAIL_ADDRESS_VALIDATION_RUN, Boolean.TRUE);
        setScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_EMAIL, email);
        
        if (emailValidationResponse != null) {
            
            setScopedValue(CawValueKeys.CAW_EMAIL_VALIDATION_LATEST_RESPONSE, emailValidationResponse);
            
            CawEmailValidationStatus status = CawEmailAddressHelper.getMailingAddressValidationStatus(emailValidationResponse);
            
            switch (status) {
            case UNAVAILABLE:
                
                IFormattable args[] = new IFormattable[2];
                
                args[0] = _formattables.getTranslatable("_cawEmailAddressValidationUnavailableTitle");
                args[1] = _formattables.getTranslatable("_cawEmailAddressValidationUnavailableMsg");
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_EMAIL_ADDRESS_VALIDATION_PROMPT"), args);
                
                break;
            case ERROR:
                setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                
                IFormattable errorArgs[] = new IFormattable[3];
                
                errorArgs[0] = _formattables.getTranslatable("_cawEmailAddressValidationErrorTitle");
                
                String errMsg = TranslationHelper.translate(Locale.getDefault(), _formattables.getTranslatable("_cawEmailAddressValidationErrorMsg"));
                errMsg = String.format(errMsg, CawEmailAddressHelper.getErrorString(emailValidationResponse));
                
                errorArgs[1] = _formattables.getSimpleFormattable(errMsg);
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_EMAIL_ADDRESS_VALIDATION_PROMPT"), errorArgs);
                break;
            case INVALID:
                setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                
                IFormattable invalidArgs[] = new IFormattable[2];
                
                invalidArgs[0] = _formattables.getTranslatable("_cawEmailAddressValidationInvalidTitle");
                invalidArgs[1] = _formattables.getTranslatable("_cawEmailAddressValidationInvalidMsg");
                
                result = HELPER.getPromptResponse(PromptKey.valueOf("CAW_EMAIL_ADDRESS_VALIDATION_PROMPT"), invalidArgs);
                break;
            case SUCCESS:                
                result = HELPER.completeResponse();
                break;
            }
            
        }
        
        return result;
    }
    
    private boolean isIdenticalThanLastSaved() {
        CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
        String currentEmail = currentEditCustomerMaintenanceModel.getCustomer().getEmailAddress();
        
        String lastSavedEmail = getScopedValue(CawValueKeys.CAW_CUSTOMER_SAVED_EMAIL);
        
        if (lastSavedEmail != null && StringUtils.isNotEmpty(lastSavedEmail)) {
            return StringUtils.equals(currentEmail, lastSavedEmail);
        }
        
        return false;
    }

}
