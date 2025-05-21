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
 * BZ23052          120917    Implement Advanced Prompting
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import caw.pos.common.CawEBSConstant;
import caw.pos.common.CawValueKeys;
import twitter4j.JSONArray;

import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawProcessDirectiveOp extends Operation {

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    @Inject
    private TransactionScope          _transaction;

    private JSONArray                 inputFileds                = null;

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        inputFileds = CawCatalystHelper.getCatalystDirectiveResponse();
        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
        if (inputFileds != null) {
            if (inputFileds.length() > 0) {
                isRun = Boolean.TRUE;
            } else if (inputFileds.length() > 1) {
                isRun = Boolean.TRUE;
            }
        }
        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        if (inputFileds != null && inputFileds.length() > 0) {
            IPosTransaction iPosTransaction = _transaction.getTransaction();
            if (iPosTransaction != null) {
                String value = "{" + "\""
                        + CawEBSConstant.CATALYST_DIRECTIVES_TYPE + "\"" + ":"
                        + inputFileds.toString() + "}";

                _cawAdvancePromptingHelper
                        .saveAdvancePromptingInfo(iPosTransaction, CawEBSConstant.CATALYST_DIRECTIVES_TYPE, value, CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
            }
        }
        return HELPER.completeResponse();
    }

}
