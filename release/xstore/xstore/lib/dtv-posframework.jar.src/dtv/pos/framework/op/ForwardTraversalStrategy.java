/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.pos.framework.OpChainPayload;
/*     */ import dtv.pos.iframework.IBusyState;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.CancelOpException;
/*     */ import dtv.pos.iframework.op.IOpChain;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.IOperationImpl;
/*     */ import dtv.pos.iframework.op.ITraversableChain;
/*     */ import dtv.pos.iframework.op.OpApplicability;
/*     */ import dtv.pos.iframework.op.TraversalStrategyType;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*     */ import dtv.util.IPooledObject;
/*     */ import java.util.Collection;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ForwardTraversalStrategy
/*     */   extends AbstractTraversalStrategy
/*     */ {
/*  33 */   private static final Logger logger_ = Logger.getLogger(ForwardTraversalStrategy.class);
/*  34 */   private static final Logger adminLogger_ = Logger.getLogger("dtv.xstore.helpdesk");
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IBusyState _busyState;
/*     */ 
/*     */   
/*     */   public ForwardTraversalStrategy() {
/*  46 */     super(TraversalStrategyType.FORWARD);
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
/*     */   public IOpResponse handleExec(ITraversableChain argChain, IOperation argOp, IXstEvent argEvent) throws CancelOpException {
/*  62 */     if (logger_.isDebugEnabled()) {
/*  63 */       logger_.debug("internal do op for operation " + argOp + " and event " + argEvent);
/*     */     }
/*  65 */     IOpResponse resp = null;
/*     */ 
/*     */     
/*  68 */     boolean runOperation = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  74 */       if (argOp.getOpState() == null && argOp instanceof IOperationImpl) {
/*  75 */         ((IOperationImpl)argOp).setApplicabilityState(OpApplicability.UNKNOWN);
/*     */       }
/*  77 */       runOperation = Operation.checkApplicable(argOp);
/*     */     }
/*  79 */     catch (Exception ex) {
/*  80 */       logger_.error("CAUGHT EXCEPTION: " + ex);
/*     */     } 
/*     */     
/*  83 */     if ((!(argOp instanceof IOpChain) || argChain.getCurrentOp() == null) && argOp.getOpState() == null) {
/*  84 */       this._flowLogger.info(argOp, getTraversalStrategyType(), runOperation);
/*     */     }
/*  86 */     else if (argOp.getOpState() != null) {
/*  87 */       this._flowLogger.debug(argOp, getTraversalStrategyType(), runOperation);
/*     */     } 
/*     */     
/*  90 */     if (runOperation) {
/*  91 */       if (argOp.getOpState() == null) {
/*     */         
/*  93 */         IUIContextDescriptor opContext = argChain.getContextDescriptor();
/*  94 */         IUIController uiCon = ((IModeController)this._modeProvider.get()).getUiController();
/*     */         
/*  96 */         if (opContext != null) {
/*  97 */           uiCon.handleContextTransition(opContext, null);
/*     */         }
/*     */         
/* 100 */         if (argOp.isLongRunning()) {
/* 101 */           this._busyState.start(argOp.getLongRunningMessage());
/*     */         }
/*     */       } 
/*     */       
/*     */       try {
/* 106 */         if (argOp instanceof IOpChain) {
/* 107 */           ((IOpChain)argOp).setProcessor(getOpChainProcessor());
/*     */         }
/* 109 */         resp = argOp.handleOpExec(argEvent);
/*     */       }
/* 111 */       catch (Exception ex) {
/* 112 */         logger_.error("Exception caught during op exec for " + argOp + ", event=" + argEvent + "]", ex);
/*     */         
/* 114 */         adminLogger_.error("Exception caught during op exec for " + argOp + ", event=" + argEvent + "]", ex);
/*     */         
/* 116 */         ((IModeController)this._modeProvider.get()).notifyErrorListeners(ex);
/*     */       } finally {
/*     */         
/* 119 */         if (argOp instanceof IPooledObject) {
/* 120 */           ((IPooledObject)argOp).release();
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 125 */       resp = this._opResponseHelper.completeResponse();
/*     */     } 
/*     */     
/* 128 */     if (resp == null) {
/* 129 */       resp = this._opResponseHelper.errorNotifyResponse();
/*     */     }
/*     */     
/* 132 */     return resp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleNoNextOp(ITraversableChain argChain) {
/* 143 */     argChain.setComplete(true);
/* 144 */     this._flowLogger.decrementProcessDepth();
/*     */     
/* 146 */     return this._opResponseHelper.completeResponse();
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
/*     */   public void handleOpCompleted(ITraversableChain argChain, IOperation argOp) {
/* 158 */     argOp.setComplete(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     if (argChain.isComplete()) {
/* 165 */       postChainComplete((IOpChain)argChain);
/*     */     }
/*     */ 
/*     */     
/* 169 */     if (argOp.isComplete()) {
/*     */       
/* 171 */       argChain.revertOpState(argOp);
/*     */ 
/*     */       
/* 174 */       if (argChain.hasOpOnList(argOp)) {
/* 175 */         argChain.addAsCompleted(argOp);
/*     */       } else {
/*     */         
/* 178 */         logger_.debug("Current Op Not On OpList: " + argOp);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 183 */       if (argOp.isCancelable()) {
/*     */         
/* 185 */         if (Operation.checkApplicable(argOp)) {
/* 186 */           argChain.addToReversalStack(argOp);
/*     */         }
/*     */       } else {
/*     */         
/* 190 */         if (!(argOp instanceof IOpChain)) {
/* 191 */           this._flowLogger.info("--- NOT CANCELABLE ---");
/*     */         }
/* 193 */         argChain.setCancelable(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChainComplete(ITraversableChain argChain) {
/* 200 */     IOperation op = argChain.getCurrentOp();
/* 201 */     boolean currentOpDone = (op == null || op.isComplete());
/* 202 */     if (!currentOpDone) {
/* 203 */       return false;
/*     */     }
/* 205 */     return (argChain.isOpStackEmpty() && argChain.isOpQueueEmpty());
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
/*     */   public void setNextOp(ITraversableChain argChain) {
/* 217 */     IOperation currentOp = argChain.getCurrentOp();
/* 218 */     boolean chainStart = false;
/*     */     
/* 220 */     if (currentOp == null || currentOp.isComplete()) {
/*     */ 
/*     */       
/* 223 */       chainStart = (argChain.getCurrentOp() == null);
/*     */       
/* 225 */       if (chainStart) {
/* 226 */         IUIContextDescriptor chainContext = null;
/*     */ 
/*     */         
/* 229 */         chainContext = argChain.getContextDescriptor();
/*     */         
/* 231 */         if (chainContext != null) {
/* 232 */           ((IModeController)this._modeProvider.get()).getUiController().handleContextTransition(chainContext, null);
/*     */         }
/*     */         
/* 235 */         this._flowLogger.info((IOperation)argChain, getTraversalStrategyType(), true);
/* 236 */         this._flowLogger.incrementProcessDepth();
/*     */ 
/*     */ 
/*     */         
/* 240 */         getOpChainProcessor().postEvent(IOpChain.OP_CHAIN_STARTED, new OpChainPayload((IOpChain)argChain));
/*     */       } 
/*     */       
/* 243 */       IOperation newCurrentOp = null;
/*     */ 
/*     */ 
/*     */       
/* 247 */       if (!argChain.isOpStackEmpty()) {
/* 248 */         newCurrentOp = argChain.popFromOpStack();
/*     */ 
/*     */       
/*     */       }
/* 252 */       else if (!argChain.isOpQueueEmpty()) {
/* 253 */         newCurrentOp = argChain.popFromOpQueue();
/*     */       } 
/*     */       
/* 256 */       argChain.setCurrentOp(newCurrentOp);
/*     */       
/* 258 */       if (chainStart && newCurrentOp != null && argChain.isDefault() && 
/* 259 */         getOpChainProcessor() != null) {
/* 260 */         getOpChainProcessor().setDefaultChain(argChain.getChainKey(), argChain.getRollbackLevel());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void postChainComplete(IOpChain argOpChain) {
/* 269 */     super.postChainComplete(argOpChain);
/*     */     
/* 271 */     Collection<String> signals_ = argOpChain.getSignals();
/*     */     
/* 273 */     if (signals_ != null) {
/* 274 */       for (String str : signals_) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 279 */         this._flowLogger.info("Signal", str, null, null, " [" + argOpChain.getChainKey() + "]");
/* 280 */         getOpChainProcessor().postEvent(IOpChain.OP_CHAIN_COMPLETE, str);
/*     */       } 
/*     */     }
/*     */     
/* 284 */     getOpChainProcessor().postEvent(IOpChain.OP_CHAIN_COMPLETE, new OpChainPayload(argOpChain));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\ForwardTraversalStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */