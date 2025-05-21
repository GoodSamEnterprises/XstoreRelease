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

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.util.CawCheetahHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawRegularCustomerInTransCondition
        extends AbstractInvertableCondition {
    /**
     * Checking the condition to show/hide "You have saved ..." message.
     * If there is customer who has active CLUB pricing, print. Other cases, do not print
     * @return true if the condition is met, else return false
     */
    @Override
    protected boolean conditionMetImpl(Object argSoure) {
        String lookupData = CawCatalystHelper.getLookupResponseData();
        CawCheetahHelper _cawCheetahHelper = new CawCheetahHelper(); //BZ49750
        
        if (argSoure instanceof IRetailTransaction) {
            IRetailTransaction trans = (IRetailTransaction) argSoure;
            if (trans.getCustomerParty() != null) {
                //IParty party = trans.getCustomerParty();
                //Begin BZ49750
                if(_cawCheetahHelper.isWhls(lookupData)) {
                    return false;
                } 
                if(_cawCheetahHelper.isCrew(lookupData)) {
                    return false;
                }
                if(lookupData!=null && CawCheetahHelper.getInstance().isClubMembership(lookupData)) {
                    return false;
                }  
                //End BZ49750
            }
        }
        return true;
    }
}
