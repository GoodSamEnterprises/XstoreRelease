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
 * BZ26893          171018    [Xstore] Transaction Receipt Changes
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawRcptWOLineItemQtyBuilderField extends AbstractDocBuilderField {

    /**
     * 
     */
    public CawRcptWOLineItemQtyBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1,
            Locale argArg2) {

        BigDecimal qty = null;
        BigDecimal price = null;
        String result = "";
        if (argSource instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argSource;
            qty = lineItem.getQuantity();
            price = lineItem.getBaseUnitPrice();
            if (qty != null && price != null) {
                /*stripTrailingZeros().toPlainString() 
                 * to remove the zero after decimal of quantity line item*/
                qty = new BigDecimal(qty.stripTrailingZeros().toPlainString());
                if (qty.compareTo(BigDecimal.ONE) != 0) {
                    result = qty.toString() + "@" + price.toString();
                }
            }
        }
        return result;
    }
}
