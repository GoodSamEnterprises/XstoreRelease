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
 * BZ23458          270917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ25068          220118    New Requirement to Process Web Order Returns
 *===================================================================
 */

package caw.pos.register.returns.customerhistory;

import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.customerhistory.PromptReturnTransByHistoryOp;
import dtv.pos.register.returns.customerhistory.ReturnableTransSearchResult;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;

/**
 * Skip Prompt return transaction by history.
 */
public class CawSkipPromptReturnTransByHistoryOp
        extends PromptReturnTransByHistoryOp {

    //BZ23955
    private static final OpChainKey PRE_RETURN_VERIFICATION = OpChainKey
            .valueOf("PRE_RETURN_VERIFICATION");

    @Override
    public boolean isOperationApplicable() {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);

        if ((isPurchaseUsedFirearm != null) && (isPurchaseUsedFirearm)) {
            return false;
            // Begin BZ25068
        } else if (_transactionScope
                .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return false;
            // End BZ25068
        }

        return super.isOperationApplicable();
    }

    /**
     * Prepares the <code>ReturnManager</code> for a verified return on the specified transaction and responds
     * with a run chain response for the verified return op chain.
     *
     * @param argTransResult transaction result for transaction to be returned
     * @return run chain op response for the verified return op chain
     */
    @Override
    protected IOpResponse handleSelectedTransaction(
            ReturnableTransSearchResult argTransResult) {

        //BEGIN BZ23955
        if (argTransResult != null
                && argTransResult.getObjectId() instanceof PosTransactionId) {
            PosTransactionId id = (PosTransactionId) argTransResult
                    .getObjectId();
            IRetailTransaction rtlTrans = getRetailTransaction(id);
            IAccountReceivableTenderLineItem arLine = null;

            if (rtlTrans != null) {
                List<IRetailTransactionLineItem> lineItems = rtlTrans
                        .getRetailTransactionLineItems();
                if (lineItems != null && lineItems.size() > 0) {
                    for (IRetailTransactionLineItem lineItem : lineItems) {
                        if (lineItem instanceof IAccountReceivableTenderLineItem) {
                            if (((IAccountReceivableTenderLineItem) lineItem)
                                    .getAccountUserName() != null) {
                                arLine = (IAccountReceivableTenderLineItem) lineItem;
                                _transactionScope
                                        .setValue(CawValueKeys.ACC_USER_NAME, arLine
                                                .getAccountUserName());
                            }
                        }
                    }
                }
                //END BZ23955
                initReturnManagerForVerfiedReturn(rtlTrans);
                return HELPER.getStartChainResponse(PRE_RETURN_VERIFICATION);
            }
        }

        return HELPER.completeResponse();
    }

}
