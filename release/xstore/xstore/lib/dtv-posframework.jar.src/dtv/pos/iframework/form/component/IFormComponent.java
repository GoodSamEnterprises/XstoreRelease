/*    */ package dtv.pos.iframework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*    */ import dtv.pos.iframework.IModelView;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
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
/*    */ public interface IFormComponent<T extends dtv.pos.iframework.ui.model.IFormModel>
/*    */   extends IModelView<T>, IXstViewComponent
/*    */ {
/* 29 */   public static final Object CONFIG_PROPERTY_KEY = new Object();
/*    */   
/*    */   IFormComponentConfig<?> getConfig();
/*    */   
/*    */   JComponent getContainer();
/*    */   
/*    */   void init(ResolvedFieldConfig paramResolvedFieldConfig);
/*    */   
/*    */   void init(IFormComponentConfig<?> paramIFormComponentConfig);
/*    */   
/*    */   void setConfig(IFormComponentConfig<?> paramIFormComponentConfig);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\component\IFormComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */