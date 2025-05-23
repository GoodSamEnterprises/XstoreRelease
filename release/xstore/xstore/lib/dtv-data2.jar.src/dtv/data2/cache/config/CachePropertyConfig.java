/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
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
/*    */ 
/*    */ 
/*    */ public class CachePropertyConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String KEY_KEY = "key";
/*    */   private static final String KEY_VALUE = "value";
/*    */   private String key_;
/*    */   private String value_;
/*    */   
/*    */   public String getKey() {
/* 30 */     return this.key_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 37 */     return this.value_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 43 */     if ("key".equals(argKey)) {
/* 44 */       this.key_ = argValue.toString();
/*    */     }
/* 46 */     else if ("value".equals(argKey)) {
/* 47 */       this.value_ = argValue.toString();
/*    */     } else {
/*    */       
/* 50 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\CachePropertyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */