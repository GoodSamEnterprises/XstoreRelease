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
 * BZ24531          171117    Receipt needs to show transaction type
 * BZ26289          170718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27414          300818    [Internal]House account payment receipt printed unexpectedly when doing sale transaction.
 * BZ29388          150219      [Internal] PLCC - Only 1 receipt prints when making a payment
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import caw.pos.common.CawConstants;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.tsn.ITenderControlTransaction;

/**
 * The CawTransTypeBuilderField class
 */
public class CawTransTypeBuilderField extends AbstractDocBuilderField {

    private static final String             TENDER_EXCHANGE      = "TENDER_EXCHANGE";

    private static final String             BEGINCOUNT           = "BEGINCOUNT";

    private static final String             ENDCOUNT             = "ENDCOUNT";

    private static final String             PAID_IN              = "PAID_IN";

    private static final String             PAID_OUT             = "PAID_OUT";

    private String                          transactionTypeCode_ = "HOUSE_ACCOUNT";  //BZ27414

    private static final FormattableFactory FF                   = FormattableFactory
            .getInstance();

    public CawTransTypeBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /* (non-Javadoc)
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof IRetailTransaction) {
            IRetailTransaction retailTrans = (IRetailTransaction) argSource;
            BigDecimal totalAmount = retailTrans.getTotal();
            // BZ26289 start
            if (totalAmount != null
                    && totalAmount.compareTo(BigDecimal.ZERO) >= 0
                    && isHouseAccountPayment(retailTrans)) {
                result = FF.getTranslatable("_transTypeHouseAccountPayment")
                        .toString(OutputContextType.RECEIPT);
            }
            /* BEGIN BZ29388 */
            else if (totalAmount != null && totalAmount.compareTo(BigDecimal.ZERO) >= 0
                    && isAccountPayment(retailTrans)) {
                
                result = FF.getTranslatable("_transTypeAccountPayment")
                        .toString(OutputContextType.RECEIPT);

            } 
            /* END BZ29388 */
            else if (totalAmount != null && totalAmount.compareTo(BigDecimal.ZERO) >= 0) {
                result = FF.getTranslatable("_transTypeSale").toString(OutputContextType.RECEIPT);
            } else {
                result = FF.getTranslatable("_transTypeReturn").toString(OutputContextType.RECEIPT);
            }
            // BZ26289 end
        } else if (argSource instanceof ITenderControlTransaction) {
            ITenderControlTransaction tndControlTrans = (ITenderControlTransaction) argSource;
            if (PAID_OUT.equals(tndControlTrans.getTypeCode())) {
                result = FF.getTranslatable("_transTypePaidOut")
                        .toString(OutputContextType.RECEIPT);
            } else if (PAID_IN.equals(tndControlTrans.getTypeCode())) {
                result = FF.getTranslatable("_transTypePaidIn")
                        .toString(OutputContextType.RECEIPT);
            } else if (ENDCOUNT.equals(tndControlTrans.getTypeCode())) {
                result = FF.getTranslatable("_transTypeEndCount")
                        .toString(OutputContextType.RECEIPT);
            } else if (BEGINCOUNT.equals(tndControlTrans.getTypeCode())) {
                result = FF.getTranslatable("_transTypeBeginCount")
                        .toString(OutputContextType.RECEIPT);
            } else if (TENDER_EXCHANGE.equals(tndControlTrans.getTypeCode())) {
                result = FF.getTranslatable("_transTypeTenderExchange")
                        .toString(OutputContextType.RECEIPT);
            }
        }
        return result;
    }

    // BZ26289 start
    /**
     * @param transaction
     * @return
     */
    private boolean isHouseAccountPayment(IRetailTransaction transaction) {

        List<IRetailTransactionLineItem> tranLineItems = null;

        if (transaction != null) {
            tranLineItems = transaction.getRetailTransactionLineItems();
        }

        if (tranLineItems != null && tranLineItems.size() > 0) {
            ISaleReturnLineItem returnLineItem = null; //BZ27414
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem
                        && !lineItem.getVoid()) {// BZ27414: Add more condition ->!lineItem.getVoid()
                    // Begin BZ27414
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getCustomerAccountModifier() != null
                            && transactionTypeCode_
                                    .equalsIgnoreCase(returnLineItem
                                            .getCustomerAccountModifier()
                                            .getCustAccountCode())) {
                        return true;
                    }
                    // End BZ27414
                }
            }
        }
        return false;
    }
    // BZ26289 end
    /* BEGIN BZ29388 */
    /**
     * Check Account Payment transaction
     * @param transaction
     * @return
     */
    private boolean isAccountPayment(IRetailTransaction transaction) {

        List<IRetailTransactionLineItem> tranLineItems = null;
        if (transaction != null) {
            tranLineItems = transaction.getRetailTransactionLineItems();
        }
        if (tranLineItems != null && tranLineItems.size() > 0) {
            ISaleReturnLineItem returnLineItem = null; //BZ27414
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem && !lineItem.getVoid()) {
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getScannedItemId() != null
                            && returnLineItem.getScannedItemId().contains(CawConstants.ACCOUNT_ID_LABEL)
                            && CawConstants.GS_ACCOUNT_PAYMENT.equalsIgnoreCase(returnLineItem.getItemDescription())) {
                        return true;
                    }

                }
            }
        }

        return false;
    }
    /* END BZ29388 */
}
