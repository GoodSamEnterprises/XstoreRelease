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
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 *===================================================================
 */

package caw.pos.customer.membership;

import javax.inject.Inject;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawHasCutomerInTransaction
 */
public class CawHasCutomerCondition extends AbstractRunCondition {

    @Inject
    private TransactionScope _transactionScope;

    /** (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractRunCondition#shouldRunImpl()
     */
    @Override
    protected boolean shouldRunImpl() {

        IPosTransaction origialTrans = null;

        IParty orginalParty = null;

        if (_transactionScope != null) {
            origialTrans = _transactionScope.getTransaction();
        }

        if (origialTrans instanceof IRetailTransaction) {

            orginalParty = ((IRetailTransaction) origialTrans)
                    .getCustomerParty();

        }

        if (_transactionScope != null) {

            IParty cust = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);

            if (cust == null && orginalParty == null) {

                return true;

            }
        }
        return false;

    }

}
