/*     */ package dtv.pos.i18n.config;
/*     */ 
/*     */ import dtv.i18n.condition.ICondition;
/*     */ import dtv.util.IHasParameters;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.util.ArrayList;
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
/*     */ public class ConditionConfig
/*     */   extends AbstractParentConfig
/*     */   implements IReflectionParameterCapable<ICondition>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private static final Logger logger_ = Logger.getLogger(ConditionConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Condition";
/*     */   
/*     */   private IConfigObject conditionClass_;
/*  33 */   private List<ParameterConfig> parameterConfigs_ = new ArrayList<>();
/*  34 */   private List<ConditionConfig> subConditions_ = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private ICondition condition_;
/*     */ 
/*     */ 
/*     */   
/*     */   public ICondition getCondition() {
/*  42 */     if (this.condition_ == null && this.conditionClass_ != null) {
/*     */       try {
/*  44 */         this.condition_ = ConfigUtils.toClassConfig(this.conditionClass_).getValue().newInstance();
/*     */       }
/*  46 */       catch (InstantiationException|IllegalAccessException ex) {
/*  47 */         logger_.warn("Could not instantiate " + this.conditionClass_.toString(), ex);
/*     */       } 
/*     */       
/*  50 */       if (this.condition_ instanceof IHasParameters) {
/*  51 */         for (ParameterConfig config : this.parameterConfigs_) {
/*  52 */           ((IHasParameters)this.condition_).setParameter(config.getName(), config.getValue());
/*     */         }
/*  54 */         for (ConditionConfig config : this.subConditions_) {
/*  55 */           ((IHasParameters)this.condition_).setParameter("Condition", config.getCondition());
/*     */         }
/*     */       }
/*  58 */       else if (this.parameterConfigs_.size() > 0 && this.condition_ != null) {
/*  59 */         logger_.warn("Could not initialize the parameters on condition " + this.condition_.getClass() + ". Must be an instance of " + IHasParameters.class);
/*     */       } 
/*     */     } 
/*     */     
/*  63 */     return this.condition_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  69 */     return "Condition";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  75 */     return (this.conditionClass_ != null) ? this.conditionClass_.toString() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<ICondition> getParamDataType() {
/*  81 */     return ICondition.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICondition getParamValue() {
/*  87 */     return getCondition();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  93 */     if (argKey.equalsIgnoreCase("Class") || argValue instanceof dtv.util.config.ClassConfig) {
/*  94 */       this.conditionClass_ = argValue;
/*     */     }
/*  96 */     else if (argValue instanceof ParameterConfig) {
/*  97 */       this.parameterConfigs_.add((ParameterConfig)argValue);
/*     */     }
/*  99 */     else if (argKey.equalsIgnoreCase("method")) {
/* 100 */       this.parameterConfigs_.add(new ParameterConfig(argKey, (IConfigObject)new StringConfig(argValue.toString())));
/*     */     }
/* 102 */     else if (argValue instanceof ConditionConfig) {
/* 103 */       this.subConditions_.add((ConditionConfig)argValue);
/*     */     } else {
/*     */       
/* 106 */       this.parameterConfigs_.add(new ParameterConfig(argKey, argValue));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\ConditionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */