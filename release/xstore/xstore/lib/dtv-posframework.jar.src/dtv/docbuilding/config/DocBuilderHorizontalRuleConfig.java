/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderFieldFactory;
/*     */ import dtv.docbuilding.DocBuilderRow;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.IDocBuilderIteratorMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderFieldType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.PositiveIntegerConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderHorizontalRuleConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private int percentWidth_ = 100;
/*  28 */   private String alignment_ = "left";
/*  29 */   private String style_ = "";
/*     */   private DocBuilderFieldConfig fieldConfig_;
/*     */   
/*     */   public String getAlignment() {
/*  33 */     return this.alignment_;
/*     */   }
/*     */   
/*     */   public int getPercentWidth() {
/*  37 */     return this.percentWidth_;
/*     */   }
/*     */   
/*     */   public String getStyle() {
/*  41 */     return this.style_;
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
/*     */   public IDocBuilderIteratorMember makeHorizontalRule(IDocElementFactory argElementFactory, FormatterMapConfig argFormatterMap) {
/*  55 */     String ruleText = argElementFactory.getHorizontalRuleText(this.alignment_, this.percentWidth_, this.style_);
/*     */ 
/*     */     
/*  58 */     IDocBuilderField endPrefixTagField = DocBuilderFieldFactory.getInstance().makeDocBuilderField(DocBuilderFieldType.TEXT, "%", Collections.EMPTY_LIST, "", null, DocBuilderAlignmentType.LEFT, 0, argFormatterMap
/*     */         
/*  60 */         .getFormatter(null));
/*     */     
/*  62 */     List<IDocBuilderCondition> conditions = Collections.emptyList();
/*  63 */     List<IDocBuilderField> fields = new ArrayList<>(2);
/*     */     
/*  65 */     if (this.fieldConfig_ != null) {
/*  66 */       fields.add(this.fieldConfig_.makeField(argFormatterMap));
/*     */     }
/*  68 */     fields.add(endPrefixTagField);
/*     */     
/*  70 */     DocBuilderRow row = new DocBuilderRow(DocBuilderAlignmentType.DEFAULT, ruleText, true, conditions, fields);
/*     */ 
/*     */     
/*  73 */     row.setSourceDescription(getSourceDescription());
/*     */     
/*  75 */     return (IDocBuilderIteratorMember)row;
/*     */   }
/*     */   
/*     */   public void setAlignment(String argAlignment) {
/*  79 */     this.alignment_ = argAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  86 */     if (argValue instanceof PositiveIntegerConfig && "percent_width".equalsIgnoreCase(argKey)) {
/*  87 */       int newValue = ((PositiveIntegerConfig)argValue).getInteger().intValue();
/*  88 */       if (0 < newValue && newValue <= 100) {
/*  89 */         this.percentWidth_ = newValue;
/*     */       }
/*     */     }
/*  92 */     else if ("alignment".equalsIgnoreCase(argKey) || "align".equalsIgnoreCase(argKey)) {
/*  93 */       this.alignment_ = argValue.toString();
/*     */     }
/*  95 */     else if ("style".equalsIgnoreCase(argKey)) {
/*  96 */       this.style_ = argValue.toString();
/*     */     }
/*  98 */     else if (argValue instanceof DocBuilderFieldConfig) {
/*  99 */       this.fieldConfig_ = (DocBuilderFieldConfig)argValue;
/*     */     } else {
/*     */       
/* 102 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPercentWidth(int argPercentWidth) {
/* 107 */     this.percentWidth_ = argPercentWidth;
/*     */   }
/*     */   
/*     */   public void setStyle(String argStyle) {
/* 111 */     this.style_ = argStyle;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderHorizontalRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */