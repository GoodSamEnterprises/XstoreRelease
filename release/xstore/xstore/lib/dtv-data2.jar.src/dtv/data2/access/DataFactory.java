/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.config.query.QueryDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.query.IQueryHandler;
/*     */ import dtv.data2.access.query.QueryFactory;
/*     */ import dtv.data2.access.query.QueryResultWrapper;
/*     */ import dtv.data2.access.status.IStatusMgr;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.ReflectionException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class DataFactory
/*     */   extends AbstractDataFactory
/*     */ {
/*  36 */   private static final Logger _logger = Logger.getLogger(DataFactory.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceManagerFactory _persistenceFactory;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private QueryFactory _queryFactory;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */ 
/*     */   
/*     */   public static <T extends IDataModel> T createObject(Class<T> objectInterface) {
/*  56 */     return createObject(null, objectInterface);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends IDataModel> T createObject(IObjectId argId, Class<T> objectInterface) {
/*  83 */     return getInstance().createNewObject(argId, objectInterface);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends IDataModel> T createTransientObject(Class<T> objectInterface) {
/*  93 */     T model = createObject(null, objectInterface);
/*  94 */     makeTransient(model);
/*  95 */     return model;
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
/*     */   public static int executeQuery(IQueryKey<Object[]> argQueryKey, Map<String, Object> argQueryParams) {
/* 107 */     Object[] results = executeQueryImpl(argQueryKey.getName(), argQueryParams);
/*     */     
/* 109 */     if (results == null || results.length == 0) {
/* 110 */       _logger.warn("No side effects reported by query: " + argQueryKey, new Throwable("STACK TRACE"));
/* 111 */       return -1;
/*     */     } 
/* 113 */     return getResults(results);
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
/*     */   public static IDataFactory getInstance() {
/* 126 */     return DataFactoryAssistant.getDataFactory();
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
/*     */   public static <M extends IDataModel> M getObjectById(IObjectId argId) {
/* 158 */     return getObjectById(argId, null);
/*     */   }
/*     */   
/*     */   public static <M extends IDataModel> M getObjectById(IObjectId argId, IPersistenceMgrType argType) {
/*     */     IDataModel iDataModel;
/* 163 */     M result = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (argId == null) {
/* 169 */       throw new DtxException("Invalid argument passed to getObjectById.  getObjectById cannot accept a null object id");
/*     */     }
/*     */ 
/*     */     
/* 173 */     if (!argId.validate()) {
/*     */       
/* 175 */       String msg = "Invalid object id passed to getObjectById.  Object id type: [" + argId.getClass().getName() + "] value: [" + argId + "]";
/*     */       
/* 177 */       _logger.warn(msg, new Throwable("STACK TRACE"));
/* 178 */       throw new ObjectNotFoundException(msg);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     long start = _logger.isDebugEnabled() ? System.currentTimeMillis() : 0L;
/*     */     
/* 186 */     IPersistenceMgr persistenceMgr = null;
/*     */     try {
/* 188 */       persistenceMgr = getInstance().getPersistenceMgr();
/* 189 */       iDataModel = persistenceMgr.getObjectById(argId, argType);
/*     */     } finally {
/*     */       
/* 192 */       cleanupPersistenceManager(persistenceMgr);
/*     */       
/* 194 */       if (_logger.isDebugEnabled()) {
/* 195 */         long end = System.currentTimeMillis();
/* 196 */         _logger.debug("== getObjectById time: " + (end - start) + " For id: " + 
/* 197 */             ObjectUtils.getClassNameFromObject(argId) + "--" + argId + " result: " + iDataModel);
/*     */       } 
/*     */     } 
/* 200 */     return (M)iDataModel;
/*     */   }
/*     */   
/*     */   public static <M extends IDataModel> M getObjectByIdFromList(IObjectId argId, List<M> argList) {
/* 204 */     M result = null;
/*     */     
/* 206 */     return (M)argList.stream().filter(obj -> obj.getObjectId().equals(argId)).findFirst().orElse(null);
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
/*     */   public static <M extends IDataModel> M getObjectByIdNoThrow(IObjectId argId) {
/*     */     try {
/* 222 */       return getObjectById(argId);
/*     */     }
/* 224 */     catch (ObjectNotFoundException ex) {
/* 225 */       _logger.debug("CAUGHT EXCEPTION", (Throwable)ex);
/* 226 */       return null;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <M extends IDataModel> M getObjectByIdNoThrow(IObjectId argId, IPersistenceMgrType argType) {
/*     */     try {
/* 243 */       return getObjectById(argId, argType);
/*     */     }
/* 245 */     catch (ObjectNotFoundException ex) {
/* 246 */       _logger.debug("CAUGHT EXCEPTION", (Throwable)ex);
/* 247 */       return null;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> IQueryResultList<T> getObjectByQuery(IQueryKey<T> argQueryKey, Map<String, Object> argParams) {
/* 280 */     return getObjectByQuery(argQueryKey, argParams, null);
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
/*     */   public static <T> IQueryResultList<T> getObjectByQuery(IQueryKey<T> argQueryKey, Map<String, Object> argParams, IPersistenceMgrType argPmType) {
/* 297 */     return getObjectByQueryImpl(argQueryKey.getName(), argParams, argQueryKey.getResultClass(), argQueryKey
/* 298 */         .getInitializerClass(), argPmType);
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
/*     */   public static <T> IQueryResultList<T> getObjectByQueryNoThrow(IQueryKey<T> argQueryKey, Map<String, Object> argParams) {
/*     */     try {
/* 315 */       return getObjectByQuery(argQueryKey, argParams);
/*     */     }
/* 317 */     catch (ObjectNotFoundException ex) {
/* 318 */       _logger.debug("CAUGHT EXCEPTION", (Throwable)ex);
/* 319 */       return new QueryResultList<>(argQueryKey.getResultClass());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> IQueryResultList<T> getObjectByQueryNoThrow(IQueryKey<T> argQueryKey, Map<String, Object> argParams, IPersistenceMgrType argPmType) {
/*     */     try {
/* 339 */       return getObjectByQuery(argQueryKey, argParams, argPmType);
/*     */     }
/* 341 */     catch (ObjectNotFoundException ex) {
/* 342 */       _logger.debug("CAUGHT EXCEPTION", (Throwable)ex);
/* 343 */       return new QueryResultList<>(argQueryKey.getResultClass());
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
/*     */   public static <T> T makePersistent(T argObject) {
/* 383 */     return makePersistent(argObject, getInstance().getPersistenceMgr(), 0L);
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
/*     */   public static <T> T makePersistent(T argObject, IPersistenceMgr argPersistenceMgr) {
/* 396 */     return makePersistent(argObject, argPersistenceMgr, 0L);
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
/*     */   public static <T> T makePersistent(T argObject, IPersistenceMgr argPersistenceMgr, long argTimeout) {
/* 413 */     T result = null;
/* 414 */     long start = _logger.isDebugEnabled() ? System.currentTimeMillis() : 0L;
/*     */     
/*     */     try {
/* 417 */       result = argPersistenceMgr.makePersistent(argObject, argTimeout);
/*     */     } finally {
/*     */       
/* 420 */       if (argPersistenceMgr != null) {
/*     */         try {
/* 422 */           argPersistenceMgr.cleanup();
/*     */         }
/* 424 */         catch (Exception ee) {
/* 425 */           _logger.debug("Exception occurred while cleaning up persistence mananger " + argPersistenceMgr, ee);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 430 */       if (_logger.isDebugEnabled()) {
/* 431 */         long end = System.currentTimeMillis();
/* 432 */         _logger.debug("== makePersistent time: " + (end - start) + " result: " + result);
/*     */       } 
/*     */     } 
/* 435 */     return result;
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
/*     */   public static <T> T makePersistent(T argObject, long argTimeout) {
/* 450 */     return makePersistent(argObject, getInstance().getPersistenceMgr(), argTimeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void makeTransient(Object argObject) {
/* 460 */     List<? extends IPersistable> persistables = DaoUtils.getPersistables(argObject);
/*     */     
/* 462 */     for (Iterator<? extends IPersistable> iter = persistables.iterator(); iter.hasNext(); ) {
/* 463 */       IPersistable persistable = iter.next();
/* 464 */       if (persistable instanceof IDataAccessObject) {
/* 465 */         ((IDataAccessObject)persistable).setTransientObject(true);
/*     */       }
/*     */       
/* 468 */       iter.remove();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void replicateData(TransactionToken argTransToken, String argCurrentDataSourceName, IPersistable argPersistable, List<String> argExcludedDataSources) {
/* 485 */     getInstance().getPersistenceMgr().replicateData(argTransToken, argCurrentDataSourceName, argPersistable, argExcludedDataSources);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void cleanupPersistenceManager(IPersistenceMgr argPersistenceMgr) {
/* 490 */     if (argPersistenceMgr != null) {
/*     */       try {
/* 492 */         argPersistenceMgr.cleanup();
/*     */       }
/* 494 */       catch (Exception ee) {
/* 495 */         _logger.debug("Exception occurred while cleaning up persistence mananger " + argPersistenceMgr, ee);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object[] executeQueryImpl(String argQueryKey, Map<String, Object> argParams) {
/* 503 */     long start = _logger.isDebugEnabled() ? System.currentTimeMillis() : 0L;
/*     */     
/* 505 */     IPersistenceMgr persistenceMgr = null;
/* 506 */     Object[] results = null;
/*     */     try {
/* 508 */       persistenceMgr = getInstance().getPersistenceMgr();
/* 509 */       Object tempResults = persistenceMgr.getObjectByQuery(argQueryKey, argParams, null);
/*     */       
/* 511 */       if (tempResults instanceof QueryResultWrapper) {
/* 512 */         results = (Object[])((QueryResultWrapper)tempResults).getData();
/*     */       }
/* 514 */       else if (tempResults instanceof Collection) {
/* 515 */         results = ((Collection)tempResults).toArray();
/*     */       } else {
/*     */         
/* 518 */         results = (Object[])tempResults;
/*     */       } 
/*     */     } finally {
/*     */       
/* 522 */       if (persistenceMgr != null) {
/*     */         try {
/* 524 */           persistenceMgr.cleanup();
/*     */         }
/* 526 */         catch (Exception ex) {
/* 527 */           _logger.debug("Exception occurred while cleaning up persistence manager " + persistenceMgr, ex);
/*     */         } 
/*     */       }
/*     */       
/* 531 */       if (_logger.isDebugEnabled()) {
/* 532 */         long end = System.currentTimeMillis();
/* 533 */         _logger.debug("== getObjectByQuery time: " + (end - start) + " For key: " + argQueryKey);
/*     */       } 
/*     */     } 
/* 536 */     return results;
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
/*     */   private static <T> IQueryResultList<T> getObjectByQueryImpl(String argQueryKey, Map<String, Object> argParams, Class<T> argTemplate, Class<? extends IQueryResultInitializer<? extends IQueryResult>> argInitializer, IPersistenceMgrType argPmType) {
/* 556 */     IQueryResultList<T> list = null;
/* 557 */     Map<String, Object> params = (argParams == null) ? new HashMap<>() : argParams;
/*     */     
/* 559 */     long start = _logger.isDebugEnabled() ? System.currentTimeMillis() : 0L;
/*     */     
/* 561 */     IPersistenceMgr persistenceMgr = null;
/*     */     try {
/* 563 */       persistenceMgr = getInstance().getPersistenceMgr();
/* 564 */       Object result = persistenceMgr.getObjectByQuery(argQueryKey, params, argPmType);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 569 */       list = QueryResultList.makeList(result, argTemplate);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 575 */       initializeResults(list, argInitializer);
/*     */     } finally {
/*     */       
/* 578 */       if (persistenceMgr != null) {
/*     */         try {
/* 580 */           persistenceMgr.cleanup();
/*     */         }
/* 582 */         catch (Exception ee) {
/* 583 */           _logger.debug("Exception occurred while cleaning up persistence mananger " + persistenceMgr, ee);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 588 */       if (_logger.isDebugEnabled()) {
/* 589 */         long end = System.currentTimeMillis();
/* 590 */         String resultString = (list != null) ? (list.get(0).toString() + ". . .") : null;
/*     */         
/* 592 */         _logger.debug("== getObjectByQuery time: " + (end - start) + " For key: " + argQueryKey + " Result: " + resultString);
/*     */       } 
/*     */     } 
/*     */     
/* 596 */     return list;
/*     */   }
/*     */   
/*     */   private static int getResults(Object[] argResults) {
/* 600 */     if (argResults == null || argResults.length < 1) {
/* 601 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 610 */     if (argResults[0] instanceof Object[]) {
/* 611 */       Object[] affectedRowsArray = (Object[])argResults[0];
/* 612 */       int affectedRows = ((Number)affectedRowsArray[0]).intValue();
/* 613 */       return affectedRows;
/*     */     } 
/*     */     
/* 616 */     if (!(argResults[0] instanceof Number)) {
/* 617 */       _logger.warn("unexpected result '" + argResults[0] + "' of type " + 
/* 618 */           ObjectUtils.getClassNameFromObject(argResults[0]));
/* 619 */       return -1;
/*     */     } 
/* 621 */     return ((Number)argResults[0]).intValue();
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
/*     */   private static void initializeResults(IQueryResultList result, Class<? extends IQueryResultInitializer<? extends IQueryResult>> argInitializerClass) {
/*     */     IQueryResultInitializer<IQueryResult> initializer;
/* 634 */     if (argInitializerClass == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 641 */       initializer = (IQueryResultInitializer<IQueryResult>)argInitializerClass.newInstance();
/*     */     }
/* 643 */     catch (Throwable ex) {
/* 644 */       throw new ReflectionException("Could not instantiate initializer " + argInitializerClass, ex);
/*     */     } 
/* 646 */     for (Object row : result) {
/* 647 */       initializer.initialize((IQueryResult)row);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataFactory() {
/* 668 */     initialize();
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
/*     */   public <T extends IDataModel> T createNewObject(IObjectId argObjectId, Class<T> argInterface) {
/* 680 */     if (argInterface == null) {
/* 681 */       throw new CreateObjectException("Cannot create model object from null argInterface");
/*     */     }
/* 683 */     T model = DataModelFactory.getModelForInterface(argInterface);
/*     */     
/* 685 */     ((IDataModelImpl)model).setDependencies(this._persistenceDefaults, this._eventManager);
/* 686 */     ((IDataModelImpl)model).getDAO().setObjectState(DaoState.NEW.intVal());
/* 687 */     if (argObjectId != null) {
/* 688 */       model.setObjectId(argObjectId);
/*     */     }
/*     */     
/* 691 */     return model;
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
/*     */   public IPersistenceMgr getPersistenceMgr() {
/* 703 */     return this._persistenceFactory.getManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryDescriptor getQueryDescriptor(String argKey) {
/* 714 */     return this._queryFactory.getQueryDescriptor(argKey);
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
/*     */   public IQueryHandler getQueryHandler(String argKey) {
/* 727 */     return this._queryFactory.getQueryHandler(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IStatusMgr getStatusMgr() {
/* 737 */     return (IStatusMgr)StatusMgr.getInstance();
/*     */   }
/*     */   
/*     */   public void reinitialize() {
/* 741 */     initialize();
/* 742 */     DataSourceFactory.getInstance().reinitialize();
/* 743 */     this._queryFactory.reinitialize();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initialize() {
/* 748 */     DataSourceFactory.getInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CreateObjectException
/*     */     extends RuntimeException
/*     */   {
/*     */     static final long serialVersionUID = -1517193094408594040L;
/*     */ 
/*     */ 
/*     */     
/*     */     public CreateObjectException(String msg) {
/* 762 */       super(msg);
/*     */     }
/*     */     
/*     */     public CreateObjectException(String msg, Throwable cause) {
/* 766 */       super(msg, cause);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */