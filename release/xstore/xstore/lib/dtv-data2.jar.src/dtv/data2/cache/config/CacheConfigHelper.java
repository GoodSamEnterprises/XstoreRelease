/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.util.config.BooleanConfig;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.StringConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CacheConfigHelper
/*    */   extends ConfigHelper<CacheConfig>
/*    */ {
/*    */   private static CacheConfig cacheConfig_;
/*    */   
/*    */   static {
/* 22 */     (new CacheConfigHelper()).initialize();
/*    */   }
/*    */   
/*    */   public static CacheConfig getCacheConfig() {
/* 26 */     return cacheConfig_;
/*    */   }
/*    */   
/*    */   public static CacheDefinitionConfig getCacheDefConfig(String argCacheId) {
/* 30 */     CacheDefinitionConfig cacheConfig = cacheConfig_.getCaches().get(argCacheId);
/* 31 */     if (cacheConfig != null) {
/* 32 */       return cacheConfig;
/*    */     }
/*    */     
/* 35 */     return cacheConfig_.getCaches().get("default-cache");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hashRootConfigs() {
/* 41 */     super.hashRootConfigs();
/* 42 */     cacheConfig_ = (CacheConfig)getRootConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 48 */     return "CacheConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 53 */     if ("CacheConfig".equals(argTagName)) {
/* 54 */       return (IConfigObject)new CacheConfig();
/*    */     }
/* 56 */     if ("id".equals(argTagName) || "key"
/* 57 */       .equals(argTagName) || "value"
/* 58 */       .equals(argTagName) || "Impl"
/* 59 */       .equals(argTagName) || "CacheFilterRef"
/* 60 */       .equals(argTagName)) {
/* 61 */       return (IConfigObject)new StringConfig();
/*    */     }
/* 63 */     if ("clearable".equals(argTagName) || "cacheable"
/* 64 */       .equals(argTagName)) {
/* 65 */       return (IConfigObject)new BooleanConfig();
/*    */     }
/* 67 */     if ("GlobalProperties".equals(argTagName)) {
/* 68 */       return (IConfigObject)new GlobalPropertiesConfig();
/*    */     }
/* 70 */     if ("Cache".equals(argTagName)) {
/* 71 */       return (IConfigObject)new CacheDefinitionConfig();
/*    */     }
/* 73 */     if ("Property".equals(argTagName)) {
/* 74 */       return (IConfigObject)new CachePropertyConfig();
/*    */     }
/* 76 */     if ("CacheFilter".equals(argTagName)) {
/* 77 */       return (IConfigObject)new CacheFilterConfig();
/*    */     }
/* 79 */     if ("Object".equals(argTagName)) {
/* 80 */       return (IConfigObject)new FilterObjectConfig();
/*    */     }
/* 82 */     if ("WriteThroughCacheEnabled".equals(argTagName)) {
/* 83 */       return (IConfigObject)new BooleanConfig();
/*    */     }
/*    */     
/* 86 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\CacheConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */