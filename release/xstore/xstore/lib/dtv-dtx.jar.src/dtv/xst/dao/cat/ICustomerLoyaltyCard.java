/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerLoyaltyCard extends IDataModel, ICustomerLoyaltyCardModel, IHasDataProperty<ICustomerLoyaltyCardProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CARDNUMBER = new EventEnum("set cardNumber");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 16 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 17 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 18 */   public static final EventEnum ADD_LOYALTYACCOUNTS = new EventEnum("add LoyaltyAccounts");
/* 19 */   public static final EventEnum REMOVE_LOYALTYACCOUNTS = new EventEnum("remove LoyaltyAccounts");
/* 20 */   public static final EventEnum SET_LOYALTYACCOUNTS = new EventEnum("set LoyaltyAccounts");
/* 21 */   public static final EventEnum ADD_AWARDACCOUNTS = new EventEnum("add AwardAccounts");
/* 22 */   public static final EventEnum REMOVE_AWARDACCOUNTS = new EventEnum("remove AwardAccounts");
/* 23 */   public static final EventEnum SET_AWARDACCOUNTS = new EventEnum("set AwardAccounts");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   IDataModel getCustomerLoyaltyCardExt();
/*    */   
/*    */   void setCustomerLoyaltyCardExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerLoyaltyAccount> getLoyaltyAccounts();
/*    */   
/*    */   void setLoyaltyAccounts(List<ICustomerLoyaltyAccount> paramList);
/*    */   
/*    */   void addCustomerLoyaltyAccount(ICustomerLoyaltyAccount paramICustomerLoyaltyAccount);
/*    */   
/*    */   void removeCustomerLoyaltyAccount(ICustomerLoyaltyAccount paramICustomerLoyaltyAccount);
/*    */   
/*    */   List<IAwardAccount> getAwardAccounts();
/*    */   
/*    */   void setAwardAccounts(List<IAwardAccount> paramList);
/*    */   
/*    */   void addAwardAccount(IAwardAccount paramIAwardAccount);
/*    */   
/*    */   void removeAwardAccount(IAwardAccount paramIAwardAccount);
/*    */   
/*    */   List<ICustomerLoyaltyCardProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerLoyaltyCardProperty> paramList);
/*    */   
/*    */   void addCustomerLoyaltyCardProperty(ICustomerLoyaltyCardProperty paramICustomerLoyaltyCardProperty);
/*    */   
/*    */   void removeCustomerLoyaltyCardProperty(ICustomerLoyaltyCardProperty paramICustomerLoyaltyCardProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerLoyaltyCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */