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
 * BZ47123          050122    [PROD] Order Service Token Error
 *===================================================================
 */

package caw.pos.hardware.op;

import caw.pos.common.CawValueKeys;

import dtv.pos.hardware.op.WaitForCashDrawerCloseOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawWaitForCashDrawerCloseOp extends WaitForCashDrawerCloseOp{
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        //CAW_CASH_DRAWER_CLOSE_FLAG = true only when open cash drawer at customer verification screen
        if(getScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP) != null 
                && getScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP)) {
            _transactionScope.setValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG, true);
        }
        return super.handlePromptResponse(argEvent);
    }

}
