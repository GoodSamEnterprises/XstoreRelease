/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerAccountJournal extends IDataModel, ICustomerAccountJournalModel, IHasDataProperty<ICustomerAccountJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_JOURNALSEQUENCE = new EventEnum("set journalSequence");
/* 13 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 19 */   public static final EventEnum SET_ACCOUNTBALANCE = new EventEnum("set accountBalance");
/* 20 */   public static final EventEnum SET_CUSTIDENTITYTYPECODE = new EventEnum("set custIdentityTypeCode");
/* 21 */   public static final EventEnum SET_TRANSRETAILLOCATIONID = new EventEnum("set transRetailLocationId");
/* 22 */   public static final EventEnum SET_TRANSWORKSTATIONID = new EventEnum("set transWorkstationId");
/* 23 */   public static final EventEnum SET_TRANSBUSINESSDATE = new EventEnum("set transBusinessDate");
/* 24 */   public static final EventEnum SET_TRANSSEQUENCE = new EventEnum("set transSequence");
/* 25 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
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
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   long getJournalSequence();
/*    */   
/*    */   void setJournalSequence(long paramLong);
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   BigDecimal getAccountBalance();
/*    */   
/*    */   void setAccountBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCustIdentityTypeCode();
/*    */   
/*    */   void setCustIdentityTypeCode(String paramString);
/*    */   
/*    */   long getTransRetailLocationId();
/*    */   
/*    */   void setTransRetailLocationId(long paramLong);
/*    */   
/*    */   long getTransWorkstationId();
/*    */   
/*    */   void setTransWorkstationId(long paramLong);
/*    */   
/*    */   Date getTransBusinessDate();
/*    */   
/*    */   void setTransBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransSequence();
/*    */   
/*    */   void setTransSequence(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   IDataModel getCustomerAccountJournalExt();
/*    */   
/*    */   void setCustomerAccountJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerAccountJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerAccountJournalProperty> paramList);
/*    */   
/*    */   void addCustomerAccountJournalProperty(ICustomerAccountJournalProperty paramICustomerAccountJournalProperty);
/*    */   
/*    */   void removeCustomerAccountJournalProperty(ICustomerAccountJournalProperty paramICustomerAccountJournalProperty);
/*    */   
/*    */   void setParentCustomerAccount(ICustomerAccount paramICustomerAccount);
/*    */   
/*    */   ICustomerAccount getParentCustomerAccount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerAccountJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */