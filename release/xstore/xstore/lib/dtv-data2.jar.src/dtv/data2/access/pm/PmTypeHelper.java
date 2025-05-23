/*     */ package dtv.data2.access.pm;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.IRunQueryKey;
/*     */ import dtv.data2.access.config.pmtype.DataSourceLocationConfig;
/*     */ import dtv.data2.access.config.pmtype.PersistenceMgrTypeDescriptor;
/*     */ import dtv.data2.access.config.query.QueryDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractPersistenceStrategy;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.PersistenceStrategyFactory;
/*     */ import dtv.data2.access.impl.config.PmTypeMappingConfigHelper;
/*     */ import dtv.data2.access.query.DtxQueryHandler;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.access.query.SqlQueryRequest;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PmTypeHelper
/*     */ {
/*  38 */   private static final Logger logger_ = Logger.getLogger(PmTypeHelper.class);
/*     */   private static final int ESTIMATED_QUERY_COUNT = 100;
/*  40 */   private static Map<String, IPersistenceMgrType> pmTypeCache_ = new HashMap<>(100);
/*     */ 
/*     */   
/*     */   private PmTypeMappingConfigHelper _cfg;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */   
/*     */   @Inject
/*     */   private PersistenceMgrTypeFactory _persistenceMgrTypeFactory;
/*     */ 
/*     */   
/*     */   protected PmTypeHelper(PmTypeMappingConfigHelper argCfg) {
/*  58 */     this._cfg = argCfg;
/*  59 */     this._cfg.initialize();
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
/*     */   public List<PmStrategyInfo> getLookupStrategies(IObjectId argObjectId) {
/*  71 */     return getLookupStrategies(getPMTypeByObjectId((Class)argObjectId.getClass()));
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
/*     */   public List<PmStrategyInfo> getLookupStrategies(IPersistenceMgrType argPmType) {
/*  83 */     List<PmStrategyInfo> online = getPrioritizedStratgies(argPmType, true, true);
/*  84 */     List<PmStrategyInfo> offline = getPrioritizedStratgies(argPmType, true, false);
/*     */     
/*  86 */     online.addAll(offline);
/*  87 */     return online;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PmStrategyInfo> getPersistenceStrategies(IObjectId argObjectId) {
/*  97 */     return getPersistenceStrategies(getPMTypeByObjectId((Class)argObjectId.getClass()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PmStrategyInfo> getPersistenceStrategies(IPersistable argPersistable) {
/* 107 */     return getPersistenceStrategies(getPMTypeForPersistable(argPersistable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PmStrategyInfo> getPersistenceStrategies(IPersistenceMgrType argPmType) {
/* 117 */     List<PmStrategyInfo> online = getPrioritizedStratgies(argPmType, false, true);
/* 118 */     List<PmStrategyInfo> offline = getPrioritizedStratgies(argPmType, false, false);
/*     */     
/* 120 */     online.addAll(offline);
/*     */     
/* 122 */     return online;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPMTypeByObject(Object argObject) {
/* 133 */     if (argObject == null) {
/* 134 */       throw new PmTypeDeterminationException("Cannot determine PM type for null object");
/*     */     }
/*     */     
/* 137 */     if (argObject instanceof IDataModel) {
/* 138 */       return getPMTypeByObjectId((Class)((IDataModel)argObject).getObjectId().getClass());
/*     */     }
/* 140 */     if (argObject instanceof Collection) {
/* 141 */       if (!((Collection)argObject).isEmpty()) {
/* 142 */         Object firstObject = ((Collection)argObject).iterator().next();
/* 143 */         if (firstObject instanceof IDataModel) {
/* 144 */           return getPMTypeByObject(firstObject);
/*     */         }
/*     */         
/* 147 */         throw new PmTypeDeterminationException("Cannot determine PM type for the given collection.  The collection must contain IDataModel's but has: " + firstObject
/*     */             
/* 149 */             .getClass().getName());
/*     */       } 
/*     */ 
/*     */       
/* 153 */       throw new PmTypeDeterminationException("Cannot determine PM type for an empty collection");
/*     */     } 
/*     */     
/* 156 */     if (argObject instanceof Object[]) {
/* 157 */       if (((Object[])argObject).length > 0) {
/* 158 */         Object firstObject = ((Object[])argObject)[0];
/* 159 */         if (firstObject instanceof IDataModel) {
/* 160 */           return getPMTypeByObject(firstObject);
/*     */         }
/*     */         
/* 163 */         throw new PmTypeDeterminationException("Cannot determine PM type for the given collection.  The collection must contain IDataModel's but has: " + firstObject
/*     */             
/* 165 */             .getClass().getName());
/*     */       } 
/*     */ 
/*     */       
/* 169 */       throw new PmTypeDeterminationException("Cannot determine PM type for an empty array");
/*     */     } 
/*     */     
/* 172 */     throw new PmTypeDeterminationException("Cannot determine PM type an unknown error occured.  This code should not be hit");
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
/*     */   public IPersistenceMgrType getPMTypeByObjectId(Class<? extends Object> argObjectIdClass) {
/* 185 */     String pmTypeString = null;
/*     */     try {
/* 187 */       pmTypeString = this._cfg.getPMType(argObjectIdClass.getName());
/*     */     }
/* 189 */     catch (Exception ex) {
/* 190 */       if (ex instanceof PmTypeDeterminationException) {
/* 191 */         throw (RuntimeException)ex;
/*     */       }
/*     */       
/* 194 */       throw new PmTypeDeterminationException("Unable to determine PM type for id: " + argObjectIdClass
/* 195 */           .getName() + " see cause exception.", ex);
/*     */     } 
/*     */ 
/*     */     
/* 199 */     if (!StringUtils.isEmpty(pmTypeString)) {
/* 200 */       return PersistenceManagerType.forName(pmTypeString);
/*     */     }
/*     */     
/* 203 */     throw new PmTypeDeterminationException("Unable to determine PM type for id: " + argObjectIdClass
/* 204 */         .getName() + " retrieved null or empty PM type string.");
/*     */   }
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPMTypeByObjectId(IObjectId argId) {
/* 209 */     return getPMTypeByObjectId((Class)argId.getClass());
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
/*     */   public IPersistenceMgrType getPMTypeByObjectId(String argObjectIdClass) {
/* 221 */     if (StringUtils.isEmpty(argObjectIdClass)) {
/* 222 */       throw new DtxException("getPMTypeByObjectId cannot accept null or empty argObjectIdClass");
/*     */     }
/* 224 */     Class<?> clazz = null;
/*     */     
/*     */     try {
/* 227 */       clazz = Class.forName(argObjectIdClass);
/*     */     }
/* 229 */     catch (Exception ee) {
/* 230 */       throw new PmTypeDeterminationException("An exception occurred while attempting to get a class for class name: " + argObjectIdClass, ee);
/*     */     } 
/*     */     
/* 233 */     return getPMTypeByObjectId((Class)clazz);
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
/*     */   public IPersistenceMgrType getPMTypeByQueryKey(String argQueryKey, Map<?, ?> argParams) {
/* 249 */     PersistenceManagerType pmTypeCachced = (PersistenceManagerType)pmTypeCache_.get(argQueryKey);
/*     */     
/* 251 */     if (pmTypeCachced != null) {
/* 252 */       return pmTypeCachced;
/*     */     }
/* 254 */     QueryDescriptor queryDescriptor = DataFactory.getInstance().getQueryDescriptor(argQueryKey);
/*     */     
/* 256 */     if (queryDescriptor == null) {
/* 257 */       throw new DtxException("No query definition found for query key: [" + argQueryKey + "] Check QueryConfig.xml and related.");
/*     */     }
/*     */     
/* 260 */     IPersistenceMgrType pmType = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     String pmTypeProperty = (String)queryDescriptor.getProperties().get("PMType");
/*     */     
/* 269 */     if (!StringUtils.isEmpty(pmTypeProperty)) {
/* 270 */       pmType = PersistenceManagerType.forName(pmTypeProperty);
/*     */     }
/*     */     
/* 273 */     if (pmType == null && DtxQueryHandler.class
/* 274 */       .getName().equals(queryDescriptor.getQueryHandler().getName())) {
/*     */ 
/*     */ 
/*     */       
/* 278 */       Properties props = queryDescriptor.getProperties();
/* 279 */       String objectIdString = (String)ObjectUtils.coalesce(new Object[] { props.get("ClassName"), props.get("ResultClass") });
/*     */       
/* 281 */       if (objectIdString == null)
/*     */       {
/*     */         
/* 284 */         if (argParams != null) {
/* 285 */           Object classNameValue = argParams.get("ClassName");
/*     */           
/* 287 */           if (classNameValue instanceof Class) {
/* 288 */             objectIdString = ((Class)classNameValue).getName();
/*     */           }
/* 290 */           else if (classNameValue instanceof String) {
/* 291 */             objectIdString = classNameValue.toString();
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 296 */       if (objectIdString != null) {
/* 297 */         pmType = getPMTypeByObjectId(objectIdString);
/*     */       }
/*     */     } 
/*     */     
/* 301 */     if (pmType == null) {
/* 302 */       PmTypeDeterminationException ex = new PmTypeDeterminationException("No persistence manager could be determined for query [" + argQueryKey + "]!");
/*     */       
/* 304 */       logger_.error("An error occured while determining PM type", ex);
/* 305 */       throw ex;
/*     */     } 
/*     */     
/* 308 */     pmTypeCache_.put(argQueryKey, pmType);
/*     */ 
/*     */     
/* 311 */     return pmType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPMTypeForPersistable(IPersistable argPersistable) {
/* 321 */     if (argPersistable == null) {
/* 322 */       throw new DtxException("getPersistenceStrategies cannot be called with null argPersistable");
/*     */     }
/* 324 */     if (argPersistable instanceof IDataModel) {
/* 325 */       return getPMTypeByObject(argPersistable);
/*     */     }
/* 327 */     if (argPersistable instanceof IDataAccessObject) {
/* 328 */       return getPMTypeByObjectId((Class)((IDataAccessObject)argPersistable).getObjectId().getClass());
/*     */     }
/* 330 */     if (argPersistable instanceof IRunQueryKey) {
/* 331 */       return getPMTypeByQueryKey(((IRunQueryKey)argPersistable).getQueryKey().getName(), ((IRunQueryKey)argPersistable)
/* 332 */           .getParams());
/*     */     }
/* 334 */     if (argPersistable instanceof SqlQueryRequest) {
/* 335 */       SqlQueryRequest request = (SqlQueryRequest)argPersistable;
/* 336 */       if (StringUtils.isEmpty(request.getPmType())) {
/* 337 */         throw new PmTypeDeterminationException("Cannot determine PM type for SqlQueryRequest because it does not define a pmType. " + argPersistable);
/*     */       }
/*     */ 
/*     */       
/* 341 */       return PersistenceManagerType.forName(request.getPmType());
/*     */     } 
/*     */     
/* 344 */     if (argPersistable instanceof QueryRequest) {
/* 345 */       if (((QueryRequest)argPersistable).getQueryKey() == null) {
/* 346 */         throw new PmTypeDeterminationException("Cannot determine PM type for QueryRequest because it does not define a query. " + argPersistable);
/*     */       }
/*     */       
/* 349 */       return getPMTypeByQueryKey(((QueryRequest)argPersistable).getQueryKey(), ((QueryRequest)argPersistable)
/* 350 */           .getParams());
/*     */     } 
/*     */     
/* 353 */     throw new DtxException("Implementation of IPeristable is not supported: " + argPersistable
/* 354 */         .getClass().getName() + " If this is dataloader running - a system property for loading the proper instance of PmTypeHelper may be missing.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isLoadPropertiesEnabled(Class<? extends Object> argObjectIdClass) {
/* 365 */     return this._cfg.isPMTypeLoadPropertiesEnabled(argObjectIdClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logPmTypeStatus(IPersistenceMgrType argPmType) {
/*     */     List<DataSourceLocationConfig> onlineLookup, offlineLookup, onlinePersistence, offlinePersistence;
/* 374 */     StringBuilder msg = new StringBuilder(1024);
/*     */     
/* 376 */     String trainingModeIndication = isTrainingMode() ? " IN TRAINING MODE." : "";
/*     */     
/* 378 */     msg.append("Logging status of PM type: " + argPmType + trainingModeIndication + "\n");
/*     */ 
/*     */     
/* 381 */     PersistenceMgrTypeDescriptor descriptor = this._persistenceMgrTypeFactory.getPersistenceMgrTypeDescriptor(argPmType);
/*     */     
/* 383 */     msg.append("Online Lookup Locations\n");
/*     */ 
/*     */     
/* 386 */     if (isTrainingMode()) {
/* 387 */       onlineLookup = descriptor.getTrainingLookupLocations();
/*     */     } else {
/*     */       
/* 390 */       onlineLookup = descriptor.getOnlineLookupLocations();
/*     */     } 
/*     */     
/* 393 */     for (DataSourceLocationConfig dataSource : onlineLookup) {
/* 394 */       msg.append(" ");
/* 395 */       msg.append(dataSource.getDataSourceName()).append(": ");
/*     */ 
/*     */       
/* 398 */       if (!DataSourceFactory.getInstance().getDataSourceDescriptor(dataSource.getDataSourceName()).isEnabled()) {
/*     */         
/* 400 */         msg.append("Disabled\n");
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 406 */       if (PersistenceManagerStatus.ONLINE == StatusMgr.getInstance()
/* 407 */         .getDataSourceStatus(dataSource.getDataSourceName())) {
/*     */         
/* 409 */         msg.append("Online\n");
/*     */         continue;
/*     */       } 
/* 412 */       msg.append("Offline\n");
/*     */     } 
/*     */     
/* 415 */     msg.append("Offline Lookup Locations\n");
/*     */ 
/*     */ 
/*     */     
/* 419 */     if (isTrainingMode()) {
/* 420 */       offlineLookup = new ArrayList<>(0);
/*     */     } else {
/*     */       
/* 423 */       offlineLookup = descriptor.getOfflineLookupLocations();
/*     */     } 
/*     */     
/* 426 */     for (DataSourceLocationConfig dataSource : offlineLookup) {
/* 427 */       msg.append(dataSource.getDataSourceName() + ": ");
/*     */ 
/*     */       
/* 430 */       if (!DataSourceFactory.getInstance().getDataSourceDescriptor(dataSource.getDataSourceName()).isEnabled()) {
/*     */         
/* 432 */         msg.append("Disabled\n");
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 438 */       if (PersistenceManagerStatus.ONLINE == StatusMgr.getInstance()
/* 439 */         .getDataSourceStatus(dataSource.getDataSourceName())) {
/*     */         
/* 441 */         msg.append("Online\n");
/*     */         continue;
/*     */       } 
/* 444 */       msg.append("Offline\n");
/*     */     } 
/*     */     
/* 447 */     msg.append("Online Persistence Locations\n");
/*     */ 
/*     */ 
/*     */     
/* 451 */     if (isTrainingMode()) {
/* 452 */       onlinePersistence = descriptor.getTrainingPersistenceLocations();
/*     */     } else {
/*     */       
/* 455 */       onlinePersistence = descriptor.getOnlinePersistenceLocations();
/*     */     } 
/*     */     
/* 458 */     for (DataSourceLocationConfig dataSource : onlinePersistence) {
/* 459 */       msg.append(dataSource.getDataSourceName() + ": ");
/*     */ 
/*     */       
/* 462 */       if (!DataSourceFactory.getInstance().getDataSourceDescriptor(dataSource.getDataSourceName()).isEnabled()) {
/*     */         
/* 464 */         msg.append("Disabled\n");
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 470 */       if (PersistenceManagerStatus.ONLINE == StatusMgr.getInstance()
/* 471 */         .getDataSourceStatus(dataSource.getDataSourceName())) {
/*     */         
/* 473 */         msg.append("Online\n");
/*     */         continue;
/*     */       } 
/* 476 */       msg.append("Offline\n");
/*     */     } 
/*     */     
/* 479 */     msg.append("Offline Persistence Locations\n");
/*     */ 
/*     */ 
/*     */     
/* 483 */     if (isTrainingMode()) {
/* 484 */       offlinePersistence = new ArrayList<>(0);
/*     */     } else {
/*     */       
/* 487 */       offlinePersistence = descriptor.getOfflinePersistenceLocations();
/*     */     } 
/*     */     
/* 490 */     for (DataSourceLocationConfig dataSource : offlinePersistence) {
/* 491 */       msg.append(dataSource.getDataSourceName() + ": ");
/*     */ 
/*     */       
/* 494 */       if (!DataSourceFactory.getInstance().getDataSourceDescriptor(dataSource.getDataSourceName()).isEnabled()) {
/*     */         
/* 496 */         msg.append("Disabled\n");
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 502 */       if (PersistenceManagerStatus.ONLINE == StatusMgr.getInstance()
/* 503 */         .getDataSourceStatus(dataSource.getDataSourceName())) {
/*     */         
/* 505 */         msg.append("Online\n");
/*     */         continue;
/*     */       } 
/* 508 */       msg.append("Offline\n");
/*     */     } 
/*     */     
/* 511 */     logger_.warn(msg);
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
/*     */   protected List<PmStrategyInfo> getPrioritizedStratgies(IPersistenceMgrType argPmType, boolean argLookup, boolean argOnline) {
/* 528 */     PersistenceMgrTypeDescriptor descriptor = this._persistenceMgrTypeFactory.getPersistenceMgrTypeDescriptor(argPmType);
/* 529 */     List<DataSourceLocationConfig> locations = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 534 */     if (!isTrainingMode()) {
/* 535 */       if (argOnline) {
/* 536 */         if (argLookup) {
/* 537 */           locations = descriptor.getOnlineLookupLocations();
/*     */         } else {
/*     */           
/* 540 */           locations = descriptor.getOnlinePersistenceLocations();
/*     */         }
/*     */       
/*     */       }
/* 544 */       else if (argLookup) {
/* 545 */         locations = descriptor.getOfflineLookupLocations();
/*     */       } else {
/*     */         
/* 548 */         locations = descriptor.getOfflinePersistenceLocations();
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 559 */       if (!argOnline) {
/* 560 */         return new ArrayList<>(0);
/*     */       }
/*     */       
/* 563 */       if (argLookup) {
/* 564 */         locations = descriptor.getTrainingLookupLocations();
/*     */       } else {
/*     */         
/* 567 */         locations = descriptor.getTrainingPersistenceLocations();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 574 */     List<PmStrategyInfo> strategies = new ArrayList<>(locations.size());
/* 575 */     List<String> alreadyAdded = new ArrayList<>(locations.size());
/*     */     
/* 577 */     for (DataSourceLocationConfig dataSourceLocation : locations) {
/* 578 */       String dataSourceName = dataSourceLocation.getDataSourceName();
/*     */       
/* 580 */       if (DataSourceFactory.isDataSourceEnabled(dataSourceName))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 585 */         if (!alreadyAdded.contains(dataSourceName)) {
/*     */           
/* 587 */           DataSourceDescriptor dataSource = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSourceName);
/* 588 */           IPersistenceStrategy strategy = this._persistenceStrategyFactory.createStrategy(dataSource, argOnline);
/*     */           
/* 590 */           if (strategy instanceof AbstractPersistenceStrategy) {
/* 591 */             ((AbstractPersistenceStrategy)strategy).setCurrentPmType(argPmType);
/*     */           }
/*     */           
/* 594 */           strategies.add(new PmStrategyInfo(strategy, StatusMgr.getInstance().isOnline(dataSourceName)));
/* 595 */           alreadyAdded.add(dataSourceName);
/*     */         } 
/*     */       }
/*     */     } 
/* 599 */     return strategies;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isTrainingMode() {
/* 609 */     return this._persistenceDefaults.isTraining();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PmTypeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */