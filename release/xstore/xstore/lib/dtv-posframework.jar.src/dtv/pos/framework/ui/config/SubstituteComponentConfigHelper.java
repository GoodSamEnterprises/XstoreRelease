/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
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
/*    */ public class SubstituteComponentConfigHelper
/*    */   extends ConfigHelper<SubstituteComponentsConfig>
/*    */ {
/*    */   public static final String FILE_NAME = "SubstituteComponentConfig";
/* 26 */   private static final SubstituteComponentsConfigReloader _configReloader = new SubstituteComponentsConfigReloader();
/*    */ 
/*    */ 
/*    */   
/* 30 */   private static SubstituteComponentConfigHelper _instance = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SubstituteComponentsConfig getConfig() {
/* 38 */     return (SubstituteComponentsConfig)getHelper().getRootConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SubstituteComponentConfigHelper getHelper() {
/* 50 */     if (_instance == null) {
/* 51 */       _instance = new SubstituteComponentConfigHelper();
/*    */     } else {
/*    */       
/* 54 */       _configReloader.reloadIfNeeded();
/*    */     } 
/* 56 */     return _instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void reinitialize() {
/* 63 */     _instance = new SubstituteComponentConfigHelper();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SubstituteComponentConfigHelper() {
/* 70 */     initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 76 */     return "SubstituteComponentConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/*    */     IConfigObject object;
/* 84 */     if ("SubstituteComponents".equals(argTagName)) {
/* 85 */       SubstituteComponentsConfig substituteComponentsConfig = new SubstituteComponentsConfig();
/*    */     }
/* 87 */     else if ("SubstituteComponent".equals(argTagName)) {
/* 88 */       SubstituteComponentConfig substituteComponentConfig = new SubstituteComponentConfig();
/*    */     }
/* 90 */     else if ("Component".equals(argTagName)) {
/* 91 */       ViewComponentConfig<IViewComponentConfig> viewComponentConfig = new ViewComponentConfig<>();
/*    */     } else {
/*    */       
/* 94 */       object = super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */     } 
/* 96 */     return object;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SubstituteComponentConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */