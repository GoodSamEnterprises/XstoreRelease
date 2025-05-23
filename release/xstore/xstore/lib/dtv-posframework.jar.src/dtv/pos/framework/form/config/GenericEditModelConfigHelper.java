/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenericEditModelConfigHelper
/*    */   extends ConfigHelper<DataObjectDefinitionConfig>
/*    */ {
/* 24 */   private static final Logger logger_ = Logger.getLogger(GenericEditModelConfigHelper.class);
/*    */   
/*    */   private final String configFile_;
/*    */   
/*    */   public GenericEditModelConfigHelper(String argConfigFile) {
/* 29 */     this.configFile_ = argConfigFile;
/*    */   }
/*    */   
/*    */   public DataObjectDefinitionConfig getDefinitionConfig() {
/* 33 */     return (DataObjectDefinitionConfig)getRootConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/*    */     try {
/* 44 */       this.parentConfigs_ = new ArrayList();
/*    */       
/* 46 */       this.currentFile_ = (new File(getConfigFileName())).toURI().toURL();
/* 47 */       InputStream is = this.currentFile_.openStream();
/* 48 */       if (is == null) {
/* 49 */         logger_.error("config file not found:" + this.currentFile_);
/*    */       } else {
/*    */         
/* 52 */         loadDocument(is);
/* 53 */         is.close();
/*    */       } 
/*    */       
/* 56 */       hashRootConfigs();
/*    */     }
/* 58 */     catch (Exception ex) {
/* 59 */       logger_.warn("Exception initializing config helper with file " + this.currentFile_, ex);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 65 */     return this.configFile_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 70 */     if ("DaoEditMappingList".equalsIgnoreCase(dtype)) {
/* 71 */       return (IConfigObject)new DaoEditMappingListConfig();
/*    */     }
/* 73 */     if ("DaoEditMapping".equalsIgnoreCase(dtype)) {
/* 74 */       return (IConfigObject)new DaoEditMappingConfig();
/*    */     }
/* 76 */     if ("DataObjectDefinition".equalsIgnoreCase(dtype)) {
/* 77 */       return (IConfigObject)new DataObjectDefinitionConfig();
/*    */     }
/* 79 */     if ("DataEditFieldList".equalsIgnoreCase(dtype)) {
/* 80 */       return (IConfigObject)new DataEditFieldListConfig();
/*    */     }
/* 82 */     if ("DataEditField".equalsIgnoreCase(dtype)) {
/* 83 */       return (IConfigObject)new DataEditFieldConfig();
/*    */     }
/* 85 */     if ("FieldDependency".equalsIgnoreCase(dtype)) {
/* 86 */       return (IConfigObject)new FieldDependencyConfig();
/*    */     }
/* 88 */     if ("FormValueEnumList".equalsIgnoreCase(dtype)) {
/* 89 */       return (IConfigObject)new FormValueEnumListConfig();
/*    */     }
/* 91 */     if ("FormValueEnum".equalsIgnoreCase(dtype)) {
/* 92 */       return (IConfigObject)new FormValueEnumConfig();
/*    */     }
/* 94 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\GenericEditModelConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */