/*     */ package dtv.data2.access.config.pmtype;
/*     */ 
/*     */ import dtv.data2.access.IPersistenceRule;
/*     */ import dtv.data2.access.IPersistenceRuleFactory;
/*     */ import dtv.util.config.ParameterConfig;
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
/*     */ 
/*     */ public class PersistenceMgrTypeDescriptor
/*     */ {
/*  23 */   private static final Logger _logger = Logger.getLogger(PersistenceMgrTypeDescriptor.class);
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> onlineLookupLocations_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> offlineLookupLocations_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> trainingLookupLocations_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> onlinePersistenceLocations_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> offlinePersistenceLocations_;
/*     */ 
/*     */   
/*     */   private final List<DataSourceLocationConfig> trainingPersistenceLocations_;
/*     */ 
/*     */   
/*     */   private final boolean writeJournalOnline_;
/*     */ 
/*     */   
/*     */   private final List<IPersistenceRule> _persistenceManagerRules;
/*     */ 
/*     */   
/*     */   private final List<IPersistenceRule> _persistenceStrategyRules;
/*     */   
/*     */   private IPersistenceRuleFactory _persistenceRuleFactory;
/*     */ 
/*     */   
/*     */   public PersistenceMgrTypeDescriptor(String argName, List<DataSourceLocationConfig> argOnlineLookup, List<DataSourceLocationConfig> argOnlinePersistence, List<DataSourceLocationConfig> argOfflineLookup, List<DataSourceLocationConfig> argOfflinePersistence, List<DataSourceLocationConfig> argTrainingLookup, List<DataSourceLocationConfig> argTrainingPersistence, boolean argOnlineJournal, PersistenceRuleGroupConfig argPersistenceManagerRules, PersistenceRuleGroupConfig argPersistenceStrategyRules, IPersistenceRuleFactory argRuleFactory) {
/*  59 */     this.name_ = argName;
/*  60 */     this.onlineLookupLocations_ = argOnlineLookup;
/*  61 */     this.offlineLookupLocations_ = argOfflineLookup;
/*  62 */     this.onlinePersistenceLocations_ = argOnlinePersistence;
/*  63 */     this.offlinePersistenceLocations_ = argOfflinePersistence;
/*  64 */     this.trainingLookupLocations_ = argTrainingLookup;
/*  65 */     this.trainingPersistenceLocations_ = argTrainingPersistence;
/*  66 */     this.writeJournalOnline_ = argOnlineJournal;
/*  67 */     this._persistenceRuleFactory = argRuleFactory;
/*  68 */     this._persistenceManagerRules = buildPersistenceRulesFromConfig(argPersistenceManagerRules);
/*  69 */     this._persistenceStrategyRules = buildPersistenceRulesFromConfig(argPersistenceStrategyRules);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  77 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getOfflineLookupLocations() {
/*  85 */     return this.offlineLookupLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getOfflinePersistenceLocations() {
/*  93 */     return this.offlinePersistenceLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getOnlineLookupLocations() {
/* 101 */     return this.onlineLookupLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getOnlinePersistenceLocations() {
/* 109 */     return this.onlinePersistenceLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistenceRule> getPersistenceManagerRules() {
/* 118 */     return this._persistenceManagerRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistenceRule> getPersistenceStrategyRules() {
/* 128 */     return this._persistenceStrategyRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getTrainingLookupLocations() {
/* 136 */     if (this.trainingLookupLocations_ == null) {
/* 137 */       return this.onlineLookupLocations_;
/*     */     }
/* 139 */     return this.trainingLookupLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataSourceLocationConfig> getTrainingPersistenceLocations() {
/* 147 */     if (this.trainingPersistenceLocations_ == null) {
/* 148 */       return this.onlinePersistenceLocations_;
/*     */     }
/* 150 */     return this.trainingPersistenceLocations_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWriteJournalOnline() {
/* 158 */     return this.writeJournalOnline_;
/*     */   }
/*     */   
/*     */   private List<IPersistenceRule> buildPersistenceRulesFromConfig(PersistenceRuleGroupConfig argRuleGroupConfig) {
/* 162 */     List<IPersistenceRule> rules = new ArrayList<>();
/*     */     
/* 164 */     if (argRuleGroupConfig == null) {
/* 165 */       return rules;
/*     */     }
/*     */     
/* 168 */     for (PersistenceRuleConfig ruleConfig : argRuleGroupConfig.getPersistenceRuleConfigs()) {
/* 169 */       IPersistenceRule rule = null;
/*     */       
/*     */       try {
/* 172 */         rule = this._persistenceRuleFactory.getRule(ruleConfig.getRuleBeanName());
/*     */       }
/* 174 */       catch (Exception ex) {
/* 175 */         _logger.error("Error instantiating persistence rule class.  Ensure class implements IPersistenceRule", ex);
/*     */       } 
/*     */ 
/*     */       
/* 179 */       if (rule != null) {
/* 180 */         for (ParameterConfig parameter : ruleConfig.getParameters()) {
/* 181 */           rule.setParameter(parameter.getName(), parameter.getValue());
/*     */         }
/*     */         
/* 184 */         rules.add(rule);
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     return rules;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceMgrTypeDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */