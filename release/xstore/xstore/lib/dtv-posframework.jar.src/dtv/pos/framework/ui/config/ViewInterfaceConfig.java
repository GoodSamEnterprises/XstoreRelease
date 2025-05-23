/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
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
/*    */ 
/*    */ public class ViewInterfaceConfig
/*    */   extends AbstractParentConfig
/*    */   implements IRootComponentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "UI";
/*    */   private static final String NAME_TAG = "Name";
/*    */   private IViewComponentConfig mainComponent_;
/*    */   private String name_;
/*    */   
/*    */   public IViewComponentConfig getMainComponent() {
/* 33 */     return this.mainComponent_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 42 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if (argKey.equalsIgnoreCase("Component") && argValue instanceof ViewComponentConfig) {
/*    */       
/* 49 */       setMainComponent((ViewComponentConfig)argValue);
/*    */     }
/* 51 */     else if (argKey.equalsIgnoreCase("Name") && argValue instanceof dtv.util.config.StringConfig) {
/* 52 */       setName(argValue.toString());
/*    */     } else {
/*    */       
/* 55 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setName(String argName) {
/* 60 */     this.name_ = argName;
/*    */   }
/*    */   
/*    */   private void setMainComponent(ViewComponentConfig mainComponent) {
/* 64 */     this.mainComponent_ = (mainComponent == null) ? new ViewComponentConfig<>() : mainComponent;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ViewInterfaceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */