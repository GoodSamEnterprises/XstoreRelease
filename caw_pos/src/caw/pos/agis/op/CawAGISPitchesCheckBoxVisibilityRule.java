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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement 
 *===================================================================
 */

package caw.pos.agis.op;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawAGISPitchesCheckBoxVisibilityRule extends AbstractVisibilityRule{

    @Inject
    private TransactionScope _transactionScope;

    public CawAGISPitchesCheckBoxVisibilityRule() {
        super();
    }

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel accessLevel = AccessLevel.DENIED;
        int cawPitchesLength = 0;
        if (_transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null) {
            cawPitchesLength = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) ;
        }
        
        int count = 0;
        if (_transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_COUNT) != null) {
            count = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_COUNT);
        }

        if (cawPitchesLength > count) {
            accessLevel = AccessLevel.GRANTED;
            count++;
        }
        _transactionScope.setValue(CawValueKeys.CAW_AGIS_PICHES_COUNT, count);
        return accessLevel;
    }

    
}
