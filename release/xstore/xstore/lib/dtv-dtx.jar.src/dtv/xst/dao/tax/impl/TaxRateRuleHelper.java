/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.xst.dao.tax.ITaxRateRule;
/*     */ import dtv.xst.dao.tax.ITaxRateRuleOverride;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaxRateRuleHelper
/*     */ {
/*     */   public static boolean doesTaxRuleApply(ITaxRateRule rateRule, BigDecimal taxableAmt) {
/*  30 */     return doesTaxRuleApplyImpl(rateRule.getTaxRateMaxTaxableAmount(), rateRule.getTaxRateMinTaxableAmount(), rateRule
/*  31 */         .getBreakPointTypeCode(), taxableAmt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean doesTaxRuleApply(ITaxRateRule rateRule, Date transactionDateTime) {
/*  42 */     return doesTaxRuleApplyImpl(rateRule.getEffectiveDatetimestamp(), rateRule.getExpirationDatetimestamp(), rateRule
/*  43 */         .getDailyStartTime(), rateRule.getDailyEndTime(), transactionDateTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean doesTaxRuleApply(ITaxRateRuleOverride rateRule, BigDecimal taxableAmt) {
/*  54 */     return doesTaxRuleApplyImpl(rateRule.getTaxRateMaxTaxableAmount(), rateRule.getTaxRateMinTaxableAmount(), rateRule
/*  55 */         .getBreakPointTypeCode(), taxableAmt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean doesTaxRuleApply(ITaxRateRuleOverride rateRule, Date transactionDateTime) {
/*  66 */     return doesTaxRuleApplyImpl(rateRule.getEffectiveDatetimestamp(), rateRule.getExpirationDatetimestamp(), rateRule
/*  67 */         .getDailyStartTime(), rateRule.getDailyEndTime(), transactionDateTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean doesTaxRuleApplyImpl(BigDecimal maxTaxableAmt, BigDecimal minTaxableAmt, String breakPointTypeCode, BigDecimal taxableAmt) {
/*  81 */     if (taxableAmt == null) {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     BigDecimal max = maxTaxableAmt;
/*  86 */     BigDecimal min = minTaxableAmt;
/*     */     
/*  88 */     if ("PART".equalsIgnoreCase(breakPointTypeCode)) {
/*     */       
/*  90 */       if (min != null && taxableAmt.abs().compareTo(min) < 0) {
/*  91 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  95 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  99 */     if (max != null && taxableAmt.abs().compareTo(max) > 0) {
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (min != null && taxableAmt.abs().compareTo(min) < 0) {
/* 104 */       return false;
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean doesTaxRuleApplyImpl(Date effDate, Date expDate, Date startTime, Date endTime, Date transactionDateTime) {
/* 122 */     Date effectiveDateTime = effDate;
/* 123 */     if (effectiveDateTime != null && effectiveDateTime.after(transactionDateTime)) {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     Date expDateTime = expDate;
/* 128 */     if (expDateTime != null && expDateTime.before(transactionDateTime)) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     Date time = DateUtils.clearDate(transactionDateTime);
/*     */     
/* 134 */     Date dailyStartTime = startTime;
/* 135 */     if (dailyStartTime != null && dailyStartTime.after(time)) {
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     Date dailyEndTime = endTime;
/* 140 */     if (dailyEndTime != null && dailyEndTime.before(time)) {
/* 141 */       return false;
/*     */     }
/* 143 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */