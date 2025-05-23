/*     */ package dtv.pos.framework.ui.view;
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.ui.component.XstActionList;
/*     */ import dtv.pos.framework.ui.component.XstTitledInstructionPanel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.pos.ui.plaf.component.PosTitledInstructionPanelUI;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ActionListView extends AbstractUIView<IMenuModel> implements IActionOwner {
/*  45 */   private static final IEventConstraint listConstraint_ = (IEventConstraint)new NameConstraint(ActionDisplayType.LIST);
/*  46 */   private static final IFormattable INSTRUCTION = FF.getTranslatable("_menuInstruction");
/*  47 */   private static final Logger logger = Logger.getLogger(ActionListView.class);
/*     */   
/*     */   private final XstTitledInstructionPanel actionPanel_;
/*     */   
/*     */   final XstActionList list_;
/*     */   private final Collection<Component> keyStrokeTargets_;
/*     */   
/*  54 */   protected final IEventAware modelChangeHandler_ = (IEventAware)new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/*  58 */         ActionListView.this.handleMenuActions(argEvent);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private ICombinedListModel<Object> listModel_;
/*     */   
/*     */   private ComponentID id_;
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   public ActionListView() {
/*  72 */     this(DtvList.TOUCH_READY_LIST_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionListView(ComponentID argId) {
/*  78 */     IMenuModel model = ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel();
/*  79 */     this.id_ = argId;
/*  80 */     this.list_ = creatActionList(getListModel(), argId);
/*  81 */     this.actionPanel_ = createTitledInstructionPanel(this.list_);
/*     */ 
/*     */ 
/*     */     
/*  85 */     this.keyStrokeTargets_ = Arrays.asList(new Component[] { this.list_.getFocusComponent() });
/*     */     
/*  87 */     setModel(model);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  92 */     return this.actionPanel_.getDisplayComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  97 */     return this.list_.getFocusComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 102 */     return (getDisplayComponent().isEnabled() && getDisplayComponent().isShowing());
/*     */   }
/*     */   
/*     */   protected XstActionList creatActionList(ICombinedListModel<Object> argModel, ComponentID argId) {
/* 106 */     return XstViewComponentFactory.getInstance().createActionList(argModel, argId);
/*     */   }
/*     */   
/*     */   protected XstTitledInstructionPanel createTitledInstructionPanel(XstActionList argList) {
/* 110 */     return XstViewComponentFactory.getInstance().createTitledInstructionPanel((IXstViewComponent)argList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(IMenuModel argModel) {
/* 115 */     this._eventManager.deregisterEventHandler(this.modelChangeHandler_, (IEventSource)argModel);
/* 116 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */   
/*     */   protected Collection<PosTitledInstructionPanelUI.BreadCrumb> getBreadCrumbs(IMenuItem argItem) {
/* 120 */     List<PosTitledInstructionPanelUI.BreadCrumb> crumbs = new ArrayList<>();
/* 121 */     int i = 0;
/* 122 */     IMenuItem item = argItem;
/*     */     while (true) {
/* 124 */       IXstAction backAction = createBreadCrumbAction();
/* 125 */       crumbs.add(0, new BackBreadCrumb(item.getMenuTitle().toString(), i++, (Action)backAction));
/* 126 */       item = item.getParent();
/*     */       
/* 128 */       if (item == null)
/* 129 */         return crumbs; 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void registerEventHandlers(IMenuModel argModel) {
/* 134 */     super.registerEventHandlers(argModel);
/* 135 */     this._eventManager.registerEventHandler(this.modelChangeHandler_, (IEventSource)argModel, listConstraint_);
/*     */   }
/*     */   
/*     */   protected void showView(IUIController argController) {
/* 139 */     argController.showPopupMenu();
/*     */   }
/*     */   
/*     */   ICombinedListModel<Object> getListModel() {
/* 143 */     if (this.listModel_ == null) {
/* 144 */       this.listModel_ = (ICombinedListModel<Object>)new DefaultListInputModel();
/* 145 */       this.listModel_.getSelectionModel().setSelectionMode(0);
/*     */     } 
/* 147 */     return this.listModel_;
/*     */   }
/*     */   
/*     */   void handleMenuActions(Event argEvent) {
/* 151 */     Collection<IXstAction> promptActions = getSupportActions();
/*     */     
/* 153 */     IMenuItem currentMenu = getModel().getCurrentMenu();
/* 154 */     if (currentMenu != null)
/*     */     {
/*     */       
/* 157 */       UIServices.invoke(() -> { if (currentMenu.getParent() == null && currentMenu.getRootTitle() != null && currentMenu.getRootTitle().toString().length() > 0) { this.actionPanel_.setTitle(currentMenu.getRootTitle()); } else { this.actionPanel_.setTitle(currentMenu.getMenuTitle()); }  if (currentMenu.getMenuDescription() != null) { this.actionPanel_.setInstruction(currentMenu.getMenuDescription()); } else { this.actionPanel_.setInstruction(INSTRUCTION); }  if (this.id_.equals(DtvList.TOUCH_READY_BACK_OFFICE_LIST_ID)) if (!currentMenu.isBreadCrumbDisabled()) { this.actionPanel_.setBreadCrumbs(getBreadCrumbs(currentMenu)); } else { this.actionPanel_.setInstruction(currentMenu.getMenuDescription()); this.actionPanel_.setBreadCrumbs(null); }   Collection<IXstAction> actions = (Collection<IXstAction>)argEvent.getBaseEvent().getPayload(); assignDefaultKeyStrokes(actions); assignVisibleActions(actions); registerKeyStrokeToActionMappings(promptActions, actions); }true, true);
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
/* 191 */     ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel().setValues(promptActions, ActionDisplayType.POPUP, 
/*     */ 
/*     */         
/* 194 */         getUIModel(), this.keyStrokeTargets_, null);
/*     */   }
/*     */   
/*     */   private void assignDefaultKeyStrokes(Collection<IXstAction> argActions) {
/* 198 */     int keyCode = 49;
/*     */     
/* 200 */     for (IXstAction action : argActions) {
/* 201 */       if (action.isVisible() && !UIViewUtils.isActionHidden(action)) {
/* 202 */         if (action.getKeyStroke() == null) {
/* 203 */           KeyStroke defaultKeyStroke = KeyStroke.getKeyStroke(keyCode, 0);
/*     */           
/* 205 */           if (keyCode >= 49 && keyCode <= 57) {
/* 206 */             KeyStroke numPad = KeyStroke.getKeyStroke(keyCode + 48, 0);
/* 207 */             action.setKeyStrokes(new KeyStroke[] { defaultKeyStroke, numPad });
/*     */           } else {
/*     */             
/* 210 */             action.setKeyStroke(defaultKeyStroke);
/*     */           } 
/*     */         } 
/*     */         
/* 214 */         if (keyCode == 57) {
/* 215 */           keyCode = 65;
/*     */           continue;
/*     */         } 
/* 218 */         keyCode++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void assignVisibleActions(Collection<IXstAction> actions) {
/* 225 */     List<IXstAction> visibleActions = new ArrayList<>();
/* 226 */     int firstSelectable = -1;
/*     */     
/* 228 */     int fs = 0;
/* 229 */     for (IXstAction action : actions) {
/* 230 */       if (action != null && 
/* 231 */         action.isVisible() && !UIViewUtils.isActionHidden(action)) {
/* 232 */         visibleActions.add(action);
/*     */         
/* 234 */         if (firstSelectable < 0 && action.getVisibility().isViewable()) {
/* 235 */           firstSelectable = fs;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     firstSelectable = Math.max(0, firstSelectable);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     IUIController currentController = ((IModeController)this._modeProvider.get()).getUiController();
/*     */     
/*     */     try {
/* 248 */       getListModel().getSelectionModel().clearSelection();
/* 249 */       getListModel().getModel().setElements(visibleActions);
/* 250 */       showView(currentController);
/*     */       
/* 252 */       if (firstSelectable < visibleActions.size()) {
/* 253 */         int index = firstSelectable;
/* 254 */         UIServices.invoke(() -> {
/*     */               this.list_.getModel().getSelectionModel().setSelectionInterval(index, index);
/*     */               
/*     */               this.list_.getListComponent().ensureIndexIsVisible(index);
/*     */             });
/*     */       } 
/* 260 */     } catch (Exception ex) {
/* 261 */       logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private IXstDataAction createAcceptAction() {
/* 266 */     IXstDataAction enterAction = this._actionFactory.getDataAction(XstDataActionKey.ACCEPT);
/* 267 */     enterAction.setKeyStroke(XstKeyStroke.forName("Enter").getKeyStroke());
/* 268 */     enterAction.setModel(getUIModel());
/* 269 */     enterAction.setVisible(true);
/* 270 */     enterAction.setEnabled(true);
/* 271 */     enterAction.setActionNameKey("_ok");
/*     */     
/* 273 */     return enterAction;
/*     */   }
/*     */   
/*     */   private IXstAction createBreadCrumbAction() {
/* 277 */     IXstDataAction action = this._actionFactory.getDataAction(XstDataActionKey.CANCEL);
/* 278 */     action.setActionNameKey("_previousmenu");
/* 279 */     action.setKeyStroke(XstKeyStroke.forName("escape").getKeyStroke());
/* 280 */     action.setVisible(true);
/*     */     
/* 282 */     return (IXstAction)action;
/*     */   }
/*     */   
/*     */   private Collection<IXstAction> getSupportActions() {
/* 286 */     IStationModel stationModel = ((IModeController)this._modeProvider.get()).getStationModel();
/* 287 */     Collection<IXstAction> actions = new ArrayList<>();
/* 288 */     actions.add(getModel().getBackAction());
/*     */     
/* 290 */     IXstAction helpAction = this._actionFactory.getHelpAction();
/*     */     
/* 292 */     if (helpAction != null) {
/* 293 */       actions.add(helpAction);
/*     */     }
/*     */     
/* 296 */     actions.add(createAcceptAction());
/* 297 */     Collection<IXstAction> appChangeActions = stationModel.getAppChangeActions();
/* 298 */     actions.addAll(appChangeActions);
/*     */     
/* 300 */     return actions;
/*     */   }
/*     */   
/*     */   private IUIInputModel getUIModel() {
/* 304 */     return (IUIInputModel)getListModel();
/*     */   }
/*     */ 
/*     */   
/*     */   private void registerKeyStrokeToActionMappings(Collection<IXstAction> promptActions, Collection<IXstAction> actions) {
/* 309 */     Map<KeyStroke, Action> keyMap = new HashMap<>();
/*     */     
/* 311 */     for (IXstAction action : promptActions) {
/* 312 */       KeyStroke[] strokes = action.getKeyStrokes();
/* 313 */       if (strokes != null) {
/* 314 */         for (KeyStroke stroke : strokes) {
/* 315 */           keyMap.put(stroke, action);
/*     */         }
/*     */       }
/*     */     } 
/* 319 */     for (IXstAction action : actions) {
/* 320 */       KeyStroke[] strokes = action.getKeyStrokes();
/* 321 */       if (strokes != null) {
/* 322 */         for (KeyStroke stroke : strokes) {
/* 323 */           keyMap.put(stroke, action);
/*     */         }
/*     */       }
/*     */     } 
/* 327 */     Collection<KeyActionPair> keyActionPairs = new ArrayList<>();
/* 328 */     Set<Map.Entry<KeyStroke, Action>> keyMapEntries = keyMap.entrySet();
/*     */     
/* 330 */     for (Map.Entry<KeyStroke, Action> entry : keyMapEntries) {
/* 331 */       keyActionPairs.add(new KeyActionPair(entry.getKey(), entry.getValue()));
/*     */     }
/*     */     
/* 334 */     this._keyEventDispatcher.setKeyMappings(this, keyActionPairs, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BackBreadCrumb
/*     */     extends PosTitledInstructionPanelUI.BreadCrumb
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private int backs_;
/*     */     
/*     */     public BackBreadCrumb(String name, int backs, Action action) {
/* 345 */       super(name);
/* 346 */       this.backs_ = backs;
/* 347 */       this.action_ = action;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void actionPerformed(ActionEvent argE) {
/* 353 */       for (int i = 0; i < this.backs_; i++)
/* 354 */         this.action_.actionPerformed(argE); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ActionListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */