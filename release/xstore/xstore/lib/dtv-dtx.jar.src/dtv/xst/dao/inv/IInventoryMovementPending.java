/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.itm.IItem;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryMovementPending extends IDataModel, IInventoryMovementPendingModel, IHasDataProperty<IInventoryMovementPendingProperty> {
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
/* 19 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 20 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 21 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 22 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 23 */   public static final EventEnum SET_RECONCILED = new EventEnum("set reconciled");
/* 24 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 25 */   public static final EventEnum ADD_MOVEMENTPENDINGDETAILS = new EventEnum("add MovementPendingDetails");
/* 26 */   public static final EventEnum REMOVE_MOVEMENTPENDINGDETAILS = new EventEnum("remove MovementPendingDetails");
/* 27 */   public static final EventEnum SET_MOVEMENTPENDINGDETAILS = new EventEnum("set MovementPendingDetails");
/* 28 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
/* 29 */   public static final EventEnum SET_SALELINEITEM = new EventEnum("set SaleLineItem");
/* 30 */   public static final EventEnum SET_INVENTORYTRANSACTIONDETAIL = new EventEnum("set InventoryTransactionDetail");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getReconciled();
/*    */   
/*    */   void setReconciled(boolean paramBoolean);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   IDataModel getInventoryMovementPendingExt();
/*    */   
/*    */   void setInventoryMovementPendingExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryMovementPendingDetail> getMovementPendingDetails();
/*    */   
/*    */   void setMovementPendingDetails(List<IInventoryMovementPendingDetail> paramList);
/*    */   
/*    */   void addInventoryMovementPendingDetail(IInventoryMovementPendingDetail paramIInventoryMovementPendingDetail);
/*    */   
/*    */   void removeInventoryMovementPendingDetail(IInventoryMovementPendingDetail paramIInventoryMovementPendingDetail);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   ISaleReturnLineItem getSaleLineItem();
/*    */   
/*    */   void setSaleLineItem(ISaleReturnLineItem paramISaleReturnLineItem);
/*    */   
/*    */   IInventoryTransactionDetail getInventoryTransactionDetail();
/*    */   
/*    */   void setInventoryTransactionDetail(IInventoryTransactionDetail paramIInventoryTransactionDetail);
/*    */   
/*    */   List<IInventoryMovementPendingProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryMovementPendingProperty> paramList);
/*    */   
/*    */   void addInventoryMovementPendingProperty(IInventoryMovementPendingProperty paramIInventoryMovementPendingProperty);
/*    */   
/*    */   void removeInventoryMovementPendingProperty(IInventoryMovementPendingProperty paramIInventoryMovementPendingProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryMovementPending.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */