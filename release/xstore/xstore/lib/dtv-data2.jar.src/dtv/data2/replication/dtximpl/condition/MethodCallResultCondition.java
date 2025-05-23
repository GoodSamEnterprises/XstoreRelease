/*    */ package dtv.data2.replication.dtximpl.condition;
/*    */ 
/*    */ import dtv.data2.replication.ReplicationException;
/*    */ import dtv.data2.replication.dtximpl.DtxReplicationService;
/*    */ import dtv.util.ObjectUtils;
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
/*    */ public class MethodCallResultCondition
/*    */   extends AbstractReplicationCondition
/*    */ {
/*    */   private static final String PARAM_METHOD_NAME = "methodName";
/*    */   private static final String PARAM_RESULT = "result";
/*    */   private String methodName_;
/*    */   private String applicableResult_;
/*    */   
/*    */   public boolean isCurrentlyMet(DtxReplicationService argParentService, Object argReplicatableData) {
/*    */     try {
/* 31 */       Object result = ObjectUtils.invokeMethod(this.methodName_, argReplicatableData, "DtxReplicationConfig.xml");
/*    */       
/* 33 */       if (result == null) {
/* 34 */         return this.applicableResult_.equals("null");
/*    */       }
/*    */       
/* 37 */       return String.valueOf(result).equals(this.applicableResult_);
/*    */     
/*    */     }
/* 40 */     catch (Exception ee) {
/*    */       
/* 42 */       throw new ReplicationException("An exception occurred during MethodCallResultCondition. Could not check this condition.  Method name: " + this.methodName_ + " Applicable Value: " + this.applicableResult_ + " replication object: " + argReplicatableData, ee);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParam(String argKey, String argValue) {
/* 50 */     if ("methodName".equals(argKey)) {
/* 51 */       this.methodName_ = argValue;
/*    */     }
/* 53 */     else if ("result".equals(argKey)) {
/* 54 */       this.applicableResult_ = argValue;
/*    */     } else {
/*    */       
/* 57 */       super.setParam(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "MethodCallResultCondition: met when call to: " + this.methodName_ + " results in: " + this.applicableResult_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\condition\MethodCallResultCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */