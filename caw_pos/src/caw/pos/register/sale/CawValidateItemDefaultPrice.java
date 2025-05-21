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
 * BZ25590          200318    New Requirement - Default price if club pricing does not exist
 *===================================================================
 */

package caw.pos.register.sale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dtv.pos.iframework.hardware.IHardwareType;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.IItemOptions;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;

/**
 *
 */
public class CawValidateItemDefaultPrice extends AbstractValidationRule {

    private static final Logger _logger = LogManager
            .getLogger(CawValidateItemDefaultPrice.class);

    /* Check if item has regular price or not
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        try {
            IItem currentItem = getScopedValue(ValueKeys.CURRENT_ITEM);

            IHardwareType<?> entryMethod = getScopedValue(ValueKeys.VALUE_ENTRY_METHOD);

            if (currentItem != null && entryMethod != null) {
                ISaleReturnLineItem detailCurrentItem = ItemLocator.getLocator()
                        .getSaleLineItem(currentItem, getSaleItemType(), entryMethod);

                if (detailCurrentItem != null) {
                    IItemOptions itemOption = detailCurrentItem.getItem()
                            .getOptions();
                    String pricePropertyCode = detailCurrentItem
                            .getPricePropertyCode();

                    if (itemOption != null && !itemOption.getPromptForPrice()) {

                        if (pricePropertyCode == null) {
                            return SimpleValidationResult.getFailed(FF
                                    .getTranslatable("_itemHasNoPrice"));
                        }
                    }
                }

            }
        } catch (Exception ex) {
            _logger.error("Can not check item's price" + ex.getMessage());
        }
        return IValidationResult.SUCCESS;
    }

    /**
     * 
     * @return
     */
    protected SaleItemType getSaleItemType() {

        return SaleItemType.SALE;
    }

}