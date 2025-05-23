/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import dtv.xst.dao.ttr.ITenderSignature;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IRetailTransactionLineItem extends IDataModel, IRetailTransactionLineItemModel, IHasDataProperty<IRetailTransactionLineItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 15 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_BEGINDATETIMESTAMP = new EventEnum("set beginDateTimestamp");
/* 21 */   public static final EventEnum SET_ENDDATETIMESTAMP = new EventEnum("set endDateTimestamp");
/* 22 */   public static final EventEnum SET_LINEITEMSTATUSCODE = new EventEnum("set lineItemStatusCode");
/* 23 */   public static final EventEnum SET_LINEITEMTYPECODE = new EventEnum("set lineItemTypeCode");
/* 24 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 25 */   public static final EventEnum SET_VOIDLINEITEMREASONCODE = new EventEnum("set voidLineItemReasonCode");
/* 26 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 27 */   public static final EventEnum SET_GENERICSTORAGE = new EventEnum("set genericStorage");
/* 28 */   public static final EventEnum SET_TLOGSEQUENCE = new EventEnum("set tLogSequence");
/* 29 */   public static final EventEnum SET_CURRENCYID = new EventEnum("set currencyId");
/* 30 */   public static final EventEnum SET_CORRECTIONMODIFIER = new EventEnum("set CorrectionModifier");
/* 31 */   public static final EventEnum SET_SIGNATURE = new EventEnum("set Signature");
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
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   String getClassName();
/*    */   
/*    */   void setClassName(String paramString);
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
/*    */   Date getBeginDateTimestamp();
/*    */   
/*    */   void setBeginDateTimestamp(Date paramDate);
/*    */   
/*    */   Date getEndDateTimestamp();
/*    */   
/*    */   void setEndDateTimestamp(Date paramDate);
/*    */   
/*    */   String getLineItemStatusCode();
/*    */   
/*    */   void setLineItemStatusCode(String paramString);
/*    */   
/*    */   String getLineItemTypeCode();
/*    */   
/*    */   void setLineItemTypeCode(String paramString);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   String getVoidLineItemReasonCode();
/*    */   
/*    */   void setVoidLineItemReasonCode(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   boolean getGenericStorage();
/*    */   
/*    */   void setGenericStorage(boolean paramBoolean);
/*    */   
/*    */   int getTLogSequence();
/*    */   
/*    */   void setTLogSequence(int paramInt);
/*    */   
/*    */   String getCurrencyId();
/*    */   
/*    */   void setCurrencyId(String paramString);
/*    */   
/*    */   IDataModel getRetailTransactionLineItemExt();
/*    */   
/*    */   void setRetailTransactionLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   ICorrectionModifier getCorrectionModifier();
/*    */   
/*    */   void setCorrectionModifier(ICorrectionModifier paramICorrectionModifier);
/*    */   
/*    */   ITenderSignature getSignature();
/*    */   
/*    */   void setSignature(ITenderSignature paramITenderSignature);
/*    */   
/*    */   List<IRetailTransactionLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRetailTransactionLineItemProperty> paramList);
/*    */   
/*    */   void addRetailTransactionLineItemProperty(IRetailTransactionLineItemProperty paramIRetailTransactionLineItemProperty);
/*    */   
/*    */   void removeRetailTransactionLineItemProperty(IRetailTransactionLineItemProperty paramIRetailTransactionLineItemProperty);
/*    */   
/*    */   void setParentTransaction(IPosTransaction paramIPosTransaction);
/*    */   
/*    */   IPosTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */