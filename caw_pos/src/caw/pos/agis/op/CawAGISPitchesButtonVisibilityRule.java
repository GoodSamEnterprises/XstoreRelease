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
 * BZ61159          200324    [New Requirement] - Xstore AGIS Replacement 
 *===================================================================
 */

package caw.pos.agis.op;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawAGISPitchesButtonVisibilityRule extends AbstractVisibilityRule {
    @Inject
    private TransactionScope     _transactionScope;
    
    private CawAGISPitchesHelper _agisPitchesHelper = CawAGISPitchesHelper.getInstance();

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        return !_agisPitchesHelper.isLoadDataPitchesForm(_transactionScope) ? AccessLevel.GRANTED : AccessLevel.DENIED;
    }

}
