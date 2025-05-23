/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import java.io.IOException;
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
/*     */ public class DocBuilderSection
/*     */   implements IHasSourceDescription
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DocBuilderSection.class);
/*  27 */   private static final boolean isInfoEnabled_ = logger_.isInfoEnabled();
/*     */   
/*     */   private final String name_;
/*  30 */   private final List<Object> members_ = new ArrayList();
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<IDocBuilderCondition> conditions_;
/*     */ 
/*     */   
/*     */   private final String sourceInfo_;
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderSection(String argName, List<IDocBuilderCondition> argConditions, String argSourceInfo) {
/*  42 */     this.name_ = argName;
/*  43 */     this.conditions_ = argConditions;
/*  44 */     this.sourceInfo_ = argSourceInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMember(Object element) {
/*  55 */     if (element == null) {
/*  56 */       logger_.warn("cannot add null element");
/*     */     }
/*  58 */     else if (element instanceof IDocBuilderSectionMember || element instanceof ITextElement || element instanceof IPageBreakElement) {
/*     */       
/*  60 */       this.members_.add(element);
/*     */     } else {
/*     */       
/*  63 */       throw new ClassCastException("was '" + element.getClass().getName() + "' expected '" + IDocBuilderSectionMember.class
/*  64 */           .getName() + "' or '" + ITextElement.class.getName() + "'");
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
/*     */   public void addMembers(Object[] elements) {
/*  76 */     for (Object element : elements) {
/*  77 */       addMember(element);
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
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*  92 */     if (isInfoEnabled_) {
/*  93 */       logger_.info("** " + getSectionDescription());
/*     */     }
/*     */     
/*  96 */     if (!DocBuilderHelper.meetsConditions(argSource, this.conditions_)) {
/*     */       return;
/*     */     }
/*     */     
/* 100 */     if (argElementFactory.isTraceEnabled()) {
/* 101 */       argDoc.appendElement(argElementFactory.makeTraceElement("***" + getSectionDescription()));
/*     */     }
/* 103 */     for (int i = 0; i < this.members_.size(); i++) {
/* 104 */       Object o = this.members_.get(i);
/* 105 */       if (o instanceof ITextElement) {
/* 106 */         argDoc.appendElement((ITextElement)((ITextElement)o).clone());
/*     */       }
/* 108 */       else if (o instanceof IDocBuilderSectionMember) {
/* 109 */         ((IDocBuilderSectionMember)o).buildDoc(argDoc, argSource, argElementFactory);
/*     */       }
/* 111 */       else if (o instanceof IPageBreakElement) {
/* 112 */         argDoc.appendElement((IPageBreakElement)o);
/*     */       } else {
/*     */         
/* 115 */         logger_.warn("unexpected member '" + o + "' with member config='" + getSourceDescription(o) + "' in " + 
/* 116 */             getSectionDescription());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 127 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 133 */     return this.sourceInfo_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 140 */     String node = argTracer.startNode(this.name_);
/* 141 */     argTracer.attr(getSourceDescription());
/* 142 */     for (IDocBuilderCondition element : this.conditions_) {
/* 143 */       element.trace(argTracer);
/*     */     }
/* 145 */     for (int i = 0; i < this.members_.size(); i++) {
/* 146 */       Object o = this.members_.get(i);
/* 147 */       if (o instanceof IDocElement) {
/* 148 */         ((IDocElement)o).trace(argTracer);
/*     */       }
/* 150 */       else if (o instanceof IDocBuilderSectionMember) {
/* 151 */         ((IDocBuilderSectionMember)o).trace(argTracer);
/*     */       } else {
/*     */         
/* 154 */         argTracer.warn("unexpected member '" + o + "' with member config='" + getSourceDescription(o) + "' in " + 
/* 155 */             getSectionDescription());
/*     */       } 
/*     */     } 
/* 158 */     argTracer.endNode(node);
/*     */   }
/*     */   
/*     */   private String getSectionDescription() {
/* 162 */     return "section::" + this.name_ + ":" + this.sourceInfo_;
/*     */   }
/*     */   
/*     */   private String getSourceDescription(Object o) {
/* 166 */     return (o instanceof IHasSourceDescription) ? ((IHasSourceDescription)o).getSourceDescription() : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */