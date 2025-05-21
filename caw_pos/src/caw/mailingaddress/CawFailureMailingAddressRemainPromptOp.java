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

package caw.mailingaddress;

import org.springframework.http.ResponseEntity;

import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.IQualifiedAddress;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Show prompt if still remain Failure Mailing Address validation
 */
public class CawFailureMailingAddressRemainPromptOp extends AbstractPromptOp {

    @Override
    public boolean isOperationApplicable() {
        
        boolean result = false;
        
        if (isValidCountry()) {
            ResponseEntity<String> lastMailingValidationRes = getScopedValue(CawValueKeys.CAW_MAILING_VALIDATION_LATEST_RESPONSE);
            
            if (lastMailingValidationRes != null) {
                CawMailingValidationStatus lastMailingValidationStatus = CawMailingAddressHelper.getMailingAddressValidationStatus(lastMailingValidationRes);
                
                if (lastMailingValidationStatus.equals(CawMailingValidationStatus.ERROR)
                        || lastMailingValidationStatus.equals(CawMailingValidationStatus.WARNING)) {
                    
                    CawCustomerMaintenanceModel currentModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
                    
                    if (currentModel != null) {
                        
                        IQualifiedAddress currentAddress = currentModel.getMainAddress();
                        
                        CawMailingAddressRequest lastAddressRequest = getScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_MAILING_REQUEST);
                        
                        if (lastAddressRequest != null) {
                            
                            if (CawMailingAddressHelper.isIdenticalMailingAddress(currentAddress, lastAddressRequest)) {
                                setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                                
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
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_PROMPT");
    }
    
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
    
        IFormattable args[] = new IFormattable[2];
        args[0] = _formattables.getTranslatable("_cawMailingAddressValidationRemainErrorTitle");
        args[1] = _formattables.getTranslatable("_cawMailingAddressValidationRemainErrorMsg");
        
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
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

}
