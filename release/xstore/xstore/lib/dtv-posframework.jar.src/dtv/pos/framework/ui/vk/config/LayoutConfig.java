/*     */ package dtv.pos.framework.ui.vk.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.KeyboardButtonPanel;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.lang3.LocaleUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class LayoutConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(LayoutConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private static final String ATT_LAYOUT_NAME = "name";
/*     */   
/*     */   private static final String ATT_LOCALE = "locale";
/*     */   private static final String TAG_PANEL = "panel";
/*  34 */   public static final Locale LOCALE_DEFAULT = Locale.ENGLISH;
/*     */   
/*     */   private String name_;
/*  37 */   private final List<PanelConfig<KeyboardButtonPanel>> panels_ = new ArrayList<>();
/*     */   
/*  39 */   private double maxRowCount_ = 0.0D;
/*  40 */   private int panelCount_ = 0;
/*  41 */   private Locale locale_ = LOCALE_DEFAULT;
/*  42 */   private int buttonCount_ = 0;
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  46 */     if (obj != null && obj instanceof LayoutConfig) {
/*  47 */       LayoutConfig compare = (LayoutConfig)obj;
/*  48 */       return getName().equalsIgnoreCase(compare.getName());
/*     */     } 
/*     */     
/*  51 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String generateButtonId() {
/*  59 */     return "Button" + ++this.buttonCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getButtonCount() {
/*  67 */     return this.buttonCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/*  75 */     return this.locale_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaxRowCount() {
/*  83 */     return this.maxRowCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  91 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PanelConfig<KeyboardButtonPanel>> getPanelConfigurations() {
/*  99 */     return this.panels_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return getName().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 112 */     if (argKey.equalsIgnoreCase("name")) {
/* 113 */       this.name_ = OnScreenKeyboard.getTranslation(argValue.toString());
/*     */     }
/*     */     
/* 116 */     if (argKey.equalsIgnoreCase("locale")) {
/* 117 */       this.locale_ = LocaleUtils.toLocale(argValue.toString());
/*     */       
/* 119 */       if (this.locale_ == null) {
/* 120 */         logger_.warn("Could not load locale '" + argValue.toString() + "'.");
/* 121 */         this.locale_ = LOCALE_DEFAULT;
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     if (argKey.equalsIgnoreCase("panel") && argValue instanceof PanelConfig) {
/* 126 */       PanelConfig<KeyboardButtonPanel> value = (PanelConfig<KeyboardButtonPanel>)argValue;
/* 127 */       value.setParentLayout(this);
/* 128 */       value.setId(this.panelCount_++);
/* 129 */       this.panels_.add(value);
/* 130 */       this.maxRowCount_ = (value.getRowCount() > this.maxRowCount_) ? value.getRowCount() : this.maxRowCount_;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\LayoutConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */