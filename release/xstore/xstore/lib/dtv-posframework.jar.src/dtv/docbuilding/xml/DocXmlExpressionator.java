/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderFieldFactory;
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.config.DocBuilderAggregateConfig;
/*     */ import dtv.docbuilding.types.DocBuilderFieldType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.ReflectionException;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ClassConfig;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlExpressionator
/*     */   implements IDocXmlExpressionator
/*     */ {
/*  36 */   private static final Logger _logger = Logger.getLogger(DocXmlExpressionator.class);
/*     */   private static final String FORMATTER_REGEX = "(?:\\[(\\w+)\\])?";
/*     */   private static final String EXPRESSION_REGEX = "([\\#\\!\\$]\\{(\\@?[\\w+|.|\\(.*\\)(?:\\{\\w+\\})?]+)\\})";
/*  39 */   private static final Pattern _evalPattern = Pattern.compile("([\\#\\!\\$]\\{(\\@?[\\w+|.|\\(.*\\)(?:\\{\\w+\\})?]+)\\})", 32);
/*     */   
/*  41 */   private static final Pattern _describePattern = Pattern.compile("(([\\#\\!\\$]\\{(\\@?[\\w+|.|\\(.*\\)(?:\\{\\w+\\})?]+)\\})(?:\\[(\\w+)\\])?)+", 32);
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DocXmlTextDescriptor> describe(String argExpr) {
/*  46 */     List<DocXmlTextDescriptor> exprs = new ArrayList<>();
/*     */     try {
/*  48 */       Matcher matcher = _describePattern.matcher(argExpr);
/*  49 */       int lastIdx = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  56 */       while (matcher.find()) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  61 */         if (lastIdx < matcher.start(1)) {
/*  62 */           String literalText = StringUtils.removeLineFeeds(argExpr.substring(lastIdx, matcher.start(1)), " ");
/*  63 */           exprs.add(DocXmlTextDescriptor.makeLiteral(literalText));
/*     */         } 
/*     */ 
/*     */         
/*  67 */         String expr = matcher.group(2);
/*  68 */         String formatterName = (matcher.groupCount() >= 4) ? matcher.group(4) : null;
/*  69 */         exprs.add(DocXmlTextDescriptor.makeExpression(expr, formatterName));
/*     */ 
/*     */         
/*  72 */         lastIdx = matcher.end(1);
/*     */       } 
/*     */ 
/*     */       
/*  76 */       if (lastIdx < argExpr.length()) {
/*  77 */         exprs.add(DocXmlTextDescriptor.makeLiteral(StringUtils.removeLineFeeds(argExpr.substring(lastIdx), "")));
/*     */       }
/*     */     }
/*  80 */     catch (Exception ex) {
/*  81 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */     
/*  84 */     return exprs;
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
/*     */   public String evaluateAndFormat(String argExpr, Object argSource, IOutputFormatter argFormatter, IDocElementFactory argFactory, String argSourceDescription) {
/*     */     try {
/*  97 */       Matcher matcher = _evalPattern.matcher(argExpr);
/*     */       
/*  99 */       if (matcher.find()) {
/*     */         DocBuilderAggregateConfig cfg;
/*     */         
/*     */         IDocBuilderField aggr, propField;
/* 103 */         char exprType = matcher.group(1).charAt(0);
/* 104 */         String expr = argFactory.getParameterMap().resolveParamValue(matcher.group(2));
/*     */         
/* 106 */         switch (exprType) {
/*     */           
/*     */           case '#':
/*     */             
/*     */             try {
/* 111 */               Object value = DocBuilderHelper.invokeMethodChain(expr, argSource, null, null, argSourceDescription);
/* 112 */               return DocXmlFacilities.formatNonNull(value, argFormatter);
/*     */             }
/* 114 */             catch (ReflectionException ex) {
/* 115 */               _logger.debug("Error invoking method [" + expr + "] @@ [" + argSourceDescription + "]", (Throwable)ex);
/* 116 */               return null;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case '!':
/* 123 */             cfg = new DocBuilderAggregateConfig();
/* 124 */             cfg.setAggregateClass(new ClassConfig(expr));
/* 125 */             aggr = cfg.makeField(null, null, null, 0, argFormatter);
/*     */             
/* 127 */             return aggr.getContents(argSource, argFactory, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case '$':
/* 134 */             propField = DocBuilderFieldFactory.getInstance().makeDocBuilderField(DocBuilderFieldType.SYSTEMPROPERTY, expr, null, null, null, null, 0, argFormatter);
/*     */ 
/*     */             
/* 137 */             return propField.getContents(argSource, argFactory, null);
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/* 143 */     } catch (Exception ex) {
/* 144 */       _logger.error("CAUGHT EXCEPTION evaluating [" + argExpr + "] @@ [" + argSourceDescription + "]", ex);
/*     */     } 
/* 146 */     return argExpr;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlExpressionator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */