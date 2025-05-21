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

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawMembershipItemCondition extends AbstractRunCondition {

    @Inject
    private CawMembershipActivityHelper _cawMembershipActivityHelper;

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractRunCondition#shouldRunImpl()
     */
    @Override
    protected boolean shouldRunImpl() {

        Boolean isRun = Boolean.FALSE;
        IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
        
        isRun = _cawMembershipActivityHelper.isExistMembershipItem(item);

        return isRun;
    }
}
