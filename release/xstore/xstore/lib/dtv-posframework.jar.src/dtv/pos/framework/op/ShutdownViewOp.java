/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.iframework.XstApplication;
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
/*    */ public class ShutdownViewOp
/*    */   extends Operation
/*    */ {
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 22 */     XstApplication.annihilate();
/* 23 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\ShutdownViewOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */