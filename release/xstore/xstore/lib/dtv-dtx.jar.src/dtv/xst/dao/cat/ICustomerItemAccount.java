/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerItemAccount extends IDataModel, ICustomerItemAccountModel, ICustomerAccount {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ACCOUNTTOTAL = new EventEnum("set accountTotal");
/* 14 */   public static final EventEnum SET_ACCOUNTPAYMENTS = new EventEnum("set accountPayments");
/* 15 */   public static final EventEnum SET_ACTIVEACCOUNTPAYMENTS = new EventEnum("set activeAccountPayments");
/* 16 */   public static final EventEnum SET_ACTIVEACCOUNTTOTAL = new EventEnum("set activeAccountTotal");
/* 17 */   public static final EventEnum SET_DELIVERYMODIFIER = new EventEnum("set DeliveryModifier");
/* 18 */   public static final EventEnum ADD_CUSTITEMACCOUNTDETAILS = new EventEnum("add CustItemAccountDetails");
/* 19 */   public static final EventEnum REMOVE_CUSTITEMACCOUNTDETAILS = new EventEnum("remove CustItemAccountDetails");
/* 20 */   public static final EventEnum SET_CUSTITEMACCOUNTDETAILS = new EventEnum("set CustItemAccountDetails");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   IDataModel getCustomerItemAccountExt();
/*    */   
/*    */   void setCustomerItemAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDeliveryModifier getDeliveryModifier();
/*    */   
/*    */   void setDeliveryModifier(IDeliveryModifier paramIDeliveryModifier);
/*    */   
/*    */   List<ICustomerItemAccountDetail> getCustItemAccountDetails();
/*    */   
/*    */   void setCustItemAccountDetails(List<ICustomerItemAccountDetail> paramList);
/*    */   
/*    */   void addCustomerItemAccountDetail(ICustomerItemAccountDetail paramICustomerItemAccountDetail);
/*    */   
/*    */   void removeCustomerItemAccountDetail(ICustomerItemAccountDetail paramICustomerItemAccountDetail);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */