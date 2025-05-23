/*     */ package dtv.pos.framework.form.design;
/*     */ 
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnumPossibleValuesPopup
/*     */   extends JPopupMenu
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected final JTextArea textArea_;
/*     */   protected EnumPossibleValues value_;
/*     */   protected ChangeListener listener_;
/*     */   private final JScrollPane pane_;
/*  35 */   private final Action okAction_ = new AbstractAction("OK")
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void actionPerformed(ActionEvent actionEvent) {
/*  40 */         String text = EnumPossibleValuesPopup.this.textArea_.getText();
/*  41 */         if (StringUtils.isEmpty(text)) {
/*  42 */           EnumPossibleValuesPopup.this.value_ = null;
/*     */         } else {
/*     */           
/*  45 */           EnumPossibleValuesPopup.this.value_ = EnumPossibleValues.makeFromDesignValue(text);
/*     */         } 
/*  47 */         EnumPossibleValuesPopup.this.listener_.stateChanged(new ChangeEvent(this));
/*  48 */         EnumPossibleValuesPopup.this.setVisible(false);
/*     */       }
/*     */     };
/*     */   
/*  52 */   private final Action cancelAction_ = new AbstractAction("Cancel")
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void actionPerformed(ActionEvent actionEvent) {
/*  57 */         EnumPossibleValuesPopup.this.listener_.stateChanged(new ChangeEvent(this));
/*  58 */         EnumPossibleValuesPopup.this.setVisible(false);
/*     */       }
/*     */     };
/*     */   
/*     */   public EnumPossibleValuesPopup(EnumPossibleValues argValue, Rectangle argCellLocation) {
/*  63 */     this.value_ = argValue;
/*  64 */     this.textArea_ = new JTextArea();
/*     */ 
/*     */     
/*  67 */     this.textArea_.setFont(UIResourceManager.getInstance().getFont("_fontLabelMedium"));
/*     */     
/*  69 */     this.textArea_.setAutoscrolls(true);
/*     */     
/*  71 */     if (argValue != null) {
/*  72 */       this.textArea_.setText(argValue.getValuesListString());
/*     */     }
/*     */     
/*  75 */     this.pane_ = new JScrollPane(this.textArea_, 22, 30);
/*     */ 
/*     */ 
/*     */     
/*  79 */     this.pane_.setPreferredSize(new Dimension(argCellLocation.width, 100));
/*     */ 
/*     */     
/*  82 */     setLayout(new BorderLayout());
/*  83 */     add(this.pane_, "Center");
/*     */     
/*  85 */     JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
/*  86 */     buttonPanel.add(new JButton(this.okAction_));
/*  87 */     buttonPanel.add(new JButton(this.cancelAction_));
/*  88 */     add(buttonPanel, "South");
/*     */     
/*  90 */     pack();
/*     */   }
/*     */   
/*     */   public void addValueChangeListener(ChangeListener listener) {
/*  94 */     this.listener_ = listener;
/*     */   }
/*     */   
/*     */   public EnumPossibleValues getValue() {
/*  98 */     return this.value_;
/*     */   }
/*     */   
/*     */   public void show(JTable argTable, Rectangle argCellLocation) {
/* 102 */     show(argTable, argCellLocation.x, argCellLocation.y);
/* 103 */     this.textArea_.requestFocusInWindow();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\EnumPossibleValuesPopup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */