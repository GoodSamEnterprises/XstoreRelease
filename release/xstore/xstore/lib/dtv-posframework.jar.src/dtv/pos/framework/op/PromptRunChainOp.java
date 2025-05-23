/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.framework.action.type.XstDataActionKey;
/*    */ import dtv.pos.framework.op.req.RunChainRequest;
/*    */ import dtv.pos.iframework.action.IXstDataAction;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
/*    */ import dtv.pos.iframework.op.OpStatus;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
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
/*    */ public class PromptRunChainOp
/*    */   extends AbstractPromptOp
/*    */ {
/*    */   private OpChainKey _chainKey;
/*    */   private static final String PARAM_CHAIN_KEY = "ChainKey";
/* 31 */   private XstChainActionType _chainActionType = XstChainActionType.STACK;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PromptKey getDefaultPromptKey() {
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handlePromptResponse(IXstEvent argEvent) {
/* 43 */     RunChainRequest req = new RunChainRequest(this._chainKey, this._chainActionType);
/* 44 */     return new OpResponse(OpStatus.COMPLETE_HALT, new IOpRequest[] { (IOpRequest)req });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 50 */     if ("ChainKey".equalsIgnoreCase(argName)) {
/* 51 */       this._chainKey = OpChainKey.valueOf(argValue);
/*    */     }
/* 53 */     else if ("ChainType".equalsIgnoreCase(argName)) {
/* 54 */       this._chainActionType = XstChainActionType.forName(argValue);
/*    */     } else {
/*    */       
/* 57 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IOpResponse handleDataAction(IXstDataAction argAction) {
/* 64 */     if (XstDataActionKey.NO.equals(argAction.getActionKey())) {
/* 65 */       return this.HELPER.completeResponse();
/*    */     }
/*    */     
/* 68 */     return super.handleDataAction(argAction);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\PromptRunChainOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */