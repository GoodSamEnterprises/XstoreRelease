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
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27256          200818    Extend price doesn't show on WO refund UI as well as receipt.
 *===================================================================
 */

package caw.pos.workorder.payment;

import java.math.BigDecimal;
import java.util.List;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.cwo.IWorkOrderLineItem;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The class update transaction total amount = deposit amount
 */
public class CawRefreshDepositAmountDueOp extends Operation {

    @Override
    public boolean isOperationApplicable() {

        boolean isRun = false;
        IRetailTransaction iRetailTransaction = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        if (iRetailTransaction != null) {

            List<IRetailTransactionLineItem> listLineItems = iRetailTransaction
                    .getRetailTransactionLineItems();
            if (listLineItems != null && listLineItems.size() > 0) {
                for (IRetailTransactionLineItem lineItem : listLineItems) {
                    if (lineItem instanceof IWorkOrderLineItem) {
                        isRun = true;
                        break;
                    }
                }
            }
        }

        if ((isRun && CawWorkOrderOptionsOp.isDepositAction())
                || (isRun && CawWorkOrderOptionsOp.isRefundAction())) {
            isRun = true;
        } else {
            isRun = false;
        }

        return isRun;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        BigDecimal depositAmount = this
                .getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
        // Begin BZ27256
        if (depositAmount == null && CawWorkOrderOptionsOp.isRefundAction()) {
            IWorkOrderAccount lastAccount = _transactionScope
                    .getValue(CawValueKeys.CAW_WORK_ORDER_ACCOUNT);
            List<ICustomerItemAccountDetail> listDetail = lastAccount
                    .getCustItemAccountDetails();

            if (!listDetail.isEmpty()) {
                for (ICustomerItemAccountDetail lineDetail : listDetail) {
                    if (lineDetail.getTypeCode()
                            .equals(CawWorkOrderConstants.DEPOSIT_TYPE_CODE)) {
                        depositAmount = lineDetail.getExtendedAmount();
                    }
                }
            }
        }
        // End BZ27256

        if (depositAmount != null) {
            IPosTransaction iPosTransaction = _transactionScope
                    .getTransaction();
            if (CawWorkOrderOptionsOp.isDepositAction()) {
                iPosTransaction.setTotal(depositAmount);
            } else if (CawWorkOrderOptionsOp.isRefundAction()) {
                iPosTransaction.setTotal(depositAmount.negate()); // BZ27256
            }
        }

        return HELPER.completeResponse();
    }
}
