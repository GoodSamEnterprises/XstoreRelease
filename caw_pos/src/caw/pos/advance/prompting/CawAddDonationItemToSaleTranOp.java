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
 * BZ39699          191120    [Task] Porting these fixes of xstore 6.0 patch 10.0/11.0 into Xstore 7.0 patch 1.0
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.register.AddItemToSaleTranOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawAddDonationItemToSaleTranOp extends AddItemToSaleTranOp {

    @Inject
    private CawMembershipActivityHelper _cawMembershipActivityHelper;

    @Override
    public boolean isOperationApplicable() {

        IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
        Boolean isRun = Boolean.FALSE;

        Boolean isMembershipItem = _cawMembershipActivityHelper
                .isExistMembershipItem(item);

        if (isMembershipItem && getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG) != null) {
            clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);
            isRun = Boolean.FALSE;
        } else if (!isMembershipItem) {
            isRun = Boolean.TRUE;
        }

        return isRun;
    }
}
