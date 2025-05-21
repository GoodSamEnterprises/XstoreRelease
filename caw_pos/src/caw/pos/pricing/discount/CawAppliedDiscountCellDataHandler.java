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
 * 
 *===================================================================
 */

package caw.pos.pricing.discount;

import java.awt.Color;
import java.awt.Font;

import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.pos.pricing.discount.AppliedDiscountCellDataHandler;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.trl.IRetailPriceModifier;

/**
 *
 */
public class CawAppliedDiscountCellDataHandler extends AppliedDiscountCellDataHandler{
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {
        if(argModel instanceof IRetailPriceModifier) {
            IRetailPriceModifier mod = (IRetailPriceModifier) argModel;
            if (mod.getStringProperty("IS_LOYALTY_MODIFIER") != null && mod.getDiscount() != null) {
                String discountDesc = mod.getDiscount().getDescription();
                discountDesc = FormattableFactory.getInstance().getSimpleFormattable(discountDesc).toString(OutputContextType.VIEW);
                return this.buildCellColumn(discountDesc, null, argDefaultRowTextColor, argDefaultRowFont,argColConfig);
            }
        }
        return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
    }
}
