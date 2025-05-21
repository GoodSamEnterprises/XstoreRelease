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
 * BZ41379          022221    Requirement - Disabled Mixed Order Transactions in Xstore
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawCheckForMixedOrdersOp extends AbstractPromptOp {

    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction trans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        if (trans != null) {
            List<IRetailTransactionLineItem> lineItems = trans
                    .getRetailTransactionLineItems();
            ISaleReturnLineItem lineItem = null;
            if (CollectionUtils.isNotEmpty(lineItems)) {
                int size = lineItems.size();
                for (int i = 0; i < size; i++) {
                    if (lineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) lineItems.get(i);
                        if (!lineItem.getVoid()
                                && lineItem.getOrderModifier() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_ORDER_MIXED_NOT_ALLOWED");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.getOpChainRollBackRequest();
    }
}
