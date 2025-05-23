/*    */ package dtv.pos.framework.ui.listview.config;
/*    */ 
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
/*    */ public class ListViewRuleSetConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "RuleSet";
/*    */   public static final String DEFAULT_SET = "DEFAULT";
/*    */   private static final String NAME_TAG = "Name";
/*    */   private static final String RULE_KEY_TAG = "RuleKey";
/*    */   private String name_;
/* 39 */   private final List<String> ruleKeys_ = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 47 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getRuleKeys() {
/* 57 */     return this.ruleKeys_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 63 */     if ("name".equalsIgnoreCase(argKey) || "Name".equalsIgnoreCase(argKey)) {
/* 64 */       this.name_ = argValue.toString();
/*    */     }
/* 66 */     else if ("RuleKey".equalsIgnoreCase(argKey)) {
/* 67 */       this.ruleKeys_.add(argValue.toString());
/*    */     } else {
/*    */       
/* 70 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewRuleSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */