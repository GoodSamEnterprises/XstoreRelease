/*     */ package dtv.xst.pricing.refresh;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pricing2.PricingDeal;
/*     */ import dtv.xst.dao.prc.IDeal;
/*     */ import dtv.xst.dao.trl.RetailPriceModifierReasonCode;
/*     */ import dtv.xst.pricing.XSTPricingDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtxDealRefreshStrategy
/*     */   extends DtxRefreshStrategyBase
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DtxRefreshStrategyBase.class);
/*     */ 
/*     */   
/*  29 */   protected static final IQueryKey<IDeal> LOAD_DEALS_QUERY = (IQueryKey<IDeal>)new QueryKey("LOAD_DEALS", IDeal.class);
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final String LOAD_DEALS_QUERY_ARG_DEFERRED = "argDeferred";
/*     */ 
/*     */   
/*     */   protected static final String LOAD_DEALS_QUERY_ARG_EFFECTIVE_DATE_LESS = "argEffectiveDateLessThan";
/*     */ 
/*     */   
/*     */   protected static final String LOAD_DEALS_QUERY_ARG_EXPIRATION_DATE_GREATER = "argExpirationDateGreaterThan";
/*     */ 
/*     */   
/*     */   protected static final long DEALS_DATE_MARGIN = 86400000L;
/*     */ 
/*     */   
/*     */   protected int _daysAhead;
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDaysAhead() {
/*  50 */     return this._daysAhead;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PricingDeal> getDeals() {
/*  56 */     return this._deals;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refresh() {
/*  65 */     List<IDeal> xDeals = loadSingles();
/*  66 */     List<PricingDeal> pDeals = new ArrayList<>(xDeals.size());
/*     */     
/*  68 */     int dealIdx = 0;
/*     */     try {
/*  70 */       for (dealIdx = 0; dealIdx < xDeals.size(); dealIdx++) {
/*  71 */         IDeal deal = xDeals.get(dealIdx);
/*  72 */         PricingDeal dl = null;
/*     */         
/*     */         try {
/*  75 */           XSTPricingDescriptor nativeDeal = new XSTPricingDescriptor(deal.getDealId(), RetailPriceModifierReasonCode.DEAL, deal.getDescription(), deal.getTaxabilityCode());
/*     */           
/*  77 */           dl = translateDeal(deal, nativeDeal);
/*     */         }
/*  79 */         catch (Exception ex) {
/*  80 */           logger_.error("Unable to load deal [" + deal.getDealId() + "]!", ex);
/*     */         } 
/*     */         
/*  83 */         if (dl != null) {
/*  84 */           logger_.info("Deal entered into dealspace: " + dl.getId());
/*  85 */           pDeals.add(dl);
/*     */         }
/*     */       
/*     */       } 
/*  89 */     } catch (Throwable th) {
/*  90 */       logger_.fatal("Something really bad happened. Latest deal worked on: " + ((IDeal)xDeals
/*  91 */           .get(dealIdx)).getDealId(), th);
/*  92 */       xDeals = new ArrayList<>();
/*     */     } 
/*     */     
/*  95 */     this._deals = pDeals;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDaysAhead(int argDaysAhead) {
/* 103 */     this._daysAhead = argDaysAhead;
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
/*     */   protected List<IDeal> loadSingles() {
/*     */     try {
/* 116 */       TreeMap<String, Object> params = new TreeMap<>();
/* 117 */       params.put("argDeferred", Boolean.FALSE);
/* 118 */       params.put("argExpirationDateGreaterThan", new Date(
/* 119 */             System.currentTimeMillis() - 86400000L));
/* 120 */       params.put("argEffectiveDateLessThan", new Date(
/* 121 */             System.currentTimeMillis() + 86400000L * getDaysAhead()));
/* 122 */       return (List<IDeal>)DataFactory.getObjectByQuery(LOAD_DEALS_QUERY, params);
/*     */     }
/* 124 */     catch (ObjectNotFoundException ex) {
/* 125 */       logger_.error("No standalone deals found.");
/* 126 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum DealRegionHierarch
/*     */   {
/* 136 */     ORG,
/*     */     
/* 138 */     PRICE;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\refresh\DtxDealRefreshStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */