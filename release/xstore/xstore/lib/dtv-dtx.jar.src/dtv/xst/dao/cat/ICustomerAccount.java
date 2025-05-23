/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerAccount extends IDataModel, ICustomerAccountModel, IHasDataProperty<ICustomerAccountProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ACCOUNTBALANCE = new EventEnum("set accountBalance");
/* 18 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 19 */   public static final EventEnum SET_CUSTIDENTITYREQ = new EventEnum("set custIdentityReq");
/* 20 */   public static final EventEnum SET_CUSTIDENTITYTYPECODE = new EventEnum("set custIdentityTypeCode");
/* 21 */   public static final EventEnum SET_CUSTACCOUNTSTATECODE = new EventEnum("set custAccountStateCode");
/* 22 */   public static final EventEnum SET_ACCOUNTSETUPDATE = new EventEnum("set accountSetupDate");
/* 23 */   public static final EventEnum SET_LASTACTIVITYDATE = new EventEnum("set lastActivityDate");
/* 24 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 25 */   public static final EventEnum SET_ACCOUNTPURCHASEORDERNUMBER = new EventEnum("set accountPurchaseOrderNumber");
/* 26 */   public static final EventEnum ADD_JOURNALS = new EventEnum("add Journals");
/* 27 */   public static final EventEnum REMOVE_JOURNALS = new EventEnum("remove Journals");
/* 28 */   public static final EventEnum SET_JOURNALS = new EventEnum("set Journals");
/* 29 */   public static final EventEnum SET_PAYMENTSCHEDULE = new EventEnum("set PaymentSchedule");
/* 30 */   public static final EventEnum SET_RETAILLOCATION = new EventEnum("set RetailLocation");
/* 31 */   public static final EventEnum ADD_CUSTACCOUNTNOTES = new EventEnum("add CustAccountNotes");
/* 32 */   public static final EventEnum REMOVE_CUSTACCOUNTNOTES = new EventEnum("remove CustAccountNotes");
/* 33 */   public static final EventEnum SET_CUSTACCOUNTNOTES = new EventEnum("set CustAccountNotes");
/* 34 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 35 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 36 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 37 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 38 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 39 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getAccountBalance();
/*    */   
/*    */   void setAccountBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   boolean getCustIdentityReq();
/*    */   
/*    */   void setCustIdentityReq(boolean paramBoolean);
/*    */   
/*    */   String getCustIdentityTypeCode();
/*    */   
/*    */   void setCustIdentityTypeCode(String paramString);
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
/*    */   String getAccountPurchaseOrderNumber();
/*    */   
/*    */   void setAccountPurchaseOrderNumber(String paramString);
/*    */   
/*    */   IDataModel getCustomerAccountExt();
/*    */   
/*    */   void setCustomerAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerAccountJournal> getJournals();
/*    */   
/*    */   void setJournals(List<ICustomerAccountJournal> paramList);
/*    */   
/*    */   void addCustomerAccountJournal(ICustomerAccountJournal paramICustomerAccountJournal);
/*    */   
/*    */   void removeCustomerAccountJournal(ICustomerAccountJournal paramICustomerAccountJournal);
/*    */   
/*    */   IPaymentSchedule getPaymentSchedule();
/*    */   
/*    */   void setPaymentSchedule(IPaymentSchedule paramIPaymentSchedule);
/*    */   
/*    */   IRetailLocation getRetailLocation();
/*    */   
/*    */   void setRetailLocation(IRetailLocation paramIRetailLocation);
/*    */   
/*    */   List<ICustomerAccountNote> getCustAccountNotes();
/*    */   
/*    */   void setCustAccountNotes(List<ICustomerAccountNote> paramList);
/*    */   
/*    */   void addCustomerAccountNote(ICustomerAccountNote paramICustomerAccountNote);
/*    */   
/*    */   void removeCustomerAccountNote(ICustomerAccountNote paramICustomerAccountNote);
/*    */   
/*    */   List<ICustomerAccountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerAccountProperty> paramList);
/*    */   
/*    */   void addCustomerAccountProperty(ICustomerAccountProperty paramICustomerAccountProperty);
/*    */   
/*    */   void removeCustomerAccountProperty(ICustomerAccountProperty paramICustomerAccountProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */