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
 * BZ49442          270422    [Internal] - The message offline shows in case the customer is not available non-point promotions
 * BZ49706          280422    [Internal] - The 'Points Redemption' prompt is displaying without value when reward is null.
 * BZ49907          120522    [Internal] - Description line of promos/reward has been applied showing incorrectly at Return transaction
 * BZ49933          120522    Loyalty - Define a default reason code for Loyalty promotions that are applied to transaction
 * BZ49893          130522    [Internal] - The message in case the customer is not eligible meets the offer threshold did not show
 * BZ49955          120522    [Internal] Loyalty - Item Discount: $ Off displays incorrectly if the previous transaction redeemed the loyalty reward
 * BZ49706          280422    [Internal] - The 'Points Redemption' prompt is displaying without value when reward is null.
 * BZ50121          260522    [Internal] - Description line of promos applied is showing incorrectly after applying reward to Sale transaction.
 * BZ50442          130622    Redemption data missing in request
 * BZ51922          260822    [UAT] Padding issue with the correlation key
 * BZ52759          171022    [UAT] Point Redemption prompt does not show correct value of Points Balance
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
 * BZ52838          211022    [UAT] Getting loyalty offline prompt for new customers
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization
 * BZ62712          210323    [Internal] - Pitches in Retrieve PromoRewards API request and Retrieve Reward API request should be the latest info.
 *===================================================================
 */

package caw.pos.cheetah.reward;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawAdvancePromptingHelper;
import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.agis.op.CawAGISPitchesHelper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.util.StringUtils;
import dtv.xst.dao.dsc.DiscountId;
import dtv.xst.dao.dsc.IDiscount;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawPromptRewardOp extends AbstractFormOp<CawRewardModel> {
    private static final Logger              _logger                   = LogManager.getLogger(CawCheetahHelper.class);
    private final FormKey                     CAW_CHEETAH_APPLY_REWARD = FormKey.valueOf("CAW_CHEETAH_APPLY_REWARD");

    private static final int                 RESPONSE_SUCCESS_CODE     = 200;
    private CawCheetahHelper                  _cheetahHelper           = CawCheetahHelper.getInstance();

    @Inject
    private IBusyState                        _busyState;
    
    @Inject
    protected StationState      stationState;
    
    @Inject
    private OrderMgr            _orderMgr;
    
    @Override
    protected CawRewardModel createModel() {
        return  updateModel(callRetrieveRewardAPI()); // BZ52759, BZ51471
    }
    //BEGIN BZ52759
    private CawRewardModel updateModel(CawRewardModel model) {
        try {
            JSONObject json = CawJSONUtils.toJSONObject(CawCatalystHelper.getLookupLoyaltyResponseData());
            if (json != null && !json.isNull(CawJSONConstant.JSON_WO_STATUS) && !json.isNull(CawJSONConstant.JSON_PROMOS)) {
                JSONObject status = CawJSONUtils.getJSONObject(json, CawJSONConstant.JSON_STATUS);
                String value= "";
                if(status.has(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE) && !StringUtils.isEmpty(status.getString(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE))) {
                    value = String.format("%,d",status.getLong(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE));
                    model.setRewardMaxReedemablePointsBalanceLabel(value);
                }
            }
            
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
        }
        return model;
    }
    //END BZ52759
    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        if(_transaction.getAmountDue().compareTo(BigDecimal.ZERO) == 1 || CawWorkOrderOptionsOp.isCompleteAction()) {//BZ54290
            return true;
        }
        return false;
    }
    
    @Override
    protected FormKey getFormKey() {
        return CAW_CHEETAH_APPLY_REWARD;
    }

    //Begin BZ49706
    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argAction) {
        
       if (this.getModel() != null) {
            if (this.getModel().getRewardMaxRedeemableValue() == null 
                    && this.getModel().getRewardMaxReedemablePointsBalance() == null) {
                return HELPER.completeResponse();
            }
            return null;
        }
        else {
            return this.HELPER.getCompletePromptResponse(PromptKey.valueOf("CAW_LOYALTY_OFFLINE_MESSAGE"), new IFormattable[0]);
        }
    }
    //End BZ49706
    
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        if (argEvent != null && argEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if ("REDEEM".equals(key.toString())) {
                JSONArray claimItemAllocations = this.getModel().getRewardClaimAllocations();
                //Begin BZ49893
                if(claimItemAllocations == null || claimItemAllocations.length() == 0) {
                    return HELPER.getPromptResponse(PromptKey.valueOf("CAW_NO_REWARD_CAN_APPLY"));
                }
                //End BZ49893
                CawCatalystHelper.setRewardApplyLoyalty(getModel()); //BZ50442
                applyReward();
                return HELPER.completeResponse();
            }
        }
        return super.handleFormResponse(argEvent);
    }

    private CawRewardModel callRetrieveRewardAPI() {
        _busyState.start(CawConstants.BUSY_STATE_MSG);
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        CawRewardModel rewardModel = null;
        String body = StringUtils.EMPTY;
        //BEGIN BZ48564: ENABLE TO USE MOCKUP
        try {            
            if (Files.exists(Paths.get("/opt/xstore/mockupResponse/Member_Retrieve_Reward_response.txt"))) {
                body = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/Member_Retrieve_Reward_response.txt")));
                rewardModel = _cheetahHelper.parseResponseToReward(body);
            }
            
        } catch (IOException ex) {
            _logger.error("[Can't read the promoReward mockup: ]"+ex.getMessage());
        }
        //END BZ48564: ENABLE TO USE MOCKUP
        //BEGIN BZ49442
        if(StringUtils.isEmpty(body)) {
            //BEGIN BZ62712
            String pitchesUpdatedJson = CawAGISPitchesHelper.getInstance().updatePitchesFormResponse(_transactionScope, CawCatalystHelper.getLookupResponseData());
            CawCatalystHelper.setLookupResponseData(pitchesUpdatedJson);
            //END BZ62712
            
        	/* BEGIN BZ59418 */
            String loyaltyFreeTierSKU = _transactionScope.getValue(CawValueKeys.CAW_LOYALTY_FREE_TIER_SKU);
            ResponseEntity<String> result = _cheetahHelper.callRetrieveRewardAPI(_transactionScope.getTransaction(), stationState, currentOrder, loyaltyFreeTierSKU);
            /* END BZ59418 */
            _busyState.end();
            //BEGIN BZ52838
            if (result != null) {
                if (result.getStatusCode().is2xxSuccessful()) {
                    if(_cheetahHelper.getResultCodeFromEBS(result) == RESPONSE_SUCCESS_CODE) {
                        rewardModel = _cheetahHelper.parseResponseToReward(result.getBody());
                    } else {
                        rewardModel = new CawRewardModel();
                        _logger.error("[Error when retrieve reward] - Error result code: " + _cheetahHelper.getResultCodeFromEBS(result));
                        _logger.error("[Error when retrieve reward] - Error detail: " + _cheetahHelper.getErrorDetailFromEBS(result));
                    }
                } else {
                    _logger.error("[Error when retrieve reward] - Error status code: " + result.getStatusCode().toString());
                }
            }
            //END BZ52838
        }
        //END BZ49442
        return rewardModel;
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {
        IXstDataAction actionKey = argAction;
        IXstActionKey key = actionKey.getActionKey();
        if("NOT_ELIGIBLE".equalsIgnoreCase(key.toString())) {
            return HELPER.completeResponse();
        }

        return super.handleDataAction(argAction);
    }
    //END BZ49893
    
    private void applyReward() {
        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItems(ISaleReturnLineItem.class);
        Iterator<ISaleReturnLineItem> iterSaleReturnLines = saleReturnLines.iterator();
      //BEGIN BZ49933, BZ52837
        String listLoyaltyDiscountReasonCode = this.getModel().getEbsCouponCode();
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
                JSONArray claimItemAllocations = this.getModel().getRewardClaimAllocations();
                if (claimItemAllocations != null && claimItemAllocations.length() > 0) {
                    for (int index = 0; index < claimItemAllocations.length(); index++) {
                        JSONObject claimItemAllocation = CawJSONUtils.getJSONObject(claimItemAllocations, index);
                        //get claimItemCorrelationkey response from API
                        String claimItemCorrelationkey = CawJSONUtils.getString(claimItemAllocation, CawJSONConstant.JSON_ITEM_CORRELATION_KEY);
                        //compare claimItemCorrelationkey vs correlationKey
                        // build Discount then add to transaction line item
                        if (!StringUtils.isEmpty(claimItemCorrelationkey) && claimItemCorrelationkey.equalsIgnoreCase(correlationKey)) {
                            String lineTotalAdjustment = CawJSONUtils.getString(claimItemAllocation, CawJSONConstant.JSON_LINE_TOTAL_ADJUSTMENT);
                            //create Discount object
                            DiscountId discountId = new DiscountId();
                            discountId.setOrganizationId(saleReturnLine.getOrganizationId());
                            discountId.setDiscountCode("LOYALTY_ITEM_AMT_PROMPT");//BZ49955
                            
                            IDiscount discount = DataFactory.getObjectByIdNoThrow(discountId);
                            discount = CawCheetahHelper.getInstance().cloneDiscount(discount);/*BZ50121*/
                            discount.setApplicationMethodCode("LINE_ITEM");
                            discount.setDescription(this.getModel().getRewardHeading());
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
                            //BEGIN BZ49933
                            if (listLoyaltyDiscountReasonCode != null) {
                                priceModifier.setDiscountReasonCode(listLoyaltyDiscountReasonCode);
                            }
                            //END BZ49933
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_LOYALTY_MODIFIER", "TRUE");
                            
                            //BEGIN BZ52837
                            priceModifier.setRetailPriceModifierReasonCode(RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT.getName());
                            priceModifier.setStringProperty("IS_REWARD", this.getModel().getRewardCode());
                            //END BZ52837
                            
                            saleReturnLine.addRetailPriceModifier(priceModifier);
                        }
                    }
                }
            }
        }
    }
}
