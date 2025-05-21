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
 * BZ29743          260319    [Internal] Modify Tender screen is prompted when there is no tenders to modify.
 *===================================================================
 */

package caw.pos.tender;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Mark value key as current OpChain is PRE_TENDERING
 */
public class CawCheckPretenderingOp extends Operation {

    /* Mark value key as current OpChain is PRE_TENDERING
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        _transactionScope.setValue(CawValueKeys.IS_PRE_TENDERING_OP, true);
        return HELPER.completeResponse();
    }

}
