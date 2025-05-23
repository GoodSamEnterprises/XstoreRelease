/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.framework.touch.TouchConfig;
/*     */ import dtv.pos.iframework.ui.config.IColorGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IFontConfig;
/*     */ import dtv.pos.iframework.ui.config.IIconGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IUIConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import java.awt.Color;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractUIConfig
/*     */   extends AbstractParentConfig
/*     */   implements ICascadableConfig, IUIConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final Logger logger_ = Logger.getLogger(AbstractUIConfig.class);
/*     */   
/*     */   protected static final String HEIGHT_TAG = "Height";
/*     */   
/*     */   protected static final String WIDTH_TAG = "Width";
/*     */   private IFontConfig fontConfig_;
/*     */   private IColorGroupConfig colorGroupConfig_;
/*     */   private IIconGroupConfig iconGroupConfig_;
/*     */   private TouchConfig touchConfig_;
/*     */   private Integer width_;
/*     */   private Integer height_;
/*     */   
/*     */   protected AbstractUIConfig() {
/*  39 */     setFontConfig(new FontConfig());
/*  40 */     setColorGroupConfig(new ColorGroupConfig());
/*  41 */     setIconGroupConfig(new IconGroupConfig());
/*  42 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  47 */     if (!(sourceConfig instanceof AbstractUIConfig)) {
/*  48 */       logger_.error("Attempted to cascade from invalid configuration object::" + 
/*  49 */           getSourceDescription(sourceConfig) + "-->" + getSourceDescription());
/*     */       return;
/*     */     } 
/*  52 */     AbstractUIConfig uiConfig = (AbstractUIConfig)sourceConfig;
/*     */     
/*  54 */     getFontConfig().cascadeValues((IConfigObject)uiConfig.getFontConfig());
/*  55 */     getColorGroupConfig().cascadeValues((IConfigObject)uiConfig.getColorGroupConfig());
/*  56 */     getIconGroupConfig().cascadeValues((IConfigObject)uiConfig.getIconGroupConfig());
/*     */     
/*  58 */     if (getHeightObject() == null) {
/*  59 */       setHeight(uiConfig.getHeightObject());
/*     */     }
/*  61 */     if (getWidthObject() == null) {
/*  62 */       setWidth(uiConfig.getWidthObject());
/*     */     }
/*     */     
/*  65 */     getFontConfig().cascadeValues((IConfigObject)uiConfig.getFontConfig());
/*  66 */     getColorGroupConfig().cascadeValues((IConfigObject)uiConfig.getColorGroupConfig());
/*  67 */     setClean();
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */   
/*     */   public Color getBackgroundColor() {
/*  73 */     if (this.colorGroupConfig_ == null) {
/*  74 */       return null;
/*     */     }
/*  76 */     return this.colorGroupConfig_.getBgColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public IColorGroupConfig getColorGroupConfig() {
/*  81 */     return this.colorGroupConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFontConfig getFontConfig() {
/*  86 */     return this.fontConfig_;
/*     */   }
/*     */   
/*     */   public Color getForegroundColor() {
/*  90 */     if (this.colorGroupConfig_ == null) {
/*  91 */       return null;
/*     */     }
/*  93 */     return this.colorGroupConfig_.getFgColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  98 */     return ConfigUtils.asInt(this.height_);
/*     */   }
/*     */   
/*     */   public Integer getHeightObject() {
/* 102 */     return this.height_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IIconGroupConfig getIconGroupConfig() {
/* 107 */     return this.iconGroupConfig_;
/*     */   }
/*     */   
/*     */   public TouchConfig getTouchConfig() {
/* 111 */     return this.touchConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 116 */     return ConfigUtils.asInt(this.width_);
/*     */   }
/*     */   
/*     */   public Integer getWidthObject() {
/* 120 */     return this.width_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 125 */     return (this.colorGroupConfig_.isDirty() || this.iconGroupConfig_.isDirty() || this.fontConfig_.isDirty() || super
/* 126 */       .isDirty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColorGroupConfig(IColorGroupConfig colorGroupConfig) {
/* 131 */     this.colorGroupConfig_ = colorGroupConfig;
/* 132 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 137 */     if (argKey.equalsIgnoreCase("Width")) {
/* 138 */       setWidth(Integer.valueOf(ConfigUtils.toInt(argValue)));
/*     */     }
/* 140 */     else if (argKey.equalsIgnoreCase("Height") && argValue instanceof IntegerConfig) {
/* 141 */       setHeight(((IntegerConfig)argValue).getInteger());
/*     */     }
/* 143 */     else if (argValue instanceof IFontConfig) {
/* 144 */       setFontConfig((IFontConfig)argValue);
/*     */     }
/* 146 */     else if (argValue instanceof IColorGroupConfig) {
/* 147 */       setColorGroupConfig((IColorGroupConfig)argValue);
/*     */     }
/* 149 */     else if (argValue instanceof IIconGroupConfig) {
/* 150 */       setIconGroupConfig((IIconGroupConfig)argValue);
/*     */     }
/* 152 */     else if (argKey.equalsIgnoreCase("touch")) {
/* 153 */       TouchConfig config = null;
/* 154 */       if (!(argValue instanceof TouchConfig)) {
/* 155 */         config = new TouchConfig(argValue.toString());
/*     */       } else {
/*     */         
/* 158 */         config = (TouchConfig)argValue;
/*     */       } 
/* 160 */       setTouchConfig(config);
/*     */     } else {
/*     */       
/* 163 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 165 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontConfig(IFontConfig fontConfig) {
/* 170 */     this.fontConfig_ = fontConfig;
/* 171 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeight(Integer height) {
/* 176 */     this.height_ = height;
/* 177 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIconGroupConfig(IIconGroupConfig iconGroupConfig) {
/* 182 */     this.iconGroupConfig_ = iconGroupConfig;
/* 183 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setTouchConfig(TouchConfig config) {
/* 187 */     this.touchConfig_ = config;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWidth(Integer width) {
/* 192 */     this.width_ = width;
/* 193 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\AbstractUIConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */