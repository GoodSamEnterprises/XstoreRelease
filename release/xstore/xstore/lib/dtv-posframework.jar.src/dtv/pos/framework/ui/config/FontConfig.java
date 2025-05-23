/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.form.design.type.FontSize;
/*     */ import dtv.pos.iframework.ui.FontStyle;
/*     */ import dtv.pos.iframework.ui.config.IFontConfig;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.awt.Font;
/*     */ import java.io.IOException;
/*     */ import javax.swing.UIManager;
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
/*     */ 
/*     */ public final class FontConfig
/*     */   extends AbstractParentConfig
/*     */   implements IFontConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  32 */   private static final Logger logger_ = Logger.getLogger(FontConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Font";
/*     */   
/*     */   private static final String FONT_NAME_TAG = "FontName";
/*     */   
/*     */   private static final String FONT_STYLE_TAG = "FontStyle";
/*     */   private static final String FONT_SIZE_TAG = "FontSize";
/*     */   private static final String DEFAULT_NAME = "<default>";
/*  41 */   private static final FontStyle DEFAULT_STYLE = FontStyle.DEFAULT;
/*  42 */   private static final FontSize DEFAULT_SIZE = FontSize.DEFAULT;
/*     */   
/*  44 */   private String fontName_ = "<default>";
/*  45 */   private FontStyle fontStyle_ = DEFAULT_STYLE;
/*  46 */   private FontSize fontSize_ = DEFAULT_SIZE;
/*     */   
/*     */   private Font font_;
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  51 */     if (!(sourceConfig instanceof FontConfig)) {
/*  52 */       logger_.error("Attempted to cascade from invalid configuration object::" + 
/*  53 */           getSourceDescription(sourceConfig) + "-->" + getSourceDescription());
/*     */       return;
/*     */     } 
/*  56 */     FontConfig fontConfig = (FontConfig)sourceConfig;
/*     */     
/*  58 */     if (!"<default>".equalsIgnoreCase(getFontName())) {
/*  59 */       setFontName(fontConfig.getFontName());
/*     */     }
/*  61 */     if (!DEFAULT_SIZE.equals(getFontSize())) {
/*  62 */       setFontSize(fontConfig.getFontSize());
/*     */     }
/*  64 */     if (!DEFAULT_STYLE.toString().equals(getFontStyle())) {
/*  65 */       setFontStyle(fontConfig.getFontStyle());
/*     */     }
/*  67 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public Font getFont() {
/*  72 */     return getFont((Font)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Font getFont(Font font) {
/*  77 */     if (font == null) {
/*  78 */       return getFont(getDefaultFontName(), getDefaultFontSize(), getDefaultFontStyle());
/*     */     }
/*  80 */     if ("<default>".equalsIgnoreCase(this.fontName_)) {
/*  81 */       return font.deriveFont(this.fontStyle_.getFontStyle(font.getStyle()), this.fontSize_.getSize(font.getSize()));
/*     */     }
/*     */     
/*  84 */     Font f = getFont(font.getName(), font.getSize(), font.getStyle());
/*  85 */     if (f == null) {
/*  86 */       return font;
/*     */     }
/*  88 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFontName() {
/*  93 */     if (this.fontName_ == null) {
/*  94 */       return "";
/*     */     }
/*  96 */     return this.fontName_;
/*     */   }
/*     */   
/*     */   public String getFontName(String argDefault) {
/* 100 */     if (this.fontName_ == null || "<default>".equalsIgnoreCase(this.fontName_)) {
/* 101 */       return UIResourceManager.getInstance().getFont("_fontLabelMedium").getFontName();
/*     */     }
/* 103 */     return this.fontName_;
/*     */   }
/*     */   
/*     */   public FontSize getFontSize() {
/* 107 */     return this.fontSize_;
/*     */   }
/*     */   
/*     */   public String getFontStyle() {
/* 111 */     if (this.fontStyle_ == null) {
/* 112 */       return "";
/*     */     }
/* 114 */     return this.fontStyle_.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 119 */     if (argKey.equalsIgnoreCase("FontName")) {
/* 120 */       setFontName(argValue.toString());
/*     */     }
/* 122 */     else if (argKey.equalsIgnoreCase("FontSize")) {
/* 123 */       setFontSize(argValue.toString());
/*     */     }
/* 125 */     else if (argKey.equalsIgnoreCase("FontStyle")) {
/* 126 */       this.fontStyle_ = FontStyle.forName(argValue);
/*     */     } else {
/*     */       
/* 129 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 131 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDirty() {
/* 136 */     this.font_ = null;
/* 137 */     super.setDirty();
/*     */   }
/*     */   
/*     */   public void setFontName(String argName) {
/* 141 */     if ("<default>".equalsIgnoreCase(argName)) {
/* 142 */       this.fontName_ = "<default>";
/*     */     } else {
/*     */       
/* 145 */       this.fontName_ = argName;
/*     */     } 
/* 147 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setFontSize(FontSize size) {
/* 151 */     this.fontSize_ = size;
/* 152 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setFontSize(String size) {
/* 156 */     this.fontSize_ = FontSize.get(size);
/* 157 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setFontStyle(FontStyle style) {
/* 161 */     this.fontStyle_ = style;
/* 162 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 169 */     if (!"<default>".equalsIgnoreCase(this.fontName_) || !DEFAULT_STYLE.equals(this.fontStyle_) || 
/* 170 */       !DEFAULT_SIZE.equals(this.fontSize_)) {
/*     */       
/* 172 */       argWriter.writeHeader("Font", "Font");
/* 173 */       if (!"<default>".equalsIgnoreCase(this.fontName_)) {
/* 174 */         argWriter.writeValue("FontName", "String", this.fontName_);
/*     */       }
/* 176 */       if (!DEFAULT_STYLE.equals(this.fontStyle_)) {
/* 177 */         argWriter.writeValue("FontStyle", "String", this.fontStyle_);
/*     */       }
/* 179 */       if (!DEFAULT_SIZE.equals(this.fontSize_)) {
/* 180 */         argWriter.writeValue("FontSize", (IReflectionParameterCapable)this.fontSize_);
/*     */       }
/* 182 */       argWriter.writeFooter("Font");
/*     */     } 
/*     */     
/* 185 */     setClean();
/*     */   }
/*     */   
/*     */   private String getDefaultFontName() {
/* 189 */     String s = UIManager.getString("defaultFontName");
/* 190 */     if (s == null) {
/* 191 */       return "<default>";
/*     */     }
/*     */     
/* 194 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getDefaultFontSize() {
/* 199 */     int i = UIManager.getInt("defaultFontSize");
/* 200 */     if (i == 0) {
/* 201 */       return 12;
/*     */     }
/*     */     
/* 204 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getDefaultFontStyle() {
/* 209 */     return UIManager.getInt("defaultFontStyle");
/*     */   }
/*     */   
/*     */   private Font getFont(String argDefaultName, int argDefaultSize, int argDefaultStyle) {
/* 213 */     if (this.font_ == null && (
/* 214 */       !DEFAULT_STYLE.equals(this.fontStyle_) || !DEFAULT_SIZE.equals(this.fontSize_) || 
/* 215 */       !"<default>".equalsIgnoreCase(this.fontName_))) {
/*     */       
/* 217 */       String SEPARATOR = "-";
/*     */ 
/*     */       
/* 220 */       String fontString = getFontName(argDefaultName) + "-" + this.fontStyle_.getFontStyleName(argDefaultStyle) + "-" + this.fontSize_.getSize(argDefaultSize);
/*     */       
/* 222 */       this.font_ = Font.decode(fontString.toString());
/*     */     } 
/* 224 */     return this.font_;
/*     */   }
/*     */   
/*     */   private void setFontStyle(String style) {
/* 228 */     setFontStyle(FontStyle.forName(style));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\FontConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */