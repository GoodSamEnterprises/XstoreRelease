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
 * BZ23758          051017    "AR account" tender is enable unexpectedly from Tender option list after removing associated customer
 * BZ23580          311017    Removal of GSC Customer Prompted for Renewal Accepted, Club Renewal Item Remains on Sale
 * BZ24509          161107    [Xstore] Unit Price does not update in POS Sale screen after club member customer is removed from transaction
 * BZ24877          251217    When Selling Memberships, Store Associates Are Not Prompted for Membership#
 * BZ27339          101018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ32142          250719    [Xstore] Warranty items not pricing correctly when customer added
 *===================================================================
 */

package caw.pos.customer;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawMembershipActivityHelper;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.TransactionType;
import dtv.pos.customer.ICustomerUIHelper;
import dtv.pos.customer.RemoveCustFromTransactionOp;
import dtv.pos.customer.loyalty.LoyaltyMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.IWarrantyHelper;
import dtv.xst.dao.trl.*;

/**
 * This function is used to clear transaction scope when removing customer.
 */
public class CawRemoveCustFromTransactionOp extends Operation {

    private static final Logger         logger_ = LogManager
            .getLogger(RemoveCustFromTransactionOp.class);

    @Inject
    private ICustomerUIHelper           _customerUIHelper;

    @Inject
    private LoyaltyMgr                  _loyaltyMgr;

    @Inject
    private OrderMgr                    _orderMgr;

    @Inject
    private CawMembershipActivityHelper _membershipHelper;
    
    @Inject
    private IWarrantyHelper             _warrantyHelper;    /*BZ32142*/

    /**
     * Instantiates a new removes the cust from transaction op.
     */
    public CawRemoveCustFromTransactionOp() {

        super(false);
    }

    /**
     * {@inheritDoc} Remove the Customer/party association from the transaction.
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        _transactionScope.clearValue(ValueKeys.SELECTED_CUSTOMER); //BZ24877
        CawCustomerHelper.getInstance().resetSelectedCustomer();//BZ27339
        _customerUIHelper.updateCustInfoDisplayMessage(null);
        _transactionScope
                .setValue(CawValueKeys.AR_ACCOUNT_BALANCE, BigDecimal.ZERO);
        _transactionScope
                .setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, false);
        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(RETAIL_SALE);

        if (retailTrans != null) {
            retailTrans.setCustomerParty(null);
            retailTrans.setLoyaltyCard(null);
            retailTrans.setTaxExemption(null);

            logger_.info("The customer/party has been disassociated from the transaction");
        }

        /* START BZ 23580 */
        IRetailTransaction retailSale = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        ISaleReturnLineItem lineItem = null;
        int size = 0;

        if (retailSale != null) {
            List<IRetailTransactionLineItem> listLineItems = retailSale
                    .getRetailTransactionLineItems();
            size = listLineItems.size();

            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    if (listLineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) listLineItems.get(i);
                        if (isGoodSamItem(lineItem.getItemId())) {
                            lineItem.setVoid(Boolean.TRUE);
                        }
                        /* BEGIN BZ32142 */
                        else if (lineItem instanceof IWarrantyLineItem) {
                            _warrantyHelper
                                    .setWarrantyPrice((IWarrantyLineItem) lineItem, lineItem.getRegularBasePrice());
                        }
                        /* END BZ32142 */
                        else {
                            lineItem.setPreDealAmount(lineItem
                                    .getRegularBasePrice()); // BZ 24509
                        }
                    }
                }
            }
        }
        /* END BZ 23580 */

        _loyaltyMgr.setCurrentCard(null);
        _orderMgr.clear();

        _modeProvider.get().getStationModel().getMenuModel().refreshMenu();

        return HELPER.completeResponse();
    }

    private boolean isGoodSamItem(String itemId) {

        if (_membershipHelper.getMembershipActivity(itemId) == null) {
            return false;
        } else {
            return true;
        }
    }
}
