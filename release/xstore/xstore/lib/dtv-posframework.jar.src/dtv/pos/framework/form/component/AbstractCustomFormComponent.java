/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*    */ import dtv.pos.iframework.form.component.IFormComponent;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import javax.swing.JComponent;
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
/*    */ public abstract class AbstractCustomFormComponent<T extends IFormModel>
/*    */   implements IFormComponent<T>
/*    */ {
/*    */   public IFormComponentConfig<?> getConfig() {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getContainer() {
/* 36 */     return getDisplayComponent();
/*    */   }
/*    */   
/*    */   public void init(ResolvedFieldConfig argFieidDef) {}
/*    */   
/*    */   public void init(IFormComponentConfig<?> argCfg) {}
/*    */   
/*    */   public void setConfig(IFormComponentConfig<?> newValue) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\AbstractCustomFormComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */