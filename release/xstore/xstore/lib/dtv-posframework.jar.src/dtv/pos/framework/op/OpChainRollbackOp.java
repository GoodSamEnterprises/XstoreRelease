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
/*    */ public class OpChainRollbackOp
/*    */   extends Operation
/*    */ {
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 22 */     return this.HELPER.getOpChainRollBackRequest();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainRollbackOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */