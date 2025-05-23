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
/*    */ public class GlobalPropertiesConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String KEY_PROPERTY = "Property";
/* 25 */   private final Map<String, String> properties_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> getProperties() {
/* 31 */     return this.properties_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 37 */     if ("Property".equals(argKey)) {
/* 38 */       this.properties_.put(((CachePropertyConfig)argValue).getKey(), ((CachePropertyConfig)argValue).getValue());
/*    */     } else {
/*    */       
/* 41 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\GlobalPropertiesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */