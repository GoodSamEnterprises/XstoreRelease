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
 * BZ30922          210619    [New Requirement] Price Check and Inventory Lookup
 *===================================================================
 */

package caw.pos.inventory.lookup;

import dtv.pos.inventory.lookup.ItemSearchOp;
import dtv.xst.dao.itm.IItem;

/**
 *
 */

public class CawItemSearchOp extends ItemSearchOp {

    /* Lookup inventories for selected item
     * @see dtv.pos.inventory.lookup.ItemSearchOp#setSelectedResult(dtv.xst.dao.itm.IItem)
     */
    @Override
    protected void setSelectedResult(IItem argDataModel) {
        CawInventoryLookupHelper.getInstance()
                .loadInventories(argDataModel.getItemId(), _stationState.getRetailLocationId());
        super.setSelectedResult(argDataModel);
    }
}
