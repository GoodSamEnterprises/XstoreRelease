/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.Constraints;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*     */ import dtv.pos.framework.ui.component.XstButton;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.ui.component.PosButtonView;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public class ActionButtonView
/*     */   extends AbstractUIView<IMenuModel>
/*     */   implements IActionOwner
/*     */ {
/*  95 */   private static final IEventConstraint buttonConstraint_ = (IEventConstraint)new NameConstraint(ActionDisplayType.BUTTON);
/*  96 */   private static final IEventConstraint buttonExConstraint_ = (IEventConstraint)new NameConstraint(ActionDisplayType.BUTTON_EXCLUSIVE);
/*     */ 
/*     */   
/*  99 */   private static final IEventConstraint buttonComboConstraint_ = Constraints.or(new IEventConstraint[] { buttonConstraint_, buttonExConstraint_ });
/*     */   
/*     */   final ActionAssignmentHelper helper_;
/*     */   
/*     */   final XstButton[] buttons_;
/*     */   
/*     */   protected final PosButtonView view_;
/*     */   
/*     */   private final IXstAction moreAction_;
/*     */   
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/* 116 */   private final IEventAware menuActionHandler_ = (IEventAware)new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/* 120 */         ActionButtonView.this.handleMenuActions(argEvent);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 125 */   private final IEventAware promptActionHandler_ = (IEventAware)new EventHandler()
/*     */     {
/*     */       
/*     */       protected void handle(Event argEvent)
/*     */       {
/* 130 */         Collection<IXstAction> newActions = (Collection<IXstAction>)argEvent.getBaseEvent().getPayload();
/*     */         
/* 132 */         Collection<Collection<IXstAction>> newActionSets = new ArrayList<>();
/* 133 */         newActionSets.add(ActionButtonView.this.helper_.getCurrentActions());
/* 134 */         newActionSets.add(newActions);
/*     */         
/* 136 */         ActionButtonView.this.initializeNewActions(newActionSets);
/*     */       }
/*     */     };
/* 139 */   private final IEventAware promptExclusiveActionHandler_ = (IEventAware)new EventHandler()
/*     */     {
/*     */       
/*     */       protected void handle(Event argEvent)
/*     */       {
/* 144 */         List<IXstAction> newActions = (List<IXstAction>)argEvent.getBaseEvent().getPayload();
/*     */         
/* 146 */         Collection<Collection<IXstAction>> newActionSets = new ArrayList<>();
/* 147 */         newActionSets.add(ActionButtonView.this.getSupportActions());
/* 148 */         newActionSets.add(newActions);
/*     */         
/* 150 */         ActionButtonView.this.initializeNewActions(newActionSets);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean moreActionRequired_;
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionButtonView() {
/* 161 */     IMenuModel menuModel = ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel();
/* 162 */     this.view_ = PosComponentFactory.getInstance().createButtonView();
/*     */     
/* 164 */     this.helper_ = new ActionAssignmentHelper();
/* 165 */     this.buttons_ = new XstButton[getButtonCount()];
/*     */     
/* 167 */     this.moreAction_ = createMoreAction();
/* 168 */     this.moreActionRequired_ = false;
/*     */     
/* 170 */     init();
/* 171 */     setModel(menuModel);
/*     */ 
/*     */ 
/*     */     
/* 175 */     IPromptActionModel promptActionModel = ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel();
/*     */     
/* 177 */     this._eventManager.registerEventHandler(this.promptActionHandler_, (IEventSource)promptActionModel, buttonConstraint_);
/* 178 */     this._eventManager.registerEventHandler(this.promptExclusiveActionHandler_, (IEventSource)promptActionModel, buttonExConstraint_);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 183 */     return (JComponent)getView();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 188 */     return (JComponent)getView();
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
/*     */   public boolean isEnabled() {
/* 200 */     return (getDisplayComponent().isEnabled() && getDisplayComponent().isShowing());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(IMenuModel argModel) {
/* 205 */     this._eventManager.deregisterEventHandler(this.menuActionHandler_, (IEventSource)argModel);
/* 206 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */   
/*     */   protected int getButtonCount() {
/* 210 */     return Math.min(ConfigurationMgr.getMenuButtonCount(), 25);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IXstAction> getSupportActions() {
/* 218 */     IStationModel stationModel = ((IModeController)this._modeProvider.get()).getStationModel();
/*     */ 
/*     */     
/* 221 */     List<IXstAction> actions = new ArrayList<>();
/* 222 */     actions.add(getModel().getBackAction());
/*     */     
/* 224 */     IXstAction helpAction = this._actionFactory.getHelpAction();
/*     */     
/* 226 */     if (helpAction != null) {
/* 227 */       actions.add(helpAction);
/*     */     }
/*     */     
/* 230 */     Collection<IXstAction> appChangeActions = stationModel.getAppChangeActions();
/* 231 */     if (appChangeActions != null) {
/* 232 */       for (IXstAction action : appChangeActions) {
/* 233 */         actions.add(action);
/*     */       }
/*     */     }
/*     */     
/* 237 */     return actions;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(IMenuModel argModel) {
/* 242 */     super.registerEventHandlers(argModel);
/* 243 */     this._eventManager.registerEventHandler(this.menuActionHandler_, (IEventSource)argModel, buttonComboConstraint_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void handleMenuActions(Event argEvent) {
/* 251 */     Collection<Collection<IXstAction>> newActionSets = new ArrayList<>();
/*     */     
/* 253 */     List<IXstAction> newActions = getSupportActions();
/* 254 */     if (newActions != null && !newActions.isEmpty()) {
/* 255 */       newActionSets.add(newActions);
/*     */     }
/* 257 */     newActions = (List<IXstAction>)argEvent.getBaseEvent().getPayload();
/* 258 */     if (newActions != null && !newActions.isEmpty()) {
/* 259 */       newActionSets.add(newActions);
/*     */     }
/* 261 */     initializeNewActions(newActionSets);
/*     */   }
/*     */   
/*     */   void initializeNewActions(Collection<Collection<IXstAction>> newActionSets) {
/* 265 */     this.helper_.clear();
/* 266 */     this.moreActionRequired_ = false;
/*     */ 
/*     */     
/* 269 */     for (Collection<IXstAction> actions : newActionSets) {
/* 270 */       for (IXstAction action : actions) {
/* 271 */         this.helper_.addAction(action);
/*     */       }
/*     */     } 
/*     */     
/* 275 */     updateButtons();
/*     */   }
/*     */   
/*     */   void updateButtons() {
/* 279 */     final boolean enableButtonComponents = isEnabled();
/* 280 */     final IXstAction[] candidateActions = new IXstAction[this.buttons_.length];
/*     */     
/* 282 */     for (int i = 0; i < this.buttons_.length; i++) {
/* 283 */       candidateActions[i] = this.helper_.getAction(this.buttons_[i].getKeyStroke());
/*     */     }
/*     */     
/* 286 */     if (this.moreActionRequired_ || this.helper_.anyMoreWaiting()) {
/* 287 */       assignMoreAction(candidateActions);
/*     */     }
/*     */     
/* 290 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 293 */             for (int i = 0; i < ActionButtonView.this.buttons_.length; i++) {
/* 294 */               if (enableButtonComponents)
/*     */               {
/*     */ 
/*     */                 
/* 298 */                 ActionButtonView.this.buttons_[i].setEnabled(true);
/*     */               }
/* 300 */               ActionButtonView.this.buttons_[i].setAction((Action)candidateActions[i]);
/*     */             } 
/*     */           }
/*     */         }true, true);
/* 304 */     this.helper_.registerKeyStrokeToActionMappings();
/*     */   }
/*     */   
/*     */   private void assignMoreAction(IXstAction[] candidateActions) {
/* 308 */     int moreActionIndex = candidateActions.length - 1;
/*     */     
/* 310 */     for (int i = candidateActions.length - 1; i >= 0; i--) {
/* 311 */       IXstAction action = candidateActions[i];
/*     */       
/* 313 */       if (action == null || action.getKeyStroke() == null) {
/* 314 */         this.moreActionRequired_ = true;
/* 315 */         moreActionIndex = i;
/*     */         
/* 317 */         if (action != null) {
/* 318 */           this.helper_.previousAction();
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/* 323 */     candidateActions[moreActionIndex] = this.moreAction_;
/*     */   }
/*     */   
/*     */   private IXstAction createMoreAction() {
/* 327 */     IXstAction action = this._actionFactory.getMoreAction();
/*     */     
/* 329 */     action.setActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent event) {
/* 332 */             ActionButtonView.this.helper_.initNewView();
/* 333 */             ActionButtonView.this.updateButtons();
/*     */           }
/*     */         });
/*     */     
/* 337 */     return action;
/*     */   }
/*     */   
/*     */   private PosButtonView getView() {
/* 341 */     return this.view_;
/*     */   }
/*     */   
/*     */   private void init() {
/* 345 */     KeyStroke escape = XstKeyStroke.forName("escape").getKeyStroke();
/* 346 */     this.buttons_[0] = XstViewComponentFactory.getInstance().createButton(escape);
/*     */     
/* 348 */     for (int i = 1; i < this.buttons_.length; i++) {
/* 349 */       KeyStroke fkey = XstKeyStroke.forName("f" + i).getKeyStroke();
/* 350 */       this.buttons_[i] = XstViewComponentFactory.getInstance().createButton(fkey);
/*     */     } 
/*     */ 
/*     */     
/* 354 */     Collection<DtvButton> buttonComponents = Collections.checkedCollection(new ArrayList<>(), DtvButton.class);
/*     */     
/* 356 */     for (XstButton element : this.buttons_) {
/* 357 */       buttonComponents.add((DtvButton)element.getDisplayComponent());
/*     */     }
/* 359 */     getView().setButtons(buttonComponents);
/*     */   }
/*     */   
/*     */   private class ActionAssignmentHelper {
/* 363 */     private final Map<KeyStroke, IXstAction> keyToActionMap_ = new HashMap<>();
/* 364 */     private final List<IXstAction> waitingPool_ = new ArrayList<>();
/*     */     private ListIterator<IXstAction> waitingIter_;
/*     */     
/*     */     public void addAction(IXstAction argAction) {
/* 368 */       if (argAction == null) {
/*     */         return;
/*     */       }
/*     */       
/* 372 */       IXstAction action = argAction;
/*     */       
/* 374 */       if (UIViewUtils.isActionHidden(argAction)) {
/* 375 */         action = ActionButtonView.this._actionFactory.getEmptyAction();
/* 376 */         action.setKeyStroke(argAction.getKeyStroke());
/*     */       } 
/*     */       
/* 379 */       KeyStroke keyStroke = action.getKeyStroke();
/*     */       
/* 381 */       if (keyStroke != null) {
/* 382 */         this.keyToActionMap_.put(keyStroke, action);
/*     */       }
/* 384 */       else if (action.isVisible()) {
/* 385 */         this.waitingPool_.add(action);
/* 386 */         resetWaitingIterator();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean anyMoreWaiting() {
/* 392 */       while (getWaitingIterator().hasNext() && 
/* 393 */         !((IXstAction)this.waitingPool_.get(getWaitingIterator().nextIndex())).isVisible()) {
/* 394 */         getWaitingIterator().next();
/*     */       }
/*     */       
/* 397 */       return getWaitingIterator().hasNext();
/*     */     }
/*     */     
/*     */     public void clear() {
/* 401 */       this.waitingIter_ = null;
/* 402 */       this.waitingPool_.clear();
/* 403 */       this.keyToActionMap_.clear();
/*     */     }
/*     */     
/*     */     public IXstAction getAction(KeyStroke keyStroke) {
/* 407 */       IXstAction action = this.keyToActionMap_.get(keyStroke);
/* 408 */       if (action == null) {
/* 409 */         action = getNextWaiting();
/*     */       }
/* 411 */       else if (!action.isVisible()) {
/* 412 */         action = null;
/*     */       } 
/* 414 */       return action;
/*     */     }
/*     */     
/*     */     public List<IXstAction> getCurrentActions() {
/* 418 */       List<IXstAction> currentActions = new ArrayList<>(this.waitingPool_);
/* 419 */       currentActions.addAll(this.keyToActionMap_.values());
/* 420 */       return currentActions;
/*     */     }
/*     */     
/*     */     public void initNewView() {
/* 424 */       if (!anyMoreWaiting()) {
/* 425 */         resetWaitingIterator();
/*     */       }
/*     */     }
/*     */     
/*     */     public void previousAction() {
/* 430 */       getWaitingIterator().previous();
/*     */     }
/*     */ 
/*     */     
/*     */     public void registerKeyStrokeToActionMappings() {
/* 435 */       Map<KeyStroke, IDtvAction> keyMap = (Map)new HashMap<>(this.keyToActionMap_);
/* 436 */       for (XstButton button : ActionButtonView.this.buttons_) {
/* 437 */         IDtvAction action = (IDtvAction)button.getAction();
/* 438 */         if (action != null) {
/* 439 */           KeyStroke[] strokes = action.getKeyStrokes();
/* 440 */           if (strokes != null && strokes.length > 0) {
/* 441 */             for (KeyStroke stroke : strokes) {
/* 442 */               keyMap.put(stroke, action);
/*     */             }
/*     */           } else {
/*     */             
/* 446 */             KeyStroke buttonKeyStroke = button.getKeyStroke();
/* 447 */             if (buttonKeyStroke != null) {
/* 448 */               keyMap.put(buttonKeyStroke, action);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 455 */       Collection<KeyActionPair> keyActionPairs = new ArrayList<>(keyMap.size());
/* 456 */       for (Map.Entry<KeyStroke, IDtvAction> entry : keyMap.entrySet()) {
/* 457 */         keyActionPairs.add(new KeyActionPair(entry.getKey(), (Action)entry.getValue()));
/*     */       }
/* 459 */       ActionButtonView.this._keyEventDispatcher.setKeyMappings(ActionButtonView.this, keyActionPairs, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 464 */       StringBuffer text = new StringBuffer();
/*     */       
/* 466 */       text.append("\nMAPPINGS:\n");
/* 467 */       Set<Map.Entry<KeyStroke, IXstAction>> entries = this.keyToActionMap_.entrySet();
/*     */       
/* 469 */       for (Map.Entry<KeyStroke, IXstAction> entry : entries) {
/* 470 */         text.append("     ");
/* 471 */         text.append(entry.getKey());
/* 472 */         text.append(" = ");
/*     */         
/* 474 */         IXstAction action = entry.getValue();
/* 475 */         String prefix = action.isVisible() ? "V" : "I";
/* 476 */         text.append(prefix);
/* 477 */         text.append("_");
/* 478 */         text.append(action.getName());
/* 479 */         text.append("\n");
/*     */       } 
/* 481 */       text.append("WAITING:\n");
/*     */       
/* 483 */       for (int i = getWaitingIterator().nextIndex(); i < this.waitingPool_.size(); i++) {
/* 484 */         IXstAction action = this.waitingPool_.get(i);
/*     */         
/* 486 */         String prefix = action.isVisible() ? "V" : "I";
/* 487 */         text.append(prefix);
/* 488 */         text.append("_");
/* 489 */         text.append(action.getName());
/* 490 */         text.append("||");
/*     */       } 
/* 492 */       return text.toString();
/*     */     }
/*     */     
/*     */     private IXstAction getNextWaiting() {
/* 496 */       if (!anyMoreWaiting()) {
/* 497 */         return null;
/*     */       }
/* 499 */       return getWaitingIterator().next();
/*     */     }
/*     */     
/*     */     private ListIterator<IXstAction> getWaitingIterator() {
/* 503 */       if (this.waitingIter_ == null) {
/* 504 */         resetWaitingIterator();
/*     */       }
/* 506 */       return this.waitingIter_;
/*     */     }
/*     */     
/*     */     private void resetWaitingIterator() {
/* 510 */       this.waitingIter_ = this.waitingPool_.listIterator();
/*     */     }
/*     */     
/*     */     private ActionAssignmentHelper() {}
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ActionButtonView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */