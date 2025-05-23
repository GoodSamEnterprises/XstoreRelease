/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerLoyaltyAccount extends IDataModel, ICustomerLoyaltyAccountModel, IHasDataProperty<ICustomerLoyaltyAccountProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CARDNUMBER = new EventEnum("set cardNumber");
/* 11 */   public static final EventEnum SET_ACCOUNTID = new EventEnum("set accountId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_LOYALTYPROGRAMID = new EventEnum("set loyaltyProgramId");
/* 17 */   public static final EventEnum SET_LOYALTYPROGRAMNAME = new EventEnum("set loyaltyProgramName");
/* 18 */   public static final EventEnum SET_LOYALTYPROGRAMLEVELID = new EventEnum("set loyaltyProgramLevelId");
/* 19 */   public static final EventEnum SET_LOYALTYPROGRAMLEVELNAME = new EventEnum("set loyaltyProgramLevelName");
/* 20 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 21 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 22 */   public static final EventEnum SET_ACCOUNTBALANCE = new EventEnum("set accountBalance");
/* 23 */   public static final EventEnum SET_ESCROWBALANCE = new EventEnum("set escrowBalance");
/* 24 */   public static final EventEnum SET_BONUSBALANCE = new EventEnum("set bonusBalance");
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
/*    */   String getCardNumber();
/*    */   
/*    */   void setCardNumber(String paramString);
/*    */   
/*    */   String getAccountId();
/*    */   
/*    */   void setAccountId(String paramString);
/*    */   
/*    */   String getLoyaltyProgramId();
/*    */   
/*    */   void setLoyaltyProgramId(String paramString);
/*    */   
/*    */   String getLoyaltyProgramName();
/*    */   
/*    */   void setLoyaltyProgramName(String paramString);
/*    */   
/*    */   String getLoyaltyProgramLevelId();
/*    */   
/*    */   void setLoyaltyProgramLevelId(String paramString);
/*    */   
/*    */   String getLoyaltyProgramLevelName();
/*    */   
/*    */   void setLoyaltyProgramLevelName(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   BigDecimal getAccountBalance();
/*    */   
/*    */   void setAccountBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getEscrowBalance();
/*    */   
/*    */   void setEscrowBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getBonusBalance();
/*    */   
/*    */   void setBonusBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getCustomerLoyaltyAccountExt();
/*    */   
/*    */   void setCustomerLoyaltyAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerLoyaltyAccountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerLoyaltyAccountProperty> paramList);
/*    */   
/*    */   void addCustomerLoyaltyAccountProperty(ICustomerLoyaltyAccountProperty paramICustomerLoyaltyAccountProperty);
/*    */   
/*    */   void removeCustomerLoyaltyAccountProperty(ICustomerLoyaltyAccountProperty paramICustomerLoyaltyAccountProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerLoyaltyAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */