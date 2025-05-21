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
 * BZ25321          310118    Redundant "Return Web Order" button is into Purchase Used Firearm Return workflow screen
 *===================================================================
 */

package caw.pos.register.returns;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawWebOrderReturnItemRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {
            Boolean isUfa = _transactionScope
                    .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);
            Boolean isSale = _transactionScope
                    .getValue(CawValueKeys.IS_RETURN_WEB_ORDER);
            if (isSale != null && isSale.booleanValue()) {
                return AccessLevel.DENIED;
            } else if (isUfa != null && isUfa.booleanValue()) {
                // Begin B25321
                return AccessLevel.DENIED;
                // End B25321
            }
        }
        return AccessLevel.GRANTED;

    }
}
