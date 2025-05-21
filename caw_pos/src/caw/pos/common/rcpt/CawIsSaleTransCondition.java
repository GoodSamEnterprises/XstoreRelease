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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction 
 *===================================================================
 */

package caw.pos.common.rcpt;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawIsSaleTransCondition extends AbstractInvertableCondition {

    @SuppressWarnings("null")
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (!(argSource instanceof IRetailTransaction)) {
            return false;
        }
        else {
            IRetailTransaction trans = (IRetailTransaction) argSource;
            
            if (trans != null) {
                if (NumberUtils.isNegative(trans.getTotal())) {
                    return false;
                }
            }

        }
        
        return true;
      
    }

}
