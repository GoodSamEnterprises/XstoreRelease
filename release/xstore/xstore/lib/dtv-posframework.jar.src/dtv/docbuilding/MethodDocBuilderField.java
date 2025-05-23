/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MethodDocBuilderField
/*     */   extends AbstractDocBuilderField
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(MethodDocBuilderField.class);
/*     */   
/*     */   private static final String PARAM_TARGET_CLASS = "TargetClass";
/*     */   
/*     */   private final Class<?>[] paramClasses_;
/*     */   private final Object[] params_;
/*  34 */   private Class<?> targetClass_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodDocBuilderField(String argContents, List<?> argMethodParamList, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/*  51 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */     
/*  53 */     if (argMethodParamList != null && argMethodParamList.size() > 0) {
/*  54 */       this.paramClasses_ = new Class[argMethodParamList.size()];
/*  55 */       this.params_ = new Object[argMethodParamList.size()];
/*     */       
/*  57 */       for (int i = 0; i < this.paramClasses_.length; i++) {
/*  58 */         IReflectionParameterCapable<?> config = (IReflectionParameterCapable)argMethodParamList.get(i);
/*  59 */         this.paramClasses_[i] = config.getParamDataType();
/*  60 */         this.params_[i] = config.getParamValue();
/*     */       } 
/*     */     } else {
/*     */       
/*  64 */       this.paramClasses_ = new Class[0];
/*  65 */       this.params_ = new Object[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/*  80 */     Object methodTarget = (this.targetClass_ == null) ? argSource : this.targetClass_;
/*  81 */     String methodName = argFactory.getParameterMap().resolveParamValue(getContents());
/*  82 */     Object result = null;
/*     */     
/*     */     try {
/*  85 */       if (".".equals(methodName)) {
/*  86 */         result = methodTarget;
/*     */       }
/*     */       else {
/*     */         
/*  90 */         result = DocBuilderHelper.invokeMethodChain(methodName, methodTarget, this.paramClasses_, this.params_, getSourceDescription());
/*     */       } 
/*     */ 
/*     */       
/*  94 */       return getFormatter().format(result, argLocale);
/*     */     }
/*  96 */     catch (Exception ex) {
/*  97 */       logger_.warn("CAUGHT EXCEPTION with source='" + ObjectUtils.getClassNameFromObject(methodTarget) + "':'" + methodTarget + "', method='" + methodName + "', config='" + 
/*  98 */           getSourceDescription() + "'", ex);
/*  99 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/* 106 */     if ("TargetClass".equalsIgnoreCase(argName)) {
/* 107 */       this.targetClass_ = ConfigUtils.toClass(argValue);
/*     */     } else {
/*     */       
/* 110 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\MethodDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */