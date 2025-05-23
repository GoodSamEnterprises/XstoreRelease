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
/*    */ 
/*    */ 
/*    */ public abstract class AbstractMssqlDecorator
/*    */   implements ISqlQueryDecorator
/*    */ {
/*    */   public final String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, IObjectId argObjId) {
/* 27 */     return decorateSqlImpl(argSqlStatement, argTargetStrategy);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argParams) {
/* 35 */     return decorateSqlImpl(argSqlStatement, argTargetStrategy);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract String decorate(String paramString);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String decorateSqlImpl(String argSqlStatement, IPersistenceStrategy argTargetStrategy) {
/* 47 */     if (targetsMssql(argTargetStrategy)) {
/* 48 */       return decorate(argSqlStatement);
/*    */     }
/* 50 */     return argSqlStatement;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean targetsMssql(IPersistenceStrategy argTargetStrategy) {
/* 58 */     Properties p = argTargetStrategy.getProperties();
/* 59 */     String connFact = p.getProperty("ConnectionFactoryClassName", "");
/* 60 */     if (connFact.contains("com.microsoft.sqlserver")) {
/* 61 */       return true;
/*    */     }
/*    */     
/* 64 */     String driver = p.getProperty("ConnectionDriverName", "");
/* 65 */     if (driver.contains("com.microsoft.sqlserver")) {
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\AbstractMssqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */