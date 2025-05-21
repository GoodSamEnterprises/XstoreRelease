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

package caw.pos.workorder.condition;

import java.util.*;

import javax.inject.Inject;

import caw.pos.OrderModQueryResult;

import dtv.data2.access.*;
import dtv.data2.access.pm.PersistenceManagerType;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.trn.PosTransactionId;

/**
 *
 */
public class CawWorkOrderReturnSearchRunCondition extends AbstractRunCondition {
    
    protected static final IQueryKey<OrderModQueryResult> QUERY_CHECK_WO_DEPOSIT_TRANS = new QueryKey<OrderModQueryResult>(
            "QUERY_CHECK_WO_DEPOSIT_TRANS", OrderModQueryResult.class);
    
    @Inject
    ReturnManager                      _returnManager;
    
    @Override
    protected boolean shouldRunImpl() {
        
        boolean result = false;
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
            
            if(woDepositTrans != null && woDepositTrans.size() >0) {
                result = true;
            }
        }
        return result;
    }
}
