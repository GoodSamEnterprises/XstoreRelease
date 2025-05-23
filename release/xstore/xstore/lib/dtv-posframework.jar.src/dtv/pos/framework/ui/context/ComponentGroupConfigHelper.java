/*    */ package dtv.pos.framework.ui.context;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import javax.inject.Inject;
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
/*    */ 
/*    */ public class ComponentGroupConfigHelper
/*    */   extends ConfigHelper<ComponentGroupSetConfig>
/*    */ {
/*    */   @Inject
/*    */   private ComponentPropertySetConfigHelper _componentPropertySetHelper;
/*    */   
/*    */   public ComponentGroupConfig getComponentGroupConfig(String argName) {
/* 32 */     return ((ComponentGroupSetConfig)getRootConfig()).getNamedConfigs().get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 38 */     super.initializeImpl();
/* 39 */     ((ComponentGroupSetConfig)getRootConfig()).initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void resolveReference(ComponentGroupConfig argConfig) {
/* 48 */     ((ComponentGroupSetConfig)getRootConfig()).resolveReference(argConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 54 */     return "ComponentGroupConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, IConfigObject argParent, String argSourceDescription) {
/* 61 */     IConfigObject configObject = super.getConfigObject(argTagName, argDtype, argParent, argSourceDescription);
/*    */ 
/*    */ 
/*    */     
/* 65 */     if (configObject instanceof ComponentGroupConfig) {
/* 66 */       ComponentGroupConfig groupConfig = (ComponentGroupConfig)configObject;
/* 67 */       groupConfig.setComponentPropertySetHelper(this._componentPropertySetHelper);
/*    */     } 
/*    */     
/* 70 */     return configObject;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentGroupConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */