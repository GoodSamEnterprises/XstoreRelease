/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.IDocBuilderIteratorMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
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
/*     */ public class MemberFactory
/*     */ {
/*  18 */   private static final Logger logger_ = Logger.getLogger(MemberFactory.class);
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
/*     */   public static IDocBuilderIteratorMember createIteratorMember(ISectionMemberConfig argConfig, IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  32 */     if (argConfig instanceof DocBuilderRowConfig) {
/*  33 */       return (IDocBuilderIteratorMember)((DocBuilderRowConfig)argConfig).makeRow(argFormatterMap);
/*     */     }
/*  35 */     if (argConfig instanceof DocBuilderRowSetConfig) {
/*  36 */       return (IDocBuilderIteratorMember)((DocBuilderRowSetConfig)argConfig).makeRowSet(argFormatterMap);
/*     */     }
/*  38 */     if (argConfig instanceof DocBuilderSectionRefConfig) {
/*  39 */       return (IDocBuilderIteratorMember)((DocBuilderSectionRefConfig)argConfig).makeSectionRef(argSectionMap);
/*     */     }
/*  41 */     if (argConfig instanceof DocBuilderIteratorConfig) {
/*  42 */       return ((DocBuilderIteratorConfig)argConfig).makeIterator(argElementFactory, argSectionMap, argFormatterMap);
/*     */     }
/*     */     
/*  45 */     if (argConfig instanceof DocBuilderGroupingConfig) {
/*  46 */       DocBuilderGroupingConfig c = (DocBuilderGroupingConfig)argConfig;
/*  47 */       return c.makeGrouping(argElementFactory, argSectionMap, argFormatterMap);
/*     */     } 
/*  49 */     if (argConfig instanceof DocBuilderCallConfig) {
/*  50 */       return ((DocBuilderCallConfig)argConfig).makeCall(argElementFactory, argSectionMap, argFormatterMap);
/*     */     }
/*  52 */     if (argConfig instanceof DocBuilderRegionConfig) {
/*  53 */       return (IDocBuilderIteratorMember)((DocBuilderRegionConfig)argConfig).makeRegion(argFormatterMap);
/*     */     }
/*  55 */     if (argConfig instanceof DocBuilderHorizontalRuleConfig) {
/*  56 */       return ((DocBuilderHorizontalRuleConfig)argConfig).makeHorizontalRule(argElementFactory, argFormatterMap);
/*     */     }
/*     */     
/*  59 */     if (argConfig instanceof DocBuilderTextBlockConfig) {
/*  60 */       return (IDocBuilderIteratorMember)((DocBuilderTextBlockConfig)argConfig).makeTextBlock(argFormatterMap);
/*     */     }
/*     */     
/*  63 */     if (argConfig == null) {
/*  64 */       logger_.warn("unexpected null member");
/*     */     } else {
/*     */       
/*  67 */       logger_.warn("unexpected member '" + argConfig + "' from config = '" + argConfig
/*  68 */           .getSourceDescription() + "'");
/*     */     } 
/*     */     
/*  71 */     return null;
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
/*     */ 
/*     */   
/*     */   public static Object[] createSectionMember(ISectionMemberConfig argConfig, IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  87 */     if (argConfig instanceof DocBuilderXmlConfig) {
/*  88 */       return new Object[] { ((DocBuilderXmlConfig)argConfig).makeXmlBlock(argSectionMap, argFormatterMap) };
/*     */     }
/*  90 */     if (argConfig instanceof DocBuilderBarcodeConfig)
/*     */     {
/*  92 */       return new Object[] { ((DocBuilderBarcodeConfig)argConfig).makeBarcode(argFormatterMap) };
/*     */     }
/*  94 */     if (argConfig instanceof DocBuilderPictureConfig) {
/*     */ 
/*     */       
/*  97 */       DocBuilderPictureConfig c = (DocBuilderPictureConfig)argConfig;
/*  98 */       return new Object[] { argElementFactory.makePictureElement(c.getFile(), c.getPreload()) };
/*     */     } 
/* 100 */     if (argConfig instanceof DocBuilderSignatureConfig)
/*     */     {
/* 102 */       return new Object[] { ((DocBuilderSignatureConfig)argConfig).makeTransactionSignature(argFormatterMap) };
/*     */     }
/* 104 */     if (argConfig instanceof DocBuilderPageBreakConfig)
/*     */     {
/* 106 */       return (Object[])argElementFactory.getPageBreakElements();
/*     */     }
/*     */ 
/*     */     
/* 110 */     IDocBuilderIteratorMember m = createIteratorMember(argConfig, argElementFactory, argSectionMap, argFormatterMap);
/* 111 */     if (m == null) {
/* 112 */       return null;
/*     */     }
/*     */     
/* 115 */     return new Object[] { m };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\MemberFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */