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
 * BZ26289          240718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27001          020818    A/R tender is disabled unexpectedly from Tender option list when doing a sale transaction attached A/R customer.
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawDisableArTenderInHouseAccountRule class
 */
public class CawDisableArTenderInHouseAccountRule
        extends AbstractVisibilityRule {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        // BZ27001 start
        IPosTransaction pos = null;

        IParty cust = null;

        if (_transactionScope != null) {
            pos = _transactionScope.getTransaction();
            cust = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);

        }

        if (pos != null && cust != null & CawCustomerUtil.isWhslCustomer(cust)
                && CawCustomerUtil.isHouseAccountPayment(pos)) {
            return AccessLevel.DENIED;
        }
        // BZ27001 end
        return AccessLevel.GRANTED;

    }
}
