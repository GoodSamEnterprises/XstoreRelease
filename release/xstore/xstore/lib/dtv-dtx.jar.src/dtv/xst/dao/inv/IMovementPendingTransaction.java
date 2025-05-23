/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IMovementPendingTransaction extends IDataModel, IInventoriedItemTransaction, IPosTransaction {
/*  8 */   public static final EventEnum ADD_MOVEMENTPENDINGTRANSACTIONLINEITEMS = new EventEnum("add MovementPendingTransactionLineItems");
/*  9 */   public static final EventEnum REMOVE_MOVEMENTPENDINGTRANSACTIONLINEITEMS = new EventEnum("remove MovementPendingTransactionLineItems");
/* 10 */   public static final EventEnum SET_MOVEMENTPENDINGTRANSACTIONLINEITEMS = new EventEnum("set MovementPendingTransactionLineItems");
/* 11 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 12 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 13 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   IDataModel getMovementPendingTransactionExt();
/*    */   
/*    */   void setMovementPendingTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IMovementPendingTransactionLineItem> getMovementPendingTransactionLineItems();
/*    */   
/*    */   void setMovementPendingTransactionLineItems(List<IMovementPendingTransactionLineItem> paramList);
/*    */   
/*    */   void addMovementPendingTransactionLineItem(IMovementPendingTransactionLineItem paramIMovementPendingTransactionLineItem);
/*    */   
/*    */   void removeMovementPendingTransactionLineItem(IMovementPendingTransactionLineItem paramIMovementPendingTransactionLineItem);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IMovementPendingTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */