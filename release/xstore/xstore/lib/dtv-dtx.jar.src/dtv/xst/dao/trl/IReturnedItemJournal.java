/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IReturnedItemJournal extends IDataModel, IHasDataProperty<IReturnedItemJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_JOURNALSEQUENCE = new EventEnum("set journalSequence");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_RETURNEDCOUNT = new EventEnum("set returnedCount");
/* 21 */   public static final EventEnum SET_RETURNEDRETAILLOCATIONID = new EventEnum("set returnedRetailLocationId");
/* 22 */   public static final EventEnum SET_RETURNEDWORKSTATIONID = new EventEnum("set returnedWorkstationId");
/* 23 */   public static final EventEnum SET_RETURNEDBUSINESSDATE = new EventEnum("set returnedBusinessDate");
/* 24 */   public static final EventEnum SET_RETURNEDRETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set returnedRetailTransactionLineItemSequence");
/* 25 */   public static final EventEnum SET_RETURNEDTRANSACTIONSEQUENCE = new EventEnum("set returnedTransactionSequence");
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
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
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
/*    */   BigDecimal getReturnedCount();
/*    */   
/*    */   void setReturnedCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   long getReturnedRetailLocationId();
/*    */   
/*    */   void setReturnedRetailLocationId(long paramLong);
/*    */   
/*    */   long getReturnedWorkstationId();
/*    */   
/*    */   void setReturnedWorkstationId(long paramLong);
/*    */   
/*    */   Date getReturnedBusinessDate();
/*    */   
/*    */   void setReturnedBusinessDate(Date paramDate);
/*    */   
/*    */   int getReturnedRetailTransactionLineItemSequence();
/*    */   
/*    */   void setReturnedRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getReturnedTransactionSequence();
/*    */   
/*    */   void setReturnedTransactionSequence(long paramLong);
/*    */   
/*    */   IDataModel getReturnedItemJournalExt();
/*    */   
/*    */   void setReturnedItemJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IReturnedItemJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IReturnedItemJournalProperty> paramList);
/*    */   
/*    */   void addReturnedItemJournalProperty(IReturnedItemJournalProperty paramIReturnedItemJournalProperty);
/*    */   
/*    */   void removeReturnedItemJournalProperty(IReturnedItemJournalProperty paramIReturnedItemJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IReturnedItemJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */