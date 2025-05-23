/*    */ package dtv.logbuilder.config;
/*    */ 
/*    */ import dtv.logbuilder.routing.IRoutingRule;
/*    */ import dtv.logbuilder.routing.RoutingRequest;
/*    */ import dtv.logbuilder.routing.RoutingRequestList;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoutingRulesConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private static final Logger logger_ = Logger.getLogger(RoutingRulesConfig.class);
/* 26 */   private static final boolean isInfoEnabled_ = logger_.isInfoEnabled();
/*    */ 
/*    */   
/*    */   public static final String MAIN_TAG = "RoutingRules";
/*    */   
/* 31 */   private List<RoutingRuleConfig> ruleConfigs_ = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   private List<IRoutingRule> rules_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RoutingRequestList getRoutingRequests(Object argSource) {
/* 41 */     initialize();
/* 42 */     RoutingRequestList reqs = new RoutingRequestList();
/* 43 */     for (int i = 0; i < this.rules_.size(); i++) {
/* 44 */       IRoutingRule rule = this.rules_.get(i);
/* 45 */       if (rule.doesRuleApply(argSource)) {
/* 46 */         reqs.add(new RoutingRequest(rule.getDocumentId(), rule.getFileId()));
/*    */       }
/*    */     } 
/* 49 */     return reqs;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void initialize() {
/* 56 */     if (this.ruleConfigs_ != null) {
/*    */       
/* 58 */       Map<String, RoutingRuleConfig> m = new HashMap<>();
/* 59 */       for (int i = 0; i < this.ruleConfigs_.size(); i++) {
/* 60 */         RoutingRuleConfig c = this.ruleConfigs_.get(i);
/* 61 */         if (isInfoEnabled_ && 
/* 62 */           m.containsKey(c.getName())) {
/* 63 */           RoutingRuleConfig oldValue = m.get(c.getName());
/* 64 */           logger_.info("overriding routing rule " + c.getName() + " from " + oldValue
/* 65 */               .getSourceDescription() + " with one from " + c.getSourceDescription());
/*    */         } 
/*    */         
/* 68 */         m.put(c.getName(), c);
/*    */       } 
/* 70 */       this.ruleConfigs_ = null;
/*    */ 
/*    */       
/* 73 */       this.rules_ = new ArrayList<>();
/* 74 */       Set<Map.Entry<String, RoutingRuleConfig>> entrySet = m.entrySet();
/* 75 */       for (Map.Entry<String, RoutingRuleConfig> entry : entrySet) {
/* 76 */         IRoutingRule rule = ((RoutingRuleConfig)entry.getValue()).makeRule();
/* 77 */         if (rule != null) {
/* 78 */           this.rules_.add(rule);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
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
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 94 */     if (argValue instanceof RoutingRuleConfig) {
/* 95 */       this.ruleConfigs_.add((RoutingRuleConfig)argValue);
/*    */     } else {
/*    */       
/* 98 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\RoutingRulesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */