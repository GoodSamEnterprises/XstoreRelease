/*    */ package dtv.xst.dao.ttr;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IIdentityVerification extends IDataModel, IIdentityVerificationModel, IHasDataProperty<IIdentityVerificationProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_IDENTITYVERIFICATIONSEQUENCE = new EventEnum("set identityVerificationSequence");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_IDNUMBER = new EventEnum("set idNumber");
/* 21 */   public static final EventEnum SET_IDTYPECODE = new EventEnum("set idTypeCode");
/* 22 */   public static final EventEnum SET_ISSUINGAUTHORITY = new EventEnum("set issuingAuthority");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   int getIdentityVerificationSequence();
/*    */   
/*    */   void setIdentityVerificationSequence(int paramInt);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   String getIdNumber();
/*    */   
/*    */   void setIdNumber(String paramString);
/*    */   
/*    */   String getIdTypeCode();
/*    */   
/*    */   void setIdTypeCode(String paramString);
/*    */   
/*    */   String getIssuingAuthority();
/*    */   
/*    */   void setIssuingAuthority(String paramString);
/*    */   
/*    */   IDataModel getIdentityVerificationExt();
/*    */   
/*    */   void setIdentityVerificationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IIdentityVerificationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IIdentityVerificationProperty> paramList);
/*    */   
/*    */   void addIdentityVerificationProperty(IIdentityVerificationProperty paramIIdentityVerificationProperty);
/*    */   
/*    */   void removeIdentityVerificationProperty(IIdentityVerificationProperty paramIIdentityVerificationProperty);
/*    */   
/*    */   void setParentLine(ITenderLineItem paramITenderLineItem);
/*    */   
/*    */   ITenderLineItem getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\IIdentityVerification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */