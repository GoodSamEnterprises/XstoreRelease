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
 * BZ49801          040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 *===================================================================
 */

package caw.pos.customer.membership;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import caw.pos.common.CawJSONConstant;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.cat.impl.AwardAccountCouponModel;

/**
 * BZ48564
 */
public class CawCustomerMembershipsAmountCellHandler
        extends DefaultCellDataHandler {
    private final String L_PERCENTORDOLLAR = "PERCENTORDOLLAR";
    @SuppressWarnings("null")
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {

        if (argArgModel instanceof AwardAccountCouponModel) {
            AwardAccountCouponModel awardmodel = (AwardAccountCouponModel) argArgModel;
            String symbol = null;
            if(awardmodel.containsKey(L_PERCENTORDOLLAR)) {
                symbol = awardmodel.getStringProperty(L_PERCENTORDOLLAR);
            }
            BigDecimal metricValue = null;
            DecimalFormat df = new DecimalFormat("#,###.00");
            if(awardmodel.getAmount()!=null) {
                metricValue  = awardmodel.getAmount();  
              }
            //START BZ49801
            if(symbol==null&&metricValue!=null) {
                if(metricValue.compareTo(BigDecimal.ZERO) == 0) {
                    return buildCellColumn(null, null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
                }
                return buildCellColumn(df.format(metricValue).toString(), null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
            }
            //END BZ49801
            if (symbol != null && !symbol.isEmpty() && metricValue != null ) {
                if (symbol.equals(CawJSONConstant.JSON_PERCENT_OFF)) {
                    String result = metricValue + "%";
                    return buildCellColumn(result, null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
                } else {
                    String result = "$" + df.format(metricValue);
                    return buildCellColumn(result, null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
                }
            }
            else if(symbol == null && metricValue != null){
                return buildCellColumn("$"+df.format(metricValue), null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
            }
            else return buildCellColumn(metricValue.toString(), null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
            
        }
        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }
}
