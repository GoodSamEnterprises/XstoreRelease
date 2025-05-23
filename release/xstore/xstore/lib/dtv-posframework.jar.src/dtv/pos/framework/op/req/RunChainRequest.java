/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IRunRequest;
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
/*    */ public class RunChainRequest
/*    */   implements IRunRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final IXstEvent event_;
/*    */   private final OpChainKey opChainKey_;
/*    */   private final XstChainActionType chainActionType_;
/*    */   private final IXstEventListener listener_;
/*    */   private final boolean required_;
/*    */   
/*    */   public RunChainRequest(OpChainKey chainKey, IXstEvent event, XstChainActionType argChainActionType, IXstEventListener listener, boolean required) {
/* 33 */     this.chainActionType_ = argChainActionType;
/* 34 */     this.opChainKey_ = chainKey;
/* 35 */     this.event_ = event;
/* 36 */     this.listener_ = listener;
/* 37 */     this.required_ = required;
/*    */   }
/*    */   
/*    */   public RunChainRequest(OpChainKey chainKey, XstChainActionType argChainActionType) {
/* 41 */     this(chainKey, null, argChainActionType, null, true);
/*    */   }
/*    */   
/*    */   public XstChainActionType getChainActionType() {
/* 45 */     return this.chainActionType_;
/*    */   }
/*    */   
/*    */   public IXstEvent getEvent() {
/* 49 */     return this.event_;
/*    */   }
/*    */   
/*    */   public IXstEventListener getEventListener() {
/* 53 */     return this.listener_;
/*    */   }
/*    */   
/*    */   public OpChainKey getOpChainKey() {
/* 57 */     return this.opChainKey_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 63 */     return OpRequestType.RUN_CHAIN.name();
/*    */   }
/*    */   
/*    */   public boolean isRequired() {
/* 67 */     return this.required_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder str = new StringBuilder(200);
/* 74 */     str.append(getClass().getName());
/* 75 */     str.append("::OpChainKey=").append(getOpChainKey());
/* 76 */     str.append("::Event=").append(getEvent());
/* 77 */     return str.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\RunChainRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */