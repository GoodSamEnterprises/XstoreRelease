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
 * BZ61159          230224    [New Requirement] - Xstore AGIS Replacement 
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import caw.pos.common.CawConstants;
import dtv.pos.hardware.rcptbuilding.copyrules.TransactionTypeRule;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawTemporaryMembershipCardRule extends TransactionTypeRule {
    
    @Override
    protected boolean doesRuleApply(Object argSource) {
        IRetailTransaction retailTrans = null;
        boolean isTemporaryMembershipCard = false;
        if (argSource instanceof IRetailTransaction) {
            retailTrans = (IRetailTransaction) argSource;
             isTemporaryMembershipCard = Boolean.valueOf(retailTrans.getStringProperty(CawConstants.CAW_IS_TEMPOPARY_MEMBERSHIP_CARD));
             retailTrans.removePosTransactionProperty(retailTrans.getProperty(CawConstants.CAW_IS_TEMPOPARY_MEMBERSHIP_CARD));
        }
        return isTemporaryMembershipCard;
    }

}
