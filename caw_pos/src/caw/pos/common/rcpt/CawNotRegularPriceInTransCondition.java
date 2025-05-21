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
 * BZ24657          011217    "You could have saved..." receipts changes
 * BZ31522          250619    [Port BZ31010 to 5.0][Xstore] Deals are being calculated into "You have saved..." for Club Members
 * BZ31523          250619    [Port BZ30263 to 5.0]Display GSC member savings in transaction
 *===================================================================
 */

package caw.pos.common.rcpt;

import caw.pos.araccount.CawCustomerUtil;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawNotRegularPriceInTransCondition extends AbstractInvertableCondition {

    /**
     * The purpose of this class is checking if customer is CLUB, NOT WHSL neither CREW
     * So: if the method return CLUB = true then finalResult = true
     * if other WHSL/CREW = true then finalResult = false.
     * Checking the condition to show/hide "You have saved ..." message.
     * If there is customer who has active CLUB pricing, print. Other cases, do not print
     * @return true if the condition is met, else return false
     */
    @Override
    protected boolean conditionMetImpl(Object argSoure) {

        if (argSoure instanceof IRetailTransaction) {
            IRetailTransaction trans = (IRetailTransaction) argSoure;
            boolean finalResult = false;
            /*BEGIN BZ31522, BZ31523*/
            if (trans.getCustomerParty() != null) {
                IParty party = trans.getCustomerParty();

                if (CawCustomerUtil.isClubCustomerXstore(party)) {
                    finalResult = true;
                }
                if (CawCustomerUtil.isWhslCustomer(party)) {
                    finalResult = false;
                }
                if (CawCustomerUtil.isCrewCustomerFromEBS(party)) {
                    finalResult = false;
                }
                return finalResult;
            }
            /*END BZ31522, BZ31523*/
        }
        return false;
    }
}
