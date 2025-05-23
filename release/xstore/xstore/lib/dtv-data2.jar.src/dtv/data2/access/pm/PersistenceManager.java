/*      */ package dtv.data2.access.pm;
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataModelRelationship;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.IPersistable;
/*      */ import dtv.data2.access.IPersistenceMgrType;
/*      */ import dtv.data2.access.IPersistenceRule;
/*      */ import dtv.data2.access.ObjectNotFoundException;
/*      */ import dtv.data2.access.config.pmtype.PersistenceMgrTypeDescriptor;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.exception.FailoverException;
/*      */ import dtv.data2.access.exception.PersistenceCancelledException;
/*      */ import dtv.data2.access.exception.PersistenceException;
/*      */ import dtv.data2.access.exception.PrimaryKeyViolationException;
/*      */ import dtv.data2.access.exception.RetryException;
/*      */ import dtv.data2.access.impl.DaoState;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.IPersistenceStrategy;
/*      */ import dtv.data2.access.impl.PersistableMetaData;
/*      */ import dtv.data2.access.query.IQueryHandler;
/*      */ import dtv.data2.access.query.QueryRequest;
/*      */ import dtv.data2.access.query.QueryToken;
/*      */ import dtv.data2.access.status.StatusMgr;
/*      */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*      */ import dtv.data2.access.transaction.TransactionToken;
/*      */ import dtv.data2.replication.IReplicationStrategy;
/*      */ import dtv.data2.replication.ReplicationStrategyHelper;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class PersistenceManager implements IPersistenceMgr {
/*   37 */   private static final Logger logger_ = Logger.getLogger(PersistenceManager.class);
/*   38 */   private static final boolean LOGGER_DEBUG_ENABLED = logger_.isDebugEnabled();
/*      */ 
/*      */   
/*      */   private static final int ABSOLUTE_MAX_RETRIES = 10;
/*      */ 
/*      */   
/*   44 */   private static final int MAX_RETRIES = Integer.getInteger("dtv.data2.datasource.maxretries", 3).intValue();
/*   45 */   private static final int RETRY_WAIT = Integer.getInteger("dtv.data2.datasource.retrywait", 500).intValue();
/*      */   
/*      */   @Inject
/*      */   private IPersistenceDefaults _persistenceDefaults;
/*      */   
/*      */   @Inject
/*      */   PmTypeHelper _pmTypeHelper;
/*      */   
/*      */   @Inject
/*      */   private PersistenceMgrTypeFactory _persistenceMgrTypeFactory;
/*      */   
/*      */   protected Map<String, Integer> retryCountMap_;
/*      */   
/*      */   protected Map<IPersistenceMgrType, IPersistenceStrategy> pmTypeToStrategyMap_;
/*      */   protected Map<String, List<String>> pmTypeToSuccessfulDSMap_;
/*   60 */   private final Map<IObjectId, IDataModel> alreadyLoadedModels_ = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean replicationEnabled_ = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkExistence(IObjectId argId) {
/*   77 */     boolean objectLocated = false;
/*   78 */     List<PmStrategyInfo> strategies = this._pmTypeHelper.getLookupStrategies(argId);
/*      */     
/*   80 */     if (LOGGER_DEBUG_ENABLED) {
/*   81 */       logger_.debug("Begin checkExistence for id type: " + argId.getClass().getName() + " value: " + argId);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*   86 */     if (strategies.isEmpty()) {
/*   87 */       logNoDatasourceWarning(this._pmTypeHelper.getPMTypeByObjectId((Class)argId.getClass()), "checkExistence for id: " + argId + " will fail without trying to pull the data");
/*      */       
/*   89 */       return objectLocated;
/*      */     } 
/*      */     
/*   92 */     boolean scanOfflineSources = true;
/*      */     
/*   94 */     for (PmStrategyInfo strategyInfo : strategies) {
/*      */ 
/*      */       
/*   97 */       if (!strategyInfo.isCurrentlyAvailable()) {
/*      */         continue;
/*      */       }
/*      */       
/*  101 */       IPersistenceStrategy strategy = strategyInfo.getStrategy();
/*      */       
/*      */       try {
/*  104 */         if (!strategy.isOnlineStrategyType() && !scanOfflineSources) {
/*  105 */           if (LOGGER_DEBUG_ENABLED) {
/*  106 */             logger_.debug("Halting checkExistence because object (" + argId + ") was not found on online datasources.");
/*      */           }
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*  113 */         objectLocated = strategy.checkExistence(argId, null);
/*  114 */         scanOfflineSources = false;
/*      */ 
/*      */         
/*  117 */         if (objectLocated) {
/*  118 */           if (LOGGER_DEBUG_ENABLED) {
/*  119 */             logger_.debug("checkExistence located the object (" + argId + ") returning success.");
/*      */           }
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*  125 */         if (LOGGER_DEBUG_ENABLED) {
/*  126 */           logger_.debug("checkExistence on datasource: " + strategy.getDataSourceName() + " did not locate the object (" + argId + ") ");
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  131 */       catch (Exception exception) {}
/*      */     } 
/*      */ 
/*      */     
/*  135 */     return objectLocated;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cleanup() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IDataModel getObjectById(IObjectId argId, IPersistenceMgrType argType) {
/*  155 */     return getObjectById(argId, argType, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IDataModel getObjectById(IObjectId argId, IPersistenceMgrType argType, PmOperationInfo argOperationInfo) {
/*      */     IPersistenceMgrType type;
/*  170 */     if (argType == null) {
/*  171 */       type = this._pmTypeHelper.getPMTypeByObjectId(argId);
/*      */     } else {
/*      */       
/*  174 */       type = argType;
/*      */     } 
/*  176 */     QueryToken token = new QueryToken(argId, type);
/*      */     try {
/*  178 */       return getObjectById(argId, type, token, argOperationInfo);
/*      */     } finally {
/*      */       
/*  181 */       QueryResourceManager.getInstance().closeQueryResources(token);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IDataModel getObjectById(IObjectId argId, IPersistenceMgrType argType, QueryToken argQueryToken, PmOperationInfo argOperationInfo) {
/*  198 */     if (LOGGER_DEBUG_ENABLED) {
/*  199 */       logger_.debug("Begin getObjectById for id type: " + argId.getClass().getName() + " value: " + argId + " using Persistence manager type: " + argType
/*  200 */           .getName());
/*      */     }
/*      */     
/*  203 */     IDataModel result = null;
/*  204 */     List<PmStrategyInfo> strategies = this._pmTypeHelper.getLookupStrategies(argType);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  209 */     if (strategies.isEmpty()) {
/*  210 */       logNoDatasourceWarning(argType, "getObjectById for id: " + argId + " will fail without trying to pull the data");
/*      */       
/*  212 */       throw new ObjectNotFoundException("Lookup failed for id type " + argId.getClass().getName() + " value: " + argId + " No datasources were available.");
/*      */     } 
/*      */ 
/*      */     
/*  216 */     boolean scanOfflineSources = true;
/*      */ 
/*      */ 
/*      */     
/*  220 */     IPersistenceStrategy preferredDataSource = null;
/*  221 */     PersistableMetaData metaData = new PersistableMetaData("OBJECT_RETRIEVED");
/*      */     
/*  223 */     for (PmStrategyInfo strategyInfo : strategies) {
/*      */ 
/*      */       
/*  226 */       if (!strategyInfo.isCurrentlyAvailable()) {
/*  227 */         if (argOperationInfo != null) {
/*  228 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  234 */       IPersistenceStrategy strategy = strategyInfo.getStrategy();
/*  235 */       String dsName = strategy.getDataSourceName();
/*      */ 
/*      */       
/*      */       try {
/*  239 */         if (!strategy.isOnlineStrategyType() && !scanOfflineSources) {
/*  240 */           if (LOGGER_DEBUG_ENABLED) {
/*  241 */             logger_.debug("Halting getObjectById because object (" + argId + ") was not found on online datasources.");
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */ 
/*      */         
/*  250 */         if (LOGGER_DEBUG_ENABLED) {
/*  251 */           logger_.debug("Performing getObjectById (" + argId + ") on datasource: " + dsName);
/*      */         }
/*      */         
/*      */         try {
/*  255 */           metaData.addDataSourceVisited(dsName);
/*  256 */           result = strategy.getObjectById(argId, argQueryToken);
/*  257 */           metaData.setPersistable((IPersistable)result);
/*      */         }
/*  259 */         catch (UnsupportedOperationException ee) {
/*  260 */           if (LOGGER_DEBUG_ENABLED) {
/*  261 */             logger_.debug("Datasource: " + dsName + " does not support getObjectById for id: " + argId);
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*  266 */         if (LOGGER_DEBUG_ENABLED) {
/*  267 */           logger_.debug("getObjectById (" + argId + ") on datasource: " + dsName + " resulted in object: " + result);
/*      */         }
/*      */ 
/*      */         
/*  271 */         scanOfflineSources = false;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  276 */         if (result != null) {
/*  277 */           metaData.setSuccessfulDataSource(dsName);
/*      */           
/*  279 */           if (strategy.isFullGraphProvided()) {
/*      */             
/*  281 */             applyPersistenceRules(metaData, false, argType);
/*      */             
/*  283 */             if (LOGGER_DEBUG_ENABLED) {
/*  284 */               logger_.debug("getObjectById (" + argId + ") returning because strategy reports full graph is provided: " + result);
/*      */             }
/*      */ 
/*      */             
/*  288 */             return result;
/*      */           } 
/*      */           
/*  291 */           if (LOGGER_DEBUG_ENABLED) {
/*  292 */             logger_.debug("getObjectById (" + argId + ") preferredDataSource is now: " + dsName);
/*      */           }
/*      */           
/*  295 */           preferredDataSource = strategy;
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*  300 */       } catch (FailoverException ee) {
/*  301 */         StatusMgr.getInstance().notifyOffline(dsName, ee);
/*  302 */         if (argOperationInfo != null) {
/*  303 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       }
/*  306 */       catch (RetryException ee) {
/*  307 */         StatusMgr.getInstance().notifyOffline(dsName, FailoverException.getNewException((Throwable)ee, dsName));
/*  308 */         if (argOperationInfo != null) {
/*  309 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  318 */     if (result != null) {
/*  319 */       result = loadRelationships(result, preferredDataSource, argQueryToken, false);
/*      */     } else {
/*      */       
/*  322 */       if (LOGGER_DEBUG_ENABLED) {
/*  323 */         logger_.debug("getObjectById (" + argId + ") failed, throwing ObjectNotFoundException.");
/*      */       }
/*  325 */       throw new ObjectNotFoundException("Lookup failed for id type " + argId
/*  326 */           .getClass().getName() + " value: " + argId);
/*      */     } 
/*      */     
/*  329 */     if (LOGGER_DEBUG_ENABLED) {
/*  330 */       logger_.debug("getObjectById (" + argId + ") succeeded, returning result: " + result);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  335 */     applyPersistenceRules(metaData, false, argType);
/*      */     
/*  337 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObjectByQuery(String argQueryKey, Map<String, Object> argParams, IPersistenceMgrType argPmType) {
/*  356 */     return getObjectByQuery(new QueryRequest(argQueryKey, argParams, argPmType), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReplicationEnabled() {
/*  363 */     return (!this._persistenceDefaults.isTraining() && ReplicationStrategyHelper.isReplicationEnabled() && this.replicationEnabled_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T makePersistent(T argObject, long argTimeout) {
/*  379 */     if (LOGGER_DEBUG_ENABLED) {
/*  380 */       logger_.debug("Begin makePersistent on object " + argObject);
/*      */     }
/*  382 */     this.retryCountMap_ = new HashMap<>(4);
/*      */ 
/*      */ 
/*      */     
/*  386 */     T objToPersist = applyManagerPersistenceRules(argObject);
/*      */     
/*  388 */     if (objToPersist != null) {
/*      */ 
/*      */       
/*  391 */       List<? extends IPersistable> persistableList = getPersistables(objToPersist);
/*      */       
/*  393 */       if (persistableList.isEmpty()) {
/*  394 */         logger_.debug("There are no objects to persist contained within " + argObject + ".  Returning.");
/*  395 */         return argObject;
/*      */       } 
/*      */       
/*  398 */       boolean complete = false;
/*  399 */       long START_TIME = System.currentTimeMillis();
/*      */ 
/*      */       
/*  402 */       int maxRetries = 10;
/*      */ 
/*      */ 
/*      */       
/*  406 */       while (!complete) {
/*      */         
/*  408 */         TransactionToken token = startTransaction(persistableList);
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  413 */           if (maxRetries-- <= 0) {
/*  414 */             rollbackTransaction(token);
/*  415 */             throw new PersistenceCancelledException("makePersistent call being cancelled because absolute maxRetries (10) has been exceeded");
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  420 */           for (IPersistable persistable : persistableList) {
/*  421 */             IPersistenceStrategy strategy = getPersistenceStrategy(persistable);
/*      */ 
/*      */             
/*  424 */             PersistableMetaData metaData = new PersistableMetaData("OBJECT_PERSISTED");
/*      */             
/*  426 */             metaData.setPersistable(persistable);
/*      */             
/*  428 */             if (strategy == null) {
/*  429 */               throw handleNoStrategiesForPersistence(token, objToPersist, persistable);
/*      */             }
/*  431 */             String dsName = strategy.getDataSourceName();
/*      */             
/*  433 */             if (LOGGER_DEBUG_ENABLED) {
/*  434 */               logger_.debug("Calling makePersistent on strategy: " + dsName + " with persistable: " + persistable);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  439 */             metaData.addDataSourceVisited(dsName);
/*  440 */             persistable = applyPersistenceRules(metaData, true, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  447 */             strategy.makePersistent(token, persistable);
/*      */ 
/*      */             
/*  450 */             List<String> successfulDSNames = getSuccessfulDSNames(persistable, dsName);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             try {
/*  457 */               replicateData(token, dsName, persistable, successfulDSNames);
/*      */             }
/*  459 */             catch (ReplicationException ex) {
/*  460 */               logger_.error("Replication of [" + persistable + "] after writing to [" + dsName + "]failed!", (Throwable)ex);
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  465 */             long ELAPSED_TIME = System.currentTimeMillis() - START_TIME;
/*      */             
/*  467 */             if (argTimeout > 0L && ELAPSED_TIME >= argTimeout) {
/*  468 */               throw new PersistenceCancelledException("makePersistent call sucessfully cancelled due to timeout, transaction rolled back. (timeoutValue: " + argTimeout + " elapsed time: " + ELAPSED_TIME);
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  474 */           commitTransaction(token, persistableList);
/*  475 */           complete = true;
/*      */         }
/*  477 */         catch (PersistenceCancelledException ex) {
/*  478 */           complete = false;
/*  479 */           handlePersistenceCancelled(token, ex);
/*      */         }
/*  481 */         catch (RetryException ex) {
/*  482 */           complete = false;
/*  483 */           handlePersistenceRetry(token, ex);
/*      */         }
/*  485 */         catch (FailoverException ex) {
/*  486 */           complete = false;
/*  487 */           handlePersistenceFailover(token, ex);
/*      */         }
/*  489 */         catch (PrimaryKeyViolationException ex) {
/*  490 */           complete = false;
/*  491 */           handlePrimaryKeyViolation(token, ex, objToPersist);
/*      */         }
/*  493 */         catch (Exception ex) {
/*  494 */           complete = false;
/*  495 */           handleGeneralPersistenceException(token, ex, objToPersist);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  500 */       commitDataModelTransaction(objToPersist);
/*      */       
/*  502 */       if (!complete) {
/*  503 */         throw new DtxException("Invalid state in DefaultPersistenceManager - this code should not be executed unless complete = true. Persistable objects will not be saved.");
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  509 */     if (LOGGER_DEBUG_ENABLED) {
/*  510 */       logger_.debug("makePersistent completed successfully for object " + argObject);
/*      */     }
/*  512 */     return objToPersist;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void replicateData(TransactionToken argTransToken, String argCurrentDataSourceName, IPersistable argPersisable, List<String> argExcludedDataSources) {
/*  520 */     if (isReplicationEnabled()) {
/*  521 */       IReplicationStrategy strategy = ReplicationStrategyHelper.getReplicationStategy();
/*      */       
/*  523 */       if (strategy.isReplicationCandidate(argCurrentDataSourceName, argPersisable, argExcludedDataSources)) {
/*  524 */         if (!(argPersisable instanceof IDataAccessObject) && !(argPersisable instanceof QueryRequest)) {
/*  525 */           throw new DtxException("Replication is not yet supported for IPersistable implementation: " + argPersisable
/*  526 */               .getClass().getName() + ". Please implement.");
/*      */         }
/*      */         
/*  529 */         strategy.replicateData(argCurrentDataSourceName, argTransToken, argPersisable, argExcludedDataSources);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReplicationEnabled(boolean argEnabled) {
/*  543 */     this.replicationEnabled_ = argEnabled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected IPersistable applyPersistenceRules(PersistableMetaData argMetaData, boolean argApplyRulesAtStrategyLevel, Object argObject) {
/*      */     List<IPersistenceRule> persistenceRules;
/*  562 */     IPersistable persistable = argMetaData.getPersistable();
/*  563 */     IPersistenceMgrType pmType = null;
/*  564 */     if (argObject instanceof IPersistenceMgrType) {
/*  565 */       pmType = (IPersistenceMgrType)argObject;
/*      */     } else {
/*      */       
/*  568 */       pmType = this._pmTypeHelper.getPMTypeForPersistable(argMetaData.getPersistable());
/*      */     } 
/*      */     
/*  571 */     PersistenceMgrTypeDescriptor pmTypeDescriptor = this._persistenceMgrTypeFactory.getPersistenceMgrTypeDescriptor(pmType);
/*      */ 
/*      */     
/*  574 */     if (argApplyRulesAtStrategyLevel) {
/*  575 */       persistenceRules = pmTypeDescriptor.getPersistenceStrategyRules();
/*      */     } else {
/*      */       
/*  578 */       persistenceRules = pmTypeDescriptor.getPersistenceManagerRules();
/*      */     } 
/*      */     
/*  581 */     for (IPersistenceRule persistenceRule : persistenceRules) {
/*  582 */       if (persistenceRule.isApplicable(argMetaData, argObject)) {
/*  583 */         persistable = persistenceRule.applyRule(argMetaData, argObject);
/*  584 */         argMetaData.setPersistable(persistable);
/*      */       } 
/*      */     } 
/*  587 */     return persistable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void commitTransaction(TransactionToken argToken, List<? extends IPersistable> argPersistables) throws PersistenceException {
/*  601 */     if (LOGGER_DEBUG_ENABLED) {
/*  602 */       logger_.debug("Committing transaction " + argToken);
/*      */     }
/*      */     
/*  605 */     DataSourceTransactionManager.getInstance().commit(argToken);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  610 */     for (IPersistable persistable : argPersistables) {
/*  611 */       if (persistable instanceof IDataAccessObject) {
/*  612 */         IDataAccessObject dao = (IDataAccessObject)persistable;
/*      */         
/*  614 */         if (DaoState.isNew(dao) || DaoState.isUpdated(dao)) {
/*  615 */           dao.setObjectState(DaoState.CLEAN.intVal());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object getObjectByQuery(QueryRequest argQueryRequest, PmOperationInfo argOperationInfo) {
/*  634 */     QueryToken token = new QueryToken(argQueryRequest);
/*      */     try {
/*  636 */       return getObjectByQuery(argQueryRequest, token, argOperationInfo);
/*      */     } finally {
/*      */       
/*  639 */       QueryResourceManager.getInstance().closeQueryResources(token);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object getObjectByQuery(QueryRequest argQueryRequest, QueryToken argQueryToken, PmOperationInfo argOperationInfo) {
/*  659 */     String queryKey = argQueryRequest.getQueryKey();
/*  660 */     Map<String, Object> params = argQueryRequest.getParams();
/*      */     
/*  662 */     if (LOGGER_DEBUG_ENABLED) {
/*  663 */       logger_.debug("Begin getObjectByQuery. Query key: " + queryKey + " params: " + params);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  669 */     IQueryHandler handler = DataFactory.getInstance().getQueryHandler(queryKey);
/*      */     
/*  671 */     if (LOGGER_DEBUG_ENABLED) {
/*  672 */       logger_.debug("getObjectByQuery using query handler: " + handler + " for query: " + queryKey);
/*      */     }
/*      */     
/*  675 */     Object<IDataModel> result = null;
/*      */ 
/*      */     
/*  678 */     IPersistenceMgrType pmType = (argQueryRequest.getPmType() != null) ? argQueryRequest.getPmType() : this._pmTypeHelper.getPMTypeByQueryKey(queryKey, params);
/*      */     
/*  680 */     List<PmStrategyInfo> strategies = this._pmTypeHelper.getLookupStrategies(pmType);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  686 */     if (strategies.isEmpty()) {
/*  687 */       logNoDatasourceWarning(pmType, "getObjectByQuery for key: " + queryKey + " will fail without trying to pull the data.");
/*      */       
/*  689 */       throw new ObjectNotFoundException("Lookup failed for Query Key: " + queryKey + " There were no available datasources.");
/*      */     } 
/*      */ 
/*      */     
/*  693 */     boolean scanOfflineSources = true;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  698 */     IPersistenceStrategy preferredDataSource = null;
/*  699 */     PersistableMetaData metaData = new PersistableMetaData("OBJECT_QUERIED");
/*  700 */     metaData.setPersistable((IPersistable)argQueryRequest);
/*      */     
/*  702 */     for (PmStrategyInfo strategyInfo : strategies) {
/*      */       
/*  704 */       if (!strategyInfo.isCurrentlyAvailable()) {
/*  705 */         if (argOperationInfo != null) {
/*  706 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  712 */       IPersistenceStrategy strategy = strategyInfo.getStrategy();
/*  713 */       String dsName = strategy.getDataSourceName();
/*      */       
/*      */       try {
/*  716 */         if (!strategy.isOnlineStrategyType() && !scanOfflineSources) {
/*  717 */           if (LOGGER_DEBUG_ENABLED) {
/*  718 */             logger_
/*  719 */               .debug("getObjectByQuery is aborting because no result was found on online strategies");
/*      */           }
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */ 
/*      */         
/*      */         try {
/*  728 */           metaData.addDataSourceVisited(dsName);
/*  729 */           result = (Object<IDataModel>)strategy.getObjectByQuery(queryKey, params, argQueryToken);
/*      */           
/*  731 */           applyPersistenceRules(metaData, true, result);
/*      */         }
/*  733 */         catch (UnsupportedOperationException ee) {
/*  734 */           if (LOGGER_DEBUG_ENABLED) {
/*  735 */             logger_.debug("Datasource: " + dsName + " does not support getObjectByQuery for qyery key: " + queryKey);
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  741 */         if (LOGGER_DEBUG_ENABLED) {
/*  742 */           logger_.debug("getObjectByQuery got result " + result + " on datasource: " + dsName + " for query key: " + queryKey);
/*      */         }
/*      */ 
/*      */         
/*  746 */         scanOfflineSources = false;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  751 */         if (result != null) {
/*  752 */           metaData.setSuccessfulDataSource(dsName);
/*      */ 
/*      */ 
/*      */           
/*  756 */           replicateActionQuery(strategy, queryKey, params);
/*      */           
/*  758 */           if (strategy.isFullGraphProvided()) {
/*  759 */             if (LOGGER_DEBUG_ENABLED) {
/*  760 */               logger_.debug("getObjectByQuery is returning " + result + " because  datasource: " + dsName + " is a full graph provider.");
/*      */             }
/*      */             
/*  763 */             applyPersistenceRules(metaData, false, result);
/*      */             
/*  765 */             return result;
/*      */           } 
/*      */           
/*  768 */           preferredDataSource = strategy;
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*  773 */       } catch (FailoverException ee) {
/*  774 */         StatusMgr.getInstance().notifyOffline(dsName, ee);
/*  775 */         if (argOperationInfo != null) {
/*  776 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       }
/*  779 */       catch (RetryException ee) {
/*  780 */         StatusMgr.getInstance().notifyOffline(dsName, FailoverException.getNewException((Throwable)ee, dsName));
/*  781 */         if (argOperationInfo != null) {
/*  782 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  788 */     applyPersistenceRules(metaData, false, result);
/*      */     
/*  790 */     if (result != null) {
/*      */ 
/*      */ 
/*      */       
/*  794 */       if (handler instanceof dtv.data2.access.query.DtxQueryHandler) {
/*  795 */         if (result instanceof Collection) {
/*  796 */           List<IDataModel> list = asList(result);
/*  797 */           result = (Object<IDataModel>)list;
/*  798 */           for (int ii = 0; ii < list.size(); ii++) {
/*  799 */             if (LOGGER_DEBUG_ENABLED) {
/*  800 */               logger_.debug("getObjectByQuery is loading relationships for model: " + list.get(ii));
/*      */             }
/*  802 */             IDataModel m = loadRelationships(list.get(ii), preferredDataSource, argQueryToken, false);
/*  803 */             list.set(ii, m);
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */           
/*  809 */           throw new DtxException("An unxpected type was returned from DtxQueryHandler. Should be a Collection, but found: " + 
/*  810 */               ObjectUtils.getClassNameFromObject(result));
/*      */         } 
/*      */       }
/*  813 */       if (LOGGER_DEBUG_ENABLED) {
/*  814 */         logger_.debug("getObjectByQuery returning result  " + result + " for query key: " + queryKey);
/*      */       }
/*      */       
/*  817 */       return result;
/*      */     } 
/*      */ 
/*      */     
/*  821 */     String msg = "Lookup failed for Query Key: " + queryKey + " with params: " + StringUtils.truncate(params.toString(), 200);
/*  822 */     throw new ObjectNotFoundException(msg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<? extends IPersistable> getPersistables(Object argObject) {
/*  837 */     if (argObject == null) {
/*  838 */       throw new DtxException("makePersistent() cannot accept null object");
/*      */     }
/*      */     
/*  841 */     List<? extends IPersistable> persistableList = DaoUtils.getPersistables(argObject);
/*  842 */     return persistableList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected IPersistenceStrategy getPersistenceStrategy(IPersistable argPersistable) {
/*  854 */     IPersistenceMgrType pmType = this._pmTypeHelper.getPMTypeForPersistable(argPersistable);
/*      */     
/*  856 */     if (this.pmTypeToStrategyMap_.containsKey(pmType)) {
/*  857 */       return this.pmTypeToStrategyMap_.get(pmType);
/*      */     }
/*      */     
/*  860 */     List<PmStrategyInfo> strategies = this._pmTypeHelper.getPersistenceStrategies(pmType);
/*      */     
/*  862 */     if (strategies == null || strategies.isEmpty()) {
/*  863 */       return null;
/*      */     }
/*      */     
/*  866 */     for (PmStrategyInfo strategyInfo : strategies) {
/*  867 */       if (strategyInfo.isCurrentlyAvailable()) {
/*  868 */         this.pmTypeToStrategyMap_.put(pmType, strategyInfo.getStrategy());
/*  869 */         return strategyInfo.getStrategy();
/*      */       } 
/*      */     } 
/*      */     
/*  873 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<String> getSuccessfulDSNames(IPersistable argPersistable, String argCurDataSource) {
/*      */     List<String> successfulDSNames;
/*  887 */     IPersistenceMgrType pmType = this._pmTypeHelper.getPMTypeForPersistable(argPersistable);
/*      */ 
/*      */     
/*  890 */     if (pmType == null) {
/*  891 */       logger_.error("Persistence Manager not found for type: " + argPersistable.getClass().getName());
/*  892 */       successfulDSNames = new ArrayList<>();
/*      */     
/*      */     }
/*  895 */     else if (this.pmTypeToSuccessfulDSMap_.containsKey(pmType.getName())) {
/*  896 */       successfulDSNames = this.pmTypeToSuccessfulDSMap_.get(pmType.getName());
/*      */     } else {
/*      */       
/*  899 */       successfulDSNames = new ArrayList<>();
/*  900 */       this.pmTypeToSuccessfulDSMap_.put(pmType.getName(), successfulDSNames);
/*      */     } 
/*      */ 
/*      */     
/*  904 */     if (!successfulDSNames.contains(argCurDataSource)) {
/*  905 */       successfulDSNames.add(argCurDataSource);
/*      */     }
/*      */     
/*  908 */     return successfulDSNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void loadRelationship(IDataModelRelationship argRel, IDataModelImpl argModel, IPersistenceStrategy argPreferredDataSource, QueryToken argQueryToken, boolean isTransientRelationship, PmOperationInfo argOperationInfo) {
/*  926 */     if (argRel.isPropertyRelationship() && 
/*  927 */       !this._pmTypeHelper.isLoadPropertiesEnabled((Class)argModel.getObjectId().getClass()).booleanValue()) {
/*      */       return;
/*      */     }
/*      */     
/*  931 */     if (LOGGER_DEBUG_ENABLED) {
/*  932 */       logger_.debug("Begin loadRelationship. Relationship: " + argRel.getIdentifier() + " Type: " + argRel
/*  933 */           .getType() + " for model: " + argModel + (isTransientRelationship ? " <Transient>" : ""));
/*      */     }
/*      */     
/*  936 */     IDataModelRelationship relationship = argRel;
/*  937 */     IDataModelImpl parentModel = argModel;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  942 */     relationship.setParent((IDataModel)parentModel);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     IObjectId childObjectId = null;
/*      */     
/*  949 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.equals(relationship.getType())) {
/*  950 */       childObjectId = argPreferredDataSource.getChildObjectIdForRelationship(relationship);
/*      */       
/*  952 */       if (LOGGER_DEBUG_ENABLED) {
/*  953 */         String childClassName = (childObjectId != null) ? childObjectId.getClass().getName() : null;
/*  954 */         logger_.debug("Determined child object for relationship: " + argRel.getIdentifier() + " Type: " + argRel
/*  955 */             .getType() + " to have id: " + childClassName + " value: " + childObjectId);
/*      */       } 
/*      */       
/*  958 */       if (childObjectId == null) {
/*  959 */         if (LOGGER_DEBUG_ENABLED) {
/*  960 */           logger_.debug("loadRelationship is returning without having loaded the relationship: " + argRel
/*  961 */               .getIdentifier() + " Type: " + argRel.getType() + " because childObjectId is null.");
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*  966 */       if (!childObjectId.validate()) {
/*  967 */         if (LOGGER_DEBUG_ENABLED) {
/*  968 */           logger_.debug("loadRelationship is returning without having loaded the relationship: " + argRel
/*  969 */               .getIdentifier() + " Type: " + argRel.getType() + " because childObjectId (" + childObjectId
/*  970 */               .getClass().getName() + " value: " + childObjectId + ") was not valid. This usually means the parent did not have the proper keys to load the relationship.");
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  976 */       if (this.alreadyLoadedModels_.containsKey(childObjectId)) {
/*  977 */         IDataModel peerModel = this.alreadyLoadedModels_.get(childObjectId);
/*      */         
/*  979 */         if (LOGGER_DEBUG_ENABLED) {
/*  980 */           logger_.debug("loadRelationship found an entry for (" + childObjectId + ") in alreadyLoadedModels_." + relationship
/*  981 */               .getIdentifier() + " will be set to: " + peerModel + " if it's not null on model " + parentModel);
/*      */         }
/*      */ 
/*      */         
/*  985 */         if (peerModel != null) {
/*  986 */           parentModel.setValue(relationship.getIdentifier(), peerModel);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  998 */     IPersistenceMgrType pmType = this._pmTypeHelper.getPMTypeByObjectId(relationship.getChild());
/*      */     
/* 1000 */     if (LOGGER_DEBUG_ENABLED) {
/* 1001 */       logger_.debug("loadRelationship using PM type: " + pmType + " to lookup relationship " + relationship
/* 1002 */           .getIdentifier() + " for model " + parentModel);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1008 */     List<PmStrategyInfo> strategies = null;
/*      */ 
/*      */ 
/*      */     
/* 1012 */     if (argPreferredDataSource != null && (IDataModelRelationship.RelationshipType.ONE_TO_MANY
/* 1013 */       .equals(relationship.getType()) || (relationship
/* 1014 */       .isUseParentPm() && IDataModelRelationship.RelationshipType.ONE_TO_ONE
/* 1015 */       .equals(relationship.getType())))) {
/*      */       
/* 1017 */       strategies = new ArrayList<>(1);
/* 1018 */       strategies.add(new PmStrategyInfo(argPreferredDataSource, true));
/*      */       
/* 1020 */       if (LOGGER_DEBUG_ENABLED) {
/* 1021 */         logger_.debug("loadRelationship using *Preferred Datasource*: " + argPreferredDataSource
/* 1022 */             .getDataSourceName() + " to lookup relationship " + relationship
/* 1023 */             .getIdentifier() + " for model " + parentModel);
/*      */       }
/*      */     } else {
/*      */       
/* 1027 */       strategies = this._pmTypeHelper.getLookupStrategies(pmType);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1033 */     if (strategies.isEmpty()) {
/* 1034 */       logNoDatasourceWarning(pmType, "loadRelationships() for relationship: '" + relationship.getIdentifier() + "' on model: " + parentModel + " will fail without trying to pull the data.");
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1039 */     boolean scanOfflineSources = true;
/*      */     
/* 1041 */     for (PmStrategyInfo strategyInfo : strategies) {
/*      */       
/* 1043 */       if (!strategyInfo.isCurrentlyAvailable()) {
/* 1044 */         if (argOperationInfo != null) {
/* 1045 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/* 1051 */       IPersistenceStrategy strategy = strategyInfo.getStrategy();
/* 1052 */       String dsName = strategy.getDataSourceName();
/*      */       
/* 1054 */       if (!strategy.isOnlineStrategyType() && !scanOfflineSources) {
/* 1055 */         if (LOGGER_DEBUG_ENABLED) {
/* 1056 */           logger_.debug("loadRelationship returning without having loaded relationship " + relationship
/* 1057 */               .getIdentifier() + " for model " + parentModel + " because a value was not found on the online datasources.");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1068 */       if (strategy.isFullGraphProvided() && 
/* 1069 */         !IDataModelRelationship.RelationshipType.ONE_TO_ONE.equals(relationship.getType())) {
/* 1070 */         if (LOGGER_DEBUG_ENABLED) {
/* 1071 */           logger_.debug("loadRelationship skipped datasource " + dsName + " for relationship " + relationship
/* 1072 */               .getIdentifier() + " on model " + parentModel + " because it is a fullGraphProvider, and therefore does not support relationship lookups.");
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*      */       try {
/* 1079 */         Object relatedObject = null;
/*      */         
/*      */         try {
/* 1082 */           relatedObject = strategy.getObjectByRelationship(relationship, argQueryToken);
/*      */         }
/* 1084 */         catch (UnsupportedOperationException ee) {
/* 1085 */           if (LOGGER_DEBUG_ENABLED) {
/* 1086 */             logger_.debug("Datasource: " + dsName + " does not support getObjectByRelationship for relationship: " + relationship
/*      */                 
/* 1088 */                 .getIdentifier());
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/* 1093 */         if (LOGGER_DEBUG_ENABLED) {
/* 1094 */           logger_.debug("loadRelationship got result " + relatedObject + " for getObjectByRelationship on datasource: " + dsName + " for  relationship " + relationship
/* 1095 */               .getIdentifier() + " on model " + parentModel);
/*      */         }
/*      */ 
/*      */         
/* 1099 */         scanOfflineSources = false;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1104 */         if (relatedObject != null) {
/* 1105 */           if (strategy.isFullGraphProvided()) {
/* 1106 */             if (LOGGER_DEBUG_ENABLED) {
/* 1107 */               logger_.debug("loadRelationship is setting " + relationship.getIdentifier() + " to " + relatedObject + " on model " + parentModel + " without recursively calling loadRelationships because datasource: " + dsName + " is a full graph provider");
/*      */             }
/*      */ 
/*      */ 
/*      */             
/* 1112 */             parentModel.setValue(relationship.getIdentifier(), relatedObject);
/*      */ 
/*      */ 
/*      */             
/*      */             return;
/*      */           } 
/*      */ 
/*      */           
/* 1120 */           if (relatedObject instanceof IDataModel) {
/* 1121 */             if (LOGGER_DEBUG_ENABLED) {
/* 1122 */               logger_
/* 1123 */                 .debug("loadRelationship loading relationships for relatedObject  " + relatedObject);
/*      */             }
/*      */             
/* 1126 */             if (isTransientRelationship && relatedObject instanceof IDataModelImpl) {
/* 1127 */               ((IDataModelImpl)relatedObject).getDAO().setTransientObject(true);
/*      */             }
/*      */             
/* 1130 */             relatedObject = loadRelationships((IDataModel)relatedObject, strategy, argQueryToken, isTransientRelationship);
/*      */           
/*      */           }
/* 1133 */           else if (relatedObject instanceof List) {
/* 1134 */             List<IDataModel> list = asList(relatedObject);
/*      */ 
/*      */             
/* 1137 */             for (int ii = 0; ii < list.size(); ii++) {
/* 1138 */               IDataModel m = list.get(ii);
/* 1139 */               if (LOGGER_DEBUG_ENABLED) {
/* 1140 */                 logger_.debug("loadRelationship loading relationships for relatedObject list element  " + ii + ": " + m);
/*      */               }
/*      */               
/* 1143 */               m = loadRelationships(m, strategy, argQueryToken, isTransientRelationship);
/*      */               
/* 1145 */               if (isTransientRelationship && m instanceof IDataModelImpl) {
/* 1146 */                 ((IDataModelImpl)m).getDAO().setTransientObject(true);
/*      */               }
/*      */               
/* 1149 */               list.set(ii, m);
/*      */             } 
/*      */           } 
/*      */           
/* 1153 */           if (LOGGER_DEBUG_ENABLED) {
/* 1154 */             logger_.debug("loadRelationship setting  " + relationship.getIdentifier() + " to " + relatedObject + " on: " + parentModel);
/*      */           }
/*      */           
/* 1157 */           parentModel.setValue(relationship.getIdentifier(), relatedObject);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1167 */         if (childObjectId != null);
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1172 */       catch (FailoverException ee) {
/* 1173 */         StatusMgr.getInstance().notifyOffline(dsName, ee);
/* 1174 */         if (argOperationInfo != null) {
/* 1175 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       }
/* 1178 */       catch (RetryException ee) {
/* 1179 */         StatusMgr.getInstance().notifyOffline(dsName, FailoverException.getNewException((Throwable)ee, dsName));
/* 1180 */         if (argOperationInfo != null) {
/* 1181 */           argOperationInfo.setOfflineDatasourceFound();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected IDataModel loadRelationships(IDataModel argDataModel, IPersistenceStrategy argPreferredDataSource, QueryToken argQueryToken, boolean ancestorHasTransientRelationship) {
/* 1200 */     if (LOGGER_DEBUG_ENABLED) {
/* 1201 */       logger_.debug("Begin loadRelationships for model: " + argDataModel + " with preferredDataSource: " + ((argPreferredDataSource != null) ? argPreferredDataSource
/* 1202 */           .getDataSourceName() : null));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1209 */     if (this.alreadyLoadedModels_.containsKey(argDataModel.getObjectId())) {
/* 1210 */       if (LOGGER_DEBUG_ENABLED) {
/* 1211 */         logger_.debug("loadRelationships found model: " + argDataModel + " in the alreadyLoadedModels_ map.  Returning.");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1219 */       IDataModel alreadyLoaded = this.alreadyLoadedModels_.get(argDataModel.getObjectId());
/*      */       
/* 1221 */       if (alreadyLoaded != null) {
/* 1222 */         return alreadyLoaded;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1229 */     IDataModelImpl model = (IDataModelImpl)argDataModel;
/* 1230 */     IDataAccessObject dao = model.getDAO();
/* 1231 */     IDataModelRelationship[] relationships = DataModelFactory.getModelRelationships(dao);
/* 1232 */     if (relationships != null) {
/* 1233 */       for (IDataModelRelationship relationship : relationships) {
/* 1234 */         loadRelationship(relationship, model, argPreferredDataSource, argQueryToken, relationship
/* 1235 */             .isTransientRelationship() | ancestorHasTransientRelationship, null);
/*      */       }
/*      */     }
/* 1238 */     dao.setObjectState(DaoState.CLEAN.intVal());
/* 1239 */     return argDataModel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void rollbackTransaction(TransactionToken argToken) throws PersistenceException {
/* 1252 */     if (LOGGER_DEBUG_ENABLED) {
/* 1253 */       logger_.debug("Rolling back transaction " + argToken);
/*      */     }
/* 1255 */     DataSourceTransactionManager.getInstance().rollback(argToken);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected TransactionToken startTransaction(Object argObject) throws PersistenceException {
/* 1268 */     if (this.pmTypeToStrategyMap_ == null) {
/* 1269 */       this.pmTypeToStrategyMap_ = new HashMap<>();
/*      */     }
/* 1271 */     this.pmTypeToStrategyMap_.clear();
/*      */     
/* 1273 */     if (this.pmTypeToSuccessfulDSMap_ == null) {
/* 1274 */       this.pmTypeToSuccessfulDSMap_ = new HashMap<>();
/*      */     }
/* 1276 */     this.pmTypeToSuccessfulDSMap_.clear();
/*      */     
/* 1278 */     IDataAccessObject sampleDao = DaoUtils.getSampleDao(argObject);
/* 1279 */     IObjectId objectIdTransTokenRandomSeed = null;
/*      */     
/* 1281 */     if (sampleDao != null) {
/* 1282 */       objectIdTransTokenRandomSeed = sampleDao.getObjectId();
/*      */     }
/*      */ 
/*      */     
/* 1286 */     TransactionToken token = DataSourceTransactionManager.getInstance().startTransaction(objectIdTransTokenRandomSeed);
/*      */     
/* 1288 */     if (LOGGER_DEBUG_ENABLED) {
/* 1289 */       logger_.debug("Starting transaction " + token);
/*      */     }
/*      */     
/* 1292 */     return token;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <T> T applyManagerPersistenceRules(T argObjectToPersist) {
/* 1300 */     List<IPersistable> persistables = new ArrayList<>();
/*      */ 
/*      */ 
/*      */     
/* 1304 */     for (DaoUtils.PersistableLink rootLink : DaoUtils.getRootPersistables(argObjectToPersist)) {
/* 1305 */       IPersistable rootPersistable = rootLink.getPersistable();
/* 1306 */       IPersistenceMgrType pmType = this._pmTypeHelper.getPMTypeForPersistable(rootPersistable);
/* 1307 */       PersistableMetaData metaData = new PersistableMetaData("OBJECT_PERSISTED");
/* 1308 */       metaData.setPersistable(rootPersistable);
/*      */       
/* 1310 */       persistables.add(applyPersistenceRules(metaData, false, pmType));
/*      */     } 
/*      */ 
/*      */     
/* 1314 */     T objToPersist = argObjectToPersist;
/*      */     
/* 1316 */     if (!persistables.isEmpty()) {
/* 1317 */       if (objToPersist instanceof Collection) {
/*      */ 
/*      */ 
/*      */         
/* 1321 */         ((Collection)objToPersist).clear();
/* 1322 */         ((Collection<IPersistable>)objToPersist).addAll(persistables);
/*      */       }
/*      */       else {
/*      */         
/* 1326 */         objToPersist = (T)persistables.get(0);
/*      */       } 
/*      */     }
/* 1329 */     return objToPersist;
/*      */   }
/*      */ 
/*      */   
/*      */   private List<IDataModel> asList(Object relatedObject) {
/* 1334 */     if (relatedObject == null) {
/* 1335 */       return null;
/*      */     }
/* 1337 */     if (relatedObject instanceof Collection) {
/* 1338 */       return new ArrayList<>((Collection<? extends IDataModel>)relatedObject);
/*      */     }
/*      */     
/* 1341 */     throw new DtxException("asList argument must be a collection at the very least, but was: " + relatedObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void commitDataModelTransaction(Object argObject) {
/* 1347 */     if (argObject instanceof Collection) {
/* 1348 */       for (Object dataObject : argObject) {
/* 1349 */         if (dataObject instanceof IDataModel) {
/* 1350 */           ((IDataModel)dataObject).commitTransaction();
/*      */         }
/*      */       }
/*      */     
/* 1354 */     } else if (argObject instanceof IDataModel) {
/* 1355 */       ((IDataModel)argObject).commitTransaction();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleGeneralPersistenceException(TransactionToken argToken, Exception argEx, Object argObjectToSave) {
/* 1362 */     logger_.error("Exception caught persisting object: " + argObjectToSave, argEx);
/* 1363 */     DaoUtils.logFailedPersistence(argEx, argObjectToSave);
/* 1364 */     rollbackTransaction(argToken);
/*      */     
/* 1366 */     throw new PersistenceException(argEx);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PersistenceException handleNoStrategiesForPersistence(TransactionToken argToken, Object argObjectToPersist, IPersistable argCurrentPersistable) {
/* 1381 */     String msg = "!!! makePersistent() failure !!! Cannot persist object: " + argCurrentPersistable + " No Available Datasources.";
/*      */ 
/*      */     
/* 1384 */     if (!(argCurrentPersistable instanceof QueryRequest)) {
/* 1385 */       logNoDatasourceWarning(this._pmTypeHelper.getPMTypeForPersistable(argCurrentPersistable), msg);
/*      */     }
/*      */     
/* 1388 */     Throwable throwable = new Throwable("STACK TRACE - Could not save data due to no available datasources");
/*      */ 
/*      */     
/* 1391 */     logger_.error(msg, throwable);
/* 1392 */     rollbackTransaction(argToken);
/* 1393 */     DaoUtils.logFailedPersistence(throwable, argObjectToPersist);
/*      */     
/* 1395 */     return new PersistenceException(msg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handlePersistenceCancelled(TransactionToken argToken, PersistenceCancelledException argException) {
/* 1407 */     logger_.warn("Persistence was intentionally cancelled. " + argException.toString());
/* 1408 */     rollbackTransaction(argToken);
/* 1409 */     throw argException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handlePersistenceFailover(TransactionToken argToken, FailoverException argFailover) {
/* 1419 */     if (LOGGER_DEBUG_ENABLED) {
/* 1420 */       logger_.debug("Failover occurred.  Rollback the transaction and start over.");
/*      */     }
/* 1422 */     StatusMgr.getInstance().notifyOffline(argFailover.getDataSourceName(), argFailover);
/* 1423 */     rollbackTransaction(argToken);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handlePersistenceRetry(TransactionToken argToken, RetryException argRetry) {
/* 1433 */     rollbackTransaction(argToken);
/*      */     
/* 1435 */     if (LOGGER_DEBUG_ENABLED) {
/* 1436 */       logger_.debug("Retry exception occurred.  Rollback the transaction and start over.");
/*      */     }
/*      */     
/* 1439 */     Integer retryCountObj = this.retryCountMap_.get(argRetry.getDataSourceName());
/*      */     
/* 1441 */     int retryCount = (retryCountObj != null) ? retryCountObj.intValue() : 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1446 */     if (retryCount >= MAX_RETRIES) {
/*      */       
/* 1448 */       FailoverException ee = FailoverException.getNewException("Failing over datasource: " + argRetry.getDataSourceName() + " because the retry count (" + MAX_RETRIES + ") was exceeded.", (Throwable)argRetry, argRetry
/* 1449 */           .getDataSourceName());
/* 1450 */       StatusMgr.getInstance().notifyOffline(argRetry.getDataSourceName(), ee);
/*      */     } else {
/*      */       
/*      */       try {
/* 1454 */         retryCount++;
/* 1455 */         this.retryCountMap_.put(argRetry.getDataSourceName(), Integer.valueOf(retryCount));
/* 1456 */         Thread.sleep(RETRY_WAIT);
/*      */       }
/* 1458 */       catch (InterruptedException interruptedException) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handlePrimaryKeyViolation(TransactionToken argToken, PrimaryKeyViolationException argEx, Object argObjectToSave) {
/* 1467 */     rollbackTransaction(argToken);
/* 1468 */     logger_.error("Primary Key Violation while persisting object: " + argObjectToSave, (Throwable)argEx);
/* 1469 */     DaoUtils.logFailedPersistence((Throwable)argEx, argObjectToSave);
/* 1470 */     throw new PersistenceException(argEx);
/*      */   }
/*      */   
/*      */   private void logNoDatasourceWarning(IPersistenceMgrType argPmType, String argMsg) {
/* 1474 */     logger_.warn("** No Available Datasources were found for PM Type: " + argPmType + "** They are all offline or disabled. Check the PersistenceManagerConfig.xml and related. " + argMsg);
/*      */ 
/*      */ 
/*      */     
/* 1478 */     this._pmTypeHelper.logPmTypeStatus(argPmType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void replicateActionQuery(IPersistenceStrategy argStrategy, String argQueryKey, Map<String, Object> argParams) {
/* 1487 */     if (isReplicationEnabled()) {
/* 1488 */       IReplicationStrategy strategy = ReplicationStrategyHelper.getReplicationStategy();
/*      */       
/* 1490 */       if (strategy.isReplicationCandidate(argStrategy.getDataSourceName(), argQueryKey, null)) {
/*      */ 
/*      */ 
/*      */         
/* 1494 */         QueryRequest queryBundle = new QueryRequest();
/* 1495 */         queryBundle.setQueryKey(argQueryKey);
/* 1496 */         queryBundle.setParams(argParams);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1501 */         TransactionToken tempToken = new TransactionToken(argParams.hashCode());
/* 1502 */         strategy.replicateData(argStrategy.getDataSourceName(), tempToken, (IPersistable)queryBundle, null);
/* 1503 */         DataSourceTransactionManager.getInstance().commit(tempToken);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PersistenceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */