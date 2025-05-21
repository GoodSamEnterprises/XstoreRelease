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
 * BZ44528          180821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ46770          131021    [Internal] Electric World Phase 1 - Kiosk Order button should be disabled when doing Work Order Complete transaction prior.
 *===================================================================
 */

package caw.pos.wondersign.visibilityrules;

import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.ejournal.CawTransactionSearchHelper;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawWonderSignEnableCheck extends AbstractVisibilityRule {
    
    @Inject
    private TransactionScope _transactionScope; //BZ46770
    @Inject
    private CawTransactionSearchHelper   _cawTransactionSearchHelper;
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        AccessLevel accessLevel = AccessLevel.DENIED;
        String enableWondersign = _cawTransactionSearchHelper.getCodeValue(CawConstants.CAW_KIOSK_ORDER_ENABLE);
        if (CawConstants.TRUE_STRING.equalsIgnoreCase(enableWondersign)) {
            accessLevel = AccessLevel.GRANTED;
            /* BEGIN BZ46770 */
            if (_transactionScope != null) {
                Boolean isWorkOrderTrans = _transactionScope.getValue(CawValueKeys.IS_WORK_ORDER_TRANS);
                if (BooleanUtils.isTrue(isWorkOrderTrans)
                        && CawWorkOrderOptionsOp.isCompleteAction()) {
                    accessLevel =  AccessLevel.DENIED;
                } 
            }
            /* END BZ46770 */
        }
        
        return accessLevel;
    }

}
