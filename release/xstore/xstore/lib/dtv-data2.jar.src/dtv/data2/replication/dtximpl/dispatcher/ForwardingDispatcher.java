/*     */ package dtv.data2.replication.dtximpl.dispatcher;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.replication.dtximpl.ReplicationQueueAccessor;
/*     */ import dtv.data2.replication.dtximpl.ReplicationTransaction;
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
/*     */ public class ForwardingDispatcher
/*     */   implements IDtxReplicationDispatcher
/*     */ {
/*  26 */   private static final Logger auditLogger_ = Logger.getLogger("REPLICATION_AUDIT_LOG");
/*     */ 
/*     */ 
/*     */   
/*     */   private final String dataSourceToForwardTo_;
/*     */ 
/*     */   
/*     */   private final String destinationService_;
/*     */ 
/*     */ 
/*     */   
/*     */   public ForwardingDispatcher(String argDataSourceToForwardTo, String argDestinationService) {
/*  38 */     this.dataSourceToForwardTo_ = argDataSourceToForwardTo;
/*  39 */     this.destinationService_ = argDestinationService;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDtxReplicationDispatcher.DispatchResult dispatch(ReplicationTransaction argReplicationLog) {
/*  45 */     if (auditLogger_.isDebugEnabled()) {
/*  46 */       auditLogger_.debug("Attempting dispatch of trans: " + argReplicationLog.getTransactionId() + " on ForwardingDispatcher. Destination datasource: " + this.dataSourceToForwardTo_ + ". Destination service: " + this.destinationService_);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     IDtxReplicationDispatcher.DispatchResult result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */     
/*     */     try {
/*  59 */       boolean success = ReplicationQueueAccessor.getInstance().addObjectRemote(argReplicationLog, this.dataSourceToForwardTo_, this.destinationService_);
/*     */ 
/*     */       
/*  62 */       if (success) {
/*  63 */         result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_SUCCESSFUL;
/*     */         
/*  65 */         if (auditLogger_.isInfoEnabled()) {
/*  66 */           auditLogger_
/*  67 */             .info("----- Data replicated: Replication eueue entry forwarded to queue on datasource: " + this.dataSourceToForwardTo_ + " Data: " + argReplicationLog
/*  68 */               .getPersistablesAsXml());
/*     */         }
/*     */       } else {
/*     */         
/*  72 */         result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */         
/*  74 */         if (auditLogger_.isDebugEnabled()) {
/*  75 */           auditLogger_.debug(" FAILURE Dispatch of trans: " + argReplicationLog.getTransactionId() + " on ForwardingDispatcher with destination datasource: " + this.dataSourceToForwardTo_ + ". Destination service: " + this.destinationService_ + " PROBLEM UNKNOWN! No exception thrown. ");
/*     */         
/*     */         }
/*     */       }
/*     */     
/*     */     }
/*  81 */     catch (Exception ee) {
/*  82 */       if (FailoverException.isFailover(ee)) {
/*  83 */         result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */         
/*  85 */         if (auditLogger_.isDebugEnabled()) {
/*  86 */           auditLogger_.debug(" FAILURE Dispatch of trans: " + argReplicationLog.getTransactionId() + " on ForwardingDispatcher with destination datasource: " + this.dataSourceToForwardTo_ + ". Destination service: " + this.destinationService_ + " Due to FailoverException " + ee);
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/*  92 */         result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE;
/*     */         
/*  94 */         if (auditLogger_.isDebugEnabled()) {
/*  95 */           auditLogger_.debug(" FAILURE Dispatch of trans: " + argReplicationLog.getTransactionId() + " on ForwardingDispatcher with destination datasource: " + this.dataSourceToForwardTo_ + ". Destination service: " + this.destinationService_ + " Due to ERROR.", ee);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 102 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDestination() {
/* 108 */     return this.dataSourceToForwardTo_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 114 */     return DataSourceFactory.isDataSourceEnabled(this.dataSourceToForwardTo_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTargeted(String argDataSourceName) {
/* 122 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\dispatcher\ForwardingDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */