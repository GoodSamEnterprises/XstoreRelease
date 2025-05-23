/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocBuilderRegion;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IntegerConfig;
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
/*     */ public class DocBuilderRegionConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected static String makeMargin(IConfigObject argValue) {
/*  30 */     if (argValue instanceof IntegerConfig) {
/*  31 */       return StringUtils.fill(' ', ((IntegerConfig)argValue).getInteger().intValue());
/*     */     }
/*     */     
/*  34 */     String v = argValue.toString();
/*     */     try {
/*  36 */       return StringUtils.fill(' ', Integer.parseInt(v));
/*     */     }
/*  38 */     catch (Exception ex) {
/*  39 */       return v;
/*     */     } 
/*     */   }
/*     */   
/*  43 */   private final List<DocBuilderConditionConfig> conditionConfigs_ = new ArrayList<>();
/*     */ 
/*     */   
/*  46 */   private DocBuilderAlignmentType alignment_ = DocBuilderAlignmentType.DEFAULT;
/*  47 */   private DocBuilderRowCharSize charSize_ = DocBuilderRowCharSize.NORMAL;
/*     */   private DocBuilderFieldConfig fieldConfig_;
/*  49 */   private String leftMargin_ = "";
/*  50 */   private String rightMargin_ = "";
/*  51 */   private DocBuilderRowStyleType style_ = null;
/*     */   
/*     */   public DocBuilderAlignmentType getAlignment() {
/*  54 */     return this.alignment_;
/*     */   }
/*     */   
/*     */   public DocBuilderRowCharSize getCharSize() {
/*  58 */     return this.charSize_;
/*     */   }
/*     */   
/*     */   public List<DocBuilderConditionConfig> getConditionConfigs() {
/*  62 */     return this.conditionConfigs_;
/*     */   }
/*     */   
/*     */   public DocBuilderFieldConfig getFieldConfig() {
/*  66 */     return this.fieldConfig_;
/*     */   }
/*     */   
/*     */   public String getLeftMargin() {
/*  70 */     return this.leftMargin_;
/*     */   }
/*     */   
/*     */   public String getRightMargin() {
/*  74 */     return this.rightMargin_;
/*     */   }
/*     */   
/*     */   public DocBuilderRowStyleType getStyle() {
/*  78 */     return this.style_;
/*     */   }
/*     */   
/*     */   public DocBuilderRegion makeRegion(FormatterMapConfig argFormatterMap) {
/*  82 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(this.conditionConfigs_);
/*     */ 
/*     */     
/*  85 */     DocBuilderRegion region = new DocBuilderRegion(this.fieldConfig_.makeField(argFormatterMap), this.leftMargin_, this.rightMargin_, this.alignment_, this.charSize_, this.style_, conditions);
/*     */ 
/*     */     
/*  88 */     region.setSourceDescription(getSourceDescription());
/*     */     
/*  90 */     return region;
/*     */   }
/*     */   
/*     */   public void setAlignment(DocBuilderAlignmentType argAlignment) {
/*  94 */     this.alignment_ = argAlignment;
/*     */   }
/*     */   
/*     */   public void setCharSize(DocBuilderRowCharSize argCharSize) {
/*  98 */     this.charSize_ = argCharSize;
/*     */   }
/*     */   
/*     */   public void setConditionConfigs(List<DocBuilderConditionConfig> argList) {
/* 102 */     this.conditionConfigs_.clear();
/* 103 */     this.conditionConfigs_.addAll(argList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 110 */     if (argValue instanceof DocBuilderFieldConfig) {
/* 111 */       this.fieldConfig_ = (DocBuilderFieldConfig)argValue;
/*     */     }
/* 113 */     else if ("right_margin".equalsIgnoreCase(argKey)) {
/* 114 */       this.rightMargin_ = makeMargin(argValue);
/*     */     }
/* 116 */     else if ("left_margin".equalsIgnoreCase(argKey)) {
/* 117 */       this.leftMargin_ = makeMargin(argValue);
/*     */     }
/* 119 */     else if ("alignment".equalsIgnoreCase(argKey) || "align".equalsIgnoreCase(argKey)) {
/* 120 */       this.alignment_ = DocBuilderAlignmentType.forName(argValue.toString());
/*     */     }
/* 122 */     else if ("charsize".equalsIgnoreCase(argKey)) {
/* 123 */       this.charSize_ = DocBuilderRowCharSize.forName(argValue.toString());
/*     */     }
/* 125 */     else if ("style".equalsIgnoreCase(argKey)) {
/* 126 */       this.style_ = DocBuilderRowStyleType.forName(argValue.toString());
/*     */     }
/* 128 */     else if (argValue instanceof DocBuilderConditionConfig) {
/* 129 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     } else {
/*     */       
/* 132 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFieldConfig(DocBuilderFieldConfig argFieldConfig) {
/* 137 */     this.fieldConfig_ = argFieldConfig;
/*     */   }
/*     */   
/*     */   public void setLeftMargin(String argLeftMargin) {
/* 141 */     this.leftMargin_ = argLeftMargin;
/*     */   }
/*     */   
/*     */   public void setRightMargin(String argRightMargin) {
/* 145 */     this.rightMargin_ = argRightMargin;
/*     */   }
/*     */   
/*     */   public void setStyle(DocBuilderRowStyleType argStyle) {
/* 149 */     this.style_ = argStyle;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderRegionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */