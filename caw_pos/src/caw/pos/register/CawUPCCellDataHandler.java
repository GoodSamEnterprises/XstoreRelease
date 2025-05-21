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
 * BZ26270          290618    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ65612          260724    AGMOD Update to Membership SKU New Requirements
 *===================================================================
 */
package caw.pos.register;

import java.awt.Color;
import java.awt.Font;

import caw.pos.common.CawConfigurationMgr;
import caw.pos.common.CawConstants;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Display full UPC text on Sale screen.
 *
 */
public class CawUPCCellDataHandler extends DefaultCellDataHandler {

    @Override
    public ViewCellData.CellColumn buildCellColumn(
            ListViewColumnConfig argColConfig, Object argModel,
            Color argDefaultRowTextColor, Font argDefaultRowFont) {

        boolean upcConfigured = CawConfigurationMgr.displayUpcLineOnReceipt();
        String displayValue = null;

        if (upcConfigured) {
            if (argModel instanceof ISaleReturnLineItem) {
                ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argModel;
                // BEGIN BZ65612
                String itemIdListFromPitch = lineItem.getStringProperty(CawConstants.CAW_PITCHES_ITEM_LIST);
                if (itemIdListFromPitch == null || !itemIdListFromPitch.contains(lineItem.getItemId())) {
                    displayValue = CawUPCHelper.getInstance().getUpcText(lineItem);
                }
                // END BZ65612
            }
        }

        if (displayValue == null || displayValue.length() == 0) {
            return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        }

        return super.buildCellColumn(displayValue, null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
    }
}
