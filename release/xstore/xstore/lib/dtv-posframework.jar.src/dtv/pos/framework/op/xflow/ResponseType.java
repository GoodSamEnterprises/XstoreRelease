/*    */ package dtv.pos.framework.op.xflow;
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
/*    */ public enum ResponseType
/*    */ {
/* 20 */   COMPLETE(false),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   COMPLETE_HALT_RESPONSE(false),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   NOTIFY_ERROR_RESPONSE(false),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   SILENT_ERROR_RESPONSE(false),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   WAIT_STACK_CHAIN(true),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 51 */   COMPLETE_STACK_CHAIN(true),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 56 */   STACK_CHAIN(true),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 61 */   RUN_CHAIN_START(true);
/*    */   
/*    */   private boolean chainType_;
/*    */   
/*    */   ResponseType(boolean argChainType) {
/* 66 */     this.chainType_ = argChainType;
/*    */   }
/*    */   
/*    */   public boolean isChainType() {
/* 70 */     return this.chainType_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\ResponseType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */