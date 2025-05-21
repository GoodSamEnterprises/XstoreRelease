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
 * BZ65612          260724    AGMOD Update to Membership SKU New Requirements
 *===================================================================
 */

package caw.pos.shared.listview;

import java.awt.Color;
import java.awt.Font;

import caw.pos.common.CawConstants;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData;
import dtv.xst.dao.cat.ICustomerItemAccountDetailModel;
import dtv.xst.dao.cat.impl.CustomerItemAccountDetailModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrderLineModel;

public class CawItemIdLineItemCellHandler extends DefaultCellDataHandler {

    @Override
    public ViewCellData.CellColumn buildCellColumn(
            ListViewColumnConfig argColConfig, Object argModel,
            Color argDefaultRowTextColor, Font argDefaultRowFont) {

        String itemId = null;
        ISaleReturnLineItem lineItem = null;
        if (argModel instanceof ICustomerItemAccountDetailModel) {
            lineItem = (ISaleReturnLineItem) ((CustomerItemAccountDetailModel) argModel)
                    .getRetailLineItem();
        } else if (argModel instanceof ISaleReturnLineItem) {
            lineItem = (ISaleReturnLineItem) argModel;
        } else if (argModel instanceof IOrderLineModel) {
            lineItem = ((IOrderLineModel) argModel).getShadowedSaleItem();
        }
        if (lineItem == null) {
            return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        } else {
            String itemIdListFromPitch = lineItem
                    .getStringProperty(CawConstants.CAW_PITCHES_ITEM_LIST);
            if (itemIdListFromPitch == null
                    || !itemIdListFromPitch.contains(lineItem.getItemId())) {
                itemId = lineItem.getItemId();
            }
            return this
                    .buildCellColumn(itemId, null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
        }
    }

}
