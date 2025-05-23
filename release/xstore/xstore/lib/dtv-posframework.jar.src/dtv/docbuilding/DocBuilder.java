/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.CompositeObject;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class DocBuilder<T extends CompositeObject>
/*     */   implements IDocBuilder<T>
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DocBuilder.class);
/*     */   
/*     */   private final T docType_;
/*  29 */   private final Collection<DocSectionRef> elements_ = new ArrayList<>();
/*     */   
/*     */   private IPrinterTargetInfo printerTargetInfo_;
/*     */   
/*     */   private boolean emailDoc_ = false;
/*     */   private String locale_;
/*     */   
/*     */   public String getLocale() {
/*  37 */     return this.locale_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocale(String argLocale) {
/*  42 */     this.locale_ = argLocale;
/*     */   }
/*     */   
/*     */   public DocBuilder(T argType) {
/*  46 */     this.docType_ = argType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSection(DocSectionRef argSection) {
/*  52 */     if (argSection == null) {
/*  53 */       logger_.warn("Invalid section reference");
/*     */     } else {
/*     */       
/*  56 */       this.elements_.add(argSection);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <D extends IPosDocument> D build(D argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*  64 */     if (argDoc instanceof IPrintablePosDocument) {
/*  65 */       ((IPrintablePosDocument)argDoc).setLocale(getLocale());
/*     */     }
/*  67 */     for (DocSectionRef s : this.elements_) {
/*  68 */       s.buildDoc((IPosDocument)argDoc, argSource, argElementFactory);
/*     */     }
/*  70 */     if (argDoc instanceof IPrintablePosDocument) {
/*  71 */       ((IPrintablePosDocument)argDoc).setPrinterTargetInfo(getPrinterTargetInfo());
/*     */     }
/*  73 */     return argDoc;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getDocType() {
/*  79 */     return this.docType_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPrinterTargetInfo getPrinterTargetInfo() {
/*  84 */     return this.printerTargetInfo_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmailDoc() {
/*  90 */     return this.emailDoc_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailDoc(boolean argEmailDoc) {
/*  96 */     this.emailDoc_ = argEmailDoc;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrinterTargetInfo(IPrinterTargetInfo newValue) {
/* 101 */     this.printerTargetInfo_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 108 */     for (DocSectionRef s : this.elements_)
/* 109 */       s.trace(argTracer); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */