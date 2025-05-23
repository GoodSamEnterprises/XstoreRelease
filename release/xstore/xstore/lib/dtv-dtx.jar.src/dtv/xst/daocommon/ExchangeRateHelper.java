/*     */ package dtv.xst.daocommon;
/*     */ 
/*     */ import dtv.util.CurrencyUtils;
/*     */ import dtv.util.Money;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Currency;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class ExchangeRateHelper
/*     */ {
/*  25 */   private static final Logger _logger = Logger.getLogger(ExchangeRateHelper.class);
/*  26 */   private static final String IMPL_KEY = IExchangeRateHelper.class.getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static IExchangeRateHelper _impl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigDecimal getExchangeRate(String argBaseCurrency, String argTargetCurrency, long argRetailLocationId) {
/*  39 */     return getImpl().getExchangeRate(argBaseCurrency, argTargetCurrency, argRetailLocationId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<? extends IExchangeRate> getLocalExchangeRates(long argRetailLocationId) {
/*  49 */     return getImpl().getLocalExchangeRates(argRetailLocationId);
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
/*     */ 
/*     */   
/*     */   public static BigDecimal getLocalizedAmount(BigDecimal argAmount, String argCurrencyId, String argLocalCurrencyId, long argRetailLocationId) {
/*  67 */     String amountCurrencyId = argCurrencyId;
/*     */     
/*  69 */     if (argAmount instanceof Money) {
/*  70 */       amountCurrencyId = (String)ObjectUtils.coalesce((Object[])new String[] { ((Money)argAmount).getCurrency().getCurrencyCode(), argCurrencyId });
/*     */     }
/*     */     
/*  73 */     BigDecimal convertedAmount = null;
/*     */     
/*  75 */     if (argAmount == null || argCurrencyId == null || argLocalCurrencyId
/*  76 */       .equalsIgnoreCase(amountCurrencyId)) {
/*  77 */       convertedAmount = argAmount;
/*     */     }
/*     */     else {
/*     */       
/*  81 */       BigDecimal exchangeRate = getImpl().getExchangeRate(argLocalCurrencyId, amountCurrencyId, argRetailLocationId);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  86 */       argAmount = argAmount.setScale(CurrencyUtils.getCurrency(argLocalCurrencyId).getDefaultFractionDigits(), RoundingMode.HALF_UP);
/*  87 */       convertedAmount = roundMoney(argAmount.divide(exchangeRate, RoundingMode.HALF_UP), CurrencyUtils.getCurrency(argLocalCurrencyId));
/*     */     } 
/*  89 */     return convertedAmount;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigDecimal getRelativeAmount(BigDecimal argAmount, String argCurrencyId, String argLocalCurrencyId, long argRetailLocationId) {
/* 108 */     String baseCurrencyId = (argAmount instanceof Money) ? ((Money)argAmount).getCurrency().getCurrencyCode() : argLocalCurrencyId;
/*     */ 
/*     */     
/* 111 */     BigDecimal convertedAmount = null;
/*     */     
/* 113 */     if (argAmount == null || argCurrencyId == null || baseCurrencyId.equals(argCurrencyId)) {
/* 114 */       convertedAmount = argAmount;
/*     */     } else {
/*     */       
/* 117 */       BigDecimal exchangeRate = getImpl().getExchangeRate(baseCurrencyId, argCurrencyId, argRetailLocationId);
/* 118 */       convertedAmount = roundMoney(argAmount.multiply(exchangeRate), CurrencyUtils.getCurrency(argCurrencyId));
/*     */     } 
/* 120 */     return convertedAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static IExchangeRateHelper getImpl() {
/* 128 */     if (_impl == null) {
/* 129 */       String className = System.getProperty(IMPL_KEY);
/*     */       
/*     */       try {
/* 132 */         _impl = (IExchangeRateHelper)Class.forName(className).newInstance();
/*     */       }
/* 134 */       catch (Exception ex) {
/* 135 */         _logger.debug("No instance of " + IExchangeRateHelper.class.getName() + " mapped to " + IMPL_KEY + ".  Using default implementation.");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 143 */           _impl = (IExchangeRateHelper)Class.forName("dtv.pos.tender.ExchangeRateHelperImpl").newInstance();
/*     */         }
/* 145 */         catch (Exception exception) {}
/*     */       } 
/*     */     } 
/* 148 */     return _impl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static BigDecimal roundMoney(BigDecimal argAmount, Currency argCurrency) {
/* 159 */     if (argAmount != null && argCurrency != null) {
/* 160 */       return argAmount.setScale(argCurrency.getDefaultFractionDigits(), RoundingMode.HALF_UP);
/*     */     }
/* 162 */     return argAmount;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\ExchangeRateHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */