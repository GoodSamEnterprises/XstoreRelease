/*    */ package dtv.data2.replication.dtximpl.event;
/*    */ 
/*    */ import dtv.data2.replication.dtximpl.ReplicationTransaction;
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
/*    */ public class ReplicationTransactionEvent
/*    */   extends ReplicationEvent
/*    */ {
/*    */   private final ReplicationTransaction replicationTrans_;
/*    */   
/*    */   public ReplicationTransactionEvent(ReplicationTransaction argReplicationTrans) {
/* 21 */     super(ReplicationEvent.ReplicationEventType.PROCESS_TRANSACTION);
/* 22 */     this.replicationTrans_ = argReplicationTrans;
/*    */   }
/*    */   
/*    */   public ReplicationTransaction getReplicationTransaction() {
/* 26 */     return this.replicationTrans_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\event\ReplicationTransactionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */