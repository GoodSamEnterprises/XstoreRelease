/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.impl.daogen.ConfigElementTables;
/*    */ import dtv.util.ClassPathUtils;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
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
/*    */ public class ConfigElementSqlDecorator
/*    */   extends AbstractTargetedDataSqlDecorator
/*    */ {
/*    */   public static final String PARAM_CONFIG_ELEMENT_LIST = "cOnFiGeLeMeNtLiSt";
/*    */   private static final String CONFIG_ELEMENT_COLUMN = "config_element";
/*    */   
/*    */   protected String getReplacementSql(String argTableName, Map<String, Object> argQueryParams) {
/* 38 */     List<String> configElements = new ArrayList<>();
/*    */     
/* 40 */     if (argQueryParams.containsKey("cOnFiGeLeMeNtLiSt")) {
/*    */ 
/*    */ 
/*    */       
/* 44 */       Collection<String> elementsParamValue = (Collection<String>)argQueryParams.get("cOnFiGeLeMeNtLiSt");
/* 45 */       configElements.addAll(elementsParamValue);
/*    */     }
/*    */     else {
/*    */       
/* 49 */       configElements.add("*");
/* 50 */       configElements.addAll(ClassPathUtils.getPrioritizedConfigPathElements().keySet());
/*    */     } 
/*    */     
/* 53 */     StringBuilder newSql = new StringBuilder();
/* 54 */     newSql.append("(SELECT * FROM ").append(argTableName).append(" WHERE config_element IN (");
/*    */ 
/*    */     
/* 57 */     String configElementArgs = SqlQueryBuilder.toSqlInClauseArgs(configElements);
/*    */     
/* 59 */     newSql.append(configElementArgs);
/* 60 */     newSql.append("))");
/*    */     
/* 62 */     return newSql.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Collection<String> getTablesToDecorate() {
/* 68 */     return ConfigElementTables.getTableNames();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDecoratable(String argSqlStatement, Map<String, Object> argQueryParams) {
/* 74 */     boolean superIsDecoratable = super.isDecoratable(argSqlStatement, argQueryParams);
/*    */     
/* 76 */     boolean ignorePresent = (argQueryParams != null && argQueryParams.containsKey("IGNORE_CONFIG_ELEMENT_FILTERING"));
/* 77 */     return (superIsDecoratable && !ignorePresent);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\ConfigElementSqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */