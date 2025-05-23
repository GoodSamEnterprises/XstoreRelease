/*    */ package dtv.data2.access.datasource.config;
/*    */ 
/*    */ import dtv.data2.access.config.common.AbstractDataConfigHelper;
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataSourceConfigHelper
/*    */   extends AbstractDataConfigHelper<DataSourceSetConfig>
/*    */ {
/*    */   public Map<String, DataSourceDescriptor> getDataSourceDescriptors() {
/* 27 */     return ((DataSourceSetConfig)getRootConfig()).getDataSources();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 33 */     return "DataSourceConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 39 */     if ("DataSourceSet".equalsIgnoreCase(argDtype)) {
/* 40 */       return (IConfigObject)new DataSourceSetConfig();
/*    */     }
/* 42 */     if ("DataSource".equalsIgnoreCase(argDtype)) {
/* 43 */       return (IConfigObject)new DataSourceConfig();
/*    */     }
/* 45 */     if ("Ping".equalsIgnoreCase(argDtype)) {
/* 46 */       return (IConfigObject)new PingConfig();
/*    */     }
/*    */     
/* 49 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\config\DataSourceConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */