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
 * BZ48629          210422    [Task] Print Points Balances - Sale transaction
 * BZ49750          090522    [Internal] Missing the message 'You could have saved $XX.XX' on the Sale receipt for non-Good Sam Club customer
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawRegularEqualsClubPriceInTransCondition
        extends AbstractInvertableCondition {
    /**
     * Checking the condition to show/hide "You have saved ..." message.
     * If there is customer who has active CLUB pricing, print. Other cases, do not print
     * @return true if the condition is met, else return false
     */
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (!(argSource instanceof IRetailTransaction)) {
            return false;
        }
        else {
            IRetailTransaction trans = (IRetailTransaction) argSource;
            
            boolean isSale = !NumberUtils.isNegative(trans.getTotal());
            
            BigDecimal clubPrice = new CawTotalAmountCouldSavedWorker(
                    (IRetailTransaction) argSource).call();
            
            if (clubPrice.compareTo(BigDecimal.ZERO) == 0 && isSale) {
                return true;
            }
        }
        
        return false;
      
    }
}
