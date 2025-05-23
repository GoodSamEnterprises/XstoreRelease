/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.ui.plaf.PosLookAndFeel;
/*     */ import dtv.ui.ComponentID;
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
/*     */ public class AlphaKeypad
/*     */   extends AbstractKeypad
/*     */ {
/*  35 */   private static final ComponentID BUTTON_ID = DtvButton.LARGE_TEXT_ID;
/*     */ 
/*     */   
/*     */   private final Collection<JComponent> buttons_;
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  43 */       UIManager.setLookAndFeel((LookAndFeel)new PosLookAndFeel());
/*     */     }
/*  45 */     catch (Exception exception) {}
/*  46 */     DtvUIManager.install();
/*     */     
/*  48 */     AlphaKeypad keyPad = new AlphaKeypad();
/*  49 */     JComponent panel = keyPad.getDisplayComponent();
/*  50 */     JFrame frame = new JFrame("Alpha-numeric Keypad Test");
/*     */     
/*  52 */     frame.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent argEvent) {
/*  55 */             System.exit(0);
/*     */           }
/*     */         });
/*  58 */     panel.setPreferredSize(new Dimension(400, 400));
/*     */     
/*  60 */     frame.getContentPane().setLayout(new BorderLayout());
/*  61 */     frame.getContentPane().add(panel, "Center");
/*  62 */     frame.pack();
/*  63 */     UIServices.centerComponent(frame);
/*  64 */     frame.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AlphaKeypad() {
/*  74 */     this.buttons_ = new ArrayList<>();
/*  75 */     initUI();
/*     */   }
/*     */ 
/*     */   
/*     */   protected JComponent createView() {
/*  80 */     DtvPanel view = new DtvPanel(DtvPanel.DROP_ID);
/*  81 */     ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener((IContextChangeListener)view);
/*     */     
/*  83 */     return (JComponent)view;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<JComponent> getActionComponents() {
/*  88 */     return this.buttons_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addButton(IXstAction argAction, String argConstraints) {
/*  93 */     addButton(argAction, argConstraints, (String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void addButton(IXstAction argAction, String argConstraints, String argIconKey) {
/*  98 */     JComponent button = createButton(BUTTON_ID, argAction, argIconKey);
/*  99 */     this.buttons_.add(button);
/*     */     
/* 101 */     getView().add(button, argConstraints);
/*     */   }
/*     */ 
/*     */   
/*     */   private void initUI() {
/* 106 */     TableLayout layout = new TableLayout(70, 7);
/* 107 */     layout.setGaps(1, 1, 1, 1);
/* 108 */     layout.setVerticalStretch(true);
/*     */     
/* 110 */     getView().setLayout((LayoutManager)layout);
/*     */     
/* 112 */     addButton(createKeyAction("1", true), "0, 0, 7, 1");
/* 113 */     addButton(createKeyAction("2", true), "7, 0, 7, 1");
/* 114 */     addButton(createKeyAction("3", true), "14, 0, 7, 1");
/* 115 */     addButton(createKeyAction("4", true), "21, 0, 7, 1");
/* 116 */     addButton(createKeyAction("5", true), "28, 0, 7, 1");
/* 117 */     addButton(createKeyAction("6", true), "35, 0, 7, 1");
/* 118 */     addButton(createKeyAction("7", true), "42, 0, 7, 1");
/* 119 */     addButton(createKeyAction("8", true), "49, 0, 7, 1");
/* 120 */     addButton(createKeyAction("9", true), "56, 0, 7, 1");
/* 121 */     addButton(createKeyAction("0", true), "63, 0, 7, 1");
/*     */     
/* 123 */     addButton(createKeyAction("a", true), "0, 1, 10, 1");
/* 124 */     addButton(createKeyAction("b", true), "10, 1, 10, 1");
/* 125 */     addButton(createKeyAction("c", true), "20, 1, 10, 1");
/* 126 */     addButton(createKeyAction("d", true), "30, 1, 10, 1");
/* 127 */     addButton(createKeyAction("e", true), "40, 1, 10, 1");
/* 128 */     addButton(createKeyAction("f", true), "50, 1, 10, 1");
/* 129 */     addButton(createKeyAction("g", true), "60, 1, 10, 1");
/* 130 */     addButton(createKeyAction("h", true), "0, 2, 10, 1");
/* 131 */     addButton(createKeyAction("i", true), "10, 2, 10, 1");
/* 132 */     addButton(createKeyAction("j", true), "20, 2, 10, 1");
/* 133 */     addButton(createKeyAction("k", true), "30, 2, 10, 1");
/* 134 */     addButton(createKeyAction("l", true), "40, 2, 10, 1");
/* 135 */     addButton(createKeyAction("m", true), "50, 2, 10, 1");
/* 136 */     addButton(createKeyAction("n", true), "60, 2, 10, 1");
/* 137 */     addButton(createKeyAction("o", true), "0, 3, 10, 1");
/* 138 */     addButton(createKeyAction("p", true), "10, 3, 10, 1");
/* 139 */     addButton(createKeyAction("q", true), "20, 3, 10, 1");
/* 140 */     addButton(createKeyAction("r", true), "30, 3, 10, 1");
/* 141 */     addButton(createKeyAction("s", true), "40, 3, 10, 1");
/* 142 */     addButton(createKeyAction("t", true), "50, 3, 10, 1");
/* 143 */     addButton(createKeyAction("u", true), "60, 3, 10, 1");
/* 144 */     addButton(createKeyAction("v", true), "0, 4, 10, 1");
/* 145 */     addButton(createKeyAction("w", true), "10, 4, 10, 1");
/* 146 */     addButton(createKeyAction("x", true), "20, 4, 10, 1");
/* 147 */     addButton(createKeyAction("y", true), "30, 4, 10, 1");
/* 148 */     addButton(createKeyAction("z", true), "40, 4, 10, 1");
/*     */     
/* 150 */     addButton(createKeyAction(".", true), "50, 4, 10, 1");
/* 151 */     addButton(createKeyAction(",", true), "60, 4, 10, 1");
/* 152 */     addButton(createKeyAction("-", true), "0, 5, 10, 1");
/* 153 */     addButton(createKeyAction("+", true), "10, 5, 10, 1");
/* 154 */     addButton(createKeyAction("@", true), "20, 5, 10, 1");
/* 155 */     addButton(createKeyAction("!", true), "30, 5, 10, 1");
/* 156 */     addButton(createKeyAction("?", true), "40, 5, 10, 1");
/* 157 */     addButton(createKeyAction("%", true), "50, 5, 10, 1");
/* 158 */     addButton(createKeyAction("SPACE", false), "20, 6, 30, 1");
/* 159 */     addButton(createKeyAction('\b'), "50, 6, 10, 1", "_imageButtonBackArrowSmall");
/*     */     
/* 161 */     IXstDataAction iXstDataAction = this._actionFactory.getDataAction(XstDataActionKey.ACCEPT);
/* 162 */     iXstDataAction.setKeyStroke(XstKeyStroke.forName("enter").getKeyStroke());
/* 163 */     addButton((IXstAction)iXstDataAction, "60, 5, 10, 2", "_imageButtonEnterArrowSmall");
/*     */     
/* 165 */     IXstAction iXstAction = createKeyAction("?", true);
/* 166 */     iXstAction.setKeyStroke(XstKeyStroke.forName("shift").getKeyStroke());
/* 167 */     addButton(iXstAction, "0, 6, 20, 1", "_imageButtonShiftArrowSmall");
/*     */     
/* 169 */     registerActions();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AlphaKeypad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */