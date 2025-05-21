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
 * BZ54208          261222    [BTM-280] Production Issue | Applying funds onto gift card without charging
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

public class CawBalanceInquiryDisabledReloadRule extends AbstractVisibilityRule{
    
    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {
            if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.CAW_IS_BACK_OFFICE_STATE))) {
                return AccessLevel.DENIED;
            }
        }
        
        return AccessLevel.GRANTED;
    }

}
