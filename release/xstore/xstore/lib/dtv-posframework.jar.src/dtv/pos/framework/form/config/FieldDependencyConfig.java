/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.config.IFieldDependencyConfig;
/*    */ import dtv.pos.iframework.form.dependency.IDependencyRule;
/*    */ import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterListConfig;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FieldDependencyConfig
/*    */   extends AbstractParentConfig
/*    */   implements IFieldDependencyConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 30 */   private static final Logger logger_ = Logger.getLogger(FieldDependencyConfig.class);
/*    */   
/* 32 */   private final ParameterListConfig parameterList_ = new ParameterListConfig();
/*    */   
/*    */   private String fieldRef_;
/*    */   
/*    */   private ClassConfig dependencyRuleClassConfig_;
/*    */ 
/*    */   
/*    */   public String getFieldRef() {
/* 40 */     return this.fieldRef_;
/*    */   }
/*    */ 
/*    */   
/*    */   public ParameterListConfig getRuleParams() {
/* 45 */     return this.parameterList_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IDependencyRule makeDependencyRule(IEditModel argParentModel, IMutableFieldDefinition argParentField) {
/* 51 */     IDependencyRule rule = null;
/*    */     try {
/* 53 */       rule = this.dependencyRuleClassConfig_.getValue().newInstance();
/*    */     }
/* 55 */     catch (Exception ex) {
/* 56 */       logger_.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/* 58 */     if (rule != null) {
/* 59 */       rule.setConfig(this);
/* 60 */       rule.setParentField(argParentField);
/* 61 */       rule.setParentEditModel(argParentModel);
/*    */     } 
/* 63 */     return rule;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 69 */     if ("field_ref".equalsIgnoreCase(argKey) || "fieldRef".equalsIgnoreCase(argKey)) {
/* 70 */       this.fieldRef_ = argValue.toString();
/*    */     }
/* 72 */     else if ("dependency_rule".equalsIgnoreCase(argKey) || "dependencyRule".equalsIgnoreCase(argKey)) {
/* 73 */       this.dependencyRuleClassConfig_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 75 */     else if (argValue instanceof dtv.util.config.ParameterConfig && argKey.equalsIgnoreCase("parameter")) {
/* 76 */       this.parameterList_.setConfigObject(argKey, argValue);
/*    */     } else {
/*    */       
/* 79 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FieldDependencyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */