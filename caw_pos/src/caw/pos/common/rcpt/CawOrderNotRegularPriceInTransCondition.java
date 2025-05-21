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
 * BZ37621          070920    [Internal] Receipt messages on the "Order Copy" of Emailed receipt does not match Camping World  
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.impl.RetailTransactionModel;

/**
 *
 */
public class CawOrderNotRegularPriceInTransCondition extends AbstractInvertableCondition {

    /**
     * The purpose of this class is checking if customer is CLUB, NOT WHSL neither CREW
     * So: if the method return CLUB = true then finalResult = true
     * if other WHSL/CREW = true then finalResult = false.
     * Checking the condition to show/hide "You have saved ..." message.
     * If there is customer who has active CLUB pricing, print. Other cases, do not print
     * @return true if the condition is met, else return false
     */
    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected boolean conditionMetImpl(Object argSoure) {

        if (_transactionScope.getTransaction(RETAIL_SALE) != null) {
            RetailTransactionModel trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
            boolean finalResult = false;
            
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
        }
        return false;
    }
}
