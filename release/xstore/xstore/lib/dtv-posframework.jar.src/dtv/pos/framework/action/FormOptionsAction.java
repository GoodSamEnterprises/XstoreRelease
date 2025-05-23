/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.FormOptionsActionType;
/*     */ import dtv.pos.framework.action.type.FormOptionsKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.form.FormAssembler;
/*     */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IListPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.Component;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormOptionsAction
/*     */   extends XstDefaultAction
/*     */   implements IXstEventListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  45 */   private static final PromptKey FORM_OPTIONS_PROMPT = PromptKey.valueOf("FORM_OPTIONS");
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private FormViewConfigHelper _formConfigHelper;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private FormAssembler _formAssembler;
/*     */   
/*     */   @Inject
/*     */   private PromptConfigHelper _promptConfigHelper;
/*     */   
/*     */   @Inject
/*     */   private FormattableFactory _formattables;
/*     */ 
/*     */   
/*     */   public FormOptionsAction(FormOptionsKey argKey, FormOptionsActionType argType) {
/*  63 */     super((IXstActionType)argType, (IXstActionKey)argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleXstEvent(IXstEvent argEvent) {
/*  69 */     if (argEvent instanceof IXstAction) {
/*  70 */       IXstAction action = (IXstAction)argEvent;
/*     */       
/*  72 */       if (XstDataActionKey.CANCEL.equals(action.getActionKey())) {
/*  73 */         UIServices.invoke(new Runnable()
/*     */             {
/*     */               public void run() {
/*  76 */                 ((IModeController)FormOptionsAction.this._modeProvider.get()).getStationModel().getListPromptModel().clear();
/*  77 */                 ((IModeController)FormOptionsAction.this._modeProvider.get()).getUiController().hidePopupView();
/*     */               }
/*     */             },  true, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNavigable() {
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {
/*  93 */     super.notifyAccessGranted(argResponse);
/*     */     
/*  95 */     FormOptionsKey optionsKey = (FormOptionsKey)getActionKey();
/*  96 */     final DataActionGroupKey actionKey = DataActionGroupKey.createForName(optionsKey.toString());
/*  97 */     final IFormModel formModel = getFormModel();
/*     */     
/*  99 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 102 */             Collection<IXstAction> actions = null;
/*     */             
/* 104 */             if (FormOptionsAction.this._formAssembler.hasFormConfiguration(formModel.getFormKey())) {
/* 105 */               actions = FormOptionsAction.this._formAssembler.getActions(formModel.getEditModel(), actionKey, formModel.getFormKey(), null, false);
/*     */             }
/*     */             else {
/*     */               
/* 109 */               actions = FormOptionsAction.this._formConfigHelper.getActions(formModel, actionKey, null, false);
/*     */             } 
/*     */             
/* 112 */             for (IXstAction action : actions) {
/* 113 */               action.evaluateVisibility();
/*     */             }
/*     */             
/* 116 */             PromptConfig promptConfig = FormOptionsAction.this._promptConfigHelper.getPromptConfig(FormOptionsAction.FORM_OPTIONS_PROMPT, null);
/*     */             
/* 118 */             IStationModel stationModel = ((IModeController)FormOptionsAction.this._modeProvider.get()).getStationModel();
/* 119 */             IListPromptModel<?> promptModel = stationModel.getListPromptModel();
/*     */             
/* 121 */             IUIController uiCon = ((IModeController)FormOptionsAction.this._modeProvider.get()).getUiController();
/* 122 */             Component c = uiCon.getFocusableChildComponent("POPUP_LIST_VIEW");
/* 123 */             Collection<Component> keyTargets = Arrays.asList(new Component[] { c });
/*     */             
/* 125 */             stationModel.getPromptActionModel().setValues(promptConfig.getPromptActions(), ActionDisplayType.POPUP, (IUIInputModel)promptModel, keyTargets, FormOptionsAction.this);
/*     */ 
/*     */             
/* 128 */             IFormattable titleArg = FormOptionsAction.this._formattables.getLiteral(FormOptionsAction.this.getActionName());
/* 129 */             promptModel.setPromptArgs(new IFormattable[] { titleArg });
/* 130 */             promptModel.setValues((IPromptConfig)promptConfig, actions.toArray(), new int[] { 0 });
/* 131 */             uiCon.showPopupList(false);
/*     */           }
/*     */         }true, false);
/*     */   }
/*     */   
/*     */   private IFormModel getFormModel() {
/* 137 */     IStationModel sm = ((IModeController)this._modeProvider.get()).getStationModel();
/* 138 */     return sm.getFormModel(sm.getPrimaryFormModelKey());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\FormOptionsAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */