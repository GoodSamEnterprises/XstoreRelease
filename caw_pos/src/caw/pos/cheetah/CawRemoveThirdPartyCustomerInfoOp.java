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
 * BZ53547          161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 *===================================================================
 */

package caw.pos.cheetah;

import caw.pos.advance.prompting.CawCatalystHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawRemoveThirdPartyCustomerInfoOp extends Operation{
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        CawCatalystHelper.setLookupResponseData(CawCatalystHelper.getLookupResponseDataUseThirdPartyTender());
        CawCatalystHelper.setLookupLoyaltyResponseData(CawCatalystHelper.getLookupResponseLoyaltyDataUseThirdPartyTender());
        _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, CawCatalystHelper.getSelectedCustomerUseThirdPartyTender());
        
        CawCatalystHelper.setLookupResponseDataUseThirdPartyTender(null);
        CawCatalystHelper.setLookupResponseLoyaltyDataUseThirdPartyTender(null);
        CawCatalystHelper.setSelectedCustomerUseThirdPartyTender(null);
        
        return HELPER.completeResponse();
    }
}
