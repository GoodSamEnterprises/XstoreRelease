/*     */ package dtv.pos.framework.scope;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.Constraints;
/*     */ import dtv.event.constraint.PayloadClassConstraint;
/*     */ import dtv.pos.framework.IHasFlowEventListener;
/*     */ import dtv.pos.framework.OpChainEventHelper;
/*     */ import dtv.pos.framework.OpChainPayload;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class OpChainBasedScope
/*     */   extends AbstractScope
/*     */   implements OperationDefaultScope, IHasFlowEventListener
/*     */ {
/*  40 */   private static final Logger _logger = Logger.getLogger(OpChainBasedScope.class);
/*     */   
/*  42 */   private static final IEventConstraint _payloadConstraint = (IEventConstraint)new PayloadClassConstraint(OpChainPayload.class);
/*     */ 
/*     */ 
/*     */   
/*  46 */   private static final IEventConstraint _chainStartedConstraint = Constraints.and(new IEventConstraint[] { OpChainEventHelper._chainStartedConstraint, _payloadConstraint });
/*     */ 
/*     */ 
/*     */   
/*  50 */   private static final IEventConstraint _chainCompleteConstraint = Constraints.and(new IEventConstraint[] { OpChainEventHelper._chainCompleteConstraint, _payloadConstraint });
/*     */ 
/*     */   
/*     */   private ScopeInfo _currentScope;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */ 
/*     */   
/*  60 */   private Map<Integer, Set<ValueKey<?>>> _rollbackLevelMap = new HashMap<>();
/*     */   
/*  62 */   private EventHandler _chainStartedHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent) {
/*  65 */         if (argEvent.getPayload() != null) {
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
/*  79 */           OpChainPayload chainStarting = (OpChainPayload)argEvent.getPayload();
/*  80 */           OpChainBasedScope._logger.debug("DefaultScope: Chain started event handled with payload [" + chainStarting + "].");
/*     */           
/*  82 */           if (chainStarting.isDefaultChain()) {
/*  83 */             OpChainBasedScope.this._currentScope = new ScopeInfo(chainStarting.getChainKey(), chainStarting.getRollbackLevel());
/*     */             
/*  85 */             for (Iterator<Integer> keyIter = OpChainBasedScope.this._rollbackLevelMap.keySet().iterator(); keyIter.hasNext(); ) {
/*  86 */               Integer valuesRollbackLevel = keyIter.next();
/*     */               
/*  88 */               if (valuesRollbackLevel.intValue() >= chainStarting.getRollbackLevel()) {
/*  89 */                 for (ValueKey<?> keyToRemove : (Iterable<ValueKey<?>>)OpChainBasedScope.this._rollbackLevelMap.get(valuesRollbackLevel)) {
/*  90 */                   OpChainBasedScope.this.getStorage().remove(keyToRemove);
/*     */                 }
/*     */                 
/*  93 */                 keyIter.remove();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
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
/* 109 */   private EventHandler _chainCompleteHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent) {
/* 112 */         if (argEvent.getPayload() != null) {
/*     */ 
/*     */           
/* 115 */           OpChainPayload payload = (OpChainPayload)argEvent.getPayload();
/* 116 */           OpChainBasedScope._logger.debug("DefaultScope: Chain complete event handled with payload [" + payload + "].");
/*     */         } 
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
/*     */   public <T> void clearValue(ValueKey<T> argValueKey) {
/* 140 */     getStorage().remove(argValueKey);
/* 141 */     this._flowLogger.debug(getScopeName(), argValueKey.getName(), null, "-", null);
/*     */     
/* 143 */     if (_logger.isTraceEnabled()) {
/* 144 */       _logger.trace(new Throwable("Stack trace for " + argValueKey));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerEventListener(IEventSource argOcpDescriptor) {
/* 150 */     this._eventManager.registerEventHandler((IEventAware)this._chainStartedHandler, argOcpDescriptor, _chainStartedConstraint);
/* 151 */     this._eventManager.registerEventHandler((IEventAware)this._chainCompleteHandler, argOcpDescriptor, _chainCompleteConstraint);
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
/*     */   public <T> void setValue(ValueKey<T> argValueKey, T argValue) {
/* 165 */     Set<ValueKey<?>> valueKeys = this._rollbackLevelMap.get(Integer.valueOf(this._currentScope.getPriority()));
/*     */     
/* 167 */     if (valueKeys == null) {
/* 168 */       valueKeys = new HashSet<>();
/* 169 */       this._rollbackLevelMap.put(Integer.valueOf(this._currentScope.getPriority()), valueKeys);
/*     */     } 
/*     */     
/* 172 */     valueKeys.add(argValueKey);
/* 173 */     super.setValue(argValueKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getAdditionalLogInfo() {
/* 179 */     return " [Level: " + this._currentScope.getPriority() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getScopeName() {
/* 185 */     return "DefaultScope";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\OpChainBasedScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */