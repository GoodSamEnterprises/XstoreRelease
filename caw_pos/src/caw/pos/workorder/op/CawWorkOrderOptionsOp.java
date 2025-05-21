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
 * BZ27024          060818    [1.6.2] WO- Refund check doesn't display on return tender options screen when doing WO refund
 * BZ27063          060818    [1.6.4] WO Xstore must NOT send the status call to reset the WO status
 * BZ27068          080818    [1.6.4] Cannot complete Work Order Refund for the selected Work Order with status: OPEN
 * BZ27163          100818    WO Email receipt shows the incorrect header for Work Order Deposit or Refund
 * BZ27193          140818    [Updated Requirement] Work Order Complete button must be enabled for both new and deposit work orders from S&I
 * BZ27243          170818    Work Order Deposit shows double the deposit amount when the first tender is declined
 * BZ27294          220818    'Issue Store credit' is displayed as refund tender when performing WO complete then remove a line item from WO transaction
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 * BZ31520          250619    [Port BZ31207 to 5.0][Work Order] clicking back after selecting a WO throws error message
 * BZ39711          301120    [Internal] Xstore does not make OLPS status (Make offer) request to Neuron API at catalyst 4 for 1st transaction when Xstore has just restarted then boot up successfully xstore
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.account.AccountManager;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 *
 */
public class CawWorkOrderOptionsOp extends PromptOp {

    private static final Logger            _logger         = LogManager
            .getLogger(CawWorkOrderOptionsOp.class);

    @Inject
    private Provider<AccountManager>       _amProvider;

    @Inject
    protected WorkOrderHelper              _workOrderHelper;

    @Inject
    private IBusyState                     _busyState;//BZ31520

    private static final IXstDataActionKey COMPLETE        = XstDataActionKey
            .valueOf("COMPLETE");

    private static final IXstDataActionKey DEPOSIT         = XstDataActionKey
            .valueOf("DEPOSIT");

    private static final IXstDataActionKey REFUND          = XstDataActionKey
            .valueOf("REFUND");

    private static final IXstDataActionKey BACK            = XstDataActionKey
            .valueOf("BACK");

    // Begin BZ27163
    /**
     * Value is:
     * -1: None
     * 0: Deposit
     * 1: Refund
     * 2: Complete
     */
    private static int                     workOrderAction = -1; // BZ-39711
    // End BZ27163

    /* Get prompt key.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        _busyState.endPermanent(); /*BZ31520*/
        return PromptKey.valueOf("CAW_WORK_ORDER_OPTIONS");
    }

    /* Start OpChain follow pressed button. Also send update status to EBS.
     * @see dtv.pos.framework.op.AbstractPromptOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey action = argEvent.getActionKey();

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT); //BZ27378

        if (account != null) {
            String[] args1 = account.getCustAccountId()
                    .split(CawWorkOrderConstants.WO_PREFIX);
            _transactionScope
                    .setValue(CawValueKeys.CAW_WORK_ORDER_NUMBER, args1[1]);
            _transactionScope
                    .setValue(CawValueKeys.IS_WORK_ORDER_TRANS, Boolean.TRUE);
            workOrderAction = -1; // BZ27163
            
            if (action == COMPLETE) {
                workOrderAction = 2; // BZ27163
                //Begin BZ27193
                if (workOrderResult.getWoPosStatusDescription()
                        .equalsIgnoreCase(CawWorkOrderConstants.OPEN)) {
                    return HELPER.getStartChainResponse(OpChainKey
                            .valueOf("CAW_PICKUP_WORK_ORDER_NO_DEPOSIT"));
                }
                //End BZ27193
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf("CAW_PICKUP_WORK_ORDER")); //BZ27378

            } else if (action == DEPOSIT) {
                workOrderAction = 0; // BZ27163
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf("CAW_WORK_ORDER_DEPOSIT_PRE_TENDER")); //BZ27243

            } else if (action == REFUND) {
                workOrderAction = 1; // BZ27163
                List<ICustomerItemAccountDetail> listItemLine = _workOrderHelper
                        .getAllLineItemsOnCurrentWorkOrderAccount();
                _transactionScope
                        .setValue(CawValueKeys.CAW_WORK_ORDER_LINE_ITEMS, listItemLine);
                _transactionScope
                        .setValue(CawValueKeys.CAW_WORK_ORDER_ACCOUNT, account);//BZ27024
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf("CAW_CANCEL_WORK_ORDER"));

            } else if (action == BACK) {
                List<ICustomerItemAccountDetail> listItemLine = _workOrderHelper
                        .getAllLineItemsOnCurrentWorkOrderAccount();
                _amProvider.get().clear();
                _transactionScope
                        .clearValue(CawValueKeys.CAW_WORK_ORDER_NUMBER);
                _transactionScope.clearValue(CawValueKeys.IS_WORK_ORDER_TRANS);
                _transactionScope
                        .setValue(CawValueKeys.CAW_WORK_ORDER_LINE_ITEMS, listItemLine);
                //After import a work order, all items appear on transaction list
                //if pressing back button, need removing all that items.
                //Start void line items OpChain
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf("WO_VOID_LINE_ITEMS"));
            }
        } else {
            _logger.error("WO work order account is null.");
        }
        return HELPER.completeResponse();
    }

    /* Display work order info on prompt.
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[1];
        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        if (account != null) {
            String[] args1 = account.getCustAccountId()
                    .split(CawWorkOrderConstants.WO_PREFIX);
            args[0] = _ff.getSimpleFormattable(args1[1]);
        }
        return args;
    }

    // Begin BZ27163
    /**
     * Check Deposit Action
     * @return Boolean value
     */
    public static boolean isDepositAction() {

        return workOrderAction == 0;
    }

    /**
     * Check Refund Action
     * @return Boolean value
     */
    public static boolean isRefundAction() {

        return workOrderAction == 1;
    }

    /**
     * Check Complete Action
     * @return Boolean value
     */
    public static boolean isCompleteAction() {

        return workOrderAction == 2;
    }

    /**
     * Reset workOrderAction value
     */
    public static void resetWorkOrderAction() {

        workOrderAction = -1;
    }
    // End BZ27163
}
