/*     */ package dtv.pos.i18n.config;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EvaluatedFormattableConfig
/*     */   extends AbstractParentConfig
/*     */   implements IFormattableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   protected String methodNameChain_ = null;
/*  27 */   private FormatterType formatterType_ = null;
/*  28 */   protected final List<IConfigObject> methodParamList_ = new ArrayList<>();
/*     */   
/*     */   protected Class<?>[] paramClasses_;
/*     */   
/*     */   protected Object[] params_;
/*     */   
/*     */   private boolean asObjectArray_;
/*     */   
/*     */   public String getConfigDataType() {
/*  37 */     return "EvaluatedFormattable";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  43 */     return this.methodNameChain_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable() {
/*  49 */     if (this.paramClasses_ == null) {
/*  50 */       if (this.asObjectArray_) {
/*  51 */         this.paramClasses_ = new Class[] { Object[].class };
/*  52 */         this.params_ = new Object[1];
/*  53 */         Object[] array = new Object[this.methodParamList_.size()];
/*     */         
/*  55 */         for (int i = 0; i < this.methodParamList_.size(); i++) {
/*     */           
/*  57 */           IReflectionParameterCapable<?> config = (IReflectionParameterCapable)this.methodParamList_.get(i);
/*  58 */           if (config instanceof ParameterConfig && ((ParameterConfig)config)
/*  59 */             .getValue() instanceof EvaluatedFormattableConfig) {
/*  60 */             array[i] = ((EvaluatedFormattableConfig)((ParameterConfig)config)
/*  61 */               .getValue()).getFormattable()
/*  62 */               .getUnformattedData();
/*     */           } else {
/*     */             
/*  65 */             array[i] = config.getParamValue();
/*     */           } 
/*     */         } 
/*     */         
/*  69 */         this.params_[0] = array;
/*     */       } else {
/*     */         
/*  72 */         this.paramClasses_ = new Class[this.methodParamList_.size()];
/*  73 */         this.params_ = new Object[this.methodParamList_.size()];
/*  74 */         for (int i = 0; i < this.params_.length; i++) {
/*     */           
/*  76 */           IReflectionParameterCapable<?> config = (IReflectionParameterCapable)this.methodParamList_.get(i);
/*  77 */           this.paramClasses_[i] = config.getParamDataType();
/*  78 */           this.params_[i] = config.getParamValue();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  84 */     IFormattable f = FormattableFactory.getInstance().getEvaluatedFormattable(this.methodNameChain_, this.paramClasses_, this.params_, this.formatterType_);
/*     */     
/*  86 */     f.setSourceDescription(getSourceDescription());
/*  87 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable(Object argTargetObject) {
/*  93 */     if (this.paramClasses_ == null) {
/*  94 */       if (this.asObjectArray_) {
/*  95 */         this.paramClasses_ = new Class[] { Object[].class };
/*  96 */         this.params_ = new Object[1];
/*  97 */         Object[] array = new Object[this.methodParamList_.size()];
/*     */         
/*  99 */         for (int i = 0; i < this.methodParamList_.size(); i++) {
/*     */           
/* 101 */           IReflectionParameterCapable<?> config = (IReflectionParameterCapable)this.methodParamList_.get(i);
/* 102 */           if (config instanceof ParameterConfig && ((ParameterConfig)config)
/* 103 */             .getValue() instanceof EvaluatedFormattableConfig) {
/* 104 */             array[i] = ((EvaluatedFormattableConfig)((ParameterConfig)config)
/* 105 */               .getValue()).getFormattable(argTargetObject)
/* 106 */               .getUnformattedData();
/*     */           } else {
/*     */             
/* 109 */             array[i] = config.getParamValue();
/*     */           } 
/*     */         } 
/*     */         
/* 113 */         this.params_[0] = array;
/*     */       } else {
/*     */         
/* 116 */         this.paramClasses_ = new Class[this.methodParamList_.size()];
/* 117 */         this.params_ = new Object[this.methodParamList_.size()];
/* 118 */         for (int i = 0; i < this.params_.length; i++) {
/*     */           
/* 120 */           IReflectionParameterCapable<?> config = (IReflectionParameterCapable)this.methodParamList_.get(i);
/* 121 */           this.paramClasses_[i] = config.getParamDataType();
/* 122 */           if (config instanceof ParameterConfig && ((ParameterConfig)config)
/* 123 */             .getValue() instanceof EvaluatedFormattableConfig) {
/* 124 */             this.params_[i] = ((EvaluatedFormattableConfig)((ParameterConfig)config)
/* 125 */               .getValue())
/* 126 */               .getFormattable(argTargetObject);
/*     */           } else {
/*     */             
/* 129 */             this.params_[i] = config.getParamValue();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 136 */     IFormattable f = FormattableFactory.getInstance().getEvaluatedFormattable(this.methodNameChain_, this.paramClasses_, this.params_, this.formatterType_, argTargetObject);
/*     */     
/* 138 */     f.setSourceDescription(getSourceDescription());
/* 139 */     return f;
/*     */   }
/*     */   
/*     */   public FormatterType getFormatterType() {
/* 143 */     return this.formatterType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<IFormattable> getParamDataType() {
/* 149 */     return IFormattable.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getParamValue() {
/* 155 */     return getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 161 */     if ("method".equalsIgnoreCase(argKey) || "method2".equalsIgnoreCase(argKey)) {
/* 162 */       setMethodNameChain(argValue.toString());
/*     */     }
/* 164 */     else if ("method_param".equalsIgnoreCase(argKey)) {
/* 165 */       this.methodParamList_.add(argValue);
/*     */     }
/* 167 */     else if ("formatter".equalsIgnoreCase(argKey)) {
/* 168 */       setFormatterType(FormatterType.forName(argValue.toString()));
/*     */     }
/* 170 */     else if ("asObjectArray".equalsIgnoreCase(argKey)) {
/* 171 */       this.asObjectArray_ = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/* 174 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setFormatterType(FormatterType formatterType) {
/* 179 */     this.formatterType_ = formatterType;
/*     */   }
/*     */   
/*     */   private void setMethodNameChain(String methodNameChain) {
/* 183 */     this.methodNameChain_ = methodNameChain;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\EvaluatedFormattableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */