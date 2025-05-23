/*     */ package dtv.data2.replication.dtximpl;
/*     */ 
/*     */ import com.google.common.collect.LinkedListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*     */ import dtv.data2.access.transaction.ITransactionalDataSource;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.data2.replication.IReplicationStrategy;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ public class DtxReplicationStrategy
/*     */   implements IReplicationStrategy
/*     */ {
/*     */   public static final String REPLICATION_AUDIT_LOG = "REPLICATION_AUDIT_LOG";
/*  31 */   private static final Logger auditLogger_ = Logger.getLogger("REPLICATION_AUDIT_LOG");
/*     */   
/*  33 */   private final Object transLock_ = new Object();
/*     */ 
/*     */   
/*  36 */   ListMultimap<TransactionToken, ReplicationTransaction> replicationTransactions_ = (ListMultimap<TransactionToken, ReplicationTransaction>)LinkedListMultimap.create();
/*     */   
/*     */   @Inject
/*     */   private DtxReplicationServiceFactory serviceFactory_;
/*     */   
/*     */   @Inject
/*     */   private ReplicationProcessor _replicationProcessor;
/*     */   
/*     */   public DtxReplicationStrategy() {
/*  45 */     this(true);
/*     */   }
/*     */   
/*     */   protected DtxReplicationStrategy(boolean argStartProcessor) {
/*  49 */     InjectionHammer.forceAtInjectProcessing(this);
/*  50 */     if (argStartProcessor) {
/*  51 */       this._replicationProcessor.startProcessor();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase1(TransactionToken argTransToken) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase2(TransactionToken argTransToken) {
/*  64 */     auditLogger_.debug("BEGIN commitPhase2");
/*     */     
/*  66 */     List<ReplicationTransaction> trans = null;
/*     */     
/*  68 */     synchronized (this.transLock_) {
/*  69 */       auditLogger_.debug("getting list of transactions");
/*  70 */       trans = this.replicationTransactions_.removeAll(argTransToken);
/*     */       
/*  72 */       if (auditLogger_.isDebugEnabled()) {
/*  73 */         auditLogger_.debug("got list of " + trans.size() + " to replicate");
/*     */       }
/*     */     } 
/*     */     
/*  77 */     if (trans.isEmpty()) {
/*  78 */       auditLogger_.debug("nothing to commit?");
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  85 */     if (auditLogger_.isDebugEnabled()) {
/*  86 */       auditLogger_.debug("dispatching " + trans.size() + " replication transactions to ReplicationProcessor");
/*     */     }
/*     */     
/*  89 */     for (ReplicationTransaction tran : trans) {
/*  90 */       this._replicationProcessor.enqueue(tran);
/*     */     }
/*     */     
/*  93 */     auditLogger_.debug("END commitPhase2");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/*  99 */     return "DtxReplicationStrategy";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplicationCandidate(String argDataSourceName, Object argData, List<String> argExcludedDataSources) {
/* 108 */     boolean result = this.serviceFactory_.isReplicationCandidate(argDataSourceName, argData, argExcludedDataSources);
/*     */     
/* 110 */     if (auditLogger_.isDebugEnabled()) {
/* 111 */       auditLogger_.debug("Object " + argData.getClass().getName() + " replication candidate: " + result);
/*     */     }
/* 113 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replicateData(String argCurrentDataSource, TransactionToken argTransToken, IPersistable argData, List<String> argExcludedDataSources) {
/* 121 */     if (auditLogger_.isDebugEnabled()) {
/* 122 */       auditLogger_.debug("**** BEGIN replicateData. Current ds: " + argCurrentDataSource + " data: " + argData);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     List<ReplicationTransaction> existingTransactions = null;
/*     */     
/* 133 */     synchronized (this.transLock_) {
/* 134 */       existingTransactions = this.replicationTransactions_.get(argTransToken);
/*     */     } 
/*     */     
/* 137 */     if (existingTransactions.isEmpty()) {
/* 138 */       DataSourceTransactionManager.getInstance().registerDataSource(argTransToken, (ITransactionalDataSource)this);
/*     */     }
/*     */ 
/*     */     
/* 142 */     List<String> applicableServices = this.serviceFactory_.getApplicableServices(argCurrentDataSource, argData, argExcludedDataSources);
/*     */     
/* 144 */     if (auditLogger_.isDebugEnabled()) {
/* 145 */       auditLogger_.debug("Applicable services for " + argData.getClass().getName() + ": " + applicableServices);
/*     */     }
/*     */ 
/*     */     
/* 149 */     for (String serviceName : applicableServices) {
/* 150 */       ReplicationTransaction trans = null;
/*     */       
/* 152 */       for (ReplicationTransaction t : existingTransactions) {
/* 153 */         if (serviceName.equals(t.getServiceName())) {
/* 154 */           trans = t;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 161 */       if (trans == null) {
/* 162 */         auditLogger_.debug("Begin create new trans");
/* 163 */         trans = this.serviceFactory_.getNewTransaction(serviceName);
/* 164 */         trans.setTransactionId(argTransToken.getValue());
/*     */         
/* 166 */         synchronized (this.transLock_) {
/* 167 */           this.replicationTransactions_.put(argTransToken, trans);
/*     */         } 
/*     */         
/* 170 */         auditLogger_.debug("End create new trans");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       if (auditLogger_.isDebugEnabled()) {
/* 178 */         auditLogger_.debug("adding argData " + argData.getClass().getName() + " to: " + trans
/* 179 */             .getTransactionId());
/*     */       }
/*     */       
/* 182 */       trans.addDataAsXmlString(argData.toXmlString());
/*     */     } 
/*     */     
/* 185 */     auditLogger_.debug("**** END replicateData");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(TransactionToken argTransToken) {
/* 191 */     auditLogger_.debug("BEGIN rollback");
/*     */ 
/*     */     
/* 194 */     synchronized (this.transLock_) {
/* 195 */       this.replicationTransactions_.removeAll(argTransToken);
/*     */     } 
/*     */     
/* 198 */     auditLogger_.debug("END rollback");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\DtxReplicationStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */