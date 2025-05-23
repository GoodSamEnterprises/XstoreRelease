/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.form.FormConstants;
/*     */ import dtv.pos.framework.ui.config.DataFieldConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.validation.IValidationResultList;
/*     */ import dtv.ui.swing.text.IStyler;
/*     */ import dtv.ui.swing.text.ValidationResultsStyler;
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
/*     */ public abstract class AbstractFormOp<EM extends IEditModel>
/*     */   extends Operation
/*     */ {
/*  36 */   private static final Logger logger_ = Logger.getLogger(AbstractFormOp.class);
/*     */ 
/*     */   
/*     */   protected static final String LIST_ELEMENT_KEY = "_listElement";
/*     */ 
/*     */   
/*  42 */   protected final IOpState AFTER_REQUEST = new OpState("AFTER_REQUEST");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   protected final IOpState VALIDATION_ERROR = new OpState("VALIDATION_ERROR");
/*     */ 
/*     */   
/*     */   private EM _editModel;
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @Inject
/*     */   protected FormattableFactory _FF;
/*     */   
/*     */   @Inject
/*     */   private PromptConfigHelper _promptConfigHelper;
/*     */ 
/*     */   
/*     */   public final IOpResponse handleOpExec(IXstEvent argEvent) {
/*  62 */     if (getOpState() == null) {
/*  63 */       this._editModel = createModel();
/*     */     }
/*     */     
/*  66 */     IOpResponse resp = handleBeforeDataAction(argEvent);
/*     */     
/*  68 */     if (resp != null) {
/*  69 */       return resp;
/*     */     }
/*     */     
/*  72 */     if (argEvent instanceof IXstDataAction) {
/*  73 */       resp = handleDataAction((IXstDataAction)argEvent);
/*     */       
/*  75 */       if (resp != null) {
/*  76 */         return resp;
/*     */       }
/*     */     } 
/*     */     
/*  80 */     return handleAfterDataAction(argEvent);
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
/*     */   protected abstract EM createModel();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataActionGroupKey getActionGroupKey() {
/* 102 */     return DataActionGroupKey.DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract FormKey getFormKey();
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptKey getFormValidationFailedPromptKey() {
/* 113 */     return PromptKey.valueOf("FORM_VALIDATION_FAILED_ALT");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse getFormValidityResponse(EM argModel) {
/* 124 */     IValidationResultList results = validateForm(argModel);
/*     */     
/* 126 */     if (results.isValid()) {
/* 127 */       return null;
/*     */     }
/*     */     
/* 130 */     setOpState(this.VALIDATION_ERROR);
/*     */     
/* 132 */     PromptConfig promptConfig = new PromptConfig();
/* 133 */     promptConfig.setDataFieldConfig((IDataFieldConfig)new DataFieldConfig());
/*     */     
/* 135 */     PromptKey promptKey = getFormValidationFailedPromptKey();
/* 136 */     promptConfig = this._promptConfigHelper.getPromptConfig(promptKey, promptConfig);
/* 137 */     String problemHeader = promptConfig.getMsgSectionConfig().getText(null).toString(OutputContextType.VIEW);
/*     */     
/* 139 */     ValidationResultsStyler styler = new ValidationResultsStyler(problemHeader, results.getInvalidResults());
/*     */     
/* 141 */     promptConfig.getDataFieldConfig().setStyler((IStyler)styler);
/*     */     
/* 143 */     return this.HELPER.getPromptResponse(promptKey, promptConfig, getFormKey(), new dtv.i18n.IFormattable[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EM getModel() {
/* 152 */     return this._editModel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleAfterDataAction(IXstEvent argEvent) {
/* 162 */     IOpState opState = getOpState();
/*     */     
/* 164 */     if (argEvent instanceof dtv.pos.iframework.action.IFormNavigationAction)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       return this.HELPER.waitResponse();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     if (opState == null || opState == this.VALIDATION_ERROR) {
/* 184 */       return handleInitialState();
/*     */     }
/* 186 */     if (argEvent == null) {
/* 187 */       return handleNullEvent();
/*     */     }
/* 189 */     if (opState == this.AFTER_REQUEST) {
/* 190 */       EM model = getModel();
/*     */       
/* 192 */       if (model != null) {
/* 193 */         IOpResponse validationResponse = getFormValidityResponse(model);
/*     */         
/* 195 */         if (validationResponse != null) {
/* 196 */           return validationResponse;
/*     */         }
/*     */       } 
/*     */       
/* 200 */       return handleFormResponse(argEvent);
/*     */     } 
/* 202 */     logger_.warn("UNEXPECTED OP STATE [" + opState + "]::argEvent=[" + argEvent + "]", new Throwable("STACK TRACE"));
/*     */ 
/*     */     
/* 205 */     return handleInitialState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleBeforeDataAction(IXstEvent argAction) {
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDataAction(IXstDataAction argAction) {
/* 225 */     IXstActionKey key = argAction.getActionKey();
/*     */     
/* 227 */     if (key == FormConstants.EXIT || key == XstDataActionKey.CANCEL) {
/* 228 */       return handleExit();
/*     */     }
/* 230 */     if (key == FormConstants.CONTINUE) {
/* 231 */       return handleSkip();
/*     */     }
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDisplayAgain() {
/* 242 */     return this.HELPER.getChangeFormResponse(getFormKey(), (IEditModel)getModel(), getActionGroupKey(), isEditable());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleExit() {
/* 251 */     return this.HELPER.silentErrorResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleFormResponse(IXstEvent argEvent) {
/* 261 */     getModel().commitChanges();
/* 262 */     setOpState(null);
/* 263 */     return this.HELPER.completeResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleInitialState() {
/* 272 */     EM model = getModel();
/* 273 */     setOpState(this.AFTER_REQUEST);
/*     */     
/* 275 */     return this.HELPER.getShowFormResponse(getFormKey(), (IEditModel)model, getActionGroupKey(), isEditable());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleNullEvent() {
/* 285 */     return handleDisplayAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleSkip() {
/* 294 */     setOpState(null);
/* 295 */     return this.HELPER.completeResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isEditable() {
/* 304 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IValidationResultList validateForm(EM argModel) {
/* 315 */     return argModel.validate();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractFormOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */