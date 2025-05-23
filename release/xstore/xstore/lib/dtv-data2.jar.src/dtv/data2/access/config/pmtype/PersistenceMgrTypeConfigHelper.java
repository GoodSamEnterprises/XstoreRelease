/*     */ package dtv.data2.access.config.pmtype;
/*     */ 
/*     */ import dtv.data2.access.IPersistenceRuleFactory;
/*     */ import dtv.data2.access.config.common.AbstractDataConfigHelper;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.PositiveIntegerConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersistenceMgrTypeConfigHelper
/*     */   extends AbstractDataConfigHelper<PersistenceMgrTypeSetConfig>
/*     */ {
/*  24 */   private final Map<String, PersistenceMgrTypeDescriptor> _descriptors = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceRuleFactory _persistenceRuleFactory;
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDescriptors() {
/*  34 */     this._descriptors.clear();
/*  35 */     PersistenceMgrTypeSetConfig root = (PersistenceMgrTypeSetConfig)getRootConfig();
/*     */     
/*  37 */     for (PersistenceMgrTypeConfig pmTypeConfig : root.getChildren()) {
/*  38 */       PersistenceMgrTypeConfig actual = new PersistenceMgrTypeConfig();
/*  39 */       actual = resolveReferences(actual, pmTypeConfig);
/*  40 */       this._descriptors.put(pmTypeConfig.getName(), createPersistenceMgrTypeDescriptor(actual));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PersistenceMgrTypeDescriptor getDescriptor(String argPmTypeName) {
/*  52 */     PersistenceMgrTypeDescriptor descriptor = this._descriptors.get(argPmTypeName);
/*     */     
/*  54 */     if (descriptor == null) {
/*  55 */       descriptor = buildDescriptor(argPmTypeName);
/*  56 */       this._descriptors.put(argPmTypeName, descriptor);
/*     */     } 
/*     */     
/*  59 */     return descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<PersistenceMgrTypeDescriptor> getDescriptors() {
/*  67 */     return this._descriptors.values();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/*  73 */     super.initializeImpl();
/*     */     
/*  75 */     buildDescriptors();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PersistenceMgrTypeDescriptor buildDescriptor(String argPmTypeName) {
/*  86 */     PersistenceMgrTypeSetConfig root = (PersistenceMgrTypeSetConfig)getRootConfig();
/*  87 */     PersistenceMgrTypeConfig requested = root.getPmTypeConfig(argPmTypeName);
/*     */ 
/*     */     
/*  90 */     PersistenceMgrTypeConfig actual = new PersistenceMgrTypeConfig();
/*  91 */     actual.cascadeValues((IConfigObject)requested);
/*     */     
/*  93 */     if (requested.isReference()) {
/*  94 */       PersistenceMgrTypeConfig referenced = root.getPmTypeConfig(requested.getReferenceName());
/*  95 */       actual.cascadeValues((IConfigObject)referenced);
/*     */     } 
/*     */     
/*  98 */     return createPersistenceMgrTypeDescriptor(actual);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PersistenceMgrTypeDescriptor createPersistenceMgrTypeDescriptor(PersistenceMgrTypeConfig argConfig) {
/* 103 */     if (argConfig.getTrainingLocations() != null) {
/* 104 */       return new PersistenceMgrTypeDescriptor(argConfig.getName(), argConfig
/* 105 */           .getOnlineLocations().getLookupLocations(), argConfig
/* 106 */           .getOnlineLocations().getPersistenceLocations(), argConfig
/* 107 */           .getOfflineLocations().getLookupLocations(), argConfig
/* 108 */           .getOfflineLocations().getPersistenceLocations(), argConfig
/* 109 */           .getTrainingLocations().getLookupLocations(), argConfig
/* 110 */           .getTrainingLocations().getPersistenceLocations(), argConfig.isWriteJournalOnline(), argConfig
/* 111 */           .getPersistenceManagerRules(), argConfig.getPersistenceStrategyRules(), this._persistenceRuleFactory);
/*     */     }
/*     */ 
/*     */     
/* 115 */     return new PersistenceMgrTypeDescriptor(argConfig.getName(), argConfig
/* 116 */         .getOnlineLocations().getLookupLocations(), argConfig
/* 117 */         .getOnlineLocations().getPersistenceLocations(), argConfig
/* 118 */         .getOfflineLocations().getLookupLocations(), argConfig
/* 119 */         .getOfflineLocations().getPersistenceLocations(), argConfig
/* 120 */         .getTrainingLocations().getLookupLocations(), argConfig
/* 121 */         .getTrainingLocations().getPersistenceLocations(), argConfig.isWriteJournalOnline(), null, null, this._persistenceRuleFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/* 128 */     return "PersistenceManagerConfig";
/*     */   }
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 133 */     if ("PersistenceManagerTypeSet".equalsIgnoreCase(argDtype)) {
/* 134 */       return (IConfigObject)new PersistenceMgrTypeSetConfig();
/*     */     }
/* 136 */     if ("PersistenceManagerTypeNew".equalsIgnoreCase(argDtype) || "PersistenceManagerType"
/* 137 */       .equalsIgnoreCase(argDtype)) {
/* 138 */       return (IConfigObject)new PersistenceMgrTypeConfig();
/*     */     }
/* 140 */     if ("PersistenceLocation".equalsIgnoreCase(argDtype) || "LookupLocation"
/* 141 */       .equals(argTagName) || "PersistenceLocation".equals(argTagName)) {
/* 142 */       return (IConfigObject)new DataSourceLocationConfig();
/*     */     }
/* 144 */     if ("LocationGroup".equalsIgnoreCase(argDtype)) {
/* 145 */       return (IConfigObject)new LocationGroupConfig();
/*     */     }
/* 147 */     if ("DataSourceName".equals(argTagName)) {
/* 148 */       return (IConfigObject)new StringConfig();
/*     */     }
/* 150 */     if ("Order".equals(argTagName)) {
/* 151 */       return (IConfigObject)new PositiveIntegerConfig();
/*     */     }
/* 153 */     if ("PersistenceRules".equalsIgnoreCase(argDtype)) {
/* 154 */       return (IConfigObject)new PersistenceRuleGroupConfig();
/*     */     }
/* 156 */     if ("PersistenceRule".equals(argTagName)) {
/* 157 */       return (IConfigObject)new PersistenceRuleConfig();
/*     */     }
/*     */     
/* 160 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected PersistenceMgrTypeConfig resolveReferences(PersistenceMgrTypeConfig argActual, PersistenceMgrTypeConfig argReference) {
/* 166 */     argActual.cascadeValues((IConfigObject)argReference);
/*     */     
/* 168 */     if (argReference.isReference()) {
/* 169 */       PersistenceMgrTypeSetConfig root = (PersistenceMgrTypeSetConfig)getRootConfig();
/* 170 */       PersistenceMgrTypeConfig secondReference = root.getPmTypeConfig(argReference.getReferenceName());
/* 171 */       if (secondReference == null) {
/* 172 */         throw new DtxException("Failed to resolve PM type reference: [" + argReference
/* 173 */             .getReferenceName() + "]");
/*     */       }
/* 175 */       resolveReferences(argActual, secondReference);
/*     */     } 
/*     */     
/* 178 */     return argActual;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceMgrTypeConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */