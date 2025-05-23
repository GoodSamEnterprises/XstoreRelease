/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.ui.IDialogOwner;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.AppIconHelper;
/*     */ import dtv.pos.ui.component.PosTransparentPanel;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JDialog;
/*     */ 
/*     */ public class DialogView
/*     */   implements IActionOwner
/*     */ {
/*  39 */   private static final Collection<IDtvAction> noActions_ = Collections.emptyList();
/*     */ 
/*     */   
/*     */   final IDialogOwner owner_;
/*     */ 
/*     */   
/*     */   private final IXstViewComponent content_;
/*     */ 
/*     */   
/*     */   private final Frame parent_;
/*     */   
/*     */   private final String title_;
/*     */   
/*     */   private final Window dialog_;
/*     */   
/*     */   private final Collection<? extends IDtvAction> actions_;
/*     */   
/*     */   boolean enabled_;
/*     */   
/*     */   @Inject
/*     */   private XstKeyEventDispatcher _keyEventDispatcher;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public DialogView(IDialogOwner argOwner, IXstViewComponent argContent, Frame argParent, boolean argModal) {
/*  66 */     this(argOwner, argContent, argParent, null, null, argModal, false);
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
/*     */   public DialogView(IDialogOwner argOwner, IXstViewComponent argContent, Frame argParent, Collection<IDtvAction> argActions, boolean argModal) {
/*  81 */     this(argOwner, argContent, argParent, null, argActions, argModal, false);
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
/*     */   public DialogView(IDialogOwner argOwner, IXstViewComponent argContent, Frame argParent, String argTitle, boolean argModal) {
/*  96 */     this(argOwner, argContent, argParent, argTitle, null, argModal, false);
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
/*     */   public DialogView(IDialogOwner argOwner, IXstViewComponent argContent, Frame argParent, String argTitle, Collection<? extends IDtvAction> argActions, boolean argModal, boolean argDecorated) {
/* 113 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/* 115 */     this.owner_ = argOwner;
/* 116 */     this.content_ = argContent;
/* 117 */     this.parent_ = argParent;
/* 118 */     this.title_ = argTitle;
/*     */ 
/*     */ 
/*     */     
/* 122 */     this.actions_ = (argActions == null) ? noActions_ : argActions;
/*     */ 
/*     */     
/* 125 */     this.dialog_ = createDialog(this.content_, this.parent_, this.title_, this.actions_, argModal, argDecorated);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.dialog_.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosed(WindowEvent argEvent)
/*     */           {
/* 137 */             DialogView.this.enabled_ = false;
/* 138 */             DialogView.this.owner_.handleDialogClose();
/*     */           }
/*     */         });
/* 141 */     this.enabled_ = false;
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.dialog_.pack();
/* 146 */     this.content_.getFocusComponent().requestFocusInWindow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Window getDialog() {
/* 154 */     return this.dialog_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 162 */     this._keyEventDispatcher.removeKeyMappings(this);
/*     */ 
/*     */     
/* 165 */     this.dialog_.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 171 */     return this.enabled_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void show() {
/* 179 */     this._keyEventDispatcher.setActionMappings(this, this.actions_, true);
/*     */     
/* 181 */     this.enabled_ = true;
/*     */     
/* 183 */     this.dialog_.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Window createDialog(IXstViewComponent argContent, Frame argParent, String argTitle, Collection<? extends IDtvAction> argActions, boolean argModal, boolean argDecorated) {
/* 193 */     DtvPanel buttonPanel = new DtvPanel(DtvPanel.TRANSPARENT_ID);
/* 194 */     buttonPanel.setLayout(new FlowLayout(1, 3, 0));
/* 195 */     Dimension buttonSize = UIResourceManager.getInstance().getDimension("_sizeDialogButton");
/*     */     
/* 197 */     for (IDtvAction action : argActions) {
/* 198 */       DtvButton btn = new DtvButton((Action)action);
/* 199 */       btn.setPreferredSize(buttonSize);
/* 200 */       buttonPanel.add((Component)btn);
/*     */     } 
/*     */     
/* 203 */     DtvPanel contentPanel = new DtvPanel(DtvPanel.DROP3_ID);
/* 204 */     contentPanel.setLayout(new BorderLayout(0, 5));
/* 205 */     contentPanel.add(argContent.getDisplayComponent(), "Center");
/* 206 */     contentPanel.add((Component)buttonPanel, "South");
/* 207 */     contentPanel.setOpaque(true);
/*     */     
/* 209 */     DtvPanel backgroundPanel = new DtvPanel(DtvPanel.INSET_ID);
/* 210 */     backgroundPanel.setLayout(new BorderLayout());
/* 211 */     backgroundPanel.add((Component)contentPanel, "Center");
/* 212 */     backgroundPanel.setBorder(BorderFactory.createLineBorder(new Color(42, 38, 29)));
/* 213 */     backgroundPanel.setBackground(Color.WHITE);
/*     */     
/* 215 */     JDialog dialog = new JDialog(argParent, argTitle, argModal);
/* 216 */     dialog.setUndecorated(!argDecorated);
/* 217 */     dialog.setDefaultCloseOperation(2);
/*     */     
/* 219 */     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/* 220 */     GraphicsDevice gd = ge.getDefaultScreenDevice();
/*     */     
/* 222 */     if (!argDecorated && gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
/* 223 */       PosTransparentPanel smokinBg = new PosTransparentPanel();
/* 224 */       smokinBg.setSize(UIServices.getScreenBounds().getSize());
/* 225 */       smokinBg.setPreferredSize(UIServices.getScreenBounds().getSize());
/* 226 */       smokinBg.setLayout(null);
/* 227 */       smokinBg.add((Component)backgroundPanel);
/* 228 */       backgroundPanel.setSize(backgroundPanel.getPreferredSize());
/*     */ 
/*     */       
/* 231 */       Component c = ((IModeController)this._modeProvider.get()).getUiController().getNamedComponent("FOCUS_BAR_MESSAGE_AREA");
/* 232 */       int y = c.getY() + c.getHeight() / 2 - backgroundPanel.getHeight() / 2;
/* 233 */       UIServices.centerComponent((Component)backgroundPanel, (Component)smokinBg);
/* 234 */       backgroundPanel.setLocation(backgroundPanel.getX(), y);
/*     */       
/* 236 */       dialog.setContentPane((Container)smokinBg);
/* 237 */       dialog.setUndecorated(!argDecorated);
/*     */       
/* 239 */       dialog.getRootPane().setOpaque(false);
/* 240 */       dialog.getContentPane().setBackground(new Color(0, 0, 0, 128));
/* 241 */       dialog.setBackground(new Color(0, 0, 0, 128));
/*     */     } else {
/*     */       
/* 244 */       dialog.setContentPane((Container)backgroundPanel);
/*     */     } 
/* 246 */     dialog.setIconImages(AppIconHelper.getIconImages());
/*     */     
/* 248 */     return dialog;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\DialogView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */