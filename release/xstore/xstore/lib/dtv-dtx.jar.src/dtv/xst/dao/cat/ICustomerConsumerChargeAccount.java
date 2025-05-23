/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerConsumerChargeAccount extends IDataModel, ICustomerConsumerChargeAccountModel, ICustomerAccount {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_CREDITLIMIT = new EventEnum("set creditLimit");
/* 14 */   public static final EventEnum SET_POREQUIRED = new EventEnum("set poRequired");
/* 15 */   public static final EventEnum SET_ONHOLD = new EventEnum("set onHold");
/* 16 */   public static final EventEnum SET_ISCORPORATEACCOUNT = new EventEnum("set isCorporateAccount");
/* 17 */   public static final EventEnum ADD_CHARGEACCOUNTUSERS = new EventEnum("add ChargeAccountUsers");
/* 18 */   public static final EventEnum REMOVE_CHARGEACCOUNTUSERS = new EventEnum("remove ChargeAccountUsers");
/* 19 */   public static final EventEnum SET_CHARGEACCOUNTUSERS = new EventEnum("set ChargeAccountUsers");
/* 20 */   public static final EventEnum ADD_CHARGEACCOUNTHISTORIES = new EventEnum("add ChargeAccountHistories");
/* 21 */   public static final EventEnum REMOVE_CHARGEACCOUNTHISTORIES = new EventEnum("remove ChargeAccountHistories");
/* 22 */   public static final EventEnum SET_CHARGEACCOUNTHISTORIES = new EventEnum("set ChargeAccountHistories");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getCreditLimit();
/*    */   
/*    */   void setCreditLimit(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getPoRequired();
/*    */   
/*    */   void setPoRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getOnHold();
/*    */   
/*    */   void setOnHold(boolean paramBoolean);
/*    */   
/*    */   boolean getIsCorporateAccount();
/*    */   
/*    */   void setIsCorporateAccount(boolean paramBoolean);
/*    */   
/*    */   IDataModel getCustomerConsumerChargeAccountExt();
/*    */   
/*    */   void setCustomerConsumerChargeAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IChargeAccountUser> getChargeAccountUsers();
/*    */   
/*    */   void setChargeAccountUsers(List<IChargeAccountUser> paramList);
/*    */   
/*    */   void addChargeAccountUser(IChargeAccountUser paramIChargeAccountUser);
/*    */   
/*    */   void removeChargeAccountUser(IChargeAccountUser paramIChargeAccountUser);
/*    */   
/*    */   List<IChargeAccountHistory> getChargeAccountHistories();
/*    */   
/*    */   void setChargeAccountHistories(List<IChargeAccountHistory> paramList);
/*    */   
/*    */   void addChargeAccountHistory(IChargeAccountHistory paramIChargeAccountHistory);
/*    */   
/*    */   void removeChargeAccountHistory(IChargeAccountHistory paramIChargeAccountHistory);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerConsumerChargeAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */