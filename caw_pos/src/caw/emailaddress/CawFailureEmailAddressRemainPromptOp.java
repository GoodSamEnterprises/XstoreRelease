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

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawFailureEmailAddressRemainPromptOp extends AbstractPromptOp {
    
    @Override
    public boolean isOperationApplicable() {

        boolean shouldRun = false;
        
        if (BooleanUtils.isNotTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {

            ResponseEntity<String> lastEmailValidationRes = getScopedValue(CawValueKeys.CAW_EMAIL_VALIDATION_LATEST_RESPONSE);
    
            if (lastEmailValidationRes != null) {
    
                CawEmailValidationStatus lastEmailValidationStatus = CawEmailAddressHelper.getMailingAddressValidationStatus(lastEmailValidationRes);
    
                if (lastEmailValidationStatus.equals(CawEmailValidationStatus.ERROR)
                        || lastEmailValidationStatus.equals(CawEmailValidationStatus.INVALID)) {
    
                    String lastestEmailAddress = getScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_EMAIL);
    
                    if (StringUtils.isNotEmpty(lastestEmailAddress)) {
    
                        CawCustomerMaintenanceModel currentModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
    
                        if (currentModel != null) {
                            String currentEmailAddress = currentModel.getCustomer().getEmailAddress();
    
                            if (StringUtils.isNotEmpty(currentEmailAddress)) {
    
                                if (lastestEmailAddress.equals(currentEmailAddress)) {
                                    setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.TRUE);
                                    
                                    shouldRun = super.isOperationApplicable();
                                }
    
                            }
                        }
                    }
    
                }
            }

        }

        return shouldRun;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_EMAIL_ADDRESS_VALIDATION_PROMPT");
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
    
        IFormattable args[] = new IFormattable[2];
        args[0] = _formattables.getTranslatable("_cawEmailAddressValidationRemainErrorTitle");
        args[1] = _formattables.getTranslatable("_cawEmailAddressValidationRemainErrorMsg");
        
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

}
