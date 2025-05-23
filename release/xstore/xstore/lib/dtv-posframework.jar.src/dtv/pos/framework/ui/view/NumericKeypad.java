/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.ui.plaf.PosLookAndFeel;
/*     */ import dtv.ui.DtvUIManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.layout.TableLayout;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.LookAndFeel;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NumericKeypad
/*     */   extends AbstractKeypad
/*     */ {
/*     */   private final Collection<JComponent> buttons_;
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  42 */       UIManager.setLookAndFeel((LookAndFeel)new PosLookAndFeel());
/*     */     }
/*  44 */     catch (Exception exception) {}
/*  45 */     DtvUIManager.install();
/*     */     
/*  47 */     NumericKeypad keyPad = new NumericKeypad();
/*  48 */     JComponent panel = keyPad.getDisplayComponent();
/*  49 */     JFrame frame = new JFrame("Numeric Keypad Test");
/*     */     
/*  51 */     frame.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent argEvent) {
/*  54 */             System.exit(0);
/*     */           }
/*     */         });
/*  57 */     panel.setPreferredSize(new Dimension(400, 400));
/*     */     
/*  59 */     frame.getContentPane().setLayout(new BorderLayout());
/*  60 */     frame.getContentPane().add(panel, "Center");
/*  61 */     frame.pack();
/*  62 */     UIServices.centerComponent(frame);
/*  63 */     frame.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumericKeypad() {
/*  73 */     this.buttons_ = new ArrayList<>();
/*  74 */     initUI();
/*     */   }
/*     */ 
/*     */   
/*     */   protected JComponent createView() {
/*  79 */     DtvPanel view = new DtvPanel(DtvPanel.DROP_ID);
/*  80 */     ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener((IContextChangeListener)view);
/*     */     
/*  82 */     return (JComponent)view;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<JComponent> getActionComponents() {
/*  87 */     return this.buttons_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addButton(IXstAction argAction, String argConstraints) {
/*  92 */     addButton(argAction, argConstraints, (String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void addButton(IXstAction argAction, String argConstraints, String argIconKey) {
/*  97 */     JComponent button = createButton(DtvButton.NUMERIC_KEYPAD_DEFAULT_ID, argAction, argIconKey);
/*  98 */     this.buttons_.add(button);
/*     */     
/* 100 */     getView().add(button, argConstraints);
/*     */   }
/*     */   
/*     */   private void addTallButton(IXstAction argAction, String argConstraints, String argIconKey) {
/* 104 */     JComponent button = createButton(DtvButton.NUMERIC_KEYPAD_TALL_ID, argAction, argIconKey);
/* 105 */     this.buttons_.add(button);
/*     */     
/* 107 */     getView().add(button, argConstraints);
/*     */   }
/*     */   
/*     */   private void addWideButton(IXstAction argAction, String argConstraints, String argIconKey) {
/* 111 */     JComponent button = createButton(DtvButton.NUMERIC_KEYPAD_WIDE_ID, argAction, argIconKey);
/* 112 */     this.buttons_.add(button);
/*     */     
/* 114 */     getView().add(button, argConstraints);
/*     */   }
/*     */ 
/*     */   
/*     */   private void initUI() {
/* 119 */     TableLayout layout = new TableLayout(4, 4);
/* 120 */     layout.setGaps(1, 1, 1, 1);
/* 121 */     layout.setVerticalStretch(true);
/*     */     
/* 123 */     getView().setLayout((LayoutManager)layout);
/*     */     
/* 125 */     addButton(createKeyAction("7", true), "0, 0, 1, 1");
/* 126 */     addButton(createKeyAction("8", true), "1, 0, 1, 1");
/* 127 */     addButton(createKeyAction("9", true), "2, 0, 1, 1");
/* 128 */     addButton(createKeyAction("-", true), "3, 0, 1, 1");
/* 129 */     addButton(createKeyAction("4", true), "0, 1, 1, 1");
/* 130 */     addButton(createKeyAction("5", true), "1, 1, 1, 1");
/* 131 */     addButton(createKeyAction("6", true), "2, 1, 1, 1");
/* 132 */     addButton(createKeyAction('\b'), "3, 1, 1, 1", "_imageButtonBackArrow");
/* 133 */     addButton(createKeyAction("1", true), "0, 2, 1, 1");
/* 134 */     addButton(createKeyAction("2", true), "1, 2, 1, 1");
/* 135 */     addButton(createKeyAction("3", true), "2, 2, 1, 1");
/* 136 */     addWideButton(createKeyAction("0", true), "0, 3, 2, 1", (String)null);
/* 137 */     addButton(createKeyAction(".", true), "2, 3, 1, 1");
/*     */     
/* 139 */     IXstDataAction iXstDataAction = this._actionFactory.getDataAction(XstDataActionKey.ACCEPT);
/* 140 */     iXstDataAction.setKeyStroke(XstKeyStroke.forName("enter").getKeyStroke());
/* 141 */     addTallButton((IXstAction)iXstDataAction, "3, 2, 1, 2", "_imageButtonEnterArrow");
/*     */     
/* 143 */     registerActions();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\NumericKeypad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */