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

package caw.hardware.barcode;

import java.util.Locale;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.hardware.barcode.BarcodeTranslator;
import dtv.hardware.barcode.TranBarcodeDocBuilderField;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawTranBarcodeDocBuilderField extends TranBarcodeDocBuilderField {

    public CawTranBarcodeDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        if (argSource instanceof SaleReturnLineItemModel) {
            IPosTransaction parentSource = ((SaleReturnLineItemModel) argSource).getParentTransaction();
            return BarcodeTranslator.getInstance().encode(parentSource.getObjectId());
        } else {
            return null;
        }
    }

}
