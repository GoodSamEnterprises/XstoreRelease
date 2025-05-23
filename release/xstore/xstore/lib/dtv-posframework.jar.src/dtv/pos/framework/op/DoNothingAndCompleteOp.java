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
/*    */ public final class DoNothingAndCompleteOp
/*    */   extends Operation
/*    */ {
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 32 */     return this.HELPER.completeResponse();
/*    */   }
/*    */   
/*    */   public void setParameter(String argName, String argValue) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\DoNothingAndCompleteOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */