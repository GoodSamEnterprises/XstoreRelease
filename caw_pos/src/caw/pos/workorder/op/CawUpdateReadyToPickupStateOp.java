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
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 *===================================================================
 */

package caw.pos.workorder.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;

import dtv.pos.common.TransactionType;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.type.CustomerAccountStateType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 *
 */
public class CawUpdateReadyToPickupStateOp extends Operation {

    private static final Logger   _logger = LogManager
            .getLogger(CawUpdateReadyToPickupStateOp.class);

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Inject
    private WorkOrderHelper       _workOrderHelper;

    /* Update work order account state to READY TO PICKUP.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT); //BZ27378

        if (account != null && workOrderResult != null) {

            if (workOrderResult.getWoPosStatusDescription()
                    .equalsIgnoreCase(CawWorkOrderConstants.DEPOSIT)) {
                _accountHelper
                        .updateAccountState(account, CustomerAccountStateType.READY_TO_PICKUP, _transactionScope
                                .getTransaction(TransactionType.RETAIL_SALE));
                _logger.info("WO update work order account state: "
                        + CustomerAccountStateType.READY_TO_PICKUP.getCode());
            }
        } else {
            _logger.error("WO current work order account is null.");
        }
        return HELPER.completeResponse();
    }

}
