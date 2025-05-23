/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.config.IRootComponentConfig;
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormLayoutConfig
/*     */   extends AbstractParentConfig
/*     */   implements IRootComponentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "FormLayout";
/*     */   private static final String NAME_TAG = "Name";
/*     */   private static final String TAB_POSITION_TAG = "TabPosition";
/*     */   private IViewComponentConfig mainComponent_;
/*     */   private String name_;
/*     */   private int tabPosition_;
/*     */   
/*     */   public IViewComponentConfig getMainComponent() {
/*  44 */     return this.mainComponent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTabPosition() {
/*  63 */     return this.tabPosition_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  74 */     if (argValue instanceof ViewComponentConfig) {
/*  75 */       setMainComponent((ViewComponentConfig)argValue);
/*     */     }
/*  77 */     else if (argKey.equalsIgnoreCase("Name")) {
/*  78 */       setName(argValue.toString());
/*     */     }
/*  80 */     else if (argKey.equalsIgnoreCase("TabPosition")) {
/*  81 */       setTabPosition(Integer.valueOf(argValue.toString()).intValue());
/*     */     } else {
/*     */       
/*  84 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setMainComponent(ViewComponentConfig argMainComponent) {
/*  90 */     this.mainComponent_ = (argMainComponent != null) ? (IViewComponentConfig)argMainComponent : (IViewComponentConfig)new ViewComponentConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setName(String argName) {
/*  95 */     this.name_ = argName;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setTabPosition(int argTabPosition) {
/* 100 */     this.tabPosition_ = argTabPosition;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormLayoutConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */