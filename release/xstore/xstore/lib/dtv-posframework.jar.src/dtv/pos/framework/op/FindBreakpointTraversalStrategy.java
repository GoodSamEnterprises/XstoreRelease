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
/*     */ 
/*     */ 
/*     */ public class FindBreakpointTraversalStrategy
/*     */   extends AbstractTraversalStrategy
/*     */ {
/*     */   private boolean anyPass_ = false;
/*     */   
/*     */   public FindBreakpointTraversalStrategy() {
/*  26 */     super(TraversalStrategyType.FIND_BREAKPOINT);
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
/*  42 */     this.anyPass_ = true;
/*     */ 
/*     */     
/*  45 */     if (!argOp.isCancelable()) {
/*  46 */       throw new CancelOpException("Unable to backup through non-cancellable operation: " + argOp);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  51 */     IOperation[] completedOps = argChain.getCompletedOps();
/*  52 */     for (IOperation op : completedOps) {
/*  53 */       if (!op.isCancelable()) {
/*  54 */         throw new CancelOpException("Unable to backup through non-cancellable operation: " + op);
/*     */       }
/*     */       
/*  57 */       if (op.hasBreakPoint()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  63 */     if (argOp.hasBreakPoint()) {
/*  64 */       this._flowLogger.info(argOp, getTraversalStrategyType(), true);
/*  65 */       IOpResponse response = argOp.handleBreakPointReversal(argEvent);
/*  66 */       return response;
/*     */     } 
/*  68 */     if (Operation.checkApplicableToReverse(argOp)) {
/*  69 */       this._flowLogger.info(argOp, getTraversalStrategyType(), true);
/*  70 */       return ((IReversibleOp)argOp).handleOpReverse(argEvent);
/*     */     } 
/*     */     
/*  73 */     return this._opResponseHelper.completeResponse();
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
/*     */   public IOpResponse handleNoNextOp(ITraversableChain argChain) {
/*  87 */     this._flowLogger.decrementProcessDepth();
/*  88 */     this.anyPass_ = true;
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (argChain != null) {
/*  93 */       argChain.setOpState(null);
/*     */     }
/*     */     
/*  96 */     return this._opResponseHelper.completeResponse();
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
/*     */   
/*     */   public void handleOpCompleted(ITraversableChain argChain, IOperation argOp) {
/* 113 */     if (argChain.isComplete()) {
/* 114 */       postChainComplete((IOpChain)argChain);
/*     */     }
/*     */ 
/*     */     
/* 118 */     argChain.revertOpState(argOp);
/* 119 */     if (!argOp.hasBreakPoint() && argOp.isComplete()) {
/* 120 */       argChain.requeue(argOp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 127 */     this.anyPass_ = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChainComplete(ITraversableChain argChain) {
/* 132 */     if (!this.anyPass_) {
/* 133 */       return false;
/*     */     }
/* 135 */     IOperation op = argChain.getCurrentOp();
/* 136 */     if (op instanceof IOpChain && 
/* 137 */       !isChainComplete((ITraversableChain)op)) {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     if (!argChain.isOpStackEmpty()) {
/* 142 */       return false;
/*     */     }
/* 144 */     return argChain.isCompletedStackEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNextOp(ITraversableChain argChain) {
/* 154 */     IOperation currentOp = argChain.getCurrentOp();
/* 155 */     if (currentOp != null) {
/*     */ 
/*     */       
/* 158 */       if (currentOp instanceof IOpChain) {
/*     */         return;
/*     */       }
/*     */       
/* 162 */       if (!currentOp.isComplete()) {
/*     */ 
/*     */         
/* 165 */         argChain.revertOpState(currentOp);
/* 166 */         argChain.requeue(currentOp);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 171 */         currentOp.setComplete(false);
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     if (!argChain.isOpStackEmpty()) {
/*     */       
/* 177 */       IOperation op = argChain.popFromOpStack();
/*     */       
/* 179 */       if (op instanceof IOpChain) {
/* 180 */         op.setComplete(false);
/*     */       }
/*     */       
/* 183 */       argChain.setCurrentOp(op);
/*     */     }
/* 185 */     else if (!argChain.isCompletedStackEmpty()) {
/*     */       
/* 187 */       IOperation op = argChain.popFromCompletedStack();
/*     */       
/* 189 */       if (op instanceof IOpChain) {
/* 190 */         op.setComplete(false);
/*     */       }
/*     */       
/* 193 */       argChain.setCurrentOp(op);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\FindBreakpointTraversalStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */