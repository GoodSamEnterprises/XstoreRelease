/*     */ package dtv.pos.framework.form.design.dialog;
/*     */ 
/*     */ import dtv.pos.framework.form.design.model.IntegerSpinnerModel;
/*     */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InsertComponentDialog
/*     */   extends JDialog
/*     */   implements IOkCancelListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final Integer ZERO = Integer.valueOf(0);
/*     */   
/*     */   private final JComboBox typeCombo_;
/*     */   
/*     */   private final IntegerSpinnerModel rowModel_;
/*     */   
/*     */   private final IntegerSpinnerModel columnModel_;
/*     */   
/*     */   public static void main(String[] args) {
/*  35 */     InsertComponentDialog d = new InsertComponentDialog(null, ZERO, ZERO, ZERO, Integer.valueOf(10));
/*  36 */     d.setVisible(true);
/*  37 */     d.dispose();
/*  38 */     System.out.println("selected: " + d
/*  39 */         .getSelectedType() + "(" + d.getSelectedRow() + ", " + d.getSelectedColumn() + ")");
/*  40 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final JSpinner rowSpinner_;
/*     */ 
/*     */   
/*     */   private final JSpinner columnSpinner_;
/*     */ 
/*     */   
/*     */   private final JButton okButton_;
/*     */ 
/*     */   
/*     */   private final JButton cancelButton_;
/*     */ 
/*     */   
/*     */   private final OkCancelDispatcher okCancelDispatcher_;
/*     */   
/*     */   private final JLabel rowLabel_;
/*     */   
/*     */   private final JLabel typeLabel_;
/*     */   
/*     */   private final JLabel columnLabel_;
/*     */   
/*     */   private FormComponentType selectedType_;
/*     */   
/*     */   private Integer selectedRow_;
/*     */   
/*     */   private Integer selectedColumn_;
/*     */ 
/*     */   
/*     */   public InsertComponentDialog(Frame argOwner, Integer argInitialRow, Integer argInitialColumn, Integer argMaxRow, Integer argMaxColumn) {
/*  73 */     super(argOwner, "Insert Component", true);
/*  74 */     getContentPane().setLayout(new GridLayout(4, 2));
/*     */     
/*  76 */     getContentPane().add(this.typeLabel_ = new JLabel("Component type"));
/*  77 */     getContentPane().add(this.typeCombo_ = new JComboBox<>(FormComponentType.getInstances()));
/*  78 */     this.typeCombo_.setSelectedItem(FormComponentType.LABEL_DIMINISHED);
/*  79 */     this.typeLabel_.setLabelFor(this.typeCombo_);
/*     */     
/*  81 */     getContentPane().add(this.rowLabel_ = new JLabel("Row"));
/*  82 */     this.rowModel_ = new IntegerSpinnerModel(ZERO, argMaxRow, argInitialRow);
/*  83 */     getContentPane().add(this.rowSpinner_ = new JSpinner((SpinnerModel)this.rowModel_));
/*  84 */     this.rowLabel_.setLabelFor(this.rowSpinner_);
/*     */     
/*  86 */     getContentPane().add(this.columnLabel_ = new JLabel("Column"));
/*  87 */     this.columnModel_ = new IntegerSpinnerModel(ZERO, argMaxColumn, argInitialColumn);
/*  88 */     getContentPane().add(this.columnSpinner_ = new JSpinner((SpinnerModel)this.columnModel_));
/*  89 */     this.columnLabel_.setLabelFor(this.columnSpinner_);
/*     */     
/*  91 */     getContentPane().add(this.okButton_ = new JButton("OK"));
/*  92 */     getContentPane().add(this.cancelButton_ = new JButton("Cancel"));
/*  93 */     this.okCancelDispatcher_ = new OkCancelDispatcher(this.okButton_, this.cancelButton_);
/*     */     
/*  95 */     pack();
/*  96 */     UIServices.centerComponent(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelSelected() {
/* 102 */     setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSelectedColumn() {
/* 110 */     return this.selectedColumn_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSelectedRow() {
/* 118 */     return this.selectedRow_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormComponentType getSelectedType() {
/* 126 */     return this.selectedType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void okSelected() {
/* 132 */     this.selectedType_ = (FormComponentType)this.typeCombo_.getSelectedItem();
/* 133 */     this.selectedRow_ = this.rowModel_.getInteger();
/* 134 */     this.selectedColumn_ = this.columnModel_.getInteger();
/* 135 */     setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean argVisible) {
/* 141 */     if (argVisible) {
/* 142 */       this.okCancelDispatcher_.addOkCancelListener(this);
/*     */     } else {
/*     */       
/* 145 */       this.okCancelDispatcher_.removeOkCancelListener(this);
/*     */     } 
/* 147 */     super.setVisible(argVisible);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\InsertComponentDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */