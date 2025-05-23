/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPartyTelephone extends IDataModel, IHasDataProperty<IPartyTelephoneProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_TELEPHONETYPE = new EventEnum("set telephoneType");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CONTACTTYPE = new EventEnum("set contactType");
/* 17 */   public static final EventEnum SET_CONTACT = new EventEnum("set contact");
/* 18 */   public static final EventEnum SET_PRIMARY = new EventEnum("set primary");
/* 19 */   public static final EventEnum SET_TELEPHONENUMBER = new EventEnum("set telephoneNumber");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getTelephoneType();
/*    */   
/*    */   void setTelephoneType(String paramString);
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
/*    */   String getContactType();
/*    */   
/*    */   void setContactType(String paramString);
/*    */   
/*    */   boolean getContact();
/*    */   
/*    */   void setContact(boolean paramBoolean);
/*    */   
/*    */   boolean getPrimary();
/*    */   
/*    */   void setPrimary(boolean paramBoolean);
/*    */   
/*    */   String getTelephoneNumber();
/*    */   
/*    */   void setTelephoneNumber(String paramString);
/*    */   
/*    */   IDataModel getPartyTelephoneExt();
/*    */   
/*    */   void setPartyTelephoneExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPartyTelephoneProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPartyTelephoneProperty> paramList);
/*    */   
/*    */   void addPartyTelephoneProperty(IPartyTelephoneProperty paramIPartyTelephoneProperty);
/*    */   
/*    */   void removePartyTelephoneProperty(IPartyTelephoneProperty paramIPartyTelephoneProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IPartyTelephone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */