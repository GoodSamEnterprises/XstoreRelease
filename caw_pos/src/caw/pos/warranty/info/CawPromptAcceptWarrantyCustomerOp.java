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
 * BZ32142          250719    [Xstore] Warranty items not pricing correctly when customer added
 *===================================================================
 */

package caw.pos.warranty.info;

import javax.inject.Inject;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyManager;
import dtv.pos.warranty.info.PromptAcceptWarrantyCustomerOp;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.IWarrantyLineItem;

public class CawPromptAcceptWarrantyCustomerOp extends PromptAcceptWarrantyCustomerOp {

    @Inject
    private WarrantyManager _warrantyMgr;

    /*
     * Override this method to update price of warranty item before add to the current transaction
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IWarrantyLineItem warrantyLineItem = this.getScopedValue(ValueKeys.CURRENT_WARRANTY_LINE_ITEM);
        IWarrantyItem warrantyItem = _warrantyMgr.getWarrantyItem(warrantyLineItem);
        PriceContext itemPrice = warrantyItem != null ? PriceProvider.getActualPrice(warrantyItem.getItemId()) : null;
        if (itemPrice != null) {
            setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, itemPrice.getPrice());
        }
        return super.handleDataAction(argAction);
    }
}