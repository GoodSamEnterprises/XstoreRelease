/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public abstract class AbstractDocBuilderRowConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private final List<DocBuilderConditionConfig> _conditionConfigs = new ArrayList<>();
/*     */ 
/*     */   
/*  29 */   private DocBuilderAlignmentType _alignment = null;
/*  30 */   private DocBuilderRowCharSize _charSize = null;
/*  31 */   private DocBuilderRowStyleType _style = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _overtype = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderAlignmentType getAlignment() {
/*  41 */     return (getConfiguredAlignment() == null) ? DocBuilderAlignmentType.LEFT : getConfiguredAlignment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderRowCharSize getCharSize() {
/*  52 */     return (getConfiguredCharSize() == null) ? DocBuilderRowCharSize.NORMAL : getConfiguredCharSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DocBuilderConditionConfig> getConditionConfigs() {
/*  60 */     return this._conditionConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderRowStyleType getStyle() {
/*  68 */     return this._style;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOvertype() {
/*  78 */     return this._overtype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(DocBuilderAlignmentType argAlignment) {
/*  86 */     this._alignment = argAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharSize(DocBuilderRowCharSize argCharSize) {
/*  94 */     this._charSize = argCharSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 100 */     if (argValue instanceof DocBuilderConditionConfig) {
/* 101 */       this._conditionConfigs.add((DocBuilderConditionConfig)argValue);
/*     */     }
/* 103 */     else if ("alignment".equalsIgnoreCase(argKey) || "align".equalsIgnoreCase(argKey)) {
/* 104 */       setAlignment(DocBuilderAlignmentType.forName(argValue.toString()));
/*     */     }
/* 106 */     else if ("charsize".equalsIgnoreCase(argKey)) {
/* 107 */       setCharSize(DocBuilderRowCharSize.forName(argValue.toString()));
/*     */     }
/* 109 */     else if ("style".equalsIgnoreCase(argKey)) {
/* 110 */       setStyle(DocBuilderRowStyleType.forName(argValue.toString()));
/*     */     }
/* 112 */     else if ("overtype".equalsIgnoreCase(argKey)) {
/* 113 */       this._overtype = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/* 116 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyle(DocBuilderRowStyleType argStyle) {
/* 125 */     this._style = argStyle;
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
/*     */   protected DocBuilderAlignmentType getConfiguredAlignment() {
/* 137 */     return this._alignment;
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
/*     */   protected DocBuilderRowCharSize getConfiguredCharSize() {
/* 149 */     return this._charSize;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\AbstractDocBuilderRowConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */