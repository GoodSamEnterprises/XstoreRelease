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
 * BZ27245          170818    Work Order Refund must be exclusive and not combined with any other items.
 * BZ27379          120918    [1.6.15] WO Xstore reflects the discount incorrectly for the WO line item
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import javax.inject.Inject;

import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawWODisableRelatedFunctionsVisibilityRule class
 */
public class CawWODisableRelatedFunctionsVisibilityRule
        extends AbstractVisibilityRule {

    @Inject
    protected WorkOrderHelper  _workOrderHelper;

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {
            IPosTransaction pos = _transactionScope.getTransaction();
            //BZ27379 changed condition for WO refund status
            if (pos != null && CawWorkOrderHelper.getInstance()
                    .isWorkOrderRedundStatus(pos)) {
                return AccessLevel.DENIED;
            }
        }

        return AccessLevel.GRANTED;

    }
}
