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
 * BZ27023          060818    [1.6.2] WO - Xstore doesn't retrieve existing tokens for credit tenders when doing WO Cancel transaction
 * BZ27035          060818    Work Order Refund Tender Option Issue
 * BZ27036          060818    Work Order Complete tender options isssue
 * BZ27063          060818    [1.6.4] WO Xstore must NOT send the status call to reset the WO status
 * BZ27256          200818    Extend price doesn't show on WO refund UI as well as receipt.
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawCancelWorkOrderAccountOp extends Operation {

    private static final Logger   _logger = LogManager
            .getLogger(CawCancelWorkOrderAccountOp.class);

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Inject
    protected WorkOrderHelper     _workOrderHelper;

    @Inject
    private ReturnManager         _returnMgr;

    /* 
     * This extends class will send update status to EBS.
     * 
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        if (account != null) {
            IPosTransaction lastTrans = _accountHelper
                    .retrieveLatestTransaction(account);

            if (lastTrans != null) {
                // Begin BZ27256
                _transactionScope
                        .setValue(CawValueKeys.CAW_LATEST_TRANSACTION, lastTrans);
                _returnMgr.addOrigTransaction((IRetailTransaction) lastTrans);
                // End BZ27256
                //Begin BZ27023, BZ27035, BZ27036
                for (IRetailTransactionLineItem retailTransLineItem : lastTrans
                        .getRetailTransactionLineItems()) {

                    if (retailTransLineItem instanceof ICreditDebitTenderLineItem) {
                        ICreditDebitTenderLineItem tenderLine = (ICreditDebitTenderLineItem) retailTransLineItem;
                        Map<ICreditDebitTenderLineItem, ICreditDebitTenderLineItem> refMap = new HashMap<>();
                        refMap.put(tenderLine, tenderLine);
                        _transactionScope
                                .setValue(TransactionScopeKeys.ORIGINAL_CREDITCARD_MAPPING, refMap);
                    }
                }
                //End BZ27023, BZ27035, BZ27036
            } else {
                _logger.error("WO last transaction is null.");
            }
        } else {
            _logger.error("WO work order account is null.");
        }
        return HELPER.completeResponse();
    }
}
