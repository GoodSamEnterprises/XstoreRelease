/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IHasDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAwardAccount extends IDataModel, IAwardAccountModel, IHasDataProperty<IAwardAccountProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CARDNUMBER = new EventEnum("set cardNumber");
/* 11 */   public static final EventEnum SET_ACCOUNTID = new EventEnum("set accountId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum ADD_AWARDCOUPONS = new EventEnum("add AwardCoupons");
/* 17 */   public static final EventEnum REMOVE_AWARDCOUPONS = new EventEnum("remove AwardCoupons");
/* 18 */   public static final EventEnum SET_AWARDCOUPONS = new EventEnum("set AwardCoupons");
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
/*    */   IDataModel getAwardAccountExt();
/*    */   
/*    */   void setAwardAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAwardAccountCoupon> getAwardCoupons();
/*    */   
/*    */   void setAwardCoupons(List<IAwardAccountCoupon> paramList);
/*    */   
/*    */   void addAwardAccountCoupon(IAwardAccountCoupon paramIAwardAccountCoupon);
/*    */   
/*    */   void removeAwardAccountCoupon(IAwardAccountCoupon paramIAwardAccountCoupon);
/*    */   
/*    */   List<IAwardAccountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAwardAccountProperty> paramList);
/*    */   
/*    */   void addAwardAccountProperty(IAwardAccountProperty paramIAwardAccountProperty);
/*    */   
/*    */   void removeAwardAccountProperty(IAwardAccountProperty paramIAwardAccountProperty);
/*    */   
/*    */   void setParentCard(ICustomerLoyaltyCard paramICustomerLoyaltyCard);
/*    */   
/*    */   ICustomerLoyaltyCard getParentCard();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IAwardAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */