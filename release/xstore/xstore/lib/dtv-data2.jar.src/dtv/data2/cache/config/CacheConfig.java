/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.BooleanConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CacheConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String KEY_CACHE = "Cache";
/*    */   private static final String KEY_GLOBAL_PROPERTIES = "GlobalProperties";
/*    */   private static final String KEY_CACHE_FILTER = "CacheFilter";
/*    */   private static final String KEY_CACHE_MODE = "WriteThroughCacheEnabled";
/* 27 */   private final Map<String, CacheDefinitionConfig> caches_ = new HashMap<>();
/* 28 */   private final Map<String, CacheFilterConfig> cacheFilters_ = new HashMap<>();
/*    */   
/* 30 */   private GlobalPropertiesConfig globalProperties_ = null;
/*    */   private boolean writeThroughEnabled_ = true;
/*    */   
/*    */   public Map<String, Boolean> getCacheFilter(String argFilterId) {
/* 34 */     CacheFilterConfig config = this.cacheFilters_.get(argFilterId);
/* 35 */     return (config != null) ? config.getCacheFilter() : null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, CacheFilterConfig> getCacheFilters() {
/* 42 */     return this.cacheFilters_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, CacheDefinitionConfig> getCaches() {
/* 49 */     return this.caches_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GlobalPropertiesConfig getGlobalProperties() {
/* 56 */     return this.globalProperties_;
/*    */   }
/*    */   
/*    */   public boolean getWriteThroughEnabled() {
/* 60 */     return this.writeThroughEnabled_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 66 */     if ("Cache".equals(argKey)) {
/* 67 */       this.caches_.put(((CacheDefinitionConfig)argValue).getCacheId(), (CacheDefinitionConfig)argValue);
/*    */     }
/* 69 */     else if ("GlobalProperties".equals(argKey)) {
/* 70 */       if (this.globalProperties_ == null) {
/* 71 */         this.globalProperties_ = (GlobalPropertiesConfig)argValue;
/*    */       } else {
/*    */         
/* 74 */         Map<String, String> newProperties = ((GlobalPropertiesConfig)argValue).getProperties();
/* 75 */         this.globalProperties_.getProperties().putAll(newProperties);
/*    */       }
/*    */     
/* 78 */     } else if ("CacheFilter".equals(argKey)) {
/* 79 */       if (!this.cacheFilters_.containsKey(((CacheFilterConfig)argValue).getCacheFilterId())) {
/* 80 */         this.cacheFilters_.put(((CacheFilterConfig)argValue).getCacheFilterId(), (CacheFilterConfig)argValue);
/*    */       
/*    */       }
/*    */       else {
/*    */ 
/*    */         
/* 86 */         Map<String, Boolean> oldFilter = ((CacheFilterConfig)this.cacheFilters_.get(((CacheFilterConfig)argValue).getCacheFilterId())).getCacheFilter();
/* 87 */         Map<String, Boolean> newFilter = ((CacheFilterConfig)argValue).getCacheFilter();
/*    */         
/* 89 */         for (String key : newFilter.keySet()) {
/* 90 */           oldFilter.put(key, newFilter.get(key));
/*    */         }
/*    */       }
/*    */     
/* 94 */     } else if ("WriteThroughCacheEnabled".equals(argKey)) {
/* 95 */       this.writeThroughEnabled_ = ((BooleanConfig)argValue).getBoolean().booleanValue();
/*    */     } else {
/*    */       
/* 98 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\CacheConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */