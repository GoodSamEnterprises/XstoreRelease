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
 * BZ29335          120219    [Internal] The Good Sam Account Payment function should be disabled once adding new item into trans
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.visibilityrule;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.trl.*;

/**
 * Rule when Account Payment button enable or disable.
 */
public class CawEnableDisableAccountPaymentRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    /* When Account Payment button enable or disable.
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        /*
         * This block code handle case: at the beginning, if item(s) is added to transaction then
         * Account Payment button disable. And then if all item(s) voided, Account Payment button enable again.
         */
        if (trans != null) {
            List<IRetailTransactionLineItem> lineItems = trans
                    .getRetailTransactionLineItems();
            ISaleReturnLineItem lineItem = null;

            if (CollectionUtils.isNotEmpty(lineItems)) {
                int size = lineItems.size();
                
                for (int i = 0; i < size; i++) {
                    if (lineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) lineItems.get(i);

                        if (!lineItem.getVoid()) {
                            return AccessLevel.DENIED;
                        }
                    }
                }
            }
        }
        return AccessLevel.GRANTED;
    }
}
