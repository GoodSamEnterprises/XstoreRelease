/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IChargeAccountUser extends IDataModel, IChargeAccountUserModel, IHasDataProperty<IChargeAccountUserProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_ACCOUNTUSERID = new EventEnum("set accountUserId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ACCOUNTUSERNAME = new EventEnum("set accountUserName");
/* 18 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 19 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 20 */   public static final EventEnum SET_PRIMARYCONTACT = new EventEnum("set primaryContact");
/* 21 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 22 */   public static final EventEnum SET_ACCOUNTUSERFIRSTNAME = new EventEnum("set accountUserFirstName");
/* 23 */   public static final EventEnum SET_ACCOUNTUSERLASTNAME = new EventEnum("set accountUserLastName");
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
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   String getAccountUserId();
/*    */   
/*    */   void setAccountUserId(String paramString);
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
/*    */   String getAccountUserName();
/*    */   
/*    */   void setAccountUserName(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   boolean getPrimaryContact();
/*    */   
/*    */   void setPrimaryContact(boolean paramBoolean);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getAccountUserFirstName();
/*    */   
/*    */   void setAccountUserFirstName(String paramString);
/*    */   
/*    */   String getAccountUserLastName();
/*    */   
/*    */   void setAccountUserLastName(String paramString);
/*    */   
/*    */   IDataModel getChargeAccountUserExt();
/*    */   
/*    */   void setChargeAccountUserExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IChargeAccountUserProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IChargeAccountUserProperty> paramList);
/*    */   
/*    */   void addChargeAccountUserProperty(IChargeAccountUserProperty paramIChargeAccountUserProperty);
/*    */   
/*    */   void removeChargeAccountUserProperty(IChargeAccountUserProperty paramIChargeAccountUserProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IChargeAccountUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */