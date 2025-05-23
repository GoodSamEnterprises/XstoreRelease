/*     */ package dtv.pos.framework.ui.vk.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Locale;
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
/*     */ public class ButtonConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String ATT_TEXT = "text";
/*     */   private static final String ATT_KEYSTROKE = "keyStroke";
/*     */   private static final String ATT_BACKGROUND = "background";
/*     */   private static final String ATT_BACKGROUND_PRESSED = "backgroundPressed";
/*     */   private static final String ATT_HORIZONTAL_SPAN = "horizontalSpan";
/*     */   private static final String ATT_HEIGHT = "height";
/*     */   private static final String ATT_WIDTH = "width";
/*     */   private static final String ATT_MODIFIER = "modifier";
/*     */   private static final String ATT_MODIFIABLE = "modifiable";
/*     */   private static final String ATT_COMPOSITE = "composite";
/*     */   private static final String ATT_KEYACTION = "keyAction";
/*     */   private RowConfig parent_;
/*     */   private String id_;
/*     */   private String text_;
/*     */   private String keyStroke_;
/*     */   private String background_;
/*     */   private String backgroundPressed_;
/*     */   private boolean horizontalSpan_;
/*  45 */   private double height_ = 1.0D;
/*  46 */   private double width_ = 1.0D;
/*     */   
/*     */   private boolean isHeightInRows_;
/*     */   
/*     */   private boolean isModifier_;
/*     */   
/*     */   private Boolean modifiable_;
/*     */   
/*     */   private boolean composite_;
/*     */   
/*     */   private String keyAction_;
/*     */   
/*     */   public ButtonConfig() {
/*  59 */     this.keyStroke_ = "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  65 */     if (obj instanceof ButtonConfig) {
/*  66 */       ButtonConfig button = (ButtonConfig)obj;
/*  67 */       return button.getId().equalsIgnoreCase(getId());
/*     */     } 
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBackgroundImageURL() {
/*  77 */     if (this.background_ != null) {
/*  78 */       return OnScreenKeyboard.getTranslation(this.background_, getLocale());
/*     */     }
/*     */     
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBackgroundPressedImageURL() {
/*  89 */     if (this.backgroundPressed_ != null) {
/*  90 */       return OnScreenKeyboard.getTranslation(this.backgroundPressed_, getLocale());
/*     */     }
/*     */     
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHeight() {
/* 101 */     return this.height_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 109 */     if (this.id_ == null) {
/* 110 */       this.id_ = this.parent_.getParentPanel().getParentLayout().generateButtonId();
/*     */     }
/* 112 */     return this.id_;
/*     */   }
/*     */   
/*     */   public String getKeyAction() {
/* 116 */     return this.keyAction_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeyStroke() {
/* 124 */     return this.keyStroke_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 132 */     return getParentRow().getParentPanel().getParentLayout().getLocale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RowConfig getParentRow() {
/* 140 */     return this.parent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 148 */     if ((this.text_ == null && this.keyStroke_.length() == 1) || isComposite()) {
/* 149 */       this.text_ = this.keyStroke_;
/*     */     }
/* 151 */     if (getKeyAction() != null && this.text_ == null) {
/* 152 */       this.text_ = "";
/*     */     }
/*     */     
/* 155 */     if (this.text_ == null || this.text_.length() > 1) {
/* 156 */       return OnScreenKeyboard.getTranslation(this.text_, getLocale());
/*     */     }
/*     */     
/* 159 */     return this.text_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getWidth() {
/* 168 */     return this.width_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 173 */     return getId().hashCode();
/*     */   }
/*     */   
/*     */   public boolean isComposite() {
/* 177 */     return this.composite_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHeightInRows() {
/* 185 */     return this.isHeightInRows_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHorizontallySpanned() {
/* 193 */     return this.horizontalSpan_;
/*     */   }
/*     */   
/*     */   public boolean isModifiable() {
/* 197 */     if (this.modifiable_ == null) {
/* 198 */       return getParentRow().isModifiable();
/*     */     }
/*     */     
/* 201 */     return this.modifiable_.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isModifier() {
/* 209 */     return this.isModifier_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 215 */     if (argKey.equalsIgnoreCase("text")) {
/* 216 */       this.text_ = argValue.toString();
/*     */     }
/* 218 */     if (argKey.equalsIgnoreCase("background")) {
/* 219 */       this.background_ = argValue.toString();
/*     */     }
/* 221 */     if (argKey.equalsIgnoreCase("backgroundPressed")) {
/* 222 */       this.backgroundPressed_ = argValue.toString();
/*     */     }
/* 224 */     if (argKey.equalsIgnoreCase("keyStroke")) {
/* 225 */       this.keyStroke_ = StringUtils.unescape(argValue.toString());
/*     */     }
/* 227 */     if (argKey.equals("horizontalSpan")) {
/* 228 */       this.horizontalSpan_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 230 */     if (argKey.equals("modifier")) {
/* 231 */       this.isModifier_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 233 */     if (argKey.equalsIgnoreCase("modifiable")) {
/* 234 */       this.modifiable_ = ConfigUtils.toBoolean(argValue.toString());
/*     */     }
/* 236 */     if (argKey.equalsIgnoreCase("composite")) {
/* 237 */       this.composite_ = ConfigUtils.toBoolean(argValue.toString()).booleanValue();
/*     */     }
/* 239 */     if (argKey.equalsIgnoreCase("keyAction")) {
/* 240 */       this.keyAction_ = argValue.toString();
/*     */     }
/* 242 */     if (argKey.equals("height")) {
/* 243 */       StringConfig stringConfig; IConfigObject value = argValue;
/* 244 */       if (argValue.toString().endsWith("r")) {
/* 245 */         this.isHeightInRows_ = true;
/*     */ 
/*     */         
/* 248 */         stringConfig = new StringConfig(argValue.toString().substring(0, argValue.toString().length() - 1).replace(" ", ""));
/*     */       } 
/*     */       
/* 251 */       this
/*     */         
/* 253 */         .height_ = (ConfigUtils.toBigDecimal((IConfigObject)stringConfig).compareTo(BigDecimal.ZERO) > 0) ? ConfigUtils.toBigDecimal((IConfigObject)stringConfig).doubleValue() : this.height_;
/*     */     } 
/* 255 */     if (argKey.equals("width")) {
/* 256 */       this
/*     */         
/* 258 */         .width_ = (ConfigUtils.toBigDecimal(argValue).compareTo(BigDecimal.ZERO) > 0) ? ConfigUtils.toBigDecimal(argValue).doubleValue() : this.width_;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentRow(RowConfig parent) {
/* 267 */     this.parent_ = parent;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\ButtonConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */