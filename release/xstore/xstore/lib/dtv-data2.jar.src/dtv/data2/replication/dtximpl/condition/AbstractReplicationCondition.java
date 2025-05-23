/*    */ package dtv.data2.replication.dtximpl.condition;
/*    */ 
/*    */ import dtv.data2.replication.ReplicationConfigException;
/*    */ import dtv.data2.replication.dtximpl.DtxReplicationService;
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
/*    */ public abstract class AbstractReplicationCondition
/*    */ {
/*    */   public abstract boolean isCurrentlyMet(DtxReplicationService paramDtxReplicationService, Object paramObject);
/*    */   
/*    */   public void setParam(String argKey, String argValue) {
/* 23 */     throw new ReplicationConfigException("This condition does not support param with key: " + argKey + " Value: " + argValue);
/*    */   }
/*    */   
/*    */   public abstract String toString();
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\condition\AbstractReplicationCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */