/*     */ package dtv.pos.framework.reporting.config;
/*     */ 
/*     */ import dtv.pos.iframework.reporting.IReportRunRule;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IUrlConfig;
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
/*     */ public class ReportRunConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final Logger logger_ = Logger.getLogger(ReportRunConfig.class);
/*     */   
/*     */   private String name_;
/*     */   private String title_;
/*     */   private boolean enabled_ = true;
/*     */   private IUrlConfig report_;
/*  30 */   private final List<ClassConfig<IReportRunRule>> runRuleConfigs_ = new ArrayList<>();
/*  31 */   private List<ReportActionConfig> actionList_ = new ArrayList<>();
/*     */   private IReportRunRule[] runRules_;
/*     */   
/*     */   public ReportActionConfig[] getActions() {
/*  35 */     return this.actionList_.<ReportActionConfig>toArray(new ReportActionConfig[this.actionList_.size()]);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  39 */     if (this.name_ != null) {
/*  40 */       return this.name_;
/*     */     }
/*     */     
/*  43 */     return this.title_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IUrlConfig getReport() {
/*  48 */     return this.report_;
/*     */   }
/*     */   
/*     */   public IReportRunRule[] getRunRules() {
/*  52 */     return this.runRules_;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  56 */     if (this.title_ != null) {
/*  57 */       return this.title_;
/*     */     }
/*     */     
/*  60 */     return this.name_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAvailableRunRules(List<IReportRunRule> argRunRules) {
/*  65 */     this.runRules_ = processRunRules(argRunRules);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  71 */     if ("name".equalsIgnoreCase(argKey)) {
/*  72 */       this.name_ = argValue.toString();
/*     */     }
/*  74 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/*  75 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/*  77 */     else if ("title".equalsIgnoreCase(argKey)) {
/*  78 */       this.title_ = argValue.toString();
/*     */     }
/*  80 */     else if (argValue instanceof IUrlConfig && "report".equalsIgnoreCase(argKey)) {
/*  81 */       this.report_ = (IUrlConfig)argValue;
/*     */     }
/*  83 */     else if ("RunRule".equalsIgnoreCase(argKey)) {
/*  84 */       ClassConfig<IReportRunRule> cc = ConfigUtils.toClassConfig(argValue);
/*  85 */       this.runRuleConfigs_.add(cc);
/*     */     }
/*  87 */     else if (argValue instanceof ReportActionConfig) {
/*  88 */       this.actionList_.add((ReportActionConfig)argValue);
/*     */     } else {
/*     */       
/*  91 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected IReportRunRule[] processRunRules(List<IReportRunRule> argRunRules) {
/*  97 */     if (!this.enabled_) {
/*  98 */       return new IReportRunRule[] { new IReportRunRule()
/*     */           {
/*     */             public boolean isRuleMet(ReportRunConfig argRunConfig) {
/* 101 */               return false;
/*     */             }
/*     */           } };
/*     */     }
/* 105 */     List<IReportRunRule> results = new ArrayList<>();
/* 106 */     for (ClassConfig<IReportRunRule> c : this.runRuleConfigs_) {
/* 107 */       for (IReportRunRule rule : argRunRules) {
/*     */         try {
/* 109 */           if (c.getValue().isInstance(rule)) {
/* 110 */             results.add(rule);
/*     */             
/*     */             break;
/*     */           } 
/* 114 */         } catch (Exception ex) {
/* 115 */           logger_.error("CAUGHT EXCEPTION with " + c.getConfigValue(), ex);
/*     */         } 
/*     */       } 
/*     */     } 
/* 119 */     assert results.size() == this.runRuleConfigs_.size();
/* 120 */     return results.<IReportRunRule>toArray(new IReportRunRule[results.size()]);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportRunConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */