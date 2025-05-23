/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.EventHandler;
/*    */ import dtv.event.EventManager;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import dtv.pos.framework.IHasFlowEventListener;
/*    */ import dtv.pos.framework.OpChainEventHelper;
/*    */ import dtv.pos.framework.scope.TransactionScope;
/*    */ import dtv.pos.framework.scope.XstoreTransactionScope;
/*    */ import dtv.pos.iframework.security.StationState;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransactionActivityTracker
/*    */   implements IHasFlowEventListener
/*    */ {
/*    */   @Inject
/*    */   private EventManager _eventManager;
/*    */   @Inject
/*    */   private ActivityTracker _activityTracker;
/*    */   @Inject
/*    */   private StationState _stationState;
/*    */   @Inject
/*    */   private XstoreTransactionScope _transactionScope;
/*    */   
/*    */   public void registerEventListener(IEventSource argEventSource) {
/* 42 */     this._eventManager.registerEventHandler((IEventAware)this._transTerminatedHandler, argEventSource, 
/* 43 */         OpChainEventHelper.getTransTerminatedConstraint());
/*    */     
/* 45 */     this._eventManager.registerEventHandler((IEventAware)this._transStartedHandler, this._transactionScope.getEventSource(), (IEventConstraint)new NameConstraint(TransactionScope.CURRENT_TRANSACTION));
/*    */   }
/*    */ 
/*    */   
/* 49 */   private final EventHandler _transTerminatedHandler = new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent) {
/* 52 */         TransactionActivityTracker.this._activityTracker.unregister(TransactionActivityTracker.this._stationState.getWorkstationId());
/*    */       }
/*    */     };
/*    */   
/* 56 */   private final EventHandler _transStartedHandler = new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent) {
/* 59 */         if (argEvent.getBaseEvent().getPayload() != null)
/* 60 */           TransactionActivityTracker.this._activityTracker.register(TransactionActivityTracker.this._stationState.getWorkstationId()); 
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\TransactionActivityTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */