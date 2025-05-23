/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderCall;
/*     */ import dtv.docbuilding.DocBuilderHelper;
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
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderCallConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private static final Logger logger_ = Logger.getLogger(DocBuilderCallConfig.class);
/*     */   
/*  30 */   private final List<DocBuilderConditionConfig> conditionConfigs_ = new ArrayList<>();
/*     */   
/*  32 */   private final List<IReflectionParameterCapable<?>> methodParams_ = new ArrayList<>();
/*     */   
/*  34 */   private final List<ISectionMemberConfig> memberConfigs_ = new ArrayList<>();
/*     */   
/*  36 */   private ClassConfig<IDocBuilderIterator> customCaller_ = null;
/*  37 */   private String method_ = "";
/*     */   
/*     */   public List<DocBuilderConditionConfig> getConditionConfigs() {
/*  40 */     return this.conditionConfigs_;
/*     */   }
/*     */   
/*     */   public ClassConfig<IDocBuilderIterator> getIteratorClass() {
/*  44 */     return this.customCaller_;
/*     */   }
/*     */   
/*     */   public List<ISectionMemberConfig> getMemberConfigs() {
/*  48 */     return this.memberConfigs_;
/*     */   }
/*     */   
/*     */   public String getMethodName() {
/*  52 */     return this.method_;
/*     */   }
/*     */   
/*     */   public List<IReflectionParameterCapable<?>> getMethodParams() {
/*  56 */     return this.methodParams_;
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
/*     */   public IDocBuilderIteratorMember makeCall(IDocElementFactory argElementFactory, DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap) {
/*  70 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(this.conditionConfigs_);
/*  71 */     List<IDocBuilderIteratorMember> members = new ArrayList<>(this.memberConfigs_.size());
/*     */     
/*  73 */     for (int i = 0; i < this.memberConfigs_.size(); i++) {
/*     */       
/*     */       try {
/*  76 */         IDocBuilderIteratorMember o = MemberFactory.createIteratorMember(this.memberConfigs_.get(i), argElementFactory, argSectionMap, argFormatterMap);
/*     */ 
/*     */         
/*  79 */         if (o != null) {
/*  80 */           members.add(o);
/*     */         }
/*     */       }
/*  83 */       catch (Throwable ex) {
/*  84 */         logger_.error("CAUGHT EXCEPTION with config='" + getSourceDescription() + "'", ex);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  90 */     IDocBuilderIterator iterator = (this.customCaller_ == null) ? (IDocBuilderIterator)new DocBuilderCall() : (IDocBuilderIterator)ObjectUtils.createInstance(this.customCaller_.getValue());
/*     */     
/*  92 */     iterator.setMethodName(this.method_);
/*  93 */     iterator.setMethodParams(this.methodParams_);
/*  94 */     iterator.setConditions(conditions);
/*  95 */     iterator.setMembers(members);
/*  96 */     iterator.setSourceDescription(getSourceDescription());
/*     */     
/*  98 */     return (IDocBuilderIteratorMember)iterator;
/*     */   }
/*     */   
/*     */   public void setConditionConfigs(List<DocBuilderConditionConfig> argConditions) {
/* 102 */     this.conditionConfigs_.clear();
/* 103 */     this.conditionConfigs_.addAll(argConditions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 111 */     if (argValue instanceof DocBuilderConditionConfig) {
/* 112 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/* 114 */     else if ("method".equalsIgnoreCase(argKey)) {
/* 115 */       this.method_ = argValue.toString();
/*     */     }
/* 117 */     else if (argValue instanceof IReflectionParameterCapable && "method_param".equalsIgnoreCase(argKey)) {
/* 118 */       this.methodParams_.add((IReflectionParameterCapable)argValue);
/*     */     }
/* 120 */     else if (argValue instanceof ISectionMemberConfig) {
/* 121 */       this.memberConfigs_.add((ISectionMemberConfig)argValue);
/*     */       
/* 123 */       if (argValue instanceof DocBuilderRowConfig) {
/* 124 */         DocBuilderRowConfig rowCfg = (DocBuilderRowConfig)argValue;
/* 125 */         for (int i = 0, n = rowCfg.getCount() - 1; i < n; i++) {
/* 126 */           this.memberConfigs_.add(rowCfg);
/*     */         }
/*     */       }
/*     */     
/* 130 */     } else if ("impl".equalsIgnoreCase(argKey)) {
/* 131 */       this.customCaller_ = ConfigUtils.toClassConfig(argValue);
/*     */     } else {
/*     */       
/* 134 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setIteratorClass(ClassConfig<IDocBuilderIterator> argItClass) {
/* 139 */     this.customCaller_ = argItClass;
/*     */   }
/*     */   
/*     */   public void setMemberConfigs(List<ISectionMemberConfig> argMembers) {
/* 143 */     this.memberConfigs_.clear();
/* 144 */     this.memberConfigs_.addAll(argMembers);
/*     */   }
/*     */   
/*     */   public void setMethodName(String argName) {
/* 148 */     this.method_ = argName;
/*     */   }
/*     */   
/*     */   public void setMethodParams(List<IReflectionParameterCapable<?>> argParams) {
/* 152 */     this.methodParams_.clear();
/* 153 */     this.methodParams_.addAll(argParams);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderCallConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */