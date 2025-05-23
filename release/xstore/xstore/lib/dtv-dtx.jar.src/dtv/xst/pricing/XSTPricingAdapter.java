/*     */ package dtv.xst.pricing;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pricing2.PricingAdapter;
/*     */ import dtv.xst.dao.prc.IDeal;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.pricing.coupon.CouponValueCodeConfigHelper;
/*     */ import dtv.xst.pricing.coupon.CouponValueConfig;
/*     */ import dtv.xst.pricing.coupon.CouponsConfig;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSTPricingAdapter
/*     */   extends PricingAdapter<IRetailTransactionLineItem, IPosTransaction>
/*     */ {
/*  31 */   private static final QueryKey<IDeal> LOAD_SINGLES_QUERY = new QueryKey("LOAD_UNGROUPED_DEALS", IDeal.class);
/*     */   
/*     */   private static final String LOAD_SINGLES_QUERY_ARG_DEFERRED = "argDeferred";
/*     */   
/*  35 */   private static final Logger logger_ = Logger.getLogger(XSTPricingAdapter.class);
/*     */   
/*     */   private CouponValueCodeConfigHelper valueConfigHelper_;
/*  38 */   private Map<String, IDeal> deals_ = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public long convertPrice(BigDecimal argPrice) {
/*  43 */     return argPrice.movePointRight(2).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long convertQuantity(BigDecimal argQuantity) {
/*  49 */     return argQuantity.movePointRight(3).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, IDeal> getDealMap() {
/*  58 */     if (this.deals_ == null) {
/*  59 */       Map<String, IDeal> deals = new HashMap<>();
/*  60 */       for (IDeal deal : loadSingles()) {
/*  61 */         deals.put(deal.getDealId(), deal);
/*     */       }
/*  63 */       this.deals_ = Collections.unmodifiableMap(deals);
/*     */     } 
/*  65 */     return this.deals_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CouponValueConfig getManufacturersCouponValue(String argValueCode) {
/*  75 */     CouponsConfig cc = (CouponsConfig)getCouponValueCodeConfigHelper().getRootConfig();
/*  76 */     return cc.getCouponValueConfig(argValueCode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<CouponValueConfig> getManufacturersCouponValues() {
/*  85 */     CouponsConfig cc = (CouponsConfig)getCouponValueCodeConfigHelper().getRootConfig();
/*  86 */     return cc.getManufacturersCouponValues();
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
/*     */   public EventedPricingTransaction makeShadow(IPosTransaction argTransaction, Class<? extends EventedPricingTransaction> clz) {
/*     */     try {
/* 100 */       Constructor<? extends EventedPricingTransaction> ctor = clz.getConstructor(new Class[] { IPosTransaction.class });
/* 101 */       EventedPricingTransaction shadow = ctor.newInstance(new Object[] { argTransaction });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       for (IRetailTransactionLineItem item : argTransaction.getRetailTransactionLineItems()) {
/* 109 */         if (item instanceof ISaleReturnLineItem) {
/* 110 */           shadow.addItem((ISaleReturnLineItem)item);
/*     */           continue;
/*     */         } 
/* 113 */         shadow.addLineItem(item);
/*     */       } 
/*     */       
/* 116 */       return shadow;
/*     */     }
/* 118 */     catch (RuntimeException ex) {
/* 119 */       throw ex;
/*     */     }
/* 121 */     catch (Exception ex) {
/* 122 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal revertPrice(long argPrice) {
/* 129 */     return (new BigDecimal(argPrice)).movePointLeft(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal revertQuantity(long argQuantity) {
/* 135 */     return (new BigDecimal(argQuantity)).movePointLeft(3);
/*     */   }
/*     */   
/*     */   private CouponValueCodeConfigHelper getCouponValueCodeConfigHelper() {
/* 139 */     if (this.valueConfigHelper_ == null) {
/* 140 */       this.valueConfigHelper_ = new CouponValueCodeConfigHelper(this);
/* 141 */       this.valueConfigHelper_.initialize();
/*     */     } 
/* 143 */     return this.valueConfigHelper_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IDeal> loadSingles() {
/*     */     try {
/* 150 */       TreeMap<String, Object> params = new TreeMap<>();
/* 151 */       params.put("argDeferred", Boolean.valueOf(false));
/* 152 */       return (List<IDeal>)DataFactory.getObjectByQuery((IQueryKey)LOAD_SINGLES_QUERY, params);
/*     */     }
/* 154 */     catch (ObjectNotFoundException ex) {
/* 155 */       logger_.error("No standalone deals found.");
/* 156 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\XSTPricingAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */