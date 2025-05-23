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
/*    */ public class CurrentDataSourceCondition
/*    */   extends AbstractReplicationCondition
/*    */ {
/*    */   private static final String STATE_CURRENT_DATA_SOURCE = "currentDataSource";
/*    */   private String currentDataSource_;
/*    */   
/*    */   public boolean isCurrentlyMet(DtxReplicationService argParentService, Object argReplicatableData) {
/* 25 */     if (this.currentDataSource_ == null) {
/* 26 */       throw new ReplicationConfigException("This condition is not properly initialized.  currentDataSource param must be specified.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     return this.currentDataSource_.equals(argParentService.getCurrentDataSource());
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParam(String argKey, String argValue) {
/* 35 */     if ("currentDataSource".equals(argKey)) {
/* 36 */       this.currentDataSource_ = argValue;
/*    */     } else {
/*    */       
/* 39 */       super.setParam(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     return "CurrentDataSourceCondition: datasource: " + this.currentDataSource_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\condition\CurrentDataSourceCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */