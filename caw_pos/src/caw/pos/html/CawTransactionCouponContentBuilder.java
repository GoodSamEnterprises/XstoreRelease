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
 * BZ49801          040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ53186          281022    [Internal] Green check mark should display in the applied column on Offers tab when offer is applied.
 * BZ53626          181122    [UAT] After voiding loyalty offer, offers tab still shows offer as applied.
 *===================================================================
 */

package caw.pos.html;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.*;

import javax.inject.Inject;


import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.coupon.CawCouponLineWrapper;
import twitter4j.*;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.html.TransactionCouponContentBuilder;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawTransactionCouponContentBuilder extends TransactionCouponContentBuilder{

    @Inject
    private TransactionScope _transactionScope;
    
    @Override
    protected List<? extends Object> retrieveResultData() {
        List<CawCouponLineWrapper> coupons = (List<CawCouponLineWrapper>) super.retrieveResultData();
        int numberLineApplyOffer = 0; //BZ53626
        //START BZ49801
        String loyaltyLookupJson = CawCatalystHelper.getLookupLoyaltyResponseData();
        if(!StringUtils.isEmpty(loyaltyLookupJson)) {
            try {
                JSONObject result = CawJSONUtils.toJSONObject(loyaltyLookupJson);
                if(result != null && result.has(CawJSONConstant.JSON_PROMOS) && !result.isNull(CawJSONConstant.JSON_PROMOS)) {//BZ61159
                    JSONArray promosJson = result.getJSONArray(CawJSONConstant.JSON_PROMOS);
                    if(promosJson != null && promosJson.length() > 0) {
                        JSONObject promoJsonOb = null;
                        CawCouponLineWrapper cawCouponLineWrapper = null;
                        for (int i = 0;i<promosJson.length(); i++) {
                            promoJsonOb = promosJson.getJSONObject(i);
                            cawCouponLineWrapper =  new CawCouponLineWrapper(null);
                            if(!promoJsonOb.isNull(CawJSONConstant.OFFER_CODE)) {
                                cawCouponLineWrapper.setPromoCode(promoJsonOb.getString(CawJSONConstant.OFFER_CODE));
                            }
                            if(!promoJsonOb.isNull(CawJSONConstant.OFFER_LABEL)) {
                                cawCouponLineWrapper.setPromoCodeLabel(promoJsonOb.getString(CawJSONConstant.OFFER_LABEL));
                            }
                            //BEGIN BZ53186
                            IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
                            if (trans!=null) {
                                List<String> listOfferApplied = new ArrayList<>();
                                List<ISaleReturnLineItem> saleReturnLines = trans.getLineItems(ISaleReturnLineItem.class);
                                for(ISaleReturnLineItem line: saleReturnLines) {
                                    for(IRetailPriceModifier mod:line.getRetailPriceModifiers()) {
                                        if(!mod.getVoid() && !line.getVoid()) {
                                            numberLineApplyOffer++; //BZ53626 - check number of lines applying this offer
                                            listOfferApplied.add(mod.getStringProperty("IS_PROMO"));
                                        } 
                                    }
                                }
                                //BEGIN BZ53626
                                if(!promoJsonOb.isNull(CawJSONConstant.OFFER_CODE) 
                                        && listOfferApplied.contains(promoJsonOb.getString(CawJSONConstant.OFFER_CODE))
                                        && numberLineApplyOffer > 0) { //if offer apply still have modify line, return true, display check mark
                                    cawCouponLineWrapper.setApplied(true);
                                    numberLineApplyOffer = 0;
                                } else {
                                    cawCouponLineWrapper.setApplied(false); 
                                }
                                //END BZ53626
                            }
                            //END BZ53186
                            if(!StringUtils.isEmpty(cawCouponLineWrapper.getPromoCode()) && !StringUtils.isEmpty(cawCouponLineWrapper.getPromoCodeLabel())) {
                                coupons.add(cawCouponLineWrapper);
                            }
                        }
                    }
                }

            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
      //END BZ49801
        return coupons;
    }
}
