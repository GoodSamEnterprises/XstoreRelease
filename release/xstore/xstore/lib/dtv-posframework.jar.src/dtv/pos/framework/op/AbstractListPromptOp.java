/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.event.XstEvent;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public abstract class AbstractListPromptOp
/*     */   extends AbstractPromptOp
/*     */ {
/*     */   private static final String PARAM_SHOW_LIST_IF_ONE = "ShowListIfOne";
/*  32 */   private static final Integer[] DEFAULT_INITIAL_SELECTION = new Integer[] { Integer.valueOf(0) };
/*  33 */   private static final Logger logger_ = LogManager.getLogger(AbstractListPromptOp.class);
/*     */   
/*  35 */   protected final IOpState SHOWING_ERROR = new OpState("SHOWING_ERROR");
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _showListIfOne;
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractListPromptOp() {
/*  44 */     this._showListIfOne = ConfigurationMgr.showListsIfOne();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {
/*  52 */     Object[] list = new Object[0];
/*     */     try {
/*  54 */       list = getPromptList(argEvent);
/*     */     }
/*  56 */     catch (ObjectNotFoundException ex) {
/*  57 */       logger_.debug("CAUGHT EXCEPTION", (Throwable)ex);
/*     */     } 
/*     */ 
/*     */     
/*  61 */     if (list == null || list.length == 0) {
/*  62 */       return getEmptyListPromptResponse();
/*     */     }
/*  64 */     if (list.length == 1 && !showListIfOne()) {
/*     */       
/*  66 */       IXstEvent event = (argEvent == null) ? (IXstEvent)new XstEvent(null) : argEvent;
/*  67 */       event.setData(list[0]);
/*  68 */       logger_.debug("The list prompt contains a single item, skipping prompt {}", argPromptKey);
/*     */       
/*  70 */       return handlePromptResponse(event);
/*     */     } 
/*     */     
/*  73 */     handleBeforeDisplayList(argEvent, list);
/*  74 */     return this.HELPER.getListPromptResponse(argPromptKey, list, getSelectedIndices(list), displayAsFullScreen(), argPromptArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/*  81 */     return (getOpState() == this.SHOWING_ERROR) ? this.HELPER.silentErrorResponse() : super.handleOpExec(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBreakPoint() {
/*  87 */     boolean breakpointed = super.hasBreakPoint();
/*     */     
/*  89 */     if (breakpointed && !showListIfOne()) {
/*  90 */       Object[] list = getPromptList((IXstEvent)null);
/*     */       
/*  92 */       return (list == null || list.length != 1);
/*     */     } 
/*     */     
/*  95 */     return breakpointed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 101 */     if ("ShowListIfOne".equalsIgnoreCase(argName)) {
/* 102 */       this._showListIfOne = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     } else {
/*     */       
/* 105 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean displayAsFullScreen() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract PromptKey getEmptyListPromptKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse getEmptyListPromptResponse() {
/* 127 */     PromptKey promptKey = getEmptyListPromptKey();
/*     */     
/* 129 */     if (promptKey == null) {
/* 130 */       return this.HELPER.completeResponse();
/*     */     }
/*     */     
/* 133 */     setOpState(this.SHOWING_ERROR);
/* 134 */     return this.HELPER.getPromptResponse(promptKey, new IFormattable[0]);
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
/*     */   protected abstract Object[] getPromptList(IXstEvent paramIXstEvent);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse getRePromptResponse(IXstEvent argEvent, Integer[] argSelectedIndices) {
/* 156 */     PromptKey promptKey = getPromptKey();
/* 157 */     IFormattable[] promptArgs = getPromptArgs(argEvent);
/* 158 */     Object[] promptList = getPromptList(argEvent);
/*     */     
/* 160 */     return this.HELPER.getListPromptResponse(promptKey, promptList, argSelectedIndices, displayAsFullScreen(), promptArgs);
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
/*     */   protected Integer[] getSelectedIndices(Object[] argList) {
/* 172 */     return DEFAULT_INITIAL_SELECTION;
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
/*     */   protected void handleBeforeDisplayList(IXstEvent argEvent, Object[] argListElements) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDataAction(IXstDataAction argEvent) {
/* 195 */     if (getOpState() == this.SHOWING_ERROR) {
/* 196 */       setOpState((IOpState)null);
/* 197 */       return this.HELPER.completeResponse();
/*     */     } 
/*     */     
/* 200 */     return super.handleDataAction(argEvent);
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
/*     */   protected boolean showListIfOne() {
/* 212 */     return this._showListIfOne;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractListPromptOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */