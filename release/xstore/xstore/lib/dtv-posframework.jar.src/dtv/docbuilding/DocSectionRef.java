/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
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
/*     */ public class DocSectionRef
/*     */   extends AbstractDocBuilderSectionMember
/*     */   implements IDocBuilderIteratorMember
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DocSectionRef.class);
/*     */   
/*     */   private final String sectionName_;
/*     */   
/*     */   private final DocSectionMap sectionMap_;
/*     */   private final Map<String, String> params_;
/*  32 */   private DocBuilderSection section_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocSectionRef(String argSectionName, DocSectionMap argSectionMap) {
/*  41 */     this(argSectionName, argSectionMap, null);
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
/*     */   public DocSectionRef(String argSectionName, DocSectionMap argSectionMap, Map<String, String> argParams) {
/*  53 */     this.sectionName_ = argSectionName;
/*  54 */     this.sectionMap_ = argSectionMap;
/*  55 */     this.params_ = argParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*  63 */     String sectionName = argElementFactory.getParameterMap().resolveParamValue(this.sectionName_);
/*     */     
/*  65 */     if (!StringUtils.isEmpty(sectionName)) {
/*  66 */       DocBuilderSection section = getSection(sectionName);
/*     */       
/*  68 */       if (section == null) {
/*  69 */         Collection<String> warningLine = new ArrayList<>();
/*  70 */         logger_.warn("Omitting unknown section [" + this.sectionName_ + "] @@ [" + getSourceDescription() + "]");
/*  71 */         warningLine.add("SECTION_[" + this.sectionName_ + "]_UNKNOWN");
/*  72 */         argDoc.appendElement(argElementFactory.makeTextElement((Collection)warningLine));
/*     */       } else {
/*     */         
/*  75 */         synchronized (this) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  81 */           argElementFactory.getParameterMap().startParamScope(this.params_);
/*  82 */           section.buildDoc(argDoc, argSource, argElementFactory);
/*  83 */           argElementFactory.getParameterMap().endParamScope();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/*  92 */     if (!StringUtils.isEmpty(this.sectionName_)) {
/*  93 */       DocBuilderSection section = getSection(this.sectionName_);
/*  94 */       if (section == null) {
/*  95 */         String node = argTracer.startNode("MISSING SECTION(" + this.sectionName_ + ")");
/*  96 */         argTracer.attr(getSourceDescription());
/*  97 */         argTracer.endNode(node);
/*     */       } else {
/*     */         
/* 100 */         section.trace(argTracer);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private DocBuilderSection getSection(String argName) {
/* 106 */     if (this.section_ == null) {
/* 107 */       this.section_ = this.sectionMap_.getSection(argName);
/*     */     }
/* 109 */     return this.section_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocSectionRef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */