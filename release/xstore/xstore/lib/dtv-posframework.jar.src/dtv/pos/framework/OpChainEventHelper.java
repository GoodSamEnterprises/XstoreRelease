/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.constraint.Constraints;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.event.constraint.PayloadConstraint;
/*     */ import dtv.pos.iframework.op.IOpChain;
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
/*     */ public class OpChainEventHelper
/*     */ {
/*  21 */   public static final IEventConstraint _chainCompleteConstraint = (IEventConstraint)new NameConstraint(IOpChain.OP_CHAIN_COMPLETE);
/*  22 */   public static final IEventConstraint _chainStartedConstraint = (IEventConstraint)new NameConstraint(IOpChain.OP_CHAIN_STARTED);
/*  23 */   public static final IEventConstraint _transCompleteSignal = (IEventConstraint)new PayloadConstraint("TransactionComplete");
/*  24 */   public static final IEventConstraint _transModifiedSignal = (IEventConstraint)new PayloadConstraint("TransactionModified");
/*  25 */   public static final IEventConstraint _transCancelledSignal = (IEventConstraint)new PayloadConstraint("TransactionCancelled");
/*  26 */   public static final IEventConstraint _transResumeSignal = (IEventConstraint)new PayloadConstraint("TransactionResumed");
/*  27 */   public static final IEventConstraint _invOpsCompleteSignal = (IEventConstraint)new PayloadConstraint("InventoryOperationsComplete");
/*     */   
/*  29 */   public static final IEventConstraint _invOpsCancelledSignal = (IEventConstraint)new PayloadConstraint("InventoryOperationsCancelled");
/*     */ 
/*     */ 
/*     */   
/*  33 */   private static final IEventConstraint _transCompleteConstraint = Constraints.and(new IEventConstraint[] { _chainCompleteConstraint, _transCompleteSignal });
/*     */   
/*  35 */   private static final IEventConstraint _transModifiedConstraint = Constraints.and(new IEventConstraint[] { _chainCompleteConstraint, _transModifiedSignal });
/*     */   
/*  37 */   private static final IEventConstraint _transCancelledConstraint = Constraints.and(new IEventConstraint[] { _chainCompleteConstraint, _transCancelledSignal });
/*     */   
/*  39 */   private static final IEventConstraint _transResumedConstraint = Constraints.and(new IEventConstraint[] { _chainCompleteConstraint, _transResumeSignal });
/*     */ 
/*     */   
/*  42 */   private static final IEventConstraint _transTerminatedConstraint = Constraints.and(new IEventConstraint[] {
/*  43 */         _chainCompleteConstraint, Constraints.or(new IEventConstraint[] { _transCompleteSignal, _transCancelledSignal })
/*     */       });
/*  45 */   private static final IEventConstraint _transAffectedConstraint = Constraints.and(new IEventConstraint[] {
/*  46 */         _chainCompleteConstraint, Constraints.or(new IEventConstraint[] { _transCompleteSignal, _transCancelledSignal, _transModifiedSignal })
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getChainCompleteConstraint() {
/*  53 */     return _chainCompleteConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransAffectedConstraint() {
/*  61 */     return _transAffectedConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransCancelledConstraint() {
/*  69 */     return _transCancelledConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransCompleteConstraint() {
/*  77 */     return _transCompleteConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransModifiedConstraint() {
/*  85 */     return _transModifiedConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransTerminatedConstraint() {
/*  96 */     return _transTerminatedConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEventConstraint getTransResumedConstraint() {
/* 105 */     return _transResumedConstraint;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\OpChainEventHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */