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
 * BZ27000          030818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 *===================================================================
 */

package caw.pos.houseaccount;

import java.awt.Color;
import java.awt.Font;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.impl.ChargeAccountUserModel;

/**
 * The CawCustomerAccountNumberCellHandler class
 */
public class CawCustomerAccountNumberCellHandler extends DefaultCellDataHandler {

    /** Display house account number follow format.
     * @see dtv.pos.framework.ui.listview.DefaultCellDataHandler#buildCellColumn(dtv.pos.framework.ui.listview.config.ListViewColumnConfig, java.lang.Object, java.awt.Color, java.awt.Font)
     */
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {
        if (argArgModel instanceof ChargeAccountUserModel) {
            return buildCellColumn(((ChargeAccountUserModel) argArgModel)
                    .getCustAccountId(), null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
        }
        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }

}
