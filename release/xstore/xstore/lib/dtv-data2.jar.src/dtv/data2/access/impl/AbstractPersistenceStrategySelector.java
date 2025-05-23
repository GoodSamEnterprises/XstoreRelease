/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.access.transaction.TransactionToken;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractPersistenceStrategySelector
/*    */   implements IPersistenceStrategySelector
/*    */ {
/*    */   protected IPersistenceStrategy _strategy;
/*    */   
/*    */   public AbstractPersistenceStrategySelector(IPersistenceStrategy argStrategyToUse) {
/* 36 */     this._strategy = argStrategyToUse;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean acceptGetObjectById(IObjectId paramIObjectId);
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean acceptGetObjectByQuery(String paramString, Map<String, Object> paramMap);
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean acceptMakePersistent(TransactionToken paramTransactionToken, IPersistable paramIPersistable);
/*    */ 
/*    */ 
/*    */   
/*    */   public IPersistenceStrategy getPersistenceStrategy() {
/* 54 */     return this._strategy;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setProperties(Properties argProps) {
/* 60 */     if (this._strategy == null) {
/* 61 */       throw new IllegalStateException("Subclasses must initialize strategy.");
/*    */     }
/* 63 */     this._strategy.setProperties(argProps);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractPersistenceStrategySelector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */