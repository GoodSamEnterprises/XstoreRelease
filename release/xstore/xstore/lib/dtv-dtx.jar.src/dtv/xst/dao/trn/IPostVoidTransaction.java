/*    */ package dtv.xst.dao.trn;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IPostVoidTransaction extends IDataModel, IPostVoidTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_VOIDEDTRANSACTIONENTRYCODE = new EventEnum("set voidedTransactionEntryCode");
/* 14 */   public static final EventEnum SET_VOIDEDBUSINESSDATE = new EventEnum("set voidedBusinessDate");
/* 15 */   public static final EventEnum SET_VOIDEDWORKSTATIONID = new EventEnum("set voidedWorkstationId");
/* 16 */   public static final EventEnum SET_VOIDEDTRANSACTIONID = new EventEnum("set voidedTransactionId");
/* 17 */   public static final EventEnum SET_VOIDEDRETAILSTOREID = new EventEnum("set voidedRetailStoreId");
/* 18 */   public static final EventEnum SET_VOIDEDORGANIZATIONID = new EventEnum("set voidedOrganizationId");
/* 19 */   public static final EventEnum SET_POSTVOIDREASONCODE = new EventEnum("set postVoidReasonCode");
/* 20 */   public static final EventEnum SET_VOIDEDTRANSACTION = new EventEnum("set VoidedTransaction");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   String getVoidedTransactionEntryCode();
/*    */   
/*    */   void setVoidedTransactionEntryCode(String paramString);
/*    */   
/*    */   Date getVoidedBusinessDate();
/*    */   
/*    */   void setVoidedBusinessDate(Date paramDate);
/*    */   
/*    */   long getVoidedWorkstationId();
/*    */   
/*    */   void setVoidedWorkstationId(long paramLong);
/*    */   
/*    */   long getVoidedTransactionId();
/*    */   
/*    */   void setVoidedTransactionId(long paramLong);
/*    */   
/*    */   long getVoidedRetailStoreId();
/*    */   
/*    */   void setVoidedRetailStoreId(long paramLong);
/*    */   
/*    */   long getVoidedOrganizationId();
/*    */   
/*    */   void setVoidedOrganizationId(long paramLong);
/*    */   
/*    */   String getPostVoidReasonCode();
/*    */   
/*    */   void setPostVoidReasonCode(String paramString);
/*    */   
/*    */   IDataModel getPostVoidTransactionExt();
/*    */   
/*    */   void setPostVoidTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IPosTransaction getVoidedTransaction();
/*    */   
/*    */   void setVoidedTransaction(IPosTransaction paramIPosTransaction);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IPostVoidTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */