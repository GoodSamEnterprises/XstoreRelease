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
 * BZ24103          191017    PO# is printed incorrectly when performing a transaction and tender by third party
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.ttr.impl.AccountReceivableTenderLineItemModel;

/**
 * This funciton is used to get the second line for prompt purchase order number and print out the receipts
 *
 */
public class CawPONumberLineDocBuilderField extends AbstractDocBuilderField {

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawPONumberLineDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof AccountReceivableTenderLineItemModel) {
            AccountReceivableTenderLineItemModel lineItem = (AccountReceivableTenderLineItemModel) argSource;
            if (lineItem.getParentTransaction() != null) {

                if (lineItem.getPoNumber().length() > 30) {
                    result = lineItem.getPoNumber().substring(0, 30);
                } else {
                    result = lineItem.getPoNumber();
                }
            }
        }
        return result;
    }

}
