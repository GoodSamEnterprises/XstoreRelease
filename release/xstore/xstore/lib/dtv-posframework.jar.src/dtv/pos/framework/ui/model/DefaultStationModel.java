/*     */ package dtv.pos.framework.ui.model;
/*     */ import com.micros.xstore.config.common.Action;
/*     */ import com.micros.xstore.config.form.ActionGroupType;
/*     */ import com.micros.xstore.config.form.FormType;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.ApplicationData;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.appmanagement.ApplicationConfigHelper;
/*     */ import dtv.pos.framework.form.FormAssembler;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*     */ import dtv.pos.framework.scope.TransactionScope;
/*     */ import dtv.pos.iframework.ILocationFactory;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IListEditModel;
/*     */ import dtv.pos.iframework.security.ISecurityMgr;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.type.ModelKey;
/*     */ import dtv.pos.iframework.ui.config.IActionGroupConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IHelpModel;
/*     */ import dtv.pos.iframework.ui.model.IListPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.pos.iframework.ui.model.IMessageModel;
/*     */ import dtv.pos.iframework.ui.model.INotifyPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.ui.model.ITextPromptModel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IFormVisibilityRule;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class DefaultStationModel extends AbstractUIModel implements IStationModel {
/*  53 */   private static final IEventConstraint modelEventorPassConstraint_ = (IEventConstraint)new NameConstraint(TransactionScope.CURRENT_TRANSACTION);
/*     */ 
/*     */   
/*  56 */   private final EventHandler cascade_ = (EventHandler)new CascadingHandler(this);
/*     */   
/*  58 */   private final Map<FormKey, IFormModel> formModelMap_ = new HashMap<>();
/*  59 */   private final Map<ModelKey<? extends IListEditModel<Object>>, IListEditModel<Object>> listModelMap_ = new HashMap<>();
/*     */   
/*     */   private ModelKey<? extends IListEditModel<Object>> currentListModelKey_;
/*     */   
/*     */   private IMenuModel menuModel_;
/*     */   private IListPromptModel<?> listPromptModel_;
/*     */   private ITextPromptModel textPromptModel_;
/*     */   private ITextPromptModel longTextPromptModel_;
/*     */   private INotifyPromptModel notifyPromptModel_;
/*     */   private IPromptActionModel actionModel_;
/*     */   private IMessageModel messageModel_;
/*     */   private IHelpModel helpModel_;
/*  71 */   private FormKey primaryFormModelKey_ = null;
/*     */   
/*     */   private ICombinedListModel<Object> currentListModel_;
/*     */   
/*     */   private ApplicationData _applicationModeData;
/*     */   
/*     */   private boolean isInitialized_;
/*     */   
/*     */   private String activeFormKey_;
/*     */   
/*     */   private String activePromptKey_;
/*     */   
/*     */   @Inject
/*     */   private FormViewConfigHelper _formConfigHelper;
/*     */   
/*     */   @Inject
/*     */   private FormAssembler _formAssembler;
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */   @Inject
/*     */   private ISecurityMgr _securityMgr;
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */   @Inject
/*     */   private ILocationFactory _locationFactory;
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   @Inject
/*     */   private ListEditModelFactory _listModelFactory;
/*     */   
/* 102 */   private final EventHandler modelEventorPassHandler_ = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/* 106 */         (new DefaultEventor((IEventSource)new EventDescriptor(ModelEventor.class))).post(ModelEventor.OPEN_EVENT);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void create() {
/* 115 */     this._eventManager.registerEventHandler((IEventAware)this.modelEventorPassHandler_, this, modelEventorPassConstraint_);
/*     */   }
/*     */   
/*     */   public void destroy() {
/* 119 */     this._eventManager.deregisterEventHandler((IEventAware)this.modelEventorPassHandler_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActiveFormKey() {
/* 125 */     return this.activeFormKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivePromptKey() {
/* 131 */     return this.activePromptKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getAppChangeActions() {
/* 137 */     Collection<String> links = this._applicationModeData.getApplicationLinks();
/*     */     
/* 139 */     if (links == null) {
/* 140 */       return null;
/*     */     }
/*     */     
/* 143 */     List<IXstAction> appChangeActions = new ArrayList<>(links.size());
/* 144 */     for (String linkedAppKey : links) {
/*     */       
/* 146 */       ApplicationData newAppData = ApplicationConfigHelper.getInstance().getApplicationData(linkedAppKey);
/*     */       
/* 148 */       if (newAppData != null) {
/* 149 */         appChangeActions.add(newAppData.getAction());
/*     */       }
/*     */     } 
/*     */     
/* 153 */     return appChangeActions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApplicationKey() {
/* 159 */     return this._applicationModeData.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICombinedListModel<Object> getCurrentListModel() {
/* 165 */     return this.currentListModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelKey<? extends IListEditModel<Object>> getCurrentListModelKey() {
/* 171 */     return this.currentListModelKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEditModel getEditModel(FormKey argFormKey) {
/* 177 */     IEditModel editModel = null;
/* 178 */     IFormModel formModel = getFormModel(argFormKey);
/*     */     
/* 180 */     if (formModel != null) {
/* 181 */       editModel = formModel.getEditModel();
/*     */       
/* 183 */       if (editModel == null && argFormKey != null) {
/*     */         
/* 185 */         FormKey formKey = FormKey.valueOf(argFormKey.toString() + "_" + this._locationFactory
/* 186 */             .getStoreById(this._stationState.getRetailLocationId()).getCountry());
/* 187 */         formModel = getFormModel(formKey);
/* 188 */         editModel = formModel.getEditModel();
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     return editModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getFormActions(FormKey argFormKey) {
/* 198 */     Collection<IXstAction> actions = new ArrayList<>();
/* 199 */     FormKey formKey = (argFormKey != null) ? argFormKey : getPrimaryFormModelKey();
/* 200 */     IFormModel formModel = getFormModel(formKey);
/*     */     
/* 202 */     if (formModel != null)
/*     */     {
/* 204 */       if (this._formAssembler.hasFormConfiguration(formKey)) {
/* 205 */         IEditModel editModel = getEditModel(formKey);
/*     */         
/* 207 */         FormType config = this._formAssembler.getFormConfiguration(formKey.toString());
/* 208 */         for (ActionGroupType actionGroup : config.getActionGroups()) {
/* 209 */           for (Action action : actionGroup.getActions()) {
/*     */             
/* 211 */             IXstAction act = this._actionFactory.getAction(null, action);
/*     */             
/* 213 */             if (act == null) {
/*     */               continue;
/*     */             }
/*     */             
/* 217 */             List<IVisibilityRule> rules = act.getVisibilityRules();
/* 218 */             if (rules != null) {
/* 219 */               for (IVisibilityRule rule : rules) {
/* 220 */                 if (rule instanceof IFormVisibilityRule) {
/* 221 */                   ((IFormVisibilityRule)rule).setEditModel(editModel);
/*     */                 }
/*     */               } 
/*     */             }
/*     */             
/* 226 */             IAccessLevel access = act.evaluateVisibility();
/* 227 */             if (access.isViewable()) {
/* 228 */               actions.add(act);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 234 */         FormViewConfig config = this._formConfigHelper.getFormViewConfig(formKey);
/*     */         
/* 236 */         if (config != null) {
/* 237 */           for (IActionGroupConfig group : config.getActionGroupConfigs()) {
/* 238 */             actions.addAll(group.getActions());
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 244 */     return actions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormModel getFormModel(FormKey argFormKey) {
/* 250 */     FormKey formKey = (argFormKey == null) ? getPrimaryFormModelKey() : argFormKey;
/* 251 */     IFormModel fm = this.formModelMap_.get(formKey);
/*     */     
/* 253 */     if (fm == null) {
/* 254 */       fm = new DefaultFormModel(formKey);
/* 255 */       this.formModelMap_.put(formKey, fm);
/*     */     } 
/*     */     
/* 258 */     return fm;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IHelpModel getHelpModel() {
/* 264 */     return this.helpModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICombinedListModel<?> getListModel(String argModelKey) {
/* 272 */     ICombinedListModel<?> result = null;
/*     */     
/* 274 */     if (argModelKey == null) {
/*     */       
/* 276 */       IListPromptModel<?> iListPromptModel = getListPromptModel();
/*     */     } else {
/*     */       
/* 279 */       ModelKey<? extends IListEditModel<Object>> modelKey = new ModelKey(argModelKey);
/* 280 */       result = getModel(modelKey, false);
/*     */       
/* 282 */       if (result == null) {
/*     */ 
/*     */         
/* 285 */         IEditModel editModel = getEditModel(FormKey.valueOf(argModelKey));
/*     */         
/* 287 */         if (editModel instanceof ICombinedListModel) {
/* 288 */           result = (ICombinedListModel)editModel;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 293 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListPromptModel<?> getListPromptModel() {
/* 299 */     return this.listPromptModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextPromptModel getLongTextPromptModel() {
/* 305 */     return this.longTextPromptModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMenuModel getMenuModel() {
/* 311 */     return this.menuModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMessageModel getMessageModel() {
/* 317 */     return this.messageModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <M extends IListEditModel<Object>> M getModel(ModelKey<M> argType) {
/* 323 */     return getModel(argType, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <M extends IListEditModel<Object>> M getModel(ModelKey<M> argType, boolean argCreate) {
/* 330 */     if (argType == null) {
/* 331 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 336 */     IListEditModel<Object> iListEditModel = this.listModelMap_.get(argType);
/*     */     
/* 338 */     if (iListEditModel == null && argCreate) {
/* 339 */       iListEditModel = this._listModelFactory.createListModel(argType);
/* 340 */       this.listModelMap_.put(argType, iListEditModel);
/*     */     } 
/*     */     
/* 343 */     iListEditModel.setUser(this._stationState.getSystemUser());
/* 344 */     return (M)iListEditModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public INotifyPromptModel getNotifyPromptModel() {
/* 350 */     return this.notifyPromptModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormKey getPrimaryFormModelKey() {
/* 356 */     return this.primaryFormModelKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptActionModel getPromptActionModel() {
/* 362 */     return this.actionModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JFormattedTextField.AbstractFormatter getTextFormatter() {
/* 368 */     return getTextPromptModel().getPromptConfig().getDataFieldConfig().getFormatters().getEditFormatter();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextPromptModel getTextPromptModel() {
/* 374 */     return this.textPromptModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(ApplicationData argApplicationModeData) {
/* 380 */     if (!this.isInitialized_) {
/* 381 */       this._applicationModeData = argApplicationModeData;
/*     */ 
/*     */       
/* 384 */       this._eventManager.registerEventHandler((IEventAware)this.cascade_, (IEventSource)this._securityMgr);
/*     */       
/* 386 */       this.isInitialized_ = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveFormKey(String argFormKey) {
/* 393 */     this.activeFormKey_ = argFormKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivePromptKey(String argPromptKey) {
/* 399 */     this.activePromptKey_ = argPromptKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentListModel(ModelKey<? extends IListEditModel<Object>> argType) {
/* 407 */     if (argType == null || !argType.equals(this.currentListModelKey_)) {
/* 408 */       this.currentListModelKey_ = argType;
/* 409 */       this.currentListModel_ = getModel(argType);
/* 410 */       this.events_.post(SET_CURRENT_LIST_MODEL, argType);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpModel(IHelpModel argModel) {
/* 417 */     this.helpModel_ = argModel;
/* 418 */     this.events_.post(SET_HELP_MODEL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <M extends IListEditModel<Object>> void setListModel(ModelKey<M> argKey, M argModel) {
/* 424 */     this.listModelMap_.put(argKey, (IListEditModel<Object>)argModel);
/*     */ 
/*     */ 
/*     */     
/* 428 */     this.currentListModelKey_ = null;
/* 429 */     setCurrentListModel(argKey);
/* 430 */     this.events_.post(SET_LIST_MODEL, argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setListPromptModel(IListPromptModel<?> model) {
/* 436 */     this.listPromptModel_ = model;
/* 437 */     this.events_.post(SET_LIST_PROMPT_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLongTextPromptModel(ITextPromptModel model) {
/* 443 */     this.longTextPromptModel_ = model;
/* 444 */     this.events_.post(SET_LONG_TEXT_PROMPT_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMenuModel(IMenuModel model) {
/* 450 */     this.menuModel_ = model;
/* 451 */     this.events_.post(SET_MENU_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageModel(IMessageModel model) {
/* 457 */     this.messageModel_ = model;
/* 458 */     this.events_.post(SET_MESSAGE_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotifyPromptModel(INotifyPromptModel model) {
/* 464 */     this.notifyPromptModel_ = model;
/* 465 */     this.events_.post(SET_NOTIFY_PROMPT_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryFormModelKey(FormKey argFormKey) {
/* 471 */     this.primaryFormModelKey_ = argFormKey;
/* 472 */     this.events_.post(SET_PRIMARY_FORM_MODEL_KEY, argFormKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptActionModel(IPromptActionModel model) {
/* 478 */     this.actionModel_ = model;
/* 479 */     this.events_.post(SET_PROMPT_ACTION_MODEL, model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextPromptModel(ITextPromptModel model) {
/* 485 */     this.textPromptModel_ = model;
/* 486 */     this.events_.post(SET_TEXT_PROMPT_MODEL, model);
/*     */   }
/*     */   
/*     */   protected void clearModelImpl() {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultStationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */