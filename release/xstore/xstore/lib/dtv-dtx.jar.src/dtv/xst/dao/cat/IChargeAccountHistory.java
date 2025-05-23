/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IChargeAccountHistory extends IDataModel, IHasDataProperty<IChargeAccountHistoryProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_HISTORYSEQ = new EventEnum("set historySeq");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ACTIVITYDATE = new EventEnum("set activityDate");
/* 18 */   public static final EventEnum SET_ACTIVITYENUM = new EventEnum("set activityEnum");
/* 19 */   public static final EventEnum SET_AMT = new EventEnum("set amt");
/* 20 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 21 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 22 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 23 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 24 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 25 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 26 */   public static final EventEnum SET_ACCOUNTBALANCE = new EventEnum("set accountBalance");
/* 27 */   public static final EventEnum SET_ACCOUNTUSERNAME = new EventEnum("set accountUserName");
/* 28 */   public static final EventEnum SET_ACCOUNTUSERID = new EventEnum("set accountUserId");
/* 29 */   public static final EventEnum SET_REVERSEDFLAG = new EventEnum("set reversedFlag");
/* 30 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 31 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 32 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 33 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 34 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 35 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   long getHistorySeq();
/*    */   
/*    */   void setHistorySeq(long paramLong);
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
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
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
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   BigDecimal getAccountBalance();
/*    */   
/*    */   void setAccountBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getAccountUserName();
/*    */   
/*    */   void setAccountUserName(String paramString);
/*    */   
/*    */   String getAccountUserId();
/*    */   
/*    */   void setAccountUserId(String paramString);
/*    */   
/*    */   boolean getReversedFlag();
/*    */   
/*    */   void setReversedFlag(boolean paramBoolean);
/*    */   
/*    */   IDataModel getChargeAccountHistoryExt();
/*    */   
/*    */   void setChargeAccountHistoryExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IChargeAccountHistoryProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IChargeAccountHistoryProperty> paramList);
/*    */   
/*    */   void addChargeAccountHistoryProperty(IChargeAccountHistoryProperty paramIChargeAccountHistoryProperty);
/*    */   
/*    */   void removeChargeAccountHistoryProperty(IChargeAccountHistoryProperty paramIChargeAccountHistoryProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IChargeAccountHistory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */