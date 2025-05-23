/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryJournal extends IDataModel, IHasDataProperty<IInventoryJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONLINEITEMSEQUENCE = new EventEnum("set transactionLineItemSequence");
/* 15 */   public static final EventEnum SET_JOURNALSEQUENCE = new EventEnum("set journalSequence");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_INVENTORYITEMID = new EventEnum("set inventoryItemId");
/* 21 */   public static final EventEnum SET_ITEMSERIALNUMBER = new EventEnum("set itemSerialNumber");
/* 22 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 23 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 24 */   public static final EventEnum SET_SOURCELOCATIONID = new EventEnum("set sourceLocationId");
/* 25 */   public static final EventEnum SET_SOURCEBUCKETID = new EventEnum("set sourceBucketId");
/* 26 */   public static final EventEnum SET_DESTINATIONLOCATIONID = new EventEnum("set destinationLocationId");
/* 27 */   public static final EventEnum SET_DESTINATIONBUCKETID = new EventEnum("set destinationBucketId");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getTransactionLineItemSequence();
/*    */   
/*    */   void setTransactionLineItemSequence(long paramLong);
/*    */   
/*    */   long getJournalSequence();
/*    */   
/*    */   void setJournalSequence(long paramLong);
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
/*    */   String getInventoryItemId();
/*    */   
/*    */   void setInventoryItemId(String paramString);
/*    */   
/*    */   String getItemSerialNumber();
/*    */   
/*    */   void setItemSerialNumber(String paramString);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getSourceLocationId();
/*    */   
/*    */   void setSourceLocationId(String paramString);
/*    */   
/*    */   String getSourceBucketId();
/*    */   
/*    */   void setSourceBucketId(String paramString);
/*    */   
/*    */   String getDestinationLocationId();
/*    */   
/*    */   void setDestinationLocationId(String paramString);
/*    */   
/*    */   String getDestinationBucketId();
/*    */   
/*    */   void setDestinationBucketId(String paramString);
/*    */   
/*    */   IDataModel getInventoryJournalExt();
/*    */   
/*    */   void setInventoryJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryJournalProperty> paramList);
/*    */   
/*    */   void addInventoryJournalProperty(IInventoryJournalProperty paramIInventoryJournalProperty);
/*    */   
/*    */   void removeInventoryJournalProperty(IInventoryJournalProperty paramIInventoryJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */