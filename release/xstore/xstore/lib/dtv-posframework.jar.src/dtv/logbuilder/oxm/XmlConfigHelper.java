/*    */ package dtv.logbuilder.oxm;
/*    */ 
/*    */ import dtv.docbuilding.IDocBuilder;
/*    */ import dtv.docbuilding.config.DocBuilderConfigHelper;
/*    */ import dtv.docbuilding.config.DocBuilderSectionMapConfig;
/*    */ import dtv.logbuilder.LogDocElementFactory;
/*    */ import dtv.util.CompositeObject;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ 
/*    */ 
/*    */ public class XmlConfigHelper
/*    */   extends DocBuilderConfigHelper<XmlDefsConfig>
/*    */ {
/*    */   public IDocBuilder<CompositeObject> getLayout(String argType) {
/* 29 */     return ((XmlDefsConfig)getRootConfig()).getDocListConfig().getBuilder(argType);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 35 */     super.initializeImpl();
/*    */     
/* 37 */     XmlDefsConfig rootConfig = (XmlDefsConfig)getRootConfig();
/*    */     
/* 39 */     DocBuilderSectionMapConfig sectionConfig = rootConfig.getSectionsConfig();
/* 40 */     sectionConfig.initialize(LogDocElementFactory.getInstance(), rootConfig.getFormatterMap());
/* 41 */     rootConfig.getDocListConfig().initialize(sectionConfig.getSections());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 50 */     return "xml";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 56 */     if (dtype != null && 
/* 57 */       "XmlDefinitions".equalsIgnoreCase(dtype)) {
/* 58 */       return (IConfigObject)new XmlDefsConfig();
/*    */     }
/*    */ 
/*    */     
/* 62 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDirectoryBased() {
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDocListConfig(String argDtype) {
/* 74 */     if ("log_types".equalsIgnoreCase(argDtype) || "LogTypes".equalsIgnoreCase(argDtype)) {
/* 75 */       return true;
/*    */     }
/* 77 */     return super.isDocListConfig(argDtype);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\oxm\XmlConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */