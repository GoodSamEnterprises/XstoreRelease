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
 * Req/Bug ID#      ddMMyy      Description
 * BZ29387          140219      [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 *===================================================================
 */
package caw.pos.shared.visibilityrules;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.trn.IPosTransaction;

public class CawAPDisableRelatedFunctionsVisibilityRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {

            Boolean valid = _transactionScope.getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);

            IPosTransaction pos = _transactionScope.getTransaction();

            if (pos != null && valid != null && CawCustomerUtil.isAccountPayment(pos, valid.booleanValue())) {
                return AccessLevel.DENIED;
            }
        }

        return AccessLevel.GRANTED;

    }

}
