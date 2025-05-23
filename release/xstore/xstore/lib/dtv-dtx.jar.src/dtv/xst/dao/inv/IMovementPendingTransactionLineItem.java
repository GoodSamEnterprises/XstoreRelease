/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IMovementPendingTransactionLineItem extends IDataModel, IInventoriedLineItem, IHasDataProperty<IMovementPendingTransactionLineItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_LINEITEMSEQUENCE = new EventEnum("set lineItemSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_ORIGINALRETAILLOCATIONID = new EventEnum("set originalRetailLocationId");
/* 20 */   public static final EventEnum SET_ORIGINALWORKSTATIONID = new EventEnum("set originalWorkstationId");
/* 21 */   public static final EventEnum SET_ORIGINALBUSINESSDATE = new EventEnum("set originalBusinessDate");
/* 22 */   public static final EventEnum SET_ORIGINALTRANSACTIONSEQUENCE = new EventEnum("set originalTransactionSequence");
/* 23 */   public static final EventEnum SET_ORIGINALLINEITEMSEQUENCE = new EventEnum("set originalLineItemSequence");
/* 24 */   public static final EventEnum SET_QUANTITYRECONCILED = new EventEnum("set quantityReconciled");
/* 25 */   public static final EventEnum SET_INVENTORYMOVEMENTPENDING = new EventEnum("set InventoryMovementPending");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   int getLineItemSequence();
/*    */   
/*    */   void setLineItemSequence(int paramInt);
/*    */   
/*    */   long getOriginalRetailLocationId();
/*    */   
/*    */   void setOriginalRetailLocationId(long paramLong);
/*    */   
/*    */   long getOriginalWorkstationId();
/*    */   
/*    */   void setOriginalWorkstationId(long paramLong);
/*    */   
/*    */   Date getOriginalBusinessDate();
/*    */   
/*    */   void setOriginalBusinessDate(Date paramDate);
/*    */   
/*    */   long getOriginalTransactionSequence();
/*    */   
/*    */   void setOriginalTransactionSequence(long paramLong);
/*    */   
/*    */   int getOriginalLineItemSequence();
/*    */   
/*    */   void setOriginalLineItemSequence(int paramInt);
/*    */   
/*    */   BigDecimal getQuantityReconciled();
/*    */   
/*    */   void setQuantityReconciled(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getMovementPendingTransactionLineItemExt();
/*    */   
/*    */   void setMovementPendingTransactionLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IInventoryMovementPending getInventoryMovementPending();
/*    */   
/*    */   void setInventoryMovementPending(IInventoryMovementPending paramIInventoryMovementPending);
/*    */   
/*    */   List<IMovementPendingTransactionLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IMovementPendingTransactionLineItemProperty> paramList);
/*    */   
/*    */   void addMovementPendingTransactionLineItemProperty(IMovementPendingTransactionLineItemProperty paramIMovementPendingTransactionLineItemProperty);
/*    */   
/*    */   void removeMovementPendingTransactionLineItemProperty(IMovementPendingTransactionLineItemProperty paramIMovementPendingTransactionLineItemProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IMovementPendingTransactionLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */