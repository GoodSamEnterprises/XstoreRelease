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
 * BZ24568          191217    [Xstore] Unit Price does not update in POS Sale screen after club member is added to a transaction
 *===================================================================
 */

package caw.pos.register;

import java.util.ArrayList;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawGSCUnVoidLineItemsOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        PriceContext itemPrice = null;
        ISaleReturnLineItem lineItem = null;

        ArrayList<IRetailTransactionLineItem> listVoidLineItems = getScopedValue(CawValueKeys.LIST_VOID_LINEITMS);
        if (listVoidLineItems == null || listVoidLineItems.isEmpty()) {
            setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, new ArrayList<IRetailTransactionLineItem>());
            return HELPER.completeResponse();
        }

        int size = listVoidLineItems.size();

        for (int i = 0; i < size; i++) {
            listVoidLineItems.get(i).setVoid(false);

            /* START BZ 24568 */
            if (listVoidLineItems.get(i) instanceof ISaleReturnLineItem) {
                lineItem = (ISaleReturnLineItem) listVoidLineItems.get(i);
                if (lineItem.getItemId() != null) {
                    itemPrice = PriceProvider
                            .getActualPrice(lineItem.getItemId());
                    if (itemPrice != null) {
                        lineItem.setPreDealAmount(itemPrice.getPrice());
                    }
                }
            }
            /* END BZ 24568 */
        }

        setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, new ArrayList<IRetailTransactionLineItem>());
        return HELPER.completeResponse();
    }
}
