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
 * BZ27243          170818    Work Order Deposit shows double the deposit amount when the first tender is declined
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
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.workorder.payment.ValidateWorkOrderDepositOp;
import dtv.util.NumberUtils;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * The base Xstore need to a deposit item to complete work order transaction.
 * The requirement of CAW, they do not want to add to work order transaction.
 * Therefore this class going to mock up the deposit item.
 * The Item deposit will not display on GUI and it also inserts to the database  when 
 * transaction completed.
 * 
 */
public class CawValidateWorkOrderDepositOp extends ValidateWorkOrderDepositOp {

    private static final Logger   _logger = LogManager
            .getLogger(CawValidateWorkOrderDepositOp.class);

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

        //Begin BZ27243
        IOpResponse response = HELPER.completeResponse();
        try {
            BigDecimal depositAmount = this
                    .getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);

            _logger.info("Work oder deposit amount:" + depositAmount);

            ISaleReturnLineItem iSaleReturnLineItem = CawWorkOrderHelper
                    .getInstance().createDepositAmountLine(depositAmount);

            iSaleReturnLineItem.setVoid(true);

            ICustomerItemAccount account = (ICustomerItemAccount) this._accountHelper
                    .getCurrentAccount(this
                            .getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE));

            if (account != null && account.getCustItemAccountDetails() != null
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

            response = NumberUtils.isPositive(depositAmount)
                    ? this.HELPER.getCompleteStackChainResponse(this
                            .getAddItemChainKey())
                    : this.HELPER.completeResponse();
        } catch (Exception ex) {
            _logger.error("The work order deposit does not add item deposit."
                    + ex.getMessage());
        }
        // End BZ27243

        return response;
    }
}
