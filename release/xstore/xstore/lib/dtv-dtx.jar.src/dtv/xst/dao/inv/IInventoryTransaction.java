/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryTransaction extends IDataModel, IInventoryTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_OLDSTATUSCODE = new EventEnum("set oldStatusCode");
/* 14 */   public static final EventEnum SET_NEWSTATUSCODE = new EventEnum("set newStatusCode");
/* 15 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 16 */   public static final EventEnum SET_INVENTORYDOCUMENTRETAILLOCATIONID = new EventEnum("set inventoryDocumentRetailLocationId");
/* 17 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 18 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 19 */   public static final EventEnum SET_DOCUMENTDATE = new EventEnum("set documentDate");
/* 20 */   public static final EventEnum SET_INVENTORYDOCUMENT = new EventEnum("set InventoryDocument");
/* 21 */   public static final EventEnum ADD_INVENTORYTRANSACTIONDETAILS = new EventEnum("add InventoryTransactionDetails");
/* 22 */   public static final EventEnum REMOVE_INVENTORYTRANSACTIONDETAILS = new EventEnum("remove InventoryTransactionDetails");
/* 23 */   public static final EventEnum SET_INVENTORYTRANSACTIONDETAILS = new EventEnum("set InventoryTransactionDetails");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getOldStatusCode();
/*    */   
/*    */   void setOldStatusCode(String paramString);
/*    */   
/*    */   String getNewStatusCode();
/*    */   
/*    */   void setNewStatusCode(String paramString);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   long getInventoryDocumentRetailLocationId();
/*    */   
/*    */   void setInventoryDocumentRetailLocationId(long paramLong);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   Date getDocumentDate();
/*    */   
/*    */   void setDocumentDate(Date paramDate);
/*    */   
/*    */   IDataModel getInventoryTransactionExt();
/*    */   
/*    */   void setInventoryTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IInventoryDocument getInventoryDocument();
/*    */   
/*    */   void setInventoryDocument(IInventoryDocument paramIInventoryDocument);
/*    */   
/*    */   List<IInventoryTransactionDetail> getInventoryTransactionDetails();
/*    */   
/*    */   void setInventoryTransactionDetails(List<IInventoryTransactionDetail> paramList);
/*    */   
/*    */   void addInventoryTransactionDetail(IInventoryTransactionDetail paramIInventoryTransactionDetail);
/*    */   
/*    */   void removeInventoryTransactionDetail(IInventoryTransactionDetail paramIInventoryTransactionDetail);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */