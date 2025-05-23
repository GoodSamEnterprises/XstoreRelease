/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocBuilderTextBlock;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
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
/*     */ public class DocBuilderTextBlockConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   protected final List<DocBuilderFieldConfig> fields_ = new LinkedList<>();
/*  29 */   protected final List<DocBuilderConditionConfig> conditionConfigs_ = new LinkedList<>();
/*     */ 
/*     */   
/*  32 */   protected String dateMethod_ = null;
/*  33 */   protected DocBuilderFieldConfig code_ = null;
/*  34 */   protected DocBuilderFieldConfig subcode_ = null;
/*  35 */   protected String rightMargin_ = "";
/*  36 */   protected String leftMargin_ = "";
/*  37 */   protected DocBuilderAlignmentType alignment_ = DocBuilderAlignmentType.DEFAULT;
/*  38 */   protected DocBuilderRowCharSize charSize_ = DocBuilderRowCharSize.NORMAL;
/*  39 */   protected String style_ = null;
/*     */   
/*     */   public DocBuilderTextBlock makeTextBlock(FormatterMapConfig argFormatterMap) {
/*  42 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(this.conditionConfigs_);
/*     */ 
/*     */     
/*  45 */     List<IDocBuilderField> fieldList = new ArrayList<>();
/*  46 */     for (DocBuilderFieldConfig fieldConfig : this.fields_) {
/*  47 */       IDocBuilderField field = fieldConfig.makeField(argFormatterMap);
/*  48 */       if (field != null) {
/*  49 */         fieldList.add(field);
/*     */       }
/*     */     } 
/*     */     
/*  53 */     IDocBuilderField code = this.code_.makeField(argFormatterMap);
/*  54 */     IDocBuilderField subcode = this.subcode_.makeField(argFormatterMap);
/*     */ 
/*     */     
/*  57 */     DocBuilderTextBlock block = createDocBuilderTextBlock(this.dateMethod_, code, subcode, fieldList, this.leftMargin_, this.rightMargin_, this.alignment_, this.charSize_, this.style_, conditions);
/*     */ 
/*     */     
/*  60 */     block.setSourceDescription(getSourceDescription());
/*  61 */     return block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  66 */     if (argValue instanceof DocBuilderFieldConfig && "code".equalsIgnoreCase(argKey)) {
/*  67 */       this.code_ = (DocBuilderFieldConfig)argValue;
/*     */     }
/*  69 */     else if (argValue instanceof DocBuilderFieldConfig && "subcode".equalsIgnoreCase(argKey)) {
/*  70 */       this.subcode_ = (DocBuilderFieldConfig)argValue;
/*     */     }
/*  72 */     else if ("DateMethod".equalsIgnoreCase(argKey)) {
/*  73 */       this.dateMethod_ = argValue.toString();
/*     */     }
/*  75 */     else if ("right_margin".equalsIgnoreCase(argKey)) {
/*  76 */       this.rightMargin_ = DocBuilderRegionConfig.makeMargin(argValue);
/*     */     
/*     */     }
/*  79 */     else if ("left_margin".equalsIgnoreCase(argKey)) {
/*  80 */       this.leftMargin_ = DocBuilderRegionConfig.makeMargin(argValue);
/*     */     }
/*  82 */     else if ("alignment".equalsIgnoreCase(argKey) || "align".equalsIgnoreCase(argKey)) {
/*  83 */       this.alignment_ = DocBuilderAlignmentType.forName(argValue.toString());
/*     */     }
/*  85 */     else if ("charsize".equalsIgnoreCase(argKey)) {
/*  86 */       this.charSize_ = DocBuilderRowCharSize.forName(argValue.toString());
/*     */     }
/*  88 */     else if ("style".equalsIgnoreCase(argKey)) {
/*  89 */       this.style_ = argValue.toString();
/*     */     }
/*  91 */     else if (argValue instanceof DocBuilderConditionConfig) {
/*  92 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/*  94 */     else if (argValue instanceof DocBuilderFieldConfig) {
/*  95 */       this.fields_.add((DocBuilderFieldConfig)argValue);
/*     */     } else {
/*     */       
/*  98 */       warnUnsupported(argKey, argValue);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocBuilderTextBlock createDocBuilderTextBlock(String argDateMethod, IDocBuilderField argCode, IDocBuilderField argSubcode, List<IDocBuilderField> argFields, String argLeftMargin, String argRightMargin, DocBuilderAlignmentType argAlignment, DocBuilderRowCharSize argCharSize, String argStyle, List<IDocBuilderCondition> argConditions) {
/* 122 */     return new DocBuilderTextBlock(argDateMethod, argCode, argSubcode, argFields, argLeftMargin, argRightMargin, argAlignment, argCharSize, argStyle, argConditions);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderTextBlockConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */