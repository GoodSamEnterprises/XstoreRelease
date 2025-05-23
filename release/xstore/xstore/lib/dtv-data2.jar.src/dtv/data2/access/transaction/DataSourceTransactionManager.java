/*     */ package dtv.data2.access.transaction;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.service.ServiceException;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataSourceTransactionManager
/*     */ {
/*  23 */   private static final Logger logger_ = Logger.getLogger(DataSourceTransactionManager.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  30 */   private static DataSourceTransactionManager instance_ = new DataSourceTransactionManager();
/*     */   
/*     */   public static DataSourceTransactionManager getInstance() {
/*  33 */     return instance_;
/*     */   }
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
/*     */ 
/*     */   
/*     */   public void commit(TransactionToken argToken) {
/*  48 */     Set<ITransactionalDataSource> datasourceSet = argToken.drainDataSources();
/*  49 */     if (datasourceSet.size() == 0) {
/*  50 */       if (logger_.isDebugEnabled()) {
/*  51 */         logger_.debug("Commit was called on token " + argToken.toString() + " but no datasources were registered on that token.  Commit for this token cannot be handled by this manager .");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  60 */     for (ITransactionalDataSource source : datasourceSet) {
/*     */       try {
/*  62 */         source.commitPhase1(argToken);
/*     */       }
/*  64 */       catch (ServiceException ee) {
/*  65 */         logger_.warn("An unexpected Service exception occurred while committing to datasource: " + source, (Throwable)ee);
/*     */       
/*     */       }
/*  68 */       catch (Exception ee) {
/*  69 */         logger_.error("An unexpected exception occurred while committing on datasource: " + source + " datasource name: " + source
/*  70 */             .getDataSourceName(), ee);
/*     */ 
/*     */         
/*  73 */         for (ITransactionalDataSource datasource : datasourceSet) {
/*  74 */           argToken.registerDataSource(datasource);
/*     */         }
/*     */ 
/*     */         
/*  78 */         if (ee instanceof dtv.data2.access.exception.FailoverException) {
/*  79 */           throw ee;
/*     */         }
/*  81 */         if (ee instanceof RuntimeException) {
/*  82 */           throw (RuntimeException)ee;
/*     */         }
/*     */         
/*  85 */         throw new PersistenceException("An exception occuring while committing.", ee);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     for (ITransactionalDataSource source : datasourceSet) {
/*     */       try {
/*  96 */         source.commitPhase2(argToken);
/*     */       }
/*  98 */       catch (ServiceException ee) {
/*  99 */         logger_.warn("An unexpected Service exception occured while committing to datasource:" + source, (Throwable)ee);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDataSourcesRegistered(TransactionToken argToken) {
/* 112 */     return argToken.hasDatasources();
/*     */   }
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
/*     */ 
/*     */   
/*     */   public void registerDataSource(TransactionToken argToken, ITransactionalDataSource argDataSource) {
/* 127 */     if (argToken == null) {
/* 128 */       throw new DataSourceTransactionException("transaction token is null - a value must be provided. Cannot register data source " + argDataSource);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 133 */     argToken.registerDataSource(argDataSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(TransactionToken argToken) {
/* 142 */     Set<ITransactionalDataSource> datasourceSet = argToken.drainDataSources();
/* 143 */     if (datasourceSet == null) {
/* 144 */       if (logger_.isDebugEnabled()) {
/* 145 */         logger_.debug("Rollback was called on token " + argToken.toString() + " but no datasources were registered with the DatasourceTransactionManager for that token.  Rollback for this token cannot be handled by this manager .");
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 151 */     for (ITransactionalDataSource source : datasourceSet) {
/*     */       try {
/* 153 */         source.rollback(argToken);
/*     */       }
/* 155 */       catch (Exception ee) {
/* 156 */         logger_.warn("Exception while rolling back. " + ee);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(TransactionToken argToken, String argDataSourceName) {
/* 167 */     ITransactionalDataSource datasource = argToken.removeDatasource(argDataSourceName);
/* 168 */     if (datasource == null) {
/* 169 */       if (logger_.isDebugEnabled()) {
/* 170 */         logger_.debug("Rollback was called on token " + argToken.toString() + " but no datasource with that name is registered on that token.  Rollback cannot be completed..");
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 177 */       datasource.rollback(argToken);
/*     */     }
/* 179 */     catch (Exception ee) {
/* 180 */       logger_.warn("Exception while rolling back. " + ee);
/*     */     } 
/*     */   }
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
/*     */   
/*     */   public TransactionToken startTransaction(IObjectId argObjectId) {
/* 195 */     if (argObjectId != null) {
/* 196 */       return new TransactionToken(argObjectId.toString().hashCode());
/*     */     }
/*     */     
/* 199 */     return new TransactionToken(hashCode());
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\transaction\DataSourceTransactionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */