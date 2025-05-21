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
 * BZ23558          290917    Receipts are missing EMV data
 * BZ23559          091017    Gift Card Tender Exchange transaction receipt does not meet CW requirements
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawAuthTimeDocBuilderField
        extends TenderEntryMethodDocBuilderField {

    @Inject
    private Provider<TransactionScope> _transactionScope;

    /**
     * 
     */
    public CawAuthTimeDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        // Begin BZ23559
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        IPosTransaction trans = _transactionScope.get().getTransaction();
        if (trans == null) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;
            trans = lineItem.getParentTransaction();
        }
        if (trans != null) {
            result = formatter.format(trans.getBeginDateTimestamp());
        }
        // End BZ23559
        return result;
    }
}
