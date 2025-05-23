/*     */ package dtv.data2.cache.impl;
/*     */ 
/*     */ import dtv.data2.cache.AbstractCache;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapCache
/*     */   extends AbstractCache
/*     */   implements ICache
/*     */ {
/*  25 */   protected String CACHE_SHORT_NAME = "mapcache";
/*     */ 
/*     */   
/*     */   protected CacheType cacheType_;
/*     */   
/*  30 */   protected int initialCapacity_ = 10;
/*  31 */   protected float loadFactor_ = 1.0F;
/*     */   
/*  33 */   protected int maxCapacity_ = 100;
/*     */   
/*     */   protected boolean accessOrder_ = true;
/*  36 */   protected int concurrencyLevel_ = 8;
/*     */ 
/*     */   
/*     */   protected Map<Object, Object> cacheStore_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearImpl() {
/*  44 */     this.cacheStore_.clear();
/*     */   }
/*     */   
/*     */   protected void createBackingMap() {
/*  48 */     if (this.cacheType_.equals(CacheType.HASHMAP)) {
/*  49 */       this.cacheStore_ = Collections.synchronizedMap(new HashMap<>(this.initialCapacity_, this.loadFactor_));
/*     */     }
/*  51 */     else if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP)) {
/*  52 */       this.cacheStore_ = new ConcurrentHashMap<>(this.initialCapacity_, this.loadFactor_, this.concurrencyLevel_);
/*     */     }
/*     */     else {
/*     */       
/*  56 */       this
/*  57 */         .cacheStore_ = Collections.synchronizedMap(new SizeLimitedLinkedHashmap(this.initialCapacity_, this.maxCapacity_, this.loadFactor_, this.accessOrder_));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void destroyImpl() {
/*  65 */     synchronized (this.cacheStore_) {
/*  66 */       this.cacheStore_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getImpl(Object argKey) {
/*  73 */     return this.cacheStore_.get(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStatusDetails() {
/*  79 */     StringBuilder statusString = new StringBuilder();
/*  80 */     synchronized (this.cacheStore_) {
/*  81 */       if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP)) {
/*  82 */         statusString.append("Concurrency Factor = ").append(this.concurrencyLevel_).append(", ");
/*     */       }
/*  84 */       if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP)) {
/*  85 */         statusString.append("Maximum Capacity = ").append(this.maxCapacity_).append(", ");
/*  86 */         statusString.append("Access Order = ").append(this.accessOrder_ ? "LRU" : "FIFO").append(", ");
/*     */       } 
/*  88 */       statusString.append("Load Factor = ").append(this.loadFactor_).append(", ");
/*  89 */       statusString.append("Initial Capacity = ").append(this.initialCapacity_).append(", ");
/*  90 */       statusString.append("Size = ").append(this.cacheStore_.size());
/*     */     } 
/*  92 */     return statusString.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initImpl(String argCacheId) {
/* 100 */     Set<Map.Entry<String, String>> allProperties = CacheConfigHelper.getCacheConfig().getGlobalProperties().getProperties().entrySet();
/* 101 */     Map<String, String> effectiveProperties = new HashMap<>();
/*     */ 
/*     */     
/* 104 */     for (Map.Entry<String, String> entry : allProperties) {
/* 105 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/* 106 */       if (splitKey.length == 3 && splitKey[0].equals(this.CACHE_SHORT_NAME) && splitKey[1]
/* 107 */         .equals("global")) {
/* 108 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 113 */     for (Map.Entry<String, String> entry : allProperties) {
/* 114 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/* 115 */       if (splitKey.length == 3 && splitKey[0].equals(this.CACHE_SHORT_NAME) && splitKey[1].equals(getCacheId())) {
/* 116 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 121 */     setConfigValues(effectiveProperties);
/*     */ 
/*     */     
/* 124 */     createBackingMap();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void putImpl(Object argKey, Object argValue) {
/* 130 */     this.cacheStore_.put(argKey, (argValue == null) ? NULL_VALUE : argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeImpl(Object argKey) {
/* 136 */     this.cacheStore_.remove(argKey);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setConfigValues(Map<String, String> cacheConfig) {
/* 141 */     String cacheType = cacheConfig.remove("CacheType");
/* 142 */     if (cacheType != null && cacheType.equals("HashMap")) {
/* 143 */       this.cacheType_ = CacheType.HASHMAP;
/*     */     }
/* 145 */     else if (cacheType != null && cacheType.equals("ConcurrentHashMap")) {
/* 146 */       this.cacheType_ = CacheType.CONCURRENTHASHMAP;
/*     */     } else {
/*     */       
/* 149 */       if (cacheType != null && !cacheType.equals("SizeLimitedLinkedHashMap")) {
/* 150 */         this.logger_.warn("An unsupported cache type of " + cacheType + " was specified.  Falling back to a SizeLimitedLinkedHashMap");
/*     */       }
/*     */       
/* 153 */       this.cacheType_ = CacheType.SIZELIMITEDLINKEDHASHMAP;
/*     */     } 
/*     */ 
/*     */     
/* 157 */     for (Map.Entry<String, String> entry : cacheConfig.entrySet()) {
/* 158 */       String key = ((String)entry.getKey()).trim();
/* 159 */       String value = ((String)entry.getValue()).trim();
/*     */       try {
/* 161 */         if (key.equals("InitialCapacity")) {
/* 162 */           this.initialCapacity_ = Integer.parseInt(value); continue;
/*     */         } 
/* 164 */         if (key.equals("LoadFactor")) {
/* 165 */           this.loadFactor_ = Float.valueOf(value).floatValue(); continue;
/*     */         } 
/* 167 */         if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP) && key.equals("ConcurrencyFactor")) {
/* 168 */           this.concurrencyLevel_ = Integer.parseInt(value); continue;
/*     */         } 
/* 170 */         if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP) && key.equals("MaxEntries")) {
/* 171 */           this.maxCapacity_ = Integer.parseInt(value); continue;
/*     */         } 
/* 173 */         if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP) && key.equals("EvictionPolicy")) {
/* 174 */           if (value.equals("LRU")) {
/* 175 */             this.accessOrder_ = true; continue;
/*     */           } 
/* 177 */           if (value.equals("FIFO")) {
/* 178 */             this.accessOrder_ = false;
/*     */             continue;
/*     */           } 
/* 181 */           this.logger_.warn("Found unrecognized eviction policy of " + value + " for region " + getCacheId() + ".  Supported types are LRU, LFU, and FIFO.  Default eviction Policy (LRU) will be used.");
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 186 */         this.logger_.warn("Found unrecognized config of " + key + " for region " + getCacheId() + ".  This config will be ignored.");
/*     */ 
/*     */       
/*     */       }
/* 190 */       catch (Exception e) {
/* 191 */         this.logger_.warn("An error occurred when parsing config of " + key + " with value " + value + " for region " + 
/* 192 */             getCacheId() + ".  This config will be ignored.");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected enum CacheType {
/* 198 */     HASHMAP, SIZELIMITEDLINKEDHASHMAP, CONCURRENTHASHMAP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class SizeLimitedLinkedHashmap
/*     */     extends LinkedHashMap<Object, Object>
/*     */   {
/*     */     private static final long serialVersionUID = 73717943498829748L;
/*     */ 
/*     */ 
/*     */     
/*     */     private int _maxEntries;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SizeLimitedLinkedHashmap(int argInitialCapacity, int argMaxCapacity, float argLoadFactor, boolean argAccessOrder) {
/* 217 */       super(argInitialCapacity, argLoadFactor, argAccessOrder);
/* 218 */       this._maxEntries = argMaxCapacity;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
/* 223 */       return (size() > this._maxEntries);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\impl\MapCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */