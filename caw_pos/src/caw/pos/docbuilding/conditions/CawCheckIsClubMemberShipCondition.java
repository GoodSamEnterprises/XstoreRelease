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
 * BZ48629          250422    [Task] Print Points Balances - Sale transaction 
 * BZ49750          090522    [Internal] Missing the message 'You could have saved $XX.XX' on the Sale receipt for non-Good Sam Club customer
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.cheetah.util.CawCheetahHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawCheckIsClubMemberShipCondition  extends AbstractInvertableCondition{

    /* (non-Javadoc)
     * @see dtv.docbuilding.conditions.AbstractInvertableCondition#conditionMetImpl(java.lang.Object)
     */
    //BEGIN BZ48629
    @Override
    protected boolean conditionMetImpl(Object argArg0) {
        String lookupData = CawCatalystHelper.getLookupResponseData();
        CawCheetahHelper _cawCheetahHelper = new CawCheetahHelper();
        if (argArg0 instanceof IRetailTransaction) {
            IRetailTransaction trans = (IRetailTransaction) argArg0;
            if (trans.getCustomerParty() != null) {
                //IParty party = trans.getCustomerParty();
                if(!CawCheetahHelper.getInstance().isClubMembershipExpired(lookupData) && !CawCheetahHelper.getInstance().isMembershipNull(lookupData)) {
                    return true;
                } 
                //Begin BZ49750
                if(_cawCheetahHelper.isWhls(lookupData) ) {
                    return false;
                } 
                if(_cawCheetahHelper.isCrew(lookupData)) {
                    return false;
                }
                //End BZ49750
            }
        }
        return false;
    }
    //END BZ48629

}
