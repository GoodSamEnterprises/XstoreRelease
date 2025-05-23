/*     */ package dtv.data2.cache.impl;
/*     */ 
/*     */ import com.google.common.cache.Cache;
/*     */ import com.google.common.cache.CacheBuilder;
/*     */ import dtv.data2.cache.AbstractCache;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class GuavaCache
/*     */   extends AbstractCache
/*     */   implements ICache
/*     */ {
/*     */   private static final String CACHE_SHORT_NAME = "guavacache";
/*     */   private Cache<Object, Object> cacheStore_;
/*     */   
/*     */   protected void clearImpl() {
/*  34 */     this.cacheStore_.invalidateAll();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void destroyImpl() {
/*  40 */     this.cacheStore_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getImpl(Object argKey) {
/*  46 */     return this.cacheStore_.getIfPresent(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStatusDetails() {
/*  52 */     return "size = " + this.cacheStore_.size() + " " + this.cacheStore_.stats().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initImpl(String argCacheId) {
/*  60 */     Set<Map.Entry<String, String>> allProperties = CacheConfigHelper.getCacheConfig().getGlobalProperties().getProperties().entrySet();
/*  61 */     Map<String, String> effectiveProperties = new HashMap<>();
/*     */ 
/*     */     
/*  64 */     for (Map.Entry<String, String> entry : allProperties) {
/*  65 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/*  66 */       if (splitKey.length == 3 && splitKey[0].equals("guavacache") && splitKey[1]
/*  67 */         .equals("global")) {
/*  68 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  73 */     for (Map.Entry<String, String> entry : allProperties) {
/*  74 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/*  75 */       if (splitKey.length == 3 && splitKey[0].equals("guavacache") && splitKey[1].equals(getCacheId())) {
/*  76 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  81 */     CacheBuilder<Object, Object> cacheBuilder = setConfigValues(effectiveProperties);
/*     */ 
/*     */     
/*  84 */     this.cacheStore_ = cacheBuilder.build();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void putImpl(Object argKey, Object argValue) {
/*  90 */     this.cacheStore_.put(argKey, (argValue == null) ? NULL_VALUE : argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeImpl(Object argKey) {
/*  96 */     this.cacheStore_.invalidate(argKey);
/*     */   }
/*     */   
/*     */   private CacheBuilder<Object, Object> setConfigValues(Map<String, String> cacheConfig) {
/* 100 */     CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
/*     */     
/* 102 */     for (Map.Entry<String, String> entry : cacheConfig.entrySet()) {
/* 103 */       String key = ((String)entry.getKey()).trim();
/* 104 */       String value = ((String)entry.getValue()).trim();
/*     */       try {
/* 106 */         if (key.equals("InitialCapacity")) {
/* 107 */           builder.initialCapacity(Integer.parseInt(value)); continue;
/*     */         } 
/* 109 */         if (key.equals("MaxEntries")) {
/* 110 */           builder.maximumSize(Long.parseLong(value)); continue;
/*     */         } 
/* 112 */         if (key.equals("ConcurrencyFactor")) {
/* 113 */           builder.concurrencyLevel(Integer.parseInt(value)); continue;
/*     */         } 
/* 115 */         if (key.equals("TimeToLiveSeconds")) {
/* 116 */           builder.expireAfterWrite(Long.parseLong(value), TimeUnit.SECONDS); continue;
/*     */         } 
/* 118 */         if (key.equals("TimeToIdleSeconds")) {
/* 119 */           builder.expireAfterAccess(Long.parseLong(value), TimeUnit.SECONDS); continue;
/*     */         } 
/* 121 */         if (key.equals("WeakReferences")) {
/* 122 */           if (Boolean.valueOf(value).booleanValue())
/* 123 */             builder.weakValues(); 
/*     */           continue;
/*     */         } 
/* 126 */         if (key.equals("TrackStats")) {
/* 127 */           if (Boolean.valueOf(value).booleanValue()) {
/* 128 */             builder.recordStats();
/*     */           }
/*     */           continue;
/*     */         } 
/* 132 */         this.logger_.warn("Found unregognized config of " + key + " for region " + getCacheId() + ".  This config will be ignored.");
/*     */ 
/*     */       
/*     */       }
/* 136 */       catch (Exception e) {
/* 137 */         this.logger_.warn("An error occurred when parsing config of " + key + " with value " + value + " for region " + 
/* 138 */             getCacheId() + ".  This config will be ignored.");
/*     */       } 
/*     */     } 
/* 141 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\impl\GuavaCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */