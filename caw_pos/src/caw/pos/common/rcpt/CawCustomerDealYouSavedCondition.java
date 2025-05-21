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
 * BZ23607          031017    CWS Receipts Requires Printing of Regular and Club Pricing for Items
 * BZ24268          011117    Club Pricing does not print on receipts if other discounts are applied to item or transaction
 * BZ24345          031117    Regular price/return price should be removed out receipt when doing trans with item has change quantity 
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Determines whether trigger customer deal run or not
 */
public class CawCustomerDealYouSavedCondition
        extends AbstractInvertableCondition {

    /**
     * Checking the condition to show/hide the customer Deal detail/Member savings
     *
     * @return true if the condition is met, else return false
     */
    @Override
    protected boolean conditionMetImpl(Object argModel) {

        if (argModel instanceof ISaleReturnLineItem) {
            return checkCondition((ISaleReturnLineItem) argModel);
        } else if (argModel instanceof IRetailTransaction) {
            return checkCondition((IRetailTransaction) argModel);
        }
        return false;

    }

    /**
     * Checking the condition to show/hide the customer Deal detail
     *
     * @return true if the condition is met, else return false
     */
    private boolean checkCondition(ISaleReturnLineItem item) {

        BigDecimal extPrice = item.getBaseUnitPrice(); // BZ24345
        BigDecimal basePrice = item.getRegularBasePrice();
        // BZ24268 - remove checking discount transaction
        /* boolean hasModifyPrice = false;
        for (IRetailPriceModifier modifier : item.getRetailPriceModifiers()) {
            if (item.getItemId().equals(modifier.getItemId())
                    && modifier.getExtendedAmount()
                            .compareTo(BigDecimal.ZERO) != 0
                    && modifier.getAmount().compareTo(BigDecimal.ZERO) != 0) {
                hasModifyPrice = true;
                break;
            }
        }*/
        return extPrice.compareTo(basePrice) != 0;
    }

    /**
    * Checking the condition to show/hide the text Total Member savings
    *
    * @return true if the condition is met, else return false
    */
    private boolean checkCondition(IRetailTransaction trans) {

        List<ISaleReturnLineItem> lineItems = trans
                .getLineItems(ISaleReturnLineItem.class);
        if (lineItems != null) {
            BigDecimal extPrice = null;
            BigDecimal basePrice = null;
            for (ISaleReturnLineItem saleLineItem : lineItems) {
                // Begin BZ24268
                extPrice = saleLineItem.getBaseUnitPrice(); // BZ24345
                basePrice = saleLineItem.getRegularBasePrice();
                if (extPrice.compareTo(basePrice) != 0) {
                    return true;
                }
                // End BZ24268
                // BZ24268 - remove checking discount transaction
                /*if (saleLineItem.getRetailPriceModifiers().size() > 0) {
                    for (IRetailPriceModifier modifier : saleLineItem
                            .getRetailPriceModifiers()) {
                
                        BigDecimal addAmount = BigDecimal.ZERO;
                
                        if (modifier.getExtendedAmount() != null) {
                            addAmount = modifier.getExtendedAmount();
                        } else if (modifier.getAmount() != null) {
                            addAmount = modifier.getAmount();
                        }
                
                        if (addAmount.compareTo(BigDecimal.ZERO) == 0) {
                            BigDecimal extPrice = saleLineItem
                                    .getBaseExtendedPrice();
                            BigDecimal basePrice = saleLineItem
                                    .getRegularBasePrice();
                            if (extPrice.compareTo(basePrice) != 0) {
                                return true;
                            }
                        }
                    }
                } else {
                    BigDecimal extPrice = saleLineItem.getBaseExtendedPrice();
                    BigDecimal basePrice = saleLineItem.getRegularBasePrice();
                    if (extPrice.compareTo(basePrice) != 0) {
                        return true;
                    }
                }*/
            }
        }
        return false;
    }
}
