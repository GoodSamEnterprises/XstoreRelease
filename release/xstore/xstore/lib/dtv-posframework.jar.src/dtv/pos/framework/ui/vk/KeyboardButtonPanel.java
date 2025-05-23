/*     */ package dtv.pos.framework.ui.vk;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.config.ButtonConfig;
/*     */ import dtv.pos.framework.ui.vk.config.PanelConfig;
/*     */ import dtv.pos.framework.ui.vk.config.RowConfig;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
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
/*     */ public abstract class KeyboardButtonPanel
/*     */   extends KeyboardPanel
/*     */   implements IKeyboardButtonPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final PanelConfig<KeyboardButtonPanel> panelConfig_;
/*  28 */   private List<KeyboardButton> buttons_ = new ArrayList<>();
/*  29 */   private List<KeyboardButton> modifiables_ = new ArrayList<>();
/*  30 */   private List<KeyboardButton> modifiers_ = new ArrayList<>();
/*     */   
/*     */   private IKeyboardDesign keyboardDesign_;
/*  33 */   private Map<String, Object> values_ = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyboardButtonPanel(PanelConfig<KeyboardButtonPanel> panelConfig, IKeyboardDesign argDesign) {
/*  41 */     this.panelConfig_ = panelConfig;
/*  42 */     this.keyboardDesign_ = argDesign;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<IKeyboardButtonPanel> getButtonPanels() {
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<KeyboardButton> getButtons() {
/*  54 */     return this.buttons_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<KeyboardButton> getModifiables() {
/*  60 */     return this.modifiables_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<KeyboardButton> getModifiers() {
/*  66 */     return this.modifiers_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String field) {
/*  71 */     return this.values_.get(field);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadButtons() {
/*  77 */     for (RowConfig row : this.panelConfig_.getRowConfigurations()) {
/*  78 */       for (ButtonConfig config : row.getButtonConfigurations()) {
/*  79 */         KeyboardButton button = createKeyboardButton(config);
/*  80 */         if (isModifiable(button)) {
/*  81 */           this.modifiables_.add(button);
/*     */         }
/*  83 */         if (button.isModifier()) {
/*  84 */           this.modifiers_.add(button);
/*     */         }
/*  86 */         this.buttons_.add(button);
/*  87 */         add((Component)button);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(String field, Object value) {
/*  94 */     this.values_.put(field, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected KeyboardButton createKeyboardButton(ButtonConfig config) {
/* 103 */     KeyboardButton button = new KeyboardButton(config, this.keyboardDesign_);
/* 104 */     button.setBounds(this.keyboardDesign_.getButtonBound(config.getId()));
/* 105 */     button.initUI();
/* 106 */     return button;
/*     */   }
/*     */   
/*     */   protected boolean isModifiable(KeyboardButton argButton) {
/* 110 */     if (!argButton.isModifier() && (argButton
/* 111 */       .getConfiguredKeyStroke().length() == 1 || OnScreenKeyboard.getTranslation(argButton
/* 112 */         .getConfiguredKeyStroke(), argButton.getConfiguredLocale()).length() == 1) && 
/*     */       
/* 114 */       !argButton.getConfiguredKeyStroke().toLowerCase().equals(argButton.getConfiguredKeyStroke().toUpperCase())) {
/* 115 */       return true;
/*     */     }
/*     */     
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isSlideToNext() {
/* 122 */     if (getValue("SLIDING_TO_NEXT") != null && getValue("SLIDING_TO_NEXT") instanceof Boolean) {
/* 123 */       return ((Boolean)getValue("SLIDING_TO_NEXT")).booleanValue();
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {}
/*     */ 
/*     */   
/*     */   protected void paintSlide(Graphics g) {
/* 133 */     g.setColor(this.keyboardDesign_.getButtonPanelBackground());
/* 134 */     int xStart = getX() + getSlidingX();
/* 135 */     if (isSlideToNext()) {
/* 136 */       xStart = (int)(xStart - this.keyboardDesign_.getBounds().getWidth());
/*     */     }
/* 138 */     g.fillRect(xStart, getSlidingY(), getWidth(), getSlidingHeight());
/*     */     
/* 140 */     for (KeyboardButton button : this.buttons_) {
/* 141 */       button.setSlidingRectangle(getSlidingX(), getSlidingY(), getSlidingWidth(), getSlidingHeight());
/* 142 */       button.setValue("SLIDING_TO_NEXT", Boolean.valueOf(isSlideToNext()));
/* 143 */       button.paintSlide(g);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardButtonPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */