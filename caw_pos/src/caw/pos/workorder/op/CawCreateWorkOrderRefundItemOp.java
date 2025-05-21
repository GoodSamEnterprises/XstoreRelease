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
 * BZ27006          020818    [1.6.2] Missing reason code on Word Order refund when performing Cancel WO transaction
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ46429          281021    [PROD] Work Order Prepay and Complete Issue
 *===================================================================
 */

package caw.pos.workorder.op;

import static dtv.pos.customer.account.type.CustomerAccountStateType.CLOSED;
import static dtv.util.NumberUtils.isNegative;
import static dtv.util.NumberUtils.isPositive;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.common.CommonHelper;
import dtv.pos.common.OpChainKey;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.type.CustomerAccountStateType;
import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnType;
import dtv.pos.spring.ValueKeys;
import dtv.pos.workorder.account.CreateWorkOrderRefundItemOp;
import dtv.util.NumberUtils;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.cat.ICustomerItemAccountActivity;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawCreateWorkOrderRefundItemOp extends CreateWorkOrderRefundItemOp {

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Inject
    private CommonHelper          _commonHelper;
    
    /* BEGIN BZ46429 */
    @Override
    public boolean isOperationApplicable() {

        ICustomerItemAccount account = (ICustomerItemAccount) this._accountHelper
                .getCurrentAccount(getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE));
        
        BigDecimal activeAccountPayment = account.getActiveAccountPayments();
        
        if (activeAccountPayment == null || activeAccountPayment.equals(BigDecimal.ZERO)) {
            
            CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                    .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
            
            account.setActiveAccountPayments(workOrderResult.getWoDepositAmt());
            account.setAccountPayments(workOrderResult.getWoDepositAmt());
            
            account.setActiveAccountTotal(workOrderResult.getWoTotalWithTax());
            account.setAccountTotal(workOrderResult.getWoTotalWithTax());
            
            DataFactory.makePersistent(account);
        }        

        if (NumberUtils.isPositive(account.getActiveAccountPayments())
                && CustomerAccountStateType.CLOSED
                        .matches(account.getCustAccountStateCode())) {
            return true;
        }
        if (NumberUtils.isNegative(account.getAccountBalance())) {
            return true;
        }
        return false;
    }
    /* END BZ46429 */

    /* Extends: add reason code to refund.
     * @see dtv.pos.customer.account.op.AbstractCreateRefundItemOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        ICustomerItemAccount account = _accountHelper
                .getCurrentAccount(getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE));
        BigDecimal refundAmount = BigDecimal.ZERO;

        IReasonCode reason = getScopedValue(ValueKeys.SELECTED_REASON_CODE);
        String comment = getScopedValue(ValueKeys.ENTERED_COMMENT);

        if (isPositive(account.getActiveAccountPayments())
                && CLOSED.matches(account.getCustAccountStateCode())) {
            refundAmount = account.getActiveAccountPayments().abs();
        } else if (isNegative(account.getAccountBalance())) {
            refundAmount = account.getAccountBalance().abs();
        }
        ICustomerItemAccountActivity detail = getCreationActivity(account);
        ISaleReturnLineItem returnItem = CawWorkOrderHelper.getInstance()
                .createDepositAmountLine(BigDecimal.ZERO);

        returnItem.setReturn(true);
        returnItem.setReturnTypeCode(ReturnType.VERIFIED.name());

        if (detail != null) {
            returnItem.setOriginalBusinessDate(detail.getBusinessDate());
            returnItem.setOriginalLineItemSequence((int) detail
                    .getTransLineItemSeq());
            returnItem
                    .setOriginalRetailLocationId(detail.getRetailLocationId());
            returnItem
                    .setOriginalTransactionSequence(detail.getTransSequence());
            returnItem.setOriginalWorkstationId(detail.getWorkstationId());
        }
        //BZ27006-Removed check null comment.
        if (reason != null) {
            returnItem.setReturnReasonCode(reason.getDescription());
            returnItem.setReturnComment(comment);
        }

        setScopedValue(ValueKeys.CURRENT_ITEM, returnItem.getItem());
        setScopedValue(ValueKeys.CURRENT_SALE_LINE, returnItem);
        setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, _commonHelper
                .roundCurrency(refundAmount));
        setScopedValue(ValueKeys.CURRENT_ACCOUNT_DETAIL_TYPE, CustomerItemAccountDetailType.PAYMENT_REFUND);

        return HELPER.getCompleteStackChainResponse(getOpChainKey());
    }

    // Begin BZ27192
    /* Get opchain key.
     * @see dtv.pos.workorder.account.CreateWorkOrderRefundItemOp#getOpChainKey()
     */
    @Override
    protected OpChainKey getOpChainKey() {

        return OpChainKey.valueOf("CAW_ADD_WORK_ORDER_DEPOSIT_ITEM");
    }
    // End BZ27192
}
