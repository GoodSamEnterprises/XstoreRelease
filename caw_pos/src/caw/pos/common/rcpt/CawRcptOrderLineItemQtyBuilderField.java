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
 * BZ37202          180820    [TASK] Modify Order receipts to matches Camping World's current templates and rules
 * BZ38075          300920    [Internal] - The Qty column and pricing title on receipt for Club member display incorrectly on Order Pick Slip
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawRcptOrderLineItemQtyBuilderField extends AbstractDocBuilderField {

    /**
     * 
     */
    public CawRcptOrderLineItemQtyBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1, Locale argArg2) {

        BigDecimal qty = null;
        BigDecimal price = null;
        String result = "";
        if (argSource instanceof IOrderLine) {
            IOrderLine lineItem = (IOrderLine) argSource;
            qty = lineItem.getQuantity();
            price = lineItem.getUnitPrice();
            if (qty != null && price != null) {
                qty = new BigDecimal(qty.stripTrailingZeros().toPlainString());
                price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);//BZ38075
                if (qty.compareTo(BigDecimal.ONE) > 0) {
                    result = qty.toString() + "@ " + price.toString();
                }
            }
        }
        return result;
    }
}
