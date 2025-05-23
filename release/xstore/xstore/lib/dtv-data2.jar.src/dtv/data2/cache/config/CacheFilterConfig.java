/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
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
/*    */ 
/*    */ 
/*    */ public class CacheFilterConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String KEY_ID = "id";
/*    */   private static final String KEY_FILTER_OBJECT = "Object";
/*    */   private String cacheFilterId_;
/* 27 */   private final Map<String, Boolean> cacheFilter_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Boolean> getCacheFilter() {
/* 33 */     return this.cacheFilter_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCacheFilterId() {
/* 40 */     return this.cacheFilterId_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 46 */     if ("id".equals(argKey)) {
/* 47 */       this.cacheFilterId_ = argValue.toString();
/*    */     }
/* 49 */     else if ("Object".equals(argKey)) {
/* 50 */       this.cacheFilter_.put(((FilterObjectConfig)argValue).getFilterId(), 
/* 51 */           Boolean.valueOf(((FilterObjectConfig)argValue).isCacheable()));
/*    */     } else {
/*    */       
/* 54 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\CacheFilterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */