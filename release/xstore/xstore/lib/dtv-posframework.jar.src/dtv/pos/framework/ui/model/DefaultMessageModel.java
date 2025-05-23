/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.pos.framework.ui.UIModelChangeType;
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
/*    */ 
/*    */ public class DefaultMessageModel
/*    */   implements IMessageModel
/*    */ {
/*    */   private IMessage message_;
/*    */   
/*    */   private static int getPriority(IMessage argMessage) {
/* 25 */     if (argMessage == null) {
/* 26 */       return Integer.MIN_VALUE;
/*    */     }
/*    */     
/* 29 */     return argMessage.getPriority();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   protected Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean addMessage(IMessage argMessage) {
/* 43 */     boolean messageAdded = false;
/*    */     
/* 45 */     if (argMessage != null && !argMessage.equals(this.message_)) {
/* 46 */       int pri1 = getPriority(this.message_);
/* 47 */       int pri2 = getPriority(argMessage);
/*    */       
/* 49 */       if (pri2 >= pri1) {
/* 50 */         this.message_ = argMessage;
/* 51 */         messageAdded = true;
/*    */       } 
/*    */     } 
/*    */     
/* 55 */     this.events_.post(IMessage.MESSAGE_ADDED_HINT, this.message_);
/* 56 */     return messageAdded;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clearMessages() {
/* 64 */     boolean changed = (this.message_ != null);
/* 65 */     this.message_ = null;
/*    */     
/* 67 */     if (changed) {
/* 68 */       this.events_.post(UIModelChangeType.CLEARED);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IMessage getCurrentMessage() {
/* 75 */     return this.message_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultMessageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */