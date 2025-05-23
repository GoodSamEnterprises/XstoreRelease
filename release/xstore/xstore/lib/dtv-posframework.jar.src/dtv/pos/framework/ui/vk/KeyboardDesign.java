/*     */ package dtv.pos.framework.ui.vk;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.config.ButtonConfig;
/*     */ import dtv.pos.framework.ui.vk.config.LayoutConfig;
/*     */ import dtv.pos.framework.ui.vk.config.PanelConfig;
/*     */ import dtv.pos.framework.ui.vk.config.RowConfig;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class KeyboardDesign
/*     */   implements IKeyboardDesign
/*     */ {
/*     */   public static final double kbdHeightRatio = 0.15337423312883436D;
/*     */   public static final double kbdHorizontalButtonSpacingRatio = 0.044682752457551385D;
/*     */   public static final double kbdHorizontalButtonPanelMarginRatio = 0.5617977528089888D;
/*     */   public static final double kbdVertialButtonSpacingRatio = 0.044444444444444446D;
/*     */   public static final double kbdVertialButtonPanelMarginRatio = 0.2331002331002331D;
/*     */   public static final double kbdSlideOutButtonWidthToKbdWidthRatio = 0.053385416666666664D;
/*     */   public static final double kbdSlideOutButtonHeightToOwnerHeightRatio = 0.0380859375D;
/*     */   private Rectangle ownerBounds_;
/*     */   private Rectangle keyboardBounds_;
/*     */   private List<Rectangle> panelBounds_;
/*     */   private Map<String, Rectangle> buttonBounds_;
/*     */   private LayoutConfig layout_;
/*     */   private Dimension buttonSize_;
/*     */   private Rectangle slideOutButtonBounds_;
/*     */   
/*     */   public KeyboardDesign(Rectangle argOwnerBounds, LayoutConfig argLayout) {
/*  58 */     this.ownerBounds_ = new Rectangle(argOwnerBounds);
/*  59 */     this.layout_ = argLayout;
/*  60 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getBackgroundColor() {
/*  66 */     return COLOR_KBD_BACKGROUND;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBounds() {
/*  72 */     if (this.keyboardBounds_ == null) {
/*  73 */       this.keyboardBounds_ = calculateKeyboardBounds();
/*     */     }
/*  75 */     return new Rectangle(this.keyboardBounds_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getButtonBound(String argId) {
/*  81 */     if (this.buttonBounds_ == null) {
/*  82 */       this.buttonBounds_ = calculateButtonBounds(calculateButtonWidth(), calculateButtonHeight());
/*     */     }
/*  84 */     return new Rectangle(this.buttonBounds_.get(argId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getButtonPanelBackground() {
/*  90 */     return COLOR_BUTTON_PANEL_BACKGROUND;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getButtonSize() {
/*  96 */     if (this.buttonSize_ == null) {
/*  97 */       this.buttonSize_ = calculateButtonSize();
/*     */     }
/*  99 */     return new Dimension(this.buttonSize_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 105 */     return FONT_MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getLineSeparatorColor() {
/* 111 */     return COLOR_SEPARATOR_LINE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Rectangle> getPanelBounds() {
/* 117 */     if (this.panelBounds_ == null) {
/* 118 */       this.panelBounds_ = calculatePanelBounds(calculateButtonWidth());
/*     */     }
/* 120 */     return this.panelBounds_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getSlideOutButtonBounds() {
/* 126 */     if (this.slideOutButtonBounds_ == null) {
/* 127 */       this.slideOutButtonBounds_ = calculateSlideOutButtonBounds(calculateKeyboardBounds());
/*     */     }
/* 129 */     return this.slideOutButtonBounds_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getTextColor() {
/* 135 */     return COLOR_KBD_TEXT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerBounds(Rectangle argOwnerBounds) {
/* 141 */     this.ownerBounds_ = new Rectangle(argOwnerBounds);
/* 142 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Rectangle calculateButtonBounds(ButtonConfig config, double buttonWidth, double buttonHeight) {
/* 152 */     return new Rectangle(calculateButtonLocation(config, buttonWidth, buttonHeight), calculateButtonSize(config, buttonWidth, buttonHeight));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, Rectangle> calculateButtonBounds(double buttonWidth, double buttonHeight) {
/* 162 */     Map<String, Rectangle> bounds = new HashMap<>();
/*     */     
/* 164 */     for (PanelConfig<KeyboardButtonPanel> panel : (Iterable<PanelConfig<KeyboardButtonPanel>>)this.layout_.getPanelConfigurations()) {
/* 165 */       for (RowConfig row : panel.getRowConfigurations()) {
/* 166 */         for (ButtonConfig button : row.getButtonConfigurations()) {
/* 167 */           bounds.put(button.getId(), calculateButtonBounds(button, buttonWidth, buttonHeight));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 172 */     return bounds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonHeight() {
/* 180 */     double maxRowCount = this.layout_.getMaxRowCount();
/*     */     
/* 182 */     double totalKeyboardHeight = maxRowCount + (maxRowCount - 1.0D) * 0.044444444444444446D + 0.4662004662004662D;
/*     */ 
/*     */     
/* 185 */     return calculateKeyboardSize().getHeight() / totalKeyboardHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonHeight(ButtonConfig button, double btnHeight) {
/* 195 */     double height = button.getHeight() * btnHeight;
/* 196 */     if (button.isHeightInRows()) {
/* 197 */       return calculateButtonVerticalSpacing(btnHeight) * (button.getHeight() - 1.0D) + height;
/*     */     }
/* 199 */     return height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonHorizontalSpacing() {
/* 207 */     return calculateButtonHorizontalSpacing(calculateButtonWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonHorizontalSpacing(double btnWidth) {
/* 216 */     return 0.044682752457551385D * btnWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Point calculateButtonLocation(ButtonConfig button, double buttonWidth, double buttonHeight) {
/* 227 */     double maxRowWidth = calculateRowWidth(button.getParentRow().getParentPanel().getMaxRowWidth(), buttonWidth);
/* 228 */     double rowWidth = calculateRowWidth(button.getParentRow(), buttonWidth);
/* 229 */     double startingX = 0.0D;
/* 230 */     switch (button.getParentRow().getAlignment()) {
/*     */       case CENTERED:
/* 232 */         startingX = calculatePanelHorizontalMargin(buttonWidth) + (maxRowWidth - rowWidth) / 2.0D;
/*     */         break;
/*     */       
/*     */       case RIGHT:
/* 236 */         startingX = calculatePanelHorizontalMargin(buttonWidth) + maxRowWidth - rowWidth;
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/* 241 */         startingX = calculatePanelHorizontalMargin(buttonWidth);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 246 */     double x = startingX;
/*     */     
/* 248 */     for (ButtonConfig config : button.getParentRow().getButtonConfigurations()) {
/* 249 */       if (config.equals(button)) {
/*     */         break;
/*     */       }
/*     */       
/* 253 */       x += calculateButtonWidth(config, buttonWidth) + calculateButtonHorizontalSpacing(buttonWidth);
/*     */     } 
/*     */ 
/*     */     
/* 257 */     double y = 0.0D;
/* 258 */     y += calculatePanelVerticalMargin(buttonHeight);
/*     */     
/* 260 */     for (int i = 0; i < button.getParentRow().getRowOrder(); i++) {
/* 261 */       y += buttonHeight;
/* 262 */       y += calculateButtonVerticalSpacing(buttonHeight);
/*     */     } 
/*     */     
/* 265 */     return new Point((int)Math.round(x), (int)Math.round(y));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Dimension calculateButtonSize() {
/* 273 */     return new Dimension((int)Math.round(calculateButtonWidth()), (int)Math.round(calculateButtonHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Dimension calculateButtonSize(ButtonConfig button, double buttonWidth, double buttonHeight) {
/* 283 */     return new Dimension((int)Math.round(calculateButtonWidth(button, buttonWidth)), 
/* 284 */         (int)Math.round(calculateButtonHeight(button, buttonHeight)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonVerticalSpacing(double btnHeight) {
/* 293 */     return btnHeight * 0.044444444444444446D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonWidth() {
/* 301 */     double totalButtonLength = 0.0D;
/*     */     
/* 303 */     for (PanelConfig<KeyboardButtonPanel> panel : (Iterable<PanelConfig<KeyboardButtonPanel>>)this.layout_.getPanelConfigurations()) {
/* 304 */       totalButtonLength += panel.getMaxRowWidth();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 309 */     double totalKeyboardLength = totalButtonLength + (totalButtonLength - this.layout_.getPanelConfigurations().size()) * 0.044682752457551385D + (2 * this.layout_.getPanelConfigurations().size()) * 0.5617977528089888D;
/*     */ 
/*     */     
/* 312 */     return calculateKeyboardSize().getWidth() / totalKeyboardLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonWidth(ButtonConfig button) {
/* 321 */     return calculateButtonWidth(button, calculateButtonWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateButtonWidth(ButtonConfig button, double btnWidth) {
/* 331 */     double thisBtnWidth = 0.0D;
/*     */     
/* 333 */     if (button.isHorizontallySpanned()) {
/*     */ 
/*     */       
/* 336 */       double maxRowWidth = calculateRowWidth(button.getParentRow().getParentPanel().getMaxRowWidth(), btnWidth);
/*     */       
/* 338 */       int countHorizontallySpanned = 0;
/* 339 */       double countKnownWidth = 0.0D;
/* 340 */       int countButtonSpacings = button.getParentRow().getButtonConfigurations().size() - 1;
/*     */       
/* 342 */       for (ButtonConfig config : button.getParentRow().getButtonConfigurations()) {
/* 343 */         if (config.isHorizontallySpanned()) {
/* 344 */           countHorizontallySpanned++;
/*     */           continue;
/*     */         } 
/* 347 */         countKnownWidth += config.getWidth();
/*     */       } 
/*     */ 
/*     */       
/* 351 */       countKnownWidth = (countKnownWidth + countButtonSpacings * 0.044682752457551385D) * btnWidth;
/*     */       
/* 353 */       thisBtnWidth = (maxRowWidth - countKnownWidth) / countHorizontallySpanned;
/*     */     } else {
/*     */       
/* 356 */       thisBtnWidth = button.getWidth() * btnWidth;
/*     */     } 
/*     */     
/* 359 */     return thisBtnWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Rectangle calculateKeyboardBounds() {
/* 367 */     return new Rectangle(calculateKeyboardLocation(), calculateKeyboardSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Point calculateKeyboardLocation() {
/* 375 */     int x = (int)this.ownerBounds_.getX();
/* 376 */     int y = (int)(this.ownerBounds_.getY() + this.ownerBounds_.getHeight() - calculateKeyboardSize().getHeight());
/*     */     
/* 378 */     return new Point(x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Dimension calculateKeyboardSize() {
/* 386 */     int width = (int)this.ownerBounds_.getWidth();
/*     */     
/* 388 */     int height = UIResourceManager.getInstance().getInt("_keyboardHeight");
/*     */     
/* 390 */     return new Dimension(width, height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Rectangle> calculatePanelBounds(double buttonWidth) {
/* 399 */     List<Rectangle> bounds = new ArrayList<>();
/*     */     
/* 401 */     for (PanelConfig<KeyboardButtonPanel> panel : (Iterable<PanelConfig<KeyboardButtonPanel>>)this.layout_.getPanelConfigurations()) {
/* 402 */       bounds.add(calculatePanelBounds(panel, buttonWidth));
/*     */     }
/*     */     
/* 405 */     return bounds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Rectangle calculatePanelBounds(PanelConfig<KeyboardButtonPanel> argPanel, double buttonWidth) {
/* 415 */     return new Rectangle(calculatePanelLocation(argPanel, buttonWidth), calculatePanelSize(argPanel, buttonWidth));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculatePanelHorizontalMargin() {
/* 424 */     return calculatePanelHorizontalMargin(calculateButtonWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculatePanelHorizontalMargin(double btnWidth) {
/* 433 */     return 0.5617977528089888D * btnWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Point calculatePanelLocation(PanelConfig<KeyboardButtonPanel> panel, double buttonWidth) {
/* 443 */     List<PanelConfig<KeyboardButtonPanel>> panels = this.layout_.getPanelConfigurations();
/* 444 */     int index = panels.indexOf(panel);
/* 445 */     double x = 0.0D;
/* 446 */     for (int i = 0; i < index; i++) {
/* 447 */       x += calculatePanelWidth(panels.get(i), buttonWidth);
/*     */     }
/*     */     
/* 450 */     return new Point((int)Math.round(x), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Dimension calculatePanelSize(PanelConfig<KeyboardButtonPanel> panel, double buttonWidth) {
/* 460 */     return new Dimension((int)Math.round(calculatePanelWidth(panel, buttonWidth)), 
/* 461 */         (int)Math.round(calculateKeyboardSize().getHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculatePanelVerticalMargin(double btnHeight) {
/* 470 */     return btnHeight * 0.2331002331002331D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculatePanelWidth(PanelConfig<KeyboardButtonPanel> panel) {
/* 479 */     return calculatePanelWidth(panel, calculateButtonWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculatePanelWidth(PanelConfig<KeyboardButtonPanel> panel, double btnWidth) {
/* 489 */     return calculateRowWidth(panel.getMaxRowWidth(), btnWidth) + 2.0D * calculatePanelHorizontalMargin(btnWidth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateRowWidth(double btnRowLength) {
/* 499 */     return calculateRowWidth(btnRowLength, calculateButtonWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateRowWidth(double btnRowLength, double btnWidth) {
/* 510 */     return btnRowLength * btnWidth + (btnRowLength - 1.0D) * calculateButtonHorizontalSpacing(btnWidth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateRowWidth(RowConfig row, double btnWidth) {
/* 520 */     double rowWidth = 0.0D;
/* 521 */     for (ButtonConfig button : row.getButtonConfigurations()) {
/* 522 */       rowWidth += calculateButtonWidth(button);
/*     */     }
/*     */     
/* 525 */     return rowWidth + (row.getButtonConfigurations().size() - 1) * calculateButtonHorizontalSpacing(btnWidth);
/*     */   }
/*     */   
/*     */   protected Rectangle calculateSlideOutButtonBounds(Rectangle kbdBounds) {
/* 529 */     int width = (int)Math.round(kbdBounds.width * 0.053385416666666664D);
/* 530 */     int height = (int)Math.round(this.ownerBounds_.height * 0.0380859375D);
/* 531 */     int x = 0;
/* 532 */     int y = kbdBounds.height - height;
/* 533 */     return new Rectangle(x, y, width, height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update() {
/* 540 */     double width = calculateButtonWidth();
/* 541 */     double height = calculateButtonHeight();
/* 542 */     this.keyboardBounds_ = calculateKeyboardBounds();
/* 543 */     if (this.keyboardBounds_.width == 0 || this.keyboardBounds_.height == 0) {
/*     */       return;
/*     */     }
/* 546 */     this.buttonSize_ = calculateButtonSize();
/* 547 */     this.panelBounds_ = calculatePanelBounds(width);
/* 548 */     this.buttonBounds_ = calculateButtonBounds(width, height);
/* 549 */     this.slideOutButtonBounds_ = calculateSlideOutButtonBounds(this.keyboardBounds_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardDesign.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */