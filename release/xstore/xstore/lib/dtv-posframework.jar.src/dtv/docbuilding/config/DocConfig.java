/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.DefaultPrinterTargetInfo;
/*    */ import dtv.docbuilding.DocBuilder;
/*    */ import dtv.docbuilding.DocSectionMap;
/*    */ import dtv.docbuilding.DocSectionRef;
/*    */ import dtv.docbuilding.IDocBuilder;
/*    */ import dtv.docbuilding.IPrinterTargetInfo;
/*    */ import dtv.util.CompositeObject;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private final List<DocBuilderSectionRefConfig> sectionRefs_ = new ArrayList<>();
/*    */   
/* 28 */   private CompositeObject documentId_ = new CompositeObject(new Object[] { "" });
/* 29 */   private String printer_ = "RECEIPT";
/* 30 */   private String printerBackup_ = "RECEIPT_BACKUP";
/*    */ 
/*    */   
/*    */   private boolean emailCopy_ = false;
/*    */ 
/*    */   
/*    */   private String locale_;
/*    */ 
/*    */ 
/*    */   
/*    */   public IDocBuilder<CompositeObject> makeBuilder(DocSectionMap argSections) {
/* 41 */     DocBuilder docBuilder = new DocBuilder(this.documentId_);
/* 42 */     docBuilder.setPrinterTargetInfo((IPrinterTargetInfo)new DefaultPrinterTargetInfo(this.printer_, this.printerBackup_));
/* 43 */     docBuilder.setEmailDoc(this.emailCopy_);
/* 44 */     docBuilder.setLocale(this.locale_);
/*    */     
/* 46 */     for (DocBuilderSectionRefConfig sectionRefCfg : this.sectionRefs_) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 55 */       DocSectionRef sectionRef = sectionRefCfg.makeSectionRef(argSections);
/* 56 */       docBuilder.addSection(sectionRef);
/*    */     } 
/* 58 */     return (IDocBuilder<CompositeObject>)docBuilder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 65 */     if ("document_id".equalsIgnoreCase(argKey) || "document".equalsIgnoreCase(argKey)) {
/* 66 */       this.documentId_ = new CompositeObject(new Object[] { StringUtils.nonNull(argValue).toUpperCase() });
/*    */     }
/* 68 */     else if (argValue instanceof DocBuilderSectionRefConfig) {
/* 69 */       this.sectionRefs_.add((DocBuilderSectionRefConfig)argValue);
/*    */     }
/* 71 */     else if ("sectionRef".equalsIgnoreCase(argKey) || "section".equalsIgnoreCase(argKey)) {
/* 72 */       DocBuilderSectionRefConfig cfg = new DocBuilderSectionRefConfig();
/* 73 */       cfg.setSectionName(argValue.toString());
/* 74 */       cfg.setSourceInfo(getSourceUrl(), getSourceLineNumber());
/* 75 */       this.sectionRefs_.add(cfg);
/*    */     }
/* 77 */     else if ("printer".equalsIgnoreCase(argKey)) {
/* 78 */       this.printer_ = argValue.toString();
/*    */     }
/* 80 */     else if ("printer_backup".equalsIgnoreCase(argKey) || "printer2".equalsIgnoreCase(argKey)) {
/* 81 */       this.printerBackup_ = argValue.toString();
/*    */     }
/* 83 */     else if ("email_copy".equalsIgnoreCase(argKey) || "email".equalsIgnoreCase(argKey)) {
/* 84 */       this.emailCopy_ = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 86 */     else if ("locale".equalsIgnoreCase(argKey)) {
/* 87 */       this.locale_ = argValue.toString();
/*    */     }
/* 89 */     else if (argKey.startsWith("arg")) {
/* 90 */       for (DocBuilderSectionRefConfig cfg : this.sectionRefs_) {
/* 91 */         cfg.setParameter(argKey, argValue.toString());
/*    */       }
/*    */     } else {
/*    */       
/* 95 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */