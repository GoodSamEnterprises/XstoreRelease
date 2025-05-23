/*    */ package dtv.pos.framework.form.design.dialog;
/*    */ 
/*    */ import dtv.pos.framework.form.design.model.IntegerSpinnerModel;
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Frame;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ import javax.swing.SpinnerModel;
/*    */ 
/*    */ public class IntegerInputDialog
/*    */   extends JDialog
/*    */   implements IOkCancelListener
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final JPanel buttonPanel_;
/*    */   private final JButton okButton_;
/*    */   private final JButton cancelButton_;
/*    */   private final IntegerSpinnerModel spinnerModel_;
/*    */   private final OkCancelDispatcher okCancelDispatcher_;
/*    */   private Integer selectedValue_;
/*    */   
/*    */   public static void main(String[] args) {
/* 28 */     IntegerInputDialog d = new IntegerInputDialog(null, "TITLE", "LABEL", Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(6));
/* 29 */     d.setVisible(true);
/* 30 */     d.dispose();
/* 31 */     System.out.println("selected: " + d.getValue());
/* 32 */     System.exit(0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IntegerInputDialog(Frame argOwner, String argTitle, String argLabelText, Integer argMinimum, Integer argMaximum, Integer argInitialValue) {
/* 47 */     super(argOwner, argTitle, true);
/* 48 */     this.spinnerModel_ = new IntegerSpinnerModel(argMinimum, argMaximum, argInitialValue);
/*    */     
/* 50 */     getContentPane().setLayout(new BorderLayout());
/* 51 */     getContentPane().add(new JLabel(argLabelText), "North");
/* 52 */     getContentPane().add(new JSpinner((SpinnerModel)this.spinnerModel_), "Center");
/*    */     
/* 54 */     getContentPane().add(this.buttonPanel_ = new JPanel(), "South");
/* 55 */     this.buttonPanel_.setLayout(new GridLayout());
/* 56 */     this.buttonPanel_.add(this.okButton_ = new JButton("OK"));
/* 57 */     this.buttonPanel_.add(this.cancelButton_ = new JButton("Cancel"));
/*    */     
/* 59 */     this.okCancelDispatcher_ = new OkCancelDispatcher(this.okButton_, this.cancelButton_);
/*    */     
/* 61 */     pack();
/* 62 */     UIServices.centerComponent(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelSelected() {
/* 67 */     setVisible(false);
/*    */   }
/*    */   
/*    */   public Integer getValue() {
/* 71 */     return this.selectedValue_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void okSelected() {
/* 76 */     this.selectedValue_ = this.spinnerModel_.getInteger();
/* 77 */     setVisible(false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVisible(boolean argVisible) {
/* 83 */     if (argVisible) {
/* 84 */       this.okCancelDispatcher_.addOkCancelListener(this);
/*    */     } else {
/*    */       
/* 87 */       this.okCancelDispatcher_.removeOkCancelListener(this);
/*    */     } 
/* 89 */     super.setVisible(argVisible);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\IntegerInputDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */