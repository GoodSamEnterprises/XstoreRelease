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
 * BZ27312          220818    Work Order Refund - Credit Card tender can't refund full deposit
 * BZ27314          220818    Work Order Refund - Cannot do a refund for Work Order has decimal quantity
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 *===================================================================
 */

package caw.pos.workorder.account;

import java.math.BigDecimal;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.pos.customer.account.type.CustomerAccountStateType;
import dtv.pos.workorder.account.UpdateWorkOrderAccountWorker;
import dtv.util.NumberUtils;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.cat.IDeliveryModifier;

/**
 *
 */
public class CawUpdateWorkOrderAccountWorker
        extends UpdateWorkOrderAccountWorker {

    /* Prevent Xstore change work order status to closed in case there no task item(s).
     * @see dtv.pos.customer.account.op.AbstractUpdateCustAccountSaleWorker#updateAccount(dtv.pos.customer.account.ICustomerAccountMaintModel)
     */
    @Override
    protected void updateAccount(ICustomerAccountMaintModel argModel) {

        ICustomerItemAccount account = (ICustomerItemAccount) argModel
                .getAccount();
        //Begin BZ27378
        if (account.getAccountBalance().compareTo(BigDecimal.ZERO) < 0) {
            account.setAccountPayments(account.getAccountTotal());
            account.setAccountBalance(BigDecimal.ZERO);
        }
        //End BZ27378
        IDeliveryModifier mod = account.getDeliveryModifier();

        updateCustomerItemAccount(account, argModel.getCurrentTransaction());

        int openItemCount = updateCustomerItemAccountDetails(account
                .getCustItemAccountDetails(), mod);

        // If there is no customer account item contains state of OPEN or NEW and the total
        // balance and actual total is the same, system should change the account
        // status to CLOSED or INACTIVE.
        BigDecimal accountBalance = NumberUtils
                .nonNull(account.getAccountBalance());

        //BZ27312 and BZ27314 added checking of isDepositAction()
        if ((openItemCount == 0) && NumberUtils.isNonPositive(accountBalance)
                && !CawWorkOrderOptionsOp.isDepositAction()) {
            if (allowMultipleAccountPerCustomer()) {
                closeCustomerAccount(account, CustomerAccountStateType.CLOSED, argModel
                        .getCurrentTransaction());
            } else {
                closeCustomerAccount(account, CustomerAccountStateType.INACTIVE, argModel
                        .getCurrentTransaction());
            }
        }
    }

}
