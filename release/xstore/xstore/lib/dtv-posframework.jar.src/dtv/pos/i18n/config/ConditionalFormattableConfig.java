/*     */ package dtv.pos.i18n.config;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.condition.ICondition;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.util.IHasParameters;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConditionalFormattableConfig
/*     */   extends EvaluatedFormattableConfig
/*     */   implements IFormattableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private ICondition condition_;
/*     */   
/*     */   private IFormattable trueResult_;
/*     */   
/*     */   private IFormattable falseResult_;
/*     */   
/*     */   public String getConfigDataType() {
/*  35 */     return "ConditionalFormattable";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  41 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable() {
/*  47 */     return getFormattable((Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable(Object argSourceObject) {
/*  53 */     if (this.condition_ instanceof IHasParameters) {
/*  54 */       ((IHasParameters)this.condition_).setParameter("targetObject", argSourceObject);
/*     */     }
/*     */     
/*  57 */     Object sourceObject = argSourceObject;
/*     */     
/*  59 */     if (this.methodNameChain_ != null) {
/*  60 */       if (this.paramClasses_ == null) {
/*  61 */         this.paramClasses_ = new Class[this.methodParamList_.size()];
/*  62 */         this.params_ = new Object[this.methodParamList_.size()];
/*  63 */         for (int i = 0; i < this.params_.length; i++) {
/*     */           
/*  65 */           IReflectionParameterCapable<?> config = (IReflectionParameterCapable)this.methodParamList_.get(i);
/*  66 */           this.paramClasses_[i] = config.getParamDataType();
/*  67 */           this.params_[i] = config.getParamValue();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  72 */       sourceObject = ObjectUtils.invokeMethodChain(this.methodNameChain_, sourceObject, this.paramClasses_, this.params_, 
/*  73 */           getSourceDescription());
/*     */     } 
/*  75 */     return FF.getConditionalFormattable(this.condition_, sourceObject, this.trueResult_, this.falseResult_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<IFormattable> getParamDataType() {
/*  81 */     return IFormattable.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getParamValue() {
/*  87 */     return getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  93 */     if (argValue instanceof ConditionConfig) {
/*  94 */       this.condition_ = ((ConditionConfig)argValue).getCondition();
/*     */     }
/*  96 */     else if (argValue instanceof ParameterConfig && ((ParameterConfig)argValue)
/*  97 */       .getName().equalsIgnoreCase("true")) {
/*  98 */       this.trueResult_ = ((IFormattableConfig)((ParameterConfig)argValue).getValue()).getFormattable();
/*     */     }
/* 100 */     else if (argValue instanceof ParameterConfig && ((ParameterConfig)argValue)
/* 101 */       .getName().equalsIgnoreCase("false")) {
/* 102 */       this.falseResult_ = ((IFormattableConfig)((ParameterConfig)argValue).getValue()).getFormattable();
/*     */     } else {
/*     */       
/* 105 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\ConditionalFormattableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */