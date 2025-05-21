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
 * BZ23607          031017    CWS Receipts Requires Printing of Regular and Club Pricing for Items
 * BZ37621          070920    [Internal] Receipt messages on the "Order Copy" of Emailed receipt does not match Camping World  
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.ConfigurationMgr.minYouSavedThresholdAmount;
import static dtv.pos.common.ConfigurationMgr.showYouSavedMessage;
import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;

import javax.inject.Inject;

import dtv.pos.common.rcpt.TotalAmountSavedMsgCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.impl.RetailTransactionModel;

/**
 * Checking the condition to show/hide the saved money message section
 */
public class CawOrderTotalAmountSavedMsgCondition extends TotalAmountSavedMsgCondition {
    
    @Inject
    protected TransactionScope _transactionScope;
    
    /** {@inheritDoc} */
    @Override
    public boolean conditionMetImpl(Object argSource) {

        if (!showYouSavedMessage()) {
            return false;
        }

        BigDecimal totalDiscount = NumberUtils.ZERO;
        if (_transactionScope.getTransaction(RETAIL_SALE) != null) {
            RetailTransactionModel trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
            
            totalDiscount = new CawTotalAmountCouldSavedWorker(trans).call();
            BigDecimal minDiscountToDisplay = minYouSavedThresholdAmount();
            if (NumberUtils.isGreaterThan(minDiscountToDisplay, totalDiscount)
                    || !NumberUtils.isPositive(totalDiscount)) {
                return false;
            }
        }
        return true;
    }
}
