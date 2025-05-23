/*    */ package dtv.pos.framework.ui.context;
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
/*    */ 
/*    */ 
/*    */ public class ComponentPropertySetConfigHelper
/*    */   extends ConfigHelper<ComponentPropertySetsConfig>
/*    */ {
/*    */   public static final String CONFIG_FILE_NAME = "uipropertysets";
/*    */   
/*    */   public ComponentPropertySetConfig getComponentPropertySetConfig(String argName) {
/* 29 */     return ((ComponentPropertySetsConfig)getRootConfig()).getNamedConfigs().get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 35 */     super.initializeImpl();
/* 36 */     ((ComponentPropertySetsConfig)getRootConfig()).initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void resolveReference(ComponentPropertySetConfig argConfig) {
/* 45 */     ((ComponentPropertySetsConfig)getRootConfig()).resolveReference(argConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 51 */     return "uipropertysets";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 57 */     if ("ComponentPropertySets".equalsIgnoreCase(argDtype)) {
/* 58 */       return (IConfigObject)new ComponentPropertySetsConfig();
/*    */     }
/* 60 */     if ("ComponentPropertySet".equalsIgnoreCase(argDtype)) {
/* 61 */       return (IConfigObject)new ComponentPropertySetConfig();
/*    */     }
/* 63 */     if ("ComponentProperty".equalsIgnoreCase(argDtype)) {
/* 64 */       return (IConfigObject)new ComponentPropertyConfig();
/*    */     }
/*    */     
/* 67 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDirectoryBased() {
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentPropertySetConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */