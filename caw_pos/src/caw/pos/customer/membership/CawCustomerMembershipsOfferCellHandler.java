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
 * BZ48564          120422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 *===================================================================
 */

package caw.pos.customer.membership;

import java.awt.Color;
import java.awt.Font;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.impl.AwardAccountCouponModel;
/**
 * BZ48564
 */
public class CawCustomerMembershipsOfferCellHandler
        extends DefaultCellDataHandler {
    private final String L_DESCRIPTION = "DESCRIPTION";
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {

        if (argArgModel instanceof AwardAccountCouponModel) {
            AwardAccountCouponModel awardmodel = (AwardAccountCouponModel) argArgModel;
            String propertyName = awardmodel.getStringProperty(L_DESCRIPTION);
            if (propertyName != null&&awardmodel.getStringProperty(L_DESCRIPTION)!=null) {
                String result = awardmodel.getStringProperty(L_DESCRIPTION);
                return buildCellColumn(result, null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
            }
        }
        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }
}
