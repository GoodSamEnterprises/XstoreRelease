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
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 *===================================================================
 */

package caw.pos.workorder.op;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawWorkOrderAccountIdOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderAccountIdOp.class);

    /* Get work order id for creating work order account chain.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);

        if (workOrderResult != null) {
            //this value is used in: CreateWorkOrderAccountOp
            setScopedValue(ValueKeys.ENTERED_ACCOUNT_ID, workOrderResult
                    .getAccountId());
        } else {
            _logger.error("Work Order: work order account result is null.");
        }
        return HELPER.completeResponse();
    }

}
