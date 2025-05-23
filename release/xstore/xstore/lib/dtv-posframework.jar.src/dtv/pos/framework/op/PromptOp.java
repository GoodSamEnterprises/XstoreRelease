/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.PromptKey;
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
/*    */ public class PromptOp
/*    */   extends AbstractPromptOp
/*    */ {
/*    */   public PromptKey getDefaultPromptKey() {
/* 23 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handlePromptResponse(IXstEvent argEvent) {
/* 29 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\PromptOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */