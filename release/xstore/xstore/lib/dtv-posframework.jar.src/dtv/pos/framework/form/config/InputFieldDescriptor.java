/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.pos.iframework.form.IInputFieldDescriptor;
/*    */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*    */ import dtv.pos.iframework.ui.config.IEditFormatterParams;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.util.Properties;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class InputFieldDescriptor
/*    */   implements IInputFieldDescriptor
/*    */ {
/* 27 */   private static final Logger logger_ = Logger.getLogger(InputFieldDescriptor.class);
/*    */   
/*    */   private final IFormattable label_;
/*    */   private final String formatterType_;
/*    */   private final Properties formatModifiers_;
/*    */   
/*    */   public InputFieldDescriptor(IFormattableConfig argLabelConfig, IDataFieldConfig argDataFieldConfig) {
/* 34 */     this.label_ = argLabelConfig.getFormattable();
/* 35 */     this.formatterType_ = argDataFieldConfig.getFormatType().getFormatterType().toString();
/* 36 */     this.formatModifiers_ = new Properties();
/* 37 */     IEditFormatterParams efp = argDataFieldConfig.getEditFormatterParams();
/* 38 */     if (efp != null) {
/* 39 */       ParameterConfig[] params = efp.getConfigs();
/* 40 */       if (params != null) {
/* 41 */         for (ParameterConfig param : params) {
/* 42 */           IConfigObject v = param.getValue();
/* 43 */           if (v instanceof IReflectionParameterCapable) {
/* 44 */             this.formatModifiers_.put(param.getName(), ((IReflectionParameterCapable)v).getParamValue());
/*    */           } else {
/*    */             
/* 47 */             logger_.warn(ObjectUtils.getClassNameFromObject(v) + " does not implement " + IReflectionParameterCapable.class
/* 48 */                 .getName());
/*    */           } 
/*    */         } 
/*    */       } else {
/*    */         
/* 53 */         logger_.debug("ignoring null");
/*    */       } 
/*    */     } else {
/*    */       
/* 57 */       logger_.debug("ignoring null");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Properties getFormatModifiers() {
/* 63 */     return this.formatModifiers_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getFormatterType() {
/* 68 */     return this.formatterType_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IFormattable getLabel() {
/* 73 */     return this.label_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\InputFieldDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */