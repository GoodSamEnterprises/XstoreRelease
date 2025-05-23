/*     */ package dtv.pos.i18n.config;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.IResourceFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractConfig;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class TranslatableConfig
/*     */   extends AbstractConfig
/*     */   implements IFormattableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private static final Logger logger_ = Logger.getLogger(TranslatableConfig.class);
/*     */   
/*     */   private String translationKey_;
/*     */   
/*     */   private Locale locale_;
/*     */   
/*     */   private String bundle_;
/*     */ 
/*     */   
/*     */   public TranslatableConfig() {}
/*     */   
/*     */   public TranslatableConfig(String argValue) {
/*  42 */     setValue(argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  48 */     return "Translatable";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  54 */     if (this.translationKey_ == null || this.translationKey_.length() == 0) {
/*  55 */       return null;
/*     */     }
/*     */     
/*  58 */     return this.translationKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable() {
/*  65 */     IFormattable f = FormattableFactory.getInstance().getSimpleFormattable(this.translationKey_);
/*  66 */     f.setSourceDescription(getSourceDescription());
/*  67 */     if (this.bundle_ != null) {
/*  68 */       if (f instanceof IResourceFormattable) {
/*  69 */         ((IResourceFormattable)f).setResourceBundleName(this.bundle_);
/*     */       } else {
/*     */         
/*  72 */         logger_.warn("unable to use bundle " + this.bundle_ + ";" + ObjectUtils.getClassNameFromObject(f) + " does not implement " + IResourceFormattable.class
/*  73 */             .getName() + ":" + getSourceDescription());
/*     */       } 
/*     */     }
/*  76 */     if (this.locale_ != null) {
/*  77 */       f.setLocale(this.locale_);
/*     */     }
/*  79 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable(Object argSourceObject) {
/*  85 */     return getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<IFormattable> getParamDataType() {
/*  91 */     return IFormattable.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getParamValue() {
/*  97 */     return getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 103 */     if ("locale".equalsIgnoreCase(argKey)) {
/*     */       try {
/* 105 */         this.locale_ = LocaleUtils.toLocale(argValue.toString());
/*     */       }
/* 107 */       catch (Exception ex) {
/* 108 */         logger_.error("CAUGHT EXCEPTION with locale name=" + argValue, ex);
/*     */       }
/*     */     
/* 111 */     } else if ("bundle".equalsIgnoreCase(argKey)) {
/* 112 */       this.bundle_ = argValue.toString();
/*     */     }
/* 114 */     else if ("name".equalsIgnoreCase(argKey)) {
/* 115 */       setValue(argValue.toString());
/*     */     } else {
/*     */       
/* 118 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argValue) {
/* 125 */     if (!StringUtils.isEmpty(argValue))
/* 126 */       this.translationKey_ = argValue; 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\TranslatableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */