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

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IVoucherSaleLineItem;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawRcptTransactionTypeDocBuilderField
        extends AbstractDocBuilderField {

    /**
     * 
     */
    private static final FormattableFactory FF = FormattableFactory
            .getInstance();

    public CawRcptTransactionTypeDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";

        if (argSource instanceof ITenderLineItem) {
            ITenderLineItem voucherSaleLineItem = (ITenderLineItem) argSource;
            if (TenderStatus.TENDER
                    .matches(voucherSaleLineItem.getTenderStatusCode())) {
                if (voucherSaleLineItem instanceof ICreditDebitTenderLineItem) {
                    ICreditDebitTenderLineItem creditDebitLineItem = (ICreditDebitTenderLineItem) voucherSaleLineItem;
                    if ("AUTHORIZED".equals(creditDebitLineItem
                            .getAdjudicationCode())) {
                        result = FF.getTranslatable("_transTypePhoneSale")
                                .toString(OutputContextType.RECEIPT);
                    } else {
                        result = FF.getTranslatable("_transTypeSale")
                                .toString(OutputContextType.RECEIPT);
                    }
                }
            } else if (TenderStatus.REFUND
                    .matches(voucherSaleLineItem.getTenderStatusCode())) {
                result = FF.getTranslatable("_transTypeRefund")
                        .toString(OutputContextType.RECEIPT);

            }
        } else if (argSource instanceof IVoucherSaleLineItem) {
            IVoucherSaleLineItem voucherSaleLineItem1 = (IVoucherSaleLineItem) argSource;
            if (voucherSaleLineItem1.getReturn()) {
                result = FF.getTranslatable("_transTypeRefund")
                        .toString(OutputContextType.RECEIPT);

            } else {
                result = FF.getTranslatable("_transTypeSale")
                        .toString(OutputContextType.RECEIPT);
            }
        }

        return result;
    }

}
