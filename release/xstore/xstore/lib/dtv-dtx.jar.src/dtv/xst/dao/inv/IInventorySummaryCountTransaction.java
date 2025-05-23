/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventorySummaryCountTransaction extends IDataModel, IPosTransaction {
/*  8 */   public static final EventEnum ADD_INVENTORYSUMMARYCOUNTTRANSACTIONDETAILS = new EventEnum("add InventorySummaryCountTransactionDetails");
/*  9 */   public static final EventEnum REMOVE_INVENTORYSUMMARYCOUNTTRANSACTIONDETAILS = new EventEnum("remove InventorySummaryCountTransactionDetails");
/* 10 */   public static final EventEnum SET_INVENTORYSUMMARYCOUNTTRANSACTIONDETAILS = new EventEnum("set InventorySummaryCountTransactionDetails");
/* 11 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 12 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 13 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   IDataModel getInventorySummaryCountTransactionExt();
/*    */   
/*    */   void setInventorySummaryCountTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventorySummaryCountTransactionDetail> getInventorySummaryCountTransactionDetails();
/*    */   
/*    */   void setInventorySummaryCountTransactionDetails(List<IInventorySummaryCountTransactionDetail> paramList);
/*    */   
/*    */   void addInventorySummaryCountTransactionDetail(IInventorySummaryCountTransactionDetail paramIInventorySummaryCountTransactionDetail);
/*    */   
/*    */   void removeInventorySummaryCountTransactionDetail(IInventorySummaryCountTransactionDetail paramIInventorySummaryCountTransactionDetail);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventorySummaryCountTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */