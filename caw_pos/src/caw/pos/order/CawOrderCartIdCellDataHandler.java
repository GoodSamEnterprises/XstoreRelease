/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Urban Barn by BTM Global Consulting
 * LLC and are the property of Urban Barn.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 *===================================================================
 */

package caw.pos.order;

import java.awt.Color;
import java.awt.Font;

import caw.pos.common.CawConstants;

import dtv.i18n.*;
import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawOrderCartIdCellDataHandler extends DefaultCellDataHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig,
            Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {

        String cartId = null;
        if (argModel instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argModel;
            cartId = lineItem.getStringProperty(CawConstants.WONDERSIGN_CART_ID);
        }
        if (cartId == null) {
            return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        } else {
            FormattableFactory ff = FormattableFactory.getInstance();
            IFormattable label = ff.getTranslatable("_cawOrderCartId", new IFormattable[] { ff.getLiteral(cartId) });
            String cellText = label.toString(OutputContextType.VIEW);
            return this.buildCellColumn(cellText, null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
        }
    }
}
