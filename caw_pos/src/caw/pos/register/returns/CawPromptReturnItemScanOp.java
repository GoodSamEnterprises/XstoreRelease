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
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.PromptReturnItemScanOp;
import dtv.pos.spring.ValueKeys;
import dtv.util.StringUtils;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 *
 */
public class CawPromptReturnItemScanOp extends PromptReturnItemScanOp {

    /* (non-Javadoc)
     * 
     * override this method to skip prompt enter item when "return item" button on the purchase history tab is clicked. 
     * 
     * @see dtv.pos.register.AbstractItemScanOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        String itemselectedID = _transactionScope
                .getValue(CawValueKeys.ITEM_SELECTED) != null
                        ? _transactionScope.getValue(CawValueKeys.ITEM_SELECTED)
                                .getItemId()
                        : null;
        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null
                && !StringUtils.isEmpty(itemselectedID)) {
            this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemselectedID);
            _transactionScope
                    .clearValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION);
            return super.handlePromptResponse(argEvent);
        } else if (_transactionScope
                .getValue(CawValueKeys.IS_RETURN_CONTINUTE) != null) {
            this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, "500");
            _transactionScope.clearValue(CawValueKeys.IS_RETURN_CONTINUTE);
            return super.handlePromptResponse(argEvent);
        }
        return super.handleOpExec(argEvent);
    }
}
