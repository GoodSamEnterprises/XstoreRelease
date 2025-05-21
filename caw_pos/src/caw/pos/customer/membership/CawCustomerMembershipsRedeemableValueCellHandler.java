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
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 * BZ53459              101122    [UAT] Accounts tab display multiple GSAM records with same points balance and redeemable points
 *===================================================================
 */

package caw.pos.customer.membership;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.NumberFormat;

import caw.pos.common.CawConstants;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.impl.CustomerLoyaltyCardModel;

/**
 *
 */
public class CawCustomerMembershipsRedeemableValueCellHandler extends DefaultCellDataHandler{
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {

        if (argArgModel instanceof CustomerLoyaltyCardModel) {

            CustomerLoyaltyCardModel model = (CustomerLoyaltyCardModel) argArgModel;
            
            /* BEGIN BZ53459 */
            if (model.getProperty(CawConstants.LOYALTY_MEMBERSHIP_REDEEMABLE_VALUE) != null) {
                String redeemableValue = model.getProperty(CawConstants.LOYALTY_MEMBERSHIP_REDEEMABLE_VALUE).getStringValue();
                if (redeemableValue != null && !redeemableValue.isEmpty()) {
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    return buildCellColumn(numberFormat.format(new BigDecimal(redeemableValue))
                            , null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
                }
            }
            /* END BZ53459 */
        }

        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }

}
