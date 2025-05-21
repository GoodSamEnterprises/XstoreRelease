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
 * BZ23676          101017    [Tender] The New Good Sam VISA tender option button should only be available on the transaction that the application was approved for.
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawTenderNewGSVisaVisibilityRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope.getValue(CawValueKeys.SAY_YES_GSV_TENDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.SAY_YES_GSV_TENDER)) {
            return AccessLevel.GRANTED;
        }
        return AccessLevel.DENIED;
    }
}
