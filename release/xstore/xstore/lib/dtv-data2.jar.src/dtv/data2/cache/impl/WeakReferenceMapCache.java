/*     */ package dtv.data2.cache.impl;
/*     */ 
/*     */ import dtv.data2.cache.AbstractCache;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WeakReferenceMapCache
/*     */   extends AbstractCache
/*     */   implements ICache
/*     */ {
/*  27 */   protected String CACHE_SHORT_NAME = "weakreferencemapcache";
/*     */ 
/*     */   
/*  30 */   protected final ReferenceQueue<CacheWeakReference<Object, Object>> cleanupRefQueue_ = new ReferenceQueue<>();
/*     */   
/*  32 */   protected final ReentrantLock cleanupSync_ = new ReentrantLock();
/*     */ 
/*     */   
/*     */   protected CacheType cacheType_;
/*     */   
/*  37 */   protected int initialCapacity_ = 10;
/*  38 */   protected float loadFactor_ = 1.0F;
/*     */   
/*  40 */   protected int maxCapacity_ = 100;
/*     */   
/*     */   protected boolean accessOrder_ = true;
/*  43 */   protected int concurrencyLevel_ = 8;
/*     */ 
/*     */   
/*     */   protected Map<Object, CacheWeakReference<Object, Object>> cacheStore_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearImpl() {
/*  51 */     this.cacheStore_.clear();
/*     */   }
/*     */   
/*     */   protected void createBackingMap() {
/*  55 */     if (this.cacheType_.equals(CacheType.HASHMAP)) {
/*  56 */       this
/*  57 */         .cacheStore_ = Collections.synchronizedMap(new HashMap<>(this.initialCapacity_, this.loadFactor_));
/*     */     
/*     */     }
/*  60 */     else if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP)) {
/*  61 */       this.cacheStore_ = new ConcurrentHashMap<>(this.initialCapacity_, this.loadFactor_, this.concurrencyLevel_);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  67 */       this
/*  68 */         .cacheStore_ = Collections.synchronizedMap(new SizeLimitedLinkedHashmap(this.initialCapacity_, this.maxCapacity_, this.loadFactor_, this.accessOrder_));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void destroyImpl() {
/*  76 */     synchronized (this.cacheStore_) {
/*  77 */       this.cacheStore_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getImpl(Object argKey) {
/*  85 */     flushLostReferences();
/*     */     
/*  87 */     WeakReference<Object> cacheEntry = this.cacheStore_.get(argKey);
/*  88 */     if (cacheEntry == null) {
/*  89 */       return null;
/*     */     }
/*     */     
/*  92 */     Object cacheObject = cacheEntry.get();
/*  93 */     if (cacheObject == null) {
/*  94 */       return null;
/*     */     }
/*     */     
/*  97 */     return cacheObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStatusDetails() {
/* 106 */     flushLostReferences();
/*     */     
/* 108 */     StringBuilder statusString = new StringBuilder();
/* 109 */     synchronized (this.cacheStore_) {
/* 110 */       if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP)) {
/* 111 */         statusString.append("Concurrency Factor = ").append(this.concurrencyLevel_).append(", ");
/*     */       }
/* 113 */       if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP)) {
/* 114 */         statusString.append("Maximum Capacity = ").append(this.maxCapacity_).append(", ");
/* 115 */         statusString.append("Access Order = ").append(this.accessOrder_ ? "LRU" : "FIFO").append(", ");
/*     */       } 
/* 117 */       statusString.append("Load Factor = ").append(this.loadFactor_).append(", ");
/* 118 */       statusString.append("Initial Capacity = ").append(this.initialCapacity_).append(", ");
/* 119 */       statusString.append("Size = ").append(this.cacheStore_.size());
/*     */     } 
/* 121 */     return statusString.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initImpl(String argCacheId) {
/* 129 */     Set<Map.Entry<String, String>> allProperties = CacheConfigHelper.getCacheConfig().getGlobalProperties().getProperties().entrySet();
/* 130 */     Map<String, String> effectiveProperties = new HashMap<>();
/*     */ 
/*     */     
/* 133 */     for (Map.Entry<String, String> entry : allProperties) {
/* 134 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/* 135 */       if (splitKey.length == 3 && splitKey[0].equals(this.CACHE_SHORT_NAME) && splitKey[1]
/* 136 */         .equals("global")) {
/* 137 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 142 */     for (Map.Entry<String, String> entry : allProperties) {
/* 143 */       String[] splitKey = ((String)entry.getKey()).split("\\.");
/* 144 */       if (splitKey.length == 3 && splitKey[0].equals(this.CACHE_SHORT_NAME) && splitKey[1].equals(getCacheId())) {
/* 145 */         effectiveProperties.put(splitKey[2], entry.getValue());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 150 */     setConfigValues(effectiveProperties);
/*     */ 
/*     */     
/* 153 */     createBackingMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void putImpl(Object argKey, Object argValue) {
/* 160 */     flushLostReferences();
/*     */     
/* 162 */     this.cacheStore_.put(argKey, (argValue == null) ? new CacheWeakReference<>(argKey, NULL_VALUE, (ReferenceQueue)this.cleanupRefQueue_) : new CacheWeakReference<>(argKey, argValue, (ReferenceQueue)this.cleanupRefQueue_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeImpl(Object argKey) {
/* 170 */     flushLostReferences();
/*     */     
/* 172 */     this.cacheStore_.remove(argKey);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setConfigValues(Map<String, String> cacheConfig) {
/* 177 */     String cacheType = cacheConfig.remove("CacheType");
/* 178 */     if (cacheType != null && cacheType.equals("HashMap")) {
/* 179 */       this.cacheType_ = CacheType.HASHMAP;
/*     */     }
/* 181 */     else if (cacheType != null && cacheType.equals("ConcurrentHashMap")) {
/* 182 */       this.cacheType_ = CacheType.CONCURRENTHASHMAP;
/*     */     } else {
/*     */       
/* 185 */       if (cacheType != null && !cacheType.equals("SizeLimitedLinkedHashMap")) {
/* 186 */         this.logger_.warn("An unsupported cache type of " + cacheType + " was specified.  Falling back to a SizeLimitedLinkedHashMap");
/*     */       }
/*     */       
/* 189 */       this.cacheType_ = CacheType.SIZELIMITEDLINKEDHASHMAP;
/*     */     } 
/*     */ 
/*     */     
/* 193 */     for (Map.Entry<String, String> entry : cacheConfig.entrySet()) {
/* 194 */       String key = ((String)entry.getKey()).trim();
/* 195 */       String value = ((String)entry.getValue()).trim();
/*     */       try {
/* 197 */         if (key.equals("InitialCapacity")) {
/* 198 */           this.initialCapacity_ = Integer.parseInt(value); continue;
/*     */         } 
/* 200 */         if (key.equals("LoadFactor")) {
/* 201 */           this.loadFactor_ = Float.valueOf(value).floatValue(); continue;
/*     */         } 
/* 203 */         if (this.cacheType_.equals(CacheType.CONCURRENTHASHMAP) && key.equals("ConcurrencyFactor")) {
/* 204 */           this.concurrencyLevel_ = Integer.parseInt(value); continue;
/*     */         } 
/* 206 */         if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP) && key.equals("MaxEntries")) {
/* 207 */           this.maxCapacity_ = Integer.parseInt(value); continue;
/*     */         } 
/* 209 */         if (this.cacheType_.equals(CacheType.SIZELIMITEDLINKEDHASHMAP) && key.equals("EvictionPolicy")) {
/* 210 */           if (value.equals("LRU")) {
/* 211 */             this.accessOrder_ = true; continue;
/*     */           } 
/* 213 */           if (value.equals("FIFO")) {
/* 214 */             this.accessOrder_ = false;
/*     */             continue;
/*     */           } 
/* 217 */           this.logger_.warn("Found unrecognized eviction policy of " + value + " for region " + getCacheId() + ".  Supported types are LRU, LFU, and FIFO.  Default eviction Policy (LRU) will be used.");
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 222 */         this.logger_.warn("Found unrecognized config of " + key + " for region " + getCacheId() + ".  This config will be ignored.");
/*     */ 
/*     */       
/*     */       }
/* 226 */       catch (Exception e) {
/* 227 */         this.logger_.warn("An error occurred when parsing config of " + key + " with value " + value + " for region " + 
/* 228 */             getCacheId() + ".  This config will be ignored.");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void flushLostReferences() {
/* 240 */     if (!this.cleanupSync_.tryLock()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 246 */       Reference<? extends CacheWeakReference<Object, Object>> reference = null;
/* 247 */       while ((reference = this.cleanupRefQueue_.poll()) != null) {
/* 248 */         Object crossRef = ((CacheWeakReference)reference).getCrossRefValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 254 */         if (this.cacheStore_.containsValue(reference)) {
/* 255 */           this.cacheStore_.remove(crossRef);
/*     */         }
/*     */       } 
/*     */     } finally {
/*     */       
/* 260 */       this.cleanupSync_.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected enum CacheType {
/* 265 */     HASHMAP, SIZELIMITEDLINKEDHASHMAP, CONCURRENTHASHMAP;
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
/*     */   private class CacheWeakReference<K, V>
/*     */     extends WeakReference<V>
/*     */   {
/*     */     private final K crossRefValue_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected CacheWeakReference(K argCrossReference, V argReferent, ReferenceQueue<? extends WeakReference<V>> argRefQueue) {
/* 291 */       super(argReferent, (ReferenceQueue)argRefQueue);
/* 292 */       this.crossRefValue_ = argCrossReference;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected K getCrossRefValue() {
/* 300 */       return this.crossRefValue_;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class SizeLimitedLinkedHashmap
/*     */     extends LinkedHashMap<Object, CacheWeakReference<Object, Object>>
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
/* 320 */       super(argInitialCapacity, argLoadFactor, argAccessOrder);
/* 321 */       this._maxEntries = argMaxCapacity;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<Object, WeakReferenceMapCache.CacheWeakReference<Object, Object>> eldest) {
/* 326 */       return (size() > this._maxEntries);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\impl\WeakReferenceMapCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */