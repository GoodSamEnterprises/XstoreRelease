/*    */ package dtv.data2x.impl;
/*    */ 
/*    */ import dtv.data2.access.DaoUtils;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.service.req.IServiceRequest;
/*    */ import dtv.servicex.impl.AbstractDecorator;
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
/*    */ public class DataSourceDecorator
/*    */   extends AbstractDecorator
/*    */ {
/*    */   private static final String PARAM_DATA_SOURCE = "DataSource";
/*    */   private String _dataSource;
/*    */   
/*    */   public Object decorate(Object argDecoratorCandidate, IServiceRequest argAuxiliaryData) {
/* 30 */     IDataModel dataModel = (IDataModel)argDecoratorCandidate;
/*    */ 
/*    */     
/* 33 */     for (IPersistable persistable : DaoUtils.getPersistables(dataModel)) {
/* 34 */       if (persistable instanceof IDataAccessObject) {
/* 35 */         ((IDataAccessObject)persistable).setOriginDataSource(this._dataSource);
/*    */       }
/*    */     } 
/*    */     
/* 39 */     return dataModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, Object argValue) {
/* 45 */     if ("DataSource".equalsIgnoreCase(argName))
/* 46 */       this._dataSource = argValue.toString(); 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\DataSourceDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */