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
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins
 * BZ26231              150518    [PROD]Blank Error displayed. Cannot print receipt after credit card tender auth is complete
 *== ================================================================
 */

package caw.pos.customer;

import java.util.List;

import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.TransactionType;
import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawViewTransactionCustomerOp extends CawEditCustomerOp {

    private CawCustomerHelper _cawCustomerUpdateHelper = CawCustomerHelper
            .getInstance();

    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {

        return true;
    }

    /** {@inheritDoc} */
    @Override
    protected CustomerMaintenanceModel createModel() {

        IRetailTransaction trans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        // Begin BZ23958
        List<ICustomerLoyaltyCard> cardLst = _cawCustomerUpdateHelper
                .getCustomerCards(trans.getCustomerParty());
        // Begin BZ26231
        if (cardLst != null && cardLst.size() > 0) {
            for (ICustomerLoyaltyCard iCustomerLoyaltyCard : cardLst) {
                ((IDataModelImpl) iCustomerLoyaltyCard).getDAO()
                        .setObjectState(DaoState.UPDATED.intVal());
            }
            trans.getCustomerParty().setLoyaltyCards(cardLst);
        }
        // End BZ26231

        // End BZ23958
        setScopedValue(ValueKeys.SELECTED_CUSTOMER, trans.getCustomerParty());
        return super.createModel();
    }
}
