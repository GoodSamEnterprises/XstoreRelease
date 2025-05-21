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
 * BZ24657          011217    "You could have saved..." receipts changes
 * BZ37621          070920    [Internal] Receipt messages on the "Order Copy" of Emailed receipt does not match Camping World
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;
import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TotalAmountSavedDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.NumberUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.impl.RetailTransactionModel;

/**
 *
 */
public class CawOrderTotalAmountCouldSavedDocBuilderField extends TotalAmountSavedDocBuilderField {
    @Inject
    protected TransactionScope _transactionScope;

    /**
    * Constructor.
    *
    * @param argContents the contents
    * @param argStyle the style
    * @param argLocation the location
    * @param argAlignment the alignment
    * @param argPriority the priority
    * @param argFormatter the formatter
    */
    public CawOrderTotalAmountCouldSavedDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
        BigDecimal totalDiscount = NumberUtils.ZERO;
        if (_transactionScope.getTransaction(RETAIL_SALE) != null) {
            RetailTransactionModel trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
            totalDiscount = new CawTotalAmountCouldSavedWorker(trans).call();
        }
        return getFormatter().format(totalDiscount, argLocale);
    }
}
