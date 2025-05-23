/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.conditions.NeverMetCondition;
/*     */ import dtv.docbuilding.config.DocBuilderConditionConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.SpELExpressionEvaluator;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class DocBuilderHelper
/*     */ {
/*  27 */   private static final Pattern PATTERN = Pattern.compile("(\\$([\\w|\\.]+))");
/*  28 */   private static final Logger logger_ = Logger.getLogger(DocBuilderHelper.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<IDocBuilderCondition> createConditions(Iterable<? extends DocBuilderConditionConfig> argConfigs) {
/*  37 */     List<IDocBuilderCondition> conditions = new ArrayList<>();
/*     */     
/*  39 */     if (argConfigs != null) {
/*  40 */       for (DocBuilderConditionConfig cfg : argConfigs) {
/*  41 */         conditions.add(createCondition(cfg));
/*     */       }
/*     */     }
/*  44 */     return conditions;
/*     */   }
/*     */   
/*     */   public static Object invokeMethodChain(String argMethodNameChain, Object argRootTarget) {
/*  48 */     return invokeMethodChain(argMethodNameChain, argRootTarget, null, null, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object invokeMethodChain(String argMethodNameChain, Object argRootTarget, Class<?>[] argParamClasses, Object[] argRootParameters, String argSourceDescription) {
/*  54 */     if (StringUtils.isEmpty(argMethodNameChain)) {
/*  55 */       return argRootTarget;
/*     */     }
/*     */     
/*  58 */     String chain = argMethodNameChain.trim();
/*  59 */     int lastIdx = chain.length() - 1;
/*     */     
/*  61 */     if (chain.charAt(0) == '(' && chain.charAt(lastIdx) == ')') {
/*  62 */       return evaluateExpression(chain.substring(1, chain.length() - 1), argRootTarget, argParamClasses, argRootParameters);
/*     */     }
/*     */ 
/*     */     
/*  66 */     return ObjectUtils.invokeMethodChainNoLog(argMethodNameChain, argRootTarget, argParamClasses, argRootParameters, 
/*  67 */         JdoFromId2ResolvingCallback.getInstance(), argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean meetsConditions(Object argValue, Iterable<? extends IDocBuilderCondition> argConditions) {
/*  74 */     if (argConditions != null) {
/*  75 */       for (IDocBuilderCondition condition : argConditions) {
/*  76 */         if (!condition.conditionMet(argValue)) {
/*  77 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Object evaluateExpression(String argExpression, Object argRootTarget, Class<?>[] argParamClasses, Object[] argRootParameters) {
/*  87 */     Matcher matcher = PATTERN.matcher(argExpression);
/*     */     
/*  89 */     StringBuffer expr = new StringBuffer();
/*  90 */     int start = 0;
/*     */ 
/*     */ 
/*     */     
/*  94 */     while (matcher.find()) {
/*  95 */       String method = matcher.group(2);
/*  96 */       expr.append(argExpression.substring(start, matcher.start(1)));
/*  97 */       Object result = invokeMethodChain(method, argRootTarget);
/*  98 */       if (result != null) {
/*  99 */         expr.append(result.toString());
/*     */       }
/* 101 */       start = matcher.end(1);
/*     */     } 
/* 103 */     expr.append(argExpression.substring(start));
/*     */     
/*     */     try {
/* 106 */       return SpELExpressionEvaluator.eval(expr.toString());
/*     */     }
/* 108 */     catch (Exception ex) {
/* 109 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 110 */       return null;
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
/*     */   private static IDocBuilderCondition createCondition(DocBuilderConditionConfig argConfig) {
/*     */     NeverMetCondition neverMetCondition;
/* 123 */     IDocBuilderCondition condition = null;
/*     */     try {
/* 125 */       condition = argConfig.makeCondition();
/*     */     }
/* 127 */     catch (Throwable ex) {
/* 128 */       neverMetCondition = new NeverMetCondition(ex);
/*     */     } 
/* 130 */     return (neverMetCondition == null) ? (IDocBuilderCondition)new NeverMetCondition() : (IDocBuilderCondition)neverMetCondition;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */