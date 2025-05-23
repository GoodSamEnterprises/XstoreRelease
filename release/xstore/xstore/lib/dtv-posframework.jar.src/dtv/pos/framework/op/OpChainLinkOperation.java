/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
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
/*    */ public class OpChainLinkOperation
/*    */   extends Operation
/*    */ {
/*    */   private final OpChainKey chainKey_;
/*    */   private final boolean useCommand_;
/*    */   
/*    */   public OpChainLinkOperation(OpChainKey chainKey, boolean useCommand) {
/* 26 */     super(true);
/* 27 */     this.chainKey_ = chainKey;
/* 28 */     this.useCommand_ = useCommand;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 40 */     if (this.useCommand_) {
/* 41 */       return this.HELPER.getStartChainResponse(this.chainKey_);
/*    */     }
/*    */     
/* 44 */     return this.HELPER.getStartChainResponse(this.chainKey_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getAdditionalDebugInfo() {
/* 50 */     return "-->" + this.chainKey_.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainLinkOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */