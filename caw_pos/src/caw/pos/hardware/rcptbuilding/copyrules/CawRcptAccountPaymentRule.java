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
 * BZ29388          150219    [Internal] PLCC - Only 1 receipt prints when making a payment
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import java.util.List;

import caw.pos.common.CawConstants;

import dtv.pos.hardware.rcptbuilding.copyrules.TransactionTypeRule;
import dtv.xst.dao.trl.*;

/**
 * The CawRcptAccountPaymentRule
 */
public class CawRcptAccountPaymentRule extends TransactionTypeRule {
    @Override
    protected boolean doesRuleApply(Object argSource) {
        
        IRetailTransaction retailTrans = null;
        if (argSource instanceof IRetailTransaction) {
            retailTrans = (IRetailTransaction) argSource;
        }
        List<IRetailTransactionLineItem> tranLineItems = null;
        if (retailTrans != null) {
            tranLineItems = retailTrans.getRetailTransactionLineItems();
        }
        if (tranLineItems != null && tranLineItems.size() > 0) {
            ISaleReturnLineItem returnLineItem = null; //BZ27414
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem && !lineItem.getVoid()) {
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getScannedItemId() != null
                            && returnLineItem.getScannedItemId().contains(CawConstants.ACCOUNT_ID_LABEL)
                            && CawConstants.GS_ACCOUNT_PAYMENT.equalsIgnoreCase(returnLineItem.getItemDescription())) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

}
