/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.ui.UIServices;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosPrettyLabel;
/*     */ import dtv.pos.ui.plaf.component.PosPrettyPanelUI;
/*     */ import dtv.pos.ui.plaf.component.PosTransactionSummaryConstants;
/*     */ import dtv.ui.layout.TableLayout;
/*     */ import dtv.ui.layout.TableLayoutConstraints;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Insets;
/*     */ import java.awt.LayoutManager;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.math.BigDecimal;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.plaf.ComponentUI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PosTransactionSummaryUI
/*     */   extends PosPrettyPanelUI
/*     */ {
/*     */   public static ComponentUI createUI(JComponent c) {
/*  41 */     return (ComponentUI)new PosTransactionSummaryUI();
/*     */   }
/*     */   
/*     */   protected static MutableString convertAmountToText(Number amount) {
/*  45 */     IFormattable text = FormattableFactory.getInstance().getSimpleFormattable(amount, AMOUNT_FORMATTER);
/*  46 */     return LocaleManager.getInstance().getRegisteredString(text);
/*     */   }
/*     */   
/*     */   protected static MutableString convertDecimalToText(Number amount) {
/*  50 */     IFormattable text = FormattableFactory.getInstance().getSimpleFormattable(amount, DECIMAL_FORMATTER);
/*  51 */     return LocaleManager.getInstance().getRegisteredString(text);
/*     */   }
/*     */   
/*  54 */   protected static final IFormatter AMOUNT_FORMATTER = FormatterFactory.getInstance().getMoneyFormatter();
/*     */   
/*  56 */   protected static final IFormatter DECIMAL_FORMATTER = FormatterFactory.getInstance().getDecimalFormatter();
/*     */   
/*     */   protected static Color separatorColor_;
/*     */   
/*     */   protected static Color disabledSeparatorColor_;
/*     */   
/*     */   protected PosPrettyLabel subtotalTextLabel_;
/*     */   protected PosPrettyLabel feesTextLabel_;
/*     */   protected PosPrettyLabel totalTextLabel_;
/*     */   protected PosPrettyLabel cashTotalTextLabel_;
/*     */   protected PosPrettyLabel cashTotalAmountLabel_;
/*     */   protected PosPrettyLabel balanceTextLabel_;
/*     */   protected PosPrettyLabel soldItemCountTextLabel_;
/*  69 */   protected String originalItemCountText_ = "";
/*     */   
/*     */   protected PosPrettyLabel subtotalAmountLabel_;
/*     */   
/*     */   protected PosPrettyLabel feesAmountLabel_;
/*     */   
/*     */   protected PosPrettyLabel totalAmountLabel_;
/*     */   
/*     */   protected PosPrettyLabel balanceAmountLabel_;
/*     */   
/*     */   protected PosPrettyLabel[] taxTextLabelArr_;
/*     */   protected PosPrettyLabel[] taxAmountLabelArr_;
/*     */   private int taxLen_;
/*     */   
/*     */   public void installUI(JComponent c) {
/*  84 */     if (!(c instanceof PosTransactionSummary)) {
/*  85 */       throw new Error(PosTransactionSummaryUI.class + " requires a component of type [" + PosTransactionSummary.class + "]!");
/*     */     }
/*     */     
/*  88 */     super.installUI(c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g, JComponent c) {
/*  93 */     Color separatorColor = separatorColor_;
/*     */     
/*  95 */     if (!c.isEnabled()) {
/*  96 */       if (!isDisplayedWhenDisabled()) {
/*     */         return;
/*     */       }
/*  99 */       separatorColor = disabledSeparatorColor_;
/*     */     } 
/* 101 */     super.paint(g, c);
/*     */     
/* 103 */     Insets margin = c.getInsets();
/* 104 */     int dividerX = margin.left;
/* 105 */     int dividerY = 0;
/* 106 */     if (this.taxLen_ > 0) {
/*     */       
/* 108 */       dividerY = Math.max(this.taxTextLabelArr_[this.taxLen_ - 1].getY() + this.taxTextLabelArr_[this.taxLen_ - 1].getHeight(), this.taxTextLabelArr_[this.taxTextLabelArr_.length - 1]
/* 109 */           .getY() + this.taxTextLabelArr_[this.taxTextLabelArr_.length - 1]
/* 110 */           .getHeight());
/*     */     } else {
/*     */       
/* 113 */       dividerY = this.subtotalTextLabel_.getY() + this.subtotalTextLabel_.getHeight();
/*     */     } 
/* 115 */     int dividerWidth = c.getWidth() - margin.left + margin.right;
/* 116 */     g.setColor(separatorColor);
/* 117 */     g.drawLine(dividerX, dividerY, dividerX + dividerWidth, dividerY);
/*     */   }
/*     */ 
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent event) {
/* 122 */     super.propertyChange(event);
/*     */     
/* 124 */     String propertyName = event.getPropertyName();
/*     */     
/* 126 */     if (propertyName == "subtotalTextChanged") {
/* 127 */       this.subtotalTextLabel_.setText((String)event.getNewValue());
/*     */     }
/* 129 */     else if (propertyName == "subtotalAmountChanged") {
/* 130 */       this.subtotalAmountLabel_.setText(convertAmountToText((Number)event.getNewValue()));
/*     */     }
/* 132 */     else if (propertyName == "feesTextChanged") {
/* 133 */       this.feesTextLabel_.setText((String)event.getNewValue());
/*     */     }
/* 135 */     else if (propertyName == "feesAmountChanged") {
/* 136 */       this.feesAmountLabel_.setText(convertAmountToText((Number)event.getNewValue()));
/*     */     }
/* 138 */     else if (propertyName == "totalTextChanged") {
/* 139 */       this.totalTextLabel_.setText((String)event.getNewValue());
/*     */     }
/* 141 */     else if (propertyName == "totalAmountChanged") {
/* 142 */       this.totalAmountLabel_.setText(convertAmountToText((Number)event.getNewValue()));
/*     */     }
/* 144 */     else if (propertyName == "cashTotalTextChanged") {
/* 145 */       this.cashTotalTextLabel_.setText((String)event.getNewValue());
/*     */     }
/* 147 */     else if (propertyName == "cashTotalAmountChanged") {
/* 148 */       this.cashTotalAmountLabel_.setText(convertAmountToText((Number)event.getNewValue()));
/*     */     }
/* 150 */     else if (propertyName == "balanceTextChanged") {
/* 151 */       this.balanceTextLabel_.setText((String)event.getNewValue());
/*     */     }
/* 153 */     else if (propertyName == "balanceAmountChanged") {
/* 154 */       this.balanceAmountLabel_.setText(convertAmountToText((Number)event.getNewValue()));
/*     */     }
/* 156 */     else if (propertyName == "soldItemCountTextChanged") {
/* 157 */       this.soldItemCountTextLabel_.setText((String)event.getNewValue());
/* 158 */       this.originalItemCountText_ = this.soldItemCountTextLabel_.getText();
/*     */     }
/* 160 */     else if (propertyName == "soldItemCountChanged") {
/*     */       MutableString newText;
/* 162 */       if (this.originalItemCountText_ != null) {
/*     */ 
/*     */         
/* 165 */         newText = new MutableString(this.originalItemCountText_ + " " + convertDecimalToText((Number)event.getNewValue()));
/*     */       } else {
/*     */         
/* 168 */         newText = convertDecimalToText((Number)event.getNewValue());
/*     */       } 
/*     */       
/* 171 */       this.soldItemCountTextLabel_.setText(newText);
/*     */     }
/* 173 */     else if (propertyName == "subtotalTextColorChanged") {
/* 174 */       this.subtotalTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 176 */     else if (propertyName == "feesTextColorChanged") {
/* 177 */       this.feesTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 179 */     else if (propertyName == "totalTextColorChanged") {
/* 180 */       this.totalTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 182 */     else if (propertyName == "cashTotalTextColorChanged") {
/* 183 */       this.cashTotalTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 185 */     else if (propertyName == "balanceTextColorChanged") {
/* 186 */       this.balanceTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 188 */     else if (propertyName == "soldItemCountTextColorChanged") {
/* 189 */       this.soldItemCountTextLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 191 */     else if (propertyName == "subtotalAmountColorChanged") {
/* 192 */       this.subtotalAmountLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 194 */     else if (propertyName == "feesAmountColorChanged") {
/* 195 */       this.feesAmountLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 197 */     else if (propertyName == "totalAmountColorChanged") {
/* 198 */       this.totalAmountLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 200 */     else if (propertyName == "cashTotalAmountColorChanged") {
/* 201 */       this.cashTotalAmountLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 203 */     else if (propertyName == "balanceAmountColorChanged") {
/* 204 */       this.balanceAmountLabel_.setForeground((Color)event.getNewValue());
/*     */     }
/* 206 */     else if (propertyName == "subtotalTextFontChanged") {
/* 207 */       this.subtotalTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 209 */     else if (propertyName == "feesTextFontChanged") {
/* 210 */       this.feesTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 212 */     else if (propertyName == "totalTextFontChanged") {
/* 213 */       this.totalTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 215 */     else if (propertyName == "cashTotalTextFontChanged") {
/* 216 */       this.cashTotalTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 218 */     else if (propertyName == "cashTotalAmountFontChanged") {
/* 219 */       this.cashTotalAmountLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 221 */     else if (propertyName == "balanceTextFontChanged") {
/* 222 */       this.balanceTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 224 */     else if (propertyName == "soldItemCountTextFontChanged") {
/* 225 */       this.soldItemCountTextLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 227 */     else if (propertyName == "subtotalAmountFontChanged") {
/* 228 */       this.subtotalAmountLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 230 */     else if (propertyName == "feesAmountFontChanged") {
/* 231 */       this.feesAmountLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 233 */     else if (propertyName == "totalAmountFontChanged") {
/* 234 */       this.totalAmountLabel_.setFont((Font)event.getNewValue());
/*     */     }
/* 236 */     else if (propertyName == "balanceAmountFontChanged") {
/* 237 */       this.balanceAmountLabel_.setFont((Font)event.getNewValue());
/*     */     } else {
/*     */       
/* 240 */       for (int i = 0; i < this.taxLen_; i++) {
/* 241 */         if (propertyName == PosTransactionSummaryConstants.TAX_TEXT_ARR_CHANGED_PROPERTY[i]) {
/* 242 */           this.taxTextLabelArr_[i].setText((String)event.getNewValue());
/*     */         }
/* 244 */         if (propertyName == PosTransactionSummaryConstants.TAX_TEXT_ARR_FONT_CHANGED_PROPERTY[i]) {
/* 245 */           this.taxTextLabelArr_[i].setFont((Font)event.getNewValue());
/*     */         }
/* 247 */         if (propertyName == PosTransactionSummaryConstants.TAX_TEXT_ARR_COLOR_CHANGED_PROPERTY[i]) {
/* 248 */           this.taxTextLabelArr_[i].setForeground((Color)event.getNewValue());
/*     */         }
/* 250 */         if (propertyName == PosTransactionSummaryConstants.TAX_AMOUNT_ARR_CHANGED_PROPERTY[i]) {
/* 251 */           this.taxAmountLabelArr_[i].setText(convertAmountToText((Number)event.getNewValue()));
/*     */         }
/* 253 */         if (propertyName == PosTransactionSummaryConstants.TAX_AMOUNT_ARR_FONT_CHANGED_PROPERTY[i]) {
/* 254 */           this.taxAmountLabelArr_[i].setFont((Font)event.getNewValue());
/*     */         }
/* 256 */         if (propertyName == PosTransactionSummaryConstants.TAX_AMOUNT_ARR_COLOR_CHANGED_PROPERTY[i]) {
/* 257 */           this.taxAmountLabelArr_[i].setForeground((Color)event.getNewValue());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createBalanceLabel() {
/* 264 */     PosPrettyLabel label = createLabel();
/* 265 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createCashTotalLabel() {
/* 269 */     PosPrettyLabel label = createLabel();
/* 270 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createFeesLabel() {
/* 274 */     PosPrettyLabel label = createLabel();
/* 275 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createGstTaxLabel() {
/* 279 */     return PosComponentFactory.getInstance().createPrettyLabel();
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createSoldItemCountLabel() {
/* 283 */     PosPrettyLabel label = createLabel();
/* 284 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createSubtotalLabel() {
/* 288 */     PosPrettyLabel label = createLabel();
/* 289 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createTaxLabel() {
/* 293 */     PosPrettyLabel label = createLabel();
/* 294 */     return label;
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel createTotalLabel() {
/* 298 */     PosPrettyLabel label = createLabel();
/* 299 */     return label;
/*     */   }
/*     */   
/*     */   protected void initializeComponents(PosTransactionSummary summary) {
/* 303 */     this.taxLen_ = summary.getTaxLines();
/* 304 */     this.taxTextLabelArr_ = new PosPrettyLabel[this.taxLen_];
/* 305 */     this.taxAmountLabelArr_ = new PosPrettyLabel[this.taxLen_];
/*     */     
/* 307 */     if (this.subtotalTextLabel_ == null) {
/* 308 */       this.subtotalTextLabel_ = createSubtotalLabel();
/*     */     }
/* 310 */     if (this.feesTextLabel_ == null) {
/* 311 */       this.feesTextLabel_ = createFeesLabel();
/*     */     }
/* 313 */     if (this.totalTextLabel_ == null) {
/* 314 */       this.totalTextLabel_ = createTotalLabel();
/*     */     }
/* 316 */     if (this.cashTotalTextLabel_ == null) {
/* 317 */       this.cashTotalTextLabel_ = createCashTotalLabel();
/*     */     }
/* 319 */     if (this.balanceTextLabel_ == null) {
/* 320 */       this.balanceTextLabel_ = createBalanceLabel();
/*     */     }
/* 322 */     if (this.soldItemCountTextLabel_ == null) {
/* 323 */       this.soldItemCountTextLabel_ = createSoldItemCountLabel();
/*     */     }
/* 325 */     if (this.subtotalAmountLabel_ == null) {
/* 326 */       this.subtotalAmountLabel_ = createSubtotalLabel();
/*     */     }
/* 328 */     if (this.feesAmountLabel_ == null) {
/* 329 */       this.feesAmountLabel_ = createFeesLabel();
/*     */     }
/* 331 */     if (this.totalAmountLabel_ == null) {
/* 332 */       this.totalAmountLabel_ = createTotalLabel();
/*     */     }
/* 334 */     if (this.cashTotalAmountLabel_ == null) {
/* 335 */       this.cashTotalAmountLabel_ = createCashTotalLabel();
/*     */     }
/* 337 */     if (this.balanceAmountLabel_ == null) {
/* 338 */       this.balanceAmountLabel_ = createBalanceLabel();
/*     */     }
/*     */     
/* 341 */     for (int i = 0; i < this.taxLen_; i++) {
/* 342 */       if (this.taxTextLabelArr_[i] == null) {
/* 343 */         this.taxTextLabelArr_[i] = createTaxLabel();
/*     */       }
/* 345 */       if (this.taxAmountLabelArr_[i] == null) {
/* 346 */         this.taxAmountLabelArr_[i] = createTaxLabel();
/*     */       }
/*     */     } 
/*     */     
/* 350 */     Color disabledTextColor = UIServices.getNonLookAndFeelColor(summary.getDisabledForeground());
/*     */     
/* 352 */     this.subtotalTextLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.subtotalText")));
/* 353 */     this.feesTextLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.feesText")));
/* 354 */     this.totalTextLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.totalText")));
/* 355 */     this.balanceTextLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.balanceText")));
/* 356 */     this.soldItemCountTextLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.soldItemCountText")));
/*     */     
/* 358 */     this.subtotalAmountLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.subtotalAmount")));
/* 359 */     this.feesAmountLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.feesAmount")));
/* 360 */     this.totalAmountLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.totalAmount")));
/* 361 */     this.balanceAmountLabel_.setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.balanceAmount")));
/*     */     
/* 363 */     Color cashTotalLabelColor = UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.cashTotalText"));
/* 364 */     cashTotalLabelColor = (cashTotalLabelColor == null) ? new Color(0, 0, 255) : cashTotalLabelColor;
/* 365 */     this.cashTotalTextLabel_.setForeground(cashTotalLabelColor);
/*     */     
/* 367 */     Color cashTotalAmountColor = UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.cashTotalAmount"));
/* 368 */     cashTotalAmountColor = (cashTotalAmountColor == null) ? new Color(0, 0, 255) : cashTotalAmountColor;
/* 369 */     this.cashTotalAmountLabel_.setForeground(cashTotalAmountColor);
/*     */     int j;
/* 371 */     for (j = 0; j < this.taxLen_; j++) {
/* 372 */       this.taxTextLabelArr_[j].setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.taxTextArr")));
/* 373 */       this.taxAmountLabelArr_[j].setForeground(UIServices.getNonLookAndFeelColor(UIManager.getColor("PosTransactionSummary.taxAmountArr")));
/*     */     } 
/*     */     
/* 376 */     this.subtotalTextLabel_.setDisabledForeground(disabledTextColor);
/* 377 */     this.feesTextLabel_.setDisabledForeground(disabledTextColor);
/* 378 */     this.totalTextLabel_.setDisabledForeground(disabledTextColor);
/* 379 */     this.cashTotalTextLabel_.setDisabledForeground(disabledTextColor);
/* 380 */     this.balanceTextLabel_.setDisabledForeground(disabledTextColor);
/* 381 */     this.soldItemCountTextLabel_.setDisabledForeground(disabledTextColor);
/*     */     
/* 383 */     this.subtotalAmountLabel_.setDisabledForeground(disabledTextColor);
/* 384 */     this.feesAmountLabel_.setDisabledForeground(disabledTextColor);
/* 385 */     this.totalAmountLabel_.setDisabledForeground(disabledTextColor);
/* 386 */     this.cashTotalAmountLabel_.setDisabledForeground(disabledTextColor);
/* 387 */     this.balanceAmountLabel_.setDisabledForeground(disabledTextColor);
/*     */     
/* 389 */     for (j = 0; j < this.taxLen_; j++) {
/* 390 */       this.taxTextLabelArr_[j].setDisabledForeground(disabledTextColor);
/* 391 */       this.taxAmountLabelArr_[j].setDisabledForeground(disabledTextColor);
/*     */     } 
/*     */     
/* 394 */     this.subtotalTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.subtotalTextFont")));
/* 395 */     this.feesTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.feesTextFont")));
/* 396 */     this.totalTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.totalTextFont")));
/* 397 */     this.balanceTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.balanceTextFont")));
/* 398 */     this.soldItemCountTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.soldItemCountTextFont")));
/*     */     
/* 400 */     this.subtotalAmountLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.subtotalAmountFont")));
/* 401 */     this.feesAmountLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.feesAmountFont")));
/* 402 */     this.totalAmountLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.totalAmountFont")));
/* 403 */     this.balanceAmountLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.balanceAmountFont")));
/* 404 */     this.cashTotalTextLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.cashTotalTextFont")));
/* 405 */     this.cashTotalAmountLabel_.setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.cashTotalAmountFont")));
/*     */     
/* 407 */     for (j = 0; j < this.taxLen_; j++) {
/* 408 */       this.taxTextLabelArr_[j].setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.taxTextFont")));
/* 409 */       this.taxAmountLabelArr_[j].setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosTransactionSummary.taxAmountFont")));
/*     */     } 
/*     */     
/* 412 */     this.subtotalTextLabel_.setText(summary.getSubtotalText());
/* 413 */     this.feesTextLabel_.setText(summary.getFeesText());
/* 414 */     this.totalTextLabel_.setText(summary.getTotalText());
/* 415 */     this.cashTotalTextLabel_.setText(summary.getCashTotalText());
/* 416 */     this.balanceTextLabel_.setText(summary.getBalanceText());
/* 417 */     this.soldItemCountTextLabel_.setText(summary.getSoldItemCountText());
/*     */     
/* 419 */     this.subtotalAmountLabel_.setText(StringUtils.nonNull(summary.getSubtotalAmount()));
/* 420 */     this.feesAmountLabel_.setText(StringUtils.nonNull(summary.getFeesAmount()));
/* 421 */     this.totalAmountLabel_.setText(StringUtils.nonNull(summary.getTotalAmount()));
/* 422 */     this.cashTotalAmountLabel_.setText(StringUtils.nonNull(convertDecimalToText(summary.getCashTotalAmount())));
/* 423 */     this.balanceAmountLabel_.setText(StringUtils.nonNull(summary.getBalanceAmount()));
/*     */     
/* 425 */     String[] taxTextArr = summary.getTaxTextArr();
/* 426 */     BigDecimal[] taxAmountArr = summary.getTaxAmountArr();
/* 427 */     if (taxTextArr == null) {
/* 428 */       taxTextArr = new String[2];
/* 429 */       taxTextArr[0] = "";
/* 430 */       taxTextArr[1] = "";
/*     */     } 
/* 432 */     if (taxAmountArr == null) {
/* 433 */       taxAmountArr = new BigDecimal[2];
/* 434 */       taxAmountArr[0] = NumberUtils.ZERO;
/* 435 */       taxAmountArr[1] = NumberUtils.ZERO;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void installDefaults(JPanel p) {
/* 441 */     super.installDefaults(p);
/*     */     
/* 443 */     separatorColor_ = UIManager.getColor("PosTransactionSummary.separatorColor");
/* 444 */     disabledSeparatorColor_ = UIManager.getColor("PosTransactionSummary.disabledSeparatorColor");
/*     */     
/* 446 */     PosTransactionSummary summary = (PosTransactionSummary)p;
/*     */     
/* 448 */     initializeComponents(summary);
/* 449 */     layoutComponents(summary);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void installPropertyKeys() {
/* 454 */     super.installPropertyKeys();
/*     */     
/* 456 */     getProperties().setPropertyKey("shape", "PosTransactionSummary.shape");
/* 457 */     getProperties().setPropertyKey("paint", "PosTransactionSummary.paint");
/* 458 */     getProperties().setPropertyKey("background", "PosTransactionSummary.background");
/* 459 */     getProperties().setPropertyKey("highlight", "PosTransactionSummary.highlight");
/* 460 */     getProperties().setPropertyKey("foreground", "PosTransactionSummary.text");
/* 461 */     getProperties().setPropertyKey("disabledBackground", "PosTransactionSummary.disabledBackground");
/* 462 */     getProperties().setPropertyKey("disabledHighlight", "PosTransactionSummary.disabledHighlight");
/* 463 */     getProperties().setPropertyKey("disabledForeground", "PosTransactionSummary.disabledText");
/* 464 */     getProperties().setPropertyKey("font", "PosTransactionSummary.font");
/* 465 */     getProperties().setPropertyKey("border", "PosTransactionSummary.border");
/* 466 */     getProperties().setPropertyKey("isDisplayedWhenDisabled", "PosTransactionSummary.isDisplayedWhenDisabled");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutComponents(PosTransactionSummary summary) {
/* 471 */     int feesRowModifier = ConfigurationMgr.isFeesLineDisplayed() ? 1 : 0;
/* 472 */     int cashTotalRowModifier = summary.isCashTotalDisplayed() ? 1 : 0;
/* 473 */     int subtotalRow = 0;
/* 474 */     int feesRow = subtotalRow + feesRowModifier;
/* 475 */     int taxRowModifier = feesRow + 1;
/* 476 */     int totalRow = taxRowModifier + ((this.taxLen_ == 0) ? this.taxLen_ : (this.taxLen_ - 1)) + 1;
/* 477 */     int cashTotalRow = totalRow + cashTotalRowModifier;
/* 478 */     int balanceRow = cashTotalRow + 1;
/*     */     
/* 480 */     int numberOfRows = balanceRow + 1;
/*     */     
/* 482 */     summary.setLayout((LayoutManager)new TableLayout(10, numberOfRows));
/*     */     
/* 484 */     if (summary.getComponentOrientation().isLeftToRight()) {
/* 485 */       summary.add((Component)this.subtotalTextLabel_, new TableLayoutConstraints(0, subtotalRow, 6, 1, 3, 3));
/* 486 */       summary.add((Component)this.subtotalAmountLabel_, new TableLayoutConstraints(6, subtotalRow, 4, 1, 3, 3));
/*     */       
/* 488 */       if (ConfigurationMgr.isFeesLineDisplayed()) {
/* 489 */         summary.add((Component)this.feesTextLabel_, new TableLayoutConstraints(0, feesRow, 6, 1, 3, 3));
/* 490 */         summary.add((Component)this.feesAmountLabel_, new TableLayoutConstraints(6, feesRow, 4, 1, 3, 3));
/*     */       } 
/*     */       
/* 493 */       for (int i = 0; i < this.taxLen_; i++) {
/* 494 */         summary.add((Component)this.taxTextLabelArr_[i], new TableLayoutConstraints(0, i + taxRowModifier, 6, 1, 3, 3));
/*     */         
/* 496 */         summary.add((Component)this.taxAmountLabelArr_[i], new TableLayoutConstraints(6, i + taxRowModifier, 4, 1, 3, 3));
/*     */       } 
/*     */ 
/*     */       
/* 500 */       summary.add((Component)this.totalTextLabel_, new TableLayoutConstraints(0, totalRow, 6, 1, 3, 3));
/* 501 */       summary.add((Component)this.totalAmountLabel_, new TableLayoutConstraints(6, totalRow, 4, 1, 3, 3));
/*     */       
/* 503 */       if (summary.isCashTotalDisplayed()) {
/* 504 */         summary.add((Component)this.cashTotalTextLabel_, new TableLayoutConstraints(0, cashTotalRow, 6, 1, 3, 3));
/* 505 */         summary.add((Component)this.cashTotalAmountLabel_, new TableLayoutConstraints(6, cashTotalRow, 4, 1, 3, 3));
/*     */       } 
/*     */       
/* 508 */       summary.add((Component)this.balanceTextLabel_, new TableLayoutConstraints(0, balanceRow, 6, 1, 3, 3));
/* 509 */       summary.add((Component)this.balanceAmountLabel_, new TableLayoutConstraints(6, balanceRow, 4, 1, 3, 3));
/* 510 */       summary.add((Component)this.soldItemCountTextLabel_, new TableLayoutConstraints(0, balanceRow, 3, 1, 0, 3));
/*     */     } else {
/*     */       
/* 513 */       summary.add((Component)this.subtotalTextLabel_, new TableLayoutConstraints(1, subtotalRow, 4, 1, 0, 3));
/* 514 */       summary.add((Component)this.subtotalAmountLabel_, new TableLayoutConstraints(0, subtotalRow, 1, 1, 0, 3));
/*     */       
/* 516 */       if (ConfigurationMgr.isFeesLineDisplayed()) {
/* 517 */         summary.add((Component)this.feesTextLabel_, new TableLayoutConstraints(1, feesRow, 4, 1, 0, 3));
/* 518 */         summary.add((Component)this.feesAmountLabel_, new TableLayoutConstraints(0, feesRow, 1, 1, 0, 3));
/*     */       } 
/*     */       
/* 521 */       for (int i = 0; i < this.taxLen_; i++) {
/* 522 */         summary.add((Component)this.taxTextLabelArr_[i], new TableLayoutConstraints(0, i + taxRowModifier, 6, 1, 3, 3));
/*     */         
/* 524 */         summary.add((Component)this.taxAmountLabelArr_[i], new TableLayoutConstraints(6, i + taxRowModifier, 4, 1, 3, 3));
/*     */       } 
/*     */ 
/*     */       
/* 528 */       summary.add((Component)this.totalTextLabel_, new TableLayoutConstraints(1, totalRow, 4, 1, 0, 3));
/* 529 */       summary.add((Component)this.totalAmountLabel_, new TableLayoutConstraints(0, totalRow, 1, 1, 0, 3));
/*     */       
/* 531 */       if (summary.isCashTotalDisplayed()) {
/* 532 */         summary.add((Component)this.cashTotalTextLabel_, new TableLayoutConstraints(3, cashTotalRow, 4, 1, 0, 3));
/* 533 */         summary.add((Component)this.cashTotalAmountLabel_, new TableLayoutConstraints(1, cashTotalRow, 3, 1, 0, 3));
/*     */       } 
/*     */       
/* 536 */       summary.add((Component)this.balanceTextLabel_, new TableLayoutConstraints(1, balanceRow, 4, 1, 0, 3));
/* 537 */       summary.add((Component)this.balanceAmountLabel_, new TableLayoutConstraints(0, balanceRow, 1, 1, 0, 3));
/* 538 */       summary.add((Component)this.soldItemCountTextLabel_, new TableLayoutConstraints(5, balanceRow, 2, 1, 3, 3));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void uninstallDefaults(JPanel p) {
/* 544 */     super.uninstallDefaults(p);
/* 545 */     p.removeAll();
/*     */   }
/*     */   
/*     */   private PosPrettyLabel createLabel() {
/* 549 */     PosPrettyLabel label = PosComponentFactory.getInstance().createPrettyLabel();
/* 550 */     label.setHorizontalAlignment(11);
/* 551 */     return label;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\PosTransactionSummaryUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */