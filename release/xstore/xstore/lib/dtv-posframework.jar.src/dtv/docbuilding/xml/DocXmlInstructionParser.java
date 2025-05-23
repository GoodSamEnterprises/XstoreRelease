/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.docbuilding.IDocBuilderSectionMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlInstructionParser
/*     */   implements IDocXmlInstructionParser, IDocXmlParserCallback
/*     */ {
/*  25 */   private static final Logger _logger = Logger.getLogger(DocXmlInstructionParser.class);
/*     */   
/*  27 */   private List<IDocBuilderSectionMember> _members = null;
/*  28 */   private IDocXmlContentHandler _contentHandler = null;
/*  29 */   private DocXmlFacilities _facilities = null;
/*     */   private final DocXmlRootElement _rootElement;
/*     */   
/*     */   public DocXmlInstructionParser(DocXmlRootElement argElement) {
/*  33 */     this._rootElement = argElement;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRootMember(IDocBuilderSectionMember argMember) {
/*  39 */     this._members.add(argMember);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DocXmlFacilities getFacilities() {
/*  45 */     return this._facilities;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(DocXmlFacilities argFacilities) {
/*  51 */     this._facilities = argFacilities;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IDocBuilderSectionMember> parse(IDocXmlSimpleElement argXmlContent, Object argSource, IDocElementFactory argFactory) {
/*     */     try {
/*  60 */       if (argXmlContent instanceof DocXmlInstruction) {
/*     */ 
/*     */         
/*  63 */         DocXmlInstruction instr = (DocXmlInstruction)argXmlContent;
/*  64 */         String target = instr.getTarget();
/*     */         
/*  66 */         if (target.contains("condition")) {
/*  67 */           this._contentHandler.handleCondition(instr, argSource, argFactory);
/*     */         }
/*  69 */         else if ("sectionRef".equalsIgnoreCase(target)) {
/*  70 */           this._contentHandler.handleSectionRef(instr, argSource, argFactory);
/*     */         }
/*  72 */         else if (target.contains("call")) {
/*  73 */           this._contentHandler.handleCall(instr, argSource, argFactory);
/*     */         }
/*  75 */         else if (target.contains("iterator")) {
/*  76 */           this._contentHandler.handleIterator(instr, argSource, argFactory);
/*     */         }
/*  78 */         else if (target.contains("element")) {
/*  79 */           this._contentHandler.handleElement(instr, argSource, argFactory);
/*     */         }
/*  81 */         else if (target.contains("literal")) {
/*  82 */           this._contentHandler.handleLiteral(instr, argSource, argFactory);
/*     */         }
/*     */       
/*  85 */       } else if (argXmlContent instanceof IDocXmlElement) {
/*     */ 
/*     */         
/*  88 */         IDocXmlElement elem = (IDocXmlElement)argXmlContent;
/*  89 */         this._contentHandler.handleElement(elem, argSource, argFactory);
/*     */       }
/*     */     
/*  92 */     } catch (Exception ex) {
/*  93 */       _logger.error("CAUGHT EXCEPTION @@ [" + getFacilities().getSourceDescription() + "]", ex);
/*     */     } 
/*  95 */     return this._members;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IDocBuilderSectionMember> parse(Object argSource, IDocElementFactory argFactory) {
/*     */     try {
/* 102 */       this._members = new ArrayList<>();
/*     */ 
/*     */ 
/*     */       
/* 106 */       parse(this._rootElement, argSource, argFactory);
/*     */     }
/* 108 */     catch (Exception ex) {
/* 109 */       _logger.error("CAUGHT EXCEPTION parsing XML @@ [" + this._facilities.getSourceDescription() + "]", ex);
/*     */     } 
/* 111 */     return this._members;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentHandler(IDocXmlContentHandler argHandler) {
/* 117 */     this._contentHandler = argHandler;
/* 118 */     this._contentHandler.initialize(this);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlInstructionParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */