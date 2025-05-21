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
 * BZ28014          310519    [New Requirement] Xstore needs to allow stackability for/Allow multiple Merchant Certificates in a transaction
 * BZ34153          091219    [PROD] Quantity value for some but not all discount lines are incorrect, total discount is correct
 *===================================================================
 */
package caw.pos.pricing;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.prc.DealId;
import dtv.xst.dao.prc.IDeal;
import dtv.xst.dao.trl.IRetailPriceModifier;

/**
 * Display the times application of a deal
 */
public class CawDealApplyTimesCellHandler extends DefaultCellDataHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {

        if (argModel instanceof IRetailPriceModifier) {
            IRetailPriceModifier model = (IRetailPriceModifier) argModel;
            /* BEGIN BZ34153 */
            BigDecimal times = BigDecimal.ONE;
            if (isAllow(model.getDealId())) {
                times = model.getExtendedAmount().divide(model.getDealAmount(), BigDecimal.ROUND_HALF_EVEN);
                if (times == null) {
                    times = BigDecimal.ONE;
                }
            } else {
                times = BigDecimal.ONE;
            }
            /* END BZ34153 */
            return buildCellColumn(times.stripTrailingZeros()
                    .toString(), null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
        }
        return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
    }

    /* BEGIN BZ34153*/
    /***
     * The function to check allow multiple Merchant Certificates.
     * @param argDealId
     * @return
     */
    public boolean isAllow(String argDealId) {

        DealId dealId = new DealId();
        dealId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        dealId.setDealId(argDealId);
        /*This logic will prevent Xstore call SQL many times*/
        IDeal deal = DataFactory
                .getObjectByIdFromList(dealId, new ArrayList<>(CawMultipleDealMap.getInstance().getDealUsed()));
        if (deal == null) {
            deal = DataFactory.getObjectByIdNoThrow(dealId);
        }
        if (deal != null) {
            CawMultipleDealMap.getInstance().putToUsedDeal(deal);
            return deal.getBooleanProperty(CawConstants.CAW_ALLOW_MULTIPLE_DEAL);
        }
        return false;
    }
    /* END BZ34153 */
}
