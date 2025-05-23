/*     */ package dtv.data2.access.impl.jdbc;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.exception.PrimaryKeyViolationException;
/*     */ import dtv.data2.access.exception.RetryException;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.IRelationshipAdapter;
/*     */ import dtv.data2.access.query.IQueryHandler;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.event.EventManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class JDBCPersistenceStrategy extends AbstractJDBCPersistenceStrategy {
/*  35 */   private static final Logger _logger = Logger.getLogger(JDBCPersistenceStrategy.class);
/*  36 */   private static final boolean _debugLogging = _logger.isDebugEnabled();
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   @Inject
/*     */   private ISqlQueryDecorator _queryDecorator;
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */ 
/*     */   
/*     */   public boolean checkExistence(IObjectId argId, QueryToken argQueryToken) {
/*  50 */     Object result = getObjectById(argId, argQueryToken);
/*  51 */     return (result != null);
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
/*     */   public List<IDataModel> getModelsByQuery(String argSql, List<?> argParams, Class<?> argTemplate, int argMaxRecords, QueryToken argQueryToken) {
/*  68 */     DBConnection conn = JDBCDataSourceMgr.getInstance().getQueryConnection(getDataSourceName(), argQueryToken);
/*  69 */     try (PreparedStatement statement = conn.prepareStatement(argSql)) {
/*  70 */       statement.setMaxRows(argMaxRecords);
/*     */       
/*  72 */       if (argParams != null && !argParams.isEmpty()) {
/*  73 */         for (int i = 0; i < argParams.size(); i++) {
/*  74 */           Object parm = argParams.get(i);
/*     */           
/*  76 */           if (parm == null) {
/*  77 */             throw new DtxException("Null parameter detected for query.  We do not support null parameters for queries. Params given: " + argParams);
/*     */           }
/*     */           
/*  80 */           if (parm instanceof Timestamp) {
/*  81 */             statement.setTimestamp(i + 1, (Timestamp)parm);
/*     */           } else {
/*     */             
/*  84 */             statement.setObject(i + 1, parm);
/*     */           } 
/*     */         } 
/*     */       }
/*  88 */       statement.execute();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  94 */     catch (Exception ex) {
/*     */       try {
/*  96 */         conn.setInvalid();
/*     */       }
/*  98 */       catch (Throwable ex1) {
/*  99 */         _logger.warn("CAUGHT EXCEPTION while marking connection invalid", ex1);
/*     */       } 
/*     */       
/* 102 */       if (FailoverException.isFailover(ex)) {
/* 103 */         throw FailoverException.getNewException(ex, getDataSourceName());
/*     */       }
/*     */ 
/*     */       
/* 107 */       String msg = "getModelsByQuery() exception CAUGHT on datasource " + getDataSourceName() + " Class template: " + argTemplate + " executing sql: " + argSql + " params: " + argParams;
/*     */ 
/*     */       
/* 110 */       if (ex instanceof SQLException) {
/* 111 */         SQLException sqlEx = SQLExceptionScrubber.scrub((SQLException)ex);
/* 112 */         JDBCHelper.logSqlException(msg, sqlEx);
/* 113 */         throw new JDBCException(sqlEx);
/*     */       } 
/*     */       
/* 116 */       _logger.error(msg, ex);
/*     */       
/* 118 */       if (ex instanceof DtxException) {
/* 119 */         throw (DtxException)ex;
/*     */       }
/*     */       
/* 122 */       throw new DtxException(msg, ex);
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
/*     */   public List<IDataModel> getModelsByQuery(String argSql, List<?> argParams, Class<?> argTemplate, QueryToken argQueryToken) {
/* 142 */     return getModelsByQuery(argSql, argParams, argTemplate, 0, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, QueryToken argQueryToken) {
/* 148 */     IJDBCTableAdapter adapter = getTableAdapter(argId);
/*     */ 
/*     */     
/* 151 */     String sqlToDecorate = adapter.getSelect() + adapter.getSelectWhere();
/* 152 */     String stmt = this._queryDecorator.decorateSql(sqlToDecorate, (IPersistenceStrategy)this, argId);
/*     */     
/* 154 */     if (_debugLogging) {
/* 155 */       _logger.debug("Getting object by id with the following statement: " + stmt + " ((" + argId.toString() + "))");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     DBConnection conn = JDBCDataSourceMgr.getInstance().getQueryConnection(getDataSourceName(), argQueryToken); try {
/* 162 */       List<IDataModel> list; PreparedStatement statement = adapter.writeObjectId(argId, conn.prepareStatement(stmt)); Throwable throwable = null; 
/* 163 */       try { List<IDataModel> models; statement.execute();
/*     */         
/* 165 */         try (ResultSet resultSet = statement.getResultSet()) {
/* 166 */           models = getModelsByResultSet(resultSet, conn, argId.getClass(), stmt);
/*     */         } 
/* 168 */         return (models == null || models.isEmpty()) ? null : models.get(0); } catch (Throwable models) { list = models = null; throw models; }
/* 169 */       finally { if (statement != null) if (list != null) { try { statement.close(); } catch (Throwable throwable1) { list.addSuppressed(throwable1); }  } else { statement.close(); }
/*     */             }
/*     */     
/* 172 */     } catch (Exception ex) {
/* 173 */       if (FailoverException.isFailover(ex)) {
/* 174 */         throw FailoverException.getNewException(ex, getDataSourceName());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 179 */       String msg = "getObjectById() exception CAUGHT on datasource " + getDataSourceName() + " while looking up id type: " + argId.getClass().getName() + " value: " + argId;
/*     */       
/* 181 */       if (ex instanceof SQLException) {
/* 182 */         SQLException sqlEx = SQLExceptionScrubber.scrub((SQLException)ex);
/* 183 */         JDBCHelper.logSqlException(msg, sqlEx);
/* 184 */         throw new JDBCException(sqlEx);
/*     */       } 
/*     */       
/* 187 */       _logger.error(msg, ex);
/* 188 */       throw new DtxException(msg, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByQuery(String argQueryKey, Map<String, Object> argParams, QueryToken argQueryToken) {
/* 198 */     IQueryHandler handler = DataFactory.getInstance().getQueryHandler(argQueryKey);
/*     */     try {
/* 200 */       return handler.execute((IPersistenceStrategy)this, argParams, argQueryToken);
/*     */     }
/* 202 */     catch (Exception ex) {
/* 203 */       if (FailoverException.isFailover(ex)) {
/* 204 */         throw FailoverException.getNewException(ex, getDataSourceName());
/*     */       }
/*     */ 
/*     */       
/* 208 */       String msg = "getObjectByQuery() exception CAUGHT on datasource " + getDataSourceName() + " while executing query key: " + argQueryKey + " with params: (" + argParams + ")";
/*     */ 
/*     */       
/* 211 */       if (ex instanceof SQLException) {
/* 212 */         SQLException sqlEx = SQLExceptionScrubber.scrub((SQLException)ex);
/* 213 */         JDBCHelper.logSqlException(msg, sqlEx);
/* 214 */         throw new JDBCException(msg, sqlEx);
/*     */       } 
/*     */       
/* 217 */       _logger.error(msg, ex);
/*     */       
/* 219 */       if (ex instanceof DtxException) {
/* 220 */         throw (DtxException)ex;
/*     */       }
/*     */       
/* 223 */       throw new DtxException(msg, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByRelationship(IDataModelRelationship argRelationship, QueryToken argQueryToken) {
/* 233 */     IDataModelImpl parent = (IDataModelImpl)argRelationship.getParent();
/*     */ 
/*     */ 
/*     */     
/* 237 */     IRelationshipAdapter adapter = AdapterMap.getRelationshipAdapter(parent.getDAO().getClass(), argRelationship.getIdentifier());
/* 238 */     IJDBCRelationshipAdapter jdbcAdapter = null;
/*     */     
/* 240 */     if (adapter == null) {
/* 241 */       throw new DtxException("Could not load relationship: " + argRelationship.getIdentifier() + " for DAO: " + parent
/* 242 */           .getDAO().getClass() + " check associated .dtx's.");
/*     */     }
/* 244 */     if (!(adapter instanceof IJDBCRelationshipAdapter)) {
/* 245 */       throw new DtxException("The AdapterMap produced an adapter that was NOT compatiable with with JDBC for relationship: [" + argRelationship
/* 246 */           .getIdentifier() + "] and DAO: [" + parent
/* 247 */           .getDAO().getClass() + "] Adapter: [" + adapter + "]");
/*     */     }
/*     */     
/* 250 */     jdbcAdapter = (IJDBCRelationshipAdapter)adapter;
/*     */ 
/*     */     
/* 253 */     jdbcAdapter.setParent(parent.getDAO());
/*     */ 
/*     */     
/* 256 */     List<?> parms = jdbcAdapter.getParameterList();
/* 257 */     Iterator<?> it = parms.iterator();
/* 258 */     while (it.hasNext()) {
/* 259 */       if (it.next() == null) {
/* 260 */         return null;
/*     */       }
/*     */     } 
/*     */     
/* 264 */     String callString = jdbcAdapter.getSelect();
/*     */     
/* 266 */     if (jdbcAdapter.isOrgHierarchyJoinRequired())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 273 */       callString = this._queryDecorator.decorateSql(jdbcAdapter.getSelect(), (IPersistenceStrategy)this, (IObjectId)null);
/*     */     }
/*     */     
/* 276 */     List<IDataModel> models = getModelsByQuery(callString, parms, argRelationship.getChild(), argQueryToken);
/*     */     
/* 278 */     if (models != null && IDataModelRelationship.RelationshipType.ONE_TO_ONE
/* 279 */       .equals(argRelationship.getType())) {
/* 280 */       return models.get(0);
/*     */     }
/*     */     
/* 283 */     return models;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphPersisted() {
/* 290 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphProvided() {
/* 296 */     return false;
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
/*     */   protected void detectUpdateNotEffective(PreparedStatement argStatement, String argSql, List<Object> argParams, IPersistable argPersistable) throws SQLException {
/* 313 */     if (argPersistable instanceof IDataAccessObject) {
/* 314 */       IDataAccessObject argDAO = (IDataAccessObject)argPersistable;
/*     */       
/* 316 */       if ((DaoState.isUpdated(argDAO) || DaoState.INSERT_OR_UPDATE.matches(argDAO)) && argStatement.getUpdateCount() == 0) {
/* 317 */         throw new UpdateNotEffectiveException("Update count was zero while persisting dao: [" + argDAO
/* 318 */             .getClass().getName() + "] id: " + argDAO.getObjectId() + " sql statement: " + 
/* 319 */             PreparedStatementTranslator.getPrettySql(argSql, argParams), getDataSourceName());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IDataModel> getModelsByResultSet(ResultSet argResultSet, DBConnection argConn, Class<?> argTemplate, String argSqlQuery) throws SQLException {
/* 339 */     if (argResultSet == null) {
/* 340 */       throw new DtxException("The result set was unexpectedly NULL for a successful query - this is unexpected jdbc behavior. Class template: [" + argTemplate
/*     */           
/* 342 */           .getName() + "] sql executed: " + argSqlQuery);
/*     */     }
/*     */     
/* 345 */     List<IDataModel> results = new ArrayList<>();
/* 346 */     while (argResultSet.next()) {
/* 347 */       IJDBCTableAdapter adapter = getTableAdapter(argTemplate);
/* 348 */       adapter.getFiller().fill(argResultSet);
/* 349 */       results.add(loadHierarchy(adapter, argConn));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 354 */     if (_debugLogging) {
/* 355 */       boolean warnings = JDBCHelper.handleWarnings(argSqlQuery, argResultSet.getWarnings());
/* 356 */       if (warnings) {
/* 357 */         argResultSet.clearWarnings();
/*     */       }
/*     */     } 
/* 360 */     return results.isEmpty() ? null : results;
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
/*     */   protected IPersistable handlePersistenceException(Exception argException, IPersistable argPersistable, String argCurrentSql, List<Object> argCurrentParams) {
/*     */     String msg;
/* 381 */     if (RetryException.isRetryException(argException)) {
/* 382 */       if (_debugLogging) {
/* 383 */         _logger.debug("handlePersistenceException determined this to be a retry exception, throwing a retry. Original exception: " + argException);
/*     */       }
/*     */ 
/*     */       
/* 387 */       throw RetryException.getNewException(argException, getDataSourceName());
/*     */     } 
/*     */ 
/*     */     
/* 391 */     if (FailoverException.isFailover(argException)) {
/* 392 */       if (_debugLogging) {
/* 393 */         _logger.debug("handlePersistenceException determined this to be a failover exception, throwing a failover. Original exception: " + argException);
/*     */       }
/*     */ 
/*     */       
/* 397 */       throw FailoverException.getNewException(argException, getDataSourceName());
/*     */     } 
/*     */ 
/*     */     
/* 401 */     if (argException instanceof UpdateNotEffectiveException)
/*     */     {
/* 403 */       return (IPersistable)handleUpdateNotEffectiveException(argPersistable, argException);
/*     */     }
/*     */ 
/*     */     
/* 407 */     if (PrimaryKeyViolationException.isPrimaryKeyViolation(argException)) {
/*     */       
/* 409 */       if (argPersistable instanceof IDataAccessObject) {
/* 410 */         IDataAccessObject dao = (IDataAccessObject)argPersistable;
/*     */ 
/*     */         
/* 413 */         if (DaoState.INSERT_ONLY.matches(dao)) {
/* 414 */           if (_debugLogging) {
/* 415 */             _logger.debug("A PK violation was detected when processing INSERT_ONLY DAO " + argPersistable
/* 416 */                 .toString() + ". This record already exists and will not be persisted.");
/*     */           }
/*     */           
/* 419 */           IDataAccessObject daoClone = DaoUtils.cloneDao(dao);
/* 420 */           daoClone.setPersistenceDefaults(this._persistenceDefaults);
/* 421 */           daoClone.setObjectState(DaoState.CLEAN.intVal());
/* 422 */           daoClone.setObjectStateRulesApplied(true);
/* 423 */           return (IPersistable)daoClone;
/*     */         } 
/*     */ 
/*     */         
/* 427 */         if (DaoConversionHelper.isDaoConvertOnPkViolation(dao) && DaoState.isNew((IDataAccessObject)argPersistable)) {
/* 428 */           _logger.warn("Primary key error attempting to insert DAO, updating instead: key=[" + dao
/* 429 */               .getObjectId() + "]");
/*     */ 
/*     */           
/* 432 */           IDataAccessObject daoClone = DaoUtils.cloneDao(dao);
/* 433 */           daoClone.setPersistenceDefaults(this._persistenceDefaults);
/* 434 */           daoClone.setObjectState(DaoState.UPDATED.intVal());
/* 435 */           daoClone.setObjectStateRulesApplied(true);
/* 436 */           return (IPersistable)daoClone;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 442 */       PrimaryKeyViolationException ex = PrimaryKeyViolationException.getNewException(argException, getDataSourceName());
/* 443 */       ex.setOffendingDao((IDataAccessObject)argPersistable);
/* 444 */       throw ex;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 450 */     if (argPersistable instanceof IDataAccessObject) {
/* 451 */       IDataAccessObject dao = (IDataAccessObject)argPersistable;
/*     */ 
/*     */ 
/*     */       
/* 455 */       msg = "makePersistent() exception caught trying to persist dao of type [" + dao.getClass().getName() + "] with id: " + dao.getObjectId().getClass().getName() + " id value: " + dao.getObjectId() + " on datasource: " + getDataSourceName() + ". Statement: " + argCurrentSql + " Params: " + argCurrentParams;
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 461 */       msg = "makePersistent() exception caught trying to persist persistable of type [" + argPersistable.getClass().getName() + "] on datasource: " + getDataSourceName() + ". Statement: " + argCurrentSql + " Params: " + argCurrentParams;
/*     */     } 
/*     */ 
/*     */     
/* 465 */     if (argException instanceof SQLException) {
/* 466 */       SQLException sqlEx = SQLExceptionScrubber.scrub((SQLException)argException);
/* 467 */       JDBCHelper.logSqlException(msg, sqlEx);
/* 468 */       throw new JDBCException(msg, sqlEx);
/*     */     } 
/*     */     
/* 471 */     _logger.error(msg, argException);
/* 472 */     throw new DtxException(msg, argException);
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
/*     */   protected IDataAccessObject handleUpdateNotEffectiveException(IPersistable argPersistable, Exception argException) {
/* 486 */     if (argPersistable instanceof IDataAccessObject && DaoState.INSERT_OR_UPDATE
/* 487 */       .matches((IDataAccessObject)argPersistable) && 
/* 488 */       !((IDataAccessObject)argPersistable).isObjectStateRulesApplied()) {
/*     */       
/* 490 */       IDataAccessObject daoClone = DaoUtils.cloneDao((IDataAccessObject)argPersistable);
/* 491 */       daoClone.setPersistenceDefaults(this._persistenceDefaults);
/* 492 */       daoClone.setObjectStateRulesApplied(true);
/* 493 */       return daoClone;
/*     */     } 
/*     */     
/* 496 */     _logger.warn("An update was run against datasource: [" + getDataSourceName() + "] that had no effect: " + argException);
/*     */ 
/*     */     
/* 499 */     return null;
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
/*     */   protected IDataModel loadHierarchy(IJDBCTableAdapter argDBAAdapter, DBConnection argConn) throws SQLException {
/* 519 */     IJDBCTableAdapter dbaAdapter = argDBAAdapter;
/* 520 */     IObjectId objectId = dbaAdapter.getObjectId();
/*     */ 
/*     */     
/* 523 */     if (dbaAdapter.isExtensible()) {
/* 524 */       String classNameRoot = dbaAdapter.getImplementingClass();
/* 525 */       String className = classNameRoot + "DBA";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 532 */       if (!className.equals(dbaAdapter.getClass().getName())) {
/* 533 */         IJDBCTableAdapter originalAdapter = dbaAdapter;
/*     */         
/* 535 */         if (_debugLogging) {
/* 536 */           _logger.debug("Getting DBA implementation of " + dbaAdapter.getImplementingClass() + " from " + dbaAdapter
/* 537 */               .getClass().getName());
/*     */         }
/*     */         
/*     */         try {
/* 541 */           dbaAdapter = (IExtendedJDBCAdapter)Class.forName(className).newInstance();
/*     */         }
/* 543 */         catch (Exception ee) {
/* 544 */           handleBadDtxClassName(dbaAdapter, classNameRoot, className, ee);
/*     */         } 
/*     */         
/* 547 */         IExtendedJDBCAdapter subclass = (IExtendedJDBCAdapter)dbaAdapter;
/*     */ 
/*     */         
/*     */         try {
/* 551 */           subclass.fill(originalAdapter);
/*     */         }
/* 553 */         catch (ClassCastException ee) {
/* 554 */           throw new DtxException("A failure occurred while calling fill on [" + subclass.getClass().getName() + "] with [" + dbaAdapter
/* 555 */               .getClass().getName() + "]  check dtv_class_name field - it's probably invalid.", ee);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 561 */     if (dbaAdapter instanceof IExtendedJDBCAdapter) {
/* 562 */       IExtendedJDBCAdapter subclass = (IExtendedJDBCAdapter)dbaAdapter;
/*     */       
/* 564 */       String[] selects = subclass.getAllSelects();
/* 565 */       IFiller[] fillers = subclass.getAllFillers();
/*     */       
/* 567 */       for (int i = 0; i < selects.length; i++) {
/* 568 */         String sql = selects[i] + dbaAdapter.getSelectWhere();
/* 569 */         sql = this._queryDecorator.decorateSql(sql, (IPersistenceStrategy)this, objectId);
/*     */         
/* 571 */         try (PreparedStatement statement = subclass.writeObjectId(objectId, argConn.prepareStatement(sql))) {
/* 572 */           statement.execute();
/* 573 */           try (ResultSet resultSet = statement.getResultSet()) {
/*     */             
/* 575 */             if (resultSet.next()) {
/* 576 */               fillers[i].fill(resultSet);
/*     */             } else {
/*     */               
/* 579 */               _logger.warn("Unable to load a level in the hierarchy. This object will likely be incompletely loaded. SQL failed: " + sql + " object ID type: " + objectId
/*     */                   
/* 581 */                   .getDtxTypeName() + " object ID value: " + objectId);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 589 */     if (dbaAdapter == null) {
/* 590 */       return null;
/*     */     }
/* 592 */     IDataAccessObject dao = dbaAdapter.loadDefaultDAO();
/* 593 */     IDataModelImpl model = DataModelFactory.getModelForDAO(dao);
/*     */     
/* 595 */     dao.setOriginDataSource(getDataSourceName());
/* 596 */     model.setDAO(dao);
/* 597 */     model.setDependencies(this._persistenceDefaults, this._eventManager);
/* 598 */     return (IDataModel)model;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void makePersistentImpl(TransactionToken argTransToken, IPersistable argPersistable) {
/* 604 */     List<JDBCCall> jdbcCalls = getJDBCCallData(argPersistable);
/*     */     
/* 606 */     if (jdbcCalls == null) {
/*     */       return;
/*     */     }
/*     */     
/* 610 */     JDBCCall currentCall = null;
/*     */     
/* 612 */     DBConnection conn = JDBCDataSourceMgr.getInstance().getConnection(argTransToken, getDataSourceName());
/* 613 */     Savepoint segmentRollbackSavepoint = null;
/*     */ 
/*     */     
/*     */     try {
/* 617 */       if (jdbcCalls.size() > 1) {
/* 618 */         segmentRollbackSavepoint = conn.setSavepoint();
/*     */       }
/*     */ 
/*     */       
/* 622 */       for (JDBCCall jdbcCall : jdbcCalls) {
/* 623 */         currentCall = jdbcCall;
/* 624 */         try (PreparedStatement statement = conn.prepareStatement(jdbcCall.getSqlString())) {
/* 625 */           JDBCHelper.assignParameters(statement, jdbcCall.getParams(), jdbcCall.getTypes());
/* 626 */           statement.execute();
/*     */ 
/*     */           
/* 629 */           detectUpdateNotEffective(statement, jdbcCall.getSqlString(), jdbcCall.getParams(), argPersistable);
/*     */ 
/*     */ 
/*     */           
/* 633 */           if (_debugLogging) {
/* 634 */             boolean warnings = JDBCHelper.handleWarnings(jdbcCall.getSqlString(), statement.getWarnings());
/* 635 */             if (warnings) {
/* 636 */               statement.clearWarnings();
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } 
/* 643 */     } catch (Exception ex) {
/* 644 */       String sql = (currentCall != null) ? currentCall.getSqlString() : null;
/* 645 */       List<Object> params = (currentCall != null) ? currentCall.getParams() : null;
/* 646 */       IPersistable result = handlePersistenceException(ex, argPersistable, sql, params);
/*     */       
/* 648 */       if (result == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 656 */         if (segmentRollbackSavepoint != null) {
/* 657 */           conn.rollback(segmentRollbackSavepoint);
/*     */         }
/*     */       }
/* 660 */       catch (SQLException e) {
/* 661 */         _logger.warn("An error occurred while rolling back to a savepoint.", e);
/*     */       } 
/*     */ 
/*     */       
/* 665 */       makePersistent(argTransToken, result);
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
/*     */   private void handleBadDtxClassName(IJDBCTableAdapter argAdapter, String argClassNameRoot, String argClassName, Exception argEx) {
/* 683 */     if (StringUtils.isEmpty(argClassNameRoot)) {
/* 684 */       throw new DtxException("Class name field is not set for a row on table: \"" + argAdapter.getTableName() + "\" (or parent table) - see \"dtv_class_name\" field, probably");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 693 */     throw new DtxException("Failed to instantiate: " + argClassName + ".  There may be a problem with the class name field on table: " + argAdapter
/* 694 */         .getTableName(), argEx);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */