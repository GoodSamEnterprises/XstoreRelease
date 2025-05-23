/*     */ package dtv.logbuilder.config;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.config.DocBuilderConditionConfig;
/*     */ import dtv.logbuilder.routing.IRoutingRule;
/*     */ import dtv.logbuilder.routing.RoutingRule;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class RoutingRuleConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private static final Logger logger_ = Logger.getLogger(RoutingRuleConfig.class);
/*     */   
/*  30 */   private final List<DocBuilderConditionConfig> conditionConfigs_ = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private String documentId_;
/*     */ 
/*     */   
/*     */   private String fileId_;
/*     */   
/*     */   private String ruleName_;
/*     */   
/*     */   private boolean enabled_ = true;
/*     */ 
/*     */   
/*     */   public String getName() {
/*  44 */     if (this.ruleName_ == null) {
/*  45 */       logger_.warn("Routing rule has no name @@ " + getSourceDescription());
/*     */     }
/*  47 */     return this.ruleName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IRoutingRule makeRule() {
/*  56 */     if (this.conditionConfigs_.size() == 0) {
/*  57 */       logger_.warn("No conditions configured @@ [" + getSourceDescription() + "]");
/*  58 */       return null;
/*     */     } 
/*  60 */     if (this.documentId_ == null) {
/*  61 */       logger_.warn("Null document id @@ [" + getSourceDescription() + "]");
/*  62 */       return null;
/*     */     } 
/*  64 */     if (!this.enabled_) {
/*  65 */       logger_.info("Routing rule disabled @@ [" + getSourceDescription() + "]");
/*  66 */       return null;
/*     */     } 
/*  68 */     RoutingRule rule = new RoutingRule();
/*  69 */     rule.setDocumentId(this.documentId_);
/*  70 */     rule.setFileId(this.fileId_);
/*     */     
/*  72 */     for (DocBuilderConditionConfig cc : this.conditionConfigs_) {
/*  73 */       IDocBuilderCondition c = cc.makeCondition();
/*  74 */       if (c != null) {
/*  75 */         rule.addCondition(c);
/*     */       }
/*     */     } 
/*  78 */     rule.setSourceDescription(getSourceDescription());
/*  79 */     return (IRoutingRule)rule;
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
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  91 */     if (argValue instanceof DocBuilderConditionConfig && "condition".equalsIgnoreCase(argKey)) {
/*  92 */       this.conditionConfigs_.add((DocBuilderConditionConfig)argValue);
/*     */     }
/*  94 */     else if ("document_id".equalsIgnoreCase(argKey) || "document".equalsIgnoreCase(argKey)) {
/*  95 */       this.documentId_ = argValue.toString();
/*     */     }
/*  97 */     else if ("file_id".equalsIgnoreCase(argKey) || "file".equalsIgnoreCase(argKey)) {
/*  98 */       this.fileId_ = argValue.toString();
/*     */     }
/* 100 */     else if ("name".equalsIgnoreCase(argKey)) {
/* 101 */       this.ruleName_ = argValue.toString();
/*     */     }
/* 103 */     else if ("transType".equalsIgnoreCase(argKey)) {
/* 104 */       DocBuilderConditionConfig cfg = new DocBuilderConditionConfig();
/* 105 */       cfg.setConditionClass(new ClassConfig("dtv.pos.docbuilding.conditions.TransactionTypeCondition"));
/* 106 */       cfg.setConfigObject("type", argValue);
/* 107 */       this.conditionConfigs_.add(cfg);
/*     */     }
/* 109 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/* 110 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/* 113 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\RoutingRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */