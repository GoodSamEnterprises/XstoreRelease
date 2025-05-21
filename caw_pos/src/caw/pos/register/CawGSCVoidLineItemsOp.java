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
 * BZ24219          011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard
 *===================================================================
 */

package caw.pos.register;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawMembershipActivityHelper;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawGSCVoidLineItemsOp extends Operation {

    @Inject
    private CawMembershipActivityHelper _membershipHelper;

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
                        && !isGoodSamItem(((ISaleReturnLineItem) listLineItems
                                .get(i)).getItemId())
                        && !listLineItems.get(i).getVoid()) {
                    listLineItems.get(i).setVoid(true);
                    listVoidLineItems.add(listLineItems.get(i));
                }
            }
        }

        setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, listVoidLineItems);
        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);

        if (retailTrans != null
                && retailTrans.getRetailTransactionLineItems().size() > 0) {
            List<IRetailTransactionLineItem> listLineItems = retailTrans
                    .getRetailTransactionLineItems();
            int size = listLineItems.size();

            for (int i = 0; i < size; i++) {
                if (listLineItems.get(i) instanceof ISaleReturnLineItem
                        && isGoodSamItem(((ISaleReturnLineItem) listLineItems
                                .get(i)).getItemId())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isGoodSamItem(String itemId) {

        if (_membershipHelper.getMembershipActivity(itemId) == null) {
            return false;
        } else {
            return true;
        }
    }
}
