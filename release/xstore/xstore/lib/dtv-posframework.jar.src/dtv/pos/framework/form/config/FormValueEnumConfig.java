/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.pos.iframework.form.IEnumLoader;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*     */ import dtv.pos.iframework.form.config.IFormValueEnumListConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterListConfig;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormValueEnumConfig
/*     */   extends AbstractParentConfig
/*     */   implements IFormValueEnumConfig
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(FormValueEnumConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private final ParameterListConfig loaderParams_ = new ParameterListConfig();
/*     */   
/*     */   private FormValueEnumListConfig configuredValues_;
/*     */   
/*     */   private IEnumLoader loader_;
/*     */   
/*     */   private ClassConfig<? extends IEnumLoader> loaderClass_;
/*     */   private boolean nullAllowed_ = false;
/*     */   
/*     */   public IFormValueEnumListConfig getConfiguredValues() {
/*  40 */     return this.configuredValues_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ParameterListConfig getLoaderParams() {
/*  46 */     return this.loaderParams_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends Object> getValues() {
/*  52 */     if (getLoader() == null) {
/*  53 */       IFormValueEnumListConfig cv = getConfiguredValues();
/*  54 */       return cv.getValues();
/*     */     } 
/*  56 */     return getLoader().getValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getWrapperFactory() {
/*  62 */     if (getLoader() == null) {
/*  63 */       return null;
/*     */     }
/*  65 */     return getLoader().getWrapperFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNullAllowed() {
/*  71 */     return this.nullAllowed_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  78 */     if ("loader".equalsIgnoreCase(argKey)) {
/*  79 */       this.loaderClass_ = ConfigUtils.toClassConfig(argValue);
/*     */     }
/*  81 */     else if (argValue instanceof FormValueEnumListConfig) {
/*  82 */       this.configuredValues_ = (FormValueEnumListConfig)argValue;
/*     */     }
/*  84 */     else if (argValue instanceof dtv.util.config.ParameterConfig) {
/*  85 */       this.loaderParams_.setConfigObject(argKey, argValue);
/*     */     }
/*  87 */     else if ("nullAllowed".equalsIgnoreCase(argKey)) {
/*  88 */       this.nullAllowed_ = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/*  91 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private IEnumLoader getLoader() {
/*  96 */     if (this.loader_ == null && this.loaderClass_ != null) {
/*     */       try {
/*  98 */         this.loader_ = this.loaderClass_.getValue().newInstance();
/*     */       }
/* 100 */       catch (Exception ex) {
/* 101 */         logger_.error("unable to instantiate enum loader class " + this.loaderClass_.getConfigValue(), ex);
/* 102 */         throw new IllegalArgumentException("enum loader class " + this.loaderClass_.getConfigValue() + " must implement no arg constructor");
/*     */       } 
/*     */       
/* 105 */       this.loader_.setConfig(this);
/*     */     } 
/* 107 */     return this.loader_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormValueEnumConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */