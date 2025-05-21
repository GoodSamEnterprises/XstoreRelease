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
 * BZ33586          291019    [New Requirement] Remove customer warranty prompt
 *===================================================================
 */
package caw.pos.warranty.info;

import javax.inject.Inject;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyManager;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.IWarrantyLineItem;

public class CawAcceptWarrantyCustomerOp extends Operation {

    @Inject
    private WarrantyManager _warrantyMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent var1) {

        IWarrantyLineItem warrantyLineItem = this.getScopedValue(ValueKeys.CURRENT_WARRANTY_LINE_ITEM);
        IWarrantyItem warrantyItem = _warrantyMgr.getWarrantyItem(warrantyLineItem);
        PriceContext itemPrice = warrantyItem != null ? PriceProvider.getActualPrice(warrantyItem.getItemId()) : null;
        if (itemPrice != null) {
            setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, itemPrice.getPrice());
        }
        return HELPER.completeResponse();
    }
}
