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
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.CollectionUtils;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVDataCondition extends AbstractInvertableCondition {

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
    
    private final String               DEFER_FINANCIAL = "DEFER_FINANCIAL";/*BZ33319*/

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, Object argValue) {

        if ("value".equalsIgnoreCase(argName)) {
            emvValue = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        if (argValue instanceof ICreditDebitTenderLineItem) {

            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argValue;
            Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope.get().getValue(CawValueKeys.EMV_DATA);

            if (CollectionUtils.isEmpty(mapEMVInfo) && !CollectionUtils.isEmpty(CawVoucherValue.getEmvInfo())) { //BZ28744

                mapEMVInfo = CawVoucherValue.getEmvInfo();
            }
            if (!CollectionUtils.isEmpty(mapEMVInfo)) {

                CawEmvPaymentCardInfo emvInfo = mapEMVInfo.get(lineItem.getRetailTransactionLineItemSequence());
                if (emvInfo != null) {

                    if (SEQNUM.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getSeqNumber())) {
                        return true;
                    } else if (HOSRESCODE.equalsIgnoreCase(emvValue)
                            && StringUtils.isNotEmpty(emvInfo.getHostResCode())) {
                        return true;
                    } else if (ISORESCODE.equalsIgnoreCase(emvValue)
                            && StringUtils.isNotEmpty(emvInfo.getIsoResCode())) {
                        return true;
                    } else if (AID.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getAidTag())) {
                        return true;
                    } else if (APPNAME.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getAppNameTag())) {
                        return true;
                    } else if (TVR.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getTvrTag())) {
                        return true;
                    } else if (TSI.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getTsiTag())) {
                        return true;
                    } else if (AC.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getAcTag())) {
                        return true;
                    } else if (CURRENCY.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getCurrency())) {
                        return true;
                    } else if (TRANUM.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getTraceNumber())) {
                        return true;
                    } else if (DEVICEID.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getDeviceId())) {
                        return true;
                    } else if (MERCHID.equalsIgnoreCase(emvValue) && StringUtils.isNotEmpty(emvInfo.getMerchId())) {
                        return true;
                    } else if (TERINALNUM.equalsIgnoreCase(emvValue)
                            && StringUtils.isNotEmpty(emvInfo.getTerminalNumber())) {
                        return true;
                    /*BEGIN BZ33319*/
                    } else if (DEFER_FINANCIAL.equalsIgnoreCase(emvValue)
                            && StringUtils.isNotEmpty(emvInfo.getDeferFinancial())) {
                        return true;
                    }
                    /*END BZ33319*/
                    else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
