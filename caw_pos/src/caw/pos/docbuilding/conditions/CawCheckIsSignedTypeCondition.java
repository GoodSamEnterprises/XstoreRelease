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
 * BZ37709          080920    [Internal] Removing the customer's signature line on Store Copy receipt of Create Order transaction
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawCheckIsSignedTypeCondition extends AbstractInvertableCondition {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        String isSigned = _transactionScope.getValue(CawValueKeys.IS_ORDER_TRANSACTION);
        if (isSigned != null && isSigned.equals("SIGNED")) {
            return false;
        }
        return true;
    }
}