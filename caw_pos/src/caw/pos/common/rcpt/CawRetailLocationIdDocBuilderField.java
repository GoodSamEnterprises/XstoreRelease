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
 * BZ24041          171017    The information of check franking doesn't met the requirement of Camping World.
 * BZ24028          191017    [Xstore] Franking is printing blank for Merchant Certificate and Check Tenders
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.ttr.impl.CheckTenderLineItemModel;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;

/**
 * This funciton is used to getLocationId and print out the receipts
 *
 */
public class CawRetailLocationIdDocBuilderField
        extends AbstractDocBuilderField {

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawRetailLocationIdDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof CheckTenderLineItemModel) {
            CheckTenderLineItemModel lineItem = (CheckTenderLineItemModel) argSource;
            if (lineItem.getParentTransaction() != null) {
                Long loc = lineItem.getParentTransaction()
                        .getRetailLocationId();
                result = String.format("%4s", loc.toString()).replace(' ', '0');
            }
        }
        //Begin BZ24028
        else if (argSource instanceof VoucherTenderLineItemModel) {
            VoucherTenderLineItemModel lineItem = (VoucherTenderLineItemModel) argSource;
            if (lineItem.getParentTransaction() != null) {
                Long loc = lineItem.getParentTransaction()
                        .getRetailLocationId();
                result = String.format("%4s", loc.toString()).replace(' ', '0');
            }
        }
        //End BZ24028
        return result;
    }

}
