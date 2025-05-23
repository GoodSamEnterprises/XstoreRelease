/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.form.design.type.FontSize;
/*     */ import dtv.pos.iframework.ui.FontStyle;
/*     */ import dtv.pos.iframework.ui.config.IFontConfig;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.awt.Font;
/*     */ import java.io.IOException;
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
/*     */ public class FontRefConfig
/*     */   extends AbstractParentConfig
/*     */   implements IFontConfig, IReflectionParameterCapable<Font>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String MAIN_TAG = "FontRef";
/*     */   private static final String FONT_KEY_TAG = "FontKey";
/*     */   private static final String FONT_STYLE_TAG = "FontStyle";
/*     */   private static final String FONT_SIZE_TAG = "FontSize";
/*  36 */   private static final FontSize DEFAULT_SIZE = FontSize.DEFAULT;
/*     */   
/*  38 */   private static final Logger logger_ = Logger.getLogger(FontRefConfig.class);
/*     */   
/*     */   private String fontKey_;
/*     */   private FontStyle fontStyle_;
/*  42 */   private FontSize fontSize_ = DEFAULT_SIZE;
/*     */ 
/*     */   
/*     */   private String fontStyleRaw_;
/*     */   
/*     */   private String fontSizeRaw_;
/*     */ 
/*     */   
/*     */   public FontRefConfig() {
/*  51 */     this.fontStyle_ = FontStyle.DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FontRefConfig(String key) {
/*  61 */     setValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  66 */     if (!(sourceConfig instanceof FontRefConfig)) {
/*  67 */       logger_.error("Attempted to cascade from invalid configuration object!");
/*     */       return;
/*     */     } 
/*  70 */     FontRefConfig fontConfig = (FontRefConfig)sourceConfig;
/*     */     
/*  72 */     if (!StringUtils.isEmpty(fontConfig.fontKey_)) {
/*  73 */       this.fontKey_ = fontConfig.fontKey_;
/*     */     }
/*  75 */     if (!FontStyle.DEFAULT.equals(fontConfig.fontStyle_)) {
/*  76 */       this.fontStyle_ = fontConfig.fontStyle_;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  82 */     if (obj == this) {
/*  83 */       return true;
/*     */     }
/*  85 */     if (!(obj instanceof FontRefConfig)) {
/*  86 */       return false;
/*     */     }
/*  88 */     return ObjectUtils.equivalent(this.fontKey_, ((FontRefConfig)obj).fontKey_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  94 */     return "Font";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/* 100 */     Font font = getFont();
/* 101 */     if (font != null) {
/* 102 */       return font.toString();
/*     */     }
/* 104 */     return this.fontKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 113 */     return getFont((Font)null);
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
/*     */   public Font getFont(Font baseFont) {
/* 127 */     int defaultStyle = (baseFont != null) ? baseFont.getStyle() : -1;
/* 128 */     Font font = null;
/*     */     
/*     */     try {
/* 131 */       font = UIResourceManager.getInstance().getFont(this.fontKey_, this.fontStyle_.getFontStyle(defaultStyle));
/*     */       
/* 133 */       if (this.fontSize_ != null) {
/* 134 */         font = font.deriveFont(this.fontSize_.getSize(font.getSize()));
/*     */       }
/*     */     }
/* 137 */     catch (Exception ex) {
/* 138 */       logger_.debug("CAUGHT EXCEPTION", ex);
/* 139 */       return baseFont;
/*     */     } 
/*     */     
/* 142 */     return font;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<Font> getParamDataType() {
/* 148 */     return Font.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getParamValue() {
/* 154 */     return getFont();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 159 */     return this.fontKey_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 170 */     if (argKey.equalsIgnoreCase("FontKey")) {
/* 171 */       this.fontKey_ = argValue.toString();
/*     */     }
/* 173 */     else if (argKey.equalsIgnoreCase("FontStyle")) {
/* 174 */       this.fontStyle_ = FontStyle.forName(argValue);
/* 175 */       this.fontStyleRaw_ = argValue.toString();
/*     */     }
/* 177 */     else if (argKey.equalsIgnoreCase("FontSize")) {
/* 178 */       setFontSize(argValue.toString());
/* 179 */       setClean();
/*     */     } else {
/*     */       
/* 182 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFontSize(String size) {
/* 187 */     this.fontSize_ = FontSize.get(size);
/* 188 */     this.fontSizeRaw_ = size;
/* 189 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 194 */     return this.fontKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter writer) throws IOException {
/* 201 */     writer.writeHeader("FontRef", "FontRef");
/* 202 */     writer.writeValue("FontSize", "String", this.fontSizeRaw_);
/* 203 */     writer.writeValue("FontKey", "String", this.fontKey_);
/* 204 */     writer.writeValue("FontStyle", "String", this.fontStyleRaw_);
/* 205 */     writer.writeFooter("FontRef");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\FontRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */