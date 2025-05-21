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
 * BZ25207          240118    Return Tender Options displays incorrectly tender types when refunding Web Order items.
 * BZ25323          050218    There are no action responses when pressing Return Item/F3 into Purchase Used Firearm Return screen.
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
public class CawDisplayReturnButton extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {
            Boolean isUfa = _transactionScope
                    .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);
            Boolean isSale = _transactionScope
                    .getValue(CawValueKeys.IS_SALE_SCREEN);
            if (isUfa != null && isUfa.booleanValue()) {
                // Begin BZ25323
                return AccessLevel.DENIED;
                // End BZ25323
            } else if (isSale != null && isSale.booleanValue()) {
                return AccessLevel.GRANTED;
            }
        }
        return AccessLevel.DENIED;
    }
}
