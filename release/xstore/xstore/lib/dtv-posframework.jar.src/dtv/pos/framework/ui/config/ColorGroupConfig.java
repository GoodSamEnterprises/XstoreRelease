/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.config.IColorGroupConfig;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ColorConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.awt.Color;
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
/*     */ public final class ColorGroupConfig
/*     */   extends AbstractParentConfig
/*     */   implements IColorGroupConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final Logger logger_ = Logger.getLogger(ColorGroupConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "ColorGroup";
/*     */   
/*     */   public static final String MAIN_DTYPE = "ColorGroup";
/*  31 */   public static final Color NO_COLOR = null;
/*     */   
/*     */   private static final String FG_COLOR_TAG = "FgColor";
/*     */   
/*     */   private static final String BG_COLOR_TAG = "BgColor";
/*     */   
/*     */   private static final String BG_COLOR_REF_TAG = "BgColorRef";
/*     */   private static final String BG_COLOR2_TAG = "BgColor2";
/*     */   private static final String SELECTION_FG_COLOR_TAG = "SelectionFgColor";
/*     */   private static final String SELECTION_BG_COLOR_TAG = "SelectionBgColor";
/*     */   private static final String SELECTION_BG_COLOR2_TAG = "SelectionBgColor2";
/*     */   private static final String HIGHLIGHT_COLOR_TAG = "HighlightColor";
/*     */   private ColorConfig bgColor_;
/*     */   private ColorConfig bgColor2_;
/*     */   private ColorConfig fgColor_;
/*     */   private ColorConfig selectionFgColor_;
/*     */   private ColorConfig selectionBgColor_;
/*     */   private ColorConfig selectionBgColor2_;
/*     */   private ColorConfig highlightColor_;
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  52 */     if (sourceConfig == null || !(sourceConfig instanceof ColorGroupConfig)) {
/*  53 */       logger_.error("Attempted to cascade from invalid configuration object!");
/*     */       return;
/*     */     } 
/*  56 */     ColorGroupConfig colorGroupConfig = (ColorGroupConfig)sourceConfig;
/*     */     
/*  58 */     if (getBgColor() == null) {
/*  59 */       this.bgColor_ = colorGroupConfig.bgColor_;
/*     */     }
/*  61 */     if (getBgColor2() == null) {
/*  62 */       this.bgColor2_ = colorGroupConfig.bgColor2_;
/*     */     }
/*  64 */     if (getFgColor() == null) {
/*  65 */       this.fgColor_ = colorGroupConfig.fgColor_;
/*     */     }
/*  67 */     if (getSelectionFgColor() == null) {
/*  68 */       this.selectionFgColor_ = colorGroupConfig.selectionFgColor_;
/*     */     }
/*  70 */     if (getSelectionBgColor() == null) {
/*  71 */       this.selectionBgColor_ = colorGroupConfig.selectionBgColor_;
/*     */     }
/*  73 */     if (getSelectionBgColor2() == null) {
/*  74 */       this.selectionBgColor2_ = colorGroupConfig.selectionBgColor2_;
/*     */     }
/*  76 */     if (getHighlightColor() == null) {
/*  77 */       this.highlightColor_ = colorGroupConfig.highlightColor_;
/*     */     }
/*  79 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getBgColor() {
/*  84 */     if (this.bgColor_ == null) {
/*  85 */       return null;
/*     */     }
/*  87 */     return this.bgColor_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getBgColor2() {
/*  92 */     return (this.bgColor2_ == null) ? getBgColor() : this.bgColor2_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getFgColor() {
/*  97 */     if (this.fgColor_ == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     return this.fgColor_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getHighlightColor() {
/* 105 */     if (this.highlightColor_ == null) {
/* 106 */       return null;
/*     */     }
/* 108 */     return this.highlightColor_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getSelectionBgColor() {
/* 113 */     if (this.selectionBgColor_ == null) {
/* 114 */       return null;
/*     */     }
/* 116 */     return this.selectionBgColor_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getSelectionBgColor2() {
/* 121 */     return (this.selectionBgColor2_ == null) ? getSelectionBgColor() : this.selectionBgColor2_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getSelectionFgColor() {
/* 126 */     if (this.selectionFgColor_ == null) {
/* 127 */       return null;
/*     */     }
/* 129 */     return this.selectionFgColor_.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBgColor(Color color) {
/* 134 */     if (this.bgColor_ == null) {
/* 135 */       this.bgColor_ = new ColorConfig();
/*     */     }
/* 137 */     this.bgColor_.setValue(color);
/* 138 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBgColor(ColorConfig color) {
/* 143 */     this.bgColor_ = color;
/* 144 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBgColor2(Color argColor) {
/* 150 */     if (this.bgColor2_ == null) {
/* 151 */       this.bgColor2_ = new ColorConfig();
/*     */     }
/* 153 */     this.bgColor2_.setValue(argColor);
/* 154 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBgColor2(ColorConfig color) {
/* 160 */     this.bgColor2_ = color;
/* 161 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 166 */     if ("FgColor".equalsIgnoreCase(argKey)) {
/* 167 */       setFgColor(ColorConfig.valueOf(argValue));
/*     */     }
/* 169 */     else if ("BgColor".equalsIgnoreCase(argKey)) {
/* 170 */       setBgColor(ColorConfig.valueOf(argValue));
/*     */     }
/* 172 */     else if ("BgColorRef".equalsIgnoreCase(argKey)) {
/* 173 */       setBgColor(UIResourceManager.getInstance().getRGBColor(argValue.toString()));
/*     */     }
/* 175 */     else if ("BgColor2".equalsIgnoreCase(argKey)) {
/* 176 */       setBgColor2(ColorConfig.valueOf(argValue));
/*     */     }
/* 178 */     else if ("SelectionFgColor".equalsIgnoreCase(argKey)) {
/* 179 */       setSelectionFgColor(ColorConfig.valueOf(argValue));
/*     */     }
/* 181 */     else if ("SelectionBgColor".equalsIgnoreCase(argKey)) {
/* 182 */       setSelectionBgColor(ColorConfig.valueOf(argValue));
/*     */     }
/* 184 */     else if ("SelectionBgColor2".equalsIgnoreCase(argKey)) {
/* 185 */       setSelectionBgColor2(ColorConfig.valueOf(argValue));
/*     */     }
/* 187 */     else if ("HighlightColor".equalsIgnoreCase(argKey)) {
/* 188 */       setHighlightColor(ColorConfig.valueOf(argValue));
/*     */     } else {
/*     */       
/* 191 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 193 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFgColor(Color color) {
/* 198 */     if (this.fgColor_ == null) {
/* 199 */       this.fgColor_ = new ColorConfig();
/*     */     }
/* 201 */     this.fgColor_.setValue(color);
/* 202 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFgColor(ColorConfig color) {
/* 207 */     this.fgColor_ = color;
/* 208 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHighlightColor(ColorConfig color) {
/* 213 */     this.highlightColor_ = color;
/* 214 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectionBgColor(ColorConfig color) {
/* 219 */     this.selectionBgColor_ = color;
/* 220 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectionBgColor2(ColorConfig argSelectionBgColor2) {
/* 226 */     this.selectionBgColor2_ = argSelectionBgColor2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectionFgColor(ColorConfig color) {
/* 231 */     this.selectionFgColor_ = color;
/* 232 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 239 */     if (this.fgColor_ != null || this.bgColor_ != null) {
/* 240 */       argWriter.writeHeader("ColorGroup", "ColorGroup");
/* 241 */       argWriter.writeValue("FgColor", (IReflectionParameterCapable)this.fgColor_);
/* 242 */       argWriter.writeValue("BgColor", (IReflectionParameterCapable)this.bgColor_);
/* 243 */       argWriter.writeValue("SelectionFgColor", (IReflectionParameterCapable)this.selectionFgColor_);
/* 244 */       argWriter.writeValue("SelectionBgColor", (IReflectionParameterCapable)this.selectionBgColor_);
/* 245 */       argWriter.writeValue("HighlightColor", (IReflectionParameterCapable)this.highlightColor_);
/* 246 */       argWriter.writeFooter("ColorGroup");
/*     */     } 
/* 248 */     setClean();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ColorGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */