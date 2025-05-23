/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.LocationFactory;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.Currency;
/*     */ import java.util.Map;
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
/*     */ public enum CommonReportParameters
/*     */ {
/*  23 */   REPORT_HELPER("HELPER")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/*  27 */       return ReportHelper.getInstance();
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  32 */   GIFT_REGISTRY_HIDE_PURCHASED("giftRegistryhidePurchased")
/*     */   {
/*     */     public Object getValue() {
/*  35 */       return Boolean.valueOf(ConfigurationMgr.hideGiftRegistryPurchasedQuantity());
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  40 */   MERCHLVL1("merchLevel1Code")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/*  44 */       return ConfigurationMgr.getMerchHierLevel1Code();
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  49 */   ORGANIZATION_ID("organizationId")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/*  53 */       return Long.valueOf(ConfigurationMgr.getOrganizationId());
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  58 */   RETAIL_LOCATION_ID("retailLocationId")
/*     */   {
/*     */     public Object getValue() {
/*  61 */       long retailLocationId = Long.parseLong(System.getProperty("dtv.location.storeNumber"));
/*  62 */       return Long.valueOf(LocationFactory.getInstance().getStoreById(retailLocationId).getRetailLocationId());
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  67 */   STORE_NAME("storeName")
/*     */   {
/*     */     public Object getValue() {
/*  70 */       long retailLocationId = Long.parseLong(System.getProperty("dtv.location.storeNumber"));
/*  71 */       return LocationFactory.getInstance().getStoreById(retailLocationId).getStoreName();
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  76 */   STORE_NBR("storeNbr")
/*     */   {
/*     */     public Object getValue() {
/*  79 */       long retailLocationId = Long.parseLong(System.getProperty("dtv.location.storeNumber"));
/*  80 */       return LocationFactory.getInstance().getStoreById(retailLocationId).getStoreNbr();
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  85 */   LOCAL_CURRENCY_SYMBOL("localCurrencySymbol")
/*     */   {
/*     */     public Object getValue() {
/*  88 */       return Currency.getInstance(ConfigurationMgr.getLocalCurrencyId()).getSymbol();
/*     */     }
/*     */   },
/*     */   
/*  92 */   SYSTEM_DATE("systemDate")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/*  96 */       return DateUtils.getNewDate();
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   BOOK_ASSALE_AT_LAYAWAYSETUP("saleLayaway")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/* 112 */       if (ConfigurationMgr.bookAsSaleOnLayawaySetup()) {
/* 113 */         return "OPEN";
/*     */       }
/*     */       
/* 116 */       return "PICKUP";
/*     */     }
/*     */   },
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
/* 129 */   BOOK_ASSALE_AT_SPECIALORDERSETUP("saleSpecialOrder")
/*     */   {
/*     */     public Object getValue()
/*     */     {
/* 133 */       if (ConfigurationMgr.bookAsSaleOnSpecialOrderSetup()) {
/* 134 */         return "OPEN";
/*     */       }
/*     */       
/* 137 */       return "'PICKUP','SHIP'";
/*     */     }
/*     */   };
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */   
/*     */   public static void addAllToMap(Map<String, Object> argMap) {
/* 146 */     for (CommonReportParameters p : values()) {
/* 147 */       p.addToMap(argMap);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean containsName(String argName) {
/* 156 */     for (CommonReportParameters p : values()) {
/* 157 */       if (p.name_.equals(argName)) {
/* 158 */         return true;
/*     */       }
/*     */     } 
/* 161 */     return false;
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
/*     */   CommonReportParameters(String argName) {
/* 173 */     this.name_ = argName;
/*     */   }
/*     */   
/*     */   public void addToMap(Map<String, Object> argMap) {
/* 177 */     if (!argMap.containsKey(getName())) {
/* 178 */       argMap.put(getName(), getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 188 */     return this.name_;
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
/*     */   public String toString() {
/* 200 */     return "CommonReportParameters[" + this.name_ + "]";
/*     */   }
/*     */   
/*     */   public abstract Object getValue();
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\CommonReportParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */