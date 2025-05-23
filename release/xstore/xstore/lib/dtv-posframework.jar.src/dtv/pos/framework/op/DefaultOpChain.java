/*     */ package dtv.pos.framework.op;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventObserver;
/*     */ import dtv.pos.iframework.event.IXstEventType;
/*     */ import dtv.pos.iframework.op.CancelOpException;
/*     */ import dtv.pos.iframework.op.IDebuggable;
/*     */ import dtv.pos.iframework.op.IOpChain;
/*     */ import dtv.pos.iframework.op.IOpChainFactory;
/*     */ import dtv.pos.iframework.op.IOpChainProcessor;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.IReversibleOp;
/*     */ import dtv.pos.iframework.op.ITraversalStrategy;
/*     */ import dtv.pos.iframework.op.OpStatus;
/*     */ import dtv.pos.iframework.op.TraversalStrategyType;
/*     */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DefaultOpChain implements IOpChain, ITraversableChain, IDebuggable {
/*  29 */   private static final Logger _logger = Logger.getLogger(DefaultOpChain.class);
/*     */   
/*  31 */   private static final Logger _adminLogger = Logger.getLogger("dtv.xstore.helpdesk"); protected IOperation _currentOp; protected OpChainKey _chainKey;
/*     */   
/*     */   private static boolean hasBreakPoint(IOperation[] argOps) {
/*  34 */     for (IOperation op : argOps) {
/*  35 */       if (op.hasBreakPoint()) {
/*  36 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected OpChainKey _rollbackChainKey;
/*     */   
/*     */   protected IOpChainProcessor _processor;
/*     */   protected List<IOperation> _opList;
/*     */   protected LinkedList<IOperation> _opQueue;
/*     */   protected Stack<IOperation> _opStack;
/*     */   protected Stack<IOperation> _reversalStack;
/*     */   protected Stack<IOperation> _completedStack;
/*     */   protected IUIContextDescriptor _contextDescriptor;
/*  53 */   protected int _rollbackLevel = -1;
/*     */   
/*     */   protected boolean _breakpoint;
/*     */   
/*     */   protected boolean _cancelable;
/*     */   
/*     */   protected boolean _default;
/*     */   
/*     */   protected boolean _required;
/*     */   
/*     */   private final ITraversalStrategy _normalStrategy;
/*     */   
/*     */   private final ITraversalStrategy _reverseStrategy;
/*     */   
/*     */   private final ITraversalStrategy _findBreakpointStrategy;
/*     */   private ITraversalStrategy _currentStrategy;
/*     */   private List<String> _signalList;
/*     */   private String _sourceDescription;
/*     */   private IOpState _opState;
/*     */   @Inject
/*     */   private IOpChainFactory _opChainFactory;
/*     */   @Inject
/*     */   private ProcessLogger _flowLogger;
/*     */   @Inject
/*     */   private OpResponseHelper _opResponseHelper;
/*     */   
/*     */   @ConstructorProperties({"forward", "reverse", "breakpoint"})
/*     */   public DefaultOpChain(ITraversalStrategy argForward, ITraversalStrategy argReverse, ITraversalStrategy argBreakpoint) {
/*  81 */     this._cancelable = true;
/*  82 */     this._required = true;
/*     */     
/*  84 */     this._opList = new ArrayList<>();
/*  85 */     this._opStack = new Stack<>();
/*  86 */     this._opQueue = new LinkedList<>();
/*  87 */     this._reversalStack = new Stack<>();
/*  88 */     this._completedStack = new Stack<>();
/*     */     
/*  90 */     this._normalStrategy = argForward;
/*  91 */     this._reverseStrategy = argReverse;
/*  92 */     this._findBreakpointStrategy = argBreakpoint;
/*     */     
/*  94 */     this._currentStrategy = this._normalStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAsCompleted(IOperation argOp) {
/*  99 */     if (this._completedStack.contains(argOp)) {
/* 100 */       _logger.debug("Completed stack already contains " + argOp);
/*     */     }
/* 102 */     this._completedStack.push(argOp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOp(IOperation argOp) {
/* 108 */     this._opList.add(argOp);
/* 109 */     queueOp(argOp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToQueueFront(IOperation argOp) {
/* 114 */     this._opQueue.addFirst(argOp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToReversalStack(IOperation argOp) {
/* 119 */     if (argOp instanceof IReversibleOp) {
/* 120 */       this._reversalStack.push(argOp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canceling() {
/* 127 */     if (this._currentOp == null) {
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     return this._currentOp.canceling();
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 144 */     throw new CloneNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dumpDebugInfo(int argLevel, StringBuilder sb) {
/* 150 */     int level = argLevel;
/* 151 */     String padding = makePadding(level);
/* 152 */     sb.append(padding);
/* 153 */     sb.append("chain:");
/* 154 */     sb.append(this._chainKey);
/* 155 */     sb.append(":");
/* 156 */     sb.append(this._currentStrategy.getTraversalStrategyType());
/* 157 */     sb.append("[");
/* 158 */     sb.append(Integer.toHexString(super.hashCode()));
/* 159 */     sb.append("]::<tt>");
/* 160 */     sb.append(getSourceDescription());
/* 161 */     sb.append("</tt>\n");
/*     */     
/* 163 */     padding = makePadding(++level);
/* 164 */     if (this._rollbackLevel > -1) {
/* 165 */       sb.append(padding + "rollback level:" + this._rollbackLevel + "\n");
/*     */     }
/* 167 */     if (this._contextDescriptor != null) {
/* 168 */       sb.append(padding + "context:" + this._contextDescriptor + "\n");
/*     */     }
/* 170 */     if (this._rollbackChainKey != null) {
/* 171 */       sb.append(padding + "rollback chain:" + this._rollbackChainKey + "\n");
/*     */     }
/* 173 */     sb.append(padding + "current op:");
/* 174 */     if (this._currentOp instanceof IDebuggable) {
/* 175 */       sb.append("\n");
/* 176 */       ((IDebuggable)this._currentOp).dumpDebugInfo(level + 1, sb);
/*     */     } else {
/*     */       
/* 179 */       sb.append(this._currentOp + "\n");
/*     */     } 
/*     */     
/* 182 */     sb.append(padding + "stack:\n");
/* 183 */     for (IOperation item : this._opStack) {
/* 184 */       if (item instanceof IDebuggable) {
/* 185 */         ((IDebuggable)item).dumpDebugInfo(level + 1, sb);
/*     */         continue;
/*     */       } 
/* 188 */       sb.append(padding + "  " + item + "\n");
/*     */     } 
/*     */ 
/*     */     
/* 192 */     sb.append(padding + "queue:\n");
/* 193 */     if (!this._opQueue.isEmpty()) {
/* 194 */       LinkedList<IOperation> q = new LinkedList<>(this._opQueue);
/* 195 */       for (IOperation item : q) {
/* 196 */         if (item instanceof IDebuggable) {
/* 197 */           ((IDebuggable)item).dumpDebugInfo(level + 1, sb);
/*     */           continue;
/*     */         } 
/* 200 */         sb.append(padding + "  " + item + "\n");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 205 */     sb.append(padding + "completed stack:\n");
/* 206 */     for (IOperation item : this._completedStack) {
/* 207 */       if (item instanceof IDebuggable) {
/* 208 */         ((IDebuggable)item).dumpDebugInfo(level + 1, sb);
/*     */         continue;
/*     */       } 
/* 211 */       sb.append(padding + "  " + item + "\n");
/*     */     } 
/*     */ 
/*     */     
/* 215 */     sb.append(padding + "reversal stack:\n");
/* 216 */     for (IOperation item : this._reversalStack) {
/* 217 */       if (item instanceof IDebuggable) {
/* 218 */         ((IDebuggable)item).dumpDebugInfo(level + 1, sb);
/*     */         continue;
/*     */       } 
/* 221 */       sb.append(padding + "  " + item.toString() + "\n");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/* 230 */     if (argObject instanceof IOpChain) {
/* 231 */       return ((IOpChain)argObject).getChainKey().equals(getChainKey());
/*     */     }
/* 233 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpChainKey getChainKey() {
/* 239 */     return this._chainKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation[] getCompletedOps() {
/* 244 */     return (IOperation[])this._completedStack.toArray((Object[])new IOperation[this._completedStack.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IUIContextDescriptor getContextDescriptor() {
/* 250 */     if (this._currentOp != null) {
/* 251 */       return (this._currentOp instanceof IOpChain) ? null : this._currentOp.getContextDescriptor();
/*     */     }
/* 253 */     return this._contextDescriptor;
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation getCurrentOp() {
/* 258 */     return this._currentOp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLogId() {
/* 264 */     return (getChainKey() != null) ? getChainKey().toString() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLongRunningMessage() {
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?>[] getObservedEventInterfaces() {
/* 276 */     if (this._currentOp != null && 
/* 277 */       this._currentOp instanceof IXstEventObserver) {
/* 278 */       return ((IXstEventObserver)this._currentOp).getObservedEventInterfaces();
/*     */     }
/*     */     
/* 281 */     return new Class[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstEventType[] getObservedEvents() {
/* 287 */     if (this._currentOp != null && 
/* 288 */       this._currentOp instanceof IXstEventObserver) {
/* 289 */       return ((IXstEventObserver)this._currentOp).getObservedEvents();
/*     */     }
/*     */     
/* 292 */     return new IXstEventType[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOpCount() {
/* 298 */     return this._opList.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpState getOpState() {
/* 304 */     return this._opState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOpType() {
/* 310 */     return "CHAIN";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpChainKey getRollbackChainKey() {
/* 316 */     if (this._currentOp instanceof IOpChain) {
/* 317 */       IOpChain subChain = (IOpChain)this._currentOp;
/* 318 */       if (subChain.getChainKey() != null && subChain.getChainKey().equals(this._rollbackChainKey))
/*     */       {
/* 320 */         return this._chainKey;
/*     */       }
/*     */     } 
/* 323 */     return this._rollbackChainKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRollbackLevel() {
/* 329 */     return this._rollbackLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<String> getSignals() {
/* 335 */     return this._signalList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getSourceDescription() {
/* 341 */     return this._sourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TraversalStrategyType getTraversalStrategyType() {
/* 347 */     return this._currentStrategy.getTraversalStrategyType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleBreakPointReversal(IXstEvent argEvent) throws CancelOpException {
/* 356 */     if (this._currentStrategy == this._reverseStrategy) {
/* 357 */       throw new CancelOpException("this chain [" + toString() + "] is currently running in reverse");
/*     */     }
/*     */     
/* 360 */     if (this._currentStrategy.getTraversalStrategyType() != TraversalStrategyType.FIND_BREAKPOINT) {
/* 361 */       if (!(this._currentOp instanceof IOpChain)) {
/* 362 */         requeue(this._currentOp);
/*     */       }
/* 364 */       setTraversalStrategyType(TraversalStrategyType.FIND_BREAKPOINT);
/*     */     } 
/*     */     
/* 367 */     IOpResponse response = handleOpExec(argEvent);
/* 368 */     if (this._currentOp != null && OpStatus.COMPLETE.equals(response.getOpStatus())) {
/* 369 */       response = response.derive(OpStatus.BREAKPOINT_FOUND);
/*     */     }
/* 371 */     return response;
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
/*     */   public IOpResponse handleChainReverse() {
/* 383 */     if (_logger.isDebugEnabled()) {
/* 384 */       _logger.debug("Handling chain cancel ");
/*     */     }
/*     */     
/* 387 */     if (this._currentStrategy != this._normalStrategy) {
/* 388 */       _logger.debug(this + ": Unexpected chain traversal strategy: " + this._currentStrategy);
/*     */     }
/* 390 */     setTraversalStrategyType(TraversalStrategyType.REVERSE);
/*     */     try {
/* 392 */       this._currentStrategy.setNextOp(this);
/*     */     }
/* 394 */     catch (CancelOpException ex) {
/* 395 */       setTraversalStrategyType(TraversalStrategyType.FORWARD);
/* 396 */       _logger.warn(ex.getMessage());
/* 397 */       stackChain(this._opChainFactory.getCancelDeniedChain());
/*     */     } 
/*     */     
/* 400 */     return handleOpExec(null);
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
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 412 */     if (_logger.isDebugEnabled()) {
/* 413 */       _logger.debug("Handling operation exec " + 
/* 414 */           getChainKey() + " for op " + this._currentOp + " and event " + argEvent);
/*     */     }
/*     */     
/* 417 */     IOpResponse resp = this._opResponseHelper.completeResponse();
/*     */     
/*     */     try {
/* 420 */       this._currentStrategy.setNextOp(this);
/*     */ 
/*     */       
/* 423 */       if (this._currentOp == null) {
/* 424 */         resp = this._currentStrategy.handleNoNextOp(this);
/*     */       } else {
/*     */         
/* 427 */         if (_logger.isDebugEnabled()) {
/* 428 */           _logger.debug("Chain [" + this._chainKey + "] running op [" + this._currentOp + "]");
/*     */         }
/*     */         
/* 431 */         resp = internalDoOp(this._currentOp, argEvent);
/*     */       }
/*     */     
/* 434 */     } catch (CancelOpException ex) {
/* 435 */       setTraversalStrategyType(TraversalStrategyType.FORWARD);
/* 436 */       _logger.warn(ex.getMessage());
/* 437 */       stackChain(this._opChainFactory.getCancelDeniedChain());
/*     */     }
/* 439 */     catch (Exception ex) {
/* 440 */       String msg = "Exception caught during op exec for " + this._currentOp + ", event=" + argEvent + "]";
/* 441 */       _logger.error(msg, ex);
/* 442 */       _adminLogger.error(msg, ex);
/* 443 */       resp = this._opResponseHelper.errorNotifyResponse();
/*     */     }
/* 445 */     catch (StackOverflowError ex) {
/* 446 */       String msg = "Error caught during op exec for " + this._currentOp + ", event=" + argEvent + "]";
/* 447 */       _logger.error(msg, ex);
/* 448 */       _adminLogger.error(msg, ex);
/* 449 */       resp = this._opResponseHelper.errorNotifyResponse();
/*     */     } 
/*     */     
/* 452 */     return resp;
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
/*     */   public IOpResponse handleOpReverse(IXstEvent argEvent) {
/* 467 */     if (_logger.isDebugEnabled()) {
/* 468 */       _logger.debug("Handling operation reverse ");
/*     */     }
/*     */     
/* 471 */     IOpResponse resp = this._opResponseHelper.completeResponse();
/*     */     
/* 473 */     if (isCurrentOpCancelable()) {
/* 474 */       if (this._currentOp != null) {
/* 475 */         boolean canceled = true;
/*     */         
/* 477 */         if (this._currentOp instanceof IReversibleOp) {
/* 478 */           resp = ((IReversibleOp)this._currentOp).handleOpReverse(argEvent);
/* 479 */           canceled = (resp == null) ? false : resp.getOpStatus().equals(OpStatus.COMPLETE);
/*     */         } 
/*     */         
/* 482 */         if (this._currentOp.isRequired() && canceled) {
/* 483 */           resp = handleChainReverse();
/*     */         }
/*     */       } else {
/*     */         
/* 487 */         resp = handleChainReverse();
/*     */       } 
/*     */     }
/*     */     
/* 491 */     return resp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBreakPoint() {
/* 497 */     if (this._breakpoint) {
/* 498 */       return true;
/*     */     }
/*     */     
/* 501 */     if (this._currentOp != null && this._currentOp.hasBreakPoint()) {
/* 502 */       return true;
/*     */     }
/*     */     
/* 505 */     if (hasBreakPoint(getStackedOps())) {
/* 506 */       return true;
/*     */     }
/*     */     
/* 509 */     if (hasBreakPoint(getCompletedOps())) {
/* 510 */       return true;
/*     */     }
/*     */     
/* 513 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 519 */     OpChainKey chainKey = getChainKey();
/* 520 */     return (chainKey == null) ? super.hashCode() : chainKey.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOpOnList(IOperation argOp) {
/* 525 */     return this._opList.contains(argOp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicableToReverse() {
/* 531 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCancelable() {
/* 537 */     return (this._cancelable && isCurrentOpCancelable());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 543 */     return this._currentStrategy.isChainComplete(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCompletedStackEmpty() {
/* 548 */     return this._completedStack.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentOpCancelable() {
/* 554 */     return (this._currentOp == null) ? true : this._currentOp.isCancelable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/* 560 */     return (this._rollbackLevel > -1);
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
/*     */   public boolean isError() {
/* 574 */     if (this._currentOp instanceof IOpChain) {
/* 575 */       return ((IOpChain)this._currentOp).isError();
/*     */     }
/*     */     
/* 578 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isLongRunning() {
/* 584 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOperationApplicable() {
/* 590 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpQueueEmpty() {
/* 595 */     return this._opQueue.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpStackEmpty() {
/* 600 */     return this._opStack.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 606 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReversalStackEmpty() {
/* 611 */     return this._reversalStack.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation popFromCompletedStack() {
/* 616 */     return this._completedStack.pop();
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation popFromOpQueue() {
/* 621 */     return this._opQueue.poll();
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation popFromOpStack() {
/* 626 */     return this._opStack.pop();
/*     */   }
/*     */ 
/*     */   
/*     */   public IOperation popFromReversalStack() {
/* 631 */     return this._reversalStack.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void queueOp(IOperation argOp) {
/* 642 */     if (this._opQueue.contains(argOp)) {
/* 643 */       _logger.debug("*** Queue already contains " + argOp.getClass() + "...adding again", new Throwable("STACK TRACE"));
/*     */     }
/*     */ 
/*     */     
/* 647 */     this._opQueue.add(argOp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void requeue(IOperation argOp) {
/* 652 */     if (argOp == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 657 */     argOp.setComplete(true);
/*     */     
/* 659 */     argOp.setComplete(false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 664 */     if (hasOpOnList(argOp)) {
/* 665 */       if (hasOpInQueue(argOp)) {
/*     */         String name;
/*     */         
/* 668 */         if (argOp instanceof IOpChain) {
/* 669 */           name = "argChain " + ((IOpChain)argOp).getChainKey();
/*     */         } else {
/*     */           
/* 672 */           name = argOp.getClass().getName();
/*     */         } 
/*     */         
/* 675 */         _logger.debug("*** " + name + " is already on the opQueue");
/*     */       } else {
/*     */         
/* 678 */         addToQueueFront(argOp);
/*     */       } 
/*     */     }
/*     */     
/* 682 */     setCurrentOp(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void revertOpState(IOperation argOp) {
/* 687 */     if (argOp.isComplete()) {
/* 688 */       argOp.setOpState(null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBreakPoint(boolean argIsBreakPoint) {
/* 695 */     this._breakpoint = argIsBreakPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelable(boolean cancelable) {
/* 701 */     this._cancelable = cancelable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChainKey(OpChainKey argKey) {
/* 707 */     this._chainKey = argKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComplete(boolean argIsComplete) {
/* 716 */     if (!argIsComplete) {
/* 717 */       setTraversalStrategyType(TraversalStrategyType.FORWARD);
/*     */       
/* 719 */       while (!this._completedStack.isEmpty()) {
/* 720 */         IOperation o = this._completedStack.pop();
/*     */         
/* 722 */         if (hasOpOnList(o)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 729 */           o.setComplete(argIsComplete);
/* 730 */           addToQueueFront(o);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContextDescriptor(IUIContextDescriptor argDescriptor) {
/* 739 */     this._contextDescriptor = argDescriptor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCurrentOp(IOperation newValue) {
/* 744 */     this._currentOp = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLongRunning(boolean argLongRunning) {
/* 750 */     _logger.warn("setLongRunning not supported on a chain");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOpState(IOpState argOpState) {
/* 756 */     this._opState = argOpState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 762 */     _logger.warn("Unexpected parameter for " + getClass().getName() + ":" + argName + "=" + argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProcessor(IOpChainProcessor argProcessor) {
/* 768 */     this._processor = argProcessor;
/*     */     
/* 770 */     if (this._normalStrategy != null) {
/* 771 */       this._normalStrategy.setOpChainProcessor(argProcessor);
/*     */     }
/*     */     
/* 774 */     if (this._reverseStrategy != null) {
/* 775 */       this._reverseStrategy.setOpChainProcessor(argProcessor);
/*     */     }
/*     */     
/* 778 */     if (this._findBreakpointStrategy != null) {
/* 779 */       this._findBreakpointStrategy.setOpChainProcessor(argProcessor);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argReq) {
/* 786 */     this._required = argReq;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRollbackChainKey(OpChainKey argKey) {
/* 792 */     this._rollbackChainKey = argKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRollbackLevel(int level) {
/* 798 */     this._rollbackLevel = level;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignals(Collection<String> argSignals) {
/* 804 */     if (argSignals == null || argSignals.isEmpty()) {
/* 805 */       this._signalList = null;
/*     */     } else {
/*     */       
/* 808 */       this._signalList = new ArrayList<>(argSignals);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSourceDescription(String argSourceDescription) {
/* 815 */     this._sourceDescription = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTraversalStrategyType(TraversalStrategyType argTraversalStrategyType) {
/* 821 */     if (argTraversalStrategyType == this._currentStrategy.getTraversalStrategyType()) {
/*     */       return;
/*     */     }
/*     */     
/* 825 */     if (TraversalStrategyType.REVERSE == argTraversalStrategyType) {
/* 826 */       this._currentStrategy = this._reverseStrategy;
/*     */     }
/* 828 */     else if (TraversalStrategyType.FIND_BREAKPOINT == argTraversalStrategyType) {
/* 829 */       this._currentStrategy = this._findBreakpointStrategy;
/*     */     } else {
/*     */       
/* 832 */       this._currentStrategy = this._normalStrategy;
/*     */     } 
/*     */     
/* 835 */     this._currentStrategy.init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stackChain(IOpChain argChain) {
/* 846 */     if (_logger.isDebugEnabled()) {
/* 847 */       _logger.debug("Stacking chain for execution " + argChain);
/*     */     }
/*     */     
/* 850 */     if (this._currentOp instanceof IOpChain && !this._currentOp.isComplete()) {
/* 851 */       ((IOpChain)this._currentOp).stackChain(argChain);
/*     */     }
/*     */     else {
/*     */       
/* 855 */       if (this._currentOp != null && !this._currentOp.isComplete()) {
/* 856 */         this._opStack.push(this._currentOp);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 861 */       if (argChain.getOpCount() == 0) {
/* 862 */         String prefix = argChain.getTraversalStrategyType().getLogPrefix() + " -";
/* 863 */         this._flowLogger.info(getOpType(), argChain.getChainKey(), null, prefix, " [Has no operations defined]");
/*     */       } 
/*     */       
/* 866 */       setCurrentOp((IOperation)argChain);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 878 */     StringBuffer sb = new StringBuffer();
/* 879 */     OpChainKey key = getChainKey();
/*     */     
/* 881 */     if (key == null) {
/* 882 */       sb.append(getClass().getName());
/*     */     } else {
/*     */       
/* 885 */       sb.append(key);
/*     */     } 
/*     */     
/* 888 */     sb.append(":");
/* 889 */     sb.append(this._currentStrategy.getTraversalStrategyType());
/* 890 */     sb.append(":[");
/* 891 */     sb.append(this._currentOp);
/* 892 */     sb.append("]");
/* 893 */     return sb.toString();
/*     */   }
/*     */   
/*     */   protected boolean hasOpInQueue(IOperation argOp) {
/* 897 */     return this._opQueue.contains(argOp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse internalDoOp(IOperation argOp, IXstEvent argEvent) throws CancelOpException {
/* 903 */     IOpResponse resp = this._currentStrategy.handleExec(this, argOp, argEvent);
/* 904 */     OpStatus status = resp.getOpStatus();
/*     */     
/* 906 */     if (status.isError()) {
/*     */       
/* 908 */       if (argOp instanceof IOpChain)
/*     */       {
/*     */         
/* 911 */         addToReversalStack(this._currentOp);
/*     */       }
/*     */       
/* 914 */       if (!status.getPauseChain() && argOp.isRequired()) {
/* 915 */         setTraversalStrategyType(TraversalStrategyType.REVERSE);
/*     */       }
/*     */     }
/* 918 */     else if (status.isComplete()) {
/* 919 */       this._currentStrategy.handleOpCompleted(this, argOp);
/*     */     }
/* 921 */     else if (OpStatus.CHAIN_COMPLETE.equals(status)) {
/* 922 */       _logger.debug("CHAIN_COMPLETE OpStatus received; clearing the rest of the operations from chain [" + 
/* 923 */           getChainKey() + "]");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 928 */       this._opStack.clear();
/*     */       
/* 930 */       this._opQueue.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 937 */       resp = resp.derive(OpStatus.COMPLETE);
/*     */ 
/*     */       
/* 940 */       this._currentStrategy.handleOpCompleted(this, argOp);
/*     */     }
/* 942 */     else if (status.isBreakpointFound()) {
/* 943 */       setTraversalStrategyType(TraversalStrategyType.FORWARD);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 948 */       if (argOp instanceof IOpChain || argOp.isComplete()) {
/* 949 */         argOp.setOpState(null);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 957 */       if (!(argOp instanceof IOpChain)) {
/* 958 */         argOp.setComplete(false);
/*     */       }
/*     */     } 
/*     */     
/* 962 */     return resp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String makePadding(int argLevel) {
/* 971 */     StringBuilder sb = new StringBuilder();
/* 972 */     sb.append("<small>");
/*     */     
/* 974 */     for (int i = 0; i < argLevel; i++) {
/* 975 */       sb.append(i);
/* 976 */       sb.append(" ");
/*     */     } 
/*     */     
/* 979 */     sb.append("</small>");
/* 980 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private IOperation[] getStackedOps() {
/* 984 */     return (IOperation[])this._opStack.toArray((Object[])new IOperation[this._opStack.size()]);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\DefaultOpChain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */