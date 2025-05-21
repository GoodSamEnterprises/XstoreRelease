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
 * BZ27193          140818    [Updated Requirement] Work Order Complete button must be enabled for both new and deposit work orders from S&I
 *===================================================================
 */

package caw.pos.workorder.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.common.TransactionType;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.type.CustomerAccountStateType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 * Update work order's status from 'new' to 'ready to pickup'
 */
public class CawUpdateNewToReadyToPickupStateOp extends Operation {

    private static final Logger   _logger = LogManager
            .getLogger(CawUpdateNewToReadyToPickupStateOp.class);

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Inject
    private WorkOrderHelper       _workOrderHelper;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        if (account != null) {

            if (account.getCustAccountStateCode()
                    .equals(CustomerAccountStateType.NEW.getCode())) {
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
