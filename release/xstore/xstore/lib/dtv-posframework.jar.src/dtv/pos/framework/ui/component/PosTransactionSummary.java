/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.pos.ui.component.PosPrettyPanel;
/*     */ import dtv.pos.ui.plaf.component.PosComponentUIType;
/*     */ import dtv.pos.ui.plaf.component.PosTransactionSummaryConstants;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.math.BigDecimal;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ public class PosTransactionSummary
/*     */   extends PosPrettyPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int taxLen_;
/*     */   private final boolean showCashTotal_;
/*     */   private final TextChangeListener subtotalChangeListener_;
/*     */   private final TextChangeListener feesChangeListener_;
/*     */   private final TextChangeListener totalChangeListener_;
/*     */   private final TextChangeListener balanceChangeListener_;
/*     */   private final TextChangeListener soldItemCountChangeListener_;
/*     */   private final TextChangeListener[] taxArrChangeListener_;
/*     */   private final TextChangeListener cashTotalChangeListener_;
/*     */   private MutableString subtotalText_;
/*     */   private MutableString feesText_;
/*     */   private MutableString totalText_;
/*     */   private MutableString balanceText_;
/*     */   private MutableString soldItemCountText_;
/*     */   private MutableString cashTotalText_;
/*     */   private BigDecimal subtotalAmount_;
/*     */   private BigDecimal feesAmount_;
/*     */   private BigDecimal totalAmount_;
/*     */   private BigDecimal balanceAmount_;
/*     */   private BigDecimal soldItemCount_;
/*     */   private BigDecimal cashTotalAmount_;
/*     */   private Color subtotalTextColor_;
/*     */   private Color subtotalAmountColor_;
/*     */   private Color feesTextColor_;
/*     */   private Color feesAmountColor_;
/*     */   private Color totalTextColor_;
/*     */   private Color totalAmountColor_;
/*     */   private Color taxTextColor_;
/*     */   private Color taxAmountColor_;
/*     */   private Color balanceTextColor_;
/*     */   private Color balanceAmountColor_;
/*     */   private Color soldItemCountTextColor_;
/*     */   private Color cashTotalTextColor_;
/*     */   private Color cashTotalAmountColor_;
/*     */   private Font subtotalTextFont_;
/*     */   private Font subtotalAmountFont_;
/*     */   private Font feesTextFont_;
/*     */   private Font feesAmountFont_;
/*     */   private Font totalTextFont_;
/*     */   private Font totalAmountFont_;
/*     */   private Font cashTotalTextFont_;
/*     */   private Font cashTotalAmountFont_;
/*     */   private Font taxTextFont_;
/*     */   private Font taxAmountFont_;
/*     */   private Font balanceTextFont_;
/*     */   private Font balanceAmountFont_;
/*     */   private Font soldItemCountTextFont_;
/*     */   private MutableString[] taxTextArr_;
/*     */   private String[] taxTextArrStr_;
/*     */   private BigDecimal[] taxAmountArr_;
/*     */   
/*     */   public PosTransactionSummary(int taxLines, boolean showCashTotal) {
/*  73 */     this.taxLen_ = taxLines;
/*  74 */     this.showCashTotal_ = showCashTotal;
/*     */     
/*  76 */     updateUI();
/*  77 */     this.subtotalChangeListener_ = new TextChangeListener("subtotalTextChanged");
/*     */     
/*  79 */     this.feesChangeListener_ = new TextChangeListener("feesTextChanged");
/*  80 */     this.totalChangeListener_ = new TextChangeListener("totalTextChanged");
/*  81 */     this.balanceChangeListener_ = new TextChangeListener("balanceTextChanged");
/*     */     
/*  83 */     this.soldItemCountChangeListener_ = new TextChangeListener("soldItemCountTextChanged");
/*     */     
/*  85 */     this.taxArrChangeListener_ = new TextChangeListener[taxLines];
/*     */     
/*  87 */     for (int i = 0; i < this.taxLen_; i++) {
/*  88 */       this.taxArrChangeListener_[i] = new TextChangeListener(PosTransactionSummaryConstants.TAX_TEXT_ARR_CHANGED_PROPERTY[i]);
/*     */     }
/*     */ 
/*     */     
/*  92 */     this.cashTotalChangeListener_ = new TextChangeListener("cashTotalTextChanged");
/*     */ 
/*     */     
/*  95 */     this.taxTextArr_ = new MutableString[this.taxLen_];
/*  96 */     this.taxTextArrStr_ = new String[this.taxLen_];
/*  97 */     this.taxAmountArr_ = new BigDecimal[this.taxLen_];
/*     */   }
/*     */   
/*     */   public BigDecimal getBalanceAmount() {
/* 101 */     return this.balanceAmount_;
/*     */   }
/*     */   
/*     */   public Color getBalanceAmountColor() {
/* 105 */     return this.balanceAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getBalanceAmountFont() {
/* 109 */     return this.balanceAmountFont_;
/*     */   }
/*     */   
/*     */   public String getBalanceText() {
/* 113 */     return StringUtils.nonNull(this.balanceText_);
/*     */   }
/*     */   
/*     */   public Color getBalanceTextColor() {
/* 117 */     return this.balanceTextColor_;
/*     */   }
/*     */   
/*     */   public Font getBalanceTextFont() {
/* 121 */     return this.balanceTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal getCashTotalAmount() {
/* 125 */     return this.cashTotalAmount_;
/*     */   }
/*     */   
/*     */   public Color getCashTotalAmountColor() {
/* 129 */     return this.cashTotalAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getCashTotalAmountFont() {
/* 133 */     return this.cashTotalAmountFont_;
/*     */   }
/*     */   
/*     */   public String getCashTotalText() {
/* 137 */     return StringUtils.nonNull(this.cashTotalText_);
/*     */   }
/*     */   
/*     */   public Color getCashTotalTextColor() {
/* 141 */     return this.cashTotalTextColor_;
/*     */   }
/*     */   
/*     */   public Font getCashTotalTextFont() {
/* 145 */     return this.cashTotalTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal getFeesAmount() {
/* 149 */     return this.feesAmount_;
/*     */   }
/*     */   
/*     */   public Color getFeesAmountColor() {
/* 153 */     return this.feesAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getFeesAmountFont() {
/* 157 */     return this.feesAmountFont_;
/*     */   }
/*     */   
/*     */   public MutableString getFeesText() {
/* 161 */     return this.feesText_;
/*     */   }
/*     */   
/*     */   public Color getFeesTextColor() {
/* 165 */     return this.feesTextColor_;
/*     */   }
/*     */   
/*     */   public Font getFeesTextFont() {
/* 169 */     return this.feesTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal getSoldItemCount() {
/* 173 */     return this.soldItemCount_;
/*     */   }
/*     */   
/*     */   public String getSoldItemCountText() {
/* 177 */     return StringUtils.nonNull(this.soldItemCountText_);
/*     */   }
/*     */   
/*     */   public Color getSoldItemCountTextColor() {
/* 181 */     return this.soldItemCountTextColor_;
/*     */   }
/*     */   
/*     */   public Font getSoldItemCountTextFont() {
/* 185 */     return this.soldItemCountTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal getSubtotalAmount() {
/* 189 */     return this.subtotalAmount_;
/*     */   }
/*     */   
/*     */   public Color getSubtotalAmountColor() {
/* 193 */     return this.subtotalAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getSubtotalAmountFont() {
/* 197 */     return this.subtotalAmountFont_;
/*     */   }
/*     */   
/*     */   public String getSubtotalText() {
/* 201 */     return StringUtils.nonNull(this.subtotalText_);
/*     */   }
/*     */   
/*     */   public Color getSubtotalTextColor() {
/* 205 */     return this.subtotalTextColor_;
/*     */   }
/*     */   
/*     */   public Font getSubtotalTextFont() {
/* 209 */     return this.subtotalTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal[] getTaxAmountArr() {
/* 213 */     return this.taxAmountArr_;
/*     */   }
/*     */   
/*     */   public Color getTaxAmountArrColor() {
/* 217 */     return this.taxAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getTaxAmountArrFont() {
/* 221 */     return this.taxAmountFont_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTaxLines() {
/* 226 */     return this.taxLen_;
/*     */   }
/*     */   
/*     */   public String[] getTaxTextArr() {
/* 230 */     if (this.taxTextArrStr_ == null && this.taxTextArr_ != null) {
/* 231 */       this.taxTextArrStr_ = new String[this.taxLen_];
/* 232 */       for (int i = 0; i < this.taxLen_; i++) {
/* 233 */         this.taxTextArrStr_[i] = StringUtils.nonNull(this.taxTextArr_[i]);
/*     */       }
/*     */     } 
/* 236 */     return this.taxTextArrStr_;
/*     */   }
/*     */   
/*     */   public Color getTaxTextArrColor() {
/* 240 */     return this.taxTextColor_;
/*     */   }
/*     */   
/*     */   public Font getTaxTextArrFont() {
/* 244 */     return this.taxTextFont_;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalAmount() {
/* 248 */     return this.totalAmount_;
/*     */   }
/*     */   
/*     */   public Color getTotalAmountColor() {
/* 252 */     return this.totalAmountColor_;
/*     */   }
/*     */   
/*     */   public Font getTotalAmountFont() {
/* 256 */     return this.totalAmountFont_;
/*     */   }
/*     */   
/*     */   public String getTotalText() {
/* 260 */     return StringUtils.nonNull(this.totalText_);
/*     */   }
/*     */   
/*     */   public Color getTotalTextColor() {
/* 264 */     return this.totalTextColor_;
/*     */   }
/*     */   
/*     */   public Font getTotalTextFont() {
/* 268 */     return this.totalTextFont_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUIClassID() {
/* 273 */     return PosComponentUIType.TRANSACTION_SUMMARY.toString();
/*     */   }
/*     */   
/*     */   public boolean isCashTotalDisplayed() {
/* 277 */     return this.showCashTotal_;
/*     */   }
/*     */   
/*     */   public void setBalanceAmount(BigDecimal balanceAmount) {
/* 281 */     BigDecimal oldValue = getBalanceAmount();
/*     */     
/* 283 */     if (!balanceAmount.equals(oldValue)) {
/* 284 */       this.balanceAmount_ = balanceAmount;
/* 285 */       firePropertyChange("balanceAmountChanged", oldValue, balanceAmount);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBalanceAmountColor(Color argBalanceAmountColor) {
/* 291 */     Color oldValue = getBalanceAmountColor();
/*     */     
/* 293 */     Color balanceAmountColor = (argBalanceAmountColor == null) ? getForeground() : argBalanceAmountColor;
/*     */     
/* 295 */     if (!balanceAmountColor.equals(oldValue)) {
/* 296 */       this.balanceAmountColor_ = balanceAmountColor;
/* 297 */       firePropertyChange("balanceAmountColorChanged", oldValue, balanceAmountColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBalanceAmountFont(Font argBalanceAmountFont) {
/* 303 */     Font oldValue = getBalanceAmountFont();
/*     */     
/* 305 */     Font balanceAmountFont = (argBalanceAmountFont == null) ? getFont() : argBalanceAmountFont;
/*     */     
/* 307 */     if (!balanceAmountFont.equals(oldValue)) {
/* 308 */       this.balanceAmountFont_ = balanceAmountFont;
/* 309 */       firePropertyChange("balanceAmountFontChanged", oldValue, balanceAmountFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBalanceText(MutableString newBalanceText) {
/* 315 */     if (newBalanceText != this.balanceText_) {
/* 316 */       if (this.balanceText_ != null) {
/* 317 */         this.balanceText_.removeChangeListener(this.balanceChangeListener_);
/*     */       }
/* 319 */       if (newBalanceText != null) {
/* 320 */         newBalanceText.addChangeListener(this.balanceChangeListener_);
/* 321 */         this.balanceChangeListener_.textChanged(newBalanceText.toString());
/*     */       } 
/* 323 */       this.balanceText_ = newBalanceText;
/*     */       
/* 325 */       revalidate();
/* 326 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBalanceTextColor(Color argBalanceTextColor) {
/* 331 */     Color oldValue = getBalanceTextColor();
/*     */     
/* 333 */     Color balanceTextColor = (argBalanceTextColor == null) ? getForeground() : argBalanceTextColor;
/*     */     
/* 335 */     if (!balanceTextColor.equals(oldValue)) {
/* 336 */       this.balanceTextColor_ = balanceTextColor;
/* 337 */       firePropertyChange("balanceTextColorChanged", oldValue, balanceTextColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBalanceTextFont(Font argBalanceTextFont) {
/* 343 */     Font oldValue = getBalanceTextFont();
/*     */     
/* 345 */     Font balanceTextFont = (argBalanceTextFont == null) ? getFont() : argBalanceTextFont;
/*     */     
/* 347 */     if (!balanceTextFont.equals(oldValue)) {
/* 348 */       this.balanceTextFont_ = balanceTextFont;
/* 349 */       firePropertyChange("balanceTextFontChanged", oldValue, balanceTextFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCashTotalAmount(BigDecimal cashTotalAmount) {
/* 355 */     BigDecimal oldValue = getCashTotalAmount();
/*     */     
/* 357 */     if (!cashTotalAmount.equals(oldValue)) {
/* 358 */       this.cashTotalAmount_ = cashTotalAmount;
/* 359 */       firePropertyChange("cashTotalAmountChanged", oldValue, cashTotalAmount);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCashTotalAmountColor(Color argCashTotalAmountColor) {
/* 365 */     Color oldValue = getCashTotalAmountColor();
/*     */ 
/*     */     
/* 368 */     Color cashTotalAmountColor = (argCashTotalAmountColor == null) ? getForeground() : argCashTotalAmountColor;
/*     */     
/* 370 */     if (!cashTotalAmountColor.equals(oldValue)) {
/* 371 */       this.cashTotalAmountColor_ = cashTotalAmountColor;
/* 372 */       firePropertyChange("cashTotalAmountColorChanged", oldValue, cashTotalAmountColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCashTotalAmountFont(Font argCashTotalAmountFont) {
/* 378 */     Font oldValue = getCashTotalAmountFont();
/*     */     
/* 380 */     Font cashTotalAmountFont = (argCashTotalAmountFont == null) ? getFont() : argCashTotalAmountFont;
/*     */     
/* 382 */     if (!cashTotalAmountFont.equals(oldValue)) {
/* 383 */       this.cashTotalAmountFont_ = cashTotalAmountFont;
/* 384 */       firePropertyChange("cashTotalAmountFontChanged", oldValue, cashTotalAmountFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCashTotalText(MutableString newCashTotalText) {
/* 390 */     if (newCashTotalText != this.cashTotalText_) {
/* 391 */       if (this.cashTotalText_ != null) {
/* 392 */         this.cashTotalText_.removeChangeListener(this.cashTotalChangeListener_);
/*     */       }
/* 394 */       if (newCashTotalText != null) {
/* 395 */         newCashTotalText.addChangeListener(this.cashTotalChangeListener_);
/* 396 */         this.cashTotalChangeListener_.textChanged(newCashTotalText.toString());
/*     */       } 
/* 398 */       this.cashTotalText_ = newCashTotalText;
/*     */       
/* 400 */       revalidate();
/* 401 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCashTotalTextColor(Color argCashTotalTextColor) {
/* 406 */     Color oldValue = getCashTotalTextColor();
/*     */     
/* 408 */     Color cashTotalTextColor = (argCashTotalTextColor == null) ? getForeground() : argCashTotalTextColor;
/*     */     
/* 410 */     if (!cashTotalTextColor.equals(oldValue)) {
/* 411 */       this.cashTotalTextColor_ = cashTotalTextColor;
/* 412 */       firePropertyChange("cashTotalTextColorChanged", oldValue, cashTotalTextColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCashTotalTextFont(Font argCashTotalTextFont) {
/* 418 */     Font oldValue = getCashTotalTextFont();
/*     */     
/* 420 */     Font cashTotalTextFont = (argCashTotalTextFont == null) ? getFont() : argCashTotalTextFont;
/*     */     
/* 422 */     if (!cashTotalTextFont.equals(oldValue)) {
/* 423 */       this.cashTotalTextFont_ = cashTotalTextFont;
/* 424 */       firePropertyChange("cashTotalTextFontChanged", oldValue, cashTotalTextFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFeesAmount(BigDecimal argFeesAmount) {
/* 430 */     BigDecimal oldValue = getFeesAmount();
/*     */     
/* 432 */     if (!argFeesAmount.equals(oldValue)) {
/* 433 */       this.feesAmount_ = argFeesAmount;
/* 434 */       firePropertyChange("feesAmountChanged", oldValue, argFeesAmount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFeesAmountColor(Color argFeesAmountColor) {
/* 439 */     Color oldValue = getFeesAmountColor();
/*     */     
/* 441 */     Color feesAmountColor = (argFeesAmountColor == null) ? getForeground() : argFeesAmountColor;
/*     */     
/* 443 */     if (!feesAmountColor.equals(oldValue)) {
/* 444 */       this.feesAmountColor_ = feesAmountColor;
/* 445 */       firePropertyChange("feesAmountColorChanged", oldValue, feesAmountColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFeesAmountFont(Font argFeesAmountFont) {
/* 450 */     Font oldValue = getFeesAmountFont();
/*     */     
/* 452 */     Font feesAmountFont = (argFeesAmountFont == null) ? getFont() : argFeesAmountFont;
/*     */     
/* 454 */     if (!feesAmountFont.equals(oldValue)) {
/* 455 */       this.feesAmountFont_ = feesAmountFont;
/* 456 */       firePropertyChange("feesAmountFontChanged", oldValue, feesAmountFont);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFeesText(MutableString argFeesText) {
/* 461 */     if (argFeesText != this.feesText_) {
/* 462 */       if (this.feesText_ != null) {
/* 463 */         this.feesText_.removeChangeListener(this.feesChangeListener_);
/*     */       }
/*     */       
/* 466 */       if (argFeesText != null) {
/* 467 */         argFeesText.addChangeListener(this.feesChangeListener_);
/* 468 */         this.feesChangeListener_.textChanged(argFeesText.toString());
/*     */       } 
/*     */       
/* 471 */       this.feesText_ = argFeesText;
/*     */       
/* 473 */       revalidate();
/* 474 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFeesTextColor(Color argFeesTextColor) {
/* 479 */     Color oldValue = getFeesTextColor();
/*     */     
/* 481 */     Color feesTextColor = (argFeesTextColor == null) ? getForeground() : argFeesTextColor;
/*     */     
/* 483 */     if (!feesTextColor.equals(oldValue)) {
/* 484 */       this.feesTextColor_ = feesTextColor;
/* 485 */       firePropertyChange("feesTextColorChanged", oldValue, feesTextColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFeesTextFont(Font argFeesTextFont) {
/* 490 */     Font oldValue = getFeesTextFont();
/*     */     
/* 492 */     Font feesTextFont = (argFeesTextFont == null) ? getFont() : argFeesTextFont;
/*     */     
/* 494 */     if (!feesTextFont.equals(oldValue)) {
/* 495 */       this.feesTextFont_ = feesTextFont;
/* 496 */       firePropertyChange("feesTextFontChanged", oldValue, feesTextFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 502 */     super.setFont(font);
/*     */     
/* 504 */     setSubtotalTextFont(font);
/* 505 */     setTotalTextFont(font);
/* 506 */     setCashTotalTextFont(font);
/* 507 */     setBalanceTextFont(font);
/* 508 */     setSoldItemCountTextFont(font);
/*     */     
/* 510 */     setSubtotalAmountFont(font);
/* 511 */     setCashTotalAmountFont(font);
/* 512 */     setTotalAmountFont(font);
/* 513 */     setBalanceAmountFont(font);
/*     */     
/* 515 */     setTaxTextArrFont(font);
/* 516 */     setTaxAmountArrFont(font);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setForeground(Color color) {
/* 521 */     super.setForeground(color);
/*     */     
/* 523 */     setSubtotalTextColor(color);
/* 524 */     setTotalTextColor(color);
/* 525 */     setBalanceTextColor(color);
/* 526 */     setSoldItemCountTextColor(color);
/* 527 */     setCashTotalTextColor(color);
/*     */     
/* 529 */     setSubtotalAmountColor(color);
/* 530 */     setTotalAmountColor(color);
/* 531 */     setBalanceAmountColor(color);
/* 532 */     setCashTotalAmountColor(color);
/*     */     
/* 534 */     setTaxTextArrColor(color);
/* 535 */     setTaxAmountArrColor(color);
/*     */   }
/*     */   
/*     */   public void setSoldItemCount(BigDecimal soldItemCount) {
/* 539 */     BigDecimal oldValue = getSoldItemCount();
/*     */     
/* 541 */     if (!soldItemCount.equals(oldValue)) {
/* 542 */       this.soldItemCount_ = soldItemCount;
/* 543 */       firePropertyChange("soldItemCountChanged", oldValue, soldItemCount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSoldItemCountText(MutableString newSoldItemCountText) {
/* 548 */     if (newSoldItemCountText != this.soldItemCountText_) {
/* 549 */       if (this.soldItemCountText_ != null) {
/* 550 */         this.soldItemCountText_.removeChangeListener(this.soldItemCountChangeListener_);
/*     */       }
/*     */       
/* 553 */       if (newSoldItemCountText != null) {
/* 554 */         newSoldItemCountText.addChangeListener(this.soldItemCountChangeListener_);
/* 555 */         this.soldItemCountChangeListener_.textChanged(newSoldItemCountText.toString());
/*     */       } 
/*     */       
/* 558 */       this.soldItemCountText_ = newSoldItemCountText;
/*     */       
/* 560 */       revalidate();
/* 561 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSoldItemCountTextColor(Color argSoldItemCountTextColor) {
/* 566 */     Color oldValue = getSoldItemCountTextColor();
/*     */ 
/*     */     
/* 569 */     Color soldItemCountTextColor = (argSoldItemCountTextColor == null) ? getForeground() : argSoldItemCountTextColor;
/*     */     
/* 571 */     if (!soldItemCountTextColor.equals(oldValue)) {
/* 572 */       this.soldItemCountTextColor_ = soldItemCountTextColor;
/* 573 */       firePropertyChange("soldItemCountTextColorChanged", oldValue, soldItemCountTextColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSoldItemCountTextFont(Font argSoldItemCountTextFont) {
/* 578 */     Font oldValue = getSoldItemCountTextFont();
/*     */ 
/*     */     
/* 581 */     Font soldItemCountTextFont = (argSoldItemCountTextFont == null) ? getFont() : argSoldItemCountTextFont;
/*     */     
/* 583 */     if (!soldItemCountTextFont.equals(oldValue)) {
/* 584 */       this.soldItemCountTextFont_ = soldItemCountTextFont;
/* 585 */       firePropertyChange("soldItemCountTextFontChanged", oldValue, soldItemCountTextFont);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalAmount(BigDecimal subtotalAmount) {
/* 590 */     BigDecimal oldValue = getSubtotalAmount();
/* 591 */     if (!ObjectUtils.equivalent(subtotalAmount, oldValue)) {
/* 592 */       this.subtotalAmount_ = subtotalAmount;
/* 593 */       firePropertyChange("subtotalAmountChanged", oldValue, subtotalAmount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalAmountColor(Color argSubtotalAmountColor) {
/* 598 */     Color oldValue = getSubtotalAmountColor();
/*     */     
/* 600 */     Color subtotalAmountColor = (argSubtotalAmountColor == null) ? getForeground() : argSubtotalAmountColor;
/*     */     
/* 602 */     if (!subtotalAmountColor.equals(oldValue)) {
/* 603 */       this.subtotalAmountColor_ = subtotalAmountColor;
/* 604 */       firePropertyChange("subtotalAmountColorChanged", oldValue, subtotalAmountColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalAmountFont(Font argSubtotalAmountFont) {
/* 609 */     Font oldValue = getSubtotalAmountFont();
/*     */     
/* 611 */     Font subtotalAmountFont = (argSubtotalAmountFont == null) ? getFont() : argSubtotalAmountFont;
/*     */     
/* 613 */     if (!subtotalAmountFont.equals(oldValue)) {
/* 614 */       this.subtotalAmountFont_ = subtotalAmountFont;
/* 615 */       firePropertyChange("subtotalAmountFontChanged", oldValue, subtotalAmountFont);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalText(MutableString newSubtotalText) {
/* 620 */     if (newSubtotalText != this.subtotalText_) {
/* 621 */       if (this.subtotalText_ != null) {
/* 622 */         this.subtotalText_.removeChangeListener(this.subtotalChangeListener_);
/*     */       }
/*     */       
/* 625 */       if (newSubtotalText != null) {
/* 626 */         newSubtotalText.addChangeListener(this.subtotalChangeListener_);
/* 627 */         this.subtotalChangeListener_.textChanged(newSubtotalText.toString());
/*     */       } 
/*     */       
/* 630 */       this.subtotalText_ = newSubtotalText;
/*     */       
/* 632 */       revalidate();
/* 633 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalTextColor(Color argSubtotalTextColor) {
/* 638 */     Color oldValue = getSubtotalTextColor();
/*     */     
/* 640 */     Color subtotalTextColor = (argSubtotalTextColor == null) ? getForeground() : argSubtotalTextColor;
/*     */     
/* 642 */     if (!subtotalTextColor.equals(oldValue)) {
/* 643 */       this.subtotalTextColor_ = subtotalTextColor;
/* 644 */       firePropertyChange("subtotalTextColorChanged", oldValue, subtotalTextColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSubtotalTextFont(Font argSubtotalTextFont) {
/* 649 */     Font oldValue = getSubtotalTextFont();
/*     */     
/* 651 */     Font subtotalTextFont = (argSubtotalTextFont == null) ? getFont() : argSubtotalTextFont;
/*     */     
/* 653 */     if (!subtotalTextFont.equals(oldValue)) {
/* 654 */       this.subtotalTextFont_ = subtotalTextFont;
/* 655 */       firePropertyChange("subtotalTextFontChanged", oldValue, subtotalTextFont);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxAmountArr(BigDecimal[] taxAmount) {
/* 660 */     if (taxAmount != null) {
/* 661 */       BigDecimal[] oldValue = getTaxAmountArr();
/* 662 */       for (int i = 0; i < taxAmount.length; i++) {
/* 663 */         if (oldValue != null) {
/* 664 */           if (taxAmount[i] != null && oldValue[i] != null) {
/* 665 */             if (!taxAmount[i].equals(oldValue[i]))
/*     */             {
/*     */ 
/*     */               
/* 669 */               firePropertyChange(PosTransactionSummaryConstants.TAX_AMOUNT_ARR_CHANGED_PROPERTY[i], oldValue[i], taxAmount[i]);
/*     */             
/*     */             }
/*     */           }
/* 673 */           else if (taxAmount[i] != null || oldValue[i] != null) {
/*     */ 
/*     */             
/* 676 */             firePropertyChange(PosTransactionSummaryConstants.TAX_AMOUNT_ARR_CHANGED_PROPERTY[i], NumberUtils.ZERO, taxAmount[i]);
/*     */           } 
/*     */         }
/*     */       } 
/* 680 */       this.taxAmountArr_ = taxAmount;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxAmountArrColor(Color argTaxAmountColor) {
/* 685 */     Color oldValue = getTaxAmountArrColor();
/*     */     
/* 687 */     Color taxAmountColor = (argTaxAmountColor == null) ? getForeground() : argTaxAmountColor;
/*     */     
/* 689 */     if (!taxAmountColor.equals(oldValue)) {
/* 690 */       this.taxAmountColor_ = taxAmountColor;
/* 691 */       for (int i = 0; i < this.taxLen_; i++) {
/* 692 */         firePropertyChange(PosTransactionSummaryConstants.TAX_AMOUNT_ARR_COLOR_CHANGED_PROPERTY[i], oldValue, taxAmountColor);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxAmountArrFont(Font argTaxAmountFont) {
/* 698 */     Font oldValue = getTaxAmountArrFont();
/*     */     
/* 700 */     Font taxAmountFont = (argTaxAmountFont == null) ? getFont() : argTaxAmountFont;
/*     */     
/* 702 */     if (!taxAmountFont.equals(oldValue)) {
/* 703 */       this.taxAmountFont_ = taxAmountFont;
/* 704 */       for (int i = 0; i < this.taxLen_; i++) {
/* 705 */         firePropertyChange(PosTransactionSummaryConstants.TAX_AMOUNT_ARR_FONT_CHANGED_PROPERTY[i], oldValue, taxAmountFont);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxTextArr(MutableString[] newTaxText) {
/* 711 */     if (newTaxText != null) {
/* 712 */       int i; for (i = 0; i < newTaxText.length; i++) {
/* 713 */         if (this.taxTextArr_[i] != null && newTaxText[i] != null && 
/* 714 */           newTaxText[i] != this.taxTextArr_[i]) {
/* 715 */           this.taxTextArr_[i].removeChangeListener(this.taxArrChangeListener_[i]);
/*     */         }
/*     */       } 
/*     */       
/* 719 */       for (i = 0; i < newTaxText.length; i++) {
/* 720 */         if (newTaxText[i] != null) {
/* 721 */           if (!newTaxText[i].equals(this.taxTextArr_[i])) {
/* 722 */             newTaxText[i].addChangeListener(this.taxArrChangeListener_[i]);
/* 723 */             this.taxArrChangeListener_[i].textChanged(newTaxText[i].toString());
/* 724 */             revalidate();
/* 725 */             repaint();
/*     */           }
/*     */         
/*     */         }
/* 729 */         else if (this.taxTextArr_[i] != null) {
/* 730 */           newTaxText[i] = new MutableString("");
/* 731 */           newTaxText[i].addChangeListener(this.taxArrChangeListener_[i]);
/* 732 */           this.taxArrChangeListener_[i].textChanged(newTaxText[i].toString());
/* 733 */           revalidate();
/* 734 */           repaint();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 739 */       this.taxTextArr_ = newTaxText;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxTextArrColor(Color argTaxTextColor) {
/* 744 */     Color oldValue = getTaxTextArrColor();
/*     */     
/* 746 */     Color taxTextColor = (argTaxTextColor == null) ? getForeground() : argTaxTextColor;
/*     */     
/* 748 */     if (!taxTextColor.equals(oldValue)) {
/* 749 */       this.taxTextColor_ = taxTextColor;
/*     */       
/* 751 */       for (int i = 0; i < this.taxLen_; i++) {
/* 752 */         firePropertyChange(PosTransactionSummaryConstants.TAX_TEXT_ARR_COLOR_CHANGED_PROPERTY[i], oldValue, taxTextColor);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTaxTextArrFont(Font argTaxTextFont) {
/* 758 */     Font oldValue = getTaxTextArrFont();
/*     */     
/* 760 */     Font taxTextFont = (argTaxTextFont == null) ? getFont() : argTaxTextFont;
/*     */     
/* 762 */     if (!taxTextFont.equals(oldValue)) {
/* 763 */       this.taxTextFont_ = taxTextFont;
/*     */       
/* 765 */       for (int i = 0; i < this.taxLen_; i++) {
/* 766 */         firePropertyChange(PosTransactionSummaryConstants.TAX_TEXT_ARR_FONT_CHANGED_PROPERTY[i], oldValue, taxTextFont);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalAmount(BigDecimal totalAmount) {
/* 772 */     BigDecimal oldValue = getTotalAmount();
/*     */     
/* 774 */     if (!totalAmount.equals(oldValue)) {
/* 775 */       this.totalAmount_ = totalAmount;
/* 776 */       firePropertyChange("totalAmountChanged", oldValue, totalAmount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalAmountColor(Color argTotalAmountColor) {
/* 781 */     Color oldValue = getTotalAmountColor();
/*     */     
/* 783 */     Color totalAmountColor = (argTotalAmountColor == null) ? getForeground() : argTotalAmountColor;
/*     */     
/* 785 */     if (!totalAmountColor.equals(oldValue)) {
/* 786 */       this.totalAmountColor_ = totalAmountColor;
/* 787 */       firePropertyChange("totalAmountColorChanged", oldValue, totalAmountColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalAmountFont(Font argTotalAmountFont) {
/* 792 */     Font oldValue = getTotalAmountFont();
/*     */     
/* 794 */     Font totalAmountFont = (argTotalAmountFont == null) ? getFont() : argTotalAmountFont;
/*     */     
/* 796 */     if (!totalAmountFont.equals(oldValue)) {
/* 797 */       this.totalAmountFont_ = totalAmountFont;
/* 798 */       firePropertyChange("totalAmountFontChanged", oldValue, totalAmountFont);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalText(MutableString newTotalText) {
/* 803 */     if (newTotalText != this.totalText_) {
/* 804 */       if (this.totalText_ != null) {
/* 805 */         this.totalText_.removeChangeListener(this.totalChangeListener_);
/*     */       }
/*     */       
/* 808 */       if (newTotalText != null) {
/* 809 */         newTotalText.addChangeListener(this.totalChangeListener_);
/* 810 */         this.totalChangeListener_.textChanged(newTotalText.toString());
/*     */       } 
/*     */       
/* 813 */       this.totalText_ = newTotalText;
/*     */       
/* 815 */       revalidate();
/* 816 */       repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalTextColor(Color argTotalTextColor) {
/* 821 */     Color oldValue = getTotalTextColor();
/*     */     
/* 823 */     Color totalTextColor = (argTotalTextColor == null) ? getForeground() : argTotalTextColor;
/* 824 */     if (!totalTextColor.equals(oldValue)) {
/* 825 */       this.totalTextColor_ = totalTextColor;
/* 826 */       firePropertyChange("totalTextColorChanged", oldValue, totalTextColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTotalTextFont(Font argTotalTextFont) {
/* 831 */     Font oldValue = getTotalTextFont();
/*     */     
/* 833 */     Font totalTextFont = (argTotalTextFont == null) ? getFont() : argTotalTextFont;
/*     */     
/* 835 */     if (!totalTextFont.equals(oldValue)) {
/* 836 */       this.totalTextFont_ = totalTextFont;
/* 837 */       firePropertyChange("totalTextFontChanged", oldValue, totalTextFont);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void firePropertyChange(String argPropertyName, Object argOldValue, Object argNewValue) {
/* 844 */     super.firePropertyChange(argPropertyName, argOldValue, argNewValue);
/*     */   }
/*     */   
/*     */   protected class TextChangeListener
/*     */     implements ChangeListener
/*     */   {
/*     */     private final String propertyName_;
/*     */     
/*     */     public TextChangeListener(String propertyName) {
/* 853 */       this.propertyName_ = propertyName;
/*     */     }
/*     */ 
/*     */     
/*     */     public void stateChanged(ChangeEvent event) {
/* 858 */       textChanged(event.getSource().toString());
/*     */     }
/*     */     
/*     */     public void textChanged(String text) {
/* 862 */       PosTransactionSummary.this.firePropertyChange(this.propertyName_, (Object)null, text);
/*     */       
/* 864 */       PosTransactionSummary.this.revalidate();
/* 865 */       PosTransactionSummary.this.repaint();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\PosTransactionSummary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */