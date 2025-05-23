/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import dtv.pos.iframework.ui.IXstAppFrame;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosFrame;
/*     */ import dtv.ui.IComponent;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.context.DefaultContextChangeListener;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.swing.DtvCardedPanel;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.ui.swing.DtvTranslucentInstructionPane;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.awt.CardLayout;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.WindowListener;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.RootPaneContainer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class XstAppFrame
/*     */   implements IXstViewComponent, IXstAppFrame, IContextChangeListener
/*     */ {
/*  34 */   private static final Logger logger_ = Logger.getLogger(XstAppFrame.class);
/*     */   
/*     */   private final Window _frame;
/*     */   final JComponent _contentPane;
/*     */   final CardLayout _layout;
/*     */   private final DtvTranslucentInstructionPane _glassPane;
/*     */   private final IContextChangeListener _contextChangeDelegate;
/*     */   
/*     */   public XstAppFrame() {
/*  43 */     this(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstAppFrame(boolean decorated) {
/*  48 */     DtvCardedPanel panel = new DtvCardedPanel(DtvPanel.BACKGROUND_ID);
/*  49 */     this._contextChangeDelegate = (IContextChangeListener)new DefaultContextChangeListener((IComponent)panel);
/*     */     
/*  51 */     if (decorated) {
/*  52 */       this._frame = (Window)PosComponentFactory.getInstance().createFrame((Container)panel);
/*     */     
/*     */     }
/*  55 */     else if (Platform.isWindows()) {
/*  56 */       PosFrame frame = PosComponentFactory.getInstance().createFrame((Container)panel);
/*  57 */       frame.setUndecorated(true);
/*  58 */       this._frame = (Window)frame;
/*     */     } else {
/*     */       
/*  61 */       this._frame = (Window)PosComponentFactory.getInstance().createWindow((Container)panel);
/*     */     } 
/*     */ 
/*     */     
/*  65 */     this._layout = (CardLayout)panel.getLayout();
/*  66 */     this._contentPane = (JComponent)((RootPaneContainer)this._frame).getContentPane();
/*     */     
/*  68 */     this._glassPane = new DtvTranslucentInstructionPane();
/*  69 */     this._glassPane.setVisible(false);
/*  70 */     ((RootPaneContainer)this._frame).setGlassPane((Component)this._glassPane);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Component baseUIComponent, String uiName) {
/*  75 */     this._contentPane.add(baseUIComponent, uiName);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addWindowListener(WindowListener listener) {
/*  80 */     this._frame.removeWindowListener(listener);
/*  81 */     this._frame.addWindowListener(listener);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  86 */     return this._contentPane;
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  91 */     return this._contentPane;
/*     */   }
/*     */ 
/*     */   
/*     */   public Window getFrameComponent() {
/*  96 */     return this._frame;
/*     */   }
/*     */   
/*     */   public DtvTranslucentInstructionPane getGlassPane() {
/* 100 */     return this._glassPane;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent argEvent) {
/* 106 */     this._contextChangeDelegate.handleContextChange(argEvent);
/* 107 */     this._frame.repaint();
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 111 */     return this._frame.isVisible();
/*     */   }
/*     */   
/*     */   public void removeWindowListener(WindowListener listener) {
/* 115 */     this._frame.removeWindowListener(listener);
/*     */   }
/*     */   
/*     */   public void setTitle(String argTitle) {
/* 119 */     if (this._frame instanceof Frame) {
/* 120 */       ((Frame)this._frame).setTitle(argTitle);
/*     */     }
/* 122 */     else if (this._frame instanceof Dialog) {
/* 123 */       ((Dialog)this._frame).setTitle(argTitle);
/*     */     } else {
/*     */       
/* 126 */       logger_.warn(ObjectUtils.getClassNameFromObject(this._frame) + " not a " + Frame.class.getName() + " or a " + Dialog.class
/* 127 */           .getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setVisible(boolean visible) {
/* 132 */     this._frame.setVisible(visible);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void show(final String uiName) {
/* 139 */     if (Boolean.getBoolean("dtv.pos.ui.overrideScreenSize.enabled")) {
/* 140 */       int width = NumberUtils.getInteger("dtv.pos.ui.overrideScreenSize.width", Integer.valueOf(240)).intValue();
/* 141 */       int height = NumberUtils.getInteger("dtv.pos.ui.overrideScreenSize.height", Integer.valueOf(320)).intValue();
/* 142 */       int left = 0;
/* 143 */       int top = 0;
/*     */       
/* 145 */       if (!Boolean.getBoolean("dtv.pos.ui.overrideScreenSize.showFrame")) {
/* 146 */         Insets i = this._frame.getInsets();
/* 147 */         width += i.left + i.right;
/* 148 */         height += i.top + i.bottom - 48;
/* 149 */         left = i.left * -1;
/* 150 */         top = i.top * -1;
/*     */       } 
/*     */       
/* 153 */       this._frame.setBounds(left, top, width, height);
/* 154 */       this._frame.validate();
/*     */     } 
/*     */     
/* 157 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 161 */             XstAppFrame.this._layout.show(XstAppFrame.this._contentPane, uiName);
/* 162 */             XstAppFrame.this._contentPane.transferFocus();
/*     */           }
/*     */         }true, false);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstAppFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */