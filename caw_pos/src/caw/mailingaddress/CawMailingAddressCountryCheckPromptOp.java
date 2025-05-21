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

import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.IQualifiedAddress;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawMailingAddressCountryCheckPromptOp extends AbstractPromptOp {

    @Override
    public boolean isOperationApplicable() {
    
        CawCustomerMaintenanceModel currentEditCustomerMaintenanceModel = getScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
        
        if (currentEditCustomerMaintenanceModel != null) {
            
            IQualifiedAddress mainAddress = currentEditCustomerMaintenanceModel.getMainAddress();
            String country = mainAddress.getCountry();
            
            if (CawMailingAddressHelper.isMailingAddressValidatableCountry(country)) {
                return false;
            }
        }
        
        return super.isOperationApplicable();
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_MAILING_ADDRESS_VALIDATION_PROMPT");
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
    
        IFormattable args[] = new IFormattable[2];
        
        args[0] = _formattables.getTranslatable("_cawMailingAddressValidationWrongCountryTitle");
        args[1] = _formattables.getTranslatable("_cawMailingAddressValidationWrongCountryMsg");
        
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {
        
        return HELPER.completeResponse();
    }

}
