/*     */ package dtv.data2.access.config.pmtype;
/*     */ 
/*     */ import dtv.data2.access.IPersistenceRuleFactory;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersistenceMgrTypeConfig
/*     */   extends AbstractParentConfig
/*     */   implements ICascadableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final Logger _logger = Logger.getLogger(PersistenceMgrTypeConfig.class);
/*     */   
/*     */   private static final String NAME_TAG = "Name";
/*     */   
/*     */   private static final String REF_TAG = "Ref";
/*     */   
/*     */   private static final String PERSISTENCE_MANAGER_RULES_TAG = "PersistenceManagerRules";
/*     */   
/*     */   private static final String PERSISTENCE_STRATEGY_RULES_TAG = "PersistenceStrategyRules";
/*     */   private static final String ONLINE_TAG = "Online";
/*     */   private static final String OFFLINE_TAG = "Offline";
/*     */   private static final String TRAINING_TAG = "Training";
/*     */   private static final String WRITE_JOURNAL_OFFLINE_TAG = "WriteJournalOnline";
/*     */   private static final String SYNC_TAG = "Sync";
/*     */   private static final String CONVERT_TAG = "Convert";
/*     */   private String _name;
/*     */   private String _referenceName;
/*     */   private LocationGroupConfig _onlineLocations;
/*     */   private LocationGroupConfig _offlineLocations;
/*     */   private LocationGroupConfig _trainingLocations;
/*     */   private PersistenceRuleGroupConfig _persistenceManagerRules;
/*     */   private PersistenceRuleGroupConfig _persistenceStrategyRules;
/*     */   private boolean _writeJournalOnline = false;
/*     */   private boolean _isReference = false;
/*     */   @Inject
/*     */   IPersistenceRuleFactory _persistenceRuleFactory;
/*     */   
/*     */   public void cascadeValues(IConfigObject argReference) {
/*  52 */     if (argReference == null || !(argReference instanceof PersistenceMgrTypeConfig)) {
/*  53 */       _logger.error("Attempted to cascade from invalid configuration object!");
/*     */       
/*     */       return;
/*     */     } 
/*  57 */     if (getSourceDescription() == null) {
/*  58 */       setSourceInfo(argReference.getSourceUrl(), argReference.getSourceLineNumber());
/*     */     }
/*     */     
/*  61 */     PersistenceMgrTypeConfig reference = (PersistenceMgrTypeConfig)argReference;
/*     */     
/*  63 */     if (getName() == null) {
/*  64 */       setName(reference.getName());
/*     */     }
/*     */     
/*  67 */     if (getPersistenceManagerRules() == null) {
/*  68 */       setPersistenceManagerRules(reference.getPersistenceManagerRules());
/*     */     }
/*     */     
/*  71 */     if (getPersistenceStrategyRules() == null) {
/*  72 */       setPersistenceStrategyRules(reference.getPersistenceStrategyRules());
/*     */     }
/*     */     
/*  75 */     if (getOfflineLocations() == null) {
/*  76 */       setOfflineLocations(reference.getOfflineLocations());
/*     */     }
/*     */     
/*  79 */     if (getOnlineLocations() == null) {
/*  80 */       setOnlineLocations(reference.getOnlineLocations());
/*     */     }
/*     */     
/*  83 */     if (getTrainingLocations() == null) {
/*  84 */       setTrainingLocations(reference.getTrainingLocations());
/*     */     }
/*     */     
/*  87 */     if (!isWriteJournalOnline()) {
/*  88 */       setWriteJournalOnline(reference.isWriteJournalOnline());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  97 */     return this._name;
/*     */   }
/*     */   
/*     */   public LocationGroupConfig getOfflineLocations() {
/* 101 */     return this._offlineLocations;
/*     */   }
/*     */   
/*     */   public LocationGroupConfig getOnlineLocations() {
/* 105 */     return this._onlineLocations;
/*     */   }
/*     */   
/*     */   public PersistenceRuleGroupConfig getPersistenceManagerRules() {
/* 109 */     return this._persistenceManagerRules;
/*     */   }
/*     */   
/*     */   public PersistenceRuleGroupConfig getPersistenceStrategyRules() {
/* 113 */     return this._persistenceStrategyRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReferenceName() {
/* 124 */     return this._referenceName;
/*     */   }
/*     */   
/*     */   public LocationGroupConfig getTrainingLocations() {
/* 128 */     return this._trainingLocations;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReference() {
/* 136 */     return this._isReference;
/*     */   }
/*     */   
/*     */   public boolean isWriteJournalOnline() {
/* 140 */     return this._writeJournalOnline;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 145 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 146 */       this._name = argValue.toString();
/*     */     }
/* 148 */     else if ("Ref".equalsIgnoreCase(argKey)) {
/* 149 */       this._isReference = true;
/* 150 */       this._referenceName = argValue.toString();
/*     */     }
/* 152 */     else if ("PersistenceManagerRules".equalsIgnoreCase(argKey) && argValue instanceof PersistenceRuleGroupConfig) {
/*     */       
/* 154 */       this._persistenceManagerRules = (PersistenceRuleGroupConfig)argValue;
/*     */     }
/* 156 */     else if ("PersistenceStrategyRules".equalsIgnoreCase(argKey) && argValue instanceof PersistenceRuleGroupConfig) {
/*     */       
/* 158 */       this._persistenceStrategyRules = (PersistenceRuleGroupConfig)argValue;
/*     */     }
/* 160 */     else if ("Online".equalsIgnoreCase(argKey) && argValue instanceof LocationGroupConfig) {
/* 161 */       this._onlineLocations = (LocationGroupConfig)argValue;
/*     */     }
/* 163 */     else if ("Offline".equalsIgnoreCase(argKey) && argValue instanceof LocationGroupConfig) {
/* 164 */       this._offlineLocations = (LocationGroupConfig)argValue;
/*     */     }
/* 166 */     else if ("Training".equalsIgnoreCase(argKey) && argValue instanceof LocationGroupConfig) {
/* 167 */       this._trainingLocations = (LocationGroupConfig)argValue;
/*     */     }
/* 169 */     else if ("WriteJournalOnline".equalsIgnoreCase(argKey)) {
/* 170 */       this._writeJournalOnline = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 172 */     else if ("Sync".equalsIgnoreCase(argKey) && ConfigUtils.toBoolean(argValue)) {
/*     */       
/* 174 */       PersistenceRuleConfig cfg = new PersistenceRuleConfig();
/* 175 */       cfg.setConfigObject("beanName", (IConfigObject)new StringConfig("manageDataInTwoPlacesRule"));
/*     */       
/* 177 */       if (this._persistenceStrategyRules == null) {
/* 178 */         this._persistenceStrategyRules = new PersistenceRuleGroupConfig();
/*     */       }
/* 180 */       this._persistenceStrategyRules.setConfigObject("PersistenceRule", (IConfigObject)cfg);
/*     */     }
/* 182 */     else if ("Convert".equalsIgnoreCase(argKey) && ConfigUtils.toBoolean(argValue)) {
/*     */       
/* 184 */       PersistenceRuleConfig cfg = new PersistenceRuleConfig();
/* 185 */       cfg.setConfigObject("beanName", (IConfigObject)new StringConfig("daoConversionRule"));
/*     */       
/* 187 */       if (this._persistenceStrategyRules == null) {
/* 188 */         this._persistenceStrategyRules = new PersistenceRuleGroupConfig();
/*     */       }
/* 190 */       this._persistenceStrategyRules.setConfigObject("PersistenceRule", (IConfigObject)cfg);
/*     */     } else {
/*     */       
/* 193 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 198 */     this._name = argName;
/*     */   }
/*     */   
/*     */   public void setOfflineLocations(LocationGroupConfig argOfflineLocations) {
/* 202 */     this._offlineLocations = argOfflineLocations;
/*     */   }
/*     */   
/*     */   public void setOnlineLocations(LocationGroupConfig argOnlineLocations) {
/* 206 */     this._onlineLocations = argOnlineLocations;
/*     */   }
/*     */   
/*     */   public void setPersistenceManagerRules(PersistenceRuleGroupConfig argPersistenceManagerRules) {
/* 210 */     this._persistenceManagerRules = argPersistenceManagerRules;
/*     */   }
/*     */   
/*     */   public void setPersistenceStrategyRules(PersistenceRuleGroupConfig argPersistenceStrategyRules) {
/* 214 */     this._persistenceStrategyRules = argPersistenceStrategyRules;
/*     */   }
/*     */   
/*     */   public void setTrainingLocations(LocationGroupConfig argTrainingLocations) {
/* 218 */     this._trainingLocations = argTrainingLocations;
/*     */   }
/*     */   
/*     */   public void setWriteJournalOnline(boolean argWriteJournalOnline) {
/* 222 */     this._writeJournalOnline = argWriteJournalOnline;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceMgrTypeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */