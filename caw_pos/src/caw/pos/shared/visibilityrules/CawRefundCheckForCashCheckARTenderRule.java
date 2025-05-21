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
 * BZ24071          181017    Refund Check is unavailable at Refund tender option 
 *                            when performing return transaction for Cash and Check tender
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ27024          060818    [1.6.2] WO- Refund check doesn't display on return tender options screen when doing WO refund
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.register.CawTransactionUtils;
import caw.pos.tender.CawTenderConstants;

import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Refund Check is enable if Original Transaction was tended by Cash, Check/Travel Check and AR Account.
 */
public class CawRefundCheckForCashCheckARTenderRule
        extends AbstractVisibilityRule {

    @Inject
    private ReturnManager         _returnMgr;

    @Inject
    protected TransactionScope    _transactionScope;

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        // Begin BZ25068
        //Begin BZ27924
        List<ISaleReturnLineItem> lineItemsWebReturn = _transactionScope
                .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
        if (CawTransactionUtils
                .isReturnWebOrder(getCurrentRetailTransaction(), lineItemsWebReturn)) {
            //End BZ27924
            return AccessLevel.GRANTED;
            // End BZ25068
        } else {
            List<IRetailTransaction> origTrans = _returnMgr
                    .getAllOrigTransaction();

            String tenderId = null;
            if (!(origTrans.isEmpty())) {
                for (IRetailTransaction retailTrans : origTrans) {
                    for (IRetailTransactionLineItem retailTransLineItem : retailTrans
                            .getTenderLineItems()) {
                        if (retailTransLineItem instanceof ITenderLineItem) {
                            tenderId = ((ITenderLineItem) retailTransLineItem)
                                    .getTenderId();
                            if (CawTenderConstants.CHECK.equals(tenderId) // Check
                                    || CawTenderConstants.USD_TRAVELERS_CHECK
                                            .equals(tenderId) // Travel Check
                                    || CawTenderConstants.AR_ACCOUNT
                                            .equals(tenderId) // AR account
                                    || CawTenderConstants.USD_CURRENCY
                                            .equals(tenderId)) { // Cash
                                return AccessLevel.GRANTED;
                            }
                        }
                    }
                }
            }

            //Begin BZ27024, BZ27192
            IWorkOrderAccount account = _transactionScope
                    .getValue(CawValueKeys.CAW_WORK_ORDER_ACCOUNT);

            if (account != null) {
                IPosTransaction lastTrans = _accountHelper
                        .retrieveLatestTransaction(account);
                if (lastTrans != null) {
                    for (IRetailTransactionLineItem retailTransLineItem : lastTrans
                            .getRetailTransactionLineItems()) {
                        if (retailTransLineItem instanceof ITenderLineItem) {
                            tenderId = ((ITenderLineItem) retailTransLineItem)
                                    .getTenderId();
                            if (CawTenderConstants.CHECK.equals(tenderId) // Check
                                    || CawTenderConstants.USD_TRAVELERS_CHECK
                                            .equals(tenderId)) { // Travel Check
                                return AccessLevel.GRANTED;
                            }
                        }
                    }
                }
            }
            //End BZ27024

            return AccessLevel.DENIED;
        }
    }

}
