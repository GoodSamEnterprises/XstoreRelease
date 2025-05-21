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
 * BZ23949          161017    Receipt Changes Required
 * BZ24052          171017    Missing Cashier number and Date Time on GC decline receipt when performing Issues/Reload or let timeout transaction
 * BZ24106          191017    Missing Date/Time on Tender Exchange receipt when performing exchange transaction in BO
 * BZ24146          201017    Missing Date/Time on receipt for sale transactions with gift receipt
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.tsn.ITenderControlTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawDateTimeDocBuilderField
        extends TenderEntryMethodDocBuilderField {

    @Inject
    protected TransactionScope _transactionScope;

    /**
     * 
     */
    public CawDateTimeDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        // Begin BZ23949
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy HH:mm");
        IPosTransaction trans = _transactionScope.getTransaction();

        if (trans == null && argSource instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;
            trans = lineItem.getParentTransaction();
        }
        // Begin BZ24106
        if (trans == null && argSource instanceof ITenderControlTransaction) {
            ITenderControlTransaction tndControl = (ITenderControlTransaction) argSource;
            result = formatter.format(tndControl.getBeginDateTimestamp());
        }
        // End BZ24106
        if (trans == null && argSource instanceof CawMiraResponse
                && ((CawMiraResponse) argSource)
                        .getRequest() instanceof CawMiraGiftCardRequest
                && ((CawMiraResponse) argSource)
                        .getBeginDateTimestamp() != null) {
            return formatter.format(((CawMiraResponse) argSource)
                    .getBeginDateTimestamp());
        }
        // Begin BZ24146
        if (trans == null && argSource instanceof IRetailTransaction) {
            IRetailTransaction retailTrans = (IRetailTransaction) argSource;
            result = formatter.format(retailTrans.getBeginDateTimestamp());
        }
        // End BZ24146
        if (trans != null) {
            result = formatter.format(trans.getBeginDateTimestamp());
        }
        // End BZ23949
        if (result.equals("")) {
            Date date = new Date();
            result = formatter.format(date);
        }

        return result;
    }
}
