/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocBuilderSection;
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class DocBuilderSectionConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   public static final String SECTION_TAG = "section";
/*  29 */   private static final Logger logger_ = Logger.getLogger(DocBuilderSectionConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*  32 */   private final List<DocBuilderConditionConfig> conditionConfigs_ = new ArrayList<>();
/*     */ 
/*     */   
/*  35 */   private String name_ = "";
/*  36 */   private final List<ISectionMemberConfig> sectionMembers_ = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void addMemberConfigs(Object argMember) {
/*  40 */     if (argMember instanceof List) {
/*  41 */       this.sectionMembers_.addAll((List)argMember);
/*     */     }
/*  43 */     else if (argMember instanceof ISectionMemberConfig) {
/*  44 */       this.sectionMembers_.add((ISectionMemberConfig)argMember);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<DocBuilderConditionConfig> getConditionConfigs() {
/*  49 */     return this.conditionConfigs_;
/*     */   }
/*     */   
/*     */   public List<ISectionMemberConfig> getMemberConfigs() {
/*  53 */     return this.sectionMembers_;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  57 */     return this.name_;
/*     */   }
/*     */   
/*     */   public List<DocBuilderSectionRefConfig> getSectionReferences() {
/*  61 */     List<DocBuilderSectionRefConfig> refs = new ArrayList<>();
/*     */     
/*  63 */     if (this.sectionMembers_ != null && !this.sectionMembers_.isEmpty()) {
/*  64 */       for (ISectionMemberConfig config : this.sectionMembers_) {
/*  65 */         if (config instanceof DocBuilderSectionRefConfig) {
/*  66 */           refs.add((DocBuilderSectionRefConfig)config); continue;
/*     */         } 
/*  68 */         if (config instanceof DocBuilderIteratorConfig) {
/*  69 */           refs.addAll(((DocBuilderIteratorConfig)config).getSectionReferences());
/*     */         }
/*     */       } 
/*     */     }
/*  73 */     return refs;
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
/*     */   public DocBuilderSection makeSection(IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  87 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(this.conditionConfigs_);
/*     */ 
/*     */     
/*  90 */     DocBuilderSection section = new DocBuilderSection(this.name_, conditions, getSourceDescription());
/*     */     
/*  92 */     for (ISectionMemberConfig config : this.sectionMembers_) {
/*     */       try {
/*  94 */         Object[] o = MemberFactory.createSectionMember(config, argElementFactory, argSectionMap, argFormatterMap);
/*  95 */         if (o != null) {
/*  96 */           section.addMembers(o);
/*     */         }
/*     */       }
/*  99 */       catch (Exception ex) {
/* 100 */         logger_.error("CAUGHT EXCEPTION with config='" + getSourceDescription() + "'", ex);
/*     */       } 
/*     */     } 
/* 103 */     return section;
/*     */   }
/*     */   
/*     */   public void removeMemberConfigs(ISectionMemberConfig argMember) {
/* 107 */     this.sectionMembers_.remove(argMember);
/*     */   }
/*     */   
/*     */   public void setConditionConfigs(List<DocBuilderConditionConfig> argList) {
/* 111 */     this.conditionConfigs_.clear();
/* 112 */     this.conditionConfigs_.addAll(argList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 119 */     if (argValue instanceof ISectionMemberConfig) {
/* 120 */       this.sectionMembers_.add((ISectionMemberConfig)argValue);
/*     */       
/* 122 */       if (argValue instanceof DocBuilderRowConfig) {
/* 123 */         DocBuilderRowConfig rowCfg = (DocBuilderRowConfig)argValue;
/* 124 */         for (int i = 0, n = rowCfg.getCount() - 1; i < n; i++) {
/* 125 */           this.sectionMembers_.add(rowCfg);
/*     */         }
/*     */       }
/*     */     
/* 129 */     } else if (argValue instanceof StringConfig && "name".equalsIgnoreCase(argKey)) {
/* 130 */       this.name_ = argValue.toString();
/*     */     }
/* 132 */     else if (argValue instanceof DocBuilderConditionConfig) {
/* 133 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/* 135 */     else if ("dbRef".equalsIgnoreCase(argKey)) {
/* 136 */       String[] textBlockDef = argValue.toString().split("::");
/*     */       
/* 138 */       DocBuilderFieldConfig docBuilderFieldConfig1 = new DocBuilderFieldConfig();
/* 139 */       docBuilderFieldConfig1.setConfigObject("text", (IConfigObject)new StringConfig(textBlockDef[0]));
/*     */       
/* 141 */       DocBuilderFieldConfig docBuilderFieldConfig2 = new DocBuilderFieldConfig();
/* 142 */       docBuilderFieldConfig2.setConfigObject("text", (IConfigObject)new StringConfig(textBlockDef[1]));
/*     */       
/* 144 */       ISectionMemberConfig cfg = new DocBuilderTextBlockConfig();
/* 145 */       cfg.setConfigObject("code", (IConfigObject)docBuilderFieldConfig1);
/* 146 */       cfg.setConfigObject("subcode", (IConfigObject)docBuilderFieldConfig2);
/* 147 */       cfg.setConfigObject("dateMethod", (IConfigObject)new StringConfig(textBlockDef[2]));
/*     */       
/* 149 */       this.sectionMembers_.add(cfg);
/*     */     } else {
/*     */       
/* 152 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMemberConfigs(List<ISectionMemberConfig> argList) {
/* 157 */     this.sectionMembers_.clear();
/* 158 */     if (argList != null) {
/* 159 */       this.sectionMembers_.addAll(argList);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 164 */     this.name_ = argName;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderSectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */