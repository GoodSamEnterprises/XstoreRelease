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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Clear Purchase Used Firearm flag when back to Sale Screen.
 */
public class CawClearPurchaseUsedFirearmOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        _transactionScope.clearValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);
        return HELPER.completeResponse();
    }

}
