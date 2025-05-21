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
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction
 * BZ49907          120522    [Internal] - Description line of promos/reward has been applied showing incorrectly at Return transaction
 * BZ49933          120522    Loyalty - Define a default reason code for Loyalty promotions that are applied to transaction
 * BZ49955          120522    [Internal] Loyalty - Item Discount: $ Off displays incorrectly if the previous transaction redeemed the loyalty reward
 * BZ50121          260522    [Internal] - Description line of promos applied is showing incorrectly after applying reward to Sale transaction.
 * BZ51922          260822    [UAT] Padding issue with the correlation key
 * BZ52837          171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
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
import dtv.util.StringUtils;
import dtv.xst.dao.dsc.DiscountId;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawApplyPromotionsOp extends Operation {

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
        //_transactionScope.clearValue(CawValueKeys.CAW_PROMOTIONS_SELECTED); //BZ53977 remove this line
        return HELPER.completeResponse(); //BZ51471
    }

    private void applyPromo(CawPromotionModel promotion) {

        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItems(ISaleReturnLineItem.class);
        Iterator<ISaleReturnLineItem> iterSaleReturnLines = saleReturnLines.iterator();
        //BEGIN BZ49933, BZ52837
        String listLoyaltyDiscountReasonCode = promotion.getEbsCouponCode();
        //END BZ49933, BZ52837
        int lineNumber = 0;
        while (iterSaleReturnLines.hasNext()) {
            ISaleReturnLineItem saleReturnLine = iterSaleReturnLines.next();
            if (!saleReturnLine.getVoid()) {
                lineNumber++;
                //build correlationKey for line item
                String correlationKey = CawAdvancePromptingHelper.getInstance().getCorrelationKey(_transaction, stationState);
                if (!correlationKey.equals(CawJSONConstant.NULL)) {
                    correlationKey = correlationKey + ":" + String.valueOf(lineNumber);//BZ51922
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
                            discountId.setDiscountCode("LOYALTY_ITEM_AMT_PROMPT"); //BZ49955
                            
                            IDiscount discount = DataFactory.getObjectByIdNoThrow(discountId);
                            discount = CawCheetahHelper.getInstance().cloneDiscount(discount);/*BZ50121*/
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
                            priceModifier.setDescription(discount.getDescription());//BZ49907
                            
                            //BEGIN BZ49933,BZ52837
                            if (listLoyaltyDiscountReasonCode != null) {
                                priceModifier.setDiscountReasonCode(listLoyaltyDiscountReasonCode);
                            }
                            //END BZ49933,BZ52837
                            
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_LOYALTY_MODIFIER", "TRUE");
                            
                            //BEGIN BZ52837
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_PROMO", promotion.getPromoCode());
                            //END BZ52837
                            saleReturnLine.addRetailPriceModifier(priceModifier);
                        }
                    }
                }
            }
        }
    }

}
