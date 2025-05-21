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
 * Req/Bug ID#          ddMMyy    Description
 * BZ24356              031117    [Advance Prompting] Xstore needs to return to Membership Info prompt after a failed membership validation response
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawProcessRemoveItemFailedOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawProcessRemoveItemFailedOp.class);

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        if (getScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED) != null
                && getScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED)
                        .size() > 0) {
            isRun = Boolean.TRUE;
        }
        return isRun;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        Set<String> itmValidateFailedSet = getScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED);
        try {
            for (String codeItem : itmValidateFailedSet) {
                CawCatalystHelper.setCatalystDirectiveResponse(CawCatalystHelper
                        .removeItemOfJsonArray(CawCatalystHelper
                                .getCatalystDirectiveResponse(), codeItem));
            }
        } catch (Exception ex) {
            _logger.error("Cannot remove Item Validate Failed: "
                    + ex.getMessage());
        }

        return HELPER.completeResponse();
    }
}
