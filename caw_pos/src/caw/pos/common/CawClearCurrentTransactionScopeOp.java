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
 * BZ48179          170122    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.common;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * when close store, 
 * The TransactionScope.CURRENT_TRANSACTION scope not clear so when make accepted a order, 
 * xstore insert TRN.TRANS.TRANS_TYPCODE incorrectly.
 * 
 */
public class CawClearCurrentTransactionScopeOp extends Operation{

    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {
        if(_transactionScope.getValue(TransactionScope.CURRENT_TRANSACTION) != null) {
            _transactionScope.clearValue(TransactionScope.CURRENT_TRANSACTION);
        }
        return this.HELPER.completeResponse();
    }
}
