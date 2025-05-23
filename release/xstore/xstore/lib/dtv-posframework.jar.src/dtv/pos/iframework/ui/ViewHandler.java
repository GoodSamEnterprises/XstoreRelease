/*    */ package dtv.pos.iframework.ui;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.EventDescriptor;
/*    */ import dtv.event.EventHandler;
/*    */ import dtv.event.EventManager;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.handler.ConditionalHandler;
/*    */ import dtv.pos.iframework.op.IOpChain;
/*    */ import dtv.pos.iframework.op.IOpChainProcessor;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ViewHandler
/*    */   extends ConditionalHandler
/*    */ {
/* 25 */   protected Event pending_ = null;
/*    */   
/*    */   @Inject
/*    */   private EventManager _eventManager;
/*    */   
/* 30 */   private final EventHandler.SettledNotifier postCompNotification_ = new EventHandler.SettledNotifier()
/*    */     {
/*    */       public void queueSettled()
/*    */       {
/* 34 */         if (ViewHandler.this.pending_ != null) {
/* 35 */           ViewHandler.this.handle(ViewHandler.this.pending_);
/* 36 */           ViewHandler.this.pending_ = null;
/*    */         } 
/*    */       }
/*    */     };
/*    */   
/*    */   protected ViewHandler() {
/* 42 */     this._eventManager.registerEventHandler((IEventAware)this, (IEventSource)new EventDescriptor(IOpChainProcessor.class));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventHandler.SettledNotifier _event(Event argEvent) {
/* 48 */     if (IOpChain.OP_CHAIN_COMPLETE.equals(argEvent.getName())) {
/* 49 */       return this.postCompNotification_;
/*    */     }
/* 51 */     if (check(argEvent)) {
/* 52 */       this.pending_ = argEvent;
/*    */     }
/* 54 */     return null;
/*    */   }
/*    */   
/*    */   protected abstract void handle(Event paramEvent);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\ViewHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */