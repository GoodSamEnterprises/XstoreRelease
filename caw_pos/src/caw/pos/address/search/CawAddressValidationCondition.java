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
 * BZ26575          150618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 *===================================================================
 */

package caw.pos.address.search;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawAddressValidationCondition extends AbstractRunCondition {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected boolean shouldRunImpl() {

        if (_transactionScope != null) {
            Boolean isNotRun = _transactionScope.getValue(CawValueKeys.IS_NOT_RUN_ADDRESS_VALIDATION_OP);
            if (isNotRun != null && isNotRun.booleanValue()) {
                return false;
            }
        }
        return true;
    }

}
