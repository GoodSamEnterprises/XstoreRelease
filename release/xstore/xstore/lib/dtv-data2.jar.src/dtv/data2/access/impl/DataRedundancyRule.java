/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.AbstractPersistenceRule;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.List;
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
/*     */ public class DataRedundancyRule
/*     */   extends AbstractPersistenceRule
/*     */ {
/*  40 */   private static final Logger _logger = Logger.getLogger(DataRedundancyRule.class);
/*     */ 
/*     */   
/*     */   private static final String PARAM_APPLIES_IN_TRAINING_MODE = "AppliesInTrainingMode";
/*     */   
/*     */   private boolean _applyInTrainingMode = false;
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */ 
/*     */   
/*     */   public DataRedundancyRule() {
/*  55 */     super(true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistable applyRule(PersistableMetaData argPersistableMetaData, Object argObject) {
/*  61 */     IPersistable persistable = argPersistableMetaData.getPersistable();
/*  62 */     String targetDataSourceName = getTargetDataSourceName();
/*     */ 
/*     */     
/*  65 */     if (DataSourceFactory.isDataSourceEnabled(targetDataSourceName) && 
/*  66 */       StatusMgr.getInstance().isOnline(targetDataSourceName)) {
/*     */ 
/*     */       
/*  69 */       DataSourceDescriptor dataSource = DataSourceFactory.getInstance().getDataSourceDescriptor(targetDataSourceName);
/*  70 */       IPersistenceStrategy strategy = this._persistenceStrategyFactory.createStrategy(dataSource, true);
/*     */       
/*  72 */       List<? extends IPersistable> persistables = DaoUtils.getPersistables(persistable);
/*  73 */       TransactionToken token = DataSourceTransactionManager.getInstance().startTransaction(null);
/*     */       
/*     */       try {
/*  76 */         for (IPersistable nextPersistable : persistables) {
/*  77 */           IDataAccessObject iDataAccessObject; if (nextPersistable instanceof IDataAccessObject) {
/*  78 */             iDataAccessObject = DaoUtils.cloneDao((IDataAccessObject)nextPersistable);
/*  79 */             iDataAccessObject.setPersistenceDefaults(this._persistenceDefaults);
/*  80 */             iDataAccessObject.setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
/*     */           } 
/*  82 */           strategy.makePersistent(token, (IPersistable)iDataAccessObject);
/*     */         } 
/*     */         
/*  85 */         DataSourceTransactionManager.getInstance().commit(token);
/*     */       }
/*  87 */       catch (Exception ex) {
/*     */         
/*  89 */         _logger.error("Exception caught attempting to persist data via rule: " + getClass().getName(), ex);
/*  90 */         DataSourceTransactionManager.getInstance().rollback(token);
/*     */       } 
/*     */     } 
/*  93 */     return persistable;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isApplicable(PersistableMetaData argPersistableMetaData, Object argObject) {
/*     */     int i;
/*  99 */     IPersistable persistable = argPersistableMetaData.getPersistable();
/*     */     
/* 101 */     boolean applicable = false;
/*     */ 
/*     */     
/* 104 */     if (persistable instanceof IDataModel && "OBJECT_RETRIEVED"
/* 105 */       .equals(argPersistableMetaData.getPersistableAction()) && (this._applyInTrainingMode || 
/* 106 */       !this._persistenceDefaults.isTraining())) {
/*     */       
/* 108 */       String dataSource = ((IDataModel)persistable).getDataSource();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       applicable = matchesSourceDataSource(dataSource, true);
/* 114 */       i = applicable & (!matchesTargetDataSource(dataSource, true) ? 1 : 0);
/*     */     } 
/* 116 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/* 122 */     if ("AppliesInTrainingMode".equalsIgnoreCase(argName)) {
/* 123 */       this._applyInTrainingMode = Boolean.valueOf(argValue.toString()).booleanValue();
/*     */     } else {
/*     */       
/* 126 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DataRedundancyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */