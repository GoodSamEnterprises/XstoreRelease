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
 * BZ27068          080818    [1.6.4] Cannot complete Work Order Refund for the selected Work Order with status: OPEN
 * BZ27006          090818    [1.6.2] Missing reason code on Word Order refund when performing Cancel WO transaction
 * BZ27256          200818    Extend price doesn't show on WO refund UI as well as receipt.
 * BZ27024          230818    [1.6.2] WO- Refund check doesn't display on return tender options screen when doing WO refund
 *===================================================================
 */

package caw.pos.customer.account.op;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;
import javax.inject.Provider;

import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.common.TransactionHelper;
import dtv.pos.customer.account.*;
import dtv.pos.customer.account.op.AddCancelledAccountToPersistablesBagOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnType;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerAccount;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawAddCancelledAccountToPersistablesBagOp
        extends AddCancelledAccountToPersistablesBagOp {

    @Inject
    private Provider<AccountManager> _accountManager;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        ICustomerAccountType type = this
                .getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE);
        AccountManager am = this._accountManager.get();
        ICustomerAccountMaintModel model = am.getCurrentCustAccountModel(type);
        ICustomerAccount account = model.getAccount();

        account.setAccountBalance(BigDecimal.ZERO);

        if (account instanceof ICustomerItemAccount) {
            ICustomerItemAccount itemAccount = (ICustomerItemAccount) account;
            if (!account.getCustAccountCode().equalsIgnoreCase("ONHOLD")) {
                itemAccount.setAccountPayments(BigDecimal.ZERO);
                itemAccount.setAccountTotal(BigDecimal.ZERO);
            } else {
                itemAccount.setAccountTotal(itemAccount.getAccountPayments());
            }
            itemAccount.setActiveAccountPayments(BigDecimal.ZERO);
            itemAccount.setActiveAccountTotal(BigDecimal.ZERO);
            //Begin BZ27006
            IReasonCode reason = getScopedValue(ValueKeys.SELECTED_REASON_CODE);
            String comment = getScopedValue(ValueKeys.ENTERED_COMMENT);
            //End BZ27006
            List<IRetailTransactionLineItem> lists = model
                    .getCurrentTransaction().getSaleLineItems();
            ISaleReturnLineItem line = null;
            IRetailTransactionLineItem iTranItem;
            // BZ27024 start
            ISaleReturnLineItem workOrderDeposit = null;
            for (IRetailTransactionLineItem list : lists) {
                if (list instanceof ISaleReturnLineItem) {
                    if (((ISaleReturnLineItem) list)
                            .getOriginalBusinessDate() != null) {
                        workOrderDeposit = (ISaleReturnLineItem) list;
                        break;
                    }
                }

            }
            // BZ27024 end
            for (Iterator<IRetailTransactionLineItem> iterator = lists
                    .iterator(); iterator.hasNext();) {
                iTranItem = iterator.next();
                //Begin BZ27006
                if (reason != null
                        && iTranItem instanceof ISaleReturnLineItem) {
                    // Begin BZ27256
                    line = (ISaleReturnLineItem) iTranItem;
                    if (line.getItemId()
                            .equals(CawWorkOrderConstants.DEPOSIT_MOCKUP_ITEM_ID)) {
                        line.setVoid(true);
                    } else {
                        line.setVoid(false);
                    }
                    line.setReturn(true);
                    line.setReturnTypeCode(ReturnType.VERIFIED.name());
                    line.setForceZeroExtendedAmt(false);

                    line.setReturnReasonCode(reason.getReasonCode());
                    line.setReturnComment(comment);
                    // BZ27024 start
                    if (workOrderDeposit != null) {
                        line.setOriginalBusinessDate(workOrderDeposit
                                .getOriginalBusinessDate());
                        line.setOriginalRetailLocationId(workOrderDeposit
                                .getRetailLocationId());
                        line.setOriginalWorkstationId(workOrderDeposit
                                .getOriginalWorkstationId());
                        line.setOriginalTransactionSequence(workOrderDeposit
                                .getOriginalTransactionSequence());
                    }
                    // BZ27024 end
                    // End BZ27256
                }
                //End BZ27006
            }
        }
        TransactionHelper.addPersistable(account);
        am.setCurrentCustomerAccountModel((ICustomerAccountMaintModel) null, type);
        return this.HELPER.completeResponse();
    }
}
