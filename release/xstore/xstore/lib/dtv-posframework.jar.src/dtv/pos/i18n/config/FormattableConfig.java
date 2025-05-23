/*    */ package dtv.pos.i18n.config;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.FormatterType;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.TranslationHelper;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
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
/*    */ public class FormattableConfig
/*    */   extends AbstractParentConfig
/*    */   implements IFormattableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String DATA_TAG = "Data";
/*    */   private static final String FORMATTER_TYPE_TAG = "Formatter";
/*    */   
/*    */   public static IFormattableConfig toFormattableConfig(IConfigObject argValue) {
/* 34 */     if (argValue instanceof IFormattableConfig) {
/* 35 */       return (IFormattableConfig)argValue;
/*    */     }
/*    */     
/* 38 */     String keyOrText = argValue.toString();
/* 39 */     return TranslationHelper.getInstance().isTranslationKey(keyOrText) ? new TranslatableConfig(keyOrText) : new LiteralConfig(keyOrText);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   private Object data_ = null;
/* 46 */   private FormatterType formatterType_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 51 */     return "Formattable";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 57 */     return this.data_.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable() {
/* 63 */     return getFormattable((Object)null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable(Object argSourceObject) {
/* 69 */     IFormattable f = FormattableFactory.getInstance().getSimpleFormattable(this.data_, this.formatterType_);
/* 70 */     f.setSourceDescription(getSourceDescription());
/* 71 */     return f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<IFormattable> getParamDataType() {
/* 77 */     return IFormattable.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getParamValue() {
/* 83 */     return getFormattable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 89 */     if (argValue instanceof IReflectionParameterCapable && argKey.equalsIgnoreCase("Data")) {
/* 90 */       this.data_ = ((IReflectionParameterCapable)argValue).getParamValue();
/*    */     }
/* 92 */     else if (argKey.equalsIgnoreCase("Formatter")) {
/* 93 */       this.formatterType_ = FormatterType.forName(argValue.toString());
/*    */     } else {
/*    */       
/* 96 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\FormattableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */