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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReplicationProcessQueueEvent
/*    */   extends ReplicationEvent
/*    */ {
/*    */   private final int minFailures_;
/*    */   private final int maxFailures_;
/*    */   
/*    */   public ReplicationProcessQueueEvent(int argMinFailures, int argMaxFailures) {
/* 21 */     super(ReplicationEvent.ReplicationEventType.PROCESS_QUEUE);
/* 22 */     this.minFailures_ = argMinFailures;
/* 23 */     this.maxFailures_ = argMaxFailures;
/*    */   }
/*    */   
/*    */   public int getMaxFailures() {
/* 27 */     return this.maxFailures_;
/*    */   }
/*    */   
/*    */   public int getMinFailures() {
/* 31 */     return this.minFailures_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\event\ReplicationProcessQueueEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */