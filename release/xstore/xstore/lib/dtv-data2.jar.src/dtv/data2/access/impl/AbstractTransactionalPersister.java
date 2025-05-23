/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractTransactionalPersister
/*     */   implements ITransactionalPersister
/*     */ {
/*  24 */   private static final Logger _logger = Logger.getLogger(AbstractTransactionalPersister.class);
/*     */   
/*     */   private final Map<TransactionToken, List<IPersistable>> _transactionsToPersist;
/*     */   
/*  28 */   private String _dataSourceName = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractTransactionalPersister() {
/*  35 */     this._transactionsToPersist = new HashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase1(TransactionToken argTransToken) {
/*  41 */     for (IPersistable persistable : this._transactionsToPersist.get(argTransToken)) {
/*  42 */       commit(persistable);
/*     */     }
/*  44 */     this._transactionsToPersist.remove(argTransToken);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase2(TransactionToken argTransToken) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/*  56 */     return this._dataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareForPersistence(TransactionToken argTransToken, IPersistable argPersistable) {
/*  62 */     if (!isApplicableForPersistence(argPersistable)) {
/*  63 */       _logger.warn("[" + argPersistable + "] is not a valid persistable for this strategy helper!");
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  69 */     synchronized (this._transactionsToPersist) {
/*  70 */       List<IPersistable> persistablesForThisTrans = this._transactionsToPersist.get(argTransToken);
/*     */       
/*  72 */       if (persistablesForThisTrans == null) {
/*  73 */         persistablesForThisTrans = new ArrayList<>();
/*  74 */         this._transactionsToPersist.put(argTransToken, persistablesForThisTrans);
/*     */ 
/*     */ 
/*     */         
/*  78 */         DataSourceTransactionManager.getInstance().registerDataSource(argTransToken, this);
/*     */       } 
/*     */       
/*  81 */       persistablesForThisTrans.add(argPersistable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(TransactionToken argTransToken) {
/*  88 */     this._transactionsToPersist.remove(argTransToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSourceName(String argDataSourceName) {
/*  94 */     this._dataSourceName = argDataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void commit(IPersistable paramIPersistable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isApplicableForPersistence(IPersistable argPersistable) {
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractTransactionalPersister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */