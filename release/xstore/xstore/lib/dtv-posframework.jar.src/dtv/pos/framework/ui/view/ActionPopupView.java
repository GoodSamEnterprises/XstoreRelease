/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
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
/*     */ import dtv.pos.ui.component.PosButtonView;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JComponent;
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
/*     */ public final class ActionPopupView
/*     */   extends AbstractUIView<IPromptActionModel>
/*     */   implements IActionOwner
/*     */ {
/*  55 */   private static final IEventConstraint _popupConstraint = (IEventConstraint)new NameConstraint(ActionDisplayType.POPUP);
/*     */   private IXstAction _helpAction;
/*     */   
/*  58 */   private final Comparator<IXstAction> _actionSorter = new Comparator<IXstAction>()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int compare(IXstAction argO1, IXstAction argO2)
/*     */       {
/*  66 */         if (isEscapeKey(argO1)) {
/*  67 */           return -1;
/*     */         }
/*  69 */         if (isEscapeKey(argO2)) {
/*  70 */           return 1;
/*     */         }
/*     */         
/*  73 */         if (isHelpKey(argO1)) {
/*  74 */           return -1;
/*     */         }
/*  76 */         if (isHelpKey(argO2)) {
/*  77 */           return 1;
/*     */         }
/*  79 */         if (isFunctionKey(argO1) && isFunctionKey(argO2))
/*     */         {
/*  81 */           return argO1.getKeyStroke().getKeyCode() - argO1.getKeyStroke().getKeyCode();
/*     */         }
/*     */         
/*  84 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       private boolean isEscapeKey(IXstAction argAction) {
/*  89 */         boolean escapeKey = false;
/*  90 */         if (argAction.getKeyStroke() != null) {
/*  91 */           escapeKey = (argAction.getKeyStroke().getKeyCode() == 27);
/*     */         }
/*  93 */         return escapeKey;
/*     */       }
/*     */       
/*     */       private boolean isFunctionKey(IXstAction argAction) {
/*  97 */         boolean functionKey = false;
/*     */         
/*  99 */         if (argAction.getKeyStroke() != null) {
/* 100 */           int keyCode = argAction.getKeyStroke().getKeyCode();
/* 101 */           functionKey = ((keyCode >= 112 && keyCode <= 123) || (keyCode >= 61440 && keyCode <= 61451));
/*     */         } 
/*     */         
/* 104 */         return functionKey;
/*     */       }
/*     */       
/*     */       private boolean isHelpKey(IXstAction argAction) {
/* 108 */         return (ActionPopupView.this._helpAction != null && ActionPopupView.this._helpAction.getActionKey().equals(argAction.getActionKey()));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   private final PosButtonView _view;
/*     */   
/* 119 */   private final IEventAware _modelChangeHandler = (IEventAware)new EventHandler()
/*     */     {
/*     */       
/*     */       protected void handle(Event argEvent)
/*     */       {
/* 124 */         final List<IXstAction> actions = new ArrayList<>((Collection<? extends IXstAction>)argEvent.getBaseEvent().getPayload());
/* 125 */         final List<DtvButton> buttonList = new ArrayList<>(actions.size());
/*     */ 
/*     */         
/* 128 */         Collections.sort(actions, ActionPopupView.this._actionSorter);
/*     */ 
/*     */ 
/*     */         
/* 132 */         UIServices.invoke(new Runnable()
/*     */             {
/*     */               public void run()
/*     */               {
/* 136 */                 for (IXstAction action : actions) {
/* 137 */                   if (action != null && action.isVisible() && !UIViewUtils.isActionHidden(action)) {
/* 138 */                     XstButton button = XstViewComponentFactory.getInstance().createButton(action);
/* 139 */                     buttonList.add(button.getButton());
/*     */                   } 
/*     */                 } 
/* 142 */                 ActionPopupView.this.getView().setButtons(buttonList);
/*     */               }
/*     */             },  true, true);
/*     */         
/* 146 */         ActionPopupView.this._keyEventDispatcher.setActionMappings(ActionPopupView.this, actions, true);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionPopupView() {
/* 155 */     this._helpAction = this._actionFactory.getHelpAction();
/* 156 */     IPromptActionModel actionModel = ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel();
/* 157 */     this._view = PosComponentFactory.getInstance().createButtonView();
/* 158 */     setModel(actionModel);
/*     */     
/* 160 */     IMenuModel menuModel = ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel();
/* 161 */     this._eventManager.registerEventHandler(this._modelChangeHandler, (IEventSource)menuModel, _popupConstraint);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 166 */     return (JComponent)getView();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 171 */     return (JComponent)getView();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 176 */     return (getDisplayComponent().isEnabled() && getDisplayComponent().isShowing());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(IPromptActionModel argModel) {
/* 181 */     this._eventManager.deregisterEventHandler(this._modelChangeHandler, (IEventSource)argModel);
/* 182 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(IPromptActionModel argModel) {
/* 187 */     super.registerEventHandlers(argModel);
/* 188 */     this._eventManager.registerEventHandler(this._modelChangeHandler, (IEventSource)argModel, _popupConstraint);
/*     */   }
/*     */   
/*     */   PosButtonView getView() {
/* 192 */     return this._view;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ActionPopupView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */