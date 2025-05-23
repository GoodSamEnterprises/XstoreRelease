/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*     */ import dtv.pos.framework.ui.component.XstButton;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.vk.KeyClickListener;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
/*     */ import dtv.pos.iframework.ui.model.IActionModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.StringObjectPair;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.event.MouseListener;
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
/*     */ public abstract class AbstractKeypad
/*     */   extends AbstractUIView<IActionModel>
/*     */   implements IActionOwner
/*     */ {
/*     */   @Inject
/*     */   protected IXstActionFactory _actionFactory;
/*     */   private final EventHandler modelChangeHandler_;
/*     */   private JComponent view_;
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   
/*     */   protected static JComponent createButton(ComponentID argComponentId, IXstAction argAction) {
/*  53 */     return createButton(argComponentId, argAction, (String)null);
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
/*     */   protected static JComponent createButton(ComponentID argComponentId, IXstAction argAction, String argIconKey) {
/*  78 */     if (argIconKey != null) {
/*  79 */       argAction.setSmallIcon(UIRM.getImageIcon(argIconKey));
/*  80 */       argAction.setRolloverIcon((UIRM.getImageIcon(argIconKey + "Roll") != null) ? UIRM
/*  81 */           .getImageIcon(argIconKey + "Roll") : UIRM.getImageIcon(argIconKey));
/*  82 */       argAction.setPressedIcon((UIRM.getImageIcon(argIconKey + "Press") != null) ? UIRM
/*  83 */           .getImageIcon(argIconKey + "Press") : UIRM.getImageIcon(argIconKey));
/*  84 */       argAction.setDisabledIcon((UIRM.getImageIcon(argIconKey + "Disabled") != null) ? UIRM
/*  85 */           .getImageIcon(argIconKey + "Disabled") : UIRM.getImageIcon(argIconKey));
/*     */     } 
/*  87 */     XstButton btn = XstViewComponentFactory.getInstance().createButton(argComponentId);
/*  88 */     assignActionTo(argAction, btn.getButton(), false);
/*  89 */     if (ConfigurationMgr.isOnScreenKeyboardKeyClickEnabled()) {
/*  90 */       btn.getButton().addMouseListener((MouseListener)KeyClickListener.getInstance());
/*     */     }
/*  92 */     return btn.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void assignActionTo(IXstAction argAction, DtvButton argButton, boolean argPreserveProps) {
/*  98 */     ComponentPropertySet oldSet = argPreserveProps ? new ComponentPropertySet(argButton.getPropertySet().getAll()) : null;
/*     */     
/* 100 */     argButton.setAction((Action)argAction);
/* 101 */     argButton.setText(argButton.getKeyStrokeText());
/* 102 */     argButton.setKeyStrokeText(MutableString.EMPTY);
/*     */     
/* 104 */     if (oldSet != null) {
/* 105 */       argButton.getPropertySet().putAll(oldSet);
/*     */     }
/*     */     
/* 108 */     Object foregroundProp = argAction.getPropertySet().get("foreground");
/*     */     
/* 110 */     if (foregroundProp != null) {
/* 111 */       argButton.getPropertySet().put(new StringObjectPair("foreground", foregroundProp));
/*     */     }
/*     */     
/* 114 */     Object foregroundPressedProp = argAction.getPropertySet().get("foregroundPressed");
/*     */     
/* 116 */     if (foregroundPressedProp != null) {
/* 117 */       argButton.getPropertySet()
/* 118 */         .put(new StringObjectPair("foregroundPressed", foregroundPressedProp));
/*     */     }
/*     */     
/* 121 */     Object foregroundRolloverProp = argAction.getPropertySet().get("foregroundRollover");
/*     */     
/* 123 */     if (foregroundRolloverProp != null) {
/* 124 */       argButton.getPropertySet()
/* 125 */         .put(new StringObjectPair("foregroundRollover", foregroundRolloverProp));
/*     */     }
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
/*     */   public AbstractKeypad() {
/* 145 */     IPromptActionModel actionModel = ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel();
/* 146 */     this.modelChangeHandler_ = new EventHandler()
/*     */       {
/*     */         protected void handle(Event argEvent) {
/* 149 */           AbstractKeypad.this.handleModelChange(argEvent);
/*     */         }
/*     */       };
/* 152 */     setModel((IActionModel)actionModel);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 157 */     return getView();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 162 */     return getView();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 167 */     return (getDisplayComponent().isEnabled() && getDisplayComponent().isShowing());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IXstAction createKeyAction(char argKeyStrokeChar) {
/* 177 */     KeyStroke key = KeyStroke.getKeyStroke(argKeyStrokeChar);
/* 178 */     XstKeyStroke xstKeyStroke = XstKeyStroke.forKeyStroke(key);
/*     */     
/* 180 */     return (IXstAction)this._actionFactory.getKeyStrokeAction((IXstKeyStroke)xstKeyStroke);
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
/*     */   protected IXstAction createKeyAction(String argKeyStrokeName, boolean argTyped) {
/* 192 */     String keyString = (argTyped ? "typed " : "") + argKeyStrokeName;
/* 193 */     XstKeyStroke xstKeyStroke = XstKeyStroke.forName(keyString);
/*     */     
/* 195 */     return (IXstAction)this._actionFactory.getKeyStrokeAction((IXstKeyStroke)xstKeyStroke);
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
/*     */   protected void deregisterEventHandlers(IActionModel argModel) {
/* 208 */     this._eventManager.deregisterEventHandler((IEventAware)this.modelChangeHandler_, (IEventSource)argModel);
/* 209 */     super.deregisterEventHandlers(argModel);
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
/*     */   protected Collection<IXstAction> getActions() {
/* 231 */     Collection<IXstAction> actions = new ArrayList<>();
/*     */     
/* 233 */     for (JComponent c : getActionComponents()) {
/*     */ 
/*     */       
/* 236 */       if (c instanceof DtvButton) {
/* 237 */         actions.add((IXstAction)((DtvButton)c).getAction());
/*     */       }
/*     */     } 
/* 240 */     return actions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final JComponent getView() {
/* 250 */     if (this.view_ == null) {
/* 251 */       this.view_ = createView();
/*     */     }
/* 253 */     return this.view_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleModelChange(Event argEvent) {
/* 259 */     Collection<IXstAction> newActions = (Collection<IXstAction>)argEvent.getBaseEvent().getPayload();
/* 260 */     Collection<JComponent> actionComponents = getActionComponents();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     final List<CompositeObject.TwoPiece<IXstAction, DtvButton>> changes = new ArrayList<>();
/* 267 */     if (newActions != null) {
/* 268 */       for (IXstAction newAction : newActions) {
/* 269 */         KeyStroke newKeyStroke = newAction.getKeyStroke();
/*     */         
/* 271 */         if (newKeyStroke != null)
/*     */         {
/* 273 */           for (JComponent c : actionComponents) {
/*     */ 
/*     */             
/* 276 */             if (c instanceof DtvButton) {
/* 277 */               DtvButton btn = (DtvButton)c;
/* 278 */               IXstAction curAction = (IXstAction)btn.getAction();
/*     */               
/* 280 */               if (curAction != null) {
/*     */ 
/*     */ 
/*     */                 
/* 284 */                 KeyStroke curKeyStroke = curAction.getKeyStroke();
/* 285 */                 if (newKeyStroke.equals(curKeyStroke)) {
/* 286 */                   changes.add(CompositeObject.make(newAction, btn));
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 296 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 299 */             for (CompositeObject.TwoPiece<IXstAction, DtvButton> change : (Iterable<CompositeObject.TwoPiece<IXstAction, DtvButton>>)changes) {
/* 300 */               IXstAction newAction = (IXstAction)change.a();
/* 301 */               DtvButton btn = (DtvButton)change.b();
/* 302 */               AbstractKeypad.assignActionTo(newAction, btn, true);
/*     */             } 
/*     */           }
/*     */         }true, true);
/* 306 */     registerActions();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerActions() {
/* 314 */     this._keyEventDispatcher.setActionMappings(this, getActions(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(IActionModel argModel) {
/* 319 */     super.registerEventHandlers(argModel);
/* 320 */     this._eventManager.registerEventHandler((IEventAware)this.modelChangeHandler_, (IEventSource)argModel);
/*     */   }
/*     */   
/*     */   protected abstract JComponent createView();
/*     */   
/*     */   protected abstract Collection<JComponent> getActionComponents();
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AbstractKeypad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */