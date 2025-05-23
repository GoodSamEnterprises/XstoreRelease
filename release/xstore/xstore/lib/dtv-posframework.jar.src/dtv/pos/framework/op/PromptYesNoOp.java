/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.framework.action.type.XstDataActionKey;
/*    */ import dtv.pos.iframework.action.IXstAction;
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
/*    */ public class PromptYesNoOp
/*    */   extends AbstractPromptOp
/*    */ {
/*    */   public PromptKey getDefaultPromptKey() {
/* 26 */     return PromptKey.valueOf("PROMPT_CONFIRM");
/*    */   }
/*    */ 
/*    */   
/*    */   public IOpResponse handlePromptResponse(IXstEvent argEvent) {
/* 31 */     IOpResponse response = null;
/*    */     
/* 33 */     if (argEvent instanceof IXstAction && ((IXstAction)argEvent)
/* 34 */       .getActionKey().equals(XstDataActionKey.NO)) {
/* 35 */       response = this.HELPER.silentErrorResponse();
/*    */     }
/* 37 */     return (response == null) ? this.HELPER.completeResponse() : response;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\PromptYesNoOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */