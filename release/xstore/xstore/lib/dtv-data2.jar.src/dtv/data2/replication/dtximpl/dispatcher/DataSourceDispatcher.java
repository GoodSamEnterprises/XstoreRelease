/*     */ package dtv.data2.replication.dtximpl.dispatcher;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.PersistenceStrategyFactory;
/*     */ import dtv.data2.access.impl.remote.AbstractHttpDatasource;
/*     */ import dtv.data2.access.impl.remote.servlet.ServletPersistenceStrategy;
/*     */ import dtv.data2.access.pm.PersistenceManagerStatus;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.data2.replication.dtximpl.ReplicationTransaction;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataSourceDispatcher
/*     */   implements IDtxReplicationDispatcher
/*     */ {
/*  41 */   private static final Logger auditLogger_ = Logger.getLogger("REPLICATION_AUDIT_LOG");
/*  42 */   private static final Logger successJournalLogger_ = Logger.getLogger("dtv.data2.replication.journal");
/*     */ 
/*     */   
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */ 
/*     */   
/*     */   private String _dataSourceName;
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSourceDispatcher(String argDataSourceName, PersistenceStrategyFactory argPersistenceStrategyFactory) {
/*  53 */     this(argPersistenceStrategyFactory);
/*  54 */     this._dataSourceName = argDataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataSourceDispatcher(PersistenceStrategyFactory argPersistenceStrategyFactory) {
/*  62 */     this._persistenceStrategyFactory = argPersistenceStrategyFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDtxReplicationDispatcher.DispatchResult dispatch(ReplicationTransaction argReplicationLog) {
/*  68 */     return dispatchImpl(this._dataSourceName, argReplicationLog);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDestination() {
/*  74 */     return this._dataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  80 */     return DataSourceFactory.isDataSourceEnabled(this._dataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTargeted(String argDataSourceName) {
/*  86 */     boolean isTargeted = StringUtils.equalsIgnoreCase(this._dataSourceName, argDataSourceName);
/*  87 */     return isTargeted;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void configureDatasource(IPersistenceStrategy argStrategy) {
/*  92 */     if (argStrategy instanceof AbstractHttpDatasource) {
/*  93 */       ((AbstractHttpDatasource)argStrategy)
/*  94 */         .setTimeout(((AbstractHttpDatasource)argStrategy).getTimeout() * 2);
/*     */     }
/*     */ 
/*     */     
/*  98 */     if (argStrategy instanceof ServletPersistenceStrategy) {
/*  99 */       ((ServletPersistenceStrategy)argStrategy).setMessageType(ServletPersistenceStrategy.MessageType.REPLICATE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected IDtxReplicationDispatcher.DispatchResult dispatchImpl(String argDataSourceName, ReplicationTransaction argReplicationLog) {
/* 105 */     if (auditLogger_.isDebugEnabled()) {
/* 106 */       auditLogger_.debug("DataSourceDispather about to dispatch trans: " + argReplicationLog
/* 107 */           .getTransactionId() + " to datasource: " + argDataSourceName);
/*     */     }
/*     */     
/* 110 */     TransactionToken token = null;
/*     */     
/*     */     try {
/* 113 */       token = new TransactionToken(argReplicationLog.getTransactionId().hashCode());
/* 114 */       String timestamp = DateUtils.formatReplicationDate((Date)new DtvDate(argReplicationLog.getCreatedTime()));
/* 115 */       token.setProperty("TIMESTAMP_PROPERTY", timestamp);
/* 116 */       token.setProperty("WORKSTATION_ID_PROPERTY", 
/* 117 */           String.valueOf(argReplicationLog.getWorkstationId()));
/*     */       
/* 119 */       if (!DataSourceFactory.isDataSourceEnabled(argDataSourceName)) {
/* 120 */         auditLogger_.info("Data not replicated because datasource: " + argDataSourceName + " is disabled. Replication trans id: " + argReplicationLog
/* 121 */             .getTransactionId());
/*     */         
/* 123 */         return IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */       } 
/*     */       
/* 126 */       if (PersistenceManagerStatus.ONLINE != StatusMgr.getInstance().getDataSourceStatus(argDataSourceName)) {
/* 127 */         auditLogger_.info("Data not replicated because datasource: " + argDataSourceName + " is not online. Replication trans id: " + argReplicationLog
/* 128 */             .getTransactionId());
/*     */         
/* 130 */         return IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */       } 
/*     */ 
/*     */       
/* 134 */       DataSourceDescriptor dataSource = DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSourceName);
/*     */ 
/*     */       
/* 137 */       IPersistenceStrategy _persistenceStrategy = this._persistenceStrategyFactory.createStrategy(dataSource, true);
/*     */       
/* 139 */       configureDatasource(_persistenceStrategy);
/* 140 */       List<IPersistable> persistables = argReplicationLog.getPersistables();
/*     */       
/* 142 */       for (IPersistable persistable : persistables) {
/* 143 */         _persistenceStrategy.makePersistent(token, persistable);
/*     */       }
/*     */       
/* 146 */       DataSourceTransactionManager.getInstance().commit(token);
/*     */       
/* 148 */       if (auditLogger_.isInfoEnabled()) {
/* 149 */         auditLogger_.info("----- Data Replicated OK to [" + argDataSourceName + "] Data: " + argReplicationLog
/* 150 */             .getPersistablesAsXml() + " replication trans id " + argReplicationLog
/* 151 */             .getTransactionId() + " replication service name: " + argReplicationLog
/* 152 */             .getServiceName());
/*     */       }
/*     */       
/* 155 */       if (successJournalLogger_.isInfoEnabled()) {
/* 156 */         successJournalLogger_.info(getSuccessJournalEntry(_persistenceStrategy, argReplicationLog));
/*     */       }
/*     */       
/* 159 */       return IDtxReplicationDispatcher.DispatchResult.DISPATCH_SUCCESSFUL;
/*     */     }
/* 161 */     catch (Exception ee) {
/* 162 */       if (token != null) {
/* 163 */         DataSourceTransactionManager.getInstance().rollback(token);
/*     */       }
/* 165 */       boolean offline = false;
/*     */ 
/*     */       
/* 168 */       if (!ReplicationPossibleFilter.getInstance().isReplicationPossible(ee)) {
/* 169 */         auditLogger_.warn("Data not replicated to datasource [" + argDataSourceName + "] because replication is impossible. Replication trans id: " + argReplicationLog
/*     */             
/* 171 */             .getTransactionId() + " Cause: " + ee.toString());
/*     */         
/* 173 */         return IDtxReplicationDispatcher.DispatchResult.DISPATCH_IMPOSSIBLE_TO_REPLICATE;
/*     */       } 
/*     */ 
/*     */       
/* 177 */       if (ee instanceof dtv.data2.access.exception.ServletFailoverException) {
/*     */ 
/*     */         
/* 180 */         offline = FailoverException.isFailover(new Exception(ee.getMessage()));
/*     */       } else {
/*     */         
/* 183 */         offline = FailoverException.isFailover(ee);
/*     */       } 
/* 185 */       if (offline) {
/* 186 */         if (auditLogger_.isDebugEnabled()) {
/* 187 */           auditLogger_.debug("Dispatch to datasource: [" + argDataSourceName + "] of trans: [" + argReplicationLog
/* 188 */               .getTransactionId() + "] FAILED b/c of Failover. " + ee.toString());
/*     */         }
/*     */         
/* 191 */         return IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */       } 
/*     */       
/* 194 */       auditLogger_
/* 195 */         .warn("An error occurred while attempting to dispatch to datasource: [" + argDataSourceName + "] " + ee
/* 196 */           .toString() + " replication trans id " + argReplicationLog.getTransactionId());
/*     */       
/* 198 */       return IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSuccessJournalEntry(IPersistenceStrategy argStrategy, ReplicationTransaction argReplicationTrans) {
/* 207 */     String source = argReplicationTrans.getOrganizationId() + "::" + argReplicationTrans.getRetailLocationId() + "::" + argReplicationTrans.getWorkstationId();
/*     */     
/* 209 */     String entry = "<replication status=\"success\" timestamp=\"%s\" source=\"%s\" destination=\"%s\">%s</replication>";
/*     */ 
/*     */     
/* 212 */     return String.format(entry, new Object[] { DateUtils.formatIsoDateTime(new Date()), source, argStrategy
/* 213 */           .getDataSourceName(), argReplicationTrans.getPersistablesAsXml() });
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\dispatcher\DataSourceDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */