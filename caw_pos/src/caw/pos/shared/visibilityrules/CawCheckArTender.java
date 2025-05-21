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
 * BZ23263          250917    Implement House Account
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *This class is used to check customer has AR account and blance account >0 or not
 * if these condition is matched, AR Tender is enable 
 */
public class CawCheckArTender extends AbstractVisibilityRule {

    @Inject
    private TransactionScope _transactionScope;
    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if ((_transactionScope
                .getValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT) != null)
                && _transactionScope
                        .getValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT) == true) {
            if ((_transactionScope
                    .getValue(CawValueKeys.AR_ACCOUNT_BALANCE) != null)
                    && _transactionScope
                            .getValue(CawValueKeys.AR_ACCOUNT_BALANCE)
                            .compareTo(BigDecimal.ZERO) > 0) {
                return AccessLevel.GRANTED;
            } else {
                return AccessLevel.DENIED;
            }
        } else {
            return AccessLevel.DENIED;
        }
    }

}
