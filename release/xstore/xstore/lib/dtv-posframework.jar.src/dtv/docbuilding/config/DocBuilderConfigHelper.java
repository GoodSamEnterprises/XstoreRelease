/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DocBuilderConfigHelper<R extends IConfigObject>
/*     */   extends ConfigHelper<R>
/*     */ {
/*     */   private static boolean isDocBuilderSectionMapConfig(String argDtype) {
/*  20 */     if ("DocBuilderSectionMap".equalsIgnoreCase(argDtype)) {
/*  21 */       return true;
/*     */     }
/*  23 */     if ("sections".equalsIgnoreCase(argDtype)) {
/*  24 */       return true;
/*     */     }
/*  26 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isFormatterMapConfig(String argDtype) {
/*  30 */     if ("FormatterMap".equalsIgnoreCase(argDtype)) {
/*  31 */       return true;
/*     */     }
/*  33 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, IConfigObject argParent, String argSourceDescription) {
/*  40 */     if (argParent instanceof IDocBuilderRootConfig) {
/*  41 */       IConfigObject c; IDocBuilderRootConfig parent = (IDocBuilderRootConfig)argParent;
/*     */       
/*  43 */       if (isFormatterMapConfig(argDtype)) {
/*  44 */         FormatterMapConfig formatterMapConfig = parent.getFormatterMapForConfig();
/*     */       }
/*  46 */       else if (isDocListConfig(argDtype)) {
/*  47 */         DocListConfig docListConfig = parent.getDocListConfig();
/*     */       }
/*  49 */       else if (isDocBuilderSectionMapConfig(argDtype)) {
/*  50 */         DocBuilderSectionMapConfig docBuilderSectionMapConfig = parent.getSectionsConfig();
/*     */       } else {
/*     */         
/*  53 */         c = null;
/*     */       } 
/*  55 */       if (c != null) {
/*  56 */         return c;
/*     */       }
/*     */     } 
/*  59 */     if (argParent instanceof DocBuilderGroupingConfig) {
/*  60 */       if ("header".equalsIgnoreCase(argDtype) || "item".equalsIgnoreCase(argDtype) || "footer"
/*  61 */         .equalsIgnoreCase(argDtype)) {
/*  62 */         return new DocBuilderSectionRefConfig();
/*     */       }
/*  64 */       if ("ItemCondition".equalsIgnoreCase(argDtype) || "GroupCondition".equalsIgnoreCase(argDtype)) {
/*  65 */         return (IConfigObject)new DocBuilderConditionConfig();
/*     */       }
/*  67 */       if ("group_comparator".equalsIgnoreCase(argDtype) || "GroupComparator".equalsIgnoreCase(argDtype) || "ItemComparator"
/*  68 */         .equalsIgnoreCase(argDtype) || "item_comparator".equalsIgnoreCase(argDtype)) {
/*  69 */         return (IConfigObject)new ClassConfig();
/*     */       }
/*     */     } 
/*  72 */     if (equalsIgnoreCase("text", argDtype, argTagName) || equalsIgnoreCase("method", argDtype, argTagName)) {
/*  73 */       return (IConfigObject)new StringConfig();
/*     */     }
/*  75 */     return super.getConfigObject(argTagName, argDtype, argParent, argSourceDescription);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/*  80 */     if ("Formatter".equalsIgnoreCase(argDtype)) {
/*  81 */       return (IConfigObject)new FormatterConfig();
/*     */     }
/*  83 */     if (isFormatterMapConfig(argDtype)) {
/*  84 */       return (IConfigObject)new FormatterMapConfig();
/*     */     }
/*  86 */     if (isDocListConfig(argDtype)) {
/*  87 */       return (IConfigObject)new DocListConfig();
/*     */     }
/*  89 */     if ("Doc".equalsIgnoreCase(argDtype)) {
/*  90 */       return (IConfigObject)new DocConfig();
/*     */     }
/*  92 */     if (isDocBuilderSectionMapConfig(argDtype)) {
/*  93 */       return (IConfigObject)new DocBuilderSectionMapConfig();
/*     */     }
/*  95 */     if ("section".equalsIgnoreCase(argDtype) || "DocBuilderSection".equalsIgnoreCase(argDtype)) {
/*  96 */       return (IConfigObject)new DocBuilderSectionConfig();
/*     */     }
/*  98 */     if ("iterator".equalsIgnoreCase(argDtype) || "DocBuilderIterator".equalsIgnoreCase(argDtype)) {
/*  99 */       return new DocBuilderIteratorConfig();
/*     */     }
/* 101 */     if ("call".equalsIgnoreCase(argDtype) || "DocBuilderCall".equalsIgnoreCase(argDtype)) {
/* 102 */       return new DocBuilderCallConfig();
/*     */     }
/* 104 */     if ("grouping".equalsIgnoreCase(argDtype) || "DocBuilderGrouping".equalsIgnoreCase(argDtype)) {
/* 105 */       return new DocBuilderGroupingConfig();
/*     */     }
/* 107 */     if ("row".equalsIgnoreCase(argDtype) || "DocBuilderRow".equalsIgnoreCase(argDtype)) {
/* 108 */       return new DocBuilderRowConfig();
/*     */     }
/* 110 */     if ("rowSet".equalsIgnoreCase(argDtype)) {
/* 111 */       return new DocBuilderRowSetConfig();
/*     */     }
/* 113 */     if ("region".equalsIgnoreCase(argDtype) || "DocBuilderRegion".equalsIgnoreCase(argDtype)) {
/* 114 */       return new DocBuilderRegionConfig();
/*     */     }
/* 116 */     if ("condition".equalsIgnoreCase(argDtype) || "DocBuilderCondition".equalsIgnoreCase(argDtype)) {
/* 117 */       return (IConfigObject)new DocBuilderConditionConfig();
/*     */     }
/* 119 */     if ("field".equalsIgnoreCase(argDtype) || "DocBuilderField".equalsIgnoreCase(argDtype)) {
/* 120 */       return (IConfigObject)new DocBuilderFieldConfig();
/*     */     }
/* 122 */     if ("aggregate".equalsIgnoreCase(argDtype) || "DocBuilderAggregate".equalsIgnoreCase(argDtype)) {
/* 123 */       return (IConfigObject)new DocBuilderAggregateConfig();
/*     */     }
/* 125 */     if ("xml".equalsIgnoreCase(argDtype)) {
/* 126 */       return new DocBuilderXmlConfig();
/*     */     }
/* 128 */     if ("sp".equalsIgnoreCase(argDtype)) {
/* 129 */       return (IConfigObject)new DocBuilderFieldConfig(1);
/*     */     }
/* 131 */     if ("picture".equalsIgnoreCase(argDtype) || "DocBuilderPicture".equalsIgnoreCase(argDtype)) {
/* 132 */       return new DocBuilderPictureConfig();
/*     */     }
/* 134 */     if ("barcode".equalsIgnoreCase(argDtype) || "DocBuilderBarcode".equalsIgnoreCase(argDtype)) {
/* 135 */       return new DocBuilderBarcodeConfig();
/*     */     }
/* 137 */     if ("signature".equalsIgnoreCase(argDtype)) {
/* 138 */       return new DocBuilderSignatureConfig();
/*     */     }
/* 140 */     if ("textblock".equalsIgnoreCase(argDtype)) {
/* 141 */       return new DocBuilderTextBlockConfig();
/*     */     }
/* 143 */     if ("pagebreak".equalsIgnoreCase(argDtype) || "DocBuilderPageBreak".equalsIgnoreCase(argDtype)) {
/* 144 */       return new DocBuilderPageBreakConfig();
/*     */     }
/* 146 */     if ("sectionRef".equalsIgnoreCase(argDtype) || "section".equalsIgnoreCase(argDtype) || "DocBuilderSectionRef"
/* 147 */       .equalsIgnoreCase(argDtype))
/*     */     {
/* 149 */       return new DocBuilderSectionRefConfig();
/*     */     }
/* 151 */     if ("horizontal_rule".equalsIgnoreCase(argDtype) || "HorizontalRule".equalsIgnoreCase(argDtype) || "DocBuilderHorizontalRule"
/* 152 */       .equalsIgnoreCase(argDtype))
/*     */     {
/* 154 */       return new DocBuilderHorizontalRuleConfig();
/*     */     }
/* 156 */     if ("formatter_class".equalsIgnoreCase(argDtype) || "conditionclass".equalsIgnoreCase(argDtype)) {
/* 157 */       return (IConfigObject)new ClassConfig();
/*     */     }
/* 159 */     if ("condition_parameter".equalsIgnoreCase(argDtype)) {
/* 160 */       return (IConfigObject)new ParameterConfig();
/*     */     }
/*     */     
/* 163 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isDocListConfig(String argDtype) {
/* 168 */     if ("DocList".equalsIgnoreCase(argDtype)) {
/* 169 */       return true;
/*     */     }
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   private boolean equalsIgnoreCase(String s1, String s2, String s3) {
/* 175 */     if (!s1.equalsIgnoreCase(s2)) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (!s1.equalsIgnoreCase(s3)) {
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */