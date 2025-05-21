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
 * BZ23372          280917    [DEV] Printing a special receipt to attach to 
 *                            returned items to aid disposition/restocking
 * BZ23372          101017    [DEV] Printing a special receipt to attach to 
 *                            returned items to aid disposition/restocking
 * BZ23952          111017    Return product receipt prints when return is canceled
 * BZ24576          211117    Return Produce receipt is printed unexpectedly when suspend "Return" transaction
 * BZ27010          080818    [PROD][1.5.0]Returned Merchandise Receipt is printing incorrectly for all reason codes
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.pricing.discount.CawDiscountCouponHelper;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;
import dtv.pos.common.TransactionStatus;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawReturnSpecialReceiptRule extends AbstractRcptCopyRule {

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    @SuppressWarnings("deprecation")
    public CawReturnSpecialReceiptRule() {

        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (argSource instanceof IPosTransaction) {
            IPosTransaction transaction = (IPosTransaction) argSource;
            // Begin BZ24576
            if (transaction.getTransactionStatusCode()
                    .equalsIgnoreCase(TransactionStatus.SUSPEND.getName())) {
                return false;
            }
            // End BZ24576
            //BEGIN BZ23952
            if (!transaction.getTransactionStatusCode()
                    .equalsIgnoreCase(TransactionStatus.CANCEL.getName())) {
                for (ISaleReturnLineItem saleLine : transaction
                        .getLineItems(ISaleReturnLineItem.class)) {
                    if (saleLine != null
                            && saleLine.getReturnReasonCode() != null
                            && !saleLine.getReturnReasonCode().isEmpty()) {
                        /* BZ27028 added, removed code of BZ26629 */
                        if (_cawDiscountCouponHelper
                                .isEnableReasonCode(CawConstants.RETURN_REASON_TYPE_CODE, saleLine
                                        .getReturnReasonCode())) {
                            //BZ27028: updated new checking method isEnableReasonCode()
                            return true;
                        }
                    }
                }
            }
            //END BZ23952
        }
        return false;
    }

}
