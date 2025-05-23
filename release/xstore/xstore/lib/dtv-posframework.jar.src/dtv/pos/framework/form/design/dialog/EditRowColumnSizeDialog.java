/*     */ package dtv.pos.framework.form.design.dialog;
/*     */ 
/*     */ import dtv.pos.ui.text.TextFieldFormatterFactory;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Label;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EditRowColumnSizeDialog
/*     */   extends JDialog
/*     */   implements IOkCancelListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  29 */   private static final Logger logger_ = Logger.getLogger(EditRowColumnSizeDialog.class);
/*     */   
/*     */   public static void main(String[] args) {
/*  32 */     test("MINIMUM TEST", -3.0D);
/*  33 */     test("PREFERRED TEST", -2.0D);
/*  34 */     test("FILL TEST", -1.0D);
/*  35 */     test("ZERO TEST", 0.0D);
/*  36 */     test("PERCENTAGE TEST", 0.05D);
/*  37 */     test("ABSOLUTE TEST", 10.0D);
/*  38 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private static void test(String argMessage, double argValue) {
/*     */     try {
/*  43 */       EditRowColumnSizeDialog d = new EditRowColumnSizeDialog(null, "TEST", argMessage, argValue);
/*  44 */       d.setVisible(true);
/*  45 */       System.out.println("selected " + d.getValue());
/*  46 */       d.dispose();
/*     */     }
/*  48 */     catch (Exception ex) {
/*  49 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */   
/*  53 */   protected Double selectedValue_ = null;
/*     */   
/*     */   protected final ButtonGroup selectionGroup_;
/*     */   
/*     */   protected final JRadioButton fillButton_;
/*     */   
/*     */   protected final JRadioButton preferredButton_;
/*     */   
/*     */   protected final JRadioButton minimumButton_;
/*     */   protected final JPanel absolutePanel_;
/*     */   protected final JRadioButton absoluteButton_;
/*     */   protected final JTextField absoluteTextField_;
/*     */   protected final JPanel percentagePanel_;
/*     */   protected final JRadioButton percentageButton_;
/*     */   protected final JTextField percentageTextField_;
/*     */   protected final JPanel buttonPanel_;
/*     */   protected final JButton okButton_;
/*     */   protected final JButton cancelButton_;
/*     */   protected final OkCancelDispatcher okCancelDispatcher_;
/*     */   
/*  73 */   private final ChangeListener selectionChangesListener = new ChangeListener()
/*     */     {
/*     */       public void stateChanged(ChangeEvent changeEvent) {
/*  76 */         EditRowColumnSizeDialog.this.absoluteTextField_.setEnabled(EditRowColumnSizeDialog.this.absoluteButton_.isSelected());
/*  77 */         EditRowColumnSizeDialog.this.percentageTextField_.setEnabled(EditRowColumnSizeDialog.this.percentageButton_.isSelected());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public EditRowColumnSizeDialog(Frame argOwner, String argTitle, String argLabelText, double argCurrentSetting) {
/*  83 */     super(argOwner, argTitle, true);
/*     */     
/*  85 */     Container contentPane = getContentPane();
/*  86 */     contentPane.setLayout(new GridLayout(7, 1, 0, 10));
/*  87 */     contentPane.add(new Label(argLabelText));
/*     */     
/*  89 */     this.selectionGroup_ = new ButtonGroup();
/*     */     
/*  91 */     contentPane.add(this.fillButton_ = new JRadioButton("FILL"));
/*  92 */     this.fillButton_.addChangeListener(this.selectionChangesListener);
/*  93 */     this.selectionGroup_.add(this.fillButton_);
/*     */     
/*  95 */     contentPane.add(this.preferredButton_ = new JRadioButton("PREFERRED"));
/*  96 */     this.preferredButton_.addChangeListener(this.selectionChangesListener);
/*  97 */     this.selectionGroup_.add(this.preferredButton_);
/*     */     
/*  99 */     contentPane.add(this.minimumButton_ = new JRadioButton("MINIMUM"));
/* 100 */     this.minimumButton_.addChangeListener(this.selectionChangesListener);
/* 101 */     this.selectionGroup_.add(this.minimumButton_);
/*     */     
/* 103 */     contentPane.add(this.absolutePanel_ = new JPanel(new GridLayout(1, 2)));
/* 104 */     this.absolutePanel_.add(this.absoluteButton_ = new JRadioButton("ABSOLUTE"));
/* 105 */     this.absoluteButton_.addChangeListener(this.selectionChangesListener);
/* 106 */     this.selectionGroup_.add(this.absoluteButton_);
/* 107 */     this.absolutePanel_.add(this
/* 108 */         .absoluteTextField_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER)));
/*     */     
/* 110 */     contentPane.add(this.percentagePanel_ = new JPanel(new GridLayout(1, 2)));
/* 111 */     this.percentagePanel_.add(this.percentageButton_ = new JRadioButton("PERCENTAGE"));
/* 112 */     this.percentageButton_.addChangeListener(this.selectionChangesListener);
/* 113 */     this.percentagePanel_.add(this
/* 114 */         .percentageTextField_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER)));
/* 115 */     this.selectionGroup_.add(this.percentageButton_);
/*     */     
/* 117 */     contentPane.add(this.buttonPanel_ = new JPanel(new GridLayout(1, 2)));
/* 118 */     this.buttonPanel_.add(this.okButton_ = new JButton("OK"));
/* 119 */     this.buttonPanel_.add(this.cancelButton_ = new JButton("Cancel"));
/*     */     
/* 121 */     this.okCancelDispatcher_ = new OkCancelDispatcher(this.okButton_, this.cancelButton_);
/*     */     
/* 123 */     pack();
/*     */     
/* 125 */     setValue(argCurrentSetting);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelSelected() {
/* 130 */     this.selectedValue_ = null;
/* 131 */     setVisible(false);
/*     */   }
/*     */   
/*     */   public Double getValue() {
/* 135 */     return this.selectedValue_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void okSelected() {
/* 140 */     if (this.fillButton_.isSelected()) {
/* 141 */       this.selectedValue_ = Double.valueOf(-1.0D);
/*     */     }
/* 143 */     else if (this.preferredButton_.isSelected()) {
/* 144 */       this.selectedValue_ = Double.valueOf(-2.0D);
/*     */     }
/* 146 */     else if (this.minimumButton_.isSelected()) {
/* 147 */       this.selectedValue_ = Double.valueOf(-3.0D);
/*     */     }
/* 149 */     else if (this.absoluteButton_.isSelected()) {
/* 150 */       this.selectedValue_ = Double.valueOf(Integer.valueOf(this.absoluteTextField_.getText()).intValue());
/*     */     }
/* 152 */     else if (this.percentageButton_.isSelected()) {
/* 153 */       this.selectedValue_ = Double.valueOf(Double.parseDouble(this.percentageTextField_.getText()) / 100.0D);
/*     */     } else {
/*     */       
/* 156 */       logger_.warn("NOTHING IS SELECTED");
/* 157 */       this.selectedValue_ = null;
/*     */     } 
/*     */     
/* 160 */     setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean argVisible) {
/* 166 */     if (argVisible) {
/* 167 */       this.okCancelDispatcher_.addOkCancelListener(this);
/*     */     } else {
/*     */       
/* 170 */       this.okCancelDispatcher_.removeOkCancelListener(this);
/*     */     } 
/* 172 */     super.setVisible(argVisible);
/*     */   }
/*     */   
/*     */   private void setValue(double newValue) {
/* 176 */     if (newValue == -1.0D) {
/* 177 */       this.fillButton_.setSelected(true);
/* 178 */       this.fillButton_.requestFocus();
/*     */     }
/* 180 */     else if (newValue == -2.0D) {
/* 181 */       this.preferredButton_.setSelected(true);
/* 182 */       this.preferredButton_.requestFocus();
/*     */     }
/* 184 */     else if (newValue == -3.0D) {
/* 185 */       this.minimumButton_.setSelected(true);
/* 186 */       this.minimumButton_.requestFocus();
/*     */     }
/* 188 */     else if (newValue <= 1.0D) {
/*     */       String sValue;
/* 190 */       this.percentageButton_.setSelected(true);
/* 191 */       this.percentageTextField_.requestFocus();
/*     */       
/* 193 */       if (newValue < 0.0D) {
/* 194 */         sValue = "0";
/*     */       } else {
/*     */         
/* 197 */         sValue = String.valueOf((int)(newValue * 100.0D));
/*     */       } 
/* 199 */       this.percentageTextField_.setText(sValue);
/*     */     } else {
/*     */       
/* 202 */       this.absoluteButton_.setSelected(true);
/* 203 */       this.absoluteTextField_.requestFocus();
/* 204 */       this.absoluteTextField_.setText(String.valueOf((int)newValue));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\EditRowColumnSizeDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */