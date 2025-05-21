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
 * BZ23052          011017    Implement Advanced Prompting
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 *===================================================================
 */

package caw.pos.advance.prompting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawEBSConstant;
import twitter4j.*;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawProcessDirectiveVoidTransactionOp extends AbstractPromptOp {

    private JSONArray           directiveFileds = new JSONArray();

    private static final Logger _logger         = LogManager
            .getLogger(CawProcessDirectiveVoidTransactionOp.class);

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                && CawCatalystHelper.getCatalystDirectiveResponse()
                        .length() > 0) {
            directiveFileds = CawCatalystHelper.getCatalystDirectiveResponse();
            try {
                JSONObject directive = null;
                int length = directiveFileds.length();
                for (int i = 0; i < length; i++) {
                    if (CawCatalystHelper.getCatalystDirectiveResponse()
                            .getJSONObject(i) != null) {
                        directive = CawCatalystHelper
                                .getCatalystDirectiveResponse()
                                .getJSONObject(i);
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == CawDirectiveType.VOID_TRANSACTION
                                                .getType()) {
                            isRun = Boolean.TRUE;
                        }
                    }
                }
            } catch (JSONException ex) {
                _logger.error("Can not get directive type 'Void Transaction'."
                        + ex.getMessage());
            }
        }

        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_CATALYST_VOID_TRANSACTION");
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.getStartChainResponse(OpChainKey
                .valueOf("ROLLBACK_TRANS_FINISH"));
    }

}
