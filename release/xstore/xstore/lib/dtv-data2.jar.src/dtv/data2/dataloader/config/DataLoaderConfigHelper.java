/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ public class DataLoaderConfigHelper
/*    */   extends ConfigHelper<DataLoaderConfig>
/*    */ {
/*    */   private static DataLoaderConfig dataLoaderConfig_;
/*    */   
/*    */   static {
/* 22 */     (new DataLoaderConfigHelper()).initialize();
/*    */   }
/*    */   
/*    */   public static DataLoaderConfig getDataLoaderConfig() {
/* 26 */     return dataLoaderConfig_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hashRootConfigs() {
/* 31 */     super.hashRootConfigs();
/*    */     
/* 33 */     dataLoaderConfig_ = (DataLoaderConfig)getRootConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 39 */     return "DataLoaderConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 44 */     if ("DataLoaderConfig".equals(argTagName)) {
/* 45 */       return (IConfigObject)new DataLoaderConfig();
/*    */     }
/* 47 */     if ("Parameter".equals(argTagName)) {
/* 48 */       return (IConfigObject)new DataLoaderParameterConfig();
/*    */     }
/* 50 */     if ("RecordType".equals(argTagName)) {
/* 51 */       return (IConfigObject)new RecordTypeConfig();
/*    */     }
/* 53 */     if ("Dao".equals(argTagName)) {
/* 54 */       return (IConfigObject)new DaoConfig();
/*    */     }
/* 56 */     if ("Sql".equals(argTagName)) {
/* 57 */       return (IConfigObject)new SqlStatementConfig();
/*    */     }
/* 59 */     if ("Field".equals(argTagName)) {
/* 60 */       return (IConfigObject)new FieldConfig();
/*    */     }
/* 62 */     if ("ValueTranslator".equals(argTagName) || "ApplicabilityCondition"
/* 63 */       .equals(argTagName)) {
/* 64 */       return (IConfigObject)new DataModifierConfig();
/*    */     }
/* 66 */     if ("Param".equals(argTagName)) {
/* 67 */       return (IConfigObject)new DataModifierParameterConfig();
/*    */     }
/*    */     
/* 70 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DataLoaderConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */