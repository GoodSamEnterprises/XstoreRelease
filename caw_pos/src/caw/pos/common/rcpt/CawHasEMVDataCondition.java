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
 * BZ23559              091017    Gift Card Tender Exchange transaction receipt does not meet CW requirements
 * BZ23873              231117    EMV printing issue after close store from Xstore
 * BZ28744              201218    [2.9.7] Missing credit/EMV credit information on Tender exchange receipt.
 *==================================================================
 */

package caw.pos.common.rcpt;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.CollectionUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawHasEMVDataCondition extends AbstractInvertableCondition {

    @Inject
    private Provider<TransactionScope> _transactionScope;

    /** Constructs a <code>CawHasEMVDataCondition</code>.
     * 
     */
    public CawHasEMVDataCondition() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        if (argValue instanceof ICreditDebitTenderLineItem) {

            Map<Integer, CawEmvPaymentCardInfo> emvInfo = _transactionScope.get().getValue(CawValueKeys.EMV_DATA); // BZ23873
            if (!CollectionUtils.isEmpty(emvInfo)) {
                return true;
            } else if (CollectionUtils.isEmpty(emvInfo) && !CollectionUtils.isEmpty(CawVoucherValue.getEmvInfo())) { //BZ28744
                return true;
            }
        }
        return false;
    }
}
