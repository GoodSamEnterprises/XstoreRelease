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
 * PAYMENT          070917    Payment-Item Display
 * BZ23915          091017    Xstore prompts for "made Offer" even though customer has been approved
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.util.StringUtils;

/**
 * Set rule for Blind Return and Purchase Used Firearm return.
 */
public class CawGSVisaNotApproachvisibilityRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (StringUtils
                .isEmpty(_transactionScope
                        .getValue(CawValueKeys.ACCOUNT_NUMBER))
                || StringUtils.isEmpty(_transactionScope
                        .getValue(CawValueKeys.EXP_DATE))) {
            return AccessLevel.GRANTED;
        }
        return AccessLevel.DENIED;
    }

}
