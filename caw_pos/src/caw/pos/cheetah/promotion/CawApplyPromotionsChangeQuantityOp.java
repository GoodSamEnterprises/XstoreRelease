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
 * BZ53977          011222    [UAT] Xstore is discounting Loyalty offer more than maximum offer amount  
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawAdvancePromptingHelper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.register.type.LineItemType;
import dtv.util.StringUtils;
import dtv.xst.dao.dsc.DiscountId;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawApplyPromotionsChangeQuantityOp extends Operation {

    @Inject
    protected StationState      stationState;

    @Override
    public boolean isOperationApplicable() {

        List<CawPromotionModel> promotions = _transactionScope.getValue(CawValueKeys.CAW_PROMOTIONS_SELECTED);
        return promotions != null && promotions.size() > 0;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        List<CawPromotionModel> promotions = _transactionScope.getValue(CawValueKeys.CAW_PROMOTIONS_SELECTED);
        Iterator<CawPromotionModel> iterPromotions = promotions.iterator();
        while (iterPromotions.hasNext()) {
            CawPromotionModel promotion = iterPromotions.next();
            applyPromo(promotion);
        }
        return HELPER.completeResponse(); 
    }

    private void applyPromo(CawPromotionModel promotion) {

        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        Iterator<ISaleReturnLineItem> iterSaleReturnLines = saleReturnLines.iterator();
        String listLoyaltyDiscountReasonCode = promotion.getEbsCouponCode();
        int lineNumber = 0;
        while (iterSaleReturnLines.hasNext()) {
            ISaleReturnLineItem saleReturnLine = iterSaleReturnLines.next();
            if (!saleReturnLine.getVoid()) {
                lineNumber++;
                //build correlationKey for line item
                String correlationKey = CawAdvancePromptingHelper.getInstance().getCorrelationKey(_transaction, stationState);
                if (!correlationKey.equals(CawJSONConstant.NULL)) {
                    correlationKey = correlationKey + ":" + String.valueOf(lineNumber);
                }
                JSONArray claimItemAllocations = promotion.getPromoOfferClaimAllocations();
                if (claimItemAllocations != null && claimItemAllocations.length() > 0) {
                    for (int index = 0; index < claimItemAllocations.length(); index++) {
                        JSONObject claimItemAllocation = CawJSONUtils.getJSONObject(claimItemAllocations, index);
                        //get claimItemCorrelationkey response from API
                        String claimItemCorrelationkey = CawJSONUtils.getString(claimItemAllocation, CawJSONConstant.JSON_ITEM_CORRELATION_KEY);
                        //compare claimItemCorrelationkey vs correlationKey
                        // build Discount then add to transaction line item
                        if (!StringUtils.isEmpty(claimItemCorrelationkey) && claimItemCorrelationkey.equalsIgnoreCase(correlationKey)) {
                            String lineTotalAdjustment = CawJSONUtils.getString(claimItemAllocation, CawJSONConstant.JSON_LINE_TOTAL_ADJUSTMENT);
                            DiscountId discountId = new DiscountId();
                            discountId.setOrganizationId(saleReturnLine.getOrganizationId());
                            discountId.setDiscountCode("LOYALTY_ITEM_AMT_PROMPT"); 
                            
                            IDiscount discount = DataFactory.getObjectByIdNoThrow(discountId);
                            discount = CawCheetahHelper.getInstance().cloneDiscount(discount);
                            discount.setApplicationMethodCode("LINE_ITEM");
                            discount.setDescription(promotion.getPromoCodeLabel());
                            discount.setCalculationMethodCode("PROMPT_AMOUNT");
                            ((IDataModelImpl) discount).getDAO().setObjectState(DaoState.CLEAN.intVal());
                            
                            //create PriceModifier object
                            IRetailPriceModifier priceModifier = DataFactory.createObject(IRetailPriceModifier.class);                           
    
                            //amount response from API is negative so need to negate it.
                            BigDecimal amountDiscount = new BigDecimal(lineTotalAdjustment).negate();
                            amountDiscount = amountDiscount.divide(saleReturnLine.getQuantity(), 6, RoundingMode.HALF_UP);
                            priceModifier.setAmount(amountDiscount);
                            
                            priceModifier.setDiscount(discount);
                            priceModifier.setDescription(discount.getDescription());
                            
                            if (listLoyaltyDiscountReasonCode != null) {
                                priceModifier.setDiscountReasonCode(listLoyaltyDiscountReasonCode);
                            }
                            
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_LOYALTY_MODIFIER", "TRUE");
                            
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_PROMO", promotion.getPromoCode());
    
                            saleReturnLine.addRetailPriceModifier(priceModifier);
                        }
                    }
                }
            }
        }
    }
}
