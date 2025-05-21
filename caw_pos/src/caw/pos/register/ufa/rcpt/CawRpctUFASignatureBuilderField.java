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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa.rcpt;

import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
@SuppressWarnings("deprecation")
public class CawRpctUFASignatureBuilderField
        extends TenderEntryMethodDocBuilderField {

    @Inject
    protected TransactionScope _transactionScope;

    /**
     * Print signature's customer
     */
    @SuppressWarnings("deprecation")
    public CawRpctUFASignatureBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        ITenderLineItem result = null;
        IPosTransaction trans = _transactionScope.getTransaction();
        result = (ITenderLineItem) trans.getTenderLineItems().get(0);

        return result.getSignature().getSignature();
    }
}
