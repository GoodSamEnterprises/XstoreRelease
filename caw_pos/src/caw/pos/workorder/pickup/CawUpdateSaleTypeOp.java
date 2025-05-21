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
 * BZ27378          050918    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 *===================================================================
 */

package caw.pos.workorder.pickup;

import java.util.List;

import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawUpdateSaleTypeOp extends Operation {

    /* When perform a work order complete, 
     * all line item will be changed from work order type to sale type for modifying.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction trans = _transactionScope.getTransaction();

        if (trans != null) {
            List<IRetailTransactionLineItem> listItems = trans
                    .getSaleLineItems();
            ISaleReturnLineItem saleLine = null;

            if (listItems != null && listItems.size() > 0) {
                for (IRetailTransactionLineItem lineItem : listItems) {
                    if (lineItem instanceof ISaleReturnLineItem
                            && !lineItem.getVoid()) {
                        saleLine = (ISaleReturnLineItem) lineItem;
                        //Check line item, if work order type then changing it to sale type
                        if (saleLine.getSaleReturnLineItemTypeCode()
                                .equalsIgnoreCase(CawWorkOrderConstants.WORK_ORDER)) {
                            saleLine.setSaleReturnLineItemTypeCode(SaleItemType.SALE
                                    .getName());
                        }
                    }
                }
            }
        }
        return HELPER.completeResponse();
    }

}
