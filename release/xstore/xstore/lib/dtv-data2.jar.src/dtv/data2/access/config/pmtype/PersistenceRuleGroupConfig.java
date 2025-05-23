/*    */ package dtv.data2.access.config.pmtype;
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
/*    */ public class PersistenceRuleGroupConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final List<PersistenceRuleConfig> _persistenceRules = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<PersistenceRuleConfig> getPersistenceRuleConfigs() {
/* 31 */     return this._persistenceRules;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 37 */     if ("PersistenceRule".equalsIgnoreCase(argKey)) {
/* 38 */       this._persistenceRules.add((PersistenceRuleConfig)argValue);
/*    */     } else {
/*    */       
/* 41 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceRuleGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */