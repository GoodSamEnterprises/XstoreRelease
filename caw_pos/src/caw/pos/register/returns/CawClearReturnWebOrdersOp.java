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
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ25206          240118    "Enter price" prompt displays unexpectedly when returning an item from original transaction after backing from Return Web Order screen
 * BZ25207          240118    Return Tender Options displays incorrectly tender types when refunding Web Order items.
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawClearReturnWebOrdersOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        // Begin BZ25206
        if (_transactionScope != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            // End BZ25206
            _transactionScope.clearValue(CawValueKeys.IS_RETURN_WEB_ORDER);
        }

        _transactionScope.clearValue(CawValueKeys.IS_SALE_SCREEN); // BZ25207
        return HELPER.completeResponse();
    }

}
