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
 * BZ35016          060320    [New Requirement] WO complete should not override WO deposit data in CAT_CUST_ITEM_ACCT_DETAIL
 *===================================================================
 */

package caw.pos.customer.account;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import dtv.data2.access.DataPropertyUtils;
import dtv.pos.common.TransactionHelper;
import dtv.pos.customer.account.AccountManager;
import dtv.pos.customer.account.AddCustAccountPersistableWorker;
import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.xst.dao.cat.ICustomerAccount;
import dtv.xst.dao.trn.IPosTransaction;

public class CawCheckWorkOrderAccountWorker extends AddCustAccountPersistableWorker {

    @Inject
    private Provider<AccountManager> _amProvider;

    @Override
    protected void performWorkImpl() throws Exception {

        List<? extends ICustomerAccountMaintModel> models = _amProvider.get().getAllCustomerAccountModels(true);

        if ((models != null) && !models.isEmpty()) {
            for (ICustomerAccountMaintModel model : models) {
                ICustomerAccount account = model.getAccount();
                // Put all the customer accounts in the persistable bag
                TransactionHelper.addPersistable(account);

                if (CustomerAccountType.WORK_ORDER.getName().equals(account.getCustAccountCode())) {
                    /* Updated into TRN_TRANS_P with WO transaction type */
                    IPosTransaction trans = model.getCurrentTransaction();
                    if (trans != null) {
                        if (CawWorkOrderOptionsOp.isDepositAction()) {
                            DataPropertyUtils.setPropertyValue(trans, account
                                    .getCustAccountId(), CustomerItemAccountDetailType.DEPOSIT.getName());
                        } else if (CawWorkOrderOptionsOp.isCompleteAction()) {
                            DataPropertyUtils.setPropertyValue(trans, account
                                    .getCustAccountId(), CustomerItemAccountDetailType.PAYMENT_TENDER.getName());
                        } else if (CawWorkOrderOptionsOp.isRefundAction()) {
                            DataPropertyUtils.setPropertyValue(trans, account
                                    .getCustAccountId(), CustomerItemAccountDetailType.PAYMENT_REFUND.getName());
                        }
                    }
                }
            }
        }
    }

}
