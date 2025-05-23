/*     */ package dtv.data2.access.status;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.datasource.config.IPing;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.pm.PersistenceManagerStatus;
/*     */ import dtv.util.DtvThreadFactory;
/*     */ import dtv.util.XmlUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatusMgr
/*     */   implements IStatusMgr
/*     */ {
/*  31 */   private static final Logger adminLogger_ = Logger.getLogger("dtv.sysadmin.data.failover");
/*  32 */   private static final StatusMgr instance_ = new StatusMgr();
/*  33 */   private static final Logger logger_ = Logger.getLogger(StatusMgr.class);
/*     */   private final ScheduledExecutorService dataSourceConnectionExecutor_;
/*     */   private List<IOfflineCountListener> countListeners_;
/*     */   private int dataSourceCount_;
/*     */   private Map<String, PersistenceManagerStatus> dataSourceStatusMap_;
/*     */   
/*     */   public static StatusMgr getInstance() {
/*  40 */     return instance_;
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, Long> lastCheckMap_;
/*     */   
/*     */   private Map<String, FailoverException> offlineCauseMap_;
/*     */   
/*     */   private Map<String, Integer> offlineCountMap_;
/*     */   
/*     */   private long offlineInterval_;
/*     */   
/*     */   private List<IDataSourceStatusListener> statusListeners_;
/*     */   
/*     */   private StatusMgr() {
/*  55 */     initialize();
/*     */     
/*  57 */     this
/*  58 */       .dataSourceConnectionExecutor_ = Executors.newSingleThreadScheduledExecutor((ThreadFactory)DtvThreadFactory.makeForDaemons(getClass().getSimpleName()));
/*  59 */     this.dataSourceConnectionExecutor_.scheduleAtFixedRate(new DatasourceConnectionTask(), this.offlineInterval_, this.offlineInterval_, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, PersistenceManagerStatus> getAllDataSourceStatuses() {
/*  64 */     return Collections.unmodifiableMap(this.dataSourceStatusMap_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDataSourceCount() {
/*  72 */     return this.dataSourceCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PersistenceManagerStatus getDataSourceStatus(String argDataSource) {
/*  81 */     return this.dataSourceStatusMap_.get(argDataSource);
/*     */   }
/*     */   
/*     */   public int getForcedOfflineCount() {
/*  85 */     return ((Long)this.offlineCauseMap_.entrySet().stream()
/*  86 */       .filter(e -> e.getValue() instanceof dtv.data2.access.exception.ForcedOfflineException)
/*  87 */       .collect(Collectors.counting()))
/*  88 */       .intValue();
/*     */   }
/*     */   
/*     */   public FailoverException getOfflineCause(String argDataSourceName) {
/*  92 */     return this.offlineCauseMap_.get(argDataSourceName);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOfflineCount() {
/*  97 */     int returnValue = 0;
/*     */     
/*  99 */     Collection<Integer> offlineCounts = this.offlineCountMap_.values();
/* 100 */     for (Integer offlineCount : offlineCounts) {
/* 101 */       returnValue += offlineCount.intValue();
/*     */     }
/* 103 */     return returnValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOfflineCount(String argNetworkScope) {
/* 108 */     Integer offlineCount = this.offlineCountMap_.get(argNetworkScope.toUpperCase());
/* 109 */     return (offlineCount == null) ? 0 : offlineCount.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Integer> getOfflineCountMap() {
/* 114 */     return this.offlineCountMap_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOnline(String argDataSourceName) {
/* 124 */     boolean online = PersistenceManagerStatus.ONLINE.equals(getDataSourceStatus(argDataSourceName));
/* 125 */     FailoverException failover = null;
/*     */     
/* 127 */     if (!online) {
/* 128 */       return online;
/*     */     }
/*     */     
/* 131 */     if (isOnlineRefreshNecessary(argDataSourceName)) {
/*     */       
/* 133 */       DataSourceDescriptor datasource = DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSourceName);
/*     */       
/* 135 */       if (!ping(datasource)) {
/* 136 */         logger_.warn("PING FAILED for datasource: " + datasource.getName());
/*     */         
/* 138 */         online = false;
/* 139 */         failover = FailoverException.getNewException("PING FAILED for datasource: " + datasource
/* 140 */             .getName() + " - this datasource is offline.", argDataSourceName);
/*     */       } 
/*     */ 
/*     */       
/* 144 */       onlineCheckOccurred(argDataSourceName);
/*     */     } 
/*     */     
/* 147 */     if (!online) {
/* 148 */       notifyOffline(argDataSourceName, failover);
/*     */     }
/*     */     
/* 151 */     return online;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyOffline(String argDataSourceName, FailoverException argCause) {
/* 161 */     PersistenceManagerStatus status = this.dataSourceStatusMap_.get(argDataSourceName);
/*     */     
/* 163 */     if (status == null) {
/* 164 */       logger_
/* 165 */         .warn("notifyOffline called with unknown datasource: " + argDataSourceName + " - no action taken.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 170 */     if (!PersistenceManagerStatus.OFFLINE.equals(status)) {
/* 171 */       DataSourceDescriptor dsd = DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSourceName);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       this.dataSourceStatusMap_.put(argDataSourceName, PersistenceManagerStatus.OFFLINE);
/* 177 */       this.offlineCauseMap_.put(argDataSourceName, argCause);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       if (dsd.isOfflineVisible()) {
/* 184 */         Integer offlineCount = this.offlineCountMap_.get(dsd.getNetworkScope().toUpperCase());
/*     */         
/* 186 */         if (offlineCount == null) {
/* 187 */           offlineCount = Integer.valueOf(0);
/*     */         }
/* 189 */         offlineCount = Integer.valueOf(offlineCount.intValue() + 1);
/* 190 */         this.offlineCountMap_.put(dsd.getNetworkScope().toUpperCase(), offlineCount);
/*     */         
/* 192 */         notifyListeners(argDataSourceName, PersistenceManagerStatus.OFFLINE);
/*     */       } 
/*     */       
/* 195 */       logOffline(dsd, (Throwable)argCause);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       if (dsd.isHighAvailability()) {
/* 206 */         notifyOnline(dsd.getName());
/*     */       }
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
/*     */   
/*     */   public void notifyOnline(String argDataSourceName) {
/* 220 */     PersistenceManagerStatus status = this.dataSourceStatusMap_.get(argDataSourceName);
/*     */     
/* 222 */     if (status == null) {
/* 223 */       logger_
/* 224 */         .warn("notifyOnline called with unknown datasource: " + argDataSourceName + " - no action taken.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 229 */     if (!PersistenceManagerStatus.ONLINE.equals(status)) {
/* 230 */       DataSourceDescriptor dsd = DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSourceName);
/* 231 */       this.dataSourceStatusMap_.put(argDataSourceName, PersistenceManagerStatus.ONLINE);
/*     */       
/* 233 */       if (dsd.isOfflineVisible()) {
/* 234 */         Integer offlineCount = this.offlineCountMap_.get(dsd.getNetworkScope().toUpperCase());
/* 235 */         if (offlineCount != null && offlineCount.intValue() > 0) {
/* 236 */           this.offlineCountMap_.put(dsd.getNetworkScope().toUpperCase(), 
/* 237 */               Integer.valueOf(offlineCount.intValue() - 1));
/*     */         }
/*     */         
/* 240 */         notifyListeners(argDataSourceName, PersistenceManagerStatus.ONLINE);
/*     */       } 
/*     */     } 
/* 243 */     onlineCheckOccurred(argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshDbStatus() {
/* 250 */     for (IOfflineCountListener countListener : this.countListeners_) {
/* 251 */       countListener.notifyNewCount(this.offlineCountMap_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOfflineCountListener(IOfflineCountListener argListener) {
/* 260 */     this.countListeners_.add(argListener);
/*     */     
/* 262 */     argListener.notifyNewCount(this.offlineCountMap_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerStatusListener(IDataSourceStatusListener argListener) {
/* 270 */     synchronized (this.statusListeners_) {
/* 271 */       this.statusListeners_.add(argListener);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeStatusListener(IDataSourceStatusListener argListener) {
/* 276 */     synchronized (this.statusListeners_) {
/* 277 */       this.statusListeners_.remove(argListener);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 286 */     this.dataSourceConnectionExecutor_.shutdownNow();
/*     */   }
/*     */   
/*     */   protected String getOfflineMessage(DataSourceDescriptor argDescriptor, Throwable argCause) {
/* 290 */     String msg = String.format("<Offline>\r  <DatasourceName>%s</DatasourceName>\r  <Cause>%s</Cause>\r  <Scope>%s</Scope>\r</Offline>\r", new Object[] {
/*     */ 
/*     */           
/* 293 */           XmlUtils.toXmlSafe(argDescriptor.getName()), XmlUtils.toXmlSafe(argCause.toString()), 
/* 294 */           XmlUtils.toXmlSafe(argDescriptor.getNetworkScope()) });
/* 295 */     return msg;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void logOffline(DataSourceDescriptor argDescriptor, Throwable argCause) {
/* 300 */     logger_
/* 301 */       .warn(String.format("Datasource offline: [%s] EXPLANATION: %s", new Object[] { argDescriptor.getName(), argCause }));
/*     */     
/* 303 */     if (logger_.isInfoEnabled()) {
/* 304 */       logger_.info("Datasource failover stack trace.", argCause);
/*     */     }
/*     */     
/* 307 */     adminLogger_.warn(getOfflineMessage(argDescriptor, argCause));
/*     */   }
/*     */   
/*     */   private void initialize() {
/* 311 */     this.dataSourceStatusMap_ = new HashMap<>(8);
/* 312 */     this.offlineCauseMap_ = new HashMap<>(8);
/*     */     
/* 314 */     this.statusListeners_ = new ArrayList<>(4);
/* 315 */     this.countListeners_ = new ArrayList<>(4);
/* 316 */     this.lastCheckMap_ = new HashMap<>(8);
/*     */     
/* 318 */     String tempInterval = System.getProperty("dtv.data.access.status.OfflineInterval", "60000");
/*     */     try {
/* 320 */       this.offlineInterval_ = Long.valueOf(tempInterval).longValue();
/*     */     }
/* 322 */     catch (NumberFormatException ex) {
/* 323 */       logger_.error("Could not parse system propery: dtv.data.access.status.OfflineInterval; Value: '" + tempInterval + "'", ex);
/*     */       
/* 325 */       this.offlineInterval_ = 60000L;
/*     */     } 
/*     */     
/* 328 */     if (this.offlineInterval_ < 50L) {
/* 329 */       this.offlineInterval_ = 50L;
/*     */     }
/*     */     
/* 332 */     Collection<DataSourceDescriptor> dss = DataSourceFactory.getInstance().getDataSourceDescriptors();
/*     */     
/* 334 */     for (DataSourceDescriptor descriptor : dss) {
/* 335 */       if (!descriptor.isEnabled()) {
/*     */         continue;
/*     */       }
/* 338 */       String name = descriptor.getName();
/* 339 */       this.dataSourceStatusMap_.put(name, PersistenceManagerStatus.ONLINE);
/*     */     } 
/*     */     
/* 342 */     if (this.dataSourceStatusMap_ == null) {
/* 343 */       this.dataSourceCount_ = 0;
/*     */     } else {
/*     */       
/* 346 */       this.dataSourceCount_ = this.dataSourceStatusMap_.size();
/*     */     } 
/* 348 */     this.offlineCountMap_ = new HashMap<>();
/*     */   }
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
/*     */ 
/*     */   
/*     */   private boolean isOnlineRefreshNecessary(String argDataSourceName) {
/* 365 */     Long lastTimeObj = this.lastCheckMap_.get(argDataSourceName);
/* 366 */     if (lastTimeObj == null) {
/* 367 */       return true;
/*     */     }
/*     */     
/* 370 */     long lastRefresh = lastTimeObj.longValue();
/* 371 */     long now = System.currentTimeMillis();
/* 372 */     long elapsed = now - lastRefresh;
/*     */     
/* 374 */     return (elapsed >= this.offlineInterval_);
/*     */   }
/*     */   
/*     */   private void notifyListeners(String argDataSource, PersistenceManagerStatus argStatus) {
/* 378 */     synchronized (this.statusListeners_) {
/* 379 */       for (IDataSourceStatusListener listener : this.statusListeners_) {
/* 380 */         if (PersistenceManagerStatus.ONLINE.equals(argStatus)) {
/* 381 */           listener.notifyOnline(argDataSource); continue;
/*     */         } 
/* 383 */         if (PersistenceManagerStatus.OFFLINE.equals(argStatus)) {
/* 384 */           listener.notfiyOffline(argDataSource);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 389 */     for (IOfflineCountListener countListener : this.countListeners_) {
/* 390 */       countListener.notifyNewCount(this.offlineCountMap_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onlineCheckOccurred(String argDataSourceName) {
/* 400 */     this.lastCheckMap_.put(argDataSourceName, Long.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ping(DataSourceDescriptor argDataSource) {
/* 411 */     boolean success = false;
/*     */     
/* 413 */     IPing ping = argDataSource.getPing();
/*     */     
/* 415 */     if (ping != null) {
/* 416 */       for (int i = 0; i < 5; i++) {
/* 417 */         if (ping.ping()) {
/* 418 */           success = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 424 */       success = true;
/*     */     } 
/*     */     
/* 427 */     return success;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class DatasourceConnectionTask
/*     */     implements Runnable
/*     */   {
/*     */     public void run() {
/* 450 */       Collection<DataSourceDescriptor> dsd = DataSourceFactory.getInstance().getDataSourceDescriptors();
/*     */       
/* 452 */       if (StatusMgr.logger_.isDebugEnabled()) {
/* 453 */         logDatasourcesToBePinged(dsd);
/*     */       }
/*     */       
/* 456 */       for (DataSourceDescriptor descriptor : dsd) {
/* 457 */         String name = "";
/*     */         try {
/* 459 */           name = descriptor.getName();
/*     */           
/* 461 */           if (descriptor.isEnabled()) {
/* 462 */             StatusMgr.logger_.debug("DatasourceConnectionTask: Attempting to ping datasource: " + descriptor.getName());
/*     */             
/* 464 */             if (!descriptor.isForcedOffline() && StatusMgr.this.ping(descriptor)) {
/* 465 */               StatusMgr.this.notifyOnline(name);
/*     */               continue;
/*     */             } 
/* 468 */             StatusMgr.this.notifyOffline(name, FailoverException.getNewException("Ping Failed", name));
/*     */           }
/*     */         
/*     */         }
/* 472 */         catch (Throwable e) {
/*     */           try {
/* 474 */             StatusMgr.logger_.error("Exception encountered while checking the availability of datasource: " + name, e);
/*     */           }
/* 476 */           catch (Throwable throwable) {}
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void logDatasourcesToBePinged(Collection<DataSourceDescriptor> argDsd) {
/* 484 */       StringBuffer message = new StringBuffer("The following datasources will be pinged: ");
/*     */       
/* 486 */       for (DataSourceDescriptor dsd : argDsd) {
/* 487 */         message.append((dsd != null && dsd.isEnabled()) ? (dsd.getName() + ", ") : "");
/*     */       }
/*     */       
/* 490 */       StatusMgr.logger_.debug(message.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\status\StatusMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */