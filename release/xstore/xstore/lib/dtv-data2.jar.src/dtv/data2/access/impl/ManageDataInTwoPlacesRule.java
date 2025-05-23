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
/*     */ import dtv.data2.access.impl.config.PmTypeMappingConfigHelper;
/*     */ import dtv.data2.access.query.QueryResourceManager;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class ManageDataInTwoPlacesRule
/*     */   extends AbstractPersistenceRule
/*     */ {
/*  35 */   private static final Logger _logger = Logger.getLogger(ManageDataInTwoPlacesRule.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   @Inject
/*     */   private PmTypeMappingConfigHelper _cfg;
/*     */ 
/*     */   
/*     */   public ManageDataInTwoPlacesRule() {
/*  50 */     super(false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistable applyRule(PersistableMetaData argPersistableMetaData, Object argObject) {
/*  56 */     IPersistable persistable = argPersistableMetaData.getPersistable();
/*  57 */     IDataAccessObject dao = (IDataAccessObject)persistable;
/*     */     
/*  59 */     int currentSourceIndex = argPersistableMetaData.getDataSourcesVisited().size() - 1;
/*  60 */     String currentDataSource = argPersistableMetaData.getDataSourcesVisited().get(currentSourceIndex);
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
/*  79 */     if (!dao.isObjectStateRulesApplied() && !DaoState.isDeleted(dao) && 
/*  80 */       !StringUtils.equalsIgnoreCase(dao.getOriginDataSource(), currentDataSource))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       if (!DaoState.INSERT_OR_UPDATE.matches(dao)) {
/*  91 */         dao = DaoUtils.cloneDao(dao);
/*  92 */         dao.setPersistenceDefaults(this._persistenceDefaults);
/*  93 */         dao.setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     if (DaoState.INSERT_ONLY.matches(dao)) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 105 */       DataSourceDescriptor dataSource = DataSourceFactory.getInstance().getDataSourceDescriptor(currentDataSource);
/* 106 */       IPersistenceStrategy strategy = this._persistenceStrategyFactory.createStrategy(dataSource, true);
/*     */       
/* 108 */       IDataModel result = null;
/*     */       
/* 110 */       QueryToken token = new QueryToken(dao.getObjectId(), getPMTypeByObjectId(dao.getObjectId().getClass()));
/*     */       try {
/* 112 */         result = strategy.getObjectById(dao.getObjectId(), token);
/* 113 */       } catch (Exception ex) {
/* 114 */         _logger.error("CAUGHT EXCEPTION", ex);
/*     */       } finally {
/* 116 */         QueryResourceManager.getInstance().closeQueryResources(token);
/*     */       } 
/* 118 */       dao = DaoUtils.cloneDao(dao);
/*     */       
/* 120 */       if (result == null) {
/* 121 */         dao.setObjectState(DaoState.NEW.intVal());
/* 122 */         dao.setObjectStateRulesApplied(true);
/*     */       } else {
/* 124 */         dao.setObjectState(DaoState.CLEAN.intVal());
/* 125 */         dao.setObjectStateRulesApplied(true);
/*     */       } 
/*     */     } 
/* 128 */     return (IPersistable)dao;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicable(PersistableMetaData argPersistableMetaData, Object argObject) {
/* 134 */     return argPersistableMetaData.getPersistable() instanceof IDataAccessObject;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\ManageDataInTwoPlacesRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */