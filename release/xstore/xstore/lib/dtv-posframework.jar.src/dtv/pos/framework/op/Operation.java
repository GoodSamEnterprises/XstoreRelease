/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.pos.framework.scope.OperationDefaultScope;
/*     */ import dtv.pos.framework.scope.TransactionScope;
/*     */ import dtv.pos.framework.scope.ValueKey;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IDebuggable;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.IOperationImpl;
/*     */ import dtv.pos.iframework.op.IReversibleOp;
/*     */ import dtv.pos.iframework.op.OpApplicability;
/*     */ import dtv.pos.iframework.op.OpStatus;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Operation
/*     */   implements IOperationImpl, IDebuggable
/*     */ {
/*     */   public static final String OPERATION_COMPLETE_EVENT_DESC = "OPERATION_COMPLETE";
/*  40 */   public static final EventEnum OPERATION_COMPLETE = new EventEnum("OPERATION_COMPLETE");
/*     */ 
/*     */   
/*  43 */   public static final EventDescriptor OPERATION_EVENTOR_DESCRIPTOR = new EventDescriptor("OPERATION_EVENTOR");
/*     */   
/*  45 */   private static final Logger logger_ = Logger.getLogger(Operation.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean checkApplicable(IOperation argOperation) {
/*  54 */     if (argOperation == null) {
/*  55 */       return false;
/*     */     }
/*     */     try {
/*  58 */       boolean applicable = false;
/*     */       
/*  60 */       if (argOperation instanceof IOperationImpl) {
/*  61 */         IOperationImpl op = (IOperationImpl)argOperation;
/*     */ 
/*     */ 
/*     */         
/*  65 */         applicable = op.getApplicabilityState().isApplicable(op);
/*     */       } else {
/*     */         
/*  68 */         applicable = argOperation.isOperationApplicable();
/*     */       } 
/*     */       
/*  71 */       return applicable;
/*     */     }
/*  73 */     catch (Exception ex) {
/*  74 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  75 */       return false;
/*     */     }
/*  77 */     catch (StackOverflowError ex) {
/*  78 */       logger_.error("CAUGHT ERROR", ex);
/*  79 */       return false;
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
/*     */   static boolean checkApplicableToReverse(IOperation argOperation) {
/*  91 */     if (!(argOperation instanceof IReversibleOp)) {
/*  92 */       return false;
/*     */     }
/*     */     try {
/*  95 */       return ((IReversibleOp)argOperation).isApplicableToReverse();
/*     */     }
/*  97 */     catch (Exception ex) {
/*  98 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  99 */       return false;
/*     */     }
/* 101 */     catch (StackOverflowError ex) {
/* 102 */       logger_.error("CAUGHT ERROR", ex);
/* 103 */       return false;
/*     */     } 
/*     */   }
/*     */   
/* 107 */   private Eventor _opEventor = null;
/*     */   
/* 109 */   private IOpState _opState = null;
/*     */   
/* 111 */   private OpApplicability applicabilityState_ = OpApplicability.UNKNOWN;
/*     */   
/*     */   private IUIContextDescriptor contextDescriptor_;
/*     */   
/*     */   private String sourceDescription_;
/*     */   
/*     */   private boolean breakpoint_;
/*     */   
/*     */   private boolean cancelable_;
/*     */   
/*     */   private boolean complete_;
/*     */   
/*     */   private boolean isLongRunning_;
/*     */   
/*     */   private String _longRunningMessage;
/*     */   
/*     */   private boolean required_;
/*     */   
/*     */   @Inject
/*     */   private OperationDefaultScope _defaultScope;
/*     */   
/*     */   @Inject
/*     */   protected TransactionScope _transactionScope;
/*     */   
/*     */   @Inject
/*     */   protected Provider<IModeController> _modeProvider;
/*     */   
/*     */   @Inject
/*     */   protected StationState _stationState;
/*     */   
/*     */   @Inject
/*     */   protected TransDateProvider _transDateProvider;
/*     */   @Inject
/*     */   protected OpResponseHelper HELPER;
/*     */   @Inject
/*     */   protected FormattableFactory _formattables;
/*     */   
/*     */   protected Operation() {
/* 149 */     this(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Operation(boolean argIsCancelable) {
/* 157 */     InjectionHammer.forceAtInjectProcessing(this);
/* 158 */     this.cancelable_ = argIsCancelable;
/* 159 */     this.required_ = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canceling() {
/* 165 */     setOpState(null);
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 172 */     Object clone = null;
/*     */     try {
/* 174 */       clone = super.clone();
/*     */     }
/* 176 */     catch (CloneNotSupportedException ex) {
/* 177 */       logger_.error("Clone not supported on operation", ex);
/*     */     } 
/* 179 */     return clone;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dumpDebugInfo(int argLevel, StringBuilder sb) {
/* 185 */     sb.append(makePadding(argLevel));
/* 186 */     sb.append(getClass().getName());
/* 187 */     sb.append(getAdditionalDebugInfo());
/* 188 */     if (this.breakpoint_) {
/* 189 */       sb.append("(breakpoint)");
/*     */     }
/* 191 */     sb.append("[");
/* 192 */     sb.append(Integer.toHexString(hashCode()));
/* 193 */     sb.append("]::<tt>");
/* 194 */     sb.append(getSourceDescription());
/* 195 */     sb.append("</tt>\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpApplicability getApplicabilityState() {
/* 201 */     return (this.applicabilityState_ != null) ? this.applicabilityState_ : OpApplicability.UNKNOWN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IUIContextDescriptor getContextDescriptor() {
/* 207 */     return this.contextDescriptor_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLogId() {
/* 213 */     return getClass().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLongRunningMessage() {
/* 219 */     return this._longRunningMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?>[] getObservedEventInterfaces() {
/* 228 */     return new Class[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpState getOpState() {
/* 234 */     return this._opState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOpType() {
/* 240 */     return "OP";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getSourceDescription() {
/* 246 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final IOpResponse handleBreakPointReversal(IXstEvent argEvent) {
/* 252 */     IOpResponse response = this.HELPER.completeResponse();
/* 253 */     if (this instanceof IReversibleOp) {
/* 254 */       response = ((IReversibleOp)this).handleOpReverse(argEvent);
/*     */     }
/*     */     
/* 257 */     if (OpStatus.INCOMPLETE.equals(response.getOpStatus())) {
/* 258 */       return response;
/*     */     }
/*     */     
/* 261 */     if (this.breakpoint_ && checkApplicable((IOperation)this)) {
/*     */ 
/*     */       
/* 264 */       if (response.getOpStatus().getPauseChain()) {
/* 265 */         logger_.warn("_HALT variant makes no sense for a breakpoint, using non _HALT variant");
/*     */       }
/*     */       
/* 268 */       return response.derive(OpStatus.BREAKPOINT_FOUND);
/*     */     } 
/*     */ 
/*     */     
/* 272 */     return response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBreakPoint() {
/* 279 */     if (this.breakpoint_) {
/*     */       try {
/* 281 */         return checkApplicable((IOperation)this);
/*     */       }
/* 283 */       catch (Exception ex) {
/* 284 */         logger_.error("CAUGHT EXCEPTION", ex);
/* 285 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 289 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicableToReverse() {
/* 297 */     return this instanceof IReversibleOp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCancelable() {
/* 303 */     return this.cancelable_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 309 */     return this.complete_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isLongRunning() {
/* 315 */     return this.isLongRunning_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOperationApplicable() {
/* 321 */     return validateConfigs();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 327 */     return this.required_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApplicabilityState(OpApplicability argApplicabilityState) {
/* 333 */     this.applicabilityState_ = argApplicabilityState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBreakPoint(boolean breakpoint) {
/* 339 */     this.breakpoint_ = breakpoint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelable(boolean argValue) {
/* 345 */     this.cancelable_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComplete(boolean argIsComplete) {
/* 351 */     if (argIsComplete && postEventWhenComplete()) {
/* 352 */       if (this._opEventor == null) {
/* 353 */         this._opEventor = (Eventor)new DefaultEventor((IEventSource)OPERATION_EVENTOR_DESCRIPTOR);
/*     */       }
/* 355 */       this._opEventor.post(OPERATION_COMPLETE);
/*     */     } 
/* 357 */     this.complete_ = argIsComplete;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContextDescriptor(IUIContextDescriptor argDescriptor) {
/* 363 */     this.contextDescriptor_ = argDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLongRunning(boolean argLongRunning) {
/* 369 */     this.isLongRunning_ = argLongRunning;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOpState(IOpState argOpState) {
/* 375 */     this._opState = argOpState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 381 */     if ("Cancelable".equalsIgnoreCase(argName)) {
/* 382 */       boolean cancelable = ConfigUtils.asBool(argValue.toString());
/* 383 */       setCancelable(cancelable);
/*     */     }
/* 385 */     else if ("LongRunningMessage".equalsIgnoreCase(argName)) {
/* 386 */       this._longRunningMessage = argValue.toString();
/*     */     } else {
/*     */       
/* 389 */       logger_.warn("Unexpected parameter for " + getClass().getName() + ":" + argName + "=" + argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argIsRequired) {
/* 396 */     this.required_ = argIsRequired;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSourceDescription(String argSourceDescription) {
/* 402 */     this.sourceDescription_ = argSourceDescription;
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
/* 413 */     return getClass().getName();
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
/*     */   protected <T> void clearScopedValue(ValueKey<T> argValueKey) {
/* 427 */     this._defaultScope.clearValue(argValueKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String dumpDefaultScope() {
/* 435 */     return this._defaultScope.dump();
/*     */   }
/*     */   
/*     */   protected String getAdditionalDebugInfo() {
/* 439 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> T getScopedValue(ValueKey<T> argValueKey) {
/* 450 */     return (T)this._defaultScope.getValue(argValueKey);
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
/*     */   protected String makePadding(int argLevel) {
/* 462 */     StringBuilder sb = new StringBuilder();
/* 463 */     sb.append("<small>");
/* 464 */     for (int i = 0; i < argLevel; i++) {
/* 465 */       sb.append(i);
/* 466 */       sb.append(" ");
/*     */     } 
/* 468 */     sb.append("</small>");
/* 469 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean postEventWhenComplete() {
/* 480 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> void setScopedValue(ValueKey<T> argValueKey, T argValue) {
/* 491 */     this._defaultScope.setValue(argValueKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean validateConfigs() {
/* 502 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\Operation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */