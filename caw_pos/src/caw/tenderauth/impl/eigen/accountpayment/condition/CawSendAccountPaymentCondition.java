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
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.condition;

import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 * Condition for sending Account Payment request.
 */
public class CawSendAccountPaymentCondition extends AbstractRunCondition {

    @Inject
    protected TransactionScope _transactionScope;

    /* Condition for sending Account Payment request.
     * @see dtv.pos.framework.op.AbstractRunCondition#shouldRunImpl()
     */
    @Override
    protected boolean shouldRunImpl() {

        if (_transactionScope.getValue(CawValueKeys.IS_ACCOUNT_PAYMENT) != null) {
            boolean isAccountPaymentTrans = _transactionScope.getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);
            if (BooleanUtils.isTrue(isAccountPaymentTrans)) {
                return true;
            }
        }

        return false;
    }

}
