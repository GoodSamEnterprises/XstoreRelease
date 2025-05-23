/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryTransactionDetail extends IDataModel, IInventoryTransactionDetailModel, IHasDataProperty<IInventoryTransactionDetailProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_INVENTORYDETAILSEQUENCE = new EventEnum("set inventoryDetailSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_OLDSTATUSCODE = new EventEnum("set oldStatusCode");
/* 20 */   public static final EventEnum SET_NEWSTATUSCODE = new EventEnum("set newStatusCode");
/* 21 */   public static final EventEnum SET_PREVIOUSUNITCOUNT = new EventEnum("set previousUnitCount");
/* 22 */   public static final EventEnum SET_NEWUNITCOUNT = new EventEnum("set newUnitCount");
/* 23 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 24 */   public static final EventEnum SET_NEWPOSTEDCOUNT = new EventEnum("set newPostedCount");
/* 25 */   public static final EventEnum SET_PREVIOUSPOSTEDCOUNT = new EventEnum("set previousPostedCount");
/* 26 */   public static final EventEnum SET_INVENTORYDOCUMENTRETAILLOCATIONID = new EventEnum("set inventoryDocumentRetailLocationId");
/* 27 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 28 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 29 */   public static final EventEnum SET_INVENTORYDOCUMENTLINENUMBER = new EventEnum("set inventoryDocumentLineNumber");
/* 30 */   public static final EventEnum SET_INVENTORYITEMID = new EventEnum("set inventoryItemId");
/* 31 */   public static final EventEnum SET_INVENTORYDOCUMENTLINEITEM = new EventEnum("set InventoryDocumentLineItem");
/* 32 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 33 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 34 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 35 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 36 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 37 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   int getInventoryDetailSequence();
/*    */   
/*    */   void setInventoryDetailSequence(int paramInt);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getOldStatusCode();
/*    */   
/*    */   void setOldStatusCode(String paramString);
/*    */   
/*    */   String getNewStatusCode();
/*    */   
/*    */   void setNewStatusCode(String paramString);
/*    */   
/*    */   BigDecimal getPreviousUnitCount();
/*    */   
/*    */   void setPreviousUnitCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getNewUnitCount();
/*    */   
/*    */   void setNewUnitCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   BigDecimal getNewPostedCount();
/*    */   
/*    */   void setNewPostedCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPreviousPostedCount();
/*    */   
/*    */   void setPreviousPostedCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   long getInventoryDocumentRetailLocationId();
/*    */   
/*    */   void setInventoryDocumentRetailLocationId(long paramLong);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   String getInventoryItemId();
/*    */   
/*    */   void setInventoryItemId(String paramString);
/*    */   
/*    */   IDataModel getInventoryTransactionDetailExt();
/*    */   
/*    */   void setInventoryTransactionDetailExt(IDataModel paramIDataModel);
/*    */   
/*    */   IInventoryDocumentLineItem getInventoryDocumentLineItem();
/*    */   
/*    */   void setInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   List<IInventoryTransactionDetailProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryTransactionDetailProperty> paramList);
/*    */   
/*    */   void addInventoryTransactionDetailProperty(IInventoryTransactionDetailProperty paramIInventoryTransactionDetailProperty);
/*    */   
/*    */   void removeInventoryTransactionDetailProperty(IInventoryTransactionDetailProperty paramIInventoryTransactionDetailProperty);
/*    */   
/*    */   void setParentTransaction(IInventoryTransaction paramIInventoryTransaction);
/*    */   
/*    */   IInventoryTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryTransactionDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */