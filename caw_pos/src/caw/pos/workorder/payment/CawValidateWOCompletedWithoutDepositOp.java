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
 * BZ27258          200818    [WO][1.6.9] Deposit/Payment and Balance due display incorrectly on receipt when doing WORK ORDER COMPLETE with the WO: OPEN.
 * BZ30013          020419    [INTERNAL] Error java.lang.IllegalArgumentException: Quantity cannot be non-positive in xstore log
 * BZ31797          120719    [Prod] BZ31596 - WO with $0 tender is pending in OS
 * BZ30688          010819    [Prod] Xstore can not create a Receipt for Work Order Transaction
 *===================================================================
 */

package caw.pos.workorder.payment;

import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.common.CawWorkOrderHelper;
import dtv.pos.common.OpChainKey;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawValidateWOCompletedWithoutDepositOp
        extends CawValidateWorkOrderDepositOp {

    private static final Logger   _logger = LogManager
            .getLogger(CawValidateWOCompletedWithoutDepositOp.class);

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Override
    protected OpChainKey getAddItemChainKey() {

        return OpChainKey.valueOf("CAW_ADD_WORK_ORDER_DEPOSIT_ITEM");
    }

    @Override
    protected OpChainKey getCompleteAddItemChainKey() {

        return OpChainKey.valueOf("ADD_WORK_ORDER_ITEM_FINISH");
    }

    @Override
    protected IOpResponse handleDeposit() {

        IOpResponse response = HELPER.completeResponse();
        try {
            IPosTransaction iPosTransaction = _transactionScope
                    .getTransaction();
            if (iPosTransaction != null) {

                BigDecimal depositAmount = iPosTransaction.getTotal();

                ISaleReturnLineItem iSaleReturnLineItem = CawWorkOrderHelper
                        .getInstance().createDepositAmountLine(BigDecimal.ZERO); /*BZ30013: in case complete without deposit, this deposit item's price should be ZERO*/
                iSaleReturnLineItem.setVoid(true);

                ICustomerItemAccount account = (ICustomerItemAccount) this._accountHelper
                        .getCurrentAccount(this
                                .getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE));

                if (account != null
                        && account.getCustItemAccountDetails() != null
                        && account.getCustItemAccountDetails().size() > 0) {
                    /*
                     * When user deposit many times, the Xstore will add ICustomerItemAccountDetails to Work Order transaction.
                     * It is reason of issue double deposit amount. Due we only keep the element in current list.
                     */
                    List<ICustomerItemAccountDetail> iCustomerItemAccountDetails = account
                            .getCustItemAccountDetails();
                    for (ICustomerItemAccountDetail iCustomerItemAccountDetail : iCustomerItemAccountDetails) {
                        if (CawWorkOrderConstants.DEPOSIT_TYPE_CODE
                                .equalsIgnoreCase(iCustomerItemAccountDetail
                                        .getTypeCode())) {
                            iCustomerItemAccountDetails
                                    .remove(iCustomerItemAccountDetail);
                            break;
                        }
                    }

                    account.setAccountPayments(depositAmount);
                }
                this.setScopedValue(ValueKeys.CURRENT_SALE_LINE, iSaleReturnLineItem);
                this.setScopedValue(ValueKeys.CURRENT_ACCOUNT_DETAIL_TYPE, CustomerItemAccountDetailType.DEPOSIT); /*BZ30688*/
                response = this.HELPER.getCompleteStackChainResponse(this
                                .getAddItemChainKey()); /*BZ31797*/
            }

        } catch (Exception ex) {
            _logger.error("The work order deposit does not add item deposit."
                    + ex.getMessage());
        }
        
        return response;
    }
}
