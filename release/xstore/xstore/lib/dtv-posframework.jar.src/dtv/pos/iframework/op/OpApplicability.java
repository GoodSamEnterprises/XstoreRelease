/*    */ package dtv.pos.iframework.op;
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
/*    */ public enum OpApplicability
/*    */ {
/* 19 */   UNKNOWN
/*    */   {
/*    */     
/*    */     public boolean isApplicable(IOperationImpl argOp)
/*    */     {
/* 24 */       boolean applicable = argOp.isOperationApplicable();
/*    */       
/* 26 */       argOp.setApplicabilityState(applicable ? APPLICABLE : INAPPLICABLE);
/*    */       
/* 28 */       return applicable;
/*    */     }
/*    */   },
/*    */   
/* 32 */   APPLICABLE
/*    */   {
/*    */     public boolean isApplicable(IOperationImpl argOp)
/*    */     {
/* 36 */       return true;
/*    */     }
/*    */   },
/*    */   
/* 40 */   INAPPLICABLE
/*    */   {
/*    */     public boolean isApplicable(IOperationImpl argOp)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */   };
/*    */   
/*    */   public abstract boolean isApplicable(IOperationImpl paramIOperationImpl);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\OpApplicability.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */