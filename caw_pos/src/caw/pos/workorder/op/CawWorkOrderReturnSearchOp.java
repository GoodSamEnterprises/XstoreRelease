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
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.*;

import javax.inject.Inject;

import caw.pos.OrderModQueryResult;
import caw.pos.common.CawValueKeys;
import caw.pos.ejournal.CawTransactionSearchHelper;

import dtv.data2.access.*;
import dtv.data2.access.pm.PersistenceManagerType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.PosTransactionId;

/**
 *
 */
public class CawWorkOrderReturnSearchOp extends Operation{

    @Inject
    ReturnManager                      _returnManager;
    
    @Inject
    private CawTransactionSearchHelper transHelper;
    
    protected static final IQueryKey<OrderModQueryResult> QUERY_CHECK_WO_DEPOSIT_TRANS = new QueryKey<OrderModQueryResult>(
            "QUERY_CHECK_WO_DEPOSIT_TRANS", OrderModQueryResult.class);
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        OrderModQueryResult woDepositTrans = getwoDepositTransIdResult();
        
        if(woDepositTrans != null) {
            PosTransactionId pos = new PosTransactionId();
            pos.setOrganizationId(Long.valueOf(woDepositTrans.getOrgId()));
            pos.setRetailLocationId(Long.valueOf(woDepositTrans.getRtlId()));
            pos.setWorkstationId(Long.valueOf(woDepositTrans.getWstId()));
            pos.setTransactionSequence(Long.valueOf(woDepositTrans.getTransSeq()));
            pos.setBusinessDate(woDepositTrans.getBDate());
            IRetailTransaction transaction = (IRetailTransaction) transHelper.getTransaction(pos, PersistenceManagerType
                    .forName("XCENTER_STANDARD"));
            _returnManager.addOrigTransaction(transaction);
            _returnManager.getAllOrigTransaction();//z
        }
        return HELPER.completeResponse();
    }

    private OrderModQueryResult getwoDepositTransIdResult() {
        OrderModQueryResult result = null;
        PosTransactionId transId = _returnManager.getCurrentOrigTransactionId();
        if(transId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("argOrgId", transId.getOrganizationId());
            params.put("argRtlId", transId.getRetailLocationId());
            params.put("argBDate", transId.getBusinessDate());
            params.put("argWstId", transId.getWorkstationId());
            params.put("argTransSeq", transId.getTransactionSequence());
            List<OrderModQueryResult> woDepositTrans = DataFactory
                    .getObjectByQueryNoThrow(QUERY_CHECK_WO_DEPOSIT_TRANS, params, PersistenceManagerType
                            .forName("XCENTER_STANDARD"));

            if(woDepositTrans != null && woDepositTrans.size() > 0) {
                result = woDepositTrans.get(0);
                
                PosTransactionId woDepositTransId = new PosTransactionId();
                woDepositTransId.setOrganizationId(result.getOrgId());
                woDepositTransId.setRetailLocationId(Long.valueOf(result.getRtlId()));
                woDepositTransId.setWorkstationId(Long.valueOf(result.getWstId()));
                woDepositTransId.setTransactionSequence(result.getTransSeq());
                woDepositTransId.setBusinessDate(result.getBDate());
                
                if(_transactionScope.getValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING) == null 
                        || _transactionScope.getValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING).isEmpty()) {
                    Map<PosTransactionId, PosTransactionId> temp = new HashMap<PosTransactionId, PosTransactionId>();
                    temp.put(transId, woDepositTransId);
                    _transactionScope.setValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING, temp);
                } else {
                    _transactionScope.getValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING).put(transId, woDepositTransId);
                }
            }
        }
        return result;
    }
}
