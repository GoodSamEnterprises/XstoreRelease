/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.ui.listview.IListViewRule;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class ListViewRuleConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final Logger logger_ = Logger.getLogger(ListViewRuleConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Rule";
/*     */   
/*     */   private static final String TYPE_TAG = "Type";
/*     */   
/*     */   private static final String CLASS_TAG = "Class";
/*     */   
/*     */   private static final String PARAMETER_TAG = "Parameter";
/*     */   
/*     */   private static final String KEY_TAG = "RuleKey";
/*     */   
/*     */   private String ruleKey_;
/*     */   
/*     */   private IViewElementType type_;
/*     */   private ClassConfig<? extends IListViewRule> classConfig_;
/*     */   private IConfigObject parameter_;
/*     */   
/*     */   public IListViewRule getRule() {
/*  43 */     Class<? extends IListViewRule> ruleClass = getRuleClass();
/*     */     
/*  45 */     if (ruleClass == null) {
/*  46 */       logger_.warn("List view rule configured with no valid class::" + getSourceDescription());
/*  47 */       return null;
/*     */     } 
/*     */     
/*  50 */     IListViewRule rule = null;
/*     */     
/*     */     try {
/*  53 */       rule = ruleClass.newInstance();
/*     */     }
/*  55 */     catch (Exception e) {
/*  56 */       logger_.error("Error creating list view rule for class name [" + ruleClass.getName() + "]::" + 
/*  57 */           getSourceDescription(), e);
/*     */     } 
/*     */     
/*  60 */     rule.setParameter(getParameter());
/*     */     
/*  62 */     return rule;
/*     */   }
/*     */   
/*     */   public String getRuleKey() {
/*  66 */     return this.ruleKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getType() {
/*  74 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  85 */     if ("Type".equalsIgnoreCase(argKey)) {
/*  86 */       setType(ViewElementType.valueOf(argValue.toString()));
/*     */     }
/*  88 */     else if ("Class".equalsIgnoreCase(argKey)) {
/*  89 */       setRuleClass(ConfigUtils.toClassConfig(argValue));
/*     */     }
/*  91 */     else if ("Parameter".equalsIgnoreCase(argKey)) {
/*  92 */       setParameter(argValue);
/*     */     }
/*  94 */     else if ("name".equalsIgnoreCase(argKey) || "RuleKey".equalsIgnoreCase(argKey)) {
/*  95 */       this.ruleKey_ = argValue.toString();
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
/*     */   private IConfigObject getParameter() {
/* 107 */     return this.parameter_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<? extends IListViewRule> getRuleClass() {
/* 115 */     return (this.classConfig_ == null) ? null : this.classConfig_.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setParameter(IConfigObject argObj) {
/* 123 */     this.parameter_ = argObj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRuleClass(ClassConfig<? extends IListViewRule> argClassConfig) {
/* 131 */     this.classConfig_ = argClassConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setType(IViewElementType type) {
/* 139 */     this.type_ = type;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */