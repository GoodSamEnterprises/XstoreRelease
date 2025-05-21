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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23951              171017    Customer Search Screen Needs to Include Membership#, Expiration Date
 *== ================================================================
 */

package caw.pos.customer;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter4j.JSONObject;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.IUIResourceManager;
import dtv.ui.UIResourceManager;
import dtv.ui.layout.ViewCellData.CellColumn;

public class CawCustMemshipIdCellHandler extends DefaultCellDataHandler {

    private static final Logger _logger         = LogManager
            .getLogger(CawEditCustomerOp.class);

    private static final String JSON_IDENTIFIER = "identifier";

    private static Font         defaultFont_    = UIResourceManager
            .getInstance().getFont(IUIResourceManager.FONT_LIST_SMALL);

    /** {@inheritDoc} */
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig,
            Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {

        if (argModel instanceof CawCustomerQueryResult) {
            CawCustomerQueryResult result = (CawCustomerQueryResult) argModel;
            StringBuilder strMembership = new StringBuilder();
            try {
                List<JSONObject> lstMemberships = result.getMembershipLst();
                if (lstMemberships != null && lstMemberships.size() > 0) {
                    for (JSONObject jsonMembership : lstMemberships) {
                        if (jsonMembership.getString(JSON_IDENTIFIER) != null) {
                            strMembership
                                    .append(jsonMembership
                                            .getString(JSON_IDENTIFIER))
                                    .append("\n");
                        }
                    }
                }
            } catch (Exception ex) {
                _logger.error("Can not get JSON object: " + ex.getMessage());
            }

            // String formattedAddress = addressFormatter.format(address, VIEW);
            return buildCellColumn(strMembership
                    .toString(), null, argDefaultRowTextColor, defaultFont_
                            .deriveFont(Font.PLAIN), argColConfig);
        }

        return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
    }
}
