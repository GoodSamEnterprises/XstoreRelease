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
 * BZ24098          191017    Missing club pricing/regular price/return price for item when performing transaction 
 *                            with cash tender which total transaction is over $10000.00
 * BZ24568          221117    Unit Price does not update in POS Sale screen after club member is added to a transaction
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ32142          250719    [Xstore] Warranty items not pricing correctly when customer added
 *===================================================================
 */

package caw.pos.customer;

import java.util.List;

import javax.inject.Inject;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.TransactionType;
import dtv.pos.customer.AddCustToTransactionOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.IWarrantyHelper;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.*;

/**
 *  Extends base class for updating customer information from EBS
 */
public class CawAddCustToTransactionOp extends AddCustToTransactionOp {

    @Inject
    private IWarrantyHelper _warrantyHelper;/*BZ32142*/

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IParty party = null;
        if (_transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER) != null) {
            party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        } else {
            party = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            //Begin BZ25115
            if (party != null) {
                _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, party);
            }
            //End BZ25115
        }
        boolean runTaxExemptChain = false;
        if (party != null && !party.getVoid()) {
            IRetailTransaction trans = this.getTransaction();
            if (trans.getCustomerParty() == null) {
                runTaxExemptChain = true;
            }

            trans.setCustomerParty(party);

            // Begin BZ24568
            IRetailTransaction retailSale = _transactionScope
                    .getTransaction(TransactionType.RETAIL_SALE);
            if (retailSale != null) {
                List<IRetailTransactionLineItem> listLineItems = retailSale
                        .getRetailTransactionLineItems();
                if (listLineItems != null && listLineItems.size() > 0) {
                    ISaleReturnLineItem lineItem = null;
                    PriceContext itemPrice = null;
                    for (int i = 0; i < listLineItems.size(); i++) {
                        if (listLineItems
                                .get(i) instanceof ISaleReturnLineItem) {
                            lineItem = (ISaleReturnLineItem) listLineItems
                                    .get(i);
                            if (lineItem.getItemId() != null) {
                                itemPrice = PriceProvider
                                        .getActualPrice(lineItem.getItemId());
                                /* BEGIN BZ32142 */
                                if (itemPrice != null && lineItem instanceof IWarrantyLineItem) {
                                    _warrantyHelper
                                            .setWarrantyPrice((IWarrantyLineItem) lineItem, itemPrice.getPrice());
                                } else if (itemPrice != null) {
                                    lineItem.setPreDealAmount(itemPrice.getPrice());
                                }
                                /* END BZ32142 */
                            }
                        }
                    }
                }
            }
            // End BZ24568
        }

        if (runTaxExemptChain) {
            return this.HELPER.getCompleteStackChainResponse(OpChainKey
                    .valueOf("APPLY_CUST_TAX_EXEMPT"));
        } else {
            this.setOpState((IOpState) null);
            return this.HELPER.completeResponse();
        }
    }
}