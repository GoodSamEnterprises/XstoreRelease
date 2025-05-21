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
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawRegularMoreThanClubPriceInTransCondition
        extends AbstractInvertableCondition {
    /**
     * Checking the condition to show/hide "You have saved ..." message.
     * If there is customer who has active CLUB pricing, print. Other cases, do not print
     * @return true if the condition is met, else return false
     */
    //BEGIN BZ48629
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (!(argSource instanceof IRetailTransaction)) {
            return false;
        }

        BigDecimal clubPrice = new CawTotalAmountCouldSavedWorker(
                (IRetailTransaction) argSource).call();
//        BigDecimal regularPrice = new CawTotalAmountSavedWorker(
//                (IRetailTransaction) argSource).call();
//        
//        if (regularPrice.compareTo(clubPrice) == 1) {
//            return true;
//        }
        //BZ49750
        if (clubPrice.compareTo(BigDecimal.ZERO) == 1) {
            return true;
        }
        return false;
    }
    //END BZ48629
}
