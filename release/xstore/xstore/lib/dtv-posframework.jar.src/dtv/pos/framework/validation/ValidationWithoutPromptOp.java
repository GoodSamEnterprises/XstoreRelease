/*     */ package dtv.pos.framework.validation;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.op.OpState;
/*     */ import dtv.pos.framework.op.Operation;
/*     */ import dtv.pos.framework.op.req.SecurityRequest;
/*     */ import dtv.pos.framework.op.req.SecurityResponse;
/*     */ import dtv.pos.framework.security.SecurityUtil;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IReversibleOp;
/*     */ import dtv.pos.iframework.op.IValidationOp;
/*     */ import dtv.pos.iframework.op.OpStatus;
/*     */ import dtv.pos.iframework.validation.IValidationResult;
/*     */ import dtv.pos.iframework.validation.IValidationResultList;
/*     */ import dtv.pos.iframework.validation.IValidationRule;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
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
/*     */ public class ValidationWithoutPromptOp
/*     */   extends Operation
/*     */   implements IValidationOp, IReversibleOp
/*     */ {
/*  39 */   private static final Logger logger_ = Logger.getLogger(ValidationWithoutPromptOp.class);
/*     */   
/*     */   private static final String LIST_ELEMENT_KEY = "_listElement";
/*     */   private static final String PARAM_IGNORABLE = "ignorable";
/*  43 */   protected final IOpState ERROR_MESSAGE_PROMPT = (IOpState)new OpState("ERROR_MESSAGE_PROMPT");
/*  44 */   protected final IOpState SECURITY_PROCESSING = (IOpState)new OpState("SECURITY_PROCESSING");
/*     */   
/*     */   private boolean _ignorable = false;
/*     */   private List<IValidationRule> _validationRules;
/*  48 */   private Object _eventDataBeforeSecProcessing = null;
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   protected ValidationHelper _validationHelper;
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private SecurityUtil _securityUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationWithoutPromptOp() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationWithoutPromptOp(boolean argIsCancelable) {
/*  68 */     super(argIsCancelable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IValidationRule> getValidationRules() {
/*  74 */     return this._validationRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/*  85 */     IOpState state = getOpState();
/*     */     
/*  87 */     if (state == null) {
/*  88 */       return handleInitialState(argEvent);
/*     */     }
/*  90 */     if (state == this.SECURITY_PROCESSING) {
/*  91 */       return handleSecurityProcessing(argEvent);
/*     */     }
/*  93 */     if (state == this.ERROR_MESSAGE_PROMPT) {
/*  94 */       return handleAfterErrorMsgPrompt(argEvent);
/*     */     }
/*     */     
/*  97 */     logger_.error("unexpected op state [" + state + "] in " + getClass().getName(), new Throwable("STACK TRACE"));
/*     */     
/*  99 */     return handleInitialState(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpReverse(IXstEvent argEvent) {
/* 109 */     setOpState(null);
/* 110 */     return this.HELPER.completeResponse();
/*     */   }
/*     */   
/*     */   public IOpResponse runValidationCheck(IXstEvent argEvent, PromptKey argFailedPrompt) {
/*     */     IFormattable problemsMessage;
/* 115 */     IValidationResultList results = this._validationHelper.applyValidationRules(argEvent, getValidationRules());
/*     */     
/* 117 */     if (results == null || results.isValid()) {
/* 118 */       return this.HELPER.completeResponse();
/*     */     }
/*     */     
/* 121 */     boolean isSingleField = (results.size() == 1);
/*     */ 
/*     */     
/* 124 */     List<String> privileges = new ArrayList<>();
/*     */     
/* 126 */     if (isSingleField) {
/* 127 */       IValidationResult r = results.getInvalidResults(0);
/* 128 */       problemsMessage = r.getMessage();
/* 129 */       String priv = r.getPrivilege();
/* 130 */       if (priv != null) {
/* 131 */         privileges.add(priv);
/*     */       }
/*     */     } else {
/*     */       
/* 135 */       Set<IFormattable> problems = new LinkedHashSet<>();
/*     */       
/* 137 */       for (int i = 0; i < results.size(); i++) {
/* 138 */         IValidationResult r = results.getInvalidResults(i);
/*     */         
/* 140 */         if (r.getPrivilege() != null) {
/* 141 */           privileges.add(r.getPrivilege());
/*     */         }
/*     */         
/* 144 */         if (!isAccessGranted(r)) {
/* 145 */           IFormattable problemLine = this._formattables.getTranslatable("_listElement", new IFormattable[] { r.getMessage() });
/* 146 */           problems.add(problemLine);
/*     */         } 
/*     */       } 
/*     */       
/* 150 */       IFormattable[] a = problems.<IFormattable>toArray(new IFormattable[problems.size()]);
/* 151 */       problemsMessage = this._formattables.getAppendingFormattable("", a);
/*     */     } 
/*     */     
/* 154 */     if (results.isSecured() && privileges.size() != 0) {
/*     */       
/* 156 */       if (argEvent != null && argEvent.getData() != null) {
/* 157 */         this._eventDataBeforeSecProcessing = argEvent.getData();
/*     */       }
/*     */ 
/*     */       
/* 161 */       setOpState(this.SECURITY_PROCESSING);
/*     */       
/* 163 */       String[] privs = privileges.<String>toArray(new String[privileges.size()]);
/* 164 */       SecurityRequest request = SecurityRequest.getAuthorizeRequest(privs);
/* 165 */       request.setMessage(problemsMessage);
/* 166 */       IOpResponse response = this.HELPER.getSecurityAuthorizeResponse(privs, problemsMessage);
/* 167 */       return response;
/*     */     } 
/*     */ 
/*     */     
/* 171 */     setOpState(this.ERROR_MESSAGE_PROMPT);
/* 172 */     return this.HELPER.getPromptResponse(getErrorPromptKey(argEvent), new IFormattable[] { problemsMessage });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 179 */     if ("ignorable".equalsIgnoreCase(argName)) {
/* 180 */       this._ignorable = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     } else {
/*     */       
/* 183 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidationRules(List<IValidationRule> argRules) {
/* 190 */     this._validationRules = argRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptKey getErrorPromptKey(IXstEvent argEvent) {
/* 200 */     return isValidationIgnorable(argEvent) ? 
/* 201 */       PromptKey.valueOf("VALIDATION_ERROR_YES_NO_MESSAGE") : 
/* 202 */       PromptKey.valueOf("VALIDATION_ERROR_MESSAGE");
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
/*     */   protected IOpResponse handleAfterErrorMsgPrompt(IXstEvent argEvent) {
/* 214 */     return isValidationIgnorable(argEvent) ? this.HELPER
/* 215 */       .completeResponse() : this.HELPER
/* 216 */       .silentErrorResponse();
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
/* 227 */     IOpResponse response = runValidationCheck(argEvent, getErrorPromptKey(argEvent));
/*     */     
/* 229 */     if (response.getOpStatus().equals(OpStatus.COMPLETE)) {
/* 230 */       response = handleValid(argEvent);
/*     */     }
/*     */     
/* 233 */     return response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleSecurityProcessing(IXstEvent argEvent) {
/* 244 */     if (argEvent != null && 
/* 245 */       argEvent.getData() instanceof SecurityResponse) {
/* 246 */       SecurityResponse response = (SecurityResponse)argEvent.getData();
/*     */       
/* 248 */       if (response.successful()) {
/*     */         
/* 250 */         if (this._eventDataBeforeSecProcessing != null) {
/* 251 */           argEvent.setData(this._eventDataBeforeSecProcessing);
/*     */         }
/* 253 */         return handleValid(argEvent);
/*     */       } 
/*     */ 
/*     */       
/* 257 */       setOpState(null);
/*     */       
/* 259 */       return this.HELPER.silentErrorResponse();
/*     */     } 
/*     */ 
/*     */     
/* 263 */     return this.HELPER.waitResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleValid(IXstEvent argEvent) {
/* 272 */     return this.HELPER.completeResponse();
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
/*     */   protected boolean isAccessGranted(IValidationResult argFailure) {
/* 284 */     boolean granted = false;
/*     */     
/* 286 */     ISystemUser systemUser = this._stationState.getSystemUser();
/* 287 */     if (systemUser != null) {
/* 288 */       String privilege = argFailure.getPrivilege();
/*     */       
/* 290 */       if (privilege != null) {
/* 291 */         IAccessLevel accessLevel = this._securityUtil.getAccessLevel(privilege, systemUser.getGroupMembership());
/*     */         
/* 293 */         granted = (accessLevel != null && accessLevel.isGranted() && argFailure.isValid());
/*     */       } 
/*     */     } 
/* 296 */     return granted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidationIgnorable(IXstEvent argEvent) {
/* 307 */     return this._ignorable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setValidationIgnorable(boolean argIgnorable) {
/* 315 */     this._ignorable = argIgnorable;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\validation\ValidationWithoutPromptOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */