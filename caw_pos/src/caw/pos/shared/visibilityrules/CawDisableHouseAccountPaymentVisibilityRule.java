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
 * BZ26947          300718    [1.6.1][26289] House Account Payment/F4 is not being disabled
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.customer.CawCustomerHelper;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawDisableHouseAccountPaymentVisibilityRule
 */
public class CawDisableHouseAccountPaymentVisibilityRule
        extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    /** {@inheritDoc} */
    @Override
    protected IAccessLevel checkVisibilityImpl() {

        IParty cust = null;

        if (_transactionScope != null) {

            IPosTransaction pos = _transactionScope.getTransaction();
            // BZ26947 start
            if (pos != null && pos.getSaleLineItems() != null
                    && pos.getSaleLineItems().size() > 0
                    && checkVoidedItems(pos)) {
                return AccessLevel.DENIED;
            }
            // BZ26947 end
            cust = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        }

        if (cust != null && CawCustomerUtil.isWhslCustomer(cust)) {

            String lookupResponse = CawCatalystHelper.getLookupResponseData();

            BigDecimal arAccountBalance = CawCustomerHelper.getInstance()
                    .getARAvailableBalanceAmt(lookupResponse);

            if (BigDecimal.ZERO.compareTo(arAccountBalance) != 0) {
                return AccessLevel.GRANTED;
            }
        }

        return AccessLevel.DENIED;
    }

    // BZ26947 start
    /**
     * @param pos
     * @return
     */
    private boolean checkVoidedItems(IPosTransaction pos) {

        if (pos != null) {

            List<IRetailTransactionLineItem> saleLineItems = pos
                    .getSaleLineItems();

            if (saleLineItems != null && saleLineItems.size() > 0) {

                for (IRetailTransactionLineItem saleLineItem : saleLineItems) {

                    if (!saleLineItem.getVoid()) {
                        return true;
                    }

                }
            }

        }
        return false;
    }
    // BZ26947 end
}
