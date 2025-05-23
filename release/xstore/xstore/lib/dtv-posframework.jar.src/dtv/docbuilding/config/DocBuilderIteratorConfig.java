/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocBuilderIterator;
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.IDocBuilderIterator;
/*     */ import dtv.docbuilding.IDocBuilderIteratorMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class DocBuilderIteratorConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final Logger logger_ = Logger.getLogger(DocBuilderIteratorConfig.class);
/*     */   
/*  29 */   private final List<DocBuilderConditionConfig> conditionConfigs_ = new ArrayList<>();
/*     */   
/*  31 */   private final List<IReflectionParameterCapable<?>> methodParams_ = new ArrayList<>();
/*     */   
/*  33 */   private final List<ISectionMemberConfig> memberConfigs_ = new ArrayList<>();
/*     */   
/*  35 */   private ClassConfig<IDocBuilderIterator> customIterator_ = null;
/*  36 */   private String method_ = "";
/*  37 */   private ClassConfig<?> itemComparatorConfig_ = null;
/*  38 */   private Comparator<Object> itemComparator_ = null;
/*     */   
/*     */   public List<DocBuilderConditionConfig> getConditionConfigs() {
/*  41 */     return this.conditionConfigs_;
/*     */   }
/*     */   
/*     */   public ClassConfig<IDocBuilderIterator> getCustomIterator() {
/*  45 */     return this.customIterator_;
/*     */   }
/*     */   
/*     */   public ClassConfig<?> getItemComparatorConfig() {
/*  49 */     return this.itemComparatorConfig_;
/*     */   }
/*     */   
/*     */   public List<ISectionMemberConfig> getMemberConfigs() {
/*  53 */     return this.memberConfigs_;
/*     */   }
/*     */   
/*     */   public String getMethod() {
/*  57 */     return this.method_;
/*     */   }
/*     */   
/*     */   public List<IReflectionParameterCapable<?>> getMethodParams() {
/*  61 */     return this.methodParams_;
/*     */   }
/*     */   
/*     */   public List<DocBuilderSectionRefConfig> getSectionReferences() {
/*  65 */     List<DocBuilderSectionRefConfig> refs = new ArrayList<>();
/*     */     
/*  67 */     if (this.memberConfigs_ != null && !this.memberConfigs_.isEmpty()) {
/*  68 */       for (ISectionMemberConfig config : this.memberConfigs_) {
/*  69 */         if (config instanceof DocBuilderSectionRefConfig) {
/*  70 */           refs.add((DocBuilderSectionRefConfig)config);
/*     */         }
/*     */       } 
/*     */     }
/*  74 */     return refs;
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
/*     */   public IDocBuilderIteratorMember makeIterator(IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*     */     IDocBuilderIterator iterator;
/*  88 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(this.conditionConfigs_);
/*  89 */     List<IDocBuilderIteratorMember> members = new ArrayList<>(this.memberConfigs_.size());
/*     */     
/*  91 */     for (ISectionMemberConfig cfg : this.memberConfigs_) {
/*     */       
/*     */       try {
/*  94 */         IDocBuilderIteratorMember o = MemberFactory.createIteratorMember(cfg, argElementFactory, argSectionMap, argFormatterMap);
/*     */         
/*  96 */         if (o != null) {
/*  97 */           members.add(o);
/*     */         }
/*     */       }
/* 100 */       catch (Throwable ex) {
/* 101 */         logger_.error("CAUGHT EXCEPTION with config='" + getSourceDescription() + "'", ex);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 106 */     if (this.customIterator_ == null) {
/* 107 */       DocBuilderIterator docBuilderIterator = new DocBuilderIterator();
/*     */     } else {
/*     */       
/* 110 */       iterator = (IDocBuilderIterator)ObjectUtils.createInstance(this.customIterator_.getValue());
/*     */     } 
/* 112 */     iterator.setMethodName(this.method_);
/* 113 */     iterator.setMethodParams(this.methodParams_);
/* 114 */     iterator.setItemComparator(getItemComparator());
/* 115 */     iterator.setConditions(conditions);
/* 116 */     iterator.setMembers(members);
/* 117 */     iterator.setSourceDescription(getSourceDescription());
/*     */     
/* 119 */     return (IDocBuilderIteratorMember)iterator;
/*     */   }
/*     */   
/*     */   public void setConditionConfigList(List<DocBuilderConditionConfig> argList) {
/* 123 */     this.conditionConfigs_.clear();
/* 124 */     this.conditionConfigs_.addAll(argList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 132 */     if (argValue instanceof DocBuilderConditionConfig) {
/* 133 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/* 135 */     else if ("method".equalsIgnoreCase(argKey)) {
/* 136 */       this.method_ = argValue.toString();
/*     */     }
/* 138 */     else if (argValue instanceof IReflectionParameterCapable && "method_param".equalsIgnoreCase(argKey)) {
/* 139 */       this.methodParams_.add((IReflectionParameterCapable)argValue);
/*     */     }
/* 141 */     else if (argValue instanceof ISectionMemberConfig) {
/* 142 */       this.memberConfigs_.add((ISectionMemberConfig)argValue);
/*     */       
/* 144 */       if (argValue instanceof DocBuilderRowConfig) {
/* 145 */         DocBuilderRowConfig rowCfg = (DocBuilderRowConfig)argValue;
/* 146 */         for (int i = 0, n = rowCfg.getCount() - 1; i < n; i++) {
/* 147 */           this.memberConfigs_.add(rowCfg);
/*     */         }
/*     */       }
/*     */     
/* 151 */     } else if ("item_comparator".equalsIgnoreCase(argKey) || "itemComparator".equalsIgnoreCase(argKey)) {
/* 152 */       this.itemComparatorConfig_ = ConfigUtils.toClassConfig(argValue);
/*     */     }
/* 154 */     else if ("impl".equalsIgnoreCase(argKey) || "class".equalsIgnoreCase(argKey)) {
/* 155 */       this.customIterator_ = ConfigUtils.toClassConfig(argValue);
/*     */     } else {
/*     */       
/* 158 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCustomIterator(ClassConfig<IDocBuilderIterator> argCustomIterator) {
/* 163 */     this.customIterator_ = argCustomIterator;
/*     */   }
/*     */   
/*     */   public void setItemComparator(Comparator<Object> argItemComparator) {
/* 167 */     this.itemComparator_ = argItemComparator;
/*     */   }
/*     */   
/*     */   public void setItemComparatorConfig(ClassConfig<?> argItemComparatorConfig) {
/* 171 */     this.itemComparatorConfig_ = argItemComparatorConfig;
/*     */   }
/*     */   
/*     */   public void setMemberConfigs(List<ISectionMemberConfig> argMembers) {
/* 175 */     this.memberConfigs_.clear();
/* 176 */     this.memberConfigs_.addAll(argMembers);
/*     */   }
/*     */   
/*     */   public void setMethod(String argMethod) {
/* 180 */     this.method_ = argMethod;
/*     */   }
/*     */   
/*     */   public void setMethodParams(List<IReflectionParameterCapable<?>> argParams) {
/* 184 */     this.methodParams_.clear();
/* 185 */     this.methodParams_.addAll(argParams);
/*     */   }
/*     */ 
/*     */   
/*     */   private Comparator<Object> getItemComparator() {
/* 190 */     if (this.itemComparator_ == null && 
/* 191 */       this.itemComparatorConfig_ != null) {
/* 192 */       this.itemComparator_ = (Comparator<Object>)ObjectUtils.createInstance(this.itemComparatorConfig_.getValue());
/*     */     }
/*     */     
/* 195 */     return this.itemComparator_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderIteratorConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */