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
 * BZ26847          170718    [1.6.0][25958] Reload/Issue Gift card info prints on receipt incorrectly
 *===================================================================
 */

package caw.pos.register.nonphysical;

import java.awt.Color;
import java.awt.Font;

import dtv.i18n.*;
import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.pos.register.nonphysical.SerialNumberCellDataHandler;
import dtv.ui.layout.ViewCellData.CellColumn;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.IVoucherSaleLineItem;
import dtv.xst.dao.ttr.IVoucher;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;

/**
 *This Class is used to format card number based on First six and last four digits Gift card
 */
public class CawSerialNumberCellDataHandler
        extends SerialNumberCellDataHandler {

    @Override
    public CellColumn buildCellColumn(ListViewColumnConfig argColConfig,
            Object argModel, Color argDefaultRowTextColor,
            Font argDefaultRowFont) {

        String serialNumber = null;
        boolean isMatchingType = false;

        if (argModel instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argModel;
            serialNumber = lineItem.getSerialNumber();
            if (argModel instanceof IVoucherSaleLineItem) {
                isMatchingType = true;
            }
        } else if (argModel instanceof IVoucherTenderLineItem) {
            IVoucherTenderLineItem lineItem = (IVoucherTenderLineItem) argModel;
            //Begin BZ26847
            if (argModel instanceof VoucherTenderLineItemModel) {
                IVoucher verchermodel = ((VoucherTenderLineItemModel) argModel)
                        .getVoucher();
                if (verchermodel != null) {
                    lineItem.setSerialNumber(verchermodel.getSerialNumber());
                }

            }
            //End BZ26847
            serialNumber = lineItem.getSerialNumber();
            isMatchingType = true;
        }

        if (serialNumber == null) {
            return super.buildCellColumn(argColConfig, argModel, argDefaultRowTextColor, argDefaultRowFont);
        }

        FormattableFactory ff = FormattableFactory.getInstance();
        String displayValue = null;

        if (isMatchingType) {
            CawVoucherSerialNumberFormatter formatter = new CawVoucherSerialNumberFormatter();
            displayValue = formatter.format(serialNumber, null);
        } else {
            displayValue = serialNumber;
        }

        IFormattable label = ff.getTranslatable("_serialNbrWithValue", ff
                .getLiteral(displayValue));
        String cellText = label.toString(OutputContextType.VIEW);

        return buildCellColumn(cellText, null, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
    }
}
