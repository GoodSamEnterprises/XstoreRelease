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
 * BZ38980          041120    [TASK] Prompt Engine - Add Item & Price
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import caw.pos.common.*;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawProcessRoundUpTransactionCondition extends AbstractRunCondition {

    @Inject
    protected TransactionScope _transactionScope;

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractRunCondition#shouldRunImpl()
     */
    @Override
    protected boolean shouldRunImpl() {

        Boolean isRun = Boolean.FALSE;

        if (!CawUtilFunction.allowEBSConnection()) {
            return false;
        }

        Boolean isResendCatalyst4 = _transactionScope
                .getValue(CawValueKeys.IS_RESENT_CATALYST_4);

        if (CawCatalystHelper
                .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
            if (CawCatalystHelper.getCatalystInputsResponse() != null
                    && isResendCatalyst4 != null
                    && isResendCatalyst4.booleanValue() && CawCatalystHelper
                            .isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_TOTAL)) {
                if (CawCatalystHelper.checkCatalystDirectiveType8()) {
                    isRun = Boolean.FALSE;
                } else {
                    isRun = Boolean.TRUE;
                }
            }
        }
        return isRun;
    }
}
