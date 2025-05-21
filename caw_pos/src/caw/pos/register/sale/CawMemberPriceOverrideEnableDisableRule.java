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
 * BZ25115          020518    New Requirement - Add a Member Price Override Function to the POS Sale screen
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawMemberPriceOverrideEnableDisableRule
        extends AbstractVisibilityRule {

    @Inject
    private TransactionScope             _transactionScope;

    @Inject
    private CawMemberPriceOverrideHelper _cawMemberPriceOverrideHelper;

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @SuppressWarnings("null")
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel isGranted = AccessLevel.GRANTED;
        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);

        if (iParty == null) {
            isGranted = AccessLevel.DENIED;
        } else {

            if (_transactionScope
                    .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE) == null) {
                Boolean isRegularGroup = _cawMemberPriceOverrideHelper
                        .isOnlyRegularGroup(iParty);

                if (!isRegularGroup) {
                    return AccessLevel.DENIED;
                }
            }

            /* Check list items in transaction, if there are 1 or more return items and 0 sale item, disable
             * Member Price Override button
             */
            List<IRetailTransactionLineItem> listLineItems = _transactionScope
                    .getTransaction().getRetailTransactionLineItems();
            ISaleReturnLineItem lineItem = null;
            int itemSale = 0;
            int itemReturn = 0;

            if (listLineItems != null && listLineItems.size() > 0) {
                int size = listLineItems.size();

                for (int i = 0; i < size; i++) {

                    if (listLineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) listLineItems.get(i);

                        if (lineItem.getReturn()) {
                            itemReturn++;
                        } else {
                            itemSale++;
                        }

                        if (lineItem.getVoid()) {
                            if (lineItem.getReturn()) {
                                itemReturn--;
                            } else {
                                itemSale--;
                            }
                        }
                    }
                }
            }

            if (itemReturn > 0 && itemSale == 0) {
                return AccessLevel.DENIED;
            }
        }

        return isGranted;
    }

}
