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
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 *===================================================================
 */

package caw.pos.workorder.account;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.pos.customer.account.AccountManager;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cat.ICustomerAccount;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 *
 */
public class CawWorkOrderRetrieveAccount extends Operation {

    private static final Logger      _logger = LogManager
            .getLogger(CawWorkOrderRetrieveAccount.class);

    @Inject
    private Provider<AccountManager> _amProvider;

    @Inject
    protected WorkOrderHelper        _workOrderHelper;

    /* Retrieve work order account from database.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        //Clear current account
        _amProvider.get().clear();
        //Get account from DB
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        ICustomerAccount account = CawWorkOrderHelper.getInstance()
                .retrieveAccount(workOrderResult);
        if (account != null && account instanceof IWorkOrderAccount) {
            _amProvider.get()
                    .addAccount(CustomerAccountType.WORK_ORDER, account);
            _transactionScope
                    .setValue(CawValueKeys.CAW_WORK_ORDER_ACCOUNT, (IWorkOrderAccount) account); //BZ27378
        } else {
            _logger.error("WO current work order account is null.");
        }
        return HELPER.completeResponse();
    }
}
