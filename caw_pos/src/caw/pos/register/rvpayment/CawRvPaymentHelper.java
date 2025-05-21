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
 * BZ44971          150921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47542          061221    RV Service Payments - Property Names
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.tender.CawTenderConstants;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawRvPaymentHelper {
    
    private static final Logger      _logger                   = LogManager.getLogger(CawRvPaymentHelper.class);
    
    public static boolean isOnlyRvPaymentAmountRemain(IPosTransaction iPosTransaction) {
        boolean result = false;
        
        BigDecimal amoutRemain = iPosTransaction.getTotal().subtract(iPosTransaction.getAmountTendered());
        
        if (amoutRemain.compareTo(getRvAmount(iPosTransaction)) <= 0) {
            result = true;
        }
        
        return result;
    }
    
    private static BigDecimal getRvAmount(IPosTransaction iPosTransaction) {
        List<ISaleReturnLineItem> transLineItems = iPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        BigDecimal rvAmount = BigDecimal.ZERO;
        
        for (ISaleReturnLineItem item : transLineItems) {
            if (!item.getVoid() && isRvPaymentSaleLineItem(item)) {
                rvAmount = rvAmount.add(item.getExtendedAmount());
            }
        }
        
        return rvAmount;
    }
    
    public static BigDecimal getNotRvAmoutRemain (IPosTransaction iPosTransaction) {
        List<ISaleReturnLineItem> transLineItems = iPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        List<ITenderLineItem> transLineTenders = iPosTransaction.getLineItemsByTypeCode(LineItemType.TENDER.getName(), ITenderLineItem.class);
        BigDecimal totalNotRvAmount = calAmountNotRvPaymentItems(iPosTransaction.getTaxAmount(), transLineItems);
        // Total of tender with Coupons/Merchant Certificate/AR Account/Third-party Account
        BigDecimal totalCMATTender = calCMATTenderAmount(transLineTenders); 
        
        BigDecimal notRvAmoutRemain = totalNotRvAmount.subtract(totalCMATTender); 
        
        return notRvAmoutRemain;
    }
    
    private static BigDecimal calAmountNotRvPaymentItems(BigDecimal taxAmount, List<ISaleReturnLineItem> transLineItems) {
        BigDecimal result = taxAmount;
        
        for (ISaleReturnLineItem lineItem : transLineItems) {
            if (!lineItem.getVoid() && !isRvPaymentSaleLineItem(lineItem)) {
                result = result.add(lineItem.getExtendedAmount());
            }
        }
        
        return result;
    }
    
    public static boolean isRvPaymentSaleLineItem(ISaleReturnLineItem lineItem) {
        boolean isRvPaymentSaleLineItem = false;
        
        if (lineItem != null) {
            if (StringUtils.isNotEmpty(lineItem.getStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES))) { //BZ47542
                isRvPaymentSaleLineItem = true;
            }
        }
        return isRvPaymentSaleLineItem;
    }
    
    /* BEGIN BZ47542 */
    @SuppressWarnings("unchecked")
    public static String getRvProperty(String strJson, String property) {
        String result = StringUtils.EMPTY ;
        
        if (StringUtils.isNotEmpty(strJson)) {
            try {
                JSONObject jsonObject = new JSONObject(strJson);

                if (jsonObject.getString(property) != null) {
                    result=  jsonObject.getString(property);
                }
                
            } catch (JSONException ex) {
                _logger.error("[Exception happen when parse Work Order Number]: " + ex.getMessage());
            }
        }
        
        return result;
    }
    /* END BZ47542 */
    
    private static BigDecimal calCMATTenderAmount(List<ITenderLineItem> tenders) {
        BigDecimal result = BigDecimal.ZERO;
        
        for (ITenderLineItem tenderLine : tenders) {
            
            String tenderId = tenderLine.getTenderId();
            
            if (!tenderLine.getVoid() && isCMATTenderOption(tenderId)) {
                result = result.add(tenderLine.getAmount());
            }
        }
        
        return result;
    }
    
    public static boolean isCMATTenderOption(String tenderId) {
        boolean result = false;
        
        if (CawTenderConstants.COUPON_TENDER_ID.equals(tenderId)
                || CawTenderConstants.MALL_CERTIFICATE_TENDER_ID.equals(tenderId)
                || CawTenderConstants.AR_ACCOUNT_TENDER_ID.equals(tenderId)
                || CawTenderConstants.THIRD_PARTY_TENDER_ID.equals(tenderId)) {
            result = true;
        }
        
        return result;
    }
    
    public static boolean isRvTransaction(List<ISaleReturnLineItem> transLineItems) {
        boolean result = false;
        
        for (ISaleReturnLineItem lineItem : transLineItems) {
            if (!lineItem.getVoid() && isRvPaymentSaleLineItem(lineItem)) {
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public static boolean isRvItemTransactionOnly(List<ISaleReturnLineItem> transLineItems) {
        boolean result = true;
        
        for (ISaleReturnLineItem item : transLineItems) {            
            if (!item.getVoid() && !isRvPaymentSaleLineItem(item)) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}
