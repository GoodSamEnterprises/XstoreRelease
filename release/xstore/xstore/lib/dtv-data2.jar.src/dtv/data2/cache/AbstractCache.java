/*     */ package dtv.data2.cache;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractCache
/*     */   implements ICache
/*     */ {
/*     */   private String cacheId_;
/*     */   protected static final String GLOBAL_CACHE_CONFIG_ID = "global";
/*  24 */   protected static final NullValue NULL_VALUE = new NullValue();
/*     */ 
/*     */ 
/*     */   
/*  28 */   protected static final NotCachedException NOT_CACHED_EXCEPTION = new NotCachedException();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   protected final Logger logger_ = Logger.getLogger(getClass());
/*  35 */   protected final boolean DEBUG = this.logger_.isDebugEnabled();
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  40 */     if (this.DEBUG) this.logger_.debug("begin clear() cache: " + getCacheId()); 
/*  41 */     clearImpl();
/*  42 */     if (this.DEBUG) this.logger_.debug("end clear() cache: " + getCacheId());
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroy() {
/*  48 */     if (this.DEBUG) this.logger_.debug("begin destroy() cache: " + getCacheId()); 
/*  49 */     destroyImpl();
/*  50 */     if (this.DEBUG) this.logger_.debug("end destroy() cache: " + getCacheId());
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get(Object argKey) throws NotCachedException {
/*  57 */     if (this.DEBUG) this.logger_.debug("begin get() on cache '" + getCacheId() + "' for key: " + argKey); 
/*  58 */     Object value = getImpl(argKey);
/*  59 */     if (value == null) {
/*  60 */       if (this.DEBUG) this.logger_.debug("CACHE MISS: cache '" + getCacheId() + "' does not contain key: " + argKey); 
/*  61 */       throw NOT_CACHED_EXCEPTION;
/*     */     } 
/*     */     
/*  64 */     if (value instanceof NullValue) {
/*  65 */       if (this.DEBUG)
/*  66 */         this.logger_.debug("CACHE HIT: cache '" + getCacheId() + "' contains key: " + argKey + " value: null"); 
/*  67 */       return null;
/*     */     } 
/*     */     
/*  70 */     if (this.DEBUG) {
/*  71 */       this.logger_.debug("CACHE HIT: cache '" + getCacheId() + "' contains key: " + argKey + " value: " + value);
/*     */     }
/*  73 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCacheId() {
/*  81 */     return this.cacheId_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getSafely(Object argKey) {
/*  86 */     if (this.DEBUG) this.logger_.debug("begin get() on cache '" + getCacheId() + "' for key: " + argKey); 
/*  87 */     Object value = getImpl(argKey);
/*  88 */     if (this.DEBUG) {
/*  89 */       if (value == null) {
/*  90 */         this.logger_.debug("CACHE MISS: cache '" + getCacheId() + "' does not contain key: " + argKey);
/*     */       }
/*  92 */       else if (value instanceof NullValue) {
/*  93 */         this.logger_.debug("CACHE HIT: cache '" + getCacheId() + "' contains key: " + argKey + " value: null");
/*     */       } else {
/*     */         
/*  96 */         this.logger_.debug("CACHE HIT: cache '" + getCacheId() + "' contains key: " + argKey + " value: " + value);
/*     */       } 
/*     */     }
/*  99 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusReport() {
/* 105 */     return getClass().getName() + " cache id: [" + getCacheId() + "]\n" + getStatusDetails();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(String argCacheId) {
/* 111 */     setCacheId(argCacheId);
/* 112 */     if (this.DEBUG) this.logger_.debug("begin init() cache: " + getCacheId()); 
/* 113 */     initImpl(argCacheId);
/* 114 */     if (this.DEBUG) this.logger_.debug("end init() cache: " + getCacheId());
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(Object argKey, Object argValue) {
/* 120 */     if (this.DEBUG)
/* 121 */       this.logger_.debug("begin put() into cache '" + getCacheId() + "' argKey " + argKey + " value " + argValue); 
/* 122 */     putImpl(argKey, argValue);
/* 123 */     if (this.DEBUG) {
/* 124 */       this.logger_.debug("end put() into cache '" + getCacheId() + "' argKey " + argKey + " value " + argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Object argKey) {
/* 130 */     if (this.DEBUG) this.logger_.debug("begin remove() from cache '" + getCacheId() + "' for argKey: " + argKey); 
/* 131 */     removeImpl(argKey);
/* 132 */     if (this.DEBUG) this.logger_.debug("end remove() from cache '" + getCacheId());
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCacheId(String argCacheId) {
/* 139 */     this.cacheId_ = argCacheId;
/*     */   }
/*     */   
/*     */   protected abstract void clearImpl();
/*     */   
/*     */   protected abstract void destroyImpl();
/*     */   
/*     */   protected abstract Object getImpl(Object paramObject);
/*     */   
/*     */   protected abstract String getStatusDetails();
/*     */   
/*     */   protected abstract void initImpl(String paramString);
/*     */   
/*     */   protected abstract void putImpl(Object paramObject1, Object paramObject2);
/*     */   
/*     */   protected abstract void removeImpl(Object paramObject);
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\AbstractCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */