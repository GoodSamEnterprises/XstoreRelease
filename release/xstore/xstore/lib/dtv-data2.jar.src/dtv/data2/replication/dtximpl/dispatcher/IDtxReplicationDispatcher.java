/*    */ package dtv.data2.replication.dtximpl.dispatcher;
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
/*    */ 
/*    */ 
/*    */ public interface IDtxReplicationDispatcher
/*    */ {
/*    */   DispatchResult dispatch(ReplicationTransaction paramReplicationTransaction);
/*    */   
/*    */   Object getDestination();
/*    */   
/*    */   boolean isEnabled();
/*    */   
/*    */   boolean isTargeted(String paramString);
/*    */   
/*    */   public enum DispatchResult
/*    */   {
/* 51 */     DISPATCH_SUCCESSFUL, DISPATCH_OFFLINE_FAILURE, DISPATCH_ERROR_FAILURE, DISPATCH_IMPOSSIBLE_TO_REPLICATE;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\dispatcher\IDtxReplicationDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */