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
 * BZ37954          180920    [Internal] - Changing Barcode on Order Customer Copy receipt to Barcode of transaction
 *===================================================================
 */
package caw.hardware.barcode;

import java.util.Locale;

import dtv.data2.access.IObjectId;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.hardware.barcode.BarcodeTranslator;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.order.OrderReceiptSource;

public class CawOrderTranBarcodeDocBuilderField extends AbstractDocBuilderField {

    public CawOrderTranBarcodeDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1, Locale argArg2) {

        if (argSource instanceof OrderReceiptSource) {
            IObjectId objectId = ((OrderReceiptSource) argSource).getTransaction().getObjectId();
            return BarcodeTranslator.getInstance().encode(objectId);
        }
        return null;
    }
}
