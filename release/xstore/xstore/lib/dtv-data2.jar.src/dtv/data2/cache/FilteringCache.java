/*     */ package dtv.data2.cache;
/*     */ 
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class FilteringCache
/*     */   implements ICache
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(CacheManager.class);
/*  27 */   private static final boolean DEBUG = logger_.isDebugEnabled();
/*     */   
/*     */   private final ICache wrappedCache_;
/*     */   private String[] filter_;
/*     */   
/*     */   public FilteringCache(ICache argWrappedCache) {
/*  33 */     this.wrappedCache_ = argWrappedCache;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  39 */     this.wrappedCache_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy() {
/*  45 */     this.wrappedCache_.destroy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get(Object argKey) throws NotCachedException {
/*  53 */     if (isCacheable(argKey)) {
/*  54 */       return this.wrappedCache_.get(argKey);
/*     */     }
/*     */     
/*  57 */     if (DEBUG) {
/*  58 */       logger_.debug("get() from cache '" + getCacheId() + "' not attempted.  Key is not cacheable: " + argKey);
/*     */     }
/*     */     
/*  61 */     throw new NotCachedException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCacheId() {
/*  68 */     return this.wrappedCache_.getCacheId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getSafely(Object argKey) {
/*  75 */     if (isCacheable(argKey)) {
/*  76 */       return this.wrappedCache_.getSafely(argKey);
/*     */     }
/*     */     
/*  79 */     if (DEBUG) {
/*  80 */       logger_.debug("get() from cache '" + getCacheId() + "' not attempted.  Key is not cacheable: " + argKey);
/*     */     }
/*     */     
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusReport() {
/*  90 */     return this.wrappedCache_.getStatusReport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(String argCacheId) {
/*  96 */     String filterId = CacheConfigHelper.getCacheDefConfig(argCacheId).getCacheFilterRef();
/*  97 */     if (DEBUG) {
/*  98 */       logger_.debug("FilteringSyncCache init() for cache id: " + argCacheId + " filter id: " + filterId);
/*     */     }
/*     */     
/* 101 */     if (!StringUtils.isEmpty(filterId)) {
/* 102 */       Map<String, Boolean> filterMap = CacheConfigHelper.getCacheConfig().getCacheFilter(filterId);
/* 103 */       if (filterMap != null) {
/* 104 */         List<String> filterList = new ArrayList<>();
/* 105 */         for (Map.Entry<String, Boolean> filterValue : filterMap.entrySet()) {
/* 106 */           if (((Boolean)filterValue.getValue()).booleanValue()) {
/* 107 */             filterList.add(filterValue.getKey());
/*     */           }
/*     */         } 
/* 110 */         String[] filter = filterList.<String>toArray(new String[filterList.size()]);
/* 111 */         Arrays.sort((Object[])filter);
/* 112 */         this.filter_ = filter;
/*     */       } else {
/*     */         
/* 115 */         this.filter_ = null;
/*     */       } 
/*     */     } 
/*     */     
/* 119 */     this.wrappedCache_.init(argCacheId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Object argKey, Object argValue) {
/* 126 */     if (isCacheable(argKey)) {
/* 127 */       this.wrappedCache_.put(argKey, argValue);
/*     */     
/*     */     }
/* 130 */     else if (DEBUG) {
/* 131 */       logger_.debug("put() into cache '" + getCacheId() + "' not attempted.  Key is not cacheable. (Key: " + argKey + " Value: " + argValue + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Object argKey) {
/* 140 */     if (isCacheable(argKey)) {
/* 141 */       this.wrappedCache_.remove(argKey);
/*     */     
/*     */     }
/* 144 */     else if (DEBUG) {
/* 145 */       logger_.debug("remove() from cache '" + getCacheId() + "' not attempted.  Key is not cacheable: " + argKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCacheable(Object argKey) {
/* 157 */     if (this.filter_ == null) {
/* 158 */       if (DEBUG) {
/* 159 */         logger_.debug("Cache elegibility on cache " + getCacheId() + " is true for key:" + argKey + " (No filter is defined for this cache.)");
/*     */       }
/*     */       
/* 162 */       return true;
/*     */     } 
/*     */     
/* 165 */     int cacheIndex = -1;
/* 166 */     if (argKey instanceof String) {
/* 167 */       cacheIndex = Arrays.binarySearch((Object[])this.filter_, argKey);
/*     */     }
/* 169 */     else if (argKey instanceof QueryRequest) {
/* 170 */       cacheIndex = Arrays.binarySearch((Object[])this.filter_, ((QueryRequest)argKey).getQueryKey());
/*     */     } else {
/*     */       
/* 173 */       cacheIndex = Arrays.binarySearch((Object[])this.filter_, argKey.getClass().getName());
/*     */     } 
/* 175 */     if (DEBUG) {
/* 176 */       logger_.debug("Cache elibility on cache " + getCacheId() + " is " + ((cacheIndex >= 0) ? 1 : 0) + " for key: " + argKey + " (filter(s): " + this.filter_ + ")");
/*     */     }
/*     */     
/* 179 */     return (cacheIndex >= 0);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\FilteringCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */