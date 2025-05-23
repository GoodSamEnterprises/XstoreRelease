/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.CancelOpException;
/*     */ import dtv.pos.iframework.op.IOpChain;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.IReversibleOp;
/*     */ import dtv.pos.iframework.op.ITraversableChain;
/*     */ import dtv.pos.iframework.op.TraversalStrategyType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReverseTraversalStrategy
/*     */   extends AbstractTraversalStrategy
/*     */ {
/*     */   public ReverseTraversalStrategy() {
/*  22 */     super(TraversalStrategyType.REVERSE);
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
/*  38 */     if (!argOp.isComplete()) {
/*  39 */       argChain.requeue(argOp);
/*     */     }
/*     */     
/*  42 */     if (argOp instanceof IReversibleOp) {
/*  43 */       IReversibleOp op = (IReversibleOp)argOp;
/*  44 */       boolean runOperation = Operation.checkApplicableToReverse((IOperation)op);
/*     */       
/*  46 */       this._flowLogger.info(argOp, getTraversalStrategyType(), runOperation);
/*     */       
/*  48 */       if (runOperation) {
/*  49 */         return op.handleOpReverse(argEvent);
/*     */       }
/*     */     } 
/*     */     
/*  53 */     return this._opResponseHelper.completeResponse();
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
/*  64 */     this._flowLogger.decrementProcessDepth();
/*  65 */     argChain.setComplete(true);
/*  66 */     return this._opResponseHelper.completeResponse();
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
/*     */   public void handleOpCompleted(ITraversableChain argChain, IOperation argOp) {
/*  80 */     argChain.revertOpState(argOp);
/*  81 */     argChain.setCurrentOp(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     if (argChain.isComplete()) {
/*  88 */       postChainComplete((IOpChain)argChain);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChainComplete(ITraversableChain argChain) {
/*  94 */     IOperation op = argChain.getCurrentOp();
/*  95 */     boolean currentOpDone = (op == null || op.isComplete());
/*     */     
/*  97 */     if (!currentOpDone) {
/*  98 */       return false;
/*     */     }
/* 100 */     return argChain.isReversalStackEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNextOp(ITraversableChain argChain) {
/* 111 */     if (argChain.getCurrentOp() == null) {
/* 112 */       if (!argChain.isOpStackEmpty()) {
/* 113 */         IOperation newCurrentOp = argChain.popFromOpStack();
/*     */         
/* 115 */         newCurrentOp.setComplete(false);
/* 116 */         argChain.setCurrentOp(newCurrentOp);
/*     */         
/*     */         return;
/*     */       } 
/* 120 */       if (argChain.isCancelable()) {
/* 121 */         if (!argChain.isReversalStackEmpty()) {
/* 122 */           IOperation newCurrentOp = argChain.popFromReversalStack();
/*     */           
/* 124 */           argChain.setCurrentOp(newCurrentOp);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } else {
/* 134 */         _logger.error("Unexpected situation where chain is not cancelable. Wiping out the reversal stack");
/* 135 */         while (!argChain.isReversalStackEmpty()) {
/* 136 */           argChain.popFromReversalStack();
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 141 */       this._flowLogger.decrementProcessDepth();
/* 142 */       argChain.setCurrentOp(null);
/*     */ 
/*     */     
/*     */     }
/* 146 */     else if (!argChain.getCurrentOp().isComplete() && !(argChain.getCurrentOp() instanceof IReversibleOp)) {
/* 147 */       argChain.requeue(argChain.getCurrentOp());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\ReverseTraversalStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */