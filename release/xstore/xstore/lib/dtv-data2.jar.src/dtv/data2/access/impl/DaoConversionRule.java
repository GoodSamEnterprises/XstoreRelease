/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.IPersistenceDefaults;
/*    */ import dtv.data2.access.AbstractPersistenceRule;
/*    */ import dtv.data2.access.DaoUtils;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*    */ import dtv.data2.access.datasource.DataSourceFactory;
/*    */ import dtv.data2.access.query.QueryResourceManager;
/*    */ import dtv.data2.access.query.QueryToken;
/*    */ import javax.inject.Inject;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DaoConversionRule
/*    */   extends AbstractPersistenceRule
/*    */ {
/* 29 */   private static final Logger _logger = Logger.getLogger(DaoConversionRule.class);
/*    */   
/*    */   @Inject
/*    */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*    */   
/*    */   @Inject
/*    */   private IPersistenceDefaults _persistenceDefaults;
/*    */   
/*    */   public DaoConversionRule() {
/* 38 */     super(false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IPersistable applyRule(PersistableMetaData argPersistableMetaData, Object argObject) {
/* 44 */     IPersistable persistable = argPersistableMetaData.getPersistable();
/* 45 */     IDataAccessObject dao = (IDataAccessObject)persistable;
/*    */     
/* 47 */     int currentSourceIndex = argPersistableMetaData.getDataSourcesVisited().size() - 1;
/* 48 */     String currentDataSource = argPersistableMetaData.getDataSourcesVisited().get(currentSourceIndex);
/*    */     
/* 50 */     if (DaoState.NEW.matches(dao)) {
/*    */       
/* 52 */       DataSourceDescriptor dataSource = DataSourceFactory.getInstance().getDataSourceDescriptor(currentDataSource);
/* 53 */       IPersistenceStrategy strategy = this._persistenceStrategyFactory.createStrategy(dataSource, true);
/*    */       
/* 55 */       IDataModel result = null;
/*    */       
/* 57 */       QueryToken token = new QueryToken(dao.getObjectId(), getPMTypeByObjectId(dao.getObjectId().getClass()));
/*    */       try {
/* 59 */         result = strategy.getObjectById(dao.getObjectId(), token);
/* 60 */       } catch (Exception ex) {
/* 61 */         _logger.error("CAUGHT EXCEPTION", ex);
/*    */       } finally {
/* 63 */         QueryResourceManager.getInstance().closeQueryResources(token);
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 68 */       if (result != null) {
/* 69 */         IDataAccessObject daoClone = DaoUtils.cloneDao(dao);
/* 70 */         daoClone.setPersistenceDefaults(this._persistenceDefaults);
/* 71 */         daoClone.setObjectState(DaoState.UPDATED.intVal());
/* 72 */         daoClone.setObjectStateRulesApplied(true);
/* 73 */         return (IPersistable)daoClone;
/*    */       } 
/*    */     } 
/*    */     
/* 77 */     return (IPersistable)dao;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DaoConversionRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */