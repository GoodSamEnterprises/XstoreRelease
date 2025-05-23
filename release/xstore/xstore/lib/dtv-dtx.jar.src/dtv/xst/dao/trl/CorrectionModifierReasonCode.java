/*    */ package dtv.xst.dao.trl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CorrectionModifierReasonCode
/*    */ {
/* 13 */   COMPLETED(true), CANCELLED(true), LAYAWAY_PICKUP(true), SPECIAL_ORDER_PICKUP(true), WORK_ORDER_PICKUP(true),
/* 14 */   LAYAWAY_CANCEL(true), SPECIAL_ORDER_CANCEL(true), WORK_ORDER_CANCEL(true), RESUME(false),
/* 15 */   CUSTOMER_ACCOUNT_PICKUP(true), CUSTOMER_ACCOUNT_CANCEL(true);
/*    */ 
/*    */   
/*    */   private boolean _representsCompletion;
/*    */ 
/*    */ 
/*    */   
/*    */   CorrectionModifierReasonCode(boolean argRepresentsCompletion) {
/* 23 */     this._representsCompletion = argRepresentsCompletion;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 32 */     return name();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(String argName) {
/* 43 */     return name().equalsIgnoreCase(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean representsAccountCompletion() {
/* 52 */     return this._representsCompletion;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\CorrectionModifierReasonCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */