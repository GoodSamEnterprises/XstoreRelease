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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawRvPaymentSelectedItemVisibilityRule extends AbstractVisibilityRule {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel accessLevel = AccessLevel.DENIED;
        List<CawRvPaymentModel> rvSelectedItems = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST);
        if (rvSelectedItems != null && rvSelectedItems.size() > 0) {
            accessLevel = AccessLevel.GRANTED;
        }
        return accessLevel;
    }

}