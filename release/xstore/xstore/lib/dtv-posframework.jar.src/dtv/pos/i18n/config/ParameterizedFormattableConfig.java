/*    */ package dtv.pos.i18n.config;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ParameterizedFormattableConfig
/*    */   extends AbstractParentConfig
/*    */   implements IFormattableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*    */   
/* 29 */   private final List<IFormattableConfig> parameterList_ = new ArrayList<>();
/*    */   
/*    */   private IFormattable formattable_;
/*    */   
/*    */   private String translationKey_;
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 37 */     return "ParameterizedFormattable";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable() {
/* 49 */     return getFormattable(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable(Object argSourceObject) {
/* 55 */     if (argSourceObject == null) {
/* 56 */       if (this.formattable_ == null)
/*    */       {
/* 58 */         this.formattable_ = makeFormattable(null);
/*    */       }
/* 60 */       return this.formattable_;
/*    */     } 
/*    */     
/* 63 */     return makeFormattable(argSourceObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<IFormattable> getParamDataType() {
/* 70 */     return IFormattable.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getParamValue() {
/* 76 */     return getFormattable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 82 */     if ("TranslationKey".equalsIgnoreCase(argKey) || "key".equalsIgnoreCase(argKey)) {
/* 83 */       this.translationKey_ = argValue.toString();
/*    */     } else {
/*    */       
/* 86 */       this.parameterList_.add(FormattableConfig.toFormattableConfig(argValue));
/*    */     } 
/*    */   }
/*    */   
/*    */   private IFormattable makeFormattable(Object argSourceObject) {
/* 91 */     IFormattableConfig[] configs = this.parameterList_.<IFormattableConfig>toArray(new IFormattableConfig[0]);
/* 92 */     IFormattable[] params = new IFormattable[this.parameterList_.size()];
/*    */     
/* 94 */     for (int i = 0; i < configs.length; i++) {
/* 95 */       params[i] = configs[i].getFormattable(argSourceObject);
/*    */     }
/* 97 */     IFormattable f = FF.getTranslatable(this.translationKey_, params);
/* 98 */     f.setSourceDescription(getSourceDescription());
/* 99 */     return f;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\ParameterizedFormattableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */