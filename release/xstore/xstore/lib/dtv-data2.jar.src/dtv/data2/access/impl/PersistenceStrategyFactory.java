/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.IPersistenceStrategyLocator;
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PersistenceStrategyFactory
/*    */ {
/*    */   private IPersistenceStrategyLocator _actualFactory;
/*    */   
/*    */   public PersistenceStrategyFactory(IPersistenceStrategyLocator argStrategyLocator) {
/* 26 */     this._actualFactory = argStrategyLocator;
/*    */   }
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
/*    */   
/*    */   public IPersistenceStrategy createStrategy(DataSourceDescriptor argDescriptor, boolean argIsOnlineStrategy) {
/* 41 */     IPersistenceStrategy strategy = this._actualFactory.createStrategy(argDescriptor.getPersistenceStrategyName());
/* 42 */     strategy.setDataSourceName(argDescriptor.getName());
/* 43 */     strategy.setProperties(argDescriptor.getProperties());
/* 44 */     strategy.setOnlineStrategyType(argIsOnlineStrategy);
/*    */     
/* 46 */     return strategy;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\PersistenceStrategyFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */