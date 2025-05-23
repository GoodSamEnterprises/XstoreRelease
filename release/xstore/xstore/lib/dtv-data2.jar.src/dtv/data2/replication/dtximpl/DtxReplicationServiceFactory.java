/*     */ package dtv.data2.replication.dtximpl;
/*     */ 
/*     */ import dtv.data2.access.impl.PersistenceStrategyFactory;
/*     */ import dtv.data2.replication.ReplicationException;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationConfigHelper;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationServiceConfig;
/*     */ import dtv.data2.replication.dtximpl.config.ServiceConditionConfig;
/*     */ import dtv.data2.replication.dtximpl.config.ServiceDestinationConfig;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.DataSourceDispatcher;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.DataSourceListDispatcher;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.ForwardingDispatcher;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.IDtxReplicationDispatcher;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtxReplicationServiceFactory
/*     */ {
/*     */   private Map<String, DtxReplicationServiceConfig> serviceConfigs_;
/*     */   private List<DtxReplicationService> serviceTemplates_;
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */   
/*     */   public synchronized List<String> getApplicableServices(String argCurrentDataSource, Object argToTest, List<String> argExcludedDataSources) {
/*  33 */     List<String> applicableList = new ArrayList<>(this.serviceConfigs_.size());
/*     */     
/*  35 */     for (DtxReplicationService service : this.serviceTemplates_) {
/*  36 */       service.setCurrentDataSource(argCurrentDataSource);
/*     */       
/*  38 */       if (service.isApplicable(argToTest)) {
/*  39 */         boolean applicable = true;
/*     */ 
/*     */ 
/*     */         
/*  43 */         if (argExcludedDataSources != null) {
/*  44 */           for (String excludedDS : argExcludedDataSources) {
/*  45 */             if (service.isTargeted(excludedDS)) {
/*  46 */               applicable = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*  52 */         if (applicable) {
/*  53 */           applicableList.add(service.getServiceName());
/*     */         }
/*     */       } 
/*     */     } 
/*  57 */     return applicableList;
/*     */   }
/*     */   
/*     */   public ReplicationTransaction getNewTransaction(String argServiceName) {
/*  61 */     DtxReplicationService serviceTemplate = null;
/*     */     
/*  63 */     for (DtxReplicationService service : this.serviceTemplates_) {
/*  64 */       if (argServiceName.equals(service.getServiceName())) {
/*  65 */         serviceTemplate = service;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  70 */     if (serviceTemplate == null) {
/*  71 */       throw new ReplicationException("Attempt was made to retieve unknown replication service for name: " + argServiceName);
/*     */     }
/*     */ 
/*     */     
/*  75 */     ReplicationTransaction trans = new ReplicationTransaction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     trans.setOrganizationId(ReplicationQueueAccessor.getInstance().getOrganizationId());
/*  82 */     trans.setRetailLocationId(ReplicationQueueAccessor.getInstance().getRetailLocationId());
/*  83 */     trans.setWorkstationId(ReplicationQueueAccessor.getInstance().getWorkstationId());
/*  84 */     trans.setCreatedTime(ReplicationUniqueTimestampFactory.getInstance().getCurrentTime());
/*  85 */     trans.setNewTransaction(true);
/*  86 */     trans.setServiceName(argServiceName);
/*     */     
/*  88 */     if (serviceTemplate.getSubscribersNeverExpire()) {
/*  89 */       trans.setNeverExpires(true);
/*     */     }
/*  91 */     else if (serviceTemplate.getSubscribersExpireImmediately()) {
/*  92 */       trans.setExpiresImmediately(true);
/*     */     } else {
/*     */       
/*  95 */       trans.setExpiresAfter(serviceTemplate.getSubscribersExpireAfter());
/*     */     } 
/*     */     
/*  98 */     return trans;
/*     */   }
/*     */   
/*     */   public DtxReplicationService getService(String argServiceName) {
/* 102 */     return getService(null, argServiceName);
/*     */   }
/*     */   public DtxReplicationService getService(String argCurrentDataSource, String argServiceName) {
/*     */     ForwardingDispatcher forwardingDispatcher;
/* 106 */     if (StringUtils.isEmpty(argServiceName)) {
/* 107 */       throw new ReplicationException("Cannot get service for null or empty service name");
/*     */     }
/*     */     
/* 110 */     DtxReplicationServiceConfig config = this.serviceConfigs_.get(argServiceName);
/*     */     
/* 112 */     if (config == null) {
/* 113 */       throw new ReplicationException("Attempt was made to retrieve unknown replication service for name: " + argServiceName);
/*     */     }
/*     */ 
/*     */     
/* 117 */     DtxReplicationService service = new DtxReplicationService();
/* 118 */     service.setEnabled(config.isEnabled());
/* 119 */     service.setServiceName(config.getName());
/* 120 */     service.setSubscribers(config.getSubscribers());
/* 121 */     service.setCurrentDataSource(argCurrentDataSource);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (config.isNeverExpires()) {
/* 128 */       service.setSubscribersNeverExpire(true);
/*     */     
/*     */     }
/* 131 */     else if (config.isExpireImediately()) {
/* 132 */       service.setSubscribersExpireImmediately(true);
/*     */     } else {
/*     */       
/* 135 */       service.setSubscribersExpireAfter(config.getExpireAfter());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     for (ServiceConditionConfig con : config.getConditions()) {
/* 144 */       service.addCondition(con.getCondition());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     ServiceDestinationConfig destinationConfig = config.getDestination();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     if (StringUtils.isEmpty(destinationConfig.getType())) {
/* 156 */       throw new ReplicationException("Replication service " + service.getServiceName() + " does not properly define a destination. destination type is null or empty");
/*     */     }
/*     */ 
/*     */     
/* 160 */     IDtxReplicationDispatcher dispatcher = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     if ("DataSource".equals(destinationConfig.getType())) {
/* 167 */       String dataSourceName = destinationConfig.getDataSourceName();
/* 168 */       DataSourceDispatcher dataSourceDispatcher = new DataSourceDispatcher(dataSourceName, this._persistenceStrategyFactory);
/*     */     }
/* 170 */     else if ("DataSourceList".equals(destinationConfig.getType())) {
/* 171 */       List<String> dataSourceList = new ArrayList<>();
/*     */       
/* 173 */       for (String dataSourceName : destinationConfig.getDataSourceList()) {
/* 174 */         dataSourceList.add(dataSourceName);
/*     */       }
/*     */       
/* 177 */       DataSourceListDispatcher dataSourceListDispatcher = new DataSourceListDispatcher(dataSourceList, this._persistenceStrategyFactory);
/*     */     }
/* 179 */     else if ("DataSourceForwarding".equals(destinationConfig.getType())) {
/*     */       
/* 181 */       forwardingDispatcher = new ForwardingDispatcher(destinationConfig.getDataSourceName(), destinationConfig.getDestinationServiceName());
/*     */     } else {
/*     */       
/* 184 */       throw new ReplicationException("Unknown destination type: " + destinationConfig.getType());
/*     */     } 
/*     */     
/* 187 */     service.setDestination((IDtxReplicationDispatcher)forwardingDispatcher);
/* 188 */     return service;
/*     */   }
/*     */   
/*     */   public void init() {
/* 192 */     DtxReplicationServiceConfig[] serviceConfigsArray = DtxReplicationConfigHelper.getServiceConfigs();
/*     */     
/* 194 */     this.serviceTemplates_ = new ArrayList<>(serviceConfigsArray.length);
/* 195 */     this.serviceConfigs_ = new HashMap<>(serviceConfigsArray.length);
/*     */     
/* 197 */     for (DtxReplicationServiceConfig config : serviceConfigsArray) {
/*     */       
/* 199 */       if (config.isEnabled()) {
/* 200 */         this.serviceConfigs_.put(config.getName(), config);
/* 201 */         this.serviceTemplates_.add(getService(null, config.getName()));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplicationCandidate(String argCurrentDataSource, Object argToTest, List<String> argExcludedDataSources) {
/* 209 */     return !getApplicableServices(argCurrentDataSource, argToTest, argExcludedDataSources).isEmpty();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\DtxReplicationServiceFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */