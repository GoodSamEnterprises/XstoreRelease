/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.framework.touch.TouchConfig;
/*     */ import dtv.pos.iframework.ui.config.IIconGroupConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.IconConfig;
/*     */ import java.io.IOException;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IconGroupConfig
/*     */   extends AbstractParentConfig
/*     */   implements IIconGroupConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final Logger logger_ = Logger.getLogger(IconGroupConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "IconGroup";
/*     */   
/*     */   public static final String ICON_TAG = "Icon";
/*     */   
/*     */   private static final String ROLL_ICON_TAG = "RollIcon";
/*     */   
/*     */   private static final String PRESS_ICON_TAG = "PressIcon";
/*     */   private static final String DISABLED_ICON_TAG = "DisabledIcon";
/*     */   private static final String TOUCH_TAG = "touch";
/*     */   private static final String SCALE_TAG = "scale";
/*     */   private IconConfig iconConfig_;
/*     */   private IconConfig rollIconConfig_;
/*     */   private IconConfig pressIconConfig_;
/*     */   private IconConfig disabledIconConfig_;
/*     */   private TouchConfig touchConfig_;
/*     */   private Boolean scaleConfig_;
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  47 */     if (!(sourceConfig instanceof IconGroupConfig)) {
/*  48 */       logger_.error("Attempted to cascade from invalid configuration object::" + 
/*  49 */           getSourceDescription(sourceConfig) + "-->" + getSourceDescription());
/*     */       return;
/*     */     } 
/*  52 */     IconGroupConfig iconGroupConfig = (IconGroupConfig)sourceConfig;
/*     */     
/*  54 */     if (getIcon() == null) {
/*  55 */       setIcon(iconGroupConfig.getIconConfig());
/*     */     }
/*  57 */     if (getRollIcon() == null) {
/*  58 */       setRollIcon(iconGroupConfig.getRollIconConfig());
/*     */     }
/*  60 */     if (getPressIcon() == null) {
/*  61 */       setPressIcon(iconGroupConfig.getPressIconConfig());
/*     */     }
/*  63 */     if (getDisabledIcon() == null) {
/*  64 */       setDisabledIcon(iconGroupConfig.getDisabledIconConfig());
/*     */     }
/*  66 */     if (getTouchConfig() == null) {
/*  67 */       setTouchConfig(iconGroupConfig.getTouchConfig());
/*     */     }
/*  69 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getDisabledIcon() {
/*  74 */     return (this.disabledIconConfig_ == null) ? null : this.disabledIconConfig_.getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   public IconConfig getDisabledIconConfig() {
/*  79 */     return this.disabledIconConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getIcon() {
/*  84 */     return (this.iconConfig_ == null) ? null : this.iconConfig_.getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   public IconConfig getIconConfig() {
/*  89 */     return this.iconConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getPressIcon() {
/*  94 */     return (this.pressIconConfig_ == null) ? null : this.pressIconConfig_.getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   public IconConfig getPressIconConfig() {
/*  99 */     return this.pressIconConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getRollIcon() {
/* 104 */     return (this.rollIconConfig_ == null) ? null : this.rollIconConfig_.getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   public IconConfig getRollIconConfig() {
/* 109 */     return this.rollIconConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getScaleConfig() {
/* 114 */     return ConfigUtils.asBool(this.scaleConfig_, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public TouchConfig getTouchConfig() {
/* 119 */     return this.touchConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 124 */     if (argKey.equalsIgnoreCase("Icon")) {
/*     */       
/* 126 */       IconConfig icon = (argValue instanceof IconConfig) ? (IconConfig)argValue : new IconRefConfig(argValue.toString());
/* 127 */       setIcon(icon);
/*     */     }
/* 129 */     else if (argKey.equalsIgnoreCase("RollIcon")) {
/*     */       
/* 131 */       IconConfig rollIcon = (argValue instanceof IconConfig) ? (IconConfig)argValue : new IconRefConfig(argValue.toString());
/* 132 */       setRollIcon(rollIcon);
/*     */     }
/* 134 */     else if (argKey.equalsIgnoreCase("PressIcon")) {
/*     */       
/* 136 */       IconConfig pressIcon = (argValue instanceof IconConfig) ? (IconConfig)argValue : new IconRefConfig(argValue.toString());
/* 137 */       setPressIcon(pressIcon);
/*     */     }
/* 139 */     else if (argKey.equalsIgnoreCase("DisabledIcon")) {
/*     */       
/* 141 */       IconConfig disabledIcon = (argValue instanceof IconConfig) ? (IconConfig)argValue : new IconRefConfig(argValue.toString());
/* 142 */       setDisabledIcon(disabledIcon);
/*     */     }
/* 144 */     else if (argKey.equalsIgnoreCase("touch")) {
/*     */       
/* 146 */       TouchConfig touchConfig = (argValue instanceof TouchConfig) ? (TouchConfig)argValue : new TouchConfig(argValue.toString());
/* 147 */       setTouchConfig(touchConfig);
/*     */     }
/* 149 */     else if (argKey.equalsIgnoreCase("scale")) {
/* 150 */       setScaleConfig(ConfigUtils.toBoolean(argValue));
/*     */     } else {
/*     */       
/* 153 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */     
/* 156 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabledIcon(IconConfig icon) {
/* 161 */     this.disabledIconConfig_ = icon;
/* 162 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIcon(IconConfig icon) {
/* 167 */     this.iconConfig_ = icon;
/* 168 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPressIcon(IconConfig icon) {
/* 173 */     this.pressIconConfig_ = icon;
/* 174 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRollIcon(IconConfig icon) {
/* 179 */     this.rollIconConfig_ = icon;
/* 180 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScaleConfig(boolean argScaleConfig) {
/* 186 */     this.scaleConfig_ = Boolean.valueOf(argScaleConfig);
/* 187 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 194 */     if (this.iconConfig_ != null) {
/* 195 */       argWriter.writeHeader("IconGroup", "IconGroup");
/* 196 */       argWriter.writeValue("Icon", (IReflectionParameterCapable)this.iconConfig_);
/* 197 */       argWriter.writeValue("RollIcon", (IReflectionParameterCapable)this.rollIconConfig_);
/* 198 */       argWriter.writeValue("PressIcon", (IReflectionParameterCapable)this.pressIconConfig_);
/* 199 */       argWriter.writeValue("DisabledIcon", (IReflectionParameterCapable)this.disabledIconConfig_);
/* 200 */       argWriter.writeFooter("IconGroup");
/*     */     } 
/* 202 */     setClean();
/*     */   }
/*     */   
/*     */   protected void setTouchConfig(TouchConfig argTouchConfig) {
/* 206 */     this.touchConfig_ = argTouchConfig;
/* 207 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\IconGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */