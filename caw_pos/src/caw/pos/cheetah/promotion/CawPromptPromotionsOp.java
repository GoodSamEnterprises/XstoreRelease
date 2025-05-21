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
 * BZ48691          210222    [Task][Offline Loyalty Capability] Xstore is not allowed to apply loyalty program during Sale/Return transaction. 
 * BZ49442          270422    [Internal] - The message offline shows in case the customer is not available non-point promotions
 * BZ49706          280422    [Internal] - The 'Points Redemption' prompt is displaying without value when reward is null.
 * BZ49893          130522    [Internal] - The message in case the customer is not eligible meets the offer threshold did not show
 * BZ50442          130622    Redemption data missing in request
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
 * BZ53143          261022    [Internal] Xstore should show correctly the prompt when assigning GSAM Club customers without an eligible offer. 
 * BZ54776          120123    Bug 54776 : [Patch 22.0] Extend ability to turn ON/OFF loyalty functionality into xstore to specific stores if needed.
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization
 * BZ62712          210323    [Internal] - Pitches in Retrieve PromoRewards API request and Retrieve Reward API request should be the latest info.
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.agis.op.CawAGISPitchesHelper;
import caw.pos.cheetah.reward.CawRewardModel;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.order.OrderMgr;
import dtv.util.StringUtils;
import dtv.xst.dao.xom.IOrder;
/**
 *
 */
public class CawPromptPromotionsOp extends AbstractListPromptOp {


    private static final Logger               _logger       = LogManager.getLogger(CawPromptPromotionsOp.class);
    private static final int          RESPONSE_SUCCESS_CODE = 200;//BZ48692
    
    private CawCheetahHelper                  _cheetahHelper = CawCheetahHelper.getInstance();
    
    List<CawPromotionModel> promotions;
    
    CawRewardModel  reward;

    boolean havePromoCanApply; //BZ49893
    
    @Inject
    private IBusyState                        _busyState;
    
    @Inject
    private TransactionScope               _transaction;
    
    @Inject
    private OrderMgr            _orderMgr;
    
