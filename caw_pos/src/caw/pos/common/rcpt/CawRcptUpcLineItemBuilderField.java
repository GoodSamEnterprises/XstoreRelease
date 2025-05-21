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
 * BZ26270          060718    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ38070          240920    UPC needs to print on Order Transaction Receipts per existing CW Functionality
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import caw.pos.register.CawUPCHelper;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.register.giftreceipt.GiftReceiptPrintItemDataModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawRcptUpcLineItemBuilderField extends AbstractDocBuilderField {

    /**
     * 
     */
    public CawRcptUpcLineItemBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1,
            Locale argArg2) {

        String result = null;
        if (argSource instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argSource;
            result = CawUPCHelper.getInstance().getUpcText(lineItem);
        } else if (argSource instanceof GiftReceiptPrintItemDataModel) {
            GiftReceiptPrintItemDataModel giftItem = (GiftReceiptPrintItemDataModel) argSource;
            ISaleReturnLineItem saleLine = giftItem.getItem();
            result = CawUPCHelper.getInstance().getUpcText(saleLine);
        //BEGIN BZ38070
        } else  if (argSource instanceof IOrderLine) {
            ISaleReturnLineItem order = ((IOrderLine) argSource).getShadowedSaleItem();
            if (order != null) {
                result = CawUPCHelper.getInstance().getUpcText(order);
            } else {
                // In case pick slip order               
                String itemId = ((IOrderLine) argSource).getItemId();
                result = CawUPCHelper.getInstance().getUpcText(itemId, itemId);
            }
        } // END BZ38070
        return result;
    }

}
