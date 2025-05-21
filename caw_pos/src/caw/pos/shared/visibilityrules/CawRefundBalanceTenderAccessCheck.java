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
 * BZ23371          140917    Implement Refund check
 * BZ23773          131017    [AR Accounts] Refund Tenders should include Refund Check
 * BZ24071          181017    Refund Check is unavailable at Refund tender option 
 *                            when performing return transaction for Cash and Check tender
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.register.CawTransactionUtils;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.shared.visibilityrules.RefundBalanceTenderAccessCheck;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Refund Check enable if amount due >= 100 USD.
 */
public class CawRefundBalanceTenderAccessCheck
        extends RefundBalanceTenderAccessCheck {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() {

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

            BigDecimal balanceDue = null;

            IRetailTransaction currentTransaction = getCurrentRetailTransaction();

            if (currentTransaction == null) {
                return AccessLevel.DENIED;
            }
            balanceDue = currentTransaction.getAmountDue();

            if (balanceDue.abs().compareTo(new BigDecimal(100.00)) < 0) {
                return AccessLevel.DENIED;
            }
            return AccessLevel.GRANTED;
        }
    }

}