    @Inject
    protected StationState      stationState;

    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf("SELECT_PROMOTIONS");
    }
    //BEGIN BZ49442
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        try {
            List<CawPromotionModel> promotionsSelected = new ArrayList<CawPromotionModel>();
            
            havePromoCanApply = false; //BZ49893
            
            for(Object ob : argArg0.getDataSet()) {
                if(ob instanceof CawPromotionModel) {                  
                    //BEGIN BZ49893
                    CawPromotionModel promo = (CawPromotionModel) ob;

                    if (promo.getPromoOfferClaimAllocations() != null && promo.getPromoOfferClaimAllocations().length() != 0) {
                        havePromoCanApply = true;
                    }                      
                    promotionsSelected.add(promo);                                     
                }
            }
            
            if(!havePromoCanApply) {
                return this.getEmptyListPromptResponse();
            }
            //END BZ49893 
            
            _transactionScope.setValue(CawValueKeys.CAW_PROMOTIONS_SELECTED, promotionsSelected);
            CawCatalystHelper.setOfferApplyLoyalty(promotionsSelected); //BZ50442
        } catch (Exception ex) {
            _logger.error("[Can't add Promo into item ]: "+ex.getMessage());
 
        }
        return this.HELPER.completeResponse();
    }

    @Override
    protected PromptKey getEmptyListPromptKey() {
        //BEGIN BZ49893
        if(!havePromoCanApply && promotions.size() > 0) {
            return PromptKey.valueOf("CAW_NO_OFFER_CAN_APPLY");
        }
        //END BZ49893
        
        return PromptKey.valueOf("CAW_LOYALTY_OFFLINE_MESSAGE");
    }
    //END BZ49442
    
    //BEGIN BZ49893  
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        if(argEvent instanceof IXstDataAction) {
            IXstDataAction actionKey = (IXstDataAction)argEvent;
            IXstActionKey key = actionKey.getActionKey();
            if("NOT_ELIGIBLE".equalsIgnoreCase(key.toString())
                    || "LOYALTY_OFFLINE".equalsIgnoreCase(key.toString())) {
                return HELPER.completeResponse(); //BZ51471
            }
        }
        return super.handleOpExec(argEvent);
    }
    //END BZ49893  
    
    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {
        _busyState.start(CawConstants.BUSY_STATE_MSG);
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        promotions = new ArrayList<CawPromotionModel>();
        if (_transaction.getTransaction() != null) {
            /* BEGIN BZ54776 */
            ResponseEntity<String> result = null;
            if (CawCheetahHelper.isEnableLoyalty()) {
                //BEGIN BZ62712
                String pitchesUpdatedJson = CawAGISPitchesHelper.getInstance().updatePitchesFormResponseForOffer(_transaction, CawCatalystHelper.getLookupResponseData());
                CawCatalystHelper.setLookupResponseData(pitchesUpdatedJson);
                //END BZ62712
               
            	/* BEGIN BZ59418 */
            	String loyaltyFreeTierSKU = _transaction.getValue(CawValueKeys.CAW_LOYALTY_FREE_TIER_SKU);
                result = _cheetahHelper.callRetrievePromoRewardsAPI(_transaction.getTransaction(),stationState, currentOrder, loyaltyFreeTierSKU);
                /* END BZ59418 */
            }  
            /* END BZ54776 */
            
            //BEGIN BZ48564: ENABLE TO USE MOCKUP
            String body = StringUtils.EMPTY;
            try {
                
                if (Files.exists(Paths.get("/opt/xstore/mockupResponse/Member_Retrieve_PromoRewards_response.txt"))) {
                    
                    body = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/Member_Retrieve_PromoRewards_response.txt")));
                    promotions = _cheetahHelper.parseResponseToPromotions(body);
                    //BEGIN BZ49893
                    JSONObject bodyJson = CawJSONUtils.toJSONObject(body);
                    JSONObject resultJson = CawJSONUtils.getJSONObject(bodyJson, CawJSONConstant.JSON_RESULT);
                    
                    if (((resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS) && resultJson.isNull(CawJSONConstant.JSON_PROMO_OFFERS)) 
                            ||(resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS) && resultJson.getJSONArray(CawJSONConstant.JSON_PROMO_OFFERS).length() == 0)  //BZ49706 
                            ||!resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS)) ) {
                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_OFFER_NOT_AVAILABLE")); //BZ51471,BZ53143
                    }
                    //END BZ49893 
                    if (promotions.size() == 0) {
                        //Begin BZ49706
                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_OFFER_NOT_AVAILABLE")); //BZ51471,BZ53143
                        //End BZ49706
                    }
                }

            } catch (IOException | JSONException ex) {
                _logger.error("[Can't read the promoReward mockup: ]"+ex.getMessage());
            }
            //END BZ48564: ENABLE TO USE MOCKUP
            if(StringUtils.isEmpty(body)) {
                if (result != null && result.getStatusCode() == HttpStatus.OK && _cheetahHelper.getResultCodeFromEBS(result)==RESPONSE_SUCCESS_CODE) {//BZ48692
                    promotions = _cheetahHelper.parseResponseToPromotions(result.getBody());
                    //BEGIN BZ49893                    
                    try {
                        JSONObject resultJson = CawJSONUtils.toJSONObject(result.getBody());
                        if(resultJson.has(CawJSONConstant.JSON_RESULT)
                               && !resultJson.isNull(CawJSONConstant.JSON_RESULT)) {
                            resultJson = resultJson.getJSONObject(CawJSONConstant.JSON_RESULT);
                        }
                        
                        if (((resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS) && resultJson.isNull(CawJSONConstant.JSON_PROMO_OFFERS))
                                || (resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS) && resultJson.getJSONArray(CawJSONConstant.JSON_PROMO_OFFERS).length() == 0)  //BZ49706 
                                || !resultJson.has(CawJSONConstant.JSON_PROMO_OFFERS))) {
                            return HELPER.getPromptResponse(PromptKey.valueOf("CAW_OFFER_NOT_AVAILABLE")); //BZ51471,BZ53143
                        }
                    } catch (JSONException ex) {
                        _logger.error("can't parse jsonObject to promotion model: " + ex.getMessage());
                    }
                    //END BZ49893 
                    if (promotions.size() == 0) {
                        //Begin BZ49706
                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_OFFER_NOT_AVAILABLE")); //BZ51471,BZ53143
                        //End BZ49706
                    }
                }
            }
        }
        _busyState.end();
        return super.getPromptResponse(argEvent, argPromptKey, argPromptArgs);
    }
    @Override
    protected Object[] getPromptList(IXstEvent argArg0) {
        return promotions.toArray();
    }
}
