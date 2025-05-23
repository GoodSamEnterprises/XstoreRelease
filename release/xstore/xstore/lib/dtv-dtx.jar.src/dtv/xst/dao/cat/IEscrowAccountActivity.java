/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEscrowAccountActivity extends IDataModel, IHasDataProperty<IEscrowAccountActivityProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_SEQNBR = new EventEnum("set seqNbr");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ACTIVITYDATE = new EventEnum("set activityDate");
/* 17 */   public static final EventEnum SET_ACTIVITYENUM = new EventEnum("set activityEnum");
/* 18 */   public static final EventEnum SET_AMT = new EventEnum("set amt");
/* 19 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 20 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 21 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 22 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 23 */   public static final EventEnum SET_SOURCECUSTACCOUNTID = new EventEnum("set sourceCustAccountId");
/* 24 */   public static final EventEnum SET_SOURCECUSTACCOUNTCODE = new EventEnum("set sourceCustAccountCode");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   long getSeqNbr();
/*    */   
/*    */   void setSeqNbr(long paramLong);
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
/*    */   Date getActivityDate();
/*    */   
/*    */   void setActivityDate(Date paramDate);
/*    */   
/*    */   String getActivityEnum();
/*    */   
/*    */   void setActivityEnum(String paramString);
/*    */   
/*    */   BigDecimal getAmt();
/*    */   
/*    */   void setAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getSourceCustAccountId();
/*    */   
/*    */   void setSourceCustAccountId(String paramString);
/*    */   
/*    */   String getSourceCustAccountCode();
/*    */   
/*    */   void setSourceCustAccountCode(String paramString);
/*    */   
/*    */   IDataModel getEscrowAccountActivityExt();
/*    */   
/*    */   void setEscrowAccountActivityExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IEscrowAccountActivityProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEscrowAccountActivityProperty> paramList);
/*    */   
/*    */   void addEscrowAccountActivityProperty(IEscrowAccountActivityProperty paramIEscrowAccountActivityProperty);
/*    */   
/*    */   void removeEscrowAccountActivityProperty(IEscrowAccountActivityProperty paramIEscrowAccountActivityProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IEscrowAccountActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */