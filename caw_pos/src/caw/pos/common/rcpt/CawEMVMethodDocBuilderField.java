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
 * BZ26893          151118    [New Requirement] - Xstore Transaction Receipt Changes
 * BZ28744          201218    [2.9.7] Missing credit/EMV credit information on Tender exchange receipt.
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.TransactionType;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.CollectionUtils;
import dtv.util.StringUtils;
import dtv.util.config.IConfigObject;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVMethodDocBuilderField
        extends TenderEntryMethodDocBuilderField {

    @Inject
    private Provider<TransactionScope> _transactionScope;

    private String                     emvValue;

    private final String               SEQNUM     = "SEQNUM";

    private final String               HOSRESCODE = "HOSRESCODE";

    private final String               ISORESCODE = "ISORESCODE";

    private final String               AID        = "AID";

    private final String               APPNAME    = "APPNAME";

    private final String               TVR        = "TVR";

    private final String               TSI        = "TSI";

    private final String               AC         = "AC";

    private final String               CURRENCY   = "CURRENCY";

    private final String               TRANUM     = "TRANUM";

    private final String               DEVICEID   = "DEVICEID";

    private final String               MERCHID    = "MERCHID";

    private final String               TERINALNUM = "TERINALNUM";

    public CawEMVMethodDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, IConfigObject argValue) {

        if ("emv_Value".equalsIgnoreCase(argName)) {
            emvValue = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        String result = "";
        if (argSource instanceof ICreditDebitTenderLineItem) {

            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;
            Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope.get().getValue(CawValueKeys.EMV_DATA);

            if (CollectionUtils.isEmpty(mapEMVInfo) && !CollectionUtils.isEmpty(CawVoucherValue.getEmvInfo())) { //BZ28744

                mapEMVInfo = CawVoucherValue.getEmvInfo();
            }
            if (!CollectionUtils.isEmpty(mapEMVInfo)) {

                CawEmvPaymentCardInfo emvInfo = mapEMVInfo.get(lineItem.getRetailTransactionLineItemSequence());
                if (emvInfo != null) {

                    if (SEQNUM.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getSeqNumber())) {
                        return emvInfo.getSeqNumber();
                    } else if (HOSRESCODE.equalsIgnoreCase(emvValue)
                            && !StringUtils.isEmpty(emvInfo.getHostResCode())) {
                        return emvInfo.getHostResCode();
                    } else if (ISORESCODE.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getIsoResCode())) {
                        return emvInfo.getIsoResCode();
                    } else if (AID.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getAidTag())) {
                        return emvInfo.getAidTag();
                    } else if (APPNAME.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getAppNameTag())) {
                        return emvInfo.getAppNameTag();
                    } else if (TVR.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getTvrTag())) {
                        return emvInfo.getTvrTag();
                    } else if (TSI.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getTsiTag())) {
                        return emvInfo.getTsiTag();
                    } else if (AC.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getAcTag())) {
                        return emvInfo.getAcTag();
                    } else if (CURRENCY.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getCurrency())) {
                        return emvInfo.getCurrency();
                    } else if (TRANUM.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getTraceNumber())) {
                        return emvInfo.getTraceNumber();
                    } else if (DEVICEID.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getDeviceId())) {
                        return emvInfo.getDeviceId();
                    } else if (MERCHID.equalsIgnoreCase(emvValue) && !StringUtils.isEmpty(emvInfo.getMerchId())) {
                        return emvInfo.getMerchId();
                    } else if (TERINALNUM.equalsIgnoreCase(emvValue)
                            && !StringUtils.isEmpty(emvInfo.getTerminalNumber())) {
                        return emvInfo.getTerminalNumber();
                    } else {
                        return result;
                    }
                } else {
                    return result;
                }
            } else {
                return result;
            }
        }
        return result;
    }
}
