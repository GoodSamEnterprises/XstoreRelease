/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.config.DocBuilderXmlConfig;
/*     */ import dtv.docbuilding.config.FormatterMapConfig;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.docbuilding.xml.DocXmlContentHandler;
/*     */ import dtv.docbuilding.xml.DocXmlDomParser;
/*     */ import dtv.docbuilding.xml.DocXmlExpressionator;
/*     */ import dtv.docbuilding.xml.DocXmlFacilities;
/*     */ import dtv.docbuilding.xml.DocXmlInstructionParser;
/*     */ import dtv.docbuilding.xml.DocXmlRootElement;
/*     */ import dtv.docbuilding.xml.IDocXmlContentHandler;
/*     */ import dtv.docbuilding.xml.IDocXmlExpressionator;
/*     */ import dtv.docbuilding.xml.IDocXmlInstructionParser;
/*     */ import dtv.docbuilding.xml.IDocXmlStringParser;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderXmlBlock
/*     */   extends AbstractDocBuilderSectionMember
/*     */ {
/*  27 */   private static final Logger _logger = Logger.getLogger(DocBuilderXmlConfig.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private final DocXmlRootElement _rootElement;
/*     */ 
/*     */ 
/*     */   
/*     */   private final DocXmlFacilities _facilities;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderXmlBlock(String argXml, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  41 */     this._rootElement = parseXml(argXml);
/*  42 */     this._facilities = new DocXmlFacilities(argSectionMap, argFormatterMap, createExpressionator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*     */     try {
/*  51 */       IDocXmlInstructionParser parser = createParser();
/*  52 */       parser.initialize(this._facilities);
/*  53 */       parser.setContentHandler(createContentHandler());
/*     */ 
/*     */       
/*  56 */       List<IDocBuilderSectionMember> members = parser.parse(argSource, argElementFactory);
/*     */ 
/*     */ 
/*     */       
/*  60 */       for (IDocBuilderSectionMember section : members) {
/*  61 */         section.buildDoc(argDoc, argSource, argElementFactory);
/*     */       }
/*     */     }
/*  64 */     catch (Exception ex) {
/*  65 */       _logger.error("CAUGHT EXCEPTION @@ [" + getSourceDescription() + "]", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argValue) {
/*  72 */     super.setSourceDescription(argValue);
/*  73 */     this._facilities.setSourceDescription(argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlContentHandler createContentHandler() {
/*  88 */     return (IDocXmlContentHandler)new DocXmlContentHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlExpressionator createExpressionator() {
/*  97 */     return (IDocXmlExpressionator)new DocXmlExpressionator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlInstructionParser createParser() {
/* 107 */     return (IDocXmlInstructionParser)new DocXmlInstructionParser(getRootElement());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlRootElement getRootElement() {
/* 115 */     return this._rootElement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlRootElement parseXml(String argXml) {
/* 124 */     IDocXmlStringParser parser = getStringParser();
/* 125 */     return parser.convertXml(argXml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlStringParser getStringParser() {
/* 134 */     return (IDocXmlStringParser)new DocXmlDomParser();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderXmlBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */