/*    */ package dtv.pos.framework.touch;
/*    */ 
/*    */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class HiddenButtonConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private List<ResponsivenessRuleConfig> rules_;
/*    */   private String actionName_;
/*    */   
/*    */   public String getActionName() {
/* 29 */     return this.actionName_;
/*    */   }
/*    */   
/*    */   public List<ITouchResponsivenessRule> getResponsivenessRules() {
/* 33 */     List<ITouchResponsivenessRule> list = new ArrayList<>();
/* 34 */     if (this.rules_ != null) {
/* 35 */       for (ResponsivenessRuleConfig config : this.rules_) {
/* 36 */         if (config.getRule() != null) {
/* 37 */           list.add(config.getRule());
/*    */         }
/*    */       } 
/*    */     }
/* 41 */     return list;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if (argKey.equalsIgnoreCase("ref") || argKey.equalsIgnoreCase("action")) {
/* 48 */       this.actionName_ = argValue.toString();
/*    */     }
/* 50 */     if (argKey.equalsIgnoreCase("ResponsivenessRule") && argValue instanceof ResponsivenessRuleConfig) {
/* 51 */       addRule((ResponsivenessRuleConfig)argValue);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void addRule(ResponsivenessRuleConfig ruleConfig) {
/* 56 */     if (this.rules_ == null) {
/* 57 */       this.rules_ = new ArrayList<>();
/*    */     }
/*    */     
/* 60 */     this.rules_.add(ruleConfig);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\HiddenButtonConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */