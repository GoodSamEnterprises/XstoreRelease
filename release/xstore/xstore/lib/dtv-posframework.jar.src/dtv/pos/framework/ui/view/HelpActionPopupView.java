/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.framework.action.XstDataAction;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionType;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*     */ import dtv.pos.framework.ui.component.XstButton;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.ui.model.IHelpModel;
/*     */ import dtv.pos.ui.component.PosButtonView;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ public final class HelpActionPopupView
/*     */   extends AbstractUIView<IHelpModel>
/*     */   implements IActionOwner
/*     */ {
/*     */   private final PosButtonView _view;
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   
/*     */   protected static IXstAction createAuxiliaryAction(IXstEventListener argEventListener, IHelpModel.HelpState argHelpState) {
/*  58 */     XstDataAction xstDataAction = new XstDataAction(XstDataActionType.STANDARD, argHelpState.getActionKey());
/*     */     
/*  60 */     xstDataAction.setEventListener(argEventListener);
/*  61 */     xstDataAction.setVisible(true);
/*  62 */     xstDataAction.setEnabled(true);
/*  63 */     xstDataAction.setKeyStroke(XstKeyStroke.forName("F8").getKeyStroke());
/*  64 */     xstDataAction.setActionNameKey(argHelpState.getName());
/*     */     
/*  66 */     return (IXstAction)xstDataAction;
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
/*     */   protected static IXstAction createCloseAction(IXstEventListener argCloseListener) {
/*  78 */     XstDataAction xstDataAction = new XstDataAction(XstDataActionType.STANDARD, XstDataActionKey.ACCEPT);
/*     */     
/*  80 */     xstDataAction.setEventListener(argCloseListener);
/*  81 */     xstDataAction.setVisible(true);
/*  82 */     xstDataAction.setEnabled(true);
/*  83 */     xstDataAction.setKeyStroke(XstKeyStroke.forName("Escape").getKeyStroke());
/*  84 */     xstDataAction.setActionNameKey("_helpDone");
/*     */     
/*  86 */     return (IXstAction)xstDataAction;
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
/*     */   public HelpActionPopupView() {
/*  99 */     IHelpModel model = ((IModeController)this._modeProvider.get()).getStationModel().getHelpModel();
/* 100 */     this._view = PosComponentFactory.getInstance().createButtonView();
/* 101 */     this._view.putClientProperty("COMPONENT_WRAPPER", this);
/*     */     
/* 103 */     setModel(model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 109 */     return (JComponent)this._view;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 115 */     return (JComponent)this._view;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 121 */     return (getDisplayComponent().isEnabled() && getDisplayComponent().isShowing());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateView(IXstEventListener argEventListener) {
/* 131 */     Collection<IXstAction> helpActions = new ArrayList<>();
/*     */ 
/*     */     
/* 134 */     helpActions.add(createCloseAction(argEventListener));
/*     */ 
/*     */     
/* 137 */     for (IHelpModel.HelpState transition : getModel().getHelpState().getTransitions()) {
/* 138 */       IXstAction transitionAction = createAuxiliaryAction(argEventListener, transition);
/* 139 */       helpActions.add(transitionAction);
/*     */     } 
/*     */     
/* 142 */     helpActions.addAll(getModel().getHelpActions());
/*     */     
/* 144 */     setActions(helpActions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerActionKeyStrokes(Collection<? extends IXstAction> argActions) {
/* 152 */     Collection<KeyActionPair> keyActionPairs = new ArrayList<>();
/*     */     
/* 154 */     for (IXstAction action : argActions) {
/* 155 */       if (action != null) {
/* 156 */         KeyStroke[] strokes = action.getKeyStrokes();
/*     */         
/* 158 */         if (strokes != null) {
/* 159 */           for (KeyStroke stroke : strokes) {
/* 160 */             keyActionPairs.add(new KeyActionPair(stroke, (Action)action));
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     this._keyEventDispatcher.setKeyMappings(this, keyActionPairs, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setActions(Collection<? extends IXstAction> argActions) {
/* 174 */     List<DtvButton> buttonList = new ArrayList<>();
/*     */     
/* 176 */     for (IXstAction action : argActions) {
/* 177 */       if (action.isVisible()) {
/* 178 */         XstButton button = XstViewComponentFactory.getInstance().createButton(action);
/* 179 */         button.setEnabled(true);
/* 180 */         buttonList.add(button.getButton());
/* 181 */         button.setAction((Action)action);
/*     */       } 
/*     */     } 
/* 184 */     this._view.setButtons(buttonList);
/*     */     
/* 186 */     registerActionKeyStrokes(argActions);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\HelpActionPopupView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */