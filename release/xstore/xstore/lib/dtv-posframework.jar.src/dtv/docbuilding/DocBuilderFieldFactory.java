/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.config.DocBuilderAggregateConfig;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderFieldType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.util.Date;
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
/*     */ public class DocBuilderFieldFactory
/*     */   implements IDocBuilderFieldFactory
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(DocBuilderFieldFactory.class);
/*  29 */   public static final String SYSTEM_PROPERTY = DocBuilderFieldFactory.class.getName();
/*     */   
/*     */   private static IDocBuilderFieldFactory INSTANCE;
/*     */   
/*     */   static {
/*  34 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*     */     try {
/*  36 */       INSTANCE = (IDocBuilderFieldFactory)Class.forName(className).newInstance();
/*     */     }
/*  38 */     catch (Exception ex) {
/*  39 */       INSTANCE = new DocBuilderFieldFactory();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static IDocBuilderFieldFactory getInstance() {
/*  44 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeyedText(Date argTargetDate, String argCode, String argSubcode, Locale argLocale) {
/*  52 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField makeDocBuilderField(DocBuilderFieldType argContentsType, Object argContents, List<IReflectionParameterCapable<?>> argMethodParamList, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/*  62 */     if (argContentsType == DocBuilderFieldType.METHOD)
/*     */     {
/*  64 */       return new MethodDocBuilderField(argContents.toString(), argMethodParamList, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */     }
/*     */     
/*  67 */     if (argContentsType == DocBuilderFieldType.AGGREGATE) {
/*     */       
/*     */       try {
/*  70 */         DocBuilderAggregateConfig config = (DocBuilderAggregateConfig)argContents;
/*     */         
/*  72 */         IDocBuilderField field = config.makeField(argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*  73 */         return field;
/*     */       }
/*  75 */       catch (Exception ex) {
/*  76 */         if (argContents instanceof IHasSourceDescription) {
/*  77 */           logger_.error("CAUGHT EXCEPTION wtih config='" + ((IHasSourceDescription)argContents)
/*  78 */               .getSourceDescription() + "'", ex);
/*     */         } else {
/*     */           
/*  81 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*  83 */         return new TextDocBuilderField("", argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */       } 
/*     */     }
/*  86 */     if (argContentsType == DocBuilderFieldType.ITERATOR) {
/*  87 */       Object[] contents = (Object[])argContents;
/*  88 */       String methodName = (String)contents[0];
/*  89 */       List<IDocBuilderField> memberFields = (List<IDocBuilderField>)contents[1];
/*  90 */       IDocBuilderField separator = (IDocBuilderField)contents[2];
/*     */       
/*  92 */       return new IteratingDocBuilderField(methodName, argMethodParamList, separator, memberFields, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (argContentsType != DocBuilderFieldType.TEXT) {
/*  98 */       if (argContents instanceof IHasSourceDescription) {
/*  99 */         logger_.warn("UNEXPECTED FIELD TYPE [" + argContentsType + "] with config='" + ((IHasSourceDescription)argContents)
/* 100 */             .getSourceDescription() + "'");
/*     */       } else {
/*     */         
/* 103 */         logger_.warn("UNEXPECTED FIELD TYPE [" + argContentsType + "]");
/*     */       } 
/*     */     }
/* 106 */     return new TextDocBuilderField(argContents.toString(), argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderFieldFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */