/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.IPersistenceStrategy;
/*    */ import java.util.Map;
/*    */ import java.util.Properties;
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
/*    */ public class MssqlConcatDecorator
/*    */   implements ISqlQueryDecorator
/*    */ {
/*    */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, IObjectId argObjId) {
/* 25 */     return decorateSqlImpl(argSqlStatement, argTargetStrategy);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argParams) {
/* 33 */     return decorateSqlImpl(argSqlStatement, argTargetStrategy);
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
/*    */   
/*    */   private String decorateSqlImpl(String argSqlStatement, IPersistenceStrategy argTargetStrategy) {
/* 48 */     boolean dsTargetsMssql = targetsMssql(argTargetStrategy);
/*    */ 
/*    */     
/* 51 */     String fixedForMssql = dsTargetsMssql ? argSqlStatement.replaceAll("\\|\\|", "+") : argSqlStatement;
/*    */ 
/*    */     
/* 54 */     return fixedForMssql;
/*    */   }
/*    */   
/*    */   private boolean targetsMssql(IPersistenceStrategy argTargetStrategy) {
/* 58 */     Properties p = argTargetStrategy.getProperties();
/* 59 */     String connFact = p.getProperty("ConnectionFactoryClassName", "");
/* 60 */     if (connFact.contains("com.microsoft.sqlserver")) {
/* 61 */       return true;
/*    */     }
/* 63 */     String driver = p.getProperty("ConnectionDriverName", "");
/* 64 */     if (driver.contains("com.microsoft.sqlserver")) {
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\MssqlConcatDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */