/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import com.micros.xstore.config.form.FormType;
/*     */ import com.micros.xstore.config.form.PageType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.ActionLogger;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.access.AccessEvaluators;
/*     */ import dtv.pos.framework.form.component.FormPanel;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IFormNavigationAction;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstChainAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.action.IXstDataActionKey;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IFormVisibilityRule;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.ui.model.ISingleSelectionModel;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.JComponent;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class FormReqHandler
/*     */   extends AbstractFormReqHandler
/*     */   implements IOpReqHandler {
/*  57 */   private static final Logger _logger = Logger.getLogger(FormReqHandler.class);
/*     */ 
/*     */   
/*     */   private IModeController _modeController;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ActionLogger _actionLogger;
/*     */   
/*     */   @Inject
/*     */   private ProcessLogger _flowLogger;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/*     */   public void handleRequest(IOpRequest argRequest, final IXstEventListener argListener, IModeController argModeController) {
/*  74 */     this._modeController = argModeController;
/*  75 */     final AbstractFormRequest request = (AbstractFormRequest)argRequest;
/*  76 */     FormKey key = request.getFormKey();
/*     */ 
/*     */     
/*  79 */     IEditModel em = request.getEditModel();
/*     */     
/*  81 */     final IFormModel formModel = this._modeController.getStationModel().getFormModel(key);
/*  82 */     final FormViewConfig cfg = this._formConfigHelper.getFormViewConfig(request.getFormKey());
/*  83 */     final boolean hasOldConfig = this._formConfigHelper.isFormConfigurationExist(key);
/*     */     
/*  85 */     final FormType newConfig = this._formAssembler.getFormConfiguration(key.toString());
/*     */     
/*  87 */     if (hasOldConfig) {
/*  88 */       this._flowLogger.info("Form", request.getFormKey(), (IHasSourceDescription)cfg, null, null);
/*     */     } else {
/*     */       
/*  91 */       this._flowLogger.info("Form", request.getFormKey(), (IHasSourceDescription)newConfig, null, null);
/*     */     } 
/*     */ 
/*     */     
/*  95 */     final IEditModel editModel = em;
/*  96 */     final StorageCallback<Throwable> storage = new StorageCallback<>();
/*     */     
/*  98 */     final FormLocationType location = (request.getFormLocationType() != null) ? request.getFormLocationType() : getFormLocationFromConfiguration(request.getFormKey());
/*     */     
/* 100 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */ 
/*     */           
/*     */           public void run()
/*     */           {
/*     */             try {
/* 107 */               if (editModel != null) {
/* 108 */                 formModel.setValues(editModel, request.getActionGroup(), request.isEditable());
/*     */               }
/* 110 */               JComponent formComp = null;
/*     */ 
/*     */               
/* 113 */               IUIController uiCon = FormReqHandler.this._modeController.getUiController();
/*     */               
/* 115 */               if (FormLocationType.POPUP_VIEW_PANEL.equals(location)) {
/* 116 */                 uiCon.showPopupView(false);
/*     */               } else {
/*     */                 
/* 119 */                 uiCon.hidePopupView();
/*     */               } 
/*     */ 
/*     */               
/* 123 */               formComp = uiCon.showFormView(request.getFormKey(), location, request.isEditable());
/*     */               
/* 125 */               if (FormLocationType.MULTI_PURPOSE_VIEW.equals(location)) {
/* 126 */                 FormReqHandler.this._modeController.getStationModel().setPrimaryFormModelKey(request.getFormKey());
/*     */               }
/*     */ 
/*     */ 
/*     */               
/* 131 */               ISingleSelectionModel selectionModel = (ISingleSelectionModel)formComp.getClientProperty("SELECTION_MODEL_PROP");
/*     */               
/* 133 */               if (selectionModel != null) {
/* 134 */                 if (request.getTabKey() != null) {
/* 135 */                   String actionSubKey = selectionModel.setSelectedTab(request.getTabKey().getName(), true);
/* 136 */                   formModel.setActionGroupSubKey(actionSubKey);
/*     */ 
/*     */ 
/*     */                 
/*     */                 }
/*     */                 else {
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 146 */                   if (request.getRequestType() == OpRequestType.SHOW_FORM.name()) {
/* 147 */                     selectionModel.setSelectedIndex(0);
/*     */                   }
/* 149 */                   String selectedName = selectionModel.getSelectedTab();
/* 150 */                   formModel.setActionGroupSubKey(selectionModel.setSelectedTab(selectedName, false));
/*     */                 } 
/*     */                 
/* 153 */                 formModel.setSelectionModel(selectionModel);
/*     */               } 
/*     */ 
/*     */               
/* 157 */               FormPanel<IFormModel> wrapperPanel = (FormPanel<IFormModel>)formComp.getClientProperty("COMPONENT_WRAPPER");
/*     */               
/* 159 */               if (wrapperPanel != null) {
/* 160 */                 wrapperPanel.setModelEnabled(request.isEditable());
/* 161 */                 wrapperPanel.setModel(formModel);
/*     */               } 
/*     */               
/* 164 */               String actionGroupSubKey = null;
/* 165 */               actionGroupSubKey = formModel.getActionGroupSubKey();
/*     */ 
/*     */               
/* 168 */               if (request.getActionGroup() != null) {
/*     */                 ActionDisplayType actionDisplayType;
/* 170 */                 Collection<IXstAction> actions = FormReqHandler.this.getActions(hasOldConfig, formModel, request.getActionGroup(), actionGroupSubKey);
/* 171 */                 ISingleSelectionModel tabSelectionModel = formModel.getSelectionModel();
/* 172 */                 if (tabSelectionModel != null) {
/*     */ 
/*     */                   
/* 175 */                   for (String tabName : tabSelectionModel.getTabs()) {
/* 176 */                     if (hasOldConfig) {
/* 177 */                       IFormViewPanelConfig<IFormComponentConfig> iFormViewPanelConfig = null;
/*     */ 
/*     */                       
/* 180 */                       for (IFormViewPanelConfig<IFormComponentConfig> panelConfig : cfg.getViewPanelConfigs()) {
/* 181 */                         FormTabKey tabKey = FormTabKey.forName(tabName);
/* 182 */                         if (panelConfig.getFormTabKey().equals(tabKey)) {
/* 183 */                           iFormViewPanelConfig = panelConfig;
/*     */                           
/*     */                           break;
/*     */                         } 
/*     */                       } 
/* 188 */                       FormReqHandler.this.addTabAction(iFormViewPanelConfig.getFormTabKey(), iFormViewPanelConfig.getAdditionalActionKey(), iFormViewPanelConfig
/* 189 */                           .getVisibilityRules(), request.getActionGroup(), tabSelectionModel, editModel);
/*     */                       
/*     */                       continue;
/*     */                     } 
/* 193 */                     PageType formPanelConfig = null;
/*     */ 
/*     */                     
/* 196 */                     for (PageType panelConfig : newConfig.getPages()) {
/* 197 */                       if (panelConfig.getName().equalsIgnoreCase(tabName)) {
/* 198 */                         formPanelConfig = panelConfig;
/*     */                         
/*     */                         break;
/*     */                       } 
/*     */                     } 
/* 203 */                     FormReqHandler.this.addTabAction(FormTabKey.forName(tabName), (IXstActionKey)null, FormReqHandler.this._formAssembler
/* 204 */                         .getVisibilityRules(formPanelConfig), request.getActionGroup(), tabSelectionModel, editModel);
/*     */                   } 
/*     */ 
/*     */ 
/*     */                   
/* 209 */                   IFormNavigationAction[] navActions = FormReqHandler.this.getNavigationActions(actions);
/*     */ 
/*     */ 
/*     */                   
/* 213 */                   if (navActions != null && navActions.length > 0) {
/* 214 */                     for (IFormNavigationAction navAction : navActions) {
/* 215 */                       tabSelectionModel.setActionAt(navAction.getFormTabKey().toString(), (IDtvAction)navAction);
/*     */                     }
/*     */                   }
/*     */                 } 
/*     */ 
/*     */                 
/* 221 */                 if (FormLocationType.POPUP_VIEW_PANEL.equals(location)) {
/* 222 */                   actionDisplayType = ActionDisplayType.POPUP;
/*     */                 } else {
/*     */                   
/* 225 */                   actionDisplayType = ActionDisplayType.BUTTON_EXCLUSIVE;
/*     */                 } 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 231 */                 Collection<Component> keyStrokeTargets = null;
/*     */ 
/*     */                 
/* 234 */                 FormReqHandler.this._modeController.getStationModel().getPromptActionModel().setValues(actions, actionDisplayType, (IUIInputModel)formModel, keyStrokeTargets, argListener);
/*     */               }
/*     */             
/*     */             }
/* 238 */             catch (Throwable ex) {
/* 239 */               FormReqHandler._logger.error("CAUGHT EXCEPTION", ex);
/* 240 */               storage.store(ex);
/*     */             } 
/*     */           }
/*     */         }true, true);
/*     */ 
/*     */     
/* 246 */     Throwable ex = storage.getStored();
/* 247 */     if (ex != null) {
/* 248 */       if (ex instanceof RuntimeException) {
/* 249 */         throw (RuntimeException)ex;
/*     */       }
/* 251 */       if (ex instanceof Error) {
/* 252 */         throw (Error)ex;
/*     */       }
/* 254 */       throw new RuntimeException(ex);
/*     */     } 
/*     */     
/* 257 */     if (formModel.getActionGroupKey() != null) {
/* 258 */       this._modeController.getStationModel().setActiveFormKey(key.toString());
/*     */ 
/*     */       
/* 261 */       if (ConfigurationMgr.isOnScreenKeyboardAutomaticallyCalled() && hasOldConfig && cfg.isAutoPopOnScreenKbdEnabled()) {
/* 262 */         OnScreenKeyboard.ensureKeyboardIsShowing();
/*     */       }
/*     */     } 
/* 265 */     this._modeController.getStationModel().setActivePromptKey(key.toString());
/* 266 */     this._actionLogger.logFormActions(key.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<IXstAction> getActions(boolean argHasOldConfig, IFormModel argFormModel, DataActionGroupKey argActionGroup, String argActionGroupSubKey) {
/* 271 */     if (argHasOldConfig) {
/* 272 */       return this._formConfigHelper.getActions(argFormModel, argActionGroup, argActionGroupSubKey);
/*     */     }
/*     */     
/* 275 */     return this._formAssembler.getActions(argFormModel.getEditModel(), argActionGroup, argFormModel.getFormKey(), argActionGroupSubKey, true);
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
/*     */   IFormNavigationAction[] getNavigationActions(Collection<IXstAction> actions) {
/* 288 */     if (actions == null || actions.size() == 0) {
/* 289 */       return null;
/*     */     }
/*     */     
/* 292 */     Collection<IFormNavigationAction> navActions = new ArrayList<>(actions.size());
/*     */     
/* 294 */     for (IXstAction action : actions) {
/* 295 */       if (action instanceof IFormNavigationAction) {
/* 296 */         navActions.add((IFormNavigationAction)action);
/*     */       }
/*     */     } 
/*     */     
/* 300 */     return navActions.<IFormNavigationAction>toArray(new IFormNavigationAction[0]);
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
/*     */   private void addTabAction(FormTabKey argFormTabKey, IXstActionKey argAdditionalKey, List<IVisibilityRule> argVisibilityRules, DataActionGroupKey argActionGroup, ISingleSelectionModel argSelectionModel, IEditModel argEditModel) {
/* 312 */     IFormNavigationAction iFormNavigationAction = this._actionFactory.getFormNavigationAction(argActionGroup, argFormTabKey);
/* 313 */     List<IVisibilityRule> visRules = argVisibilityRules;
/*     */     
/* 315 */     for (IVisibilityRule visRule : visRules) {
/* 316 */       if (visRule instanceof IFormVisibilityRule) {
/* 317 */         ((IFormVisibilityRule)visRule).setEditModel(argEditModel);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     BooleanConfig bc = new BooleanConfig(true);
/* 328 */     ParameterConfig paramConfig = new ParameterConfig("IgnoreFormNavigationRule", (IConfigObject)bc);
/* 329 */     List<ParameterConfig> paramConfigs = new ArrayList<>();
/* 330 */     paramConfigs.add(paramConfig);
/* 331 */     iFormNavigationAction.setParameters(paramConfigs);
/* 332 */     iFormNavigationAction.setVisibilityRules(visRules, false);
/*     */     
/* 334 */     if (argAdditionalKey instanceof IXstDataActionKey) {
/* 335 */       IXstDataAction iXstDataAction = this._actionFactory.getDataAction((IXstDataActionKey)argAdditionalKey);
/* 336 */       iFormNavigationAction.addPostAction((Action)iXstDataAction);
/*     */     }
/* 338 */     else if (argAdditionalKey instanceof OpChainKey) {
/* 339 */       IXstChainAction iXstChainAction = this._actionFactory.getChainAction((OpChainKey)argAdditionalKey, null);
/* 340 */       iFormNavigationAction.addPostAction((Action)iXstChainAction);
/*     */     } 
/*     */     
/* 343 */     String tabName = argFormTabKey.getName();
/* 344 */     argSelectionModel.setActionAt(tabName, (IDtvAction)iFormNavigationAction);
/* 345 */     IAccessLevel access = AccessEvaluators.getEvaluator((IXstAction)iFormNavigationAction).evaluateAccess((IXstAction)iFormNavigationAction);
/*     */     
/* 347 */     if (access.isGranted()) {
/* 348 */       argSelectionModel.setEnabledAt(tabName, true);
/*     */     } else {
/*     */       
/* 351 */       argSelectionModel.setEnabledAt(tabName, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   static class StorageCallback<T> {
/* 356 */     private T stored_ = null;
/*     */     
/*     */     public T getStored() {
/* 359 */       return this.stored_;
/*     */     }
/*     */     
/*     */     public void store(T o) {
/* 363 */       this.stored_ = o;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\FormReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */