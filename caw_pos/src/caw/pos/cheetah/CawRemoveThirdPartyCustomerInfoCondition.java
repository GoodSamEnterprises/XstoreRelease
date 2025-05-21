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

import dtv.pos.framework.op.AbstractRunCondition;

/**
 *
 */
public class CawRemoveThirdPartyCustomerInfoCondition extends AbstractRunCondition{
    
    @Override
    protected boolean shouldRunImpl() {
        
        return (CawCatalystHelper.getLookupResponseDataUseThirdPartyTender() != null
                && !CawCatalystHelper.getLookupResponseDataUseThirdPartyTender().isEmpty());  //BZ53547
    }

}
