/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAwardAccountCoupon extends IDataModel, IAwardAccountCouponModel, IHasDataProperty<IAwardAccountCouponProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CARDNUMBER = new EventEnum("set cardNumber");
/* 11 */   public static final EventEnum SET_ACCOUNTID = new EventEnum("set accountId");
/* 12 */   public static final EventEnum SET_COUPONID = new EventEnum("set couponId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 18 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCardNumber();
/*    */   
/*    */   void setCardNumber(String paramString);
/*    */   
/*    */   String getAccountId();
/*    */   
/*    */   void setAccountId(String paramString);
/*    */   
/*    */   String getCouponId();
/*    */   
/*    */   void setCouponId(String paramString);
/*    */   
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   IDataModel getAwardAccountCouponExt();
/*    */   
/*    */   void setAwardAccountCouponExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAwardAccountCouponProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAwardAccountCouponProperty> paramList);
/*    */   
/*    */   void addAwardAccountCouponProperty(IAwardAccountCouponProperty paramIAwardAccountCouponProperty);
/*    */   
/*    */   void removeAwardAccountCouponProperty(IAwardAccountCouponProperty paramIAwardAccountCouponProperty);
/*    */   
/*    */   void setParentAccount(IAwardAccount paramIAwardAccount);
/*    */   
/*    */   IAwardAccount getParentAccount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IAwardAccountCoupon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */