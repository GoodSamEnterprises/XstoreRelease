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
 * BZ28744              261218    [2.9.7] Missing credit/EMV credit information on Tender exchange receipt.
 *== ================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.CollectionUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVVerificationMethodDocBuilderField extends TenderEntryMethodDocBuilderField {

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
    public CawEMVVerificationMethodDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        String result = "";
        if (argSource instanceof ICreditDebitTenderLineItem) {

            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;

            Map<Integer, String> mapVerify = _transactionScope.get().getValue(CawValueKeys.VERIFICATION); // BZ23873

            if (!CollectionUtils.isEmpty(mapVerify)) {
                String verifycation = mapVerify.get(lineItem.getRetailTransactionLineItemSequence());
                if (verifycation != null) {
                    result = verifycation;
                }
            } else if (CollectionUtils.isEmpty(mapVerify) && !CollectionUtils.isEmpty(CawVoucherValue.getEmvInfo())) {// BZ28744

                Map<Integer, CawEmvPaymentCardInfo> emvInfo = CawVoucherValue.getEmvInfo();
                CawEmvPaymentCardInfo cawEmvInfo = emvInfo.get(lineItem.getRetailTransactionLineItemSequence());
                if (StringUtils.isNotEmpty(cawEmvInfo.getVerification())) {
                    result = cawEmvInfo.getVerification();
                }
            }

        }
        return result;
    }
}
