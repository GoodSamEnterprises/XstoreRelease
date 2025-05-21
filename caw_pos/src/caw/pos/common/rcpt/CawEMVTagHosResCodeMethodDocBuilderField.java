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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23558              270917    Receipts are missing EMV data
 * BZ23873              231117    EMV printing issue after close store from Xstore
 *== ================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVTagHosResCodeMethodDocBuilderField
        extends TenderEntryMethodDocBuilderField {

    @Inject
    private Provider<TransactionScope> _transactionScope;

    /** Constructs a <code>CawEMVTagAIDMethodDocBuilderField</code>.
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawEMVTagHosResCodeMethodDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;
            Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope
                    .get().getValue(CawValueKeys.EMV_DATA); // BZ23873
            if (mapEMVInfo != null && mapEMVInfo.size() > 0) {
                CawEmvPaymentCardInfo emvInfo = mapEMVInfo
                        .get(lineItem.getRetailTransactionLineItemSequence());
                if (emvInfo != null && emvInfo.getHostResCode() != null) {
                    result = emvInfo.getHostResCode();
                }
            }
        }
        return result;
    }
}
