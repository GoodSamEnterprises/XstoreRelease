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
 * BZ25115          020518    New Requirement - Add a Member Price Override Function to the POS Sale screen
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
public class CawMemberPriceOverrideVoidPriceOp extends Operation {

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        ArrayList<IRetailTransactionLineItem> listVoidLineItems = getScopedValue(CawValueKeys.LIST_VOID_LINEITMS);
        List<IRetailTransactionLineItem> listLineItems;
        int size = 0;

        if (listVoidLineItems == null) {
            listVoidLineItems = new ArrayList<>();
        }

        if (retailTrans != null
                && retailTrans.getRetailTransactionLineItems().size() > 0) {
            listLineItems = retailTrans.getRetailTransactionLineItems();
            size = listLineItems.size();

            for (int i = 0; i < size; i++) {
                if (listLineItems.get(i) instanceof ISaleReturnLineItem
                        && !listLineItems.get(i).getVoid()) {
                    listLineItems.get(i).setVoid(true);
                    listVoidLineItems.add(listLineItems.get(i));
                }
            }
        }

        setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, listVoidLineItems);
        return HELPER.completeResponse();
    }

}
