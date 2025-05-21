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
 * BZ26837          160718    System goes to back Register Login instead of Sale screen when pressing ESC at customer Search.
 *===================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Clear flag when pressing ESC at customer Search
 */
public class CawClearVarriableBackCustOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        _transactionScope.clearValue(CawValueKeys.FN_BACK_CUST_SEARCH); // BZ 24414
        return HELPER.completeResponse();
    }

}
