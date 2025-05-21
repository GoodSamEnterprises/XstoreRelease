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
 * BZ27294          230818    'Issue Store credit' is displayed as refund tender when 
 *                            performing WO complete then remove a line item from WO transaction
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 * BZ30754          160519    [PORT 30531 to 5.0] [Prod] Unable to complete the WO if WO deposit is created in xstore offline mode
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.ejournal.CawTransactionSearchHelper;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cat.ICustomerAccount;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawRetrieveLatestTransaction extends Operation {

    private static final Logger   _logger = LogManager
            .getLogger(CawRetrieveLatestTransaction.class);

    @Inject
    protected WorkOrderHelper     _workOrderHelper;

    @Inject
    private ReturnManager         _returnMgr;
    
    @Inject
    private CawTransactionSearchHelper _cawTransactionSearchHelper;

    /* 
     * This class will retrieve the latest transaction.
     * 
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        //Begin BZ27378
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        ICustomerAccount account = CawWorkOrderHelper.getInstance()
                .retrieveAccount(workOrderResult); /*BZ30754*/
        if (account == null) {
            account = _workOrderHelper.getCurrentWorkOrderAccount();
        }
        //End BZ27378

        if (account != null) {
            IPosTransaction lastTrans = CawWorkOrderHelper.getInstance()
                    .retrieveLatestTransaction(account, _cawTransactionSearchHelper); /*BZ30754*/

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
