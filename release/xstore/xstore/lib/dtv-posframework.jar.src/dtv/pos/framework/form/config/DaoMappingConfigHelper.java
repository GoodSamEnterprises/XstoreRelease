/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*    */ import dtv.pos.iframework.form.config.IDaoEditMappingListConfig;
/*    */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*    */ import dtv.pos.iframework.form.mapping.IEditModelKey;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Map;
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
/*    */ public class DaoMappingConfigHelper
/*    */   extends ConfigHelper<IDaoEditMappingListConfig>
/*    */ {
/*    */   public Map<IEditModelKey, IDaoEditMappingConfig> getMappingMap() {
/* 27 */     IDaoEditMappingListConfig root = (IDaoEditMappingListConfig)getRootConfig();
/* 28 */     return root.getMappingsMap();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, IDataObjectDefinitionConfig> getObjectMap() {
/* 36 */     IDaoEditMappingListConfig root = (IDaoEditMappingListConfig)getRootConfig();
/* 37 */     return root.getObjectMap();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 43 */     return "DaoEditMapping";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 49 */     if ("DaoEditMappingList".equalsIgnoreCase(dtype)) {
/* 50 */       return (IConfigObject)new DaoEditMappingListConfig();
/*    */     }
/* 52 */     if ("DaoEditMapping".equalsIgnoreCase(dtype)) {
/* 53 */       return (IConfigObject)new DaoEditMappingConfig();
/*    */     }
/* 55 */     if ("DataObjectDefinition".equalsIgnoreCase(dtype)) {
/* 56 */       return (IConfigObject)new DataObjectDefinitionConfig();
/*    */     }
/* 58 */     if ("DataEditFieldList".equalsIgnoreCase(dtype)) {
/* 59 */       return (IConfigObject)new DataEditFieldListConfig();
/*    */     }
/* 61 */     if ("KeyFields".equalsIgnoreCase(dtype)) {
/* 62 */       return (IConfigObject)new DataEditFieldListConfig();
/*    */     }
/* 64 */     if ("DataEditField".equalsIgnoreCase(dtype)) {
/* 65 */       return (IConfigObject)new DataEditFieldConfig();
/*    */     }
/* 67 */     if ("FieldDependency".equalsIgnoreCase(dtype)) {
/* 68 */       return (IConfigObject)new FieldDependencyConfig();
/*    */     }
/* 70 */     if ("FormValueEnumList".equalsIgnoreCase(dtype)) {
/* 71 */       return (IConfigObject)new FormValueEnumListConfig();
/*    */     }
/* 73 */     if ("FormValueEnum".equalsIgnoreCase(dtype)) {
/* 74 */       return (IConfigObject)new FormValueEnumConfig();
/*    */     }
/* 76 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DaoMappingConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */