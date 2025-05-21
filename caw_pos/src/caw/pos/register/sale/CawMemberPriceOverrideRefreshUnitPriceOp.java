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
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ25921          180418    [25115] Unit price is updated on Xstore after pressing 'Member Price Override' button when doing return trans
 * BZ32142          250719    [Xstore] Warranty items not pricing correctly when customer added
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.common.AbstractCreateTransactionAsNeededOp;
import dtv.pos.common.TransactionType;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.warranty.IWarrantyHelper;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawMemberPriceOverrideRefreshUnitPriceOp
        extends AbstractCreateTransactionAsNeededOp<IRetailTransaction> {

    private static final Logger _logger = LogManager
            .getLogger(CawMemberPriceOverrideRefreshUnitPriceOp.class);

    @Inject
    private IWarrantyHelper     _warrantyHelper;                       /* BZ32142 */
    
    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            IRetailTransaction retailSale = _transactionScope
                    .getTransaction(TransactionType.RETAIL_SALE);
            if (retailSale != null) {
                // Get list the current Item of transaction
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

                            //Check item is return
                            if (!lineItem.getReturn() //BZ25921
                                    && lineItem.getItemId() != null) {
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
        } catch (Exception ex) {
            _logger.error("Can not refresh unit price when used the function Member Price Override."
                    + ex.getMessage());
        }

        return this.HELPER.completeResponse();
    }

}
