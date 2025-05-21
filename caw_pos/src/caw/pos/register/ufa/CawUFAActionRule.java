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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.tsn.ITenderControlTransaction;

/**
* Check roles and privileges to enable or disable the action button
*/
public class CawUFAActionRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        /*Check roles and privileges to enable or disable the action button*/
        //return AccessLevel.DENIED;
        return AccessLevel.GRANTED;
    }

    protected final ITenderControlTransaction getCurrentPaidOutTransaction() {

        //IRetailTransaction rettx = getCurrentRetailTransaction();
        IPosTransaction tran = getCurrentPosTransaction();
        return (tran instanceof ITenderControlTransaction)
                ? (ITenderControlTransaction) tran
                : null;
    }
}
