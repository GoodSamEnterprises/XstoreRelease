/*     */ package dtv.pos.framework.ui.vk;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.config.LayoutConfig;
/*     */ import dtv.pos.framework.ui.vk.config.PanelConfig;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.LayoutManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Observer;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JLayeredPane;
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
/*     */ public class KeyboardContentPane
/*     */   extends JLayeredPane
/*     */   implements IKeyboardPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int height_;
/*     */   private int width_;
/*     */   private int x_;
/*     */   private int y_;
/*     */   private List<IKeyboardButtonPanel> keyboardButtonPanels_;
/*     */   private IKeyboardDesign kbdDesign_;
/*     */   private LayoutConfig layoutConfig_;
/*     */   private Image backgroundImage_;
/*  42 */   private Map<String, Object> values_ = new HashMap<>();
/*  43 */   private List<KeyboardButton> modifiables_ = new ArrayList<>();
/*  44 */   private List<KeyboardButton> modifiers_ = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String IS_SLIDING_TO_NEXT = "SLIDING_TO_NEXT";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyboardContentPane(IKeyboardDesign argDesign, LayoutConfig argLayoutConfig) {
/*  54 */     setFocusable(false);
/*     */ 
/*     */     
/*  57 */     setBorder(BorderFactory.createEmptyBorder());
/*  58 */     setLayout((LayoutManager)null);
/*     */     
/*  60 */     this.layoutConfig_ = argLayoutConfig;
/*  61 */     this.kbdDesign_ = argDesign;
/*  62 */     this.keyboardButtonPanels_ = new ArrayList<>();
/*  63 */     for (PanelConfig<KeyboardButtonPanel> panel : (Iterable<PanelConfig<KeyboardButtonPanel>>)argLayoutConfig.getPanelConfigurations()) {
/*  64 */       KeyboardButtonPanel swingPanel = panel.getSwingPanel(argDesign);
/*  65 */       this.modifiables_.addAll(swingPanel.getModifiables());
/*  66 */       this.modifiers_.addAll(swingPanel.getModifiers());
/*  67 */       this.keyboardButtonPanels_.add(swingPanel);
/*     */     } 
/*     */     
/*  70 */     for (KeyboardButton modifier : this.modifiers_) {
/*  71 */       for (Observer modifiable : this.modifiables_) {
/*  72 */         modifier.addModifiable(modifiable);
/*     */       }
/*     */     } 
/*     */     
/*  76 */     this.backgroundImage_ = OnScreenKeyboard.getButtonImage("_imageKbdBackground");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IKeyboardButtonPanel> getButtonPanels() {
/*  82 */     return this.keyboardButtonPanels_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingHeight() {
/*  88 */     return this.height_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingWidth() {
/*  94 */     return this.width_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingX() {
/* 100 */     return this.x_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingY() {
/* 106 */     return this.y_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String field) {
/* 111 */     return this.values_.get(field);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlidingRectangle(int argX, int argY, int argWidth, int argHeight) {
/* 117 */     this.x_ = argX;
/* 118 */     this.y_ = argY;
/* 119 */     this.width_ = argWidth;
/* 120 */     this.height_ = argHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(String field, Object value) {
/* 125 */     this.values_.put(field, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IKeyboardDesign getKeyboardDesign() {
/* 133 */     return this.kbdDesign_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<KeyboardButton> getModifiables() {
/* 141 */     return this.modifiables_;
/*     */   }
/*     */   
/*     */   protected boolean isSlideToNext() {
/* 145 */     if (getValue("SLIDING_TO_NEXT") != null && getValue("SLIDING_TO_NEXT") instanceof Boolean) {
/* 146 */       return ((Boolean)getValue("SLIDING_TO_NEXT")).booleanValue();
/*     */     }
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 154 */     super.paintComponent(g);
/* 155 */     g.drawImage(this.backgroundImage_, this.x_, this.y_, this.width_, this.height_, null);
/* 156 */     g.setColor(getKeyboardDesign().getLineSeparatorColor());
/* 157 */     g.drawLine(this.x_, this.y_, this.x_ + this.width_, this.y_);
/*     */     
/* 159 */     double panelWidth = 0.0D;
/* 160 */     for (PanelConfig<KeyboardButtonPanel> panel : (Iterable<PanelConfig<KeyboardButtonPanel>>)this.layoutConfig_.getPanelConfigurations()) {
/* 161 */       panel.getSwingPanel(getKeyboardDesign()).setSlidingRectangle(this.x_, this.y_, this.width_, this.height_);
/* 162 */       panelWidth += panel.getSwingPanel(getKeyboardDesign()).getWidth();
/* 163 */       if (!panel.isLast()) {
/* 164 */         g.setColor(getKeyboardDesign().getLineSeparatorColor());
/* 165 */         double panelSlidingWidth = 0.0D;
/* 166 */         if (isSlideToNext()) {
/* 167 */           panelSlidingWidth = this.x_ + panelWidth - Math.abs(this.width_ - getWidth());
/*     */         } else {
/*     */           
/* 170 */           panelSlidingWidth = this.x_ + panelWidth;
/*     */         } 
/*     */         
/* 173 */         g.drawLine((int)Math.round(panelSlidingWidth), this.y_, (int)Math.round(panelSlidingWidth), this.y_ + this.height_);
/*     */       } 
/* 175 */       panel.getSwingPanel(getKeyboardDesign()).setValue("SLIDING_TO_NEXT", Boolean.valueOf(isSlideToNext()));
/* 176 */       panel.getSwingPanel(getKeyboardDesign()).paintSlide(g);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardContentPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */