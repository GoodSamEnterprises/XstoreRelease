/*    */ package dtv.pos.framework.ui.config;
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
/*    */ 
/*    */ public class SecondaryPromptConfigHelper
/*    */   extends ConfigHelper<SecondaryPromptSetConfig>
/*    */ {
/*    */   public static final String FILE_NAME = "SecondaryPromptConfig";
/* 25 */   private static final SecondaryPromptConfigReloader _configReloader = new SecondaryPromptConfigReloader();
/*    */ 
/*    */   
/* 28 */   private static SecondaryPromptConfigHelper _instance = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SecondaryPromptConfigHelper getHelper() {
/* 36 */     if (_instance == null) {
/* 37 */       _instance = new SecondaryPromptConfigHelper();
/*    */     } else {
/*    */       
/* 40 */       _configReloader.reloadIfNeeded();
/*    */     } 
/* 42 */     return _instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void reinitialize() {
/* 49 */     _instance = new SecondaryPromptConfigHelper();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SecondaryPromptSetConfig getConfig() {
/* 58 */     return (SecondaryPromptSetConfig)getHelper().getRootConfig();
/*    */   }
/*    */ 
/*    */   
/*    */   private SecondaryPromptConfigHelper() {
/* 63 */     initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 69 */     return "SecondaryPromptConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/*    */     IConfigObject object;
/* 76 */     if ("SecondaryPromptSet".equals(argTagName)) {
/* 77 */       SecondaryPromptSetConfig secondaryPromptSetConfig = new SecondaryPromptSetConfig();
/*    */     }
/* 79 */     else if ("SecondaryPrompt".equals(argTagName)) {
/* 80 */       SecondaryPromptConfig secondaryPromptConfig = new SecondaryPromptConfig();
/*    */     } else {
/*    */       
/* 83 */       object = super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */     } 
/* 85 */     return object;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SecondaryPromptConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */