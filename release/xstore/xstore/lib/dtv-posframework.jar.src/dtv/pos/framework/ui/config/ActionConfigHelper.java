/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IActionConfig;
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ public class ActionConfigHelper
/*    */   extends ConfigHelper<ActionSetConfig>
/*    */ {
/*    */   public IActionConfig getActionConfig(String argName) {
/* 27 */     return ((ActionSetConfig)getRootConfig()).getNamedConfigs().get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 33 */     super.initializeImpl();
/* 34 */     ((ActionSetConfig)getRootConfig()).initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void resolveReference(IActionConfig argConfig) {
/* 43 */     ((ActionSetConfig)getRootConfig()).resolveReference(argConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 49 */     return "ActionConfig";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ActionConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */