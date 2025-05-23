/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptSectionConfig;
/*     */ import dtv.pos.iframework.ui.config.PromptSectionType;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class PromptSectionConfig
/*     */   extends AbstractUIConfig
/*     */   implements IPromptSectionConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final Logger logger_ = Logger.getLogger(PromptSectionConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Section";
/*     */   
/*     */   private static final String TYPE_TAG = "Type";
/*     */   
/*     */   private IFormattableConfig textKeyConfig_;
/*     */   
/*     */   private IFormattable textKey_;
/*     */   
/*     */   private PromptSectionType type_;
/*     */   
/*     */   private IFormattable pretextMessage_;
/*     */ 
/*     */   
/*     */   public PromptSectionConfig() {}
/*     */   
/*     */   public PromptSectionConfig(PromptSectionType argType, String argTextKey) {
/*  45 */     this.type_ = argType;
/*  46 */     this.textKeyConfig_ = (IFormattableConfig)new TranslatableConfig(argTextKey);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  51 */     if (sourceConfig == null || !(sourceConfig instanceof PromptSectionConfig)) {
/*  52 */       logger_.error("Attempted to cascade from invalid configuration object!");
/*     */       return;
/*     */     } 
/*  55 */     super.cascadeValues(sourceConfig);
/*  56 */     PromptSectionConfig config = (PromptSectionConfig)sourceConfig;
/*     */     
/*  58 */     if (getTextKeyConfig() == null) {
/*  59 */       setTextKeyConfig(config.getTextKeyConfig());
/*     */     }
/*     */     
/*  62 */     if (getType() == null) {
/*  63 */       setType(config.getType());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  69 */     setTextKey(null);
/*  70 */     setPretext(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getText(IFormattable[] argArgs) {
/*  75 */     FormattableFactory ff = FormattableFactory.getInstance();
/*  76 */     IFormattable text = ff.getTranslatable(getTextKey(), argArgs);
/*  77 */     if (this.pretextMessage_ == null) {
/*  78 */       return text;
/*     */     }
/*     */     
/*  81 */     return ff.getAppendingFormattable(" ", new IFormattable[] { this.pretextMessage_, text });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/*  87 */     if (this.textKey_ != null) {
/*  88 */       return this.textKey_;
/*     */     }
/*  90 */     return (this.textKeyConfig_ != null) ? this.textKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  95 */     String value = argValue.toString();
/*     */     
/*  97 */     if (argKey.equalsIgnoreCase("Type")) {
/*  98 */       setType(PromptSectionType.find(value));
/*     */     }
/* 100 */     else if (argValue instanceof IFormattableConfig) {
/* 101 */       setTextKeyConfig((IFormattableConfig)argValue);
/*     */     } else {
/*     */       
/* 104 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPretext(IFormattable argMessage) {
/* 110 */     this.pretextMessage_ = argMessage;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextKey(IFormattable textKey) {
/* 115 */     this.textKey_ = textKey;
/*     */   }
/*     */   
/*     */   protected PromptSectionType getType() {
/* 119 */     return this.type_;
/*     */   }
/*     */   
/*     */   protected void setType(PromptSectionType type) {
/* 123 */     this.type_ = type;
/*     */   }
/*     */   
/*     */   private IFormattableConfig getTextKeyConfig() {
/* 127 */     return this.textKeyConfig_;
/*     */   }
/*     */   
/*     */   private void setTextKeyConfig(IFormattableConfig textKeyConfig) {
/* 131 */     this.textKeyConfig_ = textKeyConfig;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\PromptSectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */