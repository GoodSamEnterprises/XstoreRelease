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
 * BZ25068          220118    New Requirement to Process Web Order Returns
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.shared.visibilityrules.TenderOnReturnRule;

/**
 *
 */
public class CawTenderOnReturnRule extends TenderOnReturnRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    public IAccessLevel checkVisibility() throws Exception {

        // Begin BZ25068
        if (_transactionScope != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return AccessLevel.GRANTED;
            // End BZ25068
        } else {
            return super.checkVisibility();
        }
    }

}
