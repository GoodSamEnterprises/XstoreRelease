/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.ui.model.IMessage;
/*    */ import dtv.pos.iframework.ui.model.IMessageModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InfoMessageRequest
/*    */   implements IOpRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private IMessage message_;
/*    */   private boolean isClearRequest_;
/*    */   
/*    */   public static InfoMessageRequest makeClearRequest() {
/* 23 */     InfoMessageRequest r = new InfoMessageRequest();
/* 24 */     r.isClearRequest_ = true;
/* 25 */     return r;
/*    */   }
/*    */   
/*    */   public static InfoMessageRequest makeMessageRequest(IMessage argMessage) {
/* 29 */     InfoMessageRequest r = new InfoMessageRequest();
/* 30 */     r.message_ = argMessage;
/* 31 */     return r;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IMessage getMessage() {
/* 42 */     return this.message_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 48 */     return OpRequestType.INFO_MESSAGE.name();
/*    */   }
/*    */   
/*    */   public boolean process(IMessageModel argModel) {
/* 52 */     boolean messageProcessed = false;
/*    */     
/* 54 */     if (this.isClearRequest_) {
/* 55 */       argModel.clearMessages();
/* 56 */       messageProcessed = true;
/*    */     } else {
/*    */       
/* 59 */       messageProcessed = argModel.addMessage(this.message_);
/*    */     } 
/*    */     
/* 62 */     return messageProcessed;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\InfoMessageRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */