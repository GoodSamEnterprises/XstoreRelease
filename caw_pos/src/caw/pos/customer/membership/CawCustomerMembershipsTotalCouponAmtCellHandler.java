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
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 *===================================================================
 */

package caw.pos.customer.membership;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.impl.CustomerLoyaltyCardModel;

/**
 * The CawCustomerMembershipsCellHandler
 */
public class CawCustomerMembershipsTotalCouponAmtCellHandler extends DefaultCellDataHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {

        if (argArgModel instanceof CustomerLoyaltyCardModel) {

            CustomerLoyaltyCardModel model = (CustomerLoyaltyCardModel) argArgModel;

            List<CawCustomerMembershipView> custMemViews;
            custMemViews = CawMembershipHelper.getInstance().getMemberships();
            if (custMemViews != null && custMemViews.size() > 0) {

                String cardNumber = model.getCardNumber();

                for (CawCustomerMembershipView cawCustMemView : custMemViews) {

                    if (!StringUtils.isEmpty(cardNumber)
                            && cardNumber.equals(cawCustMemView.getClub())) {
                        if (cawCustMemView.getTotalCouponAmount() != null && !cawCustMemView.getTotalCouponAmount().isEmpty()) {
                            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                            return buildCellColumn(numberFormat.format(new BigDecimal(cawCustMemView.getTotalCouponAmount())), null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
                        }
                    }
                }
            }
        }

        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }

}
