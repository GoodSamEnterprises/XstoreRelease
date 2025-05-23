/*    */ package dtv.data2.replication.dtximpl.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReplicationEvent
/*    */ {
/*    */   private final ReplicationEventType eventType_;
/*    */   
/*    */   public ReplicationEvent(ReplicationEventType argReplicationEventType) {
/* 16 */     this.eventType_ = argReplicationEventType;
/*    */   }
/*    */   
/*    */   public ReplicationEventType getEventType() {
/* 20 */     return this.eventType_;
/*    */   }
/*    */   
/*    */   public enum ReplicationEventType {
/* 24 */     PROCESS_QUEUE, PROCESS_TRANSACTION, RESET_OFFLINE_FAILURE_COUNTS;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\event\ReplicationEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */