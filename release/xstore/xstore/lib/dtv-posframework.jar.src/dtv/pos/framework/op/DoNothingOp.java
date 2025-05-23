/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
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
/*    */ public class DoNothingOp
/*    */   extends Operation
/*    */ {
/*    */   private static final String WAIT = "WAIT";
/*    */   private static final String COMPLETE = "COMPLETE";
/*    */   private static final String COMPLETE_HALT = "COMPLETE_HALT";
/*    */   private static final String INCOMPLETE = "INCOMPLETE";
/*    */   private static final String NOTIFY_ERROR = "NOTIFY_ERROR";
/*    */   private static final String SILENT_ERROR = "SILENT_ERROR";
/*    */   private static final String BACKUP_RESPONSE = "BACKUP_RESPONSE";
/* 28 */   private String responseName_ = "WAIT";
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 32 */     if ("COMPLETE".equalsIgnoreCase(this.responseName_)) {
/* 33 */       return this.HELPER.completeResponse();
/*    */     }
/* 35 */     if ("INCOMPLETE".equalsIgnoreCase(this.responseName_)) {
/* 36 */       return this.HELPER.incompleteResponse();
/*    */     }
/* 38 */     if ("COMPLETE_HALT".equalsIgnoreCase(this.responseName_)) {
/* 39 */       return this.HELPER.completeWaitResponse();
/*    */     }
/* 41 */     if ("NOTIFY_ERROR".equalsIgnoreCase(this.responseName_)) {
/* 42 */       return this.HELPER.errorNotifyResponse();
/*    */     }
/* 44 */     if ("SILENT_ERROR".equalsIgnoreCase(this.responseName_)) {
/* 45 */       return this.HELPER.silentErrorResponse();
/*    */     }
/* 47 */     if ("BACKUP_RESPONSE".equalsIgnoreCase(this.responseName_)) {
/* 48 */       return this.HELPER.getBackupResponse();
/*    */     }
/*    */     
/* 51 */     return this.HELPER.waitResponse();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 57 */     if ("Response".equalsIgnoreCase(argName)) {
/* 58 */       this.responseName_ = argValue;
/*    */     } else {
/*    */       
/* 61 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\DoNothingOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */