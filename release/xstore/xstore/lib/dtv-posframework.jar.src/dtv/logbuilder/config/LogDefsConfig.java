/*     */ package dtv.logbuilder.config;
/*     */ 
/*     */ import dtv.docbuilding.config.DocBuilderSectionMapConfig;
/*     */ import dtv.docbuilding.config.DocListConfig;
/*     */ import dtv.docbuilding.config.FormatterMapConfig;
/*     */ import dtv.docbuilding.config.IDocBuilderRootConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class LogDefsConfig
/*     */   extends AbstractParentConfig
/*     */   implements IDocBuilderRootConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final Logger logger_ = Logger.getLogger(LogDefsConfig.class);
/*     */   
/*  26 */   private FormatterMapConfig formatterMap_ = null;
/*     */   
/*     */   private RoutingRulesConfig routingRules_;
/*     */   
/*     */   private LogFilesConfig logFiles_;
/*     */   private DocListConfig logLayoutDefs_;
/*     */   private DocBuilderSectionMapConfig sectionDefs_;
/*     */   
/*     */   public DocListConfig getDocListConfig() {
/*  35 */     return this.logLayoutDefs_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormatterMapConfig getFormatterMap() {
/*  44 */     if (this.formatterMap_ == null) {
/*  45 */       logger_.warn("null formatter map?!?!");
/*     */     } else {
/*     */       
/*  48 */       this.formatterMap_.initialize();
/*     */     } 
/*  50 */     return this.formatterMap_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormatterMapConfig getFormatterMapForConfig() {
/*  56 */     return this.formatterMap_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogFilesConfig getLogFiles() {
/*  65 */     return this.logFiles_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoutingRulesConfig getRoutingRules() {
/*  74 */     return this.routingRules_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderSectionMapConfig getSectionsConfig() {
/*  80 */     return this.sectionDefs_;
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
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  94 */     if (argValue instanceof FormatterMapConfig) {
/*  95 */       setFormatterMap((FormatterMapConfig)argValue);
/*     */     }
/*  97 */     else if (argValue instanceof RoutingRulesConfig) {
/*  98 */       setRoutingRules((RoutingRulesConfig)argValue);
/*     */     }
/* 100 */     else if (argValue instanceof LogFilesConfig) {
/* 101 */       setLogFiles((LogFilesConfig)argValue);
/*     */     }
/* 103 */     else if (argValue instanceof DocListConfig) {
/* 104 */       setLogLayoutDefs((DocListConfig)argValue);
/*     */     }
/* 106 */     else if (argValue instanceof DocBuilderSectionMapConfig) {
/* 107 */       setSectionDefs((DocBuilderSectionMapConfig)argValue);
/*     */     } else {
/*     */       
/* 110 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setFormatterMap(FormatterMapConfig argValue) {
/* 115 */     this.formatterMap_ = argValue;
/*     */   }
/*     */   
/*     */   private void setLogFiles(LogFilesConfig argValue) {
/* 119 */     this.logFiles_ = argValue;
/*     */   }
/*     */   
/*     */   private void setLogLayoutDefs(DocListConfig argValue) {
/* 123 */     this.logLayoutDefs_ = argValue;
/*     */   }
/*     */   
/*     */   private void setRoutingRules(RoutingRulesConfig argValue) {
/* 127 */     this.routingRules_ = argValue;
/*     */   }
/*     */   
/*     */   private void setSectionDefs(DocBuilderSectionMapConfig argValue) {
/* 131 */     this.sectionDefs_ = argValue;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\LogDefsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */