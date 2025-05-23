/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.pos.iframework.form.IInputFieldDescriptor;
/*    */ import dtv.pos.iframework.form.config.IInputFieldConfig;
/*    */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
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
/*    */ public class InputFieldConfig
/*    */   extends AbstractParentConfig
/*    */   implements IInputFieldConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private IFormattableConfig labelConfig_;
/*    */   private IDataFieldConfig dataFieldConfig_;
/*    */   
/*    */   public IInputFieldDescriptor getInputFieldDescriptor() {
/* 30 */     return new InputFieldDescriptor(this.labelConfig_, this.dataFieldConfig_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 35 */     if (argValue instanceof IDataFieldConfig) {
/* 36 */       this.dataFieldConfig_ = (IDataFieldConfig)argValue;
/*    */     }
/* 38 */     else if (argValue instanceof IFormattableConfig) {
/* 39 */       this.labelConfig_ = (IFormattableConfig)argValue;
/*    */     } else {
/*    */       
/* 42 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\InputFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */