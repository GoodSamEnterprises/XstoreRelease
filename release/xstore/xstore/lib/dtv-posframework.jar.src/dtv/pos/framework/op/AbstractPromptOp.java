/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.op.req.SecurityRequest;
/*     */ import dtv.pos.framework.op.req.SecurityResponse;
/*     */ import dtv.pos.framework.validation.ValidationHelper;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IPromptOp;
/*     */ import dtv.pos.iframework.op.IValidationOp;
/*     */ import dtv.pos.iframework.validation.IValidationResult;
/*     */ import dtv.pos.iframework.validation.IValidationResultList;
/*     */ import dtv.pos.iframework.validation.IValidationRule;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public abstract class AbstractPromptOp
/*     */   extends Operation
/*     */   implements IValidationOp, IPromptOp
/*     */ {
/*  53 */   private static final Logger logger_ = Logger.getLogger(AbstractPromptOp.class);
/*     */   
/*     */   private static final String LIST_ELEMENT_KEY = "_listElement";
/*     */   
/*     */   private static final String CANCEL_AFTER_FAILED_VALIDATION_KEY = "CancelAfterFailedValidation";
/*     */   
/*     */   @Inject
/*     */   protected FormattableFactory _ff;
/*     */   @Inject
/*     */   protected ValidationHelper _validationHelper;
/*  63 */   protected final IOpState POST_PROMPT = new OpState("POST_PROMPT");
/*  64 */   protected final IOpState ERROR_MESSAGE_PROMPT = new OpState("ERROR_MESSAGE_PROMPT");
/*  65 */   protected final IOpState SECURITY_PROCESSING = new OpState("SECURITY_PROCESSING");
/*     */ 
/*     */   
/*  68 */   private final PromptKey VALIDATION_ERROR_CANCEL_MESSAGE = PromptKey.valueOf("VALIDATION_ERROR_CANCEL_MESSAGE");
/*     */   
/*  70 */   private PromptKey _injectedPromptKey = null;
/*     */   private boolean cancelAfterFailedValidation_ = false;
/*  72 */   private List<IValidationRule> _validationRules = new ArrayList<>();
/*  73 */   private Object[] _eventDataBeforeSecProcessing = null;
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractPromptOp() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractPromptOp(boolean argIsCancelable) {
/*  82 */     super(argIsCancelable);
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
/*     */   public IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {
/*  99 */     return this.HELPER.getPromptResponse(argPromptKey, argPromptArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<IValidationRule> getValidationRules() {
/* 104 */     return this._validationRules;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 129 */     IOpState state = getOpState();
/*     */ 
/*     */     
/* 132 */     if (state == this.SECURITY_PROCESSING && argEvent != null) {
/* 133 */       return handleSecurityProcessing(argEvent);
/*     */     }
/* 135 */     if (state == null || argEvent == null) {
/* 136 */       return handleInitialState(argEvent);
/*     */     }
/* 138 */     if (state == this.POST_PROMPT) {
/* 139 */       IOpResponse response = null;
/*     */       
/* 141 */       if (argEvent instanceof IXstDataAction) {
/* 142 */         response = handleDataAction((IXstDataAction)argEvent);
/*     */       }
/*     */       
/* 145 */       if (response != null) {
/* 146 */         return response;
/*     */       }
/*     */       
/* 149 */       response = handlePromptEvent(argEvent);
/*     */       
/* 151 */       if (response != null) {
/* 152 */         return response;
/*     */       }
/*     */ 
/*     */       
/* 156 */       response = runValidationCheck(argEvent, getErrorPromptKey());
/*     */ 
/*     */       
/* 159 */       if (response.getOpStatus().isComplete()) {
/* 160 */         return handlePromptResponse(argEvent);
/*     */       }
/*     */       
/* 163 */       return response;
/*     */     } 
/* 165 */     if (state == this.ERROR_MESSAGE_PROMPT)
/*     */     {
/*     */       
/* 168 */       return handleInitialState(argEvent);
/*     */     }
/*     */     
/* 171 */     logger_.error("unexpected op state [" + state + "]", new Throwable("STACK TRACE"));
/* 172 */     return handleInitialState(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse runValidationCheck(IXstEvent argEvent, PromptKey argFailedPrompt) {
/* 178 */     IValidationResultList results = this._validationHelper.applyValidationRules(argEvent, getValidationRules());
/*     */     
/* 180 */     if (results.isValid()) {
/* 181 */       return this.HELPER.completeResponse();
/*     */     }
/*     */     
/* 184 */     boolean isSingleField = (results.size() == 1);
/*     */     
/* 186 */     IFormattable problemsMessage = null;
/* 187 */     List<String> privilegeList = new ArrayList<>();
/*     */     
/* 189 */     if (isSingleField) {
/* 190 */       IValidationResult r = results.getInvalidResults(0);
/* 191 */       String priv = r.getPrivilege();
/* 192 */       problemsMessage = r.getMessage();
/*     */       
/* 194 */       if (priv != null) {
/* 195 */         privilegeList.add(r.getPrivilege());
/*     */       }
/*     */     } else {
/*     */       
/* 199 */       List<IFormattable> problemList = new ArrayList<>();
/*     */       
/* 201 */       for (int i = 0; i < results.size(); i++) {
/* 202 */         IValidationResult r = results.getInvalidResults(i);
/* 203 */         problemList.add(this._formattables.getTranslatable("_listElement", new IFormattable[] { r.getMessage() }));
/*     */         
/* 205 */         if (r.getPrivilege() != null) {
/* 206 */           privilegeList.add(r.getPrivilege());
/*     */         }
/*     */       } 
/*     */       
/* 210 */       problemsMessage = this._formattables.getAppendingFormattable("", problemList
/* 211 */           .<IFormattable>toArray(new IFormattable[problemList.size()]));
/*     */     } 
/*     */     
/* 214 */     if (results.isSecured() && !privilegeList.isEmpty()) {
/*     */       
/* 216 */       if (argEvent != null && argEvent.getData() != null) {
/* 217 */         this._eventDataBeforeSecProcessing = argEvent.getDataSet();
/*     */       }
/*     */ 
/*     */       
/* 221 */       setOpState(this.SECURITY_PROCESSING);
/*     */       
/* 223 */       String[] privs = privilegeList.<String>toArray(new String[0]);
/* 224 */       return this.HELPER.getSecurityAuthorizeResponse(privs, problemsMessage);
/*     */     } 
/*     */ 
/*     */     
/* 228 */     setOpState(this.ERROR_MESSAGE_PROMPT);
/* 229 */     return this.HELPER.getPromptResponse(argFailedPrompt, new IFormattable[] { problemsMessage });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 236 */     if ("PromptKey".equalsIgnoreCase(argName)) {
/* 237 */       setPromptKey(argValue);
/*     */     }
/* 239 */     else if ("CancelAfterFailedValidation".equalsIgnoreCase(argName)) {
/* 240 */       this.cancelAfterFailedValidation_ = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     } else {
/*     */       
/* 243 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptKey(String argPromptKey) {
/* 250 */     this._injectedPromptKey = PromptKey.valueOf(argPromptKey);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValidationRules(List<IValidationRule> argRules) {
/* 255 */     this._validationRules = argRules;
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
/*     */   protected final BigDecimal getBigDecimal(IXstEvent argEvent) {
/* 267 */     if (argEvent == null) {
/* 268 */       return null;
/*     */     }
/*     */     
/* 271 */     Object o = argEvent.getData();
/*     */     
/* 273 */     if (o instanceof BigDecimal) {
/* 274 */       return (BigDecimal)o;
/*     */     }
/* 276 */     if (o instanceof Integer || o instanceof Long) {
/* 277 */       return BigDecimal.valueOf(((Number)o).longValue());
/*     */     }
/*     */     
/* 280 */     if (o != null) {
/* 281 */       logger_.warn("NOT A BigDecimal!!!!::" + o.getClass().getName() + "=" + o);
/*     */     }
/* 283 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptKey getErrorPromptKey() {
/* 293 */     if (this.cancelAfterFailedValidation_) {
/* 294 */       return this.VALIDATION_ERROR_CANCEL_MESSAGE;
/*     */     }
/*     */     
/* 297 */     return PromptKey.valueOf("VALIDATION_ERROR_MESSAGE");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
/* 308 */     return new IFormattable[] { IFormattable.EMPTY };
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
/*     */   protected final PromptKey getPromptKey() {
/* 321 */     return (this._injectedPromptKey != null) ? this._injectedPromptKey : getDefaultPromptKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDataAction(IXstDataAction argEvent) {
/* 331 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleInitialState(IXstEvent argEvent) {
/* 342 */     setOpState(this.POST_PROMPT);
/*     */     
/* 344 */     if (logger_.isDebugEnabled()) {
/* 345 */       logger_.debug("Returning prompt response for the key " + getPromptKey());
/*     */     }
/*     */     
/* 348 */     return getPromptResponse(argEvent, getPromptKey(), getPromptArgs(argEvent));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handlePromptEvent(IXstEvent argEvent) {
/* 359 */     return null;
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
/*     */   protected IOpResponse handleSecurityFailure(IXstEvent argEvent, SecurityResponse response) {
/* 371 */     IOpResponse opResponse = this.HELPER.silentErrorResponse();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 376 */     if (response.getRequest() instanceof SecurityRequest) {
/* 377 */       IFormattable errorMsg = ((SecurityRequest)response.getRequest()).getMessage();
/*     */       
/* 379 */       if (errorMsg != null) {
/* 380 */         opResponse = this.HELPER.getErrorResponse(errorMsg);
/*     */       }
/*     */     } 
/*     */     
/* 384 */     return opResponse;
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
/*     */   protected IOpResponse handleSecurityProcessing(IXstEvent argEvent) {
/* 396 */     if (argEvent != null && 
/* 397 */       argEvent.getData() instanceof SecurityResponse) {
/*     */       
/* 399 */       setOpState((IOpState)null);
/* 400 */       SecurityResponse response = (SecurityResponse)argEvent.getData();
/*     */       
/* 402 */       if (response.successful()) {
/*     */         
/* 404 */         if (this._eventDataBeforeSecProcessing != null) {
/* 405 */           argEvent.setData(this._eventDataBeforeSecProcessing);
/*     */         }
/*     */         
/* 408 */         handlePromptResponse(argEvent);
/* 409 */         return this.HELPER.completeResponse();
/*     */       } 
/*     */       
/* 412 */       return handleSecurityFailure(argEvent, response);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 420 */     return handleInitialState(argEvent);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractPromptOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */