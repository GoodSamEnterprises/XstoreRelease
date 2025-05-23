/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.IPersistenceStrategy;
/*    */ import java.util.Collection;
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
/*    */ public class DelegatingSqlDecorator
/*    */   implements ISqlQueryDecorator
/*    */ {
/*    */   private Collection<ISqlQueryDecorator> _delegates;
/*    */   
/*    */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, IObjectId argObjId) {
/* 28 */     String sqlStatement = argSqlStatement;
/*    */     
/* 30 */     if (this._delegates != null) {
/* 31 */       for (ISqlQueryDecorator delegate : this._delegates) {
/* 32 */         sqlStatement = delegate.decorateSql(sqlStatement, argTargetStrategy, argObjId);
/*    */       }
/*    */     }
/*    */     
/* 36 */     return sqlStatement;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argParams) {
/* 44 */     String sqlStatement = argSqlStatement;
/* 45 */     if (this._delegates != null) {
/* 46 */       for (ISqlQueryDecorator delegate : this._delegates) {
/* 47 */         sqlStatement = delegate.decorateSql(sqlStatement, argTargetStrategy, argParams);
/*    */       }
/*    */     }
/*    */     
/* 51 */     return sqlStatement;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDelegates(Collection<ISqlQueryDecorator> argDelegates) {
/* 58 */     this._delegates = argDelegates;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\DelegatingSqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */