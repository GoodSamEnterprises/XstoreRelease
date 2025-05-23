/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.exception.PrimaryKeyViolationException;
/*     */ import dtv.data2.access.exception.RetryException;
/*     */ import dtv.data2.access.impl.jdbc.JDBCException;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.service.ServiceUnavailableException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConcurrentWritePersistenceStrategy
/*     */   extends AbstractPersistenceStrategy
/*     */ {
/*  39 */   private static final Logger _logger = Logger.getLogger(ConcurrentWritePersistenceStrategy.class);
/*  40 */   private static final boolean _debugLogging = _logger.isDebugEnabled();
/*     */   
/*     */   private static final String DATA_SOURCE_SEPARATOR = "|";
/*  43 */   private final List<IPersistenceStrategy> _impersonatedStrategies = new ArrayList<>();
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */ 
/*     */   
/*     */   public boolean checkExistence(IObjectId argId, QueryToken argQueryToken) {
/*  54 */     throw new UnsupportedOperationException("getObjectById() is not supported by this persistence strategy.  Only persistence via makePersistent() is supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, QueryToken argQueryToken) {
/*  61 */     throw new UnsupportedOperationException("getObjectById() is not supported by this persistence strategy.  Only persistence via makePersistent() is supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByQuery(String argKey, Map<String, Object> argParams, QueryToken argQueryToken) {
/*  68 */     throw new UnsupportedOperationException("getObjectByQuery() is not supported by this persistence strategy.  Only persistence via makePersistent() is supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByRelationship(IDataModelRelationship argRel, QueryToken argQueryToken) {
/*  75 */     throw new UnsupportedOperationException("getObjectByRelationship() is not supported by this persistence strategy.  Only persistence via makePersistent() is supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphPersisted() {
/*  82 */     boolean anyFullGraph = false;
/*  83 */     for (IPersistenceStrategy delegate : this._impersonatedStrategies) {
/*  84 */       if (delegate.isFullGraphPersisted()) {
/*  85 */         anyFullGraph = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*  89 */     return anyFullGraph;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphProvided() {
/*  95 */     throw new UnsupportedOperationException("isFullGraphProvided() is not supported by this persistence strategy.  Only persistence via makePersistent() is supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/* 104 */     this._impersonatedStrategies.clear();
/* 105 */     List<DataSourceDescriptor> enabledDataSources = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     List<String> propKeys = new ArrayList<>(argProps.stringPropertyNames());
/* 111 */     Collections.sort(propKeys);
/*     */     
/* 113 */     for (String propKey : propKeys) {
/* 114 */       String dataSourceName = argProps.getProperty(propKey);
/*     */       
/* 116 */       DataSourceDescriptor descriptor = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSourceName.toString());
/*     */       
/* 118 */       if (descriptor.isEnabled()) {
/* 119 */         enabledDataSources.add(descriptor);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     for (int i = 0; i < enabledDataSources.size(); i++) {
/*     */       
/* 129 */       IPersistenceStrategy strategyToAdd = this._persistenceStrategyFactory.createStrategy(enabledDataSources.get(i), isOnlineStrategyType());
/*     */       
/* 131 */       boolean duplicate = false;
/*     */       
/* 133 */       for (int j = i + 1; j < enabledDataSources.size(); j++) {
/*     */         
/* 135 */         IPersistenceStrategy strategyToCompare = this._persistenceStrategyFactory.createStrategy(enabledDataSources.get(j), isOnlineStrategyType());
/*     */         
/* 137 */         if (strategyToAdd.equivalentDataSources(strategyToCompare)) {
/* 138 */           duplicate = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 143 */       if (!duplicate) {
/* 144 */         this._impersonatedStrategies.add(strategyToAdd);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IPersistable getDataToPersist(IPersistable argOriginal, IPersistenceStrategy argStrategy) {
/*     */     IDataAccessObject iDataAccessObject;
/* 174 */     IPersistable dataToPersist = argOriginal;
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (!argStrategy.isFullGraphPersisted() && 
/* 179 */       argOriginal instanceof IDataAccessObject) {
/* 180 */       IDataAccessObject dao = (IDataAccessObject)argOriginal;
/*     */       
/* 182 */       if (DaoState.INSERT_OR_UPDATE.matches(dao))
/*     */       {
/* 184 */         if (argStrategy.getDataSourceName().equalsIgnoreCase(dao.getOriginDataSource())) {
/*     */ 
/*     */ 
/*     */           
/* 188 */           int newObjectState = dao.getObjectState() & 0xFFEFFFFF;
/* 189 */           if (newObjectState == 0) {
/* 190 */             newObjectState = 1;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 196 */           dao = DaoUtils.cloneDao(dao);
/* 197 */           dao.setPersistenceDefaults(this._persistenceDefaults);
/* 198 */           dao.setObjectState(newObjectState);
/* 199 */           iDataAccessObject = dao;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 205 */     return (IPersistable)iDataAccessObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getPersistenceFailedMessage(String argDataSourceName, IPersistable argPersistable) {
/* 215 */     return "Concurrent persistence failed on data source [" + argDataSourceName + "] for persistable [" + argPersistable + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void makePersistentImpl(TransactionToken argTransToken, IPersistable argPersistable) {
/*     */     DtxException dtxException;
/* 222 */     List<String> successfulWriteDSs = new ArrayList<>();
/* 223 */     RuntimeException lastNonOffline = null;
/*     */     
/* 225 */     for (IPersistenceStrategy impersonatedStrategy : this._impersonatedStrategies) {
/* 226 */       String impDataSourceName = impersonatedStrategy.getDataSourceName();
/* 227 */       if (_debugLogging) {
/* 228 */         _logger.debug("Preparing to persist to " + impDataSourceName);
/*     */       }
/*     */       
/*     */       try {
/* 232 */         if (StatusMgr.getInstance().isOnline(impDataSourceName)) {
/* 233 */           IPersistable persistable = getDataToPersist(argPersistable, impersonatedStrategy);
/*     */           
/* 235 */           impersonatedStrategy.makePersistent(argTransToken, persistable);
/* 236 */           if (_debugLogging) {
/* 237 */             _logger.debug("Successful persistence to " + impDataSourceName);
/*     */           }
/*     */ 
/*     */           
/* 241 */           successfulWriteDSs.add(impDataSourceName);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 247 */           DataFactory.replicateData(argTransToken, impDataSourceName, persistable, successfulWriteDSs);
/*     */           continue;
/*     */         } 
/* 250 */         if (_debugLogging) {
/* 251 */           _logger.debug("Persistence strategy " + impDataSourceName + " is offline.");
/*     */         }
/*     */         
/* 254 */         String altDataSourceName = getDataSourceName() + "|" + impDataSourceName;
/* 255 */         DataFactory.replicateData(argTransToken, altDataSourceName, argPersistable, successfulWriteDSs);
/*     */ 
/*     */       
/*     */       }
/* 259 */       catch (RetryException rex) {
/* 260 */         RetryException retryException1 = rex;
/*     */       }
/* 262 */       catch (FailoverException fex) {
/*     */         
/* 264 */         String altDataSourceName = getDataSourceName() + "|" + impDataSourceName;
/* 265 */         DataFactory.replicateData(argTransToken, altDataSourceName, argPersistable, successfulWriteDSs);
/*     */       }
/* 267 */       catch (ServiceUnavailableException fex) {
/*     */         
/* 269 */         String altDataSourceName = getDataSourceName() + "|" + impDataSourceName;
/* 270 */         DataFactory.replicateData(argTransToken, altDataSourceName, argPersistable, successfulWriteDSs);
/*     */       }
/* 272 */       catch (PrimaryKeyViolationException pkex) {
/* 273 */         _logger.error(getPersistenceFailedMessage(impDataSourceName, argPersistable), (Throwable)pkex);
/* 274 */         PrimaryKeyViolationException primaryKeyViolationException1 = pkex;
/*     */       }
/* 276 */       catch (JDBCException jex) {
/* 277 */         _logger.error(getPersistenceFailedMessage(impDataSourceName, argPersistable), (Throwable)jex);
/* 278 */         JDBCException jDBCException1 = jex;
/*     */       }
/* 280 */       catch (DtxException dex) {
/* 281 */         _logger.error(getPersistenceFailedMessage(impDataSourceName, argPersistable), (Throwable)dex);
/* 282 */         dtxException = dex;
/*     */       }
/* 284 */       catch (Exception ex) {
/* 285 */         _logger.error(getPersistenceFailedMessage(impDataSourceName, argPersistable), ex);
/* 286 */         dtxException = new DtxException(ex.getMessage(), ex);
/*     */       } 
/*     */     } 
/*     */     
/* 290 */     if (dtxException != null && !FailoverException.isFailover((Throwable)dtxException))
/* 291 */       throw dtxException; 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\ConcurrentWritePersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */