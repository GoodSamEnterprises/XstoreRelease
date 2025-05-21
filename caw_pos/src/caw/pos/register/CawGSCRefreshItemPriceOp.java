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
 * BZ26419          050918   [PROD] Cannot return warranty when the covered item is returned
 * BZ26715          110918   [PROD] Tax Codes not flowing to Oracle
 * BZ32142          250719   [Xstore] Warranty items not pricing correctly when customer added
 *===================================================================
 */

package caw.pos.register;

import java.util.List;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawMembershipActivityHelper;
import caw.pos.common.CawConstants;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.warranty.IWarrantyHelper;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.trl.*;

/**
 *This class is used to refresh price after joining club membership
 */
public class CawGSCRefreshItemPriceOp extends Operation {

    @Inject
    private CawMembershipActivityHelper _membershipHelper;

    @Inject
    private IWarrantyHelper             _warrantyHelper;  /*BZ32142*/
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        PriceContext itemPrice = null;
        ISaleReturnLineItem lineItem = null;
        //this condition with line item need to be different Good Sam Item and not void.
        if (retailTrans != null
                && retailTrans.getRetailTransactionLineItems() != null) {
            List<IRetailTransactionLineItem> listLineItems = retailTrans
                    .getRetailTransactionLineItems();
            int size = listLineItems.size();
            for (int i = 0; i < size; i++) {
                if (listLineItems.get(i) instanceof ISaleReturnLineItem) {
                    lineItem = (ISaleReturnLineItem) listLineItems.get(i);
                    if (lineItem.getItemId() != null
                            && !isGoodSamItem(lineItem.getItemId())
                            && !lineItem.getVoid()
                            && !lineItem.getReturn()) {
                        itemPrice = PriceProvider
                                .getActualPrice(lineItem.getItemId());
                        /* BEGIN BZ32142 */
                        if (itemPrice != null && lineItem instanceof IWarrantyLineItem) {
                            _warrantyHelper.setWarrantyPrice((IWarrantyLineItem) lineItem, itemPrice.getPrice());
                        } else if (itemPrice != null) {
                            lineItem.setPreDealAmount(itemPrice.getPrice());
                        }
                        /* END BZ32142 */
                    }
                }
            }
        }
        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction retailTrans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);

        if (retailTrans != null
                && retailTrans.getRetailTransactionLineItems() != null) {
            List<IRetailTransactionLineItem> listLineItems = retailTrans
                    .getRetailTransactionLineItems();
            int size = listLineItems.size();

            for (int i = 0; i < size; i++) {
                if (listLineItems.get(i) instanceof ISaleReturnLineItem
                        && isGoodSamItem(((ISaleReturnLineItem) listLineItems
                                .get(i)).getItemId())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * method check item is Good Sam or not
     * @param itemId
     * @return
     */
    private boolean isGoodSamItem(String itemId) {

        if (_membershipHelper.getMembershipActivity(itemId) == null) {
            return false;
        } else {
            return true;
        }
    }

    //Begin BZ26715
    /**
     * method is showing taskbar 
     */
    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
    //End BZ26715
}
