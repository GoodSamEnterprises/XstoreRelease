/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class FilterObjectConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String KEY_ID = "id";
/*    */   private static final String KEY_CACHEABLE = "cacheable";
/*    */   private String filterId_;
/*    */   private boolean cacheable_;
/*    */   
/*    */   public String getFilterId() {
/* 29 */     return this.filterId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isCacheable() {
/* 36 */     return this.cacheable_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 42 */     if ("id".equals(argKey)) {
/* 43 */       this.filterId_ = argValue.toString();
/*    */     }
/* 45 */     else if ("cacheable".equals(argKey)) {
/* 46 */       this.cacheable_ = ConfigUtils.toBoolean(argValue);
/*    */     } else {
/*    */       
/* 49 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\FilterObjectConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */