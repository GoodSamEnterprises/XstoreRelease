/*     */ package dtv.docbuilding.config;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.conditions.SimpleComparisonCondition;
/*     */ import dtv.docbuilding.conditions.compare.BlankComparison;
/*     */ import dtv.docbuilding.conditions.compare.GreaterThanComparison;
/*     */ import dtv.docbuilding.conditions.compare.GreaterThanZeroComparison;
/*     */ import dtv.docbuilding.conditions.compare.IComparison;
/*     */ import dtv.docbuilding.conditions.compare.LessThanZeroComparison;
/*     */ import dtv.docbuilding.conditions.compare.NotEmptyComparison;
/*     */ import dtv.docbuilding.conditions.compare.NotEqualComparison;
/*     */ import dtv.docbuilding.conditions.compare.NotMatchComparison;
/*     */ import dtv.docbuilding.conditions.compare.TrueComparison;
/*     */ import dtv.util.IHasParameters;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.ReflectionException;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DocBuilderConditionConfig extends AbstractParentConfig {
/*  28 */   private static final Logger logger_ = Logger.getLogger(DocBuilderConditionConfig.class);
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private final List<String> methods_ = new ArrayList<>();
/*  31 */   private final List<IReflectionParameterCapable<?>> methodParams_ = new ArrayList<>();
/*     */   
/*  33 */   private final List<ParameterConfig> conditionParams_ = new ArrayList<>();
/*     */   
/*  35 */   private IComparison comparison_ = null;
/*  36 */   private ClassConfig<?> conditionClass_ = null;
/*     */ 
/*     */ 
/*     */   
/*  40 */   private static final Map<String, Class<?>> COMPARISONS = new HashMap<>(); static {
/*  41 */     COMPARISONS.put("EQUAL", EqualComparison.class);
/*  42 */     COMPARISONS.put("NOT_EQUAL", NotEqualComparison.class);
/*  43 */     COMPARISONS.put("MATCHES", MatchComparison.class);
/*  44 */     COMPARISONS.put("NOT_MATCHES", NotMatchComparison.class);
/*  45 */     COMPARISONS.put("GREATER_THAN", GreaterThanComparison.class);
/*  46 */     COMPARISONS.put("GREATER_THAN_ZERO", GreaterThanZeroComparison.class);
/*  47 */     COMPARISONS.put("GREATER_THAN_OR_EQUAL", GreaterThanOrEqualComparison.class);
/*  48 */     COMPARISONS.put("LESS_THAN", LessThanComparison.class);
/*  49 */     COMPARISONS.put("LESS_THAN_ZERO", LessThanZeroComparison.class);
/*  50 */     COMPARISONS.put("LESS_THAN_OR_EQUAL", LessThanOrEqualComparison.class);
/*  51 */     COMPARISONS.put("IS_NULL", NullComparison.class);
/*  52 */     COMPARISONS.put("NOT_NULL", NotNullComparison.class);
/*  53 */     COMPARISONS.put("IS_BLANK", BlankComparison.class);
/*  54 */     COMPARISONS.put("NOT_BLANK", NotBlankComparison.class);
/*  55 */     COMPARISONS.put("IS_EMPTY", IsEmptyComparison.class);
/*  56 */     COMPARISONS.put("NOT_EMPTY", NotEmptyComparison.class);
/*  57 */     COMPARISONS.put("TRUE", TrueComparison.class);
/*  58 */     COMPARISONS.put("FALSE", FalseComparison.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Map<String, Class<?>> getComparisons() {
/*  63 */     return COMPARISONS;
/*     */   }
/*     */   
/*     */   public IComparison getComparison() {
/*  67 */     return this.comparison_;
/*     */   }
/*     */   
/*     */   public ClassConfig<?> getConditionClass() {
/*  71 */     return this.conditionClass_;
/*     */   }
/*     */   
/*     */   public List<String> getConditionMethods() {
/*  75 */     return this.methods_;
/*     */   }
/*     */   
/*     */   public List<ParameterConfig> getConditionParams() {
/*  79 */     return this.conditionParams_;
/*     */   }
/*     */   
/*     */   public List<IReflectionParameterCapable<?>> getMethodParams() {
/*  83 */     return this.methodParams_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderCondition makeCondition() {
/*  91 */     IDocBuilderCondition c = null;
/*  92 */     if (!this.methods_.isEmpty()) {
/*  93 */       if (this.comparison_ == null) {
/*  94 */         logger_.warn("misconfigured condition... no comparison specified with config='" + 
/*  95 */             getSourceDescription() + "'");
/*     */       } else {
/*     */         
/*  98 */         setParametersOn((IHasParameters)this.comparison_);
/*  99 */         String[] methods = this.methods_.<String>toArray(new String[this.methods_.size()]);
/* 100 */         SimpleComparisonCondition simpleComparisonCondition = new SimpleComparisonCondition(methods, this.methodParams_, this.comparison_);
/* 101 */         simpleComparisonCondition.setSourceDescription(getSourceDescription());
/*     */       }
/*     */     
/* 104 */     } else if (this.conditionClass_ == null) {
/* 105 */       logger_.warn("misconfigured condition... must have a conditionclass or a method with config='" + 
/* 106 */           getSourceDescription() + "'");
/*     */     } else {
/*     */       
/*     */       try {
/* 110 */         c = this.conditionClass_.getValue().newInstance();
/* 111 */         c.setSourceDescription(getSourceDescription());
/* 112 */         setParametersOn((IHasParameters)c);
/*     */       }
/* 114 */       catch (IllegalAccessException ex) {
/* 115 */         throw new ReflectionException(ex);
/*     */       }
/* 117 */       catch (InstantiationException ex) {
/* 118 */         throw new ReflectionException(ex);
/*     */       } 
/*     */     } 
/* 121 */     return c;
/*     */   }
/*     */   
/*     */   public void setComparason(IComparison argComparison) {
/* 125 */     this.comparison_ = argComparison;
/*     */   }
/*     */   
/*     */   public void setConditionClass(ClassConfig<?> argClass) {
/* 129 */     this.conditionClass_ = argClass;
/*     */   }
/*     */   
/*     */   public void setConditionMethods(List<String> argMethods) {
/* 133 */     this.methods_.clear();
/* 134 */     this.methods_.addAll(argMethods);
/*     */   }
/*     */   
/*     */   public void setConditionParams(List<ParameterConfig> argParams) {
/* 138 */     this.conditionParams_.clear();
/* 139 */     this.conditionParams_.addAll(argParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 146 */     if (argValue instanceof IReflectionParameterCapable && "method_param".equalsIgnoreCase(argKey)) {
/* 147 */       this.methodParams_.add((IReflectionParameterCapable)argValue);
/*     */     }
/* 149 */     else if ("method".equalsIgnoreCase(argKey)) {
/* 150 */       this.methods_.add(argValue.toString());
/*     */     }
/* 152 */     else if ("comparison".equalsIgnoreCase(argKey)) {
/* 153 */       this.comparison_ = getComparison(argValue);
/*     */     }
/* 155 */     else if ("class".equalsIgnoreCase(argKey) || argValue instanceof ClassConfig) {
/* 156 */       this.conditionClass_ = ConfigUtils.toClassConfig(argValue);
/*     */     }
/* 158 */     else if (argValue instanceof ParameterConfig) {
/* 159 */       this.conditionParams_.add((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/* 162 */       this.conditionParams_.add(new ParameterConfig(argKey, argValue));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMethodParams(List<IReflectionParameterCapable<?>> argList) {
/* 167 */     this.methodParams_.clear();
/* 168 */     this.methodParams_.addAll(argList);
/*     */   }
/*     */   
/*     */   private IComparison getComparison(IConfigObject argKey) {
/* 172 */     Class<?> c = COMPARISONS.get(argKey.toString());
/* 173 */     if (c == null) {
/* 174 */       logger_.warn("Invalid comparison [" + argKey + "] @@ [" + getSourceDescription() + "]");
/* 175 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 179 */       IComparison newInstance = (IComparison)c.newInstance();
/* 180 */       newInstance.setSourceDescription(argKey.getSourceDescription());
/* 181 */       return newInstance;
/*     */     }
/* 183 */     catch (IllegalAccessException ex) {
/* 184 */       throw new ReflectionException(ex);
/*     */     }
/* 186 */     catch (InstantiationException ex) {
/* 187 */       throw new ReflectionException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setParametersOn(IHasParameters argTarget) {
/* 192 */     for (int i = 0; i < this.conditionParams_.size(); i++) {
/* 193 */       Object o = this.conditionParams_.get(i);
/* 194 */       if (o instanceof ParameterConfig) {
/* 195 */         ParameterConfig pc = (ParameterConfig)o;
/* 196 */         pc.setParameter(argTarget);
/*     */       }
/* 198 */       else if (o instanceof IReflectionParameterCapable) {
/*     */         
/* 200 */         IReflectionParameterCapable<?> p = (IReflectionParameterCapable)o;
/* 201 */         argTarget.setParameter("VALUE", p.getParamValue());
/*     */       
/*     */       }
/* 204 */       else if (o instanceof IHasSourceDescription) {
/* 205 */         logger_.error("Unexpected member [" + ObjectUtils.getClassNameFromObject(o) + "] @@ [" + ((IHasSourceDescription)o)
/* 206 */             .getSourceDescription() + "]");
/*     */       } else {
/*     */         
/* 209 */         logger_.error("Unexpected member [" + ObjectUtils.getClassNameFromObject(o) + "] @@ [" + 
/* 210 */             getSourceDescription() + "]");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderConditionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */