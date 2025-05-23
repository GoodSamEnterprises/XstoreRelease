/*    */ package dtv.logbuilder.oxm;
/*    */ 
/*    */ import dtv.docbuilding.config.DocBuilderSectionMapConfig;
/*    */ import dtv.docbuilding.config.DocListConfig;
/*    */ import dtv.docbuilding.config.FormatterMapConfig;
/*    */ import dtv.docbuilding.config.IDocBuilderRootConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlDefsConfig
/*    */   extends AbstractParentConfig
/*    */   implements IDocBuilderRootConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private static final Logger logger_ = Logger.getLogger(XmlDefsConfig.class);
/*    */   
/* 26 */   private FormatterMapConfig formatterMap_ = null;
/* 27 */   private final DocListConfig xmlDocDefs_ = new DocListConfig();
/* 28 */   private final DocBuilderSectionMapConfig sectionDefs_ = new DocBuilderSectionMapConfig();
/*    */ 
/*    */ 
/*    */   
/*    */   public DocListConfig getDocListConfig() {
/* 33 */     return this.xmlDocDefs_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FormatterMapConfig getFormatterMap() {
/* 42 */     if (this.formatterMap_ == null) {
/* 43 */       logger_.warn("null formatter map?!?!");
/*    */     } else {
/*    */       
/* 46 */       this.formatterMap_.initialize();
/*    */     } 
/* 48 */     return this.formatterMap_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FormatterMapConfig getFormatterMapForConfig() {
/* 54 */     return this.formatterMap_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderSectionMapConfig getSectionsConfig() {
/* 60 */     return this.sectionDefs_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 74 */     if (argValue instanceof FormatterMapConfig) {
/* 75 */       setFormatterMap((FormatterMapConfig)argValue);
/*    */     }
/* 77 */     else if (argValue instanceof dtv.docbuilding.config.DocConfig) {
/* 78 */       getDocListConfig().setConfigObject(argKey, argValue);
/*    */     }
/* 80 */     else if (argValue instanceof dtv.docbuilding.config.DocBuilderSectionConfig) {
/* 81 */       getSectionsConfig().setConfigObject(argKey, argValue);
/*    */     } else {
/*    */       
/* 84 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void setFormatterMap(FormatterMapConfig argValue) {
/* 89 */     this.formatterMap_ = argValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\oxm\XmlDefsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */