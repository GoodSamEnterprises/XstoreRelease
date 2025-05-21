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
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 *===================================================================
 */

package caw.pos.shared.listview;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import caw.pos.common.CawConstants;
import oracle.retail.xstore.itm.custitem.CustItemResult.ItemType;

import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.pos.shared.listview.IconLineItemCellHandler;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.ICustomerItemAccountDetailModel;
import dtv.xst.dao.cat.impl.CustomerItemAccountDetailModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrderLineModel;

/**
 *
 */
public class CawIconLineItemCellHandler extends IconLineItemCellHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig,
            Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {

        ImageIcon icon = null;
        ISaleReturnLineItem lineItem = null;
        if (argModel instanceof ICustomerItemAccountDetailModel) {
            lineItem = (ISaleReturnLineItem) ((CustomerItemAccountDetailModel) argModel).getRetailLineItem();
        } else if (argModel instanceof ISaleReturnLineItem) {
            lineItem = (ISaleReturnLineItem) argModel;
        } else if (argModel instanceof IOrderLineModel) {
            lineItem = ((IOrderLineModel) argModel).getShadowedSaleItem();
        }

        if (lineItem == null) {
            return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        } else {
            if (lineItem.getAttachedItemFlag()) {
                icon = this.iconMap_.get("attachedItem");
            }

            if (lineItem.getStringProperty(ItemType.WISH_LIST_ITEM.toString()) != null) {
                icon = this.iconMap_.get("wishListItem");
            }

            if (lineItem.getStringProperty(ItemType.DIGITAL_CART_ITEM.toString()) != null
                    || lineItem.getStringProperty(CawConstants.WONDERSIGN_CART_ID) != null) {
                icon = this.iconMap_.get("digitalCartItem");
            }

            return this.buildCellColumn(null, icon, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
        }
    }
}
