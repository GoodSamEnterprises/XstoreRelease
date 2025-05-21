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
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVTagACDataCondition extends AbstractInvertableCondition {

    @Inject
    private Provider<TransactionScope> _transactionScope;

    /** Constructs a <code>CawHasEMVDataCondition</code>.
     * 
     */
    public CawEMVTagACDataCondition() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        if (argValue instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argValue;
            Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope
                    .get().getValue(CawValueKeys.EMV_DATA); // BZ23873
            if (mapEMVInfo != null && mapEMVInfo.size() > 0) {
                CawEmvPaymentCardInfo emvInfo = mapEMVInfo
                        .get(lineItem.getRetailTransactionLineItemSequence());
                if (emvInfo != null
                        && StringUtils.isNotEmpty(emvInfo.getAcTag())) {
                    return true;
                }
            }

        }
        return false;
    }
}
