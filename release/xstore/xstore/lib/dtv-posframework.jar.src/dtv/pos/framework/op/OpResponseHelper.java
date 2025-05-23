/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.XstDataAction;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionType;
/*     */ import dtv.pos.framework.op.req.AbstractCustomOpRequest;
/*     */ import dtv.pos.framework.op.req.ChangeFormRequest;
/*     */ import dtv.pos.framework.op.req.InfoMessageRequest;
/*     */ import dtv.pos.framework.op.req.ListPromptRequest;
/*     */ import dtv.pos.framework.op.req.PromptRequest;
/*     */ import dtv.pos.framework.op.req.RunChainRequest;
/*     */ import dtv.pos.framework.op.req.SecurityRequest;
/*     */ import dtv.pos.framework.op.req.ShowFormRequest;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.OpStatus;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.ui.model.IMessage;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class OpResponseHelper {
/*  36 */   static final Logger logger_ = Logger.getLogger(OpResponseHelper.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PromptConfigHelper _promptConfigHelper;
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse completeCurrentChainResponse() {
/*  50 */     return new OpResponse(OpStatus.CHAIN_COMPLETE, new IOpRequest[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse completeResponse() {
/*  59 */     return new OpResponse(OpStatus.COMPLETE, new IOpRequest[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse completeWaitResponse() {
/*  68 */     return new OpResponse(OpStatus.COMPLETE_HALT, new IOpRequest[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse errorNotifyResponse() {
/*  78 */     return getPromptResponseImpl(OpStatus.ERROR_HALT, PromptKey.valueOf("STANDARD_ERROR"), null, null, new IFormattable[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getBackupResponse() {
/*  89 */     return new OpResponse(OpStatus.INCOMPLETE_HALT, new IOpRequest[] { (IOpRequest)new AbstractCustomOpRequest()
/*     */           {
/*     */             private static final long serialVersionUID = 1L;
/*     */             
/*     */             public void handleRequest(IXstEventListener listener) {
/*  94 */               XstDataAction xstDataAction = new XstDataAction(XstDataActionType.STANDARD, XstDataActionKey.CANCEL);
/*  95 */               ((IModeController)OpResponseHelper.this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)xstDataAction);
/*     */             }
/*     */           } });
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
/*     */   public IOpResponse getChangeFormResponse(FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroupKey, boolean argEditable) {
/* 120 */     if (argFormKey == null) {
/* 121 */       logger_.warn("null form key", new Throwable("STACK TRACE"));
/*     */     }
/* 123 */     return getChangeFormResponse(argFormKey, argModel, argActionGroupKey, argEditable, null);
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
/*     */   public IOpResponse getChangeFormResponse(FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroupKey, boolean argEditable, FormTabKey argTabKey) {
/* 148 */     if (argFormKey == null) {
/* 149 */       logger_.warn("null form key", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/* 152 */     return new OpResponse(OpStatus.INCOMPLETE_HALT, new IOpRequest[] { (IOpRequest)new ChangeFormRequest(argFormKey, argModel, argEditable, argActionGroupKey, argTabKey) });
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
/*     */   public IOpResponse getCompleteListPromptResponse(PromptKey promptKey, Object[] listItems, IFormattable... argPromptArgs) {
/* 165 */     return getListPromptResponseImpl(OpStatus.COMPLETE_HALT, promptKey, argPromptArgs, listItems, null, false);
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
/*     */   public IOpResponse getCompletePromptResponse(PromptKey promptKey, IFormattable... promptArgs) {
/* 178 */     return getPromptResponseImpl(OpStatus.COMPLETE_HALT, promptKey, (PromptConfig)null, null, promptArgs);
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
/*     */   public IOpResponse getCompletePromptResponse(PromptKey promptKey, PromptConfig config, IFormattable... promptArgs) {
/* 192 */     return getPromptResponseImpl(OpStatus.COMPLETE_HALT, promptKey, config, null, promptArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getCompleteShowFormResponse(FormKey argFormKey, IEditModel argEditModel) {
/* 199 */     return getShowFormResponseImpl(OpStatus.COMPLETE, argFormKey, argEditModel, null, true, null);
/*     */   }
/*     */   
/*     */   public IOpResponse getCompleteStackChainResponse(OpChainKey key) {
/* 203 */     return getRunChainResponseImpl(true, key, null, XstChainActionType.STACK);
/*     */   }
/*     */   
/*     */   public IOpResponse getCompleteStackChainResponse(OpChainKey key, IXstEvent argEvent) {
/* 207 */     return getRunChainResponseImpl(true, key, argEvent, XstChainActionType.STACK);
/*     */   }
/*     */   
/*     */   public IOpResponse getErrorResponse(IFormattable message) {
/* 211 */     return getPromptResponseImpl(OpStatus.ERROR_HALT, PromptKey.valueOf("ERROR_WITH_INFO"), null, null, new IFormattable[] { message });
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
/*     */   public IOpResponse getListPromptResponse(PromptKey promptKey, Object[] listItems, IFormattable... promptArgs) {
/* 224 */     return getListPromptResponseImpl(OpStatus.INCOMPLETE_HALT, promptKey, promptArgs, listItems, null, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public IOpResponse getListPromptResponse(PromptKey argPromptKey, Object[] argListItems, Integer[] argSelectedIndices, boolean argDisplayFullScreen, IFormattable... argPromptArgs) {
/* 229 */     return getListPromptResponseImpl(OpStatus.INCOMPLETE_HALT, argPromptKey, argPromptArgs, argListItems, argSelectedIndices, argDisplayFullScreen);
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
/*     */   public IOpResponse getListPromptResponse(PromptKey promptKey, Object[] listItems, Integer[] argSelectedIndices, IFormattable... promptArgs) {
/* 245 */     return getListPromptResponseImpl(OpStatus.INCOMPLETE_HALT, promptKey, promptArgs, listItems, argSelectedIndices, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public IOpResponse getOpChainRollBackRequest() {
/* 250 */     return new OpResponse(OpStatus.COMPLETE, new IOpRequest[] { (IOpRequest)new AbstractCustomOpRequest()
/*     */           {
/*     */             private static final long serialVersionUID = 1L;
/*     */             
/*     */             public void handleRequest(IXstEventListener listener) {
/* 255 */               if (!(listener instanceof OpChainProcessor)) {
/* 256 */                 OpResponseHelper.logger_.warn("Listener must be an operation chain processor to perform rollback!");
/*     */                 return;
/*     */               } 
/* 259 */               ((OpChainProcessor)listener).processRollback();
/*     */             }
/*     */           } });
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
/*     */   public IOpResponse getPromptResponse(PromptKey promptKey, IFormattable... promptArgs) {
/* 273 */     return getPromptResponseImpl(OpStatus.INCOMPLETE_HALT, promptKey, (PromptConfig)null, null, promptArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public IOpResponse getPromptResponse(PromptKey promptKey, PromptConfig config, FormKey argParentFormKey, IFormattable... promptArgs) {
/* 278 */     return getPromptResponseImpl(OpStatus.INCOMPLETE_HALT, promptKey, config, argParentFormKey, promptArgs);
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
/*     */   public IOpResponse getPromptResponse(PromptKey promptKey, PromptConfig config, IFormattable... promptArgs) {
/* 291 */     return getPromptResponseImpl(OpStatus.INCOMPLETE_HALT, promptKey, config, null, promptArgs);
/*     */   }
/*     */   
/*     */   public IOpResponse getSecurityAuthenticateResponse(String argPrivilege) {
/* 295 */     SecurityRequest securityRequest = SecurityRequest.getAuthenticateRequest(argPrivilege);
/* 296 */     return new OpResponse(OpStatus.INCOMPLETE_HALT, new IOpRequest[] { (IOpRequest)securityRequest });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getSecurityAuthorizeResponse(String[] argPrivileges, IFormattable argOverrideMessage) {
/* 306 */     SecurityRequest securityRequest = SecurityRequest.getAuthorizeRequest(argPrivileges);
/* 307 */     securityRequest.setMessage(argOverrideMessage);
/* 308 */     return new OpResponse(OpStatus.INCOMPLETE_HALT, new IOpRequest[] { (IOpRequest)securityRequest });
/*     */   }
/*     */   
/*     */   public IOpResponse getShowFormResponse(FormKey argFormKey, IEditModel argModel) {
/* 312 */     return getShowFormResponseImpl(OpStatus.INCOMPLETE_HALT, argFormKey, argModel, DataActionGroupKey.DEFAULT, true, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getShowFormResponse(FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroup) {
/* 318 */     return getShowFormResponseImpl(OpStatus.INCOMPLETE_HALT, argFormKey, argModel, argActionGroup, true, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getShowFormResponse(FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroupKey, boolean argEditable) {
/* 324 */     return getShowFormResponseImpl(OpStatus.INCOMPLETE_HALT, argFormKey, argModel, argActionGroupKey, argEditable, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getShowFormResponse(FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroupKey, boolean argEditable, FormTabKey argTabKey) {
/* 331 */     return getShowFormResponseImpl(OpStatus.INCOMPLETE_HALT, argFormKey, argModel, argActionGroupKey, argEditable, argTabKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse getShowMessageResponse(IMessage argMessage) {
/* 338 */     InfoMessageRequest infoMessageRequest = (argMessage != null) ? InfoMessageRequest.makeMessageRequest(argMessage) : InfoMessageRequest.makeClearRequest();
/* 339 */     return new OpResponse(OpStatus.COMPLETE, new IOpRequest[] { (IOpRequest)infoMessageRequest });
/*     */   }
/*     */   
/*     */   public IOpResponse getStartChainResponse(OpChainKey key) {
/* 343 */     return getRunChainResponseImpl(true, key, null, XstChainActionType.START);
/*     */   }
/*     */   
/*     */   public IOpResponse getStartChainResponse(OpChainKey argKey, IXstEvent argEvent) {
/* 347 */     return getRunChainResponseImpl(true, argKey, argEvent, XstChainActionType.START);
/*     */   }
/*     */   
/*     */   public IOpResponse getWaitStackChainResponse(OpChainKey argKey) {
/* 351 */     return getRunChainResponseImpl(false, argKey, null, XstChainActionType.STACK);
/*     */   }
/*     */   
/*     */   public IOpResponse getWaitStackChainResponse(OpChainKey key, IXstEvent event) {
/* 355 */     return getRunChainResponseImpl(false, key, event, XstChainActionType.STACK);
/*     */   }
/*     */   
/*     */   public IOpResponse incompleteResponse() {
/* 359 */     return new OpResponse(OpStatus.INCOMPLETE, new IOpRequest[0]);
/*     */   }
/*     */   
/*     */   public IOpResponse silentErrorResponse() {
/* 363 */     return new OpResponse(OpStatus.ERROR, new IOpRequest[0]);
/*     */   }
/*     */   
/*     */   public IOpResponse waitResponse() {
/* 367 */     return new OpResponse(OpStatus.INCOMPLETE_HALT, new IOpRequest[0]);
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
/*     */   protected IOpResponse getListPromptResponseImpl(OpStatus opStatus, PromptKey promptKey, IFormattable[] promptArgs, Object[] listItems, Integer[] argSelectedIndices, boolean argDisplayFullScreen) {
/* 385 */     PromptConfig promptConfig = this._promptConfigHelper.getPromptConfig(promptKey, null);
/*     */     
/* 387 */     if (!opStatus.getPauseChain()) {
/* 388 */       logger_.error("THE LIST CALLER REALLY SHOULD SPECIFY THE '_HALT' VARIANT OF OP STATUS");
/* 389 */       Thread.dumpStack();
/*     */     } 
/*     */     
/* 392 */     ListPromptRequest req = new ListPromptRequest(promptKey, promptArgs, listItems, argSelectedIndices, promptConfig);
/*     */     
/* 394 */     req.setDisplayFullScreen(argDisplayFullScreen);
/* 395 */     return new OpResponse(opStatus, new IOpRequest[] { (IOpRequest)req });
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOpResponse getPromptResponseImpl(OpStatus argOpStatus, PromptKey argPromptKey, PromptConfig argPromptConfig, FormKey argParentFormKey, IFormattable... argPromptArgs) {
/* 400 */     PromptConfig resolvedConfig = this._promptConfigHelper.getPromptConfig(argPromptKey, argPromptConfig);
/* 401 */     return new OpResponse(argOpStatus, new IOpRequest[] { (IOpRequest)new PromptRequest(argPromptKey, resolvedConfig, argParentFormKey, argPromptArgs) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse getRunChainResponseImpl(boolean argCompleteOp, OpChainKey key, IXstEvent event, XstChainActionType argChainActionType) {
/* 407 */     OpStatus status = argCompleteOp ? OpStatus.COMPLETE_HALT : OpStatus.INCOMPLETE_HALT;
/* 408 */     return new OpResponse(status, new IOpRequest[] { (IOpRequest)new RunChainRequest(key, event, argChainActionType, null, true) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse getShowFormResponseImpl(OpStatus argOpStatus, FormKey argFormKey, IEditModel argModel, DataActionGroupKey argActionGroupKey, boolean argEditable, FormTabKey argTabKey) {
/* 416 */     return new OpResponse(argOpStatus, new IOpRequest[] { (IOpRequest)new ShowFormRequest(argFormKey, argModel, argActionGroupKey, argEditable, null, argTabKey) });
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpResponseHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */