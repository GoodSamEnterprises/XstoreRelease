/*     */ package dtv.pos.framework.op.xflow;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.op.AbstractPromptOp;
/*     */ import dtv.pos.framework.scope.ValueKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpChainFactory;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class StubPlaceholderOp
/*     */   extends AbstractPromptOp
/*     */ {
/*  36 */   private static final Logger _logger = Logger.getLogger(StubPlaceholderOp.class);
/*     */   
/*     */   private final IOperation stubbedOp_;
/*     */   private StubOpPromptConfig promptConfig_;
/*  40 */   private final Map<String, String> parameters_ = new HashMap<>(17);
/*     */   
/*     */   @Inject
/*     */   private IOpChainFactory _opChainFactory;
/*     */ 
/*     */   
/*     */   public StubPlaceholderOp(IOperation argStubbedOp) {
/*  47 */     this.stubbedOp_ = argStubbedOp;
/*     */   }
/*     */   
/*     */   public StubbedOperation getAnnotation() {
/*  51 */     return this.stubbedOp_.getClass().<StubbedOperation>getAnnotation(StubbedOperation.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final PromptKey getDefaultPromptKey() {
/*  57 */     return this.promptConfig_.getPromptKey();
/*     */   }
/*     */   
/*     */   public String getParameter(String argName) {
/*  61 */     return this.parameters_.get(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {
/*  68 */     return this.HELPER.getPromptResponse(this.promptConfig_.getPromptKey(), this.promptConfig_, new IFormattable[0]);
/*     */   }
/*     */   
/*     */   public Class<?> getStubClass() {
/*  72 */     return this.stubbedOp_.getClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/*  80 */     if (this.promptConfig_ == null) {
/*  81 */       this.promptConfig_ = new StubOpPromptConfig(this.stubbedOp_, this);
/*     */     }
/*     */ 
/*     */     
/*  85 */     IOpState state = getOpState();
/*  86 */     if (state == this.POST_PROMPT && !(argEvent instanceof IXstDataAction)) {
/*  87 */       setOpState(null);
/*     */     }
/*  89 */     return super.handleOpExec(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final IOpResponse handlePromptResponse(IXstEvent argEvent) {
/*  95 */     IXstActionKey key = ((IXstDataAction)argEvent).getActionKey();
/*     */     
/*  97 */     Action action = getAction(key);
/*  98 */     if (action != null) {
/*  99 */       return handleAction(action);
/*     */     }
/* 101 */     if (key == XstDataActionKey.ACCEPT || key == OpStubConstants.NOT_APPLICABLE) {
/* 102 */       _logger.warn("COMPLETING OPERATION");
/* 103 */       return this.HELPER.completeResponse();
/*     */     } 
/* 105 */     if (key == OpStubConstants.ERROR) {
/* 106 */       _logger.warn("THROWING HELPDESK ERROR");
/* 107 */       return this.HELPER.errorNotifyResponse();
/*     */     } 
/*     */     
/* 110 */     _logger.error("No action mapped to key " + key);
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 118 */     this.parameters_.put(argName, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     return "**** OPERATION STUB --" + this.stubbedOp_.toString() + "-- TO REALIZE THIS OPERATION, REMOVE its @StubbedOperation annotation. You won't be able to debug this op until @StubbedOperation is removed. **** Source: " + 
/*     */ 
/*     */       
/* 127 */       getSourceDescription() + " (fyi, " + getClass().getName() + " is actually running)";
/*     */   }
/*     */   
/*     */   protected Action getAction(IXstActionKey argActionKey) {
/* 131 */     for (Action action : getAnnotation().actions()) {
/* 132 */       if (action.key().equalsIgnoreCase(argActionKey.toString())) {
/* 133 */         return action;
/*     */       }
/*     */     } 
/* 136 */     return null;
/*     */   }
/*     */   
/*     */   protected String getLabel(int argIndex) {
/* 140 */     return ((getAnnotation().actions()).length > argIndex) ? getAnnotation().actions()[argIndex].label() : null;
/*     */   }
/*     */   
/*     */   protected OpChainKey getOpChainKey(Action argAction) {
/* 144 */     ResponseType responseType = argAction.responseType();
/*     */     
/* 146 */     if (responseType != null && responseType.isChainType()) {
/* 147 */       OpChainKey chainKey = OpChainKey.valueOf(argAction.key());
/*     */       
/* 149 */       if (this._opChainFactory.isValidChain(chainKey)) {
/* 150 */         return chainKey;
/*     */       }
/*     */       
/* 153 */       String parameter = getParameter(chainKey.toString());
/*     */       
/* 155 */       if (parameter != null) {
/* 156 */         chainKey = OpChainKey.valueOf(parameter.toString());
/*     */         
/* 158 */         if (this._opChainFactory.isValidChain(chainKey)) {
/* 159 */           return chainKey;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   protected IOpResponse handleAction(Action argAction) {
/* 169 */     ResponseType responseType = argAction.responseType();
/* 170 */     OpChainKey chainKey = getOpChainKey(argAction);
/* 171 */     StubOpStatus opStatus = argAction.opStatus();
/* 172 */     setScopedValue(argAction);
/*     */     
/* 174 */     switch (responseType) {
/*     */       case COMPLETE:
/* 176 */         return this.HELPER.completeResponse();
/*     */       case SILENT_ERROR_RESPONSE:
/* 178 */         return this.HELPER.silentErrorResponse();
/*     */       case COMPLETE_HALT_RESPONSE:
/* 180 */         return this.HELPER.completeWaitResponse();
/*     */       case NOTIFY_ERROR_RESPONSE:
/* 182 */         return this.HELPER.errorNotifyResponse();
/*     */       case COMPLETE_STACK_CHAIN:
/* 184 */         return this.HELPER.getCompleteStackChainResponse(chainKey);
/*     */       case RUN_CHAIN_START:
/* 186 */         return this.HELPER.getStartChainResponse(chainKey);
/*     */       case STACK_CHAIN:
/* 188 */         if (opStatus.getOpStatus().getPauseChain()) {
/* 189 */           return this.HELPER.getWaitStackChainResponse(chainKey);
/*     */         }
/*     */         
/* 192 */         return this.HELPER.getCompleteStackChainResponse(chainKey);
/*     */       
/*     */       case WAIT_STACK_CHAIN:
/* 195 */         return this.HELPER.getWaitStackChainResponse(chainKey);
/*     */     } 
/* 197 */     _logger.error("Unkown responseType: " + responseType);
/* 198 */     return this.HELPER.errorNotifyResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setScopedValue(Action argAction) {
/* 204 */     String valueKey = argAction.valueKey();
/* 205 */     if (!StringUtils.isEmpty(valueKey)) {
/*     */       String value;
/* 207 */       if (argAction.scopedValueIsNull()) {
/* 208 */         value = null;
/*     */       } else {
/*     */         
/* 211 */         value = argAction.scopedValue();
/*     */       } 
/* 213 */       setScopedValue(new ValueKey(String.class, valueKey), value);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\StubPlaceholderOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */