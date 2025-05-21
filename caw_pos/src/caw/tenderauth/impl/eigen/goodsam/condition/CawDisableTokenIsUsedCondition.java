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
 * BZ58779          110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added. 
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.condition;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawDisableTokenIsUsedCondition extends AbstractRunCondition {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected boolean shouldRunImpl() {

        Boolean cawDisableTokenIsUsed = _transactionScope.getValue(CawValueKeys.CAW_DISABLE_TOKEN_IS_USED);

        if (cawDisableTokenIsUsed != null && cawDisableTokenIsUsed) {
            return true;
        }
        return false;
    }

}
