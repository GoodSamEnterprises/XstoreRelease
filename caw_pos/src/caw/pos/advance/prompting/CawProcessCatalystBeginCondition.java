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
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawProcessCatalystBeginCondition extends AbstractRunCondition {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected boolean shouldRunImpl() {

        IPosTransaction iPosTransaction = _transactionScope.getTransaction(); // Only send catalyst 0 when do not have transaction

        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }

        if (CawCatalystHelper.isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
            if (iPosTransaction == null
                    && CawCatalystHelper.isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_BEGIN)) {
                return true;
            }
        }
        return false;
    }
}