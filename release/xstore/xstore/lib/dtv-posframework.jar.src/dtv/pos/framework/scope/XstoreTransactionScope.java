/*     */ package dtv.pos.framework.scope;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.pos.common.TransactionType;
/*     */ import dtv.pos.framework.IHasFlowEventListener;
/*     */ import dtv.pos.framework.OpChainEventHelper;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XstoreTransactionScope
/*     */   extends AbstractScope
/*     */   implements TransactionScope, IHasFlowEventListener
/*     */ {
/*  38 */   private static final Logger _logger = Logger.getLogger(XstoreTransactionScope.class);
/*  39 */   private static IEventSource _valueChangeDesriptor = (IEventSource)new EventDescriptor("xstoreTransactionScope");
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */   
/*  44 */   private EventHandler _clearScopeHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent) {
/*  47 */         DefaultEventor defaultEventor = new DefaultEventor(XstoreTransactionScope.this.getEventSource());
/*     */         
/*  49 */         for (ValueKey<?> key : XstoreTransactionScope.this.getStorage().keySet())
/*     */         {
/*     */           
/*  52 */           defaultEventor.post(key);
/*     */         }
/*  54 */         ThreadContext.put("trans", null);
/*     */         
/*  56 */         XstoreTransactionScope._logger.debug("TransactionScope: clearing scope");
/*  57 */         XstoreTransactionScope.this.getStorage().clear();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private EventHandler _modifiedTransactionHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/*  68 */         DefaultEventor defaultEventor = new DefaultEventor(XstoreTransactionScope.this.getEventSource());
/*  69 */         defaultEventor.post(TransactionScope.TRANSACTION_MODIFIED, argEvent.getPayload());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> void clearValue(ValueKey<T> argValueKey) {
/*  82 */     getStorage().remove(argValueKey);
/*  83 */     this._flowLogger.debug(getScopeName(), argValueKey.getName(), null, "-", null);
/*     */     
/*  85 */     if (_logger.isTraceEnabled()) {
/*  86 */       _logger.trace(new Throwable("Stack trace for " + argValueKey));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IEventSource getEventSource() {
/*  92 */     return _valueChangeDesriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPosTransaction getTransaction() {
/* 103 */     return getValue(TransactionScope.CURRENT_TRANSACTION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IPosTransaction> T getTransaction(TransactionType<T> argTransType) {
/* 119 */     IPosTransaction transaction = getValue(TransactionScope.CURRENT_TRANSACTION);
/*     */ 
/*     */     
/* 122 */     if (transaction != null && argTransType.getInterfaceClass().isAssignableFrom(transaction.getClass())) {
/* 123 */       return (T)argTransType.getInterfaceClass().cast(transaction);
/*     */     }
/*     */     
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerEventListener(IEventSource argOcpDescriptor) {
/* 132 */     this._eventManager.registerEventHandler((IEventAware)this._clearScopeHandler, argOcpDescriptor, 
/* 133 */         OpChainEventHelper.getTransTerminatedConstraint());
/* 134 */     this._eventManager.registerEventHandler((IEventAware)this._modifiedTransactionHandler, argOcpDescriptor, 
/* 135 */         OpChainEventHelper.getTransModifiedConstraint());
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> void setValue(ValueKey<T> argValueKey, T argValue) {
/* 140 */     if (argValue == null) {
/* 141 */       throw new IllegalArgumentException("A null value cannot be set in transaction scope. You should rely on the scope's inherent purging mechanism to clear values at the appropriate time.");
/*     */     }
/*     */     
/* 144 */     if (TransactionScope.CURRENT_TRANSACTION == argValueKey) {
/* 145 */       IPosTransaction trans = TransactionScope.CURRENT_TRANSACTION.getValueClass().cast(argValue);
/* 146 */       ThreadContext.put("trans", (trans == null) ? null : String.valueOf(trans.getTransactionSequence()));
/*     */     } 
/*     */     
/* 149 */     super.setValue(argValueKey, argValue);
/* 150 */     (new DefaultEventor(getEventSource())).post(argValueKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getScopeName() {
/* 156 */     return "TransactionScope";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\XstoreTransactionScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */