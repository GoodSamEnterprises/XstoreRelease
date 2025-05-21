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
 * BZ54208          261222    [BTM-280] Production Issue | Applying funds onto gift card without charging
 *===================================================================
 */

package caw.pos.util;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.ApplicationData;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawCheckIsRegisterStateOp extends Operation{
    
    private static final String REGISTER_MODE = "REGISTER";
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        ApplicationData newAppData = _modeProvider.get().getModeData();
        
        if(newAppData != null && newAppData.getKey() != null 
                && newAppData.getKey().equals(REGISTER_MODE)) {
            _transactionScope.setValue(CawValueKeys.CAW_IS_BACK_OFFICE_STATE, false);
        } else {
            _transactionScope.setValue(CawValueKeys.CAW_IS_BACK_OFFICE_STATE, true);
        }
        return HELPER.completeResponse();
    }

}
