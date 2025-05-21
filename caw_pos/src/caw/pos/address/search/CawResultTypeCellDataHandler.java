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
 * BZ26742          110718    [New Requirement] Update QAS results include the entered or existing customer address as an option
 *===================================================================
 */
package caw.pos.address.search;

import java.awt.Color;
import java.awt.Font;

import oracle.retail.xstore.avs.IAddressLineAndAddressId;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData;

/**
 * Identify the entered address when Moniker or AddressId is null.
 *
 */
public class CawResultTypeCellDataHandler extends DefaultCellDataHandler {

    private static final String PREFIX_ENTERED          = "Entered";

    private static final String PREFIX_SUGGESTED        = "Suggested";

    private static final String PREFIX_INVALID          = "Invalid";

    public static final String  ENTERED_ADDRESS_MONIKER = "ENTERED";

    @Override
    public ViewCellData.CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel,
            Color argDefaultRowTextColor, Font argDefaultRowFont) {

        String cellText = PREFIX_SUGGESTED;
        if (argModel instanceof IAddressLineAndAddressId) {
            IAddressLineAndAddressId lineItem = (IAddressLineAndAddressId) argModel;
            if (lineItem.getAddressId() == null || lineItem.getAddressId().length() == 0) {
                //Identify the invalid address when Moniker or AddressId is null
                cellText = PREFIX_INVALID;
            } else if (CawResultTypeCellDataHandler.ENTERED_ADDRESS_MONIKER
                    .compareToIgnoreCase(lineItem.getAddressId()) == 0) {
                //Identify the entered address when Moniker or AddressId is Entered
                cellText = PREFIX_ENTERED;
            }
        }
        //if (cellText == null || cellText.length() == 0) {
        //    return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        //}
        return buildCellColumn(cellText, null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
    }
}
