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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction
 * BZ49449          280422    [Internal] - The promotions were removed incorrectly
 * BZ50139          250522    [Internal] Xstore makes a call to New Service incorrectly when performing types of Work Order transactions. 
 * BZ54776          120123    Bug 54776 : [Patch 22.0] Extend ability to turn ON/OFF loyalty functionality into xstore to specific stores if needed.
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 *===================================================================
 */

package caw.pos.cheetah;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.CawValueKeys;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawApplyPromoRewardsCondition extends AbstractRunCondition{

    @Inject
    protected TransactionScope _transactionScope;
    @Inject
    private OrderMgr                       _orderMgr;
    @Override
    protected boolean shouldRunImpl() {
        if (CawCheetahHelper.isEnableLoyalty()) {//BZ54776
            IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
            String jsonMessage = CawCatalystHelper.getLookupResponseData();
            IParty cust = _transaction.getCustomerParty();
            //Start BZ50139
            //not allow Apply Promo Rewards for WO
            if(CawWorkOrderOptionsOp.isDepositAction() || CawWorkOrderOptionsOp.isRefundAction()) { //BZ54290
                return false;
            }
            //not allow Apply Promo Rewards for order
            IOrder currentOrder = this._orderMgr.getCurrentOrder();
            if(currentOrder != null && currentOrder.getOrderLines().size() > 0) {
                return false;
            }
            //End BZ50139
            //Start BZ54290
            if(cust != null && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null
                    &&_transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) //BZ54290
                    && (_transaction.getAmountDue().compareTo(BigDecimal.ZERO) == 1
                    || CawWorkOrderOptionsOp.isCompleteAction())) {
                _transactionScope.setValue(CawValueKeys.IS_APPLY_PROMOS_REWARD, Boolean.TRUE);/*BZ49449*/
                return true;
            }
            //End BZ54290
        }
        return false;
    }

}
