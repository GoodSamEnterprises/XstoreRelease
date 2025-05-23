/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEscrowAccount extends IDataModel, IEscrowAccountModel, IHasDataProperty<IEscrowAccountProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ACCOUNTBALANCE = new EventEnum("set accountBalance");
/* 16 */   public static final EventEnum SET_CUSTACCOUNTSTATECODE = new EventEnum("set custAccountStateCode");
/* 17 */   public static final EventEnum SET_ACCOUNTSETUPDATE = new EventEnum("set accountSetupDate");
/* 18 */   public static final EventEnum SET_LASTACTIVITYDATE = new EventEnum("set lastActivityDate");
/* 19 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 20 */   public static final EventEnum ADD_ESCROWACCOUNTACTIVITIES = new EventEnum("add EscrowAccountActivities");
/* 21 */   public static final EventEnum REMOVE_ESCROWACCOUNTACTIVITIES = new EventEnum("remove EscrowAccountActivities");
/* 22 */   public static final EventEnum SET_ESCROWACCOUNTACTIVITIES = new EventEnum("set EscrowAccountActivities");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getAccountBalance();
/*    */   
/*    */   void setAccountBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCustAccountStateCode();
/*    */   
/*    */   void setCustAccountStateCode(String paramString);
/*    */   
/*    */   Date getAccountSetupDate();
/*    */   
/*    */   void setAccountSetupDate(Date paramDate);
/*    */   
/*    */   Date getLastActivityDate();
/*    */   
/*    */   void setLastActivityDate(Date paramDate);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   IDataModel getEscrowAccountExt();
/*    */   
/*    */   void setEscrowAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IEscrowAccountActivity> getEscrowAccountActivities();
/*    */   
/*    */   void setEscrowAccountActivities(List<IEscrowAccountActivity> paramList);
/*    */   
/*    */   void addEscrowAccountActivity(IEscrowAccountActivity paramIEscrowAccountActivity);
/*    */   
/*    */   void removeEscrowAccountActivity(IEscrowAccountActivity paramIEscrowAccountActivity);
/*    */   
/*    */   List<IEscrowAccountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEscrowAccountProperty> paramList);
/*    */   
/*    */   void addEscrowAccountProperty(IEscrowAccountProperty paramIEscrowAccountProperty);
/*    */   
/*    */   void removeEscrowAccountProperty(IEscrowAccountProperty paramIEscrowAccountProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IEscrowAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */