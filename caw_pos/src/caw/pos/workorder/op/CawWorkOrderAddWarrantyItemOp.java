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
 * BZ27248          210818    Warranty Items from S&I are not associated with the items covered
 * BZ29879          270319    [Prod] Work Order Issues- missing warranty items
 * BZ29884          270319    [Prod] Work Order Issues- warranty item price was changed after import into xstore
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderItem;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyManager;
import dtv.util.CompositeObject.TwoPiece;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWorkOrderAddWarrantyItemOp extends Operation {

    @Inject
    private WarrantyManager _warrantyMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        TwoPiece<IWarrantyItem, IWarrantyItem> twoPiece = null;
        @SuppressWarnings("unchecked")
        Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warranties = _transactionScope
                .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST);
        if (warranties != null && warranties.size() > 0) {
            /* BEGIN BZ29879*/
            ISaleReturnLineItem newLineItem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
            if (newLineItem != null) {
                String itemId = newLineItem.getItemId();

                for (Map.Entry<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> entry : warranties.entrySet()) {
                    if (entry.getValue().getItemId().equalsIgnoreCase(itemId)) {
                        twoPiece = entry.getKey();
                        break;
                    }
                }

                if (twoPiece != null) {
                    IWarrantyItem selectedPlan = twoPiece.a();
                    IWarrantyItem selectedItem = twoPiece.b();

                    /* BEGIN BZ29884 */
                    clearScopedValue(ValueKeys.CURRENT_WARRANTY);//BZ29879
                    /**
                     * Update price of Warranty Item
                     */
                    if (selectedPlan != null) {
                        List<CawWorkOrderItem> woWarrantyItems = _transactionScope
                                .getValue(CawValueKeys.WO_WARRANTY_ITEMS);
                        if (woWarrantyItems != null && woWarrantyItems.size() > 0) {
                            CawWorkOrderItem cawWorkOrderItem = null;
                            for (CawWorkOrderItem workOrderResult : woWarrantyItems) {
                                if (selectedPlan.getItemId() != null
                                        && selectedPlan.getItemId().equalsIgnoreCase(workOrderResult.getItemId())) {
                                    cawWorkOrderItem = workOrderResult;
                                    break;
                                }
                            }

                            // Set price for Warranty Item
                            if (cawWorkOrderItem != null && cawWorkOrderItem.getUnitSellingPrice() != null) {
                                setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, cawWorkOrderItem.getUnitSellingPrice());
                            }

                            this.setScopedValue(ValueKeys.SELECTED_WARRANTY_PLAN, selectedPlan);
                            this._warrantyMgr.setWarrantyItem(selectedItem);
                        }
                    }
                    /* END BZ29884 */
                }
            }
            /* END BZ29879*/
        }

        return HELPER.completeResponse();
    }

}
