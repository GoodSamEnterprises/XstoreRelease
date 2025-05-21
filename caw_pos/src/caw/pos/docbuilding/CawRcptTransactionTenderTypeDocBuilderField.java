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
 * BZ25958          100718    New Requirement - Remove Gift Card transactions from the Pin Pad
 *===================================================================
 */

package caw.pos.docbuilding;

import java.util.Locale;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.RcptTransactionTypeDocBuilderField;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;

/**
 *This class is used to print out receipt on Tender line Item
 */
public class CawRcptTransactionTenderTypeDocBuilderField
        extends RcptTransactionTypeDocBuilderField {

    private static final FormattableFactory FF      = FormattableFactory
            .getInstance();

    private static final String             ACTIVE  = "_transTypeIssue";

    private static final String             RELOAD  = "_transTypeReload";

    private static final String             REDEMPT = "_transTypeRedempt";

    /**
     * 
     */
    public CawRcptTransactionTenderTypeDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof VoucherTenderLineItemModel) {
            VoucherTenderLineItemModel voucherSaleLineItem = (VoucherTenderLineItemModel) argSource;
            if (voucherSaleLineItem.getActivityCode()
                    .equalsIgnoreCase("RELOAD")) {
                result = FF.getTranslatable(RELOAD)
                        .toString(OutputContextType.RECEIPT);
            } else if (voucherSaleLineItem.getActivityCode()
                    .equalsIgnoreCase("ISSUED")) {
                result = FF.getTranslatable(ACTIVE)
                        .toString(OutputContextType.RECEIPT);
            } else {
                result = FF.getTranslatable(REDEMPT)
                        .toString(OutputContextType.RECEIPT);
            }

        }
        if (result != null) {
            return result;
        } else {
            return super.getContents(argSource, argFactory, argLocale);
        }
    }
}