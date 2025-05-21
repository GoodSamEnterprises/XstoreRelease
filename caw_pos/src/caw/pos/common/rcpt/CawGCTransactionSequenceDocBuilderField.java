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
 * BZ28915          020119    [Internal] Missing Cashier and Transaction number on Balance Inquiry receipt.
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trn.IPosTransaction;


public class CawGCTransactionSequenceDocBuilderField extends AbstractDocBuilderField {

    @Inject
    protected TransactionScope _transactionScope;

    public CawGCTransactionSequenceDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argParamObject, IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        String transSequence = "";
        if (_transactionScope != null && _transactionScope.getTransaction() != null) {
            IPosTransaction trans = _transactionScope.getTransaction();
            transSequence = String.valueOf(trans.getTransactionSequence());
        }

        return transSequence;
    }
}
