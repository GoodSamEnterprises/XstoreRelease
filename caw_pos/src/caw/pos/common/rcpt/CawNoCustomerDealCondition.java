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
 * BZ24817          131217    [Xstore] Enable the ability to sell not on file items
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.itm.IItemOptions;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Determines whether trigger customer deal run or not
 */
public class CawNoCustomerDealCondition extends AbstractInvertableCondition {

    private static final String NON_PHYSICAL = "NON_PHYSICAL";

    private static final String NOT_ON_FILE  = "NOT_ON_FILE";

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

        /* BEGIN BZ 24462 */
        if (item.getItem() != null && item.getItem().getItemTypeCode() != null
                && item.getItem().getItemTypeCode()
                        .equalsIgnoreCase(NON_PHYSICAL)) {
            return false;
        }
        if (item.getItem() != null && item.getItem().getItemTypeCode() != null
                && item.getItem().getItemTypeCode()
                        .equalsIgnoreCase(NOT_ON_FILE)) {
            return false;
        }
        if (item.getItem() != null
                && item.getItem().getOptions().getPromptForPrice()) {
            return false;
        }

        BigDecimal extPrice = item.getBaseUnitPrice(); // BZ24345
        if (extPrice.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        for (IItemOptions itemoption : item.getItem().getItemOptions()) {
            if (itemoption.getPromptForPrice()) {
                return false;
            }
        }
        return true;
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
                if (saleLineItem.getItem() != null
                        && saleLineItem.getItem().getItemTypeCode() != null
                        && saleLineItem.getItem().getItemTypeCode()
                                .equalsIgnoreCase(NON_PHYSICAL)) {
                    return false;
                }
                if (saleLineItem.getItem() != null
                        && saleLineItem.getItem().getItemTypeCode() != null
                        && saleLineItem.getItem().getItemTypeCode()
                                .equalsIgnoreCase(NOT_ON_FILE)) {
                    return false;
                }
                if (saleLineItem.getItem() != null && saleLineItem.getItem()
                        .getOptions().getPromptForPrice()) {
                    return false;
                }

                extPrice = saleLineItem.getBaseUnitPrice(); // BZ24345
                if (extPrice.compareTo(BigDecimal.ZERO) < 0) {
                    return false;
                }
                for (IItemOptions itemoption : saleLineItem.getItem()
                        .getItemOptions()) {
                    if (itemoption.getPromptForPrice()) {
                        return false;
                    }
                }
                basePrice = saleLineItem.getRegularBasePrice();
                if (extPrice.compareTo(basePrice) != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
