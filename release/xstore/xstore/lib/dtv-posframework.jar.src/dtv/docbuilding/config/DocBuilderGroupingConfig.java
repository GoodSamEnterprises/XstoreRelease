/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderGrouping;
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.IDocBuilderIteratorMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderGroupingConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final Logger logger_ = Logger.getLogger(DocBuilderGroupingConfig.class);
/*     */   
/*  29 */   private final List<DocBuilderConditionConfig> itemConditionConfigs_ = new ArrayList<>();
/*     */   
/*  31 */   private final List<DocBuilderConditionConfig> groupConditionConfigs_ = new ArrayList<>();
/*     */   
/*  33 */   private final List<IReflectionParameterCapable<?>> methodParams_ = new ArrayList<>();
/*     */ 
/*     */   
/*  36 */   private String method_ = "";
/*  37 */   private String groupByMethod_ = "";
/*     */ 
/*     */   
/*     */   private ClassConfig<?> groupComparator_;
/*     */   
/*     */   private ClassConfig<?> itemComparator_;
/*     */   
/*     */   private ISectionMemberConfig header_;
/*     */   
/*     */   private ISectionMemberConfig item_;
/*     */   
/*     */   private ISectionMemberConfig footer_;
/*     */   
/*     */   private ClassConfig<ICollectionFilter> itemFilter_;
/*     */ 
/*     */   
/*     */   public IDocBuilderIteratorMember makeGrouping(IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  54 */     IReflectionParameterCapable[] arrayOfIReflectionParameterCapable = this.methodParams_.<IReflectionParameterCapable>toArray(new IReflectionParameterCapable[this.methodParams_.size()]);
/*     */     
/*  56 */     IDocBuilderIteratorMember header = null;
/*  57 */     if (this.header_ != null) {
/*  58 */       header = MemberFactory.createIteratorMember(this.header_, argElementFactory, argSectionMap, argFormatterMap);
/*     */     }
/*  60 */     IDocBuilderIteratorMember item = null;
/*  61 */     if (this.item_ != null) {
/*  62 */       item = MemberFactory.createIteratorMember(this.item_, argElementFactory, argSectionMap, argFormatterMap);
/*     */     }
/*  64 */     IDocBuilderIteratorMember footer = null;
/*  65 */     if (this.footer_ != null) {
/*  66 */       footer = MemberFactory.createIteratorMember(this.footer_, argElementFactory, argSectionMap, argFormatterMap);
/*     */     }
/*  68 */     ICollectionFilter filter = null;
/*  69 */     if (this.itemFilter_ != null) {
/*     */       try {
/*  71 */         filter = this.itemFilter_.getValue().newInstance();
/*     */       }
/*  73 */       catch (Throwable e) {
/*  74 */         logger_.error("CAUGHT EXCEPTION", e);
/*     */       } 
/*     */     }
/*  77 */     List<IDocBuilderCondition> groupConditions = DocBuilderHelper.createConditions(this.groupConditionConfigs_);
/*  78 */     List<IDocBuilderCondition> itemConditions = DocBuilderHelper.createConditions(this.itemConditionConfigs_);
/*     */     
/*  80 */     DocBuilderGrouping grouping = new DocBuilderGrouping(this.method_, arrayOfIReflectionParameterCapable, this.groupByMethod_, groupConditions, itemConditions, this.groupComparator_, this.itemComparator_, header, item, footer, filter);
/*     */ 
/*     */ 
/*     */     
/*  84 */     grouping.setSourceDescription(getSourceDescription());
/*     */     
/*  86 */     return (IDocBuilderIteratorMember)grouping;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  93 */     if (argValue instanceof DocBuilderConditionConfig && "groupCondition".equalsIgnoreCase(argKey)) {
/*  94 */       this.groupConditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/*  96 */     else if (argValue instanceof DocBuilderConditionConfig && "itemCondition".equalsIgnoreCase(argKey)) {
/*  97 */       this.itemConditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/*  99 */     else if ("method".equalsIgnoreCase(argKey)) {
/* 100 */       this.method_ = argValue.toString();
/*     */     }
/* 102 */     else if (argValue instanceof IReflectionParameterCapable && ("method_param"
/* 103 */       .equalsIgnoreCase(argKey) || "MethodParam".equalsIgnoreCase(argKey))) {
/*     */       
/* 105 */       this.methodParams_.add((IReflectionParameterCapable)argValue);
/*     */     }
/* 107 */     else if ("groupby_method".equalsIgnoreCase(argKey) || "GroupByMethod".equalsIgnoreCase(argKey)) {
/* 108 */       this.groupByMethod_ = argValue.toString();
/*     */     }
/* 110 */     else if (argValue instanceof ClassConfig && ("group_comparator"
/* 111 */       .equalsIgnoreCase(argKey) || "GroupComparator".equalsIgnoreCase(argKey))) {
/*     */       
/* 113 */       this.groupComparator_ = (ClassConfig)argValue;
/*     */     }
/* 115 */     else if (argValue instanceof ClassConfig && ("item_comparator"
/* 116 */       .equalsIgnoreCase(argKey) || "ItemComparator".equalsIgnoreCase(argKey))) {
/*     */       
/* 118 */       this.itemComparator_ = (ClassConfig)argValue;
/*     */     }
/* 120 */     else if (argValue instanceof ClassConfig && "ItemFilter".equalsIgnoreCase(argKey)) {
/* 121 */       this.itemFilter_ = (ClassConfig<ICollectionFilter>)argValue;
/*     */     }
/* 123 */     else if (argValue instanceof ISectionMemberConfig) {
/* 124 */       if ("header".equalsIgnoreCase(argKey)) {
/* 125 */         this.header_ = (ISectionMemberConfig)argValue;
/*     */       }
/* 127 */       else if ("item".equalsIgnoreCase(argKey)) {
/* 128 */         this.item_ = (ISectionMemberConfig)argValue;
/*     */       }
/* 130 */       else if ("footer".equalsIgnoreCase(argKey)) {
/* 131 */         this.footer_ = (ISectionMemberConfig)argValue;
/*     */       } else {
/*     */         
/* 134 */         warnUnsupported(argKey, argValue);
/*     */       } 
/*     */     } else {
/*     */       
/* 138 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderGroupingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */