/*    */ package dtv.xst.dao.ttr;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderAuthLog extends IDataModel, IHasDataProperty<ITenderAuthLogProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 15 */   public static final EventEnum SET_ATTEMPTSEQUENCE = new EventEnum("set attemptSequence");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_RESPONSECODE = new EventEnum("set responseCode");
/* 21 */   public static final EventEnum SET_APPROVALCODE = new EventEnum("set approvalCode");
/* 22 */   public static final EventEnum SET_AUTHTYPE = new EventEnum("set authType");
/* 23 */   public static final EventEnum SET_CUSTOMERNAME = new EventEnum("set customerName");
/* 24 */   public static final EventEnum SET_REFERENCENUMBER = new EventEnum("set referenceNumber");
/* 25 */   public static final EventEnum SET_ERRORCODE = new EventEnum("set errorCode");
/* 26 */   public static final EventEnum SET_ERRORTEXT = new EventEnum("set errorText");
/* 27 */   public static final EventEnum SET_STARTTIMESTAMP = new EventEnum("set startTimestamp");
/* 28 */   public static final EventEnum SET_ENDTIMESTAMP = new EventEnum("set endTimestamp");
/* 29 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 30 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 31 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   int getAttemptSequence();
/*    */   
/*    */   void setAttemptSequence(int paramInt);
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
/*    */   String getResponseCode();
/*    */   
/*    */   void setResponseCode(String paramString);
/*    */   
/*    */   String getApprovalCode();
/*    */   
/*    */   void setApprovalCode(String paramString);
/*    */   
/*    */   String getAuthType();
/*    */   
/*    */   void setAuthType(String paramString);
/*    */   
/*    */   String getCustomerName();
/*    */   
/*    */   void setCustomerName(String paramString);
/*    */   
/*    */   String getReferenceNumber();
/*    */   
/*    */   void setReferenceNumber(String paramString);
/*    */   
/*    */   String getErrorCode();
/*    */   
/*    */   void setErrorCode(String paramString);
/*    */   
/*    */   String getErrorText();
/*    */   
/*    */   void setErrorText(String paramString);
/*    */   
/*    */   Date getStartTimestamp();
/*    */   
/*    */   void setStartTimestamp(Date paramDate);
/*    */   
/*    */   Date getEndTimestamp();
/*    */   
/*    */   void setEndTimestamp(Date paramDate);
/*    */   
/*    */   IDataModel getTenderAuthLogExt();
/*    */   
/*    */   void setTenderAuthLogExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderAuthLogProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderAuthLogProperty> paramList);
/*    */   
/*    */   void addTenderAuthLogProperty(ITenderAuthLogProperty paramITenderAuthLogProperty);
/*    */   
/*    */   void removeTenderAuthLogProperty(ITenderAuthLogProperty paramITenderAuthLogProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ITenderAuthLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */