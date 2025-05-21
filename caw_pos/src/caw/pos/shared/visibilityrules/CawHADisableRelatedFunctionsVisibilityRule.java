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
 * BZ26971          310718    [26289] House account payment transaction is not eligible to be suspended transaction when backing to Sale screen from Tender Option list
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
 * The CawHADisableRelatedFunctionsVisibilityRule class
 */
public class CawHADisableRelatedFunctionsVisibilityRule
        extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (_transactionScope != null) {
            IPosTransaction pos = _transactionScope.getTransaction();
            IParty cust = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);
            if (pos != null && cust != null
                    && CawCustomerUtil.isWhslCustomer(cust)
                    && CawCustomerUtil.isHouseAccountPayment(pos)) {
                return AccessLevel.DENIED;
            }
        }

        return AccessLevel.GRANTED;

    }

}
