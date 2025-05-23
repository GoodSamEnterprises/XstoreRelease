/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.data2.access.config.common.AbstractDataConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ public class QueryConfigHelper
/*    */   extends AbstractDataConfigHelper<QuerySetConfig>
/*    */ {
/*    */   public Map<String, QueryDescriptor> getQueryDescriptorMap() {
/* 24 */     Map<String, QueryDescriptor> descriptorMap = new HashMap<>();
/*    */     
/* 26 */     List<QueryDescriptor> descriptors = ((QuerySetConfig)getRootConfig()).getQueryDescriptors();
/*    */     
/* 28 */     if (descriptors != null) {
/* 29 */       for (QueryDescriptor descriptor : descriptors) {
/* 30 */         descriptorMap.put(descriptor.getName(), descriptor);
/*    */       }
/*    */     }
/*    */     
/* 34 */     return descriptorMap;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 40 */     return "query";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 46 */     if ("QuerySet".equalsIgnoreCase(argDtype)) {
/* 47 */       return (IConfigObject)new QuerySetConfig();
/*    */     }
/* 49 */     if ("Query".equalsIgnoreCase(argDtype)) {
/* 50 */       return (IConfigObject)new QueryConfig();
/*    */     }
/* 52 */     if ("ResultField".equalsIgnoreCase(argDtype)) {
/* 53 */       return (IConfigObject)new ResultFieldConfig();
/*    */     }
/* 55 */     if ("Expression".equalsIgnoreCase(argDtype)) {
/* 56 */       return (IConfigObject)new QueryExpressionConfig();
/*    */     }
/* 58 */     if ("Parameter".equalsIgnoreCase(argDtype)) {
/* 59 */       return (IConfigObject)new QueryParameterConfig();
/*    */     }
/* 61 */     if ("SQL".equalsIgnoreCase(argDtype)) {
/* 62 */       return (IConfigObject)new QueryStatementConfig();
/*    */     }
/* 64 */     if ("Sort".equalsIgnoreCase(argDtype)) {
/* 65 */       return (IConfigObject)new QuerySortConfig();
/*    */     }
/* 67 */     if ("Having".equalsIgnoreCase(argDtype)) {
/* 68 */       return (IConfigObject)new QueryHavingConfig();
/*    */     }
/*    */     
/* 71 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDirectoryBased() {
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */