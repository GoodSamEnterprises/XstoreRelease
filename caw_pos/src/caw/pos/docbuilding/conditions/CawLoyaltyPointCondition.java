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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.order.OrderReceiptSource;
import dtv.pos.workorder.common.IWorkOrderAccountModel;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.xom.impl.order.OrderStatus;

/**
 *
 */
public class CawLoyaltyPointCondition extends AbstractInvertableCondition {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected boolean conditionMetImpl(Object argSoure) {

        if (argSoure instanceof IRetailTransaction) {
            Boolean isWorkOrderTrans = _transactionScope.getValue(CawValueKeys.IS_WORK_ORDER_TRANS);
            if(BooleanUtils.isTrue(isWorkOrderTrans) && !CawWorkOrderOptionsOp.isCompleteAction()) {
                return false;
            }
            return _transactionScope.getValue(CawValueKeys.CAW_REWARD_LOYALTY_POINTS) != null;
        } else if (argSoure instanceof IWorkOrderAccountModel) {
            return CawWorkOrderOptionsOp.isCompleteAction() && _transactionScope.getValue(CawValueKeys.CAW_REWARD_LOYALTY_POINTS) != null;
        } else if (argSoure instanceof OrderReceiptSource) {
            IPosTransaction iPosTransaction = ((OrderReceiptSource) argSoure).getTransaction();
            if (iPosTransaction != null) {
                String orderType = iPosTransaction.getStringProperty(CawConstants.CAW_ORDER_TYPE);
                return OrderStatus.COMPLETE.matches(orderType);
            }
        }
        return false;
    }
}
