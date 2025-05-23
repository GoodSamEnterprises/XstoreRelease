/*     */ package dtv.pos.framework.form.design.dialog;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
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
/*     */ public class NameNewFormFrame
/*     */   extends JFrame
/*     */   implements IOkCancelListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final JTextField textField_;
/*     */   private final JPanel textPanel_;
/*     */   private final JPanel buttonPanel_;
/*     */   private final JButton cancelButton_;
/*     */   private final JButton okButton_;
/*     */   private final ListSelectorFrame<FormKey> parent_;
/*     */   private final OkCancelDispatcher okCancelDispatcher_;
/*     */   
/*     */   public NameNewFormFrame(String argTitle, ListSelectorFrame<FormKey> argParent) {
/*  42 */     super(argTitle);
/*  43 */     this.parent_ = argParent;
/*     */     
/*  45 */     this.textPanel_ = new JPanel(new GridLayout(1, 1));
/*  46 */     this.textPanel_.add(this.textField_ = new JTextField());
/*     */     
/*  48 */     this.okButton_ = new JButton("OK");
/*  49 */     this.cancelButton_ = new JButton("Cancel");
/*     */     
/*  51 */     this.buttonPanel_ = new JPanel(new GridLayout(1, 2));
/*  52 */     this.buttonPanel_.add(this.okButton_);
/*  53 */     this.buttonPanel_.add(this.cancelButton_);
/*     */     
/*  55 */     getContentPane().setLayout(new BorderLayout());
/*  56 */     getContentPane().add(this.textPanel_, "Center");
/*  57 */     getContentPane().add(this.buttonPanel_, "South");
/*     */     
/*  59 */     pack();
/*  60 */     setSize(new Dimension(400, 100));
/*  61 */     UIServices.centerComponent(this);
/*     */     
/*  63 */     this.okCancelDispatcher_ = new OkCancelDispatcher(this.okButton_, this.cancelButton_);
/*     */     
/*  65 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelSelected() {
/*  73 */     setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void okSelected() {
/*  83 */     if (StringUtils.isEmpty(this.textField_.getText())) {
/*  84 */       cancelSelected();
/*     */     } else {
/*     */       
/*  87 */       FormKey key = FormKey.valueOf(this.textField_.getText());
/*  88 */       this.parent_.setSelectedValue(key);
/*  89 */       this.parent_.okSelected();
/*     */     } 
/*  91 */     setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean argVisible) {
/*  97 */     if (argVisible) {
/*  98 */       this.okCancelDispatcher_.addOkCancelListener(this);
/*     */     } else {
/*     */       
/* 101 */       this.okCancelDispatcher_.removeOkCancelListener(this);
/*     */     } 
/* 103 */     super.setVisible(argVisible);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void processWindowEvent(WindowEvent e) {
/* 112 */     super.processWindowEvent(e);
/* 113 */     if (e.getID() == 201)
/* 114 */       cancelSelected(); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\NameNewFormFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */