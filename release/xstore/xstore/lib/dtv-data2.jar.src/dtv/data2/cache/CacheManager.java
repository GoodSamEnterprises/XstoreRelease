/*     */ package dtv.data2.cache;
/*     */ 
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import dtv.data2.cache.impl.DummyCache;
/*     */ import dtv.util.StringUtils;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class CacheManager
/*     */ {
/*     */   public static final String DEFAULT_CACHE_ID = "default-cache";
/*  25 */   private static final Logger logger_ = Logger.getLogger(CacheManager.class);
/*  26 */   private static final boolean DEBUG = logger_.isDebugEnabled();
/*     */   private static final CacheManager INSTANCE;
/*  28 */   private static final Map<String, ICache> registeredCaches_ = new HashMap<>();
/*     */   
/*     */   static {
/*  31 */     CacheManager temp = null;
/*     */     try {
/*  33 */       String className = System.getProperty("dtv.data2.cache.CacheManager", "dtv.data2.cache.CacheManager");
/*  34 */       temp = (CacheManager)Class.forName(className).newInstance();
/*  35 */       if (DEBUG) {
/*  36 */         logger_.debug("CacheManager initialized as: " + temp);
/*     */       }
/*     */     }
/*  39 */     catch (Exception ee) {
/*  40 */       logger_.error("Error created object for system property: dtv.data2.cache.CacheManager", ee);
/*  41 */       temp = new CacheManager();
/*     */     } finally {
/*     */       
/*  44 */       INSTANCE = temp;
/*     */     } 
/*     */   }
/*     */   private Constructor<ICache> permanentCacheConstructor_;
/*     */   public static CacheManager getInstance() {
/*  49 */     return INSTANCE;
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
/*     */   public void clear() {
/*  64 */     if (DEBUG) {
/*  65 */       logger_.debug("begin clear()");
/*     */     }
/*  67 */     Set<String> cacheIds = null;
/*  68 */     synchronized (registeredCaches_) {
/*  69 */       cacheIds = registeredCaches_.keySet();
/*     */     } 
/*     */     
/*  72 */     if (DEBUG) {
/*  73 */       logger_.debug("Preparing to clear managed caches: " + cacheIds);
/*     */     }
/*     */     
/*  76 */     for (String cacheName : cacheIds) {
/*  77 */       clear(cacheName);
/*     */     }
/*  79 */     if (DEBUG) {
/*  80 */       logger_.debug("end clear()");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(String argCacheId) {
/*  88 */     if (DEBUG) {
/*  89 */       logger_.debug("begin clear(String) for cache id [" + argCacheId + "] clearable: " + 
/*  90 */           CacheConfigHelper.getCacheDefConfig(argCacheId).isClearable());
/*     */     }
/*  92 */     if (CacheConfigHelper.getCacheDefConfig(argCacheId).isClearable()) {
/*  93 */       synchronized (registeredCaches_) {
/*  94 */         ICache cache = registeredCaches_.get(argCacheId);
/*  95 */         if (cache != null) {
/*  96 */           cache.clear();
/*     */         }
/*     */       } 
/*     */     }
/* 100 */     if (DEBUG) {
/* 101 */       logger_.debug("end clear(String) for cache id [" + argCacheId + "]");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean containsCache(String argCacheId) {
/* 106 */     synchronized (registeredCaches_) {
/* 107 */       return registeredCaches_.containsKey(massageCacheId(argCacheId));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICache getCache(String argCacheId) {
/* 117 */     return getCache(argCacheId, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICache getCache(String argCacheId, boolean wrapWithFilteringCache) {
/* 127 */     if (DEBUG) {
/* 128 */       logger_.debug("Request made for cache id [" + argCacheId + "]");
/*     */     }
/*     */     
/* 131 */     synchronized (registeredCaches_) {
/* 132 */       DummyCache dummyCache; String cacheId = massageCacheId(argCacheId);
/* 133 */       if (DEBUG) {
/* 134 */         logger_.debug("Massaged cache id to [" + cacheId + "]");
/*     */       }
/*     */       
/* 137 */       if (registeredCaches_.containsKey(cacheId)) {
/* 138 */         ICache cache = registeredCaches_.get(cacheId);
/* 139 */         if (DEBUG) {
/* 140 */           logger_.debug("CacheManager initialized as: " + INSTANCE);
/*     */         }
/* 142 */         if (cache != null) {
/* 143 */           if (DEBUG) {
/* 144 */             logger_.debug("Cache [" + cacheId + "] already exists, returning existing version.");
/*     */           }
/* 146 */           return cache;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 152 */         ICache cache = CacheConfigHelper.getCacheDefConfig(cacheId).getCacheImpl().newInstance();
/* 153 */         if (wrapWithFilteringCache)
/*     */         {
/*     */           
/* 156 */           cache = new FilteringCache(cache);
/*     */         }
/* 158 */         if (DEBUG) {
/* 159 */           logger_.debug("Initializing Cache [" + cacheId + "]");
/*     */         }
/* 161 */         cache.init(cacheId);
/*     */       }
/* 163 */       catch (Exception ee) {
/* 164 */         logger_.error("An exception occurred while create instance of class: " + this.permanentCacheConstructor_, ee);
/*     */         
/* 166 */         dummyCache = new DummyCache();
/* 167 */         dummyCache.init(cacheId);
/*     */       } 
/* 169 */       registeredCaches_.put(cacheId, dummyCache);
/*     */       
/* 171 */       return (ICache)dummyCache;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<ICache> getManagedCaches() {
/* 176 */     synchronized (registeredCaches_) {
/* 177 */       return new ArrayList<>(registeredCaches_.values());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 182 */     synchronized (registeredCaches_) {
/* 183 */       List<String> cacheKeys = new ArrayList<>(registeredCaches_.keySet());
/* 184 */       for (String cacheKey : cacheKeys) {
/* 185 */         ICache cache = registeredCaches_.remove(cacheKey);
/*     */         try {
/* 187 */           cache.destroy();
/*     */         }
/* 189 */         catch (Throwable t) {
/* 190 */           logger_.warn("Cache " + cache.getCacheId() + " could not be successfully destroyed.");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String massageCacheId(String argCacheId) {
/* 197 */     if (StringUtils.isEmpty(argCacheId)) {
/* 198 */       return "default-cache";
/*     */     }
/* 200 */     return argCacheId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class CacheAlreadyRegisteredException
/*     */     extends Exception
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CacheAlreadyRegisteredException(String message) {
/* 218 */       super(message);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\CacheManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */