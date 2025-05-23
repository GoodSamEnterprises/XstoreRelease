/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICustomerItemAccountJournal extends IDataModel, ICustomerAccountJournal {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_CUSTACCOUNTSTATECODE = new EventEnum("set custAccountStateCode");
/* 14 */   public static final EventEnum SET_ACCOUNTSETUPDATE = new EventEnum("set accountSetupDate");
/* 15 */   public static final EventEnum SET_LASTACTIVITYDATE = new EventEnum("set lastActivityDate");
/* 16 */   public static final EventEnum SET_ACCOUNTTOTAL = new EventEnum("set accountTotal");
/* 17 */   public static final EventEnum SET_ACCOUNTPAYMENTS = new EventEnum("set accountPayments");
/* 18 */   public static final EventEnum SET_ACTIVEACCOUNTPAYMENTS = new EventEnum("set activeAccountPayments");
/* 19 */   public static final EventEnum SET_ACTIVEACCOUNTTOTAL = new EventEnum("set activeAccountTotal");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getAccountTotal();
/*    */   
/*    */   void setAccountTotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getAccountPayments();
/*    */   
/*    */   void setAccountPayments(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getActiveAccountPayments();
/*    */   
/*    */   void setActiveAccountPayments(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getActiveAccountTotal();
/*    */   
/*    */   void setActiveAccountTotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getCustomerItemAccountJournalExt();
/*    */   
/*    */   void setCustomerItemAccountJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */