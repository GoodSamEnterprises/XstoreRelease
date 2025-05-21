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
 * BZ25992          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.ArrayList;
import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawMemberPriceOverrideVoidLinesOp extends Operation {

    private List<String> voidItems = new ArrayList<String>();

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);

        if (retailTrans != null
                && retailTrans.getRetailTransactionLineItems() != null
                && retailTrans.getRetailTransactionLineItems().size() > 0) {
            List<IRetailTransactionLineItem> listLineItems = retailTrans
                    .getRetailTransactionLineItems();

            ISaleReturnLineItem lineItem = null;
            for (int i = 0; i < listLineItems.size(); i++) {
                if (listLineItems.get(i) instanceof ISaleReturnLineItem) {
                    lineItem = (ISaleReturnLineItem) listLineItems.get(i);
                    if (lineItem.getVoid()) {
                        if (lineItem.getItemId() != null) {
                            voidItems.add(lineItem.getItemId());
                        }
                    }
                }
            }
        }

        if (voidItems != null && voidItems.size() > 0) {
            _transactionScope
                    .setValue(CawValueKeys.MEMBER_PRICE_OVERRIDE_VOID_LINES, voidItems);
        }

        return HELPER.completeResponse();
    }

}
