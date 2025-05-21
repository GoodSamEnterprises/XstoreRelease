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

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.ValueKeys;

public class CawAGISPitchesCashAndCarryConditions extends AbstractRunCondition{

    @Inject
    private TransactionScope _transactionScope;
    
    @Override
    protected boolean shouldRunImpl() {
        return _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER) == null;
    }

}
