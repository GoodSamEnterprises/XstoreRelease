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
 * BZ26207          190718    New Requirement - Enable Work Order Functionalitys
 *===================================================================
 */

package caw.pos.workorder.common;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData.CellColumn;

/**
 *
 */
public class CawWorkOrderDateTimeCellHandler extends DefaultCellDataHandler {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderDateTimeCellHandler.class);

    /* Display work order account setup date follow format.
     * @see dtv.pos.framework.ui.listview.DefaultCellDataHandler#buildCellColumn(dtv.pos.framework.ui.listview.config.ListViewColumnConfig, java.lang.Object, java.awt.Color, java.awt.Font)
     */
    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argArgColConfig,
            Object argArgModel, Color argArgDefaultRowTextColor,
            Font argArgDefaultRowFont) {

        if (argArgModel instanceof CawWorkOrderEBSQueryResult) {
            CawWorkOrderEBSQueryResult model = (CawWorkOrderEBSQueryResult) argArgModel;
            String workOrderDateTime = null;
            Date dateTime = null;

            try {
                dateTime = model.getWoDateTime();
                DateFormat format = new SimpleDateFormat(
                        CawWorkOrderConstants.DATE_TIME_FORMAT);
                workOrderDateTime = format.format(dateTime);
            } catch (Exception ex) {
                _logger.error("Work order display date/time, error: "
                        + ex.getMessage());
            }
            return buildCellColumn(workOrderDateTime, null, argArgDefaultRowTextColor, argArgDefaultRowFont, argArgColConfig);
        }

        return super.buildCellColumn(argArgColConfig, argArgModel, argArgDefaultRowTextColor, argArgDefaultRowFont);
    }

}
