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

import java.util.Collection;

import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.PromptOrigReceiptInformationOp;
import dtv.util.IKeyedValue;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 *
 */
public class CawPromptOrigReceiptInformationOp
        extends PromptOrigReceiptInformationOp {

    /* (non-Javadoc)
     * override this method to set information of the selected item into OriginalTransactionInfo model.
     * @see dtv.pos.register.returns.PromptOrigReceiptInformationOp#handleSearch(java.util.Collection)
     */
    @Override
    protected IOpResponse handleSearch(
            Collection<IKeyedValue<String, ?>> argFields) {

        CustomerTransHistoryResult itemSelected = _transactionScope
                .getValue(CawValueKeys.ITEM_SELECTED) != null
                        ? _transactionScope.getValue(CawValueKeys.ITEM_SELECTED)
                        : null;
        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null
                && itemSelected != null) {

            PosTransactionId transId = new PosTransactionId();
            transId.setTransactionSequence(itemSelected.getTransSeq());
            transId.setBusinessDate(itemSelected.getTransactionDate());
            transId.setWorkstationId(Long
                    .parseLong(itemSelected.getWorkstationId()));
            transId.setRetailLocationId(Long
                    .parseLong(itemSelected.getRetailLocationId()));
            super.setOriginalTransactionInfo(transId);
            _transactionScope
                    .setValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION, false);
            return this.HELPER.completeResponse();
        }
        return super.handleSearch(argFields);
    }

    /* (non-Javadoc)
     * override this method to skip "enter return information" prompt.
     * @see dtv.pos.register.returns.PromptOrigReceiptInformationOp#handleBeforeDataAction(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argAction) {

        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) == true) {
            return this.handleFormResponse(argAction);
        }
        _transactionScope.clearValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION);
        return super.handleBeforeDataAction(argAction);
    }
}
