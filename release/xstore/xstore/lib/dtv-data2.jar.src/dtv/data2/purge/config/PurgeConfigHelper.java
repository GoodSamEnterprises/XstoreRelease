/*    */ package dtv.data2.purge.config;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ public class PurgeConfigHelper
/*    */   extends ConfigHelper<PurgeRootConfig>
/*    */ {
/*    */   public PurgeConfigHelper() {
/* 24 */     initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 30 */     return "PurgeConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 35 */     IConfigObject config = null;
/*    */     
/* 37 */     if ("Root".equalsIgnoreCase(argTagName)) {
/* 38 */       config = new PurgeRootConfig();
/*    */     }
/* 40 */     else if ("Group".equalsIgnoreCase(argTagName)) {
/* 41 */       config = new PurgeGroupConfig();
/*    */     }
/* 43 */     else if ("Query".equalsIgnoreCase(argTagName)) {
/* 44 */       config = new PurgeQueryConfig();
/*    */     } 
/* 46 */     return (config == null) ? super.getConfigObject(argTagName, dtype, argSourceDescription) : config;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\PurgeConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */