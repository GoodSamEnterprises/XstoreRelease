/*    */ package dtv.data2.replication.dtximpl;
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
/*    */ public class ReplicationUniqueTimestampFactory
/*    */ {
/* 15 */   private static ReplicationUniqueTimestampFactory _instance = new ReplicationUniqueTimestampFactory();
/*    */   
/*    */   public static ReplicationUniqueTimestampFactory getInstance() {
/* 18 */     return _instance;
/*    */   }
/*    */   
/* 21 */   private long _previousTimestamp = System.currentTimeMillis();
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized long getCurrentTime() {
/* 26 */     long currentTime = System.currentTimeMillis();
/*    */     
/* 28 */     while (currentTime == this._previousTimestamp) {
/*    */       try {
/* 30 */         Thread.sleep(1L);
/* 31 */         currentTime = System.currentTimeMillis();
/*    */       }
/* 33 */       catch (InterruptedException interruptedException) {}
/*    */     } 
/*    */     
/* 36 */     this._previousTimestamp = currentTime;
/*    */     
/* 38 */     return currentTime;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\ReplicationUniqueTimestampFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */