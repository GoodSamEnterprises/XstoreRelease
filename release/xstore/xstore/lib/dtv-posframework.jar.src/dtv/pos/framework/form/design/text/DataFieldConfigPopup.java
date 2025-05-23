/*     */ package dtv.pos.framework.form.design.text;
/*     */ import dtv.pos.framework.ui.config.EditFormatterParams;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.config.IEditFormatterParams;
/*     */ import dtv.pos.ui.text.TextFieldFormatterFactory;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.ui.layout.TableLayout;
/*     */ import dtv.ui.layout.TableLayoutConstraints;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DataFieldConfigPopup extends JDialog {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   private static final Logger logger_ = Logger.getLogger(DataFieldConfigPopup.class);
/*  40 */   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#"); private static final boolean DEFAULT_ALLOW_NEGATIVE = false; private static final boolean DEFAULT_ALLOW_NULL = true; protected final JCheckBox allowNegativeCheckBox_; protected final JLabel allowNegativeLabel_; protected final JCheckBox allowNullCheckBox_; protected final JLabel allowNullLabel_; protected final JComboBox displayFormatCombo_; protected final JLabel displayFormatLabel_; protected final JComboBox editFormatCombo_; protected final JLabel editFormatLabel_; protected final JFormattedTextField editPatternEntry_;
/*     */   protected final JLabel editPatternLabel_;
/*     */   protected final JFormattedTextField maxCharactersEntry_;
/*     */   
/*     */   protected static Boolean nullForDefaults(boolean argValue, boolean argDefault) {
/*  45 */     return (argValue == argDefault) ? null : Boolean.valueOf(argValue);
/*     */   }
/*     */   protected final JLabel maxCharactersLabel_; protected final JFormattedTextField maximumAllowedValueEntry_; protected final JLabel maximumAllowedValueLabel_; protected final JFormattedTextField maximumFractionEntry_; protected final JLabel maximumFractionLabel_; protected final JFormattedTextField maximumIntegerEntry_; protected final JLabel maximumIntegerLabel_; protected final JFormattedTextField minimumAllowedValueEntry_; protected final JLabel minimumAllowedValueLabel_; protected final JTextField regexEntry_; protected final JLabel regexLabel_; protected ChangeListener listener_; protected IEditFormatterParams editFormatterParams_; protected IDataFieldConfig config_;
/*     */   protected static BigDecimal safeBigDecimal(Object o) {
/*  49 */     if (o == null) {
/*  50 */       return null;
/*     */     }
/*  52 */     String s = "" + o;
/*  53 */     if (StringUtils.isEmpty(s)) {
/*  54 */       return null;
/*     */     }
/*     */     try {
/*  57 */       return NumberUtils.toBigDecimal(s, DECIMAL_FORMAT);
/*     */     }
/*  59 */     catch (Exception ex) {
/*  60 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  61 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static Integer safeInteger(Object o) {
/*  66 */     if (o == null) {
/*  67 */       return null;
/*     */     }
/*  69 */     String s = "" + o;
/*  70 */     if (StringUtils.isEmpty(s)) {
/*  71 */       return null;
/*     */     }
/*  73 */     return Integer.valueOf(s);
/*     */   }
/*     */   
/*     */   protected static String safeString(Object o) {
/*  77 */     return (o == null) ? null : o.toString();
/*     */   }
/*     */   
/*     */   private static boolean safeBoolean(Boolean argValue, boolean argDefault) {
/*  81 */     return (argValue == null) ? argDefault : argValue.booleanValue();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   private final Action cancelAction = new AbstractAction("Cancel")
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void actionPerformed(ActionEvent actionEvent) {
/* 116 */         DataFieldConfigPopup.this.listener_.stateChanged(new ChangeEvent(this));
/* 117 */         DataFieldConfigPopup.this.setVisible(false);
/*     */       }
/*     */     };
/*     */   
/* 121 */   private final ActionListener editFormatActionListener = new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 124 */         FormTextFieldInputType f = DataFieldConfigPopup.this.getFormEditFormat();
/* 125 */         if (f == null) {
/* 126 */           DataFieldConfigPopup.this.allowNullCheckBox_.setEnabled(false);
/* 127 */           DataFieldConfigPopup.this.allowNullLabel_.setEnabled(false);
/*     */           
/* 129 */           DataFieldConfigPopup.this.allowNegativeCheckBox_.setEnabled(false);
/* 130 */           DataFieldConfigPopup.this.allowNegativeLabel_.setEnabled(false);
/*     */           
/* 132 */           DataFieldConfigPopup.this.maxCharactersEntry_.setEnabled(false);
/* 133 */           DataFieldConfigPopup.this.maxCharactersLabel_.setEnabled(false);
/*     */           
/* 135 */           DataFieldConfigPopup.this.regexEntry_.setEnabled(false);
/* 136 */           DataFieldConfigPopup.this.regexLabel_.setEnabled(false);
/*     */           
/* 138 */           DataFieldConfigPopup.this.editPatternEntry_.setEnabled(false);
/* 139 */           DataFieldConfigPopup.this.editPatternLabel_.setEnabled(false);
/*     */           
/* 141 */           DataFieldConfigPopup.this.maximumIntegerEntry_.setEnabled(false);
/* 142 */           DataFieldConfigPopup.this.maximumIntegerLabel_.setEnabled(false);
/*     */           
/* 144 */           DataFieldConfigPopup.this.maximumFractionEntry_.setEnabled(false);
/* 145 */           DataFieldConfigPopup.this.maximumFractionLabel_.setEnabled(false);
/*     */           
/* 147 */           DataFieldConfigPopup.this.maximumAllowedValueEntry_.setEnabled(false);
/* 148 */           DataFieldConfigPopup.this.maximumAllowedValueLabel_.setEnabled(false);
/*     */           
/* 150 */           DataFieldConfigPopup.this.minimumAllowedValueEntry_.setEnabled(false);
/* 151 */           DataFieldConfigPopup.this.minimumAllowedValueLabel_.setEnabled(false);
/*     */           
/* 153 */           DataFieldConfigPopup.this.displayFormatCombo_.setEnabled(false);
/* 154 */           DataFieldConfigPopup.this.displayFormatLabel_.setEnabled(false);
/*     */         } else {
/*     */           
/* 157 */           DataFieldConfigPopup.this.allowNullCheckBox_.setEnabled(true);
/* 158 */           DataFieldConfigPopup.this.allowNullLabel_.setEnabled(true);
/*     */           
/* 160 */           DataFieldConfigPopup.this.displayFormatCombo_.setEnabled(true);
/* 161 */           DataFieldConfigPopup.this.displayFormatLabel_.setEnabled(true);
/*     */           
/* 163 */           DataFieldConfigPopup.this.allowNegativeCheckBox_.setEnabled(f.hasSign());
/* 164 */           DataFieldConfigPopup.this.allowNegativeLabel_.setEnabled(f.hasSign());
/*     */           
/* 166 */           DataFieldConfigPopup.this.maxCharactersEntry_.setEnabled(f.hasMaxCharacters());
/* 167 */           DataFieldConfigPopup.this.maxCharactersLabel_.setEnabled(f.hasMaxCharacters());
/*     */           
/* 169 */           DataFieldConfigPopup.this.regexEntry_.setEnabled(f.hasRegexPolicy());
/* 170 */           DataFieldConfigPopup.this.regexLabel_.setEnabled(f.hasRegexPolicy());
/*     */           
/* 172 */           DataFieldConfigPopup.this.editPatternEntry_.setEnabled(f.hasEditPattern());
/* 173 */           DataFieldConfigPopup.this.editPatternLabel_.setEnabled(f.hasEditPattern());
/*     */           
/* 175 */           DataFieldConfigPopup.this.maximumIntegerEntry_.setEnabled(f.hasMaximumIntegerDigits());
/* 176 */           DataFieldConfigPopup.this.maximumIntegerLabel_.setEnabled(f.hasMaximumIntegerDigits());
/*     */           
/* 178 */           DataFieldConfigPopup.this.maximumFractionEntry_.setEnabled(f.hasMaximumFractionDigits());
/* 179 */           DataFieldConfigPopup.this.maximumFractionLabel_.setEnabled(f.hasMaximumFractionDigits());
/*     */           
/* 181 */           DataFieldConfigPopup.this.maximumAllowedValueEntry_.setEnabled(f.hasMaximumValue());
/* 182 */           DataFieldConfigPopup.this.maximumAllowedValueLabel_.setEnabled(f.hasMaximumValue());
/*     */           
/* 184 */           DataFieldConfigPopup.this.minimumAllowedValueEntry_.setEnabled(f.hasMinimumValue());
/* 185 */           DataFieldConfigPopup.this.minimumAllowedValueLabel_.setEnabled(f.hasMinimumValue());
/*     */         } 
/* 187 */         if (!DataFieldConfigPopup.this.allowNullCheckBox_.isEnabled()) {
/* 188 */           DataFieldConfigPopup.this.allowNullCheckBox_.setSelected(true);
/*     */         }
/*     */         
/* 191 */         if (!DataFieldConfigPopup.this.allowNegativeCheckBox_.isEnabled()) {
/* 192 */           DataFieldConfigPopup.this.allowNegativeCheckBox_.setSelected(false);
/*     */         }
/*     */         
/* 195 */         if (!DataFieldConfigPopup.this.maxCharactersEntry_.isEnabled()) {
/* 196 */           DataFieldConfigPopup.this.maxCharactersEntry_.setValue((Object)null);
/*     */         }
/*     */         
/* 199 */         if (!DataFieldConfigPopup.this.regexEntry_.isEnabled()) {
/* 200 */           DataFieldConfigPopup.this.regexEntry_.setText((String)null);
/*     */         }
/*     */         
/* 203 */         if (!DataFieldConfigPopup.this.editPatternEntry_.isEnabled()) {
/* 204 */           DataFieldConfigPopup.this.editPatternEntry_.setValue((Object)null);
/*     */         }
/*     */         
/* 207 */         if (!DataFieldConfigPopup.this.maximumIntegerEntry_.isEnabled()) {
/* 208 */           DataFieldConfigPopup.this.maximumIntegerEntry_.setValue((Object)null);
/*     */         }
/*     */         
/* 211 */         if (!DataFieldConfigPopup.this.maximumFractionEntry_.isEnabled()) {
/* 212 */           DataFieldConfigPopup.this.maximumFractionEntry_.setValue((Object)null);
/*     */         }
/*     */         
/* 215 */         if (!DataFieldConfigPopup.this.displayFormatCombo_.isEnabled()) {
/* 216 */           DataFieldConfigPopup.this.displayFormatCombo_.setSelectedItem((Object)null);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 222 */   private final Action okAction = new AbstractAction("OK")
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void actionPerformed(ActionEvent actionEvent) {
/* 227 */         FormTextFieldInputType displayFormat = DataFieldConfigPopup.this.getFormDisplayFormat();
/* 228 */         DataFieldConfigPopup.this.config_.setDisplayFormatType(DataFieldConfigPopup.this.getFormat(displayFormat));
/*     */         
/* 230 */         FormTextFieldInputType editFormat = DataFieldConfigPopup.this.getFormEditFormat();
/* 231 */         DataFieldConfigPopup.this.config_.setFormatType(DataFieldConfigPopup.this.getFormat(editFormat));
/*     */         
/* 233 */         if (editFormat == null) {
/* 234 */           DataFieldConfigPopup.this.editFormatterParams_ = (IEditFormatterParams)new EditFormatterParams();
/*     */         } else {
/*     */           
/* 237 */           if (editFormat.hasSign()) {
/* 238 */             DataFieldConfigPopup.this.editFormatterParams_.setAllowNegative(DataFieldConfigPopup.nullForDefaults(DataFieldConfigPopup.this.allowNegativeCheckBox_.isSelected(), false));
/*     */           }
/*     */           else {
/*     */             
/* 242 */             DataFieldConfigPopup.this.editFormatterParams_.setAllowNegative(null);
/*     */           } 
/* 244 */           DataFieldConfigPopup.this.editFormatterParams_
/* 245 */             .setAllowNull(DataFieldConfigPopup.nullForDefaults(DataFieldConfigPopup.this.allowNullCheckBox_.isSelected(), true));
/* 246 */           if (editFormat.hasMaxCharacters()) {
/* 247 */             DataFieldConfigPopup.this.editFormatterParams_.setMaxCharacters(DataFieldConfigPopup.safeInteger(DataFieldConfigPopup.this.maxCharactersEntry_.getValue()));
/*     */           } else {
/*     */             
/* 250 */             DataFieldConfigPopup.this.editFormatterParams_.setMaxCharacters(null);
/*     */           } 
/* 252 */           if (editFormat.hasRegexPolicy()) {
/* 253 */             DataFieldConfigPopup.this.editFormatterParams_.setRegexPolicy(DataFieldConfigPopup.safeString(DataFieldConfigPopup.this.regexEntry_.getText()));
/*     */           } else {
/*     */             
/* 256 */             DataFieldConfigPopup.this.editFormatterParams_.setRegexPolicy(null);
/*     */           } 
/* 258 */           if (editFormat.hasEditPattern()) {
/* 259 */             DataFieldConfigPopup.this.config_.setEditPattern(DataFieldConfigPopup.safeString(DataFieldConfigPopup.this.editPatternEntry_.getValue()));
/*     */           } else {
/*     */             
/* 262 */             DataFieldConfigPopup.this.config_.setEditPattern(null);
/*     */           } 
/* 264 */           if (editFormat.hasMaximumIntegerDigits()) {
/* 265 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumIntegerDigits(DataFieldConfigPopup.safeInteger(DataFieldConfigPopup.this.maximumIntegerEntry_.getValue()));
/*     */           } else {
/*     */             
/* 268 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumIntegerDigits(null);
/*     */           } 
/* 270 */           if (editFormat.hasMaximumFractionDigits()) {
/* 271 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumFractionalDigits(DataFieldConfigPopup.safeInteger(DataFieldConfigPopup.this.maximumFractionEntry_.getValue()));
/*     */           } else {
/*     */             
/* 274 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumFractionalDigits(null);
/*     */           } 
/*     */           
/* 277 */           if (editFormat.hasMaximumValue()) {
/* 278 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumAllowedValue(DataFieldConfigPopup.safeBigDecimal(DataFieldConfigPopup.this.maximumAllowedValueEntry_.getValue()));
/*     */           } else {
/*     */             
/* 281 */             DataFieldConfigPopup.this.editFormatterParams_.setMaximumAllowedValue(null);
/*     */           } 
/*     */           
/* 284 */           if (editFormat.hasMinimumValue()) {
/* 285 */             DataFieldConfigPopup.this.editFormatterParams_.setMinimumAllowedValue(DataFieldConfigPopup.safeBigDecimal(DataFieldConfigPopup.this.minimumAllowedValueEntry_.getValue()));
/*     */           } else {
/*     */             
/* 288 */             DataFieldConfigPopup.this.editFormatterParams_.setMinimumAllowedValue(null);
/*     */           } 
/*     */         } 
/*     */         
/* 292 */         DataFieldConfigPopup.this.config_.setEditFormatterParams(DataFieldConfigPopup.this.editFormatterParams_);
/* 293 */         DataFieldConfigPopup.this.listener_.stateChanged(new ChangeEvent(this));
/* 294 */         DataFieldConfigPopup.this.setVisible(false);
/*     */       }
/*     */     };
/*     */   
/* 298 */   private final Action removeAction = new AbstractAction("Remove")
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void actionPerformed(ActionEvent actionEvent) {
/* 303 */         DataFieldConfigPopup.this.config_ = null;
/* 304 */         DataFieldConfigPopup.this.listener_.stateChanged(new ChangeEvent(this));
/* 305 */         DataFieldConfigPopup.this.setVisible(false);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataFieldConfigPopup() {
/* 314 */     setUndecorated(true);
/*     */     
/* 316 */     TableLayout tableLayout = new TableLayout();
/* 317 */     tableLayout.setVerticalStretch(true);
/* 318 */     tableLayout.setColumn(new double[] { -2.0D, -1.0D });
/*     */     
/* 320 */     tableLayout.setRow(new double[] { -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, -2.0D, 20.0D, -2.0D });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 326 */     JPanel valuesPanel = new JPanel((LayoutManager)tableLayout);
/*     */     
/* 328 */     this.editFormatLabel_ = new JLabel("edit format");
/* 329 */     this.editFormatCombo_ = new JComboBox<>(FormTextFieldInputType.getInstances(true));
/* 330 */     this.editFormatLabel_.setLabelFor(this.editFormatCombo_);
/*     */     
/* 332 */     valuesPanel.add(this.editFormatLabel_, new TableLayoutConstraints("0, 0, 1, 1, R"));
/* 333 */     valuesPanel.add(this.editFormatCombo_, new TableLayoutConstraints("1, 0"));
/*     */     
/* 335 */     this.allowNullLabel_ = new JLabel("allow null");
/* 336 */     this.allowNullCheckBox_ = new JCheckBox();
/* 337 */     this.allowNullLabel_.setLabelFor(this.allowNullCheckBox_);
/*     */     
/* 339 */     valuesPanel.add(this.allowNullLabel_, new TableLayoutConstraints("0, 1, 1, 1, R"));
/* 340 */     valuesPanel.add(this.allowNullCheckBox_, new TableLayoutConstraints("1, 1"));
/*     */     
/* 342 */     this.allowNegativeCheckBox_ = new JCheckBox();
/* 343 */     this.allowNegativeLabel_ = new JLabel("allow negative");
/* 344 */     this.allowNegativeLabel_.setLabelFor(this.allowNegativeCheckBox_);
/*     */     
/* 346 */     valuesPanel.add(this.allowNegativeLabel_, new TableLayoutConstraints("0, 2, 1, 1, R"));
/* 347 */     valuesPanel.add(this.allowNegativeCheckBox_, new TableLayoutConstraints("1, 2"));
/*     */     
/* 349 */     this.maxCharactersLabel_ = new JLabel("max. characters");
/* 350 */     this
/* 351 */       .maxCharactersEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER));
/*     */     
/* 353 */     this.maxCharactersLabel_.setLabelFor(this.maxCharactersEntry_);
/*     */     
/* 355 */     valuesPanel.add(this.maxCharactersLabel_, new TableLayoutConstraints("0, 3, 1, 1, R"));
/* 356 */     valuesPanel.add(this.maxCharactersEntry_, new TableLayoutConstraints("1, 3"));
/*     */     
/* 358 */     this.regexLabel_ = new JLabel("regex input policy");
/* 359 */     this.regexEntry_ = new JTextField();
/* 360 */     this.regexEntry_.setBackground(Color.WHITE);
/* 361 */     this.regexLabel_.setLabelFor(this.regexEntry_);
/*     */     
/* 363 */     valuesPanel.add(this.regexLabel_, new TableLayoutConstraints("0, 4, 1, 1, R"));
/* 364 */     valuesPanel.add(this.regexEntry_, new TableLayoutConstraints("1, 4"));
/*     */ 
/*     */     
/* 367 */     this.editPatternLabel_ = new JLabel("edit pattern");
/* 368 */     this
/* 369 */       .editPatternEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.SIMPLE));
/*     */     
/* 371 */     this.editPatternLabel_.setLabelFor(this.editPatternEntry_);
/*     */     
/* 373 */     valuesPanel.add(this.editPatternLabel_, new TableLayoutConstraints("0, 5, 1, 1, R"));
/* 374 */     valuesPanel.add(this.editPatternEntry_, new TableLayoutConstraints("1, 5"));
/*     */ 
/*     */     
/* 377 */     this.maximumIntegerLabel_ = new JLabel("max. int. digits");
/* 378 */     this
/* 379 */       .maximumIntegerEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER));
/*     */     
/* 381 */     this.maximumIntegerLabel_.setLabelFor(this.maximumIntegerEntry_);
/*     */     
/* 383 */     valuesPanel.add(this.maximumIntegerLabel_, new TableLayoutConstraints("0, 6, 1, 1, R"));
/* 384 */     valuesPanel.add(this.maximumIntegerEntry_, new TableLayoutConstraints("1, 6"));
/*     */     
/* 386 */     this.maximumFractionLabel_ = new JLabel("max. fract. digits");
/* 387 */     this
/* 388 */       .maximumFractionEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER));
/*     */     
/* 390 */     this.maximumFractionLabel_.setLabelFor(this.maximumFractionEntry_);
/*     */     
/* 392 */     valuesPanel.add(this.maximumFractionLabel_, new TableLayoutConstraints("0, 7, 1, 1, R"));
/* 393 */     valuesPanel.add(this.maximumFractionEntry_, new TableLayoutConstraints("1, 7"));
/*     */ 
/*     */     
/* 396 */     this.maximumAllowedValueLabel_ = new JLabel("max. value");
/* 397 */     this
/* 398 */       .maximumAllowedValueEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.DECIMAL));
/*     */     
/* 400 */     this.maximumAllowedValueLabel_.setLabelFor(this.maximumAllowedValueEntry_);
/*     */     
/* 402 */     valuesPanel.add(this.maximumAllowedValueLabel_, new TableLayoutConstraints("0, 8, 1, 1, R"));
/* 403 */     valuesPanel.add(this.maximumAllowedValueEntry_, new TableLayoutConstraints("1, 8"));
/*     */     
/* 405 */     this.minimumAllowedValueLabel_ = new JLabel("min. value");
/* 406 */     this
/* 407 */       .minimumAllowedValueEntry_ = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.DECIMAL));
/*     */     
/* 409 */     this.minimumAllowedValueLabel_.setLabelFor(this.minimumAllowedValueEntry_);
/*     */     
/* 411 */     valuesPanel.add(this.minimumAllowedValueLabel_, new TableLayoutConstraints("0, 9, 1, 1, R"));
/* 412 */     valuesPanel.add(this.minimumAllowedValueEntry_, new TableLayoutConstraints("1, 9"));
/*     */ 
/*     */ 
/*     */     
/* 416 */     this.displayFormatLabel_ = new JLabel("display format");
/* 417 */     this.displayFormatCombo_ = new JComboBox<>(FormTextFieldInputType.getInstances(true));
/* 418 */     this.displayFormatLabel_.setLabelFor(this.displayFormatCombo_);
/*     */     
/* 420 */     valuesPanel.add(this.displayFormatLabel_, new TableLayoutConstraints("0, 11, 1, 1, R"));
/*     */     
/* 422 */     valuesPanel.add(this.displayFormatCombo_, new TableLayoutConstraints("1, 11"));
/*     */ 
/*     */     
/* 425 */     JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
/* 426 */     buttonPanel.add(new JButton(this.okAction));
/* 427 */     buttonPanel.add(new JButton(this.removeAction));
/* 428 */     buttonPanel.add(new JButton(this.cancelAction));
/*     */ 
/*     */     
/* 431 */     JPanel basePanel = new JPanel();
/* 432 */     basePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray, 2), 
/* 433 */           BorderFactory.createEmptyBorder(3, 3, 0, 3)));
/* 434 */     basePanel.setLayout(new BorderLayout());
/* 435 */     basePanel.add(valuesPanel, "Center");
/* 436 */     basePanel.add(buttonPanel, "South");
/*     */     
/* 438 */     getContentPane().setLayout(new BorderLayout());
/* 439 */     getContentPane().add(basePanel, "Center");
/*     */     
/* 441 */     pack();
/*     */     
/* 443 */     this.editFormatCombo_.addActionListener(this.editFormatActionListener);
/*     */   }
/*     */   
/*     */   public void addChangeListener(ChangeListener listener) {
/* 447 */     this.listener_ = listener;
/*     */   }
/*     */   
/*     */   public IDataFieldConfig getDataFieldConfig() {
/* 451 */     return this.config_;
/*     */   }
/*     */   
/*     */   public void setDataFieldConfig(IDataFieldConfig newValue) {
/* 455 */     this.config_ = newValue;
/*     */     
/* 457 */     FormTextFieldInputType editFormat = FormTextFieldInputType.forType(this.config_.getFormatType());
/* 458 */     this.editFormatCombo_.setSelectedItem(editFormat);
/*     */     
/* 460 */     this.editFormatterParams_ = this.config_.getEditFormatterParams();
/*     */     
/* 462 */     this.allowNullCheckBox_.setSelected(safeBoolean(this.editFormatterParams_.getAllowNull(), true));
/* 463 */     this.allowNegativeCheckBox_.setSelected(safeBoolean(this.editFormatterParams_.getAllowNegative(), false));
/*     */ 
/*     */     
/* 466 */     this.maxCharactersEntry_.setValue(this.editFormatterParams_.getMaxCharacters());
/* 467 */     this.regexEntry_.setText(this.editFormatterParams_.getRegexPolicy());
/* 468 */     this.editPatternEntry_.setValue(this.config_.getEditPattern().toString());
/* 469 */     this.maximumIntegerEntry_.setValue(this.editFormatterParams_.getMaximumIntegerDigits());
/* 470 */     this.maximumFractionEntry_.setValue(this.editFormatterParams_.getMaximumFractionalDigits());
/* 471 */     this.maximumAllowedValueEntry_.setValue(this.editFormatterParams_.getMaximumAllowedValue());
/* 472 */     this.minimumAllowedValueEntry_.setValue(this.editFormatterParams_.getMinimumAllowedValue());
/*     */     
/* 474 */     FormTextFieldInputType displayFormat = FormTextFieldInputType.forType(this.config_.getDisplayFormatType());
/* 475 */     if (!ObjectUtils.equivalent(displayFormat, editFormat)) {
/* 476 */       this.displayFormatCombo_.setSelectedItem(displayFormat);
/*     */     } else {
/*     */       
/* 479 */       this.displayFormatCombo_.setSelectedItem((Object)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setLocation(int x, int y) {
/* 485 */     Point p = adjustPopupLocationToFitScreen(x, y);
/* 486 */     super.setLocation(p.x, p.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocation(Point p) {
/* 491 */     super.setLocation(adjustPopupLocationToFitScreen(p.x, p.y));
/*     */   }
/*     */   
/*     */   public void show(JTable argTable, Rectangle argCellLocation) {
/* 495 */     Point p = argTable.getLocationOnScreen();
/* 496 */     setLocation(p.x + (int)argCellLocation.getX(), p.y + (int)argCellLocation.getY());
/* 497 */     setSize((int)argCellLocation.getWidth(), (int)getSize().getHeight());
/* 498 */     validate();
/* 499 */     setModal(true);
/* 500 */     setVisible(true);
/*     */   }
/*     */   
/*     */   protected TextFieldInputType getFormat(FormTextFieldInputType argType) {
/* 504 */     if (argType == null) {
/* 505 */       return null;
/*     */     }
/* 507 */     return TextFieldInputType.forName(argType.toString());
/*     */   }
/*     */   
/*     */   protected FormTextFieldInputType getFormDisplayFormat() {
/* 511 */     return (FormTextFieldInputType)this.displayFormatCombo_.getSelectedItem();
/*     */   }
/*     */   
/*     */   protected FormTextFieldInputType getFormEditFormat() {
/* 515 */     return (FormTextFieldInputType)this.editFormatCombo_.getSelectedItem();
/*     */   } private Point adjustPopupLocationToFitScreen(int xposition, int yposition) {
/*     */     Rectangle screenBounds;
/*     */     Insets screenInsets;
/* 519 */     Point p = new Point(xposition, yposition);
/*     */     
/* 521 */     Toolkit toolkit = Toolkit.getDefaultToolkit();
/*     */ 
/*     */     
/* 524 */     GraphicsConfiguration gc = null;
/*     */ 
/*     */     
/* 527 */     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/* 528 */     GraphicsDevice[] gd = ge.getScreenDevices();
/* 529 */     for (GraphicsDevice element : gd) {
/* 530 */       if (element.getType() == 0) {
/* 531 */         GraphicsConfiguration dgc = element.getDefaultConfiguration();
/* 532 */         if (dgc.getBounds().contains(p)) {
/* 533 */           gc = dgc;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 539 */     if (gc != null) {
/*     */       
/* 541 */       screenInsets = toolkit.getScreenInsets(gc);
/* 542 */       screenBounds = gc.getBounds();
/*     */     }
/*     */     else {
/*     */       
/* 546 */       screenInsets = new Insets(0, 0, 0, 0);
/* 547 */       screenBounds = new Rectangle(toolkit.getScreenSize());
/*     */     } 
/*     */     
/* 550 */     int scrWidth = screenBounds.width - Math.abs(screenInsets.left + screenInsets.right);
/* 551 */     int scrHeight = screenBounds.height - Math.abs(screenInsets.top + screenInsets.bottom);
/*     */     
/* 553 */     Dimension size = getPreferredSize();
/*     */     
/* 555 */     if (p.x + size.width > screenBounds.x + scrWidth) {
/* 556 */       p.x = screenBounds.x + scrWidth - size.width;
/*     */     }
/*     */     
/* 559 */     if (p.y + size.height > screenBounds.y + scrHeight) {
/* 560 */       p.y = screenBounds.y + scrHeight - size.height;
/*     */     }
/*     */ 
/*     */     
/* 564 */     if (p.x < screenBounds.x) {
/* 565 */       p.x = screenBounds.x;
/*     */     }
/* 567 */     if (p.y < screenBounds.y) {
/* 568 */       p.y = screenBounds.y;
/*     */     }
/*     */     
/* 571 */     return p;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\text\DataFieldConfigPopup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */