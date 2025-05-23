/*    */ package dtv.pos.framework.reporting;
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
/*    */ public enum ReportFillStatus
/*    */ {
/* 14 */   NEW(false), PENDING(false), RUNNING(false), CANCELED(true),
/* 15 */   SUCCESS(true), FAILED(true);
/*    */ 
/*    */   
/*    */   private final boolean isFinalState_;
/*    */ 
/*    */   
/*    */   ReportFillStatus(boolean argIsFinalState) {
/* 22 */     this.isFinalState_ = argIsFinalState;
/*    */   }
/*    */   
/*    */   public boolean isFinalState() {
/* 26 */     return this.isFinalState_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportFillStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */