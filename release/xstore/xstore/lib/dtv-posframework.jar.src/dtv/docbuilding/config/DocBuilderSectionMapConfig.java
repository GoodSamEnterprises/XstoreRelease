/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.DocSectionMap;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderSectionMapConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   public static final String MAIN_TAG = "DocBuilderSectionMap";
/*    */   private static final long serialVersionUID = 1L;
/* 28 */   private final List<DocBuilderSectionConfig> sectionConfigs_ = new ArrayList<>();
/*    */   
/*    */   private DocSectionMap sections_;
/*    */   
/*    */   public List<DocBuilderSectionConfig> getSectionConfigs() {
/* 33 */     return this.sectionConfigs_;
/*    */   }
/*    */   
/*    */   public DocSectionMap getSections() {
/* 37 */     return this.sections_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(IDocElementFactory elementFactory, FormatterMapConfig argFormatterMap) {
/* 48 */     this.sections_ = new DocSectionMap();
/* 49 */     for (int i = 0; i < this.sectionConfigs_.size(); i++) {
/* 50 */       DocBuilderSectionConfig config = this.sectionConfigs_.get(i);
/* 51 */       this.sections_.addSection(config.makeSection(elementFactory, this.sections_, argFormatterMap));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if (argValue instanceof DocBuilderSectionConfig) {
/* 60 */       this.sectionConfigs_.add((DocBuilderSectionConfig)argValue);
/*    */     } else {
/*    */       
/* 63 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderSectionMapConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */