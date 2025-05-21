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
 * BZ32239          290719    [INTERNAL] Response message return error when return transactin that have serialized coupons
 * BZ49907          120522    [Internal] - Description line of promos/reward has been applied showing incorrectly at Return transaction
 * BZ50121          260522    [Internal] - Description line of promos applied is showing incorrectly after applying reward to Sale transaction.
 *===================================================================
 */

package caw.pos.register.returns.verification;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.cheetah.util.CawCheetahHelper;

import dtv.data2.access.DataPropertyUtils;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.verification.UpdateReturnPriceModsOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawUpdateReturnPriceModsOp extends UpdateReturnPriceModsOp {

    private static final Logger logger_ = LogManager.getLogger(CawUpdateReturnPriceModsOp.class);

    /*
     * Extended to handle Price Modifier Property values.
     * @see
     * dtv.pos.register.returns.verification.UpdateReturnPriceModsOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOpResponse response = super.handleOpExec(argEvent);
        ISaleReturnLineItem oldLineItem = getScopedValue(ValueKeys.ORIGINAL_SALE_LINE);
        ISaleReturnLineItem newLineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);

        if (newLineItem != null && oldLineItem != null) {
            List<IRetailPriceModifier> oldPriceMods = oldLineItem
                    .getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.DEAL.getName());
            List<IRetailPriceModifier> newPriceMods = newLineItem
                    .getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.DEAL.getName());

            // Copy the price modifier property from old line to new line
            if (CollectionUtils.isNotEmpty(oldPriceMods) && CollectionUtils.isNotEmpty(newPriceMods)) {
                newPriceMods.stream().forEach(newPriceMod -> {
                    oldPriceMods.stream().forEach(oldPriceMod -> {
                        if (StringUtils.equals(oldPriceMod.getSerialNumber(), newPriceMod.getSerialNumber())) {
                            copyPriceModifierProperty(oldPriceMod.getProperties(), newPriceMod);
                        }
                    });
                });
            }
            
            updateLoyaltyDiscountDesctiption(newLineItem, oldLineItem);//BZ49907

        } else {
            logger_.error("Error in handleOpExec - 0: newLineItem or oldLineItem is null");
        }
        return response;
    }

    /**
     * @param argNewLineItem
     * @param argOldLineItem
     */
    //BEGIN BZ49907
    private void updateLoyaltyDiscountDesctiption(ISaleReturnLineItem argNewLineItem, ISaleReturnLineItem argOldLineItem) {

        List<IRetailPriceModifier> newLineItemPriceMods = argNewLineItem
                .getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
        List<IRetailPriceModifier> oldLineItemPriceMods = argOldLineItem
                .getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
        
        for (IRetailPriceModifier newLine : newLineItemPriceMods) {
            outOldLines:
            for (IRetailPriceModifier oldLine : oldLineItemPriceMods) {
                if (oldLine.getRetailPriceModifierSequenceNbr() == newLine.getRetailPriceModifierSequenceNbr()) {
                    List<IRetailPriceModifierProperty> oldProperties = oldLine.getProperties();
                    for (IRetailPriceModifierProperty property : oldProperties) {
                        if ("IS_LOYALTY_MODIFIER".equalsIgnoreCase(property.getPropertyCode())) {
                            if ("TRUE".equalsIgnoreCase(property.getStringValue())) {
                                /*BEGIN BZ50121*/
                                IDiscount discountClone = CawCheetahHelper.getInstance().cloneDiscount(newLine.getDiscount());
                                ((IDataModelImpl) discountClone).getDAO().setObjectState(DaoState.CLEAN.intVal());
                                newLine.setDiscount(discountClone);
                                /*END BZ50121*/
                                newLine.getDiscount().setDescription(newLine.getDisplayDescription());
                                break outOldLines;
                            }
                        }

                    }
                }

            }

        }
    }
    //END BZ49907
    /**
     * Copy the price modifier property from old line to new line
     * 
     * @param oldPriceModProp
     * @param newPriceMods
     */
    protected void copyPriceModifierProperty(List<IRetailPriceModifierProperty> oldPriceModProps,
            IRetailPriceModifier newPriceMod) {

        if (CollectionUtils.isNotEmpty(oldPriceModProps)) {
            oldPriceModProps.stream().forEach(oldPriceModProp -> {
                DataPropertyUtils.setPropertyValue(newPriceMod, oldPriceModProp.getPropertyCode(), oldPriceModProp
                        .getDecimalValue().negate());
            });
        }
    }
}
