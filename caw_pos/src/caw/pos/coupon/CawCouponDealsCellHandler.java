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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction 
 *===================================================================
 */

package caw.pos.coupon;

import java.awt.Color;
import java.awt.Font;

import dtv.i18n.*;
import dtv.pos.coupon.CouponDealsCellHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;

/**
 *
 */
public class CawCouponDealsCellHandler extends CouponDealsCellHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {
        
        if (argModel instanceof CawCouponLineWrapper) {
            CawCouponLineWrapper wrapper = (CawCouponLineWrapper) argModel;
            FormattableFactory ff = FormattableFactory.getInstance();
            IFormattable description = ff.getSimpleFormattable(wrapper.getPromoCodeLabel());
            return this.buildCellColumn(description.toString(OutputContextType.VIEW), null, argDefaultRowTextColor, argDefaultRowFont,argColConfig);
        }
        return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
    }

}
